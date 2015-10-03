package com.tcampanella.last_minute.test.main;

import org.junit.Test;

import com.tcampanella.last_minute.iface.Item;
import com.tcampanella.last_minute.main.ShoppingItem;
import com.tcampanella.last_minute.main.ReceiptItem;

import static org.junit.Assert.*;

import java.math.BigDecimal;

/**
 * @author Tommaso Campanella
 *
 * JUnit test case for Item interface implementations
 */
public class ItemTest {
	
	
	@Test
	public void testShoppingItem() {
		
		/**
		 * Create new Input_item
		 */
		
		Item shoppingItem = new ShoppingItem("book",new BigDecimal("1.0"),1,true,false);
		
		/**
		 * Check that the amount is correct
		 */
		
		assertTrue(shoppingItem.getAmount() == 1);
		
		/**
		 * Check that the name is correct
		 */
		
		assertTrue(shoppingItem.getName().equals("book"));
		
		/**
		 * Check that the price is correct
		 */
		
		assertTrue(shoppingItem.getPrice().equals(new BigDecimal("1.0")));
		
		/**
		 * Check that the item is exempt
		 */
		
		assertTrue(shoppingItem.isExempted());
		
		/**
		 * Check that the item is imported
		 */
		
		assertFalse(shoppingItem.isImported());
		
	}
	
	@Test
	public void testReceiptItem() {
		
		/**
		 * Create new Input_item
		 */
		
		Item shoppingItem = new ShoppingItem("book",new BigDecimal("1.0"),1,false,false);
		
		/**
		 * Create new Output_item
		 */
		
		Item receiptItem = new ReceiptItem(shoppingItem);
		
		/**
		 * Check that the amount is correct
		 */
		
		assertTrue(receiptItem.getAmount() == 1);
		
		/**
		 * Check that the name is correct
		 */
		
		assertTrue(receiptItem.getName().equals("book"));
		
		/**
		 * Check that the price (including taxes) is correct
		 */
		
		assertTrue(receiptItem.getPrice().equals(new BigDecimal("1.10")));
		
		/**
		 *  Check that the item is exempt
		 */
		
		assertFalse(receiptItem.isExempted());
		
		/**
		 *  Check that the item is imported
		 */
		
		assertFalse(receiptItem.isImported());
		
		/**
		 * Check that the getReference returns the correct ShoppingItem
		 */
		
		assertTrue(((ReceiptItem)receiptItem).getReference().getName().equals(receiptItem.getName()));
		assertTrue(((ReceiptItem)receiptItem).getReference().equals(shoppingItem));
		
	}

}
