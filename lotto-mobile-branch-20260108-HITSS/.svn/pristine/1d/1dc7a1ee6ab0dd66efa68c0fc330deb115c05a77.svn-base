package pe.com.intralot.loto.layer.controller.client.boimpl;

import java.text.SimpleDateFormat;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.intralot.loto.layer.controller.client.bo.ClientBalanceBo;
import pe.com.intralot.loto.layer.controller.client.bo.ClientLotocardBo;
import pe.com.intralot.loto.layer.controller.security.bo.SecurityLoginBo;
import pe.com.intralot.loto.layer.dto.client.ClientBalanceDTO;
import pe.com.intralot.loto.layer.dto.client.ClientBalanceDataDTO;
import pe.com.intralot.loto.layer.dto.client.ClientBalanceInformationRequestDTO;
import pe.com.intralot.loto.layer.dto.client.ClientBalanceInformationResponseDTO;
import pe.com.intralot.loto.layer.model.pojo.BalanceProcedureGetWinCup;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientBalanceDao;
import pe.com.intralot.loto.layer.model.pojo.BalanceProcedureGetMontoPorDia;
import pe.com.intralot.loto.layer.model.pojo.BalanceProcedureGetMontoPorDiaAgora;
import pe.com.intralot.loto.layer.model.pojo.BalanceProcedureResultEvalRulesAgora;
import pe.com.intralot.loto.layer.model.pojo.BalanceProcedureResultEvalRulesPefe;
import pe.com.intralot.loto.layer.model.pojo.BalanceProcedureResultEvalRulesSpay;
import pe.com.intralot.loto.layer.model.pojo.BalanceProcedureResultEvalRulesVisa;
import pe.com.intralot.loto.layer.model.pojo.BbvaProcedureCheckTransaction;
import pe.com.intralot.loto.layer.model.pojo.BbvaProcedureDefineTransaction;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureAccountData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureAccountDataPart;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureCodeValidation;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetBalanceList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetBalanceListFilter;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetBicolorPromoList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetGamesBonusList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetTeApuestoBonusList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetTeApuestoPromoList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureTokenValidation;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateStateRechargeAgora;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureValidateNewPhoneAgora;
import pe.com.intralot.loto.layer.model.pojo.ListTicketBicolorClient;
import pe.com.intralot.loto.layer.model.pojo.ProcedureDefineTransactionIzipay;
import pe.com.intralot.loto.layer.model.pojo.ProcedurePayTransactionIzipay;
import pe.com.intralot.loto.layer.model.pojo.ProcedureRegisterErrorIzipay;
import pe.com.intralot.loto.layer.model.pojo.ProcedureYapePlinTupayVerifyTransaction;
import pe.com.intralot.loto.layer.model.pojo.ProcedureYapePlinVerifyTransaction;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.DateAPI;


@Service("beanClientBalanceBo")
public class ClientBalanceBoImpl implements ClientBalanceBo {
  	
	//protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private ClientBalanceDao beanClientBalanceDao;	
	
	@Autowired
    private SecurityLoginBo beanSecurityLoginBo;
	
	@Autowired
	private ClientLotocardBo beanClientLotocardBo;
	
 
	/*public List<ClientBalance> getCurrentAccount(Integer id) throws Exception{
		List<ClientBalance> objectList=new ArrayList<ClientBalance>();
		LoggerApi.Log.info("id: "+id);
	    try {
			objectList=beanClientBalanceDao.finByPk(id);
			return objectList;
			
		} catch (Exception e) {
			
			LoggerApi.severe(e);			
			throw new Exception(e);	
			
		} finally{
			if(objectList!=null){
				LoggerApi.Log.info("objectList: "+objectList.size());	
			}else{
			LoggerApi.Log.info("objectList: "+"null");
			}
			}		
		
	}*/

