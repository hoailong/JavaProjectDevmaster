package com.devmaster.restaurantmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.devmaster.restaurantmanagement.dao.GenericDAO;
import com.devmaster.restaurantmanagement.mapper.RowMapper;
import com.devmaster.restaurantmanagement.util.DBUtil;

public class AbstractDAO<T> implements GenericDAO<T>{

/*	@Override
	public Object queryOne(String sql, RowMapper<T> rowMapper, Object... parameters) {
		Object result = new Object();
		Connection conn = DBUtil.getSqlConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			setParameter(pstm, parameters);
			rs = pstm.executeQuery();
			while (rs.next()) {
				result = rowMapper.mapRow(rs);
				return result;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
				try {
					if (conn != null) {
						conn.close();
					}
					if (pstm != null) {
						pstm.close();
					}
					if (rs != null) {
						rs.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}*/

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> result = new ArrayList<>();
		Connection conn = DBUtil.getSqlConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			setParameter(pstm, parameters);
			rs = pstm.executeQuery();
			while (rs.next()) {
				result.add(rowMapper.mapRow(rs));
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
				try {
					if (conn != null) {
						conn.close();
					}
					if (pstm != null) {
						pstm.close();
					}
					if (rs != null) {
						rs.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	@Override
	public void udl(String sql, Object... parameters) {
		Connection conn = DBUtil.getSqlConn();
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			setParameter(pstm, parameters);
			pstm.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstm != null) {
					pstm.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void setParameter (PreparedStatement pstm, Object ... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i+1;
				if (parameter == null) {
					pstm.setNull(index, Types.NULL);
				} else if (parameter instanceof Integer) {
					pstm.setInt(index, (Integer) parameter);
				} else if (parameter instanceof String) {
					pstm.setString(index, (String) parameter);
				}
				//....
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
