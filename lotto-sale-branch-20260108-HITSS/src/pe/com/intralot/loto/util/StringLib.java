package pe.com.intralot.loto.util;

import java.util.Random;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import pe.com.intralot.loto.lib.Dbms;
import pe.com.intralot.loto.util.ConnectionFactory;
import pe.com.intralot.loto.util.Labeler;

import org.owasp.encoder.Encode;

/**<p> NAME:    StringLib.java         
 * </p>
 * <p> VERSION LOG
 * <pre>
 * VER   BY          DATE        COMMENT
 * 001   c_achata    23/01/2008  First comment
 * </pre>
 * </p>
 */

public final class  StringLib extends ConnectionFactory{
	
	private final static String key = "20TiNk@l@tInK@18";
	
	private  StringLib ( ) { }

	public static String coverLabel(long label)
	{
		return coverLabel(String.valueOf(label));
	}

	public static String coverLabel0(long label)
	{
		return String.valueOf(label);
	}
		
	public static String coverLabel(String label)
	{
		if (label == null) return null;
		
		int len = label.length();		
		String uspass2 = (len <= 4) ? padLeft("",'*',len) : "****"+label.substring(len-1) ;

		return uspass2;
        
	}

	public static String coverLabel(String title, String label) {
		return coverLabel(title, label, " ");
	}
	
	public static String coverLabel(String title, String label, String limitChar) {
		String applicationArea = operationProperty("applicationArea");
		if (applicationArea!=null && applicationArea.equalsIgnoreCase("development")) {
				return label;	
		}

		try {
			String uspass2 = null;
			String labelTrimed = label.trim();
			String titleTrimed = title.trim();
			
			String labelUpper = labelTrimed.toUpperCase();
			String titleUpper = titleTrimed.toUpperCase();
			int i = labelUpper.indexOf(titleUpper);
			int k = i+titleUpper.length();
			while (k<labelUpper.length() && labelUpper.charAt(k)==' ') {k++;}
			if (i>=0) {
				int j = labelTrimed.indexOf(limitChar,k);
				if (j > 0) {
					String start = labelTrimed.substring(0, i+titleTrimed.length()+1 );
					String subs = labelTrimed.substring(i+titleTrimed.length(), j);
					String end = labelTrimed.substring(j);
					uspass2 =  start+
					           coverLabel(subs) +
					           end ;
					
				} else {
					try {
					    uspass2 = labelTrimed.substring(0, i+titleTrimed.length() +1 ) +
					              coverLabel(labelTrimed.substring(i+titleTrimed.length()  ) ) ;
					} catch (Exception e) {
						uspass2 = labelTrimed;
					}
				}
			} else {
				uspass2 = labelTrimed;
			}
			
			return uspass2;			
		} catch (Exception e) {
			try {
				LoggerApi.severe(e, title, label); 
			} catch (Exception e1) {
				MailLib.sendErrorMail (e1,"coverLabel()","");
			}
			return "Exception";
		}

	}
	
	public static boolean isNumeric(String s) {
		boolean isNumeric=true;
		for(int i=0; i<s.length();i++){
			if ( (s.charAt(i)>='0') && (s.charAt(i)<='9') ) {
				;
			} else {
				isNumeric=false;
				break;
			}
		}
		return isNumeric;
	}
 
	public static String encodeLabel(String label)
	throws Exception
	{
		Labeler labeler = new Labeler();
		String cod = labeler.encodeLabel(label);
		
		if (cod==null) return null;
		
		StringBuffer buffer = new StringBuffer(); 
		for (int i=0; i<cod.length(); i++) {
			char c = cod.charAt(i);
			if(c!='\r' && c!='\n' && c!='\t') buffer.append(c);
		}
		return buffer.toString();
	}
	
	public static String decodeLabel(String labelEncoded)
	throws Exception
	{
		Labeler labeler = new Labeler();
		return labeler.decodeLabel(labelEncoded);
	}
			
	public static String encodeLongLabel(String label)
	throws Exception
	{
		if (label == null) return null;
		String uspass    = label;
		String uspass2   = null;
		String uspasse   = new sun.misc.BASE64Encoder().encode (uspass.getBytes());
		uspass2   = new sun.misc.BASE64Encoder().encode (uspasse.getBytes());			
		return uspass2;
	}
	public static String decodeLongLabel(String labelEncoded)
	throws Exception
	{
		if (labelEncoded == null) return null;
		sun.misc.BASE64Decoder dec = new sun.misc.BASE64Decoder();
		String uspassd  = new String(dec.decodeBuffer(labelEncoded))  ;
		String uspassd2 = new String(dec.decodeBuffer(uspassd))  ;
		String label = uspassd2;
		return label;
	}  
	
    public static String  fill (  char  c, int  length )
    {
      String s = "";
      while ( s.length ( ) < length ) s = c + s;
      return s;
    }

     public static String  padLeft ( String  s, char  c, int  length )
     {
       if ( s == null ) return null;
       if ( length <= s.length ( ) ) return new String ( s );

       while ( s.length ( ) < length ) s = c + s;
       return s;
     }
     
     public static String padRight(String  s, char  c, int length) {
         int j = s.length();
         for(int k = 0; k < length - j; k++)
             s = s + c;
         return s;
     }
	    
     public static String generatePassword (int length) 
     {
    	 Random generator = new Random();

    	 String[][] letter = { {"a","e","i","o","u"},
    			 {"b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","v","w","x","y","z"},
    			 {"br","ch","cr","fr","gr","pr","pl","tr"},
    			 {"lt","lm","ln","ls","mn","st","sm"}};

    	 // first character
    	 int first = generator.nextInt(3);
    	 int component= generator.nextInt( letter[first].length ) ;
    	 String password = letter[first][component];
    	 boolean cons = false;
    	 if (first!=0) cons=true;

    	 while ( password.length() < length) {
    		 if (cons) {
    			 int index = generator.nextInt(5);
    			 password += letter[0][index];
    			 cons=false;
    		 }
    		 else {
    			 int[] prob = {1,1,1,2,3};
    			 // has more probability 3/5 for a consonant
    			 int index      = generator.nextInt( prob.length );
    			 int element    = generator.nextInt( letter[prob[index]].length ) ;
    			 password += letter[prob[index]][element];
    			 cons = !cons;
    		 }
    	 }
    	 // if the last adding is a double constant, it can have an extra character
    	 return password.substring(0,length); 
     } 
 
     public static int countString(String base, String match) 
     {
		  int i=0;
		  int k=0;
		  while (true) {
			  int r = base.indexOf(match,i);
			  if (r>=0 ) { k++; i=r+1;}
			  else break;
		  }
		  return k;
     } 
     
