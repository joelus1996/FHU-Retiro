package pe.com.intralot.loto.layer.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureSpecialHeader;
import pe.com.intralot.loto.layer.service.game.teapuesto.bo.TeapuestoBo;

public class TeapuestoTest extends AbstractBaseUnitTest {

    @Autowired
    private TeapuestoBo teapuestoBo;

    // private JsonArray createDrawList(int id) throws Exception {
    // List<TeapuestoProcedureDrawData> teapuestoSaleListDrawData = teapuestoBo.findListDrawData(id);
    // Map<Object, Object> outMap = new HashMap<Object, Object>();
    // JsonArray jaDrawList = new JsonArray();
    // for (TeapuestoProcedureDrawData teapuestoSale : teapuestoSaleListDrawData) {
    //
    // outMap.put("hour", teapuestoSale.getHour());
    // outMap.put("eventId", teapuestoSale.getEventId());
    // outMap.put("leagueId", teapuestoSale.getLeagueId());
    // outMap.put("minimun", teapuestoSale.getMinimum());
    // outMap.put("teams", teapuestoSale.getTeams());
    // outMap.put("local", teapuestoSale.getLocal());
    // outMap.put("equal", teapuestoSale.getEqual());
    // outMap.put("visitor", teapuestoSale.getVisitor());
    // outMap.put("localEqual", teapuestoSale.getLocalEqual());
    // outMap.put("localVisitor", teapuestoSale.getLocalVisitor());
    // outMap.put("equalVisitor", teapuestoSale.getEqualVisitor());
    // outMap.put("t1tLocal", teapuestoSale.getT1tLocal());
    // outMap.put("t1tEqual", teapuestoSale.getT1tEqual());
    // outMap.put("t1tVisitor", teapuestoSale.getT1tVisitor());
    // outMap.put("t1tLocal2tLocal", teapuestoSale.getT1tLocal2tLocal());
    // outMap.put("t1tEqual2tLocal", teapuestoSale.getT1tEqual2tLocal());
    // outMap.put("t1tVisitor2tLocal", teapuestoSale.getT1tVisitor2tLocal());
    // outMap.put("t1tLocal2tEqual", teapuestoSale.getT1tLocal2tEqual());
    // outMap.put("t1tEqual2tEqual", teapuestoSale.getT1tEqual2tEqual());
    // outMap.put("t1tVisitor2tEqual", teapuestoSale.getT1tVisitor2tEqual());
    // outMap.put("t1tLocal2tVisitor", teapuestoSale.getT1tLocal2tVisitor());
    // outMap.put("t1tEqual2tVisitor", teapuestoSale.getT1tEqual2tVisitor());
    // outMap.put("t1tVisitor2tVisitor", teapuestoSale.getT1tVisitor2tVisitor());
    // outMap.put("goalLower2", teapuestoSale.getGoalLower2());
    // outMap.put("goalOver3", teapuestoSale.getGoalOver3());
    // outMap.put("goal_0_1", teapuestoSale.getGoal_0_1());
    // outMap.put("goal_2_3", teapuestoSale.getGoal_2_3());
    // outMap.put("goal4More", teapuestoSale.getGoal4More());
    // jaDrawList.add(new Gson().toJsonTree(outMap));
    // }
    // return jaDrawList;
    // }
    //
    // private Map<Object, Object> createMapDrawMenu(Object id, Object date) {
    // Map<Object, Object> outMap = new HashMap<Object, Object>();
    // outMap.put("id", id);
    // outMap.put("date", date);
    // return outMap;
    // }
    //
    // @Test
    // public void Ex() throws Exception {
    // Integer idClient = 0;
    // JsonArray jaMenuData = new JsonArray();
    // JsonArray jaDataList = new JsonArray();
    //
    // idClient = 4;
    //
    // List<TeapuestoProcedureDrawMenu> teapuestoSaleListDrawMenu = teapuestoBo.findListDrawMenu();
    // for (TeapuestoProcedureDrawMenu teapuestoSale : teapuestoSaleListDrawMenu) {
    // jaMenuData.add(new Gson().toJsonTree(createMapDrawMenu(teapuestoSale.getDrawId(), teapuestoSale.getDate())));
    // JsonObject joElement = new JsonObject();
    // joElement.addProperty("program", teapuestoSale.getDrawId());
    // joElement.add("events", createDrawList(teapuestoSale.getDrawId()));
    // jaDataList.add(joElement);
    // }
    // // System.out.println(jaMenuData);
    // // System.out.println(jaDataList);
    // }

