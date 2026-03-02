package pe.com.intralot.loto.layer.controller.game.ganadiario.bo;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */

import java.util.List;
import pe.com.intralot.loto.layer.model.pojo.GanadiarioList;

public interface GanadiarioResultBo {
			
	public List<GanadiarioList> getResult()throws Exception;
}