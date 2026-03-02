package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureDrawData;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureDrawMenu;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureExactData;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureExactMenu;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureSpecialData;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureSpecialGroup;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureSpecialHeader;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureSpecialMenu;
import pe.com.intralot.loto.layer.model.persistence.dao.TeapuestoSaleDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

@Repository
public class TeapuestoSaleDaoImpl extends HibernateBaseDaoImpl implements TeapuestoSaleDao {

    @Override
    public TeapuestoProcedureBetData findBetData(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("clientId=" + p_clientId);
        List<TeapuestoProcedureBetData> resultQuery = new ArrayList<TeapuestoProcedureBetData>();
        TeapuestoProcedureBetData objectDomain = new TeapuestoProcedureBetData();
        try {
            Object[] values = new Object[1];
            values[0] = p_clientId;
            resultQuery = super.findForNamed("TEAPUESTOSALE_BETDATA", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	/*
            if (objectDomain != null)
                LoggerApi.Log.info("w_status=" + objectDomain.getStatus() + " w_message=" + objectDomain.getMessage() + " w_price_type=" + objectDomain.getPriceType()
                        + " w_price_message=" + objectDomain.getPriceMessage() + " w_simple_bet_price=" + objectDomain.getSimpleBetPrice() );
            */
        }
        return objectDomain;
    }

    @Override
    public List<TeapuestoProcedureDrawData> findListDrawData(Integer p_drawId) throws Exception {
        //LoggerApi.Log.info("drawId=" + p_drawId);
        List<TeapuestoProcedureDrawData> resultQueryList = new ArrayList<TeapuestoProcedureDrawData>();
        try {
            Object[] values = new Object[1];
            values[0] = p_drawId;
            resultQueryList = super.findForNamedSetCache("TEAPUESTOSALE_DRAWDATA", values);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	//if (resultQueryList != null)
        	//    LoggerApi.Log.info("size=" + resultQueryList.size());
        }
        return resultQueryList;
    }

    @Override
    public List<TeapuestoProcedureDrawMenu> findListDrawMenu() throws Exception {
        List<TeapuestoProcedureDrawMenu> resultQueryList = new ArrayList<TeapuestoProcedureDrawMenu>();
        try {
            Object[] values = new Object[0];
            resultQueryList = super.findForNamedSetCache("TEAPUESTOSALE_DRAWMENU", values);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	//if (resultQueryList != null)
        	//    LoggerApi.Log.info("size=" + resultQueryList.size());
        }
        return resultQueryList;
    }

    @Override
    public List<TeapuestoProcedureExactMenu> findListExactMenu() throws Exception {
        List<TeapuestoProcedureExactMenu> resultQueryList = new ArrayList<TeapuestoProcedureExactMenu>();
        try {
            Object[] values = new Object[0];
            resultQueryList = super.findForNamedSetCache("TEAPUESTOSALE_EXACTMENU", values);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	//if (resultQueryList != null)
        	//    LoggerApi.Log.info("size=" + resultQueryList.size());
        }
        return resultQueryList;
    }

    @Override
    public List<TeapuestoProcedureSpecialData> findListSpecialData(String p_header, String p_tadrawId, Integer p_leagueId) throws Exception {
        //LoggerApi.Log.info("header=" + p_header + " p_tadrawId=" + p_tadrawId + " leagueId=" + p_leagueId);
        List<TeapuestoProcedureSpecialData> resultQueryList = new ArrayList<TeapuestoProcedureSpecialData>();
        try {
            Object[] values = new Object[3];
            values[0] = p_header;
            values[1] = p_tadrawId;
            values[2] = p_leagueId;
            resultQueryList = super.findForNamedSetCache("TEAPUESTOSALE_SPECIALDATA", values);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	// if (resultQueryList != null)
        	//    LoggerApi.Log.info("size=" + resultQueryList.size());
        }
        return resultQueryList;
    }

    @Override
    public List<TeapuestoProcedureSpecialMenu> findListSpecialMenu(String p_header) throws Exception {
    	//LoggerApi.Log.info("header=" + p_header);
        List<TeapuestoProcedureSpecialMenu> resultQueryList = new ArrayList<TeapuestoProcedureSpecialMenu>();
        try {
            Object[] values = new Object[1];
            values[0] = p_header;
            resultQueryList = super.findForNamedSetCache("TEAPUESTOSALE_SPECIALMENU", values);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	//if (resultQueryList != null)
        	//    LoggerApi.Log.info("size=" + resultQueryList.size());
        }
        return resultQueryList;
    }

    @Override
    public List<TeapuestoProcedureSpecialHeader> findSpecialHeader() throws Exception {
        List<TeapuestoProcedureSpecialHeader> resultQueryList = new ArrayList<TeapuestoProcedureSpecialHeader>();
        try {
            Object[] values = new Object[0];
            resultQueryList = super.findForNamedSetCache("TEAPUESTOSALE_SPECIALHEADER", values);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	//if (resultQueryList != null)
        	//    LoggerApi.Log.info("size=" + resultQueryList.size());
        }
        return resultQueryList;
    }

    @Override
    public TeapuestoProcedureExactData findtExactData(Integer p_drawId, Integer p_eventId) throws Exception {
    	//LoggerApi.Log.info("drawId=" + p_drawId + " eventId=" + p_eventId);
        List<TeapuestoProcedureExactData> resultQuery = new ArrayList<TeapuestoProcedureExactData>();
        TeapuestoProcedureExactData objectDomain = new TeapuestoProcedureExactData();
        try {
            Object[] values = new Object[2];
            values[0] = p_drawId;
            values[1] = p_eventId;
            resultQuery = super.findForNamedSetCache("TEAPUESTOSALE_EXACTDATA", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	/*
            if (objectDomain != null)
                LoggerApi.Log.info("w_event_id=" + objectDomain.getEventId() + " w_date=" + objectDomain.getDate() + " w_hour=" + objectDomain.getHour() + " w_local="
                        + objectDomain.getLocal() + " w_image_local=" + objectDomain.getImageLocal() + " w_visitor=" + objectDomain.getVisitor() + " w_image_visitor="
                        + objectDomain.getImageVisitor() + " w_s_0_0=" + objectDomain.getS00() + " w_s_1_0=" + objectDomain.getS10() + " w_s_2_0=" + objectDomain.getS20()
                        + " w_s_3_0=" + objectDomain.getS30() + " w_s_4_0=" + objectDomain.getS40() + " w_s_5_more_0=" + objectDomain.getS5More0() + " w_s_2_1="
                        + objectDomain.getS21() + " w_s_3_1=" + objectDomain.getS31() + " w_s_4_1=" + objectDomain.getS41() + " w_s_5_more_1=" + objectDomain.getS5More1()
                        + " w_s_3_2=" + objectDomain.getS32() + " w_s_4_2=" + objectDomain.getS42() + " w_s_5_more_2=" + objectDomain.getS5More2() + " w_s_4_3="
                        + objectDomain.getS43() + " w_s_5_more_3=" + objectDomain.getS5More3() + " w_s_5_more_4=" + objectDomain.getS5More4() + " w_s_1_1="
                        + objectDomain.getS11() + " w_s_2_2=" + objectDomain.getS22() + " w_s_3_3=" + objectDomain.getS33() + " w_s_4_5=" + objectDomain.getS44()
                        + " w_s_5_more_5_more=" + objectDomain.getS5More5More() + " w_s_4_5_more=" + objectDomain.getS45More() + " w_s_3_4=" + objectDomain.getS34()
                        + " w_s_3_5_more=" + objectDomain.getS35More() + " w_s_2_3=" + objectDomain.getS23() + " w_s_2_4=" + objectDomain.getS24() + " w_s_2_5_more="
                        + objectDomain.getS25More() + " w_s_1_2=" + objectDomain.getS12() + " w_s_1_3=" + objectDomain.getS13() + " w_s_1_4=" + objectDomain.getS14()
                        + " w_s_1_5_more=" + objectDomain.getS15More() + " w_s_0_1=" + objectDomain.getS01() + " w_s_0_2=" + objectDomain.getS02() + " w_s_0_3="
                        + objectDomain.getS03() + " w_s_0_4=" + objectDomain.getS04() + " w_s_0_5_more=" + objectDomain.getS05More());
            */
        }
        return objectDomain;
    }

    @Override
    public List<TeapuestoProcedureSpecialGroup> findListSpecialGroup(String p_header, String p_tadrawId) throws Exception {
    	//LoggerApi.Log.info("header=" + p_header + " tadrawId=" + p_tadrawId);
        List<TeapuestoProcedureSpecialGroup> resultQueryList = new ArrayList<TeapuestoProcedureSpecialGroup>();
        try {
            Object[] values = new Object[2];
            values[0] = p_header;
            values[1] = p_tadrawId;
            resultQueryList = super.findForNamedSetCache("TEAPUESTOSALE_SPECIALGROUP", values);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	//if (resultQueryList != null)
        	//    LoggerApi.Log.info("size=" + resultQueryList.size());
        }
        return resultQueryList;
    }
}