package pe.com.intralot.loto.layer.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import pe.com.intralot.loto.layer.model.domain.BalanceProcedureGetBalanceList;
import pe.com.intralot.loto.layer.service.client.bo.BalanceSaleBo;

public class BalanceSaleTest extends AbstractBaseUnitTest {
	@Autowired
	private BalanceSaleBo balanceSaleBo;
	
	@Test	
	public void findBalanceList() throws Exception {
		List<BalanceProcedureGetBalanceList> balanceSaleList = new ArrayList<BalanceProcedureGetBalanceList>();
		balanceSaleList = balanceSaleBo.findBalanceList(4);
		System.out.println(balanceSaleList.size());
		for (BalanceProcedureGetBalanceList balanceSale : balanceSaleList) {
			System.out.println(balanceSale.getBalanceItem()+" "+balanceSale.getBalanceDate());
		}
	}

}
