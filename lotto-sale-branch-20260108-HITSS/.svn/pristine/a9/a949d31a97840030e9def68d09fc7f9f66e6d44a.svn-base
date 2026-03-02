package com.paysafecard.merchant;

import java.util.ArrayList; 
import java.util.HashMap; 
import java.util.Map.Entry;

public class Log {
	
	public HashMap<String, ArrayList<HashMap<String, String>>> LogContainer = new HashMap<String, ArrayList<HashMap<String, String>>>();

	public Log() {
		
	}
	
	public void addLogType(String type){
		ArrayList<HashMap<String, String>> varContainer = new ArrayList<HashMap<String, String>>();
		LogContainer.put(type, varContainer);
	}
	
	public boolean doesLogTypeExist(String type){
		if(LogContainer.containsKey(type)){
			return true;
		}else{
			return false;
		}
	}
	
	public void addLog(String msg, String call, String callParams, String result, String type){
		if(LogContainer.containsKey(type)){
			HashMap<String, String> currentLogContainerObject = new HashMap<String, String>();
			currentLogContainerObject.put("msg", msg);
			currentLogContainerObject.put("action", call);
			currentLogContainerObject.put("action_params", callParams);
			currentLogContainerObject.put("result", result);
			LogContainer.get(type).add(currentLogContainerObject);
		} 
	}
	
	public ArrayList<HashMap<String, String>> getLog(String type){
		if(LogContainer.containsKey(type) && LogContainer.get(type).size() > 0){
			return LogContainer.get(type);
		}else{
			return new ArrayList<HashMap<String, String>>(); 
		}
	}
	
	public String getInfoLog() {
		if(LogContainer.containsKey("info") && LogContainer.get("info").size() > 0){
			return LogContainer.get("info").get(LogContainer.get("info").size()-1).get("msg");
		}else{
			return "";
		}
	}
	
	public String getString() { 
		StringBuffer buf = new StringBuffer();
		for (Entry<String,  ArrayList<HashMap<String, String>>> entry : LogContainer.entrySet()) {
			buf.append(" [" + entry.getKey() + "]=" + entry.getValue()); 
		    ArrayList<HashMap<String, String>> arrayList = entry.getValue();
			for (HashMap<String, String> map : arrayList) { 
				for (Entry<String, String> entry2 : map.entrySet()) {
					buf.append(" [" + entry2.getKey() + "]=" + entry2.getValue()); 
				}
			}
			
		}
		return buf.toString();
	}
}
