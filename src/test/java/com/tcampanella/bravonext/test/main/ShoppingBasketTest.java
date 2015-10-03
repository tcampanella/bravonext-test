package com.tcampanella.bravonext.test.main;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tcampanella.bravonext.iface.Item;
import com.tcampanella.bravonext.main.ShoppingBasket;
import com.tcampanella.bravonext.main.ShoppingItem;

/**
 * @author Tommaso Campanella
 * 
 *  JUnit test case for the class ShoppingBasket
 *
 */
public class ShoppingBasketTest {
	
	@Test
	public void test() {
		
		/**
		 * Create a new list of Items
		 */
		
		List<Item> shoppingItems = new ArrayList<Item>();
		
		for(int i = 0; i< 10; i++)
			shoppingItems.add(new ShoppingItem("name "+ i, new BigDecimal("1.10"), i, true, false));
		
		/**
		 * Create a new shopping basket with 
		 * the list of items (shoppingItems)
		 */
		
		ShoppingBasket shoppingBasket = new ShoppingBasket(shoppingItems);
		
		/**
		 * Check that the shoppingBasket has been
		 * correctly populated 
		 */
		
		assertTrue(shoppingBasket.getItems().size() == 10);
		assertTrue(shoppingBasket.getItem(1).getName().equals("name 1"));

	}

}
