package pe.com.intralot.loto.layer.controller.game.awardMoneyAllPlays;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetClient;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.service.client.bo.TicketSaleBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.lib.DateAPI;
import pe.com.intralot.loto.lib.StringLib;
import pe.com.intralot.loto.model.Client;
import pe.com.intralot.loto.model.ClientBalance;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.sale.card.dispatcher.BussinessSaleDispatcher;
import pe.com.intralot.loto.sale.card.dispatcher.BussinessSaleLotos5Dispatcher;
import pe.com.intralot.loto.sale.card.dispatcher.GameSaleDispatcher;
import pe.com.intralot.loto.sale.card.dispatcher.GameSaleLotos5Dispatcher;
import pe.com.intralot.loto.sale.card.model.WEBMessage;
import pe.com.intralot.loto.sale.card.model.WEBTicket;
import pe.com.intralot.loto.sale.card.model.WEBTicketPay;
import pe.com.intralot.loto.sale.client.dispatcher.SalesDispatcher;
import pe.com.intralot.loto.sale.game.dispatcher.SalesGameDispatcher;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.QrUtil;

@Controller
public class AwardMoneyController {

    @Autowired
    private TicketSaleBo ticketSaleBo;
    @Autowired
    private ClientSaleBo clientSaleBo;
    @Autowired
    private QrUtil qrUtil;
    
