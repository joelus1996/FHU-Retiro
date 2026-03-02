package pe.com.intralot.loto.utils;

/**<p> NAME:    Fingerprint.java         
 * </p>
 * <p> VERSION LOG
 * <pre>
 * VER   BY          DATE        COMMENT
 * 001   c_clarico  25/06/2021  encripta MD5 para virtuales
 * </pre>
 * </p>
 */

public final class  Fingerprint {
	
	private  Fingerprint ( ) { }
 
	public static String hash(String token, String game, String backurl, String mode, String language, String platform)
	{
		//generar fingerprint
		StringBuilder sbFingerprint = new StringBuilder();
		String fingerprint;
		try {
			sbFingerprint.append(token);
			sbFingerprint.append(game);
			sbFingerprint.append(backurl);
			sbFingerprint.append(mode);
			sbFingerprint.append(language);
			sbFingerprint.append(platform);
			sbFingerprint.append(Constantes.XPRESS_PRIVATE_KEY);
			fingerprint = StringLib.toMD5(sbFingerprint.toString());
		}catch (Exception e) {
			fingerprint = "0";
		}
		return fingerprint;
	}
	
	public static void main(String[] args) {
	
		//System.out.println( coverJsonLabel(s));
		String s="debit3s0zrxdr1mmf7i2q8hmeg48akx47c1041qpm7z4rthuhxvqf9nbpij8n-89287-d10174561799masterPENGR-10174-6031710-19466E22FD96E-8171-57EF-38DB-865CC6CB66BC1bet2021-06-29T01:22:36+00:00D8698A8C-20D9-BEE7-995C-111BBF2CE802608570KVM0OZ9AQNHWR1ESYU56";
		try {
			System.out.println(StringLib.toMD5(s));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
