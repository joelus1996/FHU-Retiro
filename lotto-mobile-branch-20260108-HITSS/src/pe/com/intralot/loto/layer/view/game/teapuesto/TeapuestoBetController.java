package pe.com.intralot.loto.layer.view.game.teapuesto;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador
 * @proyecto: lotto-mobile
 *
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pe.com.intralot.loto.api.model.GroupAPI;
import pe.com.intralot.loto.card.lib.SpringFactory;
import pe.com.intralot.loto.layer.controller.game.teapuesto.bo.TeapuestoBetBo;
import pe.com.intralot.loto.layer.model.pojo.Event;
import pe.com.intralot.loto.lib.DateAPI;
import pe.com.intralot.loto.model.Client;
import pe.com.intralot.loto.model.ClientTicket;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.sale.card.dao.ClientDao;
import pe.com.intralot.loto.sale.card.dispatcher.GameSaleLotos5Dispatcher;
import pe.com.intralot.loto.sale.card.lib.LoggerAPI;
import pe.com.intralot.loto.sale.card.model.WEBMessage;
import pe.com.intralot.loto.sale.client.lib.Combina;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.IntralotUtils;

@Controller
public class TeapuestoBetController {

    //static final Log logger = LogFactory.getLog(TeapuestoBetController.class);
    @Autowired
    TeapuestoBetBo beanTeapuestoBetBo;
    @Autowired
    IntralotUtils intralotUtils;

