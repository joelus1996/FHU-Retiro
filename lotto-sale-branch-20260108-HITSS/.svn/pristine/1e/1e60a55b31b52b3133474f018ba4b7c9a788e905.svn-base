package pe.com.intralot.loto.layer.controller.client;

import java.io.PrintWriter;
import java.security.Security;
import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetDetail;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicketRetail;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetRetailTeApuestoGrecia;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.service.client.bo.TicketRetailBo;
import pe.com.intralot.loto.layer.service.client.bo.TicketSaleBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.lib.Dbms;
import pe.com.intralot.loto.lib.MailLib;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.sale.card.dispatcher.GameSaleDispatcher;
import pe.com.intralot.loto.sale.card.model.WEBTicketPrePay;
import pe.com.intralot.loto.sale.client.dispatcher.SalesDispatcher;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.QrUtil;

@Controller
public class TicketSaleController {

    @Autowired
    private TicketSaleBo ticketSaleBo;
    @Autowired
    private ClientSaleBo clientSaleBo;
    @Autowired
    private QrUtil qrUtil;
    
    @Autowired
    private TicketRetailBo ticketRetailBo;
    
    @PostConstruct
    public void init() {
        Security.addProvider(new BouncyCastleProvider());
    }

    @RequestMapping(value = "/ticket_vista_previa")
    public ModelAndView findClientCoupon(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        int SessionId = 0;
        int clientId = 0;
        int gameId = 0;
        
        String gameName="";
        
        Long ticketId = null;
        String email = null;
        String emailStat = null;
        StringBuffer htmlText = new StringBuffer();
        try {
            HttpSession session = request.getSession();
            if (session != null)
                if (session.getAttribute(Constants.USR_SESION) != null) {
                	UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                	if (userBean!=null) { 
                        SessionId = userBean.getpSessionid();
                        clientId = userBean.getpClientid();
                         
                        if (request.getParameter("gameId") != null)
                            gameId = Integer.parseInt(request.getParameter("gameId"));

                        if (clientId==0) { 
                            request.setAttribute(Constants.ALERT_MSG, "El proceso no se ha completado. Vuelva a ingresar a su cuenta.");
                            return new ModelAndView("client/print_coupon");
                        }
                        ticketId = Long.parseLong(request.getParameter("parameterId"));
                     
                     LoggerApi.Log.info("ticket_vista_previa: cid=" + clientId + " gameId=" + gameId + " ticketId=" + ticketId);
                   	 
                   	 TicketProcedureGetClientTicket ticketProcedureGetClientTicket = null;
                   	 
                        if (ticketId != null)
                            ticketProcedureGetClientTicket = ticketSaleBo.findByClientTicket(clientId, gameId, ticketId);
                        if (ticketProcedureGetClientTicket != null)
                        	gameName=ticketProcedureGetClientTicket.getGameName();
                        if (ticketProcedureGetClientTicket != null)
                            if (gameId == Game.TEAPUESTO)
                                htmlText = ticketSaleBo.findCouponByClientTicketTeApuesto(ticketProcedureGetClientTicket, 0);
                            else if (gameId == Game.FECHAZALOTOS)
                                htmlText = ticketSaleBo.findCouponByClientTicketFechaza(ticketProcedureGetClientTicket, 0);
                            else if (gameId == Game.KINELO)
                                htmlText = ticketSaleBo.findCouponByClientTicketKinelo(ticketProcedureGetClientTicket, 0);
                            else if (gameId == Game.POLLAYPOLLON)
                                htmlText = ticketSaleBo.findCouponByClientTicketPollayPollon(ticketProcedureGetClientTicket);
                            else if (gameId == Game.INSTANT)
                                htmlText = ticketSaleBo.findCouponClientTicketRapitinkas(ticketProcedureGetClientTicket, 0);
                            else if (gameId == Game.ELREVENTON)
                                htmlText = ticketSaleBo.findCouponClientTicketElReventon(ticketProcedureGetClientTicket, 0);
                            else
                                htmlText = ticketSaleBo.findCouponByClientTicket(ticketProcedureGetClientTicket, 0);
                        ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(SessionId, clientId);
                        if (clientProcedureGetClient != null) {
                            if (clientProcedureGetClient.getMail() != null)
                                email = clientProcedureGetClient.getMail();
                            // email2 = clientProcedureGetClient.getMail2();
                            if (clientProcedureGetClient.getMailstatus() != null)
                                emailStat = clientProcedureGetClient.getMailstatus();
                        }
                        // email2Stat = clientProcedureGetClient.getMail2status();
                        // ticketProcedureGetClientTicket.getCtToDrawDate();
                        request.setAttribute("gameid", gameId);
                        request.setAttribute("gameName", gameName);
                        request.setAttribute("gticket", ticketId);
                        request.setAttribute("email", email);
                        // request.setAttribute("email2", email2);
                        request.setAttribute("emailStat", emailStat);
                        // request.setAttribute("email2Stat", email2Stat);
                        // model.put("clientsale",clientSaleBean);
                        if (ticketProcedureGetClientTicket != null)
                            request.setAttribute("ctTwDefinePrize", ticketProcedureGetClientTicket.getCtTwDefinePrize());
                        if (htmlText != null){
                        	//Obtener QR @jmoran 2019-05-29
                            String htmlQr = qrUtil.generateQR(ticketProcedureGetClientTicket, htmlText.toString());
                            //request.setAttribute("htmlText", htmlText.toString()); 
                            request.setAttribute("htmlText", htmlQr.toString());
                        }                        

                	}
                }
            return new ModelAndView("client/print_coupon");
        } catch (NumberFormatException e) {
            request.setAttribute(Constants.ALERT_MSG, "La transaccion no se ha completado. Ingrese nuevamente a su cuenta.");
            return new ModelAndView("client/print_coupon");
        } catch (Exception e) {
            String id = LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "La transaccion no se ha completado. Vuelva a intentarlo en unos minutos." + id);
            return new ModelAndView("client/print_coupon");
        } finally {
            LoggerApi.Log.info("cid=" + clientId + " gameId=" + gameId + " ticketId=" + ticketId + " email=" + email + " emailStat=" + emailStat);
        }
    }
    
    @RequestMapping(value = "/ticket_vista_previa_games")
    public ModelAndView findClientCouponWebRetail(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        int SessionId = 0;
        int clientId = 0;
        int gameId = 0;
        
        String gameName="";
        
        Long ticketId = null;
        String ticketId2  = null;
        String email = null;
        String emailStat = null;
        StringBuffer htmlText = new StringBuffer();
        try {
            HttpSession session = request.getSession();
            if (session != null)
                if (session.getAttribute(Constants.USR_SESION) != null) {
                	UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                	if (userBean!=null) { 
                        SessionId = userBean.getpSessionid();
                        clientId = userBean.getpClientid();
                         
                        if (request.getParameter("gameId") != null)
                            gameId = Integer.parseInt(request.getParameter("gameId"));

                        if (clientId==0) { 
                            request.setAttribute(Constants.ALERT_MSG, "El proceso no se ha completado. Vuelva a ingresar a su cuenta.");
                            return new ModelAndView("client/print_coupon");
                        }
                        
                        LoggerApi.Log.info("cid=" + clientId + " SessionId=" + SessionId + " gameId=" + gameId + " ticketId=" + ticketId);
                        
                        Boolean ticket_retail = request.getParameter("canalVenta") != null && !request.getParameter("canalVenta").equals("Web") ? true : false;
                        LoggerApi.Log.info("canalVenta " + request.getParameter("canalVenta"));
                        //te apuesto grecia 
                        
                        if (ticket_retail) {
                           	 ticketId2 = request.getParameter("parameterId");
                           	  
                        	 TicketProcedureGetClientTicketRetail ticketProcedureGetClientTicketRetail = null;
                        	 
                        	 ClientProcedureGetDetail clientDetail = ticketSaleBo.findClientDetail(clientId);
                        	 
                             if (ticketId2 != null) {
                            	 ticketProcedureGetClientTicketRetail = ticketRetailBo.findByClientDetailTicketRetail(clientId, gameId, ticketId2);
                             }

                             if (ticketProcedureGetClientTicketRetail != null) {
                            	 if(gameId == Game.GANAGOL) {
                            	     LoggerApi.Log.info("GANAGOL=> clientId" + clientId + " SessionId=" + SessionId + " gameId=" + gameId + " ticketId=" + ticketId);
                            		 htmlText = ticketSaleBo.findCouponByTicketRetailGanagol(ticketProcedureGetClientTicketRetail, 0,clientDetail);
                            	 }else {
                            		 htmlText = ticketSaleBo.findCouponByClientTicketRetail(ticketProcedureGetClientTicketRetail, 0,clientDetail);
                            	 }    
                             }

                             ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(SessionId, clientId);
                             if (clientProcedureGetClient != null) {
                                 if (clientProcedureGetClient.getMail() != null)
                                     email = clientProcedureGetClient.getMail();
                                 // email2 = clientProcedureGetClient.getMail2();
                                 if (clientProcedureGetClient.getMailstatus() != null)
                                     emailStat = clientProcedureGetClient.getMailstatus();
                             }
                             // email2Stat = clientProcedureGetClient.getMail2status();
                             // ticketProcedureGetClientTicket.getCtToDrawDate();
                             request.setAttribute("gameid", gameId);
                             request.setAttribute("gameName", gameName);
                             request.setAttribute("gticket", ticketId);
                             request.setAttribute("email", email);
                             // request.setAttribute("email2", email2);
                             request.setAttribute("emailStat", emailStat);
                             // request.setAttribute("email2Stat", email2Stat);
                             // model.put("clientsale",clientSaleBean);
                             ///if (ticketProcedureGetClientTicketRetail != null)
                                // request.setAttribute("ctTwDefinePrize", ticketProcedureGetClientTicketRetail.getCtTwDefinePrize());
                             if (htmlText != null){
                             	//Obtener QR @jmoran 2019-05-29
                                 String htmlQr = qrUtil.generateQR_Retail(ticketProcedureGetClientTicketRetail, htmlText.toString());
                                 //request.setAttribute("htmlText", htmlText.toString()); 
                                 request.setAttribute("htmlText", htmlQr.toString());
                             }
                        	
                        } else {
 
                           	  ticketId = Long.parseLong(request.getParameter("parameterId"));
                        	 
                        	 TicketProcedureGetClientTicket ticketProcedureGetClientTicket = null;
                        	 
                             if (ticketId != null)
                                 ticketProcedureGetClientTicket = ticketSaleBo.findByClientTicket(clientId, gameId, ticketId);
                             if (ticketProcedureGetClientTicket != null)
                             	gameName=ticketProcedureGetClientTicket.getGameName();
                             if (ticketProcedureGetClientTicket != null)
                                 if (gameId == Game.TEAPUESTO)
                                     htmlText = ticketSaleBo.findCouponByClientTicketTeApuesto(ticketProcedureGetClientTicket, 0);
                                 else if (gameId == Game.FECHAZALOTOS)
                                     htmlText = ticketSaleBo.findCouponByClientTicketFechaza(ticketProcedureGetClientTicket, 0);
                                 else if (gameId == Game.KINELO)
                                     htmlText = ticketSaleBo.findCouponByClientTicketKinelo(ticketProcedureGetClientTicket, 0);
                                 else if (gameId == Game.POLLAYPOLLON)
                                     htmlText = ticketSaleBo.findCouponByClientTicketPollayPollon(ticketProcedureGetClientTicket);
                                 else if (gameId == Game.INSTANT)
                                     htmlText = ticketSaleBo.findCouponClientTicketRapitinkas(ticketProcedureGetClientTicket, 0);
                                 else if (gameId == Game.ELREVENTON)
                                     htmlText = ticketSaleBo.findCouponClientTicketElReventon(ticketProcedureGetClientTicket, 0);
                                 else
                                     htmlText = ticketSaleBo.findCouponByClientTicket(ticketProcedureGetClientTicket, 0);
                             ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(SessionId, clientId);
                             if (clientProcedureGetClient != null) {
                                 if (clientProcedureGetClient.getMail() != null)
                                     email = clientProcedureGetClient.getMail();
                                 // email2 = clientProcedureGetClient.getMail2();
                                 if (clientProcedureGetClient.getMailstatus() != null)
                                     emailStat = clientProcedureGetClient.getMailstatus();
                             }
                             // email2Stat = clientProcedureGetClient.getMail2status();
                             // ticketProcedureGetClientTicket.getCtToDrawDate();
                             request.setAttribute("gameid", gameId);
                             request.setAttribute("gameName", gameName);
                             request.setAttribute("gticket", ticketId);
                             request.setAttribute("email", email);
                             // request.setAttribute("email2", email2);
                             request.setAttribute("emailStat", emailStat);
                             // request.setAttribute("email2Stat", email2Stat);
                             // model.put("clientsale",clientSaleBean);
                             if (ticketProcedureGetClientTicket != null)
                                 request.setAttribute("ctTwDefinePrize", ticketProcedureGetClientTicket.getCtTwDefinePrize());
                             if (htmlText != null){
                             	//Obtener QR @jmoran 2019-05-29
                                 String htmlQr = qrUtil.generateQR(ticketProcedureGetClientTicket, htmlText.toString());
                                 //request.setAttribute("htmlText", htmlText.toString()); 
                                 request.setAttribute("htmlText", htmlQr.toString());
                             }
                        }                    
                	}
                }
                return new ModelAndView("client/print_coupon");
        } catch (NumberFormatException e) {
            request.setAttribute(Constants.ALERT_MSG, "La transaccion no se ha completado. Ingrese nuevamente a su cuenta.");
            return new ModelAndView("client/print_coupon");
        } catch (Exception e) {
            String id = LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "La transaccion no se ha completado. Vuelva a intentarlo en unos minutos." + id);
            return new ModelAndView("client/print_coupon");
        } finally {
            LoggerApi.Log.info("cid=" + clientId + " gameId=" + gameId + " ticketId=" + ticketId + " email=" + email + " emailStat=" + emailStat);
        }
    }
    
    
    @RequestMapping(value = "/ticket_vista_previa_ta_iflex")
    public ModelAndView findClientCouponWebRetailIflex(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	LoggerApi.Log.info("start ------------ ticket_vista_previa_ta_iflex");
        int SessionId = 0;
        int clientId = 0;
        int gameId = 0;
        
        String gameName="";
        
        String ticketId2  = null;
        String email = null;
        String emailStat = null;
        StringBuffer htmlText = new StringBuffer();
        
        int p_programa = 0;
        int p_cpn = 0;
        try {
            HttpSession session = request.getSession();
            if (session != null)
                if (session.getAttribute(Constants.USR_SESION) != null) {
                	UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                	if (userBean!=null) { 
                        SessionId = userBean.getpSessionid();
                        clientId = userBean.getpClientid();
                         
                        if (request.getParameter("gameId") != null)
                            gameId = Integer.parseInt(request.getParameter("gameId"));

                        if (clientId==0) { 
                            request.setAttribute(Constants.ALERT_MSG, "El proceso no se ha completado. Vuelva a ingresar a su cuenta.");
                            return new ModelAndView("client/print_coupon");
                        }
                        
                        LoggerApi.Log.info("cid=" + clientId + " SessionId=" + SessionId + " gameId=" + gameId + " ticketId=" + ticketId2);
                        
                        Boolean ticket_retail = request.getParameter("canalVenta") != null && !request.getParameter("canalVenta").equals("Web") ? true : false;
                        LoggerApi.Log.info("canalVenta " + request.getParameter("canalVenta"));
                        //te apuesto grecia 
                         p_programa = Integer.parseInt(request.getParameter("programa"));
                         p_cpn = Integer.parseInt(request.getParameter("cpn"));
                        
                        if (ticket_retail) {
                           	 ticketId2 = request.getParameter("parameterId");
                           	  
                        	 TicketProcedureGetClientTicketRetail ticketProcedureGetClientTicketRetail = null;
                        	 
                        	 List<TicketProcedureGetRetailTeApuestoGrecia> listaDetalleTicketTeApuestoGrecia = ticketSaleBo.findByClientTickeTeApuestoGrecia(p_programa, p_cpn);
                        	 
                             if (ticketId2 != null) {
                            	 ticketProcedureGetClientTicketRetail = ticketRetailBo.findByClientDetailTicketRetail(clientId, gameId, ticketId2);
                             }

                             if(ticketProcedureGetClientTicketRetail != null) {
                            	 
                            	if (gameId == Game.TEAPUESTO ) {
                              	     LoggerApi.Log.info("TE APUESTO GRECIA=> clientId" + clientId + " SessionId=" + SessionId + " gameId=" + gameId + " ticketId=" + ticketId2);
                            		 htmlText = ticketSaleBo.findCouponByClientTicketTeApuestoGrecia(listaDetalleTicketTeApuestoGrecia,ticketProcedureGetClientTicketRetail, 0 );
                            	}  
                             }
                             ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(SessionId, clientId);
                             if (clientProcedureGetClient != null) {
                                 if (clientProcedureGetClient.getMail() != null)
                                     email = clientProcedureGetClient.getMail();
                                 // email2 = clientProcedureGetClient.getMail2();
                                 if (clientProcedureGetClient.getMailstatus() != null)
                                     emailStat = clientProcedureGetClient.getMailstatus();
                             }
                             // email2Stat = clientProcedureGetClient.getMail2status();
                             // ticketProcedureGetClientTicket.getCtToDrawDate();
                             request.setAttribute("gameid", gameId);
                             request.setAttribute("gameName", gameName);
                             request.setAttribute("gticket", ticketId2);
                             request.setAttribute("email", email);
                             // request.setAttribute("email2", email2);
                             request.setAttribute("emailStat", emailStat);
                             // request.setAttribute("email2Stat", email2Stat);
                             // model.put("clientsale",clientSaleBean);
                             ///if (ticketProcedureGetClientTicketRetail != null)
                                // request.setAttribute("ctTwDefinePrize", ticketProcedureGetClientTicketRetail.getCtTwDefinePrize());
                             if (htmlText != null){
                             	//Obtener QR @jmoran 2019-05-29
                                 String htmlQr = qrUtil.generateQR_Retail(ticketProcedureGetClientTicketRetail, htmlText.toString());
                                 //request.setAttribute("htmlText", htmlText.toString()); 
                                 request.setAttribute("htmlText", htmlQr.toString());
                             }
                        	
                        }                  
                	}
                }
                return new ModelAndView("client/print_couponretail_iflex");

        } catch (NumberFormatException e) {
            request.setAttribute(Constants.ALERT_MSG, "La transaccion no se ha completado. Ingrese nuevamente a su cuenta.");
            return new ModelAndView("client/print_coupon");
        } catch (Exception e) {
            String id = LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "La transaccion no se ha completado. Vuelva a intentarlo en unos minutos." + id);
            return new ModelAndView("client/print_coupon");
        } finally {
            LoggerApi.Log.info("cid=" + clientId + " gameId=" + gameId + " ticketId=" + ticketId2 + " email=" + email + " emailStat=" + emailStat);
        }
    }
    
    @RequestMapping(value = "/ticket_vista_previa_pp")
    public ModelAndView findClientCouponPP(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	 int SessionId = 0;
         int clientId = 0;
         int gameId = 0;
         String gameName="";
         Long ticketId = null;
         String email = null;
         String emailStat = null;
         StringBuffer htmlText = new StringBuffer();
         try {
             HttpSession session = request.getSession();
             if (session != null)
                 if (session.getAttribute(Constants.USR_SESION) != null) {
                 	UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                 	if (userBean!=null) { 
                         SessionId = userBean.getpSessionid();
                         clientId = userBean.getpClientid();
                          
                         if (request.getParameter("gameId") != null)
                             gameId = Integer.parseInt(request.getParameter("gameId"));
                         if (request.getParameter("parameterId") != null)
                             ticketId = Long.parseLong(request.getParameter("parameterId"));
                         LoggerApi.Log.info("cid=" + clientId + " SessionId=" + SessionId + " gameId=" + gameId + " ticketId=" + ticketId);
                         
                         if (clientId==0) { 
                             request.setAttribute(Constants.ALERT_MSG, "Vuelva a intentarlo ");
                             return new ModelAndView("client/print_coupon_pp");
                         }
                         
                         TicketProcedureGetClientTicket ticketProcedureGetClientTicket = null;
                         if (ticketId != null)
                             ticketProcedureGetClientTicket = ticketSaleBo.findByClientTicket(clientId, gameId, ticketId);
                         if (ticketProcedureGetClientTicket != null)
                         	gameName=ticketProcedureGetClientTicket.getGameName();
                         if (ticketProcedureGetClientTicket != null)
                             if (gameId == Game.TEAPUESTO)
                                 htmlText = ticketSaleBo.findCouponByClientTicketTeApuesto(ticketProcedureGetClientTicket, 0);
                             else if (gameId == Game.FECHAZALOTOS)
                                 htmlText = ticketSaleBo.findCouponByClientTicketFechaza(ticketProcedureGetClientTicket, 0);
                             else if (gameId == Game.KINELO)
                                 htmlText = ticketSaleBo.findCouponByClientTicketKinelo(ticketProcedureGetClientTicket, 0);
                             else if (gameId == Game.POLLAYPOLLON)
                                 htmlText = ticketSaleBo.findCouponByClientTicketPollayPollon(ticketProcedureGetClientTicket);
                             else if (gameId == Game.INSTANT)
                                 htmlText = ticketSaleBo.findCouponClientTicketRapitinkas(ticketProcedureGetClientTicket, 0);
                             else if (gameId == Game.ELREVENTON)
                                 htmlText = ticketSaleBo.findCouponClientTicketElReventon(ticketProcedureGetClientTicket, 0);
                             else
                                 htmlText = ticketSaleBo.findCouponByClientTicket(ticketProcedureGetClientTicket, 0);
                         ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(SessionId, clientId);
                         if (clientProcedureGetClient != null) {
                             if (clientProcedureGetClient.getMail() != null)
                                 email = clientProcedureGetClient.getMail();
                             if (clientProcedureGetClient.getMailstatus() != null)
                                 emailStat = clientProcedureGetClient.getMailstatus();
                         }
                         request.setAttribute("gameid", gameId);
                         request.setAttribute("gameName", gameName);
                         request.setAttribute("gticket", ticketId);
                         request.setAttribute("email", email);
                         request.setAttribute("emailStat", emailStat);
                         if (ticketProcedureGetClientTicket != null)
                             request.setAttribute("ctTwDefinePrize", ticketProcedureGetClientTicket.getCtTwDefinePrize());
                         if (htmlText != null){
//                             String htmlQr = qrUtil.generateQR(ticketProcedureGetClientTicket, htmlText.toString());
//                             request.setAttribute("htmlText", htmlQr.toString());
                             request.setAttribute("htmlText", htmlText.toString());
                         }
                 	}
                 }
             return new ModelAndView("client/print_coupon_pp");
         } catch (NumberFormatException e) {
             request.setAttribute(Constants.ALERT_MSG, "Vuelva a intentarlo ");
             return new ModelAndView("client/print_coupon_pp");
         } catch (Exception e) {
             String id = LoggerApi.severe(e);
             request.setAttribute(Constants.ALERT_MSG, "Vuelva a intentarlo " + id);
             return new ModelAndView("client/print_coupon_pp");
         } finally {
             LoggerApi.Log.info("cid=" + clientId + " gameId=" + gameId + " ticketId=" + ticketId + " email=" + email + " emailStat=" + emailStat);
         }
    }

    @RequestMapping(value = "/ticket_vista_previa_Award")
    public ModelAndView findClientCouponAward(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        int SessionId = 0;
        int clientId = 0;
        Integer gameId = 0;
        Long ticketId = 0L;
        String[] cadena;
        String apGratis = "";
        String money = "";
        String apMtadPrmio = "";
        String premio = "";
        String freeAmount = "0";
        // String printPay="";
        Long consecutive = 0L;
        String email = null;
        String date = "";
        String emailStat = null;
        String maxPrizePaid = String.valueOf(ConnectionFactory.operationProperty("maxTerminalPrizePaid", Constants.contextCardWeb)).toString();
        StringBuffer htmlText = new StringBuffer();
        DecimalFormat df = new DecimalFormat("###,###,##0.00");
        try {
            HttpSession session = request.getSession();
            if (session.getAttribute(Constants.USR_SESION) != null) {
                SessionId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid();
                clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
            }
            if (request.getParameter("gameId") != null)
                gameId = Integer.parseInt(request.getParameter("gameId").toString());
                ticketId = Long.parseLong(request.getParameter("parameterId").toString());
            if (request.getParameter("prizesSet") != null) {
                premio = request.getParameter("prizesSet");
                cadena = premio.split("@");
                money = cadena[0];
                apGratis = cadena[1];
                apMtadPrmio = cadena[2];
            }
            /*
             * apGratis = request.getParameter("betFree"); money = request.getParameter("money");
             */
            LoggerApi.Log.info("cid="+clientId+"-"+ticketId+" gameId="+gameId+" money="+money+
            		" apGratis="+apGratis+" apMtadPrmio="+apMtadPrmio+" freeAmount="+freeAmount+" maxPrizePaid="+maxPrizePaid);        	
            if (clientId==0 || ticketId==0 ) {
                request.setAttribute(Constants.ALERT_MSG, "La transaccion no se ha completado. Vuelva a ingresar a su cuenta.");
                return new ModelAndView("client/print_coupon_award");
            }
           
            boolean notVerified = false;
            
            if (gameId==Game.TINKA || gameId==Game.KABALA || gameId==Game.GANADIARIO ) {
                WEBTicketPrePay webTicketPrePay = GameSaleDispatcher.setPrepayTicketWinnerByWebTransactionNewLotos5(gameId, String.valueOf(clientId), String.valueOf(ticketId) );
                if (webTicketPrePay!=null) {
                    money = String.valueOf( webTicketPrePay.getPrizeAmount() );
                    apGratis = String.valueOf( webTicketPrePay.getFree() );
                    apMtadPrmio = String.valueOf( webTicketPrePay.getOption2x1()/2 );
                    freeAmount = String.valueOf( webTicketPrePay.getFreeAmount() );
                    consecutive = webTicketPrePay.getRemDraw();
                } else {
                    /* request.setAttribute(Constants.ALERT_MSG, "Aun no se han verificado los premios");
                    return new ModelAndView("client/print_coupon_award");
                    */
                	notVerified = true;
                }
            }

            LoggerApi.Log.info("cid="+clientId+"-"+ticketId+" gameId="+gameId+" money="+money+
            		" apGratis="+apGratis+" apMtadPrmio="+apMtadPrmio+" freeAmount="+freeAmount+" maxPrizePaid="+maxPrizePaid+" consecutive="+consecutive+" notVerified="+notVerified);  
            
            TicketProcedureGetClientTicket ticketProcedureGetClientTicket = ticketSaleBo.findByClientTicket(clientId, gameId, ticketId);
            
            if (notVerified==true) {
                money = String.valueOf( ticketProcedureGetClientTicket.getCtTwPrizeAmount() );
                apGratis = String.valueOf( ticketProcedureGetClientTicket.getTwTwfreeColumns().intValue());
                apMtadPrmio = String.valueOf( ticketProcedureGetClientTicket.getTw2x1Columns().intValue());
                LoggerApi.Log.info("cid="+clientId+"-"+ticketId+" gameId="+gameId+" money="+money+
                		" apGratis="+apGratis+" apMtadPrmio="+apMtadPrmio+" freeAmount="+freeAmount+" consecutive="+consecutive+" notVerified="+notVerified);  
            }
        	
        	Dbms rs = null;
        	try {
        		rs = new Dbms();
            	rs.setSql("select CL_LOTOS_LOCKED from lotocard.client where client_id = ? and CL_LOTOS_LOCKED = 1");
            	rs.setInt(1, clientId);
            	rs.executeQuery();
            	String res = "";
            	if (rs.next() && Integer.parseInt(apGratis) > 0) {
            		res = rs.getString(1);
            		LoggerApi.Log.info("lotosLock res = "+res);
                    request.setAttribute(Constants.ALERT_MSG, "En este momento estamos presentando problemas. Por favor intenta nuevamente más tarde.");
                    return new ModelAndView("client/print_coupon");
            	} else {
            		LoggerApi.Log.info("lotosLock clientId = "+clientId);
            	}
        	} catch (Exception e) {;} finally { try { if (rs!=null) {rs.close();} } catch (Exception ex) {;} }
        	
            if (ticketProcedureGetClientTicket != null) {
                ticketProcedureGetClientTicket.getCtTicketNumber();
                LoggerApi.Log.info("ticketProcedureGetClientTicket.getCtTicketNumber()=" + ticketProcedureGetClientTicket.getCtTicketNumber());
                if (gameId == Game.TEAPUESTO)
                    htmlText = ticketSaleBo.findCouponByClientTicketTeApuesto(ticketProcedureGetClientTicket, 1);
                else if (gameId == Game.FECHAZALOTOS)
                    htmlText = ticketSaleBo.findCouponByClientTicketFechaza(ticketProcedureGetClientTicket, 1);
                else if (gameId == Game.KINELO)
                    htmlText = ticketSaleBo.findCouponByClientTicketKinelo(ticketProcedureGetClientTicket, 1);
                else if (gameId == Game.POLLAYPOLLON)
                    htmlText = ticketSaleBo.findCouponByClientTicketPollayPollon(ticketProcedureGetClientTicket);
                else if (gameId == Game.INSTANT)
                    htmlText = ticketSaleBo.findCouponClientTicketRapitinkas(ticketProcedureGetClientTicket, 1);
                else if (gameId == Game.CLICYGANA)
                    htmlText = ticketSaleBo.findCouponClientTicketClicyGana(ticketProcedureGetClientTicket);
                else if (gameId != null && gameId.equals(717))
                    htmlText = ticketSaleBo.findCouponClientTicketDeportesVirtuales(ticketProcedureGetClientTicket);
                else if (gameId == Game.ELREVENTON)
                    htmlText = ticketSaleBo.findCouponClientTicketElReventon(ticketProcedureGetClientTicket, 1);
                else
                    htmlText = ticketSaleBo.findCouponByClientTicket(ticketProcedureGetClientTicket, 1);
                
                //Obtener QR @jmoran 2019-05-29
                String htmlQr = qrUtil.generateQR(ticketProcedureGetClientTicket, htmlText.toString());
                
                ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(SessionId, clientId);
                if (clientProcedureGetClient.getMail() != null)
                    email = clientProcedureGetClient.getMail();
                // email2 = clientProcedureGetClient.getMail2();
                if (clientProcedureGetClient.getMailstatus() != null)
                    emailStat = clientProcedureGetClient.getMailstatus();
                // email2Stat = clientProcedureGetClient.getMail2status();
                if (ticketProcedureGetClientTicket.getCtFromDrawDate() != null)
                    date = ticketProcedureGetClientTicket.getCtFromDrawDate();
                ticketProcedureGetClientTicket.getCtToDrawDate();
                request.setAttribute("gameid", gameId);
                session.setAttribute("gticket", ticketId);
                request.setAttribute("email", email);
                session.setAttribute("apGratis", apGratis);
                session.setAttribute("dmoney", Double.parseDouble(money));
                session.setAttribute("money", df.format(Double.parseDouble(money)));
                session.setAttribute("apMtadPrmio", apMtadPrmio);
                session.setAttribute("freeAmount", df.format(Double.parseDouble(freeAmount)));
                session.setAttribute("consecutive", consecutive);
                session.setAttribute("date", date);
                session.setAttribute("ticketNumber", ticketProcedureGetClientTicket.getCtTicketNumber());
                session.setAttribute("saleType", ticketProcedureGetClientTicket.getCtSaleType());
                session.setAttribute("prizeAmount", ticketProcedureGetClientTicket.getCtTwPrizeAmount());
                // request.setAttribute("email2", email2);
                request.setAttribute("ctTwDefinePrize", ticketProcedureGetClientTicket.getCtTwDefinePrize());
                request.setAttribute("emailStat", emailStat);
                session.setAttribute("DrawId", ticketProcedureGetClientTicket.getCtDrawId());
                request.setAttribute("gameName", ticketProcedureGetClientTicket.getGameName());
                session.setAttribute("parameterId", ticketId);
                session.setAttribute("dmaxMoney", Double.parseDouble(maxPrizePaid));
                session.setAttribute("maxMoney", df.format(Double.parseDouble(maxPrizePaid)));
                // request.setAttribute("email2Stat", email2Stat);
                // model.put("clientsale",clientSaleBean);
                /*
                if (htmlText != null)
                    request.setAttribute("htmlText", htmlText.toString());
                */
                if (htmlQr != null)
                    request.setAttribute("htmlText", htmlQr.toString());
            }
            return new ModelAndView("client/print_coupon_award");
        } catch (Exception e) {
            String id = LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "La transaccion no se ha completado. Vuelva a intentarlo en unos minutos." + id);
            return new ModelAndView("client/print_coupon_award");
        } finally {
            LoggerApi.Log.info("cid="+clientId+"-"+ticketId+" gameId="+gameId+" email=" + email + " emailStat=" + emailStat + " apGratis=" + apGratis);
        }
    }

    @RequestMapping(value = "/collect_prize")
    public ModelAndView findCollectPrize(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        try {
            return new ModelAndView("client/collect_prize");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("client/collect_prize");
        } finally {
        }
    }

    @RequestMapping(value = "/generate_ticket_clicygana.html")
    public void findGenerateTicketCyG(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
        try {
            PrintWriter out = null;
            out = response.getWriter();
            String clientId = String.valueOf(((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid());
            Double amount = Double.parseDouble(request.getParameter("amount").trim());
            String ip = request.getRemoteAddr().toString();
            String message = SalesDispatcher.getPrizesClicYGanaGame(clientId, ip, amount);
            out.print(message);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        }
    }

    @RequestMapping(value = "/generate_ticket_deportesvirtuales.html")
    public void findGenerateTicketDV(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
        try {
            PrintWriter out = null;
            out = response.getWriter();
            String clientId = String.valueOf(((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid());
            Double amount = Double.parseDouble(request.getParameter("amount").trim());
            String ip = request.getRemoteAddr().toString();
            String message = SalesDispatcher.getPrizesDeportesVirtualesGame(clientId, ip, amount);
            out.print(message);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        }
    }

    @RequestMapping(value = "/send_Coupon")
    public void sendCoupon(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        // StringBuffer htmlText = null;
        String mailSender = "";
        String mailBody = "";
        String alertMsg = "";
        try {
            PrintWriter out = null;
            out = response.getWriter();
            String email = request.getParameter("email");
            String gameName = request.getParameter("gameName");
            if (email != null) {
                email = email.trim();
                if (!email.equals("")) {
                    LoggerApi.Log.info(email);
                    LoggerApi.Log.info((String) session.getAttribute("htmlTextS"));
                    if (session.getAttribute("htmlTextS") != null)
                        mailBody = session.getAttribute("htmlTextS").toString();
                    String mailSubject = null;
                    String mailSourceName = null;
                    mailBody = mailBody.replace("\"+\"/", "/");
                    mailSubject = "Tu Boleto de "+gameName;
                    mailSourceName = "LA TINKA";
                    /*
                     * if (email == null) { } else
                     */
                    //alertMsg = "\\nal correo principal " + email;
                    mailSender = email;
                    LoggerApi.Log.info(email);
                    LoggerApi.Log.info(mailBody);
                    MailLib.sendValidMailName(null, mailSourceName, mailSender, mailSubject, mailBody);
                    //request.setAttribute(WebConsts.ALERT_MSG, "Se ha enviado el mensaje con el boleto de sus jugadas" + alertMsg);
                    alertMsg = "Se ha enviado el mensaje con el boleto de sus jugadas al correo " + email;
                } else alertMsg = "Correo no encontrado.";
            } else alertMsg = "Correo no encontrado.";
            out.print(alertMsg);
            //return "client/home_user";
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        }
    }
}
