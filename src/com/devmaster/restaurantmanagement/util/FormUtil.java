package com.devmaster.restaurantmanagement.util;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtil {
	//Chuyển tất cả parameters về 1 Model
	public static <T> T toModel(Class<T> tclass, HttpServletRequest request) {
		T obj = null;
		try {
			obj = tclass.newInstance();
			BeanUtils.populate(obj, request.getParameterMap());
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
