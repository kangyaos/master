package com.sxhalo.lmb.controller.app;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sxhalo.lmb.controller.BaseController;
import com.sxhalo.lmb.domain.CoalCompanies;
import com.sxhalo.lmb.domain.CoalSales;
import com.sxhalo.lmb.domain.DiscoverView;
import com.sxhalo.lmb.domain.SysDicCode;
import com.sxhalo.lmb.domain.SysDicRegion;
import com.sxhalo.lmb.domain.UserCoalSalesAuthRecord;
import com.sxhalo.lmb.domain.UserInfo;
import com.sxhalo.lmb.service.ICoalCompaniesService;
import com.sxhalo.lmb.service.ICoalGoodsService;
import com.sxhalo.lmb.service.ICoalSalesService;
import com.sxhalo.lmb.service.IDiscoverViewService;
import com.sxhalo.lmb.service.ISysDicCodeService;
import com.sxhalo.lmb.service.ISysDicRegionService;
import com.sxhalo.lmb.service.IUserCoalSalesAuthRecordService;
import com.sxhalo.lmb.service.IUserInfoService;
import com.sxhalo.lmb.util.DataTablesParam;
import com.sxhalo.lmb.util.DataTablesParamUtility;
import com.sxhalo.lmb.util.MD5Util;
import com.sxhalo.lmb.util.PageData;


@Controller
public class AppSaleInfoRegisterController extends BaseController {
	
	@Autowired
	private ICoalCompaniesService companiesService;
	@Autowired
	private ICoalGoodsService goodsService;
	@Autowired
	private ICoalSalesService saleService;
	@Autowired
	private IUserInfoService userService;
	@Autowired
	private IUserCoalSalesAuthRecordService slesAuthService;
	@Autowired
	private ISysDicCodeService codeService;
	@Autowired
	private ISysDicRegionService regionService;
	@Autowired
	private IDiscoverViewService discoverService;
	
	private ObjectMapper objectMapper = new ObjectMapper();

	//信息部信息登记
	@RequestMapping(value = "/saleinforegister.html", method = RequestMethod.GET)
	public String saleinforegister( HttpServletRequest request, ModelMap model) throws JsonProcessingException {
		List<SysDicCode>  types=codeService.findWhereList(" type_id =22 and delete_flag=0 ", "");
		List<SysDicCode>  dictypes=codeService.findWhereList(" type_id =1 and delete_flag=0 ", "");
		model.put("types", types);
		model.put("dictypes", objectMapper.writeValueAsString(dictypes));
		return "kmb/saleinforegister";
	}
	
	
	// 运维部 信息部信息登记
	@RequestMapping(value = "/lmb/saleinforegister.html", method = RequestMethod.GET)
	public String lmbsaleinforegister( HttpServletRequest request, ModelMap model) throws JsonProcessingException {
		UserInfo  sessionuser=request.getSession().getAttribute("user")==null?null:(UserInfo)request.getSession().getAttribute("user");
		if(sessionuser==null) {
			return "redirect:/web/login.html";
		}
		List<SysDicCode> types = codeService.findWhereList(" type_id =23 and delete_flag=0 ", "");
		List<SysDicCode> dictypes = codeService.findWhereList(" type_id =1  and delete_flag=0 ", "");
		model.put("types", types);
		model.put("dictypes", objectMapper.writeValueAsString(dictypes));
		return "kmb/saleinforegister";
	}
	
	//返回页面
	@RequestMapping(value = "/saleinforegister/result.html", method = RequestMethod.GET)
	public String result( Integer code,HttpServletRequest request, ModelMap model) throws JsonProcessingException {
		model.put("code", code==null?0:code);
		return "kmb/result";
	}
	
