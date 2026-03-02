package pe.com.intralot.loto.utils;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador
 * @proyecto: lotto-mobile
 *
 */

import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.loader.JackpotCasinoObserver;
import pe.com.intralot.loto.sale.card.lib.LoggerAPI;
import pe.com.intralot.loto.sale.lib.LoggerApi;

public class ContextLoaderListener extends
		org.springframework.web.context.ContextLoaderListener {

	
	private static ApplicationContext context;

	
	public static Object getBean(String name){
		return context.getBean(name);
	}
	
	public static Object getBean(Class<?> name){
		Object bean = null;
		String beanName = ClassUtils.getShortName(name);
		if(!StringUtils.isEmpty(beanName) && context != null){
			bean = context.getBean(beanName);
		}		
		return bean;
	}

	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
		//JackpotCasinoObserver.finalized();
		context = null;
	}

	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
	
		//Inicializar clase SpringFactory de SaleCard
        pe.com.intralot.loto.sale.card.lib.SpringFactory.init();
        //LoggerApi.Log.info("********** SpringFactory de SaleCard Iniciado *************");
       
        //Inicializar clase SpringFactory de card
        pe.com.intralot.loto.card.lib.SpringFactory.init(1);
        pe.com.intralot.loto.card.lib.SpringFactory.getProperties().setMovilCompany("WEBCO");       
        //LoggerApi.Log.info("********** SpringFactory de Card Iniciado *************");            
       
        //Establecer conexion ORACLE
        ConnectionFactory.setORACLE_DS("lottomobileDS"); 
       
        
        //AGREGADO 02/09/13
        //Iniciar Logger LOTTOMOBILE
        LoggerApi.startLogger(LoggerApi.LOTTOMOBILE); 
        
        //Verificar e iniciar los loggers
        LoggerAPI.verifyLoggers();
        
        Logger.getLogger(LoggerApi.LOTTOMOBILE).info("Started SALECARD");
        Logger.getLogger(LoggerApi.LOTTOMOBILE).info("Started CARD"); 
       
        pe.com.intralot.loto.utils.LoggerApi.startLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI);
		Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI);
		Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("********** API LA POLLA Initialized web context");
		
		//Observer para api jackpot casino
		//JackpotCasinoObserver.createJackpotCasinoObservable(Integer.parseInt(ConnectionFactory.operationProperty("startSecondUpdateJackpot", Constantes.contextSale).trim()), Integer.parseInt(ConnectionFactory.operationProperty("everySecondsUpdateJackpot", Constantes.contextSale).trim()));
		//Logger.getLogger(LoggerApi.LOTTOMOBILE).info("startSecondUpdateJackpot="+ConnectionFactory.operationProperty("startSecondUpdateJackpot", Constantes.contextSale).trim());
		//Logger.getLogger(LoggerApi.LOTTOMOBILE).info("everySecondsUpdateJackpot="+ConnectionFactory.operationProperty("everySecondsUpdateJackpot", Constantes.contextSale).trim());
		
		System.out.println(Constantes.ConstantesString.TOSTRING);
	}

}