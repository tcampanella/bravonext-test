package com.tcampanella.last_minute.iface;

import java.util.List;

/**
 * @author Tommaso Campanella
 *
 *	The following interface (generic) let the class that implements it
 *  expose two methods to access a private list of Items
 *
 */
public interface IList<T> {
	
	public List<T> getItems();
	
	public T getItem(int index);

}
