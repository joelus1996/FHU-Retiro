package pe.com.intralot.loto.layer.controller.client.boimpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.intralot.loto.layer.controller.client.bo.ClientPlayBo;
import pe.com.intralot.loto.layer.controller.security.bo.SecurityLoginBo;
import pe.com.intralot.loto.layer.dto.client.ClientGameDTO;
import pe.com.intralot.loto.layer.dto.client.ClientGameDataDTO;
import pe.com.intralot.loto.layer.dto.client.ClientGameInformationRequestDTO;
import pe.com.intralot.loto.layer.dto.client.ClientGameInformationResponseDTO;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientDao;
import pe.com.intralot.loto.layer.model.persistence.dao.ProcedureDao;
import pe.com.intralot.loto.layer.model.pojo.Client;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureTokenValidation;
import pe.com.intralot.loto.utils.StringLib;
import pe.com.intralot.loto.utils.DateAPI;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import javax.servlet.http.HttpSession;

@Service("beanClientPlayBo")
public class ClientPlayBoImpl implements ClientPlayBo {

	//protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private ProcedureDao beanProcedureDao;

	@Autowired
	private ClientDao beanClientDao;
	
	@Autowired
    private SecurityLoginBo beanSecurityLoginBo;

	@SuppressWarnings("rawtypes")
	public HashMap[] getClientPlayCouponAll(Integer id) throws Exception {
		HashMap[] objectMap = null;
		
		HashMap[] objectMapRetail = null;
		
		Integer gid = 0, fdrwid = 0, tdrwid = 0;
		try {
			objectMap = beanProcedureDao.getClientPlayCoupon(id);
			objectMapRetail = beanProcedureDao.getClientRetailPlayCoupon(id);
			
	        if ((objectMap == null || objectMap.length == 0) && (objectMapRetail == null || objectMapRetail.length == 0)) {
	            return new HashMap[0]; // Retornar un arreglo vacío si no hay datos
	        }
	        
	        // Combinar ambas listas
	        int totalSize = (objectMap != null ? objectMap.length : 0) + (objectMapRetail != null ? objectMapRetail.length : 0);
	        HashMap[] combinedArray = new HashMap[totalSize];
	        
	        int index = 0;
	        if (objectMap != null) {
	            System.arraycopy(objectMap, 0, combinedArray, index, objectMap.length);
	            index += objectMap.length;
	        }
	        if (objectMapRetail != null) {
	            System.arraycopy(objectMapRetail, 0, combinedArray, index, objectMapRetail.length);
	        } 
			
			for(HashMap map : combinedArray) {
				gid = (map.get("GAMEID")!=null)?Integer.parseInt(map.get("GAMEID").toString()):null;
				fdrwid = (map.get("GFROMDRAW")!=null)?Integer.parseInt(map.get("GFROMDRAW").toString()):null;
				tdrwid = (map.get("GTODRAW")!=null)?Integer.parseInt(map.get("GTODRAW").toString()):null;
				if((gid==Game.TINKA||gid==Game.GANAGOL||gid==Game.GANADIARIO||gid==Game.KABALA)&&fdrwid>5000) map.put("fdrwid", fdrwid-5000);
				else map.put("fdrwid", fdrwid);
				if((gid==Game.TINKA||gid==Game.GANAGOL||gid==Game.GANADIARIO||gid==Game.KABALA)&&tdrwid>5000) map.put("tdrwid", tdrwid-5000);
				else map.put("tdrwid", tdrwid);
			}
			
			return combinedArray;

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw new Exception(e);

		}
	}

