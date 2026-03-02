package pe.com.intralot.loto.layer.model.persistence.dao;

import pe.com.intralot.loto.layer.model.domain.DrawItem;

/**
 * @author:   Zolanch Tavara Sandon
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */
public interface DrawItemDao {

	public DrawItem findByIdByGameId(Integer drawId,Integer gameID) throws Exception;

}
