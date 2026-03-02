package pe.com.intralot.loto.layer.service.client.bo;

import java.util.List;

import pe.com.intralot.loto.layer.model.domain.Departamento;
import pe.com.intralot.loto.layer.model.domain.Distrito;
import pe.com.intralot.loto.layer.model.domain.Provincia;

public interface UbigeoBo {

	public List<Departamento> findDepartamento() throws Exception;
	public List<Distrito> findDistrito(String id_departamento,String id_provincia) throws Exception;
	public List<Provincia> findProvincia(String id_departamento) throws Exception;
}
