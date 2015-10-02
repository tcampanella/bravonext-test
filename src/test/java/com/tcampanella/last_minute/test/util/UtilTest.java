package com.tcampanella.last_minute.test.util;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tcampanella.last_minute.iface.Item;
import com.tcampanella.last_minute.main.Input_Item;
import com.tcampanella.last_minute.main.ShoppingBasket;
import com.tcampanella.last_minute.util.Util;

/**
 * 
 * 
 * @author Tommaso Campanella
 *
 */
public class UtilTest {
	
	@Test
	public void testIsExempted() {
		
		/**
		 * Create a new Util class
		 */
		
		Util util = new Util();
		
		assertTrue(util.isExempted("book"));
		assertTrue(util.isExempted("Book"));
		
		assertFalse(util.isExempted("music CD"));
		
		assertTrue(util.isExempted("headache pills"));
		
	}
	
	@Test
	public void testCalculateTaxes() {
		
		/**
		 * Create a new Util class
		 */
		
		Util util = new Util();
		
		/**
		 * Create a new Item
		 */
		
		Item item1 = new Input_Item("name", new BigDecimal("1.51"), 1, true, true);
		
		assertTrue(util.calculateTaxes(item1).compareTo(new BigDecimal("0.10")) == 0);
		
		Item item2 = new Input_Item("name", new BigDecimal("1.51"), 1, false, true);
		
		assertTrue(util.calculateTaxes(item2).compareTo(new BigDecimal("0.25")) == 0);
		
		Item item3 = new Input_Item("name", new BigDecimal("1.51"), 1, false, false);
		
		assertTrue(util.calculateTaxes(item3).compareTo(new BigDecimal("0.20")) == 0);
		
	}
	
	@Test
	public void testRoundNumber() {
		
		/**
		 * Create a new Util class
		 */
		
		Util util = new Util();
		
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
		
		List<ShoppingBasket> shoppingBaskets = new ArrayList<ShoppingBasket>();
		
		try {
			shoppingBaskets = util.readShoppingList(new FileInputStream("./" + "file.txt"));
		} catch (IOException e) {
			// should not be reached
			e.printStackTrace();
		}
		
		assertTrue(shoppingBaskets.size() == 6);
		assertTrue(shoppingBaskets.get(0).getItem(0).getName().equals("book"));
		
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

