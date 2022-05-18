package com.unknown.dao;

import java.util.List;

import com.unknown.model.News;
import com.unknown.paging.IPageable;

public interface INewsDAO {
	List<News> findAll(IPageable pageable);
	public Integer getTotalItem();
}
