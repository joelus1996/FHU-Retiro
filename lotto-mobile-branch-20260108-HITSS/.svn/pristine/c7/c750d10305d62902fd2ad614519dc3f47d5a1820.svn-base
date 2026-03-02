package pe.com.intralot.loto.layer.controller.security.bo;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;

import pe.com.intralot.loto.layer.model.pojo.ImgDto;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetNovusId;
import pe.com.intralot.loto.layer.model.pojo.Client;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureActivatePromotion;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureCancelPromotion;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureActivatePromotionibk;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureActivateWBPromotion;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureActivateWBPromotionibk;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureCancelPromotionibk;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetPasswordCode;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureLPTokenGeneration;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedurePutSmsRegisterData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureResetNewPassword;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureTANTokenGeneration;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureTokenGeneration;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureTokenValidation;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateBonoQr;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateNovusId;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdatePhone;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdatePlayerId;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateSmsRegister;

/**
 * <p>
 * NOMBRE: SecurityLoginBo.java
 * <br></p>
 * <p>
 * FUNCION: Objeto de lógica de negocio del inicio de sesión
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 002   Cristian Cortez  25/06/2018  Métodos para la activación y rechazo del bono de TA por recargas Interbank
 * 001   Joel Ramirez     06/10/2010  First comment
 * </pre>
 * <br></p>
 */

public interface SecurityLoginBo {	
	
	public Client validaLogin(Object params[]) throws Exception;
	
	public HashMap[] updateAgreement(Integer p_clientId) throws Exception;
	
	public HashMap[] getPasswordCode(String mail, String password_code) throws Exception;
	
	public HashMap[] resetNewPassword(String mail, String password_code, String password1, String password2) throws Exception;
	
	public String clientSendMail(String email, String name, String code, int option, String user,String game);
	
	public String fintUserByMail(String mail, String password_code) throws Exception;
	
	public String clientSendUserMail(String email);
	
	public ClientProcedureGetPasswordCode findGetPasswordCode(String p_mail, String p_password_code) throws Exception;
	
	public ClientProcedureResetNewPassword resetPassword(String p_mail, String p_password_code, String p_password_1, String p_password_2) throws Exception;

	public ClientProcedureTokenGeneration getToken(Integer p_clientid, String channel, String ip) throws Exception;
	
	public ClientProcedureLPTokenGeneration getLPToken(Integer p_clientid, String ip) throws Exception;
	
	public ClientProcedureTANTokenGeneration getTANToken(Integer p_clientid, String ip) throws Exception;
	
	public ClientProcedurePutSmsRegisterData putSmsRegisterData(Integer p_clientId,String p_sms) throws Exception;
    
    public ClientProcedureUpdateSmsRegister updateSmsRegister(Integer p_clientId,String p_sms, Integer p_time_minutes) throws Exception;

    public ClientProcedureUpdatePhone updatePhoneClient(Integer p_clientId, String p_phone) throws Exception;
    
    public ClientProcedureActivatePromotion activatePromotion(Object[] values) throws Exception;
    
    public ClientProcedureActivateWBPromotion activateWBPromotion(Object[] values) throws Exception;
    
    public ClientProcedureCancelPromotion cancelPromotion(Object[] values) throws Exception;
    
    public ClientProcedureActivatePromotionibk activatePromotionibk(Object[] values) throws Exception;
    
    public ClientProcedureActivateWBPromotionibk activateWBPromotionibk(Object[] values) throws Exception;
    
    public ClientProcedureCancelPromotionibk cancelPromotionibk(Object[] values) throws Exception;
    
    public ClientProcedureUpdatePlayerId updatePlayerId(Integer p_clientId, String p_playerId) throws Exception;
    
    public ClientProcedureTokenValidation getTokenValidation(String p_token, String ip) throws Exception;
	
	public String enviarMailPD(ByteArrayOutputStream bis,List<ImgDto>listImgDto,String body,String tipo_solicitud,String nombres,String apellidos,String tipoDocumento,String numeroDocumento);
	
	public String enviarMailClientePD(String body,String tipo_solicitud,String nombres,String apellidos,String tipoDocumento, String numeroDocumento,String email);
	
	public String findCodUserfilter1(String dni, String nombre) throws Exception;
	
	public String findCodUserfilter2(String dni, String correo) throws Exception;
	
	public String findCodUserfilter3(String dni, String celular) throws Exception;
	
	public ClientProcedureUpdateNovusId updateNovusId(Integer p_clientId, Long p_novusId) throws Exception;
	
	public ClientProcedureGetNovusId findGetNovusId(Integer p_clientid) throws Exception;
	
	public String getLinkRecoverPassword(String email, String name, String code, int option, String user,String game);
	
	public ClientProcedureUpdateBonoQr updateBonoQr(Integer p_clientId, String p_bonoQr) throws Exception;
	
	String requestWSIflexApiRecharge(String json, String service);
}