     public final static String removeWhitespaces(String s) {

         StringBuffer str = new StringBuffer();

         for (int i = 0; i < s.length(); i++) {
             if (Character.isWhitespace(s.charAt(i)) ) {
            	 ;
             } else {
                 str.append(s.charAt(i));
             }
         }

         return str.toString();
     }

 	public static String cover(String str)
 	{
 		if (str == null) return null;
 		
 		int len = str.length();		
 		String uspass2 = (len <= 4) ? padLeft("",'*',len) : "****"+str.substring(len-2) ;

 		return uspass2;
         
 	}

	public static String formatHtml(String text) {
		String UNICODE_SMALL_A_GRAVE = "\u00E0";
		String UNICODE_SMALL_A_ACUTE = "\u00E1";
		String UNICODE_SMALL_A_CIRC = "\u00E2";
		String UNICODE_SMALL_A_TILDE = "\u00E3";
		String UNICODE_SMALL_A_UML = "\u00E4";
		String UNICODE_SMALL_A_RING = "\u00E5";
		String UNICODE_SMALL_C_CEDIL = "\u00E7"; 
		String UNICODE_SMALL_E_GRAVE = "\u00E8";
		String UNICODE_SMALL_E_ACUTE = "\u00E9";
		String UNICODE_SMALL_E_CIRC = "\u00EA";
		String UNICODE_SMALL_E_UML = "\u00EB";
		String UNICODE_SMALL_I_GRAVE = "\u00EC";
		String UNICODE_SMALL_I_ACUTE = "\u00ED";
		String UNICODE_SMALL_I_CIRC = "\u00EE";
		String UNICODE_SMALL_I_UML = "\u00EF";
		String UNICODE_SMALL_O_GRAVE = "\u00F2";
		String UNICODE_SMALL_O_ACUTE = "\u00F3";
		String UNICODE_SMALL_O_CIRC = "\u00F4";
		String UNICODE_SMALL_O_TILDE = "\u00F5";
		String UNICODE_SMALL_O_UML = "\u00F6";
		String UNICODE_SMALL_U_GRAVE = "\u00F9";
		String UNICODE_SMALL_U_ACUTE = "\u00FA";
		String UNICODE_SMALL_U_CIRC = "\u00FB";
		String UNICODE_SMALL_U_UML = "\u00FC";
		String UNICODE_SMALL_N_TILDE = "\u00F1";
		String UNICODE_CAPITAL_A_GRAVE = "\u00C0";
		String UNICODE_CAPITAL_A_ACUTE = "\u00C1";
		String UNICODE_CAPITAL_A_CIRC = "\u00C2";
		String UNICODE_CAPITAL_A_TILDE = "\u00C3";
		String UNICODE_CAPITAL_A_UML = "\u00C4";
		String UNICODE_CAPITAL_A_RING = "\u00C5";
		String UNICODE_CAPITAL_C_CEDIL = "\u00C7"; 
		String UNICODE_CAPITAL_E_GRAVE = "\u00C8";
		String UNICODE_CAPITAL_E_ACUTE = "\u00C9";
		String UNICODE_CAPITAL_E_CIRC = "\u00CA";
		String UNICODE_CAPITAL_E_UML = "\u00CB";
		String UNICODE_CAPITAL_I_GRAVE = "\u00CC";
		String UNICODE_CAPITAL_I_ACUTE = "\u00CD";
		String UNICODE_CAPITAL_I_CIRC = "\u00CE";
		String UNICODE_CAPITAL_I_UML = "\u00CF";
		String UNICODE_CAPITAL_O_GRAVE = "\u00D2";
		String UNICODE_CAPITAL_O_ACUTE = "\u00D3";
		String UNICODE_CAPITAL_O_CIRC = "\u00D4";
		String UNICODE_CAPITAL_O_TILDE = "\u00D5";
		String UNICODE_CAPITAL_O_UML = "\u00D6";
		String UNICODE_CAPITAL_U_GRAVE = "\u00D9";
		String UNICODE_CAPITAL_U_ACUTE = "\u00DA";
		String UNICODE_CAPITAL_U_CIRC = "\u00DB";
		String UNICODE_CAPITAL_U_UML = "\u00DC";
		String UNICODE_CAPITAL_N_TILDE = "\u00D1";
		String UNICODE_IEXCLAMATION = "\u00A1";
		String UNICODE_GRADE = "\u00B0";
		String UNICODE_IQUESTION = "\u00BF";
		String UNICODE_RETURN = "\\u000D";
		String UNICODE_NEWLINE = "\\u000A";
		String UNICODE_DOBLEQUOTE = "\\u0022";
		String UNICODE_EURO = "\u0080";
		String UNICODE_PLUS = "\\u002B";
		String UNICODE_PLUS_MINUS = "\u00B1";
		return text.replaceAll(UNICODE_SMALL_A_GRAVE, "&agrave;")
					.replaceAll(UNICODE_SMALL_A_ACUTE, "&aacute;")
					.replaceAll(UNICODE_SMALL_A_CIRC, "&acirc;")
					.replaceAll(UNICODE_SMALL_A_TILDE, "&atilde;")
					.replaceAll(UNICODE_SMALL_A_UML, "&auml;")
					.replaceAll(UNICODE_SMALL_A_RING, "&aring;")
					.replaceAll(UNICODE_SMALL_C_CEDIL, "&ccedil;")
					.replaceAll(UNICODE_SMALL_E_GRAVE, "&egrave;")
					.replaceAll(UNICODE_SMALL_E_ACUTE, "&eacute;")
					.replaceAll(UNICODE_SMALL_E_CIRC, "&ecirc;")
					.replaceAll(UNICODE_SMALL_E_UML, "&euml;")
					.replaceAll(UNICODE_SMALL_I_GRAVE, "&igrave;")
					.replaceAll(UNICODE_SMALL_I_ACUTE, "&iacute;")
					.replaceAll(UNICODE_SMALL_I_CIRC, "&icirc;")
					.replaceAll(UNICODE_SMALL_I_UML, "&iuml;")
					.replaceAll(UNICODE_SMALL_O_GRAVE, "&ograve;")
					.replaceAll(UNICODE_SMALL_O_ACUTE, "&oacute;")
					.replaceAll(UNICODE_SMALL_O_CIRC, "&ocirc;")
					.replaceAll(UNICODE_SMALL_O_TILDE, "&otilde;")
					.replaceAll(UNICODE_SMALL_O_UML, "&ouml;")
					.replaceAll(UNICODE_SMALL_U_GRAVE, "&ugrave;")
					.replaceAll(UNICODE_SMALL_U_ACUTE, "&uacute;")
					.replaceAll(UNICODE_SMALL_U_CIRC, "&ucirc;")
					.replaceAll(UNICODE_SMALL_U_UML, "&uuml;")
					.replaceAll(UNICODE_SMALL_N_TILDE, "&ntilde;")
					.replaceAll(UNICODE_CAPITAL_A_GRAVE, "&Agrave;")
					.replaceAll(UNICODE_CAPITAL_A_ACUTE, "&Aacute;")
					.replaceAll(UNICODE_CAPITAL_A_CIRC, "&Acirc;")
					.replaceAll(UNICODE_CAPITAL_A_TILDE, "A")
					.replaceAll(UNICODE_CAPITAL_A_UML, "&Atilde;")
					.replaceAll(UNICODE_CAPITAL_A_RING, "&Auml;")
					.replaceAll(UNICODE_CAPITAL_C_CEDIL, "&Ccedil;")
					.replaceAll(UNICODE_CAPITAL_E_GRAVE, "&Egrave;")
					.replaceAll(UNICODE_CAPITAL_E_ACUTE, "&Eacute;")
					.replaceAll(UNICODE_CAPITAL_E_CIRC, "&Ecirc;")
					.replaceAll(UNICODE_CAPITAL_E_UML, "&Euml;")
					.replaceAll(UNICODE_CAPITAL_I_GRAVE, "&Igrave;")
					.replaceAll(UNICODE_CAPITAL_I_ACUTE, "&Iacute;")
					.replaceAll(UNICODE_CAPITAL_I_CIRC, "&Icirc;")
					.replaceAll(UNICODE_CAPITAL_I_UML, "&Iuml;")
					.replaceAll(UNICODE_CAPITAL_O_GRAVE, "&Ograve;")
					.replaceAll(UNICODE_CAPITAL_O_ACUTE, "&Oacute;")
					.replaceAll(UNICODE_CAPITAL_O_CIRC, "&Ocirc;")
					.replaceAll(UNICODE_CAPITAL_O_TILDE, "&Otilde;")
					.replaceAll(UNICODE_CAPITAL_O_UML, "&Ouml;")
					.replaceAll(UNICODE_CAPITAL_U_GRAVE, "&Ugrave;")
					.replaceAll(UNICODE_CAPITAL_U_ACUTE, "&Uacute;")
					.replaceAll(UNICODE_CAPITAL_U_CIRC, "&Ucirc;")
					.replaceAll(UNICODE_CAPITAL_U_UML, "&Uuml;")
					.replaceAll(UNICODE_CAPITAL_N_TILDE, "&Ntilde;")
					.replaceAll(UNICODE_IEXCLAMATION, "&iexcl;")
					.replaceAll(UNICODE_GRADE, "&deg;")
					.replaceAll(UNICODE_IQUESTION, "&iquest;")
					.replaceAll(UNICODE_RETURN, "<br/>")
					.replaceAll(UNICODE_NEWLINE, "<br/>")
					.replaceAll(UNICODE_DOBLEQUOTE, "&quot;")
					.replaceAll(UNICODE_EURO, "&euro;")
					.replaceAll(UNICODE_PLUS, "&plusmn;")
					.replaceAll(UNICODE_PLUS_MINUS, "&plusmn;");
	}
  
