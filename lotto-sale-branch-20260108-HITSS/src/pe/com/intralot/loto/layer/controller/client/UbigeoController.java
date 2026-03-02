package pe.com.intralot.loto.layer.controller.client;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.google.gson.Gson;

import pe.com.intralot.loto.layer.model.domain.Country;
import pe.com.intralot.loto.layer.model.domain.Departamento;
import pe.com.intralot.loto.layer.model.domain.Distrito;
import pe.com.intralot.loto.layer.model.domain.Provincia;
import pe.com.intralot.loto.layer.service.client.bo.CountryBo;
import pe.com.intralot.loto.layer.service.client.bo.UbigeoBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Controller
public class UbigeoController {
	
	@Autowired
	UbigeoBo ubigeoBo;
	
	@Autowired
    CountryBo countryBo;
	
		
	 @RequestMapping(value = "/getDepartamentos")
	    public void getDepartamentos(HttpServletRequest request, HttpServletResponse response) throws Exception {
			LoggerApi.Log.info("-------------- START GET_LIST_DEPARTAMENTOS");
	        	        	        
	        PrintWriter out = null;
	        out = response.getWriter();
	        List<Departamento> listDepartamento = ubigeoBo.findDepartamento();
	        
	            Gson gson = new Gson();
	            out.println(gson.toJson(listDepartamento));
	           
			LoggerApi.Log.info("-------------- END GET_LIST_DEPARTAMENTOS"); 
	    }
	 
	 @RequestMapping(value = "/getProvincias")
	    public void getProvincias(HttpServletRequest request, HttpServletResponse response) throws Exception {
			LoggerApi.Log.info("-------------- START GET_LIST_PROVINCIAS");
	        
			String id_Departamento = request.getParameter("departamento").toString();
	        PrintWriter out = null;
	        out = response.getWriter();
	        List<Provincia> listProvincia = ubigeoBo.findProvincia(id_Departamento);
	        
	           Gson gson = new Gson();
	           out.println(gson.toJson(listProvincia));
	           
			LoggerApi.Log.info("-------------- END GET_LIST_PROVINCIAS"); 
	    }
	 
	 @RequestMapping(value = "/getDistritos")
	    public void getDistritos(HttpServletRequest request, HttpServletResponse response) throws Exception {
			LoggerApi.Log.info("-------------- START GET_LIST_DISTRITOS");
	        
			String id_provincia = request.getParameter("provincia").toString();
			String id_departamento = request.getParameter("departamento").toString();
	        PrintWriter out = null;
	        out = response.getWriter();
	        List<Distrito> listDistrito = ubigeoBo.findDistrito(id_provincia,id_departamento);
	        
	           Gson gson = new Gson();
	           out.println(gson.toJson(listDistrito));
	           
			LoggerApi.Log.info("-------------- END GET_LIST_DISTRITOS"); 
	    }
	 
	 @RequestMapping(value = "/getPaises")
	    public void getPaises(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 	String log="GET_LIST_COUNTRIES";
			LoggerApi.Log.info("-------------- START "+log);
	        	        	        
	        PrintWriter out = null;
	        out = response.getWriter();
	        List<Country> listPaises = countryBo.findCountry();
	        
	            Gson gson = new Gson();
	            out.println(gson.toJson(listPaises));
	           
			LoggerApi.Log.info("-------------- END "+log); 
	    }

}
