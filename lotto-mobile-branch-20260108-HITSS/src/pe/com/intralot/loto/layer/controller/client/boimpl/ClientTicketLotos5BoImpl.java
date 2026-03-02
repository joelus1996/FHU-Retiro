package pe.com.intralot.loto.layer.controller.client.boimpl;

/**
 * @author:   Celso Larico
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.intralot.loto.layer.controller.client.bo.ClientTicketLotos5Bo;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientTicketLotos5Dao;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service("beanClientTicketLotos5Bo")
public class ClientTicketLotos5BoImpl implements ClientTicketLotos5Bo {

	
	@Autowired
	private ClientTicketLotos5Dao beanClientTicketLotos5Dao;

	@SuppressWarnings("rawtypes")
	public String findTicketIdByCoupon(String couponId) throws Exception {
		//LoggerApi.Log.info("findTicketIdByCoupon couponId: " + couponId);
		String strTicketId = null;
		
		try {
			strTicketId = beanClientTicketLotos5Dao.findTicketIdByCoupon(couponId);
			
			return strTicketId;

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw new Exception(e);

		} finally {
			/*
			if(strTicketId!=null){
				LoggerApi.Log.info("findTicketIdByCoupon ticketId: " + strTicketId);
			}else{
				LoggerApi.Log.info("findTicketIdByCoupon ticketId: null");	
			}
			*/
		}
	}

}