	/*private static int[] core_md5(int x[], int len) {
        int aux[] = null;
        aux = x;
        x = new int[16];
        for(int j = 0; j < aux.length; j++) x[j] = aux[j];
        int cnt = x.length;
        x[len >> 5] |= 0x80 << ((len) % 32);
        x[(((len + 64) >>> 9) << 4) + 14] = len;
        int a = 1732584193;
        int b = -271733879;
        int c = -1732584194;
        int d = 271733878;
        for(int i = 0; i < x.length; i += 16) {
            int olda = a;
            int oldb = b;
            int oldc = c;
            int oldd = d;
            if((i + 0) < cnt) a = md5_ff(a, b, c, d, x[i + 0], 7, -680876936);
            if((i + 1) < cnt) d = md5_ff(d, a, b, c, x[i + 1], 12, -389564586);
            if((i + 2) < cnt) c = md5_ff(c, d, a, b, x[i + 2], 17, 606105819);
            if((i + 3) < cnt) b = md5_ff(b, c, d, a, x[i + 3], 22, -1044525330);
            if((i + 4) < cnt) a = md5_ff(a, b, c, d, x[i + 4], 7, -176418897);
            if((i + 5) < cnt) d = md5_ff(d, a, b, c, x[i + 5], 12, 1200080426);
            if((i + 6) < cnt) c = md5_ff(c, d, a, b, x[i + 6], 17, -1473231341);
            if((i + 7) < cnt) b = md5_ff(b, c, d, a, x[i + 7], 22, -45705983);
            if((i + 8) < cnt) a = md5_ff(a, b, c, d, x[i + 8], 7, 1770035416);
            if((i + 9) < cnt) d = md5_ff(d, a, b, c, x[i + 9], 12, -1958414417);
            if((i + 10) < cnt) c = md5_ff(c, d, a, b, x[i + 10], 17, -42063);
            if((i + 11) < cnt) b = md5_ff(b, c, d, a, x[i + 11], 22, -1990404162);
            if((i + 12) < cnt) a = md5_ff(a, b, c, d, x[i + 12], 7, 1804603682);
            if((i + 13) < cnt) d = md5_ff(d, a, b, c, x[i + 13], 12, -40341101);
            if((i + 14) < cnt) c = md5_ff(c, d, a, b, x[i + 14], 17, -1502002290);
            if((i + 15) < cnt) b = md5_ff(b, c, d, a, x[i + 15], 22, 1236535329);
            if((i + 1) < cnt) a = md5_gg(a, b, c, d, x[i + 1], 5, -165796510);
            if((i + 6) < cnt) d = md5_gg(d, a, b, c, x[i + 6], 9, -1069501632);
            if((i + 11) < cnt) c = md5_gg(c, d, a, b, x[i + 11], 14, 643717713);
            if((i + 0) < cnt) b = md5_gg(b, c, d, a, x[i + 0], 20, -373897302);
            if((i + 5) < cnt) a = md5_gg(a, b, c, d, x[i + 5], 5, -701558691);
            if((i + 10) < cnt) d = md5_gg(d, a, b, c, x[i + 10], 9, 38016083);
            if((i + 15) < cnt) c = md5_gg(c, d, a, b, x[i + 15], 14, -660478335);
            if((i + 4) < cnt) b = md5_gg(b, c, d, a, x[i + 4], 20, -405537848);
            if((i + 9) < cnt) a = md5_gg(a, b, c, d, x[i + 9], 5, 568446438);
            if((i + 14) < cnt) d = md5_gg(d, a, b, c, x[i + 14], 9, -1019803690);
            if((i + 3) < cnt) c = md5_gg(c, d, a, b, x[i + 3], 14, -187363961);
            if((i + 8) < cnt) b = md5_gg(b, c, d, a, x[i + 8], 20, 1163531501);
            if((i + 13) < cnt) a = md5_gg(a, b, c, d, x[i + 13], 5, -1444681467);
            if((i + 2) < cnt) d = md5_gg(d, a, b, c, x[i + 2], 9, -51403784);
            if((i + 7) < cnt) c = md5_gg(c, d, a, b, x[i + 7], 14, 1735328473);
            if((i + 12) < cnt) b = md5_gg(b, c, d, a, x[i + 12], 20, -1926607734);
            if((i + 5) < cnt) a = md5_hh(a, b, c, d, x[i + 5], 4, -378558);
            if((i + 8) < cnt) d = md5_hh(d, a, b, c, x[i + 8], 11, -2022574463);
            if((i + 11) < cnt) c = md5_hh(c, d, a, b, x[i + 11], 16, 1839030562);
            if((i + 14) < cnt) b = md5_hh(b, c, d, a, x[i + 14], 23, -35309556);
            if((i + 1) < cnt) a = md5_hh(a, b, c, d, x[i + 1], 4, -1530992060);
            if((i + 4) < cnt) d = md5_hh(d, a, b, c, x[i + 4], 11, 1272893353);
            if((i + 7) < cnt) c = md5_hh(c, d, a, b, x[i + 7], 16, -155497632);
            if((i + 10) < cnt) b = md5_hh(b, c, d, a, x[i + 10], 23, -1094730640);
            if((i + 13) < cnt) a = md5_hh(a, b, c, d, x[i + 13], 4, 681279174);
            if((i + 0) < cnt) d = md5_hh(d, a, b, c, x[i + 0], 11, -358537222);
            if((i + 3) < cnt) c = md5_hh(c, d, a, b, x[i + 3], 16, -722521979);
            if((i + 6) < cnt) b = md5_hh(b, c, d, a, x[i + 6], 23, 76029189);
            if((i + 9) < cnt) a = md5_hh(a, b, c, d, x[i + 9], 4, -640364487);
            if((i + 12) < cnt) d = md5_hh(d, a, b, c, x[i + 12], 11, -421815835);
            if((i + 15) < cnt) c = md5_hh(c, d, a, b, x[i + 15], 16, 530742520);
            if((i + 2) < cnt) b = md5_hh(b, c, d, a, x[i + 2], 23, -995338651);
            if((i + 0) < cnt) a = md5_ii(a, b, c, d, x[i + 0], 6, -198630844);
            if((i + 7) < cnt) d = md5_ii(d, a, b, c, x[i + 7], 10, 1126891415);
            if((i + 14) < cnt) c = md5_ii(c, d, a, b, x[i + 14], 15, -1416354905);
            if((i + 5) < cnt) b = md5_ii(b, c, d, a, x[i + 5], 21, -57434055);
            if((i + 12) < cnt) a = md5_ii(a, b, c, d, x[i + 12], 6, 1700485571);
            if((i + 3) < cnt) d = md5_ii(d, a, b, c, x[i + 3], 10, -1894986606);
            if((i + 10) < cnt) c = md5_ii(c, d, a, b, x[i + 10], 15, -1051523);
            if((i + 1) < cnt) b = md5_ii(b, c, d, a, x[i + 1], 21, -2054922799);
            if((i + 8) < cnt) a = md5_ii(a, b, c, d, x[i + 8], 6, 1873313359);
            if((i + 15) < cnt) d = md5_ii(d, a, b, c, x[i + 15], 10, -30611744);
            if((i + 6) < cnt) c = md5_ii(c, d, a, b, x[i + 6], 15, -1560198380);
            if((i + 13) < cnt) b = md5_ii(b, c, d, a, x[i + 13], 21, 1309151649);
            if((i + 4) < cnt) a = md5_ii(a, b, c, d, x[i + 4], 6, -145523070);
            if((i + 11) < cnt) d = md5_ii(d, a, b, c, x[i + 11], 10, -1120210379);
            if((i + 2) < cnt) c = md5_ii(c, d, a, b, x[i + 2], 15, 718787259);
            if((i + 9) < cnt) b = md5_ii(b, c, d, a, x[i + 9], 21, -343485551);
            a = safe_add(a, olda);
            b = safe_add(b, oldb);
            c = safe_add(c, oldc);
            d = safe_add(d, oldd);
        }
        return new int[] { a, b, c, d };
    }

    private static int md5_ff(int a, int b, int c, int d, int x, int s, int t) {
    	return md5_cmn((b & c) | ((~b) & d), a, b, x, s, t);
    }

    private static int md5_gg(int a, int b, int c, int d, int x, int s, int t) {
    	return md5_cmn((b & d) | (c & (~d)), a, b, x, s, t);
    }

    private static int md5_hh(int a, int b, int c, int d, int x, int s, int t) {
    	return md5_cmn(b ^ c ^ d, a, b, x, s, t);
    }

    private static int md5_ii(int a, int b, int c, int d, int x, int s, int t) {
    	return md5_cmn(c ^ (b | (~d)), a, b, x, s, t);
    }

    private static int md5_cmn(int q, int a, int b, int x, int s, int t) {
    	return safe_add(bit_rol(safe_add(safe_add(a, q), safe_add(x, t)), s), b);
    }

    private static int safe_add(int x, int y) {
        int lsw = (x & 0xFFFF) + (y & 0xFFFF);
        int msw = (x >> 16) + (y >> 16) + (lsw >> 16);
        return (msw << 16) | (lsw & 0xFFFF);
    }

    private static int bit_rol(int num, int cnt) {
        return (num << cnt) | (num >>> (32 - cnt));
    }

    private static int[] str2binl(String str, int chrsz) {
        int bin[] = new int[0];
        int aux[] = null;
        int mask = (1 << chrsz) - 1;
        for(int i = 0; i < str.length() * chrsz; i += chrsz) {
            aux = bin;
            bin = new int[aux.length + 1];
            for (int j = 0; j < aux.length; j++) bin[j] = aux[j];
            bin[i >> 5] |= (str.charAt(i / chrsz) & mask) << (i % 32);
        }
        for(int i = bin.length - 1; i >= 0; i--) {
            if (bin[i] == 0) {
                aux = bin;
                bin = new int[aux.length - 1];
                for (int j = 0; j < aux.length - 1; j++) bin[j] = aux[j];
            } else break;
        }
        return bin;
    }

    private static int[] crypt(int ina[], int State31pn, int Polynom31pn, int State33pn, int Polynom33pn, int State64Hpn, int State64Lpn, int Polynom64pn, int Buttpn) {
        int ota[] = new int[ina.length];
        int State31 = State31pn;
        int Polynom31 = Polynom31pn;
        int State33 = State33pn;
        int Polynom33 = Polynom33pn;
        int State64H = State64Hpn;
        int State64L = State64Lpn;
        int Polynom64 = Polynom64pn;
        int Butt = Buttpn;
        int pn = 0;
        for(int i = 0; i < ina.length; i++) {
            do{
                int MSB = State31 & 0x80000000;
                State31 &= 0x7fffffff;
                if ((State31 & 1) != 0) State31 = (State31 >>> 1) ^ Polynom31;
                else State31 >>>= 1;
                if ((State33 & 0x80000000) != 0) State31 |= 0x80000000;
                if (MSB != 0) State33 = (State33 << 1) ^ Polynom33;
                else State33 <<= 1;
                MSB = (State64H & 1);
                State64H >>>= 1;
                State64H |= State64L & 0x80000000;
                if (MSB != 0) State64L = (State64L << 1) ^ Polynom64;
                else State64L <<= 1;
            } while ((State64L & Butt) != 0);
            pn = (State31 ^ State33);
            ota[i] = ina[i] ^ pn;
        }
        return ota;
    }

    * DESENCRIPTA *

    public static String decrypt_sda(String wbuffer) {
    	return decrypt_sda(wbuffer, null);
    }
    public static String decrypt_sda(String wbuffer, String passphr) {
    	if(passphr==null) passphr = String.valueOf(ConnectionFactory.operationProperty("lotosaleKey")).toString().trim();//palabra clave
        int State31 = 0, Polynom31 = 0, State33 = 0, Polynom33 = 0, State64H = 0, State64L = 0, Polynom64 = 0, Butt = 0;
        String dwbuffer = "";
        int chrsz = 8; * bits per input character. 8 - ASCII; 16 - Unicode *
        int Polynomials31[] = { 0x40c6e78f, 0x44ea7b19, 0x45da25ce, 0x470c368e, 0x4920f4c1, 0x4a2fb865, 0x4b641875, 0x4d474412, 0x4c175700, 0x4e880047, 0x50a5894c, 0x51ae3883, 0x531df126, 0x563e62e8,
                0x586801c2, 0x5bef4706, 0x5c14c48a, 0x5d06e2a7, 0x5f2f8a72, 0x623311d9, 0x65616f52, 0x668043b4, 0x672161c9, 0x67f0a6a8, 0x6814750f, 0x6c4920c3, 0x6dca541b, 0x6e97e1ed, 0x70963ac8,
                0x72de5f24, 0x7411688a, 0x7502196b, 0x76202331, 0x7887a9e1, 0x790621f4, 0x7e79deae, 0x7faca450 };
        int pnState[] = core_md5(str2binl(passphr, chrsz), passphr.length() * chrsz);
        State31 = pnState[0];
        if((State31 & 0x7fffffff) == 0) State31++;
        State33 = pnState[1];
        if (State33 == 0) State33++;
        State64H = pnState[2];
        State64L = pnState[3];
        if(State64H == 0 && State64L == 0) State64L++;
        int Polynom[] = core_md5(pnState, 0x80);
        int[] Polynommd5 = core_md5(str2binl(passphr, chrsz), passphr.length() * chrsz >> 1);
        for(int i = 0; i < Polynom.length; i++) Polynom[i] ^= Polynommd5[i];
        Polynom31 = Polynomials31[(Polynom[0] >>> 1) % Polynomials31.length];
        Polynom33 = Polynom[1] | 1;
        Polynom64 = Polynom[2] | 1;
        Butt = 1 << (Polynom[3] & 0x1f);
        Butt |= 1 << ((Polynom[3] >> 8) & 0x1f);
        dwbuffer += expand7to8(crypt(b64_to_array(wbuffer), State31, Polynom31, State33, Polynom33, State64H, State64L, Polynom64, Butt));
        return dwbuffer;
    }

    private static String expand7to8(int array[]) {
        String str = "";
        for(int i = 0; i < array.length; i += 7) {
            int tmp = array[i];
            int out = tmp >> 1;
            str += (char) (out & 0x7f);
            for(int j = 1; j < 8; j++) {
                out = (tmp << (7 - j)) & 0x7f;
                if(i + j < array.length) tmp = array[i + j];
                str += (char) (out |= (tmp & 0xff) >> (j + 1));
            }
        }
        str = str.split("\0")[0];
        return str;
    }

    private static int[] b64_to_array(String str) {
        int decode[] = b64_decode_tab();
        int arr[] = new int[0];
        int aux[] = null;
        int lng = str.length();
        for(int i = 0; i < str.length(); i += 4) {
            int b1 = str.charAt(i);
            int b2 = (i + 1 < lng) ? (int) str.charAt(i + 1) : 0;
            int b3 = (i + 2 < lng) ? (int) str.charAt(i + 2) : 0;
            int b4 = (i + 3 < lng) ? (int) str.charAt(i + 3) : 0;
            int triplet = ((decode[b1] << 18) & 0xffffff) | ((decode[b2] << 12) & 0x3ffff) | ((decode[b3] << 6) & 0xfff) | ((decode[b4]) & 0x3f);
            aux = arr;
            arr = new int[aux.length + 1];
            for(int j = 0; j < aux.length; j++) arr[j] = aux[j];
            arr[arr.length - 1] = (triplet >> 16) & 0xff;
            if(b3 != 0) {
                aux = arr;
                arr = new int[aux.length + 1];
                for(int j = 0; j < aux.length; j++) arr[j] = aux[j];
                arr[arr.length - 1] = (triplet >> 8) & 0xff;
            }
            if(b4 != 0) {
                aux = arr;
                arr = new int[aux.length + 1];
                for(int j = 0; j < aux.length; j++) arr[j] = aux[j];
                arr[arr.length - 1] = triplet & 0xff;
            }
        }
        return arr;
    }

    private static int[] b64_decode_tab() {
        String b64_tab = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        int decode[] = new int[0];
        int aux[] = null;
        for(int i = 0; i < b64_tab.length(); i++) {
            aux = decode;
            if((b64_tab.charAt(i)) >= aux.length) {
                decode = new int[(b64_tab.charAt(i)) + 1];
                for(int j = 0; j < aux.length; j++) decode[j] = aux[j];
            }
            decode[b64_tab.charAt(i)] = i;
        }
        return decode;
    }

    * ENCRIPTA *

    public static String encrypt_sda(String plainstr) {
    	return encrypt_sda(plainstr, null);
    }
    public static String encrypt_sda(String plainstr, String passphr) {
    	if(passphr==null) passphr = String.valueOf(ConnectionFactory.operationProperty("lotosaleKey")).toString().trim();//palabra clave
        int State31 = 0, Polynom31 = 0, State33 = 0, Polynom33 = 0, State64H = 0, State64L = 0, Polynom64 = 0, Butt = 0;
        int chrsz = 8; * bits per input character. 8 - ASCII; 16 - Unicode *
        int Polynomials31[] = { 0x40c6e78f, 0x44ea7b19, 0x45da25ce, 0x470c368e, 0x4920f4c1, 0x4a2fb865, 0x4b641875, 0x4d474412, 0x4c175700, 0x4e880047, 0x50a5894c, 0x51ae3883, 0x531df126, 0x563e62e8,
                0x586801c2, 0x5bef4706, 0x5c14c48a, 0x5d06e2a7, 0x5f2f8a72, 0x623311d9, 0x65616f52, 0x668043b4, 0x672161c9, 0x67f0a6a8, 0x6814750f, 0x6c4920c3, 0x6dca541b, 0x6e97e1ed, 0x70963ac8,
                0x72de5f24, 0x7411688a, 0x7502196b, 0x76202331, 0x7887a9e1, 0x790621f4, 0x7e79deae, 0x7faca450 };
        int pnState[] = core_md5(str2binl(passphr, chrsz), passphr.length() * chrsz);
        State31 = pnState[0];
        if((State31 & 0x7fffffff) == 0) State31++;
        State33 = pnState[1];
        if(State33 == 0)State33++;
        State64H = pnState[2];
        State64L = pnState[3];
        if(State64H == 0 && State64L == 0) State64L++;
        int Polynom[] = core_md5(pnState, 0x80);
        int[] Polynommd5 = core_md5(str2binl(passphr, chrsz), passphr.length() * chrsz >> 1);
        for(int i = 0; i < Polynom.length; i++) Polynom[i] ^= Polynommd5[i];
        Polynom31 = Polynomials31[(Polynom[0] >>> 1) % Polynomials31.length];
        Polynom33 = Polynom[1] | 1;
        Polynom64 = Polynom[2] | 1;
        Butt = 1 << (Polynom[3] & 0x1f);
        Butt |= 1 << ((Polynom[3] >> 8) & 0x1f);
        String dwbuffer = array_to_form(crypt(compress8to7(plainstr), State31, Polynom31, State33, Polynom33, State64H, State64L, Polynom64, Butt));
        return dwbuffer;
    }

    private static String array_to_form(int[] arr) {
        String b64_tab = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        String wbuffer = "";
        int lng = arr.length;
        String str = "";// "\"";//"";
        for(int i = 0; i < lng; i += 3) {
            int b2 = (i + 1 < lng) ? arr[i + 1] : 0;
            int b3 = (i + 2 < lng) ? arr[i + 2] : 0;
            int triplet = ((arr[i] << 16) & 0xffffff) | ((b2 << 8) & 0xffff) | (b3 & 0xff);
            str += b64_tab.charAt((triplet >> 18) & 0x3f);
            str += b64_tab.charAt((triplet >> 12) & 0x3f);
            if(b2 != 0) str += b64_tab.charAt((triplet >> 6) & 0x3f);
            if(b3 != 0) str += b64_tab.charAt(triplet & 0x3f);
            if(i % 48 == 45) {
                str += "";
                wbuffer += str;
                if(i < lng - 3) str = "";
            } else {
                if(i >= lng - 3) {
                    str += "";
                    wbuffer += str;
                }
            }
        }
        return wbuffer;
    }

    private static int[] compress8to7(String str) {
        int arr[] = new int[0];
        int aux[] = null;
        for(int i = 0; i < str.length(); i += 8) {
            int val = str.charAt(i) << 1 & 0xfe;
            for(int j = 0; j < 7 && i + j < str.length() + 1; j++) {
                int tmp = 0;
                if(i + j + 1 < str.length()) tmp = str.charAt(i + j + 1) << (j + 2);
                val |= tmp >> 8;
                aux = arr;
                arr = new int[aux.length + 1];
                for(int k = 0; k < aux.length; k++) arr[k] = aux[k];
                arr[arr.length - 1] = (val & 0xff);
                val = tmp & 0xff;
            }
        }
        return arr;
    }*/

