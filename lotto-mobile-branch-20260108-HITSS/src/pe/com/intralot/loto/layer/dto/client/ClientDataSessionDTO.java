package pe.com.intralot.loto.layer.dto.client;

import java.util.HashMap;

public class ClientDataSessionDTO {
	
	private String clientId;
	private String coupon;
	private String couponFilter;
	
	public ClientDataSessionDTO() {}
	
	public ClientDataSessionDTO(String clientId) {
		this.clientId = clientId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public String getCouponFilter() {
		return couponFilter;
	}

	public void setCouponFilter(String couponFilter) {
		this.couponFilter = couponFilter;
	}


	
}