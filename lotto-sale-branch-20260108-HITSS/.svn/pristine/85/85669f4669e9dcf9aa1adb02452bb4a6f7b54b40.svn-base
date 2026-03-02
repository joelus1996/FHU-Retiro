package pe.com.intralot.loto.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.UnknownHostException;

import pe.com.intralot.loto.layer.model.domain.Country;

public class LookupService {

    private RandomAccessFile file = null;
    public final static int COUNTRY_EDITION = 1;
    byte databaseType = COUNTRY_EDITION;
    int databaseSegments[];
    int recordLength;
    String licenseKey;
    int dnsService = 0;
    byte dbbuffer[];
    byte index_cache[];
    long mtime;
    int last_netmask;
    private final static int COUNTRY_BEGIN = 16776960;
    public final static int GEOIP_STANDARD = 0;
    public final static int GEOIP_MEMORY_CACHE = 1;
    public final static int GEOIP_CHECK_CACHE = 2;
    public final static int GEOIP_INDEX_CACHE = 4;
    public final static int GEOIP_UNKNOWN_SPEED = 0;
    public final static int GEOIP_DIALUP_SPEED = 1;
    public final static int GEOIP_CABLEDSL_SPEED = 2;
    public final static int GEOIP_CORPORATE_SPEED = 3;
    private final static int STANDARD_RECORD_LENGTH = 3;
    private final static int MAX_RECORD_LENGTH = 4;
    private final Country UNKNOWN_COUNTRY = new Country("--", "N/A");
    private static final String[] countryCode = { "--", "AP", "EU", "AD", "AE", "AF", "AG", "AI", "AL", "AM", "AN", "AO", "AQ", "AR", "AS", "AT", "AU", "AW", "AZ", "BA",
            "BB", "BD", "BE", "BF", "BG", "BH", "BI", "BJ", "BM", "BN", "BO", "BR", "BS", "BT", "BV", "BW", "BY", "BZ", "CA", "CC", "CD", "CF", "CG", "CH", "CI", "CK", "CL",
            "CM", "CN", "CO", "CR", "CU", "CV", "CX", "CY", "CZ", "DE", "DJ", "DK", "DM", "DO", "DZ", "EC", "EE", "EG", "EH", "ER", "ES", "ET", "FI", "FJ", "FK", "FM", "FO",
            "FR", "FX", "GA", "GB", "GD", "GE", "GF", "GH", "GI", "GL", "GM", "GN", "GP", "GQ", "GR", "GS", "GT", "GU", "GW", "GY", "HK", "HM", "HN", "HR", "HT", "HU", "ID",
            "IE", "IL", "IN", "IO", "IQ", "IR", "IS", "IT", "JM", "JO", "JP", "KE", "KG", "KH", "KI", "KM", "KN", "KP", "KR", "KW", "KY", "KZ", "LA", "LB", "LC", "LI", "LK",
            "LR", "LS", "LT", "LU", "LV", "LY", "MA", "MC", "MD", "MG", "MH", "MK", "ML", "MM", "MN", "MO", "MP", "MQ", "MR", "MS", "MT", "MU", "MV", "MW", "MX", "MY", "MZ",
            "NA", "NC", "NE", "NF", "NG", "NI", "NL", "NO", "NP", "NR", "NU", "NZ", "OM", "PA", "PE", "PF", "PG", "PH", "PK", "PL", "PM", "PN", "PR", "PS", "PT", "PW", "PY",
            "QA", "RE", "RO", "RU", "RW", "SA", "SB", "SC", "SD", "SE", "SG", "SH", "SI", "SJ", "SK", "SL", "SM", "SN", "SO", "SR", "ST", "SV", "SY", "SZ", "TC", "TD", "TF",
            "TG", "TH", "TJ", "TK", "TM", "TN", "TO", "TL", "TR", "TT", "TV", "TW", "TZ", "UA", "UG", "UM", "US", "UY", "UZ", "VA", "VC", "VE", "VG", "VI", "VN", "VU", "WF",
            "WS", "YE", "YT", "RS", "ZA", "ZM", "ME", "ZW", "A1", "A2", "O1", "AX", "GG", "IM", "JE", "BL", "MF" };
    private static final String[] countryName = { "N/A", "Asia/Pacific Region", "Europe", "Andorra", "United Arab Emirates", "Afghanistan", "Antigua and Barbuda", "Anguilla",
            "Albania", "Armenia", "Netherlands Antilles", "Angola", "Antarctica", "Argentina", "American Samoa", "Austria", "Australia", "Aruba", "Azerbaijan",
            "Bosnia and Herzegovina", "Barbados", "Bangladesh", "Belgium", "Burkina Faso", "Bulgaria", "Bahrain", "Burundi", "Benin", "Bermuda", "Brunei Darussalam",
            "Bolivia", "Brazil", "Bahamas", "Bhutan", "Bouvet Island", "Botswana", "Belarus", "Belize", "Canada", "Cocos (Keeling) Islands",
            "Congo, The Democratic Republic of the", "Central African Republic", "Congo", "Switzerland", "Cote D'Ivoire", "Cook Islands", "Chile", "Cameroon", "China",
            "Colombia", "Costa Rica", "Cuba", "Cape Verde", "Christmas Island", "Cyprus", "Czech Republic", "Germany", "Djibouti", "Denmark", "Dominica",
            "Dominican Republic", "Algeria", "Ecuador", "Estonia", "Egypt", "Western Sahara", "Eritrea", "Spain", "Ethiopia", "Finland", "Fiji",
            "Falkland Islands (Malvinas)", "Micronesia, Federated States of", "Faroe Islands", "France", "France, Metropolitan", "Gabon", "United Kingdom", "Grenada",
            "Georgia", "French Guiana", "Ghana", "Gibraltar", "Greenland", "Gambia", "Guinea", "Guadeloupe", "Equatorial Guinea", "Greece",
            "South Georgia and the South Sandwich Islands", "Guatemala", "Guam", "Guinea-Bissau", "Guyana", "Hong Kong", "Heard Island and McDonald Islands", "Honduras",
            "Croatia", "Haiti", "Hungary", "Indonesia", "Ireland", "Israel", "India", "British Indian Ocean Territory", "Iraq", "Iran, Islamic Republic of", "Iceland",
            "Italy", "Jamaica", "Jordan", "Japan", "Kenya", "Kyrgyzstan", "Cambodia", "Kiribati", "Comoros", "Saint Kitts and Nevis",
            "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Cayman Islands", "Kazakhstan", "Lao People's Democratic Republic", "Lebanon",
            "Saint Lucia", "Liechtenstein", "Sri Lanka", "Liberia", "Lesotho", "Lithuania", "Luxembourg", "Latvia", "Libyan Arab Jamahiriya", "Morocco", "Monaco",
            "Moldova, Republic of", "Madagascar", "Marshall Islands", "Macedonia", "Mali", "Myanmar", "Mongolia", "Macau", "Northern Mariana Islands", "Martinique",
            "Mauritania", "Montserrat", "Malta", "Mauritius", "Maldives", "Malawi", "Mexico", "Malaysia", "Mozambique", "Namibia", "New Caledonia", "Niger", "Norfolk Island",
            "Nigeria", "Nicaragua", "Netherlands", "Norway", "Nepal", "Nauru", "Niue", "New Zealand", "Oman", "Panama", "Peru", "French Polynesia", "Papua New Guinea",
            "Philippines", "Pakistan", "Poland", "Saint Pierre and Miquelon", "Pitcairn Islands", "Puerto Rico", "Palestinian Territory", "Portugal", "Palau", "Paraguay",
            "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saudi Arabia", "Solomon Islands", "Seychelles", "Sudan", "Sweden", "Singapore", "Saint Helena",
            "Slovenia", "Svalbard and Jan Mayen", "Slovakia", "Sierra Leone", "San Marino", "Senegal", "Somalia", "Suriname", "Sao Tome and Principe", "El Salvador",
            "Syrian Arab Republic", "Swaziland", "Turks and Caicos Islands", "Chad", "French Southern Territories", "Togo", "Thailand", "Tajikistan", "Tokelau",
            "Turkmenistan", "Tunisia", "Tonga", "Timor-Leste", "Turkey", "Trinidad and Tobago", "Tuvalu", "Taiwan", "Tanzania, United Republic of", "Ukraine", "Uganda",
            "United States Minor Outlying Islands", "United States", "Uruguay", "Uzbekistan", "Holy See (Vatican City State)", "Saint Vincent and the Grenadines",
            "Venezuela", "Virgin Islands, British", "Virgin Islands, U.S.", "Vietnam", "Vanuatu", "Wallis and Futuna", "Samoa", "Yemen", "Mayotte", "Serbia", "South Africa",
            "Zambia", "Montenegro", "Zimbabwe", "Anonymous Proxy", "Satellite Provider", "Other", "Aland Islands", "Guernsey", "Isle of Man", "Jersey", "Saint Barthelemy",
            "Saint Martin" };

