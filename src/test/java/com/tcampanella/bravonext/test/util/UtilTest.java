package com.tcampanella.bravonext.test.util;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tcampanella.bravonext.iface.Item;
import com.tcampanella.bravonext.main.ShoppingBasket;
import com.tcampanella.bravonext.main.ShoppingItem;
import com.tcampanella.bravonext.util.Util;

/**
 * 
 * @author Tommaso Campanella
 * 
 *  JUnit test case for the class Util
 *
 */
public class UtilTest {
	
	@Test
	public void testisExempt() {
		
		/**
		 * Create a new Util class
		 */
		
		Util util = new Util();
		
		/**
		 * Check the correct behaviour of isExempt(String name)
		 * 
		 * exemption list --> { "chocolate","book","headache pills"}
		 */
		
		assertTrue(util.isExempt("book"));
		assertTrue(util.isExempt("Book"));
		assertFalse(util.isExempt("music CD"));
		assertTrue(util.isExempt("headache pills"));
		
	}
	
	@Test
	public void testCalculateTaxes() {
		
		/**
		 * Create a new Util class
		 */
		
		Util util = new Util();
		
		/**
		 * Check the correct behaviour of calculateTaxes(Item item)
		 */
		
		Item item1 = new ShoppingItem("name", new BigDecimal("1.51"), 1, true, true);
		
		assertTrue(util.calculateTaxes(item1).compareTo(new BigDecimal("0.10")) == 0);
		
		Item item2 = new ShoppingItem("name", new BigDecimal("1.51"), 1, false, true);
		
		assertTrue(util.calculateTaxes(item2).compareTo(new BigDecimal("0.25")) == 0);
		
		Item item3 = new ShoppingItem("name", new BigDecimal("1.51"), 1, false, false);
		
		assertTrue(util.calculateTaxes(item3).compareTo(new BigDecimal("0.20")) == 0);
		
	}
	
	@Test
	public void testRoundNumber() {
		
		/**
		 * Create a new Util class
		 */
		
		Util util = new Util();
		
		/**
		 * Check the correct behaviour of roundNumber(BigDecimal numberToBeRounded)
		 */
		
		assertTrue(util.roundNumber(new BigDecimal("0.013")).compareTo(new BigDecimal("0.05")) == 0);
		
		assertTrue(util.roundNumber(new BigDecimal("7.123")).compareTo(new BigDecimal("7.15")) == 0);
		
		assertTrue(util.roundNumber(new BigDecimal("7.120001")).compareTo(new BigDecimal("7.15")) == 0);
		
	}
	
	@Test
	public void testReadShoppingList() {
		
		/**
		 * Create a new Util class
		 */
		
		Util util = new Util();
		
		/**
		 * Create a new list of ShoppingBasket
		 */
		
		List<ShoppingBasket> shoppingBaskets = new ArrayList<ShoppingBasket>();
		
		try {
			/**
			 * Check the correct behaviour of readShoppingList(FileInputStream inputStream)
			 */
			shoppingBaskets = util.readShoppingList(new FileInputStream("./" + "shoppingList.txt"));

		} catch (IOException e) {
			// should not be reached
			
			e.printStackTrace();
		}
		
		/**
		 * Check that the list has been
		 * correctly populated
		 */
		
		assertTrue(shoppingBaskets.size() == 6);
		assertTrue(shoppingBaskets.get(0).getItem(0).getName().equals("book"));
		
		/**
		 * Check that readShoppingList(FileInputStream inputStream), if invoked
		 * with a not existing file name, it would throw a FileNotFoundException
		 */
		
		FileNotFoundException fileNotFoundException = null;
		
		try {
			
			shoppingBaskets = util.readShoppingList(new FileInputStream("./" + "file_not_existing.txt"));
		
		} catch (FileNotFoundException e) {
			// should not be reached
		
			fileNotFoundException = e;
	
		} catch (IOException e) {
			// should not be reached
		
			e.printStackTrace();
		}
		
		assertTrue(fileNotFoundException != null);
		
	}
	
}

