package de.casino.com.dao;

import java.util.List;

public interface DatabaseDao<T> {

	
	public T getSingleItemById(int id);
	public List<T> getAllItems();
	public boolean deleteItemById(int id);
	public boolean createNewItem(T newItem);
	
}
