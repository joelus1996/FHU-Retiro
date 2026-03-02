package pe.com.intralot.loto.layer.service.client.bo;

/**
 * @author:   Celso Larico
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */

import pe.com.intralot.loto.layer.model.domain.Parameter;

public interface ParameterBo {
				
	public Parameter findByIdParameter(String idParameter) throws Exception;
	
}