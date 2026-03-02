package pe.com.intralot.loto.layer.service.game.super3.bo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;

import pe.com.intralot.loto.layer.model.domain.Super3ProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.Super3ProcedureDrawData;

/**
 * @author: Zolanch Tavara Sandon
 * @rol: Analista Programador
 */
public interface Super3Bo {

    public Super3ProcedureBetData findByClientId(Integer clientId) throws Exception;

    public List<Super3ProcedureDrawData> findListDraw() throws Exception;
    public String DateFormat(String date);
    public boolean isAllowedGoIn(String user);
	
	public JsonArray datosJugada(int from,int to,int gameID, Long ticketId);
	public JsonArray resultado_premios(Integer clientId,Integer gameId,Long ticketId);
	public ArrayList valoresBoleto() throws Exception;
	public JsonArray premio_total(Integer clientId,Integer gameId,Long ticketId);
}
