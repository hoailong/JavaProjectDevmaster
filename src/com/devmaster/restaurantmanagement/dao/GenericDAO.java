package com.devmaster.restaurantmanagement.dao;

import java.util.List;

import com.devmaster.restaurantmanagement.mapper.RowMapper;

public interface GenericDAO<T> {
/*	Object queryOne(String sql, RowMapper<T> rowMapper ,Object ... parameters);*/
	<T> List<T> query(String sql, RowMapper<T> rowMapper ,Object ... parameters);
	void udl(String sql, Object ...parameters);
}
