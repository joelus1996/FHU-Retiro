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
@Table(name = "LOTOCARD.COUNTRY")
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "COUNTRY_ID")
    private String countryId;
    @Column(name = "CO_NAME")
    private String countryName;

    public Country() {
    }

    public Country(String countryId, String countryName) {
        this.countryId = countryId;
        this.countryName = countryName;
    }

    public String getCountryId() {
        return this.countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}