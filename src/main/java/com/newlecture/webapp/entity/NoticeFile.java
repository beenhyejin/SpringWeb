package com.newlecture.webapp.entity;

public class NoticeFile {
	private String id;
	private String src;
	private String noticeId;
	
	

	public NoticeFile(String id, String src, String noticeId) {
		this.id = id;
		this.src = src;
		this.noticeId = noticeId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}
	

}
