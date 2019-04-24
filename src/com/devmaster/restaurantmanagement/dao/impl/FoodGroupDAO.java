package com.devmaster.restaurantmanagement.dao.impl;

import java.util.List;

import com.devmaster.restaurantmanagement.dao.IFoodGroupDAO;
import com.devmaster.restaurantmanagement.mapper.FoodGroupMapper;
import com.devmaster.restaurantmanagement.model.FoodGroupModel;

public class FoodGroupDAO extends AbstractDAO<FoodGroupModel> implements IFoodGroupDAO{

	@Override
	public List<FoodGroupModel> findAll() {
		String sql = "Select * From tblFoodGroup";
		List<FoodGroupModel> list = query(sql, new FoodGroupMapper());
		return list;
	}

	@Override
	public List<FoodGroupModel> findByName(String name) {
		String sql = "Select * From tblFoodGroup where GroupName like ?";
		String str = "%" + name + "%";
		List<FoodGroupModel> list = query(sql, new FoodGroupMapper(), str);
		return list;
	}

	@Override
	public void insert(FoodGroupModel foodGroupModel) {
		String sql = "Insert into tblFoodGroup(GroupName,GroupCode) values(?,?)";
		udl(sql, foodGroupModel.getName(),foodGroupModel.getCode());
	}

	@Override
	public void update(FoodGroupModel foodGroupModel) {
		String sql = "Update tblFoodGroup set GroupName = ?, GroupCode = ? where GroupId = ?";
		udl(sql, foodGroupModel.getName(),foodGroupModel.getCode(), foodGroupModel.getId());
		
	}

	@Override
	public void delete(int id) {
		String sql = "Delete from tblFoodGroup where GroupId = ?";
		udl(sql, id);
	}

}
