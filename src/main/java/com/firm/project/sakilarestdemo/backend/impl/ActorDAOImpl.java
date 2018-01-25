package com.firm.project.sakilarestdemo.backend.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.firm.project.sakilarestdemo.backend.IActorDAO;
import com.firm.project.sakilarestdemo.backend.filter.PaginatorFilterBean;
import com.firm.project.sakilarestdemo.backend.model.Actor;

import java.util.List;

@Repository
public class ActorDAOImpl implements IActorDAO {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Actor> findAllActor(){
		List<Actor> lstActor = sqlSession.selectList("mybatis.mapper.ActorMapper.findAllActor");
		return lstActor;
	}
	
	public List<Actor> findAllActorPagination(PaginatorFilterBean filter){
		List<Actor> lstActor = sqlSession.selectList("mybatis.mapper.ActorMapper.findAllActorPagination", filter);
		return lstActor;
	}
	
	public List<Actor> findActorWithAllFilm(){
		List<Actor> lstActor = sqlSession.selectList("mybatis.mapper.ActorMapper.findActorWithAllFilm");
		return lstActor;
	}

}
