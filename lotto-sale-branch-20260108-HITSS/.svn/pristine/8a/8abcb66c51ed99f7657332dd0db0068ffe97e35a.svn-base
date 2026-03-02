package pe.com.intralot.loto.layer.model.persistence.dao;

import java.util.List;

import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureDrawData;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureDrawMenu;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureExactData;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureExactMenu;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureSpecialData;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureSpecialGroup;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureSpecialHeader;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureSpecialMenu;

public interface TeapuestoSaleDao {

	public TeapuestoProcedureBetData findBetData(Integer clientId) throws Exception;
	
	public List<TeapuestoProcedureDrawData> findListDrawData(Integer drawId) throws Exception;
	
	public List<TeapuestoProcedureDrawMenu> findListDrawMenu() throws Exception;
	
	public List<TeapuestoProcedureExactMenu> findListExactMenu() throws Exception;
	
	public TeapuestoProcedureExactData findtExactData(Integer drawId,Integer eventId) throws Exception;
	
	public List<TeapuestoProcedureSpecialHeader> findSpecialHeader() throws Exception;
	
	public List<TeapuestoProcedureSpecialMenu> findListSpecialMenu(String header) throws Exception;
	
	public List<TeapuestoProcedureSpecialData> findListSpecialData(String header,String tadrawId,Integer leagueId) throws Exception;
	
	public List<TeapuestoProcedureSpecialGroup> findListSpecialGroup(String header, String tadrawId) throws Exception;
	
	
}
