package pe.com.intralot.loto.layer.model.persistence.dao;

import java.util.List;

import pe.com.intralot.loto.layer.model.domain.GanagolProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.GanagolProcedureDrawData;
import pe.com.intralot.loto.layer.model.domain.GanagolProcedureProgramData;

/**
 * @author:   Victor Farro Veramendi
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */

public interface GanagolSaleDao {
	
	public GanagolProcedureBetData findBetData(Integer clientId) throws Exception;	
	public List<GanagolProcedureDrawData> findListDrawData() throws Exception;
	public List<GanagolProcedureProgramData> findListProgramData(Integer drawId) throws Exception;

}
