package org.skunion.smallru8.util;

public class RegularExpression {

	public static boolean isDigitOnly(String str) {
		return str.matches("[0-9]*");
	}
	
	public static boolean isUpperOnly(String str) {
		return str.matches("[A-Z]*");
	}
	
	public static boolean isLowerOnly(String str) {
		return str.matches("[a-z]*");
	}
	
	public static boolean isLetterOnly(String str) {
		return str.matches("[A-Za-z]*");
	}
	
	public static boolean isLetterDigitOnly(String str) {
		return str.matches("[A-Za-z0-9]*");
	}
	
	public static boolean isIPAddress(String str) {
		String[] ip4 = str.split("\\.");
		if(ip4.length!=4)
			return false;
		for(int i=0;i<4;i++) {
			if(!isDigitOnly(ip4[i]))
				return false;
			if(Integer.parseInt(ip4[i])>255||Integer.parseInt(ip4[i])<0)
				return false;
		}
		return true;
	}
	
}