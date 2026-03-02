package pe.com.intralot.loto.layer.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import pe.com.intralot.loto.layer.model.domain.Country;
import pe.com.intralot.loto.layer.service.game.ganadiario.bo.GanadiarioBo;

public class GanadiarioTest extends AbstractBaseUnitTest {

    @Autowired
    private GanadiarioBo ganadiarioBo;
    @Test
    public void findCountryAll() throws Exception {
        List<Country> countryList = new ArrayList<Country>();
        countryList = ganadiarioBo.findCountryAll();
        System.out.println(countryList.size());
        System.out.println(countryList.get(0).getCountryName());
    }
    /*
     * public void findDrawByIdByGameId() throws Exception { Draw draw = new Draw(); draw=ganadiarioBo.findDrawByIdByGameId(1, 1); System.out.println(draw.getDrTickets()); } public void
     * findDrawItemByIdByGameId() throws Exception { DrawItem drawItem = new DrawItem(); drawItem=ganadiarioBo.findDrawItemByIdByGameId(1, 1); System.out.println(drawItem.getDiAsignacion()); } public
     * void findTicketWinnerById() throws Exception { TicketWinner ticketWinner = ganadiarioBo.findTicketWinnerById(1); System.out.println(ticketWinner.getTwCashCompany()); } public void
     * findTicketWinnerByTicketNumber() throws Exception { TicketWinner ticketWinner = ganadiarioBo.findTicketWinnerByTicketNumber("1"); System.out.println(ticketWinner.getTwCashCompany()); } public
     * void findTicketWinnerLotos5ById() throws Exception { TicketWinnerLotos5 ticketWinnerLotos5 = ganadiarioBo.findTicketWinnerLotos5ById(1);
     * System.out.println(ticketWinnerLotos5.getTwCashCompany()); }
     * @Test public void findTicketWinnerLotos5ByTicketNumber() throws Exception { TicketWinnerLotos5 ticketWinnerLotos5 = ganadiarioBo.findTicketWinnerLotos5ByTicketNumber("1");
     * System.out.println(ticketWinnerLotos5.getTwCashCompany()); }
     * @Test public void procedureBetData() throws Exception { GanadiarioProcedureBetData ganadiarioProcedureBetData = ganadiarioProcedureBetDataBo.findByClientId(4);
     * System.out.println(ganadiarioProcedureBetData.getPriceMessage()); }
     * @Test public void procedureDrawData() throws Exception { //GanadiarioProcedureDrawData ganadiarioProcedureDrawData = ganadiarioProcedureBetDataBo.findDraw(); List<GanadiarioProcedureDrawData>
     * ganadiarioProcedureDrawData = ganadiarioProcedureBetDataBo.findListDraw(); System.out.println(ganadiarioProcedureDrawData.get(0).getMessageDraw()); }
     * @Test public void procedureSessionCode() throws Exception { GanadiarioProcedureSessionData ganadiarioProcedureSessionData =
     * ganadiarioProcedureBetDataBo.findSessionByCode("HxcMFMBDKtFIWBiYdPkZazRstJtFUDDjZhiHeYkVJdVecEZA04"); System.out.println(ganadiarioProcedureSessionData.getwMessage()); }
     */
}
