package pe.com.intralot.loto.layer.model.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(	
		name = "GET_POPUP_INFO", 
		query = "{ call LOTOCARD.PKG_POPUP_INFORMATIVO_GAME.GET_POPUP_INFO(?) }", 
		callable = true, 
		resultClass = PopupInformativo.class)
public class PopupInformativo implements Serializable {
	 
	private static final long serialVersionUID = 375800277059284150L;
	
    @Id
    @Column(name = "PIG_COD_POPUP")
    private String codigoPopup;

    @Id
    @Column(name = "PIG_COD_GAME")
    private Integer codigoGame;

    @Column(name = "PIG_DESCRIPTION")
    private String descripcion;

    @Column(name = "PIG_INFO_TEXT_1")
    private String infoText1;

    @Column(name = "PIG_INFO_TEXT_2")
    private String infoText2;

    @Column(name = "PIG_ROUTE_IMAGE")
    private String routeImage;

    @Column(name = "PIG_BUTTON_TEXT")
    private String buttonText;

    @Column(name = "PIG_BUTTON_REDIRECT")
    private String buttonRedirect;
    
    @Column(name = "PIG_BUTTON_STYLE")
    private String buttonStyle;

    @Column(name = "PIG_LINK_TEXT")
    private String linkText;

    @Column(name = "PIG_LINK_REDIRECT")
    private String linkRedirect;
    
    @Column(name = "PIG_LINK_STYLE")
    private String linkStyle;
    
    @Column(name = "PIG_LINKS_ALLOWED")
    private String linksAllowed;

    @Column(name = "PIG_CODS_POPUP_ALLOWED")
    private String codsPopupAllowed;
    
    @Column(name = "PIG_DATE_INIT")
    private Date dateInit;

    @Column(name = "PIG_DATE_FIN")
    private Date dateFin;
    
    @Transient
    private boolean validDateRange = false;
    
    public PopupInformativo() {
    	
    }
    
    public PopupInformativo(String codigoPopup, Date dateInit, Date dateFin, String codsPopupAllowed ) {
    	this.codigoPopup = codigoPopup;
    	this.dateInit = dateInit;
    	this.dateFin = dateFin;
    	this.codsPopupAllowed = codsPopupAllowed; 
    }

	public String getCodigoPopup() {
		return codigoPopup;
	}

	public void setCodigoPopup(String codigoPopup) {
		this.codigoPopup = codigoPopup;
	}

	public String getButtonStyle() {
		return buttonStyle;
	}

	public void setButtonStyle(String buttonStyle) {
		this.buttonStyle = buttonStyle;
	}

	public String getLinkStyle() {
		return linkStyle;
	}

	public void setLinkStyle(String linkStyle) {
		this.linkStyle = linkStyle;
	}

	public Integer getCodigoGame() {
		return codigoGame;
	}

	public void setCodigoGame(Integer codigoGame) {
		this.codigoGame = codigoGame;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getInfoText1() {
		return infoText1;
	}

	public void setInfoText1(String infoText1) {
		this.infoText1 = infoText1;
	}

	public String getInfoText2() {
		return infoText2;
	}

	public void setInfoText2(String infoText2) {
		this.infoText2 = infoText2;
	}

	public String getRouteImage() {
		return routeImage;
	}

	public void setRouteImage(String routeImage) {
		this.routeImage = routeImage;
	}

	public String getButtonText() {
		return buttonText;
	}

	public void setButtonText(String buttonText) {
		this.buttonText = buttonText;
	}

	public String getButtonRedirect() {
		return buttonRedirect;
	}

	public void setButtonRedirect(String buttonRedirect) {
		this.buttonRedirect = buttonRedirect;
	}

	public String getLinkText() {
		return linkText;
	}

	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}

	public String getLinkRedirect() {
		return linkRedirect;
	}

	public void setLinkRedirect(String linkRedirect) {
		this.linkRedirect = linkRedirect;
	}
	
	public String getLinksAllowed() {
		return linksAllowed;
	}

	public void setLinksAllowed(String linksAllowed) {
		this.linksAllowed = linksAllowed;
	}

	public String getCodsPopupAllowed() {
		return codsPopupAllowed;
	}

	public void setCodsPopupAllowed(String codsPopupAllowed) {
		this.codsPopupAllowed = codsPopupAllowed;
	}

	public Date getDateInit() {
		return dateInit;
	}

	public void setDateInit(Date dateInit) {
		this.dateInit = dateInit;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public boolean isValidDateRange() {
		return validDateRange;
	}

	public void setValidDateRange(boolean validDateRange) {
		this.validDateRange = validDateRange;
	}
	
   
}
