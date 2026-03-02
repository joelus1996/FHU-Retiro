package pe.com.intralot.loto.layer.controller.game.kinelo.bo;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */

import java.util.List;

import pe.com.intralot.loto.layer.model.pojo.Draw;
import pe.com.intralot.loto.layer.model.pojo.KineloProcedureBetData;
import pe.com.intralot.loto.layer.model.pojo.KineloProcedureDrawData;

public interface KineloResultBo {
	
	public List<Draw> getResult() throws Exception;
	
	public List<Draw> getResultForItem(Object[] params) throws Exception;
	
	public Draw getKineloLastResult() throws Exception;
	
	public List<Draw> getKineloLastResultByFecha(String fechaMinima, String fechaMaxima) throws Exception;
	
	public KineloProcedureBetData findByClientId(Integer clientId) throws Exception;
	
	public List<KineloProcedureDrawData> findListDrawData() throws Exception ;
}