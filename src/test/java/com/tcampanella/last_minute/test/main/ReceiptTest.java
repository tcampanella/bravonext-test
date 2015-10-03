package com.tcampanella.last_minute.test.main;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tcampanella.last_minute.iface.Item;
import com.tcampanella.last_minute.main.ShoppingItem;
import com.tcampanella.last_minute.main.Receipt;
import com.tcampanella.last_minute.main.ShoppingBasket;

/**
 * @author Tommaso Campanella
 *
 * JUnit test case for the class Receipt
 */
public class ReceiptTest {
	
	@Test
	public void test() {
		
		/**
		 * Create a new list of Items
		 */
		
		List<Item> shoppingItems = new ArrayList<Item>();
		
		for(int i = 0; i< 10; i++)
			shoppingItems.add(new ShoppingItem("name "+ i, new BigDecimal("1.10"), 1, false, false));
		
		/**
		 * Create a new shopping basket with 
		 * the list of items (shoppingItems)
		 */
		
		ShoppingBasket shoppingBasket = new ShoppingBasket(shoppingItems);
		
		/**
		 * Create a new Receipt
		 */
		
		Receipt receipt = new Receipt(shoppingBasket);
		
		/**
		 * Check that the receipt has been 
		 * correctly populated
		 */
		
		assertTrue(receipt.getItems().size() == 10);
		assertTrue(receipt.getItem(1).getName().equals("name 1"));
		
		/**
		 * Check that the getReference returns the correct ShoppingBasket
		 */
		
		assertTrue(receipt.getReference().equals(shoppingBasket));
		
		/**
		 * Check that the total cost and total amount of taxes
		 * have been correctly calculated given the list of items (shoppingItems)
		 */
		
		assertTrue(receipt.getTotal_cost().equals(new BigDecimal("12.50")));
		assertTrue(receipt.getTotal_taxes().equals(new BigDecimal("1.50")));		
			
	}

}
