package pe.com.intralot.loto.layer.model.persistence.dao;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: 
 *
 */

import java.util.List;

import pe.com.intralot.loto.layer.model.pojo.Draw;
import pe.com.intralot.loto.layer.model.pojo.GanagolProcedureBetData;
import pe.com.intralot.loto.layer.model.pojo.GanagolProcedureBetDataMobile;

public interface DrawDao {
	
	public Draw findAllWithCondition01() throws Exception;	
	
	public Draw findAllWithCondition02() throws Exception;
	
	public Draw findAllWithCondition03() throws Exception;	
	
	public Draw findAllWithCondition04() throws Exception;
	
	public Draw findAllWithCondition05() throws Exception;
	
	public Draw findWithCondition06() throws Exception;
	
	public Draw findWithCondition07() throws Exception;
	
	public List<Draw> findWithCondition08() throws Exception;
	
	public List<Draw> findWithCondition09(Object[] params) throws Exception;
	
	public List<Draw> findWithCondition10() throws Exception;
	
	public Draw findAllWithCondition11() throws Exception;	
	
	public Draw findAllWithCondition12() throws Exception;	

	public Draw findAllWithCondition13() throws Exception;	
	
	public Draw findAllWithCondition14() throws Exception;
	
	public Draw findAllWithCondition15() throws Exception;
	
	public Draw findAllWithCondition16() throws Exception;
	
	public GanagolProcedureBetData findGanagolBetData(Integer clientId) throws Exception;
	
	public GanagolProcedureBetDataMobile findGanagolBetDataMobile(Integer clientId) throws Exception;
	
	public Draw getKineloLastResult() throws Exception;
	
	public List<Draw> getKineloLastResultByFecha(String fechaMinima, String fechaMaxima) throws Exception;
	
	public Draw findWithCondition17(Object[] params) throws Exception;
}