package com.jiaoda.edu.util;

import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.jiaoda.edu.domain.UserInfo;
import com.jiaoda.edu.mapper.UserInfoMapper;

public class ExcelUtils {
	   public final static String XLS = "xls";  
	   public final static String XLSX = "xlsx"; 
	    @Autowired
	    private UserInfoMapper infoMapper;
	    /**
	     * 导入Excel，兼容xls和xlsx
	     */


	 
	    /**
	     * 获得Cell内容
	     * 
	     * @param cell
	     * @return
	     */
	    public static  String getCellValue(Cell cell) {
	        String value = "";
	        if (cell != null) {
	            // 以下是判断数据的类型
	            switch (cell.getCellType()) {
	            case HSSFCell.CELL_TYPE_NUMERIC: // 数字
	                value = cell.getNumericCellValue() + "";
	                if (HSSFDateUtil.isCellDateFormatted(cell)) {
	                    Date date = cell.getDateCellValue();
	                    if (date != null) {
	                        value = new SimpleDateFormat("yyyy-MM-dd").format(date);
	                    } else {
	                        value = "";
	                    }
	                } else {
	                    value = new DecimalFormat("0").format(cell.getNumericCellValue());
	                }
	                break;
	            case HSSFCell.CELL_TYPE_STRING: // 字符串
	                value = cell.getStringCellValue();
	                break;
	            case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
	                value = cell.getBooleanCellValue() + "";
	                break;
	            case HSSFCell.CELL_TYPE_FORMULA: // 公式
	                value = cell.getCellFormula() + "";
	                break;
	            case HSSFCell.CELL_TYPE_BLANK: // 空值
	                value = "";
	                break;
	            case HSSFCell.CELL_TYPE_ERROR: // 故障
	                value = "非法字符";
	                break;
	            default:
	                value = "未知类型";
	                break;
	            }
	        }
	        return value.trim();
	    }
	    
	    
	    /**
	     * 导出excel文件
	     */
	    public void exportExcel(HttpServletResponse response) throws Exception {
	        // 第一步，创建一个webbook，对应一个Excel文件  
	        HSSFWorkbook wb = new HSSFWorkbook();  
	        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
	        HSSFSheet sheet = wb.createSheet("Sheet1");  
	        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
	        HSSFRow row = sheet.createRow(0);  
	        // 第四步，创建单元格，并设置值表头 设置表头居中  
	        HSSFCellStyle style = wb.createCellStyle();  
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
	 
	        HSSFCell cell = row.createCell(0);
	        cell.setCellValue("姓名");  
	        cell.setCellStyle(style);  
	        cell = row.createCell(1);  
	        cell.setCellValue("班级");  
	        cell.setCellStyle(style);  
	        cell = row.createCell(2);  
	        cell.setCellValue("分数");  
	        cell.setCellStyle(style);  
	        cell = row.createCell(3);  
	        cell.setCellValue("时间");  
	        cell.setCellStyle(style);  
	 
	        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，  
	        List<UserInfo> list = infoMapper.findWhereList("", "");  
	 
	        for (int i = 0; i < list.size(); i++){  
	            row = sheet.createRow(i + 1);  
	            UserInfo stu = list.get(i);  
	            // 第四步，创建单元格，并设置值  
//	            row.createCell(0).setCellValue(stu.getName());  
//	            row.createCell(1).setCellValue(stu.getClasses());  
//	            row.createCell(2).setCellValue(stu.getScore());  
//	            cell = row.createCell(3);  
//	            cell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(stu.getTime()));  
	        }          
	        //第六步,输出Excel文件
	        OutputStream output=response.getOutputStream();
	        response.reset();
	        long filename = System.currentTimeMillis();
	        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
	        String fileName = df.format(new Date());// new Date()为获取当前系统时间
	        response.setHeader("Content-disposition", "attachment; filename="+fileName+".xls");
	        response.setContentType("application/msexcel");        
	        wb.write(output);
	        output.close();
	    } 
}
