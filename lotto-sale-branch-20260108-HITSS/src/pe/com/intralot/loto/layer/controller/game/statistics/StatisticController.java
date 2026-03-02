package pe.com.intralot.loto.layer.controller.game.statistics;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pe.com.intralot.loto.api.model.GroupAPI;
import pe.com.intralot.loto.card.setup.MailingForSale;
import pe.com.intralot.loto.layer.model.bean.GameBean;
import pe.com.intralot.loto.layer.model.bean.GameMonthStatistics;
import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureAccountData;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetDataClient;
import pe.com.intralot.loto.layer.model.domain.ClientTicket;
import pe.com.intralot.loto.layer.model.domain.Draw;
import pe.com.intralot.loto.layer.model.domain.GameStats;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.layer.model.domain.TinkaProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.TinkaProcedureBetDataSubscribe;
import pe.com.intralot.loto.layer.model.domain.TinkaProcedureDrawData;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.service.client.bo.ClientTicketBo;
import pe.com.intralot.loto.layer.service.client.bo.ParameterBo;
import pe.com.intralot.loto.layer.service.client.bo.TicketSaleBo;
import pe.com.intralot.loto.layer.service.draw.bo.DrawBo;
import pe.com.intralot.loto.layer.service.game.statistic.bo.StatisticBo;
import pe.com.intralot.loto.layer.service.game.tinka.bo.TinkaBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.lib.DateAPI;
import pe.com.intralot.loto.lib.StringLib;
import pe.com.intralot.loto.model.Client;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.sale.card.dispatcher.BussinessSaleDispatcher;
import pe.com.intralot.loto.sale.card.dispatcher.BussinessSaleLotos5Dispatcher;
import pe.com.intralot.loto.sale.card.dispatcher.GameSaleDispatcher;
import pe.com.intralot.loto.sale.card.model.WEBMessage;
import pe.com.intralot.loto.sale.card.model.WEBTicket;
import pe.com.intralot.loto.sale.card.model.WEBTicketPay;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.AciertoscotejadorUtil;
import pe.com.intralot.loto.util.ClientUtils;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.QrUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * <p>
 * NOMBRE: TinkaController.java
 * <br></p>
 * <p>
 * FUNCION: Controlador juego Tinka
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 002   Cristian Cortez  25/06/2018  Límite montos mínimos y maximos de recarga parametrizado
 * 001   Cristian Cortez  06/10/2010  First comment
 * </pre>
 * <br></p>
 */

@Controller
public class StatisticController {

    @Autowired
    private StatisticBo statisticBo;

    @RequestMapping(value = "/estadistica")
    public ModelAndView gameStatistic(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	String marca = request.getParameter("marca");
		String destino = "";

		List<String> anios = null;
		
		try{
			int m = marca == null ? 0 : Integer.parseInt(marca);
			
			anios = statisticBo.consultarAnios(m);
			
			request.setAttribute("marca", marca);
			request.setAttribute("anios", anios);
			
			switch(m){
					case 41:
						destino = "game/estadistica/estadisticas-tinka";
						break;
					case 42:
						destino = "game/estadistica/estadisticas-kabala";
						break;					
					case 164:
						List<String> anios2 = statisticBo.consultarAniosGanadoresPorMes(164);
						request.setAttribute("anios2", anios2);
						destino = "game/estadistica/estadisticas-ganadiario";
						break;
					default:
						destino = "game/estadistica/error";
				}
			
		}catch (Exception e) {
			destino = "game/estadistica/error";
			LoggerApi.severe(e);
		}	
		return new ModelAndView(destino);
    }
    
    @RequestMapping(value = "/resultados_estadistica")
    public ModelAndView statisticResult(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	
    	String marca = request.getParameter("marca");
    	String fecha = request.getParameter("fecha");
		String opcion = request.getParameter("opcion");
		String destino = "";

		List<GameStats> lista1 = null;
		List<GameStats> lista2 = null;
		List<GameStats> lista3 = null;
		
		try{
			int m = marca == null ? 0 : Integer.parseInt(marca);
			int a = fecha == null ? 0 : Integer.parseInt(fecha);
			int op = opcion == null ? 0 : Integer.parseInt(opcion);
						
			request.setAttribute("anio", a);
			
			switch(m){
					case 41:
						if(op == 1){
							lista1 = statisticBo.consultarEstadisticas(m, a);
							if(lista1==null || lista1.size()<50){
								destino = "game/estadistica/error";
							}else{
								request.setAttribute("lista1", lista1.subList(0,17));
								request.setAttribute("lista2", lista1.subList(17,34));
								request.setAttribute("lista3", lista1.subList(34,50));
								destino = "game/estadistica/resultados-tinka-1";
							}
						}else if(op == 2){
							List<GameMonthStatistics> lista = statisticBo.consultarEstadisticasPorMes(m, 0);
							if(lista==null || lista.size()<12){
								destino = "game/estadistica/error";
							}else{
								request.setAttribute("lista1", lista.subList(0,4));
								request.setAttribute("lista2", lista.subList(4,8));
								request.setAttribute("lista3", lista.subList(8,12));
								destino = "game/estadistica/resultados-tinka-2";
							}
						}else{
							destino = "game/estadistica/error";
						}	
						break;
					case 42:
						if(op == 1){
							lista1 = statisticBo.consultarEstadisticas(m, a);
							if(lista1==null || lista1.size()<40){
								destino = "game/estadistica/error";
							}else{
								request.setAttribute("lista1", lista1.subList(0,14));
								request.setAttribute("lista2", lista1.subList(14,28));
								request.setAttribute("lista3", lista1.subList(28,40));
								destino = "game/estadistica/resultados-kabala-1";
							}
						}else if(op == 2){
							List<GameMonthStatistics> lista = statisticBo.consultarEstadisticasPorMes(m, 0);
							if(lista==null || lista.size()<12){
								destino = "game/estadistica/error";
							}else{
								request.setAttribute("lista1", lista.subList(0,4));
								request.setAttribute("lista2", lista.subList(4,8));
								request.setAttribute("lista3", lista.subList(8,12));
								destino = "game/estadistica/resultados-kabala-2";
							}
						}else{
							destino = "game/estadistica/error";
						}
						break;					
					case 164:
						if(op == 1){
							lista1 = statisticBo.consultarEstadisticas(m, a);
							if(lista1==null || lista1.size()<35){
								destino = "game/estadistica/error";
							}else{
								request.setAttribute("lista1", lista1.subList(0,12));
								request.setAttribute("lista2", lista1.subList(12,24));
								request.setAttribute("lista3", lista1.subList(24,35));
								destino = "game/estadistica/resultados-ganadiario-1";
							}	
						}else if(op == 2){
							List<GameMonthStatistics> lista = statisticBo.consultarEstadisticasPorMes(m, a);
							if(lista==null || lista.size()<12){
								destino = "game/estadistica/error";
							}else{
								request.setAttribute("lista1", lista.subList(0,4));
								request.setAttribute("lista2", lista.subList(4,8));
								request.setAttribute("lista3", lista.subList(8,12));
								destino = "game/estadistica/resultados-ganadiario-2";
							}
						}else{
							destino = "game/estadistica/error";
						}					
						break;
					default:
						destino = "game/estadistica/error";
				}
			
		}catch (Exception e) {
			destino = "game/estadistica/error";
			LoggerApi.severe(e);
		}	
		return new ModelAndView(destino);
    }

}
