package com.tcampanella.last_minute.test.main;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import com.tcampanella.last_minute.main.ReceiptList;
import com.tcampanella.last_minute.main.ShoppingList;

/**
 * @author Tommaso Campanella
 *
 */
public class ReceiptListTest {
	
	@Test
	public void testReceiptList() {
		
		/**
		 * Create a new ShoppingList object
		 */
		
		ShoppingList shoppingList = null;
		
		try {
			shoppingList = new ShoppingList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * Create a new ReceiptList object
		 */
		
		ReceiptList receiptList = new ReceiptList(shoppingList);
		
		assertTrue(receiptList.getItems().size() > 0);
		assertTrue(receiptList.getItem(0).getItems().size() > 0);
		assertTrue(receiptList.getReference().equals(shoppingList));
		
	}


}
