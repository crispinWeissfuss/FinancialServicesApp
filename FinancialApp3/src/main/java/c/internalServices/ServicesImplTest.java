package c.internalServices;

import java.sql.SQLException;
import java.text.ParseException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ServicesImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAuthentificateUser() throws ClassNotFoundException, SQLException {
		ServicesImpl services = new ServicesImpl();
		
		System.out.println(services.authentificateUser("jon", "snow").toString());

	}
	
	@Test
	public void getCountryServiceProposal() throws ClassNotFoundException, SQLException, ParseException {
		ServicesImpl services = new ServicesImpl();
		
		System.out.println(services.getCountryServiceProposal("DE", 3, "01.01.2014", "01.01.2015").toString());

	}
	

}
