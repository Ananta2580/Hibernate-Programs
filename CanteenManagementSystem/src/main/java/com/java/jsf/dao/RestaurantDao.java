package com.java.jsf.dao;

import java.util.List;

import com.java.jsf.model.Menu;
import com.java.jsf.model.Restaurant;

public interface RestaurantDao {
	List<Restaurant> showRestaurant();
	String addRestaurant(Restaurant restaurant);
	List<Menu> showMenubyId(int restId);
}
