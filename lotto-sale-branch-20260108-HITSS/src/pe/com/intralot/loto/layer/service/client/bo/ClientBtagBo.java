package pe.com.intralot.loto.layer.service.client.bo;

import javax.servlet.http.HttpServletRequest;

import pe.com.intralot.loto.layer.model.domain.TrakingProcedureSaveClientBtag;

/**
 * @author:   Edgar Narro
 * @rol:	  Analista de desarrollo de sistemas
 * @proyecto: FHU Seguimiento de Marketing de Afiliados
 *
 */

public interface ClientBtagBo {
	
	public TrakingProcedureSaveClientBtag saveClientBtag(HttpServletRequest request,Integer clientId) throws Exception;
	
}