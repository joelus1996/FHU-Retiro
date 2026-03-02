package pe.com.intralot.loto.layer.model.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author cristian.cortez
 */
//@Cacheable
//@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Entity
@Table(name = "LOTOCARD.REGION")
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "REGION_ID")
    private String regionId;
    @Column(name = "RE_NAME")
    private String regionName;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String reName) {
        this.regionName = reName;
    }
}
