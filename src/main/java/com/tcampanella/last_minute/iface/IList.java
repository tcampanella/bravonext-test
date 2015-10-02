/**
 * 
 */
package com.tcampanella.last_minute.iface;

import java.util.List;

/**
 * @author Tommaso Campanella
 *
 */
public interface IList<T> {
	
	public List<T> getItems();
	public T getItem(int index);

}
