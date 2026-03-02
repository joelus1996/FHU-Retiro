package pe.com.intralot.loto.layer.controller.game.tinka.bo;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */

import java.util.List;


import pe.com.intralot.loto.layer.model.pojo.TinkaList;

public interface TinkaResultBo {

	public List<TinkaList> getResult() throws Exception;
	
}