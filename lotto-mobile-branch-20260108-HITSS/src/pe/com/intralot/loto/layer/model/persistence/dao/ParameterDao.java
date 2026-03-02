package pe.com.intralot.loto.layer.model.persistence.dao;

import pe.com.intralot.loto.layer.model.pojo.Parameter;

/**
 * <p>
 * NOMBRE: ParameterDao.java
 * <br></p>
 * <p>
 * FUNCION: Objeto de acceso a datos de la cuenta
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 001   Celso Larico  02/06/2020  First comment
 * </pre>
 * <br></p>
 */

public interface ParameterDao {
	
	public Parameter findByPk(String pk) throws Exception;
	
}