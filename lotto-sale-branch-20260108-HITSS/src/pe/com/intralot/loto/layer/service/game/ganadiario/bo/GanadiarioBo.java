package pe.com.intralot.loto.layer.service.game.ganadiario.bo;

import java.util.ArrayList;
import java.util.List;

import pe.com.intralot.loto.layer.model.domain.Country;
import pe.com.intralot.loto.layer.model.domain.Draw;
import pe.com.intralot.loto.layer.model.domain.DrawItem;
import pe.com.intralot.loto.layer.model.domain.GanadiarioProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.GanadiarioProcedureBetDataSubscribe;
import pe.com.intralot.loto.layer.model.domain.GanadiarioProcedureDrawData;
import pe.com.intralot.loto.layer.model.domain.TicketWinner;
import pe.com.intralot.loto.layer.model.domain.TicketWinnerLotos5;

import com.google.gson.JsonArray;

/**
 * @author: Zolanch Tavara Sandon
 * @rol: Analista Programador
 * @proyecto:
 */
public interface GanadiarioBo {

    public GanadiarioProcedureBetData findByClientId(Integer clientId) throws Exception;
    
    public GanadiarioProcedureBetDataSubscribe findSubscribeByClientId(Integer clientId) throws Exception;

    public List<GanadiarioProcedureDrawData> findListDraw() throws Exception;

    public List<Country> findCountryAll() throws Exception;

    public Draw findDrawByIdByGameId(Integer drawId, Integer gameID) throws Exception;

    public DrawItem findDrawItemByIdByGameId(Integer drawId, Integer gameID) throws Exception;

    public TicketWinner findTicketWinnerById(Long ticketId) throws Exception;

    public TicketWinner findTicketWinnerByTicketNumber(String ticketNumber) throws Exception;

    public TicketWinnerLotos5 findTicketWinnerLotos5ById(Long ticketId) throws Exception;

    public TicketWinnerLotos5 findTicketWinnerLotos5ByTicketNumber(String ticketNumber) throws Exception;

    public JsonArray cotejoJugada(String tipo_jugada, int from, int to, int gameID, int ticketId);

    public void reinicioValoresAciertos();

    public JsonArray datosJugada(String tipo_jugada, int from, int to, int gameID, Long ticketId);

    public JsonArray resultado_premios(Integer clientId, Integer gameId, Long ticketId);

    public boolean isAllowedGoIn(String user);

    public String DateFormat(String date);
    
    public ArrayList valoresBoleto() throws Exception;
    
    public JsonArray datosJugadaCotejo(String tipo_jugada, int from, int to, int gameID, String jugadaCompl, String plus,String chauChamba);

	public boolean isSubscriptionAllowedGoIn(String user);

	public String[] findGanadiarioNextDraw() throws Exception;
	
	public boolean isPopup3x5solesActive();
}
