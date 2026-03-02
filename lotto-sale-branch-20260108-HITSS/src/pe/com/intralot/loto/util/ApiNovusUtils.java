package pe.com.intralot.loto.util;

import pe.com.intralot.loto.layer.dto.novus.RegisterDataResponse;
import pe.com.intralot.loto.sale.lib.LoggerApi;

public class ApiNovusUtils {
	   private Long clientid;
	   private String log;
	   private String username;
	   private String email;
	   private String name;
	   
	   public ApiNovusUtils () {
		   
	   }
	   
	   public ApiNovusUtils (String log, Long clientid, String username, String email, String name) {
		   this.clientid = clientid;
		   this.log = log;
		   this.username = username;
		   this.email = email;
		   this.name = name;
	   }
	
	   public Long createUser() {
		   long startTime = System.currentTimeMillis();
		   long novusid = 0L;
		   try {
			   LoggerApi.Log.info(log+" clientId="+clientid);
			   
				   RegisterDataResponse novusResponse = ApiNovusTrx.registerUser(this.log, this.clientid, this.username, this.email, this.name);
				   //AGREGAR UPDATE DEL CAMPO NOVUS ID EN DBWEB
				   if (novusResponse.getResult().equals("success")){
					   novusid = novusResponse.getData().getUser_id();
				   }
				return novusid;   
		   }catch (Exception e) {
			   LoggerApi.Log.info(log+" ERROR--->clientId="+clientid);
			   e.printStackTrace();
			   return novusid;
		   }finally {
			   LoggerApi.Log.info(log+" ---> END Time="+(System.currentTimeMillis()-startTime)/1000.0 +" seconds ");
	        }
		   
	   }
}
