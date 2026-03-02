package pe.com.intralot.loto.layer.service.client.boimpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.PromProcedureGetFlagClient;
import pe.com.intralot.loto.layer.model.domain.PromProcedureGetTicketsClient;
import pe.com.intralot.loto.layer.model.domain.PromProcedureInsertClient;
import pe.com.intralot.loto.layer.model.domain.PromProcedureListTicketClient;
import pe.com.intralot.loto.layer.model.persistence.dao.PromSorteoDao;
import pe.com.intralot.loto.layer.model.domain.PromProcedureListFechaPromo;
import pe.com.intralot.loto.layer.service.client.bo.PromSorteoBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.Constants;


@Service
public class PromSorteoBoImpl implements PromSorteoBo{

	@Autowired
	PromSorteoDao promSorteoDao;
	
	@Override
	public PromProcedureInsertClient insertClient(String codPromo, Integer clientId, String promoChannel) throws Exception {
		LoggerApi.Log.info(" clientId=" + clientId + " codPromo=" + codPromo + " promoChannel=" + promoChannel);
		PromProcedureInsertClient objectDomain = new PromProcedureInsertClient();
        try {
            objectDomain = promSorteoDao.insertClient(codPromo, clientId, promoChannel);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        }
        return objectDomain;
	}

	@Override
	public PromProcedureGetFlagClient getFlagClient(String codPromo, int clientId)  throws Exception {
		LoggerApi.Log.info(" clientId=" + clientId + " codPromo=" + codPromo );
		PromProcedureGetFlagClient objectDomain = new PromProcedureGetFlagClient();
        try {
            objectDomain = promSorteoDao.getFlagClient(codPromo, clientId);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        }
        return objectDomain;
	}
	
	@Override
	public List<PromProcedureGetTicketsClient> getTicketsClient(String codPromo, int clientId)  throws Exception {
		LoggerApi.Log.info(" clientId=" + clientId + " codPromo=" + codPromo );
		List<PromProcedureGetTicketsClient> objectDomain = new ArrayList<PromProcedureGetTicketsClient>();
        try {
            objectDomain = promSorteoDao.getTicketsClient(codPromo, clientId);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        }
        return objectDomain;
	}

	@Override
	public List<PromProcedureListTicketClient> getListTicketsClient(String codPromo, int clientId) throws Exception {
		LoggerApi.Log.info(" clientId=" + clientId + " codPromo=" + codPromo );
		List<PromProcedureListTicketClient> objectDomain = new ArrayList<PromProcedureListTicketClient>();
        try {
            objectDomain = promSorteoDao.getListTicketsClient(codPromo, clientId);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        }
        return objectDomain;
	}
	
	@Override
	public List<PromProcedureListFechaPromo> getListFechaPromo(String codPromo) throws Exception {
		LoggerApi.Log.info( " codPromo=" + codPromo );
		List<PromProcedureListFechaPromo> objectDomain = new ArrayList<PromProcedureListFechaPromo>();
        try {
            objectDomain = promSorteoDao.getListFechaPromo(codPromo);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        }
        return objectDomain;
	}
	
	@Override
	public int getByIdClient(HttpSession session) {
		UserBean userSession = (UserBean) session.getAttribute(Constants.USR_SESION);
		
		return ( userSession != null && userSession.getpSessionid() != null && userSession.getpClientid() != null ) 
				? userSession.getpClientid() : 0;
				
	}
	
	@Override
	public String formatearFechaPromocion(Date dateInit, Date dateFin) {
        SimpleDateFormat sdfDia = new SimpleDateFormat("EEEE d",new Locale("es"));
        SimpleDateFormat sdfMes = new SimpleDateFormat("MMMM",new Locale("es"));
        SimpleDateFormat sdfAnio = new SimpleDateFormat("yyyy",new Locale("es"));

        String fechaInicio = sdfDia.format(dateInit) + " de " + sdfMes.format(dateInit) + " al ";
        String fechaFin = sdfDia.format(dateFin) + " de " + sdfMes.format(dateFin) + " del " + sdfAnio.format(dateFin);

        return fechaInicio + fechaFin;
    }
	
	@Override
	public String formatearFechaSorteo(Date dateFin) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateFin);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		dateFin = calendar.getTime();
        SimpleDateFormat formatoSorteo = new SimpleDateFormat("d 'de' MMMM 'del' yyyy", new Locale("es"));
        return formatoSorteo.format(dateFin);
    }
	
	@Override
	public String formatearFechaSorteoSinAnio(Date dateFin) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateFin);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		dateFin = calendar.getTime();
        SimpleDateFormat formatoSorteo = new SimpleDateFormat("d 'de' MMMM", new Locale("es"));
        return formatoSorteo.format(dateFin);
    }
	

}
