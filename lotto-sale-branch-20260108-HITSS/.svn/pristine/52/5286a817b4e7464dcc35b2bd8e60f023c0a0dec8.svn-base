package pe.com.intralot.loto.layer.model.domain;

import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "CLIENTSALE_GETCLIENT", query = "{ call LOTOCARD.CLIENTSALE.GETCLIENT(?,?,?) }", callable = true, resultClass = ClientProcedureGetClient.class)
public class ClientProcedureGetClient {

    @Id
    @Column(name = "p_nombre")
    private String nombre;
    @Column(name = "p_birthdate")
    private String birthdate;
    @Column(name = "p_mail")
    private String mail;
    @Column(name = "p_mailstatus")
    private String mailstatus;
    @Column(name = "p_item")
    private Integer item;
    @Column(name = "p_amount")
    private Double amount;
    @Column(name = "p_mail2")
    private String mail2;
    @Column(name = "p_mail2status")
    private String mail2status;
    @Column(name = "p_address")
    private String address;
    @Column(name = "p_region")
    private String region;
    @Column(name = "p_country")
    private String country;
    @Column(name = "p_status")
    private String status;
    @Column(name = "p_terms")
    private Integer terms;
    @Column(name = "p_lucky_icon")
    private String luckyIcon;
    @Column(name = "p_fixed_phone")
    private String fixedPhone;
    @Column(name = "p_mobile_phone")
    private String mobilePhone;
    @Column(name = "p_mail_code")
    private String mailCode;
    @Column(name = "p_session_code")
    private String sessionCode;
    @Transient
    private String samount;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMailstatus() {
        return mailstatus;
    }

    public void setMailstatus(String mailstatus) {
        this.mailstatus = mailstatus;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMail2() {
        return mail2;
    }

    public void setMail2(String mail2) {
        this.mail2 = mail2;
    }

    public String getMail2status() {
        return mail2status;
    }

    public void setMail2status(String mail2status) {
        this.mail2status = mail2status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTerms() {
        return terms;
    }

    public void setTerms(Integer terms) {
        this.terms = terms;
    }

    public String getLuckyIcon() {
        return luckyIcon;
    }

    public void setLuckyIcon(String luckyIcon) {
        this.luckyIcon = luckyIcon;
    }

    public String getFixedPhone() {
        return fixedPhone;
    }

    public void setFixedPhone(String fixedPhone) {
        this.fixedPhone = fixedPhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getMailCode() {
        return mailCode;
    }

    public void setMailCode(String mailCode) {
        this.mailCode = mailCode;
    }

    public String getSessionCode() {
        return sessionCode;
    }

    public void setSessionCode(String sessionCode) {
        this.sessionCode = sessionCode;
    }

    public String getSamount() {
        DecimalFormat df = new DecimalFormat("###,###,##0.00");
        return df.format(amount);
    }

    /*public void setSamount(String samount) {
        this.samount = samount;
    }*/
}
