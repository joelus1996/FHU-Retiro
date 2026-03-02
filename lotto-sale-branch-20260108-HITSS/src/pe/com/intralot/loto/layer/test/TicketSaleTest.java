package pe.com.intralot.loto.layer.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetPrizesList;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetTicketsList;
import pe.com.intralot.loto.layer.service.client.bo.TicketSaleBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;

public class TicketSaleTest extends AbstractBaseUnitTest {

	@Autowired
	private TicketSaleBo ticketSaleBo;

	@Test
	public void findPrizesList() throws Exception {
		List<TicketProcedureGetPrizesList> ticketSaleList = new ArrayList<TicketProcedureGetPrizesList>();
		ticketSaleList = ticketSaleBo.findPrizesList(4);
		System.out.println(ticketSaleList.size());
		for (TicketProcedureGetPrizesList ticketSale : ticketSaleList) {
			LoggerApi.Log.info(ticketSale.getParameterId() + " "
					+ ticketSale.getTicketId());
		}
	}

	@Test
	public void findTicketsList() throws Exception {
		List<TicketProcedureGetTicketsList> ticketSaleList = new ArrayList<TicketProcedureGetTicketsList>();
		ticketSaleList = ticketSaleBo.findTicketsListAll(4);
		System.out.println(ticketSaleList.size());
		for (TicketProcedureGetTicketsList ticketSale : ticketSaleList) {
			LoggerApi.Log.info(ticketSale.getParameterId() + " "
					+ ticketSale.getPrice());
		}
	}

}
