package pe.com.intralot.loto.layer.controller.client;

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
import java.math.BigDecimal;
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
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
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
import pe.com.intralot.loto.layer.dto.monnet.PayrollDetail;
import pe.com.intralot.loto.layer.dto.monnet.PayrollRequest;
import pe.com.intralot.loto.layer.dto.monnet.PayrollResponse;
import pe.com.intralot.loto.layer.dto.visa.Card;
import pe.com.intralot.loto.layer.dto.visa.FundsDisbursementsRequest;
import pe.com.intralot.loto.layer.dto.visa.FundsDisbursementsResponse;
import pe.com.intralot.loto.layer.dto.visa.JsonSessionForm;
import pe.com.intralot.loto.layer.dto.visa.Order;
import pe.com.intralot.loto.layer.dto.visa.Token;
import pe.com.intralot.loto.layer.dto.visa.TokenCardParameters;
import pe.com.intralot.loto.layer.dto.visa.TokenSessionParameters;
import pe.com.intralot.loto.layer.dto.visa.TokenizeCardResponse;
import pe.com.intralot.loto.layer.model.bean.DebitIdQrResponse;
import pe.com.intralot.loto.layer.model.bean.QrPPBean;
import pe.com.intralot.loto.layer.model.bean.SmsResultBean;
import pe.com.intralot.loto.layer.model.bean.TransactionPaymentToken;
import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.Client;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetDataClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureTokenValidation;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureCreateRequest;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureCreateRequestAutomatic;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureCreateRequestAutomaticDQR;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureCreateRequestTrans;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureCreateRequestTransAutomatic;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureCreateRequestVisa;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureCreateRequestVisaAutomatic;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureDefineDebitQR;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureDeleteAccount;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureEvalPopupInformativo;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureEvalRulesAutomatic;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureEvalRulesAutomaticV2;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetDataCollectPrizes;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetDataCookie;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetResultEvalRulesAgora;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetResultEvalRulesCash;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetResultEvalRulesTrans;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetResultEvalRulesVisa;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetSavingsAccount;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetTicketsPrizes;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetTicketsPrizesDebitQR;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetTicketsPrizesOld;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureHisPayment;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureInBlackList;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureListPrizesMajor;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureRegisterErrorCA;
import pe.com.intralot.loto.layer.model.domain.TransactionPaymentCreatePin;
import pe.com.intralot.loto.layer.model.domain.TransactionPaymentLogPin;
import pe.com.intralot.loto.layer.model.domain.TransactionPaymentValidatePin;
import pe.com.intralot.loto.layer.service.client.bo.PaymentPrizeBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.lib.StringLib;
import pe.com.intralot.loto.sale.card.dispatcher.BussinessSaleDispatcher;
import pe.com.intralot.loto.sale.card.dispatcher.GameSaleDispatcher;
import pe.com.intralot.loto.sale.card.model.WEBMessage;
import pe.com.intralot.loto.sale.card.model.WEBTicketPay;
import pe.com.intralot.loto.util.ClientUtils;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.DateAPI;
import pe.com.intralot.loto.util.GetResultKyc;
import pe.com.intralot.loto.util.LoggerApi;
import pe.com.intralot.loto.util.MailLib;
import pe.com.intralot.loto.util.QrUtil;
import pe.com.intralot.loto.util.SmsProviderUtils;
import sun.misc.BASE64Decoder;


@Controller
public class PaymentPrizeController {
	
	@Autowired
	private PaymentPrizeBo paymentPrizeBo;
    @Autowired
    private QrUtil qrUtil;
    String IMG_BASE64_COBRADO = "iVBORw0KGgoAAAANSUhEUgAAAEIAAABECAYAAAA1DeP1AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAQrSURBVHhe7ZjtS1RBFMb9w81kN9okpbRQP4RBQuAXX0AIs9DSoHJbV0vwbTWTNPqQhBhp6qlzmZvPnXvO7szuvRvB/ORh8cyZM3eevXdm9nZQICIYYQhGGDrK5TJlLQ0tB+MoRGpvVUgwwhCMMCSMaAWXOpijScMlxwWtTjDCEIwwqEZgXBPiEkchUjsLcYlrQrR4MMIQjDDkbgSi5WhxRMvBuCZEiwcjDMEIQ1uNQLT8VuKaEC0ejDAEIwyqEb7kXUeL+6LVCUYYghGGhBFZCckjnpWQYIQhGGHI/S22dAEsRGpntZNghKFtRrwtv6WJ9xM0sDFAxe0ide12UedOZ/TJ/3Oc2znvnxgRD1pPiNReTzyx0bVRKtQK0cQbqfixSE+/PaXzy3OxHssF3/xcjXi+/Jxub90WJ9xI/fv9UX+prgu++bkZMVOdoRvbN8RJuoofGa5j13bBN19dI7AQCtHiLysvqWerR5ycr/jOOPp1lBgLpSHl2kIyN+Lyz9+9jXvipJrVyOEIvXn3JjGePa6NlGsLydyIleMVul67Lk6oWXXvdtP4+/HEePa4NlKuLSRhhJTMcoHzlspL0TYoTcZVXTtd0dpybedaIv7w8GF0t9nY1xoLkdpZSKZGzC3PtbRA8tY5uTpJC5UFKm2VEm09ez309eyrGe0K+1pjIVI7C8nUCJ5Es49Faa9E6yfr9PrdaxpcH0y18+NRPa6a0a6wrzUWIrWzkMT2qeGSw7w4epGaAN/i9zfuU+9mb6otVu+nXtr/uU+nF6c0+mU09VjEevzhceoaXK8tRsvP3Qi+Q6ZWp6Jvmld/e5L8CBycHtDJxQk9OHiQaLP1XxvB4oPRk5UnqW+c7xI+c/A5YejzUKqfrVyNMJ910TpjnDWxOqGuEcVakaZXpv+uAXc279BiZZHml+fp7v5dsQ+K63J9e0xftL6ZGtFo1+AfXvyY8A8x3mpnq7N0c/ummGuL+z6rPkuN6YvWN1MjXM4RsRn8qPAjI+VI4rpc3x7TF62vkxE+VI4r0VYnTaZZ8SGL68bgZDQhWhzJ3Iizy7Nod5Am1Kz6N/qjujE4MU2IFkcyN4LhM8GtvVvipHzFaw6vJQhOTBOixRGn9xG+Ymo/ai2bEW+70hiSNKRcFpKbEQwflJp9L1HvDZUmDSmXheRqBMNb5aO1R86/QQq7hYbvLDVpSLksxOlk6YJWJ47xQerV91c0/HmYCh+TL3K7a93Ut9lHYx/GojysFQvR4i5ofdtmhB1HMEcTosVd0PoGIwyqERjXhLjEXYRI7a5CpHYWEowwBCMMuRuBYA7KBalfPSFaHAlGGIIRhrauES645GMOygUtPxhhCEYYVCN80er4xjV88xGXvsEIQzDCkDAiKyFSO0tDy/GNI5iDQoIRhmCEIZe32P8jwYgIot/0i6rONnza3QAAAABJRU5ErkJggg==";
	@Autowired
	ServletContext context; 
	
	private SimpleDateFormat sdfFront = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Gson gson = new Gson();
	
	@RequestMapping(value = "/pago-premio")
    public String payment_prizes(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
    	session.removeAttribute("PIN_SESSION");
    	return "client/collect_prize_form";
    	
    }
	
