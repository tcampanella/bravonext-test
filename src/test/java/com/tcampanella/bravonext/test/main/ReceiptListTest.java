package com.tcampanella.bravonext.test.main;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import com.tcampanella.bravonext.main.ReceiptList;
import com.tcampanella.bravonext.main.ShoppingList;

/**
 * @author Tommaso Campanella
 * 
 * JUnit test case for the class ReceiptList
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
			/**
			 * the standard "file.txt" is used
			 * to populated the ShoppingList
			 */
			shoppingList = new ShoppingList();
			
		} catch (IOException e) {
			
			// Should not happen
			e.printStackTrace();
		}
		
		/**
		 * Create a new ReceiptList object
		 */
		
		ReceiptList receiptList = new ReceiptList(shoppingList);
		
		/**
		 * Check that the ReceiptList has been correctly generated
		 * from shoppingList
		 */
		assertTrue(receiptList.getItems().size() > 0);
		assertTrue(receiptList.getItem(0).getItems().size() > 0);
		assertTrue(receiptList.getItem(0).getItem(0).getName().equals(receiptList.getReference().getItem(0).getItem(0).getName()));
		
		/**
		 * Check that the getReference returns the correct ShoppingList
		 */
		assertTrue(receiptList.getReference().equals(shoppingList));
		
	}


}
