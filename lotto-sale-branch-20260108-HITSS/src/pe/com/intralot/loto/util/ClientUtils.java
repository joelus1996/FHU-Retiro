package pe.com.intralot.loto.util;

import java.io.StringReader;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.routines.RegexValidator;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureAccountData;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureLPTokenGeneration;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureLogin;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureTANTokenGeneration;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureTokenGeneration;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.lib.Dbms;
import pe.com.intralot.loto.lib.StringLib;
import pe.com.intralot.loto.sale.lib.LoggerApi;

/**
 * <p>
 * NOMBRE: ClientUtils.java
 * <br></p>
 * <p>
 * FUNCION: Utilitarios para el manejo de datos de la cuenta 
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 002   Cristian Cortez  25/06/2018  Asignación de la variable para el bono TA por recargas Interbank
 * 001   Cristian Cortez  06/10/2010  First comment
 * </pre>
 * <br></p>
 */

public class ClientUtils {

    private static CipherUtils cipher = new CipherUtils();
    
    public static String toMillions(Double number) {
        String jackpot = "";
        if (number != null) {
            Locale.setDefault(Locale.US);
            DecimalFormat df = new DecimalFormat("###,###,###,###.##");
            String[] f = (df.format(number)).split(",");
            for (int i = f.length - 1; i >= 0; i--) {
                if (f.length % 2 == 0) {
                    if (i % 2 == 0) {
                        if (i != 0)
                            jackpot = "\'" + f[i] + jackpot;
                        else
                            jackpot = f[i] + jackpot;
                    } else {
                        if (i != 0)
                            jackpot = "," + f[i] + jackpot;
                        else
                            jackpot = f[i] + jackpot;
                    }
                } else {
                    if (i % 2 == 0) {
                        if (i != 0)
                            jackpot = "," + f[i] + jackpot;
                        else
                            jackpot = f[i] + jackpot;
                    } else {
                        if (i != 0)
                            jackpot = "\'" + f[i] + jackpot;
                        else
                            jackpot = f[i] + jackpot;
                    }
                }
            }
        }
        return jackpot;
    }

    public static String monthText(String m) {
        int month = Integer.parseInt(m);
        switch (month) {
            case 1:
                return "enero";
            case 2:
                return "febrero";
            case 3:
                return "marzo";
            case 4:
                return "abril";
            case 5:
                return "mayo";
            case 6:
                return "junio";
            case 7:
                return "julio";
            case 8:
                return "agosto";
            case 9:
                return "septiembre";
            case 10:
                return "octubre";
            case 11:
                return "noviembre";
            case 12:
                return "diciembre";
            default:
                return "";
        }
    }

    /*
     * public static int gameNametoId(String game) { //if(game.equals("ElDuendeMillonario")) return 538; //else if(game.equals("ElMapadelTesoro")) return 540; //else if(game.equals("Deportinka"))
     * return 541; //else if(game.equals("7-13-21")) return 542; if(game.equals("ElRatondelaSuerte")) return 703; else if(game.equals("ElCibergenio")) return 704; else
     * if(game.equals("ClickeatuSuerte")) return 705; else if(game.equals("SuerteenLinea")) return 706; else return 0; }
     */
    public static String randomString(int len) {
        // 012345678901234567890123456789012345678901234567890123456789012
        String str = new String("QAa0bcLdUK2eHfJgTP8XhiFj61DOklNm9nBoI5pGqYVrs3CtSuMZvwWx4yE7zR");
        StringBuffer sb = new StringBuffer();
        Random r = new Random();
        int te = 0;
        for (int i = 1; i <= len; i++) {
            te = r.nextInt(62);
            sb.append(str.charAt(te));
        }
        return (sb.toString());
    }

    public static String capitalize(String s) {
        if (s.length() == 0)
            return s;
        String text = "";
        String[] arrtext = null;
        arrtext = s.split(" ");
        for (int i = 0; i < arrtext.length - 1; i++)
            text += arrtext[i].substring(0, 1).toUpperCase() + arrtext[i].substring(1).toLowerCase() + " ";
        return text + arrtext[arrtext.length - 1].substring(0, 1).toUpperCase() + arrtext[arrtext.length - 1].substring(1).toLowerCase();
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
        String UNICODE_MAN_ORDINAL_INDICATOR = "\u00BA";
        String UNICODE_FEM_ORDINAL_INDICATOR = "\u00AA";
        String UNICODE_ACUTE_ACCENT = "\u00B4";
        return text.replaceAll(UNICODE_SMALL_A_GRAVE, "&agrave;").replaceAll(UNICODE_SMALL_A_ACUTE, "&aacute;").replaceAll(UNICODE_SMALL_A_CIRC, "&acirc;")
                .replaceAll(UNICODE_SMALL_A_TILDE, "&atilde;").replaceAll(UNICODE_SMALL_A_UML, "&auml;").replaceAll(UNICODE_SMALL_A_RING, "&aring;").replaceAll(UNICODE_SMALL_C_CEDIL, "&ccedil;")
                .replaceAll(UNICODE_SMALL_E_GRAVE, "&egrave;").replaceAll(UNICODE_SMALL_E_ACUTE, "&eacute;").replaceAll(UNICODE_SMALL_E_CIRC, "&ecirc;").replaceAll(UNICODE_SMALL_E_UML, "&euml;")
                .replaceAll(UNICODE_SMALL_I_GRAVE, "&igrave;").replaceAll(UNICODE_SMALL_I_ACUTE, "&iacute;").replaceAll(UNICODE_SMALL_I_CIRC, "&icirc;").replaceAll(UNICODE_SMALL_I_UML, "&iuml;")
                .replaceAll(UNICODE_SMALL_O_GRAVE, "&ograve;").replaceAll(UNICODE_SMALL_O_ACUTE, "&oacute;").replaceAll(UNICODE_SMALL_O_CIRC, "&ocirc;").replaceAll(UNICODE_SMALL_O_TILDE, "&otilde;")
                .replaceAll(UNICODE_SMALL_O_UML, "&ouml;").replaceAll(UNICODE_SMALL_U_GRAVE, "&ugrave;").replaceAll(UNICODE_SMALL_U_ACUTE, "&uacute;").replaceAll(UNICODE_SMALL_U_CIRC, "&ucirc;")
                .replaceAll(UNICODE_SMALL_U_UML, "&uuml;").replaceAll(UNICODE_SMALL_N_TILDE, "&ntilde;").replaceAll(UNICODE_CAPITAL_A_GRAVE, "&Agrave;")
                .replaceAll(UNICODE_CAPITAL_A_ACUTE, "&Aacute;").replaceAll(UNICODE_CAPITAL_A_CIRC, "&Acirc;").replaceAll(UNICODE_CAPITAL_A_TILDE, "A").replaceAll(UNICODE_CAPITAL_A_UML, "&Atilde;")
                .replaceAll(UNICODE_CAPITAL_A_RING, "&Auml;").replaceAll(UNICODE_CAPITAL_C_CEDIL, "&Ccedil;").replaceAll(UNICODE_CAPITAL_E_GRAVE, "&Egrave;")
                .replaceAll(UNICODE_CAPITAL_E_ACUTE, "&Eacute;").replaceAll(UNICODE_CAPITAL_E_CIRC, "&Ecirc;").replaceAll(UNICODE_CAPITAL_E_UML, "&Euml;")
                .replaceAll(UNICODE_CAPITAL_I_GRAVE, "&Igrave;").replaceAll(UNICODE_CAPITAL_I_ACUTE, "&Iacute;").replaceAll(UNICODE_CAPITAL_I_CIRC, "&Icirc;")
                .replaceAll(UNICODE_CAPITAL_I_UML, "&Iuml;").replaceAll(UNICODE_CAPITAL_O_GRAVE, "&Ograve;").replaceAll(UNICODE_CAPITAL_O_ACUTE, "&Oacute;")
                .replaceAll(UNICODE_CAPITAL_O_CIRC, "&Ocirc;").replaceAll(UNICODE_CAPITAL_O_TILDE, "&Otilde;").replaceAll(UNICODE_CAPITAL_O_UML, "&Ouml;")
                .replaceAll(UNICODE_CAPITAL_U_GRAVE, "&Ugrave;").replaceAll(UNICODE_CAPITAL_U_ACUTE, "&Uacute;").replaceAll(UNICODE_CAPITAL_U_CIRC, "&Ucirc;")
                .replaceAll(UNICODE_CAPITAL_U_UML, "&Uuml;").replaceAll(UNICODE_CAPITAL_N_TILDE, "&Ntilde;").replaceAll(UNICODE_IEXCLAMATION, "&iexcl;").replaceAll(UNICODE_GRADE, "&deg;")
                .replaceAll(UNICODE_IQUESTION, "&iquest;").replaceAll(UNICODE_RETURN, "<br/>").replaceAll(UNICODE_NEWLINE, "<br/>").replaceAll(UNICODE_DOBLEQUOTE, "&quot;")
                .replaceAll(UNICODE_EURO, "&euro;").replaceAll(UNICODE_PLUS, "&plusmn;").replaceAll(UNICODE_PLUS_MINUS, "&plusmn;").replaceAll(UNICODE_MAN_ORDINAL_INDICATOR, "&ordm;")
                .replaceAll(UNICODE_FEM_ORDINAL_INDICATOR, "&ordf;").replaceAll(UNICODE_ACUTE_ACCENT, "&acute;");
    }

    public static String formatText(String text) {
        String UNICODE_QUOTATION_MARK = "\\u0022";
        String UNICODE_NUMBER_SIGN = "\u0023";
        String UNICODE_AMPERSAND = "\u0026";
        String UNICODE_APOSTROPHE = "\u0027";
        String UNICODE_COMMA = "\u002C";
        String UNICODE_HYPHEN_MINUS = "\u002D";
        String UNICODE_SOLIDUS = "\u002F";
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
        String UNICODE_GRADE = "\u00B0";
        return text
                .replaceAll(UNICODE_NUMBER_SIGN, "No")
                .replaceAll(UNICODE_AMPERSAND, "y")
                .replaceAll("[" + UNICODE_QUOTATION_MARK + "|" + UNICODE_APOSTROPHE + "|" + UNICODE_COMMA + "|" + UNICODE_HYPHEN_MINUS + "|" + UNICODE_SOLIDUS + "]", " ")
                .replaceAll(
                        "[" + UNICODE_SMALL_A_GRAVE + "|" + UNICODE_SMALL_A_ACUTE + "|" + UNICODE_SMALL_A_CIRC + "|" + UNICODE_SMALL_A_TILDE + "|" + UNICODE_SMALL_A_UML + "|" + UNICODE_SMALL_A_RING
                                + "]", "a")
                .replaceAll(UNICODE_SMALL_C_CEDIL, "c")
                .replaceAll("[" + UNICODE_SMALL_E_GRAVE + "|" + UNICODE_SMALL_E_ACUTE + "|" + UNICODE_SMALL_E_CIRC + "|" + UNICODE_SMALL_E_UML + "]", "e")
                .replaceAll("[" + UNICODE_SMALL_I_GRAVE + "|" + UNICODE_SMALL_I_ACUTE + "|" + UNICODE_SMALL_I_CIRC + "|" + UNICODE_SMALL_I_UML + "]", "i")
                .replaceAll("[" + UNICODE_SMALL_O_GRAVE + "|" + UNICODE_SMALL_O_ACUTE + "|" + UNICODE_SMALL_O_CIRC + "|" + UNICODE_SMALL_O_TILDE + "|" + UNICODE_SMALL_O_UML + "]", "o")
                .replaceAll("[" + UNICODE_SMALL_U_GRAVE + "|" + UNICODE_SMALL_U_ACUTE + "|" + UNICODE_SMALL_U_CIRC + "|" + UNICODE_SMALL_U_UML + "]", "u")
                .replaceAll(UNICODE_SMALL_N_TILDE, "n")
                .replaceAll(
                        "[" + UNICODE_CAPITAL_A_GRAVE + "|" + UNICODE_CAPITAL_A_ACUTE + "|" + UNICODE_CAPITAL_A_CIRC + "|" + UNICODE_CAPITAL_A_TILDE + "|" + UNICODE_CAPITAL_A_UML + "|"
                                + UNICODE_CAPITAL_A_RING + "]", "A").replaceAll(UNICODE_CAPITAL_C_CEDIL, "C")
                .replaceAll("[" + UNICODE_CAPITAL_E_GRAVE + "|" + UNICODE_CAPITAL_E_ACUTE + "|" + UNICODE_CAPITAL_E_CIRC + "|" + UNICODE_CAPITAL_E_UML + "]", "E")
                .replaceAll("[" + UNICODE_CAPITAL_I_GRAVE + "|" + UNICODE_CAPITAL_I_ACUTE + "|" + UNICODE_CAPITAL_I_CIRC + "|" + UNICODE_CAPITAL_I_UML + "]", "I")
                .replaceAll("[" + UNICODE_CAPITAL_O_GRAVE + "|" + UNICODE_CAPITAL_O_ACUTE + "|" + UNICODE_CAPITAL_O_CIRC + "|" + UNICODE_CAPITAL_O_TILDE + "|" + UNICODE_CAPITAL_O_UML + "]", "O")
                .replaceAll("[" + UNICODE_CAPITAL_U_GRAVE + "|" + UNICODE_CAPITAL_U_ACUTE + "|" + UNICODE_CAPITAL_U_CIRC + "|" + UNICODE_CAPITAL_U_UML + "]", "U")
                .replaceAll(UNICODE_CAPITAL_N_TILDE, "N").replaceAll(UNICODE_GRADE, "o");
    }

