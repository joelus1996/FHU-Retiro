package pe.com.intralot.loto.layer.service.draw.bo;

import java.util.List;

import pe.com.intralot.loto.layer.model.domain.Draw;

public interface DrawBo {

	public Draw findByIdByGameId(Integer drawId, Integer gameID) throws Exception;

	public List<Draw> findByDrawListByGameId(Integer gameId, Integer days) throws Exception;

}
