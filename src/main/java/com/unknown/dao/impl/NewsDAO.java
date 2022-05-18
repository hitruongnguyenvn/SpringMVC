package com.unknown.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.unknown.dao.INewsDAO;
import com.unknown.mapper.NewsMapper;
import com.unknown.model.News;
import com.unknown.paging.IPageable;

@Repository
public class NewsDAO implements INewsDAO {

	@Override
	public List<News> findAll(IPageable pageable) {
		StringBuilder sql = new StringBuilder("SELECT * FROM News ORDER BY ");
		String sortName = null;
		String sortBy = null;
		if (pageable.getSort() == null) {
			sortName = "id";
			sortBy = "ASC";
		} else {
			sortName = pageable.getSort().getSortName();
			sortBy = pageable.getSort().getSortBy();
		}
		sql.append(sortName + " " + sortBy);
		if (pageable.getPage() != null) {
			sql.append(" OFFSET " + pageable.getOffset() + " ROWS FETCH NEXT " + pageable.getFetchNextRows());
			sql.append(" ROWS ONLY");
		}
		return DataProvider.getInstance().executeQuery(sql.toString(), new NewsMapper(), null);
	}

	@Override
	public Integer getTotalItem() {
		String sql = "SELECT COUNT(*) FROM News";
		return DataProvider.getInstance().count(sql, null);
	}

}
