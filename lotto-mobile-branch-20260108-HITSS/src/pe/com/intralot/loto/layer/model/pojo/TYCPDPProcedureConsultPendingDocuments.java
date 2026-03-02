package pe.com.intralot.loto.layer.model.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

/**
 * @author:   Felipe Rodriguez
 * @rol:	  Desarrollador
 * @proyecto: lotto-playerweb-ws-tyc-pdp
 *
 */
@Entity
@NamedNativeQuery(name = "TYC_PDP_VALIDATION_SP_DOCS_PENDING_ACCEPT", query = "{ call LOTOCARD.TYC_PDP_VALIDATION.SP_DOCS_PENDING_ACCEPT(?,?,?,?,?,?) }", callable = true, resultClass = TYCPDPProcedureConsultPendingDocuments.class)
public class TYCPDPProcedureConsultPendingDocuments implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "tipo_documento_id")
	private String docType;
	
	@Column(name = "version_id")
	private String version;
	
	@Column(name = "tp_fecha_hora_publicacion")
	private String publicationDate;

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	
}
