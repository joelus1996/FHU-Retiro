package pe.com.intralot.loto.layer.service.client.boimpl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.model.domain.ClientTicketLotos5;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientTicketLotos5Dao;
import pe.com.intralot.loto.layer.service.client.bo.ClientTicketLotos5Bo;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service
public class ClientTicketLotos5BoImpl implements ClientTicketLotos5Bo {

	@Autowired
	private ClientTicketLotos5Dao clientTicketLotos5Dao;
	
	@Override
	public ClientTicketLotos5 findById(Integer ticketId) throws Exception {
		LoggerApi.Log.info("ticketId=" + ticketId);
    	
    	ClientTicketLotos5 objectDomain = new ClientTicketLotos5();
    	
		try {   			        
			objectDomain = clientTicketLotos5Dao.findById(ticketId);
	        
		} catch(Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally {		
			if (objectDomain != null) {
				LoggerApi.Log.info("ctAgencyCd=" + objectDomain.getCtAgencyCd() + " ctBalanceItem=" + objectDomain.getCtBalanceItem());
			}
		}  
		
        return objectDomain;
	}

	@Override
	public ClientTicketLotos5 findByTicketNumber(BigDecimal ticketNumber)
			throws Exception {
		LoggerApi.Log.info("ticketNumber=" + ticketNumber);    	
    	ClientTicketLotos5 objectDomain = new ClientTicketLotos5();
    	
		try {   			        
			objectDomain = clientTicketLotos5Dao.findByTicketNumber(ticketNumber);
	        
		} catch(Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally {		
			if (objectDomain != null) {
				LoggerApi.Log.info("ctAgencyCd=" + objectDomain.getCtAgencyCd() + " ctBalanceItem=" + objectDomain.getCtBalanceItem());
			}
		}  
		
        return objectDomain;
	}
	
	@Override
	public ClientTicketLotos5 findByCouponId(Integer couponId) throws Exception {
		LoggerApi.Log.info("couponId=" + couponId);
    	
    	ClientTicketLotos5 objectDomain = new ClientTicketLotos5();
    	
		try {   			        
			objectDomain = clientTicketLotos5Dao.findByCouponId(couponId);
	        
		} catch(Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally {		
			if (objectDomain != null) {
				LoggerApi.Log.info("ticketId=" + objectDomain.getTicketId() );
			}
		}  
		
        return objectDomain;
	}

}
