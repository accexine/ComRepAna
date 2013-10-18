package test.dao;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.SQLException;

import main.dao.ConnectionMySQL;

import org.dom4j.DocumentException;
import org.junit.Test;

public class ConnectionMySQLTest {

	@Test
	public void testGetConfig() throws DocumentException {
		ConnectionMySQL connection = new ConnectionMySQL();
		File file = new File("config.xml");
		connection.getConfig(file);
		assertNotNull(connection.drivename);
		assertNotNull(connection.url);
		assertNotNull(connection.user);
		assertNotNull(connection.password);
	}

	
	@Test
	public void testGetConnection() throws ClassNotFoundException, SQLException, DocumentException{
		ConnectionMySQL connection = new ConnectionMySQL();
		assertNotNull(connection.getConnection());
	}
}
