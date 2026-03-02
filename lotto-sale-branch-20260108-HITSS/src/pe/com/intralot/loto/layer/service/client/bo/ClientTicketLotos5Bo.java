package pe.com.intralot.loto.layer.service.client.bo;

import java.math.BigDecimal;

import pe.com.intralot.loto.layer.model.domain.ClientTicketLotos5;

public interface ClientTicketLotos5Bo {
	
	public ClientTicketLotos5 findById(Integer ticketId) throws Exception;
	public ClientTicketLotos5 findByTicketNumber(BigDecimal ticketNumber) throws Exception;
	public ClientTicketLotos5 findByCouponId(Integer couponId) throws Exception;
}
