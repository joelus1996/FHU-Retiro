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
@NamedNativeQuery(name = "TEAPUESTOSALE_SPECIALGROUP", 
                  query = "{ call LOTOCARD.TEAPUESTOSALE.SPECIAL_GROUP(?,?,?) }", 
          		  callable=true,
        		  resultSetMapping = "specialgroup-data"
        		 )
@SqlResultSetMapping(name = "specialgroup-data",
                     entities = @EntityResult (entityClass = TeapuestoProcedureSpecialGroup.class))
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)

public class TeapuestoProcedureSpecialGroup {
    @Id
    @Column(name = "w_league_id")
    private Integer leagueId;

    @Column(name = "w_group_title")
    private String groupTitle;

    @Column(name = "w_subheader")
    private String subHeader;

    @Column(name = "w_group_image")
    private String groupImage;

    public String getGroupImage() {
        return groupImage;
    }

    public void setGroupImage(String groupImage) {
        this.groupImage = groupImage;
    }

    public String getSubHeader() {
        return subHeader;
    }

    public void setSubHeader(String subHeader) {
        this.subHeader = subHeader;
    }

    public String getGroupTitle() {
        return groupTitle;
    }

    public void setGroupTitle(String groupTitle) {
        this.groupTitle = groupTitle;
    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }
}