	@SuppressWarnings("rawtypes")
	public HashMap[] getClientPlayCouponPP(Integer id, Integer ticket) throws Exception {
		HashMap[] objectMap = null;
		Integer gid = 0, fdrwid = 0, tdrwid = 0;
		try {
			objectMap = beanProcedureDao.getClientPlayCouponPP(id,ticket);
			for(HashMap map : objectMap) {
				gid = (map.get("GAMEID")!=null)?Integer.parseInt(map.get("GAMEID").toString()):null;
				fdrwid = (map.get("GFROMDRAW")!=null)?Integer.parseInt(map.get("GFROMDRAW").toString()):null;
				tdrwid = (map.get("GTODRAW")!=null)?Integer.parseInt(map.get("GTODRAW").toString()):null;
				if((gid==Game.TINKA||gid==Game.GANAGOL||gid==Game.GANADIARIO||gid==Game.KABALA)&&fdrwid>5000) map.put("fdrwid", fdrwid-5000);
				else map.put("fdrwid", fdrwid);
				if((gid==Game.TINKA||gid==Game.GANAGOL||gid==Game.GANADIARIO||gid==Game.KABALA)&&tdrwid>5000) map.put("tdrwid", tdrwid-5000);
				else map.put("tdrwid", tdrwid);
			}
			return objectMap;

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw new Exception(e);
		} 
	}
		
	public Client findClientById(Integer id) throws Exception {
		//LoggerApi.Log.info("cid=" + id+" findClientById");
		Client objectPojo = new Client();
		try {
			objectPojo = beanClientDao.findByPk(id);
			return objectPojo;

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw new Exception(e);

		} finally {
			/*
			if(objectPojo!=null){
				LoggerApi.Log.info("cid=" + id+" findClientById objectPojo: "+objectPojo.toString());
			}else{
				LoggerApi.Log.info("cid=" + id+" findClientById objectPojo: null");
			}
			*/
		}

	}

	public pe.com.intralot.loto.layer.model.bean.Client findAccountData(Integer id) throws Exception {
		//LoggerApi.Log.info("cid=" + id+" findAccountData");
		pe.com.intralot.loto.layer.model.bean.Client objectMap = null;
		try {
			objectMap = beanProcedureDao.findAccountData(id);

			return objectMap;

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw new Exception(e);

		} finally {
			/*
			if(objectMap!=null){
				LoggerApi.Log.info("cid=" + id+" findAccountData objectMap: " + objectMap);
			}else{
				LoggerApi.Log.info("cid=" + id+" findAccountData objectMap: null");	
			}
			*/
		}

	}
	
	@SuppressWarnings("rawtypes")
	public HashMap[] getClientPlayCouponFilterAll(Integer id,  String start_date,
			String end_date) throws Exception {
		
		HashMap[] objectMap = null;
		HashMap[] objectMapRetail = null;
		
		Integer gid = 0, fdrwid = 0, tdrwid = 0;
		try {
			objectMap = beanProcedureDao.getClientPlayCouponFilter(id, start_date, end_date);
			
			objectMapRetail = beanProcedureDao.getClientPlayRetailCouponFilter(id, start_date, end_date);

	        if ((objectMap == null || objectMap.length == 0) && (objectMapRetail == null || objectMapRetail.length == 0)) {
	            return new HashMap[0]; // Retornar un arreglo vacío si no hay datos
	        }
	        // Combinar ambas listas
	        int totalSize = (objectMap != null ? objectMap.length : 0) + (objectMapRetail != null ? objectMapRetail.length : 0);
	        HashMap[] combinedArray = new HashMap[totalSize];
	        
	        int index = 0;
	        if (objectMap != null) {
	            System.arraycopy(objectMap, 0, combinedArray, index, objectMap.length);
	            index += objectMap.length;
	        }
	        if (objectMapRetail != null) {
	            System.arraycopy(objectMapRetail, 0, combinedArray, index, objectMapRetail.length);
	        } 
	        
			for(HashMap map : combinedArray) {
				gid = (map.get("GAMEID")!=null)?Integer.parseInt(map.get("GAMEID").toString()):null;
				fdrwid = (map.get("GFROMDRAW")!=null)?Integer.parseInt(map.get("GFROMDRAW").toString()):null;
				tdrwid = (map.get("GTODRAW")!=null)?Integer.parseInt(map.get("GTODRAW").toString()):null;
				if((gid==Game.TINKA||gid==Game.GANAGOL||gid==Game.GANADIARIO||gid==Game.KABALA)&&fdrwid>5000) map.put("fdrwid", fdrwid-5000);
				else map.put("fdrwid", fdrwid);
				if((gid==Game.TINKA||gid==Game.GANAGOL||gid==Game.GANADIARIO||gid==Game.KABALA)&&tdrwid>5000) map.put("tdrwid", tdrwid-5000);
				else map.put("tdrwid", tdrwid);
			}
			
			return combinedArray;

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw new Exception(e);

		} 
	}
	
