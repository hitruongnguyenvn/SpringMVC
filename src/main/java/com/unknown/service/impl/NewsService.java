package com.unknown.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unknown.dao.INewsDAO;
import com.unknown.model.News;
import com.unknown.paging.IPageable;
import com.unknown.service.INewsService;

@Service
public class NewsService implements INewsService {

	@Autowired
	private INewsDAO newsDAO;

	@Override
	public List<News> findAll(IPageable pageable) {
		return newsDAO.findAll(pageable);
	}

	@Override
	public Integer getTotalItem() {
		return newsDAO.getTotalItem();
	}

}
