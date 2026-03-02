package pe.com.intralot.loto.layer.model.persistence.dao;

import pe.com.intralot.loto.layer.model.domain.ClientTicketLotos5Item;

/**
 * @author:   Zolanch Tavara Sandon
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */
public interface ClientTicketLotos5ItemDao {

	public ClientTicketLotos5Item findById(Integer ticketId) throws Exception;

}
