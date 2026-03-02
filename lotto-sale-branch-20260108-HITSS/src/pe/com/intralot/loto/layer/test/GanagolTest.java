package pe.com.intralot.loto.layer.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pe.com.intralot.loto.layer.model.domain.GanagolProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.GanagolProcedureDrawData;
import pe.com.intralot.loto.layer.service.game.ganagol.bo.GanagolBo;

public class GanagolTest extends AbstractBaseUnitTest {

	@Autowired
	private GanagolBo ganagolBo;

	@Test
	public void findByClientId() throws Exception {
		GanagolProcedureBetData ganagolSale = ganagolBo.findByClientId(4);
		System.out.println(ganagolSale.getBets());
		System.out.println(ganagolSale.getPay());
	}

	@Test
	public void findListDrawData() throws Exception {
		List<GanagolProcedureDrawData> ganagolSaleList = new ArrayList<GanagolProcedureDrawData>();
		ganagolSaleList = ganagolBo.findListDrawData();
		for (GanagolProcedureDrawData ganagolSale : ganagolSaleList) {
			System.out.println(ganagolSale.getImageLocal());
			System.out.println(ganagolSale.getVisitor());
		}
	}

}