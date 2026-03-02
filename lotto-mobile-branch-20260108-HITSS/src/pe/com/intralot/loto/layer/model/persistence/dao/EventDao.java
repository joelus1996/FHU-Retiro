package pe.com.intralot.loto.layer.model.persistence.dao;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: 
 *
 */

import java.util.List;

import pe.com.intralot.loto.layer.model.pojo.Event;
import pe.com.intralot.loto.layer.model.pojo.TeapuestoV;

public interface EventDao {	
	
	public List<TeapuestoV> findWithCondition01() throws Exception;	
	
	public Event findWithCondition02(Object params[])throws Exception;	
	
	public List<Event>  findWithCondition03() throws Exception;	
	
	public List<Event>  findWithCondition04(Object params[]) throws Exception; 
	
	public List<Event>  findWithCondition05(Object params[]) throws Exception;
	
	public List<Event> findWithCondition06() throws Exception;
	
	public List<Event> findWithCondition07(Object[] params) throws Exception ;

}