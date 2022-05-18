package com.unknown.service;

import java.util.List;

import com.unknown.model.News;
import com.unknown.paging.IPageable;

public interface INewsService {
	public List<News> findAll(IPageable pageable);
	public Integer getTotalItem();
}
