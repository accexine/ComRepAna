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
		File file = new File("config.xml");
		ConnectionMySQL.getConfig(file);
		assertNotNull(ConnectionMySQL.drivename);
		assertNotNull(ConnectionMySQL.url);
		assertNotNull(ConnectionMySQL.user);
		assertNotNull(ConnectionMySQL.password);
	}

	
	@Test
	public void testGetConnection() throws ClassNotFoundException, SQLException, DocumentException{
		assertNotNull(ConnectionMySQL.getConnection());
	}
}
