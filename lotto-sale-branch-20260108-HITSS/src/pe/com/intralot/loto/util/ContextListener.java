package pe.com.intralot.loto.util;

/**
 * <p>
 * NOMBRE: ContextListener.java
 * <br></p>
 * <p>
 * FUNCION: Inicialización de métodos para el manejo de datos de la cuenta 
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 002   Cristian Cortez  25/06/2018  LOG de las variables parametrizadas
 * 001   Cristian Cortez  06/10/2010  First comment
 * </pre>
 * <br></p>
 */

import javax.servlet.ServletContextListener;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;


//import pe.com.intralot.loto.sale.card.lib.LoggerAPI;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.lib.ConnectionFactory; 
import pe.com.intralot.loto.lib.StringLib;

public class ContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		try {
			System.out.println("LOTTO-SALE Destroying web context");
			//JackpotCasinoObserver.finalized();
		} catch(Exception ex){
			ex.printStackTrace();
		}			
	}

	public void contextInitialized(ServletContextEvent sce) {
		try {
			//Inicializar clase SpringFactory de SaleCard
			StringLib.encodeLabel("123");
			pe.com.intralot.loto.sale.card.lib.SpringFactory.init();
			System.out.println("********** LOTTO-SALE SpringFactory de SaleCard Iniciado *************");
			
			//Inicializar clase SpringFactory de card
			pe.com.intralot.loto.card.lib.SpringFactory.init(1);
			pe.com.intralot.loto.card.lib.SpringFactory.getProperties().setMovilCompany("WEBCO");	  
			System.out.println("********** LOTTO-SALE SpringFactory de Card Iniciado *************");			
			
			//Establecer conexion ORACLE
			ConnectionFactory.setORACLE_DS("lottogameDS");
			//LoggerAPI.verifyLoggers("LOTTOSALE");
			//Iniciar Logger LOTTOSALE
			LoggerApi.startLogger(LoggerApi.LOTTOSALE);
			LoggerApi.Log.info("********** LOTTO-SALE Initialized web context");
			System.out.println("********** LOTTO-SALE Initialized web context");	
			
			pe.com.intralot.loto.util.LoggerApi.startLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI);
			Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI);
			Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("********** API LA POLLA Initialized web context");
			
			//Observer para api jackpot casino
			//JackpotCasinoObserver.createJackpotCasinoObservable(Integer.parseInt(ConnectionFactory.operationProperty("startSecondUpdateJackpot", Constants.contextSale).trim()), Integer.parseInt(ConnectionFactory.operationProperty("everySecondsUpdateJackpot", Constants.contextSale).trim()));
			//LoggerApi.Log.info("startSecondUpdateJackpot="+ConnectionFactory.operationProperty("startSecondUpdateJackpot", Constants.contextSale).trim());
			//LoggerApi.Log.info("everySecondsUpdateJackpot="+ConnectionFactory.operationProperty("everySecondsUpdateJackpot", Constants.contextSale).trim());
					
			System.out.println(Constants.ConstantesString.TOSTRING);
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
}