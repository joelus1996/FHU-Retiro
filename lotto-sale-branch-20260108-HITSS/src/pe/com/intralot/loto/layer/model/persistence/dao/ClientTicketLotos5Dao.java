package pe.com.intralot.loto.layer.model.persistence.dao;

import java.math.BigDecimal;

import pe.com.intralot.loto.layer.model.domain.ClientTicketLotos5;

/**
 * @author:   Zolanch Tavara Sandon
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */
public interface ClientTicketLotos5Dao {

	public ClientTicketLotos5 findById(Integer ticketId) throws Exception;
	public ClientTicketLotos5 findByTicketNumber(BigDecimal ticketNumber) throws Exception;
	public ClientTicketLotos5 findByCouponId(Integer couponId) throws Exception;
	
}
