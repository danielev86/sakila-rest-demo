package com.firm.project.sakilarestdemo.backend.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.firm.project.sakilarestdemo.backend.IFilmDAO;
import com.firm.project.sakilarestdemo.backend.filter.FilmFilterBean;
import com.firm.project.sakilarestdemo.backend.model.Film;

@Repository
public class FilmDAOImpl implements IFilmDAO  {
	
	private static final Logger logger = Logger.getLogger(FilmDAOImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	/* (non-Javadoc)
	 * @see com.firm.project.sakilarestdemo.backend.impl.IFilmDAO#findMoviesByCategoryAndActor(com.firm.project.sakilarestdemo.backend.filter.FilmFilterBean)
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public List<Film> findMoviesByCategoryAndActor(FilmFilterBean filterBean){
		logger.info("Retrieving info from table FILM with filter lastname: "+filterBean.getLastName()+ " category_id:"+filterBean.getCategoryId());
		List<Film> lstResult = sqlSession.selectList("mybatis.mapper.FilmMapper.findMoviesByCategoryAndActor", filterBean);
		return lstResult;
	}

}
