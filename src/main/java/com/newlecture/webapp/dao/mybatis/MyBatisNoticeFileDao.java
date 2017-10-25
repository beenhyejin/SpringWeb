package com.newlecture.webapp.dao.mybatis;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.webapp.dao.NoticeFileDao;
import com.newlecture.webapp.entity.NoticeFile;


public class MyBatisNoticeFileDao implements NoticeFileDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<NoticeFile> getListByNoticeId(String noticeId) {
		NoticeFileDao noticeFileDao =sqlSession.getMapper(NoticeFileDao.class);
		List<NoticeFile> list = noticeFileDao.getListByNoticeId(noticeId);
		return list;
	}

	@Override
	public int insert(NoticeFile noticeFile) {
		NoticeFileDao noticeFileDao =sqlSession.getMapper(NoticeFileDao.class);
		int row = noticeFileDao.insert(noticeFile);
		return row;
	}

	@Override
	public int update(NoticeFile noticeFile) {
		NoticeFileDao noticeFileDao =sqlSession.getMapper(NoticeFileDao.class);
		int row = noticeFileDao.update(noticeFile);
		return row;
	}

	@Override
	public int delete(String id) {
		NoticeFileDao noticeFileDao =sqlSession.getMapper(NoticeFileDao.class);
		int row = noticeFileDao.delete(id);
		return row;
	}

}
