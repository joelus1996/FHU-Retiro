package pe.com.intralot.loto.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.logging.Logger;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import pe.com.intralot.loto.sale.lib.LoggerApi;

import java.lang.reflect.Field;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
 

public class HttpLib {

	public static String httpBasicRequest(String method, String url, String body) {

		if (ConnectionFactory.isDevelopment()) {
			System.out.println("method="+method+" url="+url+" body="+body);
		}
	    String returnString = null;
	    String responseMessage = null;  
	    
		try {

			URL surl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) surl.openConnection();
			conn.setDoOutput(true);
			if (method.equals("PATCH")) { 
		        conn.setRequestMethod("POST");
		        /* conn.setRequestProperty("X-HTTP-Method-Override", "PATCH"); 
		        conn.setRequestProperty("Accept", "application/json"); */
		        try {
		            // Change protected field called "method" of public class HttpURLConnection
		            setProtectedFieldValue(HttpURLConnection.class, "method", conn, "PATCH");
		          } catch (Exception ex) {
		            throw new IOException(ex);
		          }
			} else {
				conn.setRequestMethod(method); // "POST";
			}
	        
			conn.setRequestProperty("Content-Type", "application/json");
			
			String userPassword = "SPSATestUser:TeApuestoTuPasion";
			String encoding = new sun.misc.BASE64Encoder().encode(userPassword.getBytes()); 
			conn.setRequestProperty("Authorization", "Basic " + encoding); 
			
			if (body!=null) {
				OutputStream os = conn.getOutputStream();
			    os.write(body.getBytes("UTF-8"));
			    os.close();
			} 

			responseMessage = conn.getResponseCode()+" "+conn.getResponseMessage();
			
			if (200 <= conn.getResponseCode() && conn.getResponseCode() <= 299) {
				returnString =  HttpLib.getJsonString(conn.getInputStream(), true);
		    } else {
		    	returnString = HttpLib.getJsonString(conn.getErrorStream(), true);
		    }
		} catch (java.lang.NullPointerException e) {
			returnString = responseMessage;
		} catch (java.io.FileNotFoundException e) {
			returnString = responseMessage;
		} catch (Exception e) {
			e.printStackTrace(System.out);
			returnString = e.getMessage();
		}

		// System.out.println("returnString="+returnString);
		
