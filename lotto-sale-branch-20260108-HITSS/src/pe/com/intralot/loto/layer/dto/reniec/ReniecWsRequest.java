package pe.com.intralot.loto.layer.dto.reniec;

public class ReniecWsRequest {
	private String docType;
    private String docNumber;
    private String birthDate;
    private String names;
    private String surnames;
	public String getDocType() {
		return docType;
	}
	
	
	public ReniecWsRequest(String docType, String docNumber, String birthDate, String names, String surnames) {
		super();
		this.docType = docType;
		this.docNumber = docNumber;
		this.birthDate = birthDate;
		this.names = names;
		this.surnames = surnames;
	}


	public void setDocType(String docType) {
		this.docType = docType;
	}
	public String getDocNumber() {
		return docNumber;
	}
	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getSurnames() {
		return surnames;
	}
	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}
	@Override
	public String toString() {
		return "ReniecWsRequest [docType=" + docType + ", docNumber=" + docNumber + ", birthDate=" + birthDate
				+ ", names=" + names + ", surnames=" + surnames + "]";
	}
    
    
}
