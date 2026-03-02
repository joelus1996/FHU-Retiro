package pe.com.intralot.loto.layer.model.persistence.daoimpl;

/**
 * Interfaz para definir metodo(s) para client btag
 * @author:   Edgar Narro
 * @rol:	  Analista de desarrollo de sistemas
 * @proyecto: FHU Seguimiento de Marketing de Afiliados
 * @version:  001	Edgar Narro		06/10/2010  Implementat metodo para guardar cookie btag en base de datos
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import pe.com.intralot.loto.layer.model.domain.TrakingProcedureSaveClientBtag;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientBtagDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

@Repository
public class ClientBtagDaoImpl extends HibernateBaseDaoImpl implements ClientBtagDao {
		
	@Override
	public TrakingProcedureSaveClientBtag saveClientBtag(Integer clientId, String btag) throws Exception {
		String log="saveClientBtag";
		LoggerApi.Log.info(log+" clientId=" + clientId);
		List<TrakingProcedureSaveClientBtag> resultQuery = new ArrayList<TrakingProcedureSaveClientBtag>();
		TrakingProcedureSaveClientBtag objectDomain = new TrakingProcedureSaveClientBtag();
		Object[] values = new Object[2];
        values[0] = clientId;
        values[1] = btag;
        resultQuery = super.findForNamed("tracking_save_clientbtag", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info(log+" idClient="+clientId+" o_message="+objectDomain.getMessage());
        }
		return objectDomain;
	}

}