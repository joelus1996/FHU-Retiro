package pe.com.intralot.loto.layer.service.client.boimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetDetail;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicketRetail;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetPrizesList;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetRetailTeApuestoGrecia;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetTicketsFilterList;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetTicketsList;
import pe.com.intralot.loto.layer.model.persistence.dao.TicketRetailDao;
import pe.com.intralot.loto.layer.model.persistence.dao.TicketSaleDao;
import pe.com.intralot.loto.layer.service.client.bo.TicketSaleBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service
public class TicketSaleBoImpl implements TicketSaleBo {

	@Autowired
	private TicketSaleDao ticketSaleDao;
	
	@Autowired
	private TicketRetailDao ticketRetailDao;
	
	@Override
	public TicketProcedureGetClientTicket findByClientTicket(Integer p_clientid, Integer p_gameid, Long p_ticketid)throws Exception {

		LoggerApi.Log.info("cid=" + p_clientid + " p_gameid=" + p_gameid+" p_ticketid=" + p_ticketid);

		TicketProcedureGetClientTicket objectDomain = new TicketProcedureGetClientTicket();
		try {
			objectDomain = ticketSaleDao.findClientTicket(p_clientid, p_gameid,	p_ticketid);
			LoggerApi.Log.info("cid=" + p_clientid + " objectDomain=" + objectDomain);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain!=null) {
				LoggerApi.Log.info("cid=" + objectDomain.getCtClientId()
						+ " p_gameid=" + objectDomain.getCtGameId()
						+ " p_ticketid=" + objectDomain.getCtTicketId());
			} else {
				LoggerApi.Log.info("cid=null");
			}
		}
		return objectDomain;
	}

	@Override
	public StringBuffer findCouponByClientTicket(TicketProcedureGetClientTicket p_clientTicket, int tip_coupon) throws Exception {
		LoggerApi.Log.info("p_clientTicket=" + p_clientTicket + " tip_coupon=" + tip_coupon);
		StringBuffer htmlText = new StringBuffer();
		try {
			htmlText = ticketSaleDao.findCouponClientTicket(p_clientTicket, tip_coupon);
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally {
			
		}
		return htmlText;
	}
	
	@Override
	public StringBuffer findCouponByClientTicketTeApuesto(TicketProcedureGetClientTicket p_clientTicket, int tip_coupon) throws Exception {
		LoggerApi.Log.info("p_clientTicket=" + p_clientTicket + " tip_coupon=" + tip_coupon);
		StringBuffer htmlText = new StringBuffer();
		try {
			htmlText = ticketSaleDao.findCouponClientTicketTeApuesto(p_clientTicket, tip_coupon);
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally {
			
		}
		return htmlText;
	}
	
	@Override
	public StringBuffer findCouponByClientTicketFechaza(TicketProcedureGetClientTicket p_clientTicket, int tip_coupon) throws Exception {
		LoggerApi.Log.info("p_clientTicket=" + p_clientTicket + " tip_coupon=" + tip_coupon);
		StringBuffer htmlText = new StringBuffer();
		try {
			htmlText = ticketSaleDao.findCouponClientTicketFechaza(p_clientTicket, tip_coupon);
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally {
			
		}
		return htmlText;
	}
	
	@Override
	public StringBuffer findCouponByClientTicketKinelo(TicketProcedureGetClientTicket p_clientTicket,  int tip_coupon) throws Exception {
		LoggerApi.Log.info("p_clientTicket=" + p_clientTicket + " tip_coupon=" + tip_coupon);
		StringBuffer htmlText = new StringBuffer();
		try {
			htmlText = ticketSaleDao.findCouponClientTicketKinelo(p_clientTicket, tip_coupon);
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally {
			
		}
		return htmlText;
	}
	
	@Override
	public StringBuffer findCouponByClientTicketPollayPollon(TicketProcedureGetClientTicket p_clientTicket) throws Exception {
		LoggerApi.Log.info("ctClientId=" + p_clientTicket.getCtClientId() + " ctBetMatrix1=" + p_clientTicket.getCtBetMatrix1());
		StringBuffer htmlText = new StringBuffer();
		try {
			htmlText = ticketSaleDao.findCouponClientTicketPollayPollon(p_clientTicket);
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally {
			
		}
		return htmlText;
	}


	
	@Override
	public List<TicketProcedureGetPrizesList> findPrizesList(Integer p_clientId) throws Exception {

		LoggerApi.Log.info("cid=" + p_clientId);

		List<TicketProcedureGetPrizesList> resultQueryList = new ArrayList<TicketProcedureGetPrizesList>();
		try {
			resultQueryList = ticketSaleDao.findPrizesList(p_clientId);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			LoggerApi.Log.info("size=" + resultQueryList.size());
		}
		return resultQueryList;
	}

	@Override
	public StringBuffer findCouponClientTicketRapitinkas(TicketProcedureGetClientTicket p_clientTicket, int  tip_coupon) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientTicket.getCtClientId() + " ctBetMatrix1=" + p_clientTicket.getCtBetMatrix1() + " tip_coupon=" + tip_coupon);
		StringBuffer htmlText = new StringBuffer();
		try {
			htmlText = ticketSaleDao.findCouponClientTicketRapitinkas(p_clientTicket, tip_coupon);
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally {			
		}
		return htmlText;
	}

	@Override
	public StringBuffer findCouponClientTicketElReventon (TicketProcedureGetClientTicket p_clientTicket, int  tip_coupon) throws Exception {
		LoggerApi.Log.info("ctClientId=" + p_clientTicket.getCtClientId() + " ctBetMatrix1=" + p_clientTicket.getCtBetMatrix1() + " tip_coupon=" + tip_coupon);
		StringBuffer htmlText = new StringBuffer();
		try {
			htmlText = ticketSaleDao.findCouponClientTicketElReventon(p_clientTicket, tip_coupon);
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally {			
		}
		return htmlText;
	}
	@Override
	public StringBuffer findCouponClientTicketClicyGana(TicketProcedureGetClientTicket p_clientTicket) throws Exception {
		LoggerApi.Log.info("ctClientId=" + p_clientTicket.getCtClientId() + " ctBetMatrix1=" + p_clientTicket.getCtBetMatrix1());
		StringBuffer htmlText = new StringBuffer();
		try {
			htmlText = ticketSaleDao.findCouponClientTicketClicyGana(p_clientTicket);
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally {
		}
		return htmlText;
	}

	@Override
	public StringBuffer findCouponClientTicketDeportesVirtuales(TicketProcedureGetClientTicket p_clientTicket) throws Exception {
		LoggerApi.Log.info("ctClientId=" + p_clientTicket.getCtClientId() + " ctBetMatrix1=" + p_clientTicket.getCtBetMatrix1());
		StringBuffer htmlText = new StringBuffer();
		try {
			htmlText = ticketSaleDao.findCouponClientTicketDeportesVirtuales(p_clientTicket);
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally {
			
		}
		return htmlText;
	}
	
	@Override
	public StringBuffer findCouponByClientTicketRetail(TicketProcedureGetClientTicketRetail p_clientTicket, int tip_coupon, ClientProcedureGetDetail clientDetail) throws Exception {
		LoggerApi.Log.info("p_clientTicket=" + p_clientTicket + " tip_coupon=" + tip_coupon + " p_dni="+clientDetail.getClDocNumber());
		StringBuffer htmlText = new StringBuffer();
		try {
			htmlText = ticketSaleDao.findCouponClientTicketRetail(p_clientTicket, tip_coupon,clientDetail);
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally {
			
		}
		return htmlText;
	}
	
	
	@Override
	public StringBuffer findCouponByClientTicketTeApuestoGrecia(List<TicketProcedureGetRetailTeApuestoGrecia> p_detalleticket, TicketProcedureGetClientTicketRetail p_clientTicket, int tip_coupon) throws Exception {
		LoggerApi.Log.info("p_clientTicket=" + p_clientTicket + " tip_coupon=" + tip_coupon);
		StringBuffer htmlText = new StringBuffer();
		try {
			htmlText = ticketSaleDao.findCouponClientTicketTeApuestoGrecia(p_detalleticket,p_clientTicket, tip_coupon);
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally {
			
		}
		return htmlText;
	}
	
	@Override
	public List<TicketProcedureGetRetailTeApuestoGrecia> findByClientTickeTeApuestoGrecia(int p_programa, int p_cpn) throws Exception {
	    LoggerApi.Log.info("p_programa=" + p_programa + " p_cpn=" + p_cpn);

	    List<TicketProcedureGetRetailTeApuestoGrecia> resultQueryList = new ArrayList<TicketProcedureGetRetailTeApuestoGrecia>();
	    try {
	    	resultQueryList = ticketSaleDao.findByClientTickeTeApuestoGrecia(p_programa, p_cpn);
	    } catch (Exception e) {
	        LoggerApi.severe(e);
	        throw e;
	    } finally {
	        if (resultQueryList != null) {
	            LoggerApi.Log.info("size=" + resultQueryList.size());
	        }
	    }
	    return resultQueryList;
	}

	@Override
	public List<TicketProcedureGetTicketsList> findTicketsListAll(Integer clientId) throws Exception {		
		List<TicketProcedureGetTicketsList> tiketsListAll = new ArrayList<TicketProcedureGetTicketsList>();
		// obtener tickets web
        List<TicketProcedureGetTicketsList> ticketsList = ticketSaleDao.findTicketsList(clientId);
        
        // obtener tickets retail
        List<TicketProcedureGetTicketsList> ticketsRetailList = ticketRetailDao.findByClientTicketRetailList(clientId);
        
        // añadir tickets web a la lista principal
        if(ticketsList != null && ticketsList.size() > 0) {
            	tiketsListAll.addAll(ticketsList);
        }        
        
        //añadir tickets retail a la lista principal
        if(ticketsRetailList != null && ticketsRetailList.size() > 0) {
        	
            tiketsListAll.addAll(ticketsRetailList);
        }
        
		return tiketsListAll;
	}
	
	@Override
	public List<TicketProcedureGetTicketsFilterList> findTicketsListFilterAll(Integer p_clientId, String p_start_date,
			String p_end_date) throws Exception {
		try {
			
			List<TicketProcedureGetTicketsFilterList> tiketsListAll = new ArrayList<TicketProcedureGetTicketsFilterList>();
			
			// obtener tickets web
	        List<TicketProcedureGetTicketsFilterList> ticketsList = ticketSaleDao.findTicketsListFilter(p_clientId,p_start_date, p_end_date);
	        
	        // obtener tickets retail
	        List<TicketProcedureGetTicketsFilterList> ticketsRetailList = ticketRetailDao.findTicketsRetailListFilter(p_clientId,p_start_date, p_end_date);
	        
			
	        if(ticketsList != null && ticketsList.size() > 0) {
            	tiketsListAll.addAll(ticketsList);
	        }    
			
	        if(ticketsRetailList != null && ticketsRetailList.size() > 0) {
	        	
	            tiketsListAll.addAll(ticketsRetailList);
	        }   
	        
			return tiketsListAll;
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} 

	}

	@Override
	public StringBuffer findCouponByTicketRetailGanagol(TicketProcedureGetClientTicketRetail p_clientTicket, int tip_coupon, ClientProcedureGetDetail clientDetail) throws Exception {
		LoggerApi.Log.info("p_clientTicket=" + p_clientTicket + " tip_coupon=" + tip_coupon + " docNumber=" + clientDetail.getClDocNumber());
		StringBuffer htmlText = new StringBuffer();
		try {
			htmlText = ticketSaleDao.findCouponByTicketRetailGanagol(p_clientTicket, tip_coupon,clientDetail);
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally {
			
		}
		return htmlText;
	}
	
	@Override
	public ClientProcedureGetDetail findClientDetail(Integer p_clientid)throws Exception {
		ClientProcedureGetDetail objectDomain = new ClientProcedureGetDetail();
		try {
			objectDomain = ticketSaleDao.findClientDetail(p_clientid);
			LoggerApi.Log.info("cid=" + p_clientid + " objectDomain=" + objectDomain);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} 
		return objectDomain;
	}
	
}
