package pe.com.intralot.loto.layer.model.persistence.dao;


/**
 * @author cristian.cortez
 */
public interface ClientTicketLotos5Dao {
	
	public String findTicketIdByCoupon(String couponId) throws Exception;
	
}