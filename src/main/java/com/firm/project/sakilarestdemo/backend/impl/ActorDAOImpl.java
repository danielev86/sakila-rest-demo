package com.firm.project.sakilarestdemo.backend.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.firm.project.sakilarestdemo.backend.IActorDAO;
import com.firm.project.sakilarestdemo.backend.bo.ActorBO;

import java.util.List;

@Repository
public class ActorDAOImpl implements IActorDAO {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ActorBO> findAllActor(){
		List<ActorBO> lstActor = sqlSession.selectList("mybatis.mapper.ActorMapper.findAllActor");
		return lstActor;
	}

}
