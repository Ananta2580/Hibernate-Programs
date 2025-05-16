package com.java.jsf.controller;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.java.jsf.dao.DaoImpl;
import com.java.jsf.model.Menu;
import com.java.jsf.model.Restaurant;

public class CanteenController {
	
	private Restaurant restaurant;
	private Menu menu;
	private DaoImpl dao = new DaoImpl();
	
	private List<Menu> menuList;
	private int restaurantId;
	
	private List<Menu> paginatedMenuList;
	private int page = 0;
	private int pageSize = 5;
	
	
	private String sortField;
    private boolean ascending = true;
    private  List<Restaurant> restList;
    
    public void sortBy(String field) {
        if (field.equals(sortField)) {
            ascending = !ascending; // toggle sort direction
        } else {
            sortField = field;
            ascending = true;
        }
    }

    private void sortList() {
        if (sortField == null || restList == null) return;

        Collections.sort(restList, (e1, e2) -> {
            try {
                Field f = Restaurant.class.getDeclaredField(sortField);
                f.setAccessible(true);
                Comparable v1 = (Comparable) f.get(e1);
                Comparable v2 = (Comparable) f.get(e2);
                return ascending ? v1.compareTo(v2) : v2.compareTo(v1);
            } catch (Exception ex) {
                return 0;
            }
        });
    }
	

	public List<Menu> getPaginatedMenuList() {
	    if (menuList == null) {
	        String restIdParam = FacesContext.getCurrentInstance()
	                .getExternalContext()
	                .getRequestParameterMap()
	                .get("restaurantid");
	        if (restIdParam != null) {
	            int restaurantId = Integer.parseInt(restIdParam);
	            menuList = dao.showMenubyId(restaurantId);
	        } else {
	            menuList = new ArrayList<>();
	        }
	    }

	    int fromIndex = page * pageSize;
	    int toIndex = Math.min(fromIndex + pageSize, menuList.size());

	    paginatedMenuList = menuList.subList(fromIndex, toIndex);
	    return paginatedMenuList;
	}
	
	
	public void nextPage() {
	    if ((page + 1) * pageSize < menuList.size()) {
	        page++;
	    }
	}

	public void previousPage() {
	    if (page > 0) {
	        page--;
	    }
	}

	public boolean isHasNextPage() {
	    return (page + 1) * pageSize < menuList.size();
	}

	public boolean isHasPreviousPage() {
	    return page > 0;
	}
	
	

	public int getRestaurantId() {
	    return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
	    this.restaurantId = restaurantId;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public DaoImpl getDao() {
		return dao;
	}
	public void setDao(DaoImpl dao) {
		this.dao = dao;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public List<Restaurant> showRestaurant(){
		restList = dao.showRestaurant();
		sortList();
		return restList;
	}
	
	public List<Menu> showMenubyId(int restId){
		return dao.showMenubyId(restId);
	}
	
}
