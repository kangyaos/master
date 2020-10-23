package com.jiaoda.edu.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jiaoda.edu.domain.UserInfo;
import com.jiaoda.edu.log.LogDesc;
import com.jiaoda.edu.mapper.UserInfoMapper;
import com.jiaoda.edu.service.IUserInfoService;
import com.jiaoda.edu.util.ExcelUtils;
import com.jiaoda.edu.util.PasswordEncoder;

@Service
public class UserInfoServiceImpl implements IUserInfoService {

	@Autowired
	private UserInfoMapper mapper;
	
	@Override
	@LogDesc(desc="添加用户信息")
	public Integer insertSelective(UserInfo record) {
		return mapper.insertSelective(record);
	}

	@Override
	@LogDesc(desc="更新用户信息")
	public Integer updateByPrimaryKeySelective(UserInfo record) {
		return mapper.updateByPrimaryKeySelective(record);
	}
	
	@Override
	public Integer updateSelective(UserInfo record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		return mapper.deleteByPrimaryKey(Integer.parseInt(key.toString()));
	}

	@Override
	public UserInfo selectByPrimaryKey(Object key) {
		return mapper.selectByPrimaryKey(Integer.parseInt(key.toString()));
	}

	@Override
	public List<UserInfo> findWhereList(String where, String order) {
		return mapper.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<UserInfo> findPagerList(Integer start, Integer length, String where, String order) {
		return mapper.findPagerList(start, length, where, order);
	}

	@Override
	public UserInfo findByWhere(String where, String order) {
		List<UserInfo>  users=findWhereList(where,order);
		return users==null||users.size()==0?null:users.get(0);
	}

	@Override
	public UserInfo selectByUserMobile(String userMobile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo selectByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer batchinsert(List<UserInfo> users) {
		return  mapper.batchinsert(users);
	}
	
	@Override
	@LogDesc(desc="Excel导入用户信息")
    public  Integer importExcel(MultipartFile myFile) throws Exception {
        //
        //        2、用HSSFWorkbook对象返回或者创建Sheet对象
        //
        //        3、用Sheet对象返回行对象，用行对象得到Cell对象
        //
        //        4、对Cell对象读写。
        //获得文件名  
    	
        Workbook workbook = null ;
        String fileName = myFile.getOriginalFilename(); 
        if(fileName.endsWith(ExcelUtils.XLS)){  
            //2003  
            workbook = new HSSFWorkbook(myFile.getInputStream());  
        }else if(fileName.endsWith(ExcelUtils.XLSX)){  
            //2007  
            workbook = new XSSFWorkbook(myFile.getInputStream());  
        }else{
            throw new Exception("文件不是Excel文件");
        }
 
        Sheet sheet = workbook.getSheet("Sheet1");
        int rows = sheet.getLastRowNum();// 指的行数，一共有多少行+
        if(rows==0){
            throw new Exception("请填写数据");
        }
        List<UserInfo> users=new ArrayList();
        for (int i = 1; i <= rows+1; i++) {
            // 读取左上端单元格
            Row row = sheet.getRow(i);
            // 行不为空
            if (row != null) {
                // **读取cell**
                UserInfo user = new UserInfo();
                String roleId = ExcelUtils.getCellValue(row.getCell(0));
                String userName = ExcelUtils.getCellValue(row.getCell(1));
                String realName = ExcelUtils.getCellValue(row.getCell(2));
                String userMobile = ExcelUtils.getCellValue(row.getCell(3));
                String remark = ExcelUtils.getCellValue(row.getCell(4));
                if(roleId!=null&&!roleId.equals("")) {
                	 user.setRoleId(Integer.parseInt(roleId) );
                }else {
                	 user.setRoleId(3 );
                }
                user.setUserName(userName);
                user.setRealName(realName);
                user.setUserPwd(PasswordEncoder.MD5("111111"));
                user.setRemark(remark);
                users.add(user);
              
                //考试时间
               // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
                //String dateString = getCellValue(row.getCell(3));  
//                if (!StringUtils.isEmpty(dateString)) {
//                    Date date=sdf.parse(dateString);  
//                    student.setTime(date);
//                }
//                studentMapper.insert(student);
            }
        }
        mapper.batchinsert(users);
        return rows-1;
    }

	@Override
	public Map<String, Integer> getindexCount(String where) {
		
		return mapper.getindexCount(where);
	}

}
