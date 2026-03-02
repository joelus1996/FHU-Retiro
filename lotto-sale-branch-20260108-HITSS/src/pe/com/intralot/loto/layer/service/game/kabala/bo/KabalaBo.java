package pe.com.intralot.loto.layer.service.game.kabala.bo;

import java.util.ArrayList;
import java.util.List;

import pe.com.intralot.loto.layer.model.domain.KabalaProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.KabalaProcedureBetDataChCh;
import pe.com.intralot.loto.layer.model.domain.KabalaProcedureBetDataSubscribe;
import pe.com.intralot.loto.layer.model.domain.KabalaProcedureDrawData;

import com.google.gson.JsonArray;

/**
 * @author: Zolanch Tavara Sandon
 * @rol: Analista Programador
 */
public interface KabalaBo {

    public KabalaProcedureBetData findByClientId(Integer clientId) throws Exception;
    
    public KabalaProcedureBetDataSubscribe findSubscribeByClientId(Integer clientId) throws Exception;
    
    public KabalaProcedureBetDataChCh findByClientIdChCh(Integer clientId) throws Exception;

    public List<KabalaProcedureDrawData> findListDraw() throws Exception;

    public String DateFormat(String date);

    public JsonArray cotejoJugada(String tipo_jugada, int from, int to, int gameID, Long ticketId);

    public void reinicioValoresAciertos();

    public JsonArray datosJugada(String tipo_jugada, int from, int to, int gameID, Long ticketId);

    public JsonArray resultado_premios(Integer clientId, Integer gameId, Long ticketId);

    public boolean isAllowedGoIn(String user);
    
    public ArrayList valoresBoleto() throws Exception;
    
    public JsonArray cotejoAciertosKabala(String tipoJugada, int from, int to, int gameID, String jugadaCompl, String plus,String chauChamba);

	public boolean isSubscriptionAllowedGoIn(String user);

	public String[] findKabalaNextDraw() throws Exception;


}
