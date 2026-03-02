package pe.com.intralot.loto.layer.controller.game.kabala.bo;

import java.util.HashMap;

import pe.com.intralot.loto.layer.model.pojo.Draw;
import pe.com.intralot.loto.layer.model.pojo.KabalaChChSale;
import pe.com.intralot.loto.layer.model.pojo.KabalaSale;

public interface KabalaBetBo {

    @SuppressWarnings("rawtypes")
    public HashMap[] getNumberConsecutive() throws Exception;

    public Draw getDataCloseDateGame() throws Exception;

    public Draw getDrawsKabala01() throws Exception;

    public Draw getDrawsKabala02() throws Exception;
    
	public KabalaSale findKabalaBetData(Integer id) throws Exception;
	
	public KabalaChChSale findKabalaBetDataChCh(Integer id) throws Exception;
	
	public String[] findKabalaNextDraw() throws Exception;

	boolean isSubscriptionAllowedGoIn(String user);
	
}
