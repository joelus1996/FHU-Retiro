package pe.com.intralot.loto.layer.service.game.clicygana.bo;

import pe.com.intralot.loto.layer.model.domain.ClicyganaProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.ClicyganaProcedureCommandCashier;
import pe.com.intralot.loto.layer.model.domain.ClicyganaProcedureCommandClose;

public interface ClicyganaBo {

    public ClicyganaProcedureBetData findByClientId(Integer clientId) throws Exception;

    public ClicyganaProcedureCommandClose findCommandClose(String sessionCode) throws Exception;

    public ClicyganaProcedureCommandCashier findCommandCashier(String sessionCode) throws Exception;

    public boolean isAllowedGoIn(String user);
}
