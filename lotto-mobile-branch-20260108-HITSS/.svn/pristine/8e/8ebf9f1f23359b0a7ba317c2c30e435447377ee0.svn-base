package pe.com.intralot.loto.layer.view.client;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import pe.com.intralot.loto.layer.controller.client.bo.UbigeoBo;
import pe.com.intralot.loto.layer.model.pojo.Departamento;
import pe.com.intralot.loto.layer.model.pojo.Distrito;
import pe.com.intralot.loto.layer.model.pojo.Provincia;
import pe.com.intralot.loto.layer.controller.client.bo.ClientAccountBo;
import pe.com.intralot.loto.layer.model.pojo.Country;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.Constantes;



@Controller
public class UbigeoController {
	
	@Autowired
	UbigeoBo ubigeoBo;
	
	@Autowired
    ClientAccountBo accountBo;

	@RequestMapping(value = "/getDepartamentos")
    public void getDepartamentos(HttpServletRequest request, HttpServletResponse response) throws Exception {

		LoggerApi.Log.info("-------------- START GET_LIST_DEPARTAMENTOS");
        	        	        
        PrintWriter out = null;
        response.setCharacterEncoding(Constantes.CHARSET_UTF8);
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
        response.setCharacterEncoding(Constantes.CHARSET_UTF8);
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
        response.setCharacterEncoding(Constantes.CHARSET_UTF8);
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
	     response.setCharacterEncoding(Constantes.CHARSET_UTF8);
	     out = response.getWriter();
	     List<Country> listDepartamento = accountBo.findCountry();
	     
         Gson gson = new Gson();
         out.println(gson.toJson(listDepartamento));     
        
		 LoggerApi.Log.info("-------------- END "+log); 
	 }

	
}