	public List<ClientProcedureGetBalanceList> getCurrentAccount(Integer p_clientId) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientId+" getCurrentAccount");

		List<ClientProcedureGetBalanceList> resultQueryList = new ArrayList<ClientProcedureGetBalanceList>();
		try {
			resultQueryList = beanClientBalanceDao.finByPk(p_clientId);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) {
				LoggerApi.Log.info("cid=" + p_clientId+" getCurrentAccount size= " + resultQueryList.size());
			}
		}
		return resultQueryList;
	}
	
	public List<ClientProcedureGetTeApuestoPromoList> getTeApuestoPromoAccount(Integer p_clientId) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientId+" getTeApuestoPromoAccount");

		List<ClientProcedureGetTeApuestoPromoList> resultQueryList = new ArrayList<ClientProcedureGetTeApuestoPromoList>();
		try {
			resultQueryList = beanClientBalanceDao.findTeApuestoPromoByPk(p_clientId);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) {
				LoggerApi.Log.info("cid=" + p_clientId+" getTeApuestoPromoAccount size= " + resultQueryList.size());
			}
		}
		return resultQueryList;
	}
	
	
	public List<ClientProcedureGetBicolorPromoList> getBicolorPromoAccount(Integer p_clientId) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientId+" getTeApuestoPromoAccount");

		List<ClientProcedureGetBicolorPromoList> resultQueryList = new ArrayList<ClientProcedureGetBicolorPromoList>();
		try {
			resultQueryList = beanClientBalanceDao.findBicolorPromoByPk(p_clientId);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) {
				LoggerApi.Log.info("cid=" + p_clientId+" getBicolorPromoAccount size= " + resultQueryList.size());
			}
		}
		return resultQueryList;
	}
	
	public List<ListTicketBicolorClient> getListBicolorTickets(Integer p_clientId) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientId+" getTeApuestoPromoAccount");

		List<ListTicketBicolorClient> resultQueryList = new ArrayList<ListTicketBicolorClient>();
		try {
			resultQueryList = beanClientBalanceDao.getListBicolorTickets(p_clientId);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) {
				LoggerApi.Log.info("cid=" + p_clientId+" getListBicolorTickets size= " + resultQueryList.size());
			}
		}
		return resultQueryList;
	}
	
	@Override
	public BalanceProcedureGetWinCup findWinProm(Integer p_clientId, String p_prom_id) throws Exception {
		
		return beanClientBalanceDao.findWinProm(p_clientId,p_prom_id);
	}

	public List<ClientProcedureGetTeApuestoBonusList> getTeApuestoBonusAccount(Integer p_clientId) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientId+" getTeApuestoBonusAccount");

		List<ClientProcedureGetTeApuestoBonusList> resultQueryList = new ArrayList<ClientProcedureGetTeApuestoBonusList>();
		try {
			resultQueryList = beanClientBalanceDao.findTeApuestoBonusByPk(p_clientId);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) {
				LoggerApi.Log.info("cid=" + p_clientId+" getTeApuestoBonusAccount size= " + resultQueryList.size());
			}
		}
		return resultQueryList;
	}
	
	public List<ClientProcedureGetGamesBonusList> getGamesBonusAccount(Integer p_clientId) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientId+" getGamesBonusAccount");

		List<ClientProcedureGetGamesBonusList> resultQueryList = new ArrayList<ClientProcedureGetGamesBonusList>();
		try {
			resultQueryList = beanClientBalanceDao.findGamesBonusByPk(p_clientId);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) {
				LoggerApi.Log.info("cid=" + p_clientId+" getGamesBonusAccount size= " + resultQueryList.size());
			}
		}
		return resultQueryList;
	}
	
	public ClientProcedureAccountData findAccountData(Integer p_clientId) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientId+" findAccountData");
		ClientProcedureAccountData objectDomain = new ClientProcedureAccountData();
        try {
            objectDomain = beanClientBalanceDao.findAccountData(p_clientId);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
           //if (objectDomain != null)
           //     LoggerApi.Log.info("cid=" + p_clientId+" findAccountData objectDomain=" + objectDomain);  
        }
        return objectDomain;
		
	}

	@Override
	public ClientProcedureCodeValidation codePromotionalValidation(Object[] values) throws Exception {
		return beanClientBalanceDao.codePromotionalValidation(values);
	}
	
	@Override
	public List<BalanceProcedureGetMontoPorDia> findMontoPorDia(Integer p_clientId) throws Exception {

		List<BalanceProcedureGetMontoPorDia> resultQueryList = new ArrayList<BalanceProcedureGetMontoPorDia>();
		try {
			resultQueryList = beanClientBalanceDao.findMontoPorDia(p_clientId);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) {
				LoggerApi.Log.info("size= " + resultQueryList.size());
			}
		}
		return resultQueryList;
	}

	@Override
	public ClientProcedureAccountDataPart findAccountDataPart(Integer p_clientId) throws Exception {
		return beanClientBalanceDao.findAccountDataPart(p_clientId);
	}

	@Override
	public List<BalanceProcedureGetMontoPorDiaAgora> findMontoPorDiaAgora(Integer clientId) throws Exception {
		return beanClientBalanceDao.findMontoPorDiaAgora(clientId);
	}

	@Override
	public ClientProcedureUpdateStateRechargeAgora updateStateRechargeAgora(Integer clientId, String phoneUpdateAgora, String phoneUpdate) throws Exception {
		return beanClientBalanceDao.updateStateRechargeAgora(clientId, phoneUpdateAgora, phoneUpdate);
	}

	@Override
	public ClientProcedureValidateNewPhoneAgora validateNewPhoneAgora(Integer clientId, String phoneUpdate)
			throws Exception {
		return beanClientBalanceDao.validateNewPhoneAgora(clientId, phoneUpdate);
	}

	@Override
	public BalanceProcedureResultEvalRulesAgora resultEvalRulesAgora(Integer clientId, Double amount) throws Exception {
		return beanClientBalanceDao.resultEvalRulesAgora(clientId, amount);
	}

	@Override
	public BalanceProcedureResultEvalRulesVisa resultEvalRulesVisa(Integer clientId, Double amount) throws Exception {
		return beanClientBalanceDao.resultEvalRulesVisa(clientId, amount);
	}

	@Override
	public ProcedureYapePlinVerifyTransaction yapePlinVerifyTransaction(Integer p_clientId, String channel)
			throws Exception {
		return beanClientBalanceDao.yapePlinVerifyTransaction(p_clientId, channel);
	}

	@Override
	public BbvaProcedureDefineTransaction getDefineTransactionBBVA(String clientId, double amount, String bonokey, String platform,	String operatorId) throws Exception {
		return beanClientBalanceDao.getDefineTransactionBBVA(clientId, amount, bonokey, platform, operatorId);
	}

	@Override
	public List<BbvaProcedureCheckTransaction> getCheckTransactionBBVA(String clientId) throws Exception {
		return beanClientBalanceDao.getCheckTransactionBBVA(clientId);
	}

	@Override
	public int expiryTransactionBBVA(String trx, String clientId) throws Exception {
		return beanClientBalanceDao.expiryTransactionBBVA(trx, clientId);
	}

	@Override
	public Object[] verifyTransactionBBVA(String trx, String clientId) throws Exception {
		return beanClientBalanceDao.verifyTransactionBBVA(trx, clientId);
	}

	@Override
	public BalanceProcedureResultEvalRulesPefe resultEvalRulesPefe(Integer clientId, Double amount) throws Exception {
		return beanClientBalanceDao.resultEvalRulesPefe(clientId, amount);
	}

	@Override
	public BalanceProcedureResultEvalRulesSpay resultEvalRulesSpay(Integer clientId, Double amount) throws Exception {
		return beanClientBalanceDao.resultEvalRulesSpay(clientId, amount);
	}

	@Override
	public ProcedurePayTransactionIzipay payTransactionIzipay(Object[] values) throws Exception {
		return beanClientBalanceDao.payTransactionIzipay(values);
	}

	@Override
	public ProcedureRegisterErrorIzipay registerErrorIzipay(Object[] values) throws Exception {
		return beanClientBalanceDao.registerErrorIzipay(values);
	}
	
	@Override
	public ProcedureDefineTransactionIzipay defineTransactionIzipay(Object[] values) throws Exception {
		return beanClientBalanceDao.defineTransactionIzipay(values);
	}
	
	@Override
	public ProcedureYapePlinTupayVerifyTransaction yapePlinTupayVerifyTransaction(Integer p_clientId, String channel)
			throws Exception {
		return beanClientBalanceDao.yapePlinTupayVerifyTransaction(p_clientId, channel);
	}
	
	@Override
	public List<ClientProcedureGetBalanceListFilter> getCurrentAccountFilter(Integer p_clientId, String start_date,
			String end_date) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientId+" start_date=" + start_date + " end_date="+ end_date);

		List<ClientProcedureGetBalanceListFilter> resultQueryList = new ArrayList<ClientProcedureGetBalanceListFilter>();
		try {
			resultQueryList = beanClientBalanceDao.finByBalanceFilter(p_clientId, start_date, end_date);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) {
				LoggerApi.Log.info("cid=" + p_clientId+" getCurrentAccountFilter size= " + resultQueryList.size());
			}
		}
		return resultQueryList;
	}

	@Override
	public ClientBalanceInformationResponseDTO getClientBalanceInformation(ClientBalanceInformationRequestDTO request) throws Exception {
		ClientBalanceInformationResponseDTO response = new ClientBalanceInformationResponseDTO();
		
		try {
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(request.getToken(), request.getClientIp());
			
			if (!tokenValidation.getStatus().equals("OK")) {
				response.setStatus("ERROR");
				response.setMessage(tokenValidation.getMessage());
				return response;
			}
			
			Integer clientId = Integer.parseInt(tokenValidation.getClientId());
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
			
			List<ClientBalanceDTO> balances = new ArrayList<ClientBalanceDTO>();
			ClientBalanceDataDTO clientBalanceDataDTO = new ClientBalanceDataDTO();		
			clientBalanceDataDTO.setTotal(beanClientLotocardBo.findClientById(Integer.valueOf(clientId)).getBalanceAmount());
			
			if(request.getStartDate() != null && request.getEndDate() != null) {
				List<ClientProcedureGetBalanceListFilter> rawList = this.getCurrentAccountFilter(clientId, request.getStartDate(), request.getEndDate());
				Collections.sort(rawList, new Comparator<ClientProcedureGetBalanceListFilter>() {
					public int compare(ClientProcedureGetBalanceListFilter a, ClientProcedureGetBalanceListFilter b) {
						Date dateA = DateAPI.parseToDate(a.getBalanceDate());
						Date dateB = DateAPI.parseToDate(b.getBalanceDate());
						return dateB.compareTo(dateA);
					}
				});
				for(ClientProcedureGetBalanceListFilter item : rawList) {
					ClientBalanceDTO clientBalanceDTO = new ClientBalanceDTO();
					clientBalanceDTO.setDescription(item.getDescription());
					clientBalanceDTO.setClientCarrier(item.getClientCarrier());
					clientBalanceDTO.setDate(DateAPI.formatBuyDate(item.getBalanceDate()));
					clientBalanceDTO.setAmount(item.getLoadAmount());
					balances.add(clientBalanceDTO);
				}
				
			}else {
				List<ClientProcedureGetBalanceList> rawList = this.getCurrentAccount(clientId);
				Collections.sort(rawList, new Comparator<ClientProcedureGetBalanceList>() {
					public int compare(ClientProcedureGetBalanceList a, ClientProcedureGetBalanceList b) {
						Date dateA = DateAPI.parseToDate(a.getBalanceDate());
						Date dateB = DateAPI.parseToDate(b.getBalanceDate());
						return dateB.compareTo(dateA);
					}
				});
				for(ClientProcedureGetBalanceList item: rawList) {
					ClientBalanceDTO clientBalanceDTO = new ClientBalanceDTO();
					clientBalanceDTO.setDescription(item.getDescription());
					clientBalanceDTO.setClientCarrier(item.getClientCarrier());
					clientBalanceDTO.setDate(DateAPI.formatBuyDate(item.getBalanceDate()));
					clientBalanceDTO.setAmount(item.getLoadAmount());
					balances.add(clientBalanceDTO);
				}
			}

			clientBalanceDataDTO.setBalances(balances);
			response.setStatus("OK");
			response.setData(clientBalanceDataDTO);
		}catch(Exception ex) {
			response.setStatus("ERROR");
			response.setMessage(ex.getMessage());
			return response;
		}
		
		return response;
	}
	
}