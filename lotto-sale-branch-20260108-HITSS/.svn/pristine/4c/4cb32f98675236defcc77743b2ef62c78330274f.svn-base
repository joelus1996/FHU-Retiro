package pe.com.intralot.loto.layer.model.persistence.dao;

import java.util.List;

import pe.com.intralot.loto.layer.model.domain.KabalaProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.KabalaProcedureBetDataChCh;
import pe.com.intralot.loto.layer.model.domain.KabalaProcedureBetDataSubscribe;
import pe.com.intralot.loto.layer.model.domain.KabalaProcedureDrawData;

public interface KabalaSaleDao {
	
	public KabalaProcedureBetData findProcedureBetData(Integer clientId) throws Exception;
	
	public KabalaProcedureBetDataSubscribe findProcedureBetDataSubscribe(Integer clientId) throws Exception;
	
	public KabalaProcedureBetDataChCh findProcedureBetDataChCh(Integer clientId) throws Exception;
	
	public List<KabalaProcedureDrawData>  findProcedureDrawData() throws Exception;

	public String[] findKabalaNextDraw() throws Exception;
	
}
