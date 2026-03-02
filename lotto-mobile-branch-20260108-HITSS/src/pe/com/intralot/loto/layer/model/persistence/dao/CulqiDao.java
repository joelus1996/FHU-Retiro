package pe.com.intralot.loto.layer.model.persistence.dao;

import java.util.List;

import pe.com.intralot.loto.layer.model.pojo.CulqiCard;
import pe.com.intralot.loto.layer.model.pojo.CulqiProcedureDefineTransaction;
import pe.com.intralot.loto.layer.model.pojo.CulqiProcedureDelCustomerCard;
import pe.com.intralot.loto.layer.model.pojo.CulqiProcedureNotifyTransaction;
import pe.com.intralot.loto.layer.model.pojo.CulqiProcedureSetCustomerCard;

/**
 * @author cristian.cortez
 */
public interface CulqiDao {
	
	public List<CulqiCard> listCustomerCard(int clientId) throws Exception;
	
	public CulqiProcedureDefineTransaction defineTransaction(Object[] values) throws Exception;
	
	public CulqiProcedureNotifyTransaction notifyTransaction(Object[] values) throws Exception;
	
	public CulqiProcedureSetCustomerCard setCustomerCard(Object[] values) throws Exception;
	
	public CulqiCard getCustomerCard(int clientId, int itemId) throws Exception;
	
	public CulqiProcedureDelCustomerCard delCustomerCard(int clientId, int itemId) throws Exception;
}