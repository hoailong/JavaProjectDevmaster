package com.devmaster.restaurantmanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.devmaster.restaurantmanagement.model.TableModel;

public class TableMapper implements RowMapper<TableModel>{

	@Override
	public TableModel mapRow(ResultSet resultSet) {
		try {
			TableModel table = new TableModel();
			table.setTableId(resultSet.getInt("TableId"));
			table.setName(resultSet.getString("TableName"));
			table.setMaxPeople(resultSet.getInt("Maxpeople"));
			table.setStatus(resultSet.getInt("Status"));
			return table;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
