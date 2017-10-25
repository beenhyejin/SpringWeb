package com.newlecture.webapp.dao.mybatis;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.webapp.dao.NoticeDao;
import com.newlecture.webapp.entity.Notice;
import com.newlecture.webapp.entity.NoticeView;

public class MyBatisNoticeDao implements NoticeDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<NoticeView> getList(int page,String field ,String query) {
		NoticeDao noticeDao =sqlSession.getMapper(NoticeDao.class);
		List<NoticeView> list = noticeDao.getList(page,field,query);
		return list;
	}

	@Override
	public int getCount() {
		return 0;
	}

	@Override
	public NoticeView get(String id) {
		NoticeDao noticeDao =sqlSession.getMapper(NoticeDao.class);
		NoticeView noticeView = noticeDao.get(id);
		return noticeView;
	}

	@Override
	public int update(String id, String title, String content) {
		return 0;
	}

	

	@Override
	public NoticeView getPrev(String id) {
		NoticeDao noticeDao =sqlSession.getMapper(NoticeDao.class);
		NoticeView list = noticeDao.getPrev(id);
		return list;
	}

	@Override
	public NoticeView getNext(String id) {
		NoticeDao noticeDao =sqlSession.getMapper(NoticeDao.class);
		NoticeView list = noticeDao.getNext(id);
		return list;
	}

	@Override
	   public int insert(String title, String content, String writerId) {
	      return insert(new Notice(title, content, writerId));
	   }
	
	@Override
	public int insert(Notice notice) {
		NoticeDao noticeDao =sqlSession.getMapper(NoticeDao.class);
		int row = noticeDao.insert(notice);
		return row;
	}

	@Override
	public String getNextId() {
		NoticeDao noticeDao =sqlSession.getMapper(NoticeDao.class);
		return noticeDao.getNextId();
	}

}
