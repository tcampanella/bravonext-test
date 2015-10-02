/**
 * 
 */
package com.tcampanella.last_minute.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.tcampanella.last_minute.util.Util;

/**
 * @author Tommaso Campanella
 *
 */
@SuppressWarnings("unused")
public class ShoppingBasket {
	
	
	private final List<Item> items = new ArrayList<Item>();
	
	public ShoppingBasket(List<Item> items) {
	
		/*
		for(Item item:items ){
			
			this.items.add(new Input_Item(item.getName(), item.getPrice(), item.getAmount(), item.isExempted(), item.isImported()));
			
		}
		*/
		this.items.addAll(items);
	}
	
	public List<Item> getItems() {
		
		return items;
	}

}
