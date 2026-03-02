package pe.com.intralot.loto.layer.model.persistence.dao;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */

import java.util.List;


import pe.com.intralot.loto.layer.model.pojo.ElreventonList;
import pe.com.intralot.loto.layer.model.pojo.GanadiarioList;
import pe.com.intralot.loto.layer.model.pojo.GanagolList;
import pe.com.intralot.loto.layer.model.pojo.KabalaList;
import pe.com.intralot.loto.layer.model.pojo.Super3List;
import pe.com.intralot.loto.layer.model.pojo.TinkaList;

public interface ViewDAO {
	
	public List<TinkaList> findWithCondition01() throws Exception;	
	
	public List<GanadiarioList> findWithCondition02() throws Exception;
	
	public List<GanagolList> findWithCondition03() throws Exception;
	
	public List<KabalaList> findWithCondition04() throws Exception;
	
	public List<Super3List> findWithCondition05() throws Exception;
	
	public List<ElreventonList> findWithCondition06() throws Exception;
	
	public List<TinkaList> findWithCondition07() throws Exception;
}