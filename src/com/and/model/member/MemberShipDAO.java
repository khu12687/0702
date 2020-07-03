package com.and.model.member;

import org.apache.ibatis.session.SqlSession;

import com.and.mybatis.MybatisConfigManager;

public class MemberShipDAO {
	MybatisConfigManager manager = MybatisConfigManager.getInstance();
	
	public MemberShip loginCheck(MemberShip membership) {
		MemberShip ms = null;
		SqlSession sqlSession = manager.getSqlSession();
		ms = sqlSession.selectOne("MemberShip.loginCheck",membership);
		manager.closeSession(sqlSession);
		return ms;
	}
}