	public static void main(String[] args) {
		
		for (int i=0; i<=10; i++) {
			int ini = 1; // 10000;
			int fin = 1; // 99999;
		 	long seed = System.nanoTime();
		    Random generator = new Random(seed);
		    String pin = (generator.nextInt((fin-ini)+1)+ini)+"";	    
		    System.out.println(seed+" "+pin );
		}
		
	}
	    
	public static String getRandom(int ini, int fin) {
	 	long seed = System.nanoTime();
	    Random generator = new Random(seed);
	    String pin = (generator.nextInt((fin-ini)+1)+ini)+"";	    
	    return pin;
	}
	
    /*public static void main(String[] args) throws UnsupportedEncodingException {

    	String plainstr = "EQ38Z1qvdfR2aHjQFn7KUMRsIEzwmNehJsKhsHzWTl09G%2B8r5nigFsSNROyIiF2Qf5gUWLh8GY3ax84To6IgcmHnnJhi8CvwxPZKSQ4OhG84XnihxLUzmkgV%2B3fuZXPNvbZSmVl8bseHFTahV2uDPikcem69Oj3c8IGgf2RMJTnugTRp79Hia0TLLjPuKTXkoat1yWU04zvBgpLMsYmxL6PUras%2FNC9G";
    	
        System.out.println("plainstr=" + plainstr);
        plainstr = plainstr.replace("+", "%2B");
        System.out.println("%plainstr=" + plainstr);
        plainstr = URLDecoder.decode(plainstr, "UTF-8");
        System.out.println("decoded=" + plainstr);
        plainstr = StringLib.decrypt_sda(plainstr,"ABCINTRALOTDEPERUKEY");
        System.out.println("decrypt=" + plainstr);*/
        
