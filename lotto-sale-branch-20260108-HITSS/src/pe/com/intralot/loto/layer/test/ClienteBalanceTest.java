package pe.com.intralot.loto.layer.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pe.com.intralot.loto.layer.model.domain.ClientBalance;
import pe.com.intralot.loto.layer.service.client.bo.ClientBalanceBo;

public class ClienteBalanceTest extends AbstractBaseUnitTest{

	@Autowired
	private ClientBalanceBo clientBalanceBo;
	
	/*@Test
	public void findByClientId() throws Exception{
	
		List<ClientBalance> clientBalanceList = new ArrayList<ClientBalance>();
		clientBalanceList = clientBalanceBo.findByIdClient(4);
		System.out.println(clientBalanceList.size());				
		for (ClientBalance clientBalance : clientBalanceList) {
			
			System.out.println(clientBalance.getIdClient()+" "+clientBalance.getBalaceItem() +" "+clientBalance.getCbSuperDate());
			
		//System.out.println(sdf.format(clientBalance.getCbBalanceDate().getTime()).toString());	
		}
	}*/
	public String DateFormat(String date) {

		SimpleDateFormat name, formato;
		String nameFormat;
		formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date calDate = null;

		try {
			calDate = formato.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		name = new SimpleDateFormat("EEE dd MMM", new Locale("es", "ES"));
		nameFormat = name.format(calDate);

		return nameFormat.toUpperCase();

	}
	
	

}