    public LookupService() throws IOException {
    }

    public LookupService(String databaseFile, int options) throws IOException {
        this(new File(databaseFile), options);
    }

    public LookupService(File databaseFile, int options) throws IOException {
        this.file = new RandomAccessFile(databaseFile, "r");
    }

    public void close() {
        try {
            if (file != null)
                file.close();
            file = null;
        } catch (Exception e) {
        }
    }

    public Country getCountry(String ipAddress) {
        InetAddress addr;
        try {
            addr = InetAddress.getByName(ipAddress);
        } catch (UnknownHostException e) {
            return UNKNOWN_COUNTRY;
        }
        return getCountry(bytesToLong(addr.getAddress()));
    }

    public synchronized Country getCountry(InetAddress ipAddress) {
        return getCountry(bytesToLong(ipAddress.getAddress()));
    }

    public Country getCountry(long ipAddress) {
        int ret = seekCountry(ipAddress) - COUNTRY_BEGIN;
        if (ret == 0)
            return UNKNOWN_COUNTRY;
        else
            return new Country(countryCode[ret], countryName[ret]);
    }

    private synchronized int seekCountry(long ipAddress) {
        byte[] buf = new byte[2 * MAX_RECORD_LENGTH];
        int[] x = new int[2];
        int offset = 0;
        for (int depth = 31; depth >= 0; depth--) {
            try {
                file.seek(2 * STANDARD_RECORD_LENGTH * offset);
                file.readFully(buf);
            } catch (IOException e) {
                System.out.println("IO Exception");
            }
            for (int i = 0; i < 2; i++) {
                x[i] = 0;
                for (int j = 0; j < STANDARD_RECORD_LENGTH; j++) {
                    int y = buf[i * STANDARD_RECORD_LENGTH + j];
                    if (y < 0)
                        y += 256;
                    x[i] += y << j * 8;
                }
            }
            if ((ipAddress & 1 << depth) > 0) {
                if (x[1] >= COUNTRY_BEGIN) {
                    last_netmask = 32 - depth;
                    return x[1];
                }
                offset = x[1];
            } else {
                if (x[0] >= COUNTRY_BEGIN) {
                    last_netmask = 32 - depth;
                    return x[0];
                }
                offset = x[0];
            }
        }
        // shouldn't reach here
        System.err.println("Error seeking country while seeking " + ipAddress);
        return 0;
    }

