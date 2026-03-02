package com.paysafecard.merchant;

import java.util.HashMap;

public class Languages 
{
 
	@SuppressWarnings({ "rawtypes" })
	private static HashMap<String, HashMap> languages = new HashMap<String, HashMap>();
	
	public static void addLanguage(String Language){
		if(isLangAvailable(Language) == false){
			languages.put(Language, new HashMap<String, String>());
		}
	}
	
	public static boolean isLangAvailable(String Language){
		if(languages.containsKey(Language)){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isVariableAvailable(String Language, String VarName){
		if(isLangAvailable(Language)){	
			@SuppressWarnings("unchecked")
			HashMap<String, String> currentLanguage = languages.get(Language);
			if(currentLanguage.containsKey(VarName)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public static void addVariable(String Language, String VarName, String Value){
		if(isLangAvailable(Language)){
			@SuppressWarnings("unchecked")
			HashMap<String, String> currentLanguage = languages.get(Language);
			currentLanguage.put(VarName, Value);
		}
	}
	
	public static boolean doesLanguageExist(String Language){
		if(languages.containsKey(Language)){
			return true;
		}else{
			return false;
		}
	}
	
	public static String getVariable(String Language, String varName){
		if(isVariableAvailable(Language, varName)){
			@SuppressWarnings("unchecked")
			HashMap<String, String> currentLanguage = languages.get(Language);
			return currentLanguage.get(varName);
		}else{
			if(isVariableAvailable("en", varName)){
				@SuppressWarnings("unchecked")
				HashMap<String, String> enLanguage = languages.get("en");
				return enLanguage.get(varName);
			}else{
				return "Unknown error: " + varName;
			}
		}
	}
}