    // @Test
    // public void findByClientId() throws Exception {
    // TeapuestoSale teapuestoSale = teapuestoBo.findByClientId(10);
    // System.out.println(teapuestoSale.getStatus() + " " +
    // teapuestoSale.getMessage());
    // System.out.println("---------------------------------findByClientId");
    // }
    //
    // @Test
    // public void findListDrawData() throws Exception {
    // List<TeapuestoSale> teapuestoSaleList = new ArrayList<TeapuestoSale>();
    // teapuestoSaleList = teapuestoBo.findListDrawData(783);
    // System.out.println(teapuestoSaleList.size());
    // System.out.println("---------------------------------/teapuestoSaleList.size()");
    // for (TeapuestoSale teapuestoSale : teapuestoSaleList) {
    // System.out.println(teapuestoSale.getHour() + " " +
    // teapuestoSale.getEventId() + " " + teapuestoSale.getLeagueId() + " " +
    // teapuestoSale.getTeams()
    // + " | " + teapuestoSale.getLocal());
    // }
    // System.out.println("---------------------------------findListDrawData");
    // }
    //
    // @Test
    // public void findListDrawMenu() throws Exception {
    // List<TeapuestoSale> teapuestoSaleList = new ArrayList<TeapuestoSale>();
    // teapuestoSaleList = teapuestoBo.findListDrawMenu();
    // System.out.println(teapuestoSaleList.size());
    // System.out.println("---------------------------------");
    // for (TeapuestoSale teapuestoSale : teapuestoSaleList) {
    // System.out.println(teapuestoSale.getDrawId() + " " +
    // teapuestoSale.getDate());
    // }
    // System.out.println("---------------------------------findListDrawMenu");
    // }
    //

    //
    // @Test
    // public void findSpecialHeader() throws Exception {
    //
    // TeapuestoSale teapuestoSale = teapuestoBo.findSpecialHeader();
    // System.out.println(teapuestoSale.getHeader());
    // System.out.println("---------------------------------findSpecialHeader");
    //
    // }
    //
    // @Test
    // public void findSpecialMenu() throws Exception {
    //
    // List<TeapuestoSale> teapuestoSaleList = new ArrayList<TeapuestoSale>();
    // teapuestoSaleList = teapuestoBo.findSpecialMenu("FUTBOL");
    // System.out.println(teapuestoSaleList.size());
    // System.out.println("---------------------------------");
    // for (TeapuestoSale teapuestoSale : teapuestoSaleList) {
    // System.out.println(teapuestoSale.getMenu());
    // }
    // System.out.println("---------------------------------findSpecialMenu");
    // }
    //
    // @Test
    // public void findtExactData() throws Exception {
    //
    // TeapuestoProcedureExactData teapuestoSale = teapuestoBo.findtExactData(802, 405);
    // System.out.println(teapuestoSale.getLocal() + " " + teapuestoSale.getVisitor());
    // System.out.println("---------------------------------findtExactData");
    // }
    @Test
    public void SpecialHeder() throws Exception {
        List<TeapuestoProcedureSpecialHeader> teapuestoSaleSpecialHeader = teapuestoBo.findSpecialHeader();
        for (TeapuestoProcedureSpecialHeader teapuestoSale : teapuestoSaleSpecialHeader) {
            // jaSpecialHeader.add(new
            // Gson().toJsonTree(teapuestoBo.createMapSpecialHeader(teapuestoSale.getHeader())));
            // JsonObject joElement = new JsonObject();
            // joElement.addProperty("header", teapuestoSale.getHeader());
            // joElement.add("games", teapuestoBo.createMapSpecialtMenu(teapuestoSale.getHeader()));
            // jaSpecialMenu.add(joElement);
            System.out.println(teapuestoSale.getHeader());
        }
    }
    //
    // @Test
    // public void findtSpecialData() throws Exception {
    //
    // TeapuestoSale teapuestoSale = teapuestoBo.findtSpecialData("080",
    // "BARCELONA - REAL MADRID - (L) QUIEN HARA EL PRIMER GOL");
    // System.out.println(teapuestoSale.getGroupCode() + " " +
    // teapuestoSale.getItemHour() + " " + teapuestoSale.getItemDate());
    // System.out.println("---------------------------------findtSpecialData");
    // }

}
