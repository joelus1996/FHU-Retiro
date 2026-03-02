package pe.com.intralot.loto.layer.controller.client.bo;

import javax.servlet.http.HttpServletRequest;

import pe.com.intralot.loto.layer.model.pojo.TrakingProcedureSaveClientBtag;

/**
 * Interfaz para definir metodo(s) para client btag
 * @author:   Edgar Narro
 * @rol:	  Analista de desarrollo de sistemas
 * @proyecto: FHU Seguimiento de Marketing de Afiliados * 
 * @version:  001	Edgar Narro		13/10/2010  Metodo para guardar cookie btag
 *
 */

public interface ClientBtagBo {
	
	public TrakingProcedureSaveClientBtag saveClientBtag(HttpServletRequest request,Integer clientId) throws Exception;
	
}