package pe.com.intralot.loto.layer.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import pe.com.intralot.loto.layer.model.domain.Client;
import pe.com.intralot.loto.layer.service.client.bo.ClientBo;

public class ClientTest extends AbstractBaseUnitTest {

	@Autowired
	private ClientBo clientBo;

	@Test
	public void findByIdClient() throws Exception {

		Client client = clientBo.findByIdClient(8);
		System.out.println(client.getUser());
		//System.out.println(client.getPassword());
	}

	@Test
	public void findByUser() throws Exception {

		Client client = clientBo.findByUser("test01");
		System.out.println(client.getMail());

	}

	@Test
	public void findByUserByPassword() throws Exception {

		Client client = clientBo.findByUserByPassword("test01", "iOdHhIKvS1I=");
		System.out.println(client.getMail());

	}
	

}
