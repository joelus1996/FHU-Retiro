package pe.com.intralot.loto.layer.model.persistence.dao;

import java.util.List;

import pe.com.intralot.loto.layer.model.pojo.KineloProcedureBetData;
import pe.com.intralot.loto.layer.model.pojo.KineloProcedureDrawData;

public interface KineloSaleDao {
	public KineloProcedureBetData findBetData(Integer clientId) throws Exception;
	public List<KineloProcedureDrawData> findListDrawData() throws Exception ;
}
