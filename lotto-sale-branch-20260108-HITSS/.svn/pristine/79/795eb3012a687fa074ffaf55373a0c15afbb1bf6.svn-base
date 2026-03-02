package pe.com.intralot.loto.layer.model.persistence.daoimpl;

/**
* TicketSaleDaoImpl
*
* <ul>
* <li> 2018 INTRALOT DE PERU.</li>
* </ul>
*
* @author Angel Chata
* @since 2017
* @version 
* 
* 001 c_achata se actualiza el la logitud de la fecha de 8 a 10. Se cambia jugada de 1 a A y B 
*
*/

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetDetail;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicketRetail;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetPrizesList;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetRetailTeApuestoGrecia;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetTicketsFilterList;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetTicketsList;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureSearchDetailGrecia;
import pe.com.intralot.loto.layer.model.persistence.dao.TicketSaleDao;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.lib.StringLib;
import pe.com.intralot.loto.lib.TestFunc;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.sale.card.dispatcher.BussinessSaleDispatcher;
import pe.com.intralot.loto.sale.client.lib.Permuta;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.ClientUtils;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

@Repository
public class TicketSaleDaoImpl extends HibernateBaseDaoImpl implements TicketSaleDao {

	@Override
	public List<TicketProcedureGetPrizesList> findPrizesList(Integer p_clientId) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientId);
		List<TicketProcedureGetPrizesList> resultQuery = new ArrayList<TicketProcedureGetPrizesList>();
		try {
			Object[] values = new Object[1];
			values[0] = p_clientId;
			resultQuery = super.findForNamed("TICKETSALE_GETPRIZESLIST", values);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			LoggerApi.Log.info("size=" + resultQuery.size());
		}
		return resultQuery;
	}

	@Override
	public List<TicketProcedureGetTicketsList> findTicketsList(Integer p_clientId) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientId);
		List<TicketProcedureGetTicketsList> resultQuery = new ArrayList<TicketProcedureGetTicketsList>();
		try {
			Object[] values = new Object[1];
			values[0] = p_clientId;
			resultQuery = super.findForNamed("TICKETSALE_GETTICKETSLIST", values);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			LoggerApi.Log.info("ticketWeb size=" + resultQuery.size());
		}
		return resultQuery;
	}

	@Override
    public TicketProcedureGetClientTicket findClientTicket(Integer p_clientid, Integer p_gameid, Long p_ticketid) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientid + " p_gameid=" + p_gameid + " p_ticketid=" + p_ticketid);
		List<TicketProcedureGetClientTicket> resultQuery = new ArrayList<TicketProcedureGetClientTicket>();
		TicketProcedureGetClientTicket objectDomain = new TicketProcedureGetClientTicket();
		try {
			Object[] values = new Object[3];
			values[0] = p_clientid;
			values[1] = p_gameid;
			values[2] = p_ticketid;
			resultQuery = super.findForNamed("TICKETSALE_GETCLIENTTICKET", values);
			objectDomain = DataAccessUtils.uniqueResult(resultQuery);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
                LoggerApi.Log.info("cid="+p_clientid+" p_ctticketid=" + objectDomain.getCtTicketId() + " p_ctclientid=" + objectDomain.getCtClientId() + " p_ticketnum="
                        + objectDomain.getCtTicketNumber() + " p_ctgameid=" + objectDomain.getCtGameId() + " p_ticketdate=" + objectDomain.getCtTicketDate() + " p_zonecd="
                        + objectDomain.getCtZoneCd() + " p_sectorcd=" + objectDomain.getCtSectorCd() + " p_agencycd=" + objectDomain.getCtAgencyCd() + " p_terminalnr="
                        + objectDomain.getCtTerminalNr() + " p_receiptnr=" + objectDomain.getCtReceiptNr() + " p_trnsnum=" + objectDomain.getCtTrnsNum() + " p_crc="
                        + objectDomain.getCtCrc() + " p_numcolumns=" + objectDomain.getCtNumColumns() + " p_saletype=" + objectDomain.getCtSaleType() + " p_eventitems="
                        + objectDomain.getCtEventItems() + " TrmId=" + objectDomain.getCtTrmId());
			} else {
				LoggerApi.Log.info("cid=" + p_clientid + " objectDomain=" + objectDomain);
			}
		}
		return objectDomain;
	}

	@Override
    public StringBuffer findCouponClientTicket(TicketProcedureGetClientTicket p_clientTicket, int tip_coupon) throws Exception {
		LoggerApi.Log.info("p_clientTicket=" + p_clientTicket + " tip_coupon=" + tip_coupon);
		StringBuffer htmlText = new StringBuffer();
		// String context = "CARD-WEB";
		String context = Constants.contextCardWeb;

		try {
			String[] betMatrix1 = null;
			String[] betMatrix2 = null;
			String[] betMatrix3 = null;
			String[] betMatrix4 = null;
			int bet1 = 0;
			int bet2 = 0;
			int bet3 = 0;
			int bet4 = 0;
			String matrix1 = "";
			String matrix2 = "";
			String matrix3 = "";
			String matrix4 = "";
			String ticketId = "";
			String clientId = "";
			// String clComName = "";
			// String clComNumber = "";
			//int crc = 0;
			String trnsNum = "0";
			int fromDraw = 0;
			String fromDrawDay = "";
			int gameNumber = 0;
			int numColumns = 0;
			Double receiptAmount = 0.0;
			Double receiptDiscounted = 0.0;
			int receiptNr = 0;
			String ticketDate = "";
			String ticketNumber = "";
			String crc_v = "";
			/**** aqui */
			int toDraw = 0;
			int consecutive = 0;
			String trmId = "";
			String gameName = "";// p_clientTicket.getGame().getName();
			int betMultiA = 0;
			int bet3ExactA = 0;
			int bet3AnyA = 0;
			int bet2ExactA = 0;
			int bet1ExactA = 0;
			int betMultiB = 0;
			int bet3ExactB = 0;
			int bet3AnyB = 0;
			int bet2ExactB = 0;
			int bet1ExactB = 0;
			String saleType = null;
			String imgGame = null;
			String imgW = null;
			String imgH = null;
			String charity = null;
			String webAddress = null;
			String bm1 = "";
			String mbm1 = "";
			String bm2 = "";
			String mbm2 = "";
			String bm3 = "";
			String mbm3 = "";
			String bm4 = "";
			String mbm4 = "";
			String tn = "";// **aqui///
			String solved = "";
			int total = 0;
			int betMax = 0;
			// Add-Ons
			String addOn1 = "";
			String addOn2 = "";
			String addOn3 = "";
			String addOn4 = "";
            boolean flagPlus = Boolean.valueOf(ConnectionFactory.operationProperty("kabalaPlusEnabled", Constants.contextCardWeb).trim()).booleanValue();
        	boolean flagChauChamba = Boolean.valueOf(ConnectionFactory.operationProperty("kabalaChauChambaEnabled", Constants.contextCardWeb).trim()).booleanValue();
			if (p_clientTicket.getCtBetMatrix1() != null)
				matrix1 = p_clientTicket.getCtBetMatrix1();
			if (p_clientTicket.getCtBetMatrix2() != null)
				matrix2 = p_clientTicket.getCtBetMatrix2();
			if (p_clientTicket.getCtBetMatrix3() != null)
				matrix3 = p_clientTicket.getCtBetMatrix3();
			if (p_clientTicket.getCtBetMatrix4() != null)
				matrix4 = p_clientTicket.getCtBetMatrix4();
			if (matrix1 != null && !matrix1.equals(""))
				betMatrix1 = matrix1.split(" ");
			if (matrix2 != null && !matrix2.equals(""))
				betMatrix2 = matrix2.split(" ");
			if (matrix3 != null && !matrix3.equals(""))
				betMatrix3 = matrix3.split(" ");
			if (matrix4 != null && !matrix4.equals(""))
				betMatrix4 = matrix4.split(" ");
			if (p_clientTicket.getCtTicketId() != null)
				ticketId = p_clientTicket.getCtTicketId();
			if (p_clientTicket.getCtClientId() != null)
				clientId = p_clientTicket.getCtClientId();
			/*if (p_clientTicket.getCtCrc() != null)
			crc = p_clientTicket.getCtCrc();*/
			if (p_clientTicket.getCtTrnsNum() != null)
				trnsNum = p_clientTicket.getCtTrnsNum();
			if (p_clientTicket.getCtFromDraw() != null)
				fromDraw = p_clientTicket.getCtFromDraw();
			if (p_clientTicket.getFromDrawDay() != null)
				fromDrawDay = p_clientTicket.getFromDrawDay();
			if (p_clientTicket.getCtGameNumber() != 0)
				gameNumber = p_clientTicket.getCtGameNumber();
			if (p_clientTicket.getCtNumColumns() != null)
				numColumns = p_clientTicket.getCtNumColumns();
			if (p_clientTicket.getCtReceiptAmount() != null)
				receiptAmount = p_clientTicket.getCtReceiptAmount();
			if (p_clientTicket.getCtReceiptDiscounted() != null)
				receiptDiscounted = p_clientTicket.getCtReceiptDiscounted();
			if (p_clientTicket.getCtReceiptNr() != null)
				receiptNr = p_clientTicket.getCtReceiptNr();
			if (p_clientTicket.getCtTicketDate() != null)
				ticketDate = p_clientTicket.getCtTicketDate();
			/***** aqui */
			if (p_clientTicket.getCtTicketNumber() != null) {
				ticketNumber = StringLib.decodeLabel(p_clientTicket.getCtTicketNumber());
				p_clientTicket.setCrc_v(TestFunc.getCrc_v(ticketNumber));
			}
			/******/
			if (p_clientTicket.getCtToDraw() != null)
				toDraw = p_clientTicket.getCtToDraw();
			if (p_clientTicket.getCtTrmId() != null)
				trmId = p_clientTicket.getCtTrmId();
			if (p_clientTicket.getCtBetMultiA() != null)
				betMultiA = p_clientTicket.getCtBetMultiA();
			if (p_clientTicket.getCtBet3exactA() != null)
				bet3ExactA = p_clientTicket.getCtBet3exactA();
			if (p_clientTicket.getCtBet3anyA() != null)
				bet3AnyA = p_clientTicket.getCtBet3anyA();
			if (p_clientTicket.getCtBet2exactA() != null)
				bet2ExactA = p_clientTicket.getCtBet2exactA();
			if (p_clientTicket.getCtBet1exactA() != null)
				bet1ExactA = p_clientTicket.getCtBet1exactA();
			if (p_clientTicket.getCtBetMultiB() != null)
				betMultiB = p_clientTicket.getCtBetMultiB();
			if (p_clientTicket.getCtBet3exactB() != null)
				bet3ExactB = p_clientTicket.getCtBet3exactB();
			if (p_clientTicket.getCtBet3anyB() != null)
				bet3AnyB = p_clientTicket.getCtBet3anyB();
			if (p_clientTicket.getCtBet2exactB() != null)
				bet2ExactB = p_clientTicket.getCtBet2exactB();
			if (p_clientTicket.getCtBet1exactB() != null)
				bet1ExactB = p_clientTicket.getCtBet1exactB();
			// Add-Ons
			if (p_clientTicket.getCtAddOn1() != null) {
				addOn1 = p_clientTicket.getCtAddOn1().trim();
				if (addOn1.equals("8")) {
					addOn1 = "0-8";
				} else if (addOn1.equals("915")) {
					addOn1 = "9-15";
				} else if (addOn1.equals("1620")) {
					addOn1 = "16-20";
				} else if (addOn1.equals("2125")) {
					addOn1 = "21-25";
				} else if (addOn1.equals("2630")) {
					addOn1 = "26-30";
				} else if (addOn1.equals("3135")) {
					addOn1 = "31-35";
				} else if (addOn1.equals("3640")) {
					addOn1 = "36-40";
				} else if (addOn1.equals("4143")) {
					addOn1 = "41- 43";
				} else if (addOn1.equals("4445")) {
					addOn1 = "44-46";
				} else if (addOn1.equals("47")) {
					addOn1 = "47-a mas";
				}
			}

			if (p_clientTicket.getCtAddOn2() != null) {
				addOn2 = p_clientTicket.getCtAddOn2().trim();
				if (addOn2.equals("8")) {
					addOn2 = "0-8";
				} else if (addOn2.equals("915")) {
					addOn2 = "9-15";
				} else if (addOn2.equals("1620")) {
					addOn2 = "16-20";
				} else if (addOn2.equals("2125")) {
					addOn2 = "21-25";
				} else if (addOn2.equals("2630")) {
					addOn2 = "26-30";
				} else if (addOn2.equals("3135")) {
					addOn2 = "31-35";
				} else if (addOn2.equals("3640")) {
					addOn2 = "36-40";
				} else if (addOn2.equals("4143")) {
					addOn2 = "41- 43";
				} else if (addOn2.equals("4445")) {
					addOn2 = "44-46";
				} else if (addOn2.equals("47")) {
					addOn2 = "47-a mas";
				}
			}
			if (p_clientTicket.getCtAddOn3() != null) {
				addOn3 = p_clientTicket.getCtAddOn3().trim();
				if (addOn3.equals("8")) {
					addOn3 = "0-8";
				} else if (addOn3.equals("915")){
					addOn3 = "9-15";
				} else if (addOn3.equals("1620")){
					addOn3 = "16-20";
				} else if (addOn3.equals("2125")){
					addOn3 = "21-25";
				} else if (addOn3.equals("2630")) {
					addOn3 = "26-30";
				} else if (addOn3.equals("3135")) {
					addOn3 = "31-35";
				} else if (addOn3.equals("3640")){
					addOn3 = "36-40";
				} else if (addOn3.equals( "4143")) {
					addOn3 = "41- 43";
				} else if (addOn3.equals("4445")) {
					addOn3 = "44-46";
				} else if (addOn3.equals("47")) {
					addOn3 = "47-a mas";
				}
			}
			if (p_clientTicket.getCtAddOn4() != null) {
				addOn4 = p_clientTicket.getCtAddOn4().trim();
				if (addOn4.equals("8")){
					addOn4 = "0-8";
				} else if (addOn4.equals("915")){
					addOn4 = "9-15";
				} else if (addOn4.equals("1620")){
					addOn4 = "16-20";
				} else if (addOn4.equals("2125")){
					addOn4 = "21-25";
				} else if (addOn4.equals("2630")){
					addOn4 = "26-30";
				} else if (addOn4.equals("3135")){
					addOn4 = "31-35";
				} else if (addOn4.equals("3640")){
					addOn4 = "36-40";
				} else if (addOn4.equals("4143")) {
					addOn4 = "41- 43";
				} else if (addOn4.equals("4445")) {
					addOn4 = "44-46";
				} else if (addOn4.equals("47")) {
					addOn4 = "47-a mas";
				}
			}

			Game game = new Game(gameNumber);
			gameName = game.getName();
			LoggerApi.Log.info("################## AD-ON ####################");
			LoggerApi.Log.info("addOn1 -> " + addOn1);
			LoggerApi.Log.info("addOn2 -> " + addOn2);
			LoggerApi.Log.info("addOn3 -> " + addOn3);
			LoggerApi.Log.info("addOn4 -> " + addOn4);
			LoggerApi.Log.info("################## MATRIX ####################");
			LoggerApi.Log.info("matrix1 -> " + matrix1);
			LoggerApi.Log.info("matrix2 -> " + matrix2);
			LoggerApi.Log.info("matrix3 -> " + matrix3);
			LoggerApi.Log.info("matrix4 -> " + matrix4);
			String barcode = ClientUtils.Interleaved2of5(ticketNumber, null);
			if (p_clientTicket.getCrc_v() != null) {
				// crc_v
				crc_v = String.valueOf(p_clientTicket.getCrc_v()).trim();
				if (crc_v.length() == 1)
					crc_v = "0000" + crc_v;
				else if (crc_v.length() == 2)
					crc_v = "000" + crc_v;
				else if (crc_v.length() == 3)
					crc_v = "00" + crc_v;
				else if (crc_v.length() == 4)
					crc_v = "0" + crc_v;
			} else
				crc_v = " ";
			if (betMatrix1 != null) {
				bet1 = betMatrix1.length;
				if (gameNumber == Game.GANAGOL)
					for (int i = 0; i < bet1; i++) {
						String betM1 = "";
						for (int j = 0; j < betMatrix1[i].length(); j++) {
							char betM = betMatrix1[i].charAt(j);
							if (betMatrix1[i].length() == 1) {
								if (j == 0 && betM == 'L')
									betM1 += betM + "&ndash;&ndash;";
								if (j == 0 && betM == 'E')
									betM1 += "&ndash;" + betM + "&ndash;";
								if (j == 0 && betM == 'V')
									betM1 += "&ndash;&ndash;" + betM;
							} else if (betMatrix1[i].length() == 2) {
								if (j == 0 && betM == 'L')
									betM1 += betM;
								if (j == 0 && betM == 'E')
									betM1 += "&ndash;" + betM;
								if (j == 1 && betM == 'E')
									betM1 += betM + "&ndash;";
								if (j == 1 && betM == 'V')
									if (betM1.equals("L"))
										betM1 += "&ndash;" + betM;
									else if (!betM1.equals("L"))
										betM1 += betM;
							} else if (betMatrix1[i].length() == 3)
								betM1 += betM;
						}
						bm1 += betM1 + "<br/>";
					}
				else if (gameNumber == Game.SUPER3) {
					for (int i = 0; i < bet1; i++)
						if ((i + 1) % 6 == 0 && i + 1 != bet1)
							bm1 += "&nbsp;&nbsp;&nbsp;" + betMatrix1[i] + "<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						else
							bm1 += "&nbsp;&nbsp;&nbsp;" + betMatrix1[i];
				} else if (gameNumber == Game.MEGATINKA) {
					boolean flag1 = false;
					for (int i = 0; i < bet1; i++)
						if (NumberUtils.isNumber(betMatrix1[i])) {
							if (flag1)
								mbm1 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix1[i], 2, "0");
							else if (i > 0 && i % 9 == 0)
                                bm1 += "&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix1[i], 2, "0");
							else
								bm1 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix1[i], 2, "0");
						} else if (!betMatrix1[i].equals(""))
							flag1 = true;
				} else if (gameNumber == Game.KABALA) {
					if (!flagPlus && flagChauChamba) {
                		if (addOn1.contains("1")) matrix1 += " " + "AD1";
                		if (addOn1.contains("2")||addOn1.contains("4")) matrix1 += " " + "CC";
					} else {
                		if (addOn1.contains("1")) matrix1 += " " + "AD1";
                		if (addOn1.contains("2")) matrix1 += " " + "AD2";
					}
					betMatrix1 = matrix1.split(" ");
					for (int i = 0; i < betMatrix1.length; i++)
						if (i > 0 && i % 9 == 0)
                            bm1 += "&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix1[i], 2, "0");
						else
							bm1 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix1[i], 2, "0");
					LoggerApi.Log.info("################# KABALA ################");
					LoggerApi.Log.info("bm1 -> " + bm1);
				} else
					for (int i = 0; i < bet1; i++)
						if (i > 0 && i % 9 == 0)
                            bm1 += "&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix1[i], 2, "0");
						else
							bm1 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix1[i], 2, "0");
			}
			if (betMatrix2 != null) {
				bet2 = betMatrix2.length;
				if (gameNumber == Game.GANAGOL)
					for (int i = 0; i < bet2; i++) {
						String betM2 = "";
						for (int j = 0; j < betMatrix2[i].length(); j++) {
							char betM = betMatrix2[i].charAt(j);
							if (betMatrix2[i].length() == 1) {
								if (j == 0 && betM == 'L')
									betM2 += betM + "&ndash;&ndash;";
								if (j == 0 && betM == 'E')
									betM2 += "&ndash;" + betM + "&ndash;";
								if (j == 0 && betM == 'V')
									betM2 += "&ndash;&ndash;" + betM;
							} else if (betMatrix2[i].length() == 2) {
								if (j == 0 && betM == 'L')
									betM2 += betM;
								if (j == 0 && betM == 'E')
									betM2 += "&ndash;" + betM;
								if (j == 1 && betM == 'E')
									betM2 += betM + "&ndash;";
								if (j == 1 && betM == 'V')
									if (betM2.equals("L"))
										betM2 += "&ndash;" + betM;
									else if (!betM2.equals("L"))
										betM2 += betM;
							} else if (betMatrix2[i].length() == 3)
								betM2 += betM;
						}
						bm2 += betM2 + "<br/>";
					}
				else if (gameNumber == Game.SUPER3) {
					for (int i = 0; i < bet2; i++)
						if ((i + 1) % 6 == 0 && i + 1 != bet2)
							bm2 += "&nbsp;&nbsp;&nbsp;" + betMatrix2[i] + "<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						else
							bm2 += "&nbsp;&nbsp;&nbsp;" + betMatrix2[i];
				} else if (gameNumber == Game.MEGATINKA) {
					boolean flag2 = false;
					for (int i = 0; i < bet2; i++)
						if (NumberUtils.isNumber(betMatrix2[i])) {
							if (flag2)
								mbm2 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix2[i], 2, "0");
							else if (i > 0 && i % 9 == 0)
                                bm2 += "&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix2[i], 2, "0");
							else
								bm2 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix2[i], 2, "0");
						} else if (!betMatrix2[i].equals(""))
							flag2 = true;
				} else if (gameNumber == Game.KABALA) {
					if (!flagPlus && flagChauChamba) {
                		if (addOn2.contains("1")) matrix2 += " " + "AD1";
                		if (addOn2.contains("2")||addOn2.contains("4")) matrix2 += " " + "CC";
					} else {
                		if (addOn2.contains("1")) matrix2 += " " + "AD1";
                		if (addOn2.contains("2")) matrix2 += " " + "AD2";
					}
					betMatrix2 = matrix2.split(" ");
					for (int i = 0; i < betMatrix2.length; i++)
						if (i > 0 && i % 9 == 0)
                            bm2 += "&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix2[i], 2, "0");
						else
							bm2 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix2[i], 2, "0");
				} else
					for (int i = 0; i < bet2; i++)
						if (i > 0 && i % 9 == 0)
                            bm2 += "&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix2[i], 2, "0");
						else
							bm2 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix2[i], 2, "0");
			}
			if (betMatrix3 != null) {
				bet3 = betMatrix3.length;
				if (gameNumber == Game.GANAGOL)
					for (int i = 0; i < bet3; i++) {
						String betM3 = "";
						for (int j = 0; j < betMatrix3[i].length(); j++) {
							char betM = betMatrix3[i].charAt(j);
							if (betMatrix3[i].length() == 1) {
								if (j == 0 && betM == 'L')
									betM3 += betM + "&ndash;&ndash;";
								if (j == 0 && betM == 'E')
									betM3 += "&ndash;" + betM + "&ndash;";
								if (j == 0 && betM == 'V')
									betM3 += "&ndash;&ndash;" + betM;
							} else if (betMatrix3[i].length() == 2) {
								if (j == 0 && betM == 'L')
									betM3 += betM;
								if (j == 0 && betM == 'E')
									betM3 += "&ndash;" + betM;
								if (j == 1 && betM == 'E')
									betM3 += betM + "&ndash;";
								if (j == 1 && betM == 'V')
									if (betM3.equals("L"))
										betM3 += "&ndash;" + betM;
									else if (!betM3.equals("L"))
										betM3 += betM;
							} else if (betMatrix3[i].length() == 3)
								betM3 += betM;
						}
						bm3 += betM3 + "<br/>";
					}
				else if (gameNumber == Game.MEGATINKA) {
					boolean flag3 = false;
					for (int i = 0; i < bet3; i++)
						if (NumberUtils.isNumber(betMatrix3[i])) {
							if (flag3)
								mbm3 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix3[i], 2, "0");
							else if (i > 0 && i % 9 == 0)
                                bm3 += "&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix3[i], 2, "0");
							else
								bm3 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix3[i], 2, "0");
						} else if (!betMatrix3[i].equals(""))
							flag3 = true;
				} else if (gameNumber == Game.KABALA) {
					if (!flagPlus && flagChauChamba) {
                		if (addOn3.contains("1")) matrix3 += " " + "AD1";
                		if (addOn3.contains("2")||addOn3.contains("4")) matrix3 += " " + "CC";
					} else {
                		if (addOn3.contains("1")) matrix3 += " " + "AD1";
                		if (addOn3.contains("2")) matrix3 += " " + "AD2";
					}
					betMatrix3 = matrix3.split(" ");
					for (int i = 0; i < betMatrix3.length; i++)
						if (i > 0 && i % 9 == 0)
                            bm3 += "&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix3[i], 2, "0");
						else
							bm3 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix3[i], 2, "0");
				} else
					for (int i = 0; i < bet3; i++)
						if (i > 0 && i % 9 == 0)
                            bm3 += "&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix3[i], 2, "0");
						else
							bm3 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix3[i], 2, "0");
			}
			if (betMatrix4 != null) {
				bet4 = betMatrix4.length;
				if (gameNumber == Game.GANAGOL)
					for (int i = 0; i < bet4; i++) {
						String betM4 = "";
						for (int j = 0; j < betMatrix4[i].length(); j++) {
							char betM = betMatrix4[i].charAt(j);
							if (betMatrix4[i].length() == 1) {
								if (j == 0 && betM == 'L')
									betM4 += betM + "&ndash;&ndash;";
								if (j == 0 && betM == 'E')
									betM4 += "&ndash;" + betM + "&ndash;";
								if (j == 0 && betM == 'V')
									betM4 += "&ndash;&ndash;" + betM;
							} else if (betMatrix4[i].length() == 2) {
								if (j == 0 && betM == 'L')
									betM4 += betM;
								if (j == 0 && betM == 'E')
									betM4 += "&ndash;" + betM;
								if (j == 1 && betM == 'E')
									betM4 += betM + "&ndash;";
								if (j == 1 && betM == 'V')
									if (betM4.equals("L"))
										betM4 += "&ndash;" + betM;
									else if (!betM4.equals("L"))
										betM4 += betM;
							} else if (betMatrix4[i].length() == 3)
								betM4 += betM;
						}
						bm4 += betM4 + "<br/>";
					}
				else if (gameNumber == Game.MEGATINKA) {
					boolean flag4 = false;
					for (int i = 0; i < bet4; i++)
						if (NumberUtils.isNumber(betMatrix4[i])) {
							if (flag4)
								mbm4 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix4[i], 2, "0");
							else if (i > 0 && i % 9 == 0)
                                bm4 += "&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix4[i], 2, "0");
							else
								bm4 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix4[i], 2, "0");
						} else if (!betMatrix4[i].equals(""))
							flag4 = true;
				} else if (gameNumber == Game.KABALA) {
					if (!flagPlus && flagChauChamba) {
                		if (addOn4.contains("1")) matrix4 += " " + "AD1";
                		if (addOn4.contains("2")||addOn4.contains("4")) matrix4 += " " + "CC";
					} else {
                		if (addOn4.contains("1")) matrix4 += " " + "AD1";
                		if (addOn4.contains("2")) matrix4 += " " + "AD2";
					}
					betMatrix4 = matrix4.split(" ");
					for (int i = 0; i < betMatrix4.length; i++)
						if (i > 0 && i % 9 == 0)
                            bm4 += "&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix4[i], 2, "0");
						else
							bm4 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix4[i], 2, "0");
				} else
					for (int i = 0; i < bet4; i++)
						if (i > 0 && i % 9 == 0)
                            bm4 += "&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix4[i], 2, "0");
						else
							bm4 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix4[i], 2, "0");
			}
			/*** aqui ****/
			for (int i = 0; i < ticketNumber.length(); i++)
				if ((i + 1) % 5 == 0)
					tn += ticketNumber.charAt(i) + " ";
				else
					tn += "" + ticketNumber.charAt(i);
			if (gameNumber == Game.TINKA) {
				imgGame = "imgTinka.gif?v=1";
				imgW = "235";
				imgH = "60";
				charity = "SOCIEDAD DE BENEFICENCIA DE HUANCAYO";
				webAddress = "www.tinka.com.pe";
			} else if (gameNumber == Game.MEGATINKA) {
				imgGame = "imgTinkamegabol.jpg";
				imgW = "200";
				imgH = "85";
				charity = "SOCIEDAD DE BENEFICENCIA DE HUANCAYO";
				webAddress = "www.tinkamegabol.com.pe";
			} else if (gameNumber == Game.GANADIARIO) {
				imgGame = "imgGanadiario.jpg";
				imgW = "151";
				imgH = "100";
				charity = "SOCIEDAD DE BENEFICENCIA PUBLICA DE JAEN";
				webAddress = "www.ganadiario.com.pe";
			} else if (gameNumber == Game.GANAGOL) {
				imgGame = "imgGanagol.jpg";
				imgW = "250";
				imgH = "60";
				charity = "La Tinka S.A.";
				webAddress = "www.ganagol.com.pe";
			} else if (gameNumber == Game.SUPER3) {
				imgGame = "imgSuper3.jpg";
				imgW = "220";
				imgH = "110";
				charity = "SOCIEDAD DE BENEFICENCIA PUBLICA DE JAEN";
				webAddress = "www.super3.com.pe";
			} else if (gameNumber == Game.KABALA) {
				imgGame = "imgKabala.jpg";
				imgW = "150";
				imgH = "110";
				charity = "SOCIEDAD DE BENEFICENCIA PUBLICA DE JAEN";
				webAddress = "www.kabala.com.pe";
			}
            if (gameNumber == Game.TINKA || gameNumber == Game.GANADIARIO || gameNumber == Game.KABALA || gameNumber == Game.MEGATINKA) {
				fromDraw = fromDraw - game.getGapLotos5(); // 5000
				toDraw = toDraw - game.getGapLotos5(); // 5000
				consecutive = toDraw - (p_clientTicket.getLastDraw() - game.getGapLotos5());
				if (gameNumber == Game.TINKA || gameNumber == Game.KABALA)
					betMax = 6;
				if (gameNumber == Game.MEGATINKA)
					betMax = 8;
				if (gameNumber == Game.GANADIARIO)
					betMax = 5;
				if (bet1 > betMax) {
					String bm = "";
					String mbm = "";
					boolean flg = false;
					for (int i = 0; i < bet1; i++)
						if (NumberUtils.isNumber(betMatrix1[i])) {
							if (flg)
								mbm += "&nbsp;" + StringUtils.leftPad(betMatrix1[i], 2, "0");
							else
								bm += "&nbsp;" + StringUtils.leftPad(betMatrix1[i], 2, "0");
						} else if (!betMatrix1[i].equals(""))
							flg = true;
					if (gameNumber == Game.MEGATINKA)
						solved += "<tr><td>TKA:&nbsp;<b>" + bm + "</b>&nbsp;&nbsp;MTA:&nbsp;<b>" + mbm
								+ "</b></td></tr><tr><td><table cellpadding='0' cellspacing='2' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>";
					else
						solved += "<tr><td>A" + StringUtils.leftPad("" + bet1, 2, "0") + ":&nbsp;<b>" + bm
								+ "</b></td></tr><tr><td><table cellpadding='0' cellspacing='2' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>";
					ArrayList<String[]> fullBets = BussinessSaleDispatcher.getBets(gameNumber, matrix1);
					int i = 0;
					for (String[] c : fullBets) {
						if (i == 0)
							solved += "<tr valign='top'><td style='padding: 0 0 5px 0;'>";
						else if (i % 25 == 0 && c.length > 0)
							if (i % 125 == 0)
								solved += "</td></tr><tr valign='top'><td style='padding: 0 0 5px 0;'>";
							else
								solved += "</td><td style='padding: 0 0 5px 0;'>";
						if (i >= 0 && i < 9)
							solved += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + (i + 1) + ")&nbsp;";
						else if (i >= 9 && i < 99)
							solved += "&nbsp;&nbsp;&nbsp;&nbsp;" + (i + 1) + ")&nbsp;";
						else if (i >= 99 && i < 999)
							solved += "&nbsp;&nbsp;" + (i + 1) + ")&nbsp;";
						else
							solved += i + 1 + ")&nbsp;";
						int j = 0;
						for (String s : c) {
							if (j == c.length - 1 && gameNumber == Game.MEGATINKA)
								solved += "M&nbsp;" + s;
							else
								solved += s + "&nbsp;";
							j++;
						}
						if (i == fullBets.size() - 1)
							solved += "</td></tr>";
						else
							solved += "<br/>";
						i++;
					}
					solved += "</table></td></tr><tr><td>" + i + " jugadas<br/><br/></td></tr>";
					total += i;
				}
				if (bet2 > betMax) {
					String bm = "";
					String mbm = "";
					boolean flg = false;
					for (int i = 0; i < bet2; i++)
						if (NumberUtils.isNumber(betMatrix2[i])) {
							if (flg)
								mbm += "&nbsp;" + StringUtils.leftPad(betMatrix2[i], 2, "0");
							else
								bm += "&nbsp;" + StringUtils.leftPad(betMatrix2[i], 2, "0");
						} else if (!betMatrix2[i].equals(""))
							flg = true;
					if (gameNumber == Game.MEGATINKA)
						solved += "<tr><td>TKB:&nbsp;<b>" + bm + "</b>&nbsp;&nbsp;MTB:&nbsp;<b>" + mbm
								+ "</b></td></tr><tr><td><table cellpadding='0' cellspacing='2' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>";
					else
						solved += "<tr><td>B" + StringUtils.leftPad("" + bet2, 2, "0") + ":&nbsp;<b>" + bm
								+ "</b></td></tr><tr><td><table cellpadding='0' cellspacing='2' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>";
					ArrayList<String[]> fullBets = BussinessSaleDispatcher.getBets(gameNumber, matrix2);
					int i = 0;
					for (String[] c : fullBets) {
						if (i == 0)
							solved += "<tr valign='top'><td style='padding: 0 0 5px 0;'>";
						else if (i % 25 == 0 && c.length > 0)
							if (i % 125 == 0)
								solved += "</td></tr><tr valign='top'><td style='padding: 0 0 5px 0;'>";
							else
								solved += "</td><td style='padding: 0 0 5px 0;'>";
						if (i >= 0 && i < 9)
							solved += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + (i + 1) + ")&nbsp;";
						else if (i >= 9 && i < 99)
							solved += "&nbsp;&nbsp;&nbsp;&nbsp;" + (i + 1) + ")&nbsp;";
						else if (i >= 99 && i < 999)
							solved += "&nbsp;&nbsp;" + (i + 1) + ")&nbsp;";
						else
							solved += i + 1 + ")&nbsp;";
						int j = 0;
						for (String s : c) {
							if (j == c.length - 1 && gameNumber == Game.MEGATINKA)
								solved += "M&nbsp;" + s;
							else
								solved += s + "&nbsp;";
							j++;
						}
						if (i == fullBets.size() - 1)
							solved += "</td></tr>";
						else
							solved += "<br/>";
						i++;
					}
					solved += "</table></td></tr><tr><td>" + i + " jugadas<br/><br/></td></tr>";
					total += i;
				}
				if (bet3 > betMax) {
					String bm = "";
					String mbm = "";
					boolean flg = false;
					for (int i = 0; i < bet3; i++)
						if (NumberUtils.isNumber(betMatrix3[i])) {
							if (flg)
								mbm += "&nbsp;" + StringUtils.leftPad(betMatrix3[i], 2, "0");
							else
								bm += "&nbsp;" + StringUtils.leftPad(betMatrix3[i], 2, "0");
						} else if (!betMatrix3[i].equals(""))
							flg = true;
					if (gameNumber == Game.MEGATINKA)
						solved += "<tr><td>TKC:&nbsp;<b>" + bm + "</b>&nbsp;&nbsp;MTC:&nbsp;<b>" + mbm
								+ "</b></td></tr><tr><td><table cellpadding='0' cellspacing='2' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>";
					else
						solved += "<tr><td>C" + StringUtils.leftPad("" + bet3, 2, "0") + ":&nbsp;<b>" + bm
								+ "</b></td></tr><tr><td><table cellpadding='0' cellspacing='2' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>";
					ArrayList<String[]> fullBets = BussinessSaleDispatcher.getBets(gameNumber, matrix3);
					int i = 0;
					for (String[] c : fullBets) {
						if (i == 0)
							solved += "<tr valign='top'><td style='padding: 0 0 5px 0;'>";
						else if (i % 25 == 0 && c.length > 0)
							if (i % 125 == 0)
								solved += "</td></tr><tr valign='top'><td style='padding: 0 0 5px 0;'>";
							else
								solved += "</td><td style='padding: 0 0 5px 0;'>";
						if (i >= 0 && i < 9)
							solved += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + (i + 1) + ")&nbsp;";
						else if (i >= 9 && i < 99)
							solved += "&nbsp;&nbsp;&nbsp;&nbsp;" + (i + 1) + ")&nbsp;";
						else if (i >= 99 && i < 999)
							solved += "&nbsp;&nbsp;" + (i + 1) + ")&nbsp;";
						else
							solved += i + 1 + ")&nbsp;";
						int j = 0;
						for (String s : c) {
							if (j == c.length - 1 && gameNumber == Game.MEGATINKA)
								solved += "M&nbsp;" + s;
							else
								solved += s + "&nbsp;";
							j++;
						}
						if (i == fullBets.size() - 1)
							solved += "</td></tr>";
						else
							solved += "<br/>";
						i++;
					}
					solved += "</table></td></tr><tr><td>" + i + " jugadas<br/><br/></td></tr>";
					total += i;
				}
				if (bet4 > betMax) {
					String bm = "";
					String mbm = "";
					boolean flg = false;
					for (int i = 0; i < bet4; i++)
						if (NumberUtils.isNumber(betMatrix4[i])) {
							if (flg)
								mbm += "&nbsp;" + StringUtils.leftPad(betMatrix4[i], 2, "0");
							else
								bm += "&nbsp;" + StringUtils.leftPad(betMatrix4[i], 2, "0");
						} else if (!betMatrix4[i].equals(""))
							flg = true;
					if (gameNumber == Game.MEGATINKA)
						solved += "<tr><td>TKD:&nbsp;<b>" + bm + "</b>&nbsp;&nbsp;MTD:&nbsp;<b>" + mbm
								+ "</b></td></tr><tr><td><table cellpadding='0' cellspacing='2' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>";
					else
						solved += "<tr><td>D" + StringUtils.leftPad("" + bet4, 2, "0") + ":&nbsp;<b>" + bm
								+ "</b></td></tr><tr><td><table cellpadding='0' cellspacing='2' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>";
					ArrayList<String[]> fullBets = BussinessSaleDispatcher.getBets(gameNumber, matrix4);
					int i = 0;
					for (String[] c : fullBets) {
						if (i == 0)
							solved += "<tr valign='top'><td style='padding: 0 0 5px 0;'>";
						else if (i % 25 == 0 && c.length > 0)
							if (i % 125 == 0)
								solved += "</td></tr><tr valign='top'><td style='padding: 0 0 5px 0;'>";
							else
								solved += "</td><td style='padding: 0 0 5px 0;'>";
						if (i >= 0 && i < 9)
							solved += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + (i + 1) + ")&nbsp;";
						else if (i >= 9 && i < 99)
							solved += "&nbsp;&nbsp;&nbsp;&nbsp;" + (i + 1) + ")&nbsp;";
						else if (i >= 99 && i < 999)
							solved += "&nbsp;&nbsp;" + (i + 1) + ")&nbsp;";
						else
							solved += i + 1 + ")&nbsp;";
						int j = 0;
						for (String s : c) {
							if (j == c.length - 1 && gameNumber == Game.MEGATINKA)
								solved += "M&nbsp;" + s;
							else
								solved += s + "&nbsp;";
							j++;
						}
						if (i == fullBets.size() - 1)
							solved += "</td></tr>";
						else
							solved += "<br/>";
						i++;
					}
					solved += "</table></td></tr><tr><td>" + i + " jugadas<br/><br/></td></tr>";
					total += i;
				}
				if (total > 0)
                    solved += "<tr><td>Total:&nbsp;" + total + "&nbsp;apuestas generadas de jugadas m&uacute;ltiples.</td></tr>";
			}
			if (gameNumber == Game.GANAGOL) {
				fromDraw = fromDraw - game.getGapLotos5(); // 5000
				toDraw = toDraw - game.getGapLotos5(); // 5000
				if (bet1 == 14) {
					String bm = "";
					int cbm = 0;
					for (int i = 0; i < bet1; i++) {
						String betM1 = "";
						for (int j = 0; j < betMatrix1[i].length(); j++) {
							char betM = betMatrix1[i].charAt(j);
							if (betMatrix1[i].length() == 1) {
								if (j == 0 && betM == 'L')
									betM1 += betM + "&ndash;&ndash;";
								if (j == 0 && betM == 'E')
									betM1 += "&ndash;" + betM + "&ndash;";
								if (j == 0 && betM == 'V')
									betM1 += "&ndash;&ndash;" + betM;
							} else if (betMatrix1[i].length() == 2) {
								if (j == 0 && betM == 'L')
									betM1 += betM;
								if (j == 0 && betM == 'E')
									betM1 += "&ndash;" + betM;
								if (j == 1 && betM == 'E')
									betM1 += betM + "&ndash;";
								if (j == 1 && betM == 'V')
									if (betM1.equals("L"))
										betM1 += "&ndash;" + betM;
									else if (!betM1.equals("L"))
										betM1 += betM;
							} else if (betMatrix1[i].length() == 3)
								betM1 += betM;
						}
						bm += betM1 + "<br/>";
						cbm += betMatrix1[i].length();
					}
					if (cbm > 14) {
						ArrayList<String[]> fullBets = BussinessSaleDispatcher.getBets(gameNumber, matrix1);
						int i = 0;
						for (String[] c : fullBets) {
							if (i == 0)
								solved += "<tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;<br/>01:<br/>02:<br/>03:<br/>04:<br/>05:<br/>06:<br/>07:<br/>08:<br/>09:<br/>10:<br/>11:<br/>12:<br/>13:<br/>14:</td>"
										+ "<td align='center' style='padding: 0 0 5px 0;'><b>&nbsp;&nbsp;&nbsp;A&nbsp;&nbsp;&nbsp;<br/>"
                                        + bm
                                        + "</b></td><td align='center' style='padding: 0 0 5px 0;'>";
							else if (i % 25 == 0 && c.length > 0)
								solved += "</td></tr><tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;<br/>01:<br/>02:<br/>03:<br/>04:<br/>05:<br/>06:<br/>07:<br/>08:<br/>09:<br/>10:<br/>11:<br/>12:<br/>13:<br/>14:"
										+ "</td><td align='center' style='padding: 0 0 5px 0;'>&nbsp;</td><td align='center' style='padding: 0 0 5px 0;'>";
							if (i >= 0 && i < 9)
								solved += "&nbsp;&nbsp;<u>" + (i + 1) + "</u>&nbsp;&nbsp;<br/>";
							else if (i >= 9 && i < 99)
								solved += "&nbsp;<u>" + (i + 1) + "</u>&nbsp;<br/>";
							else
								solved += "<u>" + (i + 1) + "</u><br/>";
							for (String s : c)
								solved += s + "<br/>";
							if (i == fullBets.size() - 1)
								solved += "</td></tr>";
							else
								solved += "</td><td align='center' style='padding: 0 0 5px 0;'>";
							i++;
						}
						solved += "<tr><td colspan='15'><br/>" + i + " jugadas<br/><br/></td></tr>";
						total += i;
					}
				}
				if (bet2 == 14) {
					String bm = "";
					int cbm = 0;
					for (int i = 0; i < bet2; i++) {
						String betM2 = "";
						for (int j = 0; j < betMatrix2[i].length(); j++) {
							char betM = betMatrix2[i].charAt(j);
							if (betMatrix2[i].length() == 1) {
								if (j == 0 && betM == 'L')
									betM2 += betM + "&ndash;&ndash;";
								if (j == 0 && betM == 'E')
									betM2 += "&ndash;" + betM + "&ndash;";
								if (j == 0 && betM == 'V')
									betM2 += "&ndash;&ndash;" + betM;
							} else if (betMatrix2[i].length() == 2) {
								if (j == 0 && betM == 'L')
									betM2 += betM;
								if (j == 0 && betM == 'E')
									betM2 += "&ndash;" + betM;
								if (j == 1 && betM == 'E')
									betM2 += betM + "&ndash;";
								if (j == 1 && betM == 'V')
									if (betM2.equals("L"))
										betM2 += "&ndash;" + betM;
									else if (!betM2.equals("L"))
										betM2 += betM;
							} else if (betMatrix2[i].length() == 3)
								betM2 += betM;
						}
						bm += betM2 + "<br/>";
						cbm += betMatrix2[i].length();
					}
					if (cbm > 14) {
						ArrayList<String[]> fullBets = BussinessSaleDispatcher.getBets(gameNumber, matrix2);
						int i = 0;
						for (String[] c : fullBets) {
							if (i == 0)
								solved += "<tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;<br/>01:<br/>02:<br/>03:<br/>04:<br/>05:<br/>06:<br/>07:<br/>08:<br/>09:<br/>10:<br/>11:<br/>12:<br/>13:<br/>14:</td>"
										+ "<td align='center' style='padding: 0 0 5px 0;'><b>&nbsp;&nbsp;&nbsp;B&nbsp;&nbsp;&nbsp;<br/>"
                                        + bm
                                        + "</b></td><td align='center' style='padding: 0 0 5px 0;'>";
							else if (i % 25 == 0 && c.length > 0)
								solved += "</td></tr><tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;<br/>01:<br/>02:<br/>03:<br/>04:<br/>05:<br/>06:<br/>07:<br/>08:<br/>09:<br/>10:<br/>11:<br/>12:<br/>13:<br/>14:"
										+ "</td><td align='center' style='padding: 0 0 5px 0;'>&nbsp;</td><td align='center' style='padding: 0 0 5px 0;'>";
							if (i >= 0 && i < 9)
								solved += "&nbsp;&nbsp;<u>" + (i + 1) + "</u>&nbsp;&nbsp;<br/>";
							else if (i >= 9 && i < 99)
								solved += "&nbsp;<u>" + (i + 1) + "</u>&nbsp;<br/>";
							else
								solved += "<u>" + (i + 1) + "</u><br/>";
							for (String s : c)
								solved += s + "<br/>";
							if (i == fullBets.size() - 1)
								solved += "</td></tr>";
							else
								solved += "</td><td align='center' style='padding: 0 0 5px 0;'>";
							i++;
						}
						solved += "<tr><td colspan='15'><br/>" + i + " jugadas<br/><br/></td></tr>";
						total += i;
					}
				}
				if (bet3 == 14) {
					String bm = "";
					int cbm = 0;
					for (int i = 0; i < bet3; i++) {
						String betM3 = "";
						for (int j = 0; j < betMatrix3[i].length(); j++) {
							char betM = betMatrix3[i].charAt(j);
							if (betMatrix3[i].length() == 1) {
								if (j == 0 && betM == 'L')
									betM3 += betM + "&ndash;&ndash;";
								if (j == 0 && betM == 'E')
									betM3 += "&ndash;" + betM + "&ndash;";
								if (j == 0 && betM == 'V')
									betM3 += "&ndash;&ndash;" + betM;
							} else if (betMatrix3[i].length() == 2) {
								if (j == 0 && betM == 'L')
									betM3 += betM;
								if (j == 0 && betM == 'E')
									betM3 += "&ndash;" + betM;
								if (j == 1 && betM == 'E')
									betM3 += betM + "&ndash;";
								if (j == 1 && betM == 'V')
									if (betM3.equals("L"))
										betM3 += "&ndash;" + betM;
									else if (!betM3.equals("L"))
										betM3 += betM;
							} else if (betMatrix3[i].length() == 3)
								betM3 += betM;
						}
						bm += betM3 + "<br/>";
						cbm += betMatrix3[i].length();
					}
					if (cbm > 14) {
						ArrayList<String[]> fullBets = BussinessSaleDispatcher.getBets(gameNumber, matrix3);
						int i = 0;
						for (String[] c : fullBets) {
							if (i == 0)
								solved += "<tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;<br/>01:<br/>02:<br/>03:<br/>04:<br/>05:<br/>06:<br/>07:<br/>08:<br/>09:<br/>10:<br/>11:<br/>12:<br/>13:<br/>14:</td>"
										+ "<td align='center' style='padding: 0 0 5px 0;'><b>&nbsp;&nbsp;&nbsp;C&nbsp;&nbsp;&nbsp;<br/>"
                                        + bm
                                        + "</b></td><td align='center' style='padding: 0 0 5px 0;'>";
							else if (i % 25 == 0 && c.length > 0)
								solved += "</td></tr><tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;<br/>01:<br/>02:<br/>03:<br/>04:<br/>05:<br/>06:<br/>07:<br/>08:<br/>09:<br/>10:<br/>11:<br/>12:<br/>13:<br/>14:"
										+ "</td><td align='center' style='padding: 0 0 5px 0;'>&nbsp;</td><td align='center' style='padding: 0 0 5px 0;'>";
							if (i >= 0 && i < 9)
								solved += "&nbsp;&nbsp;<u>" + (i + 1) + "</u>&nbsp;&nbsp;<br/>";
							else if (i >= 9 && i < 99)
								solved += "&nbsp;<u>" + (i + 1) + "</u>&nbsp;<br/>";
							else
								solved += "<u>" + (i + 1) + "</u><br/>";
							for (String s : c)
								solved += s + "<br/>";
							if (i == fullBets.size() - 1)
								solved += "</td></tr>";
							else
								solved += "</td><td align='center' style='padding: 0 0 5px 0;'>";
							i++;
						}
						solved += "<tr><td colspan='15'><br/>" + i + " jugadas<br/><br/></td></tr>";
						total += i;
					}
				}
				if (bet4 == 14) {
					String bm = "";
					int cbm = 0;
					for (int i = 0; i < bet4; i++) {
						String betM4 = "";
						for (int j = 0; j < betMatrix4[i].length(); j++) {
							char betM = betMatrix4[i].charAt(j);
							if (betMatrix4[i].length() == 1) {
								if (j == 0 && betM == 'L')
									betM4 += betM + "&ndash;&ndash;";
								if (j == 0 && betM == 'E')
									betM4 += "&ndash;" + betM + "&ndash;";
								if (j == 0 && betM == 'V')
									betM4 += "&ndash;&ndash;" + betM;
							} else if (betMatrix4[i].length() == 2) {
								if (j == 0 && betM == 'L')
									betM4 += betM;
								if (j == 0 && betM == 'E')
									betM4 += "&ndash;" + betM;
								if (j == 1 && betM == 'E')
									betM4 += betM + "&ndash;";
								if (j == 1 && betM == 'V')
									if (betM4.equals("L"))
										betM4 += "&ndash;" + betM;
									else if (!betM4.equals("L"))
										betM4 += betM;
							} else if (betMatrix4[i].length() == 3)
								betM4 += betM;
						}
						bm += betM4 + "<br/>";
						cbm += betMatrix4[i].length();
					}
					if (cbm > 14) {
						ArrayList<String[]> fullBets = BussinessSaleDispatcher.getBets(gameNumber, matrix4);
						int i = 0;
						for (String[] c : fullBets) {
							if (i == 0)
								solved += "<tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;<br/>01:<br/>02:<br/>03:<br/>04:<br/>05:<br/>06:<br/>07:<br/>08:<br/>09:<br/>10:<br/>11:<br/>12:<br/>13:<br/>14:</td>"
										+ "<td align='center' style='padding: 0 0 5px 0;'><b>&nbsp;&nbsp;&nbsp;D&nbsp;&nbsp;&nbsp;<br/>"
                                        + bm
                                        + "</b></td><td align='center' style='padding: 0 0 5px 0;'>";
							else if (i % 25 == 0 && c.length > 0)
								solved += "</td></tr><tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;<br/>01:<br/>02:<br/>03:<br/>04:<br/>05:<br/>06:<br/>07:<br/>08:<br/>09:<br/>10:<br/>11:<br/>12:<br/>13:<br/>14:"
										+ "</td><td align='center' style='padding: 0 0 5px 0;'>&nbsp;</td><td align='center' style='padding: 0 0 5px 0;'>";
							if (i >= 0 && i < 9)
								solved += "&nbsp;&nbsp;<u>" + (i + 1) + "</u>&nbsp;&nbsp;<br/>";
							else if (i >= 9 && i < 99)
								solved += "&nbsp;<u>" + (i + 1) + "</u>&nbsp;<br/>";
							else
								solved += "<u>" + (i + 1) + "</u><br/>";
							for (String s : c)
								solved += s + "<br/>";
							if (i == fullBets.size() - 1)
								solved += "</td></tr>";
							else
								solved += "</td><td align='center' style='padding: 0 0 5px 0;'>";
							i++;
						}
						solved += "<tr><td colspan='15'><br/>" + i + " jugadas<br/><br/></td></tr>";
						total += i;
					}
				}
				if (total > 0)
                    solved += "<tr><td colspan='15'>Total:&nbsp;" + total + "&nbsp;apuestas generadas de jugadas m&uacute;ltiples.</td></tr>";
			}
			if (gameNumber == Game.SUPER3) {
				fromDraw = fromDraw - game.getGapLotos5(); // 5000
				toDraw = toDraw - game.getGapLotos5(); // 5000
				int bet3exactA = p_clientTicket.getCtBet3exactA();
				int bet3anyA = p_clientTicket.getCtBet3anyA();
				int bet2exactA = p_clientTicket.getCtBet2exactA();
				int bet1exactA = p_clientTicket.getCtBet1exactA();
				int bet3exactB = p_clientTicket.getCtBet3exactB();
				int bet3anyB = p_clientTicket.getCtBet3anyB();
				int bet2exactB = p_clientTicket.getCtBet2exactB();
				int bet1exactB = p_clientTicket.getCtBet1exactB();
				if (bet1 > 0) {
					String bm = "";
					int cnt = 0;
					for (int i = 0; i < bet1; i++)
						bm += "&nbsp;" + betMatrix1[i];
					solved += "<tr><td>A" + StringUtils.leftPad("" + bet1, 2, "0") + ":&nbsp;<b>" + bm
							+ "</b></td></tr><tr><td><table cellpadding='0' cellspacing='2' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>";
					solved += "<tr valign='top'>";
					if (bet3exactA == 1) {
						int cnt3ea = 0;
						solved += "<td style='width:150px; text-align:center;'><u>3 EN ORDEN</u><br/><br/>";
						for (int i = 0; i < bet1; i++) {
							if (i >= 0 && i < 9)
								solved += "<br/>&nbsp;" + (i + 1) + ")&nbsp;" + betMatrix1[i] + "<br/><br/>";
							else
								solved += "<br/>" + (i + 1) + ")&nbsp;" + betMatrix1[i] + "<br/><br/>";
							solved += "&mdash;&mdash;&mdash;&mdash;&mdash;<br/>";
							if (bet1 - 1 == i)
								cnt3ea = i + 1;
						}
						solved += "Total en columna: " + cnt3ea + "<br/><br/></td>";
						cnt += cnt3ea;
					}
					if (bet3anyA == 1) {
						int cnt3aa = 0;
						solved += "<td style='width:150px; text-align:center;'><u>3 EN DESORDEN</u><br/><br/>";
						for (int i = 0; i < bet1; i++) {
							String num = betMatrix1[i];
							String[] cad = Permuta.permuta(num);
							for (int j = 0; j < cad.length; j++) {
								if ((j + 1) % 2 == 0) {
									if (i * 6 + j >= 0 && i * 6 + j < 9)
                                        solved += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + (i * 6 + j + 1) + ")&nbsp;" + cad[j] + "<br/>";
									else if (i * 6 + j >= 9 && i * 6 + j < 99)
                                        solved += "&nbsp;&nbsp;&nbsp;&nbsp;" + (i * 6 + j + 1) + ")&nbsp;" + cad[j] + "<br/>";
									else
										solved += "&nbsp;&nbsp;" + (i * 6 + j + 1) + ")&nbsp;" + cad[j] + "<br/>";
								} else if (i * 6 + j >= 0 && i * 6 + j < 9)
									solved += "&nbsp;&nbsp;&nbsp;" + (i * 6 + j + 1) + ")&nbsp;" + cad[j];
								else if (i * 6 + j >= 9 && i * 6 + j < 99)
									solved += "&nbsp;&nbsp;" + (i * 6 + j + 1) + ")&nbsp;" + cad[j];
								else
									solved += i * 6 + j + 1 + ")&nbsp;" + cad[j];
								if (bet1 - 1 == i)
									cnt3aa = i * 6 + j + 1;
							}
							solved += "&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;<br/>";
						}
						solved += "Total en columna: " + cnt3aa + "<br/><br/></td>";
						cnt += cnt3aa;
					}
					if (bet2exactA == 1) {
						int cnt2ea = 0;
						solved += "<td style='width:150px; text-align:center;'><u>2 EN ORDEN</u><br/><br/>";
						for (int i = 0; i < bet1; i++) {
							String num = betMatrix1[i];
							for (int j = 0; j < num.length(); j++) {
								String cad = "";
								for (int j1 = 0; j1 < num.length(); j1++)
									if (j1 != j)
										cad += num.charAt(j1);
									else
										cad += "*";
								if (i * 3 + j >= 0 && i * 3 + j < 9)
									solved += "&nbsp;" + (i * 3 + j + 1) + ")&nbsp;" + cad + "<br/>";
								else
									solved += i * 3 + j + 1 + ")&nbsp;" + cad + "<br/>";
								if (bet1 - 1 == i)
									cnt2ea = i * 3 + j + 1;
							}
							solved += "&mdash;&mdash;&mdash;&mdash;&mdash;<br/>";
						}
						solved += "Total en columna: " + (cnt2ea * 10 - 2 * bet1) + "<br/><br/></td>";
						cnt += cnt2ea * 10 - 2 * bet1;
					}
					if (bet1exactA == 1) {
						int cnt1ea = 0;
						solved += "<td style='width:150px; text-align:center;'><u>1 EN ORDEN</u><br/><br/>";
						for (int i = 0; i < bet1; i++) {
							String num = betMatrix1[i];
							for (int j = 0; j < num.length(); j++) {
								String cad = "";
								for (int j1 = 0; j1 < num.length(); j1++)
									if (j1 != j)
										cad += "*";
									else
										cad += num.charAt(j1);
								if (i * 3 + j >= 0 && i * 3 + j < 9)
									solved += "&nbsp;" + (i * 3 + j + 1) + ")&nbsp;" + cad + "<br/>";
								else
									solved += i * 3 + j + 1 + ")&nbsp;" + cad + "<br/>";
								if (bet1 - 1 == i)
									cnt1ea = i * 3 + j + 1;
							}
							solved += "&mdash;&mdash;&mdash;&mdash;&mdash;<br/>";
						}
						solved += "Total en columna: " + (cnt1ea * 100 - 20 * bet1) + "<br/><br/></td>";
						cnt += cnt1ea * 100 - 20 * bet1;
					}
					solved += "</tr></table></td></tr><tr><td colspan='3'>" + cnt + " jugadas<br/><br/></td></tr>";
					total += cnt;
				}
				if (bet2 > 0) {
					String bm = "";
					int cnt = 0;
					for (int i = 0; i < bet2; i++)
						bm += "&nbsp;" + betMatrix2[i];
					solved += "<tr><td>B" + StringUtils.leftPad("" + bet2, 2, "0") + ":&nbsp;<b>" + bm
							+ "</b></td></tr><tr><td><table cellpadding='0' cellspacing='2' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>";
					solved += "<tr valign='top'>";
					if (bet3exactB == 1) {
						int cnt3eb = 0;
						solved += "<td style='width:150px; text-align:center;'><u>3 EN ORDEN</u><br/><br/>";
						for (int i = 0; i < bet2; i++) {
							if (i >= 0 && i < 9)
								solved += "<br/>&nbsp;" + (i + 1) + ")&nbsp;" + betMatrix2[i] + "<br/><br/>";
							else
								solved += "<br/>" + (i + 1) + ")&nbsp;" + betMatrix2[i] + "<br/><br/>";
							solved += "&mdash;&mdash;&mdash;&mdash;&mdash;<br/>";
							if (bet2 - 1 == i)
								cnt3eb = i + 1;
						}
						solved += "Total en columna: " + cnt3eb + "<br/><br/></td>";
						cnt += cnt3eb;
					}
					if (bet3anyB == 1) {
						int cnt3ab = 0;
						solved += "<td style='width:150px; text-align:center;'><u>3 EN DESORDEN</u><br/><br/>";
						for (int i = 0; i < bet2; i++) {
							String num = betMatrix2[i];
							String[] cad = Permuta.permuta(num);
							for (int j = 0; j < cad.length; j++) {
								if ((j + 1) % 2 == 0) {
									if (i * 6 + j >= 0 && i * 6 + j < 9)
                                        solved += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + (i * 6 + j + 1) + ")&nbsp;" + cad[j] + "<br/>";
									else if (i * 6 + j >= 9 && i * 6 + j < 99)
                                        solved += "&nbsp;&nbsp;&nbsp;&nbsp;" + (i * 6 + j + 1) + ")&nbsp;" + cad[j] + "<br/>";
									else
										solved += "&nbsp;&nbsp;" + (i * 6 + j + 1) + ")&nbsp;" + cad[j] + "<br/>";
								} else if (i * 6 + j >= 0 && i * 6 + j < 9)
									solved += "&nbsp;&nbsp;&nbsp;&nbsp;" + (i * 6 + j + 1) + ")&nbsp;" + cad[j];
								else if (i * 6 + j >= 9 && i * 6 + j < 99)
									solved += "&nbsp;&nbsp;" + (i * 6 + j + 1) + ")&nbsp;" + cad[j];
								else
									solved += i * 6 + j + 1 + ")&nbsp;" + cad[j];
								if (bet2 - 1 == i)
									cnt3ab = i * 6 + j + 1;
							}
							solved += "&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;<br/>";
						}
						solved += "Total en columna: " + cnt3ab + "<br/><br/></td>";
						cnt += cnt3ab;
					}
					if (bet2exactB == 1) {
						int cnt2eb = 0;
						solved += "<td style='width:150px; text-align:center;'><u>2 EN ORDEN</u><br/><br/>";
						for (int i = 0; i < bet2; i++) {
							String num = betMatrix2[i];
							for (int j = 0; j < num.length(); j++) {
								String cad = "";
								for (int j1 = 0; j1 < num.length(); j1++)
									if (j1 != j)
										cad += num.charAt(j1);
									else
										cad += "*";
								if (i * 3 + j >= 0 && i * 3 + j < 9)
									solved += "&nbsp;" + (i * 3 + j + 1) + ")&nbsp;" + cad + "<br/>";
								else
									solved += i * 3 + j + 1 + ")&nbsp;" + cad + "<br/>";
								if (bet2 - 1 == i)
									cnt2eb = i * 3 + j + 1;
							}
							solved += "&mdash;&mdash;&mdash;&mdash;&mdash;<br/>";
						}
						solved += "Total en columna: " + (cnt2eb * 10 - 2 * bet2) + "<br/><br/></td>";
						cnt += cnt2eb * 10 - 2 * bet2;
					}
					if (bet1exactB == 1) {
						int cnt1eb = 0;
						solved += "<td style='width:150px; text-align:center;'><u>1 EN ORDEN</u><br/><br/>";
						for (int i = 0; i < bet2; i++) {
							String num = betMatrix2[i];
							for (int j = 0; j < num.length(); j++) {
								String cad = "";
								for (int j1 = 0; j1 < num.length(); j1++)
									if (j1 != j)
										cad += "*";
									else
										cad += num.charAt(j1);
								if (i * 3 + j >= 0 && i * 3 + j < 9)
									solved += "&nbsp;" + (i * 3 + j + 1) + ")&nbsp;" + cad + "<br/>";
								else
									solved += i * 3 + j + 1 + ")&nbsp;" + cad + "<br/>";
								if (bet2 - 1 == i)
									cnt1eb = i * 3 + j + 1;
							}
							solved += "&mdash;&mdash;&mdash;&mdash;&mdash;<br/>";
						}
						solved += "Total en columna: " + (cnt1eb * 100 - 20 * bet1) + "<br/><br/></td>";
						cnt += cnt1eb * 100 - 20 * bet1;
					}
					solved += "<tr></table></td></tr><tr><td colspan='3'>" + cnt + " jugadas<br/><br/></td></tr>";
					total += cnt;
				}
				if (total > 0)
                    solved += "<tr><td>Total:&nbsp;"
                            + total
							+ "&nbsp;apuestas generadas de jugadas m&uacute;ltiples.</td></tr><tr><td>(<b style='font-size:14px;'>*</b>)&nbsp;Cualquier n&uacute;mero entre el 0 y el 9</td></tr>";
			}
			DecimalFormat df = new DecimalFormat("###,##0.00");
            String apparea = String.valueOf(ConnectionFactory.operationProperty("applicationArea", context)).toString().trim();
            String testusers = String.valueOf(ConnectionFactory.operationProperty("testUsers", context)).toString().trim();
			if (p_clientTicket.getCtSaleType() != null)
				saleType = p_clientTicket.getCtSaleType();
			else
				saleType = "0";
            //String separateline = "<tr><td colspan='2' align='center' style='font-size:9px;'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>";
			String separateline = "<tr><td colspan='2' align='center' style='font-size:9px;'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>";
			htmlText.append("<html><head><script type='text/javascript'>function oncontextmenuHandler(){return false;}"
					+ "document.oncontextmenu = oncontextmenuHandler;function disableselect(e){return false;}"
					+ "function reEnable(){return true;}document.onselectstart=new Function ('return false');"
					+ "if (window.sidebar){document.onmousedown=disableselect;document.onclick=reEnable;}<\"+\"/script></head><body><center><table width='100%' cellpadding='0' cellspacing='0' style='margin:0; padding:0; border:0;'><tr><td align='center'>");
            //htmlText.append("<table width='292' cellpadding='0' cellspacing='0' style='margin:0; padding:9px; border:black 1px solid; font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>");
            htmlText.append("<table width='327' cellpadding='0' cellspacing='0' style='margin:0; padding:9px; border:black 1px solid; font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>");
            htmlText.append("<tr><td style='font-size:9px;' colspan='2'>Id1&nbsp;: " + clientId + "<br/>Id2&nbsp;: " + ticketId + "</td></tr>");
			/* Quitar logo de Intralot - Inicio - @jmoran 2019-05-28 */
			/*
            htmlText.append("<tr><td colspan='2' align='center'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/client/imgIntralot.gif' width='74' height='22' border='0'/></td></tr>"
                    + "<tr><td colspan='2' align='center' style='font-size:9px;'>RUC&nbsp;&nbsp;20506035121</td></tr>");
			 */
			/* Mostrar logos de sorteos en UAT */
			/*
            htmlText.append("<tr><td colspan='2' align='center'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim() + "/layer-view-image/client/" + imgGame
			 */
			htmlText.append("<tr><td colspan='2' align='center'><img src='"+Constants.eCommerceHome+"layer-view-image/client/" + imgGame 
                    //+ "' width='" + imgW + "' height='" + imgH + "' border='0'/></td></tr>" + "<tr><td align='center' colspan='2'>" + charity + "</td></tr>"
					+ "' width='" + imgW + "' height='" + imgH + "' border='0'/></td></tr>"
					+ "<tr><td style='font-size:9px;' align='center' colspan='2'>" + webAddress + "</td></tr>");
            htmlText.append("<tr><td colspan='2' align='center' style='font-size:9px;'>La Tinka S.A.&nbsp;&nbsp;RUC&nbsp;&nbsp;20506035121</td></tr>"); // cambio de posicion RUC
			/* Quitar logo de La Tinka - Fin - @jmoran 2019-05-28 */
			if (apparea.equals("development"))
                htmlText.append("<tr><td style='font-size:16px;font-weight:bold;' align='center' colspan='2'>BOLETO DE PRUEBAS</td></tr>");
			else if (apparea.equals("production"))
				if (testusers != null && !testusers.equals("")) {
					String[] users = testusers.split(",");
					for (String user : users)
						if (user.equals(clientId)) {
                            htmlText.append("<tr><td style='font-size:16px;font-weight:bold;' align='center' colspan='2'>BOLETO SIN VALOR</td></tr>");
							break;
						}
				}
			if (saleType.equals("9"))
                htmlText.append("<tr><td style='font-size:16px;font-weight:bold;' align='center' colspan='2'>TICKET CAMBIO</td></tr>");
            htmlText.append("<tr><td align='center' colspan='2'>" + ticketDate.substring(0, 10) + "&nbsp;&nbsp;&nbsp;&nbsp;&minus;&nbsp;&nbsp;&nbsp;&nbsp;"
            		 + ticketDate.substring(11) + "</td></tr>"
                     + "<tr><td align='center' colspan='2'>" + charity + "</td></tr>" // @jmoran 2019-05-29
					+ "<tr><td>AGENCIA:&nbsp;" + trmId.substring(0, 6) + "-0001 "
                    + (char) (Integer.parseInt(trmId.substring(6)) + 64) + "</td>" + "<td align='right'>TRN:&nbsp;" + StringUtils.leftPad(trnsNum, 10, "0") + "&nbsp;"
                    + "</td></tr>" + "<tr><td>" + gameName + "&nbsp;(" + StringUtils.leftPad("" + gameNumber, 3, "0") + ")&nbsp;"
                    + receiptNr + "</td><td align='right'>PERIODO:&nbsp;" + fromDrawDay + "</td></tr>");
			// if(!typeid.equals("") && !numberid.equals(""))
            // htmlText.append("<tr><td></td><td align='right'>"+typeid+":&nbsp;"+numberid+"</td></tr>");
			htmlText.append(separateline);
			if (gameNumber == Game.GANAGOL) {
                htmlText.append("<tr><td colspan='2'><font style='font-size:14px;font-weight:bold;'>GRUPO:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;B&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;C&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;D</font></td></tr>"
								+ separateline
								+ "<tr><td colspan='2'><table width='100%' cellpadding='0' cellspacing='0' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif; border-collapse:collapse;'><tr><td width='20%' align='center'>"
                        + "01:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>02:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>03:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>04:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font>"
                        + "<br/>05:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>06:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>07:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>08:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font>"
                        + "<br/>09:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>10:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>11:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>12:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>13:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>14:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font></td>");
				if (!bm1.equals(""))
                    htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>" + bm1 + "</font></td>");
				else
                    htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*</font></td>");
				if (!bm2.equals(""))
                    htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>" + bm2 + "</font></td>");
				else
                    htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*</font></td>");
				if (!bm3.equals(""))
                    htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>" + bm3 + "</font></td>");
				else
                    htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*</font></td>");
				if (!bm4.equals(""))
					htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>" + bm4 + "</font></td>");
				else
					htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*</font></td>");
				
				htmlText.append("</tr></table></td></tr>" + separateline);
				htmlText.append(
						"<tr><td colspan='2'><font style='font-size:14px;font-weight:bold;'>GOLAZO 200&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td></tr>"
								+ "<tr><td colspan='2'><table width='40%' cellpadding='0' cellspacing='0' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif; border-collapse:collapse;'><tr><td width='20%' align='center'>"
								+ "A:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font>"
								+ "<br/>B:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font>"
								+ "<br/>C:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font>"
								+ "<br/>D:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font>" + "</td>");
				if (!addOn1.equals(""))
					htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>"
							+ addOn1 + "</font><br>");
				else
					htmlText.append(
							"<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>*</font><br>");
				if (!addOn2.equals(""))
					htmlText.append("<font style='font-size:14px;font-weight:bold;'>" + addOn2 + "</font><br>");
				else
					htmlText.append("<font style='font-size:14px;font-weight:bold;'>*</font><br>");
				if (!addOn3.equals(""))
					htmlText.append("<font style='font-size:14px;font-weight:bold;'>" + addOn3 + "</font><br>");
				else
					htmlText.append("<font style='font-size:14px;font-weight:bold;'>*</font><br>");
				if (!addOn4.equals(""))
					htmlText.append("<font style='font-size:14px;font-weight:bold;'>" + addOn4 + "</font></td>");
				else
					htmlText.append("<font style='font-size:14px;font-weight:bold;'>*</font></td>");

				htmlText.append("</tr></table></td></tr>");

			} else if (gameNumber == Game.SUPER3) {
				if (!bm1.equals(""))
                    htmlText.append("<tr><td colspan='2' style='color:#FFFFFF; background-color:#000000;'><font style='font-size:10px;font-weight:bold;'>A:&nbsp;"
                            + (bet3ExactA == 1 && bet3AnyA == 0 ? "&nbsp;3&nbsp;EN&nbsp;ORDEN" : "") + (bet3ExactA == 0 && bet3AnyA == 1 ? "3&nbsp;DESORDEN" : "")
									+ (bet3ExactA == 1 && bet3AnyA == 1 ? "&nbsp;3&nbsp;EN&nbsp;ORDEN/DESORDEN" : "")
                            + ((bet3ExactA == 1 || bet3AnyA == 1) && bet2ExactA == 1 ? "-" : "") + (bet2ExactA == 1 ? "&nbsp;2&nbsp;EN&nbsp;ORDEN" : "")
                            + ((bet3ExactA == 1 || bet3AnyA == 1 || bet2ExactA == 1) && bet1ExactA == 1 ? "-" : "") + (bet1ExactA == 1 ? "&nbsp;1&nbsp;EN&nbsp;ORDEN" : "")
                            + "</font></td></tr><tr><td colspan='2'>A:&nbsp;&nbsp;&nbsp;" + bm1 + "</td></tr>" + "<tr><td colspan='2'>MULT:&nbsp;&nbsp;&nbsp;"
									+ StringUtils.leftPad("" + betMultiA, 2, "0") + "</td></tr>");
				if (!bm2.equals(""))
                    htmlText.append("<tr><td colspan='2' style='color:#FFFFFF; background-color:#000000'><font style='font-size:10px;font-weight:bold;'>B:&nbsp;"
                            + (bet3ExactB == 1 && bet3AnyB == 0 ? "3EN ORDEN" : "") + (bet3ExactB == 0 && bet3AnyB == 1 ? "3DESORDEN" : "")
                            + (bet3ExactB == 1 && bet3AnyB == 1 ? "3EN ORDEN/DESORDEN" : "") + ((bet3ExactB == 1 || bet3AnyB == 1) && bet2ExactB == 1 ? "-" : "")
                            + (bet2ExactB == 1 ? "2EN ORDEN" : "") + ((bet3ExactB == 1 || bet3AnyB == 1 || bet2ExactB == 1) && bet1ExactB == 1 ? "-" : "")
                            + (bet1ExactB == 1 ? "1EN ORDEN" : "") + "</font></td></tr><tr><td colspan='2'>B:&nbsp;&nbsp;&nbsp;" + bm2 + "</td></tr>"
                            + "<tr><td colspan='2'>MULT:&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad("" + betMultiB, 2, "0") + "</td></tr>");
			} else if (gameNumber == Game.MEGATINKA) {
				if (!bm1.equals(""))
                    htmlText.append("<tr><td colspan='2'>TKA:&nbsp;&nbsp;&nbsp;<font style='font-size:14px;font-weight:bold;'>" + bm1 + "</font></td></tr>");
				if (!mbm1.equals(""))
                    htmlText.append("<tr><td colspan='2'>MTA:&nbsp;&nbsp;&nbsp;<font style='font-size:14px;font-weight:bold;'>" + mbm1 + "</font></td></tr>");
				if (!bm2.equals(""))
                    htmlText.append("<tr><td colspan='2'>TKB:&nbsp;&nbsp;&nbsp;<font style='font-size:14px;font-weight:bold;'>" + bm2 + "</font></td></tr>");
				if (!mbm2.equals(""))
                    htmlText.append("<tr><td colspan='2'>MTB:&nbsp;&nbsp;&nbsp;<font style='font-size:14px;font-weight:bold;'>" + mbm2 + "</font></td></tr>");
				if (!bm3.equals(""))
                    htmlText.append("<tr><td colspan='2'>TKC:&nbsp;&nbsp;&nbsp;<font style='font-size:14px;font-weight:bold;'>" + bm3 + "</font></td></tr>");
				if (!mbm3.equals(""))
                    htmlText.append("<tr><td colspan='2'>MTC:&nbsp;&nbsp;&nbsp;<font style='font-size:14px;font-weight:bold;'>" + mbm3 + "</font></td></tr>");
				if (!bm4.equals(""))
                    htmlText.append("<tr><td colspan='2'>TKD:&nbsp;&nbsp;&nbsp;<font style='font-size:14px;font-weight:bold;'>" + bm4 + "</font></td></tr>");
				if (!mbm4.equals(""))
                    htmlText.append("<tr><td colspan='2'>MTD:&nbsp;&nbsp;&nbsp;<font style='font-size:14px;font-weight:bold;'>" + mbm4 + "</font></td></tr>");
			} else {
				if (!bm1.equals(""))
                    htmlText.append("<tr><td colspan='2'>A" + StringUtils.leftPad("" + bet1, 2, "0") + ":&nbsp;&nbsp;&nbsp;<font style='font-size:14px;font-weight:bold;'>"
                            + bm1 + "</font></td></tr>");
				if (!bm2.equals(""))
                    htmlText.append("<tr><td colspan='2'>B" + StringUtils.leftPad("" + bet2, 2, "0") + ":&nbsp;&nbsp;&nbsp;<font style='font-size:14px;font-weight:bold;'>"
                            + bm2 + "</font></td></tr>");
				if (!bm3.equals(""))
                    htmlText.append("<tr><td colspan='2'>C" + StringUtils.leftPad("" + bet3, 2, "0") + ":&nbsp;&nbsp;&nbsp;<font style='font-size:14px;font-weight:bold;'>"
                            + bm3 + "</font></td></tr>");
				if (!bm4.equals(""))
                    htmlText.append("<tr><td colspan='2'>D" + StringUtils.leftPad("" + bet4, 2, "0") + ":&nbsp;&nbsp;&nbsp;<font style='font-size:14px;font-weight:bold;'>"
                            + bm4 + "</font></td></tr>");
			}
            htmlText.append(separateline + "<tr><td style='font-size:14px;font-weight:bold;' align='center' colspan='2'>COL:&nbsp;&nbsp;"
					+ StringUtils.leftPad("" + numColumns, 2, "0") + "</td></tr>" + separateline);
			if (gameNumber != Game.GANAGOL)
                htmlText.append("<tr><td style='font-size:14px;' align='center' colspan='2'>BOLETO&nbsp;VALIDO&nbsp;PARA&nbsp;"
                        + StringUtils.leftPad("" + (toDraw - fromDraw + 1), 2, "0") + "&nbsp;SORTEO(S)</td></tr>");
            htmlText.append("<tr><td style='font-size:13px;font-weight:bold;' align='center' colspan='2'>DESDE&nbsp;" + StringUtils.leftPad("" + fromDraw, 4, "0")
                    + "&nbsp;DEL&nbsp;" + fromDrawDay + "&nbsp;HASTA&nbsp;" + StringUtils.leftPad("" + toDraw, 4, "0") + "</td></tr>" + separateline);
			if (saleType.equals("0")) {
                htmlText.append("<tr><td style='font-size:14px;font-weight:bold;'>TOTAL&nbsp;&nbsp;&nbsp;S/.</td><td style='font-size:14px;font-weight:bold;' align='right'>"
								+ df.format(receiptAmount) + "</td></tr>" + separateline);
				if (receiptDiscounted != 0.0) {
                    htmlText.append("<tr><td style='font-size:14px;font-weight:bold;' align='center' colspan='2'>+GANO DESCUENTO&nbsp;&nbsp;S/." + df.format(receiptDiscounted)
                            + "</td></tr>");
				}
                if(bet1ExactA!=0) htmlText.append("<tr><td style='font-size:14px;font-weight:bold;' align='center' colspan='2'>BOLETO DE SUSCRIPCI&Oacute;N " + bet1ExactA + " DE " + bet2ExactA + "</td></tr>");
                if(bet3ExactA!=0) htmlText.append("<tr><td style='font-size:14px;font-weight:bold;' align='center' colspan='2'>SUSCRIPCI&Oacute;N HASTA SORTEO " + bet3ExactA + "</td></tr>");
                if(receiptDiscounted != 0.0 || bet3ExactA!=0) htmlText.append(separateline);
			} else if (saleType.equals("1"))
                htmlText.append("<tr><td style='font-size:14px;font-weight:bold;'>TOTAL&nbsp;&nbsp;&nbsp;S/.</td><td style='font-size:14px;font-weight:bold;' align='right'>"
								+ df.format(receiptAmount) + "</td></tr>" + separateline
                        + "<tr><td style='font-size:14px;font-weight:bold;' align='center' colspan='2'>TICKET GRATIS</td></tr>" + separateline);
			else if (saleType.equals("2"))
                htmlText.append("<tr><td style='font-size:14px;font-weight:bold;'>TOTAL&nbsp;&nbsp;&nbsp;S/.</td><td style='font-size:14px;font-weight:bold;' align='right'>"
								+ df.format(receiptAmount) + "</td></tr>" + separateline
                        + "<tr><td style='font-size:14px;font-weight:bold;' align='center' colspan='2'>TICKET REGULAR</td></tr>" + separateline);
                        //+ "<tr><td style='font-size:14px;font-weight:bold;' align='center' colspan='2'>PROMOCION 2X1</td></tr>" + separateline);
			else if (saleType.equals("9"))
                htmlText.append("<tr><td style='font-size:14px;font-weight:bold;'>TOTAL&nbsp;&nbsp;&nbsp;S/.</td><td style='font-size:14px;font-weight:bold;' align='right'>0.00</td></tr>"
								+ separateline);
			// if(Integer.parseInt(p_clientTicket.getCtTwPrizeFlag()) == 1 &&
			// Integer.parseInt(p_clientTicket.getCtTwDefinePrize()) == 2 &&
			// Integer.parseInt(p_clientTicket.getCtPrizeFlag()) == 0)
			LoggerApi.Log.info("valor ---------->  " + p_clientTicket.getCtTwDefinePrize());
            if (p_clientTicket.getCtTwDefinePrize() != null && Integer.parseInt(p_clientTicket.getCtTwDefinePrize()) == 2)
                htmlText.append("<tr><td align='center' colspan='2' style='font-size:12px;'>" + tn.trim() + " " + crc_v + "</td></tr><tr><td align='center' colspan='2'>"
                        + barcode + "</td></tr>");
			/*
			 * else htmlText.append(
			 * "<tr><td align='center' style='font-size:9px; padding:10px 0 10px 0;'>Si su boleto obtiene premio y decide cobrarlo en efectivo, deber&aacute; reimprimir el boleto en donde figura el c&oacute;digo de barras y mostrarlo a la promotora en un punto de venta para cobrar su premio en efectivo.</td></tr>"
			 * );
			 */
            // htmlText.append("<tr><td align='center' colspan='2' style='font-size:12px;'>"+tn.trim()+"</td></tr><tr><td align='center' colspan='2'>"+barcode+"</td></tr>");
            htmlText.append("<tr><td align='center' colspan='2' style='font-size:12px;'></td></tr><tr><td align='center' colspan='2'>&nbsp;</td></tr></table>");
			// if(bp == 1) {
            //htmlText.append("</table><br /><div style='width:293px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'><strong>Atenci&oacute;n:</strong> Los premios est&aacute;n sujetos a los impuestos y retenciones de Ley (10%), excepto los premios menores o iguales a S/. 20.00. Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el boleto impreso con el c&oacute;digo de barras. No compartas esta informaci&oacute;n, ni la dejes a la vista de otros. ");
			if (consecutive > 0 && (toDraw - fromDraw) > 0) {
            	htmlText.append("<br /><div style='width:293px; font-size:13.5px; font-family:Verdana, Arial, Helvetica, sans-serif;'> Sorteo Consecutivo Nº"+((1+1+toDraw-fromDraw)-(consecutive))+" de "+(1+toDraw-fromDraw)+".</div>");
			}
            //<strong>Atenci&oacute;n:</strong> Los premios est&aacute;n sujetos a los impuestos y retenciones de Ley (10%), excepto los premios menores o iguales a S/. 20.00. Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el boleto impreso con el c&oacute;digo de barras. No compartas esta informaci&oacute;n, ni la dejes a la vista de otros. 
            htmlText.append("<br /><div style='width:328px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'>");
            // htmlText.append("</table><div style='width:696px;'>&nbsp;</div><br /><div style='width:293px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'><strong>Atenci&oacute;n:</strong> Para tu seguridad el c&oacute;digo de barras se mostrar&aacute; en caso tu boleto este premiado y hayas elegido la opci&oacute;n de cobrar tu premio en el Punto de Venta. ");
            if (gameNumber == Game.TINKA || gameNumber == Game.MEGATINKA || gameNumber == Game.GANADIARIO || gameNumber == Game.KABALA) {
                // htmlText.append("Los premios est&aacute;n sujetos a los impuestos y retenciones de Ley (10%), excepto los premios menores o iguales a S/. 20.00. Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el boleto impreso con el c&oacute;digo de barras. No compartas esta informaci&oacute;n, ni la dejes a la vista de otros.");
			} else if (gameNumber == Game.SUPER3) {
                // htmlText.append("Los premios est&aacute;n sujetos a los impuestos y retenciones de Ley (10%), excepto el premio m&iacute;nimo de 2 soles, que no ser&aacute;n afectados por dicho impuesto para el cliente, y que Intralot pagar&aacute; el impuesto. Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el boleto impreso con el c&oacute;digo de barras. No compartas esta informaci&oacute;n, ni la dejes a la vista de otros.");
			} else if (gameNumber == Game.GANAGOL) {
                // htmlText.append("Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el ticket impreso con el c&oacute;digo de barras. No comparta esta informaci&oacute;n, ni la deje a la vista de otros.");
			}
			htmlText.append("</div>");
			if (!solved.equals(""))
				/*
				 * htmlText.append(
				 * "<div style='width:696px;'>&nbsp;</div><div style='width:696px;'>&nbsp;</div><table width='696' cellpadding='1' cellspacing='0' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif; border-collapse:collapse;' id='tblSolved'>"
				 * + solved + "</table>");
				 */
                htmlText.append("<br /><br /><table width='696' cellpadding='1' cellspacing='0' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif; border-collapse:collapse;' id='tblSolved'>"
								+ solved + "</table>");
			htmlText.append("</td></tr></table></center></body></html>");
			return htmlText;
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
		}
	}

	@Override
    public StringBuffer findCouponClientTicketTeApuesto(TicketProcedureGetClientTicket p_clientTicket, int tip_coupon) throws Exception {
        LoggerApi.Log.info("p_clientTicket=" + p_clientTicket + " tip_coupon=" + tip_coupon);
        StringBuffer htmlText = new StringBuffer();
      //String context = "CARD-WEB";
        String context = Constants.contextCardWeb;
        try {
            DecimalFormat df = new DecimalFormat("###,##0.00");
            // String[] betMatrix1 = null;
            // String[] betMatrix2 = null;
            // int bet1 = 0;
            // int bet2 = 0;
            // String matrix1 = "";
            // String matrix2 = "";
            String ticketId = "";
            String clientId = "";
            // int crc = 0;
            String trnsNum = "0";
            int fromDraw = 0;
            String fromDrawDay = "";
            int gameNumber = 0;
            int columns = 0;
            // int numColumns = 0;
            Double receiptAmount = 0.0;
            Double receiptDiscounted = 0.0;
            int receiptNr = 0;
            String ticketDate = "";
            String ticketNumber = "";
            // int toDraw = 0;
            double maxAmountWinner = 0;
            // String trmId = "";
            String terminal = "";
            String agency = "";
            String gameName = "";
            String eventItems = "";
            String saleType = "0";
            String imgGame = null;
            String imgW = null;
            String imgH = null;
            // String charity = null;
            // String webAddress = null;
            String bm1 = "";
            // String bm2 = "";
            int multiplier = 0;
            String combined = "";
            String ticketCode = "";
            /*
             * if (p_clientTicket.getCtBetMatrix1() != null) matrix1 = p_clientTicket.getCtBetMatrix1();
             */
            /*
             * if (p_clientTicket.getCtBetMatrix2() != null) matrix2 = p_clientTicket.getCtBetMatrix2();
             */
            /*
             * if (matrix1 != null && !matrix1.equals("")) betMatrix1 = matrix1.split("x");
             */
            /*
             * if (matrix2 != null && !matrix2.equals("")) betMatrix2 = matrix2.split(" ");
             */
            if (p_clientTicket.getCtTicketId() != null)
                ticketId = p_clientTicket.getCtTicketId();
            if (p_clientTicket.getCtClientId() != null)
                clientId = p_clientTicket.getCtClientId();
            /*
             * if (p_clientTicket.getCtCrc() != null) crc = p_clientTicket.getCtCrc();
             */
            if (p_clientTicket.getCtTrnsNum() != null)
                trnsNum = p_clientTicket.getCtTrnsNum();
            if (p_clientTicket.getCtFromDraw() != null)
                fromDraw = p_clientTicket.getCtFromDraw();
            if (p_clientTicket.getFromDrawDay() != null)
                fromDrawDay = p_clientTicket.getFromDrawDay();
            if (p_clientTicket.getCtGameNumber() != 0)
                gameNumber = p_clientTicket.getCtGameNumber();
            if (p_clientTicket.getCtNumColumns() != null)
                columns = p_clientTicket.getCtNumColumns();
            if (p_clientTicket.getCtReceiptAmount() != null)
                receiptAmount = p_clientTicket.getCtReceiptAmount();
            if (p_clientTicket.getCtReceiptDiscounted() != null)
                receiptDiscounted = p_clientTicket.getCtReceiptDiscounted();
            if (p_clientTicket.getCtReceiptNr() != null)
                receiptNr = p_clientTicket.getCtReceiptNr();
            if (p_clientTicket.getCtTicketDate() != null)
                ticketDate = p_clientTicket.getCtTicketDate();
            /*
             * if (p_clientTicket.getCtTicketNumber() != null) ticketNumber = StringLib.decodeLabel(p_clientTicket.getCtTicketNumber());
             */
            /*
             * if (p_clientTicket.getCtToDraw() != null) toDraw = p_clientTicket.getCtToDraw();
             */
            /*
             * if (p_clientTicket.getCtTrmId() != null) trmId = p_clientTicket.getCtTrmId();
             */
            if (p_clientTicket.getCtMultiplier() != null)
                multiplier = p_clientTicket.getCtMultiplier();
            /*
             * if (p_clientTicket.getCtCombined() != null) multiplier = p_clientTicket.getCtCombined();
             */
            if (p_clientTicket.getCtMaxAmountWinner() != null)
                maxAmountWinner = p_clientTicket.getCtMaxAmountWinner();
            if (p_clientTicket.getCtTerminalNr() != null)
                terminal = p_clientTicket.getCtTerminalNr();
            if (p_clientTicket.getCtAgencyCd() != null)
                agency = p_clientTicket.getCtAgencyCd();
            if (p_clientTicket.getCtEventItems() != null)
                eventItems = p_clientTicket.getCtEventItems();
            if (p_clientTicket.getCtSaleType() != null)
                saleType = p_clientTicket.getCtSaleType();
            /***** aqui */
            String crc_v = "";
            if (p_clientTicket.getCtTicketNumber() != null) {
                ticketCode = StringLib.decodeLabel(p_clientTicket.getCtTicketNumber());      
                crc_v = TestFunc.getCrc_v5(ticketCode);
            }
            LoggerApi.Log.info("ticketCode=" + StringLib.cover(ticketCode));
            /*****/
            String barCode = ClientUtils.Interleaved2of5(ticketCode, null);
            String numColumns = StringUtils.leftPad("" + columns, 9, "0");
            String[] cti = eventItems.split("____");
            Game game = new Game(gameNumber);
            gameName = game.getName();
            /*
             * String tn = ""; for(int i=0; i<ticketNumber.length(); i++){ if((i+1)%5 == 0) tn += ticketNumber.charAt(i)+" "; else tn += ""+ticketNumber.charAt(i); } String barcode =
             * ClientUtils.Interleaved2of5(ticketNumber,6);
             */
            String apparea = String.valueOf(ConnectionFactory.operationProperty("applicationArea", context)).toString().trim().toLowerCase();
            String testusers = String.valueOf(ConnectionFactory.operationProperty("testUsers", context)).toString().trim();
            // StringBuffer htmlText = new StringBuffer();
            // DecimalFormat df = new DecimalFormat("###,##0.00");
            // String ticketId = clientTicket.getTicketId();
            // String clientId = clientTicket.getClientId();
            // String trnsNum = "0";
            // if(clientTicket.getTrnsNum() != null) trnsNum =
            // clientTicket.getTrnsNum();
            // int fromDraw = clientTicket.getFromDraw();
            // int toDraw = clientTicket.getToDraw();
            // int columns = clientTicket.getNumColumns();
            // String numColumns = StringUtils.leftPad(""+columns,9,"0");
            // Double receiptAmount = clientTicket.getReceiptAmount();
            // String receiptNr =
            // StringUtils.leftPad(""+clientTicket.getReceiptNr(),9,"0");
            // String ticketDate = clientTicket.getTicketDate();
            // String fromDrawDate = clientTicket.getFromDrawDate();
            // String ticketNumber = clientTicket.getTicketNumber();
            // String imgGame = null;
            // String imgW = null;
            // String imgH = null;
            // String terminal = clientTicket.getTerminalNr();
            // String agency =
            // StringUtils.leftPad(clientTicket.getAgencyCd(),7,"0");
            // double maxAmountWinner = clientTicket.getMaxAmountWinner();
            // TicketWinner ticketWinner = clientTicket.getTicketWinner();
            // int prizeFlag = 0;
            // int defineFlag = 0;
            // int payFlag = 0;
            // if(clientTicket.getPrizeFlag() != null) prizeFlag =
            // Integer.parseInt(clientTicket.getPrizeFlag());
            // if(ticketWinner.getDefinePrizeFlag() != null) defineFlag =
            // Integer.parseInt(ticketWinner.getDefinePrizeFlag());
            // if(ticketWinner.getPrizeFlag() != null) payFlag =
            // Integer.parseInt(ticketWinner.getPrizeFlag());
            // String bet1 = "";
            // String bet2 = "";
            // String multiplicador1 = null;
            // String multiplicador2 = null;
            // int lengthMatrix1 = 0;
            // int lengthMatrix2 = 0;
            // String lengthMatrix1Str = null;
            // String lengthMatrix2Str = null;
            // String[] betMatrix1 = null;
            // String[] betMatrix2 = null;
            // String matrix1 = clientTicket.getBetMatrix1();
            // String matrix2 = clientTicket.getBetMatrix2();
            // if(!matrix1.equals("")) betMatrix1 = matrix1.split("x");
            // if(!matrix2.equals("")) betMatrix2 = matrix2.split("x");
            /*
             * if(betMatrix1 != null){ //multiplicador1 = "&nbsp;&nbsp;" + betMatrix1[1]; lengthMatrix1 = betMatrix1[0].split(" ").length; //lengthMatrix1Str =
             * StringUtils.leftPad(""+lengthMatrix1,2,"0"); betMatrix1 = betMatrix1[0].split(" "); for(int i = 0; i < lengthMatrix1; i++){ bm1 = bet1 + "&nbsp;&nbsp;" +
             * StringUtils.leftPad(betMatrix1[i],2,"0"); } }
             */
            /*
             * if(betMatrix2 != null){ multiplicador2 = "&nbsp;&nbsp;" + betMatrix2[1]; lengthMatrix2 = betMatrix2[0].split(" ").length; lengthMatrix2Str = StringUtils.leftPad(""+lengthMatrix2,2,"0");
             * betMatrix2 = betMatrix2[0].split(" "); for(int i = 0; i < lengthMatrix2; i++){ bet2 = bet2 + "&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix2[i],2,"0"); } }
             */
            // String bm1 = "";
            /*
             * String tn = ""; for(int i=0; i<ticketNumber.length(); i++){ if((i+1)%5 == 0) tn += ticketNumber.charAt(i)+" "; else tn += ticketNumber.charAt(i); } String barcode = ticketNumber;
             */
            /**** Aqui ****/
            String tn = "";
            for (int i = 0; i < ticketNumber.length(); i++)
                if ((i + 1) % 5 == 0)
                    tn += ticketNumber.charAt(i) + " ";
                else
                    tn += ticketNumber.charAt(i);
            String barcode = ClientUtils.Interleaved2of5(ticketNumber, null);
            /***********/
            //imgGame = "imgTeapuesto.jpg";            
            imgGame = "imgTeapuestoSl.png";
            imgW = "195";
            imgH = "99";
            for (String element : cti) {
                String[] event = element.split("__");
                // LoggerApi.Log.info("cti="+cti[i]);
                String eventId = event[0];// StringUtils.leftPad(cti[i].getEventId(),3,"0");
                String description = event[1];// "";
                if (description.length() > 26)
                    description = description.substring(0, 22);
                String subdescription = event[2];// cti[i].getSubDescription();
                // if(cti[i].getDescription() != null) description =
                // cti[i].getDescription();
                String closeDate = event[3];// cti[i].getCloseDate();
                String closeHour = StringUtils.leftPad(event[4], 2, "0");// StringUtils.leftPad(""+cti[i].getCloseHour(),2,"0");
                String closeMinute = StringUtils.leftPad(event[5], 2, "0");// StringUtils.leftPad(""+cti[i].getCloseMinute(),2,"0");
                // if(cti[i].getApueTxt() != null) apueTxt =
                // cti[i].getApueTxt();
                // String bet = event[6];//cti[i].getBet();
                String apueTxt = event[7];// "";
                if (apueTxt.length() > 20)
                    apueTxt = apueTxt.substring(0, 16);
                String factor = event[8];// df.format(cti[i].getFactor());
                String hndTxt = event[9];// cti[i].getHndTxt();
                // int minimum = 0;
                // if(!event[10].equals("") && NumberUtils.isNumber(event[10]))
                // minimum = Integer.parseInt(event[10]);//cti[i].getMinimun();
                // LoggerApi.Log.info("eventId="+eventId+" description="+description+" subdescription="+subdescription+" closeDate="+closeDate+" closeHour="+closeHour+" closeMinute="+closeMinute+" bet="+bet+" apueTxt="+apueTxt+" factor="+factor+" hndTxt="+hndTxt+" minimum="+minimum);
                if (saleType.equals("1") || saleType.equals("3"))
                    bm1 += "<div style='float:left; width:197px; padding:3px 0 0 0;'>" + eventId + "&nbsp;&nbsp;" + description
                            + "</div><div style='float:left; width:75px; padding:3px 0 0 0;'>" + closeDate + "&nbsp;" + closeHour + ":" + closeMinute + "</div>"
                            + "<div style='float:left; width:88px; padding:3px 0 0 25px;'>APUE:" + apueTxt
                            + "</div><div style='float:left; width:79px; padding:3px 0 0 0;'>PROB:" + factor
                            + "</div><div style='float:left; width:80px; padding:3px 0 0 0;'>HND:" + hndTxt + "</div>";
                else if (saleType.equals("2"))
                    bm1 += "<div style='float:left; width:197px; padding:3px 0 0 0;'>" + eventId + "&nbsp;&nbsp;" + description
                            + "</div><div style='float:left; width:75px; padding:3px 0 0 0;'>" + closeDate + "&nbsp;" + closeHour + ":" + closeMinute + "</div>"
                            + "<div style='float:left; width:247px; padding:3px 0 0 25px;'>" + subdescription + "</div>"
                            + "<div style='float:left; width:167px; padding:3px 0 0 25px;'>APUE:&nbsp;" + apueTxt
                            + "</div><div style='float:left; width:80px; padding:3px 0 0 0;'>PROB:&nbsp;" + factor + "</div>";
            }
            // LoggerApi.Log.info("min1="+min1+" min2="+min2+" min3="+min3);
            /*
             * if(bet1 > 0 && combined != null && !combined.equals("")) { ArrayList<String[]> fullBets = Combina.getBets(combined, elements); int i = 0; for(String[] c : fullBets) { if(i == 0) solved
             * += "<tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;" +ord+"</td>" + "<td align='left' style='padding: 0 0 5px 0;'><b>Predic."
             * +bm+"</b></td><td align='right' style='padding: 0 0 5px 0;'><b>Prob." + fac+"</b></td><td align='center' style='padding: 0 0 5px 0;'><b>Min."
             * +min+"</b></td><td align='center' style='padding: 0 0 5px 0;'>"; else { if(bp == 1) { if((i%20) == 0 && c.length > 0) solved +=
             * "</td></tr><tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;" +ord+"</td>" +
             * "<td align='center' style='padding: 0 0 5px 0;'>&nbsp;</td><td align='center' style='padding: 0 0 5px 0;'>&nbsp;</td><td align='center' style='padding: 0 0 5px 0;'>&nbsp;</td><td align='center' style='padding: 0 0 5px 0;'>"
             * ; } else if (bp == 0) { if((i%8) == 0 && c.length > 0) solved += "</td></tr><tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;" +ord+"</td>" +
             * "<td align='center' style='padding: 0 0 5px 0;'>&nbsp;</td><td align='center' style='padding: 0 0 5px 0;'>&nbsp;</td><td align='center' style='padding: 0 0 5px 0;'>&nbsp;</td><td align='center' style='padding: 0 0 5px 0;'>"
             * ; } } if(i >= 0 && i < 9) solved += "&nbsp;&nbsp;<u>"+(i+1)+"</u>&nbsp;&nbsp;<br/>"; else if(i >= 9 && i < 99) solved += "&nbsp;<u>"+(i+1)+"</u>&nbsp;<br/>"; else solved +=
             * "<u>"+(i+1)+"</u><br/>"; int k = 0; double mulFactor = 1; for(int j=0; j<bet1; j++) { if(k < c.length) { String[] a = c[k].split(" "); if(Integer.parseInt(a[0].trim()) == (j+1)) {
             * solved += a[1].trim()+"<br/>"; mulFactor *= Double.parseDouble(a[2].trim()); k++; } else solved += "&nbsp;<br/>"; } else solved += "&nbsp;<br/>"; } if(i == (fullBets.size()-1)) solved
             * += df.format(mulFactor)+"</td></tr>"; else solved += df.format(mulFactor)+ "</td><td align='center' style='padding: 0 0 5px 0;'>"; total += mulFactor; i++; } solved
             * +="<tr><td colspan='15'><br/>"+i+" jugadas<br/><br/></td></tr>"; } if(total > 0.0 && total <= 50000.0) solved += "<tr><td colspan='15'>Total de probabilidades:&nbsp;" +df.format(total
             * )+"&nbsp;puntos generados de jugadas combinadas.</td></tr>";
             */
            // }
            // boolean isMobile =
            // Boolean.valueOf(ConnectionFactory.operationProperty("mobileEnabled",Constants.contextSale).trim()).booleanValue();
            // String separateline =
            // "<tr><td align='center'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>";
            //String separateline = "<tr><td align='center' style='font-size:9px;'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>";
            String separateline = "<tr><td align='center' style='font-size:9px;'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>";
            htmlText.append("<html><head><script type='text/javascript'>function oncontextmenuHandler(){return false;}"
                    + "document.oncontextmenu = oncontextmenuHandler;function disableselect(e){return false;}"
                    + "function reEnable(){return true;}document.onselectstart=new Function ('return false');"
                    + "if (window.sidebar){document.onmousedown=disableselect;document.onclick=reEnable;}<\"+\"/script></head><body><center><table width='100%' cellpadding='0' cellspacing='0' style='margin:0; padding:0; border:0;'><tr><td align='center'>");
            // "<center><table width='348' cellpadding='4' cellspacing='4' style='border:black 1px solid;'>"+
            // if(bp == 1)
            //htmlText.append("<table width='292' cellpadding='0' cellspacing='0' style='margin:0; padding:9px; border:black 1px solid; font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>");
            htmlText.append("<table width='327' cellpadding='0' cellspacing='0' style='margin:0; padding:9px; border:black 1px solid; font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>");
            // else if(bp == 0)
            // htmlText.append("<table width='272' cellpadding='0' cellspacing='0' style='margin:0; padding:0; border:0; border-collapse:collapse; font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>");
            // "<tr><td align='center' style='padding:3px 0 0 0;'><table cellpadding='0' cellspacing='0' style='font-size:11px; font-family:Verdana, Arial, Helvetica, sans-serif; border-collapse:collapse;'>"
            // +
            // if(!numberid.equals(""))
            // htmlText.append("<tr><td style='font-size:9px;' colspan='2'>Id1&nbsp;: "+clientId+"&nbsp;&nbsp;&nbsp;&nbsp;Id2&nbsp;: "+numberid+"&nbsp;&nbsp;&nbsp;&nbsp;Id3&nbsp;: "+ticketId+"<br/><br/></td></tr>");
            // else
            htmlText.append("<tr><td style='font-size:9px;' colspan='2'>Id1&nbsp;: " + clientId + "<br/>Id2&nbsp;: " + ticketId + "</td></tr>");
            // "<tr><td style='font-size:9px;' style='padding:3px 0 0 0;'>Id1&nbsp;: "+clientId+"<br/>Id2&nbsp;: "+ticketId+"</td></tr>"
            // +
            // if(bp == 1) {
            htmlText.append("<tr><td align='center' style='padding:3px 0 0 0;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/client/imgIntralot.gif' width='74' height='22' border='0'/></td></tr>"
                    + "<tr><td align='center' style='font-size:9px; padding:3px 0 0 0;'>RUC&nbsp;&nbsp;20506035121</td></tr>");
            /*
             * } else if(bp == 0) { htmlText.append("<tr><td align='center' style='padding:3px 0 0 0;'>" +clComName+"</td></tr>" +
             * "<tr><td align='center' style='font-size:9px; padding:3px 0 0 0;'>RUC&nbsp;&nbsp;" +clComNumber+"</td></tr>"); }
             */
            htmlText.append("<tr><td align='center' style='padding:3px 0 0 0;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim() + "/layer-view-image/client/" + imgGame + "'"
                    + "' width='" + imgW + "' height='" + imgH + "' border='0'/>"
                    + "<img style='top:-15px;position:relative' src='" + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim() + "/layer-view-image/client/imgTinka.gif'"
                    + "' width='146' height='36' border='0'/>"
                    + "</td></tr>");
            if (apparea.equals("development"))
                htmlText.append("<tr><td style='font-size:16px; font-weight:bold;' align='center'>BOLETO DE PRUEBAS</td></tr>");
            else if (apparea.equals("production"))
                if (testusers != null && !testusers.equals("")) {
                    String[] users = testusers.split(",");
                    for (String user : users)
                        // if(users[i].equals(clientId) ||
                        // users[i].equals(numberid)) {
                        if (user.equals(clientId)) {
                            htmlText.append("<tr><td style='font-size:16px;font-weight:bold;' align='center' colspan='2'>BOLETO SIN VALOR</td></tr>");
                            break;
                        }
                }
            htmlText.append("<tr><td align='center' style='padding:3px 0 0 0;'>" + gameName + "(4" + gameNumber + ")&nbsp;&nbsp;FECHA:" + fromDrawDay + "&nbsp;&nbsp;PROG("
                    + fromDraw + ")</td></tr>" + "<tr><td align='center' style='padding:3px 0 0 0;'>AGENTE:" + agency + "&minus;" + terminal
                    + "&nbsp;&nbsp;01&nbsp;&nbsp;TRN:" + StringUtils.leftPad(trnsNum, 10, "0") + "</td></tr>" + "<tr><td align='center' style='padding:3px 0 0 0;'>CPN:"
                    + receiptNr + "&nbsp;&nbsp;COL:" + numColumns + "&nbsp;&nbsp;" + ticketDate.substring(0, 8) + "&minus;" + ticketDate.substring(9) + "</td></tr>"
                    + separateline);
            if (!bm1.equals(""))
                htmlText.append("<tr><td style='padding:2px 0 2px 0;'>" + bm1 + "</td></tr>");
            htmlText.append(separateline);
            if (combined != null)
                htmlText.append("<tr><td style='font-weight:bold; padding:2px 0 2px 0;'>COMBINADAS&nbsp;&nbsp;&nbsp;&nbsp;" + combined + "</td></tr>");
            htmlText.append("<tr><td style='font-weight:bold; padding:2px 0 2px 0;'>MULTIPLICADOR&nbsp;" + multiplier + "&nbsp;&nbsp;&nbsp;TOTAL COLUMNAS&nbsp;" + columns
                    + "</td></tr>" + separateline);
            // if(gameNumber == Game.TEAPUESTO) {
            htmlText.append("<tr><td style='font-size:16px;font-weight:bold; padding:2px 0 2px 0;'><div style='float:left; width:162px;'>TOTAL</div><div style='float:left; text-align: right; width:108px;'>S/. "
                    + df.format(receiptAmount)
                    + "</div></td></tr>"
                    + "<tr><td style='font-weight:bold; padding:2px 0 2px 0;'><div style='float:left; width:162px;'>MONTO MAXIMO GANADOR:</div><div style='float:left; text-align: right; width:108px;'>S/. "
                    + df.format(maxAmountWinner) + "<div></td></tr>" + separateline);
            if (receiptDiscounted != 0.0)
                htmlText.append("<tr><td style='font-size:14px;font-weight:bold; padding:3px 0 0 0;' align='center'>+GANO DESCUENTO&nbsp;&nbsp;"
                        + df.format(receiptDiscounted) + "</td></tr>" + separateline);
            /*
             * } else { if(saleType.equals("0")) { htmlText.append(
             * "<tr><td style='font-size:16px;font-weight:bold; padding:2px 0 2px 0;'><div style='float:left; width:242px;'>TOTAL</div><div style='float:left; text-align: right; width:92px;'>S/. "
             * +df.format(receiptAmount)+"<div></td></tr>" +
             * "<tr><td style='font-weight:bold; padding:2px 0 2px 0;'><div style='float:left; width:242px;'>MONTO MAXIMO GANADOR:</div><div style='float:left; text-align: right; width:92px;'>S/. "
             * +df.format(maxAmountWinner)+"<div></td></tr>" +
             * "<tr><td align='center'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>"
             * ); if(receiptDiscounted != 0.0) { htmlText.append( "<tr><td style='font-size:14px;font-weight:bold; padding:3px 0 0 0;' align='center'>+GANO DESCUENTO&nbsp;&nbsp;"
             * +df.format(receiptDiscounted)+"</td></tr>" +
             * "<tr><td align='center'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>"
             * ); } } else if(saleType.equals("1")) { htmlText.append(
             * "<tr><td style='font-size:14px;font-weight:bold; padding:3px 0 0 0;'><div style='display:inline; width:245px; padding:3px 0 0 0;'>TOTAL</div><div style='display:inline; text-align: right; width:92px; padding:3px 0 0 0;'>S/. TICKET GRATIS<div></td></tr>"
             * +
             * "<tr><td align='center'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>"
             * + "<tr><td style='font-size:14px;font-weight:bold; padding:3px 0 0 0;' align='center'>TICKET GRATIS</td></tr>" +
             * "<tr><td align='center'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>"
             * ); } else if(saleType.equals("2")) { htmlText.append(
             * "<tr><td style='font-size:14px;font-weight:bold; padding:3px 0 0 0;'><div style='display:inline; width:245px; padding:3px 0 0 0;'>TOTAL</div><div style='display:inline; text-align: right; width:92px; padding:3px 0 0 0;'>S/. "
             * +df.format(receiptAmount)+"<div></td></tr>" +
             * "<tr><td align='center'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>"
             * + "<tr><td style='font-size:14px;font-weight:bold; padding:3px 0 0 0;' align='center'>PROMOCION 2X1</td></tr>" +
             * "<tr><td align='center'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>"
             * ); } else if(saleType.equals("9")) { htmlText.append(
             * "<tr><td style='font-size:14px;font-weight:bold; padding:3px 0 0 0;'><div style='display:inline; width:245px; padding:3px 0 0 0;'>TOTAL</div><div style='display:inline; text-align: right; width:92px; padding:3px 0 0 0;'>S/. 0.00<div></td></tr>"
             * +
             * "<tr><td align='center'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>"
             * ); } }
             */
            if (tip_coupon == 1)
                if (p_clientTicket.getCtTwDefinePrize() != null && Integer.parseInt(p_clientTicket.getCtTwDefinePrize()) == 2)
                    htmlText.append("<tr><td align='center' colspan='2' style='font-size:12px;'>" + ticketCode.substring(0, 5) + " " + ticketCode.substring(5, 10) + " "
                            + ticketCode.substring(10, 15) + " " + ticketCode.substring(15, 20) + "&nbsp;" + ticketCode.substring(20, 25) + "&nbsp;"
                            + ticketCode.substring(25, 30) + " " + crc_v + " &nbsp;&nbsp;&nbsp;&nbsp;" + barCode + "</td></tr>");
            // htmlText.append("<tr><td align='center' style='font-size:13px; padding:3px 0 0 0;'>"+tn.trim()+"</td></tr><tr><td align='center'>"+barcode+"</td></tr><tr><td>&nbsp;</td></tr></table></td></tr></table>");
            // LoggerApi.Log.info(prizeFlag+" "+defineFlag+" "+payFlag+" "+cashDate);
            // if(bp == 0 || (bp == 1 && prizeFlag == 1 && defineFlag == 2 &&
            // payFlag == 0))
            // htmlText.append("<tr><td align='center' style='font-size:13px; padding:3px 0 0 0;'>"+tn.trim()+"</td></tr><tr><td align='center'>"+barcode+"</td></tr>");
            // else
            // htmlText.append("<tr><td align='center' style='font-size:9px; padding:10px 0 10px 0;'>Si su boleto obtiene premio y decide cobrarlo en efectivo, deber&aacute; reimprimir el boleto en donde figura el c&oacute;digo de barras y mostrarlo a la promotora en un punto de venta para cobrar su premio en efectivo.</td></tr>");
            // else
            // htmlText.append("<tr><td>&nbsp;</td></tr><tr><td>&nbsp;</td></tr><tr><td>&nbsp;</td></tr>");
            // if(bp == 1) {
            /*
             * htmlText.append(
             * "<div style='width:696px;'>&nbsp;</div><div style='width:350px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'><strong>Atenci&oacute;n:</strong> Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el ticket impreso con el c&oacute;digo de barras. "
             * + "No comparta esta informaci&oacute;n, ni la deje a la vista de otros.</div>" );
             */
            /*
             * } else if(bp == 0) { htmlText.append(
             * "<div style='width:302px;'>&nbsp;</div><div style='width:290px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify; margin: 0 0 0 12px;'><strong>Atenci&oacute;n:</strong> Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el ticket impreso con el c&oacute;digo de barras. "
             * + "No comparta esta informaci&oacute;n, ni la deje a la vista de otros.</div>" ); if(!solved.equals("")) htmlText.append(
             * "<div style='width:302px;'>&nbsp;</div><div style='width:302px;'>&nbsp;</div><table width='302' cellpadding='0' cellspacing='0' style='font-size:10px; font-family:Verdana, Arial, Helvetica, sans-serif; border-collapse:collapse; margin:0 0 0 5px;' id='tblSolved'>"
             * +solved+"</table>"); }
             */
            // htmlText.append("<tr><td>&nbsp;</td></tr>");
            // if(bp == 1) {
            // htmlText.append("</table><div style='width:696px;'>&nbsp;</div><div style='width:293px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'>");
            //htmlText.append("</table><br /><div style='width:293px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'>");
            htmlText.append("</table><br /><div style='width:328px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'>");
            if (tip_coupon == 1)
                if (p_clientTicket.getCtTwDefinePrize() != null && Integer.parseInt(p_clientTicket.getCtTwDefinePrize()) == 2)
                    htmlText.append("<div style='width:267px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify; margin: 0 0 0 5px;'></div>");
            // if(prizeFlag == 1 && defineFlag == 2 && payFlag == 0)
            // htmlText.append("<strong>Atenci&oacute;n:</strong> Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el ticket impreso con el c&oacute;digo de barras. No comparta esta informaci&oacute;n, ni la deje a la vista de otros.</div>");
            // else
            htmlText.append("</div>");
            // else
            // htmlText.append("Si su boleto obtiene premio y decide cobrarlo en efectivo, deber&aacute; reimprimir el boleto en donde figura el c&oacute;digo de barras y mostrarlo a la promotora en un punto de venta para cobrar su premio en efectivo.</div>");
            // if(!solved.equals(""))
            // htmlText.append("<div style='width:696px;'>&nbsp;</div><div style='width:696px;'>&nbsp;</div><table width='696' cellpadding='1' cellspacing='0' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif; border-collapse:collapse;' id='tblSolved'>"+solved+"</table>");
            /*
             * } else if(bp == 0) { if(isMobile) htmlText.append( "<tr><td align='center' colspan='2'><canvas id='qrcanv' /></td></tr>" ); htmlText.append(
             * "</table><div style='width:267px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify; margin: 0 0 0 5px;'><strong>Atenci&oacute;n:</strong>" +
             * "Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el ticket impreso con el c&oacute;digo de barras. No comparta esta informaci&oacute;n, ni la deje a la vista de otros.</div>"
             * ); if(!solved.equals("")) htmlText.append(
             * "<div style='width:272px;'>&nbsp;</div><div style='width:272px;'>&nbsp;</div><table width='267' cellpadding='0' cellspacing='0' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif; border-collapse:collapse;' margin:0 0 0 5px; id='tblSolved'>"
             * +solved+"</table>"); }
             */
            htmlText.append("</td></tr></table></center></body></html>");
            return htmlText;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        }
    }

    @Override
    public StringBuffer findCouponClientTicketFechaza(TicketProcedureGetClientTicket p_clientTicket, int tip_coupon) throws Exception {
        LoggerApi.Log.info("p_clientTicket=" + p_clientTicket + " tip_coupon=" + tip_coupon);
        StringBuffer htmlText = new StringBuffer();
      //String context = "CARD-WEB";
        String context = Constants.contextCardWeb;
        try {
            DecimalFormat df = new DecimalFormat("###,##0.00");
            String[] betMatrix1 = null;
            // String[] betMatrix2 = null;
            // int bet1 = 0;
            // int bet2 = 0;
            String matrix1 = "";
            // String matrix2 = "";
            String ticketId = "";
            String clientId = "";
            // int crc = 0;
            String trnsNum = "0";
            int fromDraw = 0;
            String fromDrawDay = "";
            // int gameNumber = 0;
            int numColumns = 0;
            Double receiptAmount = 0.0;
            int receiptNr = 0;
            String ticketDate = "";
            /*** aqui ***/
            String ticketNumber = "";
            /***/
            int toDraw = 0;
            double maxAmountWinner = 0;
            // String trmId = "";
            String terminal = "";
            String agency = "";
            // String gameName = "";
            String imgGame = null;
            String imgW = null;
            String imgH = null;
            String charity = null;
            String webAddress = null;
            String bm1 = "";
            // String bm2 = "";
            int multiplier = 0;
            if (p_clientTicket.getCtBetMatrix1() != null)
                matrix1 = p_clientTicket.getCtBetMatrix1();
            LoggerApi.Log.info("matrix1:  " + matrix1);
            /*
             * if (p_clientTicket.getCtBetMatrix2() != null) matrix2 = p_clientTicket.getCtBetMatrix2();
             */
            if (matrix1 != null && !matrix1.equals(""))
                betMatrix1 = matrix1.split(":");
            /*
             * if (matrix2 != null && !matrix2.equals("")) betMatrix2 = matrix2.split(" ");
             */
            if (p_clientTicket.getCtTicketId() != null)
                ticketId = p_clientTicket.getCtTicketId();
            if (p_clientTicket.getCtClientId() != null)
                clientId = p_clientTicket.getCtClientId();
            /*
             * if (p_clientTicket.getCtCrc() != null) crc = p_clientTicket.getCtCrc();
             */
            if (p_clientTicket.getCtTrnsNum() != null)
                trnsNum = p_clientTicket.getCtTrnsNum();
            if (p_clientTicket.getCtFromDraw() != null)
                fromDraw = p_clientTicket.getCtFromDraw();
            if (p_clientTicket.getFromDrawDay() != null)
                fromDrawDay = p_clientTicket.getFromDrawDay();
            /*
             * if (p_clientTicket.getCtGameNumber() != 0) gameNumber = p_clientTicket.getCtGameNumber();
             */
            if (p_clientTicket.getCtNumColumns() != null)
                numColumns = p_clientTicket.getCtNumColumns();
            if (p_clientTicket.getCtReceiptAmount() != null)
                receiptAmount = p_clientTicket.getCtReceiptAmount();
            if (p_clientTicket.getCtReceiptNr() != null)
                receiptNr = p_clientTicket.getCtReceiptNr();
            if (p_clientTicket.getCtTicketDate() != null)
                ticketDate = p_clientTicket.getCtTicketDate();
            /** Aqui **/
            if (p_clientTicket.getCtTicketNumber() != null)
                ticketNumber = StringLib.decodeLabel(p_clientTicket.getCtTicketNumber());
            /*****/
            if (p_clientTicket.getCtToDraw() != null)
                toDraw = p_clientTicket.getCtToDraw();
            /*
             * if (p_clientTicket.getCtTrmId() != null) trmId = p_clientTicket.getCtTrmId();
             */
            if (p_clientTicket.getCtBetMultiA() != null)
                multiplier = p_clientTicket.getCtBetMultiA();
            if (p_clientTicket.getCtMaxAmountWinner() != null)
                maxAmountWinner = p_clientTicket.getCtMaxAmountWinner();
            if (p_clientTicket.getCtTerminalNr() != null)
                terminal = p_clientTicket.getCtTerminalNr();
            if (p_clientTicket.getCtAgencyCd() != null)
                agency = p_clientTicket.getCtAgencyCd();
            // Game game = new Game(gameNumber);
            // gameName = game.getName();
            /**** Angel ***/
            String tn = "";
            for (int i = 0; i < ticketNumber.length(); i++)
                if ((i + 1) % 5 == 0)
                    tn += ticketNumber.charAt(i) + " ";
                else
                    tn += "" + ticketNumber.charAt(i);
            String barcode = ClientUtils.Interleaved2of5(ticketNumber, 6);

			String crc_v = TestFunc.getCrc_v5(ticketNumber);
			
            /**************/
            String apparea = String.valueOf(ConnectionFactory.operationProperty("applicationArea", context)).toString().trim().toLowerCase();
            String testusers = String.valueOf(ConnectionFactory.operationProperty("testUsers", context)).toString().trim();
            if (betMatrix1 != null && betMatrix1.length > 0) {
                // bet1 = betMatrix1.length;
                // for(int i=0; i<bet1; i++) {
                // String matrix1txt = betMatrix1[i].trim();
                // String datemda =
                // (matrix1txt.substring(0,matrix1txt.indexOf(":"))).trim();
                String datemda = betMatrix1[0].trim();
                LoggerApi.Log.info("datemda:  " + datemda);
                String datetxt = betMatrix1[1].trim();// null;
                LoggerApi.Log.info("datetxt:  " + datetxt);
                if (datetxt.indexOf("x") > 0)
                    datetxt = datetxt.substring(0, datetxt.indexOf("x")).trim();
                String[] arrdatetxt = datetxt.split("/");
                LoggerApi.Log.info("datetxt:  " + datetxt);
                if (datemda.equals("DMA"))
                    bm1 += "1.&nbsp;TIPO:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>DD/MM/AA</strong>&nbsp;&nbsp;&nbsp;--/--&nbsp;&nbsp;&nbsp;--&nbsp;--&nbsp;--<br/>&nbsp;&nbsp;&nbsp;&nbsp;D&Iacute;A&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>"
                            + arrdatetxt[0]
                            + "</strong><br/>&nbsp;&nbsp;&nbsp;&nbsp;MES&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>"
                            + arrdatetxt[1]
                            + "</strong><br/>&nbsp;&nbsp;&nbsp;&nbsp;A&Ntilde;O&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>"
                            + arrdatetxt[2]
                            + "</strong><br/>&nbsp;&nbsp;&nbsp;&nbsp;Multiplicador&nbsp;&nbsp;:&nbsp;&nbsp;<strong>" + multiplier + "</strong>";
                else if (datemda.equals("DM"))
                    bm1 += "1.&nbsp;TIPO:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--/--/--&nbsp;&nbsp;&nbsp;<strong>DD/MM</strong>&nbsp;&nbsp;&nbsp;--&nbsp;--&nbsp;--<br/>&nbsp;&nbsp;&nbsp;&nbsp;D&Iacute;A&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>"
                            + arrdatetxt[0]
                            + "</strong><br/>&nbsp;&nbsp;&nbsp;&nbsp;MES&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>"
                            + arrdatetxt[1]
                            + "</strong><br/>&nbsp;&nbsp;&nbsp;&nbsp;A&Ntilde;O&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--<br/>&nbsp;&nbsp;&nbsp;&nbsp;Multiplicador&nbsp;&nbsp;:&nbsp;&nbsp;<strong>"
                            + multiplier + "</strong>";
                else if (datemda.equals("D"))
                    bm1 += "1.&nbsp;TIPO:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--/--/--&nbsp;&nbsp;&nbsp;--/--&nbsp;&nbsp;&nbsp;<strong>DD</strong>&nbsp;--&nbsp;--<br/>&nbsp;&nbsp;&nbsp;&nbsp;D&Iacute;A&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>"
                            + arrdatetxt[0]
                            + "</strong><br/>&nbsp;&nbsp;&nbsp;&nbsp;MES&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--<br/>&nbsp;&nbsp;&nbsp;&nbsp;A&Ntilde;O&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--<br/>&nbsp;&nbsp;&nbsp;&nbsp;Multiplicador&nbsp;&nbsp;:&nbsp;&nbsp;<strong>"
                            + multiplier + "</strong>";
                else if (datemda.equals("M"))
                    bm1 += "1.&nbsp;TIPO:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--/--/--&nbsp;&nbsp;&nbsp;--/--&nbsp;&nbsp;&nbsp;--&nbsp;<strong>MM</strong>&nbsp;--<br/>&nbsp;&nbsp;&nbsp;&nbsp;D&Iacute;A&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--<br/>&nbsp;&nbsp;&nbsp;&nbsp;MES&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>"
                            + arrdatetxt[0]
                            + "</strong><br/>&nbsp;&nbsp;&nbsp;&nbsp;A&Ntilde;O&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--<br/>&nbsp;&nbsp;&nbsp;&nbsp;Multiplicador&nbsp;&nbsp;:&nbsp;&nbsp;<strong>"
                            + multiplier + "</strong>";
                else if (datemda.equals("A"))
                    bm1 += "1.&nbsp;TIPO:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--/--/--&nbsp;&nbsp;&nbsp;--/--&nbsp;&nbsp;&nbsp;--&nbsp;--&nbsp;<strong>AA</strong><br/>&nbsp;&nbsp;&nbsp;&nbsp;D&Iacute;A&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--<br/>&nbsp;&nbsp;&nbsp;&nbsp;MES&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--<br/>&nbsp;&nbsp;&nbsp;&nbsp;A&Ntilde;O&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>"
                            + arrdatetxt[0] + "</strong><br/>&nbsp;&nbsp;&nbsp;&nbsp;Multiplicador&nbsp;&nbsp;:&nbsp;&nbsp;<strong>" + multiplier + "</strong>";
            }
            /*
             * if(betMatrix2 != null && betMatrix2.length > 0){ bet2 = betMatrix2.length; for(int i=0; i<bet2; i++) { String matrix2txt = betMatrix2[i].trim(); String datemda =
             * matrix2txt.substring(0,matrix2txt.indexOf(" ")); String datetxt = matrix2txt.substring(matrix2txt.indexOf(" ")+1); if(datemda.equals("DMA")) { bm2 +=
             * "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+datetxt+"<br/>"; } else if(datemda.equals("DM")) { bm2 += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+datetxt+"/&ndash;&ndash;<br/>"; } else
             * if(datemda.equals("D")) { bm2 += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +datetxt+"/&ndash;&ndash;/&ndash;&ndash;<br/>"; } else if(datemda.equals("M")) { bm2 +=
             * "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&ndash;&ndash;/" +datetxt+"/&ndash;&ndash;<br/>"; } else if(datemda.equals("A")) { bm2 += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&ndash;&ndash;/&ndash;&ndash;/"
             * +datetxt+"<br/>"; } } }
             */
            // if(gameNumber == Game.FECHAZA) {
            imgGame = "imgFechaza.gif";
            imgW = "150";
            imgH = "110";
            charity = "LA TINKA S.A.";
            webAddress = "www.fechaza.com.pe";
            // }
            //String separateline = "<tr><td colspan='2' align='center' style='font-size:9px;'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>";
            String separateline = "<tr><td colspan='2' align='center' style='font-size:9px;'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>";
            htmlText.append("<html><head><script type='text/javascript'>function oncontextmenuHandler(){return false;}"
                    + "document.oncontextmenu = oncontextmenuHandler;function disableselect(e){return false;}"
                    + "function reEnable(){return true;}document.onselectstart=new Function ('return false');"
                    + "if (window.sidebar){document.onmousedown=disableselect;document.onclick=reEnable;}<\"+\"/script></head><body>");
            htmlText.append("<center><table width='100%' cellpadding='0' cellspacing='0' style='margin:0; padding:0; border:0;'>"
            		+ "<tr><td align='center'><table width='327' cellpadding='0' cellspacing='0' style='margin:0; padding:9px; border:black 1px solid; font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>");
                    //+ "<tr><td align='center'><table width='292' cellpadding='0' cellspacing='0' style='margin:0; padding:9px; border:black 1px solid; font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>");
            htmlText.append("<tr><td style='font-size:9px;' colspan='2'>Id1&nbsp;: " + clientId + "<br/>Id2&nbsp;: " + ticketId + "</td></tr>"
                    + "<tr><td align='center' colspan='2'><img src='" + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/client/imgIntralot.gif' width='74' height='22' border='0'/></td></tr>"
                    + "<tr><td style='font-size:9px;' align='center' colspan='2'>R&nbsp;U&nbsp;C&nbsp;&nbsp;20506035121</td></tr>"
                    + "<tr><td align='center' colspan='2'><img src='" + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/client/" + imgGame + "'" + "' width='" + imgW + "' height='" + imgH + "' border='0'/></td></tr>"
                    + "<tr><td align='center' colspan='2'>" + charity + "</td></tr>" + "<tr><td style='font-size:9px;' align='center' colspan='2'>" + webAddress
                    + "</td></tr>");
            if (apparea.equals("development"))
                htmlText.append("<tr><td style='font-size:16px;font-weight:bold;' align='center' colspan='2'>BOLETO DE PRUEBAS</td></tr>");
            else if (apparea.equals("production"))
                if (testusers != null && !testusers.equals("")) {
                    String[] users = testusers.split(",");
                    for (String user : users)
                        if (user.equals(clientId)) {
                            htmlText.append("<tr><td style='font-size:16px;font-weight:bold;' align='center' colspan='2'>BOLETO SIN VALOR</td></tr>");
                            break;
                        }
                }
            // htmlText.append("<tr><td align='center' colspan='2'>"+ticketDate.substring(0,10)+"&nbsp;&nbsp;&nbsp;&nbsp;&minus;&nbsp;&nbsp;&nbsp;&nbsp;"+ticketDate.substring(11)+"</td></tr>"
            // +
            htmlText.append("<tr><td align='center' colspan='2'>AGENTE:" + StringUtils.leftPad(agency, 7, "0") + "&minus;" + terminal + "&nbsp;&nbsp;01&nbsp;&nbsp;TRN:"
                    + StringUtils.leftPad(trnsNum, 10, "0") + "</td></tr>" + "<tr><td align='center' colspan='2'>CPN:" + StringUtils.leftPad(receiptNr + "", 9, "0")
                    + "&nbsp;&nbsp;COL:" + StringUtils.leftPad(numColumns + "", 9, "0") + "&nbsp;&nbsp;" + fromDrawDay + "</td></tr>"
                    + "<tr><td align='center' colspan='2'>Primer Sorteo&nbsp;&nbsp;:&nbsp;&nbsp;" + ticketDate.substring(0, 10) + "&nbsp;&nbsp;"
                    + ticketDate.substring(11, 16) + "</td></tr>" + "<tr><td align='center' colspan='2'>RECIBO VALIDO PARA " + (toDraw - fromDraw + 1)
                    + " SORTEO(S)</td></tr>" + "<tr><td align='center' colspan='2'>DEL SORTEO " + fromDraw + " HASTA " + toDraw + "</td></tr>");
            htmlText.append(separateline);
            if (!bm1.equals(""))
                htmlText.append("<tr><td valign='top' style='line-height:14px;'>" + bm1 + "</td>");
            // if(!bm2.equals(""))
            // htmlText.append("<td valign='top' style='line-height:14px; text-align:center;'>B:&nbsp;<u>DD/MM/AA</u><br/><font style='font-weight:bold;'>"+bm2+"</font></td></tr>");
            htmlText.append(separateline);
            // htmlText.append(separateline+"<tr><td style='font-size:14px;font-weight:bold;' align='center' colspan='2'>COL:&nbsp;&nbsp;"+StringUtils.leftPad((""+numColumns),2,"0")+"</td></tr>"+separateline);
            // htmlText.append("<tr><td style='font-size:13px;font-weight:bold;' align='center' colspan='2'>DESDE&nbsp;"+StringUtils.leftPad((""+fromDraw),4,"0")+"&nbsp;DEL&nbsp;"+fromDrawDay+"&nbsp;HASTA&nbsp;"+StringUtils.leftPad((""+toDraw),4,"0")+"</td></tr>"+separateline);
            htmlText.append("<tr><td style='font-size:14px;font-weight:bold;'>TOTAL:</td><td style='font-size:14px;font-weight:bold;' align='right'>S/. "
                    + df.format(receiptAmount) + "</td></tr>");
            htmlText.append("<tr><td>GANA HASTA:</td><td align='right'>S/. " + df.format(maxAmountWinner) + "</td></tr>" + separateline);
            /*** Aqui **/
            if (tip_coupon == 1)
                if (p_clientTicket.getCtTwDefinePrize() != null && Integer.parseInt(p_clientTicket.getCtTwDefinePrize()) == 2)
                    htmlText.append("<tr><td align='center' colspan='2' style='font-size:12px;'>" + tn.trim() + " "+ crc_v+ "</td></tr><tr><td align='center' colspan='2'>" + barcode + "</td></tr>");
            //htmlText.append("</table><br /><div style='width:293px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'><strong>Atenci&oacute;n:</strong> "
            htmlText.append("</table><br /><div style='width:328px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'>"
                    
                    /*
                     * "Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el ticket impreso con el c&oacute;digo de barras. " +
                     * "No comparta esta informaci&oacute;n, ni la deje a la vista de otros.<br>" +
                     * "El derecho al cobro de los premios caduca a los ciento ochenta(180) d&iacute;as calendarion de la fecha de finalizaci&oacute;n de la venta de este juego, la cual ser&aacute; publicada por INTRALOT DE PER&Uacute; S.A., en un diario de circulaci&oacute;n nacional. "
                     * + "Puede cobrar el premio a partir del <strong>d&iacute;a siguiente</strong> a la compra del boleto." +
                     */
                    
                    + "</div>");
            htmlText.append("</div>");
            htmlText.append("</td></tr></table></center></body></html>");
            return htmlText;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        }
    }

    @Override
    public StringBuffer findCouponClientTicketKinelo(TicketProcedureGetClientTicket p_clientTicket, int tip_coupon) throws Exception {
        LoggerApi.Log.info("p_clientTicket=" + p_clientTicket + " tip_coupon=" + tip_coupon);
        StringBuffer htmlText = new StringBuffer();
      //String context = "CARD-WEB";
        String context = Constants.contextCardWeb;
        try {
            DecimalFormat df = new DecimalFormat("###,##0.00");
            String[] betMatrix1 = null;
            String[] betMatrix2 = null;
            int bet1 = 0;
            int bet2 = 0;
            String matrix1 = "";
            String matrix2 = "";
            String ticketId = "";
            String clientId = "";
            // int crc = 0;
            String trnsNum = "0";
            int fromDraw = 0;
            String fromDrawDay = "";
            // int gameNumber = 0;
            int numColumns = 0;
            Double receiptAmount = 0.0;
            int receiptNr = 0;
            String ticketDate = "";
            /*** Aqui ***/
            String ticketNumber = "";
            /**********/
            int toDraw = 0;
            double maxAmountWinner = 0;
            // String trmId = "";
            String terminal = "";
            String agency = "";
            // String gameName = "";
            String imgGame = null;
            String imgW = null;
            String imgH = null;
            // String charity = null;
            // String webAddress = null;
            String bm1 = "";
            String bm2 = "";
            // int multiplier = 0;
            if (p_clientTicket.getCtBetMatrix1() != null)
                matrix1 = p_clientTicket.getCtBetMatrix1();
            
            if (p_clientTicket.getCtBetMatrix2() != null) 
            	matrix2 = p_clientTicket.getCtBetMatrix2();
             
            if (matrix1 != null && !matrix1.equals(""))
                betMatrix1 = matrix1.split("x");
            
             if (matrix2 != null && !matrix2.equals("")) 
            	 betMatrix2 = matrix2.split("x");
             
            if (p_clientTicket.getCtTicketId() != null)
                ticketId = p_clientTicket.getCtTicketId();
            if (p_clientTicket.getCtClientId() != null)
                clientId = p_clientTicket.getCtClientId();
            /*
             * if (p_clientTicket.getCtCrc() != null) crc = p_clientTicket.getCtCrc();
             */
            if (p_clientTicket.getCtTrnsNum() != null)
                trnsNum = p_clientTicket.getCtTrnsNum();
            if (p_clientTicket.getCtFromDraw() != null)
                fromDraw = p_clientTicket.getCtFromDraw();
            if (p_clientTicket.getFromDrawDay() != null)
                fromDrawDay = p_clientTicket.getFromDrawDay();
            /*
             * if (p_clientTicket.getCtGameNumber() != 0) gameNumber = p_clientTicket.getCtGameNumber();
             */
            if (p_clientTicket.getCtNumColumns() != null)
                numColumns = p_clientTicket.getCtNumColumns();
            if (p_clientTicket.getCtReceiptAmount() != null)
                receiptAmount = p_clientTicket.getCtReceiptAmount();
            if (p_clientTicket.getCtReceiptNr() != null)
                receiptNr = p_clientTicket.getCtReceiptNr();
            if (p_clientTicket.getCtTicketDate() != null)
                ticketDate = p_clientTicket.getCtTicketDate();
            /**** Aqui ******/
            if (p_clientTicket.getCtTicketNumber() != null)
                ticketNumber = StringLib.decodeLabel(p_clientTicket.getCtTicketNumber());
            /***************/
            if (p_clientTicket.getCtToDraw() != null)
                toDraw = p_clientTicket.getCtToDraw();
            /*
             * if (p_clientTicket.getCtTrmId() != null) trmId = p_clientTicket.getCtTrmId();
             */
            /*
             * if (p_clientTicket.getCtBetMultiA() != null) multiplier = p_clientTicket.getCtBetMultiA();
             */
            if (p_clientTicket.getCtMaxAmountWinner() != null)
                maxAmountWinner = p_clientTicket.getCtMaxAmountWinner();
            if (p_clientTicket.getCtTerminalNr() != null)
                terminal = p_clientTicket.getCtTerminalNr();
            if (p_clientTicket.getCtAgencyCd() != null)
                agency = p_clientTicket.getCtAgencyCd();
            // Game game = new Game(gameNumber);
            // gameName = game.getName();
            /*
             * String tn = ""; for(int i=0; i<ticketNumber.length(); i++){ if((i+1)%5 == 0) tn += ticketNumber.charAt(i)+" "; else tn += ""+ticketNumber.charAt(i); } String barcode =
             * ClientUtils.Interleaved2of5(ticketNumber,6);
             */
            String apparea = String.valueOf(ConnectionFactory.operationProperty("applicationArea", context)).toString().trim().toLowerCase();
            String testusers = String.valueOf(ConnectionFactory.operationProperty("testUsers", context)).toString().trim();
            // StringBuffer htmlText = new StringBuffer();
            // DecimalFormat df = new DecimalFormat("###,##0.00");
            // String ticketId = clientTicket.getTicketId();
            // String clientId = clientTicket.getClientId();
            // String trnsNum = "0";
            // if(clientTicket.getTrnsNum() != null) trnsNum =
            // clientTicket.getTrnsNum();
            // int fromDraw = clientTicket.getFromDraw();
            // int toDraw = clientTicket.getToDraw();
            // int columns = clientTicket.getNumColumns();
            // String numColumns = StringUtils.leftPad(""+columns,9,"0");
            // Double receiptAmount = clientTicket.getReceiptAmount();
            // String receiptNr =
            // StringUtils.leftPad(""+clientTicket.getReceiptNr(),9,"0");
            // String ticketDate = clientTicket.getTicketDate();
            // String fromDrawDate = clientTicket.getFromDrawDate();
            // String ticketNumber = clientTicket.getTicketNumber();
            // String imgGame = null;
            // String imgW = null;
            // String imgH = null;
            // String terminal = clientTicket.getTerminalNr();
            // String agency =
            // StringUtils.leftPad(clientTicket.getAgencyCd(),7,"0");
            // double maxAmountWinner = clientTicket.getMaxAmountWinner();
            // TicketWinner ticketWinner = clientTicket.getTicketWinner();
            // int prizeFlag = 0;
            // int defineFlag = 0;
            // int payFlag = 0;
            // if(clientTicket.getPrizeFlag() != null) prizeFlag =
            // Integer.parseInt(clientTicket.getPrizeFlag());
            // if(ticketWinner.getDefinePrizeFlag() != null) defineFlag =
            // Integer.parseInt(ticketWinner.getDefinePrizeFlag());
            // if(ticketWinner.getPrizeFlag() != null) payFlag =
            // Integer.parseInt(ticketWinner.getPrizeFlag());
            // String bet1 = "";
            // String bet2 = "";
            String multiplicador1 = null;
            String multiplicador2 = null;
            int lengthMatrix1 = 0;
            int lengthMatrix2 = 0;
            String lengthMatrix1Str = null;
            String lengthMatrix2Str = null;
            // String[] betMatrix1 = null;
            // String[] betMatrix2 = null;
            // String matrix1 = clientTicket.getBetMatrix1();
            // String matrix2 = clientTicket.getBetMatrix2();
            // if(!matrix1.equals("")) betMatrix1 = matrix1.split("x");
            // if(!matrix2.equals("")) betMatrix2 = matrix2.split("x");
            if (betMatrix1 != null) {
                multiplicador1 = "&nbsp;&nbsp;" + betMatrix1[1];
                lengthMatrix1 = betMatrix1[0].split(" ").length;
                lengthMatrix1Str = StringUtils.leftPad("" + lengthMatrix1, 2, "0");
                betMatrix1 = betMatrix1[0].split(" ");
                for (int i = 0; i < lengthMatrix1; i++)
                    bm1 = bet1 + "&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix1[i], 2, "0");
            }
            
            if(betMatrix2 != null){ 
            	multiplicador2 = "&nbsp;&nbsp;" + betMatrix2[1]; 
            	lengthMatrix2 = betMatrix2[0].split(" ").length; 
            	lengthMatrix2Str = StringUtils.leftPad(""+lengthMatrix2,2,"0");
            	betMatrix2 = betMatrix2[0].split(" "); 
            	for(int i = 0; i < lengthMatrix2; i++)
            		bm2 = bet2 + "&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix2[i],2,"0");  
            }
             
            LoggerApi.Log.info("matrix1   ------------------>     " + matrix1);
            LoggerApi.Log.info("matrix2   ------------------>     " + matrix2);
            // String bm1 = "";
            /**** Aqui ****/
            String tn = "";
            for (int i = 0; i < ticketNumber.length(); i++)
                if ((i + 1) % 5 == 0)
                    tn += ticketNumber.charAt(i) + " ";
                else
                    tn += ticketNumber.charAt(i);
            String barcode = ClientUtils.Interleaved2of5(ticketNumber, null);
            
            String crc_v = TestFunc.getCrc_v5(ticketNumber);
            
            /***********/
            imgGame = "imgKinelo.jpg";
            imgW = "195";
            imgH = "99";
            // String apparea =
            // String.valueOf(ConnectionFactory.operationProperty("applicationArea",
            // context)).toString().trim();
            // String testusers =
            // String.valueOf(ConnectionFactory.operationProperty("testUsers",
            // context)).toString().trim();
            // boolean isMobile =
            // Boolean.valueOf(ConnectionFactory.operationProperty("mobileEnabled",Constants.contextSale)).booleanValue();
            //String separateline = "<tr><td align='center' style='font-size:9px;'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>";
            String separateline = "<tr><td align='center' style='font-size:9px;'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>";
            htmlText.append("<html><head><script type='text/javascript'>function oncontextmenuHandler(){return false;}"
                    + "document.oncontextmenu = oncontextmenuHandler;function disableselect(e){return false;}"
                    + "function reEnable(){return true;}document.onselectstart=new Function ('return false');"
                    + "if (window.sidebar){document.onmousedown=disableselect;document.onclick=reEnable;}<\"+\"/script></head><body><center><table width='100%' cellpadding='0' cellspacing='0' style='margin:0; padding:0; border:0;'><tr><td align='center'>");
            // if(bp == 1) {
            //htmlText.append("<table width='292' cellpadding='0' cellspacing='0' style='margin:0; padding:9px; border:black 1px solid; font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>");
            htmlText.append("<table width='327' cellpadding='0' cellspacing='0' style='margin:0; padding:9px; border:black 1px solid; font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>");
            // }
            /*
             * if(!numberid.equals("")) { htmlText.append( "<tr><td style='font-size:9px;' colspan='2'>Id1&nbsp;: " +clientId+"&nbsp;&nbsp;&nbsp;&nbsp;Id2&nbsp;: "+numberid+
             * "&nbsp;&nbsp;&nbsp;&nbsp;Id3&nbsp;: " +ticketId+"<br/><br/></td></tr>"); } else {
             */
            htmlText.append("<tr><td style='font-size:9px;' colspan='2'>Id1&nbsp;: " + clientId + "<br/>Id2&nbsp;: " + ticketId + "</td></tr>");
            // }
            // if(bp == 1) {
            /* Quitar logo de Intralot - Inicio - @jmoran */
            /*
            htmlText.append("<tr><td align='center' style='padding:3px 0 0 0;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/client/imgIntralot.gif' width='74' height='22' border='0'/></td></tr>"
                    + "<tr><td align='center' style='font-size:9px; padding:3px 0 0 0;'>RUC&nbsp;&nbsp;20506035121</td></tr>");
            */
            // }
            /* Mostrar logos de sorteos en UAT */
            /*
            htmlText.append("<tr><td align='center' style='padding:3px 0 0 0;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim() + "/layer-view-image/client/" + imgGame
            */
            htmlText.append("<tr><td align='center' style='padding:3px 0 0 0;'><img src='layer-view-image/client/" + imgGame
                    + "' width='" + imgW + "' height='" + imgH + "' border='0'/></td></tr>");
            htmlText.append("<tr><td style='font-size:9px;' align='center'>www.kinelo.com.pe</td></tr>");
            if (apparea.equals("development"))
                htmlText.append("<tr><td style='font-size:16px; font-weight:bold;' align='center'>BOLETO DE PRUEBAS</td></tr>");
            else if (apparea.equals("production"))
                if (testusers != null && !testusers.equals("")) {
                    String[] users = testusers.split(",");
                    for (String user : users)
                        // if(users[i].equals(clientId) ||
                        // users[i].equals(numberid)) {
                        if (user.equals(clientId)) {
                            htmlText.append("<tr><td style='font-size:16px;font-weight:bold;' align='center' colspan='2'>BOLETO SIN VALOR</td></tr>");
                            break;
                        }
                }
            htmlText.append("<tr><td align='center' style='padding:3px 0 0 0;'>AGENTE:" + StringUtils.leftPad(agency, 7, "0") + "&minus;" + terminal
                    + "&nbsp;&nbsp;01&nbsp;&nbsp;TRN:" + StringUtils.leftPad(trnsNum, 10, "0") + "</td></tr>");
            htmlText.append("<tr><td align='center' style='padding:3px 0 0 0;'>CPN:" + StringUtils.leftPad("" + receiptNr, 9, "0") + "&nbsp;&nbsp;COL:"
            		+ StringUtils.leftPad("" + numColumns, 9, "0") + "&nbsp;&nbsp;" + ticketDate.substring(0, 10)/*
                                                                                                                 * + "&minus;" + ticketDate . substring ( 9 )
                                                                                                                 */+ "</td></tr>");
            // htmlText.append("<tr><td align='center' style='padding:3px 0 0 0;'>Primer Sorteo: "
            // + fromDrawDate.substring(0,16) + "</td></tr>");
            htmlText.append("<tr><td align='center' style='padding:3px 0 0 0;'>Primer Sorteo: " + fromDrawDay + "</td></tr>");
            htmlText.append(separateline);
            htmlText.append("<tr><td style='font-size:14px;' align='center'>RECIBO&nbsp;VALIDO&nbsp;PARA&nbsp;" + StringUtils.leftPad("" + (toDraw - fromDraw + 1), 2, "0")
                    + "&nbsp;SORTEO(S)</td></tr>");
            htmlText.append("<tr><td style='font-size:13px; font-weight:bold;' align='center'>DEL&nbsp;SORTEO&nbsp;" + StringUtils.leftPad("" + fromDraw, 4, "0")
                    + "&nbsp;HASTA&nbsp;" + StringUtils.leftPad("" + toDraw, 4, "0") + "</td></tr>");
            htmlText.append(separateline);
            String paddingleft = "06";
            // if(bp == 0 || (bp == 1 && prizeFlag == 1 && defineFlag == 2 &&
            // payFlag == 0))paddingleft = "21";
            if (!matrix1.equals("")) {
                htmlText.append("<tr><td style='font-size:14px; padding-left:" + paddingleft + "px;' >A. (" + lengthMatrix1Str + "):" + matrix1 + "</td></tr>");
                htmlText.append("<tr><td style='font-size:14px;font-weight:bold;' align='center'>Multiplicador :" + multiplicador1 + "</td></tr>");
            }
            
            if(!matrix2.equals("")) { 
            	htmlText.append("<tr><td style='font-size:14px; padding-left:" + paddingleft + "px;' >B. (" + lengthMatrix2Str + "):" + matrix2 + "</td></tr>");
                htmlText.append("<tr><td style='font-size:14px;font-weight:bold;' align='center'>Multiplicador :" + multiplicador2 + "</td></tr>");
            	/*htmlText.append("<tr><td style='font-size:14px; padding-left:" +paddingleft+"px;' >"+(!matrix1.equals("")?"2":"1")+". (" + lengthMatrix2Str + "):" + bet2 +"</td></tr>"); 
            	htmlText.append( "<tr><td style='font-size:14px;font-weight:bold;' align='center'>Multiplicador :" + multiplicador2 + "</td></tr>"); 
            	*/
            }
            
            htmlText.append(separateline);
            htmlText.append("<tr><td style='font-size:16px;font-weight:bold; padding:2px 0 2px 0;'><div style='float:left; width:140px; margin-left: 8px;'>TOTAL</div><div style='float:right; text-align: right; width:140px; margin-right: 8px;'>S/. "
                    + df.format(receiptAmount) + "</div></td></tr>");
            htmlText.append("<tr><td style='font-weight:bold; padding:2px 0 2px 0;'><div style='float:left; width:140px; margin-left: 8px;'>GANA HASTA:</div><div style='float:right; text-align: right; width:140px; margin-right: 8px;'>S/. "
                    + df.format(maxAmountWinner) + "<div></td></tr>");
            htmlText.append(separateline);
            // htmlText.append("<tr><td align='center' style='font-size:9px; padding:10px 0 10px 0; margin:0 8px 0p 8px;'>Todos los premios estan afectos al 10% de descuento por impuesto municipal. El minimo monto a pagar como premio es de S/.1 sol</td></tr>");
            // htmlText.append(separateline);
            /*
             * if(bp == 0 || (bp == 1 && prizeFlag == 1 && defineFlag == 2 && payFlag == 0)) { htmlText.append("<tr><td align='center' style='font-size:12px;'>" +
             * tn.trim()+"</td></tr><tr><td align='center'>"+barcode+"</td></tr>" ); }else {
             */
            // htmlText.append("<tr><td align='center' style='font-size:9px; padding:10px 0 10px 0;'>Si su boleto obtiene premio y decide cobrarlo en efectivo, deber&aacute; reimprimir el boleto en donde figura el c&oacute;digo de barras y mostrarlo a la promotora en un punto de venta para cobrar su premio en efectivo.</td></tr>");
            // }
            /***** Aqui ***/
            if (tip_coupon == 1)
                if (p_clientTicket.getCtTwDefinePrize() != null && Integer.parseInt(p_clientTicket.getCtTwDefinePrize()) == 2)
                    htmlText.append("<tr><td align='center' style='font-size:12px;'>" + tn.trim() + " "+crc_v+"</td></tr><tr><td align='center'>" + barcode + "</td></tr>");
            // }
            // else
            // htmlText.append("<tr><td align='center' style='font-size:9px; padding:10px 0 10px 0;'>Si su boleto obtiene premio y decide cobrarlo en efectivo, deber&aacute; reimprimir el boleto en donde figura el c&oacute;digo de barras y mostrarlo a la promotora en un punto de venta para cobrar su premio en efectivo.</td></tr>");
            // }
            // htmlText.append("</table><div style='width:696px;'>&nbsp;</div><div style='width:293px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'>");
            //htmlText.append("</table><br /><div style='width:293px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'><strong>Atenci&oacute;n:</strong> "
            htmlText.append("</table><br /><div style='width:328px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'>"
                    +
                    /*
                     * "Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el ticket impreso con el c&oacute;digo de barras. " +
                     * "No comparta esta informaci&oacute;n, ni la deje a la vista de otros.<br>" +
                     * "El derecho al cobro de los premios caduca a los ciento ochenta(180) d&iacute;as calendarion de la fecha de finalizaci&oacute;n de la venta de este juego, la cual ser&aacute; publicada por INTRALOT DE PER&Uacute; S.A., en un diario de circulaci&oacute;n nacional. "
                     * + "Puede cobrar el premio a partir del <strong>d&iacute;a siguiente</strong> a la compra del boleto." +
                     */
                    "</div>");
            htmlText.append("</div>");
            htmlText.append("</td></tr></table></center></body></html>");
            return htmlText;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        }
    }

    @Override
    public StringBuffer findCouponClientTicketPollayPollon(TicketProcedureGetClientTicket p_clientTicket) throws Exception {
        LoggerApi.Log.info("ctClientId=" + p_clientTicket.getCtClientId() + " ctBetMatrix1=" + p_clientTicket.getCtBetMatrix1());
        StringBuffer htmlText = new StringBuffer();
      //String context = "CARD-WEB";
        String context = Constants.contextCardWeb;
        try {
            DecimalFormat df = new DecimalFormat("###,##0.00");
            // String[] betMatrix1 = null;
            // String[] betMatrix2 = null;
            // int bet1 = 0;
            // int bet2 = 0;
            // String matrix1 = "";
            // String matrix2 = "";
            String ticketId = "";
            String clientId = "";
            // int crc = 0;
            String trnsNum = "0";
            int fromDraw = 0;
            // String fromDrawDay = "";
            int gameNumber = 0;
            // int numColumns = 0;
            int columns = 0;
            Double receiptAmount = 0.0;
            int receiptNr = 0;
            String ticketDate = "";
            String ticketNumber = "";
            // int toDraw = 0;
            // double maxAmountWinner = 0;
            // String trmId = "";
            String terminal = "";
            String agency = "";
            String eventItems = "";
            String gameName = "";
            String imgGame = null;
            String imgW = null;
            String imgH = null;
            // String charity = null;
            // String webAddress = null;
            String bm1 = "";
            // String bm2 = "";
            int multiplier = 0;
            /*
             * if (p_clientTicket.getCtBetMatrix1() != null) matrix1 = p_clientTicket.getCtBetMatrix1();
             */
            /*
             * if (p_clientTicket.getCtBetMatrix2() != null) matrix2 = p_clientTicket.getCtBetMatrix2();
             */
            /*
             * if (matrix1 != null && !matrix1.equals("")) betMatrix1 = matrix1.split("x");
             */
            /*
             * if (matrix2 != null && !matrix2.equals("")) betMatrix2 = matrix2.split(" ");
             */
            if (p_clientTicket.getCtTicketId() != null)
                ticketId = p_clientTicket.getCtTicketId();
            if (p_clientTicket.getCtClientId() != null)
                clientId = p_clientTicket.getCtClientId();
            /*
             * if (p_clientTicket.getCtCrc() != null) crc = p_clientTicket.getCtCrc();
             */
            if (p_clientTicket.getCtTrnsNum() != null)
                trnsNum = p_clientTicket.getCtTrnsNum();
            if (p_clientTicket.getCtFromDraw() != null)
                fromDraw = p_clientTicket.getCtFromDraw();
            /*
             * if (p_clientTicket.getFromDrawDay() != null) fromDrawDay = p_clientTicket.getFromDrawDay();
             */
            if (p_clientTicket.getCtGameNumber() != 0)
                gameNumber = p_clientTicket.getCtGameNumber();
            if (p_clientTicket.getCtNumColumns() != null)
                columns = p_clientTicket.getCtNumColumns();
            if (p_clientTicket.getCtReceiptAmount() != null)
                receiptAmount = p_clientTicket.getCtReceiptAmount();
            if (p_clientTicket.getCtReceiptNr() != null)
                receiptNr = p_clientTicket.getCtReceiptNr();
            if (p_clientTicket.getCtTicketDate() != null)
                ticketDate = p_clientTicket.getCtTicketDate();
            if (p_clientTicket.getCtTicketNumber() != null)
                ticketNumber = StringLib.decodeLabel(p_clientTicket.getCtTicketNumber());
            /*
             * if (p_clientTicket.getCtToDraw() != null) toDraw = p_clientTicket.getCtToDraw();
             */
            /*
             * if (p_clientTicket.getCtTrmId() != null) trmId = p_clientTicket.getCtTrmId();
             */
            /*
             * if (p_clientTicket.getCtBetMultiA() != null) multiplier = p_clientTicket.getCtBetMultiA();
             */
            if (p_clientTicket.getCtMultiplier() != null)
                multiplier = p_clientTicket.getCtMultiplier();
            /*
             * if (p_clientTicket.getCtMaxAmountWinner() != null) maxAmountWinner = p_clientTicket.getCtMaxAmountWinner();
             */
            if (p_clientTicket.getCtTerminalNr() != null)
                terminal = p_clientTicket.getCtTerminalNr();
            if (p_clientTicket.getCtAgencyCd() != null)
                agency = p_clientTicket.getCtAgencyCd();
            if (p_clientTicket.getCtEventItems() != null)
                eventItems = p_clientTicket.getCtEventItems();
            String numColumns = StringUtils.leftPad("" + columns, 9, "0");
            String[] cti = eventItems.split("____");
            Game game = new Game(gameNumber);
            gameName = game.getName();
            String tn = "";
            for (int i = 0; i < ticketNumber.length(); i++)
                if ((i + 1) % 5 == 0)
                    tn += ticketNumber.charAt(i) + " ";
                else
                    tn += "" + ticketNumber.charAt(i);
            String barcode = ClientUtils.Interleaved2of5(ticketNumber, 6);
            
            String crc_v = TestFunc.getCrc_v5(ticketNumber);
            
            String apparea = String.valueOf(ConnectionFactory.operationProperty("applicationArea", context)).toString().trim().toLowerCase();
            String testusers = String.valueOf(ConnectionFactory.operationProperty("testUsers", context)).toString().trim();
            // StringBuffer htmlText = new StringBuffer();
            // DecimalFormat df = new DecimalFormat("###,##0.00");
            // String ticketId = clientTicket.getTicketId();
            // String clientId = clientTicket.getClientId();
            // String trnsNum = "0";
            // if(clientTicket.getTrnsNum() != null) trnsNum =
            // clientTicket.getTrnsNum();
            // int fromDraw = clientTicket.getFromDraw();
            // int toDraw = clientTicket.getToDraw();
            // int columns = clientTicket.getNumColumns();
            // String numColumns = StringUtils.leftPad(""+columns,9,"0");
            // Double receiptAmount = clientTicket.getReceiptAmount();
            // String receiptNr =
            // StringUtils.leftPad(""+clientTicket.getReceiptNr(),9,"0");
            // String ticketDate = clientTicket.getTicketDate();
            // String fromDrawDate = clientTicket.getFromDrawDate();
            // String ticketNumber = clientTicket.getTicketNumber();
            // String imgGame = null;
            // String imgW = null;
            // String imgH = null;
            // String terminal = clientTicket.getTerminalNr();
            // String agency =
            // StringUtils.leftPad(clientTicket.getAgencyCd(),7,"0");
            // double maxAmountWinner = clientTicket.getMaxAmountWinner();
            // TicketWinner ticketWinner = clientTicket.getTicketWinner();
            // int prizeFlag = 0;
            // int defineFlag = 0;
            // int payFlag = 0;
            // if(clientTicket.getPrizeFlag() != null) prizeFlag =
            // Integer.parseInt(clientTicket.getPrizeFlag());
            // if(ticketWinner.getDefinePrizeFlag() != null) defineFlag =
            // Integer.parseInt(ticketWinner.getDefinePrizeFlag());
            // if(ticketWinner.getPrizeFlag() != null) payFlag =
            // Integer.parseInt(ticketWinner.getPrizeFlag());
            // String bet1 = "";
            // String bet2 = "";
            // String multiplicador1 = null;
            // String multiplicador2 = null;
            // int lengthMatrix1 = 0;
            // int lengthMatrix2 = 0;
            // String lengthMatrix1Str = null;
            // String lengthMatrix2Str = null;
            // String[] betMatrix1 = null;
            // String[] betMatrix2 = null;
            // String matrix1 = clientTicket.getBetMatrix1();
            // String matrix2 = clientTicket.getBetMatrix2();
            // if(!matrix1.equals("")) betMatrix1 = matrix1.split("x");
            // if(!matrix2.equals("")) betMatrix2 = matrix2.split("x");
            /*
             * if(betMatrix1 != null){ multiplicador1 = "&nbsp;&nbsp;" + betMatrix1[1]; lengthMatrix1 = betMatrix1[0].split(" ").length; lengthMatrix1Str = StringUtils.leftPad(""+lengthMatrix1,2,"0");
             * betMatrix1 = betMatrix1[0].split(" "); for(int i = 0; i < lengthMatrix1; i++){ bm1 = bet1 + "&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix1[i],2,"0"); } }
             */
            /*
             * if(betMatrix2 != null){ multiplicador2 = "&nbsp;&nbsp;" + betMatrix2[1]; lengthMatrix2 = betMatrix2[0].split(" ").length; lengthMatrix2Str = StringUtils.leftPad(""+lengthMatrix2,2,"0");
             * betMatrix2 = betMatrix2[0].split(" "); for(int i = 0; i < lengthMatrix2; i++){ bet2 = bet2 + "&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix2[i],2,"0"); } }
             */
            // String bm1 = "";
            /*
             * String tn = ""; for(int i=0; i<ticketNumber.length(); i++){ if((i+1)%5 == 0) tn += ticketNumber.charAt(i)+" "; else tn += ticketNumber.charAt(i); } String barcode =
             * ClientUtils.Interleaved2of5(ticketNumber,null);
             */
            imgGame = "imgPollayPollon.gif";
            imgW = "150";
            imgH = "95";
            for (int i = 0; i < cti.length; i++) {
                // LoggerApi.Log.info(cti[i]);
                String[] event = cti[i].split("__");
                String numorder = StringUtils.leftPad("" + (i + 1), 2, "0");
                bm1 += numorder + ".&nbsp;&nbsp;Carrera&nbsp;<strong>";
                // for(int j=0; j<(event.length/3); j++) bm1 +=
                // event[1+(j*3)]+"&nbsp;";
                bm1 += event[0].trim();
                // bm1 = bm1.substring(0,(bm1.length()-6))+"</strong>(";
                // for(int j=0; j<(event.length/3); j++) bm1 +=
                // "<label style='text-transform:capitalize;'>"+event[2+(j*3)].substring(0,1).toUpperCase()+event[2+(j*3)].substring(1).toLowerCase()+"</label>,";
                bm1 += "</strong>(<label style='text-transform:capitalize;'>" + event[1].trim().substring(0, 1).toUpperCase() + event[1].trim().substring(1).toLowerCase()
                        + "</label>)<br/>";
                // bm1 = bm1.substring(0,(bm1.length()-1))+")<br/>";
                /*
                 * elements[i] = (i+1)+" "+bet+" "+factor; bm += "<br/>"+eventId+"&nbsp;&nbsp;"+bet; fac += "<br/>"+factor; ord += "<br/>"+StringUtils.leftPad((i+1)+":",4," "); min += "<br/>"+minimum;
                 * if(minimum == 1) min1++; else if(minimum == 2) min2++; else if(minimum == 3) min3++;
                 */
            }
            // LoggerApi.Log.info("min1="+min1+" min2="+min2+" min3="+min3);
            /*
             * if(bet1 > 0 && combined != null && !combined.equals("")) { ArrayList<String[]> fullBets = Combina.getBets(combined, elements); int i = 0; for(String[] c : fullBets) { if(i == 0) solved
             * += "<tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;" +ord+"</td>" + "<td align='left' style='padding: 0 0 5px 0;'><b>Predic."
             * +bm+"</b></td><td align='right' style='padding: 0 0 5px 0;'><b>Prob." + fac+"</b></td><td align='center' style='padding: 0 0 5px 0;'><b>Min."
             * +min+"</b></td><td align='center' style='padding: 0 0 5px 0;'>"; else { if(bp == 1) { if((i%20) == 0 && c.length > 0) solved +=
             * "</td></tr><tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;" +ord+"</td>" +
             * "<td align='center' style='padding: 0 0 5px 0;'>&nbsp;</td><td align='center' style='padding: 0 0 5px 0;'>&nbsp;</td><td align='center' style='padding: 0 0 5px 0;'>&nbsp;</td><td align='center' style='padding: 0 0 5px 0;'>"
             * ; } else if (bp == 0) { if((i%8) == 0 && c.length > 0) solved += "</td></tr><tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;" +ord+"</td>" +
             * "<td align='center' style='padding: 0 0 5px 0;'>&nbsp;</td><td align='center' style='padding: 0 0 5px 0;'>&nbsp;</td><td align='center' style='padding: 0 0 5px 0;'>&nbsp;</td><td align='center' style='padding: 0 0 5px 0;'>"
             * ; } } if(i >= 0 && i < 9) solved += "&nbsp;&nbsp;<u>"+(i+1)+"</u>&nbsp;&nbsp;<br/>"; else if(i >= 9 && i < 99) solved += "&nbsp;<u>"+(i+1)+"</u>&nbsp;<br/>"; else solved +=
             * "<u>"+(i+1)+"</u><br/>"; int k = 0; double mulFactor = 1; for(int j=0; j<bet1; j++) { if(k < c.length) { String[] a = c[k].split(" "); if(Integer.parseInt(a[0].trim()) == (j+1)) {
             * solved += a[1].trim()+"<br/>"; mulFactor *= Double.parseDouble(a[2].trim()); k++; } else solved += "&nbsp;<br/>"; } else solved += "&nbsp;<br/>"; } if(i == (fullBets.size()-1)) solved
             * += df.format(mulFactor)+"</td></tr>"; else solved += df.format(mulFactor)+ "</td><td align='center' style='padding: 0 0 5px 0;'>"; total += mulFactor; i++; } solved
             * +="<tr><td colspan='15'><br/>"+i+" jugadas<br/><br/></td></tr>"; } if(total > 0.0 && total <= 50000.0) solved += "<tr><td colspan='15'>Total de probabilidades:&nbsp;" +df.format(total
             * )+"&nbsp;puntos generados de jugadas combinadas.</td></tr>";
             */
            // boolean isMobile =
            // Boolean.valueOf(ConnectionFactory.operationProperty("mobileEnabled",Constants.contextSale).trim()).booleanValue();
            //String separateline = "<tr><td align='center' style='font-size:9px;'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>";
            String separateline = "<tr><td align='center' style='font-size:9px;'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>";
            htmlText.append("<html><head><script type='text/javascript'>function oncontextmenuHandler(){return false;}"
                    + "document.oncontextmenu = oncontextmenuHandler;function disableselect(e){return false;}"
                    + "function reEnable(){return true;}document.onselectstart=new Function ('return false');"
                    + "if (window.sidebar){document.onmousedown=disableselect;document.onclick=reEnable;}<\"+\"/script></head><body><center><table width='100%' cellpadding='0' cellspacing='0' style='margin:0; padding:0; border:0;'><tr><td align='center'>");
            //htmlText.append("<table width='292' cellpadding='0' cellspacing='0' style='margin:0; padding:9px; border:black 1px solid; font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>");
            htmlText.append("<table width='327' cellpadding='0' cellspacing='0' style='margin:0; padding:9px; border:black 1px solid; font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>");
            /*
             * if(bp == 1) htmlText.append(
             * "<table width='292' cellpadding='0' cellspacing='0' style='margin:0; padding:9px; border:black 1px solid; font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>" ); else
             * if(bp == 0) htmlText.append(
             * "<table width='272' cellpadding='0' cellspacing='0' style='margin:0; padding:0; border:0; border-collapse:collapse; font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>"
             * ); if(!numberid.equals("")) htmlText.append( "<tr><td style='font-size:9px;' colspan='2'>Id1&nbsp;: " +clientId+"&nbsp;&nbsp;&nbsp;&nbsp;Id2&nbsp;: "+numberid+
             * "&nbsp;&nbsp;&nbsp;&nbsp;Id3&nbsp;: " +ticketId+"<br/><br/></td></tr>"); else htmlText.append( "<tr><td style='font-size:9px;' colspan='2'>Id1&nbsp;: "
             * +clientId+"<br/>Id2&nbsp;: "+ticketId+"</td></tr>");
             */
            htmlText.append("<tr><td style='font-size:9px;' colspan='2'>Id1&nbsp;: " + clientId + "<br/>Id2&nbsp;: " + ticketId + "</td></tr>");
            // if(bp == 1) {
            htmlText.append("<tr><td colspan='2' align='center' style='padding:3px 0 0 0;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/client/imgIntralot.gif' width='74' height='22' border='0'/></td></tr>"
                    + "<tr><td colspan='2' align='center' style='font-size:9px; padding:3px 0 0 0;'>RUC&nbsp;&nbsp;20506035121</td></tr>");
            /*
             * } else if(bp == 0) { htmlText.append("<tr><td align='center' style='padding:3px 0 0 0;'>" +clComName+"</td></tr>" +
             * "<tr><td align='center' style='font-size:9px; padding:3px 0 0 0;'>RUC&nbsp;&nbsp;" +clComNumber+"</td></tr>"); }
             */
            htmlText.append("<tr><td colspan='2' align='center' style='padding:3px 0 0 0;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim() + "/layer-view-image/client/" + imgGame + "'"
                    + "' width='" + imgW + "' height='" + imgH + "' border='0'/></td></tr>");
            if (apparea.equals("development"))
                htmlText.append("<tr><td colspan='2' style='font-size:16px; font-weight:bold;' align='center'>BOLETO DE PRUEBAS</td></tr>");
            else if (apparea.equals("production"))
                if (testusers != null && !testusers.equals("")) {
                    String[] users = testusers.split(",");
                    for (String user : users)
                        // if(users[i].equals(clientId) ||
                        // users[i].equals(numberid)) {
                        if (user.equals(clientId)) {
                            htmlText.append("<tr><td style='font-size:16px;font-weight:bold;' align='center' colspan='2'>BOLETO SIN VALOR</td></tr>");
                            break;
                        }
                }
            htmlText.append("<tr><td align='center' style='padding:3px 0 0 0;'>" + gameName + "(" + gameNumber + ")&nbsp;FECHA:" + ticketDate.substring(0, 8) + "&nbsp;PROG("
                    + fromDraw + ")</td></tr>" + "<tr><td align='center' style='padding:3px 0 0 0;'>AGENTE:" + StringUtils.leftPad(agency, 7, "0") + "&minus;" + terminal
                    + "&nbsp;&nbsp;01&nbsp;&nbsp;TRN:" + StringUtils.leftPad(trnsNum, 10, "0") + "</td></tr>" + "<tr><td align='center' style='padding:3px 0 0 0;'>CPN:"
                    + StringUtils.leftPad("" + receiptNr, 9, "0") + "&nbsp;&nbsp;COL:" + numColumns + "&nbsp;&nbsp;" + ticketDate.substring(0, 8) + "&minus;"
                    + ticketDate.substring(9) + "</td></tr>" + separateline);
            if (!bm1.equals(""))
                htmlText.append("<tr><td style='padding:2px 0 2px 0;'>" + bm1 + "</td></tr>");
            htmlText.append(separateline);
            // if(combined != null)
            // htmlText.append("<tr><td style='font-weight:bold; padding:2px 0 2px 0;'>COMBINADAS&nbsp;&nbsp;&nbsp;&nbsp;"+combined+"</td></tr>");
            htmlText.append("<tr><td style='font-weight:bold; padding:2px 0 2px 0;'>MULTIPLICADOR&nbsp;" + multiplier + "&nbsp;&nbsp;&nbsp;TOTAL COLUMNAS&nbsp;" + columns
                    + "</td></tr>" + separateline);
            // if(gameNumber == Game.TEAPUESTO) {
            htmlText.append("<tr><td style='font-size:16px;font-weight:bold; padding:2px 0 2px 0;'><div style='float:left; width:162px;'>TOTAL</div><div style='float:left; text-align: right; width:108px;'>S/. "
                    + df.format(receiptAmount) + "</div></td></tr>" + separateline);
            // "<tr><td style='font-weight:bold; padding:2px 0 2px 0;'><div style='float:left; width:162px;'>MONTO MAXIMO GANADOR:</div><div style='float:left; text-align: right; width:108px;'>S/. "+df.format(maxAmountWinner)+"<div></td></tr>"+separateline);
            /*
             * if(receiptDiscounted != 0.0) { htmlText.append( "<tr><td style='font-size:14px;font-weight:bold; padding:3px 0 0 0;' align='center'>+GANO DESCUENTO&nbsp;&nbsp;"
             * +df.format(receiptDiscounted)+"</td></tr>"+separateline); }
             */
            // if(bp == 0 || (bp == 1 && prizeFlag == 1 && defineFlag == 2 &&
            // payFlag == 0))
            // htmlText.append("<tr><td align='center' style='font-size:13px; padding:3px 0 0 0;'>"+tn.trim()+"</td></tr><tr><td align='center'>"+barcode+"</td></tr>");
            // if(prizeFlag == 1 && defineFlag == 2 && payFlag == 0)
            // if(p_clientTicket.getCtTwDefinePrize() != null &&
            // Integer.parseInt(p_clientTicket.getCtTwDefinePrize()) == 2 )
            htmlText.append("<tr><td align='center' style='font-size:12px; padding:3px 0 0 0;'>" + tn.trim() + " "+crc_v+ "</td></tr><tr><td align='center'>" + barcode + "</td></tr>");
            // else
            // htmlText.append("<tr><td align='center' style='font-size:9px; padding:10px 0 10px 0;'>Si su boleto obtiene premio y decide cobrarlo en efectivo, deber&aacute; reimprimir el boleto en donde figura el c&oacute;digo de barras y mostrarlo a la promotora en un punto de venta para cobrar su premio en efectivo.</td></tr>");
            // if(bp == 1) {
            // htmlText.append("</table><div style='width:696px;'>&nbsp;</div><div style='width:293px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'>");
            //htmlText.append("</table><br /><div style='width:293px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'>");
            htmlText.append("</table><br /><div style='width:328px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'>");
            // if(prizeFlag == 1 && defineFlag == 2 && payFlag == 0)
            //EB20171018htmlText.append("<strong>Atenci&oacute;n:</strong> Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el ticket impreso con el c&oacute;digo de barras. No comparta esta informaci&oacute;n, ni la deje a la vista de otros.</div>");
            // else
            // htmlText.append("</div>");
            // if(!solved.equals(""))
            // htmlText.append("<div style='width:696px;'>&nbsp;</div><div style='width:696px;'>&nbsp;</div><table width='696' cellpadding='1' cellspacing='0' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif; border-collapse:collapse;' id='tblSolved'>"+solved+"</table>");
            /*
             * } else if(bp == 0) { if(isMobile) htmlText.append( "<tr><td align='center' colspan='2'><canvas id='qrcanv' /></td></tr>" ); htmlText.append(
             * "</table><div style='width:267px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify; margin: 0 0 0 5px;'><strong>Atenci&oacute;n:</strong>" +
             * "Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el ticket impreso con el c&oacute;digo de barras. No comparta esta informaci&oacute;n, ni la deje a la vista de otros.</div>"
             * ); if(!solved.equals("")) htmlText.append(
             * "<div style='width:272px;'>&nbsp;</div><div style='width:272px;'>&nbsp;</div><table width='267' cellpadding='0' cellspacing='0' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif; border-collapse:collapse;' margin:0 0 0 5px; id='tblSolved'>"
             * +solved+"</table>"); }
             */
            htmlText.append("</td></tr></table></center></body></html>");
            return htmlText;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        }
    }

    @Override
    public StringBuffer findCouponClientTicketRapitinkas(TicketProcedureGetClientTicket p_clientTicket, int tip_coupon) throws Exception {
        LoggerApi.Log.info("cid=" + p_clientTicket.getCtClientId() + " ctBetMatrix1=" + p_clientTicket.getCtBetMatrix1() + " tip_coupon=" + tip_coupon);
        StringBuffer htmlText = new StringBuffer();
        // SimpleDateFormat defaultDf = new
        // SimpleDateFormat("dd/MM/yyyy HH:mm:ss",Locale.getDefault());
        DecimalFormat df = new DecimalFormat("###,##0.00");
        String imgGame = null;
        String imgW = null;
        String imgH = null;
        String webAddress = null;
        int gameNumber = 0;
        String gameName = ""; // String superGame = cp.getSuperGame();
        String crcV = "";
        String editionId = "";
        String bookId = "";
        String numId = "";
        String vals = "";
        String id2 = "";
        // Date saleDate = cp.getSaleDate();
        String ticketDate = "";// defaultDf.format(saleDate);
        double netPrize = 0.0;// = cp.getNetPrize();
        double wonPrize = 0.0;// = cp.getWonPrize();
        String ticketId = "";// cp.getTicketId();
        String clientId = "";// cp.getClientId();
        String ticketCode = "";// cp.getTicketCode();
        // String barCode = cp.getBarCode();
        if (p_clientTicket.getCtTicketId() != null)
            ticketId = p_clientTicket.getCtTicketId();
        if (p_clientTicket.getCtClientId() != null)
            clientId = p_clientTicket.getCtClientId();
        if (p_clientTicket.getCtTicketDate() != null)
            ticketDate = p_clientTicket.getCtTicketDate();
        if (p_clientTicket.getCtGameNumber() != 0)
            gameNumber = p_clientTicket.getCtGameNumber();
        if (p_clientTicket.getCtTicketNumber() != null)
            ticketCode = StringLib.decodeLabel(p_clientTicket.getCtTicketNumber());
        LoggerApi.Log.info("cid=" + p_clientTicket.getCtClientId() + " ticketCode=" + StringLib.encodeLabel(ticketCode));
        if (p_clientTicket.getCrc_v() != null) {
            LoggerApi.Log.info("cid=" + p_clientTicket.getCtClientId() + " p_clientTicket.getCrc_v() != null");
            crcV = StringLib.padLeft(String.valueOf(p_clientTicket.getCrc_v()), '0', 4);
            editionId = ticketCode.substring(0, 3);
            bookId = ticketCode.substring(3, 10);
            numId = ticketCode.substring(10, 13);
            vals = "-"  + ticketCode.substring(13, 20) + "-" + ticketCode.substring(20, 22) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + crcV;
            id2 = p_clientTicket.getCtBetMatrix1();
        } else {
            LoggerApi.Log.info("cid=" + p_clientTicket.getCtClientId() + " p_clientTicket.getCrc_v() == null");
            editionId = ticketCode.substring(0, 3);
            bookId = ticketCode.substring(3, 9);
            numId = ticketCode.substring(9, 12);
            vals = "-" + ticketCode.substring(12, 22) + "&nbsp;" + ticketCode.substring(22, 26);
            id2 = editionId + "-" + bookId + "-" + numId;
        }
        Game game = new Game(gameNumber);
        gameName = game.getName();
        if (p_clientTicket.getInPrintedPrice() != null)
            wonPrize = p_clientTicket.getInPrintedPrice();
        if (p_clientTicket.getInPrintedPrice() != null)
            netPrize = p_clientTicket.getCtTwPrizeAmount();
        String barCode = ClientUtils.Interleaved2of5(ticketCode, null);
        // ***/
      //String context = "CARD-WEB";
        String context = Constants.contextCardWeb;
        //String bc = ClientUtils.Interleaved2of5(barCode, null);
        String apparea = String.valueOf(ConnectionFactory.operationProperty("applicationArea", context)).toString().trim();
        String testusers = String.valueOf(ConnectionFactory.operationProperty("testUsers", context)).toString().trim();
        if (gameName.equals("RAPITINKAS")) {
            imgGame = "imgRapitinkas.gif";
            imgW = "200";
            imgH = "105";
            webAddress = "www.instantaneas.com.pe";
        }
        // p_clientTicket.
        /*
         * else if(superGame.equals("RAPIGANA")) { imgGame = "imgRapigana.gif"; imgW = "154"; imgH = "105"; webAddress = "www.instantaneas.com.pe"; }
         */
        // String separateline =
        // "<tr><td colspan='2' align='center'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>";
        //String separateline = "<tr><td colspan='2' align='center' style='font-size:9px;'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>";
        String separateline = "<tr><td colspan='2' align='center' style='font-size:9px;'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>";
        htmlText.append("<html><head><script type='text/javascript'>function oncontextmenuHandler(){return false;}"
                + "document.oncontextmenu = oncontextmenuHandler;function disableselect(e){return false;}"
                + "function reEnable(){return true;}document.onselectstart=new Function ('return false');"
                + "if (window.sidebar){document.onmousedown=disableselect;document.onclick=reEnable;}<\"+\"/script></head><body>");
        htmlText.append("<center><table width='100%' cellpadding='0' cellspacing='0' style='margin:0; padding:0; border:0;'>"
        		+ "<tr><td align='center'><table width='327' cellpadding='0' cellspacing='0' style='margin:0; padding:9px; border:black 1px solid; font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>");
                //+ "<tr><td align='center'><table width='292' cellpadding='0' cellspacing='0' style='margin:0; padding:9px; border:black 1px solid; font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>");
        // "<center><table width='348' cellpadding='4' cellspacing='4' style='border:black 1px solid;'><tr>"
        // +
        // "<td align='center'><table cellpadding='1' cellspacing='0' style='font-size:10px; font-family:Verdana, Arial, Helvetica, sans-serif; border-collapse:collapse;'>"
        // +
        htmlText.append("<tr><td style='font-size:9px;' colspan='2'>Id1&nbsp;: " + clientId + "<br/>Id2&nbsp;: " + id2 + "</td></tr><tr>"
                + "<td style='font-size:9px;' colspan='2'>&nbsp;</td></tr><tr><td style='font-size:9px;' align='center' colspan='2'>R&nbsp;U&nbsp;C&nbsp;&nbsp;20506035121"
                + "</td></tr><tr><td align='center' colspan='2'><img src='"
                + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim() + "/layer-view-image/client/" + imgGame + "'"
                + "width='" + imgW + "' height='" + imgH + "'border='0'/></td></tr><tr><td colspan='2'>&nbsp;</td></tr>"
                + "<tr><td style='font-size:9px;' align='center' colspan='2'>" + webAddress + "</td></tr>");
        if (apparea.equals("development"))
            htmlText.append("<tr><td style='font-size:16px;font-weight:bold;' align='center' colspan='2'>BOLETO DE PRUEBAS</td></tr>");
        else if (apparea.equals("production"))
            if (testusers != null && !testusers.equals("")) {
                String[] users = testusers.split(",");
                for (String user : users)
                    if (user.equals(clientId)) {
                        htmlText.append("<tr><td style='font-size:16px;font-weight:bold;' align='center' colspan='2'>BOLETO SIN VALOR</td></tr>");
                        break;
                    }
            }
        LoggerApi.Log.info("cid=" + p_clientTicket.getCtClientId() + " p_clientTicket.getCtTwDefinePrize()  :   ------------>    "
                + Integer.parseInt(p_clientTicket.getCtTwDefinePrize()));
        htmlText.append("<tr><td align='center' colspan='2'>" + ticketDate.substring(0, 10) + "&nbsp;&nbsp;&nbsp;&nbsp;&minus;&nbsp;&nbsp;&nbsp;&nbsp;"
                + ticketDate.substring(11) + "</td></tr>" + "<tr><td>" + p_clientTicket.getGameName() + "</td><td align='right'>" + editionId + "-" + bookId + "-" + numId
                + "</td></tr>" + separateline
                /*
                 * + "<tr><td style='font-size:11px;font-weight:bold;'>PREMIO OBTENIDO S/.&nbsp;</td><td style='font-size:13px;font-weight:bold;' align='right'>" + df.format(wonPrize) + "</td></tr>"
                 */
                + "<tr><td style='font-size:11px;font-weight:bold;'>&nbsp;</td><td style='font-size:13px;font-weight:bold;' align='right'>" + "&nbsp;</td></tr>"
                + "<tr><td style='font-size:11px;font-weight:bold;'>NETO A COBRAR S/.&nbsp;</td><td style='font-size:13px;font-weight:bold;' align='right'>"
                + df.format(netPrize) + "</td></tr>" + separateline);
        if (tip_coupon == 1)
            if (p_clientTicket.getCtTwDefinePrize() != null && Integer.parseInt(p_clientTicket.getCtTwDefinePrize()) == 2)
                htmlText.append("<tr><td align='center' colspan='2'>" + editionId + "-" + bookId + "-" + numId + vals + "&nbsp;&nbsp;&nbsp;&nbsp;" + 
                	       "<div style='font-size:4.1pt; line-height:4.1pt; font-family:Geneva, Arial, Helvetica, sans-serif; letter-spacing:-0.2px;'><pre>" + barCode
                	                + "</pre></div></td></tr>");
        /*
         * "<tr><td align='center' colspan='2'>"+bc+ "</td></tr><tr><td colspan='2'>&nbsp;</td></tr>"+
         */
        htmlText.append("</table>"
        		+ "<div style='width:328px;'>&nbsp;</div><div style='width:293px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'> "
                //+ "<div style='width:292px;'>&nbsp;</div><div style='width:293px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'><strong>Atenci&oacute;n:</strong> "
                +
                /*
                 * "Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el ticket impreso con el c&oacute;digo de barras. " +
                 * "No comparta esta informaci&oacute;n, ni la deje a la vista de otros.<br>" +
                 * "El derecho al cobro de los premios caduca a los ciento ochenta(180) d&iacute;as calendarion de la fecha de finalizaci&oacute;n de la venta de este juego, la cual ser&aacute; publicada por INTRALOT DE PER&Uacute; S.A., en un diario de circulaci&oacute;n nacional. "
                 * + "Puede cobrar el premio a partir del <strong>d&iacute;a siguiente</strong> a la compra del boleto." +
                 */
                "</div>");
        htmlText.append("</td></tr></table></center></body></html>");
        return htmlText;
    }

    @Override
    public StringBuffer findCouponClientTicketClicyGana(TicketProcedureGetClientTicket p_clientTicket) throws Exception {
        LoggerApi.Log.info("ctClientId=" + p_clientTicket.getCtClientId() + " ctBetMatrix1=" + p_clientTicket.getCtBetMatrix1());
        StringBuffer htmlText = new StringBuffer();
        DecimalFormat df = new DecimalFormat("###,##0.00");
        String imgGame = null;
        String imgW = null;
        String imgH = null;
        String webAddress = null;
        int gameNumber = 0;
        String gameName = ""; // String superGame = cp.getSuperGame();
        String crcV = "";
        String editionId = "";
        String bookId = "";
        String numId = "";
        String vals = "";
        String id2 = "";
        // Date saleDate = cp.getSaleDate();
        String ticketDate = "";// defaultDf.format(saleDate);
        double netPrize = 0.0;// = cp.getNetPrize();
        double wonPrize = 0.0;// = cp.getWonPrize();
        String ticketId = "";// cp.getTicketId();
        String clientId = "";// cp.getClientId();
        String ticketCode = "";// cp.getTicketCode();
        // String barCode = cp.getBarCode();
        if (p_clientTicket.getCtTicketId() != null)
            ticketId = p_clientTicket.getCtTicketId();
        if (p_clientTicket.getCtClientId() != null)
            clientId = p_clientTicket.getCtClientId();
        if (p_clientTicket.getCtTicketDate() != null)
            ticketDate = p_clientTicket.getCtTicketDate();
        if (p_clientTicket.getCtGameNumber() != 0)
            gameNumber = p_clientTicket.getCtGameNumber();
        if (p_clientTicket.getCtTicketNumber() != null)
            ticketCode = StringLib.decodeLabel(p_clientTicket.getCtTicketNumber());
        LoggerApi.Log.info("cid=" + p_clientTicket.getCtClientId() + " ticketCode=" + StringLib.cover(ticketCode)); 
        //LoggerApi.Log.info("cid=" + p_clientTicket.getCtClientId() + " ticketCode=" + ticketCode + " getCtTicketNumber()="+p_clientTicket.getCtTicketNumber() );
        if (p_clientTicket.getCrc_v() != null) {
            crcV = StringLib.padLeft(String.valueOf(p_clientTicket.getCrc_v()), '0', 4);
            editionId = ticketCode.substring(0, 3);
            bookId = ticketCode.substring(3, 10);
            numId = ticketCode.substring(10, 13);
            //vals = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + crcV;
            vals = "-"  + ticketCode.substring(13, 20) + "-" + ticketCode.substring(20, 22) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + crcV;
            id2 = p_clientTicket.getCtBetMatrix1();
        } else {
            editionId = ticketCode.substring(0, 3);
            bookId = ticketCode.substring(3, 9);
            numId = ticketCode.substring(9, 12);
            vals = "-" + ticketCode.substring(12, 22) + "&nbsp;" + ticketCode.substring(22, 26);
            id2 = editionId + "-" + bookId + "-" + numId;
        }
        Game game = new Game(gameNumber);
        gameName = game.getName();
        if (p_clientTicket.getInPrintedPrice() != null)
            wonPrize = p_clientTicket.getInPrintedPrice();
        if (p_clientTicket.getInPrintedPrice() != null)
            netPrize = p_clientTicket.getCtTwPrizeAmount();
        LoggerApi.Log.info("ticketCode=" + StringLib.cover(ticketCode));
        String barCode = ClientUtils.Interleaved2of5(ticketCode, null);
        // ***/
      //String context = "CARD-WEB";
        String context = Constants.contextCardWeb;
        //String bc = ClientUtils.Interleaved2of5(barCode, null);
        String apparea = String.valueOf(ConnectionFactory.operationProperty("applicationArea", context)).toString().trim();
        String testusers = String.valueOf(ConnectionFactory.operationProperty("testUsers", context)).toString().trim();
        imgGame = "imgClicygana.gif";
        imgW = "150";
        imgH = "113";
        webAddress = "www.clicygana.com.pe";
        // String separateline =
        // "<tr><td colspan='2' align='center'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>";
        //String separateline = "<tr><td colspan='2' align='center' style='font-size:9px;'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>";
        String separateline = "<tr><td colspan='2' align='center' style='font-size:9px;'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>";
        htmlText.append("<html><head><script type='text/javascript'>function oncontextmenuHandler(){return false;}"
                + "document.oncontextmenu = oncontextmenuHandler;function disableselect(e){return false;}"
                + "function reEnable(){return true;}document.onselectstart=new Function ('return false');"
                + "if (window.sidebar){document.onmousedown=disableselect;document.onclick=reEnable;}<\"+\"/script></head><body>");
        htmlText.append("<center><table width='100%' cellpadding='0' cellspacing='0' style='margin:0; padding:0; border:0;'>"
        		+ "<tr><td align='center'><table width='327' cellpadding='0' cellspacing='0' style='margin:0; padding:9px; border:black 1px solid; font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>");
                //+ "<tr><td align='center'><table width='292' cellpadding='0' cellspacing='0' style='margin:0; padding:9px; border:black 1px solid; font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>");
        // htmlText.append("<center><table width='348' cellpadding='4' cellspacing='4' style='border:black 1px solid;'><tr>"
        // +
        // "<td align='center'><table cellpadding='1' cellspacing='0' style='font-size:10px; font-family:Verdana, Arial, Helvetica, sans-serif; border-collapse:collapse;'>");
        htmlText.append("<tr><td style='font-size:9px;' colspan='2'>Id1&nbsp;: " + clientId + "<br/>Id2&nbsp;: " + id2 + "</td></tr><tr>"
                + "<td style='font-size:9px;' colspan='2'>&nbsp;</td></tr><tr><td style='font-size:9px;' align='center' colspan='2'>R&nbsp;U&nbsp;C&nbsp;&nbsp;20506035121"
                + "</td></tr><tr><td align='center' colspan='2'><img src='"
                + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim() + "/layer-view-image/client/" + imgGame + "'"
                + "width='" + imgW + "' height='" + imgH + "' border='0'/></td></tr><tr><td colspan='2'>&nbsp;</td></tr>"
                + "<tr><td style='font-size:9px;' align='center' colspan='2'>" + webAddress + "</td></tr>");
        if (apparea.equals("development"))
            htmlText.append("<tr><td style='font-size:16px;font-weight:bold;' align='center' colspan='2'>BOLETO DE PRUEBAS</td></tr>");
        else if (apparea.equals("production"))
            if (testusers != null && !testusers.equals("")) {
                String[] users = testusers.split(",");
                for (String user : users)
                    if (user.equals(clientId)) {
                        htmlText.append("<tr><td style='font-size:16px;font-weight:bold;' align='center' colspan='2'>BOLETO SIN VALOR</td></tr>");
                        break;
                    }
            }
        htmlText.append("<tr><td align='center' colspan='2'>" + ticketDate.substring(0, 10) + "&nbsp;&nbsp;&nbsp;&nbsp;&minus;&nbsp;&nbsp;&nbsp;&nbsp;"
                + ticketDate.substring(11) + "</td></tr>" + "<tr><td>" + p_clientTicket.getGameName() + "</td><td align='right'>" + editionId + "-" + bookId + "-" + numId
                + "</td></tr>" + separateline
                + "<tr><td style='font-size:11px;font-weight:bold;'>PREMIO OBTENIDO S/.&nbsp;</td><td style='font-size:13px;font-weight:bold;' align='right'>"
                + df.format(wonPrize) + "</td></tr>"
                + "<tr><td style='font-size:11px;font-weight:bold;'>NETO A COBRAR S/.&nbsp;</td><td style='font-size:13px;font-weight:bold;' align='right'>"
                + df.format(netPrize) + "</td></tr>" + separateline);
        // if(p_clientTicket.getCtTwDefinePrize() != null &&
        // Integer.parseInt(p_clientTicket.getCtTwDefinePrize()) == 2 )
        htmlText.append("<tr><td align='center' colspan='2'>" + editionId + "-" + bookId + "-" + numId + vals + "&nbsp;&nbsp;&nbsp;&nbsp;" + barCode + "</td></tr>");
        /*
         * "<tr><td align='center' colspan='2'>"+bc+ "</td></tr><tr><td colspan='2'>&nbsp;</td></tr>"+
         */
        htmlText.append("</table>"
        		+ "<div style='width:328px;'>&nbsp;</div><div style='width:293px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'> "
                //+ "<div style='width:292px;'>&nbsp;</div><div style='width:293px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'><strong>Atenci&oacute;n:</strong> "
                +
                /*
                 * "Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el ticket impreso con el c&oacute;digo de barras. " +
                 * "No comparta esta informaci&oacute;n, ni la deje a la vista de otros.<br>" +
                 * "El derecho al cobro de los premios caduca a los ciento ochenta(180) d&iacute;as calendarion de la fecha de finalizaci&oacute;n de la venta de este juego, la cual ser&aacute; publicada por INTRALOT DE PER&Uacute; S.A., en un diario de circulaci&oacute;n nacional. "
                 * + "Puede cobrar el premio a partir del <strong>d&iacute;a siguiente</strong> a la compra del boleto." +
                 */
                "</div>");
        htmlText.append("</td></tr></table></center></body></html>");
        return htmlText;
    }

    @Override
    public StringBuffer findCouponClientTicketDeportesVirtuales(TicketProcedureGetClientTicket p_clientTicket) throws Exception {
        LoggerApi.Log.info("ctClientId=" + p_clientTicket.getCtClientId() + " ctBetMatrix1=" + p_clientTicket.getCtBetMatrix1());
        StringBuffer htmlText = new StringBuffer();
        DecimalFormat df = new DecimalFormat("###,##0.00");
        String imgGame = null;
        String imgW = null;
        String imgH = null;
        String webAddress = null;
        int gameNumber = 0;
        String gameName = ""; // String superGame = cp.getSuperGame();
        String crcV = "";
        String editionId = "";
        String bookId = "";
        String numId = "";
        String vals = "";
        String id2 = "";
        // Date saleDate = cp.getSaleDate();
        String ticketDate = "";// defaultDf.format(saleDate);
        double netPrize = 0.0;// = cp.getNetPrize();
        double wonPrize = 0.0;// = cp.getWonPrize();
        String ticketId = "";// cp.getTicketId();
        String clientId = "";// cp.getClientId();
        String ticketCode = "";// cp.getTicketCode();
        // String barCode = cp.getBarCode();
        if (p_clientTicket.getCtTicketId() != null)
            ticketId = p_clientTicket.getCtTicketId();
        if (p_clientTicket.getCtClientId() != null)
            clientId = p_clientTicket.getCtClientId();
        if (p_clientTicket.getCtTicketDate() != null)
            ticketDate = p_clientTicket.getCtTicketDate();
        if (p_clientTicket.getCtGameNumber() != 0)
            gameNumber = p_clientTicket.getCtGameNumber();
        if (p_clientTicket.getCtTicketNumber() != null)
            ticketCode = StringLib.decodeLabel(p_clientTicket.getCtTicketNumber());
        LoggerApi.Log.info("cid=" + p_clientTicket.getCtClientId() + " ticketCode=" + StringLib.cover(ticketCode));
        if (p_clientTicket.getCrc_v() != null) {
            crcV = StringLib.padLeft(String.valueOf(p_clientTicket.getCrc_v()), '0', 4);
            editionId = ticketCode.substring(0, 3);
            bookId = ticketCode.substring(3, 10);
            numId = ticketCode.substring(10, 13);
            // vals = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + crcV;
            vals = "-"  + ticketCode.substring(13, 20) + "-" + ticketCode.substring(20, 22) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + crcV;
            id2 = p_clientTicket.getCtBetMatrix1();
        } else {
            editionId = ticketCode.substring(0, 3);
            bookId = ticketCode.substring(3, 9);
            numId = ticketCode.substring(9, 12);
            vals = "-" + ticketCode.substring(12, 22) + "&nbsp;" + ticketCode.substring(22, 26);
            id2 = editionId + "-" + bookId + "-" + numId;
        }
        Game game = new Game(gameNumber);
        gameName = game.getName();
        if (p_clientTicket.getInPrintedPrice() != null)
            wonPrize = p_clientTicket.getInPrintedPrice();
        if (p_clientTicket.getInPrintedPrice() != null)
            netPrize = p_clientTicket.getCtTwPrizeAmount();
        String barCode = ClientUtils.Interleaved2of5(ticketCode, null);
      //String context = "CARD-WEB";
        String context = Constants.contextCardWeb;
        String bc = ClientUtils.Interleaved2of5(barCode, null);
        String apparea = String.valueOf(ConnectionFactory.operationProperty("applicationArea", context)).toString().trim();
        String testusers = String.valueOf(ConnectionFactory.operationProperty("testUsers", context)).toString().trim();
        imgGame = "imgTeapuestoSl.png"; //"imgDeportesVirtuales.jpg";
        imgW = "137";
        imgH = "70";
        webAddress = "www.latinka.com.pe"; //"www.deportesvirtuales.com.pe";
        // String separateline =
        // "<tr><td colspan='2' align='center'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>";
        //String separateline = "<tr><td colspan='2' align='center' style='font-size:9px;'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>";
        String separateline = "<tr><td colspan='2' align='center' style='font-size:9px;'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>";
        htmlText.append("<html><head><script type='text/javascript'>function oncontextmenuHandler(){return false;}"
                + "document.oncontextmenu = oncontextmenuHandler;function disableselect(e){return false;}"
                + "function reEnable(){return true;}document.onselectstart=new Function ('return false');"
                + "if (window.sidebar){document.onmousedown=disableselect;document.onclick=reEnable;}<\"+\"/script></head><body>");
        htmlText.append("<center><table width='100%' cellpadding='0' cellspacing='0' style='margin:0; padding:0; border:0;'>"
        		+ "<tr><td align='center'><table width='327' cellpadding='0' cellspacing='0' style='margin:0; padding:9px; border:black 1px solid; font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>");
                //+ "<tr><td align='center'><table width='292' cellpadding='0' cellspacing='0' style='margin:0; padding:9px; border:black 1px solid; font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>");
        // htmlText.append("<center><table width='348' cellpadding='4' cellspacing='4' style='border:black 1px solid;'><tr>"
        // +
        // "<td align='center'><table cellpadding='1' cellspacing='0' style='font-size:10px; font-family:Verdana, Arial, Helvetica, sans-serif; border-collapse:collapse;'>");
        htmlText.append("<tr><td style='font-size:9px;' colspan='2'>Id1&nbsp;: " + clientId + "<br/>Id2&nbsp;: " + id2 + "</td></tr><tr>"
        		 /* Quitar logo de Intralot - Inicio - @jmoran 2019-05-28 */
                //+ "<tr><td colspan='2' align='center' style='padding:3px 0 0 0;'><img src='"
                //+ String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                //+ "/layer-view-image/client/imgIntralot.gif' width='74' height='22' border='0'/></td></tr>"
                //+ "<td style='font-size:9px;' colspan='2'>&nbsp;</td></tr><tr><td style='font-size:9px;' align='center' colspan='2'>R&nbsp;U&nbsp;C&nbsp;&nbsp;20506035121"
                //+ "</td></tr><tr><td align='center' colspan='2'><img src='"
        /* Mostrar logos de sorteos en UAT */
        /*
                + "<tr><td align='center' colspan='2'><img src='"
                + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim() + "/layer-view-image/client/" + imgGame + "' width='"
        */
        		+ "<tr><td align='center' colspan='2'><img src='layer-view-image/client/" + imgGame + "' width='"
                + imgW + "' height='" + imgH + "' border='0'/>"
                + "<img style='top:-15px;position:relative' src='layer-view-image/client/imgTinka.gif'"
                + "' width='146' height='36' border='0'/></td></tr><tr><td colspan='2'>&nbsp;</td></tr>" + "<tr><td style='font-size:9px;' align='center' colspan='2'>"
                //+ webAddress + "</td></tr>");
                + webAddress + "</td></tr>"
                + "<tr><td style='font-size:9px;' align='center' colspan='2'>Intralot del Per&uacute; S.A.&nbsp;&nbsp;RUC&nbsp;&nbsp;20506035121</td></tr>"); // cambio de posicion del RUC
        		/* Quitar logo de Intralot - Fin - @jmoran 2019-05-28 */
        if (apparea.equals("development"))
            htmlText.append("<tr><td style='font-size:16px;font-weight:bold;' align='center' colspan='2'>BOLETO DE PRUEBAS</td></tr>");
        else if (apparea.equals("production"))
            if (testusers != null && !testusers.equals("")) {
                String[] users = testusers.split(",");
                for (String user : users)
                    if (user.equals(clientId)) {
                        htmlText.append("<tr><td style='font-size:16px;font-weight:bold;' align='center' colspan='2'>BOLETO SIN VALOR</td></tr>");
                        break;
                    }
            }
        htmlText.append("<tr><td align='center' colspan='2'>" + ticketDate.substring(0, 10) + "&nbsp;&nbsp;&nbsp;&nbsp;&minus;&nbsp;&nbsp;&nbsp;&nbsp;"
                + ticketDate.substring(11) + "</td></tr>" + "<tr><td>" + p_clientTicket.getGameName() + "</td><td align='right'>" + editionId + "-" + bookId + "-" + numId
                + "</td></tr>" + separateline
                
                //+ "<tr><td align='left' colspan='2'>PAGO DE TICKET DE INSTANTANEA</td></tr>"
                
                + "<tr><td style='font-size:11px;font-weight:bold;'>PREMIO S/&nbsp;</td><td style='font-size:13px;font-weight:bold;' align='right'>"
                + df.format(wonPrize) + "</td></tr>"
                + "<tr><td style='font-size:11px;font-weight:bold;'>NETO A COBRAR S/&nbsp;</td><td style='font-size:13px;font-weight:bold;' align='right'>"
                + df.format(netPrize) + "</td></tr>" + separateline);
        // if(p_clientTicket.getCtTwDefinePrize() != null &&
        // Integer.parseInt(p_clientTicket.getCtTwDefinePrize()) == 2 )
        htmlText.append("<tr><td align='center' colspan='2'>" + editionId + "-" + bookId + "-" + numId + vals + "&nbsp;&nbsp;&nbsp;&nbsp;" + barCode + "</td></tr>");
        /*
         * "<tr><td align='center' colspan='2'>"+bc+ "</td></tr><tr><td colspan='2'>&nbsp;</td></tr>"+
         */
        htmlText.append("</table>"
                //+ "<div style='width:292px;'>&nbsp;</div><div style='width:293px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'><strong>Atenci&oacute;n:</strong> "
                + "<div style='width:328px;'>&nbsp;</div><div style='width:293px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'>"
                +
                /*
                 * "Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el ticket impreso con el c&oacute;digo de barras. " +
                 * "No comparta esta informaci&oacute;n, ni la deje a la vista de otros.<br>" +
                 * "El derecho al cobro de los premios caduca a los ciento ochenta(180) d&iacute;as calendarion de la fecha de finalizaci&oacute;n de la venta de este juego, la cual ser&aacute; publicada por INTRALOT DE PER&Uacute; S.A., en un diario de circulaci&oacute;n nacional. "
                 * + "Puede cobrar el premio a partir del <strong>d&iacute;a siguiente</strong> a la compra del boleto." +
                 */
                "</div>");
        htmlText.append("</td></tr></table></center></body></html>");
        return htmlText;
    }

    @Override
    public StringBuffer findCouponClientTicketElReventon(TicketProcedureGetClientTicket p_clientTicket, int tip_coupon) throws Exception {
        StringBuffer htmlText = new StringBuffer();
        String imgGame1 = null;
        String imgGame2 = null;
        String imgGame3 = null;
        String imgGame4 = null;
        String imgGame5 = null;
      //String context = "CARD-WEB";
        String context = Constants.contextCardWeb;
        String drawDate = p_clientTicket.getCtToDrawDate();
        // p_clientTicket.getCtTicketNumber()
        String ticketId = p_clientTicket.getCtTicketId();
        String clientId = p_clientTicket.getCtClientId();
        String ticketCode = ""; // = p_clientTicket.getCtTicketNumber();
        /***** aqui */
        if (p_clientTicket.getCtTicketNumber() != null)
            ticketCode = StringLib.decodeLabel(p_clientTicket.getCtTicketNumber());
        LoggerApi.Log.info("ticketCode=" + StringLib.cover(ticketCode));
        /*****/
        // ***aqui****/
        // p_clientTicket.get
        String barCode = ClientUtils.Interleaved2of5(ticketCode.substring(0, ticketCode.length() - 4), null);
        // ***/
        // String barCode = cp.getBarCode();
        // String bc = ClientUtils.Interleaved2of5(barCode.substring(0,barCode.length()-4),null);
        // p_clientTicket.getct
        String ruedas = p_clientTicket.getCtReceiptNr().toString();
        String elgordo = p_clientTicket.getCtBetMatrix1();
        String elgordoval = "";
        for (int i = 0; i < elgordo.length(); i++)
            if ((i + 1) % 10 == 0 && i != elgordo.length() - 1)
                elgordoval += elgordo.charAt(i) + "</div><div style='width:164px; height:14px; float:left;'><img src='"
                        + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                        + "/layer-view-image/game/reventon/coupon/reventon-printcard8.jpg' width='164' height='14' /></div>";
            else if (i % 2 == 0)
                elgordoval += "<div style='float:left; width:20px; height:16px; background-color:#91e9f3'>" + elgordo.charAt(i);
            else if (i == 21)
                elgordoval += elgordo.charAt(i) + "</div><div style='width:16px; height:16px; float:left;'><img src='"
                        + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                        + "/layer-view-image/game/reventon/coupon/reventon-printcard11.jpg' width='16' height='16' /></div>";
            else if (i == elgordo.length() - 1)
                elgordoval += elgordo.charAt(i) + "</div>";
            else
                elgordoval += elgordo.charAt(i) + "</div><div style='width:16px; height:16px; float:left;'><img src='"
                        + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                        + "/layer-view-image/game/reventon/coupon/reventon-printcard9.jpg' width='16' height='16' /></div>";
        String zodiaco = p_clientTicket.getCtBetMatrix2();
        int drawId = p_clientTicket.getCtDrawId(); // cp.getDrawId();
        Integer defineFlag = Integer.parseInt(p_clientTicket.getCtTwDefinePrize()); // cp.getDefineFlag();
        /*
         * int payFlag = cp.getPayFlag(); int prizeFlag = cp.getPrizeFlag();
         */
        if (drawId < 192) {
            if (drawId % 2 == 0) {
                imgGame1 = "reventon-printcard-par2.jpg";
                imgGame2 = "reventon-printcard-par3.jpg";
                imgGame3 = "reventon-printcard-par4.jpg";
                imgGame4 = "reventon-printcard-par6.jpg";
                imgGame5 = "reventon-printcard-par12.jpg";
            } else {
                imgGame1 = "reventon-printcard-impar2.jpg";
                imgGame2 = "reventon-printcard-impar3.jpg";
                imgGame3 = "reventon-printcard-impar4.jpg";
                imgGame4 = "reventon-printcard-impar6.jpg";
                imgGame5 = "reventon-printcard-impar12.jpg";
            }
            htmlText.append("<html><head><meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>"
                    + "<meta http-equiv='PRAGMA' content='NO-CACHE'><meta http-equiv='CACHE-CONTROL' content='NO-CACHE'>" +
                    /*
                     * "<style type='text/css'>html,body,div,span,applet,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,a,abbr,acronym,address,big,cite,code," +
                     * "del,dfn,em,font,img,ins,kbd,q,s,samp,small,strike,strong,sub,sup,tt,var,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,table,caption,tbody," +
                     * "tfoot,thead,tr,th,td{margin:0;padding:0;border:0;outline:0;font-weight:inherit;font-style:inherit;font-size:100%;font-family:inherit;" +
                     * "vertical-align:baseline;} :focus{outline:0;} body{line-height:1;color:black;background:white;font-family:Verdana,Arial,Helvetica,sans-serif;" +
                     * "} ol,ul{list-style:none;} table{border-collapse:separate; border-spacing:0;} caption,th,td{text-align:left;font-weight:normal;} " +
                     * "blockquote:before,blockquote:after,q:before,q:after{content:'';} blockquote,q{quotes:'' '';}</style>" +
                     */
                    "<style type='text/css'>*{margin:0;padding:0;border:0;outline:0;} body{line-height:1;font-family:Verdana,Arial,Helvetica,sans-serif;}</style>"
                    + "<script type='text/javascript'>function oncontextmenuHandler(){return false;}"
                    + "document.oncontextmenu = oncontextmenuHandler;function disableselect(e){return false;}"
                    + "function reEnable(){return true;}document.onselectstart=new Function ('return false');"
                    + "if (window.sidebar){document.onmousedown=disableselect;document.onclick=reEnable;}<\"+\"/script></head>" + "<body><center>"
                    + "<table width='344' height='730' cellpadding='0' cellspacing='0' style='border:black 1px solid; font-size:11px;'><tr><td>"
                    + "<div style='width:344px; height:665px;'>" + "<div style='width:344px; height:40px;'>"
                    + "<div style='float:left; width:72px; height:30px; font-size:9px; padding:10px 0 0 0;'>Id1&nbsp;: "
                    + clientId
                    + "<br/>Id2&nbsp;: "
                    + ticketId
                    + "</div>"
                    + "<div style='width:156px; height:40px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/client/reventon/coupon/reventon-printcard1a.jpg' width='156' height='40'/></div>"
                    + "<div style='width:116px; height:40px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/reventon-printcard1b.jpg' width='116' height='40' /></div>"
                    + "</div>"
                    + "<div style='width:344px; height:107px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/reventon-printcard1c.jpg' width='344' height='107' /></div>"
                    + "<div style='width:344px; height:14px;'>"
                    + "<div style='width:124px; height:14px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/"
                    + imgGame1
                    + "' width='124' height='14' /></div>"
                    + "<div style='float:left; width:220px; height:14px; background-color:#e3f4fc;'>Sorteo N&deg; "
                    + drawId
                    + ": "
                    + drawDate.substring(0, 10)
                    + "</div>"
                    + "</div>"
                    + "<div style='width:344px; height:14px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/"
                    + imgGame2
                    + "' width='344' height='14' /></div>"
                    + "<div style='width:344px; height:26px;'>"
                    + "<div style='width:260px; height:26px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/"
                    + imgGame3
                    + "' width='260' height='26' /></div>"
                    + "<div style='float:left; width:68px; height:26px; background-color:#82d1ef; text-align:center;'><span style='font-size:9px;'>Nro de Boleto</span><br/><span style='font-size:11px; font-weight:bold;'>"
                    + ruedas.substring(0, 10)
                    + "</span></div>"
                    + "<div style='width:16px; height:26px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/reventon-printcard5.jpg' width='16' height='26' /></div>"
                    + "</div>"
                    + "<div style='width:344px; height:209px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/"
                    + imgGame4
                    + "' width='344' height='209' /></div>"
                    + "<div style='width:344px; height:76px;'>"
                    + "<div style='width:144px; height:76px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/reventon-printcard7.jpg' width='144' height='76' /></div>"
                    + "<div style='float:left; width:164px; height:76px; font-size:12px; font-weight:bold;'>"
                    + elgordoval
                    + "</div>"
                    + "<div style='width:36px; height:76px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/gameg/reventon/coupon/reventon-printcard10.jpg' width='36' height='76' /></div>"
                    + "</div>"
                    + "<div style='width:344px; height:62px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/"
                    + imgGame5
                    + "' width='344' height='62' /></div>"
                    + "<div style='width:344px; height:74px;'>"
                    + "<div style='width:235px; height:74px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/reventon-printcard13.jpg' width='235' height='74' /></div>"
                    + "<div style='width:77px; height:74px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/sign/reventon-button-sign-"
                    + zodiaco
                    + ".gif' width='77' height='74' /></div>"
                    + "<div style='width:32px; height:74px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/reventon-printcard14.jpg' width='32' height='74' /></div>"
                    + "</div>"
                    + "<div style='width:344px; height:14px;'>"
                    + "<div style='width:40px; height:14px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/reventon-printcard15.jpg' width='40' height='14' /></div>"
                    + "<div style='float:left; width:140px; height:14px; font-size:9px; background-color:#e3f4fc; text-align:center;'>Nro&nbsp;de&nbsp;Boleto&nbsp;"
                    + ruedas
                    + "</div>"
                    + "<div style='width:164px; height:14px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/reventon-printcard16.jpg' width='164' height='14' /></div>"
                    + "</div>"
                    + "<div style='width:344px; height:29px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/reventon-printcard17.jpg' width='344' height='29' /></div>" + "</div>");
        } else if (drawId >= 192) {
            if (drawId % 2 == 0) {
                imgGame1 = "reventon192-printcard-par2.jpg";
                imgGame2 = "reventon192-printcard-par3.jpg";
                imgGame3 = "reventon192-printcard-par4.jpg";
                imgGame4 = "reventon192-printcard-par6.jpg";
                imgGame5 = "reventon192-printcard-par12.jpg";
            } else {
                imgGame1 = "reventon192-printcard-impar2.jpg";
                imgGame2 = "reventon192-printcard-impar3.jpg";
                imgGame3 = "reventon192-printcard-impar4.jpg";
                imgGame4 = "reventon192-printcard-impar6.jpg";
                imgGame5 = "reventon192-printcard-impar12.jpg";
            }
            htmlText.append("<html><head><meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>"
                    + "<meta http-equiv='PRAGMA' content='NO-CACHE'><meta http-equiv='CACHE-CONTROL' content='NO-CACHE'>" +
                    /*
                     * "<style type='text/css'>html,body,div,span,applet,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,a,abbr,acronym,address,big,cite,code," +
                     * "del,dfn,em,font,img,ins,kbd,q,s,samp,small,strike,strong,sub,sup,tt,var,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,table,caption,tbody," +
                     * "tfoot,thead,tr,th,td{margin:0;padding:0;border:0;outline:0;font-weight:inherit;font-style:inherit;font-size:100%;font-family:inherit;" +
                     * "vertical-align:baseline;} :focus{outline:0;} body{line-height:1;color:black;background:white;font-family:Verdana,Arial,Helvetica,sans-serif;" +
                     * "} ol,ul{list-style:none;} table{border-collapse:separate; border-spacing:0;} caption,th,td{text-align:left;font-weight:normal;} " +
                     * "blockquote:before,blockquote:after,q:before,q:after{content:'';} blockquote,q{quotes:'' '';}</style>" +
                     */
                    "<style type='text/css'>*{margin:0;padding:0;border:0;outline:0;} body{line-height:1;font-family:Verdana,Arial,Helvetica,sans-serif;}</style>"
                    + "<script type='text/javascript'>function oncontextmenuHandler(){return false;}"
                    + "document.oncontextmenu = oncontextmenuHandler;function disableselect(e){return false;}"
                    + "function reEnable(){return true;}document.onselectstart=new Function ('return false');"
                    + "if (window.sidebar){document.onmousedown=disableselect;document.onclick=reEnable;}<\"+\"/script></head>" + "<body><center>"
                    + "<table width='344' height='730' cellpadding='0' cellspacing='0' style='border:black 1px solid; font-size:11px;'><tr><td>"
                    + "<div style='width:344px; height:665px;'>" + "<div style='width:344px; height:40px;'>"
                    + "<div style='height:30px; font-size:9px; padding:10px 0 0 0;'>Id1&nbsp;: "
                    + clientId
                    + "<br/>Id2&nbsp;: "
                    + ticketId
                    + "</div>"
                    + "<div style='width:156px; height:40px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/reventon-printcard1a.jpg' width='156' height='40' /></div>"
                    + "<div style='width:116px; height:40px; float:right;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/reventon-printcard1b.jpg' width='116' height='40' /></div>"
                    + "</div>"
                    + "<div style='width:344px; height:107px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/reventon-printcard1c.jpg' width='344' height='107' /></div>"
                    + "<div style='width:344px; height:14px;'>"
                    + "<div style='width:124px; height:14px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/"
                    + imgGame1
                    + "' width='124' height='14' /></div>"
                    + "<div style='float:left; width:220px; height:14px; background-color:#e3f4fc;'>Sorteo N&deg; "
                    + drawId
                    + ": "
                    + drawDate.substring(0, 10)
                    + "</div>"
                    + "</div>"
                    + "<div style='width:344px; height:14px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/"
                    + imgGame2
                    + "' width='344' height='14' /></div>"
                    + "<div style='width:344px; height:26px;'>"
                    + "<div style='width:260px; height:26px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/"
                    + imgGame3
                    + "' width='260' height='26' /></div>"
                    + "<div style='float:left; width:68px; height:26px; background-color:#c7b3d6; text-align:center;'><span style='font-size:9px;'>Nro de Boleto</span><br/><span style='font-size:11px; font-weight:bold;'>"
                    + ruedas
                    + "</span></div>"
                    + "<div style='width:16px; height:26px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/reventon192-printcard5.jpg' width='16' height='26' /></div>"
                    + "</div>"
                    + "<div style='width:344px; height:209px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/"
                    + imgGame4
                    + "' width='344' height='209' /></div>"
                    + "<div style='width:344px; height:76px;'>"
                    + "<div style='width:144px; height:76px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/reventon192-printcard7.jpg' width='144' height='76' /></div>"
                    + "<div style='float:left; width:164px; height:76px; font-size:12px; font-weight:bold;'>"
                    + elgordoval
                    + "</div>"
                    + "<div style='width:36px; height:76px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/reventon192-printcard10.jpg' width='36' height='76' /></div>"
                    + "</div>"
                    + "<div style='width:344px; height:62px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/"
                    + imgGame5
                    + "' width='344' height='62' /></div>"
                    + "<div style='width:344px; height:74px;'>"
                    + "<div style='width:235px; height:74px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/reventon192-printcard13.jpg' width='235' height='74' /></div>"
                    + "<div style='width:77px; height:74px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/sign/reventon-button-sign-"
                    + zodiaco
                    + ".gif' width='77' height='74' /></div>"
                    + "<div style='width:32px; height:74px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/reventon192-printcard14.jpg' width='32' height='74' /></div>"
                    + "</div>"
                    + "<div style='width:344px; height:14px;'>"
                    + "<div style='width:40px; height:14px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/reventon192-printcard15.jpg' width='40' height='14' /></div>"
                    + "<div style='float:left; width:140px; height:14px; font-size:9px; background-color:#e3f4fc; text-align:center;'>Nro&nbsp;de&nbsp;Boleto&nbsp;"
                    + ruedas
                    + "</div>"
                    + "<div style='width:164px; height:14px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/reventon192-printcard16.jpg' width='164' height='14' /></div>"
                    + "</div>"
                    + "<div style='width:344px; height:29px; float:left;'><img src='"
                    + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                    + "/layer-view-image/game/reventon/coupon/reventon192-printcard17.jpg' width='344' height='29' /></div>" + "</div>");
        }
        // htmlText.append("<div style='width:344px; height:55px; padding:10px 0 0 0; text-align:center; margin-top:40px'>"+ticketCode+"<br/>"+barCode+"</div>");
        // if(prizeFlag == 1 && defineFlag == 2 && payFlag == 0)
        if (tip_coupon == 1) {
            if (defineFlag != null && defineFlag == 2)
                htmlText.append("<div style='width:344px; height:55px; text-align:center; margin-top:40px'>" + ticketCode.substring(0, 3) + "-" + ticketCode.substring(3, 10)
                        + "-" + ticketCode.substring(10, 13) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + ticketCode.substring(22, 26) + "<br/>" + barCode
                        + "</div>");
        } else
            htmlText.append("<div style='width:344px; height:65px;'></div>");
        htmlText.append("</td></tr></table><div style='width:350px; font-size:9px; text-align:justify; padding:10px 0 0 0;'> ");
        // if(prizeFlag == 1 && defineFlag == 2 && payFlag == 0)
        //System.out.println("defineFlag:  " + defineFlag);
        if (defineFlag != null && defineFlag == 2) {}
           // htmlText.append("Los premios est&aacute;n sujetos a los impuestos y retenciones de Ley (10%), excepto los premios menores o iguales a S/. 20.00. Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el boleto impreso con el c&oacute;digo de barras. No compartas esta informaci&oacute;n, ni la dejes a la vista de otros.");
        /*
         * htmlText.append("Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el ticket impreso con el c&oacute;digo de barras. " +
         * "No comparta esta informaci&oacute;n, ni la deje a la vista de otros.");
         */
        else
            htmlText.append("Si su boleto obtiene premio y decide cobrarlo en efectivo, deber&aacute; reimprimir el boleto en donde figura el c&oacute;digo de barras y mostrarlo a la promotora en un punto de venta para cobrar su premio en efectivo.");
        htmlText.append("</div></center></body></html>");
        return htmlText;
    }

   	@Override
   	public StringBuffer findCouponClientTicketRetail(TicketProcedureGetClientTicketRetail p_clientTicket,
   			int tip_coupon, ClientProcedureGetDetail clientDetail) throws Exception {
   		LoggerApi.Log.info("p_clientTicket=" + p_clientTicket + " tip_coupon=" + tip_coupon + " p_dni="+clientDetail.getClDocNumber());
   		StringBuffer htmlText = new StringBuffer();
   		String context = Constants.contextCardWeb;

   		try {
   			String[] betMatrix1 = null;
   			String[] betMatrix2 = null;
   			String[] betMatrix3 = null;
   			String[] betMatrix4 = null;
   			int bet1 = 0;
   			int bet2 = 0;
   			int bet3 = 0;
   			int bet4 = 0;
   			String matrix1 = "";
   			String matrix2 = "";
   			String matrix3 = "";
   			String matrix4 = "";
   			String ticketId = "";
   			String docType = "";
   			String docNumber = "";
   			String clName = "";
   			String clientId = "";
   			String trnsNum = "0";
   			int fromDraw = 0;
   			String fromDrawDay = "";
   			int gameNumber = 0;
   			int numColumns = 0;
   			Double receiptAmount = 0.0;
   			int receiptNr = 0;
   			String ticketDate = "";
   			String ticketNumber = "";
   			/**** aqui */
   			int toDraw = 0;
   			int consecutive = 0;
   			String trmId = "0";
   			String gameName = "";// p_clientTicket.getGame().getName();
   			int betMultiA = 0;
   			int bet3ExactA = 0;
   			int bet3AnyA = 0;
   			int bet2ExactA = 0;
   			int bet1ExactA = 0;
   			int betMultiB = 0;
   			int bet3ExactB = 0;
   			int bet3AnyB = 0;
   			int bet2ExactB = 0;
   			int bet1ExactB = 0;
   			String saleType = null;
   			String imgGame = null;
   			String imgW = null;
   			String imgH = null;
   			String charity = null;
   			String webAddress = null;
   			String bm1 = "";
   			String mbm1 = "";
   			String bm2 = "";
   			String mbm2 = "";
   			String bm3 = "";
   			String mbm3 = "";
   			String bm4 = "";
   			String mbm4 = "";
   			String tn = "";// **aqui///
   			String solved = "";
   			int total = 0;
   			int betMax = 0;
   			// Add-Ons
   			String addOn1 = "";
   			String addOn2 = "";
   			String addOn3 = "";
   			String addOn4 = "";
               boolean flagPlus = Boolean.valueOf(ConnectionFactory.operationProperty("kabalaPlusEnabled", Constants.contextCardWeb).trim()).booleanValue();
           	boolean flagChauChamba = Boolean.valueOf(ConnectionFactory.operationProperty("kabalaChauChambaEnabled", Constants.contextCardWeb).trim()).booleanValue();
   			if (p_clientTicket.getCtBetMatrix1() != null)
   				matrix1 = p_clientTicket.getCtBetMatrix1();
   			if (p_clientTicket.getCtBetMatrix2() != null)
   				matrix2 = p_clientTicket.getCtBetMatrix2();
   			if (p_clientTicket.getCtBetMatrix3() != null)
   				matrix3 = p_clientTicket.getCtBetMatrix3();
   			if (p_clientTicket.getCtBetMatrix4() != null)
   				matrix4 = p_clientTicket.getCtBetMatrix4();
   			if (matrix1 != null && !matrix1.equals(""))
   				betMatrix1 = matrix1.split(" ");
   			if (matrix2 != null && !matrix2.equals(""))
   				betMatrix2 = matrix2.split(" ");
   			if (matrix3 != null && !matrix3.equals(""))
   				betMatrix3 = matrix3.split(" ");
   			if (matrix4 != null && !matrix4.equals(""))
   				betMatrix4 = matrix4.split(" ");
   			if (p_clientTicket.getCtTicketId() != null)
   				ticketId = p_clientTicket.getCtTicketId();
   			
   			if (clientDetail.getClDocType() != null)
   				docType = clientDetail.getClDocType();
   			if (clientDetail.getClDocNumber() != null)
   				docNumber = clientDetail.getClDocNumber();
   			if (clientDetail.getClName() != null)
   				clName = clientDetail.getClName();
   			
   			if (p_clientTicket.getCtClientId() != null)
   				clientId = p_clientTicket.getCtClientId();
   			if (p_clientTicket.getCtTrnsNum() != null)
   				trnsNum = p_clientTicket.getCtTrnsNum();
   			 LoggerApi.Log.info("trnsNum=" + p_clientTicket.getCtTrnsNum());
   			if (p_clientTicket.getCtFromDraw() != null)
   				 LoggerApi.Log.info("fromDraw=" + p_clientTicket.getCtFromDraw());
   				fromDraw = p_clientTicket.getCtFromDraw();
   			if (p_clientTicket.getFromDrawDay() != null)
   				LoggerApi.Log.info("fromDrawDay=" + p_clientTicket.getFromDrawDay());
   				fromDrawDay = p_clientTicket.getFromDrawDay();
   			if (p_clientTicket.getCtGameNumber() != 0)
   				gameNumber = p_clientTicket.getCtGameNumber();
   			if (p_clientTicket.getCtNumColumns() != null)
   				numColumns = p_clientTicket.getCtNumColumns();
   			if (p_clientTicket.getCtReceiptAmount() != null)
   				receiptAmount = p_clientTicket.getCtReceiptAmount();
   			/*if (p_clientTicket.getCtReceiptDiscounted() != null)
   				receiptDiscounted = p_clientTicket.getCtReceiptDiscounted();*/
   			if (p_clientTicket.getCtReceiptNr() != null)
   				receiptNr = p_clientTicket.getCtReceiptNr();
   			if (p_clientTicket.getCtTicketDate() != null)
   				ticketDate = p_clientTicket.getCtTicketDate();
   			/***** aqui */
   			if (p_clientTicket.getCtTicketNumber() != null) {
   				ticketNumber = p_clientTicket.getCtTicketNumber();				
   			}
   			/******/
   			if (p_clientTicket.getCtToDraw() != null)
   				toDraw = p_clientTicket.getCtToDraw();
   			if (p_clientTicket.getCtTrmId() != null)
   				 LoggerApi.Log.info("trmId=" + p_clientTicket.getCtTrmId());
   				trmId = p_clientTicket.getCtTrmId();
   			/*if (p_clientTicket.getCtBetMultiA() != null)
   				betMultiA = p_clientTicket.getCtBetMultiA();
   			if (p_clientTicket.getCtBet3exactA() != null)
   				bet3ExactA = p_clientTicket.getCtBet3exactA();
   			if (p_clientTicket.getCtBet3anyA() != null)
   				bet3AnyA = p_clientTicket.getCtBet3anyA();
   			if (p_clientTicket.getCtBet2exactA() != null)
   				bet2ExactA = p_clientTicket.getCtBet2exactA();
   			if (p_clientTicket.getCtBet1exactA() != null)
   				bet1ExactA = p_clientTicket.getCtBet1exactA();
   			if (p_clientTicket.getCtBetMultiB() != null)
   				betMultiB = p_clientTicket.getCtBetMultiB();
   			if (p_clientTicket.getCtBet3exactB() != null)
   				bet3ExactB = p_clientTicket.getCtBet3exactB();
   			if (p_clientTicket.getCtBet3anyB() != null)
   				bet3AnyB = p_clientTicket.getCtBet3anyB();
   			if (p_clientTicket.getCtBet2exactB() != null)
   				bet2ExactB = p_clientTicket.getCtBet2exactB();
   			if (p_clientTicket.getCtBet1exactB() != null)
   				bet1ExactB = p_clientTicket.getCtBet1exactB();*/
   			// Add-Ons
   			/*if (p_clientTicket.getCtAddOn1() != null) {
   				addOn1 = p_clientTicket.getCtAddOn1().trim();
   				if (addOn1.equals("8")) {
   					addOn1 = "0-8";
   				} else if (addOn1.equals("915")) {
   					addOn1 = "9-15";
   				} else if (addOn1.equals("1620")) {
   					addOn1 = "16-20";
   				} else if (addOn1.equals("2125")) {
   					addOn1 = "21-25";
   				} else if (addOn1.equals("2630")) {
   					addOn1 = "26-30";
   				} else if (addOn1.equals("3135")) {
   					addOn1 = "31-35";
   				} else if (addOn1.equals("3640")) {
   					addOn1 = "36-40";
   				} else if (addOn1.equals("4143")) {
   					addOn1 = "41- 43";
   				} else if (addOn1.equals("4445")) {
   					addOn1 = "44-46";
   				} else if (addOn1.equals("47")) {
   					addOn1 = "47-a mas";
   				}
   			}

   			if (p_clientTicket.getCtAddOn2() != null) {
   				addOn2 = p_clientTicket.getCtAddOn2().trim();
   				if (addOn2.equals("8")) {
   					addOn2 = "0-8";
   				} else if (addOn2.equals("915")) {
   					addOn2 = "9-15";
   				} else if (addOn2.equals("1620")) {
   					addOn2 = "16-20";
   				} else if (addOn2.equals("2125")) {
   					addOn2 = "21-25";
   				} else if (addOn2.equals("2630")) {
   					addOn2 = "26-30";
   				} else if (addOn2.equals("3135")) {
   					addOn2 = "31-35";
   				} else if (addOn2.equals("3640")) {
   					addOn2 = "36-40";
   				} else if (addOn2.equals("4143")) {
   					addOn2 = "41- 43";
   				} else if (addOn2.equals("4445")) {
   					addOn2 = "44-46";
   				} else if (addOn2.equals("47")) {
   					addOn2 = "47-a mas";
   				}
   			}
   			if (p_clientTicket.getCtAddOn3() != null) {
   				addOn3 = p_clientTicket.getCtAddOn3().trim();
   				if (addOn3.equals("8")) {
   					addOn3 = "0-8";
   				} else if (addOn3.equals("915")){
   					addOn3 = "9-15";
   				} else if (addOn3.equals("1620")){
   					addOn3 = "16-20";
   				} else if (addOn3.equals("2125")){
   					addOn3 = "21-25";
   				} else if (addOn3.equals("2630")) {
   					addOn3 = "26-30";
   				} else if (addOn3.equals("3135")) {
   					addOn3 = "31-35";
   				} else if (addOn3.equals("3640")){
   					addOn3 = "36-40";
   				} else if (addOn3.equals( "4143")) {
   					addOn3 = "41- 43";
   				} else if (addOn3.equals("4445")) {
   					addOn3 = "44-46";
   				} else if (addOn3.equals("47")) {
   					addOn3 = "47-a mas";
   				}
   			}
   			if (p_clientTicket.getCtAddOn4() != null) {
   				addOn4 = p_clientTicket.getCtAddOn4().trim();
   				if (addOn4.equals("8")){
   					addOn4 = "0-8";
   				} else if (addOn4.equals("915")){
   					addOn4 = "9-15";
   				} else if (addOn4.equals("1620")){
   					addOn4 = "16-20";
   				} else if (addOn4.equals("2125")){
   					addOn4 = "21-25";
   				} else if (addOn4.equals("2630")){
   					addOn4 = "26-30";
   				} else if (addOn4.equals("3135")){
   					addOn4 = "31-35";
   				} else if (addOn4.equals("3640")){
   					addOn4 = "36-40";
   				} else if (addOn4.equals("4143")) {
   					addOn4 = "41- 43";
   				} else if (addOn4.equals("4445")) {
   					addOn4 = "44-46";
   				} else if (addOn4.equals("47")) {
   					addOn4 = "47-a mas";
   				}
   			}*/

   			Game game = new Game(gameNumber);
   			gameName = game.getName();
   			LoggerApi.Log.info("################## AD-ON ####################");
   			LoggerApi.Log.info("addOn1 -> " + addOn1);
   			LoggerApi.Log.info("addOn2 -> " + addOn2);
   			LoggerApi.Log.info("addOn3 -> " + addOn3);
   			LoggerApi.Log.info("addOn4 -> " + addOn4);
   			LoggerApi.Log.info("################## MATRIX ####################");
   			LoggerApi.Log.info("matrix1 -> " + matrix1);
   			LoggerApi.Log.info("matrix2 -> " + matrix2);
   			LoggerApi.Log.info("matrix3 -> " + matrix3);
   			LoggerApi.Log.info("matrix4 -> " + matrix4);
   			//String barcode = ClientUtils.Interleaved2of5(ticketNumber, null);
   			/*if (p_clientTicket.getCrc_v() != null) {
   				// crc_v
   				crc_v = String.valueOf(p_clientTicket.getCrc_v()).trim();
   				if (crc_v.length() == 1)
   					crc_v = "0000" + crc_v;
   				else if (crc_v.length() == 2)
   					crc_v = "000" + crc_v;
   				else if (crc_v.length() == 3)
   					crc_v = "00" + crc_v;
   				else if (crc_v.length() == 4)
   					crc_v = "0" + crc_v;
   			} else
   				crc_v = " ";*/
   			if (betMatrix1 != null) {
   				bet1 = betMatrix1.length;
   				if (gameNumber == Game.GANAGOL)
   					for (int i = 0; i < bet1; i++) {
   						String betM1 = "";
   						for (int j = 0; j < betMatrix1[i].length(); j++) {
   							char betM = betMatrix1[i].charAt(j);
   							if (betMatrix1[i].length() == 1) {
   								if (j == 0 && betM == 'L')
   									betM1 += betM + "&ndash;&ndash;";
   								if (j == 0 && betM == 'E')
   									betM1 += "&ndash;" + betM + "&ndash;";
   								if (j == 0 && betM == 'V')
   									betM1 += "&ndash;&ndash;" + betM;
   							} else if (betMatrix1[i].length() == 2) {
   								if (j == 0 && betM == 'L')
   									betM1 += betM;
   								if (j == 0 && betM == 'E')
   									betM1 += "&ndash;" + betM;
   								if (j == 1 && betM == 'E')
   									betM1 += betM + "&ndash;";
   								if (j == 1 && betM == 'V')
   									if (betM1.equals("L"))
   										betM1 += "&ndash;" + betM;
   									else if (!betM1.equals("L"))
   										betM1 += betM;
   							} else if (betMatrix1[i].length() == 3)
   								betM1 += betM;
   						}
   						bm1 += betM1 + "<br/>";
   					}
   				else if (gameNumber == Game.SUPER3) {
   					for (int i = 0; i < bet1; i++)
   						if ((i + 1) % 6 == 0 && i + 1 != bet1)
   							bm1 += "&nbsp;&nbsp;&nbsp;" + betMatrix1[i] + "<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
   						else
   							bm1 += "&nbsp;&nbsp;&nbsp;" + betMatrix1[i];
   				} else if (gameNumber == Game.MEGATINKA) {
   					boolean flag1 = false;
   					for (int i = 0; i < bet1; i++)
   						if (NumberUtils.isNumber(betMatrix1[i])) {
   							if (flag1)
   								mbm1 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix1[i], 2, "0");
   							else if (i > 0 && i % 9 == 0)
                                   bm1 += "&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix1[i], 2, "0");
   							else
   								bm1 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix1[i], 2, "0");
   						} else if (!betMatrix1[i].equals(""))
   							flag1 = true;
   				} else if (gameNumber == Game.KABALA) {
   					if (!flagPlus && flagChauChamba) {
                   		if (addOn1.contains("1")) matrix1 += " " + "AD1";
                   		if (addOn1.contains("2")||addOn1.contains("4")) matrix1 += " " + "CC";
   					} else {
                   		if (addOn1.contains("1")) matrix1 += " " + "AD1";
                   		if (addOn1.contains("2")) matrix1 += " " + "AD2";
   					}
   					betMatrix1 = matrix1.split(" ");
   					for (int i = 0; i < betMatrix1.length; i++)
   						if (i > 0 && i % 9 == 0)
                               bm1 += "&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix1[i], 2, "0");
   						else
   							bm1 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix1[i], 2, "0");
   					LoggerApi.Log.info("################# KABALA ################");
   					LoggerApi.Log.info("bm1 -> " + bm1);
   				} else
   					for (int i = 0; i < bet1; i++)
   						if (i > 0 && i % 9 == 0)
                               bm1 += "&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix1[i], 2, "0");
   						else
   							bm1 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix1[i], 2, "0");
   			}
   			if (betMatrix2 != null) {
   				bet2 = betMatrix2.length;
   				if (gameNumber == Game.GANAGOL)
   					for (int i = 0; i < bet2; i++) {
   						String betM2 = "";
   						for (int j = 0; j < betMatrix2[i].length(); j++) {
   							char betM = betMatrix2[i].charAt(j);
   							if (betMatrix2[i].length() == 1) {
   								if (j == 0 && betM == 'L')
   									betM2 += betM + "&ndash;&ndash;";
   								if (j == 0 && betM == 'E')
   									betM2 += "&ndash;" + betM + "&ndash;";
   								if (j == 0 && betM == 'V')
   									betM2 += "&ndash;&ndash;" + betM;
   							} else if (betMatrix2[i].length() == 2) {
   								if (j == 0 && betM == 'L')
   									betM2 += betM;
   								if (j == 0 && betM == 'E')
   									betM2 += "&ndash;" + betM;
   								if (j == 1 && betM == 'E')
   									betM2 += betM + "&ndash;";
   								if (j == 1 && betM == 'V')
   									if (betM2.equals("L"))
   										betM2 += "&ndash;" + betM;
   									else if (!betM2.equals("L"))
   										betM2 += betM;
   							} else if (betMatrix2[i].length() == 3)
   								betM2 += betM;
   						}
   						bm2 += betM2 + "<br/>";
   					}
   				else if (gameNumber == Game.SUPER3) {
   					for (int i = 0; i < bet2; i++)
   						if ((i + 1) % 6 == 0 && i + 1 != bet2)
   							bm2 += "&nbsp;&nbsp;&nbsp;" + betMatrix2[i] + "<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
   						else
   							bm2 += "&nbsp;&nbsp;&nbsp;" + betMatrix2[i];
   				} else if (gameNumber == Game.MEGATINKA) {
   					boolean flag2 = false;
   					for (int i = 0; i < bet2; i++)
   						if (NumberUtils.isNumber(betMatrix2[i])) {
   							if (flag2)
   								mbm2 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix2[i], 2, "0");
   							else if (i > 0 && i % 9 == 0)
                                   bm2 += "&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix2[i], 2, "0");
   							else
   								bm2 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix2[i], 2, "0");
   						} else if (!betMatrix2[i].equals(""))
   							flag2 = true;
   				} else if (gameNumber == Game.KABALA) {
   					if (!flagPlus && flagChauChamba) {
                   		if (addOn2.contains("1")) matrix2 += " " + "AD1";
                   		if (addOn2.contains("2")||addOn2.contains("4")) matrix2 += " " + "CC";
   					} else {
                   		if (addOn2.contains("1")) matrix2 += " " + "AD1";
                   		if (addOn2.contains("2")) matrix2 += " " + "AD2";
   					}
   					betMatrix2 = matrix2.split(" ");
   					for (int i = 0; i < betMatrix2.length; i++)
   						if (i > 0 && i % 9 == 0)
                               bm2 += "&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix2[i], 2, "0");
   						else
   							bm2 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix2[i], 2, "0");
   				} else
   					for (int i = 0; i < bet2; i++)
   						if (i > 0 && i % 9 == 0)
                               bm2 += "&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix2[i], 2, "0");
   						else
   							bm2 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix2[i], 2, "0");
   			}
   			if (betMatrix3 != null) {
   				bet3 = betMatrix3.length;
   				if (gameNumber == Game.GANAGOL)
   					for (int i = 0; i < bet3; i++) {
   						String betM3 = "";
   						for (int j = 0; j < betMatrix3[i].length(); j++) {
   							char betM = betMatrix3[i].charAt(j);
   							if (betMatrix3[i].length() == 1) {
   								if (j == 0 && betM == 'L')
   									betM3 += betM + "&ndash;&ndash;";
   								if (j == 0 && betM == 'E')
   									betM3 += "&ndash;" + betM + "&ndash;";
   								if (j == 0 && betM == 'V')
   									betM3 += "&ndash;&ndash;" + betM;
   							} else if (betMatrix3[i].length() == 2) {
   								if (j == 0 && betM == 'L')
   									betM3 += betM;
   								if (j == 0 && betM == 'E')
   									betM3 += "&ndash;" + betM;
   								if (j == 1 && betM == 'E')
   									betM3 += betM + "&ndash;";
   								if (j == 1 && betM == 'V')
   									if (betM3.equals("L"))
   										betM3 += "&ndash;" + betM;
   									else if (!betM3.equals("L"))
   										betM3 += betM;
   							} else if (betMatrix3[i].length() == 3)
   								betM3 += betM;
   						}
   						bm3 += betM3 + "<br/>";
   					}
   				else if (gameNumber == Game.MEGATINKA) {
   					boolean flag3 = false;
   					for (int i = 0; i < bet3; i++)
   						if (NumberUtils.isNumber(betMatrix3[i])) {
   							if (flag3)
   								mbm3 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix3[i], 2, "0");
   							else if (i > 0 && i % 9 == 0)
                                   bm3 += "&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix3[i], 2, "0");
   							else
   								bm3 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix3[i], 2, "0");
   						} else if (!betMatrix3[i].equals(""))
   							flag3 = true;
   				} else if (gameNumber == Game.KABALA) {
   					if (!flagPlus && flagChauChamba) {
                   		if (addOn3.contains("1")) matrix3 += " " + "AD1";
                   		if (addOn3.contains("2")||addOn3.contains("4")) matrix3 += " " + "CC";
   					} else {
                   		if (addOn3.contains("1")) matrix3 += " " + "AD1";
                   		if (addOn3.contains("2")) matrix3 += " " + "AD2";
   					}
   					betMatrix3 = matrix3.split(" ");
   					for (int i = 0; i < betMatrix3.length; i++)
   						if (i > 0 && i % 9 == 0)
                               bm3 += "&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix3[i], 2, "0");
   						else
   							bm3 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix3[i], 2, "0");
   				} else
   					for (int i = 0; i < bet3; i++)
   						if (i > 0 && i % 9 == 0)
                               bm3 += "&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix3[i], 2, "0");
   						else
   							bm3 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix3[i], 2, "0");
   			}
   			if (betMatrix4 != null) {
   				bet4 = betMatrix4.length;
   				if (gameNumber == Game.GANAGOL)
   					for (int i = 0; i < bet4; i++) {
   						String betM4 = "";
   						for (int j = 0; j < betMatrix4[i].length(); j++) {
   							char betM = betMatrix4[i].charAt(j);
   							if (betMatrix4[i].length() == 1) {
   								if (j == 0 && betM == 'L')
   									betM4 += betM + "&ndash;&ndash;";
   								if (j == 0 && betM == 'E')
   									betM4 += "&ndash;" + betM + "&ndash;";
   								if (j == 0 && betM == 'V')
   									betM4 += "&ndash;&ndash;" + betM;
   							} else if (betMatrix4[i].length() == 2) {
   								if (j == 0 && betM == 'L')
   									betM4 += betM;
   								if (j == 0 && betM == 'E')
   									betM4 += "&ndash;" + betM;
   								if (j == 1 && betM == 'E')
   									betM4 += betM + "&ndash;";
   								if (j == 1 && betM == 'V')
   									if (betM4.equals("L"))
   										betM4 += "&ndash;" + betM;
   									else if (!betM4.equals("L"))
   										betM4 += betM;
   							} else if (betMatrix4[i].length() == 3)
   								betM4 += betM;
   						}
   						bm4 += betM4 + "<br/>";
   					}
   				else if (gameNumber == Game.MEGATINKA) {
   					boolean flag4 = false;
   					for (int i = 0; i < bet4; i++)
   						if (NumberUtils.isNumber(betMatrix4[i])) {
   							if (flag4)
   								mbm4 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix4[i], 2, "0");
   							else if (i > 0 && i % 9 == 0)
                                   bm4 += "&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix4[i], 2, "0");
   							else
   								bm4 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix4[i], 2, "0");
   						} else if (!betMatrix4[i].equals(""))
   							flag4 = true;
   				} else if (gameNumber == Game.KABALA) {
   					if (!flagPlus && flagChauChamba) {
                   		if (addOn4.contains("1")) matrix4 += " " + "AD1";
                   		if (addOn4.contains("2")||addOn4.contains("4")) matrix4 += " " + "CC";
   					} else {
                   		if (addOn4.contains("1")) matrix4 += " " + "AD1";
                   		if (addOn4.contains("2")) matrix4 += " " + "AD2";
   					}
   					betMatrix4 = matrix4.split(" ");
   					for (int i = 0; i < betMatrix4.length; i++)
   						if (i > 0 && i % 9 == 0)
                               bm4 += "&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix4[i], 2, "0");
   						else
   							bm4 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix4[i], 2, "0");
   				} else
   					for (int i = 0; i < bet4; i++)
   						if (i > 0 && i % 9 == 0)
                               bm4 += "&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad(betMatrix4[i], 2, "0");
   						else
   							bm4 += "&nbsp; &nbsp;" + StringUtils.leftPad(betMatrix4[i], 2, "0");
   			}
   			/*** aqui ****/
   			for (int i = 0; i < ticketNumber.length(); i++)
   				if ((i + 1) % 5 == 0)
   					tn += ticketNumber.charAt(i) + " ";
   				else
   					tn += "" + ticketNumber.charAt(i);
   			if (gameNumber == Game.TINKA) {
   				imgGame = "imgTinka.gif";
   				imgW = "235";
   				imgH = "60";
   				charity = "SOCIEDAD DE BENEFICENCIA DE HUANCAYO";
   				webAddress = "www.tinka.com.pe";
   			} else if (gameNumber == Game.MEGATINKA) {
   				imgGame = "imgTinkamegabol.jpg";
   				imgW = "200";
   				imgH = "85";
   				charity = "SOCIEDAD DE BENEFICENCIA DE HUANCAYO";
   				webAddress = "www.tinkamegabol.com.pe";
   			} else if (gameNumber == Game.GANADIARIO) {
   				imgGame = "imgGanadiario.jpg";
   				imgW = "151";
   				imgH = "100";
   				charity = "SOCIEDAD DE BENEFICENCIA PUBLICA DE JAEN";
   				webAddress = "www.ganadiario.com.pe";
   			} else if (gameNumber == Game.GANAGOL) {
   				imgGame = "imgGanagol.jpg";
   				imgW = "250";
   				imgH = "60";
   				charity = "La Tinka S.A.";
   				webAddress = "www.ganagol.com.pe";
   			} else if (gameNumber == Game.SUPER3) {
   				imgGame = "imgSuper3.jpg";
   				imgW = "220";
   				imgH = "110";
   				charity = "SOCIEDAD DE BENEFICENCIA PUBLICA DE JAEN";
   				webAddress = "www.super3.com.pe";
   			} else if (gameNumber == Game.KABALA) {
   				imgGame = "imgKabala.jpg";
   				imgW = "150";
   				imgH = "110";
   				charity = "SOCIEDAD DE BENEFICENCIA PUBLICA DE JAEN";
   				webAddress = "www.kabala.com.pe";
   			}
               if (gameNumber == Game.TINKA || gameNumber == Game.GANADIARIO || gameNumber == Game.KABALA || gameNumber == Game.MEGATINKA) {
   				//consecutive = toDraw - (p_clientTicket.getLastDraw() - game.getGapLotos5());
   				if (gameNumber == Game.TINKA || gameNumber == Game.KABALA)
   					betMax = 6;
   				if (gameNumber == Game.MEGATINKA)
   					betMax = 8;
   				if (gameNumber == Game.GANADIARIO)
   					betMax = 5;
   				if (bet1 > betMax) {
   					String bm = "";
   					String mbm = "";
   					boolean flg = false;
   					for (int i = 0; i < bet1; i++)
   						if (NumberUtils.isNumber(betMatrix1[i])) {
   							if (flg)
   								mbm += "&nbsp;" + StringUtils.leftPad(betMatrix1[i], 2, "0");
   							else
   								bm += "&nbsp;" + StringUtils.leftPad(betMatrix1[i], 2, "0");
   						} else if (!betMatrix1[i].equals(""))
   							flg = true;
   					if (gameNumber == Game.MEGATINKA)
   						solved += "<tr><td>TKA:&nbsp;<b>" + bm + "</b>&nbsp;&nbsp;MTA:&nbsp;<b>" + mbm
   								+ "</b></td></tr><tr><td><table cellpadding='0' cellspacing='2' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>";
   					else
   						solved += "<tr><td>A" + StringUtils.leftPad("" + bet1, 2, "0") + ":&nbsp;<b>" + bm
   								+ "</b></td></tr><tr><td><table cellpadding='0' cellspacing='2' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>";
   					ArrayList<String[]> fullBets = BussinessSaleDispatcher.getBets(gameNumber, matrix1);
   					int i = 0;
   					for (String[] c : fullBets) {
   						if (i == 0)
   							solved += "<tr valign='top'><td style='padding: 0 0 5px 0;'>";
   						else if (i % 25 == 0 && c.length > 0)
   							if (i % 125 == 0)
   								solved += "</td></tr><tr valign='top'><td style='padding: 0 0 5px 0;'>";
   							else
   								solved += "</td><td style='padding: 0 0 5px 0;'>";
   						if (i >= 0 && i < 9)
   							solved += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + (i + 1) + ")&nbsp;";
   						else if (i >= 9 && i < 99)
   							solved += "&nbsp;&nbsp;&nbsp;&nbsp;" + (i + 1) + ")&nbsp;";
   						else if (i >= 99 && i < 999)
   							solved += "&nbsp;&nbsp;" + (i + 1) + ")&nbsp;";
   						else
   							solved += i + 1 + ")&nbsp;";
   						int j = 0;
   						for (String s : c) {
   							if (j == c.length - 1 && gameNumber == Game.MEGATINKA)
   								solved += "M&nbsp;" + s;
   							else
   								solved += s + "&nbsp;";
   							j++;
   						}
   						if (i == fullBets.size() - 1)
   							solved += "</td></tr>";
   						else
   							solved += "<br/>";
   						i++;
   					}
   					solved += "</table></td></tr><tr><td>" + i + " jugadas<br/><br/></td></tr>";
   					total += i;
   				}
   				if (bet2 > betMax) {
   					String bm = "";
   					String mbm = "";
   					boolean flg = false;
   					for (int i = 0; i < bet2; i++)
   						if (NumberUtils.isNumber(betMatrix2[i])) {
   							if (flg)
   								mbm += "&nbsp;" + StringUtils.leftPad(betMatrix2[i], 2, "0");
   							else
   								bm += "&nbsp;" + StringUtils.leftPad(betMatrix2[i], 2, "0");
   						} else if (!betMatrix2[i].equals(""))
   							flg = true;
   					if (gameNumber == Game.MEGATINKA)
   						solved += "<tr><td>TKB:&nbsp;<b>" + bm + "</b>&nbsp;&nbsp;MTB:&nbsp;<b>" + mbm
   								+ "</b></td></tr><tr><td><table cellpadding='0' cellspacing='2' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>";
   					else
   						solved += "<tr><td>B" + StringUtils.leftPad("" + bet2, 2, "0") + ":&nbsp;<b>" + bm
   								+ "</b></td></tr><tr><td><table cellpadding='0' cellspacing='2' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>";
   					ArrayList<String[]> fullBets = BussinessSaleDispatcher.getBets(gameNumber, matrix2);
   					int i = 0;
   					for (String[] c : fullBets) {
   						if (i == 0)
   							solved += "<tr valign='top'><td style='padding: 0 0 5px 0;'>";
   						else if (i % 25 == 0 && c.length > 0)
   							if (i % 125 == 0)
   								solved += "</td></tr><tr valign='top'><td style='padding: 0 0 5px 0;'>";
   							else
   								solved += "</td><td style='padding: 0 0 5px 0;'>";
   						if (i >= 0 && i < 9)
   							solved += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + (i + 1) + ")&nbsp;";
   						else if (i >= 9 && i < 99)
   							solved += "&nbsp;&nbsp;&nbsp;&nbsp;" + (i + 1) + ")&nbsp;";
   						else if (i >= 99 && i < 999)
   							solved += "&nbsp;&nbsp;" + (i + 1) + ")&nbsp;";
   						else
   							solved += i + 1 + ")&nbsp;";
   						int j = 0;
   						for (String s : c) {
   							if (j == c.length - 1 && gameNumber == Game.MEGATINKA)
   								solved += "M&nbsp;" + s;
   							else
   								solved += s + "&nbsp;";
   							j++;
   						}
   						if (i == fullBets.size() - 1)
   							solved += "</td></tr>";
   						else
   							solved += "<br/>";
   						i++;
   					}
   					solved += "</table></td></tr><tr><td>" + i + " jugadas<br/><br/></td></tr>";
   					total += i;
   				}
   				if (bet3 > betMax) {
   					String bm = "";
   					String mbm = "";
   					boolean flg = false;
   					for (int i = 0; i < bet3; i++)
   						if (NumberUtils.isNumber(betMatrix3[i])) {
   							if (flg)
   								mbm += "&nbsp;" + StringUtils.leftPad(betMatrix3[i], 2, "0");
   							else
   								bm += "&nbsp;" + StringUtils.leftPad(betMatrix3[i], 2, "0");
   						} else if (!betMatrix3[i].equals(""))
   							flg = true;
   					if (gameNumber == Game.MEGATINKA)
   						solved += "<tr><td>TKC:&nbsp;<b>" + bm + "</b>&nbsp;&nbsp;MTC:&nbsp;<b>" + mbm
   								+ "</b></td></tr><tr><td><table cellpadding='0' cellspacing='2' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>";
   					else
   						solved += "<tr><td>C" + StringUtils.leftPad("" + bet3, 2, "0") + ":&nbsp;<b>" + bm
   								+ "</b></td></tr><tr><td><table cellpadding='0' cellspacing='2' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>";
   					ArrayList<String[]> fullBets = BussinessSaleDispatcher.getBets(gameNumber, matrix3);
   					int i = 0;
   					for (String[] c : fullBets) {
   						if (i == 0)
   							solved += "<tr valign='top'><td style='padding: 0 0 5px 0;'>";
   						else if (i % 25 == 0 && c.length > 0)
   							if (i % 125 == 0)
   								solved += "</td></tr><tr valign='top'><td style='padding: 0 0 5px 0;'>";
   							else
   								solved += "</td><td style='padding: 0 0 5px 0;'>";
   						if (i >= 0 && i < 9)
   							solved += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + (i + 1) + ")&nbsp;";
   						else if (i >= 9 && i < 99)
   							solved += "&nbsp;&nbsp;&nbsp;&nbsp;" + (i + 1) + ")&nbsp;";
   						else if (i >= 99 && i < 999)
   							solved += "&nbsp;&nbsp;" + (i + 1) + ")&nbsp;";
   						else
   							solved += i + 1 + ")&nbsp;";
   						int j = 0;
   						for (String s : c) {
   							if (j == c.length - 1 && gameNumber == Game.MEGATINKA)
   								solved += "M&nbsp;" + s;
   							else
   								solved += s + "&nbsp;";
   							j++;
   						}
   						if (i == fullBets.size() - 1)
   							solved += "</td></tr>";
   						else
   							solved += "<br/>";
   						i++;
   					}
   					solved += "</table></td></tr><tr><td>" + i + " jugadas<br/><br/></td></tr>";
   					total += i;
   				}
   				if (bet4 > betMax) {
   					String bm = "";
   					String mbm = "";
   					boolean flg = false;
   					for (int i = 0; i < bet4; i++)
   						if (NumberUtils.isNumber(betMatrix4[i])) {
   							if (flg)
   								mbm += "&nbsp;" + StringUtils.leftPad(betMatrix4[i], 2, "0");
   							else
   								bm += "&nbsp;" + StringUtils.leftPad(betMatrix4[i], 2, "0");
   						} else if (!betMatrix4[i].equals(""))
   							flg = true;
   					if (gameNumber == Game.MEGATINKA)
   						solved += "<tr><td>TKD:&nbsp;<b>" + bm + "</b>&nbsp;&nbsp;MTD:&nbsp;<b>" + mbm
   								+ "</b></td></tr><tr><td><table cellpadding='0' cellspacing='2' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>";
   					else
   						solved += "<tr><td>D" + StringUtils.leftPad("" + bet4, 2, "0") + ":&nbsp;<b>" + bm
   								+ "</b></td></tr><tr><td><table cellpadding='0' cellspacing='2' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>";
   					ArrayList<String[]> fullBets = BussinessSaleDispatcher.getBets(gameNumber, matrix4);
   					int i = 0;
   					for (String[] c : fullBets) {
   						if (i == 0)
   							solved += "<tr valign='top'><td style='padding: 0 0 5px 0;'>";
   						else if (i % 25 == 0 && c.length > 0)
   							if (i % 125 == 0)
   								solved += "</td></tr><tr valign='top'><td style='padding: 0 0 5px 0;'>";
   							else
   								solved += "</td><td style='padding: 0 0 5px 0;'>";
   						if (i >= 0 && i < 9)
   							solved += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + (i + 1) + ")&nbsp;";
   						else if (i >= 9 && i < 99)
   							solved += "&nbsp;&nbsp;&nbsp;&nbsp;" + (i + 1) + ")&nbsp;";
   						else if (i >= 99 && i < 999)
   							solved += "&nbsp;&nbsp;" + (i + 1) + ")&nbsp;";
   						else
   							solved += i + 1 + ")&nbsp;";
   						int j = 0;
   						for (String s : c) {
   							if (j == c.length - 1 && gameNumber == Game.MEGATINKA)
   								solved += "M&nbsp;" + s;
   							else
   								solved += s + "&nbsp;";
   							j++;
   						}
   						if (i == fullBets.size() - 1)
   							solved += "</td></tr>";
   						else
   							solved += "<br/>";
   						i++;
   					}
   					solved += "</table></td></tr><tr><td>" + i + " jugadas<br/><br/></td></tr>";
   					total += i;
   				}
   				if (total > 0)
                       solved += "<tr><td>Total:&nbsp;" + total + "&nbsp;apuestas generadas de jugadas m&uacute;ltiples.</td></tr>";
   			}
   			if (gameNumber == Game.GANAGOL) {
   				if (bet1 == 14) {
   					String bm = "";
   					int cbm = 0;
   					for (int i = 0; i < bet1; i++) {
   						String betM1 = "";
   						for (int j = 0; j < betMatrix1[i].length(); j++) {
   							char betM = betMatrix1[i].charAt(j);
   							if (betMatrix1[i].length() == 1) {
   								if (j == 0 && betM == 'L')
   									betM1 += betM + "&ndash;&ndash;";
   								if (j == 0 && betM == 'E')
   									betM1 += "&ndash;" + betM + "&ndash;";
   								if (j == 0 && betM == 'V')
   									betM1 += "&ndash;&ndash;" + betM;
   							} else if (betMatrix1[i].length() == 2) {
   								if (j == 0 && betM == 'L')
   									betM1 += betM;
   								if (j == 0 && betM == 'E')
   									betM1 += "&ndash;" + betM;
   								if (j == 1 && betM == 'E')
   									betM1 += betM + "&ndash;";
   								if (j == 1 && betM == 'V')
   									if (betM1.equals("L"))
   										betM1 += "&ndash;" + betM;
   									else if (!betM1.equals("L"))
   										betM1 += betM;
   							} else if (betMatrix1[i].length() == 3)
   								betM1 += betM;
   						}
   						bm += betM1 + "<br/>";
   						cbm += betMatrix1[i].length();
   					}
   					if (cbm > 14) {
   						ArrayList<String[]> fullBets = BussinessSaleDispatcher.getBets(gameNumber, matrix1);
   						int i = 0;
   						for (String[] c : fullBets) {
   							if (i == 0)
   								solved += "<tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;<br/>01:<br/>02:<br/>03:<br/>04:<br/>05:<br/>06:<br/>07:<br/>08:<br/>09:<br/>10:<br/>11:<br/>12:<br/>13:<br/>14:</td>"
   										+ "<td align='center' style='padding: 0 0 5px 0;'><b>&nbsp;&nbsp;&nbsp;A&nbsp;&nbsp;&nbsp;<br/>"
                                           + bm
                                           + "</b></td><td align='center' style='padding: 0 0 5px 0;'>";
   							else if (i % 25 == 0 && c.length > 0)
   								solved += "</td></tr><tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;<br/>01:<br/>02:<br/>03:<br/>04:<br/>05:<br/>06:<br/>07:<br/>08:<br/>09:<br/>10:<br/>11:<br/>12:<br/>13:<br/>14:"
   										+ "</td><td align='center' style='padding: 0 0 5px 0;'>&nbsp;</td><td align='center' style='padding: 0 0 5px 0;'>";
   							if (i >= 0 && i < 9)
   								solved += "&nbsp;&nbsp;<u>" + (i + 1) + "</u>&nbsp;&nbsp;<br/>";
   							else if (i >= 9 && i < 99)
   								solved += "&nbsp;<u>" + (i + 1) + "</u>&nbsp;<br/>";
   							else
   								solved += "<u>" + (i + 1) + "</u><br/>";
   							for (String s : c)
   								solved += s + "<br/>";
   							if (i == fullBets.size() - 1)
   								solved += "</td></tr>";
   							else
   								solved += "</td><td align='center' style='padding: 0 0 5px 0;'>";
   							i++;
   						}
   						solved += "<tr><td colspan='15'><br/>" + i + " jugadas<br/><br/></td></tr>";
   						total += i;
   					}
   				}
   				if (bet2 == 14) {
   					String bm = "";
   					int cbm = 0;
   					for (int i = 0; i < bet2; i++) {
   						String betM2 = "";
   						for (int j = 0; j < betMatrix2[i].length(); j++) {
   							char betM = betMatrix2[i].charAt(j);
   							if (betMatrix2[i].length() == 1) {
   								if (j == 0 && betM == 'L')
   									betM2 += betM + "&ndash;&ndash;";
   								if (j == 0 && betM == 'E')
   									betM2 += "&ndash;" + betM + "&ndash;";
   								if (j == 0 && betM == 'V')
   									betM2 += "&ndash;&ndash;" + betM;
   							} else if (betMatrix2[i].length() == 2) {
   								if (j == 0 && betM == 'L')
   									betM2 += betM;
   								if (j == 0 && betM == 'E')
   									betM2 += "&ndash;" + betM;
   								if (j == 1 && betM == 'E')
   									betM2 += betM + "&ndash;";
   								if (j == 1 && betM == 'V')
   									if (betM2.equals("L"))
   										betM2 += "&ndash;" + betM;
   									else if (!betM2.equals("L"))
   										betM2 += betM;
   							} else if (betMatrix2[i].length() == 3)
   								betM2 += betM;
   						}
   						bm += betM2 + "<br/>";
   						cbm += betMatrix2[i].length();
   					}
   					if (cbm > 14) {
   						ArrayList<String[]> fullBets = BussinessSaleDispatcher.getBets(gameNumber, matrix2);
   						int i = 0;
   						for (String[] c : fullBets) {
   							if (i == 0)
   								solved += "<tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;<br/>01:<br/>02:<br/>03:<br/>04:<br/>05:<br/>06:<br/>07:<br/>08:<br/>09:<br/>10:<br/>11:<br/>12:<br/>13:<br/>14:</td>"
   										+ "<td align='center' style='padding: 0 0 5px 0;'><b>&nbsp;&nbsp;&nbsp;B&nbsp;&nbsp;&nbsp;<br/>"
                                           + bm
                                           + "</b></td><td align='center' style='padding: 0 0 5px 0;'>";
   							else if (i % 25 == 0 && c.length > 0)
   								solved += "</td></tr><tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;<br/>01:<br/>02:<br/>03:<br/>04:<br/>05:<br/>06:<br/>07:<br/>08:<br/>09:<br/>10:<br/>11:<br/>12:<br/>13:<br/>14:"
   										+ "</td><td align='center' style='padding: 0 0 5px 0;'>&nbsp;</td><td align='center' style='padding: 0 0 5px 0;'>";
   							if (i >= 0 && i < 9)
   								solved += "&nbsp;&nbsp;<u>" + (i + 1) + "</u>&nbsp;&nbsp;<br/>";
   							else if (i >= 9 && i < 99)
   								solved += "&nbsp;<u>" + (i + 1) + "</u>&nbsp;<br/>";
   							else
   								solved += "<u>" + (i + 1) + "</u><br/>";
   							for (String s : c)
   								solved += s + "<br/>";
   							if (i == fullBets.size() - 1)
   								solved += "</td></tr>";
   							else
   								solved += "</td><td align='center' style='padding: 0 0 5px 0;'>";
   							i++;
   						}
   						solved += "<tr><td colspan='15'><br/>" + i + " jugadas<br/><br/></td></tr>";
   						total += i;
   					}
   				}
   				if (bet3 == 14) {
   					String bm = "";
   					int cbm = 0;
   					for (int i = 0; i < bet3; i++) {
   						String betM3 = "";
   						for (int j = 0; j < betMatrix3[i].length(); j++) {
   							char betM = betMatrix3[i].charAt(j);
   							if (betMatrix3[i].length() == 1) {
   								if (j == 0 && betM == 'L')
   									betM3 += betM + "&ndash;&ndash;";
   								if (j == 0 && betM == 'E')
   									betM3 += "&ndash;" + betM + "&ndash;";
   								if (j == 0 && betM == 'V')
   									betM3 += "&ndash;&ndash;" + betM;
   							} else if (betMatrix3[i].length() == 2) {
   								if (j == 0 && betM == 'L')
   									betM3 += betM;
   								if (j == 0 && betM == 'E')
   									betM3 += "&ndash;" + betM;
   								if (j == 1 && betM == 'E')
   									betM3 += betM + "&ndash;";
   								if (j == 1 && betM == 'V')
   									if (betM3.equals("L"))
   										betM3 += "&ndash;" + betM;
   									else if (!betM3.equals("L"))
   										betM3 += betM;
   							} else if (betMatrix3[i].length() == 3)
   								betM3 += betM;
   						}
   						bm += betM3 + "<br/>";
   						cbm += betMatrix3[i].length();
   					}
   					if (cbm > 14) {
   						ArrayList<String[]> fullBets = BussinessSaleDispatcher.getBets(gameNumber, matrix3);
   						int i = 0;
   						for (String[] c : fullBets) {
   							if (i == 0)
   								solved += "<tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;<br/>01:<br/>02:<br/>03:<br/>04:<br/>05:<br/>06:<br/>07:<br/>08:<br/>09:<br/>10:<br/>11:<br/>12:<br/>13:<br/>14:</td>"
   										+ "<td align='center' style='padding: 0 0 5px 0;'><b>&nbsp;&nbsp;&nbsp;C&nbsp;&nbsp;&nbsp;<br/>"
                                           + bm
                                           + "</b></td><td align='center' style='padding: 0 0 5px 0;'>";
   							else if (i % 25 == 0 && c.length > 0)
   								solved += "</td></tr><tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;<br/>01:<br/>02:<br/>03:<br/>04:<br/>05:<br/>06:<br/>07:<br/>08:<br/>09:<br/>10:<br/>11:<br/>12:<br/>13:<br/>14:"
   										+ "</td><td align='center' style='padding: 0 0 5px 0;'>&nbsp;</td><td align='center' style='padding: 0 0 5px 0;'>";
   							if (i >= 0 && i < 9)
   								solved += "&nbsp;&nbsp;<u>" + (i + 1) + "</u>&nbsp;&nbsp;<br/>";
   							else if (i >= 9 && i < 99)
   								solved += "&nbsp;<u>" + (i + 1) + "</u>&nbsp;<br/>";
   							else
   								solved += "<u>" + (i + 1) + "</u><br/>";
   							for (String s : c)
   								solved += s + "<br/>";
   							if (i == fullBets.size() - 1)
   								solved += "</td></tr>";
   							else
   								solved += "</td><td align='center' style='padding: 0 0 5px 0;'>";
   							i++;
   						}
   						solved += "<tr><td colspan='15'><br/>" + i + " jugadas<br/><br/></td></tr>";
   						total += i;
   					}
   				}
   				if (bet4 == 14) {
   					String bm = "";
   					int cbm = 0;
   					for (int i = 0; i < bet4; i++) {
   						String betM4 = "";
   						for (int j = 0; j < betMatrix4[i].length(); j++) {
   							char betM = betMatrix4[i].charAt(j);
   							if (betMatrix4[i].length() == 1) {
   								if (j == 0 && betM == 'L')
   									betM4 += betM + "&ndash;&ndash;";
   								if (j == 0 && betM == 'E')
   									betM4 += "&ndash;" + betM + "&ndash;";
   								if (j == 0 && betM == 'V')
   									betM4 += "&ndash;&ndash;" + betM;
   							} else if (betMatrix4[i].length() == 2) {
   								if (j == 0 && betM == 'L')
   									betM4 += betM;
   								if (j == 0 && betM == 'E')
   									betM4 += "&ndash;" + betM;
   								if (j == 1 && betM == 'E')
   									betM4 += betM + "&ndash;";
   								if (j == 1 && betM == 'V')
   									if (betM4.equals("L"))
   										betM4 += "&ndash;" + betM;
   									else if (!betM4.equals("L"))
   										betM4 += betM;
   							} else if (betMatrix4[i].length() == 3)
   								betM4 += betM;
   						}
   						bm += betM4 + "<br/>";
   						cbm += betMatrix4[i].length();
   					}
   					if (cbm > 14) {
   						ArrayList<String[]> fullBets = BussinessSaleDispatcher.getBets(gameNumber, matrix4);
   						int i = 0;
   						for (String[] c : fullBets) {
   							if (i == 0)
   								solved += "<tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;<br/>01:<br/>02:<br/>03:<br/>04:<br/>05:<br/>06:<br/>07:<br/>08:<br/>09:<br/>10:<br/>11:<br/>12:<br/>13:<br/>14:</td>"
   										+ "<td align='center' style='padding: 0 0 5px 0;'><b>&nbsp;&nbsp;&nbsp;D&nbsp;&nbsp;&nbsp;<br/>"
                                           + bm
                                           + "</b></td><td align='center' style='padding: 0 0 5px 0;'>";
   							else if (i % 25 == 0 && c.length > 0)
   								solved += "</td></tr><tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;<br/>01:<br/>02:<br/>03:<br/>04:<br/>05:<br/>06:<br/>07:<br/>08:<br/>09:<br/>10:<br/>11:<br/>12:<br/>13:<br/>14:"
   										+ "</td><td align='center' style='padding: 0 0 5px 0;'>&nbsp;</td><td align='center' style='padding: 0 0 5px 0;'>";
   							if (i >= 0 && i < 9)
   								solved += "&nbsp;&nbsp;<u>" + (i + 1) + "</u>&nbsp;&nbsp;<br/>";
   							else if (i >= 9 && i < 99)
   								solved += "&nbsp;<u>" + (i + 1) + "</u>&nbsp;<br/>";
   							else
   								solved += "<u>" + (i + 1) + "</u><br/>";
   							for (String s : c)
   								solved += s + "<br/>";
   							if (i == fullBets.size() - 1)
   								solved += "</td></tr>";
   							else
   								solved += "</td><td align='center' style='padding: 0 0 5px 0;'>";
   							i++;
   						}
   						solved += "<tr><td colspan='15'><br/>" + i + " jugadas<br/><br/></td></tr>";
   						total += i;
   					}
   				}
   				if (total > 0)
                       solved += "<tr><td colspan='15'>Total:&nbsp;" + total + "&nbsp;apuestas generadas de jugadas m&uacute;ltiples.</td></tr>";
   			}
   			/*if (gameNumber == Game.SUPER3) {
   				fromDraw = fromDraw - game.getGapLotos5(); // 5000
   				toDraw = toDraw - game.getGapLotos5(); // 5000
   				int bet3exactA = p_clientTicket.getCtBet3exactA();
   				int bet3anyA = p_clientTicket.getCtBet3anyA();
   				int bet2exactA = p_clientTicket.getCtBet2exactA();
   				int bet1exactA = p_clientTicket.getCtBet1exactA();
   				int bet3exactB = p_clientTicket.getCtBet3exactB();
   				int bet3anyB = p_clientTicket.getCtBet3anyB();
   				int bet2exactB = p_clientTicket.getCtBet2exactB();
   				int bet1exactB = p_clientTicket.getCtBet1exactB();
   				if (bet1 > 0) {
   					String bm = "";
   					int cnt = 0;
   					for (int i = 0; i < bet1; i++)
   						bm += "&nbsp;" + betMatrix1[i];
   					solved += "<tr><td>A" + StringUtils.leftPad("" + bet1, 2, "0") + ":&nbsp;<b>" + bm
   							+ "</b></td></tr><tr><td><table cellpadding='0' cellspacing='2' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>";
   					solved += "<tr valign='top'>";
   					if (bet3exactA == 1) {
   						int cnt3ea = 0;
   						solved += "<td style='width:150px; text-align:center;'><u>3 EN ORDEN</u><br/><br/>";
   						for (int i = 0; i < bet1; i++) {
   							if (i >= 0 && i < 9)
   								solved += "<br/>&nbsp;" + (i + 1) + ")&nbsp;" + betMatrix1[i] + "<br/><br/>";
   							else
   								solved += "<br/>" + (i + 1) + ")&nbsp;" + betMatrix1[i] + "<br/><br/>";
   							solved += "&mdash;&mdash;&mdash;&mdash;&mdash;<br/>";
   							if (bet1 - 1 == i)
   								cnt3ea = i + 1;
   						}
   						solved += "Total en columna: " + cnt3ea + "<br/><br/></td>";
   						cnt += cnt3ea;
   					}
   					if (bet3anyA == 1) {
   						int cnt3aa = 0;
   						solved += "<td style='width:150px; text-align:center;'><u>3 EN DESORDEN</u><br/><br/>";
   						for (int i = 0; i < bet1; i++) {
   							String num = betMatrix1[i];
   							String[] cad = Permuta.permuta(num);
   							for (int j = 0; j < cad.length; j++) {
   								if ((j + 1) % 2 == 0) {
   									if (i * 6 + j >= 0 && i * 6 + j < 9)
                                           solved += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + (i * 6 + j + 1) + ")&nbsp;" + cad[j] + "<br/>";
   									else if (i * 6 + j >= 9 && i * 6 + j < 99)
                                           solved += "&nbsp;&nbsp;&nbsp;&nbsp;" + (i * 6 + j + 1) + ")&nbsp;" + cad[j] + "<br/>";
   									else
   										solved += "&nbsp;&nbsp;" + (i * 6 + j + 1) + ")&nbsp;" + cad[j] + "<br/>";
   								} else if (i * 6 + j >= 0 && i * 6 + j < 9)
   									solved += "&nbsp;&nbsp;&nbsp;" + (i * 6 + j + 1) + ")&nbsp;" + cad[j];
   								else if (i * 6 + j >= 9 && i * 6 + j < 99)
   									solved += "&nbsp;&nbsp;" + (i * 6 + j + 1) + ")&nbsp;" + cad[j];
   								else
   									solved += i * 6 + j + 1 + ")&nbsp;" + cad[j];
   								if (bet1 - 1 == i)
   									cnt3aa = i * 6 + j + 1;
   							}
   							solved += "&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;<br/>";
   						}
   						solved += "Total en columna: " + cnt3aa + "<br/><br/></td>";
   						cnt += cnt3aa;
   					}
   					if (bet2exactA == 1) {
   						int cnt2ea = 0;
   						solved += "<td style='width:150px; text-align:center;'><u>2 EN ORDEN</u><br/><br/>";
   						for (int i = 0; i < bet1; i++) {
   							String num = betMatrix1[i];
   							for (int j = 0; j < num.length(); j++) {
   								String cad = "";
   								for (int j1 = 0; j1 < num.length(); j1++)
   									if (j1 != j)
   										cad += num.charAt(j1);
   									else
   										cad += "*";
   								if (i * 3 + j >= 0 && i * 3 + j < 9)
   									solved += "&nbsp;" + (i * 3 + j + 1) + ")&nbsp;" + cad + "<br/>";
   								else
   									solved += i * 3 + j + 1 + ")&nbsp;" + cad + "<br/>";
   								if (bet1 - 1 == i)
   									cnt2ea = i * 3 + j + 1;
   							}
   							solved += "&mdash;&mdash;&mdash;&mdash;&mdash;<br/>";
   						}
   						solved += "Total en columna: " + (cnt2ea * 10 - 2 * bet1) + "<br/><br/></td>";
   						cnt += cnt2ea * 10 - 2 * bet1;
   					}
   					if (bet1exactA == 1) {
   						int cnt1ea = 0;
   						solved += "<td style='width:150px; text-align:center;'><u>1 EN ORDEN</u><br/><br/>";
   						for (int i = 0; i < bet1; i++) {
   							String num = betMatrix1[i];
   							for (int j = 0; j < num.length(); j++) {
   								String cad = "";
   								for (int j1 = 0; j1 < num.length(); j1++)
   									if (j1 != j)
   										cad += "*";
   									else
   										cad += num.charAt(j1);
   								if (i * 3 + j >= 0 && i * 3 + j < 9)
   									solved += "&nbsp;" + (i * 3 + j + 1) + ")&nbsp;" + cad + "<br/>";
   								else
   									solved += i * 3 + j + 1 + ")&nbsp;" + cad + "<br/>";
   								if (bet1 - 1 == i)
   									cnt1ea = i * 3 + j + 1;
   							}
   							solved += "&mdash;&mdash;&mdash;&mdash;&mdash;<br/>";
   						}
   						solved += "Total en columna: " + (cnt1ea * 100 - 20 * bet1) + "<br/><br/></td>";
   						cnt += cnt1ea * 100 - 20 * bet1;
   					}
   					solved += "</tr></table></td></tr><tr><td colspan='3'>" + cnt + " jugadas<br/><br/></td></tr>";
   					total += cnt;
   				}
   				if (bet2 > 0) {
   					String bm = "";
   					int cnt = 0;
   					for (int i = 0; i < bet2; i++)
   						bm += "&nbsp;" + betMatrix2[i];
   					solved += "<tr><td>B" + StringUtils.leftPad("" + bet2, 2, "0") + ":&nbsp;<b>" + bm
   							+ "</b></td></tr><tr><td><table cellpadding='0' cellspacing='2' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>";
   					solved += "<tr valign='top'>";
   					if (bet3exactB == 1) {
   						int cnt3eb = 0;
   						solved += "<td style='width:150px; text-align:center;'><u>3 EN ORDEN</u><br/><br/>";
   						for (int i = 0; i < bet2; i++) {
   							if (i >= 0 && i < 9)
   								solved += "<br/>&nbsp;" + (i + 1) + ")&nbsp;" + betMatrix2[i] + "<br/><br/>";
   							else
   								solved += "<br/>" + (i + 1) + ")&nbsp;" + betMatrix2[i] + "<br/><br/>";
   							solved += "&mdash;&mdash;&mdash;&mdash;&mdash;<br/>";
   							if (bet2 - 1 == i)
   								cnt3eb = i + 1;
   						}
   						solved += "Total en columna: " + cnt3eb + "<br/><br/></td>";
   						cnt += cnt3eb;
   					}
   					if (bet3anyB == 1) {
   						int cnt3ab = 0;
   						solved += "<td style='width:150px; text-align:center;'><u>3 EN DESORDEN</u><br/><br/>";
   						for (int i = 0; i < bet2; i++) {
   							String num = betMatrix2[i];
   							String[] cad = Permuta.permuta(num);
   							for (int j = 0; j < cad.length; j++) {
   								if ((j + 1) % 2 == 0) {
   									if (i * 6 + j >= 0 && i * 6 + j < 9)
                                           solved += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + (i * 6 + j + 1) + ")&nbsp;" + cad[j] + "<br/>";
   									else if (i * 6 + j >= 9 && i * 6 + j < 99)
                                           solved += "&nbsp;&nbsp;&nbsp;&nbsp;" + (i * 6 + j + 1) + ")&nbsp;" + cad[j] + "<br/>";
   									else
   										solved += "&nbsp;&nbsp;" + (i * 6 + j + 1) + ")&nbsp;" + cad[j] + "<br/>";
   								} else if (i * 6 + j >= 0 && i * 6 + j < 9)
   									solved += "&nbsp;&nbsp;&nbsp;&nbsp;" + (i * 6 + j + 1) + ")&nbsp;" + cad[j];
   								else if (i * 6 + j >= 9 && i * 6 + j < 99)
   									solved += "&nbsp;&nbsp;" + (i * 6 + j + 1) + ")&nbsp;" + cad[j];
   								else
   									solved += i * 6 + j + 1 + ")&nbsp;" + cad[j];
   								if (bet2 - 1 == i)
   									cnt3ab = i * 6 + j + 1;
   							}
   							solved += "&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;<br/>";
   						}
   						solved += "Total en columna: " + cnt3ab + "<br/><br/></td>";
   						cnt += cnt3ab;
   					}
   					if (bet2exactB == 1) {
   						int cnt2eb = 0;
   						solved += "<td style='width:150px; text-align:center;'><u>2 EN ORDEN</u><br/><br/>";
   						for (int i = 0; i < bet2; i++) {
   							String num = betMatrix2[i];
   							for (int j = 0; j < num.length(); j++) {
   								String cad = "";
   								for (int j1 = 0; j1 < num.length(); j1++)
   									if (j1 != j)
   										cad += num.charAt(j1);
   									else
   										cad += "*";
   								if (i * 3 + j >= 0 && i * 3 + j < 9)
   									solved += "&nbsp;" + (i * 3 + j + 1) + ")&nbsp;" + cad + "<br/>";
   								else
   									solved += i * 3 + j + 1 + ")&nbsp;" + cad + "<br/>";
   								if (bet2 - 1 == i)
   									cnt2eb = i * 3 + j + 1;
   							}
   							solved += "&mdash;&mdash;&mdash;&mdash;&mdash;<br/>";
   						}
   						solved += "Total en columna: " + (cnt2eb * 10 - 2 * bet2) + "<br/><br/></td>";
   						cnt += cnt2eb * 10 - 2 * bet2;
   					}
   					if (bet1exactB == 1) {
   						int cnt1eb = 0;
   						solved += "<td style='width:150px; text-align:center;'><u>1 EN ORDEN</u><br/><br/>";
   						for (int i = 0; i < bet2; i++) {
   							String num = betMatrix2[i];
   							for (int j = 0; j < num.length(); j++) {
   								String cad = "";
   								for (int j1 = 0; j1 < num.length(); j1++)
   									if (j1 != j)
   										cad += "*";
   									else
   										cad += num.charAt(j1);
   								if (i * 3 + j >= 0 && i * 3 + j < 9)
   									solved += "&nbsp;" + (i * 3 + j + 1) + ")&nbsp;" + cad + "<br/>";
   								else
   									solved += i * 3 + j + 1 + ")&nbsp;" + cad + "<br/>";
   								if (bet2 - 1 == i)
   									cnt1eb = i * 3 + j + 1;
   							}
   							solved += "&mdash;&mdash;&mdash;&mdash;&mdash;<br/>";
   						}
   						solved += "Total en columna: " + (cnt1eb * 100 - 20 * bet1) + "<br/><br/></td>";
   						cnt += cnt1eb * 100 - 20 * bet1;
   					}
   					solved += "<tr></table></td></tr><tr><td colspan='3'>" + cnt + " jugadas<br/><br/></td></tr>";
   					total += cnt;
   				}
   				if (total > 0)
                       solved += "<tr><td>Total:&nbsp;"
                               + total
   							+ "&nbsp;apuestas generadas de jugadas m&uacute;ltiples.</td></tr><tr><td>(<b style='font-size:14px;'>*</b>)&nbsp;Cualquier n&uacute;mero entre el 0 y el 9</td></tr>";
   			}*/
   			DecimalFormat df = new DecimalFormat("###,##0.00");
               String apparea = String.valueOf(ConnectionFactory.operationProperty("applicationArea", context)).toString().trim();
               String testusers = String.valueOf(ConnectionFactory.operationProperty("testUsers", context)).toString().trim();
   			saleType = "0";
               //String separateline = "<tr><td colspan='2' align='center' style='font-size:9px;'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>";
   			String separateline = "<tr><td colspan='2' align='center' style='font-size:9px;'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>";
   			htmlText.append("<html><head><script type='text/javascript'>function oncontextmenuHandler(){return false;}"
   					+ "document.oncontextmenu = oncontextmenuHandler;function disableselect(e){return false;}"
   					+ "function reEnable(){return true;}document.onselectstart=new Function ('return false');"
   					+ "if (window.sidebar){document.onmousedown=disableselect;document.onclick=reEnable;}<\"+\"/script></head><body><center><table width='100%' cellpadding='0' cellspacing='0' style='margin:0; padding:0; border:0;'><tr><td align='center'>");
               //htmlText.append("<table width='292' cellpadding='0' cellspacing='0' style='margin:0; padding:9px; border:black 1px solid; font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>");
               htmlText.append("<table width='327' cellpadding='0' cellspacing='0' style='margin:0; padding:9px; border:black 1px solid; font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>");
               htmlText.append("<tr><td style='font-size:9px;' colspan='2'>Id1&nbsp;: " + clientId + "<br/>Id2&nbsp;: " + ticketId + "<BR>Id3 : " + docType + ' ' + docNumber + ' ' +clName + "<br/>" + "</td></tr>");
   			/* Quitar logo de Intralot - Inicio - @jmoran 2019-05-28 */
   			/*
               htmlText.append("<tr><td colspan='2' align='center'><img src='"
                       + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                       + "/layer-view-image/client/imgIntralot.gif' width='74' height='22' border='0'/></td></tr>"
                       + "<tr><td colspan='2' align='center' style='font-size:9px;'>RUC&nbsp;&nbsp;20506035121</td></tr>");
   			 */
   			/* Mostrar logos de sorteos en UAT */
   			/*
               htmlText.append("<tr><td colspan='2' align='center'><img src='"
                       + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim() + "/layer-view-image/client/" + imgGame
   			 */
   			htmlText.append("<tr><td colspan='2' align='center'><img src='"+Constants.eCommerceHome+"layer-view-image/client/" + imgGame 
                       //+ "' width='" + imgW + "' height='" + imgH + "' border='0'/></td></tr>" + "<tr><td align='center' colspan='2'>" + charity + "</td></tr>"
   					+ "' width='" + imgW + "' height='" + imgH + "' border='0'/></td></tr>"
   					+ "<tr><td style='font-size:9px;' align='center' colspan='2'>" + webAddress + "</td></tr>");
               htmlText.append("<tr><td colspan='2' align='center' style='font-size:9px;'>La Tinka S.A.&nbsp;&nbsp;RUC&nbsp;&nbsp;20506035121</td></tr>"); // cambio de posicion RUC
   			/* Quitar logo de La Tinka - Fin - @jmoran 2019-05-28 */
   			if (apparea.equals("development"))
                   htmlText.append("<tr><td style='font-size:16px;font-weight:bold;' align='center' colspan='2'>BOLETO DE PRUEBAS</td></tr>");
   			else if (apparea.equals("production"))
   				if (testusers != null && !testusers.equals("")) {
   					String[] users = testusers.split(",");
   					for (String user : users)
   						if (user.equals(clientId)) {
                               htmlText.append("<tr><td style='font-size:16px;font-weight:bold;' align='center' colspan='2'>BOLETO SIN VALOR</td></tr>");
   							break;
   						}
   				}
   			if (saleType.equals("9"))
                   htmlText.append("<tr><td style='font-size:16px;font-weight:bold;' align='center' colspan='2'>TICKET CAMBIO</td></tr>");
               htmlText.append("<tr><td align='center' colspan='2'>" + ticketDate.substring(0, 10) + "&nbsp;&nbsp;&nbsp;&nbsp;&minus;&nbsp;&nbsp;&nbsp;&nbsp;"
               		 + ticketDate.substring(11) + "</td></tr>"
                        + "<tr><td align='center' colspan='2'>" + charity + "</td></tr>" // @jmoran 2019-05-29
   					+ "<tr><td>AGENCIA:&nbsp;" + trmId /*trmId.substring(0, 6)*/ + "-0001 "
                       /*(char) (Integer.parseInt(trmId.substring(6)) + 64)*/ + "</td>" + "<td align='right'>TRN:&nbsp;" + trnsNum /*StringUtils.leftPad(trnsNum, 10, "0")*/ + "&nbsp;"
                       + "</td></tr>" + "<tr><td>" + gameName + "&nbsp;(" + StringUtils.leftPad("" + gameNumber, 3, "0") + ")&nbsp;"
                       + receiptNr + "</td><td align='right'>PERIODO:&nbsp;" + fromDrawDay + "</td></tr>");
   			// if(!typeid.equals("") && !numberid.equals(""))
               // htmlText.append("<tr><td></td><td align='right'>"+typeid+":&nbsp;"+numberid+"</td></tr>");
   			htmlText.append(separateline);
   			if (gameNumber == Game.GANAGOL) {
                   htmlText.append("<tr><td colspan='2'><font style='font-size:14px;font-weight:bold;'>GRUPO:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;B&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;C&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;D</font></td></tr>"
   								+ separateline
   								+ "<tr><td colspan='2'><table width='100%' cellpadding='0' cellspacing='0' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif; border-collapse:collapse;'><tr><td width='20%' align='center'>"
                           + "01:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>02:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>03:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>04:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font>"
                           + "<br/>05:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>06:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>07:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>08:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font>"
                           + "<br/>09:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>10:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>11:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>12:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>13:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>14:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font></td>");
   				if (!bm1.equals(""))
                       htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>" + bm1 + "</font></td>");
   				else
                       htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*</font></td>");
   				if (!bm2.equals(""))
                       htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>" + bm2 + "</font></td>");
   				else
                       htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*</font></td>");
   				if (!bm3.equals(""))
                       htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>" + bm3 + "</font></td>");
   				else
                       htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*</font></td>");
   				if (!bm4.equals(""))
   					htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>" + bm4 + "</font></td>");
   				else
   					htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*</font></td>");
   				
   				htmlText.append("</tr></table></td></tr>" + separateline);
   				htmlText.append(
   						"<tr><td colspan='2'><font style='font-size:14px;font-weight:bold;'>GOLAZO 200&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td></tr>"
   								+ "<tr><td colspan='2'><table width='40%' cellpadding='0' cellspacing='0' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif; border-collapse:collapse;'><tr><td width='20%' align='center'>"
   								+ "A:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font>"
   								+ "<br/>B:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font>"
   								+ "<br/>C:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font>"
   								+ "<br/>D:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font>" + "</td>");
   				if (!addOn1.equals(""))
   					htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>"
   							+ addOn1 + "</font><br>");
   				else
   					htmlText.append(
   							"<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>*</font><br>");
   				if (!addOn2.equals(""))
   					htmlText.append("<font style='font-size:14px;font-weight:bold;'>" + addOn2 + "</font><br>");
   				else
   					htmlText.append("<font style='font-size:14px;font-weight:bold;'>*</font><br>");
   				if (!addOn3.equals(""))
   					htmlText.append("<font style='font-size:14px;font-weight:bold;'>" + addOn3 + "</font><br>");
   				else
   					htmlText.append("<font style='font-size:14px;font-weight:bold;'>*</font><br>");
   				if (!addOn4.equals(""))
   					htmlText.append("<font style='font-size:14px;font-weight:bold;'>" + addOn4 + "</font></td>");
   				else
   					htmlText.append("<font style='font-size:14px;font-weight:bold;'>*</font></td>");

   				htmlText.append("</tr></table></td></tr>");

   			} else if (gameNumber == Game.SUPER3) {
   				if (!bm1.equals(""))
                       htmlText.append("<tr><td colspan='2' style='color:#FFFFFF; background-color:#000000;'><font style='font-size:10px;font-weight:bold;'>A:&nbsp;"
                               + (bet3ExactA == 1 && bet3AnyA == 0 ? "&nbsp;3&nbsp;EN&nbsp;ORDEN" : "") + (bet3ExactA == 0 && bet3AnyA == 1 ? "3&nbsp;DESORDEN" : "")
   									+ (bet3ExactA == 1 && bet3AnyA == 1 ? "&nbsp;3&nbsp;EN&nbsp;ORDEN/DESORDEN" : "")
                               + ((bet3ExactA == 1 || bet3AnyA == 1) && bet2ExactA == 1 ? "-" : "") + (bet2ExactA == 1 ? "&nbsp;2&nbsp;EN&nbsp;ORDEN" : "")
                               + ((bet3ExactA == 1 || bet3AnyA == 1 || bet2ExactA == 1) && bet1ExactA == 1 ? "-" : "") + (bet1ExactA == 1 ? "&nbsp;1&nbsp;EN&nbsp;ORDEN" : "")
                               + "</font></td></tr><tr><td colspan='2'>A:&nbsp;&nbsp;&nbsp;" + bm1 + "</td></tr>" + "<tr><td colspan='2'>MULT:&nbsp;&nbsp;&nbsp;"
   									+ StringUtils.leftPad("" + betMultiA, 2, "0") + "</td></tr>");
   				if (!bm2.equals(""))
                       htmlText.append("<tr><td colspan='2' style='color:#FFFFFF; background-color:#000000'><font style='font-size:10px;font-weight:bold;'>B:&nbsp;"
                               + (bet3ExactB == 1 && bet3AnyB == 0 ? "3EN ORDEN" : "") + (bet3ExactB == 0 && bet3AnyB == 1 ? "3DESORDEN" : "")
                               + (bet3ExactB == 1 && bet3AnyB == 1 ? "3EN ORDEN/DESORDEN" : "") + ((bet3ExactB == 1 || bet3AnyB == 1) && bet2ExactB == 1 ? "-" : "")
                               + (bet2ExactB == 1 ? "2EN ORDEN" : "") + ((bet3ExactB == 1 || bet3AnyB == 1 || bet2ExactB == 1) && bet1ExactB == 1 ? "-" : "")
                               + (bet1ExactB == 1 ? "1EN ORDEN" : "") + "</font></td></tr><tr><td colspan='2'>B:&nbsp;&nbsp;&nbsp;" + bm2 + "</td></tr>"
                               + "<tr><td colspan='2'>MULT:&nbsp;&nbsp;&nbsp;" + StringUtils.leftPad("" + betMultiB, 2, "0") + "</td></tr>");
   			} else if (gameNumber == Game.MEGATINKA) {
   				if (!bm1.equals(""))
                       htmlText.append("<tr><td colspan='2'>TKA:&nbsp;&nbsp;&nbsp;<font style='font-size:14px;font-weight:bold;'>" + bm1 + "</font></td></tr>");
   				if (!mbm1.equals(""))
                       htmlText.append("<tr><td colspan='2'>MTA:&nbsp;&nbsp;&nbsp;<font style='font-size:14px;font-weight:bold;'>" + mbm1 + "</font></td></tr>");
   				if (!bm2.equals(""))
                       htmlText.append("<tr><td colspan='2'>TKB:&nbsp;&nbsp;&nbsp;<font style='font-size:14px;font-weight:bold;'>" + bm2 + "</font></td></tr>");
   				if (!mbm2.equals(""))
                       htmlText.append("<tr><td colspan='2'>MTB:&nbsp;&nbsp;&nbsp;<font style='font-size:14px;font-weight:bold;'>" + mbm2 + "</font></td></tr>");
   				if (!bm3.equals(""))
                       htmlText.append("<tr><td colspan='2'>TKC:&nbsp;&nbsp;&nbsp;<font style='font-size:14px;font-weight:bold;'>" + bm3 + "</font></td></tr>");
   				if (!mbm3.equals(""))
                       htmlText.append("<tr><td colspan='2'>MTC:&nbsp;&nbsp;&nbsp;<font style='font-size:14px;font-weight:bold;'>" + mbm3 + "</font></td></tr>");
   				if (!bm4.equals(""))
                       htmlText.append("<tr><td colspan='2'>TKD:&nbsp;&nbsp;&nbsp;<font style='font-size:14px;font-weight:bold;'>" + bm4 + "</font></td></tr>");
   				if (!mbm4.equals(""))
                       htmlText.append("<tr><td colspan='2'>MTD:&nbsp;&nbsp;&nbsp;<font style='font-size:14px;font-weight:bold;'>" + mbm4 + "</font></td></tr>");
   			} else {
   				if (!bm1.equals(""))
                       htmlText.append("<tr><td colspan='2'>A" + StringUtils.leftPad("" + bet1, 2, "0") + ":&nbsp;&nbsp;&nbsp;<font style='font-size:14px;font-weight:bold;'>"
                               + bm1 + "</font></td></tr>");
   				if (!bm2.equals(""))
                       htmlText.append("<tr><td colspan='2'>B" + StringUtils.leftPad("" + bet2, 2, "0") + ":&nbsp;&nbsp;&nbsp;<font style='font-size:14px;font-weight:bold;'>"
                               + bm2 + "</font></td></tr>");
   				if (!bm3.equals(""))
                       htmlText.append("<tr><td colspan='2'>C" + StringUtils.leftPad("" + bet3, 2, "0") + ":&nbsp;&nbsp;&nbsp;<font style='font-size:14px;font-weight:bold;'>"
                               + bm3 + "</font></td></tr>");
   				if (!bm4.equals(""))
                       htmlText.append("<tr><td colspan='2'>D" + StringUtils.leftPad("" + bet4, 2, "0") + ":&nbsp;&nbsp;&nbsp;<font style='font-size:14px;font-weight:bold;'>"
                               + bm4 + "</font></td></tr>");
   			}
               htmlText.append(separateline + "<tr><td style='font-size:14px;font-weight:bold;' align='center' colspan='2'>COL:&nbsp;&nbsp;"
   					+ StringUtils.leftPad("" + numColumns, 2, "0") + "</td></tr>" + separateline);
   			if (gameNumber != Game.GANAGOL)
                   htmlText.append("<tr><td style='font-size:14px;' align='center' colspan='2'>BOLETO&nbsp;VALIDO&nbsp;PARA&nbsp;"
                           + StringUtils.leftPad("" + (toDraw - fromDraw + 1), 2, "0") + "&nbsp;SORTEO(S)</td></tr>");
   			htmlText.append("<tr><td style='font-size:13px;font-weight:bold;' align='center' colspan='2'>DESDE&nbsp;" + StringUtils.leftPad("" + fromDraw, 4, "0")
                       + "&nbsp;DEL&nbsp;" + fromDrawDay + "&nbsp;HASTA&nbsp;" + StringUtils.leftPad("" + toDraw, 4, "0") + "</td></tr>" + separateline);
   			if (saleType.equals("0")) {
                   htmlText.append("<tr><td style='font-size:14px;font-weight:bold;'>TOTAL&nbsp;&nbsp;&nbsp;S/.</td><td style='font-size:14px;font-weight:bold;' align='right'>"
   								+ df.format(receiptAmount) + "</td></tr>" + separateline);
   				/*if (receiptDiscounted != 0.0) {
                       htmlText.append("<tr><td style='font-size:14px;font-weight:bold;' align='center' colspan='2'>+GANO DESCUENTO&nbsp;&nbsp;S/." + df.format(receiptDiscounted)
                               + "</td></tr>");
   				}*/
                   if(bet1ExactA!=0) htmlText.append("<tr><td style='font-size:14px;font-weight:bold;' align='center' colspan='2'>BOLETO DE SUSCRIPCI&Oacute;N " + bet1ExactA + " DE " + bet2ExactA + "</td></tr>");
                   if(bet3ExactA!=0) htmlText.append("<tr><td style='font-size:14px;font-weight:bold;' align='center' colspan='2'>SUSCRIPCI&Oacute;N HASTA SORTEO " + bet3ExactA + "</td></tr>");
                   //if(receiptDiscounted != 0.0 || bet3ExactA!=0) htmlText.append(separateline);
   			} else if (saleType.equals("1"))
                   htmlText.append("<tr><td style='font-size:14px;font-weight:bold;'>TOTAL&nbsp;&nbsp;&nbsp;S/.</td><td style='font-size:14px;font-weight:bold;' align='right'>"
   								+ df.format(receiptAmount) + "</td></tr>" + separateline
                           + "<tr><td style='font-size:14px;font-weight:bold;' align='center' colspan='2'>TICKET GRATIS</td></tr>" + separateline);
   			else if (saleType.equals("2"))
                   htmlText.append("<tr><td style='font-size:14px;font-weight:bold;'>TOTAL&nbsp;&nbsp;&nbsp;S/.</td><td style='font-size:14px;font-weight:bold;' align='right'>"
   								+ df.format(receiptAmount) + "</td></tr>" + separateline
                           + "<tr><td style='font-size:14px;font-weight:bold;' align='center' colspan='2'>TICKET REGULAR</td></tr>" + separateline);
                           //+ "<tr><td style='font-size:14px;font-weight:bold;' align='center' colspan='2'>PROMOCION 2X1</td></tr>" + separateline);
   			else if (saleType.equals("9"))
                   htmlText.append("<tr><td style='font-size:14px;font-weight:bold;'>TOTAL&nbsp;&nbsp;&nbsp;S/.</td><td style='font-size:14px;font-weight:bold;' align='right'>0.00</td></tr>"
   								+ separateline);
   			// if(Integer.parseInt(p_clientTicket.getCtTwPrizeFlag()) == 1 &&
   			// Integer.parseInt(p_clientTicket.getCtTwDefinePrize()) == 2 &&
   			// Integer.parseInt(p_clientTicket.getCtPrizeFlag()) == 0)
   			//LoggerApi.Log.info("valor ---------->  " + p_clientTicket.getCtTwDefinePrize());
              // if (p_clientTicket.getCtTwDefinePrize() != null && Integer.parseInt(p_clientTicket.getCtTwDefinePrize()) == 2)
               //    htmlText.append("<tr><td align='center' colspan='2' style='font-size:12px;'>" + tn.trim() + " " + crc_v + "</td></tr><tr><td align='center' colspan='2'>"
                //           + barcode + "</td></tr>");
   			/*
   			 * else htmlText.append(
   			 * "<tr><td align='center' style='font-size:9px; padding:10px 0 10px 0;'>Si su boleto obtiene premio y decide cobrarlo en efectivo, deber&aacute; reimprimir el boleto en donde figura el c&oacute;digo de barras y mostrarlo a la promotora en un punto de venta para cobrar su premio en efectivo.</td></tr>"
   			 * );
   			 */
               // htmlText.append("<tr><td align='center' colspan='2' style='font-size:12px;'>"+tn.trim()+"</td></tr><tr><td align='center' colspan='2'>"+barcode+"</td></tr>");
               htmlText.append("<tr><td align='center' colspan='2' style='font-size:12px;'></td></tr><tr><td align='center' colspan='2'>&nbsp;</td></tr></table>");
   			// if(bp == 1) {
               //htmlText.append("</table><br /><div style='width:293px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'><strong>Atenci&oacute;n:</strong> Los premios est&aacute;n sujetos a los impuestos y retenciones de Ley (10%), excepto los premios menores o iguales a S/. 20.00. Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el boleto impreso con el c&oacute;digo de barras. No compartas esta informaci&oacute;n, ni la dejes a la vista de otros. ");
   			if (consecutive > 0 && (toDraw - fromDraw) > 0) {
               	htmlText.append("<br /><div style='width:293px; font-size:13.5px; font-family:Verdana, Arial, Helvetica, sans-serif;'> Sorteo Consecutivo Nº"+((1+1+toDraw-fromDraw)-(consecutive))+" de "+(1+toDraw-fromDraw)+".</div>");
   			}
               //<strong>Atenci&oacute;n:</strong> Los premios est&aacute;n sujetos a los impuestos y retenciones de Ley (10%), excepto los premios menores o iguales a S/. 20.00. Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el boleto impreso con el c&oacute;digo de barras. No compartas esta informaci&oacute;n, ni la dejes a la vista de otros. 
               htmlText.append("<br /><div style='width:328px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'>");
               // htmlText.append("</table><div style='width:696px;'>&nbsp;</div><br /><div style='width:293px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'><strong>Atenci&oacute;n:</strong> Para tu seguridad el c&oacute;digo de barras se mostrar&aacute; en caso tu boleto este premiado y hayas elegido la opci&oacute;n de cobrar tu premio en el Punto de Venta. ");
               if (gameNumber == Game.TINKA || gameNumber == Game.MEGATINKA || gameNumber == Game.GANADIARIO || gameNumber == Game.KABALA) {
                   // htmlText.append("Los premios est&aacute;n sujetos a los impuestos y retenciones de Ley (10%), excepto los premios menores o iguales a S/. 20.00. Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el boleto impreso con el c&oacute;digo de barras. No compartas esta informaci&oacute;n, ni la dejes a la vista de otros.");
   			} else if (gameNumber == Game.SUPER3) {
                   // htmlText.append("Los premios est&aacute;n sujetos a los impuestos y retenciones de Ley (10%), excepto el premio m&iacute;nimo de 2 soles, que no ser&aacute;n afectados por dicho impuesto para el cliente, y que Intralot pagar&aacute; el impuesto. Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el boleto impreso con el c&oacute;digo de barras. No compartas esta informaci&oacute;n, ni la dejes a la vista de otros.");
   			} else if (gameNumber == Game.GANAGOL) {
                   // htmlText.append("Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el ticket impreso con el c&oacute;digo de barras. No comparta esta informaci&oacute;n, ni la deje a la vista de otros.");
   			}
   			htmlText.append("</div>");
   			if (!solved.equals(""))
   				/*
   				 * htmlText.append(
   				 * "<div style='width:696px;'>&nbsp;</div><div style='width:696px;'>&nbsp;</div><table width='696' cellpadding='1' cellspacing='0' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif; border-collapse:collapse;' id='tblSolved'>"
   				 * + solved + "</table>");
   				 */
                   htmlText.append("<br /><br /><table width='696' cellpadding='1' cellspacing='0' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif; border-collapse:collapse;' id='tblSolved'>"
   								+ solved + "</table>");
   			htmlText.append("</td></tr></table></center></body></html>");
   			return htmlText;
   		} catch (Exception e) {
   			LoggerApi.severe(e);
   			throw e;
   		} finally {
   		}
   	}

    
   	@Override
   	public StringBuffer findCouponClientTicketTeApuestoGrecia(List<TicketProcedureGetRetailTeApuestoGrecia> p_detalleticket, TicketProcedureGetClientTicketRetail p_clientTicket, int tip_coupon) throws Exception {
   	    LoggerApi.Log.info("p_clientTicket=" + p_clientTicket + " tip_coupon=" + tip_coupon);
   	    StringBuffer htmlText = new StringBuffer();
   	    try {
   	        DecimalFormat df = new DecimalFormat("###,##0.00");
   	        
   	         // Definición de variables
   	        	
	   	     String ticketId = p_clientTicket.getCtTicketId() != null ? p_clientTicket.getCtTicketId() : "";
	   	     Double receiptAmount = p_clientTicket.getCtReceiptAmount() != null ? p_clientTicket.getCtReceiptAmount() : 0.0;
	   	     String ticketDate = p_clientTicket.getCtTicketDate() != null ? p_clientTicket.getCtTicketDate() : "";
	   	     Double maxAmountWinner = p_clientTicket.getCtMaxAmountWinner() != null ? p_clientTicket.getCtMaxAmountWinner() : 0.0;
	   	     Double prizeAmount = p_clientTicket.getCtPrizeAmount() != null ? p_clientTicket.getCtPrizeAmount() : 0.0;
	   	     String combination = p_clientTicket.getCtCombination() != null ? p_clientTicket.getCtCombination() : ""; 	  
	   	     String matrix3_multiplicador = p_clientTicket.getCtBetMatrix3() != null ? p_clientTicket.getCtBetMatrix3() : ""; 	 // multiplicador
	   	     String estado = p_clientTicket.getCtEstado() != null ? p_clientTicket.getCtEstado() : "";
   
   	        // Comienza a construir el HTML con estilos simplificados
   	        htmlText.append("<html><head><style>");
   	        htmlText.append(".tableHead { background-color: black; color: white; }");
   	        htmlText.append(".tableSubHead { background-color: #fddfc1; }");
   	        htmlText.append(".table { width: 100%; margin-bottom: 1rem; background-color: transparent; border-collapse: collapse; }");
   	        htmlText.append(".table th, .table td { padding: 0.15rem; vertical-align: top; border: 1px solid #dee2e6; text-align: left; }");
   	        htmlText.append(".table tr:hover { background-color: #dee2e6; }"); // Añadido: Cambia el color de la fila al pasar el mouse
   	        htmlText.append("body { min-width: 700px; font-size: small; font-family: Arial, sans-serif;}");
   	        htmlText.append("</style></head><body>");

   	        // Tabla Cupon
   	        htmlText.append("<table class='table'>");
   	        htmlText.append("<tbody>");
   	        htmlText.append("<tr class='tableHead'><th colspan='2'>Cupón</th></tr>");
   	        htmlText.append("<tr><th style='width:220px;'>Cód. De Apuesta</th><td>").append(ticketId).append("</td></tr>");
   	        htmlText.append("<tr><th>ID de cupón</th><td>").append(ticketId).append("</td></tr>");
   	        htmlText.append("<tr><th>Estado del cupón</th><td>").append(estado).append("</td></tr>");
   	        htmlText.append("<tr><th>Fecha</th><td>").append(ticketDate).append("</td></tr>");
   	        //htmlText.append("<tr><th>Tipo de apuesta</th><td>-</td></tr>");
   	        htmlText.append("<tr><th>Importe</th><td>S/").append(df.format(receiptAmount)).append("</td></tr>");
   	        htmlText.append("<tr><th>Ganancias Max.</th><td>S/").append(df.format(maxAmountWinner)).append("</td></tr>"); // ganancia maxima con tu apuesta
   	        htmlText.append("<tr><th>Ganancias Totales</th><td>S/").append(df.format(prizeAmount)).append("</td></tr>"); // ganancia obtenida
   	        htmlText.append("</tbody>");
   	        htmlText.append("</table>");

   	        // Apuestas
   	        htmlText.append("<table class='table'>");
   	        htmlText.append("<tbody>");
   	        htmlText.append("<tr class='tableHead'><th colspan='4'>Apuestas</th></tr>");
   	        htmlText.append("<tr class='tableSubHead'>");
   	        htmlText.append("<th style='width:220px;'>Combinada</th>");
   	        htmlText.append("<th>Multiplicador</th>");
   	        htmlText.append("<th>Importe</th>");
   	        htmlText.append("<th>Gan. Potencial</th>");
   	        htmlText.append("</tr>");
   	        htmlText.append("<tr>");
   	        htmlText.append("<td>").append(combination).append("</td>");
   	        htmlText.append("<td>").append(matrix3_multiplicador).append("</td>");
   	       // htmlText.append("<td>").append(df.format(p_detalleticket.size())).append(" x ").append(df.format(receiptAmount)).append(" = ").append(df.format(receiptAmount)).append("</td>");
   	        htmlText.append("<td>S/").append(df.format(receiptAmount)).append("</td>");
   	        htmlText.append("<td>S/").append(df.format(maxAmountWinner)).append("</td>");
   	        htmlText.append("</tr>");
   	        htmlText.append("</tbody>");
   	        htmlText.append("</table>");

   	        // Eventos
   	        htmlText.append("<table class='table'>");
   	        htmlText.append("<tbody>");
   	        htmlText.append("<tr class='tableHead'><th colspan='7'>Eventos</th></tr>");
   	        //htmlText.append("<tr class='tableSubHead'><th style='width:220px;'>Evento</th><th>Fecha de inicio</th><th>Mercados</th><th>Tipo</th><th>Hnd</th><th>Cuotas</th><th>Resultados</th></tr>");
   	        htmlText.append("<tr class='tableSubHead'><th style='width:220px;'>Evento</th><th>Mercados</th><th>Tipo</th><th>Hnd</th><th>Cuotas</th></tr>");
   	        if (p_detalleticket != null && !p_detalleticket.isEmpty()) {
   	            for (TicketProcedureGetRetailTeApuestoGrecia evento : p_detalleticket) {
   	                htmlText.append("<tr>");
   	                htmlText.append("<td>").append(evento.getEquipos()).append("</td>"); // Evento
   	                //htmlText.append("<td>").append(evento.getFechaInicio() != null ?  evento.getFechaInicio() : '-').append("</td>"); // Fecha de inicio
   	                htmlText.append("<td>").append(evento.getMercado() != null ? evento.getMercado() : '-').append("</td>"); // Mercados
   	                htmlText.append("<td>").append(evento.getCodigoSeleccion() != null ? evento.getCodigoSeleccion() : '-').append("</td>"); // Tipo
   	                htmlText.append("<td>").append("-").append("</td>"); // Hnd
   	                htmlText.append("<td>").append(evento.getOdd() != null ? evento.getOdd() : '-').append("</td>"); // Cuotas
   	                //htmlText.append("<td>").append(evento.getResultado()).append("</td>"); // Resultados
   	                htmlText.append("</tr>");
   	            }
   	        }

   	        htmlText.append("</table>");
   	        htmlText.append("</body></html>");
   	        
   	        return htmlText;
   	    } catch (Exception e) {
   	        LoggerApi.severe(e);
   	        throw e;
   	    } finally {
   	    }
   	}

   @Override
   public List<TicketProcedureGetTicketsFilterList> findTicketsListFilter(Integer p_clientId, String p_start_date,
   		String p_end_date) throws Exception {
   	LoggerApi.Log.info("cid=" + p_clientId + " start_date="+p_start_date + " end_date="+p_end_date);
   	List<TicketProcedureGetTicketsFilterList> resultQuery = new ArrayList<TicketProcedureGetTicketsFilterList>();
   	try {
   		Object[] values = new Object[3];
   		values[0] = p_clientId;
   		values[1] = p_start_date;
        values[2] = p_end_date;
   		resultQuery = super.findForNamed("TICKETSALE_GETTICKETS_FILTER_LIST", values);
   	} catch (Exception e) {
   		LoggerApi.severe(e);
   		throw e;
   	} finally {
   		LoggerApi.Log.info("ticketWeb size=" + resultQuery.size());
   	}
   	return resultQuery;
   }
   
	@Override
   	public StringBuffer findCouponByTicketRetailGanagol(TicketProcedureGetClientTicketRetail p_clientTicket,
   			int tip_coupon, ClientProcedureGetDetail clientDetail) throws Exception {
   		LoggerApi.Log.info("p_clientTicket=" + p_clientTicket + " tip_coupon=" + tip_coupon + " dni=" + clientDetail.getClDocNumber());
   		StringBuffer htmlText = new StringBuffer();
   		String context = Constants.contextCardWeb;

   		try {
   			//String[] betMatrix1 = null;
   			String[] betMatrix2 = null;
   			String[] betMatrix3 = null;
   			String[] betMatrix4 = null;
   			String[] betMatrix01 = null;
   			int bet1 = 0;
   			int bet2 = 0;
   			int bet3 = 0;
   			int bet4 = 0;
   			//String matrix1 = "";
   			String matrix2 = "";
   			String matrix3 = "";
   			String matrix4 = "";
   			String matrix01 = "";
   			String ticketId = "";
   			String docType = "";
   			String docNumber = "";
   			String clName = "";
   			String clientId = "";
   			String trnsNum = "0";
   			int fromDraw = 0;
   			String fromDrawDay = "";
   			int gameNumber = 0;
   			int numColumns = 0;
   			Double receiptAmount = 0.0;
   			int receiptNr = 0;
   			String ticketDate = "";
   			String ticketNumber = "";
   			/**** aqui */
   			int toDraw = 0;
   			int consecutive = 0;
   			String trmId = "0";
   			String gameName = "";// p_clientTicket.getGame().getName();
   			int betMultiA = 0;
   			int bet3ExactA = 0;
   			int bet3AnyA = 0;
   			int bet2ExactA = 0;
   			int bet1ExactA = 0;
   			int betMultiB = 0;
   			int bet3ExactB = 0;
   			int bet3AnyB = 0;
   			int bet2ExactB = 0;
   			int bet1ExactB = 0;
   			String saleType = null;
   			String imgGame = null;
   			String imgW = null;
   			String imgH = null;
   			String charity = null;
   			String webAddress = null;
   			String bm1 = "";
   			String mbm1 = "";
   			String bm2 = "";
   			String mbm2 = "";
   			String bm3 = "";
   			String mbm3 = "";
   			String bm4 = "";
   			String mbm4 = "";
   			String tn = "";// **aqui///
   			String solved = "";
   			int total = 0;
   			int betMax = 0;
   			// Add-Ons
   			String addOn1 = "";
   			String addOn2 = "";
   			String addOn3 = "";
   			String addOn4 = "";
            boolean flagPlus = Boolean.valueOf(ConnectionFactory.operationProperty("kabalaPlusEnabled", Constants.contextCardWeb).trim()).booleanValue();
           	boolean flagChauChamba = Boolean.valueOf(ConnectionFactory.operationProperty("kabalaChauChambaEnabled", Constants.contextCardWeb).trim()).booleanValue();
   			//if (p_clientTicket.getCtBetMatrix1() != null)
   			//	matrix1 = p_clientTicket.getCtBetMatrix1();
   			if (p_clientTicket.getCtBetMatrix2() != null)
   				matrix2 = p_clientTicket.getCtBetMatrix2();
   			if (p_clientTicket.getCtBetMatrix3() != null)
   				matrix3 = p_clientTicket.getCtBetMatrix3();
   			if (p_clientTicket.getCtBetMatrix4() != null)
   				matrix4 = p_clientTicket.getCtBetMatrix4();
   			if (p_clientTicket.getCtBetMatrix01() != null)
   				matrix01 = p_clientTicket.getCtBetMatrix01();
   			//if (matrix1 != null && !matrix1.equals(""))
   			//	betMatrix1 = matrix1.split(" ");
   			if (matrix2 != null && !matrix2.equals(""))
   				betMatrix2 = matrix2.split(" ");
   			if (matrix3 != null && !matrix3.equals(""))
   				betMatrix3 = matrix3.split(" ");
   			if (matrix4 != null && !matrix4.equals(""))
   				betMatrix4 = matrix4.split(" ");
   			if (matrix01 != null && !matrix01.equals(""))
   				
   				betMatrix01 = matrix01.split(" ");
   			if (p_clientTicket.getCtTicketId() != null)
   				ticketId = p_clientTicket.getCtTicketId();
   			
   			if (clientDetail.getClDocType() != null)
   				docType = clientDetail.getClDocType();
   			if (clientDetail.getClDocNumber() != null)
   				docNumber = clientDetail.getClDocNumber();
   			if (clientDetail.getClName() != null)
   				clName = clientDetail.getClName();
   			
   			if (p_clientTicket.getCtClientId() != null)
   				clientId = p_clientTicket.getCtClientId();
   			if (p_clientTicket.getCtTrnsNum() != null)
   				trnsNum = p_clientTicket.getCtTrnsNum();
   			 LoggerApi.Log.info("trnsNum=" + p_clientTicket.getCtTrnsNum());
   			if (p_clientTicket.getCtFromDraw() != null)
   				 LoggerApi.Log.info("fromDraw=" + p_clientTicket.getCtFromDraw());
   				fromDraw = p_clientTicket.getCtFromDraw();
   			if (p_clientTicket.getFromDrawDay() != null)
   				LoggerApi.Log.info("fromDrawDay=" + p_clientTicket.getFromDrawDay());
   				fromDrawDay = p_clientTicket.getFromDrawDay();
   			if (p_clientTicket.getCtGameNumber() != 0)
   				gameNumber = p_clientTicket.getCtGameNumber();
   			if (p_clientTicket.getCtNumColumns() != null)
   				numColumns = p_clientTicket.getCtNumColumns();
   			if (p_clientTicket.getCtReceiptAmount() != null)
   				receiptAmount = p_clientTicket.getCtReceiptAmount();
   			/*if (p_clientTicket.getCtReceiptDiscounted() != null)
   				receiptDiscounted = p_clientTicket.getCtReceiptDiscounted();*/
   			if (p_clientTicket.getCtReceiptNr() != null)
   				receiptNr = p_clientTicket.getCtReceiptNr();
   			if (p_clientTicket.getCtTicketDate() != null)
   				ticketDate = p_clientTicket.getCtTicketDate();
   			/***** aqui */
   			if (p_clientTicket.getCtTicketNumber() != null) {
   				ticketNumber = p_clientTicket.getCtTicketNumber();				
   			}
   			/******/
   			if (p_clientTicket.getCtToDraw() != null)
   				toDraw = p_clientTicket.getCtToDraw();
   			if (p_clientTicket.getCtTrmId() != null)
   				 LoggerApi.Log.info("trmId=" + p_clientTicket.getCtTrmId());
   				trmId = p_clientTicket.getCtTrmId();

   			Game game = new Game(gameNumber);
   			gameName = game.getName();
   			LoggerApi.Log.info("################## AD-ON ####################");
   			LoggerApi.Log.info("addOn1 -> " + addOn1);
   			LoggerApi.Log.info("addOn2 -> " + addOn2);
   			LoggerApi.Log.info("addOn3 -> " + addOn3);
   			LoggerApi.Log.info("addOn4 -> " + addOn4);
   			LoggerApi.Log.info("################## MATRIX ####################");
   			LoggerApi.Log.info("matrix1 -> " );
   			LoggerApi.Log.info("matrix2 -> " + matrix2);
   			LoggerApi.Log.info("matrix3 -> " + matrix3);
   			LoggerApi.Log.info("matrix4 -> " + matrix4);
   			LoggerApi.Log.info("matrix01 -> " + matrix01);

   			if (betMatrix01 != null) {
   				
   				bet1 = betMatrix01.length;
   				if (gameNumber == Game.GANAGOL)
   					for (int i = 0; i < bet1; i++) {
   						String betM1 = "";
   						for (int j = 0; j < betMatrix01[i].length(); j++) {
   							char betM = betMatrix01[i].charAt(j);
   							if (betMatrix01[i].length() == 1) {
   								if (j == 0 && betM == 'L')
   									betM1 += betM + "&ndash;&ndash;";
   								if (j == 0 && betM == 'E')
   									betM1 += "&ndash;" + betM + "&ndash;";
   								if (j == 0 && betM == 'V')
   									betM1 += "&ndash;&ndash;" + betM;
   							} else if (betMatrix01[i].length() == 2) {
   								if (j == 0 && betM == 'L')
   									betM1 += betM;
   								if (j == 0 && betM == 'E')
   									betM1 += "&ndash;" + betM;
   								if (j == 1 && betM == 'E')
   									betM1 += betM + "&ndash;";
   								if (j == 1 && betM == 'V')
   									if (betM1.equals("L"))
   										betM1 += "&ndash;" + betM;
   									else if (!betM1.equals("L"))
   										betM1 += betM;
   							} else if (betMatrix01[i].length() == 3)
   								betM1 += betM;
   						}
   						bm1 += betM1 + "<br/>";
   					}
   			}
   			if (betMatrix2 != null) {
   				bet2 = betMatrix2.length;
   				if (gameNumber == Game.GANAGOL)
   					for (int i = 0; i < bet2; i++) {
   						String betM2 = "";
   						for (int j = 0; j < betMatrix2[i].length(); j++) {
   							char betM = betMatrix2[i].charAt(j);
   							if (betMatrix2[i].length() == 1) {
   								if (j == 0 && betM == 'L')
   									betM2 += betM + "&ndash;&ndash;";
   								if (j == 0 && betM == 'E')
   									betM2 += "&ndash;" + betM + "&ndash;";
   								if (j == 0 && betM == 'V')
   									betM2 += "&ndash;&ndash;" + betM;
   							} else if (betMatrix2[i].length() == 2) {
   								if (j == 0 && betM == 'L')
   									betM2 += betM;
   								if (j == 0 && betM == 'E')
   									betM2 += "&ndash;" + betM;
   								if (j == 1 && betM == 'E')
   									betM2 += betM + "&ndash;";
   								if (j == 1 && betM == 'V')
   									if (betM2.equals("L"))
   										betM2 += "&ndash;" + betM;
   									else if (!betM2.equals("L"))
   										betM2 += betM;
   							} else if (betMatrix2[i].length() == 3)
   								betM2 += betM;
   						}
   						bm2 += betM2 + "<br/>";
   					}
   			}
   			if (betMatrix3 != null) {
   				bet3 = betMatrix3.length;
   				if (gameNumber == Game.GANAGOL)
   					for (int i = 0; i < bet3; i++) {
   						String betM3 = "";
   						for (int j = 0; j < betMatrix3[i].length(); j++) {
   							char betM = betMatrix3[i].charAt(j);
   							if (betMatrix3[i].length() == 1) {
   								if (j == 0 && betM == 'L')
   									betM3 += betM + "&ndash;&ndash;";
   								if (j == 0 && betM == 'E')
   									betM3 += "&ndash;" + betM + "&ndash;";
   								if (j == 0 && betM == 'V')
   									betM3 += "&ndash;&ndash;" + betM;
   							} else if (betMatrix3[i].length() == 2) {
   								if (j == 0 && betM == 'L')
   									betM3 += betM;
   								if (j == 0 && betM == 'E')
   									betM3 += "&ndash;" + betM;
   								if (j == 1 && betM == 'E')
   									betM3 += betM + "&ndash;";
   								if (j == 1 && betM == 'V')
   									if (betM3.equals("L"))
   										betM3 += "&ndash;" + betM;
   									else if (!betM3.equals("L"))
   										betM3 += betM;
   							} else if (betMatrix3[i].length() == 3)
   								betM3 += betM;
   						}
   						bm3 += betM3 + "<br/>";
   					}
   			}
   			if (betMatrix4 != null) {
   				bet4 = betMatrix4.length;
   				if (gameNumber == Game.GANAGOL)
   					for (int i = 0; i < bet4; i++) {
   						String betM4 = "";
   						for (int j = 0; j < betMatrix4[i].length(); j++) {
   							char betM = betMatrix4[i].charAt(j);
   							if (betMatrix4[i].length() == 1) {
   								if (j == 0 && betM == 'L')
   									betM4 += betM + "&ndash;&ndash;";
   								if (j == 0 && betM == 'E')
   									betM4 += "&ndash;" + betM + "&ndash;";
   								if (j == 0 && betM == 'V')
   									betM4 += "&ndash;&ndash;" + betM;
   							} else if (betMatrix4[i].length() == 2) {
   								if (j == 0 && betM == 'L')
   									betM4 += betM;
   								if (j == 0 && betM == 'E')
   									betM4 += "&ndash;" + betM;
   								if (j == 1 && betM == 'E')
   									betM4 += betM + "&ndash;";
   								if (j == 1 && betM == 'V')
   									if (betM4.equals("L"))
   										betM4 += "&ndash;" + betM;
   									else if (!betM4.equals("L"))
   										betM4 += betM;
   							} else if (betMatrix4[i].length() == 3)
   								betM4 += betM;
   						}
   						bm4 += betM4 + "<br/>";
   					}
   			}
   			/*** aqui ****/
   			for (int i = 0; i < ticketNumber.length(); i++)
   				if ((i + 1) % 5 == 0)
   					tn += ticketNumber.charAt(i) + " ";
   				else
   					tn += "" + ticketNumber.charAt(i);
   			if (gameNumber == Game.GANAGOL) {
   				imgGame = "imgGanagol.jpg";
   				imgW = "250";
   				imgH = "60";
   				charity = "La Tinka S.A.";
   				webAddress = "www.ganagol.com.pe";
   			} 

   			if (gameNumber == Game.GANAGOL) {
   				if (bet1 == 14) {
   					String bm = "";
   					int cbm = 0;
   					for (int i = 0; i < bet1; i++) {
   						String betM1 = "";
   						for (int j = 0; j < betMatrix01[i].length(); j++) {
   							char betM = betMatrix01[i].charAt(j);
   							if (betMatrix01[i].length() == 1) {
   								if (j == 0 && betM == 'L')
   									betM1 += betM + "&ndash;&ndash;";
   								if (j == 0 && betM == 'E')
   									betM1 += "&ndash;" + betM + "&ndash;";
   								if (j == 0 && betM == 'V')
   									betM1 += "&ndash;&ndash;" + betM;
   							} else if (betMatrix01[i].length() == 2) {
   								if (j == 0 && betM == 'L')
   									betM1 += betM;
   								if (j == 0 && betM == 'E')
   									betM1 += "&ndash;" + betM;
   								if (j == 1 && betM == 'E')
   									betM1 += betM + "&ndash;";
   								if (j == 1 && betM == 'V')
   									if (betM1.equals("L"))
   										betM1 += "&ndash;" + betM;
   									else if (!betM1.equals("L"))
   										betM1 += betM;
   							} else if (betMatrix01[i].length() == 3)
   								betM1 += betM;
   						}
   						bm += betM1 + "<br/>";
   						cbm += betMatrix01[i].length();
   					}
   					if (cbm > 14) {
   						ArrayList<String[]> fullBets = BussinessSaleDispatcher.getBets(gameNumber, matrix01);
   						int i = 0;
   						for (String[] c : fullBets) {
   							if (i == 0)
   								solved += "<tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;<br/>01:<br/>02:<br/>03:<br/>04:<br/>05:<br/>06:<br/>07:<br/>08:<br/>09:<br/>10:<br/>11:<br/>12:<br/>13:<br/>14:</td>"
   										+ "<td align='center' style='padding: 0 0 5px 0;'><b>&nbsp;&nbsp;&nbsp;A&nbsp;&nbsp;&nbsp;<br/>"
                                           + bm
                                           + "</b></td><td align='center' style='padding: 0 0 5px 0;'>";
   							else if (i % 25 == 0 && c.length > 0)
   								solved += "</td></tr><tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;<br/>01:<br/>02:<br/>03:<br/>04:<br/>05:<br/>06:<br/>07:<br/>08:<br/>09:<br/>10:<br/>11:<br/>12:<br/>13:<br/>14:"
   										+ "</td><td align='center' style='padding: 0 0 5px 0;'>&nbsp;</td><td align='center' style='padding: 0 0 5px 0;'>";
   							if (i >= 0 && i < 9)
   								solved += "&nbsp;&nbsp;<u>" + (i + 1) + "</u>&nbsp;&nbsp;<br/>";
   							else if (i >= 9 && i < 99)
   								solved += "&nbsp;<u>" + (i + 1) + "</u>&nbsp;<br/>";
   							else
   								solved += "<u>" + (i + 1) + "</u><br/>";
   							for (String s : c)
   								solved += s + "<br/>";
   							if (i == fullBets.size() - 1)
   								solved += "</td></tr>";
   							else
   								solved += "</td><td align='center' style='padding: 0 0 5px 0;'>";
   							i++;
   						}
   						solved += "<tr><td colspan='15'><br/>" + i + " jugadas<br/><br/></td></tr>";
   						total += i;
   					}
   				}
   				if (bet2 == 14) {
   					String bm = "";
   					int cbm = 0;
   					for (int i = 0; i < bet2; i++) {
   						String betM2 = "";
   						for (int j = 0; j < betMatrix2[i].length(); j++) {
   							char betM = betMatrix2[i].charAt(j);
   							if (betMatrix2[i].length() == 1) {
   								if (j == 0 && betM == 'L')
   									betM2 += betM + "&ndash;&ndash;";
   								if (j == 0 && betM == 'E')
   									betM2 += "&ndash;" + betM + "&ndash;";
   								if (j == 0 && betM == 'V')
   									betM2 += "&ndash;&ndash;" + betM;
   							} else if (betMatrix2[i].length() == 2) {
   								if (j == 0 && betM == 'L')
   									betM2 += betM;
   								if (j == 0 && betM == 'E')
   									betM2 += "&ndash;" + betM;
   								if (j == 1 && betM == 'E')
   									betM2 += betM + "&ndash;";
   								if (j == 1 && betM == 'V')
   									if (betM2.equals("L"))
   										betM2 += "&ndash;" + betM;
   									else if (!betM2.equals("L"))
   										betM2 += betM;
   							} else if (betMatrix2[i].length() == 3)
   								betM2 += betM;
   						}
   						bm += betM2 + "<br/>";
   						cbm += betMatrix2[i].length();
   					}
   					if (cbm > 14) {
   						ArrayList<String[]> fullBets = BussinessSaleDispatcher.getBets(gameNumber, matrix2);
   						int i = 0;
   						for (String[] c : fullBets) {
   							if (i == 0)
   								solved += "<tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;<br/>01:<br/>02:<br/>03:<br/>04:<br/>05:<br/>06:<br/>07:<br/>08:<br/>09:<br/>10:<br/>11:<br/>12:<br/>13:<br/>14:</td>"
   										+ "<td align='center' style='padding: 0 0 5px 0;'><b>&nbsp;&nbsp;&nbsp;B&nbsp;&nbsp;&nbsp;<br/>"
                                           + bm
                                           + "</b></td><td align='center' style='padding: 0 0 5px 0;'>";
   							else if (i % 25 == 0 && c.length > 0)
   								solved += "</td></tr><tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;<br/>01:<br/>02:<br/>03:<br/>04:<br/>05:<br/>06:<br/>07:<br/>08:<br/>09:<br/>10:<br/>11:<br/>12:<br/>13:<br/>14:"
   										+ "</td><td align='center' style='padding: 0 0 5px 0;'>&nbsp;</td><td align='center' style='padding: 0 0 5px 0;'>";
   							if (i >= 0 && i < 9)
   								solved += "&nbsp;&nbsp;<u>" + (i + 1) + "</u>&nbsp;&nbsp;<br/>";
   							else if (i >= 9 && i < 99)
   								solved += "&nbsp;<u>" + (i + 1) + "</u>&nbsp;<br/>";
   							else
   								solved += "<u>" + (i + 1) + "</u><br/>";
   							for (String s : c)
   								solved += s + "<br/>";
   							if (i == fullBets.size() - 1)
   								solved += "</td></tr>";
   							else
   								solved += "</td><td align='center' style='padding: 0 0 5px 0;'>";
   							i++;
   						}
   						solved += "<tr><td colspan='15'><br/>" + i + " jugadas<br/><br/></td></tr>";
   						total += i;
   					}
   				}
   				if (bet3 == 14) {
   					String bm = "";
   					int cbm = 0;
   					for (int i = 0; i < bet3; i++) {
   						String betM3 = "";
   						for (int j = 0; j < betMatrix3[i].length(); j++) {
   							char betM = betMatrix3[i].charAt(j);
   							if (betMatrix3[i].length() == 1) {
   								if (j == 0 && betM == 'L')
   									betM3 += betM + "&ndash;&ndash;";
   								if (j == 0 && betM == 'E')
   									betM3 += "&ndash;" + betM + "&ndash;";
   								if (j == 0 && betM == 'V')
   									betM3 += "&ndash;&ndash;" + betM;
   							} else if (betMatrix3[i].length() == 2) {
   								if (j == 0 && betM == 'L')
   									betM3 += betM;
   								if (j == 0 && betM == 'E')
   									betM3 += "&ndash;" + betM;
   								if (j == 1 && betM == 'E')
   									betM3 += betM + "&ndash;";
   								if (j == 1 && betM == 'V')
   									if (betM3.equals("L"))
   										betM3 += "&ndash;" + betM;
   									else if (!betM3.equals("L"))
   										betM3 += betM;
   							} else if (betMatrix3[i].length() == 3)
   								betM3 += betM;
   						}
   						bm += betM3 + "<br/>";
   						cbm += betMatrix3[i].length();
   					}
   					if (cbm > 14) {
   						ArrayList<String[]> fullBets = BussinessSaleDispatcher.getBets(gameNumber, matrix3);
   						int i = 0;
   						for (String[] c : fullBets) {
   							if (i == 0)
   								solved += "<tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;<br/>01:<br/>02:<br/>03:<br/>04:<br/>05:<br/>06:<br/>07:<br/>08:<br/>09:<br/>10:<br/>11:<br/>12:<br/>13:<br/>14:</td>"
   										+ "<td align='center' style='padding: 0 0 5px 0;'><b>&nbsp;&nbsp;&nbsp;C&nbsp;&nbsp;&nbsp;<br/>"
                                           + bm
                                           + "</b></td><td align='center' style='padding: 0 0 5px 0;'>";
   							else if (i % 25 == 0 && c.length > 0)
   								solved += "</td></tr><tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;<br/>01:<br/>02:<br/>03:<br/>04:<br/>05:<br/>06:<br/>07:<br/>08:<br/>09:<br/>10:<br/>11:<br/>12:<br/>13:<br/>14:"
   										+ "</td><td align='center' style='padding: 0 0 5px 0;'>&nbsp;</td><td align='center' style='padding: 0 0 5px 0;'>";
   							if (i >= 0 && i < 9)
   								solved += "&nbsp;&nbsp;<u>" + (i + 1) + "</u>&nbsp;&nbsp;<br/>";
   							else if (i >= 9 && i < 99)
   								solved += "&nbsp;<u>" + (i + 1) + "</u>&nbsp;<br/>";
   							else
   								solved += "<u>" + (i + 1) + "</u><br/>";
   							for (String s : c)
   								solved += s + "<br/>";
   							if (i == fullBets.size() - 1)
   								solved += "</td></tr>";
   							else
   								solved += "</td><td align='center' style='padding: 0 0 5px 0;'>";
   							i++;
   						}
   						solved += "<tr><td colspan='15'><br/>" + i + " jugadas<br/><br/></td></tr>";
   						total += i;
   					}
   				}
   				if (bet4 == 14) {
   					String bm = "";
   					int cbm = 0;
   					for (int i = 0; i < bet4; i++) {
   						String betM4 = "";
   						for (int j = 0; j < betMatrix4[i].length(); j++) {
   							char betM = betMatrix4[i].charAt(j);
   							if (betMatrix4[i].length() == 1) {
   								if (j == 0 && betM == 'L')
   									betM4 += betM + "&ndash;&ndash;";
   								if (j == 0 && betM == 'E')
   									betM4 += "&ndash;" + betM + "&ndash;";
   								if (j == 0 && betM == 'V')
   									betM4 += "&ndash;&ndash;" + betM;
   							} else if (betMatrix4[i].length() == 2) {
   								if (j == 0 && betM == 'L')
   									betM4 += betM;
   								if (j == 0 && betM == 'E')
   									betM4 += "&ndash;" + betM;
   								if (j == 1 && betM == 'E')
   									betM4 += betM + "&ndash;";
   								if (j == 1 && betM == 'V')
   									if (betM4.equals("L"))
   										betM4 += "&ndash;" + betM;
   									else if (!betM4.equals("L"))
   										betM4 += betM;
   							} else if (betMatrix4[i].length() == 3)
   								betM4 += betM;
   						}
   						bm += betM4 + "<br/>";
   						cbm += betMatrix4[i].length();
   					}
   					if (cbm > 14) {
   						ArrayList<String[]> fullBets = BussinessSaleDispatcher.getBets(gameNumber, matrix4);
   						int i = 0;
   						for (String[] c : fullBets) {
   							if (i == 0)
   								solved += "<tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;<br/>01:<br/>02:<br/>03:<br/>04:<br/>05:<br/>06:<br/>07:<br/>08:<br/>09:<br/>10:<br/>11:<br/>12:<br/>13:<br/>14:</td>"
   										+ "<td align='center' style='padding: 0 0 5px 0;'><b>&nbsp;&nbsp;&nbsp;D&nbsp;&nbsp;&nbsp;<br/>"
                                           + bm
                                           + "</b></td><td align='center' style='padding: 0 0 5px 0;'>";
   							else if (i % 25 == 0 && c.length > 0)
   								solved += "</td></tr><tr valign='top'><td align='center' style='padding: 0 0 5px 0;'>&nbsp;<br/>01:<br/>02:<br/>03:<br/>04:<br/>05:<br/>06:<br/>07:<br/>08:<br/>09:<br/>10:<br/>11:<br/>12:<br/>13:<br/>14:"
   										+ "</td><td align='center' style='padding: 0 0 5px 0;'>&nbsp;</td><td align='center' style='padding: 0 0 5px 0;'>";
   							if (i >= 0 && i < 9)
   								solved += "&nbsp;&nbsp;<u>" + (i + 1) + "</u>&nbsp;&nbsp;<br/>";
   							else if (i >= 9 && i < 99)
   								solved += "&nbsp;<u>" + (i + 1) + "</u>&nbsp;<br/>";
   							else
   								solved += "<u>" + (i + 1) + "</u><br/>";
   							for (String s : c)
   								solved += s + "<br/>";
   							if (i == fullBets.size() - 1)
   								solved += "</td></tr>";
   							else
   								solved += "</td><td align='center' style='padding: 0 0 5px 0;'>";
   							i++;
   						}
   						solved += "<tr><td colspan='15'><br/>" + i + " jugadas<br/><br/></td></tr>";
   						total += i;
   					}
   				}
   				if (total > 0)
                       solved += "<tr><td colspan='15'>Total:&nbsp;" + total + "&nbsp;apuestas generadas de jugadas m&uacute;ltiples.</td></tr>";
   			}
   			
   			DecimalFormat df = new DecimalFormat("###,##0.00");
               String apparea = String.valueOf(ConnectionFactory.operationProperty("applicationArea", context)).toString().trim();
               String testusers = String.valueOf(ConnectionFactory.operationProperty("testUsers", context)).toString().trim();
   			saleType = "0";
               //String separateline = "<tr><td colspan='2' align='center' style='font-size:9px;'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>";
   			String separateline = "<tr><td colspan='2' align='center' style='font-size:9px;'>&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;</td></tr>";
   			htmlText.append("<html><head><script type='text/javascript'>function oncontextmenuHandler(){return false;}"
   					+ "document.oncontextmenu = oncontextmenuHandler;function disableselect(e){return false;}"
   					+ "function reEnable(){return true;}document.onselectstart=new Function ('return false');"
   					+ "if (window.sidebar){document.onmousedown=disableselect;document.onclick=reEnable;}<\"+\"/script></head><body><center><table width='100%' cellpadding='0' cellspacing='0' style='margin:0; padding:0; border:0;'><tr><td align='center'>");
               //htmlText.append("<table width='292' cellpadding='0' cellspacing='0' style='margin:0; padding:9px; border:black 1px solid; font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>");
               htmlText.append("<table width='327' cellpadding='0' cellspacing='0' style='margin:0; padding:9px; border:black 1px solid; font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif;'>");
               htmlText.append("<tr><td style='font-size:9px;' colspan='2'>Id1&nbsp;: " + clientId + "<br/>Id2&nbsp;: " + ticketId + "<BR>Id3 : " + docType + ' ' + docNumber + ' ' +clName + "<br/>" + "</td></tr>");
   			/* Quitar logo de Intralot - Inicio - @jmoran 2019-05-28 */
   			/*
               htmlText.append("<tr><td colspan='2' align='center'><img src='"
                       + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim()
                       + "/layer-view-image/client/imgIntralot.gif' width='74' height='22' border='0'/></td></tr>"
                       + "<tr><td colspan='2' align='center' style='font-size:9px;'>RUC&nbsp;&nbsp;20506035121</td></tr>");
   			 */
   			/* Mostrar logos de sorteos en UAT */
   			/*
               htmlText.append("<tr><td colspan='2' align='center'><img src='"
                       + String.valueOf(ConnectionFactory.operationProperty("lotosaleServerURI", context)).toString().trim() + "/layer-view-image/client/" + imgGame
   			 */
   			htmlText.append("<tr><td colspan='2' align='center'><img src='"+Constants.eCommerceHome+"layer-view-image/client/" + imgGame 
                       //+ "' width='" + imgW + "' height='" + imgH + "' border='0'/></td></tr>" + "<tr><td align='center' colspan='2'>" + charity + "</td></tr>"
   					+ "' width='" + imgW + "' height='" + imgH + "' border='0'/></td></tr>"
   					+ "<tr><td style='font-size:9px;' align='center' colspan='2'>" + webAddress + "</td></tr>");
               htmlText.append("<tr><td colspan='2' align='center' style='font-size:9px;'>La Tinka S.A.&nbsp;&nbsp;RUC&nbsp;&nbsp;20506035121</td></tr>"); // cambio de posicion RUC
   			/* Quitar logo de La Tinka - Fin - @jmoran 2019-05-28 */
   			if (apparea.equals("development"))
                   htmlText.append("<tr><td style='font-size:16px;font-weight:bold;' align='center' colspan='2'>BOLETO DE PRUEBAS</td></tr>");
   			else if (apparea.equals("production"))
   				if (testusers != null && !testusers.equals("")) {
   					String[] users = testusers.split(",");
   					for (String user : users)
   						if (user.equals(clientId)) {
                               htmlText.append("<tr><td style='font-size:16px;font-weight:bold;' align='center' colspan='2'>BOLETO SIN VALOR</td></tr>");
   							break;
   						}
   				}
   			if (saleType.equals("9"))
                   htmlText.append("<tr><td style='font-size:16px;font-weight:bold;' align='center' colspan='2'>TICKET CAMBIO</td></tr>");
               htmlText.append("<tr><td align='center' colspan='2'>" + ticketDate.substring(0, 10) + "&nbsp;&nbsp;&nbsp;&nbsp;&minus;&nbsp;&nbsp;&nbsp;&nbsp;"
               		 + ticketDate.substring(11) + "</td></tr>"
                        + "<tr><td align='center' colspan='2'>" + charity + "</td></tr>" // @jmoran 2019-05-29
   					+ "<tr><td>AGENCIA:&nbsp;" + trmId /*trmId.substring(0, 6)*/ + "-0001 "
                       /*(char) (Integer.parseInt(trmId.substring(6)) + 64)*/ + "</td>" + "<td align='right'>TRN:&nbsp;" + trnsNum /*StringUtils.leftPad(trnsNum, 10, "0")*/ + "&nbsp;"
                       + "</td></tr>" + "<tr><td>" + gameName + "&nbsp;(" + StringUtils.leftPad("" + gameNumber, 3, "0") + ")&nbsp;"
                       + receiptNr + "</td><td align='right'>PERIODO:&nbsp;" + fromDrawDay + "</td></tr>");
   			// if(!typeid.equals("") && !numberid.equals(""))
               // htmlText.append("<tr><td></td><td align='right'>"+typeid+":&nbsp;"+numberid+"</td></tr>");
   			htmlText.append(separateline);
   			if (gameNumber == Game.GANAGOL) {
                   htmlText.append("<tr><td colspan='2'><font style='font-size:14px;font-weight:bold;'>GRUPO:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;B&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;C&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;D</font></td></tr>"
   								+ separateline
   								+ "<tr><td colspan='2'><table width='100%' cellpadding='0' cellspacing='0' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif; border-collapse:collapse;'><tr><td width='20%' align='center'>"
                           + "01:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>02:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>03:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>04:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font>"
                           + "<br/>05:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>06:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>07:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>08:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font>"
                           + "<br/>09:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>10:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>11:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>12:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>13:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font><br/>14:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font></td>");
   				if (!bm1.equals(""))
                       htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>" + bm1 + "</font></td>");
   				else
                       htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*</font></td>");
   				if (!bm2.equals(""))
                       htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>" + bm2 + "</font></td>");
   				else
                       htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*</font></td>");
   				if (!bm3.equals(""))
                       htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>" + bm3 + "</font></td>");
   				else
                       htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*</font></td>");
   				if (!bm4.equals(""))
   					htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>" + bm4 + "</font></td>");
   				else
   					htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*<br/>*</font></td>");
   				
   				htmlText.append("</tr></table></td></tr>" + separateline);
   				htmlText.append(
   						"<tr><td colspan='2'><font style='font-size:14px;font-weight:bold;'>SUPERGOL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td></tr>"
   								+ "<tr><td colspan='2'><table width='40%' cellpadding='0' cellspacing='0' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif; border-collapse:collapse;'><tr><td width='20%' align='center'>"
   								+ "A:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font>"
   								+ "<br/>B:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font>"
   								+ "<br/>C:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font>"
   								+ "<br/>D:<font style='font-size:14px;font-weight:bold;'>&nbsp;</font>" + "</td>");
   				if (!addOn1.equals(""))
   					htmlText.append("<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>"
   							+ addOn1 + "</font><br>");
   				else
   					htmlText.append(
   							"<td width='20%' align='center'><font style='font-size:14px;font-weight:bold;'>*</font><br>");
   				if (!addOn2.equals(""))
   					htmlText.append("<font style='font-size:14px;font-weight:bold;'>" + addOn2 + "</font><br>");
   				else
   					htmlText.append("<font style='font-size:14px;font-weight:bold;'>*</font><br>");
   				if (!addOn3.equals(""))
   					htmlText.append("<font style='font-size:14px;font-weight:bold;'>" + addOn3 + "</font><br>");
   				else
   					htmlText.append("<font style='font-size:14px;font-weight:bold;'>*</font><br>");
   				if (!addOn4.equals(""))
   					htmlText.append("<font style='font-size:14px;font-weight:bold;'>" + addOn4 + "</font></td>");
   				else
   					htmlText.append("<font style='font-size:14px;font-weight:bold;'>*</font></td>");

   				htmlText.append("</tr></table></td></tr>");

   			} 
               htmlText.append(separateline + "<tr><td style='font-size:14px;font-weight:bold;' align='center' colspan='2'>COL:&nbsp;&nbsp;"
   					+ StringUtils.leftPad("" + numColumns, 2, "0") + "</td></tr>" + separateline);
   			if (gameNumber != Game.GANAGOL)
                   htmlText.append("<tr><td style='font-size:14px;' align='center' colspan='2'>BOLETO&nbsp;VALIDO&nbsp;PARA&nbsp;"
                           + StringUtils.leftPad("" + (toDraw - fromDraw + 1), 2, "0") + "&nbsp;SORTEO(S)</td></tr>");
   			htmlText.append("<tr><td style='font-size:13px;font-weight:bold;' align='center' colspan='2'>DESDE&nbsp;" + StringUtils.leftPad("" + fromDraw, 4, "0")
                       + "&nbsp;DEL&nbsp;" + fromDrawDay + "&nbsp;HASTA&nbsp;" + StringUtils.leftPad("" + toDraw, 4, "0") + "</td></tr>" + separateline);
   			if (saleType.equals("0")) {
                   htmlText.append("<tr><td style='font-size:14px;font-weight:bold;'>TOTAL&nbsp;&nbsp;&nbsp;S/.</td><td style='font-size:14px;font-weight:bold;' align='right'>"
   								+ df.format(receiptAmount) + "</td></tr>" + separateline);
   				/*if (receiptDiscounted != 0.0) {
                       htmlText.append("<tr><td style='font-size:14px;font-weight:bold;' align='center' colspan='2'>+GANO DESCUENTO&nbsp;&nbsp;S/." + df.format(receiptDiscounted)
                               + "</td></tr>");
   				}*/
                   if(bet1ExactA!=0) htmlText.append("<tr><td style='font-size:14px;font-weight:bold;' align='center' colspan='2'>BOLETO DE SUSCRIPCI&Oacute;N " + bet1ExactA + " DE " + bet2ExactA + "</td></tr>");
                   if(bet3ExactA!=0) htmlText.append("<tr><td style='font-size:14px;font-weight:bold;' align='center' colspan='2'>SUSCRIPCI&Oacute;N HASTA SORTEO " + bet3ExactA + "</td></tr>");
                   //if(receiptDiscounted != 0.0 || bet3ExactA!=0) htmlText.append(separateline);
   			} else if (saleType.equals("1"))
                   htmlText.append("<tr><td style='font-size:14px;font-weight:bold;'>TOTAL&nbsp;&nbsp;&nbsp;S/.</td><td style='font-size:14px;font-weight:bold;' align='right'>"
   								+ df.format(receiptAmount) + "</td></tr>" + separateline
                           + "<tr><td style='font-size:14px;font-weight:bold;' align='center' colspan='2'>TICKET GRATIS</td></tr>" + separateline);
   			else if (saleType.equals("2"))
                   htmlText.append("<tr><td style='font-size:14px;font-weight:bold;'>TOTAL&nbsp;&nbsp;&nbsp;S/.</td><td style='font-size:14px;font-weight:bold;' align='right'>"
   								+ df.format(receiptAmount) + "</td></tr>" + separateline
                           + "<tr><td style='font-size:14px;font-weight:bold;' align='center' colspan='2'>TICKET REGULAR</td></tr>" + separateline);
                           //+ "<tr><td style='font-size:14px;font-weight:bold;' align='center' colspan='2'>PROMOCION 2X1</td></tr>" + separateline);
   			else if (saleType.equals("9"))
                   htmlText.append("<tr><td style='font-size:14px;font-weight:bold;'>TOTAL&nbsp;&nbsp;&nbsp;S/.</td><td style='font-size:14px;font-weight:bold;' align='right'>0.00</td></tr>"
   								+ separateline);
   			// if(Integer.parseInt(p_clientTicket.getCtTwPrizeFlag()) == 1 &&
   			// Integer.parseInt(p_clientTicket.getCtTwDefinePrize()) == 2 &&
   			// Integer.parseInt(p_clientTicket.getCtPrizeFlag()) == 0)
   			//LoggerApi.Log.info("valor ---------->  " + p_clientTicket.getCtTwDefinePrize());
              // if (p_clientTicket.getCtTwDefinePrize() != null && Integer.parseInt(p_clientTicket.getCtTwDefinePrize()) == 2)
               //    htmlText.append("<tr><td align='center' colspan='2' style='font-size:12px;'>" + tn.trim() + " " + crc_v + "</td></tr><tr><td align='center' colspan='2'>"
                //           + barcode + "</td></tr>");
   			/*
   			 * else htmlText.append(
   			 * "<tr><td align='center' style='font-size:9px; padding:10px 0 10px 0;'>Si su boleto obtiene premio y decide cobrarlo en efectivo, deber&aacute; reimprimir el boleto en donde figura el c&oacute;digo de barras y mostrarlo a la promotora en un punto de venta para cobrar su premio en efectivo.</td></tr>"
   			 * );
   			 */
               // htmlText.append("<tr><td align='center' colspan='2' style='font-size:12px;'>"+tn.trim()+"</td></tr><tr><td align='center' colspan='2'>"+barcode+"</td></tr>");
               htmlText.append("<tr><td align='center' colspan='2' style='font-size:12px;'></td></tr><tr><td align='center' colspan='2'>&nbsp;</td></tr></table>");
   			// if(bp == 1) {
               //htmlText.append("</table><br /><div style='width:293px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'><strong>Atenci&oacute;n:</strong> Los premios est&aacute;n sujetos a los impuestos y retenciones de Ley (10%), excepto los premios menores o iguales a S/. 20.00. Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el boleto impreso con el c&oacute;digo de barras. No compartas esta informaci&oacute;n, ni la dejes a la vista de otros. ");
   			if (consecutive > 0 && (toDraw - fromDraw) > 0) {
               	htmlText.append("<br /><div style='width:293px; font-size:13.5px; font-family:Verdana, Arial, Helvetica, sans-serif;'> Sorteo Consecutivo Nº"+((1+1+toDraw-fromDraw)-(consecutive))+" de "+(1+toDraw-fromDraw)+".</div>");
   			}
               //<strong>Atenci&oacute;n:</strong> Los premios est&aacute;n sujetos a los impuestos y retenciones de Ley (10%), excepto los premios menores o iguales a S/. 20.00. Intralot reconocer&aacute; como acreedor del premio a la primera persona que se presente al cobro portando el boleto impreso con el c&oacute;digo de barras. No compartas esta informaci&oacute;n, ni la dejes a la vista de otros. 
               htmlText.append("<br /><div style='width:328px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'>");
               // htmlText.append("</table><div style='width:696px;'>&nbsp;</div><br /><div style='width:293px; font-size:9px; font-family:Verdana, Arial, Helvetica, sans-serif; text-align:justify;'><strong>Atenci&oacute;n:</strong> Para tu seguridad el c&oacute;digo de barras se mostrar&aacute; en caso tu boleto este premiado y hayas elegido la opci&oacute;n de cobrar tu premio en el Punto de Venta. ");     
   			htmlText.append("</div>");
   			if (!solved.equals(""))
   				/*
   				 * htmlText.append(
   				 * "<div style='width:696px;'>&nbsp;</div><div style='width:696px;'>&nbsp;</div><table width='696' cellpadding='1' cellspacing='0' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif; border-collapse:collapse;' id='tblSolved'>"
   				 * + solved + "</table>");
   				 */
                   htmlText.append("<br /><br /><table width='696' cellpadding='1' cellspacing='0' style='font-size:10px; font-family:Geneva, Arial, Helvetica, sans-serif; border-collapse:collapse;' id='tblSolved'>"
   								+ solved + "</table>");
   			htmlText.append("</td></tr></table></center></body></html>");
   			return htmlText;
   		} catch (Exception e) {
   			LoggerApi.severe(e);
   			throw e;
   		} finally {
   		}
   	}

	 	@Override
	   	public List<TicketProcedureGetRetailTeApuestoGrecia> findByClientTickeTeApuestoGrecia(int p_programa, int p_cpn) throws Exception {
	   		LoggerApi.Log.info("p_programa=" + p_programa + " p_cpn=" + p_cpn);
	   		List<TicketProcedureGetRetailTeApuestoGrecia> resultQuery = new ArrayList<TicketProcedureGetRetailTeApuestoGrecia>();
	   		try {
	   			Object[] values = new Object[2];
	   			values[0] = p_programa;
	   			values[1] = p_cpn;
	   			resultQuery = super.findForNamed("TICKETSALE_GETCLIENTTICKET_RETAIL_GRECIA", values);
	   		} catch (Exception e) {
	   			LoggerApi.severe(e);
	   			throw e;
	   		} finally {
	   			if (resultQuery != null) {
	                   LoggerApi.Log.info("p_programa="+p_programa+" p_cpn=" + p_cpn);
	   			} else {
	   				LoggerApi.Log.info("p_programa=" + p_programa + " objectDomain=" + resultQuery);
	   			}
	   		}
	   		return resultQuery;
	   	}

		@Override
		public Boolean searchDetailGrecia(String p_programa, String p_cpn) throws Exception {
			//LoggerApi.Log.info("p_programa="+p_programa+" p_cpn=" + p_cpn);
			List<TicketProcedureSearchDetailGrecia> resultQuery = new ArrayList<TicketProcedureSearchDetailGrecia>();
			try {
				Object[] values = new Object[2];
	   			values[0] = p_programa;
	   			values[1] = p_cpn;
	   			
		    	resultQuery = super.findForNamed("SEARCH_DETAIL_GRECIA", values);
		    	TicketProcedureSearchDetailGrecia objectDomain = DataAccessUtils.uniqueResult(resultQuery);
				return Boolean.valueOf(objectDomain.getFound());
				
			}catch (Exception e) {
	   			LoggerApi.severe(e);
	   			throw e; 
	   		} 
		}
		
		@Override
	    public ClientProcedureGetDetail findClientDetail(Integer p_clientid) throws Exception {
			LoggerApi.Log.info("cid=" + p_clientid);
			List<ClientProcedureGetDetail> resultQuery = new ArrayList<ClientProcedureGetDetail>();
			ClientProcedureGetDetail objectDomain = new ClientProcedureGetDetail();
			try {
				Object[] values = new Object[1];
				values[0] = p_clientid;
				resultQuery = super.findForNamed("SP_CLIENT_DETAIL", values);
				objectDomain = DataAccessUtils.uniqueResult(resultQuery);
			} catch (Exception e) {
				LoggerApi.severe(e);
				throw e;
			} finally {
				if (objectDomain != null) {
	                LoggerApi.Log.info("cid="+p_clientid);
				} else {
					LoggerApi.Log.info("cid=" + p_clientid + " objectDomain=" + objectDomain);
				}
			}
			return objectDomain;
		}
		
}