    private static long bytesToLong(byte[] address) {
        long ipnum = 0;
        for (int i = 0; i < 4; ++i) {
            long y = address[i];
            if (y < 0)
                y += 256;
            ipnum += y << (3 - i) * 8;
        }
        return ipnum;
    }

    public static void main(String[] args) {
        String sep = System.getProperty("file.separator");
        String path = System.getProperty("java.home") + sep + "setup" + sep + "sale" + sep;
        args = new String[4];
        args[0] = "190.42.58.186";// "190.42.59.247";//"190.42.60.54";//"190.12.81.45";
        try {
            String dbfile1 = path + "GeoIP.dat";
            // String dbfile2 = path+"GeoLiteCity.dat";
            LookupService cl = new LookupService(dbfile1, LookupService.GEOIP_STANDARD);
            // LookupService cl2 = new LookupService(dbfile2,LookupService.GEOIP_MEMORY_CACHE);
            System.out.println(cl.getCountry(args[0]).getCountryId());
            System.out.println(cl.getCountry(args[0]).getCountryName());
            System.out.println(cl.getCountry("190.12.81.45").getCountryId());
            System.out.println(cl.getCountry("190.12.81.45").getCountryName());
            System.out.println(cl.getCountry("151.38.39.114").getCountryId());
            System.out.println(cl.getCountry("151.38.39.114").getCountryName());
            System.out.println(cl.getCountry("12.25.205.51").getCountryId());
            System.out.println(cl.getCountry("12.25.205.51").getCountryName());
            System.out.println(cl.getCountry("64.81.104.131").getCountryId());
            System.out.println(cl.getCountry("64.81.104.131").getCountryName());
            System.out.println(cl.getCountry("200.21.225.82").getCountryId());
            System.out.println(cl.getCountry("200.21.225.82").getCountryName());
            // Location l2 = cl2.getLocation(args[0]);
            // Location l2 = cl1.getLocation(args[0]);
            // System.out.println("countryCode: " + l2.countryCode);
            // System.out.println("countryName: " + l2.countryName);
            cl.close();
            // cl2.close();
        } catch (IOException e) {
            System.out.println("IO Exception: " + e);
        }
    }
}
