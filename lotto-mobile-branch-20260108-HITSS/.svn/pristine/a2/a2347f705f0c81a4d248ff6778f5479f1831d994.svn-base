package pe.com.intralot.loto.layer.controller.game.ganadiario.bo;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */

import java.util.HashMap;

import pe.com.intralot.loto.layer.model.pojo.GanadiarioSale;
import pe.com.intralot.loto.layer.model.pojo.Draw;

public interface GanadiarioBetBo {
		
	@SuppressWarnings("rawtypes")
	public HashMap[] getNumberConsecutive() throws Exception;	
	
	public Draw getDrawsGanadiario() throws Exception;
	
	public Draw getDataCloseDateGame() throws Exception;
	
	public GanadiarioSale findGanadiarioBetData(Integer id) throws Exception;
	
	public String[] findGanadiarioNextDraw() throws Exception;

	boolean isSubscriptionAllowedGoIn(String user);
	
	public boolean isPopup3x5solesActive();
	
}