package pe.com.intralot.loto.layer.service.game.fechaza.bo;

import java.util.List;

import pe.com.intralot.loto.layer.model.domain.FechazaProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.FechazaProcedureDrawData;

import com.google.gson.JsonArray;

public interface FechazaBo {

    public FechazaProcedureBetData findByClientId(Integer clientId) throws Exception;

    public List<FechazaProcedureDrawData> findListDrawData() throws Exception;
    public String DateFormat(String date);

    public JsonArray datosJugada(int from, int to, int clientid, int gameID, Long ticketId);

    public JsonArray resultado_premios(Integer clientId, Integer gameId, Long ticketId);

    public boolean isAllowedGoIn(String user);
}
