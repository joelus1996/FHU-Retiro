package pe.com.intralot.loto.layer.model.persistence.dao;

import pe.com.intralot.loto.layer.model.domain.ClientBalance;

/**
 * @author: Oscar Erick Candela Carbajal
 * @rol: Analista Programador
 * @proyecto:
 */
public interface ClientBalanceDao {

    // public List<ClientBalance> findByIdClient(Integer idClient) throws Exception;
    public ClientBalance findBy(Integer idClient) throws Exception;
}