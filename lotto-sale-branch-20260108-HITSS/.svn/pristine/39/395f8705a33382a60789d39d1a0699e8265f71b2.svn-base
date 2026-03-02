package pe.com.intralot.loto.layer.model.persistence.dao;

import java.util.List;

import pe.com.intralot.loto.layer.model.domain.GanadiarioProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.GanadiarioProcedureBetDataSubscribe;
import pe.com.intralot.loto.layer.model.domain.GanadiarioProcedureDrawData;

/**
 * @author: Zolanch Tavara Sandon
 * @rol: Analista Programador
 * @proyecto:
 */
public interface GanadiarioSaleDao {

    public GanadiarioProcedureBetData findProcedureBetData(Integer clientId) throws Exception;

    public List<GanadiarioProcedureDrawData> findProcedureDrawData() throws Exception;
    
    public GanadiarioProcedureBetDataSubscribe findProcedureBetDataSubscribe(Integer clientId) throws Exception;

	public String[] findGanadiarioNextDraw() throws Exception;
    
    // public GanadiarioProcedureSessionData findProcedureSessionData(String sessionCode) throws Exception;

}
