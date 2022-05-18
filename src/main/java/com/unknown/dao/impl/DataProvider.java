package com.unknown.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.unknown.mapper.IRowMapper;

public class DataProvider {

	private static String URL = "jdbc:sqlserver://DESKTOP-UNF4A4J\\SQLEXPRESS:1433;databaseName=News;user=sa;password=123456";
	private static DataProvider instance;
	private static Connection connect;
	private static PreparedStatement pstmt;
	private static ResultSet dataResult;

	public DataProvider() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			DataProvider.connect = null;
			DataProvider.pstmt = null;
			DataProvider.dataResult = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DataProvider getInstance() {
		if (DataProvider.instance == null) {
			DataProvider.instance = new DataProvider();
		}
		return DataProvider.instance;
	}

	public <T> List<T> executeQuery(String query, IRowMapper<T> rowMapper, Object[] parameter) {
		List<T> convertResult = new ArrayList<T>();
		try {
			DataProvider.connect = DriverManager.getConnection(DataProvider.URL);
			DataProvider.pstmt = DataProvider.connect.prepareStatement(query);
			if (parameter != null) {
				int length = parameter.length;
				for (int i = 0; i < length; ++i) {
					DataProvider.pstmt.setObject(i + 1, parameter[i]);
				}
			}
			DataProvider.dataResult = DataProvider.pstmt.executeQuery();
			while (DataProvider.dataResult.next()) {
				T object = rowMapper.mapRow(DataProvider.dataResult);
				convertResult.add(object);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (DataProvider.dataResult != null) {
					DataProvider.dataResult.close();
				}
				if (DataProvider.pstmt != null) {
					DataProvider.pstmt.close();
				}
				if (DataProvider.connect != null) {
					DataProvider.connect.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return convertResult;
	}

	public Integer executeNonQuery(String query, Object[] parameter) {
		Integer data = null;
		try {
			DataProvider.connect = DriverManager.getConnection(DataProvider.URL);
			connect.setAutoCommit(false);
			DataProvider.pstmt = DataProvider.connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			if (parameter != null) {
				int length = parameter.length;
				for (int i = 0; i < length; ++i) {
					DataProvider.pstmt.setObject(i + 1, parameter[i]);
				}
			}
			DataProvider.pstmt.executeUpdate();
			DataProvider.dataResult = DataProvider.pstmt.getGeneratedKeys();
			if (DataProvider.dataResult.next()) {
				data = DataProvider.dataResult.getInt(1);
			}
			DataProvider.connect.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if (DataProvider.connect != null) {
				try {
					DataProvider.connect.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (DataProvider.dataResult != null) {
					DataProvider.dataResult.close();
				}
				if (DataProvider.pstmt != null) {
					DataProvider.pstmt.close();
				}
				if (DataProvider.connect != null) {
					DataProvider.connect.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return data;
	}

	public Object executeScalar(String query, Object[] parameter) {
		Object data = null;
		try {
			DataProvider.connect = DriverManager.getConnection(URL);
			DataProvider.pstmt = DataProvider.connect.prepareStatement(query);
			if (parameter != null) {
				int length = parameter.length;
				for (int i = 0; i < length; ++i) {
					DataProvider.pstmt.setObject(i + 1, parameter[i]);
				}
			}
			data = DataProvider.pstmt.executeQuery().next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dataResult != null) {
					DataProvider.dataResult.close();
				}
				if (pstmt != null) {
					DataProvider.pstmt.close();
				}
				if (connect != null) {
					DataProvider.connect.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}

	public int count(String query, Object[] parameter) {
		int data = 0;
		try {
			DataProvider.connect = DriverManager.getConnection(URL);
			DataProvider.pstmt = DataProvider.connect.prepareStatement(query);
			if (parameter != null) {
				int length = parameter.length;
				for (int i = 0; i < length; ++i) {
					pstmt.setObject(i + 1, parameter[i]);
				}
			}
			DataProvider.dataResult = DataProvider.pstmt.executeQuery();
			if (DataProvider.dataResult.next()) {
				data = DataProvider.dataResult.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dataResult != null) {
					DataProvider.dataResult.close();
				}
				if (pstmt != null) {
					DataProvider.pstmt.close();
				}
				if (connect != null) {
					DataProvider.connect.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
}