	@RequestMapping(value = "/getResultKyc")
    public void getResultKyc(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START getResultKYC uuid="+uuid.toString());
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
		JsonObject o = null;
		try {
			HttpSession session = request.getSession();
			Integer idClient = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
	        o = GetResultKyc.getResultKyc(idClient);
	        LoggerApi.Log.info("RESULT: "+ o +" - " +uuid.toString());
	        out.print(o);
		}catch (Exception e) {
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e,uuid.toString());
		}
		LoggerApi.Log.info("-------------- END getResultKYC uuid="+uuid.toString());
    }
	
	@RequestMapping(value = "/evalPopupInformativo")
	public void evalPopupInformativo(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
			throws Exception {
		UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START evalPopupInformativo uuid="+uuid.toString());
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		try {
			HttpSession session = request.getSession();
			if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
					&& ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
				Integer idClient = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
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
    public void getDataCollectPrizes(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START getDataCollectPrizes uuid="+uuid.toString());
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
    	try {
			HttpSession session = request.getSession();
			if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
				&& ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
				Integer idClient = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
				ClientProcedureGetDataClient client = (ClientProcedureGetDataClient) session.getAttribute("CLIENT_SESSION");
				PaymentPrizeProcedureGetDataCollectPrizes getDataCollectPrizes = paymentPrizeBo.getDataCollectPrizes(idClient);
				o.addProperty("status", Constants.RESULT_OK);
				o.addProperty("cid", idClient);
				o.addProperty("saldoLiquidable", getDataCollectPrizes.getSaldoLiquidable());
				o.addProperty("saldoLiquidableCompleto", ClientUtils.formatCurrency(getDataCollectPrizes.getSaldoLiquidableCompleto()));
				o.addProperty("amountMinRequestCash", getDataCollectPrizes.getAmountMinRequestCash());
				o.addProperty("amountMaxRequestCash", getDataCollectPrizes.getAmountMaxRequestCash());
				o.addProperty("amountMinRequestVisa",getDataCollectPrizes.getAmountMinRequestVisa());
				o.addProperty("amountMaxRequestVisa",getDataCollectPrizes.getAmountMaxRequestVisa());
				o.addProperty("maxMbPerImageVisa",getDataCollectPrizes.getMaxMbPerImageVisa());
				o.addProperty("stateDni",getDataCollectPrizes.getStateDni());
				o.addProperty("itemXPageHRDesktop", getDataCollectPrizes.getItemXPageHRDesktop());
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
				o.addProperty("balanceAmount", getDataCollectPrizes.getBalanceAmount());		
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
				o.addProperty("doctype", client.getTypeId().trim());
				o.addProperty("docnumber", client.getNumberId().trim());
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
					session.setAttribute("getSavingsAccount", getSavingsAccount);
				}
				
				List<PaymentPrizeProcedureListPrizesMajor> listPrizesMajor = paymentPrizeBo.listPrizesMajor(idClient);
				if(listPrizesMajor!=null && !listPrizesMajor.isEmpty()) {
					LoggerApi.Log.info("listPrizesMajor size="+listPrizesMajor.size());
					o.addProperty("listPrizesMajor", gson.toJson(listPrizesMajor));
					session.setAttribute("listPrizesMajor", listPrizesMajor);
				}else {
					LoggerApi.Log.info("listPrizesMajor null");
				}
				
				session.setAttribute("fullName", client.getNombre());
				session.setAttribute("lastName", client.getApPaterno()+" "+client.getApMaterno()!=null?client.getApMaterno():"");
				session.setAttribute("paymentPrizeProcedureGetDataCollectPrizes", getDataCollectPrizes);
			}else {
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

    @RequestMapping(value = "/getHisPayment")
    public void getHisPayment(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START getHisPayment uuid="+uuid.toString());
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
    	PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
    	try {
			HttpSession session = request.getSession();
			if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
				&& ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
				Integer idClient = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
				List<PaymentPrizeProcedureHisPayment> paymentPrizeProcedureHisPayment = paymentPrizeBo.getHisPayment(idClient);
				for (PaymentPrizeProcedureHisPayment hisPayment : paymentPrizeProcedureHisPayment) {
					if(hisPayment.getPaymentType().equalsIgnoreCase(Constants.TYPE_PAYMENT_VISA) || hisPayment.getPaymentType().equalsIgnoreCase(Constants.TYPE_PAYMENT_AGORA)) {
						if(hisPayment.getCardNumber()!=null && !hisPayment.getCardNumber().isEmpty()) {
							hisPayment.setCardNumber(StringLib.decodeLabel(hisPayment.getCardNumber()));
						}
					}
				}
				Gson gson = new Gson();
		        String result = gson.toJson(paymentPrizeProcedureHisPayment);
				o.addProperty("status", Constants.RESULT_OK);
				o.addProperty("cid", idClient);
				o.addProperty("hisPaymentSize", paymentPrizeProcedureHisPayment.size());
				o.addProperty("hisPayment", result);
				session.setAttribute("paymentPrizeProcedureHisPayment", paymentPrizeProcedureHisPayment);
				session.setAttribute("paymentPrizeProcedureHisPaymentFiltered", paymentPrizeProcedureHisPayment);
			}else {
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
    public void filterHisPayment(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START filterHisPayment uuid="+uuid.toString());
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
    	PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
    	try {
    		HttpSession session = request.getSession();
    		String typeFilterHisPayment = request.getParameter("typeFilterHisPayment");
    		String startdate = request.getParameter("startdate");
    		String enddate = request.getParameter("enddate");
    		List<PaymentPrizeProcedureHisPayment> filteredList = new ArrayList<PaymentPrizeProcedureHisPayment>();
    		List<PaymentPrizeProcedureHisPayment> paymentPrizeProcedureHisPayment = (List<PaymentPrizeProcedureHisPayment>) session.getAttribute("paymentPrizeProcedureHisPayment");
    		Gson gson = new Gson();
    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    		String fecha = sdf.format(new Date());
	        Calendar calendario = Calendar.getInstance();
	        calendario.setTime(sdf.parse(fecha));
    		if(typeFilterHisPayment.trim().equals(Constants.FILTER_TYPE_ALL)) {
    			String result = gson.toJson(paymentPrizeProcedureHisPayment);
    			o.addProperty("hisPaymentSize", paymentPrizeProcedureHisPayment.size());
				o.addProperty("hisPayment", result);
				o.addProperty("status", Constants.RESULT_OK);
				session.setAttribute("paymentPrizeProcedureHisPaymentFiltered", paymentPrizeProcedureHisPayment);
    		}else if(typeFilterHisPayment.trim().equals(Constants.FILTER_TYPE_LAST_WEEK)) {
    			calendario.add(Calendar.DAY_OF_YEAR, -7);
    			for (PaymentPrizeProcedureHisPayment record : paymentPrizeProcedureHisPayment) {
    				Date requestDateHour = sdf.parse(record.getRequestDateHour());
    				if(requestDateHour.getTime()>=calendario.getTime().getTime()) {
    					filteredList.add(record);
    				}
        		}
    			String result = gson.toJson(filteredList);
    			o.addProperty("hisPaymentSize", filteredList.size());
				o.addProperty("hisPayment", result);
				o.addProperty("status", Constants.RESULT_OK);
				session.setAttribute("paymentPrizeProcedureHisPaymentFiltered", filteredList);
    		}else if(typeFilterHisPayment.trim().equals(Constants.FILTER_TYPE_LAST_MONTH)) {
    			calendario.add(Calendar.DAY_OF_YEAR, -30);
    			for (PaymentPrizeProcedureHisPayment record : paymentPrizeProcedureHisPayment) {
    				Date requestDateHour = sdf.parse(record.getRequestDateHour());
    				if(requestDateHour.getTime()>=calendario.getTime().getTime()) {
    					filteredList.add(record);
    				}
        		}
    			String result = gson.toJson(filteredList);
    			o.addProperty("hisPaymentSize", filteredList.size());
				o.addProperty("hisPayment", result);
				o.addProperty("status", Constants.RESULT_OK);
				session.setAttribute("paymentPrizeProcedureHisPaymentFiltered", filteredList);
    		}else if(typeFilterHisPayment.trim().equals(Constants.FILTER_TYPE_RANGE)) {
    			Date fechaIni = null;
    			Date fechaFin = null;
    			try {
					fechaIni = sdf.parse(startdate);
					fechaFin = sdf.parse(enddate);
					if(fechaIni.getTime()<=fechaFin.getTime()) {
						calendario.setTime(sdf.parse(enddate));
						calendario.add(Calendar.YEAR, -1);
						if(fechaIni.getTime()>=calendario.getTime().getTime()) {
							Integer idClient = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
							List<PaymentPrizeProcedureHisPayment> filteredListRange = paymentPrizeBo.getHisPaymentByReangeDate(idClient, startdate, enddate);
							String result = gson.toJson(filteredListRange);
			    			o.addProperty("hisPaymentSize", filteredListRange.size());
							o.addProperty("hisPayment", result);
							o.addProperty("status", Constants.RESULT_OK);
							session.setAttribute("paymentPrizeProcedureHisPaymentFiltered", filteredListRange);
						}else {
							o.addProperty("status", "ERROR_FECHA");
							o.addProperty("message",Constants.MSG_DATE_OUT_RANGE);
						}
					}else {
						o.addProperty("status", "ERROR_FECHA");
						o.addProperty("message", Constants.MSG_RANGE_INVALID_DATE);
					}
				} catch (Exception e) {
					o.addProperty("status", "ERROR_FECHA");
					o.addProperty("message", Constants.MSG_INVALID_DATE);
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
    public void sendMailTicketsPP(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START sendMailTicketsPP uuid="+uuid.toString());
    	PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
    	try {
    		HttpSession session = request.getSession();
    		String mail = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpMail();
    		if(mail!=null && !mail.trim().isEmpty()) {
    			System.out.println("*************************************************************revision");
	    		String fullName = session.getAttribute("fullName").toString().split(" ")[0]+" "+session.getAttribute("lastName").toString().split(" ")[0];
	    		String requestNumberPDF = session.getAttribute("requestNumberPDF").toString();
	    		String requestDateHourFrontTicketPDF = session.getAttribute("requestDateHourFrontTicketPDF").toString();
	    		String docNumberFrontTicketPDF = session.getAttribute("docNumberFrontTicketPDF").toString();
	    		String requestAmountFrontTicketPDF = session.getAttribute("requestAmountFrontTicketPDF").toString();
	    		String clientIdQR = session.getAttribute("clientIdQR").toString();
	    		String nombresQR = session.getAttribute("nombresQR").toString();
	    		List<PaymentPrizeProcedureGetTicketsPrizes> paymentPrizeProcedureGetTicketsPrizesPDF = (List<PaymentPrizeProcedureGetTicketsPrizes>) session.getAttribute("paymentPrizeProcedureGetTicketsPrizesPDF");
	    		List<QrPPBean> listaQR = new ArrayList<QrPPBean>();
	    		
	    		QrPPBean qrPPBean = new QrPPBean();
	    		int contador = 1;
	    		if(paymentPrizeProcedureGetTicketsPrizesPDF.size()>0) {
	    			PaymentPrizeProcedureGetTicketsPrizes record = paymentPrizeProcedureGetTicketsPrizesPDF.get(0);
	    			if(record.getStatus().equalsIgnoreCase(Constants.PENDIENTE)) {
						String base64QR = qrUtil.generateQR(StringLib.decodeLabel(record.getBarcode()));
						qrPPBean.setQr1(base64QR);
					}else if(record.getStatus().equalsIgnoreCase(Constants.COBRADO)) {
						qrPPBean.setQr1(IMG_BASE64_COBRADO);
					} 
					qrPPBean.setPrize1(record.getPrize());
					qrPPBean.setVal1(record.getValPrinted());
					contador++;
	    		}
	    		
	    		if(paymentPrizeProcedureGetTicketsPrizesPDF.size()==1) {
	    			listaQR.add(qrPPBean);
	    			contador=0;
	    		}
	    		
	    		for (int i = 1; i < paymentPrizeProcedureGetTicketsPrizesPDF.size(); i++) {
	    			PaymentPrizeProcedureGetTicketsPrizes record = paymentPrizeProcedureGetTicketsPrizesPDF.get(i);
	    			if(contador==1) {
	    				if(record.getStatus().equalsIgnoreCase(Constants.PENDIENTE)) {
	    					String base64QR = qrUtil.generateQR(StringLib.decodeLabel(record.getBarcode()));
	    					qrPPBean.setQr1(base64QR);
	    				}else if(record.getStatus().equalsIgnoreCase(Constants.COBRADO)) {
	    					qrPPBean.setQr1(IMG_BASE64_COBRADO);
	    				} 
	    				qrPPBean.setPrize1(record.getPrize());
	    				qrPPBean.setVal1(record.getValPrinted());
	    				contador++;
	    			}else if(contador==2) {
	    				if(record.getStatus().equalsIgnoreCase(Constants.PENDIENTE)) {
	    					String base64QR = qrUtil.generateQR(StringLib.decodeLabel(record.getBarcode()));
	    					qrPPBean.setQr2(base64QR);
	    				}else if(record.getStatus().equalsIgnoreCase(Constants.COBRADO)) {
	    					qrPPBean.setQr2(IMG_BASE64_COBRADO);
	    				} 
	    				qrPPBean.setPrize2(record.getPrize());
	    				qrPPBean.setVal2(record.getValPrinted());
	    				contador++;
	    			}else if(contador==3) {
	    				if(record.getStatus().equalsIgnoreCase(Constants.PENDIENTE)) {
	    					String base64QR = qrUtil.generateQR(StringLib.decodeLabel(record.getBarcode()));
	    					qrPPBean.setQr3(base64QR);
	    				}else if(record.getStatus().equalsIgnoreCase(Constants.COBRADO)) {
	    					qrPPBean.setQr3(IMG_BASE64_COBRADO);
	    				} 
	    				qrPPBean.setPrize3(record.getPrize());
	    				qrPPBean.setVal3(record.getValPrinted());
	    				contador++;
	    			}else if(contador==4) {
	    				if(record.getStatus().equalsIgnoreCase(Constants.PENDIENTE)) {
	    					String base64QR = qrUtil.generateQR(StringLib.decodeLabel(record.getBarcode()));
	    					qrPPBean.setQr4(base64QR);
	    				}else if(record.getStatus().equalsIgnoreCase(Constants.COBRADO)) {
	    					qrPPBean.setQr4(IMG_BASE64_COBRADO);
	    				} 
	    				qrPPBean.setPrize4(record.getPrize());
	    				qrPPBean.setVal4(record.getValPrinted());
	    				contador=1;
	    				listaQR.add(qrPPBean);
	    				qrPPBean = new QrPPBean();
	    			}
				}
	    		
	    		if(contador==2 || contador==3 || contador==4) {
	    			listaQR.add(qrPPBean);
	    		}
	    		    		
		    	JasperReport reporte = (JasperReport) JRLoader.loadObject(new File(Constants.BASE_PATH_TEMPLATE+Constants.JR_MAIL_PP));
				Map<String, Object> parametrosReporte = new HashMap<String, Object>();
				parametrosReporte.put("requestNumber", requestNumberPDF);
				parametrosReporte.put("requestDateHour", requestDateHourFrontTicketPDF);
				parametrosReporte.put("docNumber", docNumberFrontTicketPDF);
				parametrosReporte.put("requestAmount", Constants.MONEDA_SOLES+requestAmountFrontTicketPDF);
				parametrosReporte.put("clientId", clientIdQR);
				parametrosReporte.put("nombres", nombresQR);
				
				JasperPrint jpTickets = JasperFillManager.fillReport(reporte,parametrosReporte,new JRBeanCollectionDataSource(listaQR));
				byte[] bytes = JasperExportManager.exportReportToPdf(jpTickets);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				baos.write(bytes);
				baos.flush();
				baos.close();
				
				String body = getHtmlMailTicketsPP(fullName);				
				
		        MailLib.sendValidMail("micuenta"+Constants.DOMAIN_MAIL, "LA TINKA",mail, fullName+Constants.PP_MAIL_SUBJECT_PART1+requestNumberPDF+Constants.PP_MAIL_SUBJECT_PART2, body, 
		        		Constants.FORMAT_HTML_UTF8, baos, Constants.BASE_NAME_FILE_PP+requestNumberPDF+Constants.EXTENSION_PDF,context.getRealPath(Constants.INTERNAL_PATH_LOGO_MAIL), context.getRealPath(Constants.INTERNAL_PATH_LOGOS_JUEGOS_MAIL_V2));
	    		o.addProperty("status", Constants.RESULT_OK);
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
    
	@RequestMapping(value = "/downloadTicketsPP", produces = {
			MediaType.APPLICATION_OCTET_STREAM_VALUE }, method = RequestMethod.POST)
	public @ResponseBody void downloadTicketsPP(HttpServletRequest request,HttpServletResponse response){
		UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START downloadTicketsPP uuid="+uuid.toString());
    	try {
    		HttpSession session = request.getSession();
    		String requestNumberPDF = session.getAttribute("requestNumberPDF").toString();
    		String requestDateHourFrontTicketPDF = session.getAttribute("requestDateHourFrontTicketPDF").toString();
    		String docNumberFrontTicketPDF = session.getAttribute("docNumberFrontTicketPDF").toString();
    		String requestAmountFrontTicketPDF = session.getAttribute("requestAmountFrontTicketPDF").toString();
    		String clientIdQR = session.getAttribute("clientIdQR").toString();
    		String nombresQR = session.getAttribute("nombresQR").toString();
    		    		
    		List<PaymentPrizeProcedureGetTicketsPrizes> paymentPrizeProcedureGetTicketsPrizesPDF = (List<PaymentPrizeProcedureGetTicketsPrizes>) session.getAttribute("paymentPrizeProcedureGetTicketsPrizesPDF");
    		List<QrPPBean> listaQR = new ArrayList<QrPPBean>();
    		
    		QrPPBean qrPPBean = new QrPPBean();
    		int contador = 1;
    		if(paymentPrizeProcedureGetTicketsPrizesPDF.size()>0) {
    			PaymentPrizeProcedureGetTicketsPrizes record = paymentPrizeProcedureGetTicketsPrizesPDF.get(0);
    			if(record.getStatus().equalsIgnoreCase(Constants.PENDIENTE)) {
					String base64QR = qrUtil.generateQR(StringLib.decodeLabel(record.getBarcode()));
					qrPPBean.setQr1(base64QR);
				}else if(record.getStatus().equalsIgnoreCase(Constants.COBRADO)) {
					qrPPBean.setQr1(IMG_BASE64_COBRADO);
				} 
				qrPPBean.setPrize1(record.getPrize());
				qrPPBean.setVal1(record.getValPrinted());
				contador++;
    		}
    		
    		if(paymentPrizeProcedureGetTicketsPrizesPDF.size()==1) {
    			listaQR.add(qrPPBean);
    			contador=0;
    		}
    		
    		for (int i = 1; i < paymentPrizeProcedureGetTicketsPrizesPDF.size(); i++) {
    			PaymentPrizeProcedureGetTicketsPrizes record = paymentPrizeProcedureGetTicketsPrizesPDF.get(i);
    			if(contador==1) {
    				if(record.getStatus().equalsIgnoreCase(Constants.PENDIENTE)) {
    					String base64QR = qrUtil.generateQR(StringLib.decodeLabel(record.getBarcode()));
    					qrPPBean.setQr1(base64QR);
    				}else if(record.getStatus().equalsIgnoreCase(Constants.COBRADO)) {
    					qrPPBean.setQr1(IMG_BASE64_COBRADO);
    				} 
    				qrPPBean.setPrize1(record.getPrize());
    				qrPPBean.setVal1(record.getValPrinted());
    				contador++;
    			}else if(contador==2) {
    				if(record.getStatus().equalsIgnoreCase(Constants.PENDIENTE)) {
    					String base64QR = qrUtil.generateQR(StringLib.decodeLabel(record.getBarcode()));
    					qrPPBean.setQr2(base64QR);
    				}else if(record.getStatus().equalsIgnoreCase(Constants.COBRADO)) {
    					qrPPBean.setQr2(IMG_BASE64_COBRADO);
    				} 
    				qrPPBean.setPrize2(record.getPrize());
    				qrPPBean.setVal2(record.getValPrinted());
    				contador++;
    			}else if(contador==3) {
    				if(record.getStatus().equalsIgnoreCase(Constants.PENDIENTE)) {
    					String base64QR = qrUtil.generateQR(StringLib.decodeLabel(record.getBarcode()));
    					qrPPBean.setQr3(base64QR);
    				}else if(record.getStatus().equalsIgnoreCase(Constants.COBRADO)) {
    					qrPPBean.setQr3(IMG_BASE64_COBRADO);
    				} 
    				qrPPBean.setPrize3(record.getPrize());
    				qrPPBean.setVal3(record.getValPrinted());
    				contador++;
    			}else if(contador==4) {
    				if(record.getStatus().equalsIgnoreCase(Constants.PENDIENTE)) {
    					String base64QR = qrUtil.generateQR(StringLib.decodeLabel(record.getBarcode()));
    					qrPPBean.setQr4(base64QR);
    				}else if(record.getStatus().equalsIgnoreCase(Constants.COBRADO)) {
    					qrPPBean.setQr4(IMG_BASE64_COBRADO);
    				} 
    				qrPPBean.setPrize4(record.getPrize());
    				qrPPBean.setVal4(record.getValPrinted());
    				contador=1;
    				listaQR.add(qrPPBean);
    				qrPPBean = new QrPPBean();
    			}
			}
    		
    		if(contador==2 || contador==3 || contador==4) {
    			listaQR.add(qrPPBean);
    		}
    		    		
	    	JasperReport reporte = (JasperReport) JRLoader.loadObject(new File(Constants.BASE_PATH_TEMPLATE+Constants.JR_MAIL_PP));
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();
			parametrosReporte.put("requestNumber", requestNumberPDF);
			parametrosReporte.put("requestDateHour", requestDateHourFrontTicketPDF);
			parametrosReporte.put("docNumber", docNumberFrontTicketPDF);
			parametrosReporte.put("requestAmount", Constants.MONEDA_SOLES+requestAmountFrontTicketPDF);
			parametrosReporte.put("clientId", clientIdQR);
			parametrosReporte.put("nombres", nombresQR);
			
			JasperPrint jpTickets = JasperFillManager.fillReport(reporte,parametrosReporte,new JRBeanCollectionDataSource(listaQR));
			OutputStream os = response.getOutputStream();
			byte[] bystes = JasperExportManager.exportReportToPdf(jpTickets);			
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename="+Constants.BASE_NAME_FILE_PP+requestNumberPDF+Constants.EXTENSION_PDF);
			os.write(bystes);
	        os.close();     
    	}catch (Exception e) {
    		LoggerApi.severe(e,uuid.toString());
		}
    	LoggerApi.Log.info("-------------- END downloadTicketsPP uuid="+uuid.toString());
    }
	
	@RequestMapping(value = "/sendMailTicketsPPDebitIdQR")
    public void sendMailTicketsPPDebitIdQR(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START sendMailTicketsPPDebitIdQR uuid="+uuid.toString());
    	PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
    	try {
    		HttpSession session = request.getSession();
    		String mail = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpMail();
    		if(mail!=null && !mail.trim().isEmpty()) {
	    		String fullName = session.getAttribute("fullName").toString().split(" ")[0]+" "+session.getAttribute("lastName").toString().split(" ")[0];
	    		String requestNumberPDF = session.getAttribute("requestNumberPDF").toString();
	    		String requestDateHourFrontTicketPDF = session.getAttribute("requestDateHourFrontTicketPDF").toString();
	    		String docNumberFrontTicketPDF = session.getAttribute("docNumberFrontTicketPDF").toString();
	    		String requestAmountFrontTicketPDF = session.getAttribute("requestAmountFrontTicketPDF").toString();
	    		String clientIdQR = session.getAttribute("clientIdQR").toString();
	    		String nombresQR = session.getAttribute("nombresQR").toString();
	    		List<PaymentPrizeProcedureGetTicketsPrizesDebitQR> paymentPrizeProcedureGetTicketsPrizesPDF = (List<PaymentPrizeProcedureGetTicketsPrizesDebitQR>) session.getAttribute("paymentPrizeProcedureGetTicketsPrizesPDF");
	    		List<QrPPBean> listaQR = new ArrayList<QrPPBean>();	    		
	    		QrPPBean qrPPBean = new QrPPBean();
    			PaymentPrizeProcedureGetTicketsPrizesDebitQR record = paymentPrizeProcedureGetTicketsPrizesPDF.get(0);
    			if(record.getStatus().equalsIgnoreCase(Constants.PENDIENTE)) {
					String base64QR = qrUtil.generateQRStringDebitId(record.getBarcode());
					qrPPBean.setQr1(base64QR);
				}else if(record.getStatus().equalsIgnoreCase(Constants.COBRADO)) {
					qrPPBean.setQr1(IMG_BASE64_COBRADO);
				} 
				qrPPBean.setPrize1(record.getPrize());
				listaQR.add(qrPPBean);    		
	    			    		    		
		    	JasperReport reporte = (JasperReport) JRLoader.loadObject(new File(Constants.BASE_PATH_TEMPLATE+Constants.JR_MAIL_DEBITIDQR_PP));
				Map<String, Object> parametrosReporte = new HashMap<String, Object>();
				parametrosReporte.put("requestNumber", requestNumberPDF);
				parametrosReporte.put("requestDateHour", requestDateHourFrontTicketPDF);
				parametrosReporte.put("docNumber", docNumberFrontTicketPDF);
				parametrosReporte.put("requestAmount", Constants.MONEDA_SOLES+requestAmountFrontTicketPDF);
				parametrosReporte.put("clientId", clientIdQR);
				parametrosReporte.put("nombres", nombresQR);
				
				JasperPrint jpTickets = JasperFillManager.fillReport(reporte,parametrosReporte,new JRBeanCollectionDataSource(listaQR));
				byte[] bytes = JasperExportManager.exportReportToPdf(jpTickets);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				baos.write(bytes);
				baos.flush();
				baos.close();
				
				String body = getHtmlMailTicketsPP(fullName);				
				
		        MailLib.sendValidMail("micuenta"+Constants.DOMAIN_MAIL, "LA TINKA",mail, fullName+Constants.PP_MAIL_SUBJECT_PART1+requestNumberPDF+Constants.PP_MAIL_SUBJECT_PART2, body, 
		        		Constants.FORMAT_HTML_UTF8, baos, Constants.BASE_NAME_FILE_PP+requestNumberPDF+Constants.EXTENSION_PDF,context.getRealPath(Constants.INTERNAL_PATH_LOGO_MAIL), context.getRealPath(Constants.INTERNAL_PATH_LOGOS_JUEGOS_MAIL_V2));
	    		o.addProperty("status", Constants.RESULT_OK);
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
	
	@RequestMapping(value = "/downloadTicketsPPDebitIdQR", produces = {
			MediaType.APPLICATION_OCTET_STREAM_VALUE }, method = RequestMethod.POST)
	public @ResponseBody void downloadTicketsPPDebitIdQR(HttpServletRequest request,HttpServletResponse response){
		UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START downloadTicketsPPDebitIdQR uuid="+uuid.toString());
    	try {
    		HttpSession session = request.getSession();
    		String requestNumberPDF = session.getAttribute("requestNumberPDF").toString();
    		String requestDateHourFrontTicketPDF = session.getAttribute("requestDateHourFrontTicketPDF").toString();
    		String docNumberFrontTicketPDF = session.getAttribute("docNumberFrontTicketPDF").toString();
    		String requestAmountFrontTicketPDF = session.getAttribute("requestAmountFrontTicketPDF").toString();
    		String clientIdQR = session.getAttribute("clientIdQR").toString();
    		String nombresQR = session.getAttribute("nombresQR").toString();
    		    		
    		List<PaymentPrizeProcedureGetTicketsPrizesDebitQR> paymentPrizeProcedureGetTicketsPrizesPDF = (List<PaymentPrizeProcedureGetTicketsPrizesDebitQR>) session.getAttribute("paymentPrizeProcedureGetTicketsPrizesPDF");
    		List<QrPPBean> listaQR = new ArrayList<QrPPBean>();  		
    		QrPPBean qrPPBean = new QrPPBean();
			PaymentPrizeProcedureGetTicketsPrizesDebitQR record = paymentPrizeProcedureGetTicketsPrizesPDF.get(0);
			if(record.getStatus().equalsIgnoreCase(Constants.PENDIENTE)) {
				String base64QR = qrUtil.generateQRStringDebitId(record.getBarcode());
				qrPPBean.setQr1(base64QR);
			}else if(record.getStatus().equalsIgnoreCase(Constants.COBRADO)) {
				qrPPBean.setQr1(IMG_BASE64_COBRADO);
			} 
			qrPPBean.setPrize1(record.getPrize());
			listaQR.add(qrPPBean);
    		
	    	JasperReport reporte = (JasperReport) JRLoader.loadObject(new File(Constants.BASE_PATH_TEMPLATE+Constants.JR_MAIL_DEBITIDQR_PP));
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();
			parametrosReporte.put("requestNumber", requestNumberPDF);
			parametrosReporte.put("requestDateHour", requestDateHourFrontTicketPDF);
			parametrosReporte.put("docNumber", docNumberFrontTicketPDF);
			parametrosReporte.put("requestAmount", Constants.MONEDA_SOLES+requestAmountFrontTicketPDF);
			parametrosReporte.put("clientId", clientIdQR);
			parametrosReporte.put("nombres", nombresQR);
			
			JasperPrint jpTickets = JasperFillManager.fillReport(reporte,parametrosReporte,new JRBeanCollectionDataSource(listaQR));
			OutputStream os = response.getOutputStream();
			byte[] bystes = JasperExportManager.exportReportToPdf(jpTickets);			
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename="+Constants.BASE_NAME_FILE_PP+requestNumberPDF+Constants.EXTENSION_PDF);
			os.write(bystes);
	        os.close();     
    	}catch (Exception e) {
    		LoggerApi.severe(e,uuid.toString());
		}
    	LoggerApi.Log.info("-------------- END downloadTicketsPPDebitIdQR uuid="+uuid.toString());
    }
    
    @RequestMapping(value = "/createRequest")
    public void createRequest(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START createRequest uuid="+uuid.toString());
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
    	PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
        o.addProperty("paymentType", "EFECTIVO");
        TransactionPaymentToken paymentSession = null;
		HttpSession session = request.getSession();
        try {
			Integer clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();		
    		Double amountEfectivo = Double.parseDouble(request.getParameter("amountEfectivo"));

			TransactionPaymentLogPin sessionPin = null;
			String resultPin = "";
			paymentSession = (TransactionPaymentToken) session.getAttribute("PIN_SESSION");
			if ( paymentSession!=null && paymentSession.getValidatePinStatus()!=null && paymentSession.getValidatePinStatus().equals("OK") ) {
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
    			paymentPrizeBo.transactionRequestIp("DESKTOP","createRequest", clientId+"", ClientUtils.getClientIp(request), paymentSession.getPinUuid(), "EFECTIVO", amountEfectivo+"" );
		    } catch (Exception ex) {
		    	try { LoggerApi.severe(ex, "cid="+clientId+" ip="+ClientUtils.getClientIp(request)); } catch (Exception e) {;}
		    }
    		
    		String imgDNI = request.getParameter("imgDNI")!=null?request.getParameter("imgDNI"):"";
		    String kycResult = request.getParameter("kycResult")!=null?request.getParameter("kycResult"):"";
			PaymentPrizeProcedureGetDataCollectPrizes paymentPrizeProcedureGetDataCollectPrizes = (PaymentPrizeProcedureGetDataCollectPrizes)session.getAttribute("paymentPrizeProcedureGetDataCollectPrizes");
			Double saldoLiquidable = paymentPrizeProcedureGetDataCollectPrizes.getSaldoLiquidable();
    		
			String flujoDocumento = paymentPrizeProcedureGetDataCollectPrizes.getRequiredKycVisa()!=null?paymentPrizeProcedureGetDataCollectPrizes.getRequiredKycVisa():"";
			
			LoggerApi.Log.info("sigue flujoDNI:" + flujoDocumento);
			if(amountEfectivo>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRequestCash() && amountEfectivo<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxRequestCash()) {
				PaymentPrizeProcedureGetResultEvalRulesCash paymentPrizeProcedureGetResultEvalRulesCash = paymentPrizeBo.getResultEvalRulesCash(clientId,amountEfectivo);
				int accAmtCash = paymentPrizeProcedureGetResultEvalRulesCash.getAccAmtCash().intValue();
				LoggerApi.Log.info("accAmtCash:" + accAmtCash);
				if(paymentPrizeProcedureGetResultEvalRulesCash.getResult().trim().equals(Constants.RESULT_OK)) {
					String loadedImage = Constants.LOADED_IMAGE_NO;
					if(saldoLiquidable==0) {
		    			o.addProperty("status", "ERROR_MONTO");
		    			o.addProperty("message", Constants.MSG_NO_CREDIT);
		    		}else if(amountEfectivo>saldoLiquidable) {
		    			o.addProperty("status", "ERROR_MONTO");
		    			o.addProperty("message", Constants.MSG_NO_CREDIT_SUFICENT);
		    		}
		    		else if (flujoDocumento.equalsIgnoreCase("ACTIVO") && (kycResult.trim().isEmpty() && amountEfectivo >= paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRequiredKycEf().intValue()) ) { // validar si es flujo KYC o DNI
		    			LoggerApi.Log.info("ERROR_DNI pasar verificacib kyc");
						o.addProperty("status", "ERROR_DNI");
						o.addProperty("message", Constants.MSG_DNI_NOT_LOADED);
						
					} else if (!flujoDocumento.equalsIgnoreCase("ACTIVO") && (!paymentPrizeProcedureGetDataCollectPrizes.getStateDni().equals(Constants.DNI_STATE_ACTIVE)&& imgDNI.trim().isEmpty()&& (amountEfectivo >= paymentPrizeProcedureGetDataCollectPrizes.getAmountMinEnblDniCash().intValue()|| (amountEfectivo + accAmtCash) >= paymentPrizeProcedureGetDataCollectPrizes.getMinAccAmtEnblDniCash())) ) {
						LoggerApi.Log.info("ERROR_DNI subir foto dni" );
						o.addProperty("status", "ERROR_DNI");
						o.addProperty("message", Constants.MSG_DNI_NOT_LOADED);
					}else {
		    			
		    			boolean errorDocumento= true;
		    			
		    			 if (flujoDocumento.equalsIgnoreCase("ACTIVO")) {
		    				 boolean errorKyc = true;
								if (!kycResult.trim().isEmpty() && (kycResult.equals("verified") || kycResult.equals("rejected") || kycResult.equals("reviewNeeded"))) {
									errorKyc = false;
								}
								errorDocumento=errorKyc;
		    			 }else {
		    				 LoggerApi.Log.info("validar dni");
						boolean errorDNI = false;
						Double peso = 0.0;
						if(amountEfectivo>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinEnblDniCash().intValue() ||
							(amountEfectivo+accAmtCash)>=paymentPrizeProcedureGetDataCollectPrizes.getMinAccAmtEnblDniCash() ) {
							BASE64Decoder decoder = new BASE64Decoder();
							byte[] decodedBytes = decoder.decodeBuffer(imgDNI.replace("data:image/png;base64,", "").replace("data:image/jpeg;base64,", ""));
							peso = (double) decodedBytes.length;
							if( (peso/1024/1024)<=paymentPrizeProcedureGetDataCollectPrizes.getMaxMbPerImageVisa().intValue()) {
								if(!imgDNI.trim().isEmpty()) {
									loadedImage=Constants.LOADED_IMAGE_YES;
									try {
										ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
										BufferedImage image = ImageIO.read(bis);
								        bis.close();
								        if(image==null) {
								        	errorDNI = true;
											o.addProperty("status", "ERROR_DNI");
											o.addProperty("message", Constants.MSG_DNI_NOT_VALID);
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
								o.addProperty("message", Constants.MSG_DNI_LIMIT_MB+paymentPrizeProcedureGetDataCollectPrizes.getMaxMbPerImageVisa().intValue()+Constants.MB);
							}
						}
								errorDocumento=errorDNI;
		    			 }
						
		    			 LoggerApi.Log.info("efectivo errorDocumento:" + errorDocumento);
		    			if(!errorDocumento) {
		    			 //if(!errorKyc) {
						//if(!errorDNI) {
			    			String ip = request.getRemoteAddr();
			    			
							//reglas pp automatico
							boolean flagEvalRulesAutomatic=false;
							String whiteList = paymentPrizeProcedureGetDataCollectPrizes.getWhiteList();
							/*Si no está en lista blanca se evalua si puede ser automático */
							/*if(!whiteList.trim().equalsIgnoreCase("ACT")) {
								if(amountEfectivo<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxAutomaticCash()) {
									PaymentPrizeProcedureEvalRulesAutomaticV2 objEvalRulesAutomatic=paymentPrizeBo.evalRulesAutomaticV2(clientId,Constants.TYPE_PAYMENT_CASH);
									if(objEvalRulesAutomatic!=null && objEvalRulesAutomatic.getResult().trim().equals(Constants.RESULT_OK)) {
										flagEvalRulesAutomatic=true;
									}
								}
							}else {
								flagEvalRulesAutomatic=true;
							}*/
							
							if(amountEfectivo<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxAutomaticCash()) {
								PaymentPrizeProcedureEvalRulesAutomaticV2 objEvalRulesAutomatic=paymentPrizeBo.evalRulesAutomaticV2(clientId,Constants.TYPE_PAYMENT_CASH);
								if(objEvalRulesAutomatic!=null && objEvalRulesAutomatic.getResult().trim().equals(Constants.RESULT_OK)) {
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
				    			PaymentPrizeProcedureCreateRequest result = paymentPrizeBo.createRequest(clientId.toString(), amountEfectivo, ip, Constants.TYPE_PAYMENT_CASH, Constants.PLATAFORM, imgDNI, loadedImage);
				    			if(result.getMessage()!=null && result.getMessage().trim().equalsIgnoreCase(Constants.RESULT_OK)) {
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
									}*/
									session.setAttribute("paymentPrizeProcedureGetDataCollectPrizes", paymentPrizeProcedureGetDataCollectPrizes);
				    			}
				    			
				    			o.addProperty("message", result.getMessage());
				    			o.addProperty("amount", result.getAmount());
				    			o.addProperty("requestNumber", result.getRequestNumber());
				    			o.addProperty("status", Constants.RESULT_OK);
				    			o.addProperty("messageSuccess", Constants.MSG_SUCCESS_REQUEST_CASH);
				    			o.addProperty("evaluacion", "MANUAL");
			    			}else {
								//aprobacion automatica
			    				PaymentPrizeProcedureInBlackList paymentPrizeProcedureInBlackList = paymentPrizeBo.inBlackList(clientId);
								if(paymentPrizeProcedureInBlackList.getResult()!=null && paymentPrizeProcedureInBlackList.getResult().trim().equals(Constants.BLACKLIST_INACTIVE)) {
									String message = "OK";
									String amountResponse = "0";
									String requestNumber = "0";
									
									Object[] values = new Object[3];
									values[0] = clientId;
									values[1] = amountEfectivo;
									values[2] = "AUTOMATICO";
									PaymentPrizeProcedureDefineDebitQR defineDebitQR = paymentPrizeBo.defineDebitQR(values);
									LoggerApi.Log.info("defineDebitQR Message="+defineDebitQR.getMessage()+
											" State="+defineDebitQR.getState()+
											" DebitIdQR="+defineDebitQR.getDebitIdQR()+
											" KironprizeAmount="+defineDebitQR.getKironprizeAmount()+
											" NeoprizeAmount="+defineDebitQR.getNeoprizeAmount()
											);
									if(defineDebitQR!=null && defineDebitQR.getState()!=null && defineDebitQR.getState().trim().equals(Constants.RESULT_OK)) {
										String urlDebitIdQR = ConnectionFactory.operationProperty("urlDebitIdQR", Constants.contextSale);
										String userDebitIdQR = ConnectionFactory.operationProperty("userDebitIdQR", Constants.contextSale);
										String passDebitIdQR = ConnectionFactory.operationProperty("passDebitIdQR", Constants.contextSale);
										String tokenDebitIdQR = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constants.contextPlayerWebApi);
										
										JsonObject jdata = new JsonObject();	  
										jdata.addProperty("token", tokenDebitIdQR);
								        jdata.addProperty("clientId", clientId.toString());
								        jdata.addProperty("debitId", defineDebitQR.getDebitIdQR());
								        jdata.addProperty("amountKiron", defineDebitQR.getKironprizeAmount());
								        jdata.addProperty("amountNeoga", defineDebitQR.getNeoprizeAmount());
								        jdata.addProperty("playerIp", ClientUtils.getClientIp(request));
								        jdata.addProperty("company", "ECOMM");
								        jdata.addProperty("operatorId", Constants.OPERATOR_ID+"");						        
								        jdata.addProperty("platform", Constants.PLATAFORM);
								        
								        String jsonResponseDebitIdQR="";
										String jsonRequestDebitIdQR=jdata.toString();
										String credenciales = userDebitIdQR+":"+passDebitIdQR;
										credenciales = Base64.encodeBase64String(credenciales.getBytes()); 	    	
							 	    	URL url = new URL(urlDebitIdQR+defineDebitQR.getDebitIdQR());
							 			HttpURLConnection  con = (HttpURLConnection )url.openConnection();
							 			con.setRequestMethod("POST");
							 			con.setRequestProperty("Authorization", "Basic "+credenciales);
							 			con.setRequestProperty("Content-Type", Constants.APPLICATION_JSON);
							 			con.setRequestProperty("Accept", Constants.APPLICATION_JSON);
							     		con.setDoOutput(true);
							     		OutputStream os = con.getOutputStream();
							 			os.write(jsonRequestDebitIdQR.getBytes(Constants.CHARSET_UTF8));
							 			os.flush();
							 			os.close();
							 			BufferedReader br = null;
							 			int responseCode = con.getResponseCode();
							 			if(responseCode < HttpServletResponse.SC_BAD_REQUEST) {
							 				br = new BufferedReader(new InputStreamReader((con.getInputStream()),Constants.CHARSET_UTF8));
							 			}else {
							 				LoggerApi.Log.info("API DEBIT ID QR HTTP CODE: "+responseCode + " json: "+jsonRequestDebitIdQR);
							 				br = new BufferedReader(new InputStreamReader((con.getErrorStream()),Constants.CHARSET_UTF8));
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
							 			if(debitIdQrResponse!=null && debitIdQrResponse.getEstado().equals(Constants.RESULT_OK)) {
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
							 				PaymentPrizeProcedureCreateRequestAutomaticDQR result = paymentPrizeBo.createRequestAutomaticDQR(clientId,
													amountEfectivo, Constants.TYPE_PAYMENT_CASH, Constants.PLATAFORM,imgDNI, loadedImage, 
													amountKiron,amountNeo,defineDebitQR.getDebitIdQR(),balanceItemKiron,balanceItemNeo);
							 				LoggerApi.Log.info("PaymentPrizeProcedureCreateRequestAutomaticDQR getMessage:"+result.getMessage());
							 				if (result.getMessage() != null && result.getMessage().trim().equalsIgnoreCase(Constants.RESULT_OK)) {
							 					Double newSaldoLiquidable = saldoLiquidable - amountTotal;
												paymentPrizeProcedureGetDataCollectPrizes.setSaldoLiquidable(newSaldoLiquidable);
												o.addProperty("saldoLiquidable", paymentPrizeProcedureGetDataCollectPrizes.getSaldoLiquidable());
												amountResponse=amountEfectivo.toString();
												requestNumber=result.getRequestNumber().toString();	
							 				}else {
							 					message = Constants.MSG_EXCEPTION;
							 				}								
							 			}else {
							 				message = Constants.MSG_EXCEPTION;
							 			}
							 			
							 			/*
							 			PaymentPrizeProcedureCreateRequestAutomatic result = paymentPrizeBo.createRequestAutomatic(clientId.toString(),
												amountEfectivo, ip, Constants.TYPE_PAYMENT_CASH, Constants.PLATAFORM, imgDNI, loadedImage);
										if (result.getMessage() != null && result.getMessage().trim().equalsIgnoreCase(Constants.RESULT_OK)) {
											Double newSaldoLiquidable = saldoLiquidable - result.getAmount();
											paymentPrizeProcedureGetDataCollectPrizes.setSaldoLiquidable(newSaldoLiquidable);
											o.addProperty("saldoLiquidable", paymentPrizeProcedureGetDataCollectPrizes.getSaldoLiquidable());
											
//											if(peso>0 || paymentPrizeProcedureGetDataCollectPrizes.getStateDni().trim().equals("ACT")	) {
//												paymentPrizeProcedureGetDataCollectPrizes.setStateDni("ACT");
//												o.addProperty("stateDni", "ACT");
//											}else {
//												paymentPrizeProcedureGetDataCollectPrizes.setStateDni("PEN");
//												o.addProperty("stateDni", "PEN");
//											}
//											session.setAttribute("paymentPrizeProcedureGetDataCollectPrizes", paymentPrizeProcedureGetDataCollectPrizes);
											
										}
										*/
									}else {
										message = Constants.MSG_EXCEPTION;
									}
														
									o.addProperty("message", message);
									o.addProperty("amount", amountResponse);
									o.addProperty("requestNumber", requestNumber);
									o.addProperty("status", Constants.RESULT_OK);
									o.addProperty("messageSuccess", paymentPrizeProcedureGetDataCollectPrizes.getMsgAutomaticCashApr());
									o.addProperty("evaluacion", "AUTOMATICO");
								}else {
									o.addProperty("message", Constants.MSG_BLACKLIST);
									o.addProperty("status", Constants.RESULT_OK);
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
				o.addProperty("message", Constants.MSG_AMOUNT_OUT_RANGE.replace("MIN", ClientUtils.formatCurrency3(paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRequestCash().intValue())).replace("MAX", ClientUtils.formatCurrency3(paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxRequestCash().intValue())) );
			}
        	out.print(o);
        } catch (Exception e) {
        	int transactionId = Constants.generateTransactionId();
			String mensaje = Constants.MSG_EXCEPTION+"<br><br>Nº de operación: I"+transactionId+"<br>"+sdfFront.format(new Date());
			o.addProperty("message", mensaje);
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e,uuid.toString());
	    } 
        
		TransactionPaymentLogPin sessionPin = null;
		try { 
	    	session.removeAttribute("PIN_SESSION");
			String status = o.getAsJsonObject().get("status").toString();
			sessionPin = paymentPrizeBo.transactionLogPin(paymentSession.getChannel(), "createRequestEnd", paymentSession.getClientId(), paymentSession.getClientIp(), paymentSession.getPinUuid(), paymentSession.getType(), paymentSession.getAmount()
						, status , o.toString() );
		} catch (Exception e) {
			LoggerApi.severe(e, "sessionPin="+sessionPin);			
		}
		
        LoggerApi.Log.info("-------------- END createRequest uuid="+uuid.toString());
    }
    
    @RequestMapping(value = "/getTicketsPrizes")
    public void getTicketsPrizes(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START getTicketsPrizes uuid="+uuid.toString());
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
    	PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
    	try {
    		HttpSession session = request.getSession();
    		ClientProcedureGetDataClient client = (ClientProcedureGetDataClient) session.getAttribute("CLIENT_SESSION");
    		String pRequestNumber = request.getParameter("requestNumber");
    		List<PaymentPrizeProcedureHisPayment> paymentPrizeProcedureHisPayment = (List<PaymentPrizeProcedureHisPayment>) session.getAttribute("paymentPrizeProcedureHisPaymentFiltered");
    		if(paymentPrizeProcedureHisPayment!=null && !paymentPrizeProcedureHisPayment.isEmpty() && pRequestNumber!=null) {
    			Integer requestNumber = Integer.valueOf(pRequestNumber);
    			for (PaymentPrizeProcedureHisPayment record : paymentPrizeProcedureHisPayment) {
					if(record.getRequestNumber().compareTo(requestNumber)==0) {
						o.addProperty("requestNumber", record.getRequestNumber());
						o.addProperty("requestDateHour", record.getRequestDateHour());
						o.addProperty("docNumber", record.getDocNumber());
						o.addProperty("requestAmount", record.getRequestAmount());	
						o.addProperty("clientIdQR", client.getClientId());
						o.addProperty("nombresQR", client.getNombre() + " " + client.getApPaterno());
						session.setAttribute("requestNumberPDF", record.getRequestNumber());
						session.setAttribute("requestDateHourFrontTicketPDF", record.getRequestDateHour());
						session.setAttribute("docNumberFrontTicketPDF", record.getDocNumber());
						session.setAttribute("requestAmountFrontTicketPDF", record.getRequestAmount());
						session.setAttribute("clientIdQR", client.getClientId());
						session.setAttribute("nombresQR", client.getNombre() + " " + client.getApPaterno());
						break;
					}
				}
    			Integer clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
    			List<PaymentPrizeProcedureGetTicketsPrizes> paymentPrizeProcedureGetTicketsPrizes = paymentPrizeBo.getTicketsPrizes(clientId, requestNumber);
    			session.setAttribute("paymentPrizeProcedureGetTicketsPrizesPDF", paymentPrizeProcedureGetTicketsPrizes);
    			String htmlText = "";
    			for (PaymentPrizeProcedureGetTicketsPrizes record : paymentPrizeProcedureGetTicketsPrizes) {
    				if(record.getStatus().equalsIgnoreCase(Constants.PENDIENTE)) {
    					String base64QR = qrUtil.generateQR(StringLib.decodeLabel(record.getBarcode()));
    					htmlText+="<div class='imgqr'><img src='data:image/png;base64,"+base64QR+"' alt='QR'><span style='padding-top: 5px; font-size: 12px;'>"+record.getValPrinted()+"</span><span style='padding-top: 5px;'>"+record.getPrize()+"</span></div>";
    				}else if(record.getStatus().equalsIgnoreCase(Constants.COBRADO)) {
    					String base64QR = qrUtil.generateQR(Constants.COBRADO);
    					htmlText+="<div class='imgqr is-checked'><img src='data:image/png;base64,"+base64QR+"' alt='QR'><span>"+record.getPrize()+"</span></div>";
    				}    				
				}
    			o.addProperty("htmlText", htmlText);
    			o.addProperty("status", Constants.RESULT_OK);
    		}else {
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
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
    	PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
    	try {
    		HttpSession session = request.getSession();
    		ClientProcedureGetDataClient client = (ClientProcedureGetDataClient) session.getAttribute("CLIENT_SESSION");
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
						o.addProperty("nombresQR", client.getNombre() +" "+ client.getApPaterno());
						session.setAttribute("requestNumberPDF", record.getRequestNumber());
						session.setAttribute("requestDateHourFrontTicketPDF", record.getRequestDateHour());
						session.setAttribute("docNumberFrontTicketPDF", record.getDocNumber());
						session.setAttribute("requestAmountFrontTicketPDF", record.getRequestAmount());
						session.setAttribute("clientIdQR", client.getClientId());
						session.setAttribute("nombresQR", client.getNombre() +" "+ client.getApPaterno());
						break;
					}
				}
    			Integer clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
    			List<PaymentPrizeProcedureGetTicketsPrizesOld> paymentPrizeProcedureGetTicketsPrizesOld = paymentPrizeBo.getTicketsPrizesOld(clientId, ticket);
    			List<PaymentPrizeProcedureGetTicketsPrizes> paymentPrizeProcedureGetTicketsPrizes = new ArrayList<PaymentPrizeProcedureGetTicketsPrizes>();
    			String htmlText = "";
    			for (PaymentPrizeProcedureGetTicketsPrizesOld record : paymentPrizeProcedureGetTicketsPrizesOld) {
    				if(record.getStatus().equalsIgnoreCase(Constants.PENDIENTE)) {
    					String base64QR = qrUtil.generateQR(StringLib.decodeLabel(record.getBarcode()));
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
    			o.addProperty("status", Constants.RESULT_OK);
    		}else {
				o.addProperty("status", "ERROR");
			}
			out.print(o);
    	} catch (Exception e) {
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e,uuid.toString());
	    }  
    	LoggerApi.Log.info("-------------- END getTicketsPrizesOld uuid="+uuid.toString());
    }
    
    @RequestMapping(value = "/getTicketsPrizesDebitIdQR")
    public void getTicketsPrizesDebitIdQR(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START getTicketsPrizesDebitIdQR uuid="+uuid.toString());
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
    	PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
    	try {
    		HttpSession session = request.getSession();
    		ClientProcedureGetDataClient client = (ClientProcedureGetDataClient) session.getAttribute("CLIENT_SESSION");
    		String pRequestNumber = request.getParameter("requestNumber");
    		List<PaymentPrizeProcedureHisPayment> paymentPrizeProcedureHisPayment = (List<PaymentPrizeProcedureHisPayment>) session.getAttribute("paymentPrizeProcedureHisPaymentFiltered");
    		if(paymentPrizeProcedureHisPayment!=null && !paymentPrizeProcedureHisPayment.isEmpty() && pRequestNumber!=null) {
    			Integer requestNumber = Integer.valueOf(pRequestNumber);
    			for (PaymentPrizeProcedureHisPayment record : paymentPrizeProcedureHisPayment) {
					if(record.getRequestNumber().compareTo(requestNumber)==0) {
						o.addProperty("requestNumber", record.getRequestNumber());
						o.addProperty("requestDateHour", record.getRequestDateHour());
						o.addProperty("docNumber", record.getDocNumber());
						o.addProperty("requestAmount", record.getRequestAmount());	
						o.addProperty("clientIdQR", client.getClientId());
						o.addProperty("nombresQR", client.getNombre() + " " + client.getApPaterno());
						session.setAttribute("requestNumberPDF", record.getRequestNumber());
						session.setAttribute("requestDateHourFrontTicketPDF", record.getRequestDateHour());
						session.setAttribute("docNumberFrontTicketPDF", record.getDocNumber());
						session.setAttribute("requestAmountFrontTicketPDF", record.getRequestAmount());
						session.setAttribute("clientIdQR", client.getClientId());
						session.setAttribute("nombresQR", client.getNombre() + " " + client.getApPaterno());
						
						LoggerApi.Log.info("-------------- getNombre="+client.getNombre());
						LoggerApi.Log.info("-------------- getApPaterno="+client.getApPaterno());
						LoggerApi.Log.info("-------------- getApMaterno="+client.getApMaterno());
						LoggerApi.Log.info("-------------- nombresQR="+client.getNombre() + " " + client.getApPaterno() + ((client.getApMaterno() != null) ? " " + client.getApMaterno() : ""));
						break;
					}
				}
    			Integer clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
    			List<PaymentPrizeProcedureGetTicketsPrizesDebitQR> paymentPrizeProcedureGetTicketsPrizes = paymentPrizeBo.getTicketsPrizesDebitQR(clientId, requestNumber);
    			session.setAttribute("paymentPrizeProcedureGetTicketsPrizesPDF", paymentPrizeProcedureGetTicketsPrizes);
    			String htmlText = "";
    			for (PaymentPrizeProcedureGetTicketsPrizesDebitQR record : paymentPrizeProcedureGetTicketsPrizes) {
    				if(record.getStatus().equalsIgnoreCase(Constants.PENDIENTE)) {
    					String base64QR = qrUtil.generateQRStringDebitId(record.getBarcode());
    					htmlText+="<div class='imgqrdebit'><img src='data:image/png;base64,"+base64QR+"' alt='QR'></div>";
    				}else if(record.getStatus().equalsIgnoreCase(Constants.COBRADO)) {
    					String base64QR = qrUtil.generateQRStringDebitId(Constants.COBRADO);
    					htmlText+="<div class='imgqrdebit is-checked'><img src='data:image/png;base64,"+base64QR+"' alt='QR'></div>";
    				}    				
				}
    			o.addProperty("htmlText", htmlText);
    			o.addProperty("status", Constants.RESULT_OK);
    		}else {
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
        return "client/tokenization_card";
    }
    
    @RequestMapping(value = "/tokenizationCardAgora")
    public String tokenizationCardAgora(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "client/tokenization_card_agora";
    }

    @RequestMapping(value = "/createSessionTokenizationCard")
    public void createSessionTokenizationCard(HttpServletRequest request, HttpServletResponse response) throws Exception {    	
    	UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START createSessionTokenizationCard uuid="+uuid.toString());
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		JsonSessionForm jsonResponse = new JsonSessionForm();
		try {
			HttpSession session = request.getSession();
			ClientProcedureGetDataClient client = (ClientProcedureGetDataClient) session.getAttribute("CLIENT_SESSION");

    		try {
    			paymentPrizeBo.transactionRequestIp("DESKTOP","createSessionTokenizationCard", client.getClientId(), ClientUtils.getClientIp(request), uuid.toString(), "VISA", "" );
		    } catch (Exception ex) {
		    	try { LoggerApi.severe(ex, "cid="+client.getClientId()+" ip="+ClientUtils.getClientIp(request)); } catch (Exception e) {;}
		    }
			
			String sessionWsApiTokenizationCard = ConnectionFactory.operationProperty("session_ws_api_tokenization_card", Constants.contextSale);
			String merchantIdAPITokenizationCard = ConnectionFactory.operationProperty("merchant_id_api_tokenization_card", Constants.contextSale);
			
			URL urlSession = new URL(sessionWsApiTokenizationCard);
			HttpURLConnection  cnSession = (HttpURLConnection )urlSession.openConnection();
    		cnSession.setRequestMethod("POST");
    		cnSession.setRequestProperty("Content-Type", Constants.APPLICATION_JSON);
    		cnSession.setRequestProperty("Accept", Constants.APPLICATION_JSON);
    		cnSession.setDoOutput(true);
    			    		
    		TokenSessionParameters tokenSessionParameters = new TokenSessionParameters();
    		tokenSessionParameters.setUserToken("CID" + client.getClientId() + "@intralot.com.pe");
    		
        	Gson gson = new Gson();
            String jsonInputString = gson.toJson(tokenSessionParameters);
            
        	OutputStream os = cnSession.getOutputStream();
        	os.write(jsonInputString.getBytes(Constants.CHARSET_UTF8)); 
        	os.flush();
        	os.close();
        	
        	BufferedReader brSession = null;
        	int responseCodeSession = cnSession.getResponseCode();
        	if(responseCodeSession < HttpServletResponse.SC_BAD_REQUEST) {
        		brSession = new BufferedReader(new InputStreamReader((cnSession.getInputStream()),Constants.CHARSET_UTF8));
        	}else {
        		LoggerApi.Log.info("API WS Session HTTP CODE uuid="+uuid.toString()+": "+responseCodeSession+ " clientId:"+client.getClientId());
        		brSession = new BufferedReader(new InputStreamReader((cnSession.getErrorStream()),Constants.CHARSET_UTF8));
        	}
        	            	
    		StringBuilder sbSession = new StringBuilder();
    		char[] bufferSession = new char[1000];
            int leidoSession;
            while ((leidoSession = brSession.read(bufferSession)) > 0) {
            	sbSession.append(new String(bufferSession, 0, leidoSession));
            }
    		brSession.close();
    		
    		String jsonSessionKey = sbSession.toString();
    		try { jsonResponse = gson.fromJson(jsonSessionKey, JsonSessionForm.class); } catch (Exception e) { } 
    		if(responseCodeSession < HttpServletResponse.SC_BAD_REQUEST && jsonResponse!=null && !jsonResponse.getSessionKey().equals("0")) {
    			request.getSession().setAttribute("token", StringLib.encodeLabel(jsonResponse.getToken()));	 
    			
        		String baseUri = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        		            		            		
        		o.addProperty("json", jsonSessionKey);
        		o.addProperty("merchantid", merchantIdAPITokenizationCard);
        		o.addProperty("purchasenumber", paymentPrizeBo.generateTokenPurchaseNumber());         		
        		o.addProperty("formbuttontext", "Confirmar");
        		o.addProperty("merchantlogo", baseUri + "/layer-view-image/v2/landing/img/logo-tinka.png");
        		o.addProperty("cardholdername", client.getNombre().toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u").replace("à", "a").replace("è", "e").replace("ì", "i").replace("ò", "o").replace("ù", "u").replace("ä", "a").replace("ë", "e").replace("ï", "i").replace("ö", "o").replace("ü", "u").replace("ñ", "n").replace("'", ""));
        		o.addProperty("cardholderlastname", (client.getApPaterno() + ((client.getApMaterno() != null) ? " " + client.getApMaterno() : "")).toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u").replace("à", "a").replace("è", "e").replace("ì", "i").replace("ò", "o").replace("ù", "u").replace("ä", "a").replace("ë", "e").replace("ï", "i").replace("ö", "o").replace("ü", "u").replace("ñ", "n").replace("'", ""));
        		o.addProperty("cardholderemail", "CID" + client.getClientId() + "@intralot.com.pe");
        		o.addProperty("timeouturl", baseUri + "/client_price_show_information.html");
        		o.addProperty("userToken", "CID" + client.getClientId() + "@intralot.com.pe" );
            	o.addProperty("status", Constants.RESULT_OK);
    		}else {
    			LoggerApi.Log.info("API WS Session RESPONSE uuid="+uuid.toString()+": "+jsonSessionKey + " clientId:"+client.getClientId());
    			
    			int transactionId = Constants.generateTransactionId();
				String mensaje = Constants.MSG_EXCEPTION+"<br><br>Nº de operación: V"+transactionId+"<br>"+sdfFront.format(new Date());
				o.addProperty("message", mensaje);
				registrarErrorVisa(new BigInteger(client.getClientId()+""), new BigInteger(transactionId+""), 
						jsonResponse.getProcess()!=null?jsonResponse.getProcess():Constants.VACIO, Constants.VACIO, 
						Constants.VACIO, "API Session (createSessionTokenizationCard) HTTP CODE "+jsonResponse.getHttpCode(), 
						Constants.VACIO, Constants.VACIO, Constants.VACIO, Constants.VACIO);
    			
    			o.addProperty("status", "ERROR");
    		}
    		
	      	out.print(o);
		}catch (Exception e) {
			int transactionId = Constants.generateTransactionId();
			String mensaje = Constants.MSG_EXCEPTION+"<br><br>Nº de operación: I"+transactionId+"<br>"+sdfFront.format(new Date());
			o.addProperty("message", mensaje);
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e,uuid.toString()+ " mensaje: "+mensaje);
		}
		LoggerApi.Log.info("-------------- END createSessionTokenizationCard uuid="+uuid.toString());
    }   
    
    @RequestMapping(value = "/tokenizeCard")
    public void tokenizeCard(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START tokenizeCard uuid="+uuid.toString());
		try {
			HttpSession session = request.getSession();
			ClientProcedureGetDataClient client = (ClientProcedureGetDataClient) session.getAttribute("CLIENT_SESSION");

    		try {
    			paymentPrizeBo.transactionRequestIp("DESKTOP", "tokenizeCard", client.getClientId(), ClientUtils.getClientIp(request), uuid.toString(),"VISA", "" );
		    } catch (Exception ex) {
		    	try { LoggerApi.severe(ex, "cid="+client.getClientId()+" ip="+ClientUtils.getClientIp(request)); } catch (Exception e) {;}
		    }
    		
			String tokenizeWsApiTokenizationCard = ConnectionFactory.operationProperty("tokenize_ws_api_tokenization_card", Constants.contextSale);
					
	    	String securityToken = request.getSession().getAttribute("token").toString();
	    	String transactionToken = request.getParameter("transactionToken");

	    	URL url = new URL(tokenizeWsApiTokenizationCard);
			HttpURLConnection  con = (HttpURLConnection )url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", Constants.APPLICATION_JSON);
			con.setRequestProperty("Accept", Constants.APPLICATION_JSON);
    		con.setDoOutput(true);
    					
    		TokenCardParameters tokenCardParameters = new TokenCardParameters();
    		tokenCardParameters.setSecurityToken(securityToken);
    		tokenCardParameters.setTransactionToken(transactionToken);
    		
    		Gson gson = new Gson();
			String json = gson.toJson(tokenCardParameters);
    		
    		OutputStream os = con.getOutputStream();
			os.write(json.getBytes(Constants.CHARSET_UTF8));
			os.flush();
			os.close();
						
			BufferedReader br = null;
			int responseCode = con.getResponseCode();
			if(responseCode < HttpServletResponse.SC_BAD_REQUEST) {
				br = new BufferedReader(new InputStreamReader((con.getInputStream()),Constants.CHARSET_UTF8));
			}else {
				LoggerApi.Log.info("API Token HTTP CODE uuid="+uuid.toString()+": "+responseCode+ " clientId:"+client.getClientId());
				br = new BufferedReader(new InputStreamReader((con.getErrorStream()),Constants.CHARSET_UTF8));
			}
			
			StringBuilder sb = new StringBuilder();
			char[] buffer = new char[1000];
	        int leido;
	        while ((leido = br.read(buffer)) > 0) {
	        	sb.append(new String(buffer, 0, leido));
	        }
			br.close();
			con.disconnect();
			
			String tokenizacion = sb.toString();
			if(responseCode >= HttpServletResponse.SC_BAD_REQUEST) {
				LoggerApi.Log.info("API Token RESPONSE uuid="+uuid.toString()+": "+tokenizacion+ " clientId:"+client.getClientId());	
			}
			
			TokenizeCardResponse tokenizeCardResponse = gson.fromJson(tokenizacion, TokenizeCardResponse.class);
			tokenizeCardResponse.setJson(tokenizacion);
			request.getSession().setAttribute("tokenizeCardResponse", tokenizeCardResponse);	 
		} catch (Exception e) {
			LoggerApi.severe(e,uuid.toString());
		}
		LoggerApi.Log.info("-------------- END tokenizeCard uuid="+uuid.toString());
    }    
      
    @RequestMapping(value = "/tokenizeCardAgora")
    public void tokenizeCardAgora(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START tokenizeCardAgora uuid="+uuid.toString());
		try {
			HttpSession session = request.getSession();
			ClientProcedureGetDataClient client = (ClientProcedureGetDataClient) session.getAttribute("CLIENT_SESSION");

    		try {
    			paymentPrizeBo.transactionRequestIp("DESKTOP","tokenizeCardAgora", client.getClientId(), ClientUtils.getClientIp(request), uuid.toString(), "AGORA", "" );
		    } catch (Exception ex) {
		    	try { LoggerApi.severe(ex, "cid="+client.getClientId()+" ip="+ClientUtils.getClientIp(request)); } catch (Exception e) {;}
		    }
    		
			String tokenizeWsApiTokenizationCard = ConnectionFactory.operationProperty("tokenize_ws_api_tokenization_card", Constants.contextSale);
					
	    	String securityToken = request.getSession().getAttribute("token").toString();
	    	String transactionToken = request.getParameter("transactionToken");

	    	URL url = new URL(tokenizeWsApiTokenizationCard);
			HttpURLConnection  con = (HttpURLConnection )url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", Constants.APPLICATION_JSON);
			con.setRequestProperty("Accept", Constants.APPLICATION_JSON);
    		con.setDoOutput(true);
    					
    		TokenCardParameters tokenCardParameters = new TokenCardParameters();
    		tokenCardParameters.setSecurityToken(securityToken);
    		tokenCardParameters.setTransactionToken(transactionToken);
    		
    		Gson gson = new Gson();
			String json = gson.toJson(tokenCardParameters);
    		
    		OutputStream os = con.getOutputStream();
			os.write(json.getBytes(Constants.CHARSET_UTF8));
			os.flush();
			os.close();
						
			BufferedReader br = null;
			int responseCode = con.getResponseCode();
			if(responseCode < HttpServletResponse.SC_BAD_REQUEST) {
				br = new BufferedReader(new InputStreamReader((con.getInputStream()),Constants.CHARSET_UTF8));
			}else {
				LoggerApi.Log.info("API Token HTTP CODE uuid="+uuid.toString()+": "+responseCode+ " clientId:"+client.getClientId());
				br = new BufferedReader(new InputStreamReader((con.getErrorStream()),Constants.CHARSET_UTF8));
			}
			
			StringBuilder sb = new StringBuilder();
			char[] buffer = new char[1000];
	        int leido;
	        while ((leido = br.read(buffer)) > 0) {
	        	sb.append(new String(buffer, 0, leido));
	        }
			br.close();
			con.disconnect();
			
			String tokenizacion = sb.toString();
			if(responseCode >= HttpServletResponse.SC_BAD_REQUEST) {
				LoggerApi.Log.info("API Token RESPONSE uuid="+uuid.toString()+": "+tokenizacion+ " clientId:"+client.getClientId());	
			}
			
			TokenizeCardResponse tokenizeCardResponse = gson.fromJson(tokenizacion, TokenizeCardResponse.class);
			tokenizeCardResponse.setJson(tokenizacion);
			request.getSession().setAttribute("tokenizeCardResponseAgora", tokenizeCardResponse);	 
		} catch (Exception e) {
			LoggerApi.severe(e,uuid.toString());
		}
		LoggerApi.Log.info("-------------- END tokenizeCardAgora uuid="+uuid.toString());
    }

	@RequestMapping(value = "/getTokenizedCard")
	public void getTokenizedCard(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START getTokenizedCard uuid="+uuid.toString());
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
    	PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
		try {
			HttpSession session = request.getSession();
			TokenizeCardResponse tokenizeCardResponse = (TokenizeCardResponse) session.getAttribute("tokenizeCardResponse");
			if(tokenizeCardResponse!=null && tokenizeCardResponse.getErrorCode()!=null && tokenizeCardResponse.getErrorMessage()!=null && 
					tokenizeCardResponse.getOrder()!=null && tokenizeCardResponse.getOrder().getActionCode()!=null && 
					tokenizeCardResponse.getErrorCode().toString().equals("0") && tokenizeCardResponse.getErrorMessage().equals("OK") && 
					tokenizeCardResponse.getOrder().getActionCode().equals("000")) {
				o.addProperty("cardNumber", tokenizeCardResponse.getCard()!=null?tokenizeCardResponse.getCard().getCardNumber():"");
				o.addProperty("status", Constants.RESULT_OK);
			}else {
				ClientProcedureGetDataClient client = (ClientProcedureGetDataClient) session.getAttribute("CLIENT_SESSION");
				String purchaseNumber = Constants.VACIO;
				String actionCode = Constants.VACIO;
				String actionDescription = Constants.VACIO;
				String errorCode = Constants.VACIO;
				String errorMessage = Constants.VACIO;
				errorCode = tokenizeCardResponse.getErrorCode()!=null?tokenizeCardResponse.getErrorCode().toString().trim():Constants.VACIO;
				errorMessage = tokenizeCardResponse.getErrorMessage()!=null?tokenizeCardResponse.getErrorMessage().toString().trim():Constants.VACIO;
				if(tokenizeCardResponse.getOrder()!=null) {
					Order order = tokenizeCardResponse.getOrder();
					purchaseNumber = order.getPurchaseNumber()!=null?order.getPurchaseNumber().trim():Constants.VACIO;
					actionCode = order.getActionCode()!=null?order.getActionCode().trim():Constants.VACIO;
					actionDescription = order.getActionDescription()!=null?order.getActionDescription().trim():Constants.VACIO;
				}
				int transactionId = Constants.generateTransactionId();
				String mensaje = Constants.MSG_EXCEPTION+"<br><br>Nº de operación: V"+transactionId+"<br>"+sdfFront.format(new Date());
				o.addProperty("message", mensaje);
				o.addProperty("status", "ERROR");
				o.addProperty("code", actionCode);
				o.addProperty("description", actionDescription);
				registrarErrorVisa(new BigInteger(client.getClientId()+""), new BigInteger(transactionId+""), Constants.PROCESS_TOKEN_API, 
						Constants.VACIO, purchaseNumber, tokenizeCardResponse.getJson(), 
						errorCode, errorMessage, actionCode, actionDescription);
			}			
		} catch (Exception e) {
			int transactionId = Constants.generateTransactionId();
			String mensaje = Constants.MSG_EXCEPTION+"<br><br>Nº de operación: I"+transactionId+"<br>"+sdfFront.format(new Date());
			o.addProperty("message", mensaje);
			o.addProperty("status", "ERROR");
			LoggerApi.severe(e,uuid.toString());
		}
		out.print(o);
		LoggerApi.Log.info("-------------- END getTokenizedCard uuid="+uuid.toString());
	}
	
	@RequestMapping(value = "/getTokenizedCardAgora")
	public void getTokenizedCardAgora(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START getTokenizedCardAgora uuid="+uuid.toString());
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
    	PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
		try {
			HttpSession session = request.getSession();
			TokenizeCardResponse tokenizeCardResponse = (TokenizeCardResponse) session.getAttribute("tokenizeCardResponseAgora");
			if(tokenizeCardResponse!=null && tokenizeCardResponse.getErrorCode()!=null && tokenizeCardResponse.getErrorMessage()!=null && 
					tokenizeCardResponse.getOrder()!=null && tokenizeCardResponse.getOrder().getActionCode()!=null && 
					tokenizeCardResponse.getErrorCode().toString().equals("0") && tokenizeCardResponse.getErrorMessage().equals("OK") && 
					tokenizeCardResponse.getOrder().getActionCode().equals("000")) {
				o.addProperty("cardNumber", tokenizeCardResponse.getCard()!=null?tokenizeCardResponse.getCard().getCardNumber():"");
				o.addProperty("status", Constants.RESULT_OK);
			}else {
				ClientProcedureGetDataClient client = (ClientProcedureGetDataClient) session.getAttribute("CLIENT_SESSION");
				String purchaseNumber = Constants.VACIO;
				String actionCode = Constants.VACIO;
				String actionDescription = Constants.VACIO;
				String errorCode = Constants.VACIO;
				String errorMessage = Constants.VACIO;
				errorCode = tokenizeCardResponse.getErrorCode()!=null?tokenizeCardResponse.getErrorCode().toString().trim():Constants.VACIO;
				errorMessage = tokenizeCardResponse.getErrorMessage()!=null?tokenizeCardResponse.getErrorMessage().toString().trim():Constants.VACIO;
				if(tokenizeCardResponse.getOrder()!=null) {
					Order order = tokenizeCardResponse.getOrder();
					purchaseNumber = order.getPurchaseNumber()!=null?order.getPurchaseNumber().trim():Constants.VACIO;
					actionCode = order.getActionCode()!=null?order.getActionCode().trim():Constants.VACIO;
					actionDescription = order.getActionDescription()!=null?order.getActionDescription().trim():Constants.VACIO;
				}
				int transactionId = Constants.generateTransactionId();
				String mensaje = Constants.MSG_EXCEPTION+"<br><br>Nº de operación: V"+transactionId+"<br>"+sdfFront.format(new Date());
				o.addProperty("message", mensaje);
				o.addProperty("status", "ERROR");
				registrarErrorVisa(new BigInteger(client.getClientId()+""), new BigInteger(transactionId+""), Constants.PROCESS_TOKEN_API, 
						Constants.VACIO, purchaseNumber, tokenizeCardResponse.getJson(), 
						errorCode, errorMessage, actionCode, actionDescription);
			}			
		} catch (Exception e) {
			int transactionId = Constants.generateTransactionId();
			String mensaje = Constants.MSG_EXCEPTION+"<br><br>Nº de operación: I"+transactionId+"<br>"+sdfFront.format(new Date());
			o.addProperty("message", mensaje);
			o.addProperty("status", "ERROR");
			LoggerApi.severe(e,uuid.toString());
		}
		out.print(o);
		LoggerApi.Log.info("-------------- END getTokenizedCardAgora uuid="+uuid.toString());
	}

	@RequestMapping(value = "/createRequestVisa")
	public void createRequestVisa(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
			throws Exception {
		UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START createRequestVisa uuid="+uuid.toString());
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		o.addProperty("paymentType", "VISA");
		Gson gson = new Gson();
		TransactionPaymentToken paymentSession = null;
		HttpSession session = request.getSession();
		try {
			Integer clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
			Double amountVisa = Double.parseDouble(request.getParameter("amountVisa"));
			
			TransactionPaymentLogPin sessionPin = null;
			String resultPin = "";
			paymentSession = (TransactionPaymentToken) session.getAttribute("PIN_SESSION");
			if ( paymentSession!=null && paymentSession.getValidatePinStatus()!=null && paymentSession.getValidatePinStatus().equals("OK") ) {
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
    			paymentPrizeBo.transactionRequestIp("DESKTOP","createRequestVisa", clientId+"", ClientUtils.getClientIp(request), paymentSession.getPinUuid(), "VISA", ""+amountVisa );
		    } catch (Exception ex) {
		    	try { LoggerApi.severe(ex, "cid="+clientId+" ip="+ClientUtils.getClientIp(request)); } catch (Exception e) {;}
		    }
    		
			String imgDNI = request.getParameter("imgDNI")!=null?request.getParameter("imgDNI"):"";
			String kycResult = request.getParameter("kycResult")!=null?request.getParameter("kycResult"):"";
			PaymentPrizeProcedureGetDataCollectPrizes paymentPrizeProcedureGetDataCollectPrizes = (PaymentPrizeProcedureGetDataCollectPrizes)session.getAttribute("paymentPrizeProcedureGetDataCollectPrizes");
			Double saldoLiquidable = paymentPrizeProcedureGetDataCollectPrizes.getSaldoLiquidable();
			Double billetera1 = paymentPrizeProcedureGetDataCollectPrizes.getBalanceAmount();
			
			String flujoDocumento = paymentPrizeProcedureGetDataCollectPrizes.getRequiredKycVisa()!=null?paymentPrizeProcedureGetDataCollectPrizes.getRequiredKycVisa():"";
			
			LoggerApi.Log.info("sigue flujoDNI:" + flujoDocumento);
			LoggerApi.Log.info("sigue amountVisa:" + amountVisa);
			if(amountVisa>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRequestVisa() && amountVisa<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxRequestVisa()) {	
				PaymentPrizeProcedureGetResultEvalRulesVisa paymentPrizeProcedureGetResultEvalRulesVisa = paymentPrizeBo.getResultEvalRulesVisa(clientId,amountVisa);
				int accAmtVisa = paymentPrizeProcedureGetResultEvalRulesVisa.getAccAmtVisa().intValue();
				if(paymentPrizeProcedureGetResultEvalRulesVisa.getResult().trim().equals(Constants.RESULT_OK)) {
					String loadedImage = Constants.LOADED_IMAGE_NO;
					if (saldoLiquidable == 0) {
						o.addProperty("status", "ERROR_MONTO");
						o.addProperty("message", Constants.MSG_NO_CREDIT);
					} else if (amountVisa > saldoLiquidable) {
						o.addProperty("status", "ERROR_MONTO");
						o.addProperty("message", Constants.MSG_NO_CREDIT_SUFICENT);
					} 
					//descomentar despues
					else if (flujoDocumento.equalsIgnoreCase("ACTIVO") && kycResult.trim().isEmpty() && amountVisa >= paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRequiredKycVisa().intValue() ) { // validar si es flujo KYC o DNI
						LoggerApi.Log.info("ERROR_DNI pasar verificacion kyc" );
						o.addProperty("status", "ERROR_DNI");
						o.addProperty("message", Constants.MSG_DNI_NOT_LOADED);
					} 
					else if (!flujoDocumento.equalsIgnoreCase("ACTIVO") && !paymentPrizeProcedureGetDataCollectPrizes.getStateDni().equals(Constants.DNI_STATE_ACTIVE)&& imgDNI.trim().isEmpty()&& (amountVisa >= paymentPrizeProcedureGetDataCollectPrizes.getAmountMinEnableDni().intValue()|| (amountVisa + accAmtVisa) >= paymentPrizeProcedureGetDataCollectPrizes.getMinAccAmtEnblDniVisa()) ) {
						LoggerApi.Log.info("ERROR_DNI subir foto dni" );
					o.addProperty("status", "ERROR_DNI");
						o.addProperty("message", Constants.MSG_DNI_NOT_LOADED);
					}
				else {						
						
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
							mensajeComision=Constants.MSG_COMMISSION+ClientUtils.formatCurrency(comision);
							if((amountVisa+comision)>billetera1) {
								errorComision=true;
								o.addProperty("status", "ERRO_COMISION");
								o.addProperty("message", paymentPrizeProcedureGetDataCollectPrizes.getMsjComDenVisa().replace("XXX", ClientUtils.formatCurrency(comision)));
							}
						}
						
						
						boolean errorDocumento= true;
						 if (flujoDocumento.equalsIgnoreCase("ACTIVO")) {
							boolean errorKyc = true;
							if (!kycResult.trim().isEmpty() && (kycResult.equals("verified")|| kycResult.equals("rejected") || kycResult.equals("reviewNeeded"))) {
								errorKyc = false;
							}
							errorDocumento = errorKyc;
						 }else {
							 LoggerApi.Log.info("imgDNI visa" +imgDNI);
						boolean errorDNI = false;
						Double peso = 0.0;
						if(amountVisa>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinEnableDni().intValue()) {
							BASE64Decoder decoder = new BASE64Decoder();
							byte[] decodedBytes = decoder.decodeBuffer(imgDNI.replace("data:image/png;base64,", "").replace("data:image/jpeg;base64,", ""));
							peso = (double) decodedBytes.length;
							if( (peso/1024/1024)<=paymentPrizeProcedureGetDataCollectPrizes.getMaxMbPerImageVisa().intValue()  ||
									(amountVisa+accAmtVisa)>=paymentPrizeProcedureGetDataCollectPrizes.getMinAccAmtEnblDniVisa()) {
								if(!imgDNI.trim().isEmpty()) {
									loadedImage=Constants.LOADED_IMAGE_YES;
									try {
										ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
										BufferedImage image = ImageIO.read(bis);
								        bis.close();
								        if(image==null) {
								        	errorDNI = true;
											o.addProperty("status", "ERROR_DNI");
											o.addProperty("message", Constants.MSG_DNI_NOT_VALID);
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
								o.addProperty("message", Constants.MSG_DNI_LIMIT_MB+paymentPrizeProcedureGetDataCollectPrizes.getMaxMbPerImageVisa().intValue()+Constants.MB);
							}
						}
							errorDocumento=errorDNI;
						 }
						
						 LoggerApi.Log.info("errorDocumento" +errorDocumento);
						
						if(!errorDocumento&& !errorComision) {
						
						//if(!errorDNI  && !errorComision) {								
							String ip = request.getRemoteAddr();
							TokenizeCardResponse tokenizeCardResponse = (TokenizeCardResponse) session.getAttribute("tokenizeCardResponse");
							
							//reglas pp automatico
							boolean flagEvalRulesAutomatic=false;
							String whiteList = paymentPrizeProcedureGetDataCollectPrizes.getWhiteList();
							/*if(!whiteList.trim().equalsIgnoreCase("ACT")) {
								if(amountVisa<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxAutomaticVisa()) {
									PaymentPrizeProcedureEvalRulesAutomaticV2 objEvalRulesAutomatic=paymentPrizeBo.evalRulesAutomaticV2(clientId,Constants.TYPE_PAYMENT_VISA);
									LoggerApi.Log.info("is rule automatic:" +objEvalRulesAutomatic.getResult().trim() );
									if(objEvalRulesAutomatic!=null && objEvalRulesAutomatic.getResult().trim().equals(Constants.RESULT_OK)) {
										flagEvalRulesAutomatic=true;
									}
								}
							}else {
								flagEvalRulesAutomatic=true;
							}*/
							
							if(amountVisa<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxAutomaticVisa()) {
								PaymentPrizeProcedureEvalRulesAutomaticV2 objEvalRulesAutomatic=paymentPrizeBo.evalRulesAutomaticV2(clientId,Constants.TYPE_PAYMENT_VISA);
								if(objEvalRulesAutomatic!=null && objEvalRulesAutomatic.getResult().trim().equals(Constants.RESULT_OK)) {
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
								PaymentPrizeProcedureCreateRequestVisa result = paymentPrizeBo.createRequestVisa(clientId.toString(),
										amountVisa, ip, Constants.TYPE_PAYMENT_VISA, Constants.PLATAFORM, StringLib.encodeLabel(tokenizeCardResponse.getToken().getTokenId()),
										StringLib.encodeLabel(tokenizeCardResponse.getCard().getCardNumber()),tokenizeCardResponse.getOrder().getTransactionId(),StringLib.encodeLabel(gson.toJson(tokenizeCardResponse)), 
										imgDNI, loadedImage, comision);
															
								if (result.getMessage() != null && result.getMessage().trim().equalsIgnoreCase(Constants.RESULT_OK)) {
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
									session.setAttribute("paymentPrizeProcedureGetDataCollectPrizes", paymentPrizeProcedureGetDataCollectPrizes);
								}
			
								o.addProperty("message", result.getMessage());
								o.addProperty("amount", result.getAmount());
								o.addProperty("requestNumber", result.getRequestNumber());
								o.addProperty("status", Constants.RESULT_OK);
								o.addProperty("messageSuccess", Constants.MSG_SUCCESS_REQUEST_VISA+mensajeComision);
								o.addProperty("evaluacion", "MANUAL");
							}else {
								//flujo aprobacion automatica
								//crear solicitud para retener dinero
								PaymentPrizeProcedureInBlackList paymentPrizeProcedureInBlackList = paymentPrizeBo.inBlackList(clientId);
								if(paymentPrizeProcedureInBlackList.getResult()!=null && paymentPrizeProcedureInBlackList.getResult().trim().equals(Constants.BLACKLIST_INACTIVE)) {
									String mensaje = "";
									LoggerApi.Log.info("createRequestVisaAutomatic  isBlackList=" + paymentPrizeProcedureInBlackList.getResult());
									PaymentPrizeProcedureCreateRequestVisaAutomatic result = paymentPrizeBo.createRequestVisaAutomatic(clientId.toString(),
											amountVisa, ip, Constants.TYPE_PAYMENT_VISA, Constants.PLATAFORM, StringLib.encodeLabel(tokenizeCardResponse.getToken().getTokenId()),
											StringLib.encodeLabel(tokenizeCardResponse.getCard().getCardNumber()),tokenizeCardResponse.getOrder().getTransactionId(),StringLib.encodeLabel(gson.toJson(tokenizeCardResponse)), 
											imgDNI, loadedImage, comision);
									//si se pudo crear solicitud
									if (result.getMessage() != null && result.getMessage().trim().equalsIgnoreCase(Constants.RESULT_OK)) {
										//call fd
										LoggerApi.Log.info("createRequestVisaAutomatic: " +  "clientId: " + clientId.toString() + " message: " + result.getMessage() + " amount: " + result.getAmount() + " requestNumber: " + result.getRequestNumber().toString());
							    		ClientProcedureGetDataClient client = (ClientProcedureGetDataClient) session.getAttribute("CLIENT_SESSION");
										FundsDisbursementsResponse objFD = dispersionFondo(amountVisa.toString(), tokenizeCardResponse.getToken().getTokenId(), clientId.toString(), client.getNombre(), client.getApPaterno(), result.getRequestNumber().toString(), uuid);
							    		//si se realizo la fd
										if(objFD!=null && objFD.getResponseCode()!=null && !objFD.getResponseCode().trim().isEmpty() && objFD.getResponseCode().trim().equalsIgnoreCase(HttpServletResponse.SC_OK+"")) {
											LoggerApi.Log.info("dispersionFondo responseCode " + objFD.getResponseCode() + " clientId=" + clientId.toString()  + " requestNumber: " + result.getRequestNumber());		    		
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
											session.setAttribute("paymentPrizeProcedureGetDataCollectPrizes", paymentPrizeProcedureGetDataCollectPrizes);
											
											//registrar fd										
											Object[] values = new Object[25];
											values[0] = result.getRequestNumber();
											values[1] = "AUTO";
											values[2] = "";
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
											LoggerApi.Log.info("denegacion dispersionFondo clientId: " + clientId.toString() + "requestNumber"+ result.getRequestNumber());
											mensaje = paymentPrizeProcedureGetDataCollectPrizes.getMsgAutomaticVisaDen();//mensaje de error al intentar dispersar fondos
											Object[] values = new Object[2];
											values[0] = result.getRequestNumber();
											values[1] = Constants.VACIO;
											paymentPrizeBo.refuseRequestAutomatic(values);
											o.addProperty("clean", "OK");
											o.addProperty("titulo", "Tu retiro por tu tarjeta Visa ha sido denegado");
											
											int transactionId = Constants.generateTransactionId();
											mensaje += "<br><br>Nº de operación: V"+transactionId+"<br>"+sdfFront.format(new Date());
											registrarErrorVisa(new BigInteger(clientId.toString()), new BigInteger(transactionId+""),
															Constants.PROCESS_FD_API, result.getRequestNumber().toString(), 
															Constants.VACIO, objFD.getJson(), 
															objFD.getErrorCode()!=null?objFD.getErrorCode(): Constants.VACIO, 
															objFD.getErrorMessage()!=null?objFD.getErrorMessage(): Constants.VACIO, 
															Constants.VACIO, Constants.VACIO);	
										}
									}else {
										LoggerApi.Log.info("Error al crear solicitud: " + result.getMessage() + " clientId: " + clientId.toString());
										mensaje = result.getMessage();//mensaje de error al intentar crear solicitud
									}
									
									o.addProperty("message", mensaje);
									o.addProperty("amount", result.getAmount());
									o.addProperty("requestNumber", result.getRequestNumber());
									o.addProperty("status", Constants.RESULT_OK);
									o.addProperty("messageSuccess", paymentPrizeProcedureGetDataCollectPrizes.getMsgAutomaticVisaApr()+mensajeComision);
									o.addProperty("evaluacion", "AUTOMATICO");
								}else {
									LoggerApi.Log.info("Retiro denegado: " + Constants.MSG_BLACKLIST + " clientId: " + clientId.toString());
									o.addProperty("message", Constants.MSG_BLACKLIST);
									o.addProperty("status", Constants.RESULT_OK);
									o.addProperty("evaluacion", "AUTOMATICO");
									o.addProperty("clean", "OK");
									o.addProperty("titulo", "Tu retiro ha sido denegado");
								}
							}	
						}
					}
				}else {
					LoggerApi.Log.info("ERROR_RULES: " + paymentPrizeProcedureGetResultEvalRulesVisa.getMessage() + " clientId: " + clientId.toString());
					o.addProperty("status", "ERROR_RULES");
					o.addProperty("clean", paymentPrizeProcedureGetResultEvalRulesVisa.getClean());
					o.addProperty("message", paymentPrizeProcedureGetResultEvalRulesVisa.getMessage());
				}
			}else {
				LoggerApi.Log.info("ERROR_MONTO clientId: " + clientId.toString());
				o.addProperty("status", "ERROR_MONTO");
				o.addProperty("message", Constants.MSG_AMOUNT_OUT_RANGE.replace("MIN", ClientUtils.formatCurrency3(paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRequestVisa().intValue())).replace("MAX", ClientUtils.formatCurrency3(paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxRequestVisa().intValue())) );
			}
			out.print(o);
		} catch (Exception e) {			
			int transactionId = Constants.generateTransactionId();
			String mensaje = Constants.MSG_EXCEPTION+"<br><br>Nº de operación: I"+transactionId+"<br>"+sdfFront.format(new Date());
			o.addProperty("message", mensaje);
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e,uuid.toString() + " mensaje: "+mensaje);
		}
		
		TransactionPaymentLogPin sessionPin = null;
		try { 
	    	session.removeAttribute("PIN_SESSION");
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
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		o.addProperty("paymentType", "AGORA");
		Gson gson = new Gson();
		TransactionPaymentToken paymentSession = null;
		HttpSession session = request.getSession();
		try {
    		ClientProcedureGetDataClient client = (ClientProcedureGetDataClient) session.getAttribute("CLIENT_SESSION");
			Double amountAgora = Double.parseDouble(request.getParameter("amountAgora"));

			TransactionPaymentLogPin sessionPin = null;
			String resultPin = "";
			paymentSession = (TransactionPaymentToken) session.getAttribute("PIN_SESSION");
			if ( paymentSession!=null && paymentSession.getValidatePinStatus()!=null && paymentSession.getValidatePinStatus().equals("OK") ) {
				resultPin = "OK";
				LoggerApi.Log.info(uuid.toString()+" PIN ok");
				try { sessionPin = paymentPrizeBo.transactionLogPin(paymentSession.getChannel(), "createRequestAgora", paymentSession.getClientId(), paymentSession.getClientIp(), paymentSession.getPinUuid(), paymentSession.getType(), paymentSession.getAmount(), paymentSession.getValidatePinStatus(), resultPin);
				} catch (Exception e) {
					LoggerApi.severe(e, "sessionPin="+sessionPin);			
				}
			} else {
				resultPin = "PIN NO VALIDO!!! "+ paymentSession.getValidatePinStatus();
				LoggerApi.Log.info(uuid.toString()+" "+resultPin);
				try { sessionPin = paymentPrizeBo.transactionLogPin(paymentSession.getChannel(), "createRequestAgora", paymentSession.getClientId(), paymentSession.getClientIp(), paymentSession.getPinUuid(), paymentSession.getType(), paymentSession.getAmount(), paymentSession.getValidatePinStatus(), resultPin);
				} catch (Exception e) {
					LoggerApi.severe(e, "sessionPin="+sessionPin);			
				}
				throw new Exception(resultPin);
			}
			
    		try {
    			paymentPrizeBo.transactionRequestIp("DESKTOP","createRequestAgora", client.getClientId(), ClientUtils.getClientIp(request), paymentSession.getPinUuid(), "AGORA", ""+amountAgora );
		    } catch (Exception ex) {
		    	try { LoggerApi.severe(ex, "cid="+client.getClientId()+" ip="+ClientUtils.getClientIp(request)); } catch (Exception e) {;}
		    }
    		
			String imgDNI = request.getParameter("imgDNIAgora")!=null?request.getParameter("imgDNIAgora"):"";
			String kycResult = request.getParameter("kycResult")!=null?request.getParameter("kycResult"):"";
			PaymentPrizeProcedureGetDataCollectPrizes paymentPrizeProcedureGetDataCollectPrizes = (PaymentPrizeProcedureGetDataCollectPrizes)session.getAttribute("paymentPrizeProcedureGetDataCollectPrizes");
			Double saldoLiquidable = paymentPrizeProcedureGetDataCollectPrizes.getSaldoLiquidable();
			Double billetera1 = paymentPrizeProcedureGetDataCollectPrizes.getBalanceAmount();
			
			if(amountAgora>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRequestAgr() && amountAgora<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxRequestAgr()) {	
				Integer clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
				PaymentPrizeProcedureGetResultEvalRulesAgora paymentPrizeProcedureGetResultEvalRulesAgora = paymentPrizeBo.getResultEvalRulesAgora(clientId,amountAgora);
				int accAmtAgora = paymentPrizeProcedureGetResultEvalRulesAgora.getAccAmtAgora().intValue();
				if(paymentPrizeProcedureGetResultEvalRulesAgora.getResult().trim().equals(Constants.RESULT_OK)) {
					String loadedImage = Constants.LOADED_IMAGE_NO;
					if (saldoLiquidable == 0) {
						o.addProperty("status", "ERROR_MONTO");
						o.addProperty("message", Constants.MSG_NO_CREDIT);
					} else if (amountAgora > saldoLiquidable) {
						o.addProperty("status", "ERROR_MONTO");
						o.addProperty("message", Constants.MSG_NO_CREDIT_SUFICENT);
					} else if ( kycResult.trim().isEmpty()  &&
							(amountAgora>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinEnblDniAgr().intValue()  || 
							 (amountAgora+accAmtAgora)>=paymentPrizeProcedureGetDataCollectPrizes.getMinAccAmtEnblDniAgr())) {
						o.addProperty("status", "ERROR_DNI");
						o.addProperty("message", Constants.MSG_DNI_NOT_LOADED);
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
							mensajeComision=Constants.MSG_COMMISSION+ClientUtils.formatCurrency(comision);
							if((amountAgora+comision)>billetera1) {
								errorComision=true;
								o.addProperty("status", "ERRO_COMISION");
								o.addProperty("message", paymentPrizeProcedureGetDataCollectPrizes.getMsjComDenAgr().replace("XXX", ClientUtils.formatCurrency(comision)));
							}
						}
						/*
						boolean errorDNI = false;
						Double peso = 0.0;
						if(amountAgora>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinEnblDniAgr().intValue() ||
								(amountAgora+accAmtAgora)>=paymentPrizeProcedureGetDataCollectPrizes.getMinAccAmtEnblDniAgr()) {
							BASE64Decoder decoder = new BASE64Decoder();
							byte[] decodedBytes = decoder.decodeBuffer(imgDNI.replace("data:image/png;base64,", "").replace("data:image/jpeg;base64,", ""));
							peso = (double) decodedBytes.length;
							if( (peso/1024/1024)<=paymentPrizeProcedureGetDataCollectPrizes.getMaxMbPerImageVisa().intValue()) {
								if(!imgDNI.trim().isEmpty()) {
									loadedImage=Constants.LOADED_IMAGE_YES;
									try {
										ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
										BufferedImage image = ImageIO.read(bis);
								        bis.close();
								        if(image==null) {
								        	errorDNI = true;
											o.addProperty("status", "ERROR_DNI");
											o.addProperty("message", Constants.MSG_DNI_NOT_VALID);
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
								o.addProperty("message", Constants.MSG_DNI_LIMIT_MB+paymentPrizeProcedureGetDataCollectPrizes.getMaxMbPerImageVisa().intValue()+Constants.MB);
							}
						}*/
						boolean errorKyc = true;
						if (!kycResult.trim().isEmpty() && (kycResult.equals("verified") || kycResult.equals("rejected") || kycResult.equals("reviewNeeded"))) {
							errorKyc = false;
						}
						if(!errorKyc && !errorComision) {
						//if(!errorDNI && !errorComision) {								
							String ip = request.getRemoteAddr();
							TokenizeCardResponse tokenizeCardResponse = (TokenizeCardResponse) session.getAttribute("tokenizeCardResponseAgora");
							
							//reglas pp automatico
							boolean flagEvalRulesAutomatic=false;
							String whiteList = paymentPrizeProcedureGetDataCollectPrizes.getWhiteList();
							if(!whiteList.trim().equalsIgnoreCase("ACT")) {
								if(amountAgora<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxAutomaticAgr()) {
									PaymentPrizeProcedureEvalRulesAutomaticV2 objEvalRulesAutomatic=paymentPrizeBo.evalRulesAutomaticV2(clientId,Constants.TYPE_PAYMENT_AGORA);
									if(objEvalRulesAutomatic!=null && objEvalRulesAutomatic.getResult().trim().equals(Constants.RESULT_OK)) {
										flagEvalRulesAutomatic=true;
									}
								}
							}else {
								flagEvalRulesAutomatic=true;
							}

							if(amountAgora>paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxAutomaticAgr() && flagEvalRulesAutomatic==false) {
								PaymentPrizeProcedureCreateRequestVisa result = paymentPrizeBo.createRequestVisa(clientId.toString(),
										amountAgora, ip, Constants.TYPE_PAYMENT_AGORA, Constants.PLATAFORM, StringLib.encodeLabel(tokenizeCardResponse.getToken().getTokenId()),
										StringLib.encodeLabel(tokenizeCardResponse.getCard().getCardNumber()),tokenizeCardResponse.getOrder().getTransactionId(),StringLib.encodeLabel(gson.toJson(tokenizeCardResponse)), 
										imgDNI, loadedImage, comision);
															
								if (result.getMessage() != null && result.getMessage().trim().equalsIgnoreCase(Constants.RESULT_OK)) {
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
									session.setAttribute("paymentPrizeProcedureGetDataCollectPrizes", paymentPrizeProcedureGetDataCollectPrizes);
								}
			
								o.addProperty("message", result.getMessage());
								o.addProperty("amount", result.getAmount());
								o.addProperty("requestNumber", result.getRequestNumber());
								o.addProperty("status", Constants.RESULT_OK);
								o.addProperty("messageSuccess", Constants.MSG_SUCCESS_REQUEST_AGORA+mensajeComision);
								o.addProperty("evaluacion", "MANUAL");
							}else {
								//flujo aprobacion automatica
								//crear solicitud para retener dinero
								PaymentPrizeProcedureInBlackList paymentPrizeProcedureInBlackList = paymentPrizeBo.inBlackList(clientId);
								if(paymentPrizeProcedureInBlackList.getResult()!=null && paymentPrizeProcedureInBlackList.getResult().trim().equals(Constants.BLACKLIST_INACTIVE)) {
									String mensaje = "";
									PaymentPrizeProcedureCreateRequestVisaAutomatic result = paymentPrizeBo.createRequestVisaAutomatic(clientId.toString(),
											amountAgora, ip, Constants.TYPE_PAYMENT_AGORA, Constants.PLATAFORM, StringLib.encodeLabel(tokenizeCardResponse.getToken().getTokenId()),
											StringLib.encodeLabel(tokenizeCardResponse.getCard().getCardNumber()),tokenizeCardResponse.getOrder().getTransactionId(),StringLib.encodeLabel(gson.toJson(tokenizeCardResponse)), 
											imgDNI, loadedImage, comision);
									//si se pudo crear solicitud
									if (result.getMessage() != null && result.getMessage().trim().equalsIgnoreCase(Constants.RESULT_OK)) {
										//call fd
										FundsDisbursementsResponse objFD = dispersionFondo(amountAgora.toString(), tokenizeCardResponse.getToken().getTokenId(), clientId.toString(), client.getNombre(), client.getApPaterno(), result.getRequestNumber().toString(), uuid);
							    		//si se realizo la fd
										if(objFD!=null && objFD.getResponseCode()!=null && !objFD.getResponseCode().trim().isEmpty() && objFD.getResponseCode().trim().equalsIgnoreCase(HttpServletResponse.SC_OK+"")) {
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
											session.setAttribute("paymentPrizeProcedureGetDataCollectPrizes", paymentPrizeProcedureGetDataCollectPrizes);
											
											//registrar fd										
											Object[] values = new Object[25];
											values[0] = result.getRequestNumber();
											values[1] = "AUTO";
											values[2] = "";
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
											values[1] = Constants.VACIO;
											paymentPrizeBo.refuseRequestAutomatic(values);
											o.addProperty("cleanAgora", "OK");
											o.addProperty("titulo", "Tu retiro por tu tarjeta Agora ha sido denegado");
											
											int transactionId = Constants.generateTransactionId();
											mensaje += "<br><br>Nº de operación: V"+transactionId+"<br>"+sdfFront.format(new Date());
											registrarErrorVisa(new BigInteger(clientId.toString()), new BigInteger(transactionId+""),
															Constants.PROCESS_FD_API, result.getRequestNumber().toString(), 
															Constants.VACIO, objFD.getJson(), 
															objFD.getErrorCode()!=null?objFD.getErrorCode(): Constants.VACIO, 
															objFD.getErrorMessage()!=null?objFD.getErrorMessage(): Constants.VACIO, 
															Constants.VACIO, Constants.VACIO);	
										}
									}else {
										mensaje = result.getMessage();//mensaje de error al intentar crear solicitud
									}
									
									o.addProperty("message", mensaje);
									o.addProperty("amount", result.getAmount());
									o.addProperty("requestNumber", result.getRequestNumber());
									o.addProperty("status", Constants.RESULT_OK);
									o.addProperty("messageSuccess", paymentPrizeProcedureGetDataCollectPrizes.getMsgAutomaticAgrApr()+mensajeComision);
									o.addProperty("evaluacion", "AUTOMATICO");
								}else {
									o.addProperty("message", Constants.MSG_BLACKLIST);
									o.addProperty("status", Constants.RESULT_OK);
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
				o.addProperty("message", Constants.MSG_AMOUNT_OUT_RANGE.replace("MIN", ClientUtils.formatCurrency3(paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRequestAgr().intValue())).replace("MAX", ClientUtils.formatCurrency3(paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxRequestAgr().intValue())) );
			}
			out.print(o);
		} catch (Exception e) {			
			int transactionId = Constants.generateTransactionId();
			String mensaje = Constants.MSG_EXCEPTION+"<br><br>Nº de operación: I"+transactionId+"<br>"+sdfFront.format(new Date());
			o.addProperty("message", mensaje);
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e,uuid.toString());
		}
		
		TransactionPaymentLogPin sessionPin = null;
		try { 
	    	session.removeAttribute("PIN_SESSION");
			String status = o.getAsJsonObject().get("status").toString();
			sessionPin = paymentPrizeBo.transactionLogPin(paymentSession.getChannel(), "createRequestAgoraEnd", paymentSession.getClientId(), paymentSession.getClientIp(), paymentSession.getPinUuid(), paymentSession.getType(), paymentSession.getAmount()
						, status , o.toString() );
		} catch (Exception e) {
			LoggerApi.severe(e, "sessionPin="+sessionPin);			
		}
		
		LoggerApi.Log.info("-------------- END createRequestAgora uuid="+uuid.toString());
	}
	
	@RequestMapping(value = "/deleteTokenizedCard")
	public void deleteTokenizedCard(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
			throws Exception {
		UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START deleteTokenizedCard uuid="+uuid.toString());
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		
		Integer clientId = 0;
		try {
			HttpSession session = request.getSession();
			clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
			paymentPrizeBo.transactionLogPin("DESKTOP", "deleteTokenizedCard", clientId+"", ClientUtils.getClientIp(request), "", "", "", "", "");
	    } catch (Exception ex) {
	    	try { LoggerApi.severe(ex, "cid="+clientId+" ip="+ClientUtils.getClientIp(request)); } catch (Exception e) {;}
	    }
		
		try {
			request.getSession().setAttribute("tokenizeCardResponse", null);
		} catch (Exception e) {
			out.print(o);
			LoggerApi.severe(e,uuid.toString());
		}
		LoggerApi.Log.info("-------------- END deleteTokenizedCard uuid="+uuid.toString());
	}	
	
	@RequestMapping(value = "/deleteTokenizedCardAgora")
	public void deleteTokenizedCardAgora(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
			throws Exception {
		UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START deleteTokenizedCardAgora uuid="+uuid.toString());
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		try {
			request.getSession().setAttribute("tokenizeCardResponseAgora", null);
		} catch (Exception e) {
			out.print(o);
			LoggerApi.severe(e,uuid.toString());
		}
		LoggerApi.Log.info("-------------- END deleteTokenizedCardAgora uuid="+uuid.toString());
	}	
	
	private FundsDisbursementsResponse dispersionFondo(String requestAmount, String cardToken, String clientId, String nombres, String apellido, String requestNumber, UUID uuid) {
		LoggerApi.Log.info("-------------- START dispersionFondo uuid="+uuid.toString());
		FundsDisbursementsResponse obj = new FundsDisbursementsResponse();
		try {
			LoggerApi.Log.info("dispersionFondo amount=" + requestAmount + " clientId=" + clientId + " cardToken=" + cardToken+ " nombres=" + nombres + "apellidos="+ apellido + " requestnumber=" + requestNumber + " uuid=" + uuid);

			String pushPaymentsWsApiFd = ConnectionFactory.operationProperty("push_payments_ws_api_fd", Constants.contextSale);
					
	    	URL url = new URL(pushPaymentsWsApiFd);
			HttpURLConnection  con = (HttpURLConnection )url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", Constants.APPLICATION_JSON);
			con.setRequestProperty("Accept", Constants.APPLICATION_JSON);
    		con.setDoOutput(true);
    				
    		FundsDisbursementsRequest fundsDisbursementsRequest = new FundsDisbursementsRequest(); 
    		fundsDisbursementsRequest.setClientId(clientId);
    		fundsDisbursementsRequest.setRequestAmount(requestAmount);
    		fundsDisbursementsRequest.setRequestNumber(requestNumber);
    		fundsDisbursementsRequest.setNombres(nombres);
    		fundsDisbursementsRequest.setApellido(apellido);
    		fundsDisbursementsRequest.setCardToken(cardToken);
    		
    		Gson gson = new Gson();
			String json = gson.toJson(fundsDisbursementsRequest);
    		
    		OutputStream os = con.getOutputStream();
			os.write(json.getBytes(Constants.CHARSET_UTF8));
			os.flush();
			os.close();
						
			BufferedReader br = null;
			int responseCode = con.getResponseCode();
			if(responseCode < HttpServletResponse.SC_BAD_REQUEST) {
				LoggerApi.Log.info("FD responseCode uuid="+uuid.toString()+": "+responseCode+ " clientId:"+clientId);
				br = new BufferedReader(new InputStreamReader((con.getInputStream()),Constants.CHARSET_UTF8));
			}else {
				LoggerApi.Log.info("API FD HTTP CODE uuid="+uuid.toString()+": "+responseCode+ " clientId:"+clientId);
				br = new BufferedReader(new InputStreamReader((con.getErrorStream()),Constants.CHARSET_UTF8));
			}
			
			StringBuilder sb = new StringBuilder();
			char[] buffer = new char[1000];
	        int leido;
	        while ((leido = br.read(buffer)) > 0) {
	        	sb.append(new String(buffer, 0, leido));
	        }
			br.close();
			con.disconnect();
			
			String fdResult = sb.toString();
			if(responseCode >= HttpServletResponse.SC_BAD_REQUEST) {
				LoggerApi.Log.info("API Token RESPONSE uuid="+uuid.toString()+": "+fdResult+ " clientId:"+clientId);	
			}
			
			try { 
				LoggerApi.Log.info("RESPONSE API FD: "+fdResult);  
				obj = gson.fromJson(fdResult, FundsDisbursementsResponse.class); 
		} catch (Exception e) {
			obj.setErrorMessage(e.getMessage());
			LoggerApi.severe(e,uuid.toString());
		}
    		obj.setJson(fdResult);
		} catch (Exception e) {
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
		String log = uuid.toString();
		LoggerApi.Log.info(log+" -------------- START createRequestTransferencia uuid="+uuid.toString());
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		o.addProperty("paymentType", "TRANSFERENCIA");
		
		TransactionPaymentToken paymentSession = null;
		HttpSession session = request.getSession();
		try {
			ClientProcedureGetDataClient client = (ClientProcedureGetDataClient) session.getAttribute("CLIENT_SESSION");
			String amount = request.getParameter("amountTransferencia")!=null?request.getParameter("amountTransferencia"):"";
			log += " cid="+client.getClientId();
			LoggerApi.Log.info(log);
			TransactionPaymentLogPin sessionPin = null;
			String resultPin = "";
			paymentSession = (TransactionPaymentToken) session.getAttribute("PIN_SESSION");
			if ( paymentSession!=null && paymentSession.getValidatePinStatus()!=null && paymentSession.getValidatePinStatus().equals("OK") ) {
				resultPin = "OK";
				LoggerApi.Log.info(log+" PIN ok");
				try { sessionPin = paymentPrizeBo.transactionLogPin(paymentSession.getChannel(), "createRequestTransferencia", paymentSession.getClientId(), paymentSession.getClientIp(), paymentSession.getPinUuid(), paymentSession.getType(), paymentSession.getAmount(), paymentSession.getValidatePinStatus(), resultPin);
				} catch (Exception e) {
					LoggerApi.severe(e, log+" sessionPin="+sessionPin);			
				}
			} else {
				resultPin = "PIN NO VALIDO!!! "+ paymentSession.getValidatePinStatus();
				LoggerApi.Log.info(log+" "+resultPin);
				try { sessionPin = paymentPrizeBo.transactionLogPin(paymentSession.getChannel(), "createRequestTransferencia", paymentSession.getClientId(), paymentSession.getClientIp(), paymentSession.getPinUuid(), paymentSession.getType(), paymentSession.getAmount(), paymentSession.getValidatePinStatus(), resultPin);
				} catch (Exception e) {
					LoggerApi.severe(e, log+" sessionPin="+sessionPin);			
				}
				throw new Exception(resultPin);
			}
			
    		try {
    			paymentPrizeBo.transactionRequestIp("DESKTOP","createRequestTransferencia", client.getClientId(), ClientUtils.getClientIp(request), paymentSession.getPinUuid(), paymentSession.getType(), amount );
		    } catch (Exception ex) {
		    	try { LoggerApi.severe(ex, log+" cid="+client.getClientId()+" ip="+ClientUtils.getClientIp(request)); } catch (Exception e) {;}
		    }
    		
			boolean flagDatosPersonales = true;
			if(client.getNombre()==null || client.getNombre().trim().isEmpty() || 
					( (client.getApMaterno()==null || client.getApMaterno().trim().isEmpty()) &&
					  (client.getApPaterno()==null || client.getApPaterno().trim().isEmpty())
					) ||
					client.getNumberId()==null || client.getNumberId().trim().isEmpty() || client.getNumberId().trim().length()<8 ||
					client.getTypeId()==null || client.getTypeId().trim().isEmpty()
			) {
				flagDatosPersonales = false;
			}
			if(flagDatosPersonales) {
				String imgDNITransferencia = request.getParameter("imgDNITransferencia")!=null?request.getParameter("imgDNITransferencia"):"";
				String kycResult = request.getParameter("kycResult")!=null?request.getParameter("kycResult"):"";
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
							List<PaymentPrizeProcedureGetSavingsAccount> getSavingsAccount = (List<PaymentPrizeProcedureGetSavingsAccount>)session.getAttribute("getSavingsAccount");
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
						LoggerApi.severe(e, log+" Exception e");
					}
					if(iAmount>0 && !banco.isEmpty() && !departamento.isEmpty()) {
						Double amountTransferencia = Double.parseDouble(amount);
						PaymentPrizeProcedureGetDataCollectPrizes paymentPrizeProcedureGetDataCollectPrizes = (PaymentPrizeProcedureGetDataCollectPrizes)session.getAttribute("paymentPrizeProcedureGetDataCollectPrizes");
						Double saldoLiquidable = paymentPrizeProcedureGetDataCollectPrizes.getSaldoLiquidable();
						
						LoggerApi.Log.info(log+" amountTransferencia:"+amountTransferencia);
						String flujoDocumento = paymentPrizeProcedureGetDataCollectPrizes.getRequiredKycVisa()!=null?paymentPrizeProcedureGetDataCollectPrizes.getRequiredKycVisa():"";
						LoggerApi.Log.info(log+" sigue flujoDNI:" + flujoDocumento);
	
						if(amountTransferencia<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxRequestTra()) {
							rango="RANGO_1";
							paymentType=Constants.TYPE_PAYMENT_TRANSFERENCIA;
						}else if(amountTransferencia<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxRquTraRan2()) {
							rango="RANGO_2";
							paymentType=Constants.TYPE_PAYMENT_PREMIO_MAYOR;
						}else if(amountTransferencia>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRquTraRan3()) {
							rango="RANGO_3";
							paymentType=Constants.TYPE_PAYMENT_PREMIO_MAYOR;
						}else if("PML".equals(tipoTransferencia)) {
							paymentType=Constants.TYPE_PAYMENT_PREMIO_MAYOR;
						}
						
						LoggerApi.Log.info(log+" rango:"+rango );
						
						if( (((amountTransferencia>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRequestTra() && amountTransferencia<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxRequestTra() && paymentPrizeProcedureGetDataCollectPrizes.getStateRequestTraRan1().equalsIgnoreCase("ACTIVO")) || 
								(amountTransferencia>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRquTraRan2() && amountTransferencia<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxRquTraRan2() && paymentPrizeProcedureGetDataCollectPrizes.getStateRequestTraRan2().equalsIgnoreCase("ACTIVO")) ||
								(amountTransferencia>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRquTraRan3() && paymentPrizeProcedureGetDataCollectPrizes.getStateRequestTraRan3().equalsIgnoreCase("ACTIVO"))) 
								&& !rango.isEmpty()) || "PML".equals(tipoTransferencia)) {		
							Integer clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
							
							//Cambios para Premio Mayor
							PaymentPrizeProcedureGetResultEvalRulesTrans  paymentPrizeProcedureGetResultEvalRulesTrans = null;
							int accAmtTrans=0;
							if ( !"PML".equals(tipoTransferencia) ) {
								paymentPrizeProcedureGetResultEvalRulesTrans = paymentPrizeBo.getResultEvalRulesTrans(clientId,amountTransferencia, rango);
								accAmtTrans= paymentPrizeProcedureGetResultEvalRulesTrans.getAccAmtTrans().intValue();
							}
	
							if( ( paymentPrizeProcedureGetResultEvalRulesTrans !=null &&  paymentPrizeProcedureGetResultEvalRulesTrans.getResult().trim().equals(Constants.RESULT_OK) )  || "PML".equals(tipoTransferencia) ) {
								LoggerApi.Log.info(log+" entra a if general transferencia" );
								String loadedImage;
								if("PML".equals(tipoTransferencia) ) {
									loadedImage = Constants.LOADED_IMAGE_NO;
									paymentPrizeProcedureGetDataCollectPrizes.setStateDni(Constants.DNI_STATE_ACTIVE);//ksolis
								}else {
									loadedImage = Constants.LOADED_IMAGE_NO;
									paymentPrizeProcedureGetDataCollectPrizes.setStateDni(Constants.DNI_STATE_ACTIVE);
								}
								//String loadedImage = Constants.LOADED_IMAGE_NO;
								if (saldoLiquidable == 0 && !"PML".equals(tipoTransferencia)) {
									o.addProperty("status", "ERROR_MONTO");
									o.addProperty("message", Constants.MSG_NO_CREDIT);
									LoggerApi.Log.info(log+" entra a if general transferencia6" );
								} else if (amountTransferencia > saldoLiquidable && !"PML".equals(tipoTransferencia)) {
									o.addProperty("status", "ERROR_MONTO");
									o.addProperty("message", Constants.MSG_NO_CREDIT_SUFICENT);
									LoggerApi.Log.info(log+" entra a if general transferencia7" );
								} else if (flujoDocumento.equalsIgnoreCase("ACTIVO") && 
										( (kycResult.trim().isEmpty() &&  rango.equals("RANGO_1") && (amountTransferencia>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRequiredKycTrans().intValue()) ) ||
											//evaluacion para solicitar dni rango 2
										    ( kycResult.trim().isEmpty() 	&& rango.equals("RANGO_2")) ||
										    //evaluacion para solicitar dni rango 3
									    (kycResult.trim().isEmpty() && rango.equals("RANGO_3"))) ) {
										LoggerApi.Log.info(log+" ERROR_DNI pasar verificacion kyc");
										o.addProperty("status", "ERROR_DNI");
										o.addProperty("message", Constants.MSG_DNI_NOT_LOADED);
								}else if (!flujoDocumento.equalsIgnoreCase("ACTIVO") && 
										( //evaluacion para solicitar dni rango 1
										(!paymentPrizeProcedureGetDataCollectPrizes.getStateDni().equals(Constants.DNI_STATE_ACTIVE) && imgDNITransferencia.trim().isEmpty() && rango.equals("RANGO_1")  &&
										(amountTransferencia>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinEnblDniTra().intValue() || (amountTransferencia+accAmtTrans)>=paymentPrizeProcedureGetDataCollectPrizes.getMinAccAmtEnblDniTra())) ||
										//evaluacion para solicitar dni rango 2
									    ((!paymentPrizeProcedureGetDataCollectPrizes.getStateDni().equals(Constants.DNI_STATE_ACTIVE) && imgDNITransferencia.trim().isEmpty() && rango.equals("RANGO_2")) || 
									    (paymentPrizeProcedureGetDataCollectPrizes.getDaysElapsedDni()>=paymentPrizeProcedureGetDataCollectPrizes.getValidityDniTraRan2() && imgDNITransferencia.trim().isEmpty() && rango.equals("RANGO_2"))) ||
									    //evaluacion para solicitar dni rango 3
									    ((!paymentPrizeProcedureGetDataCollectPrizes.getStateDni().equals(Constants.DNI_STATE_ACTIVE) && imgDNITransferencia.trim().isEmpty() && rango.equals("RANGO_3")) || 
										(paymentPrizeProcedureGetDataCollectPrizes.getDaysElapsedDni()>=paymentPrizeProcedureGetDataCollectPrizes.getValidityDniTraRan3() && imgDNITransferencia.trim().isEmpty() && rango.equals("RANGO_3")))) ) { 
										LoggerApi.Log.info(log+" ERROR_DNI subir foto dni");
									o.addProperty("status", "ERROR_DNI");
									o.addProperty("message", Constants.MSG_DNI_NOT_LOADED);
								} else {
									
									LoggerApi.Log.info(log+" entra a if general transferencia" );
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
										
										//if ("PML".equals(tipoTransferencia)) {
										LoggerApi.Log.info(log+" tipo transferencia:" + tipoTransferencia );
											if ( !imgDNITransferencia.trim().isEmpty() ||
													//evaluacion para solicitar dni rango 1
												    (rango.equals("RANGO_1") && (amountTransferencia>=paymentPrizeProcedureGetDataCollectPrizes.getAmountMinEnblDniTra().intValue() ||
													(amountTransferencia+accAmtTrans)>=paymentPrizeProcedureGetDataCollectPrizes.getMinAccAmtEnblDniTra())) ||
												    //evaluacion para solicitar dni rango 2
												    (rango.equals("RANGO_2") && paymentPrizeProcedureGetDataCollectPrizes.getDaysElapsedDni()>=paymentPrizeProcedureGetDataCollectPrizes.getValidityDniTraRan2()) ||
												    //evaluacion para solicitar dni rango 3
												    (rango.equals("RANGO_3") && paymentPrizeProcedureGetDataCollectPrizes.getDaysElapsedDni()>=paymentPrizeProcedureGetDataCollectPrizes.getValidityDniTraRan3()) 
													) {
												LoggerApi.Log.info(log+" tipo transferencia keyla" );
												BASE64Decoder decoder = new BASE64Decoder();
												byte[] decodedBytes = decoder.decodeBuffer(imgDNITransferencia.replace("data:image/png;base64,", "").replace("data:image/jpeg;base64,", ""));
												peso = (double) decodedBytes.length;
												if ((peso / 1024 / 1024) <= paymentPrizeProcedureGetDataCollectPrizes.getMaxMbPerImageVisa().intValue()) {
													if (!imgDNITransferencia.trim().isEmpty()) {
														loadedImage = Constants.LOADED_IMAGE_YES;
														try {
															ByteArrayInputStream bis = new ByteArrayInputStream(
																	decodedBytes);
															BufferedImage image = ImageIO.read(bis);
															bis.close();
															if (image == null) {
																errorDNI = true;
																o.addProperty("status", "ERROR_DNI");
																o.addProperty("message", Constants.MSG_DNI_NOT_VALID);
															}
														} catch (Exception e) {

														} catch (OutOfMemoryError e) {
															MemoryMXBean memoryBean = ManagementFactory
																	.getMemoryMXBean();
															MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
															long maxMemory = heapUsage.getMax() / (1024 * 1024);
															long usedMemory = heapUsage.getUsed() / (1024 * 1024);
															LoggerApi.Log.info(log+" Memory Use :" + usedMemory + "M/"
																	+ maxMemory + "M");
														}
													}
												} else {
													errorDNI = true;
													o.addProperty("status", "ERROR_DNI");
													o.addProperty("message", Constants.MSG_DNI_LIMIT_MB+ paymentPrizeProcedureGetDataCollectPrizes.getMaxMbPerImageVisa().intValue()+ Constants.MB);
												}
											}
										//}
										errorDocumento=errorDNI;
									}

				
									LoggerApi.Log.info(log+" transferencia errorDocumento:" + errorDocumento );
									if(!errorDocumento ) {
										LoggerApi.Log.info(log+" entra a if general transferencia10" );
										String ip = request.getRemoteAddr();									
										//reglas pp automatico
										boolean flagEvalRulesAutomatic=false;
										String whiteList = paymentPrizeProcedureGetDataCollectPrizes.getWhiteList();
										if(rango.equals("RANGO_1")) {
											/*if(!whiteList.trim().equalsIgnoreCase("ACT")) {			
												if(amountTransferencia<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxAutomaticTra()) {
													PaymentPrizeProcedureEvalRulesAutomaticV2 objEvalRulesAutomatic=paymentPrizeBo.evalRulesAutomaticV2(clientId, Constants.TYPE_PAYMENT_TRANSFERENCIA);
													//PaymentPrizeProcedureEvalRulesAutomatic objEvalRulesAutomatic=paymentPrizeBo.evalRulesAutomatic(clientId);
													LoggerApi.Log.info("is rule automatic:" +objEvalRulesAutomatic.getResult().trim() );
													if(objEvalRulesAutomatic!=null && objEvalRulesAutomatic.getResult().trim().equals(Constants.RESULT_OK)) {
														flagEvalRulesAutomatic=true;
													}
												}
											}else {
												flagEvalRulesAutomatic=true;
											}*/
											if(amountTransferencia<=paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxAutomaticTra()) {
												PaymentPrizeProcedureEvalRulesAutomaticV2 objEvalRulesAutomatic=paymentPrizeBo.evalRulesAutomaticV2(clientId, Constants.TYPE_PAYMENT_TRANSFERENCIA);
												if(objEvalRulesAutomatic!=null && objEvalRulesAutomatic.getResult().trim().equals(Constants.RESULT_OK)) {
													flagEvalRulesAutomatic=true;
												}
											}
											
											if(flagEvalRulesAutomatic == false ) {
												if(whiteList.trim().equalsIgnoreCase("ACT")) {
													flagEvalRulesAutomatic=true;
												}
											}
										}
										
										LoggerApi.Log.info(log+" createRequestTransferencia ->flagEvalRulesAutomatic:"+flagEvalRulesAutomatic);
										LoggerApi.Log.info(log+" is white list ->:"+whiteList);
		
										//if(amountTransferencia>paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxAutomaticTra() && flagEvalRulesAutomatic==false) {
										if( flagEvalRulesAutomatic==false) {
											PaymentPrizeProcedureCreateRequestTrans result = null;
											BigDecimal amountTransferenciaBD = new BigDecimal(amount);
											if("PML".equals(tipoTransferencia)) {
												String gameId = "";
												String barCode = "";
												List<PaymentPrizeProcedureListPrizesMajor> listPrizesMajor = (List<PaymentPrizeProcedureListPrizesMajor>) session.getAttribute("listPrizesMajor");
												for (PaymentPrizeProcedureListPrizesMajor paymentPrizeProcedureListPrizesMajor : listPrizesMajor) {
													if(paymentPrizeProcedureListPrizesMajor.getTicketId().toString().equals(ticketId)) {
														gameId = paymentPrizeProcedureListPrizesMajor.getGameId().toString();
														barCode = StringLib.decodeLabel(paymentPrizeProcedureListPrizesMajor.getTicketNumber());
													}
												}
												/********************************************/
												DateAPI d = new DateAPI();
												WEBMessage web = new WEBMessage();
												web.setIp(request.getRemoteAddr());
												web.setMessageId("W" + d.getTimeLong() + gameId);
												pe.com.intralot.loto.model.Client cliente= BussinessSaleDispatcher.getClientByClientId(clientId.toString());
												String clientCarrier="AUTOM";
												String originalId=ticketId;
												
												WEBTicketPay webTicketPay = new WEBTicketPay();
												webTicketPay.setWebTickets(null);
												webTicketPay.setOriginalId(originalId); 
												
												WEBTicketPay wtp = GameSaleDispatcher.autopayTicketWinnerByWebTransactionNewLotos5(clientCarrier, cliente, web, barCode, webTicketPay,99000000.00);
												LoggerApi.Log.info(log+" PML cid=" + clientId + " message=" + wtp.getMessage() + " prizeAmount="+wtp.getPrizeAmount() + " freeAmount="+wtp.getFreeAmount() + " ---autopayTicketWinnerByWebTransactionNewLotos5");
												/********************************************/
												LoggerApi.Log.info(log+" createRequestPMLManual");
												result = paymentPrizeBo.createRequestTrans(clientId.toString(), amountTransferenciaBD, 
														ip, paymentType, Constants.PLATAFORM, imgDNITransferencia, loadedImage, banco, cuenta, departamento, idBanco, guardarRecurrente, "RANGO_4", "PML", ticketId,gameId,wtp.getPrizeAmount(),wtp.getFreeAmount());
											}else {
												LoggerApi.Log.info(log+" createRequestTranferenciaManual");
												result = paymentPrizeBo.createRequestTrans(clientId.toString(), amountTransferenciaBD, 
														ip, paymentType, Constants.PLATAFORM, imgDNITransferencia, loadedImage, banco, cuenta, departamento, idBanco, guardarRecurrente, rango,"","","",-1.0,-1.0);
											}
											
											if (result.getMessage() != null && result.getMessage().trim().equalsIgnoreCase(Constants.RESULT_OK)) {
												Double newSaldoLiquidable = null;
												if("PML".equals(tipoTransferencia)) {
													newSaldoLiquidable = saldoLiquidable;
												}else {
													newSaldoLiquidable = saldoLiquidable - result.getAmount();
												}
												paymentPrizeProcedureGetDataCollectPrizes.setSaldoLiquidable(newSaldoLiquidable);
												o.addProperty("saldoLiquidable", paymentPrizeProcedureGetDataCollectPrizes.getSaldoLiquidable());
//												if(peso>0 || paymentPrizeProcedureGetDataCollectPrizes.getStateDni().trim().equals("ACT")	) { 
//													paymentPrizeProcedureGetDataCollectPrizes.setStateDni("ACT");
//													o.addProperty("stateDni", "ACT");
//												}else {
//													paymentPrizeProcedureGetDataCollectPrizes.setStateDni("PEN");
//													o.addProperty("stateDni", "PEN");
//												}
												session.setAttribute("paymentPrizeProcedureGetDataCollectPrizes", paymentPrizeProcedureGetDataCollectPrizes);
												
												if(guardarRecurrente.equals("true")) {
													List<PaymentPrizeProcedureGetSavingsAccount> getSavingsAccount=paymentPrizeBo.getSavingsAccount(clientId);
													Gson gson = new Gson();
													o.addProperty("getSavingsAccount", gson.toJson(getSavingsAccount));
													o.addProperty("guardarRecurrente", guardarRecurrente);
													session.setAttribute("getSavingsAccount", getSavingsAccount);
												}
											}
							
											o.addProperty("daysElapsedDni", result.getDaysElapsedDni());
											o.addProperty("message", result.getMessage());
											o.addProperty("amount", result.getAmount());
											o.addProperty("requestNumber", result.getRequestNumber());
											o.addProperty("status", Constants.RESULT_OK);
											if(rango.equals("RANGO_1")) {
												o.addProperty("messageSuccess", Constants.MSG_SUCCESS_REQUEST_TRANSFERENCIA);
											}else if(rango.equals("RANGO_2")) {
												o.addProperty("messageSuccess", Constants.MSG_SUCCESS_REQUEST_TRANSFERENCIA_RANGO2);
											}else if(rango.equals("RANGO_3")) {
												o.addProperty("messageSuccess", Constants.MSG_SUCCESS_REQUEST_TRANSFERENCIA_RANGO3);
											}else if(paymentType.equals("PREMIO_MAYOR")) {
												o.addProperty("messageSuccess", Constants.MSG_SUCCESS_REQUEST_TRANSFERENCIA_RANGO4);
											}
											o.addProperty("evaluacion", "MANUAL");
										}else {
											//aprobacion automatica
											PaymentPrizeProcedureInBlackList paymentPrizeProcedureInBlackList = paymentPrizeBo.inBlackList(clientId);
											if(paymentPrizeProcedureInBlackList.getResult()!=null && paymentPrizeProcedureInBlackList.getResult().trim().equals(Constants.BLACKLIST_INACTIVE)) {
												String mensaje = "";
												LoggerApi.Log.info(log+" createRequestTranferenciaAutomatic");
												PaymentPrizeProcedureCreateRequestTransAutomatic result = paymentPrizeBo.createRequestTransAutomatic(clientId.toString(),
														amountTransferencia, ip, Constants.TYPE_PAYMENT_TRANSFERENCIA, Constants.PLATAFORM,imgDNITransferencia, loadedImage, banco, cuenta, departamento, idBanco, guardarRecurrente);
												if (result.getMessage() != null && result.getMessage().trim().equalsIgnoreCase(Constants.RESULT_OK)) {
													//call api monnet
													SimpleDateFormat sdfMonnet = new SimpleDateFormat("yyyy-MM-dd");
													PayrollRequest payrollRequest = new PayrollRequest();
													PayrollResponse payrollResponse = new PayrollResponse();
													payrollRequest.setName(Constants.FD_MONNET_NAME);
													payrollRequest.setCountry(Constants.FD_MONNET_COUNTRY);
													payrollRequest.setCurrency(Constants.FD_MONNET_CURRENCY);
													payrollRequest.setOrigin(Constants.APPLICATION_TYPE);
													PayrollDetail payrollDetail = new PayrollDetail();
													payrollDetail.setIndex(Constants.FD_MONNET_DETAIL_INDEX);
													payrollDetail.setTransactionId(result.getRequestNumber().toString());
													payrollDetail.setDate(sdfMonnet.format(new Date()));
													payrollDetail.setAmount(amount);
													payrollDetail.setCurrency(Constants.FD_MONNET_DETAIL_CURRENCY);
													payrollDetail.setAmountUsd(Constants.FD_MONNET_DETAIL_AMOUNT_USD);
													payrollDetail.setMerchant(Constants.FD_MONNET_DETAIL_MERCHANT);
													payrollDetail.setAccountType(Constants.FD_MONNET_DETAIL_ACCOUNT_TYPE);
													payrollDetail.setBank(banco);
													payrollDetail.setPaymentAccount(cuenta);
													if(banco.equals("Otros")) {
														payrollDetail.setCciNumber(cuenta);
													}else {
														payrollDetail.setCciNumber("");
													}
													payrollDetail.setDepartment(departamento);
													String fullNames = client.getNombre().toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u").replace("à", "a").replace("è", "e").replace("ì", "i").replace("ò", "o").replace("ù", "u").replace("ä", "a").replace("ë", "e").replace("ï", "i").replace("ö", "o").replace("ü", "u").replace("ñ", "n").replace("'", "");
													payrollDetail.setCustomerName(fullNames.trim());
													if(client.getTypeId().trim().equals("DNI")) {
														payrollDetail.setCustomerIdType(Constants.FD_MONNET_DETAIL_ID_TYPE_DNI);
													}else if(client.getTypeId().trim().equals("PASAP")) {
														payrollDetail.setCustomerIdType(Constants.FD_MONNET_DETAIL_ID_TYPE_PAS);
													}else if(client.getTypeId().trim().equals("CAREX")) {
														payrollDetail.setCustomerIdType(Constants.FD_MONNET_DETAIL_ID_TYPE_CE);
													}
													payrollDetail.setCustomerId(client.getNumberId().trim());
													if(client.getMail()!=null && !client.getMail().trim().isEmpty()) {
														payrollDetail.setCustomerEmail(client.getMail());
													}else {
														payrollDetail.setCustomerEmail(Constants.FD_MONNET_DETAIL_EMAIL_DEFAULT);
													}
													payrollDetail.setUserName(Constants.FD_MONNET_DETAIL_USER_NAME);
													payrollDetail.setAccountNumber(Constants.FD_MONNET_DETAIL_ACCOUNT_NUMBER);
													payrollDetail.setKycyn(Constants.ESPACIO);
													payrollDetail.setReference(Constants.ESPACIO);
													payrollDetail.setCustomerCellphone(Constants.FD_MONNET_DETAIL_PHONE);
													List<PayrollDetail> listPayrollDetail = new ArrayList<PayrollDetail>();
													listPayrollDetail.add(payrollDetail);
													payrollRequest.setDetail(listPayrollDetail);
													Gson gson = new Gson();
									    			String json = gson.toJson(payrollRequest);	
									    			LoggerApi.Log.info("payroll transfer Monnet request: "+ json);
									    			payrollResponse = getPaymentTransferMonnetResponse(log, json, uuid.toString());
													//si api monnet ok
													if(payrollResponse!=null && payrollResponse.getResult()!=null && payrollResponse.getResult().equals(Constants.RESULT_OK)) {
														LoggerApi.Log.info(log+" payrollResponse OK=" + payrollResponse.getResult());
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
														}*/
														session.setAttribute("paymentPrizeProcedureGetDataCollectPrizes", paymentPrizeProcedureGetDataCollectPrizes);
														//registrar respuesta api monnet*
														//Object[] values = new Object[25];
														//values[0] = result.getRequestNumber();	
														//paymentPrizeBo.approveRequestVisa(values); 
														mensaje = result.getMessage();//mensaje de exito al crear solicitud
													}else {
														//denegacion automatica
														//mensaje = paymentPrizeProcedureGetDataCollectPrizes.getMsgAutomaticTraDen();//mensaje de error al intentar call api monnet
														if(payrollResponse!=null && payrollResponse.getTypeError()!=null && payrollResponse.getTypeError().trim().equals("1")) {
															mensaje = "Antes de poder solicitar una transferencia, debes actualizar y completar tus datos en tu cuenta de La Tinka. Tu dinero está disponible para retiro.<br><br><a href=\"https://m.latinka.com.pe/derechos-arco.html\" target=\"_blank\" style=\"text-decoration: underline; color: #e30613;\">Actualiza tus datos aquí</a> e intenta nuevamente, o solicita tu retiro usando otro método.";
															o.addProperty("titulo", "No es posible procesar tu transferencia");
														}else {
															int transactionId = Constants.generateTransactionId();
															mensaje = Constants.MSG_EXCEPTION+"<br><br>Nº de operación: I"+transactionId+"<br>"+sdfFront.format(new Date());
															o.addProperty("titulo", "No fue posible confirmar tu transferencia");
														}
														Object[] values = new Object[2];
														values[0] = result.getRequestNumber();
														values[1] = Constants.VACIO;
														paymentPrizeBo.refuseRequestAutomatic(values);
														o.addProperty("cleanTrans", "OK");
														LoggerApi.Log.info(log+" Transferencia denegacion automatica: "+ mensaje);
													}
												}else {
													mensaje = result.getMessage();//mensaje de error al intentar crear solicitud
												}
												
												if(guardarRecurrente.equals("true")) {
													List<PaymentPrizeProcedureGetSavingsAccount> getSavingsAccount=paymentPrizeBo.getSavingsAccount(clientId);
													Gson gson = new Gson();
													o.addProperty("getSavingsAccount", gson.toJson(getSavingsAccount));
													o.addProperty("guardarRecurrente", guardarRecurrente);
													session.setAttribute("getSavingsAccount", getSavingsAccount);
												}
								
												o.addProperty("message", mensaje);
												o.addProperty("amount", result.getAmount());
												o.addProperty("requestNumber", result.getRequestNumber());
												o.addProperty("status", Constants.RESULT_OK);
												o.addProperty("messageSuccess", paymentPrizeProcedureGetDataCollectPrizes.getMsgAutomaticTraApr());
												o.addProperty("evaluacion", "AUTOMATICO");
											}else {
												o.addProperty("message", Constants.MSG_BLACKLIST);
												o.addProperty("status", Constants.RESULT_OK);
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
							//o.addProperty("message", Constants.MSG_AMOUNT_OUT_RANGE.replace("MIN", ClientUtils.formatCurrency3(paymentPrizeProcedureGetDataCollectPrizes.getAmountMinRequestTra().intValue())).replace("MAX", ClientUtils.formatCurrency3(paymentPrizeProcedureGetDataCollectPrizes.getAmountMaxRequestTra().intValue())) );
							o.addProperty("message", "Montos no válidos" );
						}      
					}else {
						o.addProperty("status", "ERROR_PARAMETERS");
						o.addProperty("message", "Los valores son inválidos");
					}
				}else {
					o.addProperty("status", "ERROR_PARAMETERS");
					o.addProperty("message", "El monto, banco, número de cuenta y departamento son obligatorios");
				}
			}else {
				o.addProperty("status", "ERROR_DATA");
				o.addProperty("titulo", "No es posible procesar tu transferencia");
				o.addProperty("message", "Antes de poder solicitar una transferencia, debes actualizar y completar tus datos en tu cuenta de La Tinka. Tu dinero está disponible para retiro.<br><br><a href=\"https://latinkaportal.com.pe/derechos-arco/?origin=i\" target=\"_blank\" style=\"text-decoration: underline; color: #e30613;\">Actualiza tus datos aquí</a> e intenta nuevamente, o solicita tu retiro usando otro método.");
			}
			out.print(o);
		} catch (Exception e) {			
			int transactionId = Constants.generateTransactionId();
			String mensaje = Constants.MSG_EXCEPTION+"<br><br>Nº de operación: I"+transactionId+"<br>"+sdfFront.format(new Date());
			o.addProperty("message", mensaje);
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e,log+ " mensaje: "+mensaje);
		}
		
		TransactionPaymentLogPin sessionPin = null;
		try {
	    	session.removeAttribute("PIN_SESSION");
			String status = o.getAsJsonObject().get("status").toString();
			sessionPin = paymentPrizeBo.transactionLogPin(paymentSession.getChannel(), "createRequestTransferenciaEnd", paymentSession.getClientId(), paymentSession.getClientIp(), paymentSession.getPinUuid(), paymentSession.getType(), paymentSession.getAmount()
						, status , o.toString() );
		} catch (Exception e) {
    		 LoggerApi.severe(e, "sessionPin="+sessionPin);
    	}
		
		LoggerApi.Log.info(log+" -------------- END createRequestTransferencia uuid="+uuid.toString());
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
	
	private PayrollResponse getPaymentTransferMonnetResponse(String log, String json, String uuid) {
		PayrollResponse payrollResponse = new PayrollResponse();
		Gson gson = new Gson();
		log += " getPaymentTransferMonnetResponse";
		try {
			String urlTransferMonnetPayrollAPI = ConnectionFactory.operationProperty("urlTransferMonnetPayrollAPI", Constants.contextSale);
			String userTransferAPI = ConnectionFactory.operationProperty("userTransferAPI", Constants.contextSale);
			String passTransferAPI = ConnectionFactory.operationProperty("passTransferAPI", Constants.contextSale);
			String credenciales = userTransferAPI+":"+passTransferAPI;
			LoggerApi.Log.info(log+" [CALL]: "+urlTransferMonnetPayrollAPI);
			credenciales = Base64.encodeBase64String(credenciales.getBytes());
 	    	URL url = new URL(urlTransferMonnetPayrollAPI);
 			HttpURLConnection  con = (HttpURLConnection )url.openConnection();
 			con.setRequestMethod("POST");
 			con.setRequestProperty("Authorization", "Basic "+credenciales);
 			con.setRequestProperty("Content-Type", Constants.APPLICATION_JSON);
 			con.setRequestProperty("Accept", Constants.APPLICATION_JSON);
     		con.setDoOutput(true);
     		OutputStream os = con.getOutputStream();
 			os.write(json.getBytes(Constants.CHARSET_UTF8));
 			os.flush();
 			os.close();
 			BufferedReader br = null;
 			int responseCode = con.getResponseCode();
 			if(responseCode < HttpServletResponse.SC_BAD_REQUEST) {
 				br = new BufferedReader(new InputStreamReader((con.getInputStream()),Constants.CHARSET_UTF8));
 			}else {
 				LoggerApi.Log.info(log+" API TRANSFERENCIA MONNET HTTP CODE: "+responseCode+" uuid: "+uuid+ " json: "+json);
 				br = new BufferedReader(new InputStreamReader((con.getErrorStream()),Constants.CHARSET_UTF8));
 			}
 			StringBuilder sb = new StringBuilder();
 			char[] buffer = new char[1000];
 	        int leido;
 	        while ((leido = br.read(buffer)) > 0) {
 	        	sb.append(new String(buffer, 0, leido));
 	        }
 			br.close();
 			con.disconnect();
			LoggerApi.Log.info(log+" [END]: "+urlTransferMonnetPayrollAPI);
 			String jsonResponsePayment = sb.toString();
 			if(responseCode >= HttpServletResponse.SC_BAD_REQUEST) {
 				LoggerApi.Log.info(log+" API TRANSFERENCIA MONNET RESPONSE: "+jsonResponsePayment+" uuid: "+uuid+ " json: "+json);	
 			}
 			LoggerApi.Log.info(log+" payrollResponse="+jsonResponsePayment+" uuid="+uuid.toString());
 			payrollResponse = gson.fromJson(jsonResponsePayment, PayrollResponse.class);
		} catch (Throwable e) {
			LoggerApi.severe(e,log);
		}
		return payrollResponse;
	}
	
	@RequestMapping(value = "/eliminarCuentaTransferencia")
	public void eliminarCuentaTransferencia(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
			throws Exception {
		UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START eliminarCuentaTransferencia uuid="+uuid.toString());
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		try {
			HttpSession session = request.getSession();			
			UserBean user = (UserBean) session.getAttribute(Constants.USR_SESION);
			String cuenta = request.getParameter("cuenta")!=null?request.getParameter("cuenta"):"";
			if (user!=null && user.getpSessionid()!=null && user.getpClientid()!=null && !cuenta.isEmpty()) {
				Integer idClient = user.getpClientid();
				PaymentPrizeProcedureDeleteAccount deleteAccount=paymentPrizeBo.deleteAccount(idClient, cuenta);
				
				if(deleteAccount!=null && deleteAccount.getResult().equals("OK") && deleteAccount.getMessage().equals("OK")) {
					List<PaymentPrizeProcedureGetSavingsAccount> getSavingsAccount=paymentPrizeBo.getSavingsAccount(idClient);
					Gson gson = new Gson();
					o.addProperty("getSavingsAccount", gson.toJson(getSavingsAccount));
					session.setAttribute("getSavingsAccount", getSavingsAccount);
					
					o.addProperty("message", Constants.RESULT_OK);
					o.addProperty("status", Constants.RESULT_OK);
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
				"		<td colspan='3' bgcolor='#ffffff' width='470' height='40' alt='' style='color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:13px;'>Acércate a una tienda o punto de venta de La Tinka y presenta tu recibo adjunto con tu DNI para realizar el cobro.</td>" + 
				"	</tr>" + 
				"	" + 
				"	<tr>" + 
				"		<td colspan='3' bgcolor='#ffffff' width='470' height='40' alt='' style='color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:13px;'>¡Protege tu recibo! Recuerda que el cobro es personal.</td>" + 
				"	</tr>" + 
				"	" + 
				"	<tr>" + 
				"		<td colspan='3' bgcolor='#ffffff' width='470' height='40' alt='' style='color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:13px;'>También puedes volver a visualizar tu recibo en el Historial de retiros, ingresando a <strong> Mis premios</strong> desde tu cuenta de <a href='https://www.latinka.com.pe/p/' target='_blank' style='color:#5a5a5a; font-family:Arial, Helvetica, sans-serif; font-size:13px; text-decoration:underline;'><strong>La Tinka.</strong></a></td>" + 
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
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		HttpSession session = request.getSession();
		TransactionPaymentToken paymentSession = null;

		try {

			ClientProcedureGetDataClient client = (ClientProcedureGetDataClient) session.getAttribute("CLIENT_SESSION");
			String type = request.getParameter("type")!=null?request.getParameter("type"):"";
			String amount = request.getParameter("amount")!=null?request.getParameter("amount"):"";
			String method="createPin";
			String p_sms = "";
			
			if (type.equals("REENVIAR")) {
				paymentSession = (TransactionPaymentToken) session.getAttribute("PIN_SESSION");
		    	paymentSession.setPinEnc("");
		    	method="recreatePin";
		    	LoggerApi.Log.info("Renviar por correo " + type);
			} else if(type.equals("REENVIARSMS")) {
				paymentSession = (TransactionPaymentToken) session.getAttribute("PIN_SESSION");
		    	paymentSession.setPinEnc("");
		    	method="recreatePin";
		    	p_sms="sms";
		    	LoggerApi.Log.info("Renviar por mensaje " + type);
			} else {
		    	session.removeAttribute("PIN_SESSION");
		    	paymentSession = new TransactionPaymentToken();
				paymentSession.setChannel("DESKTOP");
				paymentSession.setClientId(""+client.getClientId());
				paymentSession.setClientIp(ClientUtils.getClientIp(request));
				paymentSession.setPinUuid(pinuuid.toString());
				paymentSession.setType(type);
				paymentSession.setAmount(amount);
				
				
			}

	    	String pin =  pe.com.intralot.loto.util.StringLib.getRandom(10000,99999);
	    	String pinEnc = StringLib.encodeLabel(pin);
		    		
	    	TransactionPaymentCreatePin createPin = paymentPrizeBo.transactionCreatePin(paymentSession.getChannel(), method, paymentSession.getClientId(), paymentSession.getClientIp(), paymentSession.getPinUuid(), paymentSession.getType(), amount, pinEnc, p_sms);
	    	LoggerApi.Log.info("-------------- status  "+ createPin.getStatus());
	    	if ( createPin.getStatus().equals("OK") ) {
	    		
	    		String result = paymentSendPinMail(createPin.getMail(), createPin.getNombre(), pin, createPin.getMinutos() );

	    		if (result.equals("OK")) {
	    			
		    		o.addProperty("status", createPin.getStatus());
		    		o.addProperty("titulo", createPin.getTitulo());
		    		o.addProperty("mensaje", createPin.getMensaje());
		    		o.addProperty("contCorreo", createPin.getCont_correo());
		    		
		    		paymentSession.setPinEnc(pinEnc);
			    	session.setAttribute("PIN_SESSION", paymentSession);
			    	
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

		    		paymentSession.setPinEnc(pinEnc);
			    	session.setAttribute("PIN_SESSION", paymentSession);
	    		} else {
	    			LoggerApi.Log.info("Error: " + "No se puede establecer conexion con el servicio de sms " + "Code: " + result.getCode() +" status: " +result.getStatus());
	    			o.addProperty("status", "ERROR");
		    		o.addProperty("titulo", "No se ha logrado enviar el c&oacute;digo de autorizaci&oacute;n");
		    		o.addProperty("mensaje","Ocurri&oacute; un incidente inesperado. Por favor realice la acci&oacute;n nuevamente.");
	    		}
	    	}else {
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

        String context = Constants.contextCardWeb;
        StringBuffer mailBodyPass = new StringBuffer();
        String mailSender = email;
        String mailSubject = "Código de autorización de retiro";
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
    				   "		<td colspan='3' bgcolor='#ffffff' width='470' height='63' alt='' style='color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:22px;'><strong>¡Hola "+name+"!</strong></td>            "+
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
    				   "		<td bgcolor='#ffffff' width='422' height='33' alt='' style='color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:12px;'>¿No solicitaste ningún retiro de tus premios? Para mantener tu cuenta segura, te recomendamos <a href='https://www.latinka.com.pe/p/restablecer.html' style='color:#07663a;'><u>cambiar tu contraseña aquí</u></style>            "+
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
    				   "		<td colspan='5' bgcolor='#dedede' width='600' height='117' alt=''></td>            "+
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
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		String result = "";
		HttpSession session = request.getSession();
		TransactionPaymentToken paymentSession = (TransactionPaymentToken) session.getAttribute("PIN_SESSION");

		try {

			String inputPin = request.getParameter("pin")!=null?request.getParameter("pin"):"";
	    	String inputPinEnc = StringLib.encodeLabel(inputPin);

	    	TransactionPaymentValidatePin validatePin = paymentPrizeBo.transactionValidatePin(paymentSession.getChannel(), "validatePin", paymentSession.getClientId(), paymentSession.getClientIp(), paymentSession.getPinUuid(), paymentSession.getType(), paymentSession.getAmount(), "", inputPinEnc);

    		paymentSession.setValidatePinStatus(validatePin.getStatus());
	    	session.setAttribute("PIN_SESSION", paymentSession);
	    	
	    	if ( validatePin.getStatus().equals("OK") ) {
	    		
		    	if  ( !paymentSession.getPinEnc().equals(inputPinEnc) ) {

		    		o.addProperty("status", "CODEERROR");
		    		o.addProperty("mensajeerror", "Código incorrecto. Verifique si escribió correctamente.");
		    		result = "Pin de session no corresponde al Pin de ingreso"; 
		    				
		    	} else {
		    				    		
		    		o.addProperty("status", validatePin.getStatus());
		    		o.addProperty("type", paymentSession.getType());    		
		    		
		    	}
		    		    		
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
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
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
	
	@RequestMapping(value = "/registerCAPP")
	public void registerCA(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		String ip=ClientUtils.getClientIp(request);
		PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
		try {
			HttpSession session = request.getSession();
			Integer clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
			String medio = request.getParameter("medio");
			String code = request.getParameter("code");
			String description = request.getParameter("description");
			String monto = request.getParameter("monto");
			
			Object[] valuesRegisterErrorCA = new Object[8];
			valuesRegisterErrorCA[0] = clientId;
			valuesRegisterErrorCA[1] = ip;
			valuesRegisterErrorCA[2] = "DESKTOP";
			valuesRegisterErrorCA[3] = "ECOMMERCE";
			valuesRegisterErrorCA[4] = "RETIRO";
			valuesRegisterErrorCA[5] = medio;
			valuesRegisterErrorCA[6] = code;
			valuesRegisterErrorCA[7] = description;
			PaymentPrizeProcedureRegisterErrorCA registerErrorCA = paymentPrizeBo.registerErrorCA(valuesRegisterErrorCA);
			if(registerErrorCA!=null && registerErrorCA.getState()!=null && registerErrorCA.getState().equals("BAN")) {
				Object[] valuesRegisterTYCPDPLog = new Object[10];
				valuesRegisterTYCPDPLog[0] = clientId;
				valuesRegisterTYCPDPLog[1] = "PRE";
				valuesRegisterTYCPDPLog[2] = "BO";
				valuesRegisterTYCPDPLog[3] = ip;
				valuesRegisterTYCPDPLog[4] = "DESKTOP";
				valuesRegisterTYCPDPLog[5] = "ECOMMERCE";
				valuesRegisterTYCPDPLog[6] = "RETIRO";
				valuesRegisterTYCPDPLog[7] = medio;
				valuesRegisterTYCPDPLog[8] = code;
				valuesRegisterTYCPDPLog[9] = description;
				paymentPrizeBo.registerTYCPDPLog(valuesRegisterTYCPDPLog);
				o.addProperty("ban", "OK");
				
				String body ="<html>" + 
						"<head>" + 
						"<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>" + 
						"</head>" + 
						"<body leftmargin='0' topmargin='0' marginwidth='0' marginheight='0'>" + 
						"<p>ID de cliente: " + clientId+
						"<br>Metodo: Retiro"+
						"<br>Medio: "+medio+
						"<br>Monto: "+monto+
						"</p>"+ 
						"</body>" + 
						"</html>";
				try {
					MailLib.sendValidMail(ConnectionFactory.operationProperty("mailSourceApp", Constants.contextSale), "LA TINKA", ConnectionFactory.operationProperty("mailTargetAntifraudeRetiro", Constants.contextSale),"Alerta de fraude", body, Constants.FORMAT_HTML_UTF8, null, null, null, null);
				} catch (Exception e) {
					LoggerApi.severe(e);
				}
			}else {
				o.addProperty("ban", "KO");
			}			
		} catch (Exception e) {
			LoggerApi.severe(e);
		}
		out.print(o);
	}
}