	/*
	 * 	查询所有的矿口
	 */
	@ResponseBody
	@RequestMapping(value = "/selectcompany.json", method = RequestMethod.POST)
	public PageData<DiscoverView> selectcompany(Integer draw,Integer start, Integer length,String position,String region,String search, HttpServletRequest request) {
		DataTablesParam param = DataTablesParamUtility.getParam(request);
		String where = param.getDefaultFilter();
		String order="";
		if(region!=null&&!"".equals(region)) {
			where=" ( a.region_code like '"+region.substring(0,6)+"%')";
		}
		if(search!=null&&!"".equals(search)) {
			if( "".equals(where)) {
				where=" ( name like '"+search+"%')";
			}else {
				where+=" and ( name like '"+search+"%')";
			}
		}
		
		order="   convert(trim(REPLACE(REPLACE(name, CHAR(9), ''), CHAR(13), ''))  using gbk) asc ,distance asc ";
		
		where = "".equals(where) ? "delete_flag = 0" : where + " and delete_flag = 0";    	
		PageData<DiscoverView> pageData = new PageData<DiscoverView>();
		Integer count = discoverService.getCount(where);
		List<DiscoverView> data = discoverService.findPagerList(start, length, where, order,position);
		pageData.setDraw(draw);
		pageData.setRecordsTotal(count);
		pageData.setRecordsFiltered(count);
		pageData.setData(data);
		return pageData;
	}
	
	
	/*
     * 	提交登记信息
     */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/savesaleinfo.do", method = RequestMethod.POST)
	public String savesaleinfo(UserCoalSalesAuthRecord sauthRecord, ModelMap model,Integer typeId,String userphone,String minedata,String coaltypes,
			HttpServletRequest request) throws ParseException, JsonParseException, JsonMappingException, IOException {		
		int code = 1;
		try {
			Timestamp nowTime = new Timestamp(System.currentTimeMillis());
			UserInfo sessionuser = request.getSession().getAttribute("user") == null ? null
					: (UserInfo) request.getSession().getAttribute("user");
			// 添加信息部信息
			CoalSales sale = new CoalSales();
			sale.setAddress(sauthRecord.getAddress());
			sale.setTypeId(typeId);
			sale.setLongitude(sauthRecord.getLongitude());
			sale.setLatitude(sauthRecord.getLatitude());
			sale.setCompanyName(sauthRecord.getCoalSalesName());
			sale.setRegionCode(sauthRecord.getRegionCode());
			sale.setContactPerson(sauthRecord.getRealName());
			sale.setContactPhone(userphone);
			sale.setCreateTime(nowTime);
			sale.setUpdateTime(nowTime);
			sale.setSalesState(1);
			sale.setAuthState(sessionuser == null ? 0 : 1);
			saleService.insertSelective(sale);
			UserInfo user = new UserInfo();
			user.setRoleId(3);
			user.setCoalSalesId(sale.getCoalSalesId());
			if (sessionuser != null) {
				user.setCoalSalesAuthState(1);
				user.setCoalSalesAuthPassTime(nowTime);
			}
			user.setUserPwd(MD5Util.MD5Encode("111111"));
			user.setNickname("匿名用户");
			user.setUserName(userphone);
			user.setCreateTime(nowTime);
			user.setUserState(100);
			user.setUserMobile(userphone);
			userService.insertSelective(user);
			sauthRecord.setCoalSalesId(sale.getCoalSalesId().intValue());
			sauthRecord.setUserId(user.getUserId());
			sauthRecord.setCreateTime(nowTime);
			sauthRecord.setAuthState(sessionuser == null ? 0 : 1);
			slesAuthService.insertSelective(sauthRecord);

			List<Map<String, Object>> data = new ObjectMapper().readValue(minedata, ArrayList.class);
			for (Map<String, Object> map : data) {
				if (map.get("id") == null) {
					CoalCompanies cc = new CoalCompanies();
					cc.setAddress(map.get("address").toString());
					cc.setMineMouthName(map.get("name").toString());
					cc.setCreateTime(nowTime);
					cc.setUpdateTime(nowTime);
					cc.setLatitude(map.get("latitude") == null ? null : new BigDecimal(map.get("latitude").toString()));
					cc.setLongitude(map.get("longitude") == null ? null : new BigDecimal(map.get("longitude").toString()));
					cc.setRegionCode(map.get("regionCode") == null ? null : Integer.parseInt(map.get("regionCode").toString()));
					cc.setAuthState(0);
					cc.setTypeId(0);
					companiesService.insertSelective(cc);
					map.put("id", cc.getMineMouthId() + "");
				}
				if (!"".equals(map.get("types"))) {
					List<Map<String, String>> typelist = new ObjectMapper().readValue(map.get("types").toString(), ArrayList.class);
					map.put("types", typelist);

				} else {
					data.remove(map);
				}
			}
			if (data.size() > 0) {
				// 批量添加用户煤炭信息
				goodsService.batchinsert(user.getUserId(), sale.getCoalSalesId(), data);
			}
			// 批量添加煤种
			if (!"".equals(coaltypes) && !"[]".equals(coaltypes)) {
				List<Map<String, String>> coaltypelist = new ObjectMapper().readValue(coaltypes, ArrayList.class);
				codeService.batchinsert(coaltypelist, user.getUserId());
			}
		} catch (Exception e) {
			System.out.println(e);
			code = 0;
		} 
		model.addAttribute("code", code);
		return  "redirect:/saleinforegister/result.html"; 
	}	

	
	// 查询市
	@ResponseBody
	@RequestMapping(value = "/getcity.json", method = RequestMethod.GET)
	public String Regioncity(HttpServletRequest request, Integer id,
			Integer leval) {
		List<SysDicRegion> regionCodes = regionService.findWhereList("parent_code="
				+ id + " and region_level =" + leval,"region_code");

		String temp = "";
		temp += " [";
		int t = 0;
		for (int i = 0; i < regionCodes.size(); i++) {
			temp += "{ \"id\": \"" + regionCodes.get(i).getRegionCode()
					+ "\", \"name\": \"" + regionCodes.get(i).getRegionName()
					+ "\", \"pid\": \"" + regionCodes.get(i).getParentCode()
					+ "\" }";
			t++;
			if (t == regionCodes.size()) {
				temp += "";
			} else {
				temp += ",";

			}
		}
		temp += "]";
		return temp;
	}
		
	/**
	 *验证手机号是否存在 
	 */
	@ResponseBody
	@RequestMapping(value = "/checkMobile.json", method = RequestMethod.POST)
	public Boolean checkMobile(String userMobile, String userId,HttpServletRequest request) {
		UserInfo user = userService.findByWhere(" delete_flag=0 and user_mobile= "+userMobile, "");
		if (user == null) {
			return true;
		} else {
			if (user.getUserId().toString().equals(userId)) {
				return true;
			} else {
				return false;
			}
		}
	}
}
