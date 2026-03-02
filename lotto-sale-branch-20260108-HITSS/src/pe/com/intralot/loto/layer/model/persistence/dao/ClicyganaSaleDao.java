package pe.com.intralot.loto.layer.model.persistence.dao;

import pe.com.intralot.loto.layer.model.domain.ClicyganaProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.ClicyganaProcedureCommandCashier;
import pe.com.intralot.loto.layer.model.domain.ClicyganaProcedureCommandClose;

public interface ClicyganaSaleDao {

	public ClicyganaProcedureBetData findBetData(Integer clientId) throws Exception;

	public ClicyganaProcedureCommandClose findCommandClose(String sessionCode) throws Exception;

	public ClicyganaProcedureCommandCashier findCommandCashier(String sessionCode) throws Exception;

}
