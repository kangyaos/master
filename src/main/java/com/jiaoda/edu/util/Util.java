package com.jiaoda.edu.util;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Util {
	/**
	 * 根据日期计算驾龄
	 * @param date
	 * @return
	 */
	public static String getDriverYear(Date date) {
		String driverYear = "";
		if (null == date)
			return driverYear;
		else {
			Calendar calendarstart=Calendar.getInstance();
			Calendar calendarend=Calendar.getInstance();
			calendarstart.setTime(new Date());
			calendarend.setTime(date);
			int end = calendarstart.get(Calendar.YEAR)*12+calendarstart.get(Calendar.MONTH); 
			int start=calendarend.get(Calendar.YEAR)*12+calendarend.get(Calendar.MONTH);
			if(Math.floor((end - start)/12) > 0){
				driverYear = (int)Math.floor((end - start)/12) + "年";
			}
			if( (end - start)%12 > 0){
				driverYear = driverYear + (end - start)%12 +"个月";
			}
			return driverYear;
		}

	}
	/**
	 * 根据身份证计算年龄
	 * @param date
	 * @return
	 */
	public static Integer getAge(String identitycard){
		Integer age=null;
		if (null == identitycard){
			return age;
		}else if(isIDCard(identitycard)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			String nowyear=sdf.format(new Date());
			String year=identitycard.substring(6,10);
			age=Integer.parseInt(nowyear)-Integer.parseInt(year);
		}
		return age;
	}
	
	//身份证号验证/^(\d{15}|\d{18}|\d{17}[a-zA-Z]{1})$/
	public static final String REGEX_ID_CARD = "(^(\\d{15}|\\d{18}|\\d{17}[a-zA-Z]{1})$)";
	public static boolean isIDCard(String idCard) {
        return Pattern.matches(REGEX_ID_CARD, idCard);
    }
	 /**
		 * 字典类型
		 * 1	煤种                             coalCategoryId
		 * 2	交易结算方式              payType
		 * 3	运费结算方式              paymentMethod
		 * 4	短信类型                     shortMessageType
		 * 5	回访方式                     followMode
		 * 6	加工工艺                     technology
		 * 21	车辆类型                     vehicleMode
		 * 22	信息部类型                 coalSaleType
		 * 23	矿口类型                     coalCompaniesType
		 * @param date
		 * @return
	 */
/*	public static Integer getDicType(String typeName){
		Properties p = new Properties();
		String typeId = "0";
		try {
			p.load(JPushUtil.class.getResourceAsStream("/comm.properties"));
			typeId = p.getProperty(typeName);			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return Integer.parseInt(typeId);
	}
	*/
	/**
	 * 去除字符串中的空格、回车、换行符、制表符
	 */
	public static String replaceBlank(String str) {
		String dest = "";
		if (str!=null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}
	
	   
	public static void main(String[] args)
	{
		System.out.println(1111);
	}
}
