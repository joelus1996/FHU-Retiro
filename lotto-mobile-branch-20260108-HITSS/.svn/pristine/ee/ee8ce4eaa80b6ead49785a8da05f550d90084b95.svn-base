package pe.com.intralot.loto.layer.controller.client.bo;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import pe.com.intralot.loto.layer.model.pojo.PromProcedureInsertClient;
import pe.com.intralot.loto.layer.model.pojo.PromProcedureListFechaPromo;
import pe.com.intralot.loto.layer.model.pojo.PromProcedureListTicketClient;
import pe.com.intralot.loto.layer.model.pojo.PromProcedureGetFlagClient;
import pe.com.intralot.loto.layer.model.pojo.PromProcedureGetTicketsClient;

public interface PromSorteoBo {
	public PromProcedureInsertClient insertClient(String codPromo, Integer clientId, String promoChannel) throws Exception;

	public PromProcedureGetFlagClient getFlagClient(String codPromo, int clientId)  throws Exception;
	
	public List<PromProcedureGetTicketsClient> getTicketsClient(String codPromo, int clientId)  throws Exception;
	
	public List<PromProcedureListTicketClient>  getListTicketsClient(String codPromo, int clientId)  throws Exception;
	
	public List<PromProcedureListFechaPromo>  getListFechaPromo(String codPromo)  throws Exception;
	
	public int getByIdClient(HttpSession session);
	
	public String formatearFechaPromocion(Date dateInit, Date dateFin) ;
	
	public String formatearFechaSorteo(Date dateFin) ;
	
	public String formatearFechaSorteoSinAnio(Date dateFin) ;
	
	public double puntajePorJugadas(int cantSorteoPromo);
}
