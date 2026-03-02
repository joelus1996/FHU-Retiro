package pe.com.intralot.loto.layer.service.game.raspaditas.boimpl;

import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.service.game.raspaditas.bo.RaspaditasBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.util.Constants;

@Service
public class RaspaditasBoImpl implements RaspaditasBo {
    
    @Override
    public boolean isAllowedGoIn(String user) {
        boolean isRaspaditas = Boolean.valueOf(ConnectionFactory.operationProperty("raspaditasEnabled", Constants.contextSale).trim()).booleanValue();
        boolean isAllowed = false;
        String raspaditasUsers = String.valueOf(ConnectionFactory.operationProperty("raspaditasUsers", Constants.contextSale)).toString().trim();
        if (isRaspaditas == false) {
            if (raspaditasUsers != null && !raspaditasUsers.equals("")) {
                String[] saleUsers = raspaditasUsers.split(",");
                for (String saleUser : saleUsers)
                    if (saleUser.equals(user)) {
                        isAllowed = true;
                        break;
                    } else
                        isAllowed = false;
            }
        } else
            isAllowed = true;
        return isAllowed;
    }
    
   
}
