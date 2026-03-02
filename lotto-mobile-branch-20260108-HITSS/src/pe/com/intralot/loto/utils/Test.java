package pe.com.intralot.loto.utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import pe.com.intralot.loto.layer.controller.game.tinka.bo.TinkaBetBo;
import pe.com.intralot.loto.layer.controller.game.tinka.boimpl.TinkaBetBoImpl;
import pe.com.intralot.loto.layer.model.pojo.TinkaSale;
import pe.com.intralot.loto.layer.model.pojo.Tinka;


public class Test {


	public static void main(String[] args)  throws Throwable { 

		
		/*
		TinkaBetBo beanTinkaBetBo =  new TinkaBetBoImpl();
		IntralotUtils intralotUtils =  new IntralotUtils();
		TinkaSale tinkaSale = beanTinkaBetBo.findTinkaBetData();
		tinkaSale = intralotUtils.getdata(tinkaSale);
		
		System.out.println("::::game_tinka_show_menu BEGIN:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("tinkaSale="+tinkaSale.toString());
		
		TinkaSuscripcion tinkaSuscripcion8 = new TinkaSuscripcion(tinkaSale, 8);
		TinkaSuscripcion tinkaSuscripcion24 = new TinkaSuscripcion(tinkaSale, 24);
		TinkaSuscripcion tinkaSuscripcion48 = new TinkaSuscripcion(tinkaSale, 48);
		
		System.out.println("tinkaSuscripcion8="+tinkaSuscripcion8.toString());
		System.out.println("tinkaSuscripcion24="+tinkaSuscripcion24.toString());
		System.out.println("tinkaSuscripcion48="+tinkaSuscripcion48.toString());
	
		System.out.println("/game_tinka_show_menu END::::::::::::::::::::::::::");
		String play="24";
		System.out.println("::::game_tinka_show_bet BEGIN:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		if(play.equals("8") || play.equals("24") || play.equals("48")) {
			
			System.out.println("suscripcionPlayTinka_sorteos="+play);
			System.out.println("suscripcionPlayTinka_meses="+Integer.parseInt(play)/8);
			System.out.println(Constantes.Boleto.typeBoleto+"="+Constantes.BoletoTinka.boletoTinkaSuscripcionPrefijo+play);
			System.out.println(Constantes.Boleto.idBoleto+"="+"jugada_".concat(play));
			 
			System.out.println("return=game/tinka/interface-suscripcion-type");
			 
		   } else {
			System.out.println(Constantes.Boleto.typeBoleto+"="+Constantes.BoletoTinka.boletoTinkaRegular);
			System.out.println(Constantes.Boleto.idBoleto+"="+"jugada_".concat(play));
			System.out.println("typePlay="+play.toUpperCase());
			
			System.out.println("return=game/tinka/interface-bet-touchscreen");
				
		   }
		
		System.out.println("/game_tinka_show_bet END::::::::::::::::::::::::::");
		*/
		
		/*
		String play = "1LEV 2LEV 3LEV 4LEV 5LV 6L 7V 8E 9L 10L 11V 12V 13E 14E";
		Map<String, Map<String,List<String>>> game=new HashMap<String, Map<String,List<String>>>();
		Map<String, List<String>> playList=new LinkedHashMap<String, List<String>>();
		List<String> betList =new ArrayList<String>();
		
		System.out.println(play);
		System.out.println("***");
		play = play.replace("0", "");
		play = play.replace("1", "");
		play = play.replace("2", "");
		play = play.replace("3", "");
		play = play.replace("4", "");
        play = play.replace("5", "");
        play = play.replace("6", "");
        play = play.replace("7", "");
        play = play.replace("8", "");
        play = play.replace("9", "");
        
        System.out.println(play);
        System.out.println("***");
        String[] bets = play.split(" ");
        
        System.out.println(bets);
        System.out.println("***");
		
        Integer index=1;
		for (String bet : bets) {
			String firstOpt = bet.substring(0,1);
			String seconfOpt = bet.length()>1? bet.substring(1,2):"";
			String thirdOpt = bet.length()>2? bet.substring(2,3):"";
			System.out.println(firstOpt);
			if (seconfOpt!="")System.out.println(seconfOpt);
			if (thirdOpt!="")System.out.println(thirdOpt);
			System.out.println("***");
			betList.add(firstOpt);
			if (seconfOpt!="")betList.add(seconfOpt);
			if (thirdOpt!="")betList.add(thirdOpt);
			System.out.println(betList);
			System.out.println("***");
			
			playList.put("id_"+index++,betList);
			betList =  new ArrayList<String>();
			System.out.println(playList);
		    System.out.println("***");
		}
		
		game.put("a", playList);
		game.put("b", playList);
		game=new HashMap<String, Map<String,List<String>>>();
		System.out.println(game);
	    System.out.println("***");
	    
	    Integer totalJugadasNew = 1;
		Integer totalJugadasBoleto = 0;
		boolean isValid = false;
		
		for (Map.Entry<String, List<String>> bet : playList.entrySet()) {
			totalJugadasNew = totalJugadasNew*bet.getValue().size();
		}
		
		System.out.println(totalJugadasNew);
	    System.out.println("***");
	    
		for (Map.Entry<String, Map<String,List<String>>> jugada : game.entrySet()) {
			Integer totalJugadasOld = 1;
			for (Map.Entry<String,List<String>> bet : jugada.getValue().entrySet()) {
				totalJugadasOld = totalJugadasOld * bet.getValue().size();
			}
			totalJugadasBoleto += totalJugadasOld;
			System.out.println(totalJugadasOld);
		    System.out.println("***");
		    System.out.println(totalJugadasBoleto);
		    System.out.println("***");
		}
		
		if(totalJugadasBoleto+totalJugadasNew <= 288) isValid = true;
		
		System.out.println(isValid);
	    System.out.println("***");
	    
	    */
		
		BigInteger total = bin_newton(13);
		
		System.out.println(total);
		
	}
	
	private static BigInteger bin_newton(Integer cantidad) {
		BigInteger base = new BigInteger("720");
		return (factorial(cantidad)).divide(((factorial(cantidad-6)).multiply(base)));
	}
	
	private static BigInteger factorial(Integer cantidad) {
		BigInteger biCantidad = new BigInteger(String.valueOf(cantidad));
		
		if (cantidad < 0) return new BigInteger("0"); 
		else if (cantidad > 1) return factorial(cantidad - 1).multiply(biCantidad);
		else return new BigInteger("1");
	}
	

}
