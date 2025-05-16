package com.java.jsf.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.java.jsf.model.Menu;
import com.java.jsf.model.Restaurant;
import com.java.jsf.util.SessionHelper;

public class DaoImpl implements RestaurantDao{
	
	Session session;

	@Override
	public List<Restaurant> showRestaurant() {
		session = SessionHelper.getSessionFactory().openSession();
		Query query = session.getNamedQuery("showRestaurant");
		List<Restaurant> restList = query.list();
		
		return restList;
	}

	@Override
	public String addRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> showMenubyId(int restId) {
		session = SessionHelper.getSessionFactory().openSession();
		Query query = session.getNamedQuery("showMenuById");
		query.setParameter("restaurantId", restId);
		List<Menu> menuList = query.list();
		session.close();
		return menuList;
	}
	
}
