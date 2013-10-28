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
	public static String drivename;
	public static String url;
	public static String user;
	public static String password;
	
	public static Connection con;
	
	public static void getConfig(File file) throws DocumentException{
		SAXReader reader = new SAXReader();
		Document  document = reader.read(file);
		Element root = document.getRootElement();
		Element memberElm=root.element("database");
		
		drivename = memberElm.elementText("drivename").trim();
		url = memberElm.elementText("url").trim();
		user = memberElm.elementText("user").trim();
		password = memberElm.elementText("password").trim();
	}
	
	public static Connection getConnection(){
		if(con != null) {
			return con;
		}
		if(drivename == null){
			File file = new File("config.xml");
			try {
				getConfig(file);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Class.forName(drivename);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeConnection(Connection con) throws SQLException{
		con.close();
	}
}
