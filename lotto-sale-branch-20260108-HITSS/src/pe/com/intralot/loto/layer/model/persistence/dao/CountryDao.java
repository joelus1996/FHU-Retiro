package pe.com.intralot.loto.layer.model.persistence.dao;

import java.util.List;

import pe.com.intralot.loto.layer.model.domain.Country;

/**
 * @author:   Zolanch Tavara Sandon
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */

public interface CountryDao {
	
	public List<Country> findCountry() throws Exception; 

}
