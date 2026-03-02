package pe.com.intralot.loto.layer.controller.game.tinka.bo;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */

import java.util.HashMap;

import pe.com.intralot.loto.layer.model.pojo.Draw;
import pe.com.intralot.loto.layer.model.pojo.TinkaSale;

public interface TinkaBetBo {
	
	@SuppressWarnings("rawtypes")
	public HashMap[] getNumberConsecutive() throws Exception;		
	
	public Draw getDataCloseDateGame()throws Exception;	
	
	public Draw getDrawsTinka01()throws Exception;
	
	public Draw getDrawsTinka02()throws Exception;
	
    public TinkaSale findTinkaBetData(Integer id) throws Exception;
    
    public String[] findTinkaNextDraw() throws Exception;
    
    public boolean isPopupSiosiActive();

    public boolean isPopup3x12Active();
}