package com.devmaster.restaurantmanagement.dao.impl;

import java.util.List;

import com.devmaster.restaurantmanagement.dao.ITableDAO;
import com.devmaster.restaurantmanagement.mapper.TableMapper;
import com.devmaster.restaurantmanagement.model.TableModel;

public class TableDAO extends AbstractDAO<TableModel> implements ITableDAO {

	@Override
	public List<TableModel> findAll() {
		String sql = "Select * from tblTable";
		List<TableModel> list = query(sql, new TableMapper());
		return list;
	}

}