    @SuppressWarnings("unchecked")
    @RequestMapping("/game_teapuesto_show_menu")
    public ModelAndView showMenu(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
            LoggerApi.Log.info("");
            objectModelMap.put("resultListTeapuesto", beanTeapuestoBetBo.findInformationForEvent());
            HttpSession session = request.getSession();
            session.removeAttribute("amountMaxAltern-session");
            session.removeAttribute("arrayMultiply");
            session.removeAttribute("arrayCombination");
            if (CollectionUtils.isEmpty((List<Event>) session.getAttribute("homeTapuesto")))
                session.setAttribute("homeTapuesto", beanTeapuestoBetBo.getDataRegularHeaderForEvent());
            return new ModelAndView("game/teapuesto/interface-home");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/teapuesto/interface-home");
        } finally {
            //LoggerApi.Log.info("Salir del método: showMenu. Estado : Satisfactorio");
            //LoggerApi.Log.info("Salir del action: TeapuestoBetController.");
        }
    }

    @RequestMapping("/game_teapuesto_show_bet")
    public ModelAndView showBet(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
            LoggerApi.Log.info("");
            if (request.getParameter("event") != null && request.getParameter("draw") != null && request.getParameter("game") != null) {
                Object params[] = new Object[3];
                params[0] = request.getParameter("event").toString();
                params[1] = request.getParameter("draw").toString();
                params[2] = request.getParameter("game").toString();
                objectModelMap.put("teapuestoGameList", beanTeapuestoBetBo.getByPkInformationForEvent(params));
            }
            return new ModelAndView("game/teapuesto/interface-shoppingcart-add");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/teapuesto/interface-shoppingcart-add");
        } finally {
            //LoggerApi.Log.info("Salir del método: ShowBet. Estado : Satisfactorio");
            //LoggerApi.Log.info("Salir del action: TeapuestoBetController. ");
        }
    }

    @RequestMapping("/game_teapuesto_show_bet_exact")
    public ModelAndView showBet_exact(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
            LoggerApi.Log.info("");
            Object params[] = new Object[3];
            params[0] = request.getParameter("event").toString();
            params[1] = request.getParameter("draw").toString();
            params[2] = request.getParameter("game").toString();
            objectModelMap.put("teapuestoGameList", beanTeapuestoBetBo.getByPkInformationForEvent(params));
            return new ModelAndView("game/teapuesto/interface-shoppingcart-marc-exact");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/teapuesto/interface-shoppingcart-marc-exact");
        } finally {
            //LoggerApi.Log.info("Salir del método: ShowBetexact. Estado : Satisfactorio");
            //LoggerApi.Log.info("Salir del action: TeapuestoBetController. ");
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping("/game_teapuesto_show_shoppingcart")
    public ModelAndView showShoppingcart(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
            LoggerApi.Log.info("");
            Map sessionShop = new HashMap();
            Map param = new HashMap();
            param.put("date", request.getParameter("date"));
            param.put("hour", request.getParameter("hour"));
            param.put("minute", request.getParameter("minute"));
            param.put("tipo", request.getParameter("tipo"));
            param.put("valor", request.getParameter("valor"));
            param.put("event", request.getParameter("event"));
            param.put("draw", request.getParameter("draw"));
            param.put("game", request.getParameter("game"));
            param.put("local", request.getParameter("local"));
            param.put("visit", request.getParameter("visit"));
            param.put("min", request.getParameter("min"));
            HttpSession session = request.getSession();
            if (MapUtils.isNotEmpty((HashMap) session.getAttribute("sessionShop-session")))
                sessionShop.putAll((HashMap) session.getAttribute("sessionShop-session"));
            if (MapUtils.isNotEmpty((HashMap) sessionShop.get(param.get("event") + "-" + param.get("draw") + "-" + param.get("game")))) {
                Double valor = Double.valueOf((String) ((HashMap) sessionShop.get(param.get("event") + "-" + param.get("draw") + "-" + param.get("game"))).get("valor"));
                Double monto = (Double) session.getAttribute("amountMax-session") / valor;
                session.setAttribute("amountMax-session", monto);
            }
            sessionShop.put(param.get("event") + "-" + param.get("draw") + "-" + param.get("game"), param);
            session.setAttribute("sessionShop-session", sessionShop);
            Double amountMax = Double.valueOf(request.getParameter("valor"));
            if ((Double) session.getAttribute("amountMax-session") != null)
                amountMax *= (Double) session.getAttribute("amountMax-session");
            session.setAttribute("amountMax-session", amountMax);
            return new ModelAndView("redirect:game_teapuesto_show_shoppingcart_resume.html");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("redirect:game_teapuesto_show_shoppingcart_resume.html");
        } finally {
            //LoggerApi.Log.info("Salir del método: showShoppingCart. Estado : Satisfactorio");
            //LoggerApi.Log.info("Salir del action: TeapuestoBetController. ");
        }
    }

    @RequestMapping("/game_teapuesto_show_multiplier")
    public ModelAndView showMultiplier(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
            LoggerApi.Log.info("");
            return new ModelAndView("game/teapuesto/interface-multiplier");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/teapuesto/interface-multiplier");
        } finally {
            //LoggerApi.Log.info("Salir método: showMultiplier. Estado Satisfactorio");
            //LoggerApi.Log.info("Salir al action: TeapuestoBetController.");
        }
    }

    @RequestMapping("/game_teapuesto_show_combined")
    public ModelAndView showCombined(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
            LoggerApi.Log.info("");
            return new ModelAndView("game/teapuesto/interface-combined");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/teapuesto/interface-combined");
        } finally {
            //LoggerApi.Log.info("Salir método: showCombined. Estado Satisfactorio");
            //LoggerApi.Log.info("Salir al action: TeapuestoBetController.");
        }
    }

    @SuppressWarnings("rawtypes")
    @RequestMapping("/game_teapuesto_show_shoppingcart_resume")
    public ModelAndView showShoppingCartResume(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
            LoggerApi.Log.info("showShoppingCartResume");
            HttpSession session = request.getSession();
            List combinationList = (ArrayList) session.getAttribute("arrayCombination");
            String combina = StringUtils.EMPTY;
            if (CollectionUtils.isNotEmpty(combinationList)) {
                for (Object object : combinationList)
                    combina += String.valueOf(object).concat(" ");
                combina = combina.substring(0, combina.length() - 1);
            }
            double multi = 50000;
            if (MapUtils.isNotEmpty((HashMap) session.getAttribute("sessionShop-session")))
                if ((Double) session.getAttribute("amountMaxAltern-session") == null)
                    objectModelMap.put("amountMax", intralotUtils.formatCurrency((Double) session.getAttribute("amountMax-session")));
                else if ((Double) session.getAttribute("amountMaxAltern-session") > 50000)
                    objectModelMap.put("amountMax", intralotUtils.formatCurrency(multi));
                else
                    objectModelMap.put("amountMax", intralotUtils.formatCurrency((Double) session.getAttribute("amountMaxAltern-session")));
            int total = 1;
            if (!CollectionUtils.isEmpty((ArrayList) session.getAttribute("arrayMultiply")))
                for (Object object : (ArrayList) session.getAttribute("arrayMultiply"))
                    total *= Integer.valueOf(String.valueOf(object));
            objectModelMap.put("total", intralotUtils.formatCurrency(total));
            objectModelMap.put("totalMultiplier", total);
            session.setAttribute("ShoppingListTeapuesto", session.getAttribute("sessionShop-session"));
            session.setAttribute("LottoCar",Integer.parseInt(session.getAttribute("LottoCar").toString())+1);
            Map map = (HashMap) session.getAttribute("ShoppingListTeapuesto");
            if (map==null) {
                LoggerApi.Log.info("ShoppingListTeapuesto map==null total="+total);
                return new ModelAndView("game/teapuesto/interface-shoppingcart");
            }
            int cantidad = map.size();
            int combinacion = 0;
            String combinas = "";
            if (CollectionUtils.isNotEmpty(combinationList))
                for (Object object : combinationList) {
                    combinas = String.valueOf(object);
                    combinacion = Integer.parseInt(combinas);
                    if (combinacion > cantidad) {
                        objectModelMap.put("mensaje_alerta", "Numero de combinadas incorrecto");
                        HttpSession sessiones = request.getSession();
                        sessiones.removeAttribute("arrayCombination");
                    }
                }
            objectModelMap.put("cantidad", cantidad);
            Map mapFormato = new HashMap();
            List lista = new ArrayList();
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                String mapa = (String) it.next();
                Map maping = (Map) map.get(mapa);
                String key = new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("yyyy/MM/dd").parse(String.valueOf(maping.get("date")).replaceAll("-", "/")));
                lista.add(maping);
                mapFormato.put(key, lista);
            }
            String play = StringUtils.EMPTY;
            String[] elementos = new String[map.size()];
            int pos = -1;
            double num = 0;
            Iterator i = mapFormato.keySet().iterator();
            while (i.hasNext()) {
                String mapa = (String) i.next();
                pos = pos--;
                for (Object object : (List) mapFormato.get(mapa)) {
                    Map maping = (Map) object;
                    String key = new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("yyyy/MM/dd").parse(String.valueOf(maping.get("date")).replaceAll("-", "/")));
                    if (key.equalsIgnoreCase(mapa)) {
                        play += maping.get("valor");
                        pos++;
                        elementos[pos] = play;
                        play = "";
                    }
                }
            }
            objectModelMap.put("total", intralotUtils.formatCurrency(total));
            /*objectModelMap.put("totalpago",intralotUtils.formatCurrency(Combina.getFactor(combina,elementos)));*/
            objectModelMap.put("movimiento", intralotUtils.formatCurrency(Combina.getNumBets(combina, elementos)));
            if (Combina.getFactor(combina, elementos) > 50000)
                objectModelMap.put("totalpago", intralotUtils.formatCurrency(Combina.getFactor(combina, elementos)));
            else
                objectModelMap.put("totalpago", intralotUtils.formatCurrency(Combina.getFactor(combina, elementos)));
            objectModelMap.put("totalpago_M_C", intralotUtils.formatCurrency(Combina.getFactor(combina, elementos) * total));
            objectModelMap.put("movimiento_M_C", intralotUtils.formatCurrency(Combina.getNumBets(combina, elementos) * total));
            if (Combina.getFactor(combina, elementos) * total > 50000)
                objectModelMap.put("totalpago_M_C_M", intralotUtils.formatCurrency(multi));
            else
                objectModelMap.put("totalpago_M_C_M", intralotUtils.formatCurrency(Combina.getFactor(combina, elementos) * total));
            return new ModelAndView("game/teapuesto/interface-shoppingcart");
        } catch (Exception e) {
        	LoggerApi.severe(e);
            return new ModelAndView("game/teapuesto/interface-shoppingcart");
        } finally {
            //LoggerApi.Log.info("Salir del método: showShoppingCartResume. Estado : Satisfactorio");
            //LoggerApi.Log.info("Salir del action: TeapuestoBetController.");
        }
    }

    @SuppressWarnings("rawtypes")
    @RequestMapping("/game_teapuesto_delete_bet")
    public ModelAndView deleteBet(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
            LoggerApi.Log.info("");
            String parametro = request.getParameter("id");
            HttpSession session = request.getSession();
            if (MapUtils.isNotEmpty((HashMap) session.getAttribute("sessionShop-session"))) {
                session.setAttribute("arrayCombination", null);
                session.removeAttribute("arrayCombination");
                Map map = (HashMap) session.getAttribute("sessionShop-session");
                if (StringUtils.equals(parametro, "all")) {
                    session.setAttribute("sessionShop-session", null);
                    session.removeAttribute("sessionShop-session");
                    session.setAttribute("amountMax-session", null);
                    session.removeAttribute("amountMax-session");
                    session.setAttribute("amountMaxAltern-session", null);
                    session.removeAttribute("amountMaxAltern-session");
                    session.setAttribute("arrayMultiply", null);
                    session.removeAttribute("arrayMultiply");
                } else {
                    for (Object key : map.keySet())
                        if (StringUtils.equals(String.valueOf(key), parametro)) {
                            Double restar = Double.valueOf(String.valueOf(((Map) map.get(String.valueOf(key))).get("valor")));
                            session.setAttribute("amountMax-session", (Double) session.getAttribute("amountMax-session") / restar);
                            map.remove(key);
                            session.setAttribute("amountMaxAltern-session", null);
                            session.removeAttribute("amountMaxAltern-session");
                            session.setAttribute("arrayMultiply", null);
                            session.removeAttribute("arrayMultiply");
                            break;
                        }
                    session.setAttribute("sessionShop-session", map);
                }
            }
            return new ModelAndView("redirect:game_teapuesto_show_shoppingcart_resume.html");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("redirect:game_teapuesto_show_shoppingcart_resume.html");
        } finally {
            //LoggerApi.Log.info("Salir del método: deleteBet. Estado: Satisfactorio");
            //LoggerApi.Log.info("Salir del action: TeapuestoBetController.");
        }
    }

    @SuppressWarnings({ "unchecked" })
    @RequestMapping("/game_teapuesto_filter_game")
    public ModelAndView filterGame(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
            LoggerApi.Log.info("");
            String filtro = request.getParameter("filter");
            if (!filtro.equals("") && filtro != null && filtro.length() > 0) {
                Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(filtro);
                objectModelMap.put("title", fecha);
                filtro = new SimpleDateFormat("dd/MM/yyyy").format(fecha);
                HttpSession session = request.getSession();
                if (CollectionUtils.isEmpty((List<Event>) session.getAttribute(filtro + "-session"))) {
                    Object params[] = new Object[1];
                    params[0] = filtro;
                    List<Event> eventList = beanTeapuestoBetBo.findByFilterInformationForEvent(params);
                    objectModelMap.put("resultListTeapuesto", eventList);
                    session.setAttribute(filtro + "-session", eventList);
                } else
                    objectModelMap.put("resultListTeapuesto", session.getAttribute(filtro + "-session"));
                objectModelMap.put("filter", "game_teapuesto_filter_game.html?filter=" + new SimpleDateFormat("yyyy-MM-dd").format(fecha));
            } else {
                ;
                ;
            }
            return new ModelAndView("game/teapuesto/interface-home");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/teapuesto/interface-home");
        } finally {
            //LoggerApi.Log.info("Salir del método: filterGame. Estado : Satisfactorio");
            //LoggerApi.Log.info("Salir del action: TeapuestoBetController.");
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping("/game_teapuesto_add_multiplier")
    public ModelAndView addMultiplier(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
            LoggerApi.Log.info("");
            HttpSession session = request.getSession();
            Double monto = (Double) session.getAttribute("amountMax-session");
            List multiplyList = new ArrayList();
            if (!ObjectUtils.isEmpty(request.getParameterValues("multiply")))
                for (Object object : request.getParameterValues("multiply")) {
                	if (object!=null) {
                        multiplyList.add(Long.valueOf(object.toString()));
                        monto = monto * Double.valueOf(object.toString());
                	}
                }
            session.setAttribute("arrayMultiply", multiplyList);
            session.setAttribute("amountMaxAltern-session", monto);
            return new ModelAndView("redirect:game_teapuesto_show_shoppingcart_resume.html");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("redirect:game_teapuesto_show_shoppingcart_resume.html");
        } finally {
            //LoggerApi.Log.info("Salir al metodo: addMultiplier. Estado : Satisfactorio");
            //LoggerApi.Log.info("Salir al action: TeapuestoBetController.");
        }
    }

    @RequestMapping("/game_teapuesto_delete_multiplier")
    public ModelAndView deleteMultiplier(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
            LoggerApi.Log.info("");
            HttpSession session = request.getSession();
            Double monto = (Double) session.getAttribute("amountMax-session");
            session.removeAttribute("arrayMultiply");
            session.setAttribute("amountMaxAltern-session", monto);
            return new ModelAndView("redirect:game_teapuesto_show_shoppingcart_resume.html");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("redirect:game_teapuesto_show_shoppingcart_resume.html");
        } finally {
            //LoggerApi.Log.info("Salir al action: TeapuestoBetController.");
            //LoggerApi.Log.info("Salir al metodo: deleteMultiplier. Estado : Satisfactorio");
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping("/game_teapuesto_add_combined")
    public ModelAndView addCombined(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
            LoggerApi.Log.info("");
            HttpSession session = request.getSession();
            List combinationList = new ArrayList();
            if (!ObjectUtils.isEmpty(request.getParameterValues("combination")))
                for (Object object : request.getParameterValues("combination"))
                    combinationList.add(Long.valueOf(object.toString()));
            session.setAttribute("arrayCombination", combinationList);
            return new ModelAndView("redirect:game_teapuesto_show_shoppingcart_resume.html");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("redirect:game_teapuesto_show_shoppingcart_resume.html");
        } finally {
            //LoggerApi.Log.info("Salir al metodo: addCombined. Estado : Erroneo");
            //LoggerApi.Log.info("Salir al action: TeapuestoBetController.");
        }
    }

    @RequestMapping("/game_teapuesto_delete_combined")
    public ModelAndView deleteCombined(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
            LoggerApi.Log.info("");
            HttpSession session = request.getSession();
            session.removeAttribute("arrayCombination");
            return new ModelAndView("redirect:game_teapuesto_show_shoppingcart_resume.html");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("redirect:game_teapuesto_show_shoppingcart_resume.html");
        } finally {
            //LoggerApi.Log.info("Salir al action: TeapuestoBetController.");
            //LoggerApi.Log.info("Salir al metodo: deleteCombined. Estado : Satisfactorio ");
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping("/game_teapuesto_play_bet")
    public ModelAndView playBet(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        LoggerApi.Log.info("");
        HttpSession session = request.getSession();
        try {
            if (StringUtils.isNotEmpty((String) session.getAttribute("clientId"))) {
                List multiplyList = (ArrayList) session.getAttribute("arrayMultiply");
                List combinationList = (ArrayList) session.getAttribute("arrayCombination");
                Map map = (HashMap) session.getAttribute("ShoppingListTeapuesto");
                SpringFactory.init();
                SpringFactory.getProperties().setMovilCompany("WEBCO");
                LoggerAPI.initCardFileHandler();
                Logger.getLogger(LoggerAPI.CARD).setLevel(Level.ALL);
                int gameId = Game.TEAPUESTO;
                Game game = new Game();
                game.setGame(gameId);
                ClientDao cd = new ClientDao();
                Client client = new Client();
                client = cd.getClientByClientId((String) session.getAttribute("clientId"));
                int multiplo = 1;
                if (CollectionUtils.isNotEmpty(multiplyList))
                    for (Object object : multiplyList)
                        multiplo = multiplo * Integer.parseInt(String.valueOf(object));
                String combina = StringUtils.EMPTY;
                if (CollectionUtils.isNotEmpty(combinationList)) {
                    for (Object object : combinationList)
                        combina += String.valueOf(object).concat(",");
                    combina = combina.substring(0, combina.length() - 1);
                }
                Map mapFormato = new HashMap();
                List lista = new ArrayList();
                if (map != null) {
                    Iterator it = map.keySet().iterator();
                    while (it.hasNext()) {
                        String mapa = (String) it.next();
                        Map maping = (Map) map.get(mapa);
                        String key = new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("yyyy/MM/dd").parse(String.valueOf(maping.get("date"))
                                .replaceAll("-", "/")));
                        lista.add(maping);
                        mapFormato.put(key, lista);
                    }
                }
                String play = StringUtils.EMPTY;
                String partidos = StringUtils.EMPTY;
                String evento = StringUtils.EMPTY;
                ArrayList<String> listaPartidos = new ArrayList();
                Iterator i = mapFormato.keySet().iterator();
                while (i.hasNext()) {
                    String mapa = (String) i.next();
                    play += mapa.concat(" : ");
                    for (Object object : (List) mapFormato.get(mapa)) {
                        Map maping = (Map) object;
                        String key = new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("yyyy/MM/dd").parse(String.valueOf(maping.get("date"))
                                .replaceAll("-", "/")));
                        if (key.equalsIgnoreCase(mapa)) {
                            play += " " + maping.get("event");
                            if (StringUtils.contains((String) maping.get("tipo"), "r")) {
                                play += " - : ";
                                partidos = maping.get("event") + "-" + maping.get("local") + "-" + maping.get("visit");
                            } else if (StringUtils.contains((String) maping.get("tipo"), "s")) {
                                play += " + : ";
                                partidos = maping.get("event") + "-" + maping.get("local") + "-" + maping.get("visit");
                            } else {
                                play += " " + maping.get("tipo").toString().concat(" :");
                                partidos = maping.get("event") + "-" + maping.get("local") + "-" + maping.get("visit");
                            }
                        }
                    }
                    listaPartidos.add(partidos);
                    play = play.concat(" __");
                }
                if (play.length() > 4) {
                    play = play.substring(0, play.length() - 5);
                    play = play.replace(": __", " __").replace("  ", " ");
                }
                LoggerApi.Log.info("Jugada Te apuesto :  " + play);
                DateAPI d = new DateAPI();
                WEBMessage web = new WEBMessage();
                web.setClient(client);
                web.setIp(request.getRemoteAddr());
                web.setGame(game);
                GroupAPI[] group = new GroupAPI[3];
                web.setGroup(group);
                web.setMessageId("W" + d.getTimeLong() + "  " + Game.TEAPUESTO);
                web.setCarrier("MOBILE");
                System.out.println("game.getGameNumber(): " + game.getGameNumber() + "  play: " + play + "    multiplo:" + multiplo + "   combina: " + combina);
                double amount = GameSaleLotos5Dispatcher.verifyCouponLotos5(game.getGameNumber(), play, multiplo, combina, 1);
                /*double amount=-216;*/
                int amoun_in = (int) amount;
                String amoun_n = String.valueOf(amoun_in);
                String amoun_n_1 = amoun_n.substring(1);
                String partido = "";
                ClientTicket ct = null;
                if (amount > 0.00)
                    ct = GameSaleLotos5Dispatcher.playCouponLotos5(client, web, game, play, multiplo, combina, amount, 1);
                else if (amount == -1) {
                    System.out.println("amount paso : " + amount);
                    session.setAttribute("alertPlay", "La jugada no puede procesarse, verifique si ha escogido la cantidad de partidos m&iacute;nimo.");
                } else {
                    System.out.println("amount : " + amount);
                    session.setAttribute("alertPlay", "La jugada no puede procesarse, verifique si ha escogido la cantidad de partidos m&iacute;nimo.");
                    for (int x = 0; x < listaPartidos.size(); x++) {
                        String paises = listaPartidos.get(x);
                        String num = paises.substring(0, amoun_n.length());
                        if (num.equalsIgnoreCase(amoun_n)) {
                            partido = paises.substring(amoun_n.length() + 1);
                            session.setAttribute("alertPlay", "El evento " + amoun_n_1 + " " + partido + " esta bloqueado. No se permite elegir y debe elegir otro evento.");
                        }
                    }
                }
                if (ct != null) {
                	LoggerApi.Log.info("/game_teapuesto_play_bet_result messageResult="+ct.getMessage());
                    if (StringUtils.equals(ct.getMessage(), "OK")) {
                        session.removeAttribute("ShoppingListTeapuesto");
                        session.setAttribute("LottoCar",Integer.parseInt(session.getAttribute("LottoCar").toString())-1);
                        session.setAttribute("sessionShop-session", null);
                        session.removeAttribute("sessionShop-session");
                        session.setAttribute("amountMax-session", null);
                        session.removeAttribute("amountMax-session");
                        session.setAttribute("amountMaxAltern-session", null);
                        session.removeAttribute("amountMaxAltern-session");
                        session.removeAttribute("arrayCombination");
                        session.removeAttribute("arrayMultiply");
                        session.setAttribute("alertPlay", "Jugada realizada con &eacute;xito");
                        session.setAttribute("alertPlay2", "Gracias por tu compra");
                        return new ModelAndView("redirect:client_play_show_information.html?game=teapuesto&status=ok");
                    } else if (StringUtils.contains(ct.getMessage(), "CLIENTE NO EXISTE")) {
                        session.setAttribute("alertPlay", "No se ha encontrado el registro del cliente.");
                        return new ModelAndView("redirect:client_play_show_information.html?game=teapuesto&status=error");
                    } else if (StringUtils.contains(ct.getMessage(), "CREDITO INSUFICIENTE") || StringUtils.contains(ct.getMessage(), "Cuenta Lotocard ha expirado")) {
                        session.setAttribute("alertPlay", "Credito Insuficiente ver ");
                        return new ModelAndView("redirect:client_play_show_information.html?game=teapuesto&status=error");
                    } else {
                        session.setAttribute("alertPlay", "Ocurrio un Erroneo intente nuevamente  ");
                        return new ModelAndView("redirect:client_play_show_information.html?game=teapuesto&status=error");
                    }
            }}
            return new ModelAndView("redirect:client_play_show_information.html?game=teapuesto&status=error");
        } catch (Exception e) {
            session.setAttribute("alertPlay", "Ocurrio un error intente nuevamente");
            LoggerApi.severe(e);
            return new ModelAndView("redirect:client_play_show_information.html?game=teapuesto&status=error");
        } finally {
            //LoggerApi.Log.info("Salir al metodo: playBet. Estado : Satisfactorio");
            //LoggerApi.Log.info("Salir al action: TeapuestoBetController.");
        }
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping("/game_teapuesto_play_bet_result")
    public ModelAndView playBetResult(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        LoggerApi.Log.info("");
        HttpSession session = request.getSession();
        try {
            if (StringUtils.isNotEmpty((String) session.getAttribute("clientId"))) {
                List multiplyList = (ArrayList) session.getAttribute("arrayMultiply");
                List combinationList = (ArrayList) session.getAttribute("arrayCombination");
                Map map = (HashMap) session.getAttribute("ShoppingListTeapuesto");
                SpringFactory.init();
                SpringFactory.getProperties().setMovilCompany("WEBCO");
                LoggerAPI.initCardFileHandler();
                Logger.getLogger(LoggerAPI.CARD).setLevel(Level.ALL);
                int gameId = Game.TEAPUESTO;
                Game game = new Game();
                game.setGame(gameId);
                ClientDao cd = new ClientDao();
                Client client = new Client();
                client = cd.getClientByClientId((String) session.getAttribute("clientId"));
                int multiplo = 1;
                if (CollectionUtils.isNotEmpty(multiplyList))
                    for (Object object : multiplyList)
                        multiplo = multiplo * Integer.parseInt(String.valueOf(object));
                String combina = StringUtils.EMPTY;
                if (CollectionUtils.isNotEmpty(combinationList)) {
                    for (Object object : combinationList)
                        combina += String.valueOf(object).concat(",");
                    combina = combina.substring(0, combina.length() - 1);
                }
                Map mapFormato = new HashMap();
                List lista = new ArrayList();
                if (map != null) {
                    Iterator it = map.keySet().iterator();
                    while (it.hasNext()) {
                        String mapa = (String) it.next();
                        Map maping = (Map) map.get(mapa);
                        String key = new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("yyyy/MM/dd").parse(String.valueOf(maping.get("date"))
                                .replaceAll("-", "/")));
                        lista.add(maping);
                        mapFormato.put(key, lista);
                    }
                }
                String play = StringUtils.EMPTY;
                String partidos = StringUtils.EMPTY;
                String evento = StringUtils.EMPTY;
                ArrayList<String> listaPartidos = new ArrayList();
                Iterator i = mapFormato.keySet().iterator();
                while (i.hasNext()) {
                    String mapa = (String) i.next();
                    play += mapa.concat(" : ");
                    for (Object object : (List) mapFormato.get(mapa)) {
                        Map maping = (Map) object;
                        String key = new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("yyyy/MM/dd").parse(String.valueOf(maping.get("date"))
                                .replaceAll("-", "/")));
                        if (key.equalsIgnoreCase(mapa)) {
                            play += " " + maping.get("event");
                            if (StringUtils.contains((String) maping.get("tipo"), "r")) {
                                play += " - : ";
                                partidos = maping.get("event") + "-" + maping.get("local") + "-" + maping.get("visit");
                            } else if (StringUtils.contains((String) maping.get("tipo"), "s")) {
                                play += " + : ";
                                partidos = maping.get("event") + "-" + maping.get("local") + "-" + maping.get("visit");
                            } else {
                                play += " " + maping.get("tipo").toString().concat(" :");
                                partidos = maping.get("event") + "-" + maping.get("local") + "-" + maping.get("visit");
                            }
                        }
                    }
                    listaPartidos.add(partidos);
                    play = play.concat(" __");
                }
                if (play.length() > 4) {
                    play = play.substring(0, play.length() - 5);
                    play = play.replace(": __", " __").replace("  ", " ");
                }
                LoggerApi.Log.info("Jugada Te apuesto :  " + play);
                DateAPI d = new DateAPI();
                WEBMessage web = new WEBMessage();
                web.setClient(client);
                web.setIp(request.getRemoteAddr());
                web.setGame(game);
                GroupAPI[] group = new GroupAPI[3];
                web.setGroup(group);
                web.setMessageId("W" + d.getTimeLong() + "  " + Game.TEAPUESTO);
                web.setCarrier("MOBILE");
                System.out.println("game.getGameNumber(): " + game.getGameNumber() + "  play: " + play + "    multiplo:" + multiplo + "   combina: " + combina);
                double amount = GameSaleLotos5Dispatcher.verifyCouponLotos5(game.getGameNumber(), play, multiplo, combina, 1);
                /*double amount=-216;*/
                int amoun_in = (int) amount;
                String amoun_n = String.valueOf(amoun_in);
                String amoun_n_1 = amoun_n.substring(1);
                String partido = "";
                ClientTicket ct = null;
                if (amount > 0.00)
                    ct = GameSaleLotos5Dispatcher.playCouponLotos5(client, web, game, play, multiplo, combina, amount, 1);
                else if (amount == -1) {
                    System.out.println("amount paso : " + amount);
                    session.setAttribute("alertPlay", "La jugada no puede procesarse, verifique si ha escogido la cantidad de partidos m&iacute;nimo.");
                } else {
                    System.out.println("amount : " + amount);
                    session.setAttribute("alertPlay", "La jugada no puede procesarse, verifique si ha escogido la cantidad de partidos m&iacute;nimo.");
                    for (int x = 0; x < listaPartidos.size(); x++) {
                        String paises = listaPartidos.get(x);
                        String num = paises.substring(0, amoun_n.length());
                        if (num.equalsIgnoreCase(amoun_n)) {
                            partido = paises.substring(amoun_n.length() + 1);
                            session.setAttribute("alertPlay", "El evento " + amoun_n_1 + " " + partido + " esta bloqueado. No se permite elegir y debe elegir otro evento.");
                        }
                    }
                }
                if (ct != null)
                	LoggerApi.Log.info("/game_teapuesto_play_bet_result messageResult="+ct.getMessage());
                    if (StringUtils.equals(ct.getMessage(), "OK")) {
                        session.removeAttribute("ShoppingListTeapuesto");
                        session.setAttribute("LottoCar",Integer.parseInt(session.getAttribute("LottoCar").toString())-1);
                        session.setAttribute("sessionShop-session", null);
                        session.removeAttribute("sessionShop-session");
                        session.setAttribute("amountMax-session", null);
                        session.removeAttribute("amountMax-session");
                        session.setAttribute("amountMaxAltern-session", null);
                        session.removeAttribute("amountMaxAltern-session");
                        session.removeAttribute("arrayCombination");
                        session.removeAttribute("arrayMultiply");
                        //session.setAttribute("alertPlay", "Jugada realizada con &eacute;xito");
                        session.setAttribute("alertPlay2", "Gracias por tu compra");
                        objectModelMap.put("alertPlay", "Jugada realizada con &eacute;xito");
                        objectModelMap.put("game","teapuesto");
            			objectModelMap.put("status","ok");
            			return new ModelAndView("game/teapuesto/interface-result_game");
                    } else if (StringUtils.contains(ct.getMessage(), "CLIENTE NO EXISTE")) {
                        //session.setAttribute("alertPlay", "No se ha encontrado el registro del cliente.");
                    	objectModelMap.put("alertPlay", "No se ha encontrado el registro del cliente.");
                        objectModelMap.put("game","teapuesto");
            			objectModelMap.put("status","error");
            			return new ModelAndView("game/teapuesto/interface-result_game");
                    } else if (StringUtils.contains(ct.getMessage(), "CREDITO INSUFICIENTE") || StringUtils.contains(ct.getMessage(), "Cuenta Lotocard ha expirado")) {
                        //session.setAttribute("alertPlay", "Credito Insuficiente ver ");
                    	objectModelMap.put("alertPlay", "Credito Insuficiente ver ");
                        objectModelMap.put("game","teapuesto");
            			objectModelMap.put("status","error");
            			return new ModelAndView("game/teapuesto/interface-result_game");
                    } else {
                        //session.setAttribute("alertPlay", "Ocurrio un Erroneo intente nuevamente  ");
                    	objectModelMap.put("alertPlay", "Ocurrio un Erroneo intente nuevamente  ");
                        objectModelMap.put("game","teapuesto");
            			objectModelMap.put("status","error");
            			return new ModelAndView("game/teapuesto/interface-result_game");
                    }
            }
            objectModelMap.put("game","teapuesto");
			objectModelMap.put("status","error");
			return new ModelAndView("game/teapuesto/interface-result_game");
        } catch (Exception e) {
            //session.setAttribute("alertPlay", "Ocurrio un error intente nuevamente");
        	objectModelMap.put("alertPlay", "Ocurrio un error intente nuevamente");
            LoggerApi.severe(e);
            objectModelMap.put("game","teapuesto");
			objectModelMap.put("status","error");
			return new ModelAndView("game/teapuesto/interface-result_game");
        } finally {
        }
    }
}
