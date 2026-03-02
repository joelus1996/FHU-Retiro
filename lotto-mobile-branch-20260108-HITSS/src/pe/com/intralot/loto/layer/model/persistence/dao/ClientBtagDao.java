package pe.com.intralot.loto.layer.model.persistence.dao;

import pe.com.intralot.loto.layer.model.pojo.TrakingProcedureSaveClientBtag;

/**
 * Interfaz para definir metodo(s) para client btag
 * @author:   Edgar Narro
 * @rol:	  Analista de desarrollo de sistemas
 * @proyecto: FHU Seguimiento de Marketing de Afiliados
 * @version:  001	Edgar Narro		13/10/2010  Metodo para guardar cookie btag en base de datos
 *
 */


public interface ClientBtagDao {
	
	public TrakingProcedureSaveClientBtag saveClientBtag(Integer clientId, String btag) throws Exception;

}