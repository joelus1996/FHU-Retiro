package pe.com.intralot.loto.layer.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import pe.com.intralot.loto.layer.model.bean.ClientBean;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;

public class ClientSaleTest extends AbstractBaseUnitTest {
    @Autowired
    private ClientSaleBo clientSaleBo;
/*
    @Test
    public void findSessionData() throws Exception {

        ClientSale clientSale = clientSaleBo.findSessionData(1, 1, "123");
        System.out.println(clientSale.getMessage());
    }

    @Test
    public void findCreatesession() throws Exception {

        ClientSale clientSale = clientSaleBo.findCreatesession(1);
        System.out.println(clientSale.getSessionId());
    }

    @Test
    public void updateModsession() throws Exception {

        ClientSale clientSale = clientSaleBo.updateModsession(189, 1);
        System.out.println(clientSale.getStatus());
    }

    /*
     * Corregir el SP
     * @Test public void findChecksession() throws Exception { ClientSale clientSale = clientSaleBo.findChecksession(189,1); System.out.println(clientSale.getStatus()); }
     */

    // Corregir el SP

    @Test
    public void findPutclient() throws Exception {

        ClientBean clientBean = null;
        clientBean.setpNombre("Lucia");
        // ClientSale clientSale = clientSaleBo.findPutclient(clientBean);
        // System.out.println(clientSale.getStatus());
        /*
         * cs.setString(2, clientBean.getpNombre()); cs.setString(3, clientBean.getpAppaterno()); cs.setString(4, clientBean.getpApmaterno()); cs.setString(5, clientBean.getpBirthdate());
         * cs.setString(6, clientBean.getpTypeid()); cs.setString(7, clientBean.getpIntegerid()); cs.setString(8, clientBean.getpNickname()); cs.setString(9, clientBean.getpGender()); cs.setString(10,
         * clientBean.getpMarital()); cs.setString(11, clientBean.getpUser()); cs.setString(12, clientBean.getpMail1()); cs.setString(13, clientBean.getpMail2()); cs.setString(14,
         * clientBean.getpConfirm()); cs.setString(15, clientBean.getpPassword()); cs.setString(16, clientBean.getpCountry()); cs.setString(17, clientBean.getpRegion()); cs.setString(18,
         * clientBean.getpAddress()); cs.setInt(19, clientBean.getpTerms()); cs.setString(20, clientBean.getpPIntegers()); cs.setString(21, clientBean.getpPIntegers00()); cs.setString(22,
         * clientBean.getpComtypeid()); cs.setString(23, clientBean.getpComIntegerid()); cs.setString(24, clientBean.getpComname()); cs.setString(25, clientBean.getpComphones()); cs.setString(26,
         * clientBean.getpComcountry()); cs.setString(27, clientBean.getpComregion()); cs.setString(28, clientBean.getpComaddress()); cs.setInt(29, clientBean.getpMode());
         */

        /* hello */
    }

}
