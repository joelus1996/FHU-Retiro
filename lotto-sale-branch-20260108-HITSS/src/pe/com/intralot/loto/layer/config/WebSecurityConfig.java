package pe.com.intralot.loto.layer.config;

import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("init spring csrf");
		http.csrf().requireCsrfProtectionMatcher(new CSRFRequestMatcher()).and()
		.authorizeRequests().anyRequest().permitAll().and()
		.headers().frameOptions().disable();
	}
	
	private static class CSRFRequestMatcher implements RequestMatcher {
		//pago de premios
		private final RegexRequestMatcher protectedApiSendMailTicketsPP = new RegexRequestMatcher("/sendMailTicketsPP.html", "POST");
		private final RegexRequestMatcher protectedApiFilterHisPayment = new RegexRequestMatcher("/filterHisPayment.html", "POST");
		private final RegexRequestMatcher protectedApiGetDataCollectPrizes = new RegexRequestMatcher("/getDataCollectPrizes.html", "POST");
		private final RegexRequestMatcher protectedApiGetResultKyc = new RegexRequestMatcher("/getResultKyc.html", "POST");
		private final RegexRequestMatcher protectedApiGetTicketsPrizes = new RegexRequestMatcher("/getTicketsPrizes.html", "POST");
		private final RegexRequestMatcher protectedApiGetTicketsPrizesOld = new RegexRequestMatcher("/getTicketsPrizesOld.html", "POST");
		private final RegexRequestMatcher protectedApiGetHisPayment = new RegexRequestMatcher("/getHisPayment.html", "POST");
		private final RegexRequestMatcher protectedApiGetTokenizedCard = new RegexRequestMatcher("/getTokenizedCard.html", "POST");
		private final RegexRequestMatcher protectedApiGetTokenizedCardAgora = new RegexRequestMatcher("/getTokenizedCardAgora.html", "POST");
		private final RegexRequestMatcher protectedApiDeleteTokenizedCard = new RegexRequestMatcher("/deleteTokenizedCard.html", "POST");
		private final RegexRequestMatcher protectedApiDeleteTokenizedCardAgora = new RegexRequestMatcher("/deleteTokenizedCardAgora.html", "POST");
		private final RegexRequestMatcher protectedApiCreateRequest = new RegexRequestMatcher("/createRequest.html", "POST");
		private final RegexRequestMatcher protectedApiCreateRequestVisa = new RegexRequestMatcher("/createRequestVisa.html", "POST");
		private final RegexRequestMatcher protectedApiCreateRequestAgora = new RegexRequestMatcher("/createRequestAgora.html", "POST");
		private final RegexRequestMatcher protectedApiCreateRequestTransferencia = new RegexRequestMatcher("/createRequestTransferencia.html", "POST");
		private final RegexRequestMatcher protectedApiEliminarCuentaTransferencia = new RegexRequestMatcher("/eliminarCuentaTransferencia.html", "POST");
		private final RegexRequestMatcher protectedApiDownloadTicketsPP = new RegexRequestMatcher("/downloadTicketsPP.html", "POST");
		private final RegexRequestMatcher protectedApiCreateSessionTokenizationCard = new RegexRequestMatcher("/createSessionTokenizationCard.html", "POST");
		
		private final RegexRequestMatcher protectedApiSendMailTicketsPPDebitIdQR = new RegexRequestMatcher("/sendMailTicketsPPDebitIdQR.html", "POST");
		private final RegexRequestMatcher protectedApiDownloadTicketsPPDebitIdQR = new RegexRequestMatcher("/downloadTicketsPPDebitIdQR.html", "POST");
		private final RegexRequestMatcher protectedApiGetTicketsPrizesDebitIdQR = new RegexRequestMatcher("/getTicketsPrizesDebitIdQR.html", "POST");

		private final Pattern allowedMethods = Pattern
				.compile("^(GET)$");

		public boolean matches(HttpServletRequest request) {
			return (protectedApiSendMailTicketsPP.matches(request) || 
					protectedApiFilterHisPayment.matches(request) ||
					protectedApiGetDataCollectPrizes.matches(request) ||
					protectedApiGetResultKyc.matches(request) ||
					protectedApiGetTicketsPrizes.matches(request) ||
					protectedApiGetTicketsPrizesOld.matches(request) ||
					protectedApiGetHisPayment.matches(request) ||
					protectedApiGetTokenizedCard.matches(request) ||
					protectedApiGetTokenizedCardAgora.matches(request) ||
					protectedApiDeleteTokenizedCard.matches(request) ||
					protectedApiDeleteTokenizedCardAgora.matches(request) ||
					protectedApiCreateRequest.matches(request) ||
					protectedApiCreateRequestVisa.matches(request) ||
					protectedApiCreateRequestAgora.matches(request) ||
					protectedApiCreateRequestTransferencia.matches(request) ||
					protectedApiEliminarCuentaTransferencia.matches(request) ||
					protectedApiDownloadTicketsPP.matches(request) ||
					protectedApiSendMailTicketsPPDebitIdQR.matches(request) ||
					protectedApiDownloadTicketsPPDebitIdQR.matches(request) ||
					protectedApiGetTicketsPrizesDebitIdQR.matches(request) ||
					protectedApiCreateSessionTokenizationCard.matches(request)) && 
					!allowedMethods.matcher(request.getMethod()).matches();
		}
	}

}
