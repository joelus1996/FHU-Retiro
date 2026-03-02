package pe.com.intralot.loto.layer.service.client.bo;

/**
 * @author:   Zolanch Tavara Sandon
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */

import pe.com.intralot.loto.layer.model.domain.ClientBalance;

public interface ClientBalanceBo {
		
	public ClientBalance findByIdClient(Integer idClient) throws Exception;
	
}