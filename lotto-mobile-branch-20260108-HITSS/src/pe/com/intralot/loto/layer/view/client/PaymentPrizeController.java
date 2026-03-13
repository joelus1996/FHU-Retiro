package pe.com.intralot.loto.layer.view.client;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.com.intralot.loto.layer.controller.client.bo.PaymentPrizeBo;
import pe.com.intralot.loto.layer.controller.security.bo.SecurityLoginBo;
import pe.com.intralot.loto.layer.dto.monnet.PayrollDetail;
import pe.com.intralot.loto.layer.dto.monnet.PayrollRequest;
import pe.com.intralot.loto.layer.dto.monnet.PayrollResponse;
import pe.com.intralot.loto.layer.dto.visa.Address;
import pe.com.intralot.loto.layer.dto.visa.BodyFundsDisbursements;
import pe.com.intralot.loto.layer.dto.visa.BodySessionKey;
import pe.com.intralot.loto.layer.dto.visa.Card;
import pe.com.intralot.loto.layer.dto.visa.FundsDisbursementsResponse;
import pe.com.intralot.loto.layer.dto.visa.Merchant;
import pe.com.intralot.loto.layer.dto.visa.Order;
import pe.com.intralot.loto.layer.dto.visa.Recipient;
import pe.com.intralot.loto.layer.dto.visa.Token;
import pe.com.intralot.loto.layer.dto.visa.TokenizeCardResponse;
import pe.com.intralot.loto.layer.model.bean.DebitIdQrResponse;
import pe.com.intralot.loto.layer.model.bean.QrPPBean;
import pe.com.intralot.loto.layer.model.bean.SmsResultBean;
import pe.com.intralot.loto.layer.model.pojo.Client;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetLoginData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureLogin;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureTokenValidation;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureCreateRequest;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureCreateRequestAutomatic;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureCreateRequestAutomaticDQR;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureCreateRequestTrans;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureCreateRequestTransAutomatic;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureCreateRequestTransV2;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureCreateRequestVisa;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureCreateRequestVisaAutomatic;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureDefineDebitQR;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureDeleteAccount;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureEvalPopupInformativo;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureEvalRulesAutomatic;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureEvalRulesAutomaticV2;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetDataCollectPrizes;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetDataCookie;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetRequestByNumber;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetResultEvalRulesAgora;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetResultEvalRulesCash;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetResultEvalRulesTrans;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetResultEvalRulesVisa;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetSavingsAccount;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetTicketsPrizes;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetTicketsPrizesDebitQR;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetTicketsPrizesOld;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetTokenCard;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureHisPayment;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureInBlackList;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureListPrizesMajor;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureRegisterErrorCA;
import pe.com.intralot.loto.layer.model.pojo.TransactionPaymentCreatePin;
import pe.com.intralot.loto.layer.model.pojo.TransactionPaymentLogPin;
import pe.com.intralot.loto.layer.model.pojo.TransactionPaymentRequestIp;
import pe.com.intralot.loto.layer.model.pojo.TransactionPaymentToken;
import pe.com.intralot.loto.layer.model.pojo.TransactionPaymentValidatePin;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.lib.StringLib;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.sale.card.dispatcher.BussinessSaleDispatcher;
import pe.com.intralot.loto.sale.card.dispatcher.GameSaleDispatcher;
import pe.com.intralot.loto.sale.card.model.WEBMessage;
import pe.com.intralot.loto.sale.card.model.WEBTicketPay;
import pe.com.intralot.loto.utils.Constantes;
import pe.com.intralot.loto.utils.DateAPI;
import pe.com.intralot.loto.utils.IntralotUtils;
import pe.com.intralot.loto.utils.LoggerApi;
import pe.com.intralot.loto.utils.MailLib;
import pe.com.intralot.loto.utils.QrUtil;
import pe.com.intralot.loto.utils.SecurityUtils;
import pe.com.intralot.loto.utils.SmsProviderUtils;
import pe.com.intralot.loto.utils.TSLSocketConnectionFactory;
import pe.com.intralot.loto.www.sale.client.lib.WebConsts;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import pe.com.intralot.loto.utils.GetResultKyc;

@Controller
public class PaymentPrizeController {

	@Autowired
	private PaymentPrizeBo paymentPrizeBo;
	@Autowired
    private SecurityLoginBo beanSecurityLoginBo;
	@Autowired
	private IntralotUtils intralotUtils;
	@Autowired
	private QrUtil qrUtil;
	String IMG_BASE64_COBRADO = "iVBORw0KGgoAAAANSUhEUgAAAEIAAABECAYAAAA1DeP1AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAQrSURBVHhe7ZjtS1RBFMb9w81kN9okpbRQP4RBQuAXX0AIs9DSoHJbV0vwbTWTNPqQhBhp6qlzmZvPnXvO7szuvRvB/ORh8cyZM3eevXdm9nZQICIYYQhGGDrK5TJlLQ0tB+MoRGpvVUgwwhCMMCSMaAWXOpijScMlxwWtTjDCEIwwqEZgXBPiEkchUjsLcYlrQrR4MMIQjDDkbgSi5WhxRMvBuCZEiwcjDMEIQ1uNQLT8VuKaEC0ejDAEIwyqEb7kXUeL+6LVCUYYghGGhBFZCckjnpWQYIQhGGHI/S22dAEsRGpntZNghKFtRrwtv6WJ9xM0sDFAxe0ide12UedOZ/TJ/3Oc2znvnxgRD1pPiNReTzyx0bVRKtQK0cQbqfixSE+/PaXzy3OxHssF3/xcjXi+/Jxub90WJ9xI/fv9UX+prgu++bkZMVOdoRvbN8RJuoofGa5j13bBN19dI7AQCtHiLysvqWerR5ycr/jOOPp1lBgLpSHl2kIyN+Lyz9+9jXvipJrVyOEIvXn3JjGePa6NlGsLydyIleMVul67Lk6oWXXvdtP4+/HEePa4NlKuLSRhhJTMcoHzlspL0TYoTcZVXTtd0dpybedaIv7w8GF0t9nY1xoLkdpZSKZGzC3PtbRA8tY5uTpJC5UFKm2VEm09ez309eyrGe0K+1pjIVI7C8nUCJ5Es49Faa9E6yfr9PrdaxpcH0y18+NRPa6a0a6wrzUWIrWzkMT2qeGSw7w4epGaAN/i9zfuU+9mb6otVu+nXtr/uU+nF6c0+mU09VjEevzhceoaXK8tRsvP3Qi+Q6ZWp6Jvmld/e5L8CBycHtDJxQk9OHiQaLP1XxvB4oPRk5UnqW+c7xI+c/A5YejzUKqfrVyNMJ910TpjnDWxOqGuEcVakaZXpv+uAXc279BiZZHml+fp7v5dsQ+K63J9e0xftL6ZGtFo1+AfXvyY8A8x3mpnq7N0c/ummGuL+z6rPkuN6YvWN1MjXM4RsRn8qPAjI+VI4rpc3x7TF62vkxE+VI4r0VYnTaZZ8SGL68bgZDQhWhzJ3Iizy7Nod5Am1Kz6N/qjujE4MU2IFkcyN4LhM8GtvVvipHzFaw6vJQhOTBOixRGn9xG+Ymo/ai2bEW+70hiSNKRcFpKbEQwflJp9L1HvDZUmDSmXheRqBMNb5aO1R86/QQq7hYbvLDVpSLksxOlk6YJWJ47xQerV91c0/HmYCh+TL3K7a93Ut9lHYx/GojysFQvR4i5ofdtmhB1HMEcTosVd0PoGIwyqERjXhLjEXYRI7a5CpHYWEowwBCMMuRuBYA7KBalfPSFaHAlGGIIRhrauES645GMOygUtPxhhCEYYVCN80er4xjV88xGXvsEIQzDCkDAiKyFSO0tDy/GNI5iDQoIRhmCEIZe32P8jwYgIot/0i6rONnza3QAAAABJRU5ErkJggg==";
	@Autowired
	ServletContext context; 
	
	private SimpleDateFormat sdfFront = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Gson gson = new Gson();
	
	@RequestMapping(value = "/pago-premio")
	public String payment_prizes(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		//servicio tokenprize
		HttpSession session = request.getSession();
		String clientId = null;
		ClientProcedureGetLoginData user = (ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION);
		clientId = (user.getClientId() != null) ? user.getClientId().toString() : "0";
		
		JsonObject jdata = new JsonObject();
        jdata.addProperty("operatorId", "6");
        jdata.addProperty("playerId", clientId);
        jdata.addProperty("playerIp", SecurityUtils.getClientIp(request));
        jdata.addProperty("platform", "PTA");
        jdata.addProperty("secret", "742b76434e76726a7a2b672f5379416639674b4468682b43305275735878494554647a344a46677231777052636c414b4e4f2b5033685874663773313539724243344b7670544a3859425269464d576c305439587a413d3d");
		        
        String iarechargeResponse=requestWSIflexApiRecharge(jdata.toString(), "tokenprize");
        JSONObject convertedObject = new JSONObject(iarechargeResponse);
        String status = convertedObject.getString("status");
        if(!status.equals("OK")) {
        	request.setAttribute(WebConsts.ALERT_MSG, "Ha ocurrido un error en el servidor. Vuelva a intentar en unos minutos");
        	return "client/interface-collect_prize_form_api_ta";
        }
        String token=convertedObject.getString("token");
        objectModelMap.put("prizetoken",token);
        objectModelMap.put("operatorId","1");
        return "client/interface-collect_prize_form_api_ta";
	}
	
	@RequestMapping(value = "/pago-premio-api")
	public String payment_prizes_api(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		String token=request.getParameter("prizetoken");	
		objectModelMap.put("prizetoken",token);
		objectModelMap.put("operatorId","6");
		return "client/interface-collect_prize_form_api_ta";
	}
	
