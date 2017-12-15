package com.oa.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class EidUtil 
{
	 public static String getRandomString(int length){  
		 Date date = new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
	        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";  
	        Random random = new Random();  
	        StringBuffer sb = new StringBuffer(); 
			 String eid;
	        for(int i = 0 ; i < length; ++i){  
	            int number = random.nextInt(62);//[0,62)  
	            sb.append(str.charAt(number));  
	        }  
	        String b;
	        b=sdf.format(date).substring(6, 12);
	        eid=b+sb; 
	        return eid;  
	    }  
	    public static void main(String[] args){  
	        System.out.println(getRandomString(2));  
	      
	    }  
	} 

