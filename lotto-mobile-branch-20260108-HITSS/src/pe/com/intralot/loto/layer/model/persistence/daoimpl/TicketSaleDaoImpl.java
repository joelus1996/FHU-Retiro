package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import pe.com.intralot.loto.layer.model.persistence.dao.TicketSaleDao;
import pe.com.intralot.loto.layer.model.pojo.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.layer.model.pojo.TicketProcedureGetClientTicketRetail;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.HibernateBaseDaoImpl;

@Repository
public class TicketSaleDaoImpl extends HibernateBaseDaoImpl implements TicketSaleDao {

	public TicketProcedureGetClientTicket findClientTicket(Integer p_clientid, Integer p_gameid, Long p_ticketid)
			throws Exception {
		LoggerApi.Log.info("cid=" + p_clientid + " p_gameid=" + p_gameid + " p_ticketid=" + p_ticketid);
        List<TicketProcedureGetClientTicket> resultQuery = new ArrayList<TicketProcedureGetClientTicket>();
        TicketProcedureGetClientTicket objectDomain = new TicketProcedureGetClientTicket();
        try {
            Object[] values = new Object[3];
            values[0] = p_clientid;
            values[1] = p_gameid;
            values[2] = p_ticketid;
            resultQuery = super.findForNamed("TICKETSALE_GETCLIENTTICKET", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null) {
                LoggerApi.Log.info("cid="+p_clientid+" p_ctticketid=" + objectDomain.getCtTicketId() + " p_ctclientid=" + objectDomain.getCtClientId() + " p_ticketnum="
                        + objectDomain.getCtTicketNumber() + " p_ctgameid=" + objectDomain.getCtGameId() + " p_ticketdate=" + objectDomain.getCtTicketDate() + " p_zonecd="
                        + objectDomain.getCtZoneCd() + " p_sectorcd=" + objectDomain.getCtSectorCd() + " p_agencycd=" + objectDomain.getCtAgencyCd() + " p_terminalnr="
                        + objectDomain.getCtTerminalNr() + " p_receiptnr=" + objectDomain.getCtReceiptNr() + " p_trnsnum=" + objectDomain.getCtTrnsNum() + " p_crc="
                        + objectDomain.getCtCrc() + " p_numcolumns=" + objectDomain.getCtNumColumns() + " p_saletype=" + objectDomain.getCtSaleType() + " p_eventitems="
                        + objectDomain.getCtEventItems() + " TrmId=" + objectDomain.getCtTrmId());
            } else {
                LoggerApi.Log.info("cid="+p_clientid+" objectDomain=" + objectDomain);
            }
        }
        return objectDomain;
	}
	
	public TicketProcedureGetClientTicketRetail findClientTicketRetail(Integer p_clientid, Integer p_gameid, String p_ticketid)
			throws Exception {
		LoggerApi.Log.info("cid=" + p_clientid + " p_gameid=" + p_gameid + " p_ticketid=" + p_ticketid);
        List<TicketProcedureGetClientTicketRetail> resultQuery = new ArrayList<TicketProcedureGetClientTicketRetail>();
        TicketProcedureGetClientTicketRetail objectDomain = new TicketProcedureGetClientTicketRetail();
        try {
            Object[] values = new Object[3];
            values[0] = p_clientid;
            values[1] = p_gameid;
            values[2] = p_ticketid;
            resultQuery = super.findForNamed("TICKETSALE_GETCLIENTTICKET_RETAIL", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null) {
                LoggerApi.Log.info("cid="+p_clientid+" p_ctticketid=" + objectDomain.getCtTicketId());
            } else {
                LoggerApi.Log.info("cid="+p_clientid+" objectDomain=" + objectDomain);
            }
        }
        return objectDomain;
	}

}
