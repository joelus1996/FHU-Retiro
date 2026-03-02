package pe.com.intralot.loto.layer.model.persistence.dao;

import java.util.List;

import pe.com.intralot.loto.layer.model.pojo.Departamento;
import pe.com.intralot.loto.layer.model.pojo.Distrito;
import pe.com.intralot.loto.layer.model.pojo.Provincia;

public interface UbigeoDao {

	public List<Departamento> findDepartamento() throws Exception;
	public List<Provincia> findProvincia(String id_departamento) throws Exception;
	public List<Distrito> findDistrito(String id_departamento,String id_provincia) throws Exception;
}