    public static String ParseXMLString(String xmlRecords) {
        String rpt = "";
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xmlRecords));
            Document doc = db.parse(is);
            Node root = doc.getDocumentElement();
            rpt = writeDocumentToOutput(root, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rpt.substring(0, rpt.length() - 1);
    }

    public static String writeDocumentToOutput(Node node, String cdn) {
        // get element name
        String nodeName = node.getNodeName();
        // get element value
        String nodeValue = "";
        Node kid;
        if (node != null) {
            if (node.hasChildNodes()) {
                for (kid = node.getFirstChild(); kid != null; kid = kid.getNextSibling()) {
                    if (kid.getNodeType() == Node.TEXT_NODE) {
                        nodeValue = kid.getNodeValue();
                    }
                }
            }
        }
        if (!nodeValue.equals(""))
            cdn += nodeName + "=" + nodeValue + ",";
        else
            cdn += nodeName + ",";
        // get attributes of element
        NamedNodeMap attributes = node.getAttributes();
        // cdn += nodeName + "=" + nodeValue;
        for (int i = 0; i < attributes.getLength(); i++) {
            Node attribute = attributes.item(i);
            cdn += attribute.getNodeName() + "=" + attribute.getNodeValue() + ",";
        }
        // write all child nodes recursively
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                cdn = writeDocumentToOutput(child, cdn);
            }
        }
        return cdn;
    }

    public static String Interleaved2of5(String DataToEncode, Integer BarHeight) {
        String onlyCorrectData = "";
        int currentChar = 0;
        String d = "";
        String j = "";
        DataToEncode = DataToEncode.trim();
        if (BarHeight == null)
            BarHeight = 7;
        String XDimensionPoints = "4.1";// "3.7";
        for (int i = 1; i <= DataToEncode.length(); i++) {
            // Add only numbers to OnlyCorrectData string
            currentChar = DataToEncode.charAt(i - 1);
            if ((currentChar < 58) && (currentChar > 47))
                onlyCorrectData += DataToEncode.charAt(i - 1);
        }
        DataToEncode = onlyCorrectData;
        // Check for an even number of digits, add 0 if not even
        if ((DataToEncode.length() % 2) == 1)
            DataToEncode = "0" + DataToEncode;
        for (int i = 1; i <= DataToEncode.length(); i += 2) {
            // Get the value of each number pair (ex: 5 and 6 = 5*10+6 =56)
            currentChar = (((DataToEncode.charAt(i - 1)) - 48) * 10) + ((DataToEncode.charAt(i)) - 48);
            if (currentChar == 0)
                j += "&#9616;&#9616;&#9616;&#9612;&#9616;&#9612;&#9616;";
            if (currentChar == 1)
                j += "&#9616;&nbsp;&#9612;&#9608;&#9616;&#9612;&#9612;";
            if (currentChar == 2)
                j += "&#9616;&#9616;&nbsp;&#9608;&#9616;&#9612;&#9612;";
            if (currentChar == 3)
                j += "&#9616;&nbsp;&#9612;&#9616;&#9612;&#9608;&#9616;";
            if (currentChar == 4)
                j += "&#9616;&#9616;&#9616;&#9612;&#9616;&#9612;&#9612;";
            if (currentChar == 5)
                j += "&#9616;&nbsp;&#9612;&#9608;&nbsp;&#9608;&#9616;";
            if (currentChar == 6)
                j += "&#9616;&#9616;&nbsp;&#9608;&nbsp;&#9608;&#9616;";
            if (currentChar == 7)
                j += "&#9616;&#9616;&#9616;&#9612;&#9608;&nbsp;&#9612;";
            if (currentChar == 8)
                j += "&#9616;&nbsp;&#9612;&#9608;&#9616;&#9612;&#9616;";
            if (currentChar == 9)
                j += "&#9616;&#9616;&nbsp;&#9608;&#9616;&#9612;&#9616;";
            if (currentChar == 10)
                j += "&#9616;&#9612;&#9612;&#9612;&#9616;&nbsp;&#9608;";
            if (currentChar == 11)
                j += "&#9616;&#9612;&#9616;&#9616;&#9616;&#9616;&#9612;";
            if (currentChar == 12)
                j += "&#9616;&#9612;&#9612;&#9616;&#9616;&#9616;&#9612;";
            if (currentChar == 13)
                j += "&#9616;&#9612;&#9616;&nbsp;&#9612;&#9612;&#9608;";
            if (currentChar == 14)
                j += "&#9616;&#9612;&#9612;&#9612;&#9616;&#9616;&#9612;";
            if (currentChar == 15)
                j += "&#9616;&#9612;&#9616;&#9616;&nbsp;&#9612;&#9608;";
            if (currentChar == 16)
                j += "&#9616;&#9612;&#9612;&#9616;&nbsp;&#9612;&#9608;";
            if (currentChar == 17)
                j += "&#9616;&#9612;&#9612;&#9612;&#9612;&#9616;&#9612;";
            if (currentChar == 18)
                j += "&#9616;&#9612;&#9616;&#9616;&#9616;&nbsp;&#9608;";
            if (currentChar == 19)
                j += "&#9616;&#9612;&#9612;&#9616;&#9616;&nbsp;&#9608;";
            if (currentChar == 20)
                j += "&#9616;&#9616;&#9612;&#9612;&#9616;&nbsp;&#9608;";
            if (currentChar == 21)
                j += "&#9616;&nbsp;&#9608;&#9616;&#9616;&#9616;&#9612;";
            if (currentChar == 22)
                j += "&#9616;&#9616;&#9612;&#9616;&#9616;&#9616;&#9612;";
            if (currentChar == 23)
                j += "&#9616;&nbsp;&#9608;&nbsp;&#9612;&#9612;&#9608;";
            if (currentChar == 24)
                j += "&#9616;&#9616;&#9612;&#9612;&#9616;&#9616;&#9612;";
            if (currentChar == 25)
                j += "&#9616;&nbsp;&#9608;&#9616;&nbsp;&#9612;&#9608;";
            if (currentChar == 26)
                j += "&#9616;&#9616;&#9612;&#9616;&nbsp;&#9612;&#9608;";
            if (currentChar == 27)
                j += "&#9616;&#9616;&#9612;&#9612;&#9612;&#9616;&#9612;";
            if (currentChar == 28)
                j += "&#9616;&nbsp;&#9608;&#9616;&#9616;&nbsp;&#9608;";
            if (currentChar == 29)
                j += "&#9616;&#9616;&#9612;&#9616;&#9616;&nbsp;&#9608;";
            if (currentChar == 30)
                j += "&#9616;&#9612;&#9608;&#9616;&nbsp;&#9612;&#9616;";
            if (currentChar == 31)
                j += "&#9616;&#9612;&#9616;&#9612;&#9612;&#9612;&#9612;";
            if (currentChar == 32)
                j += "&#9616;&#9612;&#9608;&nbsp;&#9612;&#9612;&#9612;";
            if (currentChar == 33)
                j += "&#9616;&#9612;&#9616;&#9612;&#9616;&#9616;&#9616;";
            if (currentChar == 34)
                j += "&#9616;&#9612;&#9608;&#9616;&nbsp;&#9612;&#9612;";
            if (currentChar == 35)
                j += "&#9616;&#9612;&#9616;&#9612;&#9612;&#9616;&#9616;";
            if (currentChar == 36)
                j += "&#9616;&#9612;&#9608;&nbsp;&#9612;&#9616;&#9616;";
            if (currentChar == 37)
                j += "&#9616;&#9612;&#9608;&#9616;&#9616;&nbsp;&#9612;";
            if (currentChar == 38)
                j += "&#9616;&#9612;&#9616;&#9612;&#9612;&#9612;&#9616;";
            if (currentChar == 39)
                j += "&#9616;&#9612;&#9608;&nbsp;&#9612;&#9612;&#9616;";
            if (currentChar == 40)
                j += "&#9616;&#9616;&#9616;&#9612;&#9616;&nbsp;&#9608;";
            if (currentChar == 41)
                j += "&#9616;&nbsp;&#9612;&#9608;&#9616;&#9616;&#9612;";
            if (currentChar == 42)
                j += "&#9616;&#9616;&nbsp;&#9608;&#9616;&#9616;&#9612;";
            if (currentChar == 43)
                j += "&#9616;&nbsp;&#9612;&#9616;&#9612;&#9612;&#9608;";
            if (currentChar == 44)
                j += "&#9616;&#9616;&#9616;&#9612;&#9616;&#9616;&#9612;";
            if (currentChar == 45)
                j += "&#9616;&nbsp;&#9612;&#9608;&nbsp;&#9612;&#9608;";
            if (currentChar == 46)
                j += "&#9616;&#9616;&nbsp;&#9608;&nbsp;&#9612;&#9608;";
            if (currentChar == 47)
                j += "&#9616;&#9616;&#9616;&#9612;&#9612;&#9616;&#9612;";
            if (currentChar == 48)
                j += "&#9616;&nbsp;&#9612;&#9608;&#9616;&nbsp;&#9608;";
            if (currentChar == 49)
                j += "&#9616;&#9616;&nbsp;&#9608;&#9616;&nbsp;&#9608;";
            if (currentChar == 50)
                j += "&#9616;&#9612;&#9612;&#9608;&nbsp;&#9612;&#9616;";
            if (currentChar == 51)
                j += "&#9616;&#9612;&#9616;&#9616;&#9612;&#9612;&#9612;";
            if (currentChar == 52)
                j += "&#9616;&#9612;&#9612;&#9616;&#9612;&#9612;&#9612;";
            if (currentChar == 53)
                j += "&#9616;&#9612;&#9616;&nbsp;&#9608;&#9616;&#9616;";
            if (currentChar == 54)
                j += "&#9616;&#9612;&#9612;&#9608;&nbsp;&#9612;&#9612;";
            if (currentChar == 55)
                j += "&#9616;&#9612;&#9616;&#9616;&#9612;&#9616;&#9616;";
            if (currentChar == 56)
                j += "&#9616;&#9612;&#9612;&#9616;&#9612;&#9616;&#9616;";
            if (currentChar == 57)
                j += "&#9616;&#9612;&#9612;&#9608;&#9616;&nbsp;&#9612;";
            if (currentChar == 58)
                j += "&#9616;&#9612;&#9616;&#9616;&#9612;&#9612;&#9616;";
            if (currentChar == 59)
                j += "&#9616;&#9612;&#9612;&#9616;&#9612;&#9612;&#9616;";
            if (currentChar == 60)
                j += "&#9616;&#9616;&#9612;&#9608;&nbsp;&#9612;&#9616;";
            if (currentChar == 61)
                j += "&#9616;&nbsp;&#9608;&#9616;&#9612;&#9612;&#9612;";
            if (currentChar == 62)
                j += "&#9616;&#9616;&#9612;&#9616;&#9612;&#9612;&#9612;";
            if (currentChar == 63)
                j += "&#9616;&nbsp;&#9608;&nbsp;&#9608;&#9616;&#9616;";
            if (currentChar == 64)
                j += "&#9616;&#9616;&#9612;&#9608;&nbsp;&#9612;&#9612;";
            if (currentChar == 65)
                j += "&#9616;&nbsp;&#9608;&#9616;&#9612;&#9616;&#9616;";
            if (currentChar == 66)
                j += "&#9616;&#9616;&#9612;&#9616;&#9612;&#9616;&#9616;";
            if (currentChar == 67)
                j += "&#9616;&#9616;&#9612;&#9608;&#9616;&nbsp;&#9612;";
            if (currentChar == 68)
                j += "&#9616;&nbsp;&#9608;&#9616;&#9612;&#9612;&#9616;";
            if (currentChar == 69)
                j += "&#9616;&#9616;&#9612;&#9616;&#9612;&#9612;&#9616;";
            if (currentChar == 70)
                j += "&#9616;&#9616;&#9616;&nbsp;&#9608;&nbsp;&#9608;";
            if (currentChar == 71)
                j += "&#9616;&nbsp;&#9612;&#9612;&#9608;&#9616;&#9612;";
            if (currentChar == 72)
                j += "&#9616;&#9616;&nbsp;&#9612;&#9608;&#9616;&#9612;";
            if (currentChar == 73)
                j += "&#9616;&nbsp;&#9612;&#9616;&#9616;&#9612;&#9608;";
            if (currentChar == 74)
                j += "&#9616;&#9616;&#9616;&nbsp;&#9608;&#9616;&#9612;";
            if (currentChar == 75)
                j += "&#9616;&nbsp;&#9612;&#9612;&#9616;&#9612;&#9608;";
            if (currentChar == 76)
                j += "&#9616;&#9616;&nbsp;&#9612;&#9616;&#9612;&#9608;";
            if (currentChar == 77)
                j += "&#9616;&#9616;&#9616;&#9616;&#9612;&#9616;&#9612;";
            if (currentChar == 78)
                j += "&#9616;&nbsp;&#9612;&#9612;&#9608;&nbsp;&#9608;";
            if (currentChar == 79)
                j += "&#9616;&#9616;&nbsp;&#9612;&#9608;&nbsp;&#9608;";
            if (currentChar == 80)
                j += "&#9616;&#9612;&#9612;&#9612;&#9616;&#9612;&#9616;";
            if (currentChar == 81)
                j += "&#9616;&#9612;&#9616;&#9616;&#9616;&#9612;&#9612;";
            if (currentChar == 82)
                j += "&#9616;&#9612;&#9612;&#9616;&#9616;&#9612;&#9612;";
            if (currentChar == 83)
                j += "&#9616;&#9612;&#9616;&nbsp;&#9612;&#9608;&#9616;";
            if (currentChar == 84)
                j += "&#9616;&#9612;&#9612;&#9612;&#9616;&#9612;&#9612;";
            if (currentChar == 85)
                j += "&#9616;&#9612;&#9616;&#9616;&nbsp;&#9608;&#9616;";
            if (currentChar == 86)
                j += "&#9616;&#9612;&#9612;&#9616;&nbsp;&#9608;&#9616;";
            if (currentChar == 87)
                j += "&#9616;&#9612;&#9612;&#9612;&#9608;&nbsp;&#9612;";
            if (currentChar == 88)
                j += "&#9616;&#9612;&#9616;&#9616;&#9616;&#9612;&#9616;";
            if (currentChar == 89)
                j += "&#9616;&#9612;&#9612;&#9616;&#9616;&#9612;&#9616;";
            if (currentChar == 90)
                j += "&#9616;&#9616;&#9612;&#9612;&#9616;&#9612;&#9616;";
            if (currentChar == 91)
                j += "&#9616;&nbsp;&#9608;&#9616;&#9616;&#9612;&#9612;";
            if (currentChar == 92)
                j += "&#9616;&#9616;&#9612;&#9616;&#9616;&#9612;&#9612;";
            if (currentChar == 93)
                j += "&#9616;&nbsp;&#9608;&nbsp;&#9612;&#9608;&#9616;";
            if (currentChar == 94)
                j += "&#9616;&#9616;&#9612;&#9612;&#9616;&#9612;&#9612;";
            if (currentChar == 95)
                j += "&#9616;&nbsp;&#9608;&#9616;&nbsp;&#9608;&#9616;";
            if (currentChar == 96)
                j += "&#9616;&#9616;&#9612;&#9616;&nbsp;&#9608;&#9616;";
            if (currentChar == 97)
                j += "&#9616;&#9616;&#9612;&#9612;&#9608;&nbsp;&#9612;";
            if (currentChar == 98)
                j += "&#9616;&nbsp;&#9608;&#9616;&#9616;&#9612;&#9616;";
            if (currentChar == 99)
                j += "&#9616;&#9616;&#9612;&#9616;&#9616;&#9612;&#9616;";
        }
        j = "&#9616;&#9616;" + j + "&#9616;&#9612;&#9612;";
        for (int f = 0; f < BarHeight; f++) {
            // if(f == (BarHeight-1)) d += j;
            // else d += j+"<br/>";
            d += "<div style='margin:-1px; padding:0;'>" + j + "</div>";
        }
        // return
        // "<div style='font-size:"+XDimensionPoints+"px; line-height:"+XDimensionPoints+"px; font-family:\'Courier New\', \'Lucida Console\', \'monospace\'; letter-spacing:-1px;'><pre>"+d+"</pre></div>";
        // return "<div style='font-size:"+XDimensionPoints+"pt; line-height:"+XDimensionPoints+"pt; font-family:\'Courier New\', \'Lucida Console\', \'monospace\';'><pre>"+d+"</pre></div>";
        // return "<div style='font-size:"+XDimensionPoints+"px; line-height:"+XDimensionPoints+"px; font-family:Geneva, Arial, Helvetica, sans-serif; letter-spacing:-0.3px;'><pre>"+d+"</pre></div>";
        return "<div style='font-size:" + XDimensionPoints + "pt; line-height:" + XDimensionPoints + "pt; font-family:Geneva, Arial, Helvetica, sans-serif; letter-spacing:-0.2px;'><pre>" + d
                + "</pre></div>";
        // return "<div style='font-size:"+XDimensionPoints+"pt; line-height:"+XDimensionPoints+"pt; font-family:Arial,Helvetica,sans-serif; letter-spacing:-0.3px;'><pre>"+d+"</pre></div>";
    }

    /*
     * public static void mailMaximunSales(String srvURL, double priceSale, double maxPriceSale, String posClientId, String dependentId, String mailSender) { String head =
     * "<html><head></head><body bgcolor='#FFFFFF' marginheight='0' marginwidth='0' topmargin='0' leftmargin='0' rightmargin='0' " +
     * "bottommargin='0'><table width='768' border='0' align='center' cellpadding='0' cellspacing='0'><tr><td style='background:url("+
     * srvURL+"/img/account/header-intralot.jpg) center no-repeat; border: 0; margin: 0; padding: 0; width: 768px; height: 108px;'>" +
     * "</td></tr><tr><td><table width='768' border='0' cellspacing='0' cellpadding='0'><tr><td colspan='3' style='background:url("+
     * srvURL+"/img/account/header-contactenos.gif) center no-repeat; border: 0; margin: 0; padding: 0; width: 768px; height: 110px;'>" +
     * "</td></tr><tr><td style='background:url("+srvURL+"/img/account/box-left.gif) repeat-y; border: 0; margin: 0; padding: 0; " + "width: 109px;'></td>"; String footer =
     * "<tr><td colspan='2' style='height:20px;'>&nbsp;</td></tr></table></td><td style='background:url("+srvURL+
     * "/img/account/box-right.gif) repeat-y; border: 0; margin: 0; padding: 0; width: 110px;'></td></tr><tr><td colspan='3' " +
     * "style='background:url("+srvURL+"/img/account/footer-box.gif) center no-repeat; border: 0; margin: 0; padding: 0; " +
     * "width: 768px; height: 45px;'></td></tr></table></td></tr></table></body></html>"; String mailBody =
     * head+"<td bgcolor='#F7F7F7' valign='top' align='center'><table width='549' border='0' cellpadding='0' cellspacing='0' " +
     * "bgcolor='#F7F7F7' style='background: #F7F7F7; font-family: Arial, Helvetica, sans-serif; font-size: 11px; color:#434d3e;'>"+footer; String mailSubject = "[INTRALOT_VIRTUAL] POS: "+
     * posClientId+" Dependiente: "+dependentId+" Monto de venta: "+priceSale; try { MailLib.sendValidMail(mailSender, mailSubject, mailBody); } catch (Exception e) { e.printStackTrace(); } }
     */
    public static String getMailHeader(String srvURL) {
        return "<html><head></head><body bgcolor='#FFFFFF' marginheight='0' marginwidth='0' topmargin='0' leftmargin='0' rightmargin='0' "
                + "bottommargin='0'><table width='768' border='0' align='center' cellpadding='0' cellspacing='0'><tr><td style='background:url(" + srvURL
                + "/img/account/header-intralot.jpg) center no-repeat; border: 0; margin: 0; padding: 0; width: 768px; height: 108px;'>"
                + "</td></tr><tr><td><table width='768' border='0' cellspacing='0' cellpadding='0'><tr><td colspan='3' style='background:url(" + srvURL
                + "/img/account/header-only.gif) center no-repeat; border: 0; margin: 0; padding: 0; width: 768px; height: 75px;'>" +
                /*
                 * "</td></tr><tr><td><table width='768' border='0' cellspacing='0' cellpadding='0'><tr><td colspan='3' style='background:url("+
                 * srvURL+"/img/account/header-contactenos.gif) center no-repeat; border: 0; margin: 0; padding: 0; width: 768px; height: 110px;'>" +
                 */
                "</td></tr><tr><td style='background:url(" + srvURL + "/img/account/box-left.gif) repeat-y; border: 0; margin: 0; padding: 0; " + "width: 109px;'></td>";
    }

    public static String getMailFooter(String srvURL) {
        return "<td style='background:url(" + srvURL + "/img/account/box-right.gif) repeat-y; border: 0; margin: 0; padding: 0; width: 110px;'>"
                + "</td></tr><tr><td colspan='3' style='background:url(" + srvURL + "/img/account/footer-box.gif) center no-repeat; border: 0; "
                + "margin: 0; padding: 0; width: 768px; height: 45px;'></td></tr></table></td></tr></table></body></html>";
    }

    public static String[] sortArray(String[] strArray) {
        String[] arrayEvent = new String[0];
        String[] arrayDate = new String[0];
        String eventAux = "";
        String tmp1 = "";
        String tmp2 = "";
        if (strArray.length == 1)
            return strArray;
        for (int i = 0; i < strArray.length; i++) {
            for (int j = i + 1; j < strArray.length; j++) {
                arrayEvent = strArray[i].split("\\|\\|");// StringUtils.split(strArray[i],"||");
                arrayDate = arrayEvent[4].split("\\/");// StringUtils.split(arrayEvent[4],"/");
                tmp1 = arrayDate[2] + arrayDate[1] + arrayDate[0];
                arrayEvent = strArray[j].split("\\|\\|");// StringUtils.split(strArray[j],"||");
                arrayDate = arrayEvent[4].split("\\/");// StringUtils.split(arrayEvent[4],"/");
                tmp2 = arrayDate[2] + arrayDate[1] + arrayDate[0];
                if (tmp1.compareTo(tmp2) > 0) {
                    eventAux = strArray[i];
                    strArray[i] = strArray[j];
                    strArray[j] = eventAux;
                }
            }
        }
        return strArray;
    }

    private static int[] core_md5(int x[], int len) {
        /* append padding */
        // for(int i=0; i<x.length; i++) System.out.println("1x["+i+"]="+x[i]+" len="+len);
        // System.out.println("0x80="+(0x80 << (len%32))+" len="+len);
        // int cnt = x.length;
        // System.out.println("xlen="+x.length+" len="+len+" len+64="+((((len + 64) >>> 9) << 4) + 14)+" len>>5="+(len >> 5));//+" x[len+64]="+(x[(((len + 64) >>> 9) << 4) + 14])+" x[len>>5]="+(x[len
        // >> 5]));
        // int bin[] = new int[0];
        int aux[] = null;
        aux = x;
        x = new int[16];
        for (int j = 0; j < aux.length; j++)
            x[j] = aux[j];
        // if((len >> 5) >= 0 && (len >> 5) < cnt)
        int cnt = x.length;
        x[len >> 5] |= 0x80 << ((len) % 32);
        // if(((((len + 64) >>> 9) << 4) + 14) >= 0 && ((((len + 64) >>> 9) << 4) + 14) < cnt)
        x[(((len + 64) >>> 9) << 4) + 14] = len;
        int a = 1732584193;
        int b = -271733879;
        int c = -1732584194;
        int d = 271733878;
        // for(int i=0; i<x.length; i++) System.out.println("2x["+i+"]="+x[i]+" len="+len);
        for (int i = 0; i < x.length; i += 16) {
            // if(x[i]!=0) {
            int olda = a;
            int oldb = b;
            int oldc = c;
            int oldd = d;
            if ((i + 0) < cnt)
                a = md5_ff(a, b, c, d, x[i + 0], 7, -680876936);
            if ((i + 1) < cnt)
                d = md5_ff(d, a, b, c, x[i + 1], 12, -389564586);
            if ((i + 2) < cnt)
                c = md5_ff(c, d, a, b, x[i + 2], 17, 606105819);
            if ((i + 3) < cnt)
                b = md5_ff(b, c, d, a, x[i + 3], 22, -1044525330);
            if ((i + 4) < cnt)
                a = md5_ff(a, b, c, d, x[i + 4], 7, -176418897);
            if ((i + 5) < cnt)
                d = md5_ff(d, a, b, c, x[i + 5], 12, 1200080426);
            if ((i + 6) < cnt)
                c = md5_ff(c, d, a, b, x[i + 6], 17, -1473231341);
            if ((i + 7) < cnt)
                b = md5_ff(b, c, d, a, x[i + 7], 22, -45705983);
            if ((i + 8) < cnt)
                a = md5_ff(a, b, c, d, x[i + 8], 7, 1770035416);
            if ((i + 9) < cnt)
                d = md5_ff(d, a, b, c, x[i + 9], 12, -1958414417);
            if ((i + 10) < cnt)
                c = md5_ff(c, d, a, b, x[i + 10], 17, -42063);
            if ((i + 11) < cnt)
                b = md5_ff(b, c, d, a, x[i + 11], 22, -1990404162);
            if ((i + 12) < cnt)
                a = md5_ff(a, b, c, d, x[i + 12], 7, 1804603682);
            if ((i + 13) < cnt)
                d = md5_ff(d, a, b, c, x[i + 13], 12, -40341101);
            if ((i + 14) < cnt)
                c = md5_ff(c, d, a, b, x[i + 14], 17, -1502002290);
            if ((i + 15) < cnt)
                b = md5_ff(b, c, d, a, x[i + 15], 22, 1236535329);
            if ((i + 1) < cnt)
                a = md5_gg(a, b, c, d, x[i + 1], 5, -165796510);
            if ((i + 6) < cnt)
                d = md5_gg(d, a, b, c, x[i + 6], 9, -1069501632);
            if ((i + 11) < cnt)
                c = md5_gg(c, d, a, b, x[i + 11], 14, 643717713);
            if ((i + 0) < cnt)
                b = md5_gg(b, c, d, a, x[i + 0], 20, -373897302);
            if ((i + 5) < cnt)
                a = md5_gg(a, b, c, d, x[i + 5], 5, -701558691);
            if ((i + 10) < cnt)
                d = md5_gg(d, a, b, c, x[i + 10], 9, 38016083);
            if ((i + 15) < cnt)
                c = md5_gg(c, d, a, b, x[i + 15], 14, -660478335);
            if ((i + 4) < cnt)
                b = md5_gg(b, c, d, a, x[i + 4], 20, -405537848);
            if ((i + 9) < cnt)
                a = md5_gg(a, b, c, d, x[i + 9], 5, 568446438);
            if ((i + 14) < cnt)
                d = md5_gg(d, a, b, c, x[i + 14], 9, -1019803690);
            if ((i + 3) < cnt)
                c = md5_gg(c, d, a, b, x[i + 3], 14, -187363961);
            if ((i + 8) < cnt)
                b = md5_gg(b, c, d, a, x[i + 8], 20, 1163531501);
            if ((i + 13) < cnt)
                a = md5_gg(a, b, c, d, x[i + 13], 5, -1444681467);
            if ((i + 2) < cnt)
                d = md5_gg(d, a, b, c, x[i + 2], 9, -51403784);
            if ((i + 7) < cnt)
                c = md5_gg(c, d, a, b, x[i + 7], 14, 1735328473);
            if ((i + 12) < cnt)
                b = md5_gg(b, c, d, a, x[i + 12], 20, -1926607734);
            if ((i + 5) < cnt)
                a = md5_hh(a, b, c, d, x[i + 5], 4, -378558);
            if ((i + 8) < cnt)
                d = md5_hh(d, a, b, c, x[i + 8], 11, -2022574463);
            if ((i + 11) < cnt)
                c = md5_hh(c, d, a, b, x[i + 11], 16, 1839030562);
            if ((i + 14) < cnt)
                b = md5_hh(b, c, d, a, x[i + 14], 23, -35309556);
            if ((i + 1) < cnt)
                a = md5_hh(a, b, c, d, x[i + 1], 4, -1530992060);
            if ((i + 4) < cnt)
                d = md5_hh(d, a, b, c, x[i + 4], 11, 1272893353);
            if ((i + 7) < cnt)
                c = md5_hh(c, d, a, b, x[i + 7], 16, -155497632);
            if ((i + 10) < cnt)
                b = md5_hh(b, c, d, a, x[i + 10], 23, -1094730640);
            if ((i + 13) < cnt)
                a = md5_hh(a, b, c, d, x[i + 13], 4, 681279174);
            if ((i + 0) < cnt)
                d = md5_hh(d, a, b, c, x[i + 0], 11, -358537222);
            if ((i + 3) < cnt)
                c = md5_hh(c, d, a, b, x[i + 3], 16, -722521979);
            if ((i + 6) < cnt)
                b = md5_hh(b, c, d, a, x[i + 6], 23, 76029189);
            if ((i + 9) < cnt)
                a = md5_hh(a, b, c, d, x[i + 9], 4, -640364487);
            if ((i + 12) < cnt)
                d = md5_hh(d, a, b, c, x[i + 12], 11, -421815835);
            if ((i + 15) < cnt)
                c = md5_hh(c, d, a, b, x[i + 15], 16, 530742520);
            if ((i + 2) < cnt)
                b = md5_hh(b, c, d, a, x[i + 2], 23, -995338651);
            if ((i + 0) < cnt)
                a = md5_ii(a, b, c, d, x[i + 0], 6, -198630844);
            if ((i + 7) < cnt)
                d = md5_ii(d, a, b, c, x[i + 7], 10, 1126891415);
            if ((i + 14) < cnt)
                c = md5_ii(c, d, a, b, x[i + 14], 15, -1416354905);
            if ((i + 5) < cnt)
                b = md5_ii(b, c, d, a, x[i + 5], 21, -57434055);
            if ((i + 12) < cnt)
                a = md5_ii(a, b, c, d, x[i + 12], 6, 1700485571);
            if ((i + 3) < cnt)
                d = md5_ii(d, a, b, c, x[i + 3], 10, -1894986606);
            if ((i + 10) < cnt)
                c = md5_ii(c, d, a, b, x[i + 10], 15, -1051523);
            if ((i + 1) < cnt)
                b = md5_ii(b, c, d, a, x[i + 1], 21, -2054922799);
            if ((i + 8) < cnt)
                a = md5_ii(a, b, c, d, x[i + 8], 6, 1873313359);
            if ((i + 15) < cnt)
                d = md5_ii(d, a, b, c, x[i + 15], 10, -30611744);
            if ((i + 6) < cnt)
                c = md5_ii(c, d, a, b, x[i + 6], 15, -1560198380);
            if ((i + 13) < cnt)
                b = md5_ii(b, c, d, a, x[i + 13], 21, 1309151649);
            if ((i + 4) < cnt)
                a = md5_ii(a, b, c, d, x[i + 4], 6, -145523070);
            if ((i + 11) < cnt)
                d = md5_ii(d, a, b, c, x[i + 11], 10, -1120210379);
            if ((i + 2) < cnt)
                c = md5_ii(c, d, a, b, x[i + 2], 15, 718787259);
            if ((i + 9) < cnt)
                b = md5_ii(b, c, d, a, x[i + 9], 21, -343485551);
            // System.out.println("1a="+a+" b="+b+" c="+c+" d="+d);
            a = safe_add(a, olda);
            b = safe_add(b, oldb);
            c = safe_add(c, oldc);
            d = safe_add(d, oldd);
            // System.out.println("2a="+a+" b="+b+" c="+c+" d="+d);
        }
        // x[0] = a;
        // x[1] = b;
        // x[2] = c;
        // x[3] = d;
        // }
        return new int[] { a, b, c, d };
    }

    private static int md5_ff(int a, int b, int c, int d, int x, int s, int t) {
        int rsp = md5_cmn((b & c) | ((~b) & d), a, b, x, s, t);
        // System.out.println("md5_ff="+rsp+" a="+a+" b="+b+" c="+c+" d="+d+" x="+x+" s="+s+" t="+t);
        return rsp;
    }

    private static int md5_gg(int a, int b, int c, int d, int x, int s, int t) {
        int rsp = md5_cmn((b & d) | (c & (~d)), a, b, x, s, t);
        // System.out.println("md5_gg="+rsp+" a="+a+" b="+b+" c="+c+" d="+d+" x="+x+" s="+s+" t="+t);
        return rsp;
    }

    private static int md5_hh(int a, int b, int c, int d, int x, int s, int t) {
        int rsp = md5_cmn(b ^ c ^ d, a, b, x, s, t);
        // System.out.println("md5_hh="+rsp+" a="+a+" b="+b+" c="+c+" d="+d+" x="+x+" s="+s+" t="+t);
        return rsp;
    }

    private static int md5_ii(int a, int b, int c, int d, int x, int s, int t) {
        int rsp = md5_cmn(c ^ (b | (~d)), a, b, x, s, t);
        // System.out.println("md5_ii="+rsp+" a="+a+" b="+b+" c="+c+" d="+d+" x="+x+" s="+s+" t="+t);
        return rsp;
    }

    private static int md5_cmn(int q, int a, int b, int x, int s, int t) {
        int rsp = safe_add(bit_rol(safe_add(safe_add(a, q), safe_add(x, t)), s), b);
        // System.out.println("md5_cmn="+rsp+" q="+q+" a="+a+" b="+b+" x="+x+" s="+s+" t="+t);
        return rsp;
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
        // System.out.println("str="+str+" chrsz="+chrsz);
        int bin[] = new int[0];
        int aux[] = null;
        int mask = (1 << chrsz) - 1;
        for (int i = 0; i < str.length() * chrsz; i += chrsz) {
            // aux = bin;
            // bin = new int[aux.length+1];
            // for(int j=0; j<aux.length; j++) bin[j] = aux[j];
            // System.out.println((int)((str.charAt(i / chrsz) & mask) << (i%32)));
            // if(((byte)((str.charAt(i / chrsz) & mask) << (i%32))) != 0) {
            aux = bin;
            bin = new int[aux.length + 1];
            for (int j = 0; j < aux.length; j++)
                bin[j] = aux[j];
            bin[i >> 5] |= (str.charAt(i / chrsz) & mask) << (i % 32);
            // }
        }
        // aux = new int[0];
        // int temp[] = null;
        for (int i = bin.length - 1; i >= 0; i--) {
            // temp = aux;
            if (bin[i] == 0) {
                aux = bin;
                bin = new int[aux.length - 1];
                for (int j = 0; j < aux.length - 1; j++)
                    bin[j] = aux[j];
                // aux[i] = bin[i];
                // System.out.println("aux["+i+"]="+aux[i]);
            } else
                break;
        }
        // System.out.println("bin="+bin.length);
        // for(int i=0; i<bin.length; i++) System.out.println("bin["+i+"]="+bin[i]);
        // bin = aux;
        return bin;
    }

    private static int[] crypt(int ina[], int State31pn, int Polynom31pn, int State33pn, int Polynom33pn, int State64Hpn, int State64Lpn, int Polynom64pn, int Buttpn) {
        int ota[] = new int[ina.length];// null;
        int State31 = State31pn;
        int Polynom31 = Polynom31pn;
        int State33 = State33pn;
        int Polynom33 = Polynom33pn;
        int State64H = State64Hpn;
        int State64L = State64Lpn;
        int Polynom64 = Polynom64pn;
        int Butt = Buttpn;
        int pn = 0;
        // System.out.println("State31="+State31+" Polynom31="+Polynom31+" State33="+State33+" Polynom33="+Polynom33+" State64H="+State64H+" State64L="+State64L+" Polynom64="+Polynom64+" Butt="+Butt);
        for (int i = 0; i < ina.length; i++) {
            // System.out.println("ina["+i+"]="+ina[i]+" State31="+State31+" Polynom31="+Polynom31+" State33="+State33+" Polynom33="+Polynom33+" State64H="+State64H+" State64L="+State64L+" Polynom64="+Polynom64+" Butt="+Butt);
            do {
                int MSB = State31 & 0x80000000;
                State31 &= 0x7fffffff;
                if ((State31 & 1) != 0)
                    State31 = (State31 >>> 1) ^ Polynom31;
                else
                    State31 >>>= 1;
                if ((State33 & 0x80000000) != 0)
                    State31 |= 0x80000000;
                // System.out.println("State31="+State31);
                if (MSB != 0)
                    State33 = (State33 << 1) ^ Polynom33;
                else
                    State33 <<= 1;
                MSB = (State64H & 1);
                State64H >>>= 1;
                State64H |= State64L & 0x80000000;
                if (MSB != 0)
                    State64L = (State64L << 1) ^ Polynom64;
                else
                    State64L <<= 1;
            } while ((State64L & Butt) != 0);
            pn = (State31 ^ State33);
            ota[i] = ina[i] ^ pn;
        }
        // for(int i=0; i<ota.length; i++) System.out.println("ota["+i+"]="+ota[i]);
        return ota;
    }

    /* DESENCRIPTA */

    public static String decrypt_sda(String wbuffer) {
    	return decrypt_sda(wbuffer, null);
    }
    public static String decrypt_sda(String wbuffer, String passphr) {
        int State31 = 0, Polynom31 = 0, State33 = 0, Polynom33 = 0, State64H = 0, State64L = 0, Polynom64 = 0, Butt = 0;
        String dwbuffer = "";
        if (passphr==null) {
            passphr = String.valueOf(ConnectionFactory.operationProperty("lotosaleKey", Constants.contextCardWeb)).toString().trim();// "1NTR4L0T$";
        }
        int chrsz = 8; /* bits per input character. 8 - ASCII; 16 - Unicode */
        int Polynomials31[] = { 0x40c6e78f, 0x44ea7b19, 0x45da25ce, 0x470c368e, 0x4920f4c1, 0x4a2fb865, 0x4b641875, 0x4d474412, 0x4c175700, 0x4e880047, 0x50a5894c, 0x51ae3883, 0x531df126, 0x563e62e8,
                0x586801c2, 0x5bef4706, 0x5c14c48a, 0x5d06e2a7, 0x5f2f8a72, 0x623311d9, 0x65616f52, 0x668043b4, 0x672161c9, 0x67f0a6a8, 0x6814750f, 0x6c4920c3, 0x6dca541b, 0x6e97e1ed, 0x70963ac8,
                0x72de5f24, 0x7411688a, 0x7502196b, 0x76202331, 0x7887a9e1, 0x790621f4, 0x7e79deae, 0x7faca450 };
        // for(int i=0; i<str2binl(passphr, chrsz).length; i++) System.out.println("str2binl["+i+"]="+(str2binl(passphr, chrsz)[i])+" passphr.length="+(passphr.length() * chrsz));
        int pnState[] = core_md5(str2binl(passphr, chrsz), passphr.length() * chrsz);
        // for(int i=0; i<pnState.length; i++) System.out.println("1pnState["+i+"]="+pnState[i]);
        State31 = pnState[0];
        if ((State31 & 0x7fffffff) == 0)
            State31++;
        State33 = pnState[1];
        if (State33 == 0)
            State33++;
        State64H = pnState[2];
        State64L = pnState[3];
        if (State64H == 0 && State64L == 0)
            State64L++;
        // for(int i=0; i<pnState.length; i++) System.out.println("2pnState["+i+"]="+pnState[i]);
        int Polynom[] = core_md5(pnState, 0x80);
        // int aux[] = null;
        // aux = Polynom;
        // Polynom = new int[15];
        // for(int j=0; j<aux.length; j++) Polynom[j] = aux[j];
        // System.out.println("Polynom="+Polynom.length);
        // for(int i=0; i<Polynom.length; i++) System.out.println("1Polynom["+i+"]="+Polynom[i]);
        int[] Polynommd5 = core_md5(str2binl(passphr, chrsz), passphr.length() * chrsz >> 1);
        // aux = Polynommd5;
        // Polynommd5 = new int[15];
        // for(int j=0; j<aux.length; j++) Polynommd5[j] = aux[j];
        // for(int i=0; i<Polynommd5.length; i++) System.out.println("Polynommd5["+i+"]="+Polynommd5[i]);
        for (int i = 0; i < Polynom.length; i++)
            Polynom[i] ^= Polynommd5[i];
        // Polynom[0] ^= core_md5(str2binl(passphr, chrsz), passphr.length() * chrsz >> 1)[0];
        // Polynom = new int[15];
        Polynom31 = Polynomials31[(Polynom[0] >>> 1) % Polynomials31.length];
        Polynom33 = Polynom[1] | 1;
        Polynom64 = Polynom[2] | 1;
        Butt = 1 << (Polynom[3] & 0x1f);
        Butt |= 1 << ((Polynom[3] >> 8) & 0x1f);
        // int[] b64 = b64_to_array(wbuffer);
        // for(int i=0; i<b64.length; i++) System.out.println("b64_to_array["+i+"]="+b64[i]);
        dwbuffer += expand7to8(crypt(b64_to_array(wbuffer), State31, Polynom31, State33, Polynom33, State64H, State64L, Polynom64, Butt));
        // System.out.println("DESENCRIPTADO...\n"+dwbuffer+"\nï¿½Es el mismo dï¿½a? "+dwbuffer.substring(8)+" "+today.getTime()+" "+((dwbuffer.substring(8)).equals(String.valueOf(today.getTime()).toString())));
        // document.write( dwbuffer );
        // document.close();
        // return false;
        return dwbuffer;
    }

    private static String expand7to8(int array[]) {
        // for(int i=0; i< array.length; i++) System.out.println("array["+i+"]="+array[i]);
        String str = "";
        for (int i = 0; i < array.length; i += 7) {
            int tmp = array[i];
            int out = tmp >> 1;
            str += (char) (out & 0x7f);
            for (int j = 1; j < 8; j++) {
                out = (tmp << (7 - j)) & 0x7f;
                if (i + j < array.length)
                    tmp = array[i + j];
                str += (char) (out |= (tmp & 0xff) >> (j + 1));
            }
        }
        str = str.split("\0")[0];
        return str;
    }

    private static int[] b64_to_array(String str) {
        int decode[] = b64_decode_tab();
        int arr[] = new int[0];// str.length()+1];
        int aux[] = null;
        int lng = str.length();
        for (int i = 0; i < str.length(); i += 4) {
            int b1 = str.charAt(i);
            int b2 = (i + 1 < lng) ? (int) str.charAt(i + 1) : 0;
            int b3 = (i + 2 < lng) ? (int) str.charAt(i + 2) : 0;
            int b4 = (i + 3 < lng) ? (int) str.charAt(i + 3) : 0;
            int triplet = ((decode[b1] << 18) & 0xffffff) | ((decode[b2] << 12) & 0x3ffff) | ((decode[b3] << 6) & 0xfff) | ((decode[b4]) & 0x3f);
            aux = arr;
            arr = new int[aux.length + 1];
            for (int j = 0; j < aux.length; j++)
                arr[j] = aux[j];
            arr[arr.length - 1] = (triplet >> 16) & 0xff;
            if (b3 != 0) {
                aux = arr;
                arr = new int[aux.length + 1];
                for (int j = 0; j < aux.length; j++)
                    arr[j] = aux[j];
                arr[arr.length - 1] = (triplet >> 8) & 0xff;
            }
            if (b4 != 0) {
                aux = arr;
                arr = new int[aux.length + 1];
                for (int j = 0; j < aux.length; j++)
                    arr[j] = aux[j];
                arr[arr.length - 1] = triplet & 0xff;
            }
            // arr[aux.length] = (triplet >> 16) & 0xff;
            // if(b3 != 0) arr[aux.length+1] = (triplet >> 8) & 0xff;
            // if(b4 != 0) arr[aux.length+1+(b3!=0?1:0)] = triplet & 0xff;
        }
        // for(int i=0; i< arr.length; i++) System.out.println("arr["+i+"]="+arr[i]);
        return arr;
    }

    private static int[] b64_decode_tab() {
        String b64_tab = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        int decode[] = new int[0];// b64_tab.length()+2];
        int aux[] = null;
        for (int i = 0; i < b64_tab.length(); i++) {
            aux = decode;
            if ((b64_tab.charAt(i)) >= aux.length) {
                decode = new int[(b64_tab.charAt(i)) + 1];
                for (int j = 0; j < aux.length; j++)
                    decode[j] = aux[j];
            }
            // System.out.println("["+i+"] b64_tab="+(int)b64_tab.charAt(i)+" "+b64_tab.length());
            decode[b64_tab.charAt(i)] = i;
        }
        // for(int i=0; i<decode.length; i++) System.out.println("decode["+i+"]="+decode[i]);
        return decode;
    }

    /* ENCRIPTA */

    public static String encrypt_sda(String plainstr) {
    	return encrypt_sda(plainstr, null);
    }
    public static String encrypt_sda(String plainstr, String passphr) {
    	if (passphr==null) {
            passphr = String.valueOf(ConnectionFactory.operationProperty("lotosaleKey", Constants.contextCardWeb)).toString().trim();// "1NTR4L0T$"; //palabra clave
    	}
        int State31 = 0, Polynom31 = 0, State33 = 0, Polynom33 = 0, State64H = 0, State64L = 0, Polynom64 = 0, Butt = 0;
        int chrsz = 8; /* bits per input character. 8 - ASCII; 16 - Unicode */
        int Polynomials31[] = { 0x40c6e78f, 0x44ea7b19, 0x45da25ce, 0x470c368e, 0x4920f4c1, 0x4a2fb865, 0x4b641875, 0x4d474412, 0x4c175700, 0x4e880047, 0x50a5894c, 0x51ae3883, 0x531df126, 0x563e62e8,
                0x586801c2, 0x5bef4706, 0x5c14c48a, 0x5d06e2a7, 0x5f2f8a72, 0x623311d9, 0x65616f52, 0x668043b4, 0x672161c9, 0x67f0a6a8, 0x6814750f, 0x6c4920c3, 0x6dca541b, 0x6e97e1ed, 0x70963ac8,
                0x72de5f24, 0x7411688a, 0x7502196b, 0x76202331, 0x7887a9e1, 0x790621f4, 0x7e79deae, 0x7faca450 };
        int pnState[] = core_md5(str2binl(passphr, chrsz), passphr.length() * chrsz);
        // for(int i=0; i<pnState.length; i++) System.out.println("pnState["+i+"]="+pnState[i]);
        State31 = pnState[0];
        // System.out.println("1State31="+State31);
        if ((State31 & 0x7fffffff) == 0)
            State31++;
        // System.out.println("2State31="+State31+" 0x7fffffff="+(State31 & 0x7fffffff));
        State33 = pnState[1];
        // System.out.println("1State33="+State33);
        if (State33 == 0)
            State33++;
        // System.out.println("2State33="+State33+" !State33="+(State33 == 0));
        State64H = pnState[2];
        State64L = pnState[3];
        // System.out.println("1State64H="+State64H+" State64L="+State64L);
        if (State64H == 0 && State64L == 0)
            State64L++;
        // System.out.println("2State64L="+State64L+" State64L="+(State64H == 0 && State64L == 0));
        int Polynom[] = core_md5(pnState, 0x80);
        // System.out.println("Polynom="+Polynom.length);
        // for(int i=0; i<Polynom.length; i++) System.out.println("Polynom["+i+"]="+Polynom[i]);
        // int aux[] = null;
        // aux = Polynom;
        // Polynom = new int[15];
        // for(int j=0; j<aux.length; j++) Polynom[j] = aux[j];
        // System.out.println("Polynom="+Polynom.length);
        // for(int i=0; i<Polynom.length; i++) System.out.println("1Polynom["+i+"]="+Polynom[i]);
        int[] Polynommd5 = core_md5(str2binl(passphr, chrsz), passphr.length() * chrsz >> 1);
        // System.out.println("Polynommd5="+Polynommd5.length);
        // for(int i=0; i<Polynommd5.length; i++) System.out.println("Polynommd5["+i+"]="+Polynommd5[i]);
        // aux = Polynommd5;
        // Polynommd5 = new int[15];
        // for(int j=0; j<aux.length; j++) Polynommd5[j] = aux[j];
        // for(int i=0; i<Polynommd5.length; i++) System.out.println("Polynommd5["+i+"]="+Polynommd5[i]);
        for (int i = 0; i < Polynom.length; i++)
            Polynom[i] ^= Polynommd5[i];
        // System.out.println("Polynom="+Polynom.length);
        // for(int i=0; i<Polynom.length; i++) System.out.println("2Polynom["+i+"]="+Polynom[i]);
        // System.out.println("Polynom="+Polynom[0]);
        // Polynom = new int[15];
        Polynom31 = Polynomials31[(Polynom[0] >>> 1) % Polynomials31.length];
        // System.out.println("Polynom31="+Polynom31);
        Polynom33 = Polynom[1] | 1;
        Polynom64 = Polynom[2] | 1;
        Butt = 1 << (Polynom[3] & 0x1f);
        Butt |= 1 << ((Polynom[3] >> 8) & 0x1f);
        // System.out.println("State31="+State31+" Polynom31="+Polynom31+" State33="+State33+" Polynom33="+Polynom33+" State64H="+State64H+" State64L="+State64L+" Polynom64="+Polynom64+" Butt="+Butt);
        // System.out.println("today="+today+" today.getTime="+today.getTime());
        // String plainstr = "INTRALOT"+today.getTime(); //texto a encriptar
        // int[] crypta = crypt(compress8to7(plainstr), State31, Polynom31, State33, Polynom33, State64H, State64L, Polynom64, Butt);
        // System.out.println("plainstr="+plainstr);
        // for(int i=0; i<crypta.length; i++) System.out.println("crypta["+i+"]="+crypta[i]);
        String dwbuffer = array_to_form(crypt(compress8to7(plainstr), State31, Polynom31, State33, Polynom33, State64H, State64L, Polynom64, Butt));// array_to_form(crypt(compress8to7(plainstr),
                                                                                                                                                    // State31, Polynom31, State33, Polynom33, State64H,
                                                                                                                                                    // State64L, Polynom64, Butt));
        // System.out.println("ENCRIPTADO...\n"+dwbuffer);//+"\nï¿½Es el mismo dï¿½a? "+dwbuffer.substring(8)+" "+today.getTime()+" "+(dwbuffer.substring(8).equals(today.getTime())));
        return dwbuffer;
        // alert("ENCRIPTADO...\n"+result);
    }

    private static String array_to_form(int[] arr) {
        String b64_tab = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        String wbuffer = "";
        int lng = arr.length;
        String str = "";// "\"";//"";
        for (int i = 0; i < lng; i += 3) {
            int b2 = (i + 1 < lng) ? arr[i + 1] : 0;
            int b3 = (i + 2 < lng) ? arr[i + 2] : 0;
            int triplet = ((arr[i] << 16) & 0xffffff) | ((b2 << 8) & 0xffff) | (b3 & 0xff);
            str += b64_tab.charAt((triplet >> 18) & 0x3f);
            str += b64_tab.charAt((triplet >> 12) & 0x3f);
            if (b2 != 0)
                str += b64_tab.charAt((triplet >> 6) & 0x3f);
            if (b3 != 0)
                str += b64_tab.charAt(triplet & 0x3f);
            if (i % 48 == 45) {
                str += "";// "\"";
                wbuffer += str;
                if (i < lng - 3)
                    str = "";// "+\"";//"+\n\"";
            } else {
                if (i >= lng - 3) {
                    str += "";// "\"";
                    wbuffer += str;
                }
            }
            // wbuffer += str;
        }
        return wbuffer;
    }

    private static int[] compress8to7(String str) {
        // function compress8to7(str) {
        int arr[] = new int[0];
        int aux[] = null;
        // arr = Array();
        for (int i = 0; i < str.length(); i += 8) {
            // val = str.charCodeAt(i) << 1 & 0xfe;
            int val = str.charAt(i) << 1 & 0xfe;
            for (int j = 0; j < 7 && i + j < str.length() + 1; j++) {
                // tmp = str.charCodeAt(i+j+1) << (j+2);
                // System.out.println("i+j+1="+(i+j+1)+" j+2="+(j+2)+" str.charAt="+str.charAt(i+j+1));
                int tmp = 0;
                if (i + j + 1 < str.length())
                    tmp = str.charAt(i + j + 1) << (j + 2);
                val |= tmp >> 8;
                aux = arr;
                arr = new int[aux.length + 1];
                for (int k = 0; k < aux.length; k++)
                    arr[k] = aux[k];
                arr[arr.length - 1] = (val & 0xff);
                val = tmp & 0xff;
            }
        }
        // for(int i=0; i<arr.length; i++) System.out.println("arr["+i+"]="+arr[i]);
        return arr;
    }

    public static void main(String[] args) throws  Exception {

    	System.out.println( verifySintaxMobilePhone("999148057") ) ; 
    	
    	String pPassword = "angel123";
        boolean atleastOneAlpha = pPassword.matches(".*[a-zA-Z]+.*");
        boolean atleastOneNumber = pPassword.matches(".*[0-9]+.*");

        //System.out.println(verifyPassword("","fine2021$","fine2021$"));
        System.out.println(StringLib.decodeLabel("5BB05tOdzYRGP9NfINC/eg=="));
        //System.out.println(atleastOneNumber);
        
        
    	/*
    	String plainstr = "EQ38Z1qvdfR2aHjQFn7KUMRsIEzwmNehJsKhsHzWTl09G%2B8r5nigFsSNROyIiF2Qf5gUWLh8GY3ax84To6IgcmHnnJhi8CvwxPZKSQ4OhG84XnihxLUzmkgV%2B3fuZXPNvbZSmVl8bseHFTahV2uDPikcem69Oj3c8IGgf2RMJTnugTRp79Hia0TLLjPuKTXkoat1yWU04zvBgpLMsYmxL6PUras%2FNC9G";
    	
        System.out.println("plainstr=" + plainstr);
        plainstr = plainstr.replace("+", "%2B");
        System.out.println("%plainstr=" + plainstr);
        plainstr = URLDecoder.decode(plainstr, "UTF-8");
        System.out.println("decoded=" + plainstr);
        plainstr = ClientUtils.decrypt_sda(plainstr,"ABCINTRALOTDEPERUKEY");
        System.out.println("decrypt=" + plainstr);
        */
        
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
    }
    

    public static String verifyPassword(String pUser, String pPassword, String rePassword) throws Exception {        
        //------------ VERIFICACION DE PASSWORD
    	//String message="Esta contrase&ntilde;a no cumple con el formato seguro, para m&aacute;s informaci&oacute;n haz clic en <b>&quot;Crea una contraseña segura&quot;</b>";
    	String message="Esta contrase&ntilde;a debe tener al menos 8 caracteres, incluir may&uacute;sculas, min&uacute;sculas, n&uacute;meros y s&iacute;mbolos ($%&+!@), y ser diferente de las &uacute;ltimas 6 contrase&ntilde;as que hayas usado.";
        if (!pPassword.equals(rePassword)) {
        	//System.out.println("*"+pPassword+"*"+rePassword+"*");
        	return message;
        }
        // Password length must be at least 8 characters long. 
        if (pPassword.length()<8) {
        	return message;
        }
        // Password must consist at least 1 number and 1 letter. 
        boolean atleastOneAlpha = pPassword.matches(".*[a-zA-Z]+.*");
        boolean atleastOneNumber = pPassword.matches(".*[0-9]+.*");
        boolean atleastSpecialCharacter = pPassword.matches(".*[!@#$%^&*()+=\\[\\]\\';,\\/\\{\\}|\\\":<>?~`.\\-_¬€£¦]+.*");
        if (atleastOneAlpha==false || atleastOneNumber==false || atleastSpecialCharacter==false) {
        	return message;
        }
        //pUser vacio debido a que el codigo de verificacion es errado
        if (pUser.equals("")) {
        	return message;
        }        
        	// Expresión regular para validar que la contraseña tenga al menos una letra mayúscula y una letra minúscula
        String regex = "^(?=.*[a-z])(?=.*[A-Z]).+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pPassword);
        if (!matcher.matches()) {
            	return message;
        }
        return "OK";
    }


    public static String verifyEmail(String email) throws Exception {
    	/*
        String mails = "@mailcatch.com,@trbvn.com,@20email,@clrmail.com,@emailsensei.com,@filzmail.com,@sharklasers.com,@grr.la,@guerrillamail,@spam4.me,@incognitomail.org,@uu1.pl,@mailinator.com,@mailnesia.com,@mintemail.com,@mt2015.com,@noclickemail.com,@spamfree24.org,@tempemail.net,@trashmail.ws,@yopmail.com";
        
        //------------ VERIFICACION DE MAIL
        String[] list = mails.split(",");
        for (String s:list) {
            if (email.toLowerCase().contains(s.toLowerCase())) {
            	return "El correo ingresado es incorrecto [3]";
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
        	return "El correo registrado tiene un dominio invalido";
        }
    	
        return "OK";
    }
    
    public static String getResponseBody(String url, MediaType mediaType, HttpMethod httpMethod, HashMap<String, String> parameters) {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(mediaType);
		HttpEntity<String> requestEntity = new HttpEntity<String>(requestHeaders);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		ResponseEntity<String> responseEntity;
		/*if (parameters != null && parameters.containsKey("datagenericbet") && parameters.containsKey("bet")) {
			Log.e("datagenericbet utils", parameters.get("datagenericbet"));
			Log.e("bet utils", parameters.get("bet"));
		}*/
		if(parameters != null && parameters.containsKey("dni")) System.out.println("DNI="+parameters.get("dni"));
        if(parameters != null)responseEntity = restTemplate.exchange(url, httpMethod, requestEntity, String.class, parameters);
        else responseEntity = restTemplate.exchange(url, httpMethod, requestEntity, String.class);
        //String s = cipher.decrypt(responseEntity.getBody());
        return cipher.decrypt(responseEntity.getBody());//s;
	}
    
    public static Object toGenericObject(String json, Class clase){
        try {
            Gson gson = new Gson();
            return gson.fromJson(json, clase);
        } catch (JsonSyntaxException e) {
            //Log.e("osef", "Date exception. Other parser.");
            Gson gson = new GsonBuilder().setDateFormat("Mon dd, yyyy hh:mi:ss AM").create();
            return gson.fromJson(json, clase);
        }
 	}
    
    public static boolean verifySintaxMail(String pMail1) {
    	if(StringUtils.isNotEmpty(pMail1)) {
        	String EMAIL_PATTERN =
        			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        	Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        	Matcher matcher  = pattern.matcher(pMail1);
        	
        	return matcher.matches();	
        }
    	
    	return false;
    }
    
    public static boolean verifySintaxMobilePhone(String pMobilePhone) {
    	
        if (pMobilePhone==null || pMobilePhone.equals("")) {
            return false;
        }
    	if(StringUtils.isNotEmpty(pMobilePhone)) {
        	String PHONE_PATTERN =
        			"^9\\d{8}";
        	Pattern pattern = Pattern.compile(PHONE_PATTERN);
        	Matcher matcher  = pattern.matcher(pMobilePhone);
        	
        	return matcher.matches();
        } else {
        	return true;
        } //return false;
    }
    
    public static boolean verifySintaxSmsCode(String pSmsCode, String pSize) {
    	if(StringUtils.isNotEmpty(pSmsCode)) {
        	String SMS_CODE_PATTERN =
        			"\\d{"+pSize+"}";
        	Pattern pattern = Pattern.compile(SMS_CODE_PATTERN);
        	Matcher matcher  = pattern.matcher(pSmsCode);
        	
        	return matcher.matches();
        }
    	
    	return false;
    }
    
    public static void updateUserSession(HttpSession session,ClientProcedureLogin clientProcedureLogin,ClientProcedureTokenGeneration tokenGeneration,ClientProcedureLPTokenGeneration lpTokenGeneration,ClientProcedureTANTokenGeneration tanTokenGeneration,int game) {
    	UserBean userBean = new UserBean();
        userBean.setpSessionid(clientProcedureLogin.getSessionId());
        userBean.setpClientid(clientProcedureLogin.getClientId());
        userBean.setpMail(clientProcedureLogin.getMail());
        userBean.setpSessionCode(clientProcedureLogin.getSessionCode());
        userBean.setpStatus(clientProcedureLogin.getStatus());
        userBean.setpMode(Integer.parseInt(clientProcedureLogin.getMode()));
        userBean.setpLuckyIcon(clientProcedureLogin.getLuckyIcon());
        userBean.setpAgreement(clientProcedureLogin.getAgreement());
        userBean.setpMailVerified(clientProcedureLogin.getMailVerified());
        userBean.setpPromotion(clientProcedureLogin.getPromotion());
        userBean.setpPromotionibk(clientProcedureLogin.getPromotionibk());
	    userBean.setpMobilePhone(clientProcedureLogin.getMobilePhone());
	    userBean.setpMobileStatus(clientProcedureLogin.getMobileStatus());
        userBean.setpNombre(clientProcedureLogin.getCl_nombre());
        userBean.setpMonto(clientProcedureLogin.getBalanceAmount());
        userBean.setpMailStatus(clientProcedureLogin.getMailStatus());
        userBean.setpKironAmount(Double.parseDouble(clientProcedureLogin.getToday()));
        userBean.setpGame(game);
        if (tokenGeneration!=null && tokenGeneration.getMessage().equals("OK")) {
        	userBean.setpToken(tokenGeneration.getIflexToken());
        }
        session.setAttribute(Constants.USR_SESION, userBean);
    }
    
    public static String formatCurrency(double mount){    		
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
		DecimalFormat df = (DecimalFormat)nf;
		df.applyPattern("'S/' #,###,###,##0.00");  
		
		return df.format(mount); 
	}
    
	public static String formatCurrency3(int mount){    		
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
		DecimalFormat df = (DecimalFormat)nf;
		df.applyPattern(Constants.FORMATTER_CURRENCY3);  
		
		return df.format(mount); 
	}
    
    public static String formatAmount(double mount){    		
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
		DecimalFormat df = (DecimalFormat)nf;
		df.applyPattern("#,###,###,##0.00");  
		
		return df.format(mount); 
	}
    
    public static String formatAmountBalance(double mount){    		
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
		DecimalFormat df = (DecimalFormat)nf;
		df.applyPattern("###0.0");  
		
		return df.format(mount); 
	}
    
    public static ClientProcedureAccountData verifiedTestUsersWelcomeBonus(ClientProcedureAccountData accountData, HttpSession session) {
    	//LoggerApi.Log.info("/verifiedTestUsersWelcomeBonus ALL-ALLOWED=" + Constants.welcameBonusUsers.trim().equals("ALL-ALLOWED"));
    	//LoggerApi.Log.info("/verifiedTestUsersWelcomeBonus USER-ID=" + ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid());
    	//LoggerApi.Log.info("/verifiedTestUsersWelcomeBonus USER-ALLOWED=" + Constants.welcameBonusUsers.contains(((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid().toString()));
    	String clientId = "";
    	try {
    		clientId = (session!=null && session.getAttribute(Constants.USR_SESION)!=null && !(session.getAttribute(Constants.USR_SESION).toString().trim()).equals(""))?((UserBean)session.getAttribute(Constants.USR_SESION)).getpClientid().toString():"";
    	} catch(Exception e) {
    		clientId = "";
    	}
    	if(StringUtils.isNotEmpty(accountData.getBonusAmount())) {
    		accountData.setBonusMessage(accountData.getBonusMessage().replaceAll("__",""));
    	}
    	if(Constants.welcameBonusUsers.trim().equals("ALL-ALLOWED") || (clientId!=null && !clientId.trim().equals("") && Constants.welcameBonusUsers.contains(clientId))) {
    		accountData.setWelcomeBonusLastDate(accountData.getWelcomeBonusLastDate().trim());
			accountData.setWelcomeBonusMessage(accountData.getWelcomeBonusMessage().trim());
			accountData.setWelcomeBonusPercentaje(accountData.getWelcomeBonusPercentaje().trim());
			accountData.setWelcomeBonusStatus(accountData.getWelcomeBonusStatus().trim());
			//if(accountData.getWelcomeBonusStatus()!=null && accountData.getWelcomeBonusStatus().toString().trim().equals("Reciente")) accountData.setWelcomeBonusMessagePor("<fieldset><div class=\"top-saldo\">&iexcl;OBT&Eacute;N TU BONO<br/>DE BIENVENIDA!<br/><span><b>"+accountData.getWelcomeBonusPercentaje().toString().trim()+"</b>% DE TU RECARGA</span><div class=\"saldo-add\">para jugar Te Apuesto<br/><label>(recarga m&iacute;nima de S/20)</label><h3>+</h3><span>JUGADAS GRATIS</span>de todas nuestras loter&iacute;as</div><img src=\"layer-view-image/v2/logos.png\" alt=\"\" /></div></fieldset><div class=\"control-form\"><input type=\"button\" onclick=\"top.dhtmlwindow.close(top.document.getElementById('resultboxwcb'));$('#tab-item_4').trigger('click');\" value=\"ACT&Iacute;VALO AQU&Iacute;\" class=\"js-close-modal btn btn-orange white wcb-button-text\" /></div><p class=\"tyc-block\">Inf&oacute;rmate de los t&eacute;rminos y condiciones antes de realizar tu recarga</p>");
			//if(accountData.getWelcomeBonusStatus()!=null && accountData.getWelcomeBonusStatus().toString().trim().equals("Activo"))   accountData.setWelcomeBonusMessagePor("<fieldset><div class=\"top-saldo\">&iexcl;OBT&Eacute;N TU BONO<br/>DE BIENVENIDA!<br/><span><b>"+accountData.getWelcomeBonusPercentaje().toString().trim()+"</b>% DE TU RECARGA</span><div class=\"saldo-add\">para jugar Te Apuesto<br/><label>(recarga m&iacute;nima de S/20)</label><h3>+</h3><span>JUGADAS GRATIS</span>de todas nuestras loter&iacute;as</div><img src=\"layer-view-image/v2/logos.png\" alt=\"\" /></div></fieldset><div class=\"control-form\"><input type=\"button\" id=\"activaloAqui\" onclick=\"top.dhtmlwindow.close(top.document.getElementById('resultboxwcb'));$('#tab-item_4').trigger('click');\" value=\"ACT&Iacute;VALO AQU&Iacute;\" class=\"js-close-modal btn btn-orange white wcb-button-text\" /></div><p class=\"tyc-block\">Inf&oacute;rmate de los t&eacute;rminos y condiciones antes de realizar tu recarga</p>");
			if(accountData.getWelcomeBonusStatus()!=null && accountData.getWelcomeBonusStatus().toString().trim().equals("Reciente"))   accountData.setWelcomeBonusMessagePor("<fieldset><div class=\"top-saldo\">&iexcl;OBT&Eacute;N TU BONO<br/>DE BIENVENIDA!<br/><span><b>"+accountData.getWelcomeBonusPercentaje().toString().trim()+"</b>% DE TU RECARGA</span><div class=\"saldo-add\">para jugar Te Apuesto<br/><label>(recarga m&iacute;nima de S/20)</label><h3>+</h3><span>JUGADAS GRATIS</span>de nuestras loter&iacute;as</div><img src=\"layer-view-image/v2/logos.png\" alt=\"\" /></div></fieldset><div class=\"control-form\"><input type=\"button\" id=\"activaloAqui\" onclick=\"top.dhtmlwindow.close(top.document.getElementById('resultboxwcb'));$('#tab-item_4').trigger('click');\" value=\"CONTINUAR\" class=\"js-close-modal btn btn-orange white wcb-button-text\" /></div><p class=\"tyc-block\">Inf&oacute;rmate de los t&eacute;rminos y condiciones antes de realizar tu recarga</p>");
	     	else accountData.setWelcomeBonusMessagePor("");
    		return accountData;
    	} else {
    		accountData.setWelcomeBonusLastDate("");
    		accountData.setWelcomeBonusMessage("");
    		accountData.setWelcomeBonusPercentaje("");
    		accountData.setWelcomeBonusStatus("");
    		return accountData;
    	}
    }
    
    public static void updateClientBalance(HttpSession session,ClientSaleBo clientSaleBo) throws Exception {
    	Integer clientId = 0;
    	try {
    		clientId = (session!=null && session.getAttribute(Constants.USR_SESION)!=null && !(session.getAttribute(Constants.USR_SESION).toString().trim()).equals(""))?((UserBean)session.getAttribute(Constants.USR_SESION)).getpClientid():0;//session.getAttribute(Constants.USR_SESION)!=null?((UserBean)session.getAttribute(Constants.USR_SESION)).getpClientid():0;
    	} catch(Exception e) {
    		clientId = 0;
    	}
    	if (clientId!=0) {
    		ClientProcedureAccountData clientProcedureAccountData = clientSaleBo.findAccountData(clientId);
    		clientProcedureAccountData = ClientUtils.verifiedTestUsersWelcomeBonus(clientProcedureAccountData,session);
    		
    		if (clientProcedureAccountData!=null) {
    			String result = new Gson().toJson(clientProcedureAccountData);
    			session.setAttribute("clientBalance", result);
    		}
    	}
    	
    }
    
    public static String getClientIp(HttpServletRequest request) {
    	String log="getClientIp";
    	String url = escapeChar(request.getRequestURL().toString());
		LoggerApi.Log.info(log+" user-agent	="+request.getHeader("user-agent"));
		LoggerApi.Log.info(log+" url="+url);
    	String clientIp=request.getHeader("Incap-Client-IP");
		LoggerApi.Log.info(log+" Incap-Client-IP=" +clientIp);
		if (clientIp==null || clientIp.equals("") || clientIp.equals("NULL") || clientIp.equals("unknown")) {
	    	clientIp=request.getHeader("X-Forwarded-For");
			LoggerApi.Log.info(log+" X-Forwarded-For IP=" +clientIp);
			if (clientIp==null || clientIp.equals("") || clientIp.equals("NULL") || clientIp.equals("unknown")) {
				clientIp=request.getRemoteAddr();
				LoggerApi.Log.info(log+" getRemoteAddr IP=" +clientIp);
			}
		}
    	return clientIp;
    }
    
    private static String escapeChar(String str) {
        char src[] = str.toCharArray();
        int len = src.length;
        for (int i = 0; i < src.length; i++) {
            switch (src[i]) {
                case '<':    // to "&lt;"
                    len += 3;
                    break;
                case '>':    // to "&gt;"
                    len += 3;
                    break;
                case '&':    // to "&amp;"
                    len += 4;
                    break;
            }
        }
        char ret[] = new char[len];
        int j = 0;
        for (int i = 0; i < src.length; i++) {
            switch (src[i]) {
                case '<':    // to "&lt;"
                    ret[j++] = '&';
                    ret[j++] = 'l';
                    ret[j++] = 't';
                    ret[j++] = ';';
                    break;
                case '>':    // to "&gt;"
                    ret[j++] = '&';
                    ret[j++] = 'g';
                    ret[j++] = 't';
                    ret[j++] = ';';
                    break;
                case '&':    // to "&amp;"
                    ret[j++] = '&';
                    ret[j++] = 'a';
                    ret[j++] = 'm';
                    ret[j++] = 'p';
                    ret[j++] = ';';
                    break;
                default:
                    ret[j++] = src[i];
                    break;
            }
        }
        return new String(ret);
    }
    
	public static String verifyPersonalInformation(String documentType, String document, String name, String lastname)
			throws Exception {

		// ------------ VERIFICACION DE TIPO DE DOCUMENTO
		if ((documentType==null || documentType.equals("")) || (!documentType.equals("DNI") && !documentType.equals("PASAP") && !documentType.equals("CAREX"))) {
			return "El tipo de documento ingresado es invalido";
		}
		// ------------ VERIFICACION DE DOCUMENTO
		if (documentType.equals("DNI")) {
			String expRegDocument = "^\\d{8}$";
			Boolean verifyDocument = new RegexValidator(expRegDocument).isValid(document);
			if(!verifyDocument) {
				return "El documento debe tener 8 caracteres numericos";
			}
		}
		if (documentType.equals("PASAP") || documentType.equals("CAREX")) {
			String expRegDocument = "^[a-zA-Z0-9]{9,12}$";
			Boolean verifyDocument = new RegexValidator(expRegDocument).isValid(document);
			if(!verifyDocument) {
				return "El documento debe tener mas de 8 caracteres y menos de 13 caracteres alfanumericos";
			}
		}
		// ------------ VERIFICACION DE NOMBRES
		String expRegName ="^[a-zA-Z\\sáéíóúÁÉÍÓÚäëïöüÄËÏÖÜñÑ]+{1,74}$";
		Boolean verifyName = new RegexValidator(expRegName).isValid(name.trim());
		if(!verifyName) {
			return "Los nombres ingresado son invalidos";
		}
		// ------------ VERIFICACION DE TIPO APELLIDOS
		verifyName = new RegexValidator(expRegName).isValid(lastname.trim());
		if(!verifyName) {
			return "Los apellidos ingresado son invalidos";
		}
        
        return "OK";
    }
	
	public static String verifyContactInformation(String nacionalidad, String domicilio, String departamento, String provincia, String distrito) {		
		String expRegAddress = "[a-zA-Z0-9°#.,\\sáéíóúÁÉÍÓÚäëïöüÄËÏÖÜñÑ-]+";
		String expRegCode = "\\d{2}";
		String expCouCode = "^[A-Z]{2}$";
		//validar nacionalidad
		Boolean verifyCountry = new RegexValidator(expCouCode).isValid(nacionalidad);        
        if (!verifyCountry) {
            return "Seleccionar una nacionalidad correcta";       
        }
		 //validar domicilio
        if(domicilio.length()>70) {           
            return "La direcci&oacute;n debe tener menos de 70 caracteres";        	
        }else {
        	Boolean verifyAddress = new RegexValidator(expRegAddress).isValid(domicilio.trim());        
            if (!verifyAddress) { 
                return "Ingresar una direcci&oacute;n correcta"; 
            }
        }
        Boolean verifyDepartamento = new RegexValidator(expRegCode).isValid(departamento);        
        if (!verifyDepartamento) {
            return "Seleccionar un departamento correcto";       
        }
       //validar provincia        
        Boolean verifyProvincia = new RegexValidator(expRegCode).isValid(provincia);        
        if (!verifyProvincia) {
            return "Seleccionar una provincia correcta";
        }
        //validar distrito        
        Boolean verifyDistrito = new RegexValidator(expRegCode).isValid(distrito);        
        if (!verifyDistrito) {
            return "Seleccionar un distrito correcto";           
        }
		return "OK";
	}
	
	public static String verifyPasswordRegisterClient(String pPassword,String pNombre, String pApPaterno, String pNumberId, String pBirthDate, String pMobilePhone) throws Exception {
		String message="Esta contrase&ntilde;a debe tener al menos 8 caracteres, incluir may&uacute;sculas, min&uacute;sculas, n&uacute;meros y s&iacute;mbolos ($%&+!@), y ser diferente de las &uacute;ltimas 6 contrase&ntilde;as que hayas usado.";
		//validar mayusculas y minusculas
		// Expresión regular para validar que la contraseña tenga al menos una letra mayúscula y una letra minúscula
        String regex = "^(?=.*[a-z])(?=.*[A-Z]).+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pPassword);
        if (!matcher.matches()) {
        	return message;
        }         
		
		//validar nombres
		//quitar extraños
		pNombre=normalizarTexto(pNombre);
		//upper
		pPassword=pPassword.toUpperCase();
		pNombre=pNombre.toUpperCase();
		//separar
		String snombre[]=pNombre.split(" ");
		//lista blanca
		String[] list = {"EL","LA","LOS","LAS","DE","DEL","Y","O"};
		for (String sn:snombre) {
			boolean white=false;
			for(String li:list){
				if(sn.equals(li)) {
					white=true;
					break;
				}
			}
			if(white)
				continue;
			
			if(pPassword.contains(sn)) {
				return message;
			}
		}
				
		//validar apellidos
		//quitar extraños
		pApPaterno=normalizarTexto(pApPaterno);
		//upper
		pApPaterno=pApPaterno.toUpperCase();
		//separar
		String sapellidos[]=pApPaterno.split(" ");
		for (String sn:sapellidos) {
			boolean white=false;
			for(String li:list){
				if(sn.equals(li)) {
					white=true;
					break;
				}
			}
			if(white)
				continue;
			
			if(pPassword.contains(sn)) {
				return message;
			}
		}
		
		//validar document
		if(pPassword.contains(pNumberId)) {
			return message;
		}
		
		//validar birthdate
		//ddmmyyyy
		String pBirthDate1=pBirthDate.replaceAll("/", "");
		if(pPassword.contains(pBirthDate1)) {
			return message;
		}
		//yyyy
		String spBirthDate[]=pBirthDate.split("/");
		String pBirthDate2=spBirthDate[2];
		if(pPassword.contains(pBirthDate2)) {
			return message;
		}
		//yyyymmdd
		String pBirthDate3=spBirthDate[2]+spBirthDate[1]+spBirthDate[0];		
		if(pPassword.contains(pBirthDate3)) {
			return message;
		}
		
		//validar mobilephone
		if(pPassword.contains(pMobilePhone)) {
			return message;
		}
				
		return "OK";
	}
	
	public static String normalizarTexto(String cadena) {
        String cadenaNormalizada = Normalizer.normalize(cadena, Normalizer.Form.NFD);
        return cadenaNormalizada.replaceAll("[^\\p{ASCII}ñÑ]", "");
    }
	
	public static String verifyPasswordChangePassword(String pPassword,String pNombre, String pApPaterno, String pNumberId, String pBirthDate, String pMobilePhone) throws Exception {
		String message="Esta contrase&ntilde;a debe tener al menos 8 caracteres, incluir may&uacute;sculas, min&uacute;sculas, n&uacute;meros y s&iacute;mbolos ($%&+!@), y ser diferente de las &uacute;ltimas 6 contrase&ntilde;as que hayas usado.";
		//validar mayusculas y minusculas
		// Expresión regular para validar que la contraseña tenga al menos una letra mayúscula y una letra minúscula
        String regex = "^(?=.*[a-z])(?=.*[A-Z]).+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pPassword);
        if (!matcher.matches()) {
        	return message;
        }   
        
        //lista blanca
		String[] list = {"EL","LA","LOS","LAS","DE","DEL","Y","O"};
		
		//validar nombres		
        if(!pNombre.equals("")) {
        	//quitar extraños
        	pNombre=normalizarTexto(pNombre);
    		//upper
    		pPassword=pPassword.toUpperCase();
    		pNombre=pNombre.toUpperCase();
    		//separar
    		String snombre[]=pNombre.split(" ");    		
    		for (String sn:snombre) {
    			boolean white=false;
    			for(String li:list){
    				if(sn.equals(li)) {
    					white=true;
    					break;
    				}
    			}
    			if(white)
    				continue;
    			
    			if(pPassword.contains(sn)) {
    				return message;
    			}
    		}
        }
		
				
		//validar apellidos
        if(!pApPaterno.equals("")) {
        	//quitar extraños
    		pApPaterno=normalizarTexto(pApPaterno);
    		//upper
    		pApPaterno=pApPaterno.toUpperCase();
    		//separar
    		String sapellidos[]=pApPaterno.split(" ");
    		for (String sn:sapellidos) {
    			boolean white=false;
    			for(String li:list){
    				if(sn.equals(li)) {
    					white=true;
    					break;
    				}
    			}
    			if(white)
    				continue;
    			
    			if(pPassword.contains(sn)) {
    				return message;
    			}
    		}
        }
		
		
		//validar document
		if(!pNumberId.equals("") && pPassword.contains(pNumberId)) {
			return message;
		}
		
		//validar birthdate
		if(!pBirthDate.equals("")) {
			//ddmmyyyy
			String pBirthDate1=pBirthDate.replaceAll("/", "");
			if(pPassword.contains(pBirthDate1)) {
				return message;
			}
			//yyyy
			String spBirthDate[]=pBirthDate.split("/");
			String pBirthDate2=spBirthDate[2];
			if(pPassword.contains(pBirthDate2)) {
				return message;
			}
			//yyyymmdd
			String pBirthDate3=spBirthDate[2]+spBirthDate[1]+spBirthDate[0];		
			if(pPassword.contains(pBirthDate3)) {
				return message;
			}
		}
		
		
		//validar mobilephone
		if(!pMobilePhone.equals("") && pPassword.contains(pMobilePhone)) {
			return message;
		}
				
		return "OK";
	}

}
