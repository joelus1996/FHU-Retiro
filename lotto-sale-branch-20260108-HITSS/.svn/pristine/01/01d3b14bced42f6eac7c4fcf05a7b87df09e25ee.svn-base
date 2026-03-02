package pe.com.intralot.loto.layer.test;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import pe.com.intralot.loto.layer.model.domain.FechazaProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.FechazaProcedureDrawData;
import pe.com.intralot.loto.layer.service.game.fechaza.bo.FechazaBo;

public class FechazaTest extends AbstractBaseUnitTest {
	@Autowired
	private FechazaBo fechazaBo;
	
	@Test
	public void findByClientId() throws Exception{	
		
		FechazaProcedureBetData fechazaSale = fechazaBo.findByClientId(4);
			System.out.println(fechazaSale.getMessage());
			//System.out.println(fechazaSale.getDrawDate());
	}
	@Test
	public void findListDrawData() throws Exception {
		List<FechazaProcedureDrawData> fechazaSaleList = new ArrayList<FechazaProcedureDrawData>();
		System.out.println(fechazaSaleList.size());
		fechazaSaleList = fechazaBo.findListDrawData();
		for (FechazaProcedureDrawData fechazaSale : fechazaSaleList) {
			System.out.println(fechazaSale.getNumDraws()+" "+fechazaSale.getDrawDate());
		}
	}

}
