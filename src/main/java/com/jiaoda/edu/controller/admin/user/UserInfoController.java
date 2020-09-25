package com.jiaoda.edu.controller.admin.user;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class UserInfoController {
/*	*//**
     * 用户列表管理
     *//*
	@RequestMapping(value = "/userlist.html", method = RequestMethod.GET)
	public String userinfoList(ModelMap model,String starttime,String suserId,Integer time, String endtime,Integer type,Integer counttype,HttpServletRequest request) {
		UserInfo user = userinfosService.find("userName", request.getRemoteUser());
		List<SysRoles> roles = rolesService.findPagerList(0,-1, "roleIsdisable=0 and roleLevel <="+user.getRole().getRoleLevel(), "");
		model.put("roles",roles);
		model.put("starttime", starttime);
		model.put("endtime", endtime);
		model.put("type", type);
		model.put("counttype", counttype);
		model.put("suserId", suserId);
		model.put("time", time);
		return "user/userinfolist";
	}

	@RequestMapping(value = "/adduser.html", method = RequestMethod.GET)
	public String adduserinfo(ModelMap model,HttpServletRequest request) {
		UserInfo user = userinfosService.find("userName", request.getRemoteUser());		
		List<SysRoles> roles = rolesService.findPagerList(0, 100, "roleIsdisable=0 and roleLevel <="+user.getRole().getRoleLevel(), "");		
        model.put("roles", roles);
        String[] driverType ={"","A1","A2","A3","B1","B2","C1","C2","C3","C4","其他"};
		model.put("driverType", driverType);
		model.put("user", new UserInfo());
		//model.put("CoalSales", salesService.findListWhere("deleteFlag=0 and salesState=1", ""));
		return "user/userinfoform";
	}

	@RequestMapping(value = "/edituser.html", method = RequestMethod.GET)
	public String edituserinfo(Integer userId, ModelMap model,HttpServletRequest request) {
		UserInfo user = userinfosService.find("userName", request.getRemoteUser());
		UserInfo userinfo = userinfosService.find("userId", userId);
		userinfo = userinfo != null ? userinfo : new UserInfo();
		model.put("user", userinfo);
		List<SysRoles> roles = rolesService.findPagerList(0, 100, "roleIsdisable=0 and roleLevel <="+user.getRole().getRoleLevel(), "");		
		model.put("roles", roles);
		//model.put("CoalSales", salesService.findListWhere("deleteFlag=0 and salesState=1", ""));
		String[] driverType ={"","A1","A2","A3","B1","B2","C1","C2","C3","C4","其他"};
		model.put("driverType", driverType);
		return "user/userinfoform";
	}

	@RequestMapping(value = "/saveuser.do", method = RequestMethod.POST)
	public String saveUserInfo(UserInfo user,String myCode,Integer userCoupon,HttpServletRequest request) {
		UserInfo info = userinfosService.find("userName", request.getRemoteUser());
		String[] code=myCode==null?null:myCode.split("-");
		String regioncode= code[code.length - 1];
		if (user.getUserId()==null) {
			Integer max=Integer.parseInt(userinfosService.findmax().toString());
			max = max==null?Integer.parseInt("80000001"):max+1;
			user.setUserId(max);
			user.setRealName(user.getRealName()==""?null:user.getRealName());
			user.setUserPwd(PasswordEncoder.MD5(user.getUserPwd()));
			user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
			user.setCreateTime(new Timestamp(System.currentTimeMillis()));
			user.setCreditRating(user.getCreditRating());
			user.setCoalSalesAuthState(0);
			user.setDriverAuthState(0);
			user.setDeleteFlag(0);
			user.setHeadPicCode(user.getHeadPicCode()==""?null:user.getHeadPicCode());
			user.setIdentitycardFrontPicCode(user.getIdentitycardFrontPicCode()==""?null:user.getIdentitycardFrontPicCode());			
			user.setIdentitycardBackPicCode(user.getIdentitycardBackPicCode()==""?null:user.getIdentitycardBackPicCode());
			user.setDriverLicensePicCode(user.getDriverLicensePicCode()==""?null:user.getDriverLicensePicCode());
			if(regioncode.length()>1){
				user.setRegionCode(Integer.parseInt(regioncode));			
			}
			if(user.getRealnameAuthState()==1){
				user.setRealnameAuthPassTime(new Timestamp(System.currentTimeMillis()));
				saveUserRealnameAuthRecord(user,info.getUserId());
			}
			userinfosService.save(user);			
			if(user.getNickname().equals(""))user.setNickname("煤宝"+user.getUserId());
			userinfosService.update(user);	
			// 添加子帐户信息
			for (int i = 0; i <= 2; i++) {
				UserAccount userSub = new UserAccount();
				userSub.setAmount(0);
				userSub.setCashAmount(0);
				userSub.setUncashAmount(0);
				userSub.setFreezeCashAmount(0);
				userSub.setFreezeUncashAmount(0);
				userSub.setState("00");
				userSub.setUserId(max);
				userSub.setCreateTime(new Timestamp(System.currentTimeMillis()));
				userSub.setUpdateTime(new Timestamp(System.currentTimeMillis()));
				if (i == 0) {
					userSub.setAccountCode(max + "00" + "00" + "0000");
					userSub.setAccountType("00");
					userSub.setAccountProperty("00");
					userSub.setAccountName("拉煤宝余额账户");
					userSub.setCheckCode(getcheckcode(userSub));
					userAccountService.save(userSub);
				} else if (i == 1) {
					userSub.setAccountCode(max + "01" + "00" + "0000");
					userSub.setAccountType("01");
					userSub.setAccountProperty("00");
					userSub.setAccountName("快煤宝余额账户");
					
					userSub.setCheckCode(getcheckcode(userSub));
					userAccountService.save(userSub);
				} else if (i == 2) {
					userSub.setAccountCode(max + "02" + "01" + "0000");
					userSub.setAccountType("02");
					userSub.setAccountProperty("01");
					userSub.setAccountName("货款现金托管账户");
					userSub.setCheckCode(getcheckcode(userSub));
					userAccountService.save(userSub);
				}
        }
			
		} else {
			UserInfo entity = userinfosService.find("userId", user.getUserId());
			entity.setUserName(user.getUserName());
			entity.setNickname(user.getNickname());
			if(user.getNickname().equals(""))entity.setNickname("煤宝"+user.getUserId());
			entity.setRealName(user.getRealName()==""?null:user.getRealName());
			entity.setLevel(user.getLevel());
			entity.setCreditRating(user.getCreditRating());
			entity.setSignature(user.getSignature());
			entity.setUserBirth(user.getUserBirth());
			entity.setUserEmail(user.getUserEmail());
			entity.setUserWeChat(user.getUserWeChat());
			entity.setUserQq(user.getUserQq());			
			entity.setDriverRegisterName(user.getDriverRegisterName());
			entity.setDriverLicenseId(user.getDriverLicenseId());
			entity.setDriverLicenseInitialTime(user.getDriverLicenseInitialTime());
			entity.setDriverLicenseIssueDate(user.getDriverLicenseIssueDate());
			entity.setDriverLicenseType(user.getDriverLicenseType());
			entity.setIsShow(user.getIsShow());
			entity.setUserMobile(user.getUserMobile());
			entity.setIdentitycardId(user.getIdentitycardId());
			entity.setHeadPicCode(user.getHeadPicCode().equals("")?null:user.getHeadPicCode());
			entity.setIdentitycardFrontPicCode(user.getIdentitycardFrontPicCode().equals("")?null:user.getIdentitycardFrontPicCode());			
			entity.setIdentitycardBackPicCode(user.getIdentitycardBackPicCode().equals("")?null:user.getIdentitycardBackPicCode());
			entity.setDriverLicensePicCode(user.getDriverLicensePicCode().equals("")?null:user.getDriverLicensePicCode());
			entity.setUserState(user.getUserState());
			entity.setLongitude(user.getLongitude());
			entity.setLatitude(user.getLatitude());
			entity.setRoleId(user.getRoleId());
			entity.setUpdateTime(new Timestamp(System.currentTimeMillis()));
			if(regioncode.length()>1){
				entity.setRegionCode(Integer.parseInt(regioncode));			
			}
			entity.setRealnameAuthState(user.getRealnameAuthState());
			if(user.getRealnameAuthState()==1){
				entity.setRealnameAuthPassTime(new Timestamp(System.currentTimeMillis()));
				saveUserRealnameAuthRecord(user,info.getUserId());
			}
			entity.setRemark(user.getRemark());
			userinfosService.update(entity);
		}
		return "redirect:/userlist.html";
	}

	
	//保存一条实名认证审核记录
	private void saveUserRealnameAuthRecord(UserInfo info,Integer verifier){
		UserRealnameAuthRecord entity =realnameAuthRecordService.findWhere("id.userId="+info.getUserId(), "id.createTime desc");
		if(entity==null ||(entity!=null&&entity.getAuthState()!=1)){
			UserRealnameAuthRecord record = new UserRealnameAuthRecord();
			UserRealnameAuthRecordId id = new UserRealnameAuthRecordId();
			if(info!=null){
				id.setCreateTime(new Timestamp(System.currentTimeMillis()));
				id.setUserId(info.getUserId());
				record.setId(id);
				record.setIdentitycardFrontPicCode(info.getIdentitycardFrontPicCode());
				record.setIdentitycardBackPicCode(info.getIdentitycardBackPicCode());
				record.setIdentitycardId(info.getIdentitycardId());
				record.setRealName(info.getRealName());
				record.setUserBirth(info.getUserBirth());
				record.setAuthState(1);
				record.setVerifier(verifier);
				record.setVerifyTime(new Timestamp(System.currentTimeMillis()));
				record.setVerifyMemo("由光环平台运营人员认证！");
				realnameAuthRecordService.update(record);
			}	
		}	
	}

	
	*//**
	 * 注册发优惠券
	 * *//*
	private void loginObtainCoupon(Integer userId){
		//优惠券代码:优惠券id+年月日时分秒+12位顺序号
		List<OperateCoupon> list = operateCouponService.findWhereList("publishState=1 and deleteFlag=0", "");
		Timestamp nowtime = new Timestamp(System.currentTimeMillis());
		for (OperateCoupon operateCoupon : list) {
			String couponId = userCouponService.getMaxCouponCode(operateCoupon.getCouponId());
			Integer obtainNum = operateCoupon.getObtainNum() == null ? 0 : operateCoupon.getObtainNum();
			for (int i = 0; i < obtainNum; i++) {
				String max = "000000000001";
				if(!"".equals(couponId)){
					Long maxCode = Long.parseLong(couponId) + 1 + i;
					Integer len = maxCode.toString().length();
					max = max.substring(0, 12 - len) + maxCode.toString();
				}
				String couponCode = operateCoupon.getCouponId()+""+DateUtils.yyyymmddhhmmss.format(nowtime)+""+max;
				UserCoupon coupon = new UserCoupon();
				coupon.setCouponCode(couponCode);
				coupon.setCouponId(operateCoupon.getCouponId());
				coupon.setUserId(userId);
				coupon.setCreateTime(nowtime);
				coupon.setUpdateTime(nowtime);
				coupon.setCouponState(0);
				coupon.setDeleteFlag(0);
				coupon.setUseState(1);
				userCouponService.save(coupon);
			}
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/userlist.json", method = RequestMethod.POST)
	public PageData<UserInfo> getRoleList(Integer draw, Integer start, Integer length,
			HttpServletRequest request,String stime,String totime) {
		UserInfo user = userinfosService.find("userName", request.getRemoteUser());
		DataTablesParam param = DataTablesParamUtility.getParam(request);
		PageData<UserInfo> pageData = new PageData<UserInfo>();
		String where =param.getDefaultFilter();
		String sql ="";
		if(stime.equals("") && !totime.equals("")){
			sql = "createTime <= '"+totime+"%'";
		}else if(!stime.equals("") && totime.equals("")){
			sql = "createTime >= '"+stime+"%'";
		}else if(!stime.equals("") && !totime.equals("")){
			sql = "createTime >= '"+stime+"%' and createTime <= '"+totime+"%'";
		}		
		sql = sql.equals("")?"":" and "+ sql;
		if(where.equals("")){
			where = "role.roleLevel <="+user.getRole().getRoleLevel()+" and deleteFlag=0"+sql;
		}else{
			where = "role.roleLevel <="+user.getRole().getRoleLevel()+" and deleteFlag=0 and ("+where+")"+sql;
		}		
		Integer count = userinfosService.getCount(where);
		List<UserInfo> data = userinfosService.findPagerList(start, length, where, "createTime desc");
		pageData.setDraw(draw);
		pageData.setRecordsTotal(count);
		pageData.setRecordsFiltered(count);
		pageData.setData(data);
		return pageData;
	}
	
	*//**
	 * 验证用户名
	 *//*
	@ResponseBody
	@RequestMapping(value = "/validUserName.json", method = RequestMethod.POST)
	public Boolean validUserName(String userId, String userName) {
		UserInfo user = userinfosService.findWhere("deleteFlag=0 and userName='"+userName+"'", "");
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

	*//**
	 * 验证新密码
	 *//*
	@ResponseBody
	@RequestMapping(value = "/checkPass.json", method = RequestMethod.POST)
	public Boolean checkPassWord(String oldPwd, HttpServletRequest request) {
		UserInfo user = userinfosService.find("userName", request.getRemoteUser());
		if (user != null) {
			if (user.getUserPwd().equals(PasswordEncoder.MD5(oldPwd))) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	*//**
	 * 修改密码
	 *//*
	@RequestMapping(value = "/modifypwd.html", method = RequestMethod.GET)
	public String modifyPwd(ModelMap model) {
		return "user/modifypwd";
	}
	
	*//**
	 * 修改密码
	 *//*
	@ResponseBody
	@RequestMapping(value = "/modifypwd.do", method = RequestMethod.POST)
	public Boolean modifyPwd(String oldPwd, String newPwd, HttpServletRequest request) {
		UserInfo user = userinfosService.find("userName", request.getRemoteUser());
		if (user != null) {
			if (user.getUserPwd().equals(PasswordEncoder.MD5(oldPwd))) {
				user.setUserPwd(PasswordEncoder.MD5(newPwd));
				userinfosService.update(user);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	*//**
	 * 重置密码
	 *//*
	@ResponseBody
	@RequestMapping(value = "/passwordreset.do", method = RequestMethod.POST)
	public Boolean passwordreset(Integer userid){
		UserInfo user = userinfosService.find("userId", userid);
		user.setUserPwd(PasswordEncoder.MD5("111111"));
		userinfosService.update(user);
		return true;
	}
	
	
	*//**
	 * 批量重置密码
	 *//*
	@ResponseBody
	@RequestMapping(value = "/userRestAll.do", method = RequestMethod.POST)
	public Boolean userRestAll(@RequestParam(value = "ids[]") Integer[] ids){
		for (Integer id : ids) {
			UserInfo user = userinfosService.find("userId", id);
			user.setUserPwd(PasswordEncoder.MD5("111111"));
			userinfosService.update(user);
		}
		return true;		
	}
	
		

	*//**
	 * 批量删除
	 *//*
	@ResponseBody
	@RequestMapping(value = "/userDelAll.do", method = RequestMethod.POST)
	public Boolean userDelAll(@RequestParam(value = "ids[]") Integer[] ids){
		for (Integer id : ids) {
			UserInfo user = userinfosService.find("userId", id);
			user.setDeleteFlag(1);
			userinfosService.update(user);			
			//procDAO.getProcCleanUser(id);
		}
		return true;		
	}
	
	*//**
	 *验证手机号是否存在 
	 *//*
	@ResponseBody
	@RequestMapping(value = "/checkMobile.json", method = RequestMethod.POST)
	public Boolean checkMobile(String userMobile, String userId,HttpServletRequest request) {
		UserInfo user = userinfosService.findWhere("deleteFlag=0 and userMobile="+userMobile, "");
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
	
	*//**
	 *验证身份证号码是否合法
	 *//*
	@ResponseBody
	@RequestMapping(value = "/IdentityCodeValid.json", method = RequestMethod.POST)
	public Boolean IdentityCodeValid(String identitycardId,HttpServletRequest request) {
		return IDCardUtil.isValidatedAllIdcard(identitycardId);
	}
	
	*//**
	 * 获取信息部下的用户
	 *//*
	@ResponseBody
	@RequestMapping(value = "/getUserBySaleId.json", method = RequestMethod.POST)
	public List<UserInfo>  getUserBySaleId(Integer coalSalesId,HttpServletRequest request) {
		return 	userinfosService.findWhereList("coalSalesId ="+coalSalesId+" and deleteFlag=0 and userState=1", "");
	}
	
	
	*//**
	 * 获取用户基本信息   
	 *//*
	@ResponseBody
	@RequestMapping(value = "/getUserBasicInfo.do", method = RequestMethod.POST)
	public UserInfo getUserBasicInfo(Integer userId) {
		UserInfo info = userinfosService.find("userId", userId);
		return info;
	}
	
	*//**
	 * 用户详情页
	 *//*
	@RequestMapping(value = "/UserInfoDetail.html", method = RequestMethod.GET)
	public String UserInfoDetail(Integer userId,ModelMap model) {
		UserInfo info = userinfosService.find("userId", userId);
		model.put("info", info);
		model.put("role", info.getRole()==null?"":info.getRole().getRoleName());
		model.put("realnameAuthState", info.getRealnameAuthState()==null?"":(info.getRealnameAuthState()==1?"已认证":"未认证"));
		String driverAuthState="未认证",userStatus="未知";
		if(info.getDriverAuthState()!=null&&info.getUserState()!=null){
			if(info.getDriverAuthState()==2){
				driverAuthState="认证司机";
			}else if(info.getDriverAuthState()==1){
				driverAuthState="登记司机";
			}
			if(info.getUserState()==100){
				userStatus="未激活";
			}else if(info.getUserState()==1){
				userStatus="启用";
			}else if(info.getUserState()==0){
				userStatus="禁用";
			}
		}
		model.put("specialLine", info.getSpecialLine()==null?"否":(info.getSpecialLine()==1?"是":"否"));
		model.put("driverState", info.getDriverState()==null?"未知":(info.getDriverState()==1?"空闲":(info.getDriverState()==2?"忙碌":"未知")));
		model.put("driverAuthState", driverAuthState);
		model.put("userStatus", userStatus);
		model.put("coalSaleAuthState", info.getCoalSalesId()==null?"未认证":"已认证");
		model.put("companyName", info.getCoalSales()==null?"":info.getCoalSales().getCompanyName());
		return "user/userinfodetail";
	}
	
	
	*//**
	 * 用户导出页面，多条件搜索查询
	 * @param model
	 * @param request
	 * @return
	 *//*
	@RequestMapping(value = "/userinfosearch.html", method = RequestMethod.GET)
	public String userinfosearchList(ModelMap model,HttpServletRequest request) {
		UserInfo user = userinfosService.find("userName", request.getRemoteUser());
		List<SysRoles> roles = rolesService.findPagerList(0,-1, "roleIsdisable=0 and roleLevel <="+user.getRole().getRoleLevel(), "");
		model.put("roles",roles);
		return "user/userinfosearch";
	}
	
	@ResponseBody
	@RequestMapping(value = "/userInfoList.json", method = RequestMethod.POST)
	public PageData<UserInfo> getuserInfoList(Integer draw, Integer start, Integer length,String search,
			HttpServletRequest request,String createsTime,String createdTime,String latestUsecTime,String latestUsedTime,String recommend,String starttime,String suserPhone,Integer time, String endtime,Integer type,Integer counttype) throws ParseException {
		UserInfo user = userinfosService.find("userName", request.getRemoteUser());
		DataTablesParam param = DataTablesParamUtility.getParam(request);
		PageData<UserInfo> pageData = new PageData<UserInfo>();
		String where =param.getDefaultFilter();
		String order ="createTime desc";
		if(param.getOrderColumn()==1){
			order = "userId "+param.getOrderDir();
		}else if(param.getOrderColumn()==6){
			order = "createTime "+param.getOrderDir();
		}else if(param.getOrderColumn()==7){
			order = "machineCode "+param.getOrderDir();
		}else if(param.getOrderColumn()==14){
			order = "latestUseTime "+param.getOrderDir();
		}
		String createTime ="";
		if(StringUtils.isBlank(createsTime) && StringUtils.isNotBlank(createdTime)){
			createTime = "createTime <= '"+createdTime+"%'";
		}else if(StringUtils.isNotBlank(createsTime) && StringUtils.isBlank(createdTime)){
			createTime = "createTime >= '"+createsTime+"%'";
		}else if(StringUtils.isNotBlank(createsTime) && StringUtils.isNotBlank(createdTime)){
			createTime = "createTime >= '"+createsTime+"%' and createTime <= '"+createdTime+"%'";
		}		
		createTime = createTime.equals("")?"":" and "+ createTime;
		String latestUseTime ="";
		if(StringUtils.isBlank(latestUsecTime) && StringUtils.isNotBlank(latestUsedTime)){
			latestUseTime = "latestUseTime <= '"+latestUsedTime+"%'";
		}else if(StringUtils.isNotBlank(latestUsecTime) && StringUtils.isBlank(latestUsedTime)){
			latestUseTime = "latestUseTime >= '"+latestUsecTime+"%'";
		}else if(StringUtils.isNotBlank(latestUsecTime) && StringUtils.isNotBlank(latestUsedTime)){
			latestUseTime = "latestUseTime >= '"+latestUsecTime+"%' and latestUseTime <= '"+latestUsedTime+"%'";
		}		
		latestUseTime = latestUseTime.equals("")?"":" and "+ latestUseTime;
	
		if(where.equals("")){
			where = "roleLevel <="+user.getRole().getRoleLevel()+createTime+ latestUseTime;
		}else{
			if(where.contains("machineCode like 'no%'")){
				where=where.replaceAll("machineCode like 'no%'", "machineCode is not null");
			}else if(where.contains("machineCode like 'ok%'")){
				where=where.replaceAll("machineCode like 'ok%'", "machineCode is null");
			}
			where = "roleLevel <="+user.getRole().getRoleLevel()+" and ("+where+")"+createTime+ latestUseTime;
		}	
		if(recommend!=null&&!"".equals(recommend)) {
			where+=" and recommend is not null and recommend!=\"\"  and createTime>'2020-08-05'";
		}
		
		if(type!=null) {
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			 where+=" and recommend is not null and recommend!='' ";
			if(type==1) {
				 if(counttype==0) {
					 where+=" and  createTime like '"+starttime+" "+time+"%'";
				 }else if(counttype==2) {
					Date startdate=sdf1.parse(starttime);
					endtime=sdf1.format(DateUtils.getSomeDay(startdate, -7));
					where +=" and createTime BETWEEN '"+endtime+"' and  '"+starttime+" 23:59:59' and DATE_FORMAT(createTime,'%H')  ='"+time+"'";
				}else if(counttype==3) {
					Date startdate=sdf1.parse(starttime);
					endtime=sdf1.format(DateUtils.getSomeDay(startdate, -15));
					where +=" and createTime BETWEEN '"+endtime+"' and  '"+starttime+" 23:59:59' and DATE_FORMAT(createTime,'%H')  ='"+time+"'";
				}
			}else if(type==2) {
				 if(counttype==0) {
					 where+=" and  createTime like '"+starttime+"%'  ";
				 }else if(counttype==2) {
					Date startdate=sdf1.parse(starttime);
					endtime=sdf1.format(DateUtils.getSomeDay(startdate, -7));
					where +=" and createTime BETWEEN '"+endtime+"' and  '"+starttime+" 23:59:59' ";
				}else if(counttype==3) {
					Date startdate=sdf1.parse(starttime);
					endtime=sdf1.format(DateUtils.getSomeDay(startdate, -15));
					where +=" and createTime BETWEEN '"+endtime+"' and  '"+starttime+" 23:59:59' ";
				}
			}else {
				 where+=" and  createTime  BETWEEN '"+starttime+"' and  '"+endtime+" 23:59:59'  and recommend='"+suserPhone+"'   ";
				
			}
			
			
			
		}
		Integer count = userinfosService.getSqlCount(where);
		List data = userinfosService.findSqlPagerList(start, length, where, order);
		List<UserInfo> UserInfoList = createUserListRecord(data);
		pageData.setDraw(draw);
		pageData.setRecordsTotal(count);
		pageData.setRecordsFiltered(count);
		pageData.setData(UserInfoList);
		return pageData;
	}
	
	
	public static List<UserInfo> createUserListRecord(List list) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<UserInfo> b = new ArrayList<>(); 
		if(list != null && list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				UserInfo csi=new UserInfo();
			    Object[] object = (Object[])list.get(i);
			    csi.setUserId(Integer.parseInt(object[0].toString()));
			    csi.setUserName(object[1]==null?"":object[1].toString());
			    csi.setRoleName(object[2]==null?"":object[2].toString());	
			    csi.setRoleLevel(object[3]==null?null:Integer.parseInt(object[3].toString()));			    
			    csi.setNickname(object[4]==null?"":object[4].toString());
			    csi.setRealName(object[5]==null?"":object[5].toString());
			    csi.setCreateTime(Timestamp.valueOf(object[6].toString()));			    
			    csi.setMachineCode(object[7]==null?"":object[7].toString());
			    csi.setCoalSalesId(object[8]==null?null:Integer.parseInt(object[8].toString()));
			    csi.setCompanyName(object[9]==null?"":object[9].toString());
			    csi.setRealAuthState(object[10]==null?"":object[10].toString());
			    csi.setRealnameAuthState(object[11]==null?null:Integer.parseInt(object[11].toString()));
			    csi.setDriAuthState(object[12]==null?"":object[12].toString());
			    csi.setDriverAuthState(object[13]==null?null:Integer.parseInt(object[13].toString()));
				csi.setRecommend(object[14]==null?"":object[14].toString());
				csi.setRegionName(object[15]==null?"":object[15].toString());
				csi.setRemark(object[16]==null?"":object[16].toString());
				csi.setLatestUseTime(object[17]==null?null:Timestamp.valueOf(object[17].toString()));
				csi.setObtainApproach((object[22]==null?"":object[22].toString()));
				csi.setIdentityFlag(object[23]==null?null:Integer.parseInt(object[23].toString()));
			    b.add(csi);
			}
		}
		return b;
	}
	
	private String getcheckcode(UserAccount account) {
		String userId=account.getUserId().toString();
		String account_type=account.getAccountType();
		String account_property=account.getAccountProperty();
		String amount=account.getAmount().toString();
		String uncash_amount=account.getUncashAmount().toString();
		String cash_amount=account.getCashAmount().toString();
		String freeze_cash_amount=account.getFreezeCashAmount().toString();
		String freeze_uncash_amount=account.getFreezeUncashAmount().toString();
		String longstr=userId+account_type+account_property+amount+cash_amount+uncash_amount+freeze_cash_amount+freeze_uncash_amount;
		String md5str =getMD5Util.getMD5(longstr);
		return md5str;
	}
	*//**
	 * 修改用户备注和地址
	 *//*
	@ResponseBody
	@RequestMapping(value = "/changeRemark.do", method = RequestMethod.POST)
	public boolean changeRemark(String userId,Integer countyId,String remark,String reginName,String obtainApproach){
		try {
			UserInfo user=userinfosService.findById(userId);
			if(user!=null){
				if(remark!=null||!"".equals(remark)){
					user.setRemark(remark);
				}
				if(countyId!=null){
					user.setRegionCode(countyId);
				}
				if("".equals(reginName)){
					user.setRegionCode(null);
				}
				if(obtainApproach!=null||!"".equals(obtainApproach)){
					user.setObtainApproach(obtainApproach);
				}
				userinfosService.update(user);
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	

	@ResponseBody
	@RequestMapping(value = "/userpackagelist.json", method = RequestMethod.POST)
	public PageData<UserInfo> userpackagelist(Integer draw, Integer start, Integer length,
			HttpServletRequest request,String stime,String totime) {
		DataTablesParam param = DataTablesParamUtility.getParam(request);
		PageData<UserInfo> pageData = new PageData<UserInfo>();
		String where =param.getDefaultFilter();
		if(where.equals("")) {
			where ="deleteFlag=0 and userState=1 and  coalSalesId in  (select DISTINCT id.coalSalesId from UserPackageInfo where endTime >CURRENT_DATE())";
		}else {
			where = "("+where+") and deleteFlag=0 and userState=1 and  coalSalesId in  (select DISTINCT id.coalSalesId from UserPackageInfo where endTime >CURRENT_DATE())";
		}
		
	    Integer count = userinfosService.getCount(where);
		List<UserInfo> data = userinfosService.findPagerList(start, length, where, "coalSalesId");
		pageData.setDraw(draw);
		pageData.setRecordsTotal(count);
		pageData.setRecordsFiltered(count);
		pageData.setData(data);
		return pageData;
	}
	
	
	
	
	*//**
	 * 用户精简信息(方便运营记录新注册用户的角色和地址)
	 * (2018-08-24)
	 *//*
	@RequestMapping(value = "/userbrieflist.html", method = RequestMethod.GET)
	public String userBriefList(ModelMap model,HttpServletRequest request) {
		return "user/userbrieflist";
	}
	@Autowired
	private IUserInfoService userinfosService;
	@Autowired
	private IUserRealnameAuthRecordService realnameAuthRecordService;
	@Autowired
	private ICoalGoodsService goodsService;
	@Autowired
	private ICoalGoodsHisService goodsHisService;
	@Autowired
	private ICoalTransportService transportService;
	@Autowired
	private ISysRolesService rolesService;
	@Autowired
	private ICoalSalesService salesService;
	@Autowired
	private IUserVehiclesService vehiclesService;
	@Autowired
	private IUserCouponService userCouponService;
	@Autowired
	private IOperateCouponService operateCouponService;
	@Autowired
	private ExecuteProcDAO procDAO;
	@Autowired
	private IUserAccountService userAccountService;
	*/
	
	
}
