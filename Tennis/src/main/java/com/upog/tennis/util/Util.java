package com.upog.tennis.util;
public abstract class Util {

   public static String toCamelCase(String input) {
	 if(input==null || input.length()==0)
		 return input;
	   
	   StringBuffer sb = new StringBuffer();
	    for (String s : input.split("_")) {
	        sb.append(Character.toUpperCase(s.charAt(0)));	        
	        sb.append(s.substring(1, s.length()).toLowerCase());
	        sb.append(Constant.SPACE);
	    }
	   return sb.toString().trim();
   }
}
