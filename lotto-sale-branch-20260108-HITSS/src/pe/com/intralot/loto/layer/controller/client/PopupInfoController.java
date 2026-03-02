package pe.com.intralot.loto.layer.controller.client;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import pe.com.intralot.loto.layer.model.domain.PopupInformativo;
import pe.com.intralot.loto.layer.service.client.PopupInformativoService;

@Controller
public class PopupInfoController {

	@Autowired
	public PopupInformativoService popupInformativoService;
	
	@RequestMapping("/obtenerPopupsInfo")
	public void obtenerPopupsInfo(
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setContentType("application/json; charset=UTF-8");
	    JsonObject jsonObjectResponse = new JsonObject();
	    PrintWriter outResponse = response.getWriter();
	    Gson gson = new Gson();
	    
	    List<PopupInformativo> popupsInformativo = popupInformativoService.obtenerPopupsInformativo();
	    
	    List<JsonElement> popupsInformativoJson = new ArrayList<JsonElement>();
	    
	    for(PopupInformativo popupInformativo : popupsInformativo) {
	    	
	    	popupInformativoService.validDateRange(popupInformativo);
	    	
	    	popupInformativoService.validatePopups(popupInformativo,popupsInformativo);
		    
	    	popupInformativoService.setRedirects(popupInformativo);
	    	
		    JsonElement popupInformativoJson = gson.toJsonTree(popupInformativo);
		    
		    popupsInformativoJson.add(popupInformativoJson);
	    }
	    
	    jsonObjectResponse.add("popupsInformativo", gson.toJsonTree(popupsInformativoJson));

	    outResponse.print(jsonObjectResponse);
	}
	
}
