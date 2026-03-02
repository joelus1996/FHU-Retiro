package pe.com.intralot.loto.layer.model.persistence.dao;

/**
 * @author:   Edgar Narro
 * @rol:	  Analista de desarrollo de sistemas
 * @proyecto: FHU Seguimiento de Marketing de Afiliados
 *
 */

import pe.com.intralot.loto.layer.model.domain.TrakingProcedureSaveClientBtag;

public interface ClientBtagDao {
	
	public TrakingProcedureSaveClientBtag saveClientBtag(Integer clientId, String btag) throws Exception;

}