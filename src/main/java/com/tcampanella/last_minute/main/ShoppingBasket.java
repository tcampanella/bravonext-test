package com.tcampanella.last_minute.main;

import java.util.ArrayList;
import java.util.List;

import com.tcampanella.last_minute.iface.IShoppingBasket;
import com.tcampanella.last_minute.iface.Item;

/**
 * @author Tommaso Campanella
 * 
 * Class representing a Shopping Basket
 *
 */
public class ShoppingBasket implements IShoppingBasket {
	
	/**
	 * List of ShoppingItems
	 */
	private final List<Item> shoppingIems = new ArrayList<Item>();
	
	/**
	 * 
	 * A ShoppingBasket is created out of a list of ShoppingItems
	 * 
	 * @param shoppingIems
	 */
	public ShoppingBasket(List<Item> shoppingIems) {
	
		this.shoppingIems.addAll(shoppingIems);
	}
	
	/* 
	 * @see com.tcampanella.last_minute.main.IList#getItems()
	 */
	public List<Item> getItems() {
		
		return shoppingIems;
	}
	
	/* 
	 * @see com.tcampanella.last_minute.main.IList#getItem(int index)
	 */
	public Item getItem(int index) {
		
		return this.shoppingIems.get(index);
	}

}
