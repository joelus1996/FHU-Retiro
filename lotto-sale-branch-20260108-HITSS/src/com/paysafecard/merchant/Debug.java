package com.paysafecard.merchant;

public class Debug {
	
	private static String Debug;
	private static boolean debugEnabled;
	private static String NewLine = System.getProperty("line.separator");
	
	public static void setDebugenabled(boolean enabled){
		debugEnabled = enabled;
	}
	
	public static void addDebug(String Function, String Message){
		if(debugEnabled){
			if(Debug != null && !Debug.isEmpty()){
				Debug += NewLine + Function + ": " + Message;
			}else{
				Debug = Function + ": " + Message;
			}
		}
	}
	
	public static String getDebug(){
		return Debug;
	}
	
	public static void clear(){
		Debug = "";
	}
}
