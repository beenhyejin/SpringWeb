package com.newlecture.webapp.entity;
   
import java.util.Date;

public class Notice {
	private String id;
	private String title;
	private String content;
	private String writerId;
	private Date regDate;
	private int hit;

	public Notice() {

	}

	public Notice(String id, String title, String content, Date regDate, int hit) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.hit = hit;
	}

	public Notice(String title, String content, String writerId) {
		this.title = title;
		this.content = content;
		this.writerId = writerId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

}