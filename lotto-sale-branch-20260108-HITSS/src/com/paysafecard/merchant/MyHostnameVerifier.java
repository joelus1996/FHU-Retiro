package com.paysafecard.merchant;

import javax.net.ssl.SSLSession;
import javax.net.ssl.HostnameVerifier;

public class MyHostnameVerifier implements HostnameVerifier {
	
	 public boolean verify(String hostname, SSLSession session) {
		   return true;
	}
 
}