		return returnString;
	}
	
	public static String httpsBasicRequest(String method, String url, String body) {

		if (ConnectionFactory.isDevelopment()) {
			System.out.println("method="+method+" url="+url+" body="+body);
		}
	    String returnString = null;
	    String responseMessage = null;  
	    
		try {

			URL surl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) surl.openConnection();
					
		  if (url.startsWith("https")) {
			  //Logger.getLogger(LoggerAPI.SETUP).info("Inicia validacion de certificado SSL"); 
			  //Logger.getLogger(LoggerAPI.SETUP).info("Paso1");
			  Security.addProvider(new BouncyCastleProvider()); //Adding BouncyCastlePRovider in security
	    	   // Create a trust manager that does not validate certificate chains
	           TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
	                   public java.security.cert.X509Certificate[] getAcceptedIssuers() {
	                       return null;
	                   }
	                   public void checkClientTrusted(X509Certificate[] certs, String authType) {
	                   }
	                   public void checkServerTrusted(X509Certificate[] certs, String authType) {
	                   }
	               }
	           }; 
	           //Logger.getLogger(LoggerAPI.SETUP).info("Paso2");
	         // Install the all-trusting trust manager
	            SSLContext sc = SSLContext.getInstance("SSL");
	            sc.init(null, trustAllCerts, new java.security.SecureRandom());
	            //HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	            ((HttpsURLConnection)conn).setSSLSocketFactory(sc.getSocketFactory());
	            
	            //Logger.getLogger(LoggerAPI.SETUP).info("Paso3");
	            // Create all-trusting host name verifier
	            HostnameVerifier allHostsValid = new HostnameVerifier() {
	                public boolean verify(String hostname, SSLSession session) {
	                    return true;
	                }
	            };
	            
	            //Logger.getLogger(LoggerAPI.SETUP).info("Paso4");
	            // Install the all-trusting host verifier
	            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	           // Logger.getLogger(LoggerAPI.SETUP).info("Fin pasos");
		  } 
		  //Logger.getLogger(LoggerAPI.SETUP).info("Termina validacion de certificado SSL");
            
			conn.setDoOutput(true);
			//Logger.getLogger(LoggerAPI.SETUP).info("setDoOutput");
			if (method.equals("PATCH")) { 
		        conn.setRequestMethod("POST");
		        //Logger.getLogger(LoggerAPI.SETUP).info("setRequestMethod:"+method);
		        /* conn.setRequestProperty("X-HTTP-Method-Override", "PATCH"); 
		        conn.setRequestProperty("Accept", "application/json"); */
		        try {
		            // Change protected field called "method" of public class HttpURLConnection
		        	//Logger.getLogger(LoggerAPI.SETUP).info("setProtectedFieldValue");
		            setProtectedFieldValue(HttpURLConnection.class, "method", conn, "PATCH");		            
		          } catch (Exception ex) {
		        	//Logger.getLogger(LoggerAPI.SETUP).info("exception in setProtectedFieldValue");
		            throw new IOException(ex);
		          }
			} else {
				conn.setRequestMethod(method); // "POST";
				//Logger.getLogger(LoggerAPI.SETUP).info("setRequestMethod:"+method);
			}
			
			conn.setConnectTimeout(10000); //10 segundo
			conn.setReadTimeout(10000);
			//Logger.getLogger(LoggerAPI.SETUP).info("setConnectTimeout y setConnectTimeout");
	        
			conn.setRequestProperty("Content-Type", "application/json");
			
			String userPassword = "SPSATestUser:TeApuestoTuPasion";
			String encoding = new sun.misc.BASE64Encoder().encode(userPassword.getBytes()); 
			//Logger.getLogger(LoggerAPI.SETUP).info("encode");
			conn.setRequestProperty("Authorization", "Basic " + encoding); 
			
			if (body!=null) {
				//Logger.getLogger(LoggerAPI.SETUP).info("getOutputStream");
				OutputStream os = conn.getOutputStream();
				//Logger.getLogger(LoggerAPI.SETUP).info("fin getOutputStream");
			    os.write(body.getBytes("UTF-8"));
			    //Logger.getLogger(LoggerAPI.SETUP).info("fin getBytes");
			    os.close();
			    //Logger.getLogger(LoggerAPI.SETUP).info("os.close()");
			} 
			registraRemoteAddress(surl,conn);
			responseMessage = conn.getResponseCode()+" "+conn.getResponseMessage();
			//Logger.getLogger(LoggerAPI.SETUP).info("responseMessage="+responseMessage);
			if (200 <= conn.getResponseCode() && conn.getResponseCode() <= 299) {
				returnString =  HttpLib.getJsonString(conn.getInputStream(), true);
				System.out.println("-->json response "+returnString);
		    } else {
		    	returnString = HttpLib.getJsonString(conn.getErrorStream(), true);
		    }
		} catch (java.net.SocketTimeoutException e) {
			returnString = "timeout";
			LoggerApi.Log.info(e.getMessage());
		} catch (java.lang.NullPointerException e) {
			returnString = responseMessage;
			LoggerApi.Log.info(e.getMessage());
		} catch (java.io.FileNotFoundException e) {
			returnString = responseMessage;
			LoggerApi.Log.info(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace(System.out);
			returnString = e.getMessage();
			LoggerApi.Log.info(e.getMessage());
		}

		// System.out.println("returnString="+returnString);
		
		return returnString;
	}

	public static String getJsonString(InputStream inputStream) throws Exception {
		return getJsonString(inputStream, true);
	}
	
	public static String getJsonString(InputStream inputStream, boolean flag) throws Exception {
		BufferedReader buff = null;
		StringBuilder data = new StringBuilder();
		String line;
		buff = new BufferedReader(new InputStreamReader(inputStream));
		while (null != (line = buff.readLine()) && !"null".equals(line)) data.append(line + "\n"); 
		/* if (flag) {
			System.out.println("rawdata="+data.toString() );
		} */

		if (ConnectionFactory.isDevelopment()) {
			System.out.println("output ---> "+data.toString()+" <---");
		}
		
		return data.toString();
	}
	
	public static String getHttpZipped(String url) throws Exception {
		return getHttpZipped(url,"GET");
	}
	
	public static String putHttpZipped(String url) throws Exception {
		return getHttpZipped(url,"PUT");
	}

	@SuppressWarnings("deprecation")
	public static String getHttpZipped(String url, String method) throws Exception {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		
		//System.out.println("getHttpZipped="+url);
		try {
			httpclient.addRequestInterceptor(new HttpRequestInterceptor() {

				public void process(
						final HttpRequest request,
						final HttpContext context) throws HttpException, IOException {
					if (!request.containsHeader("Accept-Encoding")) {
						//System.out.println("Accept-Encoding");
						request.addHeader("Accept-Encoding", "gzip");
					}
				}

			});

			httpclient.addResponseInterceptor(new HttpResponseInterceptor() {

				public void process(
						final HttpResponse response,
						final HttpContext context) throws HttpException, IOException {
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						Header ceheader = entity.getContentEncoding();
						if (ceheader != null) {
							HeaderElement[] codecs = ceheader.getElements();
							for (int i = 0; i < codecs.length; i++) {
								if (codecs[i].getName().equalsIgnoreCase("gzip")) {
									response.setEntity(
											new GzipDecompressingEntity(response.getEntity()));
									return;
								}
							}
						}
					}
				}

			});
			HttpEntity entity = null;
			
			if (method.equals("GET")) {
				HttpGet httpget = new HttpGet(url); 
				// Execute HTTP request
				//System.out.println("executing request " + httpget.getURI());
				HttpResponse response = httpclient.execute(httpget); 
				//            System.out.println("----------------------------------------");
				//            System.out.println(response.getStatusLine());
				//            System.out.println(response.getLastHeader("Content-Encoding"));
				//            System.out.println(response.getLastHeader("Set-Cookie"));
				//            System.out.println(response.getLastHeader("CF-RAY"));
				//            System.out.println("----------------------------------------");

				entity = response.getEntity(); 
				//System.out.println("entity="+entity);
			}

			if (method.equals("PUT")) {
				HttpPut httpput = new HttpPut(url);
				HttpResponse response = httpclient.execute(httpput); 
				entity = response.getEntity();
			}
			

			if (entity != null) {
				String content = EntityUtils.toString(entity);
				//                System.out.println(content);
				//                System.out.println("----------------------------------------");
				//                System.out.println("Uncompressed size: "+content.length());
				return content;
			}

		} finally {
			// When HttpClient instance is no longer needed,
			// shut down the connection manager to ensure
			// immediate deallocation of all system resources
			httpclient.getConnectionManager().shutdown();
			httpclient.close();
		}
		return null;
	}

	public static String httpLongRequest(String method, String url, String body, String authorization, String secret) {
		return httpRequestFlag(method, url, body, authorization, secret, false);
	}

	public static String httpRequest(String method, String url, String body, String authorization, String secret) {
		return httpRequestFlag(method, url, body, authorization, secret, true);
	}

	private static String httpRequestFlag(String method, String url, String body, String authorization, String secret, boolean flag) {

		System.out.println("method="+method+" url="+url+" body="+body);
	    String returnString = null;
	    String responseMessage = null; 
		try {

			URL surl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) surl.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod(method); // "POST";
			conn.setRequestProperty("Content-Type", "application/json");
			if (secret!=null)         conn.setRequestProperty("Secret", secret);
			if (authorization!=null)  conn.setRequestProperty("Authorization", authorization);
			
			if (body!=null) {
				OutputStream os = conn.getOutputStream();
			    os.write(body.getBytes("UTF-8"));
			    os.close();
			} 
			registraRemoteAddress(surl,conn);
			responseMessage = conn.getResponseCode()+" "+conn.getResponseMessage();
			
			if (200 <= conn.getResponseCode() && conn.getResponseCode() <= 299) {
				returnString =  HttpLib.getJsonString(conn.getInputStream(), flag);
		    } else {
		    	returnString = HttpLib.getJsonString(conn.getErrorStream(), flag);
		    }
			
		} catch (java.lang.NullPointerException e) {
			returnString = responseMessage;
		} catch (java.io.FileNotFoundException e) {
			returnString = responseMessage;
		} catch (Exception e) {
			e.printStackTrace(System.out);
			returnString = e.getMessage();
		}

		// System.out.println("returnString="+returnString);
		
		return returnString;
	}
	
	public static <T> void setProtectedFieldValue(Class<T> clazz, String fieldName, T object, Object newValue) throws Exception {
	    Field field = clazz.getDeclaredField(fieldName);

	    field.setAccessible(true);
	    field.set(object, newValue);
	 }
	private static void registraRemoteAddress(URL url, HttpURLConnection conn) throws Exception {
		java.net.InetAddress address = java.net.InetAddress.getByName(url.getHost());
		String ip = address.getHostAddress();
		//if(conn.getErrorStream()!=null)
		LoggerApi.Log.info("status code:"+conn.getResponseCode()+" Remote Address:"+ip+" Request Url:"+url.toString());
	}

 
}