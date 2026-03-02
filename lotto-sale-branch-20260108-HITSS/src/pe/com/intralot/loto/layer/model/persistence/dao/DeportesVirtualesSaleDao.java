package pe.com.intralot.loto.layer.model.persistence.dao;

import pe.com.intralot.loto.layer.model.domain.DeportesvirtualesProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.DeportesvirtualesProcedureGetEventsTraduction;

public interface DeportesVirtualesSaleDao {
	
	public DeportesvirtualesProcedureBetData findBetData(Integer clientId) throws Exception;
	
	public DeportesvirtualesProcedureGetEventsTraduction getEventsTraduction(String playlistId) throws Exception;
	
}
