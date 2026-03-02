package pe.com.intralot.loto.layer.repository.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.intralot.loto.layer.model.pojo.PopupInformativo;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.HibernateBaseDaoImpl;

@Repository
public class PopupInformativoRepository extends HibernateBaseDaoImpl {

	public List<PopupInformativo> getPopupsInformativo() throws Exception {
		List<PopupInformativo> resultQuery = new ArrayList<PopupInformativo>();
        try {
            resultQuery = super.findForNamed("GET_POPUP_INFO", null);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        }
        if (!resultQuery.isEmpty()) {
            return resultQuery;
        }
        return null;
	}
}
