package com.firm.project.sakilarestdemo.backend.utility;

import org.springframework.stereotype.Component;

import com.firm.project.sakilarestdemo.backend.filter.PaginatorFilterBean;

@Component
public class MyBatisUtility {
	
	public PaginatorFilterBean buildPaginationFilter(Integer page, Integer itemPerPage) {
		Integer offset = (page-1) * itemPerPage;
		PaginatorFilterBean filterBean = new PaginatorFilterBean();
		filterBean.setOffSet(offset);
		filterBean.setItemPerPage(itemPerPage);
		return filterBean;	
	}

}
