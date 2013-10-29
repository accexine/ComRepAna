package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.model.Comment;
import main.model.Repost;
import main.model.Status;
import main.model.User;

public class GetData {
	public static Connection con = ConnectionMySQL.getConnection();
	
	/**
	 * 由mid返回评论列表
	 * @param mid
	 * @return
	 * @throws SQLException
	 */
	public static List<Comment> getComments(String mid) throws SQLException{
		List<Comment> comments = new ArrayList<Comment>();
		String sql = "select * from comments where mid="+mid;
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Comment comment = new Comment();
			comment.setId(rs.getString("id"));
			comment.setMid(rs.getString("mid"));
			comment.setUid(rs.getString("uid"));
			comment.setText(rs.getString("text"));
			comment.setSource(rs.getString("source"));
			comment.setReply_comment(rs.getString("reply_comment"));
			comment.setCreated_at(rs.getTimestamp("created_at"));
			comment.setScore(rs.getDouble("score"));
			comments.add(comment);
		}
		return comments;
	}
	/**
	 * 由mid返回转发列表 
	 * @param mid
	 * @return
	 * @throws SQLException
	 */
	public static List<Repost> getReposts(String mid) throws SQLException{
		List<Repost> reposts = new ArrayList<Repost>();
		String sql = "select * from reposts where mid="+mid;
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Repost repost = new Repost();
			repost.setId(rs.getString("id"));
			repost.setMid(rs.getString("mid"));
			repost.setUid(rs.getString("uid"));
			repost.setText(rs.getString("text"));
			repost.setSource(rs.getString("source"));
			repost.setRetweeted_status_mid(rs.getString("retweeted_status_mid"));
			repost.setRetweeted_status_uid(rs.getString("retweeted_status_uid"));
			repost.setPic_urls(rs.getString("pic_urls"));
			repost.setReposts_count(rs.getInt("reposts_count"));
			repost.setComments_count(rs.getInt("comments_count"));
			repost.setCreated_at(rs.getTimestamp("created_at"));
			repost.setFavorited(rs.getString("favorited"));
			repost.setTruncated(rs.getString("truncated"));
			repost.setAttitudes_count(rs.getInt("attitudes_count"));
			repost.setScore(rs.getDouble("score"));
			reposts.add(repost);
		}
		return reposts;
	}
	
	/**
	 * 由mid返回单条微博
	 * @param mid
	 * @return
	 * @throws SQLException
	 */
	public static Status getStatus(String mid) throws SQLException{
		String sql = "select * from status where mid="+mid;
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		Status status = new Status();
		while(rs.next()){
			status.setMid(rs.getString("mid"));
			status.setUid(rs.getString("uid"));
			status.setText(rs.getString("text"));
			status.setSource(rs.getString("source"));
			status.setRetweeted_status_mid(rs.getString("retweeted_status_mid"));
			status.setRetweeted_status_uid(rs.getString("retweeted_status_uid"));
			status.setPic_urls(rs.getString("pic_urls"));
			status.setReposts_count(rs.getInt("reposts_count"));
			status.setComments_count(rs.getInt("comments_count"));
			status.setCreated_at(rs.getTimestamp("created_at"));
			status.setFavorited(rs.getString("favorited"));
			status.setTruncated(rs.getString("truncated"));
			status.setAttitudes_count(rs.getInt("attitudes_count"));
		}
		return status;
	}
	/**
	 * 返回所有的微博
	 * @return
	 * @throws SQLException
	 */
	public static List<Status> getAllStatus() throws SQLException{
		List<Status> allStatus = new ArrayList<Status>();
		String sql = "select * from status";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Status status = new Status();
			status.setMid(rs.getString("mid"));
			status.setUid(rs.getString("uid"));
			status.setText(rs.getString("text"));
			status.setSource(rs.getString("source"));
			status.setRetweeted_status_mid(rs.getString("retweeted_status_mid"));
			status.setRetweeted_status_uid(rs.getString("retweeted_status_uid"));
			status.setPic_urls(rs.getString("pic_urls"));
			status.setReposts_count(rs.getInt("reposts_count"));
			status.setComments_count(rs.getInt("comments_count"));
			status.setCreated_at(rs.getTimestamp("created_at"));
			status.setFavorited(rs.getString("favorited"));
			status.setTruncated(rs.getString("truncated"));
			status.setAttitudes_count(rs.getInt("attitudes_count"));
			allStatus.add(status);
		}
		return allStatus;
	}
	/**
	 * 由uid返回单个用户
	 * @param uid
	 * @return
	 * @throws SQLException
	 */
	public static User getUser(String uid) throws SQLException{
		User user = new User();
		String sql = "select * from user where uid="+uid;
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			user.setUid(rs.getString("uid"));
			user.setScreen_name(rs.getString("screen_name"));
			user.setProvince(rs.getInt("provice"));
			user.setCity(rs.getInt("city"));
			user.setLocation(rs.getString("location"));
			user.setDescription(rs.getString("description"));
			user.setUrl(rs.getString("url"));
			user.setProfile_image_url(rs.getString("profile_image_url"));
			user.setGender(rs.getInt("gender"));
			user.setFollowers_count(rs.getInt("followers_count"));
			user.setFriends_count(rs.getInt("friends_count"));
			user.setStatuses_count(rs.getInt("statuses_count"));
			user.setCreated_at(rs.getTimestamp("created_at"));
			user.setVerified(rs.getInt("verified"));
			user.setVerified_reason(rs.getString("verified_reason"));
			user.setFavourites_count(rs.getInt("favourites_count"));
			user.setAllow_all_act_mas(rs.getString("allow_all_act_msg"));
			user.setAllow_all_comment(rs.getString("allow_all_comment"));
			user.setBi_followers_count(rs.getInt("bi_followers_count"));
			user.setLang(rs.getString("lang"));
			user.setFlag(rs.getInt("flag"));
		}
		
		return user;
	}
	
}
