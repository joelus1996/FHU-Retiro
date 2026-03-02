package pe.com.intralot.loto.layer.controller.game.teapuesto.bo;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */

import java.util.List;

import pe.com.intralot.loto.layer.model.pojo.Event;

public interface TeapuestoResultBo {
		
	public List<Event>  getDataRegularHeaderForResult() throws Exception;
	
	public List<Event> getResultForEvent(Object params[])throws Exception;
}