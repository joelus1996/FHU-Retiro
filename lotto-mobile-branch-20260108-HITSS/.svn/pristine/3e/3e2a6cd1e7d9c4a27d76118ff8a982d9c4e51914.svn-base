package pe.com.intralot.loto.layer.model.persistence.dao;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */

import java.util.HashMap;
import java.util.Map;

import pe.com.intralot.loto.layer.model.bean.Client;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedurePutClient;
import pe.com.intralot.loto.layer.model.pojo.GanadiarioSale;
import pe.com.intralot.loto.layer.model.pojo.GanagolSale;
import pe.com.intralot.loto.layer.model.pojo.KabalaChChSale;
import pe.com.intralot.loto.layer.model.pojo.KabalaSale;
import pe.com.intralot.loto.layer.model.pojo.TinkaSale;

@SuppressWarnings("rawtypes")
public interface ProcedureDao {
		
	
	public HashMap[]  getClientPlayCoupon(Integer id) throws Exception;
	
	public HashMap[]  getClientRetailPlayCoupon(Integer id) throws Exception;
	
	public HashMap[]  getClientPlayCouponPP(Integer id, Integer ticket) throws Exception;
	
	public HashMap<String, Object> getPendingPrizeByTicketid(Integer gameid, Integer ticketid) throws Exception;
	
	public HashMap[]  getPendingPrize(Integer id) throws Exception;
	
	public HashMap[]  getNumberConsecutiveTinkamegabol() throws Exception;
	
	public HashMap[]  getNumberConsecutiveGanadiario() throws Exception;
	
	public Map registerUser(Map param) throws Exception;
	
	public ClientProcedurePutClient findPutclient(Object[] values) throws Exception;
	
	public GanadiarioSale  findProcedureGanadiarioBetData(Integer clientId) throws Exception;
	
	public HashMap[]  getNumberConsecutiveTinka() throws Exception;
	
	public HashMap[]  getNumberConsecutiveKabala() throws Exception;
	
	public KabalaSale  findProcedureKabalaBetData(Integer clientId) throws Exception;
	
	public KabalaChChSale  findProcedureKabalaBetDataChCh(Integer clientId) throws Exception;
	
    public Client findAccountData(Integer clientId) throws Exception;
    
    public TinkaSale findProcedureTinkaBetData(Integer clientId) throws Exception;

	public GanagolSale findProcedureGanagolBetData(Integer clientId) throws Exception;
	
	public String[] findTinkaNextDraw() throws Exception;
	
	public String[] findKabalaNextDraw() throws Exception;
	
	public String[] findGanadiarioNextDraw() throws Exception;
	
	public HashMap<String, Object> getTicketById(Integer gameid, Integer ticketid) throws Exception; // @jmoran 2019-06-24
	
	public HashMap[]  getClientPlayCouponFilter(Integer id, String start_date, String end_date) throws Exception;
	
	public HashMap[]  getClientPlayRetailCouponFilter(Integer id, String start_date, String end_date) throws Exception;
	
	public HashMap[]  getTicketDetailRetail(Integer p_clientId, Integer gameId, String ticket) throws Exception;
	
	public HashMap[]  getTicketDetailRetailGrecia(Integer p_programa, Integer p_cpn) throws Exception;
}