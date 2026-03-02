package pe.com.intralot.loto.layer.controller.game.ganagol.bo;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */

import java.util.List;

import pe.com.intralot.loto.layer.model.pojo.Draw;
import pe.com.intralot.loto.layer.model.pojo.DrawItem;
import pe.com.intralot.loto.layer.model.pojo.GanagolProcedureBetData;
import pe.com.intralot.loto.layer.model.pojo.GanagolProcedureBetDataMobile;
import pe.com.intralot.loto.layer.model.pojo.GanagolSale;


public interface GanagolBetBo {
	

	public List<DrawItem> findInformationForDrawItem() throws Exception;
	 
	public Draw getDrawsGanagol01()throws Exception;
	 
	public Draw getDrawsGanagol02()throws Exception;
	 
	public GanagolProcedureBetData findGanagolByClientId(Integer clientId) throws Exception;
	
	public GanagolProcedureBetDataMobile findGanagolByClientIdMobile(Integer clientId) throws Exception;

	public GanagolSale findGanagolBetData(Integer id) throws Exception;
	
	public Draw findInformationForDraw(Object[] params) throws Exception;
	
}