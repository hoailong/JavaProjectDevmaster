package com.devmaster.restaurantmanagement.dao.impl;

import java.util.List;

import com.devmaster.restaurantmanagement.dao.IFoodDAO;
import com.devmaster.restaurantmanagement.mapper.FoodMapper;
import com.devmaster.restaurantmanagement.model.FoodModel;

public class FoodDAO extends AbstractDAO<FoodModel> implements IFoodDAO{

	@Override
	public List<FoodModel> findAll() {
		String sql = "Select * From tblFood";
		List<FoodModel> list = query(sql, new FoodMapper());
		return list;
	}

	@Override
	public List<FoodModel> findByGroupCode(String groupCode) {
		String sql = "Select f.FoodId,f.FoodName,f.FoodImage,f.FoodCost,f.GroupId From tblFood f, tblFoodGroup fg where f.GroupId = fg.GroupId AND fg.GroupCode LIKE '"+groupCode+"'" ;
		List<FoodModel> list = query(sql, new FoodMapper());
		return list;
	}

	@Override
	public List<FoodModel> findByNameAndGroupCode(String name, String groupCode) {
		String sql = "Select f.FoodId,f.FoodName,f.FoodImage,f.FoodCost,f.GroupId "
				+ "From tblFood f, tblFoodGroup fg where f.GroupId = fg.GroupId AND fg.GroupCode "
				+ "LIKE '%"+groupCode+"%' and f.FoodName LIKE '%"+name+"%'" ;
		List<FoodModel> list = query(sql, new FoodMapper());
		return list;
	}

	@Override
	public List<FoodModel> findTopByGroupCode(String groupCode, int count) {
		String sql = "Select TOP (?) f.FoodId,f.FoodName,f.FoodImage,f.FoodCost,f.GroupId From tblFood f, tblFoodGroup fg where f.GroupId = fg.GroupId AND fg.GroupCode LIKE '"+groupCode+"'" ;
		List<FoodModel> list = query(sql, new FoodMapper(),count);
		return list;
	}

	@Override
	public void insert(FoodModel foodModel) {
		String sql = "Insert into tblFood(FoodName, FoodImage, FoodCost, GroupId) values(?,?,?,?)";
		udl(sql, foodModel.getFoodName(), foodModel.getImage(), foodModel.getCost(), foodModel.getGroupId());
	}

	@Override
	public void update(FoodModel foodModel) {
		String sql = "UPDATE tblFood set FoodName = ?, FoodImage = ?, FoodCost = ?, GroupId = ? Where FoodId = ?";
		udl(sql, foodModel.getFoodName(), foodModel.getImage(), foodModel.getCost(), foodModel.getGroupId(), foodModel.getFoodId());
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE from tblFood Where FoodId = ?";
		udl(sql, id);
	}

}
