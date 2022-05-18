package com.unknown.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.unknown.model.News;

public class NewsMapper implements IRowMapper<News> {

	@Override
	public News mapRow(ResultSet resultSet) {
		News news = new News();
		try {
			news.setId(resultSet.getInt("id"));
			news.setIdCategory(resultSet.getInt("idCategory"));
			news.setContent(resultSet.getNString("content"));
			news.setShortDescription(resultSet.getNString("shortDescription"));
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setTitle(resultSet.getNString("title"));
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