        /*
    	  String key = ClientUtils.decrypt_sda(URLDecoder.decode("qgq5p%2BFmqcjyEilmWNDMNizVjaQl9A6oo6z07Rgzj3ZOcxfOCegMSERvxQL5DhboWg","UTF-8"),"ABCINTRALOTDEPERUKEY");
          System.out.println("k="+key);
            
          System.out.println("e="+URLDecoder.decode("qgq5p%2BFmqcjyEilmWNDMNizVjaQl9A6oo6z07Rgzj3ZOcxfOCegMSERvxQL5DhboWg","UTF-8"));
        */
        /* ENCRIPTA */
        /*
         * Date today = new Date(); if(today != null) { Calendar cal = Calendar.getInstance(); cal.setTime(today); //cal.set(Calendar.HOUR_OF_DAY, 0); //cal.set(Calendar.MINUTE, 0);
         * //cal.set(Calendar.SECOND, 0); cal.set(Calendar.MILLISECOND, 0); //today.setTime(cal.getTime().getTime()); today = cal.getTime(); }
         */
        // String plainstr = "INTRALOT"+today.getTime();
        // System.out.println("ENCRIPTANDO "+plainstr+"...\n"+dwbuffer);
        /* DESENCRIPTA */
         /* String dwbuffer = "UZskuupSN7Z7EK79ivoIveRcQt6nn8DG2AW9guZXJBoLWEOeP1Ts8qGCFdH5pBqWEZ6TN0Hvz0Bf1FGt47k2UJR8DkCoZ3z7OXVz5r0xwDAIF7C1se";// encrypt_sda(plainstr);
        dwbuffer = decrypt_sda(dwbuffer);
        System.out.println("DESENCRIPTADO...\n" + dwbuffer); */ // +"\nï¿½Es el mismo dï¿½a? "+today.getTime()+" "+dwbuffer.substring(8)+" "+((today.getTime())-(Long.valueOf(dwbuffer.substring(8)).longValue())));
        // today = new Date();
        /*
         * if(today != null) { Calendar cal = Calendar.getInstance(); cal.setTime(today); //cal.set(Calendar.HOUR_OF_DAY, 0); //cal.set(Calendar.MINUTE, 0); //cal.set(Calendar.SECOND, 0);
         * cal.set(Calendar.MILLISECOND, 0); //today.setTime(cal.getTime().getTime()); today = cal.getTime(); }
         */
    //}

