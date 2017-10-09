package org.zhuc.mybatis.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CommonUtil {
	public static String getSerial(String CardCode){
		return	 "00000000"+CardCode.substring(6,8)+CardCode.substring(4,6)+CardCode.substring(2,4)+CardCode.substring(0,2);
	}
	public static Byte getSex(String sex){
		Byte s=1;
		if("0".equals(sex)){
			s=2;
		}
		return	s;
	}
	public static Date strToDate(String str){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//小写的mm表示的是分钟  
		Date date=null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  	
		return	 date;
	}
	public static String getNewPath(String path){
		String ss=path.substring(0,path.lastIndexOf("-"));
		String sss=ss.substring(ss.lastIndexOf("-")+1,ss.length());
		return "1-"+(Integer.valueOf(sss)+1)+"-";
	}
	
}
