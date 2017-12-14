package com.oa.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class EidUtil 
{
	 public static String getRandomString(int length){  
	        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";  
	        Random random = new Random();  
	        StringBuffer sb = new StringBuffer();  
	        Date date = new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyMMddhhmmss");
			 String eid;
	        for(int i = 0 ; i < length; ++i){  
	            int number = random.nextInt(62);//[0,62)  
	             eid= sdf.format(date)+sb; 
	            sb.append(str.charAt(number));  
	        }  
	        eid= sdf.format(date)+sb; 
	        return getRandomString(2);  
	    }  
	    public static void main(String[] args){  
	        System.out.println(getRandomString(2));  
	      
	    }  
	} 

