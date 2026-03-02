package pe.com.intralot.loto.layer.service.client.bo;

import java.util.List;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetDetail;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicketRetail;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetPrizesList;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetRetailTeApuestoGrecia;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetTicketsFilterList;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetTicketsList;

public interface TicketSaleBo {
	
	public List<TicketProcedureGetPrizesList> findPrizesList(Integer clientId) throws Exception;
	
	public TicketProcedureGetClientTicket findByClientTicket(Integer p_clientid, Integer p_gameid, Long p_ticketid) throws Exception;
	
	public StringBuffer findCouponByClientTicket(TicketProcedureGetClientTicket p_clientTicket, int tip_coupon) throws Exception;
	
	public StringBuffer findCouponByClientTicketTeApuesto(TicketProcedureGetClientTicket p_clientTicket, int tip_coupon) throws Exception;
	
	public StringBuffer findCouponByClientTicketFechaza(TicketProcedureGetClientTicket p_clientTicket, int tip_coupon) throws Exception;
	
	public StringBuffer findCouponByClientTicketKinelo(TicketProcedureGetClientTicket p_clientTicket, int tip_coupon) throws Exception;
	
	public StringBuffer findCouponByClientTicketPollayPollon(TicketProcedureGetClientTicket p_clientTicket) throws Exception;
	
	public StringBuffer findCouponClientTicketRapitinkas (TicketProcedureGetClientTicket p_clientTicket, int tip_coupon) throws Exception;
	
	public StringBuffer findCouponClientTicketElReventon (TicketProcedureGetClientTicket p_clientTicket, int tip_coupon) throws Exception;
	
	public StringBuffer findCouponClientTicketClicyGana (TicketProcedureGetClientTicket p_clientTicket) throws Exception;

	public StringBuffer findCouponClientTicketDeportesVirtuales (TicketProcedureGetClientTicket p_clientTicket) throws Exception;
	
	public StringBuffer findCouponByClientTicketRetail(TicketProcedureGetClientTicketRetail p_clientTicket, int tip_coupon, ClientProcedureGetDetail clientDetail) throws Exception;
	
	public StringBuffer findCouponByClientTicketTeApuestoGrecia(List<TicketProcedureGetRetailTeApuestoGrecia> p_detalleticket,TicketProcedureGetClientTicketRetail p_clientTicket, int tip_coupon) throws Exception;
	
	public StringBuffer findCouponByTicketRetailGanagol(TicketProcedureGetClientTicketRetail p_clientTicket, int tip_coupon, ClientProcedureGetDetail clientDetail) throws Exception;
	
	public List<TicketProcedureGetRetailTeApuestoGrecia> findByClientTickeTeApuestoGrecia(int p_programa, int p_cpn) throws Exception;
	
	public List<TicketProcedureGetTicketsList> findTicketsListAll(Integer clientId) throws Exception;
	
	public List<TicketProcedureGetTicketsFilterList> findTicketsListFilterAll(Integer clientId, String start_date, String end_date) throws Exception;
	
	public ClientProcedureGetDetail findClientDetail(Integer clientId) throws Exception; 
	
	
}
