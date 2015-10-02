package com.tcampanella.last_minute.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.tcampanella.last_minute.iface.IList;
import com.tcampanella.last_minute.util.Util;

/**
 * @author Tommaso Campanella
 *
 */
public class ShoppingList implements IList<ShoppingBasket>{
	
	private List<ShoppingBasket> shoppingBaskets = new ArrayList<ShoppingBasket>();
	private final Util util = new Util();
	private final static String DEFAULT_FILE_NAME = "file.txt";
	
	
	public ShoppingList() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		
		this(DEFAULT_FILE_NAME);
		
	}
	
	public ShoppingList(String fileName) throws UnsupportedEncodingException, FileNotFoundException, IOException {
		
		
		shoppingBaskets.addAll(util.readShoppingList(new FileInputStream("./" + fileName)));
			
	}

	public List<ShoppingBasket> getItems(){
		
		return this.shoppingBaskets;
	}
	
	public ShoppingBasket getItem(int index) {
		
		return shoppingBaskets.get(index);
	}

}
