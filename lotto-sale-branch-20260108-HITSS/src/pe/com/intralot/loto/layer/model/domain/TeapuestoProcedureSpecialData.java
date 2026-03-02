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
@NamedNativeQuery(name = "TEAPUESTOSALE_SPECIALDATA",
                  query = "{ call LOTOCARD.TEAPUESTOSALE.SPECIAL_DATA(?,?,?,?) }", 
          		  callable=true,
        		  resultSetMapping = "specialdata-data"
        		)
@SqlResultSetMapping(name = "specialdata-data",
                     entities = @EntityResult (entityClass = TeapuestoProcedureSpecialData.class))
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)

public class TeapuestoProcedureSpecialData {

    @Id
    @Column(name = "w_item_id")
    private String itemId;

    @Column(name = "w_item_code")
    private Integer itemCode;

    @Column(name = "w_group_code")
    private String groupCode;

    @Column(name = "w_group_title")
    private String groupTitle;

    @Column(name = "w_item_date")
    private String itemDate;

    @Column(name = "w_item_hour")
    private String itemHour;

    @Column(name = "w_item_image")
    private String itemImage;

    @Column(name = "w_item_description")
    private String itemDescription;

    @Column(name = "w_odds")
    private String odds;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Integer getItemCode() {
        return itemCode;
    }

    public void setItemCode(Integer itemCode) {
        this.itemCode = itemCode;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupTitle() {
        return groupTitle;
    }

    public void setGroupTitle(String groupTitle) {
        this.groupTitle = groupTitle;
    }

    public String getItemDate() {
        return itemDate;
    }

    public void setItemDate(String itemDate) {
        this.itemDate = itemDate;
    }

    public String getItemHour() {
        return itemHour;
    }

    public void setItemHour(String itemHour) {
        this.itemHour = itemHour;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getOdds() {
        return odds;
    }

    public void setOdds(String odds) {
        this.odds = odds;
    }
}