    public static String getValues(Object values[]) 
    {
    	StringBuilder b = new StringBuilder();
		for(int i=0; i<values.length; i++) {
			  b.append(" ["+i+"]="+values[i]);
		}
		return b.toString();
    } 
    
    public static String getValues(Object values[], int j) 
    {
    	StringBuilder b = new StringBuilder();
		for(int i=0; i<values.length; i++) {
			  b.append(" ["+i+"]="+values[i]);
			  if (i>=j) break;
		}
		return b.toString();
    }

    public static String verifyPassword(String pUser, String pPassword) throws Exception {
    	
        //(pUser, pPassword, rePassword, pNombre, pApPaterno, pApMaterno, pNumberId, pFixedPhone, pMobilePhone, pBirthDate;
        
        //------------ VERIFICACION DE PASSWORD
        // Password length must be at least 8 characters long. 
        if (pPassword.length()<5) {
        	return "La contraseña debe tener al menos 5 caracteres.";
        }
        // Password must consist at least 1 number and 1 letter. 
        /* boolean atleastOneAlpha = pPassword.matches(".*[a-zA-Z]+.*");
        boolean atleastOneNumber = pPassword.matches(".*[0-9]+.*");
        if (atleastOneAlpha==false || atleastOneNumber==false) {
        	return "La contrase&ntilde;a debe tener al menos 1 letra y 1 n&uacute;mero.";
        } */
        // The password may not be equal to the user name. 
        if (pPassword.equalsIgnoreCase(pUser)) {
        	return "La contraseña no debe ser igual a sus datos.";
        }
        // Dictionary checking of limited words must be enabled (extensive dictionary checks may create problems: players may not be able to register leading to drop of sales).
        String[] list = {"12345","11111","22222","passw0rd","password","123456","000000","111111","222222","tequiero","qwerty","abc123","estrella","iloveyou","654321","bonita","mariposa","america","starwars","azerty","sexo","dinero","amor","123456","password","12345678","1234","pussy","12345","dragon","qwerty","696969","mustang","letmein","baseball","master","michael","football","shadow","monkey","abc123","pass","fuckme","6969","jordan","harley","ranger","iwantu","jennifer","hunter","fuck","2000","test","batman","trustno1","thomas","tigger","robert","access","love","buster","1234567","soccer","hockey","killer","george","sexy","andrew","charlie","superman","asshole","fuckyou","dallas","panties","pepper","1111","austin","golfer","summer","heather","hammer","yankees","joshua","maggie","biteme","enter","ashley","thunder","cowboy","silver","richard","fucker","orange","merlin","michelle","corvette","bigdog","cheese","matthew","121212","patrick","freedom","ginger","blowjob","sparky","yellow","camaro","secret","dick","falcon","taylor","111111","131313","123123","bitch","hello","scooter","please","porsche","guitar","chelsea","black","diamond","nascar","jackson","cameron","654321","computer","wizard","xxxxxxxx","money","phoenix","mickey","bailey","knight","iceman","tigers","purple","horny","dakota","aaaaaa","player","sunshine","morgan","starwars","boomer","cowboys","edward","charles","girls","booboo","coffee","xxxxxx","bulldog","ncc1701","rabbit","peanut","john","johnny","gandalf","spanky","winter","brandy","compaq","carlos","tennis","james","mike","brandon","fender","anthony","blowme","ferrari","cookie","chicken","maverick","chicago","joseph","diablo","sexsex","hardcore","666666","willie","welcome","chris","panther","yamaha","justin","banana","driver","marine","angels","fishing","david","maddog","hooters","wilson","butthead","dennis","fucking","captain","bigdick","chester","smokey","xavier","steven","viking","snoopy","blue","eagles","winner","house","miller","flower","jack","firebird","butter","united","turtle","steelers","tiffany","zxcvbn","tomcat","golf","bond007","bear","tiger","doctor","gateway","gators","angel","junior","thx1138","porno","badboy","debbie","spider","booger","1212","flyers","fish","porn","matrix","teens","scooby","jason","walter","cumshot","boston","braves","yankee","lover","barney","victor","tucker","princess","5150","doggie","zzzzzz","gunner","horney","bubba","2112","fred","johnson","xxxxx","tits","member","boobs","donald","bigdaddy","bronco","penis","voyager","rangers","birdie","trouble","white","topgun","bigtits","bitches","green","super","qazwsx","magic","lakers","rachel","slayer","scott","2222","asdf","video","london","7777","marlboro","srinivas","internet","action","carter","jasper","monster","jeremy","11111111","bill","peter","pussies","cock","beer","rocket","theman","oliver","rosebud","jaguar","great","cool","cooper","1313","scorpio","mountain","987654","brazil","lauren","japan","naked","squirt","stars","apple","alexis","aaaa","bonnie","peaches","jasmine","kevin","matt","qwertyui","beaver","4321","4128","runner","swimming","dolphin","gordon","casper","stupid","shit","saturn","gemini","apples","august","3333","canada","blazer","cumming","hunting","kitty","rainbow","112233","arthur","cream","calvin","shaved","surfer","samson","kelly","paul","mine","king","racing","5555","eagle","hentai","newyork","little","redwings","smith","sticky","cocacola","animal","broncos","private","skippy","marvin","blondes","enjoy","girl","apollo","parker","qwert","time","sydney","women","voodoo","magnum","juice","abgrtyu","777777","dreams","maxwell","music","rush2112","russia","scorpion","tester","mistress","phantom","billy","6666","albert","prince","beach","amateur","7777777","muffin","redsox","star","testing","shannon","murphy","frank","hannah","dave","eagle1","11111","mother","nathan","raiders","steve","forever","angela","viper","ou812","jake","lovers","suckit","gregory","buddy","whatever","young","nicholas","lucky","helpme","jackie","midnight","college","baby","cunt","brian","mark","startrek","sierra","leather","232323","4444","beavis","bigcock","happy","sophie","ladies","naughty","giants","booty","blonde","fucked","golden","fire","pookie","packers","einstein","dolphins","chevy","winston","warrior","sammy","slut","8675309","zxcvbnm","nipples","power","asdfgh","vagina","toyota","travis","hotdog","paris","rock","xxxx","extreme","redskins","erotic","dirty","ford","freddy","arsenal","access14","wolf","nipple","iloveyou","alex","florida","eric","legend","movie","success"};
        for (String s:list) {
            if (pPassword.toLowerCase().contains(s.toLowerCase())) {
            	return "La contraseña no debe contener una palabra o numeros muy utilizados ["+s.toLowerCase()+"].";
            }
            /* Dbms rs = new Dbms();
            String sql = "select 1 from lotocard.client where lower(cl_nombre) like ? or lower(cl_apellido_paterno) like ?  or lower(cl_apellido_materno) like ? and rownum<=1";
            rs.setSql(sql);
            rs.setString(1,"%"+pPassword.toLowerCase()+"%");
            rs.setString(2,"%"+pPassword.toLowerCase()+"%");
            rs.setString(3,"%"+pPassword.toLowerCase()+"%");
            rs.executeQuery();
            if (rs.next()) {
            	return "La contrase&ntilde;a no debe tener la palabra "+pPassword;
            }
            rs.close();  */
        }
        // System generated passwords will always have to be changed the first time a customer tries to log on with this password. 
        // The new password may not be equal to the generated one. 
        //------------ FIN DE VERIFICACION DE PASSWORD 
        return "OK";
    }


