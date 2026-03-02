package pe.com.intralot.loto.layer.model.persistence.dao;

import java.util.List;

import pe.com.intralot.loto.layer.model.domain.TinkaProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.TinkaProcedureBetDataSubscribe;
import pe.com.intralot.loto.layer.model.domain.TinkaProcedureDrawData;

public interface TinkaSaleDao {
	
	public TinkaProcedureBetData findBetData(Integer clientId) throws Exception;
	
	public TinkaProcedureBetDataSubscribe findBetDataSubscribe(Integer clientId) throws Exception;
	
	public List<TinkaProcedureDrawData>  findListDrawData() throws Exception;
	
	public String[]  findTinkaNextDraw() throws Exception;
	
}
