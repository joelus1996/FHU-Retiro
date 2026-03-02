package pe.com.intralot.loto.layer.service.client;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import pe.com.intralot.loto.layer.model.pojo.PopupInformativo;
import pe.com.intralot.loto.layer.repository.client.PopupInformativoRepository;

@Service
public class PopupInformativoService {
	
	@Autowired
	public PopupInformativoRepository popupInformativoRepository;

	public static JsonParser PARSE_JSON = new JsonParser();
	
	public static String PLATAFORMA = "mobile";
	
	/*public PopupInformativo obtenerPopupInformativo(String codigoPopup, int codigoGame) throws Exception {
        
        return popupInformativoRepository.getPopupInformativo(codigoPopup, codigoGame);
    }*/
	
	public List<PopupInformativo> obtenerPopupsInformativo() throws Exception {
		return popupInformativoRepository.getPopupsInformativo();
	}
	
	public void validDateRange(PopupInformativo popupInformativo) {
		if (popupInformativo.getDateInit() == null || popupInformativo.getDateFin() == null) {
	        return;
	    }
	    
	    popupInformativo.setValidDateRange( this.isDateInclude(popupInformativo) );
	}
	
	public boolean isDateInclude(PopupInformativo popupInformativo) {
		Date fechaActual = new Date(); 
	    return fechaActual.after( popupInformativo.getDateInit() ) && fechaActual.before( popupInformativo.getDateFin() ) ;
	}

	public void validatePopups(PopupInformativo popupInformativo, List<PopupInformativo> popupsInformativo) {
		String[] codsPopupArray = ( popupInformativo.getCodsPopupAllowed() == null || popupInformativo.getCodsPopupAllowed().isEmpty() ) ? 
				new String[0] : popupInformativo.getCodsPopupAllowed().split(",");
			
		String codsPopupAllowed = popupInformativo.getCodsPopupAllowed();
				
		if(codsPopupArray.length <= 0) return;
		
		Set<String> listaCodPopup = new HashSet<String>();
        for (String codigo : codsPopupArray) {
        	listaCodPopup.add(codigo);
        }
		
		for (PopupInformativo popup : popupsInformativo) {
			if ( !listaCodPopup.contains( popup.getCodigoPopup() ) ) continue;
			
			// verificamos si el popup esta disponible por las fechas
			if( isDateInclude(popup) ) continue;
			
			// Usar una expresión regular para eliminar el código y comas adyacentes
			codsPopupAllowed = codsPopupAllowed.replaceAll("(^|,)" + popup.getCodigoPopup() + "(,|$)", ",");

			// Limpiar cualquier coma adicional al principio o al final de la cadena
			codsPopupAllowed = codsPopupAllowed.replaceAll("^,|,$", "");
			
        }
		
		popupInformativo.setCodsPopupAllowed(codsPopupAllowed);
	}
	
	public void setRedirects(PopupInformativo popupInformativo) {
		
		JsonObject redirectJson = PARSE_JSON.parse(popupInformativo.getLinkRedirect()).getAsJsonObject();
		
		String redirect = redirectJson.get(PLATAFORMA).getAsString();
		
		popupInformativo.setLinkRedirect(redirect);
		
		redirectJson = PARSE_JSON.parse(popupInformativo.getButtonRedirect() ).getAsJsonObject();
		
		redirect = redirectJson.get(PLATAFORMA).getAsString();
		
		popupInformativo.setButtonRedirect(redirect);
		
		redirectJson = PARSE_JSON.parse(popupInformativo.getLinksAllowed() ).getAsJsonObject();
		
		redirect = redirectJson.get(PLATAFORMA).getAsString();
		
		popupInformativo.setLinksAllowed(redirect);
	}
	
}
