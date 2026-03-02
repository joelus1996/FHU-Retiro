package pe.com.intralot.loto.layer.model.persistence.dao;

import java.math.BigDecimal;

import pe.com.intralot.loto.layer.model.domain.ClientTicket;

/**
 * @author:   Zolanch Tavara Sandon
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */
public interface ClientTicketDao {
	
	public ClientTicket findById(Long ticketId)throws Exception;
	public ClientTicket findByTicketNumber(BigDecimal ticketNumber)throws Exception;
	
}
