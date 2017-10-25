package com.newlecture.webapp.dao;

import com.newlecture.webapp.entity.Member;

public interface MemberDao {
	int insert(String id, String string, String name, String phone, String email);
	Member get(String id);
	int insert(Member member);
	int pointUp(String id);
}
