package pe.com.intralot.loto.layer.controller.client.boimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.controller.client.bo.UbigeoBo;
import pe.com.intralot.loto.layer.model.persistence.dao.UbigeoDao;
import pe.com.intralot.loto.layer.model.pojo.Departamento;
import pe.com.intralot.loto.layer.model.pojo.Distrito;
import pe.com.intralot.loto.layer.model.pojo.Provincia;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service
public class UbigeoBoImpl implements UbigeoBo{
	
	@Autowired
	private UbigeoDao ubigeoDao;

	@Override
	public List<Departamento> findDepartamento() throws Exception {
		List<Departamento> resultQuery = new ArrayList<Departamento>();
		
	 	try {
	 		resultQuery = ubigeoDao.findDepartamento();			
			
	        return resultQuery;
		} catch(Exception e) {
			LoggerApi.severe(e);			
			throw new Exception(e);
		} finally {	
			if(resultQuery!=null){
				LoggerApi.Log.info("resultQuery: "+resultQuery.size());	
			}else{
				LoggerApi.Log.info("resultQuery: "+"null");
			}
			
		}
	}

	@Override
	public List<Distrito> findDistrito(String id_departamento, String id_provincia) throws Exception {
		List<Distrito> resultQuery = new ArrayList<Distrito>();
		
	 	try {
	 		resultQuery = ubigeoDao.findDistrito(id_departamento,id_provincia);			
			
	        return resultQuery;
		} catch(Exception e) {
			LoggerApi.severe(e);			
			throw new Exception(e);
		} finally {	
			if(resultQuery!=null){
				LoggerApi.Log.info("resultQuery: "+resultQuery.size());	
			}else{
				LoggerApi.Log.info("resultQuery: "+"null");
			}
			
		}
	}

	@Override
	public List<Provincia> findProvincia(String id_departamento) throws Exception {
		List<Provincia> resultQuery = new ArrayList<Provincia>();
		
	 	try {
	 		resultQuery = ubigeoDao.findProvincia(id_departamento);			
			
	        return resultQuery;
		} catch(Exception e) {
			LoggerApi.severe(e);			
			throw new Exception(e);
		} finally {	
			if(resultQuery!=null){
				LoggerApi.Log.info("resultQuery: "+resultQuery.size());	
			}else{
				LoggerApi.Log.info("resultQuery: "+"null");
			}
			
		}
	}

}
