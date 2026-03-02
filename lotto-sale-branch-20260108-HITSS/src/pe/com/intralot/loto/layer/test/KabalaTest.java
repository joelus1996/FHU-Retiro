package pe.com.intralot.loto.layer.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import pe.com.intralot.loto.layer.model.domain.KabalaProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.KabalaProcedureDrawData;
import pe.com.intralot.loto.layer.service.game.kabala.bo.KabalaBo;

public class KabalaTest extends AbstractBaseUnitTest{
	
	@Autowired
	private KabalaBo kabalaBo;

	public void procedureBetData() throws Exception {
	
		KabalaProcedureBetData kabalaProcedureBetData = kabalaBo.findByClientId(1);
		System.out.println(kabalaProcedureBetData.getPriceMessage());		
	
	}
	@Test
	public void procedureDrawData() throws Exception {
        
		List<KabalaProcedureDrawData> KabalaProcedureDrawDataList = kabalaBo.findListDraw();
		System.out.println(KabalaProcedureDrawDataList.get(0).getMessageDraw());
				
	}
	
}
