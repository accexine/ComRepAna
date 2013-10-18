package main.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class ConnectionMySQL {
	public String drivename;
	public String url;
	public String user;
	public String password;
	
	public void getConfig(File file) throws DocumentException{
		SAXReader reader = new SAXReader();
		Document  document = reader.read(file);
		Element root = document.getRootElement();
		Element memberElm=root.element("database");
		
		this.drivename = memberElm.elementText("drivename").trim();
		this.url = memberElm.elementText("url").trim();
		this.user = memberElm.elementText("user").trim();
		this.password = memberElm.elementText("password").trim();
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException, DocumentException{
		if(this.drivename == null){
			File file = new File("config.xml");
			getConfig(file);
		}
		Class.forName(this.drivename);
		Connection conn = DriverManager.getConnection(url,user,password);
		return conn;
	}
	
	public void closeConnection(Connection con) throws SQLException{
		con.close();
	}
}
