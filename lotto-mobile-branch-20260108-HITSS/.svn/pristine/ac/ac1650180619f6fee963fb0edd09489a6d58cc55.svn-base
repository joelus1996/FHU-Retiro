package pe.com.intralot.loto.layer.dto.visa;

public class BodySessionKey {

	private String channel;
	private String amount;
	private DataMap dataMap;
	
	public BodySessionKey(String userToken) {
		channel="paycard";
		amount="1.00";
		dataMap = new DataMap();
		dataMap.setUserToken(userToken);
	}

	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public DataMap getDataMap() {
		return dataMap;
	}

	public void setDataMap(DataMap dataMap) {
		this.dataMap = dataMap;
	}
}