    //@RequestMapping("/payAwardMoneygeneral")
    @RequestMapping("/payAwardMoney")
    public void AwardMoney(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String message = "";
        String tId = "";
        try {
            WEBMessage web = new WEBMessage();
            boolean desist = false;
            boolean credit = true;
            //int idGame = 0;
            int definePrizeFlag = 1;
            UserBean userBean = null;
            String barCode = "";
            double amount = 0.0;
            if (session != null) {
                userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                barCode = StringLib.decodeLabel(session.getAttribute("ticketNumber").toString());
                amount = Double.parseDouble(session.getAttribute("money").toString().replace(",", ""));
            }
            PrintWriter out = null;
            out = response.getWriter();
            String clientIp = request.getRemoteAddr();
            if (clientIp == null)
                clientIp = request.getRemoteAddr();
            //LoggerApi.Log.info("payAwardMoneygeneral userBean=" + userBean);
            LoggerApi.Log.info("payAwardMoney userBean=" + userBean);
            // request.getContextPath();
            int ticketType = 1;
            // String play = "1 2 3 4 5 6";
            //int id = Integer.parseInt(request.getParameter("idGame").toString());
            int gameId = Integer.parseInt(request.getParameter("idGame").toString());
            String idTicket = request.getParameter("parameterId");
            /*if (id == 108)
                idGame = Game.TEAPUESTO;
            if (id == 5209)
                idGame = Game.FECHAZALOTOS;
            if (id == 1121)
                idGame = Game.KINELO;
            if (id == 10102)
                idGame = Game.POLLAYPOLLON;
            if (id == 249)
                idGame = Game.INSTANT;
            if (id == 13)
                idGame = Game.ELREVENTON;
            int gameId = idGame;*/
            String idDraw = "";
            if (session.getAttribute("DrawId") != null)
                idDraw = session.getAttribute("DrawId").toString();
            Game game = new Game(gameId);
            // String name_game = game.getName();
            String ip = "";
            Client client = new Client();
            String clientId = "";
            if (session.getAttribute(Constants.USR_SESION) != null)
                clientId = String.valueOf(((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid());// Integer.parseInt(request.getParameter("clienIdClient"));
            client = BussinessSaleDispatcher.getClientByClientId(clientId);
            web.setClient(client);
            web.setIp(ip);
            DateAPI d = new DateAPI();
            web.setMessageId("W" + d.getTimeLong());
            web.setGame(game);
            // WEBTicketPay webTicketPay = new WEBTicketPay();
            // WEBTicketPay resp[0] =
            // GameSaleDispatcher.payTicketWinnerByWebTransaction(client, web,
            // game,barCode, webTicketPay, desist, credit);
            // WEBTicketPay wtp =
            //if (id == Game.INSTANT) {
            if (gameId == Game.TINKA && gameId == Game.KABALA && gameId == Game.GANADIARIO && gameId == Game.GANAGOL && gameId == Game.SUPER3) {
                WEBTicketPay webTicketPay = new WEBTicketPay();
                WEBTicketPay wtp = GameSaleDispatcher.payTicketWinnerByWebTransaction(client, web, game, barCode, webTicketPay, desist, credit);
                int gratis = 0, mitadPrecio = 0;
                if (wtp.getMessage() != null) {
                    message = wtp.getMessage();
                    if (message.equals("OK")) {
                        if (wtp.getClientTicketExchange() != null)
                            tId = wtp.getClientTicketExchange().getTicketId();
                        if (wtp.getWebTickets() != null)
                            for (WEBTicket webTicket : wtp.getWebTickets())
                                // ES GRATIS caso contrario es 2x1
                                if (webTicket.getClientTicket() != null)
                                    if (webTicket.getClientTicket().getReceiptAmount() == 0.0)
                                        // wtp.getClientTicket().getTicketId();
                                        gratis++;
                                    else
                                        mitadPrecio++;
                    }
                    userBean.setpMonto(wtp.getBalanceAmount());
                    LoggerApi.Log.info(message + ";" + wtp.getLoadAmount() + ";" + wtp.getBalanceAmount() + ";" + tId);
                }
                //session.setAttribute(Constants.USR_SESION, userBean);
                out.print(message + ";" + wtp.getLoadAmount() + ";" + wtp.getBalanceAmount() + ";" + tId + ";" + gratis + ";" + mitadPrecio);
            } else if (gameId == Game.INSTANT) {
                int editionId = Integer.parseInt(idTicket.substring(0, 3));
                int prizeBook = Integer.parseInt(idTicket.substring(3, 9));
                int prizeNum = Integer.parseInt(idTicket.substring(9, 12));
                ClientBalance clientBalance = SalesGameDispatcher.payTicketWinnerByWebTransactionLotosInstantaneas(client, web, game, amount, editionId, prizeBook, prizeNum);
                if (clientBalance.getMessage() != null) {
                    message = clientBalance.getMessage();
                    if (clientBalance != null) {
                        System.out.println(clientBalance.getNewAmount());
                        userBean.setpMonto(clientBalance.getNewAmount());
                    }
                    LoggerApi.Log.info(message + ";" + clientBalance.getNewAmount());
                }
                out.print(message + ";" + clientBalance.getNewAmount());
                //} else if (id == Game.ELREVENTON) {
            } else if (gameId == Game.ELREVENTON) {
                String idEdition = idTicket.substring(0, 3);
                String bookTicket = idTicket.substring(3, 10);
                String numTicket = idTicket.substring(10, 13);
                String dataConcatTicket = SalesGameDispatcher.payTicketWinnerByWebTransactionElReventon(clientId, ip, idDraw, idEdition, bookTicket, numTicket,
                        definePrizeFlag);
                System.out.println("dataConcatTicket   --->  " + dataConcatTicket);
                String cadena[] = (dataConcatTicket + "").split("\\|");
                if (dataConcatTicket != null) {
                    double monto = Double.parseDouble(cadena[0].toString());
                    userBean.setpMonto(monto);
                }
                LoggerApi.Log.info(cadena[2] + ";" + cadena[0]);
                out.print(cadena[2].trim() + ";" + cadena[0].trim());
            } else {
                String resp[] = GameSaleLotos5Dispatcher.payCouponToBalanceByWeb(null, clientId, clientIp, gameId, barCode, idTicket, false);
                System.out.println(resp[0]);
                if (resp[0] != null && resp[0] == "OK") {
                    message = resp[0];
                    if (resp[2] != null) {
                        System.out.println(resp[2]);
                        userBean.setpMonto(Double.parseDouble(resp[2]));
                    }
                    LoggerApi.Log.info(message + ";" + resp[1]);
                }
                out.print(resp[0] + ";" + resp[1]);
            }
            session.setAttribute(Constants.USR_SESION, userBean);
        } catch (Exception e) {
            LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, message);
            throw e;
        } finally {
        }
    }

    @RequestMapping(value = "/premio_punto_venta_general")
    public void sale_dot_award(HttpServletRequest request, HttpServletResponse response, ModelMap modelDraw, ModelMap model) throws Exception {
        HttpSession session = request.getSession();
        int SessionId = 0;
        StringBuffer htmlTextCode = new StringBuffer();
        //int gameId = 0;
        Long ticketId = 0L;
        //int idGame = 0;
        String email = null;
        String emailStat = null;
        Integer editionId = 0;
        Integer prizeBook = 0;
        Integer prizeNum = 0;
        try {
            PrintWriter out = null;
            out = response.getWriter();
            int clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
            int definePrizeFlag = 2;
            String phone = String.valueOf(request.getParameter("numberPhone"));
            /*String idDraw =  session.getAttribute("DrawId").toString();*/
            String idDraw = session.getAttribute("gticket").toString();
            //int id = Integer.parseInt(request.getParameter("idGame").toString());
            int gameId = Integer.parseInt(request.getParameter("idGame").toString());
            /*if (id == 163)
                idGame = Game.SUPER3;
            if (id == 4)
                idGame = Game.GANAGOL;
            if (id == 108)
                idGame = Game.TEAPUESTO;
            if (id == 5209)
                idGame = Game.FECHAZALOTOS;
            if (id == 1121)
                idGame = Game.KINELO;
            if (id == 10102)
                idGame = Game.POLLAYPOLLON;
            if (id == 13)
                idGame = Game.ELREVENTON;*/
            String msg = "";
            //if (id == 249) {
            if (gameId == Game.INSTANT) {
                String idTicket = session.getAttribute("gticket").toString();
                //idGame = Game.INSTANT;
                editionId = Integer.parseInt(idTicket.substring(0, 3));
                prizeBook = Integer.parseInt(idTicket.substring(3, 9));
                prizeNum = Integer.parseInt(idTicket.substring(9, 12));
                // 3 6 3
                LoggerApi.Log.info("cid=" + clientId + " gameId:  " + gameId + "   editionId:   " + editionId + "   prizeBook: " + prizeBook + "   prizeNum:  " + prizeNum);
                msg = SalesGameDispatcher.setClientPrizeToCollectPrizeInstantaneas(editionId, prizeBook, prizeNum, phone);
                ticketId = Long.parseLong(idTicket);
                //
            } else if (gameId == Game.ELREVENTON) {
                String idTicket = session.getAttribute("gticket").toString();
                String idEdition = idTicket.substring(0, 3);
                String bookTicket = idTicket.substring(3, 10);
                String numTicket = idTicket.substring(10, 13);
                String dataConcatTicket = SalesGameDispatcher.payTicketWinnerByWebTransactionElReventon(String.valueOf(clientId), phone, idDraw, idEdition, bookTicket,
                        numTicket, definePrizeFlag);
                LoggerApi.Log.info("cid=" + clientId + " dataConcatTicket   --->  " + dataConcatTicket);
                String cadena[] = (dataConcatTicket + "").split("\\|");
                ticketId = Long.parseLong(idTicket);
                LoggerApi.Log.info(cadena[2] + ";" + cadena[0]);
                msg = cadena[2];
            } else {
                Integer idTicket = Integer.parseInt(session.getAttribute("gticket").toString());
                LoggerApi.Log.info("cid=" + clientId + " idTicket: " + idTicket + "  phone: " + phone + "   clientId:  " + clientId);
                msg = BussinessSaleLotos5Dispatcher.definePrizeFlagPhone(idTicket, clientId, gameId, definePrizeFlag, phone);
                LoggerApi.Log.info("cid=" + clientId + " msg ------------ > " + msg);
                ticketId = Long.valueOf(idTicket);
            }
            SessionId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid();
            //gameId = idGame;
            // ticketId = Long.valueOf(idTicket);
            TicketProcedureGetClientTicket ticketProcedureGetClientTicket = ticketSaleBo.findByClientTicket(clientId, gameId, ticketId);
            // htmlTextCode =
            // ticketSaleBo.findCouponByClientTicket(ticketProcedureGetClientTicket);
            LoggerApi.Log.info("cid=" + clientId + " gameId: " + gameId);
            if (gameId == Game.TEAPUESTO)
                htmlTextCode = ticketSaleBo.findCouponByClientTicketTeApuesto(ticketProcedureGetClientTicket, 1);
            else if (gameId == Game.FECHAZALOTOS)
                htmlTextCode = ticketSaleBo.findCouponByClientTicketFechaza(ticketProcedureGetClientTicket, 1);
            else if (gameId == Game.KINELO)
                htmlTextCode = ticketSaleBo.findCouponByClientTicketKinelo(ticketProcedureGetClientTicket, 1);
            else if (gameId == Game.POLLAYPOLLON)
                htmlTextCode = ticketSaleBo.findCouponByClientTicketPollayPollon(ticketProcedureGetClientTicket);
            else if (gameId == Game.INSTANT)
                htmlTextCode = ticketSaleBo.findCouponClientTicketRapitinkas(ticketProcedureGetClientTicket, 1);
            else if (gameId == Game.ELREVENTON)
                htmlTextCode = ticketSaleBo.findCouponClientTicketElReventon(ticketProcedureGetClientTicket, 1);
            else
                htmlTextCode = ticketSaleBo.findCouponByClientTicket(ticketProcedureGetClientTicket, 1);
            ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(SessionId, clientId);
            if (clientProcedureGetClient.getMail() != null)
                email = clientProcedureGetClient.getMail();
            // email2 = clientProcedureGetClient.getMail2();
            if (clientProcedureGetClient.getMailstatus() != null)
                emailStat = clientProcedureGetClient.getMailstatus();
            // email2Stat = clientProcedureGetClient.getMail2status();
            ticketProcedureGetClientTicket.getCtToDrawDate();
            request.setAttribute("gameid", gameId);
            request.setAttribute("gticket", ticketId);
            request.setAttribute("email", email);
            // request.setAttribute("email2", email2);
            request.setAttribute("emailStat", emailStat);
            // request.setAttribute("email2Stat", email2Stat);
            // model.put("clientsale",clientSaleBean);

            //Obtener QR @jmoran 2019-05-24
            String htmlQr = qrUtil.generateQR(ticketProcedureGetClientTicket, htmlTextCode.toString());
            
            //request.setAttribute("htmlTextCode", htmlTextCode.toString());
            //String array = msg + "|||" + htmlTextCode; // @jmoran 2019-05-24
            request.setAttribute("htmlTextCode", htmlQr.toString());
            String array = msg + "|||" + htmlQr;
            
            out.print(array);
        } catch (Exception e) {
            LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.");
            throw e;
        }
    }

    @RequestMapping("/payAwardMoneyAdvais")
    public void AwardMoneyAdvais(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String message = "";
        try {
            WEBMessage web = new WEBMessage();
            /*  boolean desist = false;
             boolean credit = true;
             int idGame = 0;
             int definePrizeFlag = 1; */
            UserBean userBean = null;
            String barCode = "";
            double amount = 0.0;
            if (session != null) {
                userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                barCode = StringLib.decodeLabel(session.getAttribute("ticketNumber").toString());
                amount = Double.parseDouble(session.getAttribute("money").toString());
            }
            PrintWriter out = null;
            out = response.getWriter();
            String clientIp = request.getRemoteAddr();
            if (clientIp == null)
                clientIp = request.getRemoteAddr();
            LoggerApi.Log.info("payAwardMoneyAdvais userBean=" + userBean);
            // request.getContextPath();
            int ticketType = 1;
            // String play = "1 2 3 4 5 6";
            int gameId = Integer.parseInt(request.getParameter("idGame").toString());
            String idTicket = request.getParameter("parameterId");
            /* if (id == 108)
                idGame = Game.TEAPUESTO;
            if (id == 5209)
                idGame = Game.FECHAZALOTOS;
            if (id == 1121)
                idGame = Game.KINELO;
            if (id == 10102)
                idGame = Game.POLLAYPOLLON;
            if (id == 249)
                idGame = Game.INSTANT;
            if(id==13)
               idGame = Game.ELREVENTON;

            int gameId = idGame; */
            String idDraw = "";
            if (session.getAttribute("DrawId") != null)
                idDraw = session.getAttribute("DrawId").toString();
            // String name_game = game.getName();
            String clientId = "";
            if (session.getAttribute(Constants.USR_SESION) != null)
                clientId = String.valueOf(((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid());// Integer.parseInt(request.getParameter("clienIdClient"));
            clientIp = "ADVAIS";
            LoggerApi.Log.info("cid=" + clientId + " clientIp=" + clientIp + " gameId=" + gameId + " tid=" + idTicket);
            String dataTransaction = "null";
            String advaisURL = ""; // String.valueOf(ConnectionFactory.operationProperty("advaisURL", Constants.contextSale)).toString().trim();
            if (gameId == Game.INSTANT) {
                Client client = new Client();
                client = BussinessSaleDispatcher.getClientByClientId(clientId);
                Game game = new Game(gameId);
                web.setClient(client);
                web.setIp(clientIp);
                DateAPI d = new DateAPI();
                web.setMessageId("W" + d.getTimeLong());
                web.setGame(game);
                int editionId = Integer.parseInt(idTicket.substring(0, 3));
                int prizeBook = Integer.parseInt(idTicket.substring(3, 9));
                int prizeNum = Integer.parseInt(idTicket.substring(9, 12));
                LoggerApi.Log.info("cid=" + clientId + " SalesGameDispatcher.payTicketWinnerByWebTransactionLotosInstantaneas");
                ClientBalance clientBalance = SalesGameDispatcher.payTicketWinnerByWebTransactionLotosInstantaneas(client, web, game, amount, editionId, prizeBook, prizeNum);
                if (clientBalance.getMessage() != null) {
                    message = clientBalance.getMessage();
                    if (clientBalance != null) {
                        //System.out.println(clientBalance.getNewAmount());
                        userBean.setpMonto(clientBalance.getNewAmount());
                        dataTransaction = SalesDispatcher.getTransactionAdvais(clientId, 249,
                                editionId + StringLib.padLeft(String.valueOf(prizeBook), '0', 6) + StringLib.padLeft(String.valueOf(prizeNum), '0', 3));
                        dataTransaction += ";" + advaisURL;
                    }
                    LoggerApi.Log.info(message + ";" + dataTransaction);
                }
                out.print(message + ";" + dataTransaction);
            } else if (gameId == Game.TINKA || gameId == Game.KABALA || gameId == Game.GANADIARIO || gameId == Game.SUPER3 || gameId == Game.GANAGOL
                    || gameId == Game.TEAPUESTO || gameId == Game.FECHAZALOTOS || gameId == Game.KINELO || gameId == Game.GIROMAGICO || gameId == Game.POLLAYPOLLON) {
                LoggerApi.Log.info("cid=" + clientId + " GameSaleLotos5Dispatcher.payCouponToBalanceByWeb");
                String resp[] = GameSaleLotos5Dispatcher.payCouponToBalanceByWeb(null, clientId, clientIp, gameId, barCode, idTicket, true);
                System.out.println(resp[0]);
                if (resp[0] != null && resp[0] == "OK") {
                    message = resp[0];
                    if (resp[2] != null) {
                        //System.out.println(resp[2]);
                        dataTransaction = SalesDispatcher.getTransactionAdvais(clientId, gameId, idTicket);
                        dataTransaction += ";" + advaisURL;
                        userBean.setpMonto(Double.parseDouble(resp[2]));
                    }
                    LoggerApi.Log.info(message + ";" + dataTransaction);
                }
                out.print(resp[0] + ";" + dataTransaction);
            } else
                LoggerApi.Log.info("Juego no encontrado gameId=" + gameId);
            session.setAttribute(Constants.USR_SESION, userBean);
        } catch (Exception e) {
            LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, message);
            throw e;
        } finally {
        }
    }
}
