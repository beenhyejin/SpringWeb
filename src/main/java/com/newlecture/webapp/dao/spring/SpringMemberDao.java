package com.newlecture.webapp.dao.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.newlecture.webapp.dao.MemberDao;
import com.newlecture.webapp.entity.Member;

public class SpringMemberDao implements MemberDao {
	
	@Autowired
	private JdbcTemplate template;

	@Override
	public int insert(String id, String string, String name, String phone, String email) {
		return 0;
	}
	@Override
	public Member get(String id) {
		return null;
	}
	@Override
	public int insert(Member member) {
		return 0;
	}
	@Override
	public int pointUp(String id) {
		String sql = "update Member set point=point+1 where id =?";
		int result = template.update(sql,id);
		return result;
	}
}
