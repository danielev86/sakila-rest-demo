package com.firm.project.sakilarestdemo.backend.filter;

import java.io.Serializable;

public class PaginatorFilterBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer offSet;
	
	private Integer itemPerPage;

	public Integer getOffSet() {
		return offSet;
	}

	public void setOffSet(Integer offSet) {
		this.offSet = offSet;
	}

	public Integer getItemPerPage() {
		return itemPerPage;
	}

	public void setItemPerPage(Integer itemPerPage) {
		this.itemPerPage = itemPerPage;
	}
}
