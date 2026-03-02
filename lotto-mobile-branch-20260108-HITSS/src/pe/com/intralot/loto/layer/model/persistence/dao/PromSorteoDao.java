package pe.com.intralot.loto.layer.model.persistence.dao;

import java.util.List;

import pe.com.intralot.loto.layer.model.pojo.PromProcedureGetFlagClient;
import pe.com.intralot.loto.layer.model.pojo.PromProcedureGetTicketsClient;
import pe.com.intralot.loto.layer.model.pojo.PromProcedureInsertClient;
import pe.com.intralot.loto.layer.model.pojo.PromProcedureListFechaPromo;
import pe.com.intralot.loto.layer.model.pojo.PromProcedureListTicketClient;

public interface PromSorteoDao {
	public PromProcedureInsertClient insertClient(String codPromo, Integer clientId, String promoChannel) throws Exception;
	
	public PromProcedureGetFlagClient getFlagClient(String codPromo, int clientId) throws Exception;
	
	public List<PromProcedureGetTicketsClient> getTicketsClient(String codPromo, int clientId) throws Exception;
	
	public List<PromProcedureListTicketClient> getListTicketsClient(String codPromo, int clientId) throws Exception;
	
	public List<PromProcedureListFechaPromo>  getListFechaPromo(String codPromo)  throws Exception;
 
}
