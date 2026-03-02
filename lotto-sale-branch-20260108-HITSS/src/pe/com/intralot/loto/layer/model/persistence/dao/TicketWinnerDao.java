package pe.com.intralot.loto.layer.model.persistence.dao;

import pe.com.intralot.loto.layer.model.domain.TicketWinner;

/**
 * @author:   Zolanch Tavara Sandon
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */
public interface TicketWinnerDao {
	
	public TicketWinner findById(Long ticketId)throws Exception;
	public TicketWinner findByTicketNumber(String ticketNumber)throws Exception;

}
