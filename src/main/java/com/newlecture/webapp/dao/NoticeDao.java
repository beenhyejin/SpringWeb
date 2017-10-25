package com.newlecture.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.newlecture.webapp.entity.Notice;
import com.newlecture.webapp.entity.NoticeView;

public interface NoticeDao {
	List<NoticeView> getList(@Param("page") int page,String field, String query);//@쓰는건 추천하지 않아
	
	int getCount();
	
	//@Select("select * from NoticeView where id=#{id}")
	NoticeView get(String id);
	
	int update(String id, String title, String content);

	int insert(String title, String content, String writerId);

	int insert(Notice notice);

	NoticeView getPrev(String id);

	NoticeView getNext(String id);

	String getNextId();

}
