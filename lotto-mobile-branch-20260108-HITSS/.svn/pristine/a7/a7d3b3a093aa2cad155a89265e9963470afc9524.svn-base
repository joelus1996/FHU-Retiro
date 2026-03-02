package pe.com.intralot.loto.layer.view.home;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador
 * @proyecto: lotto-mobile
 *
 */

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.mobile.device.wurfl.WurflDevice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.Constantes;


@Controller
public class AndroidController {

	//private static final Log logger = LogFactory.getLog(AndroidController.class);    

	@SuppressWarnings("rawtypes")
	@RequestMapping("/android")	
	public ModelAndView showMenu(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
	
		try {
			LoggerApi.Log.info("Ingresar al action: AndroidController.");
			
			WurflDevice device = (WurflDevice)DeviceUtils.getCurrentDevice(request);
			String userAgent = StringUtils.isNotEmpty(device.getUserAgent()) ? device.getUserAgent() : request.getHeader("User-Agent");
			String userAgentHeader = request.getHeader("User-Agent");
			LoggerApi.Log.info("userAgentHeader :: " + userAgentHeader);
			Map capabilities = device.getCapabilities();
			String resolution_width = MapUtils.getString(capabilities, "resolution_width");
			String resolution_height = MapUtils.getString(capabilities, "resolution_height");
			String physical_screen_width = MapUtils.getString(capabilities, "physical_screen_width");
			String physical_screen_height = MapUtils.getString(capabilities, "physical_screen_height");
			String mobile_browser = MapUtils.getString(capabilities, "mobile_browser");
			String mobile_pointing = MapUtils.getString(capabilities,"pointing_method");
			String device_os = MapUtils.getString(capabilities,"device_os");
			
			LoggerApi.Log.info("resolution_width :: " + resolution_width);
			LoggerApi.Log.info("resolution_height :: " + resolution_height);
			LoggerApi.Log.info("physical_screen_width :: " + physical_screen_width);
			LoggerApi.Log.info("physical_screen_height :: " + physical_screen_height);
			LoggerApi.Log.info("mobile_browser :: " + mobile_browser);
			LoggerApi.Log.info("mobile_pointing :: " + mobile_pointing);
			LoggerApi.Log.info("device_os :: " + device_os);
			LoggerApi.Log.info("=========================================");
						
			String phoneNumber = StringUtils.EMPTY;

			
		if(StringUtils.isEmpty(phoneNumber)){
				/*
				 * SE OBTIENE EL NUMERO TELEFONICO DEL DISPOSITIVO MEDIANTE EL ID DEL HEADER
				 * DE ACUERDO AL EQUIPO PUEDE ESTAR EN MIN O MAYUS
				 */
			
				String[] header = StringUtils.split("x-up-calling-line-id, HTTP_X_UP_CALLING_LINE_ID, X-TLF-MSISDN");
            							
				for(int i = 0; i < header.length; i++){
					String value = request.getHeader(header[i]);
					if(StringUtils.isNotEmpty(value)){
						phoneNumber = value;
						break;
					}
				}
				LoggerApi.Log.info("phoneNumber : [" + phoneNumber + "]");
			}
			
			
			/*
			 * AGREGAR EN SESSION EL TIPO DE EQUIPO QUE SE HA CONECTADO
			 * QWERTY O TOUCHCREEN
			 */
			//clickwheel
			//touchscreen
			HttpSession session = request.getSession();	
			
			if(StringUtils.isNotEmpty(mobile_pointing)) {
				session.setAttribute("mobile_pointing", mobile_pointing);
			 }else {
				session.setAttribute("mobile_pointing",Constantes.MOBILE_TOUCHSCREEN);
			}
			/*
			 * AGREGAR EN SESSION SI EL SISTEMA OPERATIVO ES ANDROID 
			 */
			//is_android==true
			//is_android==false

			if(userAgentHeader.toLowerCase().indexOf("android")>=0) {
				session.setAttribute("is_android", "true");
			 }else {
				session.setAttribute("is_android", "false");
			}
			
			return new ModelAndView("home/interface-android");
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("home/interface-android");
		} finally{
			//LoggerApi.Log.info("Salir al metodo: HomeAndroid. Estado : Satisfactorio");
			//LoggerApi.Log.info("Salir al action: AndroidController.");
			
		}
		}
						
	}
	