    public static String verifyEmail(String email) throws Exception {
    	/*
        String mails = "@mailcatch.com,@trbvn.com,@20email,@clrmail.com,@emailsensei.com,@filzmail.com,@sharklasers.com,@grr.la,@guerrillamail,@spam4.me,@incognitomail.org,@uu1.pl,@mailinator.com,@mailnesia.com,@mintemail.com,@mt2015.com,@noclickemail.com,@spamfree24.org,@tempemail.net,@trashmail.ws,@yopmail.com";
        
        //------------ VERIFICACION DE MAIL
        String[] list = mails.split(",");
        for (String s:list) {
            if (email.toLowerCase().contains(s.toLowerCase())) {
         	String message = "El correo ingresado es incorrecto [4]";
      		Logger.getLogger(LoggerApi.LOGGERLAPOLLAAPI).info("email="+email+" "+message);
            	return message; 
            }
        }
        //------------ FIN DE VERIFICACION DE MAIL
        */
    	Dbms rs = null;
        int domain = 0;
        try {
            rs = new Dbms();
    	    String sql = "select count(edt_domain) from lotocard.email_domains_temporary  where  trim(lower(edt_domain)) = trim(lower(substr(?,INSTR(?,'@')))) ";
    	    rs.setSql(sql);
            rs.setString(1,email);
            rs.setString(2,email);
            rs.executeQuery();
            if (rs.next()) {
            	domain = rs.getInt(1);
            }
		} finally {
			try {
				if(rs!=null) {
					System.out.println("<--------------------ClientUtils.verifyEmail cerrando conexion------------------->");
					 rs.close();
				}
			} catch (Exception e) {
				System.out.println("<--------------------ClientUtils.verifyEmail error cerrando conexion------------------->");
				e.printStackTrace();
			}
			
		}
        if (domain > 0) {
        	String message = "El correo ingresado es incorrecto [4]";
      		Logger.getLogger(LoggerApi.LOGGERLAPOLLAAPI).info("email="+email+" "+message);
            	return message;
        }
         
        return "OK";
    }
    
