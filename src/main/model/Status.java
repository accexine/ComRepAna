package main.model;

import java.sql.Timestamp;

public class Status {
	private String mid;
	private String uid;
	private String text;
	private String source;
	private String retweeted_status_mid;
	private String retweeted_status_uid;
	private String pic_urls;
	private int reposts_count;
	private int comments_count;
	private Timestamp created_at;
	private String favorited;
	private String truncated;
	private int attitudes_count;
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getRetweeted_status_mid() {
		return retweeted_status_mid;
	}
	public void setRetweeted_status_mid(String retweeted_status_mid) {
		this.retweeted_status_mid = retweeted_status_mid;
	}
	public String getRetweeted_status_uid() {
		return retweeted_status_uid;
	}
	public void setRetweeted_status_uid(String retweeted_status_uid) {
		this.retweeted_status_uid = retweeted_status_uid;
	}
	public String getPic_urls() {
		return pic_urls;
	}
	public void setPic_urls(String pic_urls) {
		this.pic_urls = pic_urls;
	}
	public int getReposts_count() {
		return reposts_count;
	}
	public void setReposts_count(int reposts_count) {
		this.reposts_count = reposts_count;
	}
	public int getComments_count() {
		return comments_count;
	}
	public void setComments_count(int comments_count) {
		this.comments_count = comments_count;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public String getFavorited() {
		return favorited;
	}
	public void setFavorited(String favorited) {
		this.favorited = favorited;
	}
	public String getTruncated() {
		return truncated;
	}
	public void setTruncated(String truncated) {
		this.truncated = truncated;
	}
	public int getAttitudes_count() {
		return attitudes_count;
	}
	public void setAttitudes_count(int attitudes_count) {
		this.attitudes_count = attitudes_count;
	}
}
