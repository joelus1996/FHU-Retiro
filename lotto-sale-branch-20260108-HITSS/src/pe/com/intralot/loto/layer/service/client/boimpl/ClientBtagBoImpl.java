package pe.com.intralot.loto.layer.service.client.boimpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author:   Edgar Narro
 * @rol:	  Analista de desarrollo de sistemas
 * @proyecto: FHU Seguimiento de Marketing de Afiliados
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.model.domain.TrakingProcedureSaveClientBtag;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientBtagDao;
import pe.com.intralot.loto.layer.service.client.bo.ClientBtagBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service
public class ClientBtagBoImpl implements ClientBtagBo {

   
    @Autowired
    private ClientBtagDao clientBtagDao;    

	@Override
	public TrakingProcedureSaveClientBtag saveClientBtag(HttpServletRequest request,Integer clientId) throws Exception {
		String log="saveClientBtag";
		LoggerApi.Log.info("-------------- START "+log);
		TrakingProcedureSaveClientBtag procedureSaveClientBtag=new TrakingProcedureSaveClientBtag();
		try {
			//Obtener cookies de la solicitud
			Cookie[] cookies = request.getCookies();
			
			//Si hay cookies procesar
			if(cookies!=null) {
				for (Cookie cookie : cookies) {
					//Si existe cookie procesar
					if(cookie.getName().equals("btag")) {
						//Guardar cookie en base de datos
						procedureSaveClientBtag= clientBtagDao.saveClientBtag(clientId, cookie.getValue());
						break;
					}
				}
			}
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			LoggerApi.Log.info("--------------  END "+log+" convertedObject:" + procedureSaveClientBtag.toString());
		}
		return procedureSaveClientBtag;	
	}
}