    public static String encrypt(String input){
		  byte[] crypted = null;
		  try{
		    SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
		      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		      cipher.init(Cipher.ENCRYPT_MODE, skey);
		      crypted = cipher.doFinal(input.getBytes());
		    }catch(Exception e){
		    	System.out.println(e.toString());
		    }
		    return new String(Base64.encodeBase64(crypted));
		}

		public static String decrypt(String input){
		    byte[] output = null;
		    try{
		      SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
		      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		      cipher.init(Cipher.DECRYPT_MODE, skey);
		      output = cipher.doFinal(Base64.decodeBase64(input));
		    }catch(Exception e){
		      System.out.println(e.toString());
		    }
		    return new String(output);
		}
		/*
		public static void main(String[] args) {
			  String param_encriptado = "<script> alert('hola'); </script>";
			  //String param_ini = "13291|&t=0&s=41|tinka|1527546765798|13291";
			  //System.out.println(StringLib.encrypt(param_ini));
			  
			  System.out.println(StringLib.stripXSSESAPI(param_encriptado));	    
			}
		*/

		   private static Pattern[] patterns = new Pattern[]{
			        // Script fragments
			        Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE),
			        // src='...'
			        Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
			        Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
			        // lonely script tags
			        Pattern.compile("</script>", Pattern.CASE_INSENSITIVE),
			        Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
			        // eval(...)
			        Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
			        // expression(...)
			        Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
			        // javascript:...
			        Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE),
			        // vbscript:...
			        Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE),
			        // onload(...)=...
			        Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL)
			    };
  
			    public static String stripXSS(String value) {
			        if (value != null) {
			            // NOTE: It's highly recommended to use the ESAPI library and uncomment the following line to
			            // avoid encoded attacks.
			            // value = ESAPI.encoder().canonicalize(value);

			            // Avoid null characters
			            value = value.replaceAll("\0", "");

			            // Remove all sections that match a pattern
			            for (Pattern scriptPattern : patterns){
			                value = scriptPattern.matcher(value).replaceAll("");
			            }
			        }
			        return value;
			    }
			    
			    public static String stripXSSESAPI(String value) {
			        if (value != null) {
			            // NOTE: It's highly recommended to use the ESAPI library and uncomment the following line to
			            // avoid encoded attacks.
			            value = Encode.forJavaScript(value);//  ESAPI.encoder().canonicalize(value);
			            
			           /* // Avoid null characters
			            value = value.replaceAll("\0", "");

			            // Remove all sections that match a pattern
			            for (Pattern scriptPattern : patterns){
			                value = scriptPattern.matcher(value).replaceAll("");
			            }*/
			            System.out.println(Encode.forJavaScriptAttribute(value));
			            System.out.println(Encode.forJavaScript(value));
			            System.out.println(Encode.forJavaScriptBlock(value));
			        }
			        return value;
			    }
			    
    public static String toMD5(String string)
	throws Exception
	{
		Labeler labeler = new Labeler();		
		return labeler.getMD5(string);
	}			    
}
