package com.tcampanella.last_minute.test.main;

import org.junit.Test;

import com.tcampanella.last_minute.main.ReceiptList;
import com.tcampanella.last_minute.main.ShoppingList;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author Tommaso Campanella
 *
 */
public class ShoppingListTest {
	
	@Test
	public void testShoppingList() {
		
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
		
		assertTrue(shoppingList.getItems().size() > 0);
		assertTrue(shoppingList.getItem(0).getItems().size() > 0);
		
		FileNotFoundException fileNotFoundException = null;
		
		try {
			shoppingList = new ShoppingList("wrong file name");
		} catch (UnsupportedEncodingException e) {
			//should not happen
			e.printStackTrace();
		} catch (FileNotFoundException e) {

			fileNotFoundException = e;
		
		} catch (IOException e) {
			//should not happen
			e.printStackTrace();
		}
		
		assertTrue(fileNotFoundException != null);
		
	}
	
}
