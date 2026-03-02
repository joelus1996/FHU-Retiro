package pe.com.intralot.loto.layer.service.game.kinelo.bo;

import java.util.ArrayList;
import java.util.List;

import pe.com.intralot.loto.layer.model.domain.KineloProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.KineloProcedureDrawData;

public interface KineloBo {

    public KineloProcedureBetData findByClientId(Integer clientId) throws Exception;

    public List<KineloProcedureDrawData> findListDrawData() throws Exception;

    public ArrayList cotejadoKinelo(int clientId, int gameId, Long ticketId) throws Exception;
	
	public boolean isAllowedGoIn(String user);
}
