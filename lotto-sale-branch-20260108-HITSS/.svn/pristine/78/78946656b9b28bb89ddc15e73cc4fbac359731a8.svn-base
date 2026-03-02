package pe.com.intralot.loto.layer.service.client.bo;

import java.util.List;

import pe.com.intralot.loto.layer.model.domain.CulqiCard;
import pe.com.intralot.loto.layer.model.domain.CulqiProcedureDefineTransaction;
import pe.com.intralot.loto.layer.model.domain.CulqiProcedureDelCustomerCard;
import pe.com.intralot.loto.layer.model.domain.CulqiProcedureNotifyTransaction;
import pe.com.intralot.loto.layer.model.domain.CulqiProcedureSetCustomerCard;

public interface CulqiBo {
	
	public CulqiProcedureDefineTransaction defineTransaction(Object[] values) throws Exception;
	
	public CulqiProcedureNotifyTransaction notifyTransaction(Object[] values) throws Exception;
	
	public CulqiProcedureSetCustomerCard setCustomerCard(Object[] values) throws Exception;
	
	//public List<CulqiProcedureListCustomerCard> listCustomerCard(int clientId) throws Exception;
	
	public List<CulqiCard> listCustomerCard(int clientId) throws Exception;
	
	public CulqiCard getCustomerCard(int clientId, int itemId) throws Exception;
	
	public CulqiProcedureDelCustomerCard delCustomerCard(int clientId, int itemId) throws Exception;
}
