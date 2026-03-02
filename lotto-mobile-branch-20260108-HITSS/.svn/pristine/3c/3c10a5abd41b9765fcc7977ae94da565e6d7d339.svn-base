package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.intralot.loto.layer.model.pojo.Provincia;
import pe.com.intralot.loto.layer.model.pojo.Distrito;
import pe.com.intralot.loto.layer.model.persistence.dao.UbigeoDao;
import pe.com.intralot.loto.layer.model.pojo.Departamento;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.HibernateBaseDaoImpl;


@Repository
public class UbigeoDaoImpl extends HibernateBaseDaoImpl implements UbigeoDao{

	
	@Transactional(readOnly = false)
	public List<Departamento> findDepartamento() throws Exception {
		
		List<Departamento> resultQueryList = new ArrayList<Departamento>();
						
		try {
					
			String queryString = "FROM Departamento d ORDER BY d.departmentName";
			resultQueryList = super.find(queryString);			
		} catch (Exception e) {
			LoggerApi.severe(e);
		} finally {
			if(resultQueryList != null)
				LoggerApi.Log.info("Lista_Departamentos");
		}
		return resultQueryList;
		
         
	}
	
	@Transactional(readOnly = false)
	public List<Provincia> findProvincia(String id_departamento) throws Exception {
		List<Provincia> resultQueryList = new ArrayList<Provincia>();
		
		try {
					
			String queryString = "FROM Provincia p WHERE p.departmentId='"+id_departamento+"' ORDER BY p.provinceName";
			resultQueryList = super.find(queryString);			
		} catch (Exception e) {
			LoggerApi.severe(e);
		} finally {
			if(resultQueryList != null)
				LoggerApi.Log.info("Lista_Provincias");
		}
		return resultQueryList;
	}
	
	@Transactional(readOnly = false)
	public List<Distrito> findDistrito(String id_provincia,String id_departamento) throws Exception {
		List<Distrito> resultQueryList = new ArrayList<Distrito>();
		
		try {
					
			String queryString = "FROM Distrito d WHERE d.provinceId='"+id_provincia+"' and d.departmentId='"+id_departamento+"' and d.districtName <> 'Venta Internet' ORDER BY d.districtName";
			resultQueryList = super.find(queryString);			
		} catch (Exception e) {
			LoggerApi.severe(e);
		} finally {
			if(resultQueryList != null)
				LoggerApi.Log.info("Lista_Distritos");
		}
		return resultQueryList;
	}
}
