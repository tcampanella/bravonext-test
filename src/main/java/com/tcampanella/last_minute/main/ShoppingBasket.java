package com.tcampanella.last_minute.main;

import java.util.ArrayList;
import java.util.List;

import com.tcampanella.last_minute.iface.IShoppingBasket;
import com.tcampanella.last_minute.iface.Item;

/**
 * @author Tommaso Campanella
 *
 */
public class ShoppingBasket implements IShoppingBasket {
	
	private final List<Item> items = new ArrayList<Item>();
	
	public ShoppingBasket(List<Item> items) {
	
		this.items.addAll(items);
	}
	
	public List<Item> getItems() {
		
		return items;
	}
	
	public Item getItem(int index) {
		
		return this.items.get(index);
	}

}
