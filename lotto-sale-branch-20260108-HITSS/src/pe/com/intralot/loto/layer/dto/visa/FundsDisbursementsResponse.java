package pe.com.intralot.loto.layer.dto.visa;

public class FundsDisbursementsResponse {
	
	private Header header;
    private String responseCode;
    private String responseMessage;
    private Order order;
    private DataMap dataMap;
	private String errorCode;
	private String errorMessage;    
	private Data data;
	private String json;
	
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public DataMap getDataMap() {
		return dataMap;
	}
	public void setDataMap(DataMap dataMap) {
		this.dataMap = dataMap;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}	
}
