package com.oa.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

	public static String  getTime(){
		
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
}
