package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.EntityResult;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

@Entity
@NamedNativeQuery(name = "TEAPUESTOSALE_SPECIALMENU", 
                  query = "{ call LOTOCARD.TEAPUESTOSALE.SPECIAL_MENU(?,?) }", 
          		callable=true,
        		resultSetMapping = "specialmenu-data"
        		)
@SqlResultSetMapping(name = "specialmenu-data",
                     entities = @EntityResult (entityClass = TeapuestoProcedureSpecialMenu.class))
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)

public class TeapuestoProcedureSpecialMenu {

    @Id
    @Column(name = "w_tadraw_id")
    private String tadrawId;

    @Column(name = "w_menu")
    private String menu;

    public String getTadrawId() {
        return tadrawId;
    }

    public void setTadrawId(String tadrawId) {
        this.tadrawId = tadrawId;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}