	@RequestMapping(value = "/evalPopupInformativo")
	public void evalPopupInformativo(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
			throws Exception {
		UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START evalPopupInformativo uuid="+uuid.toString());
		response.setCharacterEncoding(Constantes.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		String prizetoken=request.getHeader("prizetoken");
		String ipToken=SecurityUtils.getClientIp(request);	
		try {
			Integer idClient = null;
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(prizetoken, ipToken);
			if (tokenValidation.getStatus().equals("OK") && (tokenValidation.getMessage().equals("Validated") || tokenValidation.getMessage().equals("Show"))) {
				idClient = Integer.parseInt(tokenValidation.getClientId());
				o.addProperty("prizetoken", tokenValidation.getRechargeToken());
				LoggerApi.Log.info("-------------- evalPopupInformativo token idClient="+idClient);
			}
			if (idClient != null) {
				PaymentPrizeProcedureEvalPopupInformativo result = paymentPrizeBo.evalPopupInformativo(idClient);
				o.addProperty("status", result.getMessage());
			}else {
				o.addProperty("status", "ERROR");
			}
		} catch (Exception e) {
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e,uuid.toString());
		}
		out.print(o);
		LoggerApi.Log.info("-------------- END evalPopupInformativo uuid="+uuid.toString());		
	}
				
	@RequestMapping(value = "/getDataCollectPrizes")
	public void getDataCollectPrizes(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
			throws Exception {
		UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START getDataCollectPrizes uuid="+uuid.toString());
		response.setCharacterEncoding(Constantes.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		String prizetoken=request.getHeader("prizetoken");
		String ipToken=SecurityUtils.getClientIp(request);	
		try {
			Integer idClient = null;
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(prizetoken, ipToken);
			if (tokenValidation.getStatus().equals("OK") && (tokenValidation.getMessage().equals("Validated") || tokenValidation.getMessage().equals("Show"))) {
				idClient = Integer.parseInt(tokenValidation.getClientId());
				o.addProperty("prizetoken", tokenValidation.getRechargeToken());
				LoggerApi.Log.info("-------------- getDataCollectPrizes token idClient="+idClient);
			}
			if (idClient != null) {
				PaymentPrizeProcedureGetDataCollectPrizes getDataCollectPrizes = paymentPrizeBo
						.getDataCollectPrizes(idClient);
				o.addProperty("status", Constantes.RESULT_OK);
				o.addProperty("cid", idClient);
				o.addProperty("saldoLiquidable", getDataCollectPrizes.getSaldoLiquidable());
				o.addProperty("saldoLiquidableCompleto", intralotUtils.formatCurrency(getDataCollectPrizes.getSaldoLiquidableCompleto()));
				o.addProperty("amountMinRequestCash",getDataCollectPrizes.getAmountMinRequestCash());
				o.addProperty("amountMaxRequestCash",getDataCollectPrizes.getAmountMaxRequestCash());
				o.addProperty("amountMinRequestVisa",getDataCollectPrizes.getAmountMinRequestVisa());
				o.addProperty("amountMaxRequestVisa",getDataCollectPrizes.getAmountMaxRequestVisa());
				o.addProperty("maxMbPerImageVisa",getDataCollectPrizes.getMaxMbPerImageVisa());
				o.addProperty("stateDni",getDataCollectPrizes.getStateDni());
				o.addProperty("itemXPageHRMobile", getDataCollectPrizes.getItemXPageHRMobile());
				o.addProperty("daysExpireRequest", getDataCollectPrizes.getDaysExpireRequest());
				o.addProperty("amountMinEnableDni", getDataCollectPrizes.getAmountMinEnableDni());
				o.addProperty("amountMinEnableDniCash", getDataCollectPrizes.getAmountMinEnblDniCash());
				o.addProperty("minAccAmtEnblDniVisa", getDataCollectPrizes.getMinAccAmtEnblDniVisa());
				o.addProperty("minAccAmtEnblDniCash", getDataCollectPrizes.getMinAccAmtEnblDniCash());
				o.addProperty("accAmtVisa", getDataCollectPrizes.getAccAmtVisa());
				o.addProperty("accAmtCash", getDataCollectPrizes.getAccAmtCash());
				o.addProperty("accAmtAgora", getDataCollectPrizes.getAccAmtAgora());
				o.addProperty("accAmtTrans", getDataCollectPrizes.getAccAmtTrans());
				o.addProperty("amountMinRequestAgr", getDataCollectPrizes.getAmountMinRequestAgr());
				o.addProperty("amountMaxRequestAgr", getDataCollectPrizes.getAmountMaxRequestAgr());
				o.addProperty("amountMinEnblDniAgr", getDataCollectPrizes.getAmountMinEnblDniAgr());
				o.addProperty("minAccAmtEnblDniAgr", getDataCollectPrizes.getMinAccAmtEnblDniAgr());
				o.addProperty("amountMaxAutomaticAgr", getDataCollectPrizes.getAmountMaxAutomaticAgr());
				o.addProperty("msgAutomaticAgrApr", getDataCollectPrizes.getMsgAutomaticAgrApr());
				o.addProperty("msgAutomaticAgrDen", getDataCollectPrizes.getMsgAutomaticAgrDen());
				o.addProperty("maxRequestPerDayAgr", getDataCollectPrizes.getMaxRequestPerDayAgr());
				o.addProperty("msgMaxRquPerDayAgr", getDataCollectPrizes.getMsgMaxRquPerDayAgr());
				o.addProperty("maxAmountPerDayAgr", getDataCollectPrizes.getMaxAmountPerDayAgr());
				o.addProperty("msgMaxAmtPerDayAgr", getDataCollectPrizes.getMsgMaxAmtPerDayAgr());
				o.addProperty("msgAmtAvblPerDayAgr", getDataCollectPrizes.getMsgAmtAvblPerDayAgr());
				o.addProperty("maxAmountPerWeekAgr", getDataCollectPrizes.getMaxAmountPerWeekAgr());
				o.addProperty("msgMaxAmtPerWeekAgr", getDataCollectPrizes.getMsgMaxAmtPerWeekAgr());
				o.addProperty("msgAmtAvblPerWeekAgr", getDataCollectPrizes.getMsgAmtAvblPerWeekAgr());
				o.addProperty("stateRequestAgr", getDataCollectPrizes.getStateRequestAgr());
				o.addProperty("balanceAmount", intralotUtils.formatCurrency(getDataCollectPrizes.getBalanceAmount()));		
				o.addProperty("comMinRan1Visa", getDataCollectPrizes.getComMinRan1Visa());
				o.addProperty("comMaxRan1Visa", getDataCollectPrizes.getComMaxRan1Visa());
				o.addProperty("comAmtRan1Visa", getDataCollectPrizes.getComAmtRan1Visa());
				o.addProperty("comMinRan2Visa", getDataCollectPrizes.getComMinRan2Visa());
				o.addProperty("comMaxRan2Visa", getDataCollectPrizes.getComMaxRan2Visa());
				o.addProperty("comAmtRan2Visa", getDataCollectPrizes.getComAmtRan2Visa());
				o.addProperty("comMinRan3Visa", getDataCollectPrizes.getComMinRan3Visa());
				o.addProperty("comMaxRan3Visa", getDataCollectPrizes.getComMaxRan3Visa());
				o.addProperty("comAmtRan3Visa", getDataCollectPrizes.getComAmtRan3Visa());
				o.addProperty("comMinRan4Visa", getDataCollectPrizes.getComMinRan4Visa());
				o.addProperty("comMaxRan4Visa", getDataCollectPrizes.getComMaxRan4Visa());
				o.addProperty("comAmtRan4Visa", getDataCollectPrizes.getComAmtRan4Visa());
				o.addProperty("comMinRan1Agr", getDataCollectPrizes.getComMinRan1Agr());
				o.addProperty("comMaxRan1Agr", getDataCollectPrizes.getComMaxRan1Agr());
				o.addProperty("comAmtRan1Agr", getDataCollectPrizes.getComAmtRan1Agr());
				o.addProperty("comMinRan2Agr", getDataCollectPrizes.getComMinRan2Agr());
				o.addProperty("comMaxRan2Agr", getDataCollectPrizes.getComMaxRan2Agr());
				o.addProperty("comAmtRan2Agr", getDataCollectPrizes.getComAmtRan2Agr());
				o.addProperty("comMinRan3Agr", getDataCollectPrizes.getComMinRan3Agr());
				o.addProperty("comMaxRan3Agr", getDataCollectPrizes.getComMaxRan3Agr());
				o.addProperty("comAmtRan3Agr", getDataCollectPrizes.getComAmtRan3Agr());
				o.addProperty("comMinRan4Agr", getDataCollectPrizes.getComMinRan4Agr());
				o.addProperty("comMaxRan4Agr", getDataCollectPrizes.getComMaxRan4Agr());
				o.addProperty("comAmtRan4Agr", getDataCollectPrizes.getComAmtRan4Agr());
				o.addProperty("msjComVisa", getDataCollectPrizes.getMsjComVisa());
				o.addProperty("msjComAgr", getDataCollectPrizes.getMsjComAgr());
				o.addProperty("msjComDenVisa", getDataCollectPrizes.getMsjComDenVisa());
				o.addProperty("msjComDenAgr", getDataCollectPrizes.getMsjComDenAgr());
				o.addProperty("amountMinRequestTra", getDataCollectPrizes.getAmountMinRequestTra());
				o.addProperty("amountMaxRequestTra", getDataCollectPrizes.getAmountMaxRequestTra());
				o.addProperty("amountMinEnblDniTra", getDataCollectPrizes.getAmountMinEnblDniTra());
				o.addProperty("minAccAmtEnblDniTra", getDataCollectPrizes.getMinAccAmtEnblDniTra());
				o.addProperty("amountMaxAutomaticTra", getDataCollectPrizes.getAmountMaxAutomaticTra());
				o.addProperty("msgAutomaticTraApr", getDataCollectPrizes.getMsgAutomaticTraApr());
				o.addProperty("msgAutomaticTraDen", getDataCollectPrizes.getMsgAutomaticTraDen());
				o.addProperty("msgMaxRquPerDayTra", getDataCollectPrizes.getMsgMaxRquPerDayTra());
				o.addProperty("maxAmountPerDayTra", getDataCollectPrizes.getMaxAmountPerDayTra());
				o.addProperty("msgMaxAmtPerDayTra", getDataCollectPrizes.getMsgMaxAmtPerDayTra());
				o.addProperty("msgAmtAvblPerDayTra", getDataCollectPrizes.getMsgAmtAvblPerDayTra());
				o.addProperty("msgMaxAmtPerWeekTra", getDataCollectPrizes.getMsgMaxAmtPerWeekTra());
				o.addProperty("msgAmtAvblPerWeekTra", getDataCollectPrizes.getMsgAmtAvblPerWeekTra());
				o.addProperty("maxRequestPerDayVisa", getDataCollectPrizes.getMaxRequestPerDayVisa());
				o.addProperty("maxAmountPerWeekVisa", getDataCollectPrizes.getMaxAmountPerWeekVisa());
				o.addProperty("names", getDataCollectPrizes.getNombre()!=null?getDataCollectPrizes.getNombre().trim():"");
				o.addProperty("lastname", (getDataCollectPrizes.getApellidoPaterno()!=null?getDataCollectPrizes.getApellidoPaterno().trim():"")+" "+(getDataCollectPrizes.getApellidoMaterno()!=null?getDataCollectPrizes.getApellidoMaterno().trim():""));
				o.addProperty("doctype", getDataCollectPrizes.getDocType().trim());
				o.addProperty("docnumber", getDataCollectPrizes.getDocNumber().trim());		
				o.addProperty("maxRequestPerDayTra", getDataCollectPrizes.getMaxRequestPerDayTra());
				o.addProperty("maxAmountPerWeekTra", getDataCollectPrizes.getMaxAmountPerWeekTra());
				o.addProperty("amountMinRquTraRan2", getDataCollectPrizes.getAmountMinRquTraRan2());
				o.addProperty("amountMaxRquTraRan2", getDataCollectPrizes.getAmountMaxRquTraRan2());
				o.addProperty("validityDniTraRan2", getDataCollectPrizes.getValidityDniTraRan2());
				o.addProperty("maxRquPerDayTraRan2", getDataCollectPrizes.getMaxRquPerDayTraRan2());
				o.addProperty("maxAmtPerWeekTraRan2", getDataCollectPrizes.getMaxAmtPerWeekTraRan2());
				o.addProperty("amountMinRquTraRan3", getDataCollectPrizes.getAmountMinRquTraRan3());
				o.addProperty("validityDniTraRan3", getDataCollectPrizes.getValidityDniTraRan3());
				o.addProperty("maxRquPerDayTraRan3", getDataCollectPrizes.getMaxRquPerDayTraRan3());
				o.addProperty("maxAmtPerWeekTraRan3", getDataCollectPrizes.getMaxAmtPerWeekTraRan3());
				o.addProperty("stateRequestTraRan1", getDataCollectPrizes.getStateRequestTraRan1().trim());
				o.addProperty("stateRequestTraRan2", getDataCollectPrizes.getStateRequestTraRan2().trim());
				o.addProperty("stateRequestTraRan3", getDataCollectPrizes.getStateRequestTraRan3().trim());
				o.addProperty("stateRequestTra", getDataCollectPrizes.getStateRequestTra().trim());
				o.addProperty("stateRequestVisa", getDataCollectPrizes.getStateRequestVisa().trim());
				o.addProperty("stateRequestCash", getDataCollectPrizes.getStateRequestCash().trim());
				o.addProperty("daysElapsedDni", getDataCollectPrizes.getDaysElapsedDni());
				
				o.addProperty("requiredKycEf", getDataCollectPrizes.getRequiredKycEf());
				o.addProperty("requiredKycVisa", getDataCollectPrizes.getRequiredKycVisa());
				o.addProperty("requiredKycTrans", getDataCollectPrizes.getRequiredKycTrans());
				
				o.addProperty("amountMinReqKycEf", getDataCollectPrizes.getAmountMinRequiredKycEf());
				o.addProperty("amountMinReqKycVisa", getDataCollectPrizes.getAmountMinRequiredKycVisa());
				o.addProperty("amountMinReqKycTrans", getDataCollectPrizes.getAmountMinRequiredKycTrans());
				
				LoggerApi.Log.info("listPrizesMajor obtener valores");
	
				
				if(getDataCollectPrizes.getStateRequestTra().trim().equals("ACTIVO")) {
					List<PaymentPrizeProcedureGetSavingsAccount> getSavingsAccount=paymentPrizeBo.getSavingsAccount(idClient);
					
					o.addProperty("getSavingsAccount", gson.toJson(getSavingsAccount));
				}
				
				List<PaymentPrizeProcedureListPrizesMajor> listPrizesMajor = paymentPrizeBo.listPrizesMajor(idClient);
				if(listPrizesMajor!=null && !listPrizesMajor.isEmpty()) {
					LoggerApi.Log.info("listPrizesMajor size="+listPrizesMajor.size());
					o.addProperty("listPrizesMajor", gson.toJson(listPrizesMajor));
				}else {
					LoggerApi.Log.info("listPrizesMajor null");
				}
				
			} else {
				o.addProperty("status", "ERROR");
			}
			out.print(o);
		} catch (Exception e) {
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e,uuid.toString());
		}
		LoggerApi.Log.info("-------------- END getDataCollectPrizes uuid="+uuid.toString());
	}
	
	@RequestMapping(value = "/getResultKyc")
    public void getResultKyc(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START getResultKYC uuid="+uuid.toString());
		response.setCharacterEncoding(Constantes.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		String prizetoken=request.getHeader("prizetoken");
		String ipToken=SecurityUtils.getClientIp(request);	
		try {
			Integer idClient = null;
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(prizetoken, ipToken);
			if (tokenValidation.getStatus().equals("OK") && (tokenValidation.getMessage().equals("Validated") || tokenValidation.getMessage().equals("Show"))) {
				idClient = Integer.parseInt(tokenValidation.getClientId());
				o.addProperty("prizetoken", tokenValidation.getRechargeToken());
				LoggerApi.Log.info("-------------- getResultKYC token idClient="+idClient);
			}
	        o = GetResultKyc.getResultKyc(idClient);
	        LoggerApi.Log.info("RESULT: "+ o +" - " +uuid.toString());
	        out.print(o);
		}catch (Exception e) {
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e,uuid.toString());
		}
		LoggerApi.Log.info("-------------- END getResultKyc uuid="+uuid.toString());
    }

	@RequestMapping(value = "/getHisPayment")
	public void getHisPayment(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
			throws Exception {
		UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START getHisPayment uuid="+uuid.toString());
		response.setCharacterEncoding(Constantes.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		String prizetoken=request.getHeader("prizetoken");
		String ipToken=SecurityUtils.getClientIp(request);	
		try {
			Integer idClient = null;
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(prizetoken, ipToken);
			if (tokenValidation.getStatus().equals("OK") && (tokenValidation.getMessage().equals("Validated") || tokenValidation.getMessage().equals("Show"))) {
				idClient = Integer.parseInt(tokenValidation.getClientId());
				o.addProperty("prizetoken", tokenValidation.getRechargeToken());
				LoggerApi.Log.info("-------------- getHisPayment token idClient="+idClient);
			}
			
			if (idClient != null) {
				List<PaymentPrizeProcedureHisPayment> paymentPrizeProcedureHisPayment = paymentPrizeBo
						.getHisPayment(idClient);
				for (PaymentPrizeProcedureHisPayment hisPayment : paymentPrizeProcedureHisPayment) {
					if(hisPayment.getPaymentType().equalsIgnoreCase(Constantes.TYPE_PAYMENT_VISA) || hisPayment.getPaymentType().equalsIgnoreCase(Constantes.TYPE_PAYMENT_AGORA)) {
						if(hisPayment.getCardNumber()!=null && !hisPayment.getCardNumber().isEmpty()) {
							hisPayment.setCardNumber(StringLib.decodeLabel(hisPayment.getCardNumber()));
						}
					}
				}
				Gson gson = new Gson();
				String result = gson.toJson(paymentPrizeProcedureHisPayment);
				o.addProperty("status", Constantes.RESULT_OK);
				o.addProperty("cid", idClient);
				o.addProperty("hisPaymentSize", paymentPrizeProcedureHisPayment.size());
				o.addProperty("hisPayment", result);
			} else {
				o.addProperty("status", "ERROR");
			}
			out.print(o);
		} catch (Exception e) {
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e,uuid.toString());
		}
		LoggerApi.Log.info("-------------- END getHisPayment uuid="+uuid.toString());
	}

	@RequestMapping(value = "/filterHisPayment")
	public void filterHisPayment(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
			throws Exception {
		UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START filterHisPayment uuid="+uuid.toString());
		response.setCharacterEncoding(Constantes.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		String prizetoken=request.getHeader("prizetoken");
		String ipToken=SecurityUtils.getClientIp(request);	
		try {
			Integer idClient = null;
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(prizetoken, ipToken);
			if (tokenValidation.getStatus().equals("OK") && (tokenValidation.getMessage().equals("Validated") || tokenValidation.getMessage().equals("Show"))) {
				idClient = Integer.parseInt(tokenValidation.getClientId());
				o.addProperty("prizetoken", tokenValidation.getRechargeToken());
				LoggerApi.Log.info("-------------- filterHisPayment token idClient="+idClient);
			}
			
			String typeFilterHisPayment = request.getParameter("typeFilterHisPayment");
			String startdate = request.getParameter("startdate");
			String enddate = request.getParameter("enddate");
			List<PaymentPrizeProcedureHisPayment> filteredList = new ArrayList<PaymentPrizeProcedureHisPayment>();
						
			List<PaymentPrizeProcedureHisPayment> paymentPrizeProcedureHisPayment = paymentPrizeBo
					.getHisPayment(idClient);
			for (PaymentPrizeProcedureHisPayment hisPayment : paymentPrizeProcedureHisPayment) {
				if(hisPayment.getPaymentType().equalsIgnoreCase(Constantes.TYPE_PAYMENT_VISA) || hisPayment.getPaymentType().equalsIgnoreCase(Constantes.TYPE_PAYMENT_AGORA)) {
					if(hisPayment.getCardNumber()!=null && !hisPayment.getCardNumber().isEmpty()) {
						hisPayment.setCardNumber(StringLib.decodeLabel(hisPayment.getCardNumber()));
					}
				}
			}
			
			Gson gson = new Gson();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String fecha = sdf.format(new Date());
			Calendar calendario = Calendar.getInstance();
			calendario.setTime(sdf.parse(fecha));
			if (typeFilterHisPayment.trim().equals(Constantes.FILTER_TYPE_ALL)) {
				String result = gson.toJson(paymentPrizeProcedureHisPayment);
				o.addProperty("hisPaymentSize", paymentPrizeProcedureHisPayment.size());
				o.addProperty("hisPayment", result);
				o.addProperty("status", Constantes.RESULT_OK);
			} else if (typeFilterHisPayment.trim().equals(Constantes.FILTER_TYPE_LAST_WEEK)) {
				calendario.add(Calendar.DAY_OF_YEAR, -7);
				for (PaymentPrizeProcedureHisPayment record : paymentPrizeProcedureHisPayment) {
					Date requestDateHour = sdf.parse(record.getRequestDateHour());
					if (requestDateHour.getTime() >= calendario.getTime().getTime()) {
						filteredList.add(record);
					}
				}
				String result = gson.toJson(filteredList);
				o.addProperty("hisPaymentSize", filteredList.size());
				o.addProperty("hisPayment", result);
				o.addProperty("status", Constantes.RESULT_OK);
			} else if (typeFilterHisPayment.trim().equals(Constantes.FILTER_TYPE_LAST_MONTH)) {
				calendario.add(Calendar.DAY_OF_YEAR, -30);
				for (PaymentPrizeProcedureHisPayment record : paymentPrizeProcedureHisPayment) {
					Date requestDateHour = sdf.parse(record.getRequestDateHour());
					if (requestDateHour.getTime() >= calendario.getTime().getTime()) {
						filteredList.add(record);
					}
				}
				String result = gson.toJson(filteredList);
				o.addProperty("hisPaymentSize", filteredList.size());
				o.addProperty("hisPayment", result);
				o.addProperty("status", Constantes.RESULT_OK);
			} else if (typeFilterHisPayment.trim().equals(Constantes.FILTER_TYPE_RANGE)) {
				Date fechaIni = null;
				Date fechaFin = null;
				try {
					fechaIni = sdf.parse(startdate);
					fechaFin = sdf.parse(enddate);
					if (fechaIni.getTime() <= fechaFin.getTime()) {
						calendario.setTime(sdf.parse(enddate));
						calendario.add(Calendar.YEAR, -1);
						if(fechaIni.getTime()>=calendario.getTime().getTime()) {
							List<PaymentPrizeProcedureHisPayment> filteredListRange = paymentPrizeBo.getHisPaymentByReangeDate(idClient, startdate, enddate);
							String result = gson.toJson(filteredListRange);
			    			o.addProperty("hisPaymentSize", filteredListRange.size());
							o.addProperty("hisPayment", result);
							o.addProperty("status", Constantes.RESULT_OK);
						}else {
							o.addProperty("status", "ERROR_FECHA");
							o.addProperty("message",Constantes.MSG_DATE_OUT_RANGE);
						}
					} else {
						o.addProperty("status", "ERROR_FECHA");
						o.addProperty("message", Constantes.MSG_RANGE_INVALID_DATE);
					}
				} catch (Exception e) {
					o.addProperty("status", "ERROR_FECHA");
					o.addProperty("message", Constantes.MSG_INVALID_DATE);
				}
			}
			out.print(o);
		} catch (Exception e) {
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e,uuid.toString());
		}
		LoggerApi.Log.info("-------------- END filterHisPayment uuid="+uuid.toString());
	}

	@RequestMapping(value = "/sendMailTicketsPP")
	public void sendMailTicketsPP(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
			throws Exception {
		UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START sendMailTicketsPP uuid="+uuid.toString());
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		String prizetoken=request.getHeader("prizetoken");
		String ipToken=SecurityUtils.getClientIp(request);	
		try {
			String nombresQR = request.getParameter("nombres");
			String requestNumberPDF = request.getParameter("requestNumber");
			String requestDateHourFrontTicketPDF = request.getParameter("requestDateHour");
			String docNumberFrontTicketPDF = request.getParameter("docNumber");
			String requestAmountFrontTicketPDF = request.getParameter("requestAmount");
			
			Integer idClient = null;
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(prizetoken, ipToken);
			if (tokenValidation.getStatus().equals("OK") && (tokenValidation.getMessage().equals("Validated") || tokenValidation.getMessage().equals("Show"))) {
				idClient = Integer.parseInt(tokenValidation.getClientId());
				o.addProperty("prizetoken", tokenValidation.getRechargeToken());
				LoggerApi.Log.info("-------------- sendMailTicketsPP token idClient="+idClient);
			}
			PaymentPrizeProcedureGetDataCollectPrizes getDataCollectPrizes = paymentPrizeBo.getDataCollectPrizes(idClient);
			String mail = getDataCollectPrizes.getMail();
			if(mail!=null && !mail.trim().isEmpty() && idClient!=null) {
				String name = getDataCollectPrizes.getNombre()+" "+getDataCollectPrizes.getApellidoPaterno();
	    		String clientIdQR = idClient.toString();
					
				List<PaymentPrizeProcedureGetTicketsPrizes> paymentPrizeProcedureGetTicketsPrizesPDF = paymentPrizeBo
						.getTicketsPrizes(idClient, Integer.valueOf(requestNumberPDF));
				
				List<QrPPBean> listaQR = new ArrayList<QrPPBean>();
	
				QrPPBean qrPPBean = new QrPPBean();
				int contador = 1;
				if (paymentPrizeProcedureGetTicketsPrizesPDF.size() > 0) {
					PaymentPrizeProcedureGetTicketsPrizes record = paymentPrizeProcedureGetTicketsPrizesPDF.get(0);
					if (record.getStatus().equalsIgnoreCase(Constantes.PENDIENTE)) {
						String base64QR = qrUtil
								.generateQRString(StringLib.decodeLabel(record.getBarcode()));
						qrPPBean.setQr1(base64QR);
					} else if (record.getStatus().equalsIgnoreCase(Constantes.COBRADO)) {
						qrPPBean.setQr1(IMG_BASE64_COBRADO);
					}
					qrPPBean.setPrize1(record.getPrize());
					qrPPBean.setVal1(record.getValPrinted());
					contador++;
				}
	
				if (paymentPrizeProcedureGetTicketsPrizesPDF.size() == 1) {
					listaQR.add(qrPPBean);
					contador = 0;
				}
	
				for (int i = 1; i < paymentPrizeProcedureGetTicketsPrizesPDF.size(); i++) {
					PaymentPrizeProcedureGetTicketsPrizes record = paymentPrizeProcedureGetTicketsPrizesPDF.get(i);
					if (contador == 1) {
						if (record.getStatus().equalsIgnoreCase(Constantes.PENDIENTE)) {
							String base64QR = qrUtil
									.generateQRString(StringLib.decodeLabel(record.getBarcode()));
							qrPPBean.setQr1(base64QR);
						} else if (record.getStatus().equalsIgnoreCase(Constantes.COBRADO)) {
							qrPPBean.setQr1(IMG_BASE64_COBRADO);
						}
						qrPPBean.setPrize1(record.getPrize());
						qrPPBean.setVal1(record.getValPrinted());
						contador++;
					} else if (contador == 2) {
						if (record.getStatus().equalsIgnoreCase(Constantes.PENDIENTE)) {
							String base64QR = qrUtil
									.generateQRString(StringLib.decodeLabel(record.getBarcode()));
							qrPPBean.setQr2(base64QR);
						} else if (record.getStatus().equalsIgnoreCase(Constantes.COBRADO)) {
							qrPPBean.setQr2(IMG_BASE64_COBRADO);
						}
						qrPPBean.setPrize2(record.getPrize());
						qrPPBean.setVal2(record.getValPrinted());
						contador++;
					} else if (contador == 3) {
						if (record.getStatus().equalsIgnoreCase(Constantes.PENDIENTE)) {
							String base64QR = qrUtil
									.generateQRString(StringLib.decodeLabel(record.getBarcode()));
							qrPPBean.setQr3(base64QR);
						} else if (record.getStatus().equalsIgnoreCase(Constantes.COBRADO)) {
							qrPPBean.setQr3(IMG_BASE64_COBRADO);
						}
						qrPPBean.setPrize3(record.getPrize());
						qrPPBean.setVal3(record.getValPrinted());
						contador++;
					} else if (contador == 4) {
						if (record.getStatus().equalsIgnoreCase(Constantes.PENDIENTE)) {
							String base64QR = qrUtil
									.generateQRString(StringLib.decodeLabel(record.getBarcode()));
							qrPPBean.setQr4(base64QR);
						} else if (record.getStatus().equalsIgnoreCase(Constantes.COBRADO)) {
							qrPPBean.setQr4(IMG_BASE64_COBRADO);
						}
						qrPPBean.setPrize4(record.getPrize());
						qrPPBean.setVal4(record.getValPrinted());
						contador = 1;
						listaQR.add(qrPPBean);
						qrPPBean = new QrPPBean();
					}
				}
	
				if (contador == 2 || contador == 3 || contador == 4) {
					listaQR.add(qrPPBean);
				}
	
				JasperReport reporte = (JasperReport) JRLoader
						.loadObject(new File(Constantes.BASE_PATH_TEMPLATE + Constantes.JR_MAIL_PP));
				Map<String, Object> parametrosReporte = new HashMap<String, Object>();
				parametrosReporte.put("requestNumber", requestNumberPDF);
				parametrosReporte.put("requestDateHour", requestDateHourFrontTicketPDF);
				parametrosReporte.put("docNumber", docNumberFrontTicketPDF);
				parametrosReporte.put("requestAmount", Constantes.MONEDA_SOLES + requestAmountFrontTicketPDF);
				parametrosReporte.put("clientId", clientIdQR);
				parametrosReporte.put("nombres", nombresQR);
				JasperPrint jpTickets = JasperFillManager.fillReport(reporte, parametrosReporte,
						new JRBeanCollectionDataSource(listaQR));
				byte[] bytes = JasperExportManager.exportReportToPdf(jpTickets);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				baos.write(bytes);
				baos.flush();
				baos.close();
				
				String body=getHtmlMailTicketsPP(name);
	
				MailLib.sendValidMail("micuenta" + Constantes.DOMAIN_MAIL, "LA TINKA", mail,name + Constantes.PP_MAIL_SUBJECT_PART1 + requestNumberPDF + Constantes.PP_MAIL_SUBJECT_PART2, body,
						Constantes.FORMAT_HTML_UTF8, baos,Constantes.BASE_NAME_FILE_PP + requestNumberPDF + Constantes.EXTENSION_PDF, context.getRealPath(Constantes.INTERNAL_PATH_LOGO_MAIL), context.getRealPath(Constantes.INTERNAL_PATH_LOGOS_JUEGOS_MAIL));
				o.addProperty("status", Constantes.RESULT_OK);
			}else {
    			o.addProperty("status", "ERROR_MAIL");
    		}
			out.print(o);
		} catch (Exception e) {
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e,uuid.toString());
		}
		LoggerApi.Log.info("-------------- END sendMailTicketsPP uuid="+uuid.toString());
	}

//	@RequestMapping(value = "/downloadTicketsPP", produces = {
//			MediaType.APPLICATION_OCTET_STREAM_VALUE }, method = RequestMethod.POST)
	@RequestMapping(value = "/downloadTicketsPP")
	public @ResponseBody void downloadTicketsPP(HttpServletRequest request, HttpServletResponse response) {
		UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START downloadTicketsPP uuid="+uuid.toString());
		try {
			PrintWriter out = response.getWriter();
			JsonObject o = new JsonObject();
			
			String nombresQR = request.getParameter("nombresPDF");
			String requestNumberPDF = request.getParameter("requestNumberPDF");
			String requestDateHourFrontTicketPDF = request.getParameter("requestDateHourPDF");
			String docNumberFrontTicketPDF = request.getParameter("docNumberPDF");
			String requestAmountFrontTicketPDF = request.getParameter("requestAmountPDF");
			String clientIdQR = request.getParameter("clientIdPDF");
			
			String prizetoken=request.getHeader("prizetoken");
	        String ipToken=SecurityUtils.getClientIp(request);	
			Integer idClient = null;
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(prizetoken, ipToken);
			if (tokenValidation.getStatus().equals("OK") && (tokenValidation.getMessage().equals("Validated") || tokenValidation.getMessage().equals("Show"))) {
				idClient = Integer.parseInt(tokenValidation.getClientId());
				clientIdQR=idClient.toString();
				LoggerApi.Log.info("-------------- downloadTicketsPP token idClient="+idClient);
			}
						
			List<PaymentPrizeProcedureGetTicketsPrizes> paymentPrizeProcedureGetTicketsPrizesPDF = paymentPrizeBo
					.getTicketsPrizes(Integer.valueOf(clientIdQR), Integer.valueOf(requestNumberPDF));
			List<QrPPBean> listaQR = new ArrayList<QrPPBean>();

			QrPPBean qrPPBean = new QrPPBean();
			int contador = 1;
			if (paymentPrizeProcedureGetTicketsPrizesPDF.size() > 0) {
				PaymentPrizeProcedureGetTicketsPrizes record = paymentPrizeProcedureGetTicketsPrizesPDF.get(0);
				if (record.getStatus().equalsIgnoreCase(Constantes.PENDIENTE)) {
					String base64QR = qrUtil
							.generateQRString(StringLib.decodeLabel(record.getBarcode()));
					qrPPBean.setQr1(base64QR);
				} else if (record.getStatus().equalsIgnoreCase(Constantes.COBRADO)) {
					qrPPBean.setQr1(IMG_BASE64_COBRADO);
				}
				qrPPBean.setPrize1(record.getPrize());
				qrPPBean.setVal1(record.getValPrinted());
				contador++;
			}

			if (paymentPrizeProcedureGetTicketsPrizesPDF.size() == 1) {
				listaQR.add(qrPPBean);
				contador = 0;
			}

			for (int i = 1; i < paymentPrizeProcedureGetTicketsPrizesPDF.size(); i++) {
				PaymentPrizeProcedureGetTicketsPrizes record = paymentPrizeProcedureGetTicketsPrizesPDF.get(i);
				if (contador == 1) {
					if (record.getStatus().equalsIgnoreCase(Constantes.PENDIENTE)) {
						String base64QR = qrUtil
								.generateQRString(StringLib.decodeLabel(record.getBarcode()));
						qrPPBean.setQr1(base64QR);
					} else if (record.getStatus().equalsIgnoreCase(Constantes.COBRADO)) {
						qrPPBean.setQr1(IMG_BASE64_COBRADO);
					}
					qrPPBean.setPrize1(record.getPrize());
					qrPPBean.setVal1(record.getValPrinted());
					contador++;
				} else if (contador == 2) {
					if (record.getStatus().equalsIgnoreCase(Constantes.PENDIENTE)) {
						String base64QR = qrUtil
								.generateQRString(StringLib.decodeLabel(record.getBarcode()));
						qrPPBean.setQr2(base64QR);
					} else if (record.getStatus().equalsIgnoreCase(Constantes.COBRADO)) {
						qrPPBean.setQr2(IMG_BASE64_COBRADO);
					}
					qrPPBean.setPrize2(record.getPrize());
					qrPPBean.setVal2(record.getValPrinted());
					contador++;
				} else if (contador == 3) {
					if (record.getStatus().equalsIgnoreCase(Constantes.PENDIENTE)) {
						String base64QR = qrUtil
								.generateQRString(StringLib.decodeLabel(record.getBarcode()));
						qrPPBean.setQr3(base64QR);
					} else if (record.getStatus().equalsIgnoreCase(Constantes.COBRADO)) {
						qrPPBean.setQr3(IMG_BASE64_COBRADO);
					}
					qrPPBean.setPrize3(record.getPrize());
					qrPPBean.setVal3(record.getValPrinted());
					contador++;
				} else if (contador == 4) {
					if (record.getStatus().equalsIgnoreCase(Constantes.PENDIENTE)) {
						String base64QR = qrUtil
								.generateQRString(StringLib.decodeLabel(record.getBarcode()));
						qrPPBean.setQr4(base64QR);
					} else if (record.getStatus().equalsIgnoreCase(Constantes.COBRADO)) {
						qrPPBean.setQr4(IMG_BASE64_COBRADO);
					}
					qrPPBean.setPrize4(record.getPrize());
					qrPPBean.setVal4(record.getValPrinted());
					contador = 1;
					listaQR.add(qrPPBean);
					qrPPBean = new QrPPBean();
				}
			}

			if (contador == 2 || contador == 3 || contador == 4) {
				listaQR.add(qrPPBean);
			}

			JasperReport reporte = (JasperReport) JRLoader
					.loadObject(new File(Constantes.BASE_PATH_TEMPLATE + Constantes.JR_MAIL_PP));
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();
			parametrosReporte.put("requestNumber", requestNumberPDF);
			parametrosReporte.put("requestDateHour", requestDateHourFrontTicketPDF);
			parametrosReporte.put("docNumber", docNumberFrontTicketPDF);
			parametrosReporte.put("requestAmount", Constantes.MONEDA_SOLES + requestAmountFrontTicketPDF);
			parametrosReporte.put("clientId", clientIdQR);
			parametrosReporte.put("nombres", nombresQR);
			JasperPrint jpTickets = JasperFillManager.fillReport(reporte, parametrosReporte,
					new JRBeanCollectionDataSource(listaQR));
//			OutputStream os = response.getOutputStream();
			byte[] bystes = JasperExportManager.exportReportToPdf(jpTickets);
			
			Base64 codec = new Base64();
			String b64 = codec.encodeBase64String(bystes);
			o.addProperty("pdf", b64);
			out.print(o);
			
//			response.setContentType("application/octet-stream");
//			response.setHeader("Content-Disposition", "attachment; filename=" + Constantes.BASE_NAME_FILE_PP
//					+ requestNumberPDF + Constantes.EXTENSION_PDF);
//			os.write(bystes);
//			os.close();
		} catch (Exception e) {
			LoggerApi.severe(e,uuid.toString());
		}
		LoggerApi.Log.info("-------------- END downloadTicketsPP uuid="+uuid.toString());
	}
	
	@RequestMapping(value = "/sendMailTicketsPPDebitIdQR")
	public void sendMailTicketsPPDebitIdQR(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
			throws Exception {
		UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START sendMailTicketsPPDebitIdQR uuid="+uuid.toString());
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		String prizetoken=request.getHeader("prizetoken");
		String ipToken=SecurityUtils.getClientIp(request);	
		try {
			String nombresQR = request.getParameter("nombres");
			String requestNumberPDF = request.getParameter("requestNumber");
			String requestDateHourFrontTicketPDF = request.getParameter("requestDateHour");
			String docNumberFrontTicketPDF = request.getParameter("docNumber");
			String requestAmountFrontTicketPDF = request.getParameter("requestAmount");
			
			Integer idClient = null;
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(prizetoken, ipToken);
			if (tokenValidation.getStatus().equals("OK") && (tokenValidation.getMessage().equals("Validated") || tokenValidation.getMessage().equals("Show"))) {
				idClient = Integer.parseInt(tokenValidation.getClientId());
				o.addProperty("prizetoken", tokenValidation.getRechargeToken());
				LoggerApi.Log.info("-------------- sendMailTicketsPPDebitIdQR token idClient="+idClient);
			}
			PaymentPrizeProcedureGetDataCollectPrizes getDataCollectPrizes = paymentPrizeBo.getDataCollectPrizes(idClient);
			String mail = getDataCollectPrizes.getMail();
			if(mail!=null && !mail.trim().isEmpty() && idClient!=null) {
				String name = getDataCollectPrizes.getNombre()+" "+getDataCollectPrizes.getApellidoPaterno();
	    		String clientIdQR = idClient.toString();
					
				List<PaymentPrizeProcedureGetTicketsPrizesDebitQR> paymentPrizeProcedureGetTicketsPrizesPDF = paymentPrizeBo
						.getTicketsPrizesDebitQR(idClient, Integer.valueOf(requestNumberPDF));
				
				List<QrPPBean> listaQR = new ArrayList<QrPPBean>();
	
				QrPPBean qrPPBean = new QrPPBean();
				PaymentPrizeProcedureGetTicketsPrizesDebitQR record = paymentPrizeProcedureGetTicketsPrizesPDF.get(0);
				if (record.getStatus().equalsIgnoreCase(Constantes.PENDIENTE)) {
					String base64QR = qrUtil
							.generateQRStringDebitId(record.getBarcode());
					qrPPBean.setQr1(base64QR);
				} else if (record.getStatus().equalsIgnoreCase(Constantes.COBRADO)) {
					qrPPBean.setQr1(IMG_BASE64_COBRADO);
				}
				qrPPBean.setPrize1(record.getPrize());
				listaQR.add(qrPPBean);
	
				JasperReport reporte = (JasperReport) JRLoader
						.loadObject(new File(Constantes.BASE_PATH_TEMPLATE + Constantes.JR_MAIL_DEBITIDQR_PP));
				Map<String, Object> parametrosReporte = new HashMap<String, Object>();
				parametrosReporte.put("requestNumber", requestNumberPDF);
				parametrosReporte.put("requestDateHour", requestDateHourFrontTicketPDF);
				parametrosReporte.put("docNumber", docNumberFrontTicketPDF);
				parametrosReporte.put("requestAmount", Constantes.MONEDA_SOLES + requestAmountFrontTicketPDF);
				parametrosReporte.put("clientId", clientIdQR);
				parametrosReporte.put("nombres", nombresQR);
				JasperPrint jpTickets = JasperFillManager.fillReport(reporte, parametrosReporte,
						new JRBeanCollectionDataSource(listaQR));
				byte[] bytes = JasperExportManager.exportReportToPdf(jpTickets);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				baos.write(bytes);
				baos.flush();
				baos.close();
				
				String body=getHtmlMailTicketsPP(name);
	
				MailLib.sendValidMail("micuenta" + Constantes.DOMAIN_MAIL, "LA TINKA", mail,name + Constantes.PP_MAIL_SUBJECT_PART1 + requestNumberPDF + Constantes.PP_MAIL_SUBJECT_PART2, body,
						Constantes.FORMAT_HTML_UTF8, baos,Constantes.BASE_NAME_FILE_PP + requestNumberPDF + Constantes.EXTENSION_PDF, context.getRealPath(Constantes.INTERNAL_PATH_LOGO_MAIL), context.getRealPath(Constantes.INTERNAL_PATH_LOGOS_JUEGOS_MAIL));
				o.addProperty("status", Constantes.RESULT_OK);
			}else {
    			o.addProperty("status", "ERROR_MAIL");
    		}
			out.print(o);
		} catch (Exception e) {
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e,uuid.toString());
		}
		LoggerApi.Log.info("-------------- END sendMailTicketsPPDebitIdQR uuid="+uuid.toString());
	}
	
//	@RequestMapping(value = "/downloadTicketsPPDebitIdQR", produces = {
//			MediaType.APPLICATION_OCTET_STREAM_VALUE }, method = RequestMethod.POST)
	@RequestMapping(value = "/downloadTicketsPPDebitIdQR")
	public @ResponseBody void downloadTicketsPPDebitIdQR(HttpServletRequest request, HttpServletResponse response) {
		UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START downloadTicketsPPDebitIdQR uuid="+uuid.toString());
		try {
			
			PrintWriter out = response.getWriter();
			JsonObject o = new JsonObject();
			
			String nombresQR = request.getParameter("nombresPDF");
			String requestNumberPDF = request.getParameter("requestNumberPDF");
			String requestDateHourFrontTicketPDF = request.getParameter("requestDateHourPDF");
			String docNumberFrontTicketPDF = request.getParameter("docNumberPDF");
			String requestAmountFrontTicketPDF = request.getParameter("requestAmountPDF");
			String clientIdQR = request.getParameter("clientIdPDF");
						
			String prizetoken=request.getHeader("prizetoken");
	        String ipToken=SecurityUtils.getClientIp(request);	
			Integer idClient = null;
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(prizetoken, ipToken);
			if (tokenValidation.getStatus().equals("OK") && (tokenValidation.getMessage().equals("Validated") || tokenValidation.getMessage().equals("Show"))) {
				idClient = Integer.parseInt(tokenValidation.getClientId());
				clientIdQR=idClient.toString();
				LoggerApi.Log.info("-------------- downloadTicketsPPDebitIdQR token idClient="+idClient);
			}
			
			List<PaymentPrizeProcedureGetTicketsPrizesDebitQR> paymentPrizeProcedureGetTicketsPrizesPDF = paymentPrizeBo
					.getTicketsPrizesDebitQR(Integer.valueOf(clientIdQR), Integer.valueOf(requestNumberPDF));
			List<QrPPBean> listaQR = new ArrayList<QrPPBean>();
			QrPPBean qrPPBean = new QrPPBean();
		
			PaymentPrizeProcedureGetTicketsPrizesDebitQR record = paymentPrizeProcedureGetTicketsPrizesPDF.get(0);
			if (record.getStatus().equalsIgnoreCase(Constantes.PENDIENTE)) {
				String base64QR = qrUtil
						.generateQRStringDebitId(record.getBarcode());
				qrPPBean.setQr1(base64QR);
			} else if (record.getStatus().equalsIgnoreCase(Constantes.COBRADO)) {
				qrPPBean.setQr1(IMG_BASE64_COBRADO);
			}
			listaQR.add(qrPPBean);

			JasperReport reporte = (JasperReport) JRLoader
					.loadObject(new File(Constantes.BASE_PATH_TEMPLATE + Constantes.JR_MAIL_DEBITIDQR_PP));
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();
			parametrosReporte.put("requestNumber", requestNumberPDF);
			parametrosReporte.put("requestDateHour", requestDateHourFrontTicketPDF);
			parametrosReporte.put("docNumber", docNumberFrontTicketPDF);
			parametrosReporte.put("requestAmount", Constantes.MONEDA_SOLES + requestAmountFrontTicketPDF);
			parametrosReporte.put("clientId", clientIdQR);
			parametrosReporte.put("nombres", nombresQR);
			JasperPrint jpTickets = JasperFillManager.fillReport(reporte, parametrosReporte,
					new JRBeanCollectionDataSource(listaQR));
			//OutputStream os = response.getOutputStream();
			byte[] bystes = JasperExportManager.exportReportToPdf(jpTickets);
			
			
			Base64 codec = new Base64();
			String b64 = codec.encodeBase64String(bystes);
			o.addProperty("pdf", b64);
			out.print(o);
			
//			response.setContentType("application/octet-stream");
//			response.setHeader("Content-Disposition", "attachment; filename=" + Constantes.BASE_NAME_FILE_PP+ requestNumberPDF + Constantes.EXTENSION_PDF);
//			os.write(bystes);
//			os.close();
		} catch (Exception e) {
			LoggerApi.severe(e,uuid.toString());
		}
		LoggerApi.Log.info("-------------- END downloadTicketsPPDebitIdQR uuid="+uuid.toString());
	}

	@RequestMapping(value = "/createRequest")
	public void createRequest(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
			throws Exception {
		UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START createRequest uuid="+uuid.toString());
		response.setCharacterEncoding(Constantes.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		JsonObject o = new JsonObject();
		o.addProperty("paymentType", "EFECTIVO");
        TransactionPaymentToken paymentSession = null;
        String prizetoken=request.getHeader("prizetoken");
        String ipToken=SecurityUtils.getClientIp(request);	
		try {
			Integer idClient = null;
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(prizetoken, ipToken);
			if (tokenValidation.getStatus().equals("OK") && (tokenValidation.getMessage().equals("Validated") || tokenValidation.getMessage().equals("Show"))) {
				idClient = Integer.parseInt(tokenValidation.getClientId());
				o.addProperty("prizetoken", tokenValidation.getRechargeToken());
				LoggerApi.Log.info("-------------- createRequest token idClient="+idClient);
			}
			Double amountEfectivo = Double.parseDouble(request.getParameter("amountEfectivo"));

			TransactionPaymentLogPin sessionPin = null;
			String resultPin = "";
			
			String amount = request.getParameter("amount")!=null?request.getParameter("amount"):"";	
			String paymentType = request.getParameter("paymentType")!=null?request.getParameter("paymentType"):"";
			String pinUuid = request.getParameter("pinUuid")!=null?request.getParameter("pinUuid"):"";
			paymentSession = new TransactionPaymentToken();
			paymentSession.setChannel(Constantes.PLATAFORM);
			paymentSession.setClientId(idClient.toString());
			paymentSession.setClientIp(ipToken);
			paymentSession.setPinUuid(pinUuid);
			paymentSession.setType(paymentType);
			paymentSession.setAmount(amount);
			
			String statusPin = request.getParameter("statusPin")!=null?request.getParameter("statusPin"):"";
			if ( statusPin.equals("OK") ) {
				resultPin = "OK";
				LoggerApi.Log.info(uuid.toString()+" PIN ok");
				try { sessionPin = paymentPrizeBo.transactionLogPin(paymentSession.getChannel(), "createRequest", paymentSession.getClientId(), paymentSession.getClientIp(), paymentSession.getPinUuid(), paymentSession.getType(), paymentSession.getAmount(), paymentSession.getValidatePinStatus(), resultPin);
				} catch (Exception e) {
					LoggerApi.severe(e, "sessionPin="+sessionPin);			
				}
			} else {
				resultPin = "PIN NO VALIDO!!! "+ paymentSession.getValidatePinStatus();
				LoggerApi.Log.info(uuid.toString()+" "+resultPin);
				try { sessionPin = paymentPrizeBo.transactionLogPin(paymentSession.getChannel(), "createRequest", paymentSession.getClientId(), paymentSession.getClientIp(), paymentSession.getPinUuid(), paymentSession.getType(), paymentSession.getAmount(), paymentSession.getValidatePinStatus(), resultPin);
				} catch (Exception e) {
					LoggerApi.severe(e, "sessionPin="+sessionPin);			
				}
				throw new Exception(resultPin);
			}
			
    		try {
    			paymentPrizeBo.transactionRequestIp("MOBILE","createRequest", idClient.toString(), SecurityUtils.getClientIp(request), paymentSession.getPinUuid(), "EFECTIVO", ""+amountEfectivo );    			
		    } catch (Exception ex) {
		    	try { LoggerApi.severe(ex, "cid="+idClient+" ip="+SecurityUtils.getClientIp(request)); } catch (Exception e) {;}
		    }
			
			String imgDNI = request.getParameter("imgDNI")!=null?request.getParameter("imgDNI"):"";
			String kycResult = request.getParameter("kycResult")!=null?request.getParameter("kycResult"):"";		
			PaymentPrizeProcedureGetDataCollectPrizes paymentPrizeProcedureGetDataCollectPrizes = paymentPrizeBo
					.getDataCollectPrizes(idClient);
			Double saldoLiquidable = paymentPrizeProcedureGetDataCollectPrizes.getSaldoLiquidable();
			
			String flujoDocumento = paymentPrizeProcedureGetDataCollectPrizes.getRequiredKycVisa()!=null?paymentPrizeProcedureGetDataCollectPrizes.getRequiredKycVisa():"";
			
			LoggerApi.Log.info("sigue flujoDNI:" + flujoDocumento);
			if(amountEfectivo>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRequestCash() && amountEfectivo<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxRequestCash()) {
				PaymentPrizeProcedureGetResultEvalRulesCash paymentPrizeProcedureGetResultEvalRulesCash = paymentPrizeBo.getResultEvalRulesCash(idClient,amountEfectivo);
				int accAmtCash = paymentPrizeProcedureGetResultEvalRulesCash.getAccAmtCash().intValue();
				if(paymentPrizeProcedureGetResultEvalRulesCash.getResult().trim().equals(Constantes.RESULT_OK)) {
					String loadedImage = Constantes.LOADED_IMAGE_NO;
					//String loadedImage = Constantes.LOADED_IMAGE_YES;
					if (saldoLiquidable == 0) {
						o.addProperty("status", "ERROR_MONTO");
						o.addProperty("message", Constantes.MSG_NO_CREDIT);
					} else if (amountEfectivo > saldoLiquidable) {
						o.addProperty("status", "ERROR_MONTO");
						o.addProperty("message", Constantes.MSG_NO_CREDIT_SUFICENT);
					}
					else if (flujoDocumento.equalsIgnoreCase("ACTIVO") && (kycResult.trim().isEmpty() && amountEfectivo >= paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRequiredKycEf().intValue()) ) { // validar si es flujo KYC o DNI
						o.addProperty("status", "ERROR_DNI");
						o.addProperty("message", Constantes.MSG_DNI_NOT_LOADED);
						
					} else if (!flujoDocumento.equalsIgnoreCase("ACTIVO") && (!paymentPrizeProcedureGetDataCollectPrizes.getStateDni().equals(Constantes.DNI_STATE_ACTIVE)&& imgDNI.trim().isEmpty()&& (amountEfectivo >= paymentPrizeProcedureGetDataCollectPrizes.getAmountMinEnblDniCash().intValue()|| (amountEfectivo + accAmtCash) >= paymentPrizeProcedureGetDataCollectPrizes.getMinAccAmtEnblDniCash())) ) {
						o.addProperty("status", "ERROR_DNI");
						o.addProperty("message", Constantes.MSG_DNI_NOT_LOADED);
					}else {
						
						boolean errorDocumento= true;
		    			 if (flujoDocumento.equalsIgnoreCase("ACTIVO")) {
		    				 boolean errorKyc = true;
								if (!kycResult.trim().isEmpty() && (kycResult.equals("verified") || kycResult.equals("rejected") || kycResult.equals("reviewNeeded"))) {
									errorKyc = false;
								}
								errorDocumento=errorKyc;
		    			 }else {

						boolean errorDNI = false;
						Double peso = 0.0;
						if(amountEfectivo>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinEnblDniCash().intValue() ||
							(amountEfectivo+accAmtCash)>=paymentPrizeProcedureGetDataCollectPrizes.getMinAccAmtEnblDniCash() ) {
							BASE64Decoder decoder = new BASE64Decoder();
							byte[] decodedBytes = decoder.decodeBuffer(imgDNI.replace("data:image/png;base64,", "").replace("data:image/jpeg;base64,", ""));
							peso = (double) decodedBytes.length;
							if( (peso/1024/1024)<=paymentPrizeProcedureGetDataCollectPrizes.getMaxMbPerImageVisa().intValue()) {
								if(!imgDNI.trim().isEmpty()) {
									loadedImage=Constantes.LOADED_IMAGE_YES;
									try {
										ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
										BufferedImage image = ImageIO.read(bis);
								        bis.close();
								        if(image==null) {
								        	errorDNI = true;
											o.addProperty("status", "ERROR_DNI");
											o.addProperty("message", Constantes.MSG_DNI_NOT_VALID);
								        }
									} catch (Exception e) {
										
									} catch (OutOfMemoryError e) {
										MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
							            MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
							            long maxMemory = heapUsage.getMax() / (1024*1024);
							            long usedMemory = heapUsage.getUsed() / (1024*1024);
							            LoggerApi.Log.info("Memory Use :" + usedMemory + "M/" + maxMemory + "M");
							        }
								}							    
							}else {
								errorDNI = true;
								o.addProperty("status", "ERROR_DNI");
								o.addProperty("message", Constantes.MSG_DNI_LIMIT_MB+paymentPrizeProcedureGetDataCollectPrizes.getMaxMbPerImageVisa().intValue()+Constantes.MB);
							}
						}
								errorDocumento=errorDNI;
		    			 }
						
		    			 LoggerApi.Log.info("errorDocumento:" + flujoDocumento);
						if(!errorDocumento) {
							String ip = request.getRemoteAddr();
							
							//reglas pp automatico
							boolean flagEvalRulesAutomatic=false;
							String whiteList = paymentPrizeProcedureGetDataCollectPrizes.getWhiteList();
						/*	if(!whiteList.trim().equalsIgnoreCase("ACT")) {
								LoggerApi.Log.info("is white list ->:"+whiteList);
								if(amountEfectivo<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxAutomaticCash()) {
									//PaymentPrizeProcedureEvalRulesAutomatic objEvalRulesAutomatic=paymentPrizeBo.evalRulesAutomatic(clientId);
									PaymentPrizeProcedureEvalRulesAutomaticV2 objEvalRulesAutomatic=paymentPrizeBo.evalRulesAutomaticV2(clientId,Constantes.TYPE_PAYMENT_CASH);
									if(objEvalRulesAutomatic!=null && objEvalRulesAutomatic.getResult().trim().equals(Constantes.RESULT_OK)) {
										flagEvalRulesAutomatic=true;
										LoggerApi.Log.info("rules of pay automatic:" + objEvalRulesAutomatic.getResult());
									}
								}
							}else {
								flagEvalRulesAutomatic=true;
							}*/
							
							if(amountEfectivo<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxAutomaticCash()) {
								PaymentPrizeProcedureEvalRulesAutomaticV2 objEvalRulesAutomatic=paymentPrizeBo.evalRulesAutomaticV2(idClient,Constantes.TYPE_PAYMENT_CASH);
								if(objEvalRulesAutomatic!=null && objEvalRulesAutomatic.getResult().trim().equals(Constantes.RESULT_OK)) {
									flagEvalRulesAutomatic=true;
								}
							}
							
							if(flagEvalRulesAutomatic == false) {
								if(whiteList.trim().equalsIgnoreCase("ACT")) {
									flagEvalRulesAutomatic=true;
								}
							}
							LoggerApi.Log.info("createRequestEfectivo ->flagEvalRulesAutomatic:"+flagEvalRulesAutomatic);
							LoggerApi.Log.info("is white list ->:"+whiteList);
							

							
							//if(amountEfectivo>paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxAutomaticCash() && flagEvalRulesAutomatic==false) {
							if( flagEvalRulesAutomatic==false) {
								PaymentPrizeProcedureCreateRequest result = paymentPrizeBo.createRequest(idClient.toString(),
										amountEfectivo, ip, Constantes.TYPE_PAYMENT_CASH, Constantes.PLATAFORM, imgDNI, loadedImage);
								LoggerApi.Log.info("createRequestEfectivoManual");
								if (result.getMessage() != null && result.getMessage().trim().equalsIgnoreCase(Constantes.RESULT_OK)) {
									Double newSaldoLiquidable = saldoLiquidable - result.getAmount();
									paymentPrizeProcedureGetDataCollectPrizes.setSaldoLiquidable(newSaldoLiquidable);
									o.addProperty("saldoLiquidable", paymentPrizeProcedureGetDataCollectPrizes.getSaldoLiquidable());
									/*
									if(peso>0 || paymentPrizeProcedureGetDataCollectPrizes.getStateDni().trim().equals("ACT")	) {
										paymentPrizeProcedureGetDataCollectPrizes.setStateDni("ACT");
										o.addProperty("stateDni", "ACT");
									}else {
										paymentPrizeProcedureGetDataCollectPrizes.setStateDni("PEN");
										o.addProperty("stateDni", "PEN");
									}
									*/
								}
				
								o.addProperty("message", result.getMessage());
								o.addProperty("amount", result.getAmount());
								o.addProperty("requestNumber", result.getRequestNumber());
								o.addProperty("status", Constantes.RESULT_OK);
								o.addProperty("messageSuccess", Constantes.MSG_SUCCESS_REQUEST_CASH);
								o.addProperty("evaluacion", "MANUAL");
							}else {
								//aprobacion automatica
								PaymentPrizeProcedureInBlackList paymentPrizeProcedureInBlackList = paymentPrizeBo.inBlackList(idClient);
								if(paymentPrizeProcedureInBlackList.getResult()!=null && paymentPrizeProcedureInBlackList.getResult().trim().equals(Constantes.BLACKLIST_INACTIVE)) {
									String message = "OK";
									String amountResponse = "0";
									String requestNumber = "0";
									
									Object[] values = new Object[3];
									values[0] = idClient;
									values[1] = amountEfectivo;
									values[2] = "AUTOMATICO";
									PaymentPrizeProcedureDefineDebitQR defineDebitQR = paymentPrizeBo.defineDebitQR(values);
									LoggerApi.Log.info("defineDebitQR Message="+defineDebitQR.getMessage()+
											" State="+defineDebitQR.getState()+
											" DebitIdQR="+defineDebitQR.getDebitIdQR()+
											" KironprizeAmount="+defineDebitQR.getKironprizeAmount()+
											" NeoprizeAmount="+defineDebitQR.getNeoprizeAmount()
											);
									if(defineDebitQR!=null && defineDebitQR.getState()!=null && defineDebitQR.getState().trim().equals(Constantes.RESULT_OK)) {
										String urlDebitIdQR = ConnectionFactory.operationProperty("urlDebitIdQR", Constantes.contextSale);
										String userDebitIdQR = ConnectionFactory.operationProperty("userDebitIdQR", Constantes.contextSale);
										String passDebitIdQR = ConnectionFactory.operationProperty("passDebitIdQR", Constantes.contextSale);
										String tokenDebitIdQR = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constantes.contextPlayerWebApi);
										
										JsonObject jdata = new JsonObject();	  
										jdata.addProperty("token", tokenDebitIdQR);
								        jdata.addProperty("clientId", idClient.toString());
								        jdata.addProperty("debitId", defineDebitQR.getDebitIdQR());
								        jdata.addProperty("amountKiron", defineDebitQR.getKironprizeAmount());
								        jdata.addProperty("amountNeoga", defineDebitQR.getNeoprizeAmount());
								        jdata.addProperty("playerIp", SecurityUtils.getClientIp(request));
								        jdata.addProperty("company", "ECOMM");
								        jdata.addProperty("operatorId", Constantes.OPERATOR_ID+"");						        
								        jdata.addProperty("platform", Constantes.PLATAFORMA);
	
										String jsonResponseDebitIdQR="";
										String jsonRequestDebitIdQR=jdata.toString();
										String credenciales = userDebitIdQR+":"+passDebitIdQR;
										credenciales = Base64.encodeBase64String(credenciales.getBytes()); 	    	
							 	    	URL url = new URL(urlDebitIdQR+defineDebitQR.getDebitIdQR());
							 			HttpURLConnection  con = (HttpURLConnection )url.openConnection();
							 			con.setRequestMethod("POST");
							 			con.setRequestProperty("Authorization", "Basic "+credenciales);
							 			con.setRequestProperty("Content-Type", Constantes.APPLICATION_JSON);
							 			con.setRequestProperty("Accept", Constantes.APPLICATION_JSON);
							     		con.setDoOutput(true);
							     		OutputStream os = con.getOutputStream();
							 			os.write(jsonRequestDebitIdQR.getBytes(Constantes.CHARSET_UTF8));
							 			os.flush();
							 			os.close();
							 			BufferedReader br = null;
							 			int responseCode = con.getResponseCode();
							 			if(responseCode < HttpServletResponse.SC_BAD_REQUEST) {
							 				br = new BufferedReader(new InputStreamReader((con.getInputStream()),Constantes.CHARSET_UTF8));
							 			}else {
							 				LoggerApi.Log.info("API DEBIT ID QR HTTP CODE: "+responseCode + " json: "+jsonRequestDebitIdQR);
							 				br = new BufferedReader(new InputStreamReader((con.getErrorStream()),Constantes.CHARSET_UTF8));
							 			}
							 			StringBuilder sb = new StringBuilder();
							 			char[] buffer = new char[1000];
							 	        int leido;
							 	        while ((leido = br.read(buffer)) > 0) {
							 	        	sb.append(new String(buffer, 0, leido));
							 	        }
							 			br.close();
							 			con.disconnect();
							 			jsonResponseDebitIdQR = sb.toString();
							 			LoggerApi.Log.info("API DEBIT ID QR Response:"+jsonResponseDebitIdQR);
							 			if(responseCode >= HttpServletResponse.SC_BAD_REQUEST) {
							 				LoggerApi.Log.info("API DEBIT ID QR "+ defineDebitQR.getDebitIdQR()+"Response: "+jsonResponseDebitIdQR + " json: "+jsonRequestDebitIdQR);	
							 			}  
							 			DebitIdQrResponse debitIdQrResponse = gson.fromJson(jsonResponseDebitIdQR,DebitIdQrResponse.class); 
							 			if(debitIdQrResponse!=null && debitIdQrResponse.getEstado().equals(Constantes.RESULT_OK)) {
							 				Double amountKiron = new Double(0);
							 				Double amountNeo = new Double(0);
							 				Double amountTotal = new Double(0);
							 				Integer balanceItemKiron = new Integer(0);
							 				Integer balanceItemNeo = new Integer(0);
							 				if(debitIdQrResponse.getAmountKiron()!=null && !debitIdQrResponse.getAmountKiron().trim().isEmpty()) {
							 					amountKiron = Double.parseDouble(debitIdQrResponse.getAmountKiron().trim());
							 				}
							 				if(debitIdQrResponse.getAmountNeoga()!=null && !debitIdQrResponse.getAmountNeoga().trim().isEmpty()) {
							 					amountNeo = Double.parseDouble(debitIdQrResponse.getAmountNeoga().trim());
							 				}
							 				if(debitIdQrResponse.getAmountTotal()!=null && !debitIdQrResponse.getAmountTotal().trim().isEmpty()) {
							 					amountTotal = Double.parseDouble(debitIdQrResponse.getAmountTotal().trim());
							 				}
							 				if(debitIdQrResponse.getBalanceItemKiron()!=null && !debitIdQrResponse.getBalanceItemKiron().trim().isEmpty()) {
							 					balanceItemKiron = Integer.parseInt(debitIdQrResponse.getBalanceItemKiron().trim());
							 				}
							 				if(debitIdQrResponse.getBalanceItemNeoga()!=null && !debitIdQrResponse.getBalanceItemNeoga().trim().isEmpty()) {
							 					balanceItemNeo = Integer.parseInt(debitIdQrResponse.getBalanceItemNeoga().trim());
							 				}
							 				PaymentPrizeProcedureCreateRequestAutomaticDQR result = paymentPrizeBo.createRequestAutomaticDQR(idClient,
													amountEfectivo, Constantes.TYPE_PAYMENT_CASH, Constantes.PLATAFORM,imgDNI, loadedImage, 
													amountKiron,amountNeo,defineDebitQR.getDebitIdQR(),balanceItemKiron,balanceItemNeo);
							 				LoggerApi.Log.info("PaymentPrizeProcedureCreateRequestAutomaticDQR getMessage:"+result.getMessage());
							 				if (result.getMessage() != null && result.getMessage().trim().equalsIgnoreCase(Constantes.RESULT_OK)) {
							 					Double newSaldoLiquidable = saldoLiquidable - amountTotal;
												paymentPrizeProcedureGetDataCollectPrizes.setSaldoLiquidable(newSaldoLiquidable);
												o.addProperty("saldoLiquidable", paymentPrizeProcedureGetDataCollectPrizes.getSaldoLiquidable());
												amountResponse=amountEfectivo.toString();
												requestNumber=result.getRequestNumber().toString();	
							 				}else {
							 					message = Constantes.MSG_EXCEPTION;
							 				}								
							 			}else {
							 				message = Constantes.MSG_EXCEPTION;
							 			}
							 			/*
										PaymentPrizeProcedureCreateRequestAutomatic result = paymentPrizeBo.createRequestAutomatic(idClient.toString(),
												amountEfectivo, ip, Constantes.TYPE_PAYMENT_CASH, Constantes.PLATAFORM,imgDNI, loadedImage);
										LoggerApi.Log.info("createRequestEfectivoAutomatic");
										if (result.getMessage() != null && result.getMessage().trim().equalsIgnoreCase(Constantes.RESULT_OK)) {
											Double newSaldoLiquidable = saldoLiquidable - result.getAmount();
											paymentPrizeProcedureGetDataCollectPrizes.setSaldoLiquidable(newSaldoLiquidable);
											o.addProperty("saldoLiquidable", paymentPrizeProcedureGetDataCollectPrizes.getSaldoLiquidable());
											
											//if(peso>0 || paymentPrizeProcedureGetDataCollectPrizes.getStateDni().trim().equals("ACT")	) {
											//	paymentPrizeProcedureGetDataCollectPrizes.setStateDni("ACT");
											//	o.addProperty("stateDni", "ACT");
											//}else {
											//	paymentPrizeProcedureGetDataCollectPrizes.setStateDni("PEN");
											//	o.addProperty("stateDni", "PEN");
											//}
										}
										*/
									}else {
										message = Constantes.MSG_EXCEPTION;
									}
						 			
									o.addProperty("message", message);
									o.addProperty("amount", amountResponse);
									o.addProperty("requestNumber", requestNumber);
									o.addProperty("status", Constantes.RESULT_OK);
									o.addProperty("messageSuccess", paymentPrizeProcedureGetDataCollectPrizes.getMsgAutomaticCashApr());
									o.addProperty("evaluacion", "AUTOMATICO");
								}else {
									o.addProperty("message", Constantes.MSG_BLACKLIST);
									o.addProperty("status", Constantes.RESULT_OK);
									o.addProperty("evaluacion", "AUTOMATICO");
									o.addProperty("cleanCash", "OK");
									o.addProperty("titulo", "Tu retiro ha sido denegado");
								}
							}
						}
					}
				}else {
					o.addProperty("status", "ERROR_RULES");
					o.addProperty("cleanCash", paymentPrizeProcedureGetResultEvalRulesCash.getClean());
					o.addProperty("message", paymentPrizeProcedureGetResultEvalRulesCash.getMessage());
				}
			}else {
				o.addProperty("status", "ERROR_MONTO");
				o.addProperty("message", Constantes.MSG_AMOUNT_OUT_RANGE.replace("MIN", intralotUtils.formatCurrency3(paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRequestCash().intValue())).replace("MAX", intralotUtils.formatCurrency3(paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxRequestCash().intValue())) );
			}            
			out.print(o);
		} catch (Exception e) {			
			int transactionId = Constantes.generateTransactionId();
			String mensaje = Constantes.MSG_EXCEPTION+"<br><br>N� de operaci�n: I"+transactionId+"<br>"+sdfFront.format(new Date());
			o.addProperty("message", mensaje);
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e,uuid.toString()+ " mensaje: "+mensaje);
		}
        
		TransactionPaymentLogPin sessionPin = null;
		try { 
			String status = o.getAsJsonObject().get("status").toString();
			sessionPin = paymentPrizeBo.transactionLogPin(paymentSession.getChannel(), "createRequestEnd", paymentSession.getClientId(), paymentSession.getClientIp(), paymentSession.getPinUuid(), paymentSession.getType(), paymentSession.getAmount()
						, status , o.toString() );
		} catch (Exception e) {
			LoggerApi.severe(e, "sessionPin="+sessionPin);			
		}
		
		LoggerApi.Log.info("-------------- END createRequest uuid="+uuid.toString());
	}

	@RequestMapping(value = "/getTicketsPrizes")
	public void getTicketsPrizes(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
			throws Exception {
		UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START getTicketsPrizes uuid="+uuid.toString());
		response.setCharacterEncoding(Constantes.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		try {
			String pRequestNumber = request.getParameter("requestNumber");
			Object[] values = new Object[1];
			values[0] = Integer.valueOf(pRequestNumber);
			PaymentPrizeProcedureGetRequestByNumber requestByNumber=paymentPrizeBo.getRequestByNumber(values);
			if (requestByNumber != null) {
				o.addProperty("requestNumber", requestByNumber.getRequestNumber());
				o.addProperty("requestDateHour", requestByNumber.getRequestDateHour());
				LoggerApi.Log.info("--------------requestDateHour ="+requestByNumber.getRequestDateHour());
				o.addProperty("docNumber", requestByNumber.getDocNumber());
				o.addProperty("requestAmount", requestByNumber.getRequestAmount());
				o.addProperty("clientIdQR", requestByNumber.getClientId());
				o.addProperty("nombresQR", requestByNumber.getNombre() + " " + requestByNumber.getApellidoPaterno() + ((requestByNumber.getApellidoMaterno() != null) ? " " + requestByNumber.getApellidoMaterno() : ""));

				List<PaymentPrizeProcedureGetTicketsPrizes> paymentPrizeProcedureGetTicketsPrizes = paymentPrizeBo
						.getTicketsPrizes(requestByNumber.getClientId(), requestByNumber.getRequestNumber());
				String htmlText = "";
				for (PaymentPrizeProcedureGetTicketsPrizes record : paymentPrizeProcedureGetTicketsPrizes) {
					if (record.getStatus().equalsIgnoreCase(Constantes.PENDIENTE)) {
						String base64QR = qrUtil
								.generateQRString(StringLib.decodeLabel(record.getBarcode()));
						htmlText+="<div class='imgqr'><img src='data:image/png;base64,"+base64QR+"' alt='QR'><span style='padding-top: 5px; font-size: 12px;'>"+record.getValPrinted()+"</span><span style='padding-top: 5px;'>"+record.getPrize()+"</span></div>";
					} else if (record.getStatus().equalsIgnoreCase(Constantes.COBRADO)) {
						String base64QR = qrUtil.generateQRString(Constantes.COBRADO);
						htmlText += "<div class='imgqr is-checked'><img src='data:image/png;base64," + base64QR
								+ "' alt='QR'><span>" + record.getPrize() + "</span></div>";
					}
				}
				o.addProperty("htmlText", htmlText);
				o.addProperty("status", Constantes.RESULT_OK);
			} else {
				o.addProperty("status", "ERROR");
			}
			out.print(o);
		} catch (Exception e) {
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e,uuid.toString());
		}
		LoggerApi.Log.info("-------------- END getTicketsPrizes uuid="+uuid.toString());
	}
	
	 @RequestMapping(value = "/getTicketsPrizesOld")
	    public void getTicketsPrizesOld(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
			UUID uuid = UUID.randomUUID();
			LoggerApi.Log.info("-------------- START getTicketsPrizesOld uuid="+uuid.toString());
			/*response.setCharacterEncoding(Constantes.CHARSET_UTF8);
	    	PrintWriter out = response.getWriter();
	        JsonObject o = new JsonObject();
	    	try {
	    		HttpSession session = request.getSession();
	    		Client client = (Client) session.getAttribute("CLIENT_SESSION");
	    		String ticket = request.getParameter("ticket");
	    		List<PaymentPrizeProcedureHisPayment> paymentPrizeProcedureHisPayment = (List<PaymentPrizeProcedureHisPayment>) session.getAttribute("paymentPrizeProcedureHisPaymentFiltered");
	    		if(paymentPrizeProcedureHisPayment!=null && !paymentPrizeProcedureHisPayment.isEmpty() && ticket!=null) {
	    			Integer requestNumber = Integer.valueOf(ticket);
	    			for (PaymentPrizeProcedureHisPayment record : paymentPrizeProcedureHisPayment) {
						if(record.getRequestNumber().compareTo(requestNumber)==0) {
							o.addProperty("requestNumber", record.getRequestNumber());
							o.addProperty("requestDateHour", record.getRequestDateHour());
							o.addProperty("docNumber", record.getDocNumber());
							o.addProperty("requestAmount", record.getRequestAmount());
							o.addProperty("clientIdQR", client.getClientId());
							o.addProperty("nombresQR", client.getName() + " " + client.getLastname() + ((client.getMaidenname() != null) ? " " + client.getMaidenname() : ""));
							session.setAttribute("requestNumberPDF", record.getRequestNumber());
							session.setAttribute("requestDateHourFrontTicketPDF", record.getRequestDateHour());
							session.setAttribute("docNumberFrontTicketPDF", record.getDocNumber());
							session.setAttribute("requestAmountFrontTicketPDF", record.getRequestAmount());
							session.setAttribute("clientIdQR", client.getClientId());
							session.setAttribute("nombresQR", client.getName() + " " + client.getLastname() + ((client.getMaidenname() != null) ? " " + client.getMaidenname() : ""));
							break;
						}
					}
	    			ClientProcedureGetLoginData user = (ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION);
					Integer clientId = user.getClientId();
	    			List<PaymentPrizeProcedureGetTicketsPrizesOld> paymentPrizeProcedureGetTicketsPrizesOld = paymentPrizeBo.getTicketsPrizesOld(clientId, ticket);
	    			List<PaymentPrizeProcedureGetTicketsPrizes> paymentPrizeProcedureGetTicketsPrizes = new ArrayList<PaymentPrizeProcedureGetTicketsPrizes>();
	    			String htmlText = "";
	    			for (PaymentPrizeProcedureGetTicketsPrizesOld record : paymentPrizeProcedureGetTicketsPrizesOld) {
	    				if(record.getStatus().equalsIgnoreCase(Constantes.PENDIENTE)) {
	    					String base64QR = qrUtil.generateQRString(StringLib.decodeLabel(record.getBarcode()));
	    					htmlText+="<div class='imgqr'><img src='data:image/png;base64,"+base64QR+"' alt='QR'><span style='padding-top: 5px; font-size: 12px;'>"+record.getValPrinted()+"</span><span style='padding-top: 5px;'>"+record.getPrize()+"</span></div>";
	    				}   				
	    				PaymentPrizeProcedureGetTicketsPrizes dataPDF = new PaymentPrizeProcedureGetTicketsPrizes();
	    				dataPDF.setId(record.getId());
	    				dataPDF.setBarcode(record.getBarcode());
	    				dataPDF.setPrize(record.getPrize());
	    				dataPDF.setStatus(record.getStatus());
	    				dataPDF.setValPrinted(record.getValPrinted());
	    				paymentPrizeProcedureGetTicketsPrizes.add(dataPDF);
					}
	    			session.setAttribute("paymentPrizeProcedureGetTicketsPrizesPDF", paymentPrizeProcedureGetTicketsPrizes);
	    			o.addProperty("htmlText", htmlText);
	    			o.addProperty("status", Constantes.RESULT_OK);
	    		}else {
					o.addProperty("status", "ERROR");
				}
				out.print(o);
	    	} catch (Exception e) {
				o.addProperty("status", "ERROR");
				out.print(o);
				LoggerApi.severe(e,uuid.toString());
		    } */ 
	    	LoggerApi.Log.info("-------------- END getTicketsPrizesOld uuid="+uuid.toString());
	    }
	 
		@RequestMapping(value = "/getTicketsPrizesDebitIdQR")
		public void getTicketsPrizesDebitIdQR(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
				throws Exception {
			UUID uuid = UUID.randomUUID();
			LoggerApi.Log.info("-------------- START getTicketsPrizesDebitIdQR uuid="+uuid.toString());
			response.setCharacterEncoding(Constantes.CHARSET_UTF8);
			PrintWriter out = response.getWriter();
			JsonObject o = new JsonObject();
			try {
				String pRequestNumber = request.getParameter("requestNumber");
				Object[] values = new Object[1];
				values[0] = Integer.valueOf(pRequestNumber);
				PaymentPrizeProcedureGetRequestByNumber requestByNumber=paymentPrizeBo.getRequestByNumber(values);
				if (requestByNumber != null) {
					o.addProperty("requestNumber", requestByNumber.getRequestNumber());
					o.addProperty("requestDateHour", requestByNumber.getRequestDateHour());
					o.addProperty("docNumber", requestByNumber.getDocNumber());
					o.addProperty("requestAmount", requestByNumber.getRequestAmount());
					o.addProperty("clientIdQR", requestByNumber.getClientId());
					o.addProperty("nombresQR", requestByNumber.getNombre() + " " + requestByNumber.getApellidoPaterno() + ((requestByNumber.getApellidoMaterno() != null) ? " " + requestByNumber.getApellidoMaterno() : ""));

					List<PaymentPrizeProcedureGetTicketsPrizesDebitQR> paymentPrizeProcedureGetTicketsPrizes = paymentPrizeBo
							.getTicketsPrizesDebitQR(requestByNumber.getClientId(), requestByNumber.getRequestNumber());
					String htmlText = "";
					for (PaymentPrizeProcedureGetTicketsPrizesDebitQR record : paymentPrizeProcedureGetTicketsPrizes) {
						if (record.getStatus().equalsIgnoreCase(Constantes.PENDIENTE)) {
							String base64QR = qrUtil
									.generateQRStringDebitId(record.getBarcode());
							htmlText+="<div class='imgqrdebit'><img src='data:image/png;base64,"+base64QR+"' alt='QR'></div>";
						} else if (record.getStatus().equalsIgnoreCase(Constantes.COBRADO)) {
							String base64QR = qrUtil.generateQRStringDebitId(Constantes.COBRADO);
							htmlText += "<div class='imgqrdebit is-checked'><img src='data:image/png;base64," + base64QR
									+ "' alt='QR'></div>";
						}
					}
					o.addProperty("htmlText", htmlText);
					o.addProperty("status", Constantes.RESULT_OK);
				} else {
					o.addProperty("status", "ERROR");
				}
				out.print(o);
			} catch (Exception e) {
				o.addProperty("status", "ERROR");
				out.print(o);
				LoggerApi.severe(e,uuid.toString());
			}
			LoggerApi.Log.info("-------------- END getTicketsPrizesDebitIdQR uuid="+uuid.toString());
		}
	 
	    @RequestMapping(value = "/tokenizationCard")
	    public String tokenizationCard(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        return "client/interface-tokenization-card";
	    }
	    
	    @RequestMapping(value = "/tokenizationCardAgora")
	    public String tokenizationCardAgora(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        return "client/interface-tokenization-card-agora";
	    }
	    
	    @RequestMapping(value = "/tokenizationCardTa")
	    public String tokenizationCardTa(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        return "client/interface-tokenization-card-ta";
	    }
	 
	    @RequestMapping(value = "/createSessionTokenizationCard")
	    public void createSessionTokenizationCard(HttpServletRequest request, HttpServletResponse response) throws Exception {    	
	    	UUID uuid = UUID.randomUUID();
			LoggerApi.Log.info("-------------- START createSessionTokenizationCard uuid="+uuid.toString());
			response.setCharacterEncoding(Constantes.CHARSET_UTF8);
			PrintWriter out = response.getWriter();
			JsonObject o = new JsonObject();
			String prizetoken=request.getHeader("prizetoken");
			String ipToken=SecurityUtils.getClientIp(request);	
			try {
				Integer idClient = null;
				ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
				tokenValidation = beanSecurityLoginBo.getTokenValidation(prizetoken, ipToken);
				if (tokenValidation.getStatus().equals("OK") && (tokenValidation.getMessage().equals("Validated") || tokenValidation.getMessage().equals("Show"))) {
					idClient = Integer.parseInt(tokenValidation.getClientId());
					o.addProperty("prizetoken", tokenValidation.getRechargeToken());
					LoggerApi.Log.info("-------------- createSessionTokenizationCard token idClient="+idClient);
				}
	    		
	    		try {
	    			paymentPrizeBo.transactionRequestIp("MOBILE","createSessionTokenizationCard", ""+idClient, SecurityUtils.getClientIp(request), uuid.toString(), "VISA", "" );
    		    } catch (Exception ex) {
    		    	try { LoggerApi.severe(ex, "cid="+idClient+" ip="+SecurityUtils.getClientIp(request)); } catch (Exception e) {;}
    		    }
				
				String userAPITokenizationCard = ConnectionFactory.operationProperty("user_api_tokenization_card", Constantes.contextSale);
				String passAPITokenizationCard = ConnectionFactory.operationProperty("pass_api_tokenization_card", Constantes.contextSale);
				String securityAPITokenizationCard = ConnectionFactory.operationProperty("security_api_tokenization_card", Constantes.contextSale);
				String sessionAPITokenizationCard = ConnectionFactory.operationProperty("session_api_tokenization_card", Constantes.contextSale);
				String merchantIdAPITokenizationCard = ConnectionFactory.operationProperty("merchant_id_api_tokenization_card", Constantes.contextSale);
								
				String credenciales = userAPITokenizationCard+":"+passAPITokenizationCard;
		    	credenciales = new BASE64Encoder().encode(credenciales.getBytes(Constantes.CHARSET_UTF8));
		    	URL urlSecurity = new URL(securityAPITokenizationCard);
	    		HttpsURLConnection  cnSecurity = (HttpsURLConnection )urlSecurity.openConnection();
	    		cnSecurity.setRequestMethod("GET");
	    		cnSecurity.setRequestProperty("Authorization", "Basic "+credenciales);
	    		cnSecurity.setSSLSocketFactory(new TSLSocketConnectionFactory());
	    		
	    		BufferedReader brSecurity = null;
	    		int responseCodeSecurity = cnSecurity.getResponseCode();
				if(responseCodeSecurity < HttpServletResponse.SC_BAD_REQUEST) {
					brSecurity = new BufferedReader(new InputStreamReader((cnSecurity.getInputStream()),Constantes.CHARSET_UTF8));
				}else {
					LoggerApi.Log.info("API Security HTTP CODE uuid="+uuid.toString()+": "+responseCodeSecurity+ " clientId:"+idClient);
					int transactionId = Constantes.generateTransactionId();
					String mensaje = Constantes.MSG_EXCEPTION+"<br><br>N� de operaci�n: V"+transactionId+"<br>"+sdfFront.format(new Date());
					o.addProperty("message", mensaje);
					registrarErrorVisa(new BigInteger(idClient+""), new BigInteger(transactionId+""), Constantes.PROCESS_SECURITY_API, Constantes.VACIO, Constantes.VACIO, 
							"API Security (createSessionTokenizationCard) HTTP CODE "+responseCodeSecurity, 
									Constantes.VACIO, Constantes.VACIO, Constantes.VACIO, Constantes.VACIO);
					brSecurity = new BufferedReader(new InputStreamReader((cnSecurity.getErrorStream()),Constantes.CHARSET_UTF8));
				}
					    		
	    		StringBuilder sbSecurity = new StringBuilder();
	    		char[] bufferSecurity = new char[1000];
	            int leidoSecurity;
	            while ((leidoSecurity = brSecurity.read(bufferSecurity)) > 0) {
	            	sbSecurity.append(new String(bufferSecurity, 0, leidoSecurity));
	            }
	    		brSecurity.close();
	    		
	    		String token = sbSecurity.toString();
	    		if(responseCodeSecurity < HttpServletResponse.SC_BAD_REQUEST) {
	    			URL urlSession = new URL(sessionAPITokenizationCard+merchantIdAPITokenizationCard);
		    		HttpsURLConnection  cnSession = (HttpsURLConnection )urlSession.openConnection();
		    		cnSession.setRequestMethod("POST");
		    		cnSession.setRequestProperty("Content-Type", Constantes.APPLICATION_JSON);
		    		cnSession.setRequestProperty("Accept", Constantes.APPLICATION_JSON);
		    		cnSession.setRequestProperty("Authorization", token);
		    		cnSession.setDoOutput(true);
		    		cnSession.setSSLSocketFactory(new TSLSocketConnectionFactory());
		    			    		
		        	Gson gson = new Gson();
		            String jsonInputString = gson.toJson(new BodySessionKey("CID" + idClient + "@intralot.com.pe"));
		        	byte[] input = jsonInputString.getBytes(Constantes.CHARSET_UTF8);
		        	OutputStream os = cnSession.getOutputStream();
		        	os.write(input, 0, input.length); 
		        	os.flush();
		        	os.close();
		        	
		        	BufferedReader brSession = null;
		        	int responseCodeSession = cnSession.getResponseCode();
		        	if(responseCodeSession < HttpServletResponse.SC_BAD_REQUEST) {
	            		brSession = new BufferedReader(new InputStreamReader((cnSession.getInputStream()),Constantes.CHARSET_UTF8));
	            	}else {
	            		LoggerApi.Log.info("API Session HTTP CODE uuid="+uuid.toString()+": "+responseCodeSession+ " clientId:"+idClient);
						int transactionId = Constantes.generateTransactionId();
						String mensaje = Constantes.MSG_EXCEPTION+"<br><br>N� de operaci�n: V"+transactionId+"<br>"+sdfFront.format(new Date());
						o.addProperty("message", mensaje);
						registrarErrorVisa(new BigInteger(idClient+""), new BigInteger(transactionId+""), Constantes.PROCESS_SESSION_API, Constantes.VACIO, 
								Constantes.VACIO, "API Session (createSessionTokenizationCard) HTTP CODE "+responseCodeSession, 
										Constantes.VACIO, Constantes.VACIO, Constantes.VACIO, Constantes.VACIO);
	            		brSession = new BufferedReader(new InputStreamReader((cnSession.getErrorStream()),Constantes.CHARSET_UTF8));
	            	}	        	
		        	
		    		StringBuilder sbSession = new StringBuilder();
		    		char[] bufferSession = new char[1000];
		            int leidoSession;
		            while ((leidoSession = brSession.read(bufferSession)) > 0) {
		            	sbSession.append(new String(bufferSession, 0, leidoSession));
		            }
		    		brSession.close();
		    		
		    		String jsonSessionKey = sbSession.toString();
		    		if(responseCodeSession < HttpServletResponse.SC_BAD_REQUEST) {
		    			PaymentPrizeProcedureGetDataCollectPrizes getDataCollectPrizes = paymentPrizeBo.getDataCollectPrizes(idClient);
		    			
		    			request.getSession().setAttribute("token", StringLib.encodeLabel(token));	 
		    			
			    		String baseUri = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
			    		
			    		o.addProperty("json", jsonSessionKey);
			    		o.addProperty("merchantid", merchantIdAPITokenizationCard);
			    		o.addProperty("purchasenumber", paymentPrizeBo.generateTokenPurchaseNumber());	    		
			    		o.addProperty("formbuttontext", "Confirmar");
			    		o.addProperty("merchantlogo", baseUri + "/layer-view-image/v2/landing/img/logo-tinka.png?v=1");
			    		o.addProperty("cardholdername", getDataCollectPrizes.getNombre().toLowerCase().replace("�", "a").replace("�", "e").replace("�", "i").replace("�", "o").replace("�", "u").replace("�", "a").replace("�", "e").replace("�", "i").replace("�", "o").replace("�", "u").replace("�", "a").replace("�", "e").replace("�", "i").replace("�", "o").replace("�", "u").replace("�", "n").replace("'", ""));
			    		o.addProperty("cardholderlastname", (getDataCollectPrizes.getApellidoPaterno() + ((getDataCollectPrizes.getApellidoMaterno() != null) ? " " + getDataCollectPrizes.getApellidoMaterno() : "")).toLowerCase().replace("�", "a").replace("�", "e").replace("�", "i").replace("�", "o").replace("�", "u").replace("�", "a").replace("�", "e").replace("�", "i").replace("�", "o").replace("�", "u").replace("�", "a").replace("�", "e").replace("�", "i").replace("�", "o").replace("�", "u").replace("�", "n").replace("'", ""));
			    		o.addProperty("cardholderemail", "CID" + idClient + "@intralot.com.pe");
			    		o.addProperty("userToken", "CID" + idClient + "@intralot.com.pe" );			    		
			    		o.addProperty("timeouturl", baseUri + "/client_price_show_information.html");
			        	o.addProperty("status", Constantes.RESULT_OK);
		    		}else {
	        			LoggerApi.Log.info("API Session RESPONSE uuid="+uuid.toString()+": "+jsonSessionKey + " clientId:"+idClient);
	        			o.addProperty("status", "ERROR");
		    		}
	    		}else {
	    			LoggerApi.Log.info("API Security RESPONSE uuid="+uuid.toString()+": "+token + " clientId:"+idClient);
	    			o.addProperty("status", "ERROR");
	    		}
	    		
	        	out.print(o);
			}catch (Exception e) {
				int transactionId = Constantes.generateTransactionId();
				String mensaje = Constantes.MSG_EXCEPTION+"<br><br>N� de operaci�n: I"+transactionId+"<br>"+sdfFront.format(new Date());
				o.addProperty("message", mensaje);
				o.addProperty("status", "ERROR");
				out.print(o);
				LoggerApi.severe(e,uuid.toString() + " mensaje: "+mensaje);
			}
			LoggerApi.Log.info("-------------- END createSessionTokenizationCard uuid="+uuid.toString());
	    }

	    @RequestMapping(value = "/createSessionTokenizationCardTa")
	    public void createSessionTokenizationCardTa(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    	UUID uuid = UUID.randomUUID();
			LoggerApi.Log.info("-------------- START createSessionTokenizationCardTa uuid="+uuid.toString());
			response.setCharacterEncoding(Constantes.CHARSET_UTF8);
			PrintWriter out = response.getWriter();
			JsonObject o = new JsonObject();
			String prizetoken=request.getHeader("prizetoken");
			String ipToken=SecurityUtils.getClientIp(request);	
			try {
				Integer idClient = null;
				ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
				tokenValidation = beanSecurityLoginBo.getTokenValidation(prizetoken, ipToken);
				if (tokenValidation.getStatus().equals("OK") && (tokenValidation.getMessage().equals("Validated") || tokenValidation.getMessage().equals("Show"))) {
					idClient = Integer.parseInt(tokenValidation.getClientId());
					o.addProperty("prizetoken", tokenValidation.getRechargeToken());
					LoggerApi.Log.info("-------------- createSessionTokenizationCardTa token idClient="+idClient);
				}

				try {
					paymentPrizeBo.transactionRequestIp("MOBILE","createSessionTokenizationCardTa", ""+idClient, SecurityUtils.getClientIp(request), uuid.toString(), "VISA", "" );
			    } catch (Exception ex) {
			    	try { LoggerApi.severe(ex, "cid="+idClient+" ip="+SecurityUtils.getClientIp(request)); } catch (Exception e) {;}
			    }
				
				String userAPITokenizationCard = ConnectionFactory.operationProperty("user_api_tokenization_card", Constantes.contextSale);
				String passAPITokenizationCard = ConnectionFactory.operationProperty("pass_api_tokenization_card", Constantes.contextSale);
				String securityAPITokenizationCard = ConnectionFactory.operationProperty("security_api_tokenization_card", Constantes.contextSale);
				String sessionAPITokenizationCard = ConnectionFactory.operationProperty("session_api_tokenization_card", Constantes.contextSale);
				String merchantIdAPITokenizationCard = ConnectionFactory.operationProperty("merchant_id_api_tokenization_card", Constantes.contextSale);
							
				String credenciales = userAPITokenizationCard+":"+passAPITokenizationCard;
		    	credenciales = new BASE64Encoder().encode(credenciales.getBytes(Constantes.CHARSET_UTF8));
		    	URL urlSecurity = new URL(securityAPITokenizationCard);
		    	HttpsURLConnection  cnSecurity = (HttpsURLConnection )urlSecurity.openConnection();
		    	cnSecurity.setRequestMethod("GET");
		    	cnSecurity.setRequestProperty("Authorization", "Basic "+credenciales);
		    	cnSecurity.setSSLSocketFactory(new TSLSocketConnectionFactory());
		    	
		    	BufferedReader brSecurity = null;
		    	int responseCodeSecurity = cnSecurity.getResponseCode();
				if(responseCodeSecurity < HttpServletResponse.SC_BAD_REQUEST) {
					brSecurity = new BufferedReader(new InputStreamReader((cnSecurity.getInputStream()),Constantes.CHARSET_UTF8));
				}else {
					LoggerApi.Log.info("API Security HTTP CODE uuid="+uuid.toString()+": "+responseCodeSecurity+ " clientId:"+idClient);
					int transactionId = Constantes.generateTransactionId();
					String mensaje = Constantes.MSG_EXCEPTION+"<br><br>N� de operaci�n: V"+transactionId+"<br>"+sdfFront.format(new Date());
					o.addProperty("message", mensaje);
					registrarErrorVisa(new BigInteger(idClient+""), new BigInteger(transactionId+""), Constantes.PROCESS_SECURITY_API, Constantes.VACIO, Constantes.VACIO, 
							"API Security (createSessionTokenizationCardTa) HTTP CODE "+responseCodeSecurity, 
									Constantes.VACIO, Constantes.VACIO, Constantes.VACIO, Constantes.VACIO);
					brSecurity = new BufferedReader(new InputStreamReader((cnSecurity.getErrorStream()),Constantes.CHARSET_UTF8));
				}
						    		
		    	StringBuilder sbSecurity = new StringBuilder();
		    	char[] bufferSecurity = new char[1000];
	            int leidoSecurity;
	            while ((leidoSecurity = brSecurity.read(bufferSecurity)) > 0) {
	            	sbSecurity.append(new String(bufferSecurity, 0, leidoSecurity));
	            }
		    	brSecurity.close();
		    	
		    	String token = sbSecurity.toString();
		    	if(responseCodeSecurity < HttpServletResponse.SC_BAD_REQUEST) {
		    		URL urlSession = new URL(sessionAPITokenizationCard+merchantIdAPITokenizationCard);
		    		HttpsURLConnection  cnSession = (HttpsURLConnection )urlSession.openConnection();
		    		cnSession.setRequestMethod("POST");
		    		cnSession.setRequestProperty("Content-Type", Constantes.APPLICATION_JSON);
		    		cnSession.setRequestProperty("Accept", Constantes.APPLICATION_JSON);
		    		cnSession.setRequestProperty("Authorization", token);
		    		cnSession.setDoOutput(true);
		    		cnSession.setSSLSocketFactory(new TSLSocketConnectionFactory());
		    					    		
	        		Gson gson = new Gson();
	            	String jsonInputString = gson.toJson(new BodySessionKey("CID" + idClient + "@intralot.com.pe"));
	        		byte[] input = jsonInputString.getBytes(Constantes.CHARSET_UTF8);
	        		OutputStream os = cnSession.getOutputStream();
	        		os.write(input, 0, input.length); 
	        		os.flush();
	        		os.close();
	        		
	        		BufferedReader brSession = null;
	        		int responseCodeSession = cnSession.getResponseCode();
	        		if(responseCodeSession < HttpServletResponse.SC_BAD_REQUEST) {
	            		brSession = new BufferedReader(new InputStreamReader((cnSession.getInputStream()),Constantes.CHARSET_UTF8));
	            	}else {
	            		LoggerApi.Log.info("API Session HTTP CODE uuid="+uuid.toString()+": "+responseCodeSession+ " clientId:"+idClient);
						int transactionId = Constantes.generateTransactionId();
						String mensaje = Constantes.MSG_EXCEPTION+"<br><br>N� de operaci�n: V"+transactionId+"<br>"+sdfFront.format(new Date());
						o.addProperty("message", mensaje);
						registrarErrorVisa(new BigInteger(idClient+""), new BigInteger(transactionId+""), Constantes.PROCESS_SESSION_API, Constantes.VACIO, 
								Constantes.VACIO, "API Session (createSessionTokenizationCardTa) HTTP CODE "+responseCodeSession, 
										Constantes.VACIO, Constantes.VACIO, Constantes.VACIO, Constantes.VACIO);
	            		brSession = new BufferedReader(new InputStreamReader((cnSession.getErrorStream()),Constantes.CHARSET_UTF8));
	            	}	        		
	        		
		    		StringBuilder sbSession = new StringBuilder();
		    		char[] bufferSession = new char[1000];
	            	int leidoSession;
	            	while ((leidoSession = brSession.read(bufferSession)) > 0) {
	            		sbSession.append(new String(bufferSession, 0, leidoSession));
	            	}
		    		brSession.close();
		    		
		    		String jsonSessionKey = sbSession.toString();
		    		if(responseCodeSession < HttpServletResponse.SC_BAD_REQUEST) {
		    			PaymentPrizeProcedureGetDataCollectPrizes getDataCollectPrizes = paymentPrizeBo.getDataCollectPrizes(idClient);
		    			
		    			request.getSession().setAttribute("token", StringLib.encodeLabel(token));	 
		    			
				    		String baseUri = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
				    		
				    		o.addProperty("json", jsonSessionKey);
				    		o.addProperty("merchantid", merchantIdAPITokenizationCard);
				    		o.addProperty("purchasenumber", paymentPrizeBo.generateTokenPurchaseNumber());	    		
				    		o.addProperty("formbuttontext", "Confirmar");
				    		o.addProperty("merchantlogo", baseUri + "/layer-view-image/v2/TE_APUESTO_Logotipo_RGB_visa.png?v=1");
				    		o.addProperty("cardholdername", getDataCollectPrizes.getNombre().toLowerCase().replace("�", "a").replace("�", "e").replace("�", "i").replace("�", "o").replace("�", "u").replace("�", "a").replace("�", "e").replace("�", "i").replace("�", "o").replace("�", "u").replace("�", "a").replace("�", "e").replace("�", "i").replace("�", "o").replace("�", "u").replace("�", "n").replace("'", ""));
				    		o.addProperty("cardholderlastname", (getDataCollectPrizes.getApellidoPaterno() + ((getDataCollectPrizes.getApellidoMaterno() != null) ? " " + getDataCollectPrizes.getApellidoMaterno() : "")).toLowerCase().replace("�", "a").replace("�", "e").replace("�", "i").replace("�", "o").replace("�", "u").replace("�", "a").replace("�", "e").replace("�", "i").replace("�", "o").replace("�", "u").replace("�", "a").replace("�", "e").replace("�", "i").replace("�", "o").replace("�", "u").replace("�", "n").replace("'", ""));
				    		o.addProperty("cardholderemail", "CID" + idClient + "@intralot.com.pe");
				    		o.addProperty("userToken", "CID" + idClient + "@intralot.com.pe" );	    				
				    		o.addProperty("timeouturl", baseUri + "/client_price_show_information.html");
		        		o.addProperty("status", Constantes.RESULT_OK);
		    		}else {
	        			LoggerApi.Log.info("API Session RESPONSE uuid="+uuid.toString()+": "+jsonSessionKey + " clientId:"+idClient);
	        			o.addProperty("status", "ERROR");
		    		}
	    		}else {
	    			LoggerApi.Log.info("API Security RESPONSE uuid="+uuid.toString()+": "+token + " clientId:"+idClient);
	    			o.addProperty("status", "ERROR");
	    		}
				
	        	out.print(o);
			}catch (Exception e) {
				int transactionId = Constantes.generateTransactionId();
				String mensaje = Constantes.MSG_EXCEPTION+"<br><br>N� de operaci�n: I"+transactionId+"<br>"+sdfFront.format(new Date());
				o.addProperty("message", mensaje);
				o.addProperty("status", "ERROR");
				out.print(o);
				LoggerApi.severe(e,uuid.toString() + " mensaje: "+mensaje);
			}
			LoggerApi.Log.info("-------------- END createSessionTokenizationCardTa uuid="+uuid.toString());
	    }
	    
	    @RequestMapping(value = "/tokenizeCard")
	    public void tokenizeCard(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    	UUID uuid = UUID.randomUUID();
			LoggerApi.Log.info("-------------- START tokenizeCard uuid="+uuid.toString());
			TokenizeCardResponse tokenizeCardResponse = new TokenizeCardResponse();
			String prizetoken=request.getHeader("prizetoken");
			if(prizetoken==null || prizetoken.trim().isEmpty()) {
				prizetoken=request.getParameter("prizetoken");
			}
			String ipToken=SecurityUtils.getClientIp(request);	
			try {
				Integer idClient = null;
				ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
				tokenValidation = beanSecurityLoginBo.getTokenValidation(prizetoken, ipToken);
				if (tokenValidation.getStatus().equals("OK") && (tokenValidation.getMessage().equals("Validated") || tokenValidation.getMessage().equals("Show"))) {
					idClient = Integer.parseInt(tokenValidation.getClientId());
					LoggerApi.Log.info("-------------- tokenizeCard token idClient="+idClient);
				}	    		
	    		try {
	    			paymentPrizeBo.transactionRequestIp("MOBILE","tokenizeCard", ""+idClient, SecurityUtils.getClientIp(request), uuid.toString(), "VISA", "" );
    		    } catch (Exception ex) {
    		    	try { LoggerApi.severe(ex, "cid="+idClient+" ip="+SecurityUtils.getClientIp(request)); } catch (Exception e) {;}
    		    }
	    		
				String tokenizeAPITokenizationCard = ConnectionFactory.operationProperty("tokenize_api_tokenization_card", Constantes.contextSale);
				String merchantIdAPITokenizationCard = ConnectionFactory.operationProperty("merchant_id_api_tokenization_card", Constantes.contextSale);
				
		    	String securityToken = request.getSession().getAttribute("token").toString();
		    	String transactionToken = request.getParameter("transactionToken");

		    	URL url = new URL(tokenizeAPITokenizationCard+merchantIdAPITokenizationCard+"/"+transactionToken);
				HttpsURLConnection  con = (HttpsURLConnection )url.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("Content-Type", Constantes.APPLICATION_JSON);
				con.setRequestProperty("Accept", Constantes.APPLICATION_JSON);
				con.setRequestProperty("Authorization", StringLib.decodeLabel(securityToken));
				con.setSSLSocketFactory(new TSLSocketConnectionFactory());
				
				BufferedReader br = null;
				int responseCode = con.getResponseCode();
				if(responseCode==HttpServletResponse.SC_OK) {
					br = new BufferedReader(new InputStreamReader((con.getInputStream()),Constantes.CHARSET_UTF8));
				}else {
					LoggerApi.Log.info("API Token HTTP CODE uuid="+uuid.toString()+": "+responseCode+ " clientId:"+idClient);
					br = new BufferedReader(new InputStreamReader((con.getErrorStream()),Constantes.CHARSET_UTF8));
				}
				
				StringBuilder sb = new StringBuilder();
				char[] buffer = new char[1000];
		        int leido;
		        while ((leido = br.read(buffer)) > 0) {
		        	sb.append(new String(buffer, 0, leido));
		        }
				br.close();
				
				String tokenizacion = sb.toString();
				if(responseCode >= HttpServletResponse.SC_BAD_REQUEST) {
					LoggerApi.Log.info("API Token RESPONSE uuid="+uuid.toString()+": "+tokenizacion+ " clientId:"+idClient);
				}
				
				Gson gson = new Gson();
				try { tokenizeCardResponse = gson.fromJson(tokenizacion, TokenizeCardResponse.class); } catch (Exception e) { }  
				tokenizeCardResponse.setJson(tokenizacion);
				tokenizeCardResponse.setHttpCode(responseCode);
 
				Object[] values = new Object[3];
				values[0] = idClient;
				values[1] = StringLib.encodeLabel(tokenizacion);
				values[2] = "MOBILE";
				paymentPrizeBo.updateTokenCard(values);
			} catch (Exception e) {
				LoggerApi.severe(e,uuid.toString());
			}
			LoggerApi.Log.info("-------------- END tokenizeCard uuid="+uuid.toString());
	    }
	    
	    @RequestMapping(value = "/tokenizeCardAgora")
	    public void tokenizeCardAgora(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    	UUID uuid = UUID.randomUUID();
			LoggerApi.Log.info("-------------- START tokenizeCardAgora uuid="+uuid.toString());
			TokenizeCardResponse tokenizeCardResponse = new TokenizeCardResponse();
			
			String prizetoken=request.getHeader("prizetoken");
			if(prizetoken==null || prizetoken.trim().isEmpty()) {
				prizetoken=request.getParameter("prizetoken");
			}
			String ipToken=SecurityUtils.getClientIp(request);	
			try {
				Integer idClient = null;
				ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
				tokenValidation = beanSecurityLoginBo.getTokenValidation(prizetoken, ipToken);
				if (tokenValidation.getStatus().equals("OK") && (tokenValidation.getMessage().equals("Validated") || tokenValidation.getMessage().equals("Show"))) {
					idClient = Integer.parseInt(tokenValidation.getClientId());
					LoggerApi.Log.info("-------------- tokenizeCardAgora token idClient="+idClient);
				}
				
	    		try {
	    			paymentPrizeBo.transactionRequestIp("MOBILE","tokenizeCardAgora", ""+idClient, SecurityUtils.getClientIp(request), uuid.toString(), "AGORA", "" );
    		    } catch (Exception ex) {
    		    	try { LoggerApi.severe(ex, "cid="+idClient+" ip="+SecurityUtils.getClientIp(request)); } catch (Exception e) {;}
    		    }
	    		
				String tokenizeAPITokenizationCard = ConnectionFactory.operationProperty("tokenize_api_tokenization_card", Constantes.contextSale);
				String merchantIdAPITokenizationCard = ConnectionFactory.operationProperty("merchant_id_api_tokenization_card", Constantes.contextSale);
				
		    	String securityToken = request.getSession().getAttribute("token").toString();
		    	String transactionToken = request.getParameter("transactionToken");

		    	URL url = new URL(tokenizeAPITokenizationCard+merchantIdAPITokenizationCard+"/"+transactionToken);
				HttpsURLConnection  con = (HttpsURLConnection )url.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("Content-Type", Constantes.APPLICATION_JSON);
				con.setRequestProperty("Accept", Constantes.APPLICATION_JSON);
				con.setRequestProperty("Authorization", StringLib.decodeLabel(securityToken));
				con.setSSLSocketFactory(new TSLSocketConnectionFactory());
				
				BufferedReader br = null;
				int responseCode = con.getResponseCode();
				if(responseCode==HttpServletResponse.SC_OK) {
					br = new BufferedReader(new InputStreamReader((con.getInputStream()),Constantes.CHARSET_UTF8));
				}else {
					LoggerApi.Log.info("API Token HTTP CODE uuid="+uuid.toString()+": "+responseCode+ " clientId:"+idClient);
					br = new BufferedReader(new InputStreamReader((con.getErrorStream()),Constantes.CHARSET_UTF8));
				}
				
				StringBuilder sb = new StringBuilder();
				char[] buffer = new char[1000];
		        int leido;
		        while ((leido = br.read(buffer)) > 0) {
		        	sb.append(new String(buffer, 0, leido));
		        }
				br.close();
				
				String tokenizacion = sb.toString();
				if(responseCode >= HttpServletResponse.SC_BAD_REQUEST) {
					LoggerApi.Log.info("API Token RESPONSE uuid="+uuid.toString()+": "+tokenizacion+ " clientId:"+idClient);	
				}
				
				Gson gson = new Gson();
				try { tokenizeCardResponse = gson.fromJson(tokenizacion, TokenizeCardResponse.class); } catch (Exception e) { }  
				tokenizeCardResponse.setJson(tokenizacion);
				tokenizeCardResponse.setHttpCode(responseCode);
 
				Object[] values = new Object[3];
				values[0] = idClient;
				values[1] = StringLib.encodeLabel(tokenizacion);
				values[2] = "MOBILE";
				paymentPrizeBo.updateTokenCard(values);
			} catch (Exception e) {
				LoggerApi.severe(e,uuid.toString());
			}
			LoggerApi.Log.info("-------------- END tokenizeCardAgora uuid="+uuid.toString());
	    }

		@RequestMapping(value = "/getTokenizedCard")
		public void getTokenizedCard(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    	UUID uuid = UUID.randomUUID();
			LoggerApi.Log.info("-------------- START getTokenizedCard uuid="+uuid.toString());
			response.setCharacterEncoding(Constantes.CHARSET_UTF8);
	    	PrintWriter out = response.getWriter();
	        JsonObject o = new JsonObject();
			String prizetoken=request.getHeader("prizetoken");
			String ipToken=SecurityUtils.getClientIp(request);	
			try {
				Integer idClient = null;
				ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
				tokenValidation = beanSecurityLoginBo.getTokenValidation(prizetoken, ipToken);
				if (tokenValidation.getStatus().equals("OK") && (tokenValidation.getMessage().equals("Validated") || tokenValidation.getMessage().equals("Show"))) {
					idClient = Integer.parseInt(tokenValidation.getClientId());
					o.addProperty("prizetoken", tokenValidation.getRechargeToken());
					LoggerApi.Log.info("-------------- getTokenizedCard token idClient="+idClient);
				}
				
				Object[] values = new Object[2];
				values[0] = idClient;
				values[1] = "MOBILE";
				PaymentPrizeProcedureGetTokenCard getTokenCard=paymentPrizeBo.getTokenCard(values);
				TokenizeCardResponse tokenizeCardResponse = gson.fromJson(StringLib.decodeLabel(getTokenCard.getVisaTokenResponse()), TokenizeCardResponse.class);
								
				if(tokenizeCardResponse!=null && tokenizeCardResponse.getErrorCode()!=null && tokenizeCardResponse.getErrorMessage()!=null && 
						tokenizeCardResponse.getOrder()!=null && tokenizeCardResponse.getOrder().getActionCode()!=null && 
						tokenizeCardResponse.getErrorCode().toString().equals("0") && tokenizeCardResponse.getErrorMessage().equals("OK") && 
						tokenizeCardResponse.getOrder().getActionCode().equals("000")) {
					o.addProperty("cardNumber", tokenizeCardResponse.getCard()!=null?tokenizeCardResponse.getCard().getCardNumber():"");
					o.addProperty("status", Constantes.RESULT_OK);
				}else {
					String purchaseNumber = Constantes.VACIO;
    				String actionCode = Constantes.VACIO;
    				String actionDescription = Constantes.VACIO;
    				String errorCode = Constantes.VACIO;
    				String errorMessage = Constantes.VACIO;
					errorCode = tokenizeCardResponse.getErrorCode()!=null?tokenizeCardResponse.getErrorCode().toString().trim():Constantes.VACIO;
					errorMessage = tokenizeCardResponse.getErrorMessage()!=null?tokenizeCardResponse.getErrorMessage().toString().trim():Constantes.VACIO;
    				if(tokenizeCardResponse.getOrder()!=null) {
    					Order order = tokenizeCardResponse.getOrder();
    					purchaseNumber = order.getPurchaseNumber()!=null?order.getPurchaseNumber().trim():Constantes.VACIO;
    					actionCode = order.getActionCode()!=null?order.getActionCode().trim():Constantes.VACIO;
    					actionDescription = order.getActionDescription()!=null?order.getActionDescription().trim():Constantes.VACIO;
    				}
					int transactionId = Constantes.generateTransactionId();
					String mensaje = Constantes.MSG_EXCEPTION+"<br><br>N� de operaci�n: V"+transactionId+"<br>"+sdfFront.format(new Date());
					o.addProperty("message", mensaje);
					o.addProperty("status", "ERROR");
					registrarErrorVisa(new BigInteger(idClient+""), new BigInteger(transactionId+""), Constantes.PROCESS_TOKEN_API, 
							Constantes.VACIO, purchaseNumber, tokenizeCardResponse.getJson()+"| HTTP CODE "+tokenizeCardResponse.getHttpCode(), 
							errorCode, errorMessage, actionCode, actionDescription);
					
					String ip=SecurityUtils.getClientIp(request);
					Object[] valuesRegisterErrorCA = new Object[8];
					valuesRegisterErrorCA[0] = idClient;
					valuesRegisterErrorCA[1] = ip;
					valuesRegisterErrorCA[2] = "MOBILE";
					valuesRegisterErrorCA[3] = "ECOMMERCE";
					valuesRegisterErrorCA[4] = "RETIRO";
					valuesRegisterErrorCA[5] = "NIUBIZ";
					valuesRegisterErrorCA[6] = actionCode;
					valuesRegisterErrorCA[7] = actionDescription;
					PaymentPrizeProcedureRegisterErrorCA registerErrorCA = paymentPrizeBo.registerErrorCA(valuesRegisterErrorCA);
					if(registerErrorCA!=null && registerErrorCA.getState()!=null && registerErrorCA.getState().equals("BAN")) {
						Object[] valuesRegisterTYCPDPLog = new Object[10];
						valuesRegisterTYCPDPLog[0] = idClient;
						valuesRegisterTYCPDPLog[1] = "PRE";
						valuesRegisterTYCPDPLog[2] = "BO";
						valuesRegisterTYCPDPLog[3] = ip;
						valuesRegisterTYCPDPLog[4] = "MOBILE";
						valuesRegisterTYCPDPLog[5] = "ECOMMERCE";
						valuesRegisterTYCPDPLog[6] = "RETIRO";
						valuesRegisterTYCPDPLog[7] = "NIUBIZ";
						valuesRegisterTYCPDPLog[8] = actionCode;
						valuesRegisterTYCPDPLog[9] = actionDescription;
						paymentPrizeBo.registerTYCPDPLog(valuesRegisterTYCPDPLog);
						o.addProperty("ban", "OK");
						
						String body ="<html>" + 
								"<head>" + 
								"<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>" + 
								"</head>" + 
								"<body leftmargin='0' topmargin='0' marginwidth='0' marginheight='0'>" + 
								"<p>ID de cliente: " + idClient+
								"<br>Metodo: Retiro"+
								"<br>Medio: Niubiz"+
								"<br>Monto: "+
								"</p>"+ 
								"</body>" + 
								"</html>";
						try {
							MailLib.sendValidMail(ConnectionFactory.operationProperty("mailSourceApp", Constantes.contextSale), "LA TINKA", ConnectionFactory.operationProperty("mailTargetAntifraudeRetiro", Constantes.contextSale),"Alerta de fraude", body, Constantes.FORMAT_HTML_UTF8, null, null, null, null);
						}catch (Exception e) {
							LoggerApi.severe(e);
						}
					}else {
						o.addProperty("ban", "KO");
					}
				}
			} catch (Exception e) {
				int transactionId = Constantes.generateTransactionId();
				String mensaje = Constantes.MSG_EXCEPTION+"<br><br>N� de operaci�n: I"+transactionId+"<br>"+sdfFront.format(new Date());
				o.addProperty("message", mensaje);
				o.addProperty("status", "ERROR");
				LoggerApi.severe(e,uuid.toString()+ " mensaje: "+mensaje);
			}
			out.print(o);
			LoggerApi.Log.info("-------------- END getTokenizedCard uuid="+uuid.toString());
		}
		
		@RequestMapping(value = "/getTokenizedCardAgora")
		public void getTokenizedCardAgora(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    	UUID uuid = UUID.randomUUID();
			LoggerApi.Log.info("-------------- START getTokenizedCardAgora uuid="+uuid.toString());
			response.setCharacterEncoding(Constantes.CHARSET_UTF8);
	    	PrintWriter out = response.getWriter();
	        JsonObject o = new JsonObject();
	        String prizetoken=request.getHeader("prizetoken");
			String ipToken=SecurityUtils.getClientIp(request);	
			try {
				Integer idClient = null;
				ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
				tokenValidation = beanSecurityLoginBo.getTokenValidation(prizetoken, ipToken);
				if (tokenValidation.getStatus().equals("OK") && (tokenValidation.getMessage().equals("Validated") || tokenValidation.getMessage().equals("Show"))) {
					idClient = Integer.parseInt(tokenValidation.getClientId());
					o.addProperty("prizetoken", tokenValidation.getRechargeToken());
					LoggerApi.Log.info("-------------- getTokenizedCardAgora token idClient="+idClient);
				}
				
				Object[] values = new Object[2];
				values[0] = idClient;
				values[1] = "MOBILE";
				PaymentPrizeProcedureGetTokenCard getTokenCard=paymentPrizeBo.getTokenCard(values);
				TokenizeCardResponse tokenizeCardResponse = gson.fromJson(StringLib.decodeLabel(getTokenCard.getVisaTokenResponse()), TokenizeCardResponse.class);

				if(tokenizeCardResponse!=null && tokenizeCardResponse.getErrorCode()!=null && tokenizeCardResponse.getErrorMessage()!=null && 
						tokenizeCardResponse.getOrder()!=null && tokenizeCardResponse.getOrder().getActionCode()!=null && 
						tokenizeCardResponse.getErrorCode().toString().equals("0") && tokenizeCardResponse.getErrorMessage().equals("OK") && 
						tokenizeCardResponse.getOrder().getActionCode().equals("000")) {
					o.addProperty("cardNumber", tokenizeCardResponse.getCard()!=null?tokenizeCardResponse.getCard().getCardNumber():"");
					o.addProperty("status", Constantes.RESULT_OK);
				}else {
					String purchaseNumber = Constantes.VACIO;
    				String actionCode = Constantes.VACIO;
    				String actionDescription = Constantes.VACIO;
    				String errorCode = Constantes.VACIO;
    				String errorMessage = Constantes.VACIO;
					errorCode = tokenizeCardResponse.getErrorCode()!=null?tokenizeCardResponse.getErrorCode().toString().trim():Constantes.VACIO;
					errorMessage = tokenizeCardResponse.getErrorMessage()!=null?tokenizeCardResponse.getErrorMessage().toString().trim():Constantes.VACIO;
    				if(tokenizeCardResponse.getOrder()!=null) {
    					Order order = tokenizeCardResponse.getOrder();
    					purchaseNumber = order.getPurchaseNumber()!=null?order.getPurchaseNumber().trim():Constantes.VACIO;
    					actionCode = order.getActionCode()!=null?order.getActionCode().trim():Constantes.VACIO;
    					actionDescription = order.getActionDescription()!=null?order.getActionDescription().trim():Constantes.VACIO;
    				}
					int transactionId = Constantes.generateTransactionId();
					String mensaje = Constantes.MSG_EXCEPTION+"<br><br>N� de operaci�n: V"+transactionId+"<br>"+sdfFront.format(new Date());
					o.addProperty("message", mensaje);
					o.addProperty("status", "ERROR");
					registrarErrorVisa(new BigInteger(idClient+""), new BigInteger(transactionId+""), Constantes.PROCESS_TOKEN_API, 
							Constantes.VACIO, purchaseNumber, tokenizeCardResponse.getJson()+"| HTTP CODE "+tokenizeCardResponse.getHttpCode(), 
							errorCode, errorMessage, actionCode, actionDescription);
				}
			} catch (Exception e) {
				int transactionId = Constantes.generateTransactionId();
				String mensaje = Constantes.MSG_EXCEPTION+"<br><br>N� de operaci�n: I"+transactionId+"<br>"+sdfFront.format(new Date());
				o.addProperty("message", mensaje);
				o.addProperty("status", "ERROR");
				LoggerApi.severe(e,uuid.toString()+ " mensaje: "+mensaje);
			}
			out.print(o);
			LoggerApi.Log.info("-------------- END getTokenizedCardAgora uuid="+uuid.toString());
		}

		@RequestMapping(value = "/createRequestVisa")
		public void createRequestVisa(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
				throws Exception {
			UUID uuid = UUID.randomUUID();
			LoggerApi.Log.info("-------------- START createRequestVisa uuid="+uuid.toString());
			response.setCharacterEncoding(Constantes.CHARSET_UTF8);
			PrintWriter out = response.getWriter();
			JsonObject o = new JsonObject();
			o.addProperty("paymentType", "VISA");
			Gson gson = new Gson();
			TransactionPaymentToken paymentSession = null;
			String prizetoken=request.getHeader("prizetoken");
	        String ipToken=SecurityUtils.getClientIp(request);	
			try {				
				Integer idClient = null;
				ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
				tokenValidation = beanSecurityLoginBo.getTokenValidation(prizetoken, ipToken);
				if (tokenValidation.getStatus().equals("OK") && (tokenValidation.getMessage().equals("Validated") || tokenValidation.getMessage().equals("Show"))) {
					idClient = Integer.parseInt(tokenValidation.getClientId());
					o.addProperty("prizetoken", tokenValidation.getRechargeToken());
					LoggerApi.Log.info("-------------- createRequestVisa token idClient="+idClient);
				}
				Double amountVisa = Double.parseDouble(request.getParameter("amountVisa"));
				
				TransactionPaymentLogPin sessionPin = null;
				String resultPin = "";
				
				String amount = request.getParameter("amount")!=null?request.getParameter("amount"):"";	
				String paymentType = request.getParameter("paymentType")!=null?request.getParameter("paymentType"):"";
				String pinUuid = request.getParameter("pinUuid")!=null?request.getParameter("pinUuid"):"";
				paymentSession = new TransactionPaymentToken();
				paymentSession.setChannel(Constantes.PLATAFORM);
				paymentSession.setClientId(idClient.toString());
				paymentSession.setClientIp(ipToken);
				paymentSession.setPinUuid(pinUuid);
				paymentSession.setType(paymentType);
				paymentSession.setAmount(amount);
				
				String statusPin = request.getParameter("statusPin")!=null?request.getParameter("statusPin"):"";
				if ( statusPin.equals("OK") ) {
					resultPin = "OK";
					LoggerApi.Log.info(uuid.toString()+" PIN ok");
					try { sessionPin = paymentPrizeBo.transactionLogPin(paymentSession.getChannel(), "createRequestVisa", paymentSession.getClientId(), paymentSession.getClientIp(), paymentSession.getPinUuid(), paymentSession.getType(), paymentSession.getAmount(), paymentSession.getValidatePinStatus(), resultPin);
					} catch (Exception e) {
						LoggerApi.severe(e, "sessionPin="+sessionPin);			
					}
				} else {
					resultPin = "PIN NO VALIDO!!! "+ paymentSession.getValidatePinStatus();
					LoggerApi.Log.info(uuid.toString()+" "+resultPin);
					try { sessionPin = paymentPrizeBo.transactionLogPin(paymentSession.getChannel(), "createRequestVisa", paymentSession.getClientId(), paymentSession.getClientIp(), paymentSession.getPinUuid(), paymentSession.getType(), paymentSession.getAmount(), paymentSession.getValidatePinStatus(), resultPin);
					} catch (Exception e) {
						LoggerApi.severe(e, "sessionPin="+sessionPin);			
					}
					throw new Exception(resultPin);
				}
	    		
	    		try {
	    			paymentPrizeBo.transactionRequestIp("MOBILE","createRequestVisa", idClient.toString(), SecurityUtils.getClientIp(request), paymentSession.getPinUuid(), "VISA", ""+amountVisa );
    		    } catch (Exception ex) {
    		    	try { LoggerApi.severe(ex, "cid="+idClient+" ip="+SecurityUtils.getClientIp(request)); } catch (Exception e) {;}
    		    }
					
				String imgDNI = request.getParameter("imgDNI")!=null?request.getParameter("imgDNI"):"";
				String kycResult = request.getParameter("kycResult")!=null?request.getParameter("kycResult"):"";
				PaymentPrizeProcedureGetDataCollectPrizes paymentPrizeProcedureGetDataCollectPrizes = paymentPrizeBo
						.getDataCollectPrizes(idClient);
				Double saldoLiquidable = paymentPrizeProcedureGetDataCollectPrizes.getSaldoLiquidable();
				Double billetera1 = paymentPrizeProcedureGetDataCollectPrizes.getBalanceAmount();
				
				String flujoDocumento = paymentPrizeProcedureGetDataCollectPrizes.getRequiredKycVisa()!=null?paymentPrizeProcedureGetDataCollectPrizes.getRequiredKycVisa():"";
				
				LoggerApi.Log.info("sigue flujoDNI:" + flujoDocumento);
				if(amountVisa>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRequestVisa() && amountVisa<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxRequestVisa()) {				
					PaymentPrizeProcedureGetResultEvalRulesVisa paymentPrizeProcedureGetResultEvalRulesVisa = paymentPrizeBo.getResultEvalRulesVisa(idClient,amountVisa);
					int accAmtVisa = paymentPrizeProcedureGetResultEvalRulesVisa.getAccAmtVisa().intValue();
					if(paymentPrizeProcedureGetResultEvalRulesVisa.getResult().trim().equals(Constantes.RESULT_OK)) {
						String loadedImage = Constantes.LOADED_IMAGE_NO;
						if (saldoLiquidable == 0) {
							o.addProperty("status", "ERROR_MONTO");
							o.addProperty("message", Constantes.MSG_NO_CREDIT);
						} else if (amountVisa > saldoLiquidable) {
							o.addProperty("status", "ERROR_MONTO");
							o.addProperty("message", Constantes.MSG_NO_CREDIT_SUFICENT);
						} else if (flujoDocumento.equalsIgnoreCase("ACTIVO") && kycResult.trim().isEmpty() && amountVisa >= paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRequiredKycVisa().intValue() ) { // validar si es flujo KYC o DNI
							o.addProperty("status", "ERROR_DNI");
							o.addProperty("message", Constantes.MSG_DNI_NOT_LOADED);
						} else if (!flujoDocumento.equalsIgnoreCase("ACTIVO") && !paymentPrizeProcedureGetDataCollectPrizes.getStateDni().equals(Constantes.DNI_STATE_ACTIVE)&& imgDNI.trim().isEmpty()&& (amountVisa >= paymentPrizeProcedureGetDataCollectPrizes.getAmountMinEnableDni().intValue()|| (amountVisa + accAmtVisa) >= paymentPrizeProcedureGetDataCollectPrizes.getMinAccAmtEnblDniVisa()) ) {
							o.addProperty("status", "ERROR_DNI");
							o.addProperty("message", Constantes.MSG_DNI_NOT_LOADED);
						}else {
							
							double comision = 0;
							boolean errorComision = false;
							if(amountVisa>=paymentPrizeProcedureGetDataCollectPrizes.getComMinRan1Visa() && amountVisa<=paymentPrizeProcedureGetDataCollectPrizes.getComMaxRan1Visa()){
								comision=paymentPrizeProcedureGetDataCollectPrizes.getComAmtRan1Visa();
							}else if(amountVisa>=paymentPrizeProcedureGetDataCollectPrizes.getComMinRan2Visa() && amountVisa<=paymentPrizeProcedureGetDataCollectPrizes.getComMaxRan2Visa()){
								comision=paymentPrizeProcedureGetDataCollectPrizes.getComAmtRan2Visa();
							}else if(amountVisa>=paymentPrizeProcedureGetDataCollectPrizes.getComMinRan3Visa() && amountVisa<=paymentPrizeProcedureGetDataCollectPrizes.getComMaxRan3Visa()){
								comision=paymentPrizeProcedureGetDataCollectPrizes.getComAmtRan3Visa();
							}else if(amountVisa>=paymentPrizeProcedureGetDataCollectPrizes.getComMinRan4Visa() && amountVisa<=paymentPrizeProcedureGetDataCollectPrizes.getComMaxRan4Visa()){
								comision=paymentPrizeProcedureGetDataCollectPrizes.getComAmtRan4Visa();
							}
							
							String mensajeComision = "";
							if(comision>0) {
								mensajeComision=Constantes.MSG_COMMISSION+intralotUtils.formatCurrency(comision);
								if((amountVisa+comision)>billetera1) {
									errorComision=true;
									o.addProperty("status", "ERRO_COMISION");
									o.addProperty("message", paymentPrizeProcedureGetDataCollectPrizes.getMsjComDenVisa().replace("XXX", intralotUtils.formatCurrency(comision)));
								}
							}
							
						boolean errorDocumento = true;
						if (flujoDocumento.equalsIgnoreCase("ACTIVO")) {
							boolean errorKyc = true;
							if (!kycResult.trim().isEmpty() && (kycResult.equals("verified")
									|| kycResult.equals("rejected") || kycResult.equals("reviewNeeded"))) {
								errorKyc = false;
							}
							errorDocumento = errorKyc;
						} else {
								 LoggerApi.Log.info("imgDNI visa" +imgDNI);
							boolean errorDNI = false;
							Double peso = 0.0;
							if(amountVisa>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinEnableDni().intValue() ||
								(amountVisa+accAmtVisa)>=paymentPrizeProcedureGetDataCollectPrizes.getMinAccAmtEnblDniVisa() ) {
								BASE64Decoder decoder = new BASE64Decoder();
								byte[] decodedBytes = decoder.decodeBuffer(imgDNI.replace("data:image/png;base64,", "").replace("data:image/jpeg;base64,", ""));
								peso = (double) decodedBytes.length;
								if( (peso/1024/1024)<=paymentPrizeProcedureGetDataCollectPrizes.getMaxMbPerImageVisa().intValue()) {
									if(!imgDNI.trim().isEmpty()) {
										loadedImage=Constantes.LOADED_IMAGE_YES;
										try {
											ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
											BufferedImage image = ImageIO.read(bis);
									        bis.close();
									        if(image==null) {
									        	errorDNI = true;
												o.addProperty("status", "ERROR_DNI");
												o.addProperty("message", Constantes.MSG_DNI_NOT_VALID);
									        }
										} catch (Exception e) {
											
										} catch (OutOfMemoryError e) {
											MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
								            MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
								            long maxMemory = heapUsage.getMax() / (1024*1024);
								            long usedMemory = heapUsage.getUsed() / (1024*1024);
								            LoggerApi.Log.info("Memory Use :" + usedMemory + "M/" + maxMemory + "M");
								        }
									}							    
								}else {
									errorDNI = true;
									o.addProperty("status", "ERROR_DNI");
									o.addProperty("message", Constantes.MSG_DNI_LIMIT_MB+paymentPrizeProcedureGetDataCollectPrizes.getMaxMbPerImageVisa().intValue()+Constantes.MB);
								}
							}
							errorDocumento=errorDNI;
							}
							
						LoggerApi.Log.info("visa errorDocumento:" + errorDocumento);
						if(!errorDocumento&& !errorComision) {
								String ip = request.getRemoteAddr();								
								Object[] valuesTC = new Object[2];
								valuesTC[0] = idClient;
								valuesTC[1] = "MOBILE";
								PaymentPrizeProcedureGetTokenCard getTokenCard=paymentPrizeBo.getTokenCard(valuesTC);
								TokenizeCardResponse tokenizeCardResponse = gson.fromJson(StringLib.decodeLabel(getTokenCard.getVisaTokenResponse()), TokenizeCardResponse.class);
								//reglas pp automatico
								boolean flagEvalRulesAutomatic=false;
								String whiteList = paymentPrizeProcedureGetDataCollectPrizes.getWhiteList();
							/*	if(!whiteList.trim().equalsIgnoreCase("ACT")) {
									LoggerApi.Log.info("is white list ->:"+whiteList);
									if(amountVisa<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxAutomaticVisa()) {
										//PaymentPrizeProcedureEvalRulesAutomatic objEvalRulesAutomatic=paymentPrizeBo.evalRulesAutomatic(clientId);
										PaymentPrizeProcedureEvalRulesAutomaticV2 objEvalRulesAutomatic=paymentPrizeBo.evalRulesAutomaticV2(clientId,Constantes.TYPE_PAYMENT_VISA);
										if(objEvalRulesAutomatic!=null && objEvalRulesAutomatic.getResult().trim().equals(Constantes.RESULT_OK)) {
											flagEvalRulesAutomatic=true;
										}
									}
								}else {
									flagEvalRulesAutomatic=true;
								}*/
											
								if(amountVisa<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxAutomaticVisa()) {
									PaymentPrizeProcedureEvalRulesAutomaticV2 objEvalRulesAutomatic=paymentPrizeBo.evalRulesAutomaticV2(idClient,Constantes.TYPE_PAYMENT_VISA);
									if(objEvalRulesAutomatic!=null && objEvalRulesAutomatic.getResult().trim().equals(Constantes.RESULT_OK)) {
										flagEvalRulesAutomatic=true;
									}
								}

								if(flagEvalRulesAutomatic == false) {
									if(whiteList.trim().equalsIgnoreCase("ACT")) {
										flagEvalRulesAutomatic=true;
									}
								}
								LoggerApi.Log.info("createRequestVisa ->flagEvalRulesAutomatic:"+flagEvalRulesAutomatic);
								LoggerApi.Log.info("is white list ->:"+whiteList);

								//if(amountVisa>paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxAutomaticVisa() && flagEvalRulesAutomatic==false) {
								  if(flagEvalRulesAutomatic==false) {
									LoggerApi.Log.info("createRequestVisaManual");
									PaymentPrizeProcedureCreateRequestVisa result = paymentPrizeBo.createRequestVisa(idClient.toString(),
											amountVisa, ip, Constantes.TYPE_PAYMENT_VISA, Constantes.PLATAFORM, StringLib.encodeLabel(tokenizeCardResponse.getToken().getTokenId()),
											StringLib.encodeLabel(tokenizeCardResponse.getCard().getCardNumber()),tokenizeCardResponse.getOrder().getTransactionId(),StringLib.encodeLabel(gson.toJson(tokenizeCardResponse)), 
											imgDNI, loadedImage, comision);
									if (result.getMessage() != null && result.getMessage().trim().equalsIgnoreCase(Constantes.RESULT_OK)) {
										Double newSaldoLiquidable = result.getNewSaldoLiquidable();
										paymentPrizeProcedureGetDataCollectPrizes.setSaldoLiquidable(newSaldoLiquidable);								
										o.addProperty("saldoLiquidable", paymentPrizeProcedureGetDataCollectPrizes.getSaldoLiquidable());	
										/*
										if(peso>0 || paymentPrizeProcedureGetDataCollectPrizes.getStateDni().trim().equals("ACT")	) {
											paymentPrizeProcedureGetDataCollectPrizes.setStateDni("ACT");
											o.addProperty("stateDni", "ACT");
										}else {
											paymentPrizeProcedureGetDataCollectPrizes.setStateDni("PEN");
											o.addProperty("stateDni", "PEN");
										}*/
									}
				
									o.addProperty("message", result.getMessage());
									o.addProperty("amount", result.getAmount());
									o.addProperty("requestNumber", result.getRequestNumber());
									o.addProperty("status", Constantes.RESULT_OK);
									o.addProperty("messageSuccess", Constantes.MSG_SUCCESS_REQUEST_VISA+mensajeComision);
									o.addProperty("evaluacion", "MANUAL");
								}else {
									//flujo aprobacion automatica
									//crear solicitud para retener dinero
									PaymentPrizeProcedureInBlackList paymentPrizeProcedureInBlackList = paymentPrizeBo.inBlackList(idClient);
									if(paymentPrizeProcedureInBlackList.getResult()!=null && paymentPrizeProcedureInBlackList.getResult().trim().equals(Constantes.BLACKLIST_INACTIVE) && flagEvalRulesAutomatic==true  ) {
										String mensaje = "";
										PaymentPrizeProcedureCreateRequestVisaAutomatic result = paymentPrizeBo.createRequestVisaAutomatic(idClient.toString(),
												amountVisa, ip, Constantes.TYPE_PAYMENT_VISA, Constantes.PLATAFORM, StringLib.encodeLabel(tokenizeCardResponse.getToken().getTokenId()),
												StringLib.encodeLabel(tokenizeCardResponse.getCard().getCardNumber()),tokenizeCardResponse.getOrder().getTransactionId(),StringLib.encodeLabel(gson.toJson(tokenizeCardResponse)), 
												imgDNI, loadedImage, comision);
										LoggerApi.Log.info("createRequestVisaAutomatic");
										//si se pudo crear solicitud
										if (result.getMessage() != null && result.getMessage().trim().equalsIgnoreCase(Constantes.RESULT_OK)) {
											//call fd
											LoggerApi.Log.info("createRequestVisaAutomatic: " +  "clientId: " + idClient.toString() + " message: " + result.getMessage() + " amount: " + result.getAmount() + " requestNumber: " + result.getRequestNumber().toString());	
								    		String purchaseNumberFD = Constantes.generatePurchaseNumberFD();
											FundsDisbursementsResponse objFD = dispersionFondo(amountVisa.toString(), tokenizeCardResponse.getToken().getTokenId(), idClient.toString(), paymentPrizeProcedureGetDataCollectPrizes.getNombre(), paymentPrizeProcedureGetDataCollectPrizes.getApellidoPaterno(), result.getRequestNumber().toString(), purchaseNumberFD, uuid);
								    		//si se realizo la fd
											if(objFD!=null && objFD.getResponseCode()!=null && objFD.getResponseCode().trim().equalsIgnoreCase(HttpServletResponse.SC_OK+"")) {
												LoggerApi.Log.info("dispersionFondo responseCode=" + objFD.getResponseCode() + " clientId=" + idClient.toString() + " requestNumber: " + result.getRequestNumber());
												//Double newSaldoLiquidable = saldoLiquidable - result.getAmount();
												Double newSaldoLiquidable = result.getNewSaldoLiquidable();
												paymentPrizeProcedureGetDataCollectPrizes.setSaldoLiquidable(newSaldoLiquidable);								
												o.addProperty("saldoLiquidable", paymentPrizeProcedureGetDataCollectPrizes.getSaldoLiquidable());
												/*
												if(peso>0 || paymentPrizeProcedureGetDataCollectPrizes.getStateDni().trim().equals("ACT")	) {
													paymentPrizeProcedureGetDataCollectPrizes.setStateDni("ACT");
													o.addProperty("stateDni", "ACT");
												}else {
													paymentPrizeProcedureGetDataCollectPrizes.setStateDni("PEN");
													o.addProperty("stateDni", "PEN");
												}*/												
												//registrar fd										
												Object[] values = new Object[25];
												values[0] = result.getRequestNumber();
												values[1] = "AUTO";
												values[2] = Constantes.ESPACIO_VACIO;
												values[3] = "AUTO";				
												values[4] = objFD.getHeader()!=null?objFD.getHeader().getEcoreTransactionUUID():"";
												values[5] = objFD.getHeader()!=null?objFD.getHeader().getEcoreTransactionDate():"";
												values[6] = objFD.getHeader()!=null?objFD.getHeader().getMillis():"";
												values[7] = objFD.getResponseCode()!=null?objFD.getResponseCode():"";
												values[8] = objFD.getResponseMessage()!=null?objFD.getResponseMessage():"";
												values[9] = objFD.getOrder()!=null?objFD.getOrder().getPurchaseNumber():"";
												values[10] = objFD.getOrder()!=null?Double.parseDouble(objFD.getOrder().getAmount()):0;
												values[11] = objFD.getOrder()!=null?objFD.getOrder().getCurrency():"";
												values[12] = objFD.getOrder()!=null?objFD.getOrder().getExternalTransactionId():"";
												values[13] = objFD.getOrder()!=null?objFD.getOrder().getStatusIdentifier():"";
												values[14] = objFD.getOrder()!=null?objFD.getOrder().getTransactionIdentifier():"";
												values[15] = objFD.getOrder()!=null?objFD.getOrder().getRetrievalReferenceNumber():"";
												values[16] = objFD.getOrder()!=null?objFD.getOrder().getActionCode():"";
												values[17] = objFD.getOrder()!=null?objFD.getOrder().getApprovalCode():"";
												values[18] = objFD.getOrder()!=null?objFD.getOrder().getResponseCode():"";
												values[19] = objFD.getOrder()!=null?objFD.getOrder().getTransmissionDateTime():"";
												values[20] = objFD.getDataMap()!=null?objFD.getDataMap().getComisionVisanet():0;
												values[21] = objFD.getDataMap()!=null?objFD.getDataMap().getBalance():0;
												values[22] = objFD.getDataMap()!=null?objFD.getDataMap().getIgv():0;
												values[23] = objFD.getDataMap()!=null?objFD.getDataMap().getTotalVisanet():0;
												values[24] = objFD.getDataMap()!=null?objFD.getDataMap().getDebit():0;		
												paymentPrizeBo.approveRequestVisa(values); 
												mensaje = result.getMessage();//mensaje de exito al crear solicitud
											}else {
												//denegacion automatica
												LoggerApi.Log.info("denegacion dispersionFondo clientId: " + idClient.toString() + "requestNumber"+ result.getRequestNumber());
												mensaje = paymentPrizeProcedureGetDataCollectPrizes.getMsgAutomaticVisaDen();//mensaje de error al intentar dispersar fondos
												Object[] values = new Object[2];
												values[0] = result.getRequestNumber();
												values[1] = Constantes.ESPACIO_VACIO;
												paymentPrizeBo.refuseRequestAutomatic(values);
												o.addProperty("clean", "OK");
												o.addProperty("titulo", "Tu retiro por tu tarjeta Visa ha sido denegado");
												
												int transactionId = Constantes.generateTransactionId();
												mensaje += "<br><br>N� de operaci�n: V"+transactionId+"<br>"+sdfFront.format(new Date());
												registrarErrorVisa(new BigInteger(idClient.toString()), new BigInteger(transactionId+""),
																Constantes.PROCESS_FD_API, result.getRequestNumber().toString(), 
																purchaseNumberFD, objFD.getJson() + "| HTTP CODE: "+ objFD.getHttpCode(), 
																objFD.getErrorCode()!=null?objFD.getErrorCode(): Constantes.VACIO, 
																objFD.getErrorMessage()!=null?objFD.getErrorMessage(): Constantes.VACIO, 
																Constantes.VACIO, Constantes.VACIO);											
											}
										}else {
											LoggerApi.Log.info("Error al crear solicitud: " + result.getMessage() + " clientId: " + idClient.toString());
											mensaje = result.getMessage();//mensaje de error al intentar crear solicitud
										}
										
										o.addProperty("message", mensaje);
										o.addProperty("amount", result.getAmount());
										o.addProperty("requestNumber", result.getRequestNumber());
										o.addProperty("status", Constantes.RESULT_OK);
										o.addProperty("messageSuccess", paymentPrizeProcedureGetDataCollectPrizes.getMsgAutomaticVisaApr()+mensajeComision);
										o.addProperty("evaluacion", "AUTOMATICO");
									}else {
										LoggerApi.Log.info("Retiro denegado: " + Constantes.MSG_BLACKLIST + " clientId: " + idClient.toString());
										o.addProperty("message", Constantes.MSG_BLACKLIST);
										o.addProperty("status", Constantes.RESULT_OK);
										o.addProperty("evaluacion", "AUTOMATICO");
										o.addProperty("clean", "OK");
										o.addProperty("titulo", "Tu retiro ha sido denegado");
									}
								}
							}
						}
					}else {
						LoggerApi.Log.info("ERROR_RULES: " + paymentPrizeProcedureGetResultEvalRulesVisa.getMessage() + " clientId: " + idClient.toString());
						o.addProperty("status", "ERROR_RULES");
						o.addProperty("clean", paymentPrizeProcedureGetResultEvalRulesVisa.getClean());
						o.addProperty("message", paymentPrizeProcedureGetResultEvalRulesVisa.getMessage());
					}
				}else {
					LoggerApi.Log.info("ERROR_MONTO clientId: " + idClient.toString());
					o.addProperty("status", "ERROR_MONTO");
					o.addProperty("message", Constantes.MSG_AMOUNT_OUT_RANGE.replace("MIN", intralotUtils.formatCurrency3(paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRequestVisa().intValue())).replace("MAX", intralotUtils.formatCurrency3(paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxRequestVisa().intValue())) );
				}
				out.print(o);
			} catch (Exception e) {
				int transactionId = Constantes.generateTransactionId();
				String mensaje = Constantes.MSG_EXCEPTION+"<br><br>N� de operaci�n: I"+transactionId+"<br>"+sdfFront.format(new Date());
				o.addProperty("message", mensaje);
				o.addProperty("status", "ERROR");
				out.print(o);
				LoggerApi.severe(e,uuid.toString()+ " mensaje: "+mensaje);
			}

			TransactionPaymentLogPin sessionPin = null;
			try { 
				String status = o.getAsJsonObject().get("status").toString();
				sessionPin = paymentPrizeBo.transactionLogPin(paymentSession.getChannel(), "createRequestVisaEnd", paymentSession.getClientId(), paymentSession.getClientIp(), paymentSession.getPinUuid(), paymentSession.getType(), paymentSession.getAmount()
							, status , o.toString() );
			} catch (Exception e) {
				LoggerApi.severe(e, "Error transactionLogPin sessionPin="+sessionPin);			
			}
			
			LoggerApi.Log.info("-------------- END createRequestVisa uuid="+uuid.toString());
		}
		
		@RequestMapping(value = "/createRequestAgora")
		public void createRequestAgora(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
				throws Exception {
			UUID uuid = UUID.randomUUID();
			LoggerApi.Log.info("-------------- START createRequestAgora uuid="+uuid.toString());
			response.setCharacterEncoding(Constantes.CHARSET_UTF8);
			PrintWriter out = response.getWriter();
			JsonObject o = new JsonObject();
			o.addProperty("paymentType", "AGORA");
			Gson gson = new Gson();
			String prizetoken=request.getHeader("prizetoken");
	        String ipToken=SecurityUtils.getClientIp(request);	
			try {				
				Integer idClient = null;
				ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
				tokenValidation = beanSecurityLoginBo.getTokenValidation(prizetoken, ipToken);
				if (tokenValidation.getStatus().equals("OK") && (tokenValidation.getMessage().equals("Validated") || tokenValidation.getMessage().equals("Show"))) {
					idClient = Integer.parseInt(tokenValidation.getClientId());
					o.addProperty("prizetoken", tokenValidation.getRechargeToken());
					LoggerApi.Log.info("-------------- createRequestAgora token idClient="+idClient);
				}
				Double amountAgora = Double.parseDouble(request.getParameter("amountAgora"));

	    		try {
	    			paymentPrizeBo.transactionRequestIp("MOBILE","createRequestAgora", idClient.toString(), SecurityUtils.getClientIp(request), uuid.toString() , "AGORA", ""+amountAgora);
			    } catch (Exception ex) {
    		    	try { LoggerApi.severe(ex, "cid="+idClient+" ip="+SecurityUtils.getClientIp(request)); } catch (Exception e) {;}
			    }
					
				String imgDNI = request.getParameter("imgDNIAgora")!=null?request.getParameter("imgDNIAgora"):"";
				String kycResult = request.getParameter("kycResult")!=null?request.getParameter("kycResult"):"";
				PaymentPrizeProcedureGetDataCollectPrizes paymentPrizeProcedureGetDataCollectPrizes = paymentPrizeBo
						.getDataCollectPrizes(idClient);
				Double saldoLiquidable = paymentPrizeProcedureGetDataCollectPrizes.getSaldoLiquidable();
				Double billetera1 = paymentPrizeProcedureGetDataCollectPrizes.getBalanceAmount();
				
				if(amountAgora>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRequestAgr() && amountAgora<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxRequestAgr()) {		
					PaymentPrizeProcedureGetResultEvalRulesAgora paymentPrizeProcedureGetResultEvalRulesAgora = paymentPrizeBo.getResultEvalRulesAgora(idClient,amountAgora);
					int accAmtAgora = paymentPrizeProcedureGetResultEvalRulesAgora.getAccAmtAgora().intValue();
					if(paymentPrizeProcedureGetResultEvalRulesAgora.getResult().trim().equals(Constantes.RESULT_OK)) {
						String loadedImage = Constantes.LOADED_IMAGE_NO;
						if (saldoLiquidable == 0) {
							o.addProperty("status", "ERROR_MONTO");
							o.addProperty("message", Constantes.MSG_NO_CREDIT);
						} else if (amountAgora > saldoLiquidable) {
							o.addProperty("status", "ERROR_MONTO");
							o.addProperty("message", Constantes.MSG_NO_CREDIT_SUFICENT);
						} else if ( kycResult.trim().isEmpty()  &&
									(amountAgora>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinEnblDniAgr().intValue() || 
									 (amountAgora+accAmtAgora)>=paymentPrizeProcedureGetDataCollectPrizes.getMinAccAmtEnblDniAgr()) ) {
							o.addProperty("status", "ERROR_DNI");
							o.addProperty("message", Constantes.MSG_DNI_NOT_LOADED);
						}else {
							
							double comision = 0;
							boolean errorComision = false;
							if(amountAgora>=paymentPrizeProcedureGetDataCollectPrizes.getComMinRan1Agr() && amountAgora<=paymentPrizeProcedureGetDataCollectPrizes.getComMaxRan1Agr()){
								comision=paymentPrizeProcedureGetDataCollectPrizes.getComAmtRan1Agr();
							}else if(amountAgora>=paymentPrizeProcedureGetDataCollectPrizes.getComMinRan2Agr() && amountAgora<=paymentPrizeProcedureGetDataCollectPrizes.getComMaxRan2Agr()){
								comision=paymentPrizeProcedureGetDataCollectPrizes.getComAmtRan2Agr();
							}else if(amountAgora>=paymentPrizeProcedureGetDataCollectPrizes.getComMinRan3Agr() && amountAgora<=paymentPrizeProcedureGetDataCollectPrizes.getComMaxRan3Agr()){
								comision=paymentPrizeProcedureGetDataCollectPrizes.getComAmtRan3Agr();
							}else if(amountAgora>=paymentPrizeProcedureGetDataCollectPrizes.getComMinRan4Agr() && amountAgora<=paymentPrizeProcedureGetDataCollectPrizes.getComMaxRan4Agr()){
								comision=paymentPrizeProcedureGetDataCollectPrizes.getComAmtRan4Agr();
							}
							
							String mensajeComision = "";
							if(comision>0) {
								mensajeComision=Constantes.MSG_COMMISSION+intralotUtils.formatCurrency(comision);
								if((amountAgora+comision)>billetera1) {
									errorComision=true;
									o.addProperty("status", "ERRO_COMISION");
									o.addProperty("message", paymentPrizeProcedureGetDataCollectPrizes.getMsjComDenAgr().replace("XXX", intralotUtils.formatCurrency(comision)));
								}
							}
							/*
							boolean errorDNI = false;
							Double peso = 0.0;
							if(amountAgora>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinEnblDniAgr().intValue() ||
								(amountAgora+accAmtAgora)>=paymentPrizeProcedureGetDataCollectPrizes.getMinAccAmtEnblDniAgr() ) {
								BASE64Decoder decoder = new BASE64Decoder();
								byte[] decodedBytes = decoder.decodeBuffer(imgDNI.replace("data:image/png;base64,", "").replace("data:image/jpeg;base64,", ""));
								peso = (double) decodedBytes.length;
								if( (peso/1024/1024)<=paymentPrizeProcedureGetDataCollectPrizes.getMaxMbPerImageVisa().intValue()) {
									if(!imgDNI.trim().isEmpty()) {
										loadedImage=Constantes.LOADED_IMAGE_YES;
										try {
											ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
											BufferedImage image = ImageIO.read(bis);
									        bis.close();
									        if(image==null) {
									        	errorDNI = true;
												o.addProperty("status", "ERROR_DNI");
												o.addProperty("message", Constantes.MSG_DNI_NOT_VALID);
									        }
										} catch (Exception e) {
											
										} catch (OutOfMemoryError e) {
											MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
								            MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
								            long maxMemory = heapUsage.getMax() / (1024*1024);
								            long usedMemory = heapUsage.getUsed() / (1024*1024);
								            LoggerApi.Log.info("Memory Use :" + usedMemory + "M/" + maxMemory + "M");
								        }
									}							    
								}else {
									errorDNI = true;
									o.addProperty("status", "ERROR_DNI");
									o.addProperty("message", Constantes.MSG_DNI_LIMIT_MB+paymentPrizeProcedureGetDataCollectPrizes.getMaxMbPerImageVisa().intValue()+Constantes.MB);
								}
							}*/
							
							boolean errorKyc = true;
							if (!kycResult.trim().isEmpty() && (kycResult.equals("verified") || kycResult.equals("rejected") || kycResult.equals("reviewNeeded"))) {
								errorKyc = false;
							}
							
							if(!errorKyc && !errorComision) {
							//if(!errorDNI && !errorComision) {	
								String ip = request.getRemoteAddr();
								Object[] valuesTC = new Object[2];
								valuesTC[0] = idClient;
								valuesTC[1] = "MOBILE";
								PaymentPrizeProcedureGetTokenCard getTokenCard=paymentPrizeBo.getTokenCard(valuesTC);
								TokenizeCardResponse tokenizeCardResponse = gson.fromJson(StringLib.decodeLabel(getTokenCard.getVisaTokenResponse()), TokenizeCardResponse.class);							
								//reglas pp automatico
								boolean flagEvalRulesAutomatic=false;
								String whiteList = paymentPrizeProcedureGetDataCollectPrizes.getWhiteList();
								if(!whiteList.trim().equalsIgnoreCase("ACT")) {
									if(amountAgora<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxAutomaticAgr()) {
										PaymentPrizeProcedureEvalRulesAutomaticV2 objEvalRulesAutomatic=paymentPrizeBo.evalRulesAutomaticV2(idClient,Constantes.TYPE_PAYMENT_AGORA);
										//PaymentPrizeProcedureEvalRulesAutomatic objEvalRulesAutomatic=paymentPrizeBo.evalRulesAutomatic(clientId);
										if(objEvalRulesAutomatic!=null && objEvalRulesAutomatic.getResult().trim().equals(Constantes.RESULT_OK)) {
											flagEvalRulesAutomatic=true;
										}
									}
								}else {
									flagEvalRulesAutomatic=true;
								}

								if(amountAgora>paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxAutomaticAgr() && flagEvalRulesAutomatic==false) {
									PaymentPrizeProcedureCreateRequestVisa result = paymentPrizeBo.createRequestVisa(idClient.toString(),
											amountAgora, ip, Constantes.TYPE_PAYMENT_AGORA, Constantes.PLATAFORM, StringLib.encodeLabel(tokenizeCardResponse.getToken().getTokenId()),
											StringLib.encodeLabel(tokenizeCardResponse.getCard().getCardNumber()),tokenizeCardResponse.getOrder().getTransactionId(),StringLib.encodeLabel(gson.toJson(tokenizeCardResponse)), 
											imgDNI, loadedImage, comision);
																	
									if (result.getMessage() != null && result.getMessage().trim().equalsIgnoreCase(Constantes.RESULT_OK)) {
										//Double newSaldoLiquidable = saldoLiquidable - result.getAmount();
										Double newSaldoLiquidable = result.getNewSaldoLiquidable();
										paymentPrizeProcedureGetDataCollectPrizes.setSaldoLiquidable(newSaldoLiquidable);								
										o.addProperty("saldoLiquidable", paymentPrizeProcedureGetDataCollectPrizes.getSaldoLiquidable());	
										/*
										if(peso>0 || paymentPrizeProcedureGetDataCollectPrizes.getStateDni().trim().equals("ACT")	) {
											paymentPrizeProcedureGetDataCollectPrizes.setStateDni("ACT");
											o.addProperty("stateDni", "ACT");
										}else {
											paymentPrizeProcedureGetDataCollectPrizes.setStateDni("PEN");
											o.addProperty("stateDni", "PEN");
										}
										*/
									}
				
									o.addProperty("message", result.getMessage());
									o.addProperty("amount", result.getAmount());
									o.addProperty("requestNumber", result.getRequestNumber());
									o.addProperty("status", Constantes.RESULT_OK);
									o.addProperty("messageSuccess", Constantes.MSG_SUCCESS_REQUEST_AGORA+mensajeComision);
									o.addProperty("evaluacion", "MANUAL");
								}else {
									//flujo aprobacion automatica
									//crear solicitud para retener dinero
									PaymentPrizeProcedureInBlackList paymentPrizeProcedureInBlackList = paymentPrizeBo.inBlackList(idClient);
									if(paymentPrizeProcedureInBlackList.getResult()!=null && paymentPrizeProcedureInBlackList.getResult().trim().equals(Constantes.BLACKLIST_INACTIVE)) {
										String mensaje = "";
										PaymentPrizeProcedureCreateRequestVisaAutomatic result = paymentPrizeBo.createRequestVisaAutomatic(idClient.toString(),
												amountAgora, ip, Constantes.TYPE_PAYMENT_AGORA, Constantes.PLATAFORM, StringLib.encodeLabel(tokenizeCardResponse.getToken().getTokenId()),
												StringLib.encodeLabel(tokenizeCardResponse.getCard().getCardNumber()),tokenizeCardResponse.getOrder().getTransactionId(),StringLib.encodeLabel(gson.toJson(tokenizeCardResponse)), 
												imgDNI, loadedImage, comision);
										//si se pudo crear solicitud
										if (result.getMessage() != null && result.getMessage().trim().equalsIgnoreCase(Constantes.RESULT_OK)) {
											//call fd
								    		String purchaseNumberFD = Constantes.generatePurchaseNumberFD();
											FundsDisbursementsResponse objFD = dispersionFondo(amountAgora.toString(), tokenizeCardResponse.getToken().getTokenId(), idClient.toString(), paymentPrizeProcedureGetDataCollectPrizes.getNombre(), paymentPrizeProcedureGetDataCollectPrizes.getApellidoPaterno(), result.getRequestNumber().toString(), purchaseNumberFD, uuid);
								    		//si se realizo la fd
											if(objFD!=null && objFD.getResponseCode()!=null && objFD.getResponseCode().trim().equalsIgnoreCase(HttpServletResponse.SC_OK+"")) {
												//Double newSaldoLiquidable = saldoLiquidable - result.getAmount();
												Double newSaldoLiquidable = result.getNewSaldoLiquidable();
												paymentPrizeProcedureGetDataCollectPrizes.setSaldoLiquidable(newSaldoLiquidable);								
												o.addProperty("saldoLiquidable", paymentPrizeProcedureGetDataCollectPrizes.getSaldoLiquidable());
												/*
												if(peso>0 || paymentPrizeProcedureGetDataCollectPrizes.getStateDni().trim().equals("ACT")	) {
													paymentPrizeProcedureGetDataCollectPrizes.setStateDni("ACT");
													o.addProperty("stateDni", "ACT");
												}else {
													paymentPrizeProcedureGetDataCollectPrizes.setStateDni("PEN");
													o.addProperty("stateDni", "PEN");
												}*/												
												//registrar fd										
												Object[] values = new Object[25];
												values[0] = result.getRequestNumber();
												values[1] = "AUTO";
												values[2] = Constantes.ESPACIO_VACIO;
												values[3] = "AUTO";				
												values[4] = objFD.getHeader()!=null?objFD.getHeader().getEcoreTransactionUUID():"";
												values[5] = objFD.getHeader()!=null?objFD.getHeader().getEcoreTransactionDate():"";
												values[6] = objFD.getHeader()!=null?objFD.getHeader().getMillis():"";
												values[7] = objFD.getResponseCode()!=null?objFD.getResponseCode():"";
												values[8] = objFD.getResponseMessage()!=null?objFD.getResponseMessage():"";
												values[9] = objFD.getOrder()!=null?objFD.getOrder().getPurchaseNumber():"";
												values[10] = objFD.getOrder()!=null?Double.parseDouble(objFD.getOrder().getAmount()):0;
												values[11] = objFD.getOrder()!=null?objFD.getOrder().getCurrency():"";
												values[12] = objFD.getOrder()!=null?objFD.getOrder().getExternalTransactionId():"";
												values[13] = objFD.getOrder()!=null?objFD.getOrder().getStatusIdentifier():"";
												values[14] = objFD.getOrder()!=null?objFD.getOrder().getTransactionIdentifier():"";
												values[15] = objFD.getOrder()!=null?objFD.getOrder().getRetrievalReferenceNumber():"";
												values[16] = objFD.getOrder()!=null?objFD.getOrder().getActionCode():"";
												values[17] = objFD.getOrder()!=null?objFD.getOrder().getApprovalCode():"";
												values[18] = objFD.getOrder()!=null?objFD.getOrder().getResponseCode():"";
												values[19] = objFD.getOrder()!=null?objFD.getOrder().getTransmissionDateTime():"";
												values[20] = objFD.getDataMap()!=null?objFD.getDataMap().getComisionVisanet():0;
												values[21] = objFD.getDataMap()!=null?objFD.getDataMap().getBalance():0;
												values[22] = objFD.getDataMap()!=null?objFD.getDataMap().getIgv():0;
												values[23] = objFD.getDataMap()!=null?objFD.getDataMap().getTotalVisanet():0;
												values[24] = objFD.getDataMap()!=null?objFD.getDataMap().getDebit():0;		
												paymentPrizeBo.approveRequestVisa(values); 
												mensaje = result.getMessage();//mensaje de exito al crear solicitud
											}else {
												//denegacion automatica
												mensaje = paymentPrizeProcedureGetDataCollectPrizes.getMsgAutomaticAgrDen();//mensaje de error al intentar dispersar fondos
												Object[] values = new Object[2];
												values[0] = result.getRequestNumber();
												values[1] = Constantes.ESPACIO_VACIO;
												paymentPrizeBo.refuseRequestAutomatic(values);
												o.addProperty("cleanAgora", "OK");
												o.addProperty("titulo", "Tu retiro por tu tarjeta Agora ha sido denegado");
												
												int transactionId = Constantes.generateTransactionId();
												mensaje += "<br><br>N� de operaci�n: V"+transactionId+"<br>"+sdfFront.format(new Date());
												registrarErrorVisa(new BigInteger(idClient.toString()), new BigInteger(transactionId+""),
																Constantes.PROCESS_FD_API, result.getRequestNumber().toString(), 
																purchaseNumberFD, objFD.getJson() + "| HTTP CODE: "+ objFD.getHttpCode(), 
																objFD.getErrorCode()!=null?objFD.getErrorCode(): Constantes.VACIO, 
																objFD.getErrorMessage()!=null?objFD.getErrorMessage(): Constantes.VACIO, 
																Constantes.VACIO, Constantes.VACIO);											
											}
										}else {
											mensaje = result.getMessage();//mensaje de error al intentar crear solicitud
										}
										
										o.addProperty("message", mensaje);
										o.addProperty("amount", result.getAmount());
										o.addProperty("requestNumber", result.getRequestNumber());
										o.addProperty("status", Constantes.RESULT_OK);
										o.addProperty("messageSuccess", paymentPrizeProcedureGetDataCollectPrizes.getMsgAutomaticAgrApr()+mensajeComision);
										o.addProperty("evaluacion", "AUTOMATICO");
									}else {
										o.addProperty("message", Constantes.MSG_BLACKLIST);
										o.addProperty("status", Constantes.RESULT_OK);
										o.addProperty("evaluacion", "AUTOMATICO");
										o.addProperty("cleanAgora", "OK");
										o.addProperty("titulo", "Tu retiro ha sido denegado");
									}
								}
							}
						}
					}else {
						o.addProperty("status", "ERROR_RULES");
						o.addProperty("cleanAgora", paymentPrizeProcedureGetResultEvalRulesAgora.getClean());
						o.addProperty("message", paymentPrizeProcedureGetResultEvalRulesAgora.getMessage());
					}
				}else {
					o.addProperty("status", "ERROR_MONTO");
					o.addProperty("message", Constantes.MSG_AMOUNT_OUT_RANGE.replace("MIN", intralotUtils.formatCurrency3(paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRequestAgr().intValue())).replace("MAX", intralotUtils.formatCurrency3(paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxRequestAgr().intValue())) );
				}
				out.print(o);
			} catch (Exception e) {
				int transactionId = Constantes.generateTransactionId();
				String mensaje = Constantes.MSG_EXCEPTION+"<br><br>N� de operaci�n: I"+transactionId+"<br>"+sdfFront.format(new Date());
				o.addProperty("message", mensaje);
				o.addProperty("status", "ERROR");
				out.print(o);
				LoggerApi.severe(e,uuid.toString()+ " mensaje: "+mensaje);
			}
			LoggerApi.Log.info("-------------- END createRequestAgora uuid="+uuid.toString());
		}
		
		@RequestMapping(value = "/deleteTokenizedCard")
		public void deleteTokenizedCard(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
				throws Exception {
			UUID uuid = UUID.randomUUID();
			LoggerApi.Log.info("-------------- START deleteTokenizedCard uuid="+uuid.toString());
			String prizetoken=request.getHeader("prizetoken");
			String ipToken=SecurityUtils.getClientIp(request);	
			Integer clientId = 0;
			try {
				ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
				tokenValidation = beanSecurityLoginBo.getTokenValidation(prizetoken, ipToken);
				if (tokenValidation.getStatus().equals("OK") && (tokenValidation.getMessage().equals("Validated") || tokenValidation.getMessage().equals("Show"))) {
					clientId = Integer.parseInt(tokenValidation.getClientId());
					//o.addProperty("prizetoken", tokenValidation.getRechargeToken());
					LoggerApi.Log.info("-------------- deleteTokenizedCard token idClient="+clientId);
				}

				paymentPrizeBo.transactionLogPin("MOBILE", "deleteTokenizedCard", clientId+"", SecurityUtils.getClientIp(request), "", "", "", "", "");
		    } catch (Exception ex) {
		    	try { LoggerApi.severe(ex, "cid="+clientId+" ip="+SecurityUtils.getClientIp(request)); } catch (Exception e) {;}
		    }
			LoggerApi.Log.info("-------------- END deleteTokenizedCard uuid="+uuid.toString());
		}	
		
		@RequestMapping(value = "/deleteTokenizedCardAgora")
		public void deleteTokenizedCardAgora(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
				throws Exception {
			UUID uuid = UUID.randomUUID();
			LoggerApi.Log.info("-------------- START deleteTokenizedCardAgora uuid="+uuid.toString());
			LoggerApi.Log.info("-------------- END deleteTokenizedCardAgora uuid="+uuid.toString());
		}	
		
		private FundsDisbursementsResponse dispersionFondo(String requestAmount, String cardToken, String clientId, String nombres, String apellido, String requestNumber, String purchaseNumber, UUID uuid) {
			LoggerApi.Log.info("-------------- START dispersionFondo uuid="+uuid.toString());
			FundsDisbursementsResponse obj = new FundsDisbursementsResponse();
			try {						
				LoggerApi.Log.info("dispersionFondo amount=" + requestAmount + " clientId=" + clientId + " cardToken=" + cardToken+ " nombres=" + nombres + "apellidos="+ apellido + " requestnumber=" + requestNumber + " uuid=" + uuid);

				String user = ConnectionFactory.operationProperty("user_api_tokenization_card", Constantes.contextSale);
				String pass = ConnectionFactory.operationProperty("pass_api_tokenization_card", Constantes.contextSale);
				String securityApiUrl = ConnectionFactory.operationProperty("security_api_tokenization_card", Constantes.contextSale);
				String pushPaymentsApiUrl = ConnectionFactory.operationProperty("push_payments_api_fd", Constantes.contextSale);
						
				String credenciales = user+":"+pass;
		    	credenciales = new BASE64Encoder().encode(credenciales.getBytes("UTF-8"));
		    	URL url = new URL(securityApiUrl);
	    		HttpsURLConnection  con = (HttpsURLConnection )url.openConnection();
	    		con.setRequestMethod("GET");
	    		con.setRequestProperty("Authorization", "Basic "+credenciales);
	    		con.setSSLSocketFactory(new TSLSocketConnectionFactory());
	    		BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream()),"UTF-8"));
	    		StringBuilder sb = new StringBuilder();
	    		char[] buffer = new char[1000];
	            int leido;
	            while ((leido = br.read(buffer)) > 0) {
	            	sb.append(new String(buffer, 0, leido));
	            }
	    		br.close();
	    		String token = sb.toString();
	    		LoggerApi.Log.info("TOKEN FD: " + token);
	    		
	     		URL urlS = new URL(pushPaymentsApiUrl);
	    		HttpsURLConnection  conS = (HttpsURLConnection )urlS.openConnection();
	    		conS.setRequestMethod("POST");
	    		conS.setRequestProperty("Content-Type", Constantes.APPLICATION_JSON);
	    		conS.setRequestProperty("Authorization", token);
	    		conS.setDoOutput(true);
	    		conS.setSSLSocketFactory(new TSLSocketConnectionFactory());	    		
	  		
	    		BodyFundsDisbursements body = new BodyFundsDisbursements();
	    		body.setChannel(Constantes.FD_CHANNEL);
	    		body.setTerminalId(Constantes.FD_TERMINAL_ID);
	    		body.setApplicationId(Constantes.FD_APPLICATION_ID);
	    		Order order = new Order();
	    		order.setPurchaseNumber(purchaseNumber);
	    		order.setAmount(requestAmount);
	    		order.setCurrency(Constantes.FD_ORDER_CURRENCY);
	    		order.setExternalTransactionId(uuid.toString().replace("-", ""));
	    		order.setBusinessApplicationId(Constantes.FD_ORDER_BUSINESS_APPLICATION_ID);
	    		body.setOrder(order);
	    		Merchant merchant = new Merchant();
	    		merchant.setName(Constantes.FD_MERCHANT_NAME);
	    		merchant.setCategoryCode(Constantes.FD_MERCHANT_CATEGORY_CODE);
	    		Address address = new Address();
	    		address.setCountry(Constantes.FD_MERCHANT_ADDRESS_COUNTRY);
	    		merchant.setAddress(address);
	    		body.setMerchant(merchant);
	    		Recipient recipient = new Recipient(); 
	    		recipient.setTokenId(cardToken.trim());
	    		recipient.setEmail("CID"+clientId+"@intralot.com.pe");
	    		recipient.setCaptureType(Constantes.FD_RECIPIENT_CAPTURE_TYPE);
	    		
	    		if(nombres!=null && !nombres.trim().isEmpty()) {
	    			if(nombres.length()>10) {
	    				nombres = nombres.substring(0, 10);
	    			}
	    		}
	    		recipient.setFirstName(nombres);
	    		
	    		String apellidoPaterno = "";
	    		if(apellido!=null && !apellido.trim().isEmpty()) {
	    			String[] apellidos = apellido.split(" ");
	        		apellidoPaterno = apellidos[0];
	        		if(apellidoPaterno.length()>16) {
	        			apellidoPaterno = apellidoPaterno.substring(0, 16);
	        		}
	    		}
	    		recipient.setLastName(apellidoPaterno);
	    		
	    		recipient.setAddress(Constantes.FD_RECIPIENT_ADDRESS);
	    		recipient.setCity(Constantes.FD_RECIPIENT_CITY);
	    		recipient.setStateCode(Constantes.FD_RECIPIENT_STATE_CODE);
	    		recipient.setCountryCode(Constantes.FD_RECIPIENT_COUNTRY_CODE);
	    		recipient.setReference(requestNumber);
	    		body.setRecipient(recipient);
	    		
	        	Gson gson = new Gson();
	            String jsonInputString = gson.toJson(body);
	            LoggerApi.Log.info("REQUEST API FD: "+jsonInputString);
	        	byte[] input = jsonInputString.getBytes("utf-8");
	        	OutputStream os = conS.getOutputStream();
	        	os.write(input, 0, input.length); 
	        	os.flush();
	        	os.close();
	        	
	        	StringBuilder sbS = new StringBuilder();
	        	int responseCode = conS.getResponseCode();
	        	BufferedReader brS = null;
	        	        	
	        	if(responseCode==HttpServletResponse.SC_OK) {
		        	LoggerApi.Log.info("FD responseCode uuid="+uuid.toString()+": "+responseCode+ " clientId:"+clientId);
	        		brS = new BufferedReader(new InputStreamReader((conS.getInputStream()),"UTF-8"));
		    	}else {
		    		LoggerApi.Log.info("HTTP CODE FD: "+responseCode);
		    		try {
		    			brS = new BufferedReader(new InputStreamReader((conS.getErrorStream()),"UTF-8"));	
					} catch (Exception e) {
						brS = new BufferedReader(new InputStreamReader((conS.getInputStream()),"UTF-8"));
						LoggerApi.severe(e,uuid.toString());
					}
		    	}
	        	
	    		char[] bufferS = new char[1000];
	            int leidoS;
	            while ((leidoS = brS.read(bufferS)) > 0) {
	            	sbS.append(new String(bufferS, 0, leidoS));
	            }
	    		brS.close();
	    		
	    		String jsonFD = sbS.toString();
	    		      
	    		try { 
	    		LoggerApi.Log.info("RESPONSE API FD: "+jsonFD);      
	    			obj = gson.fromJson(jsonFD,FundsDisbursementsResponse.class); 
	    		} catch (Exception e) {
	    			obj.setErrorMessage(e.getMessage());
	    			LoggerApi.severe(e, "Error RESPONSE API FD. uuid=" + uuid.toString());
	    		}     
	    		obj.setJson(jsonFD);
	    		obj.setHttpCode(responseCode);
			}catch (Exception e) {
				obj.setErrorMessage(e.getMessage());
				LoggerApi.severe(e,"Error en dispersionFondo. uuid=" + uuid.toString());
			}
			LoggerApi.Log.info("-------------- END dispersionFondo uuid="+uuid.toString());
			return obj;
		}
	
		private void registrarErrorVisa(BigInteger clientId, BigInteger transaccionId, String process, String requestNumber, String purchaseNumber, 
				String jsonResponse, String errorCode, String errorMessage, String actionCode, String actionCodeDescription) {
			try {
				Object[] values = new Object[10];
				values[0] = clientId;
				values[1] = transaccionId;
				values[2] = process;
				values[3] = requestNumber;
				values[4] = purchaseNumber;
				values[5] = jsonResponse;
				values[6] = errorCode;
				values[7] = errorMessage;
				values[8] = actionCode;
				values[9] = actionCodeDescription;
				paymentPrizeBo.errorVisa(values);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@RequestMapping(value = "/createRequestTransferencia")
		public void createRequestTransferencia(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
				throws Exception {
			UUID uuid = UUID.randomUUID();
			LoggerApi.Log.info("-------------- START createRequestTransferencia uuid="+uuid.toString());
			response.setCharacterEncoding(Constantes.CHARSET_UTF8);
			PrintWriter out = response.getWriter();
			JsonObject o = new JsonObject();
			o.addProperty("paymentType", "TRANSFERENCIA");
			TransactionPaymentToken paymentSession = null;
			String prizetoken=request.getHeader("prizetoken");
			String ipToken=SecurityUtils.getClientIp(request);
			try {
				Integer idClient = null;
				ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
				tokenValidation = beanSecurityLoginBo.getTokenValidation(prizetoken, ipToken);
				if (tokenValidation.getStatus().equals("OK") && (tokenValidation.getMessage().equals("Validated") || tokenValidation.getMessage().equals("Show"))) {
					idClient = Integer.parseInt(tokenValidation.getClientId());
					o.addProperty("prizetoken", tokenValidation.getRechargeToken());
					LoggerApi.Log.info("-------------- createRequestTransferencia token idClient="+idClient);
				}
				String amount = request.getParameter("amountTransferencia")!=null?request.getParameter("amountTransferencia"):"";

				TransactionPaymentLogPin sessionPin = null;
				String resultPin = "";
				
				String pinUuid = request.getParameter("pinUuid")!=null?request.getParameter("pinUuid"):"";
				paymentSession = new TransactionPaymentToken();
				paymentSession.setChannel(Constantes.PLATAFORM);
				paymentSession.setClientId(idClient.toString());
				paymentSession.setClientIp(ipToken);
				paymentSession.setPinUuid(pinUuid);
				paymentSession.setType(request.getParameter("paymentType")!=null?request.getParameter("paymentType"):"");
				paymentSession.setAmount(request.getParameter("amount")!=null?request.getParameter("amount"):"");
				
				String statusPin = request.getParameter("statusPin")!=null?request.getParameter("statusPin"):"";
				if ( statusPin.equals("OK") ) {
					resultPin = "OK";
					LoggerApi.Log.info(uuid.toString()+" PIN ok");
					try { sessionPin = paymentPrizeBo.transactionLogPin(paymentSession.getChannel(), "createRequestTransferencia", paymentSession.getClientId(), paymentSession.getClientIp(), paymentSession.getPinUuid(), paymentSession.getType(), paymentSession.getAmount(), paymentSession.getValidatePinStatus(), resultPin);
					} catch (Exception e) {
						LoggerApi.severe(e, "sessionPin="+sessionPin);			
					}
				} else {
					resultPin = "PIN NO VALIDO!!! "+ paymentSession.getValidatePinStatus();
					LoggerApi.Log.info(uuid.toString()+" "+resultPin);
					try { sessionPin = paymentPrizeBo.transactionLogPin(paymentSession.getChannel(), "createRequestTransferencia", paymentSession.getClientId(), paymentSession.getClientIp(), paymentSession.getPinUuid(), paymentSession.getType(), paymentSession.getAmount(), paymentSession.getValidatePinStatus(), resultPin);
					} catch (Exception e) {
						LoggerApi.severe(e, "sessionPin="+sessionPin);			
					}
					throw new Exception(resultPin);
				}
	    		
	    		try {
	    			paymentPrizeBo.transactionRequestIp("MOBILE","createRequestTransferencia", idClient.toString(), SecurityUtils.getClientIp(request), paymentSession.getPinUuid(), "TRANSFERENCIA", ""+amount);
    		    } catch (Exception ex) {
    		    	try { LoggerApi.severe(ex, "cid="+idClient+" ip="+SecurityUtils.getClientIp(request)); } catch (Exception e) {;}
    		    }
	    		
	    		PaymentPrizeProcedureGetDataCollectPrizes paymentPrizeProcedureGetDataCollectPrizes = paymentPrizeBo
						.getDataCollectPrizes(idClient);
	    		
				boolean flagDatosPersonales = true;
				if(paymentPrizeProcedureGetDataCollectPrizes.getNombre()==null || paymentPrizeProcedureGetDataCollectPrizes.getNombre().trim().isEmpty() || 
						( (paymentPrizeProcedureGetDataCollectPrizes.getApellidoPaterno()==null || paymentPrizeProcedureGetDataCollectPrizes.getApellidoPaterno().trim().isEmpty()) &&
						  (paymentPrizeProcedureGetDataCollectPrizes.getApellidoMaterno()==null || paymentPrizeProcedureGetDataCollectPrizes.getApellidoMaterno().trim().isEmpty())
						) ||
						paymentPrizeProcedureGetDataCollectPrizes.getDocNumber()==null || paymentPrizeProcedureGetDataCollectPrizes.getDocNumber().trim().isEmpty() || paymentPrizeProcedureGetDataCollectPrizes.getDocNumber().trim().length()<8 ||
						paymentPrizeProcedureGetDataCollectPrizes.getDocType()==null || paymentPrizeProcedureGetDataCollectPrizes.getDocType().trim().isEmpty()
				) {
					flagDatosPersonales = false;
				}
				if(flagDatosPersonales) {
					String imgDNITransferencia = request.getParameter("imgDNITransferencia")!=null?request.getParameter("imgDNITransferencia"):"";
					String kycResult = request.getParameter("kycResult")!=null?request.getParameter("kycResult"):"";
					LoggerApi.Log.info("create request  kycResult:" + kycResult);
					String idBanco = request.getParameter("banco")!=null?request.getParameter("banco"):"";
					String banco = "";
					String cuenta = request.getParameter("cuenta")!=null?request.getParameter("cuenta"):"";
					String departamento = request.getParameter("departamento")!=null?request.getParameter("departamento"):"";
					String guardarRecurrente = request.getParameter("guardarRecurrente")!=null?request.getParameter("guardarRecurrente"):"";
					String recurrenteSeleccionado = request.getParameter("recurrenteSeleccionado")!=null?request.getParameter("recurrenteSeleccionado"):"";
					String rango="";
					String paymentType="";
					String tipoTransferencia = request.getParameter("tipoTransferencia")!=null?request.getParameter("tipoTransferencia"):"";
					String ticketId = request.getParameter("ticketId")!=null?request.getParameter("ticketId"):"";
					
					if(!amount.isEmpty() && ( (!idBanco.isEmpty() && !cuenta.isEmpty() && !departamento.isEmpty()) || recurrenteSeleccionado.trim().equals("true")) ) {
						double iAmount = 0;
						try {
							iAmount = Double.parseDouble(amount);
							if(recurrenteSeleccionado.trim().equals("false") || (recurrenteSeleccionado.trim().equals("true") && (!idBanco.isEmpty() && !cuenta.isEmpty() && !departamento.isEmpty()) ) ) {
								banco = getBank(idBanco);
								departamento = getDepartment(departamento);
							}else {
								cuenta = request.getParameter("ncRecurrenteSeleccionado")!=null?request.getParameter("ncRecurrenteSeleccionado").trim():"";
								List<PaymentPrizeProcedureGetSavingsAccount> getSavingsAccount=paymentPrizeBo.getSavingsAccount(idClient);
								if(getSavingsAccount!=null && !getSavingsAccount.isEmpty()) {
									for (PaymentPrizeProcedureGetSavingsAccount paymentPrizeProcedureGetSavingsAccount : getSavingsAccount) {
										if(cuenta.equals(paymentPrizeProcedureGetSavingsAccount.getAccountNumber().trim())) {
											banco=paymentPrizeProcedureGetSavingsAccount.getBank();
											departamento=paymentPrizeProcedureGetSavingsAccount.getDepartment();
											idBanco=getIdBank(banco);
											break;
										}
									}
								}
							}
						} catch (Exception e) {
							LoggerApi.severe(e);
						}
						if(iAmount>0 && !banco.isEmpty() && !departamento.isEmpty()) {
							Double amountTransferencia = Double.parseDouble(amount);							
							Double saldoLiquidable = paymentPrizeProcedureGetDataCollectPrizes.getSaldoLiquidable();
							
							LoggerApi.Log.info("amountTransferencia:"+amountTransferencia);
							String flujoDocumento = paymentPrizeProcedureGetDataCollectPrizes.getRequiredKycVisa()!=null?paymentPrizeProcedureGetDataCollectPrizes.getRequiredKycVisa():"";
							LoggerApi.Log.info("sigue flujoDNI:" + flujoDocumento);
							
							
							
							if(amountTransferencia<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxRequestTra()) {
								rango="RANGO_1";
								paymentType=Constantes.TYPE_PAYMENT_TRANSFERENCIA;
							}else if(amountTransferencia<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxRquTraRan2()) {
								rango="RANGO_2";
								paymentType=Constantes.TYPE_PAYMENT_PREMIO_MAYOR;
							}else if(amountTransferencia>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRquTraRan3()) {
								rango="RANGO_3";
								paymentType=Constantes.TYPE_PAYMENT_PREMIO_MAYOR;
							}else if("PML".equals(tipoTransferencia)) {
								paymentType=Constantes.TYPE_PAYMENT_PREMIO_MAYOR;
								LoggerApi.Log.info("entra a rango premio mayor ");
							}
							LoggerApi.Log.info("rango:"+rango + " " );
							
							if( (((amountTransferencia>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRequestTra() && amountTransferencia<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxRequestTra() && paymentPrizeProcedureGetDataCollectPrizes.getStateRequestTraRan1().equalsIgnoreCase("ACTIVO")) || 
									(amountTransferencia>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRquTraRan2() && amountTransferencia<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxRquTraRan2() && paymentPrizeProcedureGetDataCollectPrizes.getStateRequestTraRan2().equalsIgnoreCase("ACTIVO")) ||
									(amountTransferencia>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRquTraRan3() && paymentPrizeProcedureGetDataCollectPrizes.getStateRequestTraRan3().equalsIgnoreCase("ACTIVO"))) 
									&& !rango.isEmpty()) || "PML".equals(tipoTransferencia)) {
								//Cambios para Premio Mayor
								PaymentPrizeProcedureGetResultEvalRulesTrans  paymentPrizeProcedureGetResultEvalRulesTrans = null;
								int accAmtTrans=0;			
								
								if ( !"PML".equals(tipoTransferencia) ) {
									paymentPrizeProcedureGetResultEvalRulesTrans = paymentPrizeBo.getResultEvalRulesTrans(idClient,amountTransferencia, rango);
									accAmtTrans = paymentPrizeProcedureGetResultEvalRulesTrans.getAccAmtTrans().intValue();
								}
													
								
								if( ( paymentPrizeProcedureGetResultEvalRulesTrans !=null && paymentPrizeProcedureGetResultEvalRulesTrans.getResult().trim().equals(Constantes.RESULT_OK) ) || "PML".equals(tipoTransferencia) ) {
							
									String loadedImage;
									if("PML".equals(tipoTransferencia)) {
										loadedImage = Constantes.LOADED_IMAGE_NO;
										paymentPrizeProcedureGetDataCollectPrizes.setStateDni(Constantes.DNI_STATE_ACTIVE);
									}else {
										loadedImage = Constantes.LOADED_IMAGE_NO;
										paymentPrizeProcedureGetDataCollectPrizes.setStateDni(Constantes.DNI_STATE_ACTIVE);
									}
									//String loadedImage = Constantes.LOADED_IMAGE_NO;
									if (saldoLiquidable == 0 && !"PML".equals(tipoTransferencia)) {
										o.addProperty("status", "ERROR_MONTO");
										o.addProperty("message", Constantes.MSG_NO_CREDIT);
									} else if (amountTransferencia > saldoLiquidable && !"PML".equals(tipoTransferencia)) {
										o.addProperty("status", "ERROR_MONTO");
										o.addProperty("message", Constantes.MSG_NO_CREDIT_SUFICENT);
									} else if (flujoDocumento.equalsIgnoreCase("ACTIVO") && 
											( (kycResult.trim().isEmpty() &&  rango.equals("RANGO_1") && (amountTransferencia>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRequiredKycTrans().intValue()) ) ||
												//evaluacion para solicitar dni rango 2
											    ( kycResult.trim().isEmpty() 	&& rango.equals("RANGO_2")) ||
											    //evaluacion para solicitar dni rango 3
												    (kycResult.trim().isEmpty() && rango.equals("RANGO_3"))) ) {
													LoggerApi.Log.info("ERROR_DNI Pasar verificacion kyc");
													o.addProperty("status", "ERROR_DNI");
													o.addProperty("message", Constantes.MSG_DNI_NOT_LOADED);
									}else if (!flujoDocumento.equalsIgnoreCase("ACTIVO") && 
											( //evaluacion para solicitar dni rango 1
											(!paymentPrizeProcedureGetDataCollectPrizes.getStateDni().equals(Constantes.DNI_STATE_ACTIVE) && imgDNITransferencia.trim().isEmpty() && rango.equals("RANGO_1")  &&
											(amountTransferencia>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinEnblDniTra().intValue() || (amountTransferencia+accAmtTrans)>=paymentPrizeProcedureGetDataCollectPrizes.getMinAccAmtEnblDniTra())) ||
											//evaluacion para solicitar dni rango 2
										    ((!paymentPrizeProcedureGetDataCollectPrizes.getStateDni().equals(Constantes.DNI_STATE_ACTIVE) && imgDNITransferencia.trim().isEmpty() && rango.equals("RANGO_2")) || 
										    (paymentPrizeProcedureGetDataCollectPrizes.getDaysElapsedDni()>=paymentPrizeProcedureGetDataCollectPrizes.getValidityDniTraRan2() && imgDNITransferencia.trim().isEmpty() && rango.equals("RANGO_2"))) ||
										    //evaluacion para solicitar dni rango 3
										    ((!paymentPrizeProcedureGetDataCollectPrizes.getStateDni().equals(Constantes.DNI_STATE_ACTIVE) && imgDNITransferencia.trim().isEmpty() && rango.equals("RANGO_3")) || 
											(paymentPrizeProcedureGetDataCollectPrizes.getDaysElapsedDni()>=paymentPrizeProcedureGetDataCollectPrizes.getValidityDniTraRan3() && imgDNITransferencia.trim().isEmpty() && rango.equals("RANGO_3")))) ) { 
											LoggerApi.Log.info("ERROR_DNI subir foto dni");
										o.addProperty("status", "ERROR_DNI");
										o.addProperty("message", Constantes.MSG_DNI_NOT_LOADED);
									} else {
										LoggerApi.Log.info("entra a if general transferencia8" );
										boolean errorDocumento= true;
										
										if (flujoDocumento.equalsIgnoreCase("ACTIVO")) {
										boolean errorKyc = true;
											if (!kycResult.trim().isEmpty() && (kycResult.equals("verified")|| kycResult.equals("rejected") || kycResult.equals("reviewNeeded"))) {
											errorKyc = false;
										}
											errorDocumento = errorKyc;
										}else {
											boolean errorDNI = false;
											Double peso = 0.0;
											//if("PML".equals(tipoTransferencia)) {
											if( !imgDNITransferencia.trim().isEmpty() ||
												//evaluacion para solicitar dni rango 1
											    (rango.equals("RANGO_1") && (amountTransferencia>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinEnblDniTra().intValue() ||
												(amountTransferencia+accAmtTrans)>=paymentPrizeProcedureGetDataCollectPrizes.getMinAccAmtEnblDniTra())) ||
											    //evaluacion para solicitar dni rango 2
											    (rango.equals("RANGO_2") && paymentPrizeProcedureGetDataCollectPrizes.getDaysElapsedDni()>=paymentPrizeProcedureGetDataCollectPrizes.getValidityDniTraRan2()) ||
											    //evaluacion para solicitar dni rango 3
											    (rango.equals("RANGO_3") && paymentPrizeProcedureGetDataCollectPrizes.getDaysElapsedDni()>=paymentPrizeProcedureGetDataCollectPrizes.getValidityDniTraRan3())
												) {
												BASE64Decoder decoder = new BASE64Decoder();
												byte[] decodedBytes = decoder.decodeBuffer(imgDNITransferencia.replace("data:image/png;base64,", "").replace("data:image/jpeg;base64,", ""));
												peso = (double) decodedBytes.length;
												if( (peso/1024/1024)<=paymentPrizeProcedureGetDataCollectPrizes.getMaxMbPerImageVisa().intValue()) {
													if(!imgDNITransferencia.trim().isEmpty()) {
														loadedImage=Constantes.LOADED_IMAGE_YES;
														try {
															ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
															BufferedImage image = ImageIO.read(bis);
													        bis.close();
													        if(image==null) {
													        	errorDNI = true;
																o.addProperty("status", "ERROR_DNI");
																o.addProperty("message", Constantes.MSG_DNI_NOT_VALID);
													        }
														} catch (Exception e) {
															
														} catch (OutOfMemoryError e) {
															MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
												            MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
												            long maxMemory = heapUsage.getMax() / (1024*1024);
												            long usedMemory = heapUsage.getUsed() / (1024*1024);
												            LoggerApi.Log.info("Memory Use :" + usedMemory + "M/" + maxMemory + "M");
												        }
													}							    
												}else {
													errorDNI = true;
													o.addProperty("status", "ERROR_DNI");
													o.addProperty("message", Constantes.MSG_DNI_LIMIT_MB+paymentPrizeProcedureGetDataCollectPrizes.getMaxMbPerImageVisa().intValue()+Constantes.MB);
												}
											}
										errorDocumento=errorDNI;
										}
										
										LoggerApi.Log.info("transferencia errorDocumento:" +errorDocumento);
										if(!errorDocumento ) { //ksolis
											String ip = request.getRemoteAddr();									
											//reglas pp automatico
											boolean flagEvalRulesAutomatic=false;
											String whiteList = paymentPrizeProcedureGetDataCollectPrizes.getWhiteList();
											if(rango.equals("RANGO_1")) {
											/*	if(!whiteList.trim().equalsIgnoreCase("ACT")) {	
													LoggerApi.Log.info("is white list ->:"+whiteList);
													if(amountTransferencia<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxAutomaticTra()) {
														PaymentPrizeProcedureEvalRulesAutomaticV2 objEvalRulesAutomatic=paymentPrizeBo.evalRulesAutomaticV2(clientId, Constantes.TYPE_PAYMENT_TRANSFERENCIA);
														//PaymentPrizeProcedureEvalRulesAutomatic objEvalRulesAutomatic=paymentPrizeBo.evalRulesAutomatic(clientId);
														if(objEvalRulesAutomatic!=null && objEvalRulesAutomatic.getResult().trim().equals(Constantes.RESULT_OK)) {
															flagEvalRulesAutomatic=true;
															LoggerApi.Log.info("rules of pay automatic:" + objEvalRulesAutomatic.getResult());
														}
													}
												}else {
													flagEvalRulesAutomatic=true;
												}*/
												if(amountTransferencia<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxAutomaticTra()) {
													PaymentPrizeProcedureEvalRulesAutomaticV2 objEvalRulesAutomatic=paymentPrizeBo.evalRulesAutomaticV2(idClient, Constantes.TYPE_PAYMENT_TRANSFERENCIA);
													if(objEvalRulesAutomatic!=null && objEvalRulesAutomatic.getResult().trim().equals(Constantes.RESULT_OK)) {
														flagEvalRulesAutomatic=true;
													}
												}
												
												if(flagEvalRulesAutomatic == false ) {
													if(whiteList.trim().equalsIgnoreCase("ACT")) {
														flagEvalRulesAutomatic=true;
													}
												}
											}
											LoggerApi.Log.info("createRequestTransferencia ->flagEvalRulesAutomatic:"+flagEvalRulesAutomatic);
											LoggerApi.Log.info("is white list ->:"+whiteList);
			
											//if(amountTransferencia>paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxAutomaticTra() && flagEvalRulesAutomatic==false) {
											if( flagEvalRulesAutomatic==false) {
												//PaymentPrizeProcedureCreateRequestTransV2 result = paymentPrizeBo.createRequestTransV2(clientId.toString(), amountTransferencia, 
												//		ip, paymentType, Constantes.PLATAFORM, imgDNITransferencia, loadedImage, banco, cuenta, departamento, idBanco, guardarRecurrente, rango);
												PaymentPrizeProcedureCreateRequestTrans result = null;
												if("PML".equals(tipoTransferencia)) {
													String gameId = "";
													String barCode = "";
													List<PaymentPrizeProcedureListPrizesMajor> listPrizesMajor = paymentPrizeBo.listPrizesMajor(idClient);
													for (PaymentPrizeProcedureListPrizesMajor paymentPrizeProcedureListPrizesMajor : listPrizesMajor) {
														if(paymentPrizeProcedureListPrizesMajor.getTicketId().toString().equals(ticketId)) {
															gameId = paymentPrizeProcedureListPrizesMajor.getGameId().toString();
															barCode = StringLib.decodeLabel(paymentPrizeProcedureListPrizesMajor.getTicketNumber());
															break;
														}
													}
													/********************************************/
													DateAPI d = new DateAPI();
													WEBMessage web = new WEBMessage();
													web.setIp(request.getRemoteAddr());
													web.setMessageId("W" + d.getTimeLong() + gameId);
													pe.com.intralot.loto.model.Client cliente= BussinessSaleDispatcher.getClientByClientId(idClient.toString());
													String clientCarrier="AUTOM";
													String originalId=ticketId;
													
													WEBTicketPay webTicketPay = new WEBTicketPay();
													webTicketPay.setWebTickets(null);
													webTicketPay.setOriginalId(originalId);
													
													WEBTicketPay wtp = GameSaleDispatcher.autopayTicketWinnerByWebTransactionNewLotos5(clientCarrier, cliente, web, barCode, webTicketPay, 99000000.00);
													LoggerApi.Log.info("PML cid=" + idClient + " message=" + wtp.getMessage() + " prizeAmount="+wtp.getPrizeAmount() + " freeAmount="+wtp.getFreeAmount() + " ---autopayTicketWinnerByWebTransactionNewLotos5");
													/********************************************/
													LoggerApi.Log.info("createRequestPMLManual");
													result = paymentPrizeBo.createRequestTrans(idClient.toString(), amountTransferencia, 
															ip, paymentType, Constantes.PLATAFORM, imgDNITransferencia, loadedImage, banco, cuenta, departamento, idBanco, guardarRecurrente, "RANGO_4", "PML", ticketId,gameId,wtp.getPrizeAmount(),wtp.getFreeAmount());
												}else {
													LoggerApi.Log.info("createRequestTranferenciaManual");
													result = paymentPrizeBo.createRequestTrans(idClient.toString(), amountTransferencia, 
															ip, paymentType, Constantes.PLATAFORM, imgDNITransferencia, loadedImage, banco, cuenta, departamento, idBanco, guardarRecurrente, rango,"","","",-1.0,-1.0);
												}
												
												
												if (result.getMessage() != null && result.getMessage().trim().equalsIgnoreCase(Constantes.RESULT_OK)) {
													Double newSaldoLiquidable = null;
													if("PML".equals(tipoTransferencia)) {
														newSaldoLiquidable = saldoLiquidable;
													}else {
														newSaldoLiquidable = saldoLiquidable - result.getAmount();
													}
													paymentPrizeProcedureGetDataCollectPrizes.setSaldoLiquidable(newSaldoLiquidable);
													o.addProperty("saldoLiquidable", paymentPrizeProcedureGetDataCollectPrizes.getSaldoLiquidable());
//ksolis													
//													if("PML".equals(tipoTransferencia)) {   ksolis
//														if(peso>0 || paymentPrizeProcedureGetDataCollectPrizes.getStateDni().trim().equals("ACT")	) {
//															paymentPrizeProcedureGetDataCollectPrizes.setStateDni("ACT");
//															o.addProperty("stateDni", "ACT");
//														}else {
//															paymentPrizeProcedureGetDataCollectPrizes.setStateDni("PEN");
//															o.addProperty("stateDni", "PEN");
//														}
//													}

													
													if(guardarRecurrente.equals("true")) {
														List<PaymentPrizeProcedureGetSavingsAccount> getSavingsAccount=paymentPrizeBo.getSavingsAccount(idClient);
														Gson gson = new Gson();
														o.addProperty("getSavingsAccount", gson.toJson(getSavingsAccount));
														o.addProperty("guardarRecurrente", guardarRecurrente);
													}
												}
												o.addProperty("daysElapsedDni", result.getDaysElapsedDni());
												o.addProperty("message", result.getMessage());
												o.addProperty("amount", result.getAmount());
												o.addProperty("requestNumber", result.getRequestNumber());
												o.addProperty("status", Constantes.RESULT_OK);
												if(rango.equals("RANGO_1")) {
													o.addProperty("messageSuccess", Constantes.MSG_SUCCESS_REQUEST_TRANSFERENCIA);
												}else if(rango.equals("RANGO_2")) {
													o.addProperty("messageSuccess", Constantes.MSG_SUCCESS_REQUEST_TRANSFERENCIA_RANGO2);
												}else if(rango.equals("RANGO_3")) {
													o.addProperty("messageSuccess", Constantes.MSG_SUCCESS_REQUEST_TRANSFERENCIA_RANGO3);
												}else if(paymentType.equals("PREMIO_MAYOR")) {
													o.addProperty("messageSuccess", Constantes.MSG_SUCCESS_REQUEST_TRANSFERENCIA_RANGO4);
												}
												o.addProperty("evaluacion", "MANUAL");
											}else {
												//aprobacion automatica
												PaymentPrizeProcedureInBlackList paymentPrizeProcedureInBlackList = paymentPrizeBo.inBlackList(idClient);
												if(paymentPrizeProcedureInBlackList.getResult()!=null && paymentPrizeProcedureInBlackList.getResult().trim().equals(Constantes.BLACKLIST_INACTIVE)) {
													String mensaje = "";
													LoggerApi.Log.info("createRequestTranferenciaAutomatic");
													PaymentPrizeProcedureCreateRequestTransAutomatic result = paymentPrizeBo.createRequestTransAutomatic(idClient.toString(),
															amountTransferencia, ip, Constantes.TYPE_PAYMENT_TRANSFERENCIA, Constantes.PLATAFORM,imgDNITransferencia, loadedImage, banco, cuenta, departamento, idBanco, guardarRecurrente);
													if (result.getMessage() != null && result.getMessage().trim().equalsIgnoreCase(Constantes.RESULT_OK)) {
														//call api monnet
														SimpleDateFormat sdfMonnet = new SimpleDateFormat("yyyy-MM-dd");
														PayrollRequest payrollRequest = new PayrollRequest();
														PayrollResponse payrollResponse = new PayrollResponse();
														payrollRequest.setName(Constantes.FD_MONNET_NAME);
														payrollRequest.setCountry(Constantes.FD_MONNET_COUNTRY);
														payrollRequest.setCurrency(Constantes.FD_MONNET_CURRENCY);
														payrollRequest.setOrigin(Constantes.APPLICATION_TYPE);
														PayrollDetail payrollDetail = new PayrollDetail();
														payrollDetail.setIndex(Constantes.FD_MONNET_DETAIL_INDEX);
														payrollDetail.setTransactionId(result.getRequestNumber().toString());
														payrollDetail.setDate(sdfMonnet.format(new Date()));
														payrollDetail.setAmount(amount);
														payrollDetail.setCurrency(Constantes.FD_MONNET_DETAIL_CURRENCY);
														payrollDetail.setAmountUsd(Constantes.FD_MONNET_DETAIL_AMOUNT_USD);
														payrollDetail.setMerchant(Constantes.FD_MONNET_DETAIL_MERCHANT);
														payrollDetail.setAccountType(Constantes.FD_MONNET_DETAIL_ACCOUNT_TYPE);
														payrollDetail.setBank(banco);
														payrollDetail.setPaymentAccount(cuenta);
														if(banco.equals("Otros")) {
															payrollDetail.setCciNumber(cuenta);
														}else {
															payrollDetail.setCciNumber("");
														}
														payrollDetail.setDepartment(departamento);
														String nombres = paymentPrizeProcedureGetDataCollectPrizes.getNombre().toLowerCase().replace("�", "a").replace("�", "e").replace("�", "i").replace("�", "o").replace("�", "u").replace("�", "a").replace("�", "e").replace("�", "i").replace("�", "o").replace("�", "u").replace("�", "a").replace("�", "e").replace("�", "i").replace("�", "o").replace("�", "u").replace("�", "n").replace("'", "");
														String apellidos = (paymentPrizeProcedureGetDataCollectPrizes.getApellidoPaterno() + ((paymentPrizeProcedureGetDataCollectPrizes.getApellidoMaterno() != null) ? " " + paymentPrizeProcedureGetDataCollectPrizes.getApellidoMaterno() : "")).toLowerCase().replace("�", "a").replace("�", "e").replace("�", "i").replace("�", "o").replace("�", "u").replace("�", "a").replace("�", "e").replace("�", "i").replace("�", "o").replace("�", "u").replace("�", "a").replace("�", "e").replace("�", "i").replace("�", "o").replace("�", "u").replace("�", "n").replace("'", "");
														payrollDetail.setCustomerName(nombres.trim()+" "+apellidos.trim());
														if(paymentPrizeProcedureGetDataCollectPrizes.getDocType().trim().equals("DNI")) {
															payrollDetail.setCustomerIdType(Constantes.FD_MONNET_DETAIL_ID_TYPE_DNI);
														}else if(paymentPrizeProcedureGetDataCollectPrizes.getDocType().trim().equals("PASAP")) {
															payrollDetail.setCustomerIdType(Constantes.FD_MONNET_DETAIL_ID_TYPE_PAS);
														}else if(paymentPrizeProcedureGetDataCollectPrizes.getDocType().trim().equals("CAREX")) {
															payrollDetail.setCustomerIdType(Constantes.FD_MONNET_DETAIL_ID_TYPE_CE);
														}
														payrollDetail.setCustomerId(paymentPrizeProcedureGetDataCollectPrizes.getDocNumber().trim());
														if(paymentPrizeProcedureGetDataCollectPrizes.getMail()!=null && !paymentPrizeProcedureGetDataCollectPrizes.getMail().trim().isEmpty()) {
															payrollDetail.setCustomerEmail(paymentPrizeProcedureGetDataCollectPrizes.getMail());
														}else {
															payrollDetail.setCustomerEmail(Constantes.FD_MONNET_DETAIL_EMAIL_DEFAULT);
														}
														payrollDetail.setUserName(Constantes.FD_MONNET_DETAIL_USER_NAME);
														payrollDetail.setAccountNumber(Constantes.FD_MONNET_DETAIL_ACCOUNT_NUMBER);
														payrollDetail.setKycyn(Constantes.ESPACIO);
														payrollDetail.setReference(Constantes.ESPACIO);
														payrollDetail.setCustomerCellphone(Constantes.FD_MONNET_DETAIL_PHONE);
														List<PayrollDetail> listPayrollDetail = new ArrayList<PayrollDetail>();
														listPayrollDetail.add(payrollDetail);
														payrollRequest.setDetail(listPayrollDetail);
														Gson gson = new Gson();
										    			String json = gson.toJson(payrollRequest);	
										    			payrollResponse = getPaymentTransferMonnetResponse(json, uuid.toString());
														//si api monnet ok
														if(payrollResponse!=null && payrollResponse.getResult()!=null && payrollResponse.getResult().equals(Constantes.RESULT_OK)) {
															Double newSaldoLiquidable = saldoLiquidable - result.getAmount();
															paymentPrizeProcedureGetDataCollectPrizes.setSaldoLiquidable(newSaldoLiquidable);
															o.addProperty("saldoLiquidable", paymentPrizeProcedureGetDataCollectPrizes.getSaldoLiquidable());
															
															/* ksolis
															if("PML".equals(tipoTransferencia)) {
																if(peso>0 || paymentPrizeProcedureGetDataCollectPrizes.getStateDni().trim().equals("ACT")	) {
																	paymentPrizeProcedureGetDataCollectPrizes.setStateDni("ACT");
																	o.addProperty("stateDni", "ACT");
																}else {
																	paymentPrizeProcedureGetDataCollectPrizes.setStateDni("PEN");
																	o.addProperty("stateDni", "PEN");
																}
															}*/
															//registrar respuesta api monnet*
															//Object[] values = new Object[25];
															//values[0] = result.getRequestNumber();	
															//paymentPrizeBo.approveRequestVisa(values); 
															mensaje = result.getMessage();//mensaje de exito al crear solicitud
														}else {
															//denegacion automatica
															//mensaje = paymentPrizeProcedureGetDataCollectPrizes.getMsgAutomaticTraDen();//mensaje de error al intentar call api monnet
															if(payrollResponse!=null && payrollResponse.getTypeError()!=null && payrollResponse.getTypeError().trim().equals("1")) {
																mensaje = "Antes de poder solicitar una transferencia, debes actualizar y completar tus datos en tu cuenta de La Tinka. Tu dinero est� disponible para retiro.<br><br><a href=\"https://m.latinka.com.pe/derechos-arco.html\" target=\"_blank\" style=\"text-decoration: underline; color: #e30613;\">Actualiza tus datos aqu�</a> e intenta nuevamente, o solicita tu retiro usando otro m�todo.";
																o.addProperty("titulo", "No es posible procesar tu transferencia");
															}else {
																int transactionId = Constantes.generateTransactionId();
																mensaje = Constantes.MSG_EXCEPTION+"<br><br>N� de operaci�n: I"+transactionId+"<br>"+sdfFront.format(new Date());
																o.addProperty("titulo", "No fue posible confirmar tu transferencia");
															}
															Object[] values = new Object[2];
															values[0] = result.getRequestNumber();
															values[1] = Constantes.ESPACIO_VACIO;
															paymentPrizeBo.refuseRequestAutomatic(values);
															o.addProperty("cleanTrans", "OK");
															LoggerApi.Log.info("Transferencia denegacion automatica: "+ mensaje);
														}
													}else {
														mensaje = result.getMessage();//mensaje de error al intentar crear solicitud
													}
													
													if(guardarRecurrente.equals("true")) {
														List<PaymentPrizeProcedureGetSavingsAccount> getSavingsAccount=paymentPrizeBo.getSavingsAccount(idClient);
														Gson gson = new Gson();
														o.addProperty("getSavingsAccount", gson.toJson(getSavingsAccount));
														o.addProperty("guardarRecurrente", guardarRecurrente);
													}
									
													o.addProperty("message", mensaje);
													o.addProperty("amount", result.getAmount());
													o.addProperty("requestNumber", result.getRequestNumber());
													o.addProperty("status", Constantes.RESULT_OK);
													o.addProperty("messageSuccess", paymentPrizeProcedureGetDataCollectPrizes.getMsgAutomaticTraApr());
													o.addProperty("evaluacion", "AUTOMATICO");
												}else {
													o.addProperty("message", Constantes.MSG_BLACKLIST);
													o.addProperty("status", Constantes.RESULT_OK);
													o.addProperty("evaluacion", "AUTOMATICO");
													o.addProperty("cleanTrans", "OK");
													o.addProperty("titulo", "No fue posible confirmar tu transferencia");
												}
											}
										}
									}
								}else {
									o.addProperty("status", "ERROR_RULES");
									o.addProperty("cleanTrans", paymentPrizeProcedureGetResultEvalRulesTrans.getClean());
									o.addProperty("message", paymentPrizeProcedureGetResultEvalRulesTrans.getMessage());
								}
							}else {
								o.addProperty("status", "ERROR_MONTO");
								//o.addProperty("message", Constantes.MSG_AMOUNT_OUT_RANGE.replace("MIN", intralotUtils.formatCurrency3(paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRequestTra().intValue())).replace("MAX", intralotUtils.formatCurrency3(paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxRequestTra().intValue())) );
								o.addProperty("message", "Montos no v�lidos" );
							}      
						}else {
							o.addProperty("status", "ERROR_PARAMETERS");
							o.addProperty("message", "Los valores son inv�lidos");
						}
					}else {
						o.addProperty("status", "ERROR_PARAMETERS");
						o.addProperty("message", "El monto, banco, n�mero de cuenta y departamento son obligatorios");
					}
				}else {
					o.addProperty("status", "ERROR_DATA");
					o.addProperty("titulo", "No es posible procesar tu transferencia");
					o.addProperty("message", "Antes de poder solicitar una transferencia, debes actualizar y completar tus datos en tu cuenta de La Tinka. Tu dinero est� disponible para retiro.<br><br><a href=\"https://m.latinka.com.pe/derechos-arco.html\" target=\"_blank\" style=\"text-decoration: underline; color: #e30613;\">Actualiza tus datos aqu�</a> e intenta nuevamente, o solicita tu retiro usando otro m�todo.");
				}
				out.print(o);
			} catch (Exception e) {			
				int transactionId = Constantes.generateTransactionId();
				String mensaje = Constantes.MSG_EXCEPTION+"<br><br>N� de operaci�n: I"+transactionId+"<br>"+sdfFront.format(new Date());
				o.addProperty("message", mensaje);
				o.addProperty("status", "ERROR");
				out.print(o);
				LoggerApi.severe(e,uuid.toString()+ " mensaje: "+mensaje);
			}
			
			TransactionPaymentLogPin sessionPin = null;
			try {
				String status = o.getAsJsonObject().get("status").toString();
				sessionPin = paymentPrizeBo.transactionLogPin(paymentSession.getChannel(), "createRequestTransferenciaEnd", paymentSession.getClientId(), paymentSession.getClientIp(), paymentSession.getPinUuid(), paymentSession.getType(), paymentSession.getAmount()
							, status , o.toString() );
			} catch (Exception e) {
	    		 LoggerApi.severe(e, "sessionPin="+sessionPin);
	    	}
			
			LoggerApi.Log.info("-------------- END createRequestTransferencia uuid="+uuid.toString());
		}
		
		private String getIdBank(String banco) {
			String idBanco="";
			if(banco.trim().equalsIgnoreCase("Interbank")) {
				idBanco="1";
			}else if(banco.trim().equalsIgnoreCase("Banco de Credito")) {
				idBanco="2";
			}else if(banco.trim().equalsIgnoreCase("Banco Continental")) {
				idBanco="3";
			}else if(banco.trim().equalsIgnoreCase("Scotiabank")) {
				idBanco="4";
			}else if(banco.trim().equalsIgnoreCase("Otros")) {
				idBanco="5";
			}			
			return idBanco;
		}
		
		private String getBank(String indice) {
			String banco="";
			if(indice.equals("1")) {
				banco="Interbank";
			}else if(indice.equals("2")) {
				banco="Banco de Credito";
			}else if(indice.equals("3")) {
				banco="Banco Continental";
			}else if(indice.equals("4")) {
				banco="Scotiabank";
			}else if(indice.equals("5")) {
				banco="Otros";
			}
			return banco;
		}
		
		private String getDepartment(String indice) {
			String departamento="";
			if(indice.equals("1")) {
				departamento="Amazonas";
			}else if(indice.equals("2")) {
				departamento="Ancash";
			}else if(indice.equals("3")) {
				departamento="Apurimac";
			}else if(indice.equals("4")) {
				departamento="Arequipa";
			}else if(indice.equals("5")) {
				departamento="Ayacucho";
			}else if(indice.equals("6")) {
				departamento="Cajamarca";
			}else if(indice.equals("7")) {
				departamento="Callao";
			}else if(indice.equals("8")) {
				departamento="Cuzco";
			}else if(indice.equals("9")) {
				departamento="Huancavelica";
			}else if(indice.equals("10")) {
				departamento="Huanuco";
			}else if(indice.equals("11")) {
				departamento="Ica";
			}else if(indice.equals("12")) {
				departamento="Junin";
			}else if(indice.equals("13")) {
				departamento="La Libertad";
			}else if(indice.equals("14")) {
				departamento="Lambayeque";
			}else if(indice.equals("15")) {
				departamento="Lima";
			}else if(indice.equals("16")) {
				departamento="Loreto";
			}else if(indice.equals("17")) {
				departamento="Madre de Dios";
			}else if(indice.equals("18")) {
				departamento="Moquegua";
			}else if(indice.equals("19")) {
				departamento="Pasco";
			}else if(indice.equals("20")) {
				departamento="Piura";
			}else if(indice.equals("21")) {
				departamento="Puno";
			}else if(indice.equals("22")) {
				departamento="San Martin";
			}else if(indice.equals("23")) {
				departamento="Tacna";
			}else if(indice.equals("24")) {
				departamento="Tumbes";
			}else if(indice.equals("25")) {
				departamento="Ucayali";
			}
			return departamento;
		}
		
		private PayrollResponse getPaymentTransferMonnetResponse(String json, String uuid) {
			PayrollResponse payrollResponse = new PayrollResponse();
			Gson gson = new Gson();
			try {
				String urlTransferMonnetPayrollAPI = ConnectionFactory.operationProperty("urlTransferMonnetPayrollAPI", Constantes.contextSale);
				String userTransferAPI = ConnectionFactory.operationProperty("userTransferAPI", Constantes.contextSale);
				String passTransferAPI = ConnectionFactory.operationProperty("passTransferAPI", Constantes.contextSale);
				String credenciales = userTransferAPI+":"+passTransferAPI;
				credenciales = Base64.encodeBase64String(credenciales.getBytes());
	 	    	URL url = new URL(urlTransferMonnetPayrollAPI);
	 			HttpURLConnection  con = (HttpURLConnection )url.openConnection();
	 			con.setRequestMethod("POST");
	 			con.setRequestProperty("Authorization", "Basic "+credenciales);
	 			con.setRequestProperty("Content-Type", Constantes.APPLICATION_JSON);
	 			con.setRequestProperty("Accept", Constantes.APPLICATION_JSON);
	     		con.setDoOutput(true);
	     		OutputStream os = con.getOutputStream();
	 			os.write(json.getBytes(Constantes.CHARSET_UTF8));
	 			os.flush();
	 			os.close();
	 			BufferedReader br = null;
	 			int responseCode = con.getResponseCode();
	 			if(responseCode < HttpServletResponse.SC_BAD_REQUEST) {
	 				br = new BufferedReader(new InputStreamReader((con.getInputStream()),Constantes.CHARSET_UTF8));
	 			}else {
	 				LoggerApi.Log.info("API TRANSFERENCIA MONNET HTTP CODE: "+responseCode+" uuid: "+uuid+ " json: "+json);
	 				br = new BufferedReader(new InputStreamReader((con.getErrorStream()),Constantes.CHARSET_UTF8));
	 			}
	 			StringBuilder sb = new StringBuilder();
	 			char[] buffer = new char[1000];
	 	        int leido;
	 	        while ((leido = br.read(buffer)) > 0) {
	 	        	sb.append(new String(buffer, 0, leido));
	 	        }
	 			br.close();
	 			con.disconnect();
	 			String jsonResponsePayment = sb.toString();
	 			if(responseCode >= HttpServletResponse.SC_BAD_REQUEST) {
	 				LoggerApi.Log.info("API TRANSFERENCIA MONNET RESPONSE: "+jsonResponsePayment+" uuid: "+uuid+ " json: "+json);	
	 			}
	 			LoggerApi.Log.info("payrollResponse="+jsonResponsePayment+" uuid="+uuid.toString());
	 			payrollResponse = gson.fromJson(jsonResponsePayment, PayrollResponse.class);
			} catch (Throwable e) {
				LoggerApi.severe(e,uuid.toString());
			}
			return payrollResponse;
		}
		
		@RequestMapping(value = "/eliminarCuentaTransferencia")
		public void eliminarCuentaTransferencia(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
				throws Exception {
			UUID uuid = UUID.randomUUID();
			LoggerApi.Log.info("-------------- START eliminarCuentaTransferencia uuid="+uuid.toString());
			response.setCharacterEncoding(Constantes.CHARSET_UTF8);
			PrintWriter out = response.getWriter();
			JsonObject o = new JsonObject();
			String prizetoken=request.getHeader("prizetoken");
			String ipToken=SecurityUtils.getClientIp(request);	
			try {
				Integer idClient = null;
				ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
				tokenValidation = beanSecurityLoginBo.getTokenValidation(prizetoken, ipToken);
				if (tokenValidation.getStatus().equals("OK") && (tokenValidation.getMessage().equals("Validated") || tokenValidation.getMessage().equals("Show"))) {
					idClient = Integer.parseInt(tokenValidation.getClientId());
					o.addProperty("prizetoken", tokenValidation.getRechargeToken());
					LoggerApi.Log.info("-------------- eliminarCuentaTransferencia token idClient="+idClient);
				}
				String cuenta = request.getParameter("cuenta")!=null?request.getParameter("cuenta"):"";
				if (idClient!=null && !cuenta.isEmpty()) {
					PaymentPrizeProcedureDeleteAccount deleteAccount=paymentPrizeBo.deleteAccount(idClient, cuenta);
					
					if(deleteAccount!=null && deleteAccount.getResult().equals("OK") && deleteAccount.getMessage().equals("OK")) {
						List<PaymentPrizeProcedureGetSavingsAccount> getSavingsAccount=paymentPrizeBo.getSavingsAccount(idClient);
						Gson gson = new Gson();
						o.addProperty("getSavingsAccount", gson.toJson(getSavingsAccount));
						
						o.addProperty("message", Constantes.RESULT_OK);
						o.addProperty("status", Constantes.RESULT_OK);
					}else {
						o.addProperty("message", "ERROR");
						o.addProperty("status", "ERROR");
					}
				}else {
					o.addProperty("message", "ERROR");
					o.addProperty("status", "ERROR");
				}
				out.print(o);
			} catch (Exception e) {
				o.addProperty("message", "ERROR");
				o.addProperty("status", "ERROR");
				out.print(o);
				LoggerApi.severe(e,uuid.toString());
			}
			LoggerApi.Log.info("-------------- END eliminarCuentaTransferencia uuid="+uuid.toString());
		}
		
		private String getHtmlMailTicketsPP(String fullName) throws Exception {
			
			String html="<html>" + 
					"<head>" + 
					"<title>La Tinka - Recibo de retiro efectivo</title>" + 
					"<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>" + 
					"</head>" + 
					"<body leftmargin='0' topmargin='0' marginwidth='0' marginheight='0'>" + 
					"" + 
					"<table width='600' bgcolor='#FFFFFF'  align='center' border='0' cellpadding='0' cellspacing='0'>" + 
					"	<tr>" + 
					"		<td rowspan='2' bgcolor='#ffe510' width='65' height='106' alt=''></td>" + 
					"		<td colspan='3' bgcolor='#ffe510' width='470' height='53' alt=''></td>" + 
					"		<td rowspan='2' bgcolor='#ffe510' width='65' height='106' alt=''></td>" + 
					"	</tr>" + 
					"	<tr>" + 
					"		<td colspan='3'>" + 
					"			<img src='cid:logoimg' width='470' height='53' alt='LA TINKA' style='display:block; color:#5a5a5a; text-align:left; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:18px;'></td>" + 
					"	</tr>" + 
					"	<tr>" + 
					"		<td rowspan='7' bgcolor='#dedede'  width='65' alt=''></td>" + 
					"		<td colspan='3' bgcolor='#ffffff' width='470' height='15' alt=''></td>" + 
					"		<td rowspan='7' bgcolor='#dedede'  width='65' alt=''></td>" + 
					"	</tr>" + 
					"	<tr>" + 
					"		<td colspan='3' bgcolor='#ffffff' width='470' height='44' alt='' style='color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:22px;'><strong>Hola "+fullName+"</strong></td>" + 
					"	</tr>" + 
					"	<tr>" + 
					"		<td colspan='3' bgcolor='#ffffff' width='470' height='40' alt='' style='color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:13px;'>Ac�rcate a una tienda o punto de venta de La Tinka y presenta tu recibo adjunto con tu DNI para realizar el cobro.</td>" + 
					"	</tr>" + 
					"	" + 
					"	<tr>" + 
					"		<td colspan='3' bgcolor='#ffffff' width='470' height='40' alt='' style='color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:13px;'>�Protege tu recibo! Recuerda que el cobro es personal.</td>" + 
					"	</tr>" + 
					"	" + 
					"	<tr>" + 
					"		<td colspan='3' bgcolor='#ffffff' width='470' height='40' alt='' style='color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:13px;'>Tambi�n puedes volver a visualizar tu recibo en el Historial de retiros, ingresando a <strong> Mis premios</strong> desde tu cuenta de <a href='https://www.latinka.com.pe/p/' target='_blank' style='color:#5a5a5a; font-family:Arial, Helvetica, sans-serif; font-size:13px; text-decoration:underline;'><strong>La Tinka.</strong></a></td>" + 
					"	</tr>" + 
					"	" + 
					"	<tr>" + 
					"		<td width='20'></td>" + 
					"" + 
					"		<td width='20'></td>" + 
					"	</tr>" + 
					"	" + 
					"	<tr>" + 
					"		<td colspan='3' bgcolor='#ffffff' width='470' height='50' alt=''></td>" + 
					"	</tr>" + 
					"	<tr>" + 
					"		<td colspan='5' bgcolor='#dedede'>" + 
					"			<img src='cid:juegosimg' width='600' height='118' alt='Tinka - Te Apuesto - Casino - RaspaY&aacute; - Deportes Virtuales - Ganagol - K&aacute;bala - Gana Diario - Kinelo' style='display:block; color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:12px;'></td>" + 
					"	</tr>" + 
					"	<tr>" + 
					"		<td colspan='5' bgcolor='#dedede' width='600' height='10' alt=''></td>" + 
					"	</tr>" + 
					"</table>" + 
					"</body>" + 
					"</html>";
			return html;
		}

		@RequestMapping(value = "/createRequestTransferenciaPin")
		public void createRequestTransferenciaPin(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
				throws Exception {
			UUID pinuuid = UUID.randomUUID();
			LoggerApi.Log.info("-------------- START createRequestTransferenciaPin pinuuid="+pinuuid.toString());
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			JsonObject o = new JsonObject();
			TransactionPaymentToken paymentSession = null;
			String prizetoken=request.getHeader("prizetoken");
			String ipToken=SecurityUtils.getClientIp(request);
			try {
				Integer idClient = null;
				ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
				tokenValidation = beanSecurityLoginBo.getTokenValidation(prizetoken, ipToken);
				if (tokenValidation.getStatus().equals("OK") && (tokenValidation.getMessage().equals("Validated") || tokenValidation.getMessage().equals("Show"))) {
					idClient = Integer.parseInt(tokenValidation.getClientId());
					o.addProperty("prizetoken", tokenValidation.getRechargeToken());
					LoggerApi.Log.info("-------------- createRequestTransferenciaPin token idClient="+idClient);
				}

				String type = request.getParameter("type")!=null?request.getParameter("type"):"";
				String amount = request.getParameter("amount")!=null?request.getParameter("amount"):"";	
				String method="createPin";
				String p_sms = "";
				if (type.equals("REENVIAR")) {
					String paymentType = request.getParameter("paymentType")!=null?request.getParameter("paymentType"):"";
					String pinUuid = request.getParameter("pinUuid")!=null?request.getParameter("pinUuid"):"";
					paymentSession = new TransactionPaymentToken();
					paymentSession.setChannel(Constantes.PLATAFORM);
					paymentSession.setClientId(idClient.toString());
					paymentSession.setClientIp(ipToken);
					paymentSession.setPinUuid(pinUuid);
					paymentSession.setType(paymentType);
					paymentSession.setAmount(amount);
			    	method="recreatePin";
			    	LoggerApi.Log.info("Renviar por correo " + type);
				} else if(type.equals("REENVIARSMS")) {
					String paymentType = request.getParameter("paymentType")!=null?request.getParameter("paymentType"):"";
					String pinUuid = request.getParameter("pinUuid")!=null?request.getParameter("pinUuid"):"";
					paymentSession = new TransactionPaymentToken();
					paymentSession.setChannel(Constantes.PLATAFORM);
					paymentSession.setClientId(idClient.toString());
					paymentSession.setClientIp(ipToken);
					paymentSession.setPinUuid(pinUuid);
					paymentSession.setType(paymentType);
					paymentSession.setAmount(amount);
			    	method="recreatePin";
			    	p_sms="sms";
			    	LoggerApi.Log.info("Renviar por mensaje " + type);
				} else {
			    	paymentSession = new TransactionPaymentToken();
					paymentSession.setChannel(Constantes.PLATAFORM);
					paymentSession.setClientId(idClient.toString());
					paymentSession.setClientIp(ipToken);
					paymentSession.setPinUuid(pinuuid.toString());
					paymentSession.setType(type);
					paymentSession.setAmount(amount);
					o.addProperty("pinUuid", paymentSession.getPinUuid());
					o.addProperty("paymentType", paymentSession.getType());
					o.addProperty("amount", paymentSession.getAmount());
				}

		    	String pin =  pe.com.intralot.loto.utils.StringLib.getRandom(10000,99999);
		    	String pinEnc = StringLib.encodeLabel(pin);
			    		
		    	TransactionPaymentCreatePin createPin = paymentPrizeBo.transactionCreatePin(paymentSession.getChannel(), method, paymentSession.getClientId(), paymentSession.getClientIp(), paymentSession.getPinUuid(), paymentSession.getType(), amount, pinEnc,p_sms);
	    		
		    	if ( createPin.getStatus().equals("OK") ) {
		    		
		    		String result = paymentSendPinMail(createPin.getMail(), createPin.getNombre(), pin, createPin.getMinutos() );
		    		LoggerApi.Log.info("-------------- PIN:  "+ pin);
		    		if (result.equals("OK")) {
		    			
			    		o.addProperty("status", createPin.getStatus());
			    		o.addProperty("titulo", createPin.getTitulo());
			    		o.addProperty("mensaje", createPin.getMensaje());
			    		o.addProperty("contCorreo", createPin.getCont_correo());
			    		
			    		paymentSession.setPinEnc(pinEnc);
				    	
		    		} else {
		    			
			    		o.addProperty("status", "ERROR");
			    		o.addProperty("titulo", "No se ha logrado enviar el c&oacute;digo de autorizaci&oacute;n");
			    		o.addProperty("mensaje","Ocurri&oacute; un incidente inesperado. Por favor realice la acci&oacute;n nuevamente.");
		    		}
		    		
		    	} else if (createPin.getStatus().equals("ERROR_RECREATEPIN")){
		    		SmsProviderUtils registerSms = new SmsProviderUtils();
		    		SmsResultBean result = registerSms.sendNetSMS(createPin.getPhone(),"LA TINKA. Tu codigo de activacion es "+pin+" ");
		    		LoggerApi.Log.info("-------------- result:  "+ "code= "  + result.getCode() + "status= " + result.getStatus());

		    		if(result!=null && result.getCode() !=null && result.getCode()==200 && result.getStatus()==1) {
		    			o.addProperty("status", createPin.getStatus());
		    			o.addProperty("titulo", createPin.getTitulo());
		    			o.addProperty("mensaje", createPin.getMensaje());
		    			o.addProperty("contSms", createPin.getCont_sms());
		    			o.addProperty("pin", pin);
		    		
			    		paymentSession.setPinEnc(pinEnc);
		    		} else {
		    			// El env�o del SMS fall�
		    			LoggerApi.Log.info("Error: " + "No se puede establecer conexion con el servicio de sms " + "Code: " + result.getCode() +" status: " +result.getStatus());
		    			o.addProperty("status", "ERROR");
			    		o.addProperty("titulo", "No se ha logrado enviar el c&oacute;digo de autorizaci&oacute;n");
			    		o.addProperty("mensaje","Ocurri&oacute; un incidente inesperado. Por favor realice la acci&oacute;n nuevamente.");
		    		}
		    	} else {
		    		o.addProperty("status", "ERROR");
		    		o.addProperty("titulo", createPin.getTitulo());
		    		o.addProperty("mensaje", createPin.getMensaje());
		    	}

				out.print(o);
				
			} catch (Exception e) {			

				LoggerApi.severe(e, pinuuid.toString());
				
	    		o.addProperty("status", "ERROR");
	    		o.addProperty("titulo", "Ha ocurrido un incidente en el servicio");
	    		o.addProperty("mensaje","Por favor realice la acci&oacute;n nuevamente.");
	    		
				out.print(o);
			}
			
			TransactionPaymentLogPin sessionPin = null;
			try {    	     
	 			String status = o.getAsJsonObject().get("status").toString();
	 			sessionPin = paymentPrizeBo.transactionLogPin(paymentSession.getChannel(), "mailPin", paymentSession.getClientId(), paymentSession.getClientIp(), paymentSession.getPinUuid(), paymentSession.getType(), paymentSession.getAmount()
	     						, status , o.toString() );
			} catch (Exception e) {
	    		 LoggerApi.severe(e, "sessionPin="+sessionPin);
	    	}

			
			LoggerApi.Log.info("-------------- END createRequestTransferenciaPin pinuuid="+pinuuid.toString());
		}
		
	    public String paymentSendPinMail(String email, String name, String code, String minutes) {

	        StringBuffer mailBodyPass = new StringBuffer();
	        String mailSender = email;
	        String mailSubject = "C�digo de autorizaci�n de retiro";
	        String mailBody = "";
	        String result = "";
	        
	       mailBodyPass.append(    		   
	    		   "<html>            "+
	    				   "<head>            "+
	    				   "<title>La Tinka - Autorizaci&oacute;n de retiro</title>            "+
	    				   "<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>            "+
	    				   "</head>            "+
	    				   "<body leftmargin='0' topmargin='0' marginwidth='0' marginheight='0'>            "+
	    				   "            "+
	    				   "<table width='600' height='365' bgcolor='#FFFFFF'  align='center' border='0' cellpadding='0' cellspacing='0'>            "+
	    				   "	<tr>            "+
	    				   "		<td rowspan='2' bgcolor='#ffe510' width='65' height='106' alt=''></td>            "+
	    				   "		<td colspan='3' bgcolor='#ffe510' width='470' height='53' alt=''></td>            "+
	    				   "		<td rowspan='2' bgcolor='#ffe510' width='65' height='106' alt=''></td>            "+
	    				   "	</tr>            "+
	    				   "	<tr>            "+
	    				   "		<td colspan='3'>            "+
	    				   "			<img src='https://www.latinka.com.pe/latinka/mailing-sale/logo_tinka.gif?v=2' width='470' height='53' alt='LA TINKA' style='display:block; color:#5a5a5a; text-align:left; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:18px;'></td>            "+
	    				   "	</tr>            "+
	    				   "	<tr>            "+
	    				   "		<td rowspan='7' bgcolor='#dedede'  width='65' height='283' alt=''></td>            "+
	    				   "		<td colspan='3' bgcolor='#ffffff' width='470' height='38' alt=''></td>            "+
	    				   "		<td rowspan='7' bgcolor='#dedede'  width='65' height='283' alt=''></td>            "+
	    				   "	</tr>            "+
	    				   "	<tr>            "+
	    				   "		<td colspan='3' bgcolor='#ffffff' width='470' height='63' alt='' style='color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:22px;'><strong>�Hola "+name+"!</strong></td>            "+
	    				   "	</tr>            "+
	    				   "	<tr>            "+
	    				   "		<td width='24' height='33'></td>            "+
	    				   "		<td bgcolor='#ffffff' width='422' height='33' alt='' style='color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:14px;'>Este es el c&oacute;digo de autorizaci&oacute;n de tu retiro, que estar&aacute; vigente por "+minutes+" minutos:            "+
	    				   "		</td>            "+
	    				   "		<td width='24' height='33'></td>            "+
	    				   "	</tr>            "+
	    				   "	<tr>            "+
	    				   "		<td colspan='3' valign='center' bgcolor='#ffffff' width='470' height='63' style='color:#07663a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:22px;'><strong>"+code+"</strong></td>            "+
	    				   "	</tr>            "+
	    				   "	<tr>            "+
	    				   "		<td width='24' height='33'></td>            "+
	    				   "		<td bgcolor='#ffffff' width='422' height='33' alt='' style='color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:12px;'>�No solicitaste ning�n retiro de tus premios? Para mantener tu cuenta segura, te recomendamos <a href='https://www.latinka.com.pe/p/restablecer.html' style='color:#07663a;'><u>cambiar tu contrase�a aqu�</u></style>            "+
	    				   "		<td width='24' height='33'></td>            "+
	    				   "</td>            "+
	    				   "	</tr>            "+
	    				   "	<tr>            "+
	    				   "		<td colspan='3'bgcolor='#ffffff' width='470' height='49' alt=''></td>            "+
	    				   "	</tr>            "+
	    				   "	<tr>            "+
	    				   "		<td colspan='3'bgcolor='#dedede' width='470' height='76' alt='' style='color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:12px;'>&Eacute;ste es un correo generado autom&aacute;ticamente y <strong>caducar&aacute; a los "+minutes+" minutos</strong> de la fecha y hora en que lo recibiste. Tiene car&aacute;cter confidencial y solo puede ser utilizada por la persona a quien ha sido dirigida.</td>            "+
	    				   "	</tr>            "+
	    				   "	<tr>            "+
	    				   "		<td colspan='5' bgcolor='#dedede'>            "+
	    				   "			<img src='https://www.latinka.com.pe/latinka/mailing-sale/collage-logos.gif?v=2' width='600' height='118' alt='Tinka - Te Apuesto - Casino - GanaY&aacute; - Virtuales - Ganagol - K&aacute;bala - Gana Diario - Kinelo' style='display:block; color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:12px;'></td>            "+
	    				   "	</tr>            "+
	    				   "	<tr>            "+
	    				   "	</tr>            "+
	    				   "</table>            "+
	    				   "</body>            "
	    		   );
	    		       		   
	        mailBody = mailBodyPass.toString();
	        
	        try {
	        	result = MailLib.sendValidMailEco(mailSender, mailSubject, mailBody);
	        } catch (Exception e) {
	            LoggerApi.severe(e);
	            result = e.getMessage();
	        } finally {
	            LoggerApi.Log.info(result);
	        }
	        return result;
	        
	    }

		@RequestMapping(value = "/validateRequestTransferenciaPin")
		public void validateRequestTransferenciaPin(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
				throws Exception {
			UUID valuuid = UUID.randomUUID();
			LoggerApi.Log.info("-------------- START validateRequestTransferenciaPin valuuid="+valuuid.toString());
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			JsonObject o = new JsonObject();
			String result = "";
			String prizetoken=request.getHeader("prizetoken");
			String ipToken=SecurityUtils.getClientIp(request);
			TransactionPaymentToken paymentSession = new TransactionPaymentToken();
			try {
				Integer idClient = null;
				ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
				tokenValidation = beanSecurityLoginBo.getTokenValidation(prizetoken, ipToken);
				if (tokenValidation.getStatus().equals("OK") && (tokenValidation.getMessage().equals("Validated") || tokenValidation.getMessage().equals("Show"))) {
					idClient = Integer.parseInt(tokenValidation.getClientId());
					o.addProperty("prizetoken", tokenValidation.getRechargeToken());
					LoggerApi.Log.info("-------------- validateRequestTransferenciaPin token idClient="+idClient);
				}
				String amount = request.getParameter("amount")!=null?request.getParameter("amount"):"";	
				String paymentType = request.getParameter("paymentType")!=null?request.getParameter("paymentType"):"";
				String pinUuid = request.getParameter("pinUuid")!=null?request.getParameter("pinUuid"):"";
				
				paymentSession.setChannel(Constantes.PLATAFORM);
				paymentSession.setClientId(idClient.toString());
				paymentSession.setClientIp(ipToken);
				paymentSession.setPinUuid(pinUuid);
				paymentSession.setType(paymentType);
				paymentSession.setAmount(amount);
				String inputPin = request.getParameter("pin")!=null?request.getParameter("pin"):"";
		    	String inputPinEnc = StringLib.encodeLabel(inputPin);

		    	TransactionPaymentValidatePin validatePin = paymentPrizeBo.transactionValidatePin(paymentSession.getChannel(), "validatePin", paymentSession.getClientId(), paymentSession.getClientIp(), paymentSession.getPinUuid(), paymentSession.getType(), paymentSession.getAmount(), "", inputPinEnc);

	    		paymentSession.setValidatePinStatus(validatePin.getStatus());
		    	
		    	if ( validatePin.getStatus().equals("OK") ) {
		    		
//			    	if  ( !paymentSession.getPinEnc().equals(inputPinEnc) ) {
//
//			    		o.addProperty("status", "CODEERROR");
//			    		o.addProperty("mensajeerror", "C�digo incorrecto. Verifique si escribi� correctamente.");
//			    		result = "Pin de session no corresponde al Pin de ingreso"; 
//			    				
//			    	} else {
			    				    		
			    		o.addProperty("status", validatePin.getStatus());
			    		o.addProperty("type", paymentSession.getType());    		
			    		
//			    	}
			    		    		
		    	} else {

		    		if (validatePin.getStatus().equals("CODEERROR")) {
			    		o.addProperty("status", validatePin.getStatus());
			    		o.addProperty("mensajeerror", validatePin.getMensajeError());
		    		} else {

		        		o.addProperty("status", "ERROR");
		        		o.addProperty("titulo", "Ha ocurrido un incidente en la acci&oacute;n.");
		        		o.addProperty("mensaje", validatePin.getMensajeError()); 
		        		
		    		}
		    		
		    	}
				
			} catch (Exception e) {			

				LoggerApi.severe(e, valuuid.toString());
				
	    		o.addProperty("status", "ERROR");
	    		o.addProperty("titulo", "Ha ocurrido un incidente en el servicio");
	    		o.addProperty("mensaje","Por favor realice la acci&oacute;n nuevamente.");
	    		
			}
			
			TransactionPaymentLogPin sessionPin = null;
			try { 
				String status = o.getAsJsonObject().get("status").toString();
				sessionPin = paymentPrizeBo.transactionLogPin(paymentSession.getChannel(), "validateSessionPin", paymentSession.getClientId(), paymentSession.getClientIp(), paymentSession.getPinUuid(), paymentSession.getType(), paymentSession.getAmount()
							, status , o.toString()+" * "+result);
			} catch (Exception e) {
				LoggerApi.severe(e, "sessionPin="+sessionPin);			
			}

			out.print(o);
			
			LoggerApi.Log.info("-------------- END validateRequestTransferenciaPin valuuid="+valuuid.toString());
		}
		
	@RequestMapping(value = "/getConfigBannerCookie")
	public void getConfigBannerCookie(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
			throws Exception {
		UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START getConfigBannerCookie uuid="+uuid.toString());
		response.setCharacterEncoding(Constantes.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		try {

			PaymentPrizeProcedureGetDataCookie result = paymentPrizeBo.getDataCookie();
			o.addProperty("status", result.getStateBannerCookieModal());
			
			LoggerApi.Log.info("getStateBannerCookieModal" + result.getStateBannerCookieModal());
		} catch (Exception e) {
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e,uuid.toString());
		}
		out.print(o);
		LoggerApi.Log.info("-------------- END getConfigBannerCookie uuid="+uuid.toString());		
	}
	
	private String requestWSIflexApiRecharge(String json, String service) {
    	LoggerApi.Log.info("start requestWSIflexApiRecharge: "+json);
		String jsonResponseIflexApiRecharge="";
		try {
			String urlIflexapiRecharge = ConnectionFactory.operationProperty("urlIflexapiRecharge", Constantes.contextRechargeApi);
			String secretIflexapiRecharge = ConnectionFactory.operationProperty("secretIflexapiRecharge", Constantes.contextRechargeApi);
			String userIflexapiRecharge = ConnectionFactory.operationProperty("userIflexapiRecharge", Constantes.contextRechargeApi);
			String passIflexapiRecharge = ConnectionFactory.operationProperty("passIflexapiRecharge", Constantes.contextRechargeApi);
			String credenciales = userIflexapiRecharge+":"+passIflexapiRecharge;
			credenciales = Base64.encodeBase64String(credenciales.getBytes()); 	    	
 	    	URL url = new URL(urlIflexapiRecharge+service);
 			HttpURLConnection  con = (HttpURLConnection )url.openConnection();
 			con.setRequestMethod("POST");
 			con.setRequestProperty("Authorization", "Basic "+credenciales);
 			con.setRequestProperty("Secret", secretIflexapiRecharge);
 			con.setRequestProperty("Content-Type", Constantes.APPLICATION_JSON);
 			con.setRequestProperty("Accept", Constantes.APPLICATION_JSON);
     		con.setDoOutput(true);
     		OutputStream os = con.getOutputStream();
 			os.write(json.getBytes(Constantes.CHARSET_UTF8));
 			os.flush();
 			os.close();
 			BufferedReader br = null;
 			int responseCode = con.getResponseCode();
 			if(responseCode < HttpServletResponse.SC_BAD_REQUEST) {
 				br = new BufferedReader(new InputStreamReader((con.getInputStream()),Constantes.CHARSET_UTF8));
 			}else {
 				LoggerApi.Log.info("API TOKENGENERATION IFEXAPI-RECHARGE HTTP CODE: "+responseCode + " json: "+json);
 				br = new BufferedReader(new InputStreamReader((con.getErrorStream()),Constantes.CHARSET_UTF8));
 			}
 			StringBuilder sb = new StringBuilder();
 			char[] buffer = new char[1000];
 	        int leido;
 	        while ((leido = br.read(buffer)) > 0) {
 	        	sb.append(new String(buffer, 0, leido));
 	        }
 			br.close();
 			con.disconnect();
 			jsonResponseIflexApiRecharge = sb.toString();
 			if(responseCode >= HttpServletResponse.SC_BAD_REQUEST) {
 				LoggerApi.Log.info("API TOKENGENERATION IFEXAPI-RECHARGE"+ service+"Response: "+jsonResponseIflexApiRecharge + " json: "+json);	
 			}
 			LoggerApi.Log.info("API TOKENGENERATION IFEXAPI-RECHARGE "+service+"Response: "+jsonResponseIflexApiRecharge);
		} catch (Throwable e) {
			LoggerApi.severe(e);
		}finally {
			LoggerApi.Log.info("end requestWSIflexApiRecharge: "+jsonResponseIflexApiRecharge);
		}
		return jsonResponseIflexApiRecharge;
	}
		
}
