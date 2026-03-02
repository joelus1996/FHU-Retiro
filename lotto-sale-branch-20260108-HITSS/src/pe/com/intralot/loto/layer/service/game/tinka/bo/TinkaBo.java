package pe.com.intralot.loto.layer.service.game.tinka.bo;

import java.util.ArrayList;
import java.util.List;

import pe.com.intralot.loto.layer.model.domain.TinkaProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.TinkaProcedureBetDataSubscribe;
import pe.com.intralot.loto.layer.model.domain.TinkaProcedureDrawData;

import com.google.gson.JsonArray;

public interface TinkaBo {

    public TinkaProcedureBetData findByClientId(Integer clientId) throws Exception;
    
    public TinkaProcedureBetDataSubscribe findSubscribeByClientId(Integer clientId) throws Exception;

    public List<TinkaProcedureDrawData> findListDraw() throws Exception;

    public String DateFormat(String date);

    public JsonArray cotejoJugada(String tipo_jugada, int from, int to, int gameID, int ticketId);

    public void reinicioValoresAciertos();

    public JsonArray datosJugada(String tipo_jugada, int from, int to, int gameID, Long ticketId);

    public JsonArray resultado_premios(Integer clientId, Integer gameId, Long ticketId);

    public boolean isAllowedGoIn(String user);
    
    public boolean isSubscriptionAllowedGoIn(String user);

    public ArrayList<Integer> valoresBoleto() throws Exception;

    public JsonArray datosJugadaCotejo(String tipo_jugada, int from, int to, int gameID, String jugadaCompl, String plus, String chauChamba);
    
    public String[] findTinkaNextDraw() throws Exception;
    
    public boolean isPopupSiosiActive();
    
    public boolean isPopup3x12Active();
}