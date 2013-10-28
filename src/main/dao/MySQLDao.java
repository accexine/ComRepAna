package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLDao {

	public static Connection con = ConnectionMySQL.getConnection();
	
	/**
	 * 更新评论或转发的支持度得分
	 * @param table
	 * @param id
	 * @param score
	 * @throws SQLException
	 */
	public static void updateScore(String table,String id,double score) throws SQLException{
		String sql = "update "+table+" set score = "+score+" where id="+id;
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.execute();
	}
}
