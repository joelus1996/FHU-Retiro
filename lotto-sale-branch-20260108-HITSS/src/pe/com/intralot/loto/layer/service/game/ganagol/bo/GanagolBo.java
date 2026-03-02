package pe.com.intralot.loto.layer.service.game.ganagol.bo;

import java.util.List;

import pe.com.intralot.loto.layer.model.domain.GanagolProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.GanagolProcedureDrawData;
import pe.com.intralot.loto.layer.model.domain.GanagolProcedureProgramData;

import com.google.gson.JsonArray;

public interface GanagolBo {

    public GanagolProcedureBetData findByClientId(Integer clientId) throws Exception;

    public List<GanagolProcedureDrawData> findListDrawData() throws Exception;
    public List<GanagolProcedureProgramData> findListProgramData(Integer drawId) throws Exception;
  
  
	public JsonArray cotejadorGanagol(int clientId,int gameId,Long ticketId)throws Exception;
	public JsonArray resultado_premios(Integer clientId,Integer gameId,Long ticketId);
	public JsonArray premio_total(Integer clientId,Integer gameId,Long ticketId);
    public boolean isAllowedGoIn(String user);
    public JsonArray datosJugadaCotejo(String tipo_jugada, int from, int to, int gameID, String jugadaCompl);
}