	@SuppressWarnings("rawtypes")
	public HashMap[] getTicketDetailRetail(Integer p_clientId, Integer gameId, String ticket) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientId+" gameId="+ gameId +" ticket="+ticket);
		HashMap[] objectMap = null;
		Integer gid = 0, fdrwid = 0, tdrwid = 0;
		try {
			objectMap = beanProcedureDao.getTicketDetailRetail(p_clientId, gameId, ticket);
			for(HashMap map : objectMap) {
				gid = (map.get("GAMEID")!=null)?Integer.parseInt(map.get("GAMEID").toString()):null;
				fdrwid = (map.get("GFROMDRAW")!=null)?Integer.parseInt(map.get("GFROMDRAW").toString()):null;
				tdrwid = (map.get("GTODRAW")!=null)?Integer.parseInt(map.get("GTODRAW").toString()):null;
				if((gid==Game.TINKA||gid==Game.GANAGOL||gid==Game.GANADIARIO||gid==Game.KABALA)&&fdrwid>5000) map.put("fdrwid", fdrwid-5000);
				else map.put("fdrwid", fdrwid);
				if((gid==Game.TINKA||gid==Game.GANAGOL||gid==Game.GANADIARIO||gid==Game.KABALA)&&tdrwid>5000) map.put("tdrwid", tdrwid-5000);
				else map.put("tdrwid", tdrwid);
			}
			return objectMap;

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw new Exception(e);

		} 
	}
	
	@SuppressWarnings("rawtypes")
	public HashMap[] getTicketDetailRetailGrecia(Integer p_programa, Integer p_cpn) throws Exception {
		LoggerApi.Log.info("p_programa=" + p_programa+" p_cpn=" + p_cpn);
		HashMap[] objectMap = null;
		try {
			objectMap = beanProcedureDao.getTicketDetailRetailGrecia(p_programa, p_cpn);
			return objectMap;

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw new Exception(e);

		} finally {
		}
	}

	@Override
	public ClientGameInformationResponseDTO getClientGameInformation(ClientGameInformationRequestDTO request, HttpSession session) throws Exception {
		ClientGameInformationResponseDTO response = new ClientGameInformationResponseDTO();
		
		try {
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(request.getToken(), request.getClientIp());
			
			if (!tokenValidation.getStatus().equals("OK")) {
				response.setStatus("ERROR");
				response.setMessage(tokenValidation.getMessage());
				return response;
			}
			
			Integer idClient = Integer.parseInt(tokenValidation.getClientId());
			response.setToken(tokenValidation.getRechargeToken());
			
        	String startdate = request.getStartDate();
    		String enddate = request.getEndDate();
    		
    		if (startdate != null && enddate != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
				Calendar calendarioinicio = Calendar.getInstance();
				calendarioinicio.setTime(sdf.parse(startdate));
				
				Calendar calendariofin = Calendar.getInstance();
				calendariofin.setTime(sdf.parse(enddate));
				
				Date timeinicio = calendarioinicio.getTime();
				Date timefin = calendariofin.getTime();
				
				if(timefin.before(timeinicio)) {
					response.setStatus("ERROR");
					response.setMessage("La fecha de finalización debe ser posterior a la fecha de inicio.");
					return response;
				}
    		}
			
			List<ClientGameDTO> games = new ArrayList<ClientGameDTO>();
			ClientGameDataDTO clientGameDataDTO = new ClientGameDataDTO();
			
			HashMap[] coupons = null;
			
			if(request.getStartDate() != null && request.getEndDate() != null) {
				coupons = this.getClientPlayCouponFilterAll(idClient, request.getStartDate(), request.getEndDate());
			}else {
				coupons = this.getClientPlayCouponAll(idClient);
			}
			
			coupons = sortByTicketDateDesc(coupons, "GDATE");

			if (coupons != null && coupons.length > 0) {
				for (HashMap coupon : coupons) {
					ClientGameDTO clientGameDTO = new ClientGameDTO();
					clientGameDTO.setDescription(StringLib.getValueOrEmpty(coupon.get("GNAME")));
					clientGameDTO.setDate(DateAPI.DateToformatBuyDate(coupon.get("GDATE")));
					clientGameDTO.setAmount(Double.parseDouble(StringLib.getValueOrEmpty(coupon.get("GAMOUNT"))));
					String rawStatus = StringLib.getValueOrEmpty(coupon.get("STATUS")).replaceAll("<.*?>", "").trim();
					if (rawStatus.equalsIgnoreCase("Con premio")) {
					    rawStatus = "Ganado";
					}
					clientGameDTO.setStatus(rawStatus);
					clientGameDTO.setType(StringLib.getValueOrEmpty(coupon.get("GTYPE")));
					clientGameDTO.setGameId(coupon.get("GAMEID") != null ? Integer.parseInt(coupon.get("GAMEID").toString()) : null);
					clientGameDTO.setCode(StringLib.getValueOrEmpty(coupon.get("GCODE")));
					clientGameDTO.setTicket(StringLib.getValueOrEmpty(coupon.get("GTYPE")).equals("99") ? StringLib.getValueOrEmpty(coupon.get("GCODE")) :  StringLib.getValueOrEmpty(coupon.get("GTICKET")));
					clientGameDTO.setSalesChannel(StringLib.getValueOrEmpty(coupon.get("SALESCHANNEL")));
					clientGameDTO.setPidTicket(StringLib.getValueOrEmpty(coupon.get("CT_PID_TICKET")));
					clientGameDTO.setProgram(StringLib.getValueOrEmpty(coupon.get("GPROGRAM")));
					clientGameDTO.setCpn(StringLib.getValueOrEmpty(coupon.get("GCPN")));
					games.add(clientGameDTO);
                }
				
				session.setAttribute("client_play_show_informationList", coupons);
				session.setAttribute("client_play_show_informationListFilter", coupons);
				session.setAttribute("r_List", coupons.length);
			}else {
				session.setAttribute("client_play_show_informationList", new ArrayList());
				session.setAttribute("client_play_show_informationListFilter", new ArrayList());
				session.setAttribute("r_List", 0);
			}

			clientGameDataDTO.setGames(games);
			response.setStatus("OK");
			response.setData(clientGameDataDTO);
		}catch(Exception ex) {
			response.setStatus("ERROR");
			response.setMessage(ex.getMessage());
			return response;
		}
		
		return response;
	}
	
	@SuppressWarnings("rawtypes")
	public static HashMap[] sortByTicketDateDesc(HashMap[] array, final String dateField) {
		if (array == null || array.length == 0) {
			return new HashMap[0];
		}

		List<HashMap> list = Arrays.asList(array);

		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		Collections.sort(list, new Comparator<HashMap>() {
			public int compare(HashMap a, HashMap b) {
				try {
					String strDateA = (String) a.get(dateField);
					String strDateB = (String) b.get(dateField);

					Date dateA = sdf.parse(strDateA);
					Date dateB = sdf.parse(strDateB);

					return dateB.compareTo(dateA);
				} catch (Exception e) {
					return 0;
				}
			}
		});

		return list.toArray(new HashMap[list.size()]);
	}
	
}