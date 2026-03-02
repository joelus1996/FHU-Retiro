package pe.com.intralot.loto.layer.test;

import pe.com.intralot.loto.layer.model.domain.ClientProcedureAccountData;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.service.client.boimpl.ClientSaleBoImpl;
import pe.com.intralot.loto.lib.StringLib;
import pe.com.intralot.loto.util.ClientUtils;
import org.apache.commons.lang.StringUtils;
//import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Test {

	public static void main(String[] args) throws Exception {
		
		
		//Integer id = 27764;
		//ClientSaleBo clientSaleBo =  new ClientSaleBoImpl();
		//ClientProcedureAccountData clientProcedureAccountData = clientSaleBo.findAccountData(id);
		
		String result = "{\"clientName\":\"Emanuel\",\"mailStatus\":\"ACT\",\"balanceAmount\":7668351.6,\"numPrizes\":0,\"neoprizeAmount\":0.0,\"kironPrizeAmount\":0.0,\"bonusStatus\":\"Activo\",\"bonusMessage\":\"\\u003cspan style\\u003d\\u0027font-size: 18px;\\u0027\\u003eACTIVAR BONO DE   50%\\u003c/span\\u003e por recargas m\\u0026iacute;nimas de S/   50\",\"bonusDate\":\"06/12/2017\",\"bonusClientStatus\":\"Pendiente\",\"bonusAddedBalance\":\" \",\"bonusForPlay\":\"700\",\"bonusLastDate\":\"05/01/2018\",\"minOdd\":\"1.75\",\"bonusAmount\":\"200\",\"bonusLimit\":\"700\",\"bonusPercentage\":\"50\",\"bonusChannel\":\"BCP CULQUI LOTOCARD PEFE RDDG SPAY\",\"channel1Order\":\"CULQUI,BCP,PEFE,SPAY,OTHER\",\"channel2Order\":\"LOTOCARD,PEFE,SPAY,OTHER\",\"stepAmount\":\"50\",\"welcomeBonusStatus\":\"Desactivado\",\"welcomeBonusPercentaje\":\"0\",\"welcomeBonusMessage\":\" \",\"welcomeBonusLastDate\":\" \"}";
		
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(result).getAsJsonObject();
		
		String welcomeBonus = o.get("welcomeBonusStatus").getAsString();
		
		System.out.println(welcomeBonus);
	}

	
	
}
