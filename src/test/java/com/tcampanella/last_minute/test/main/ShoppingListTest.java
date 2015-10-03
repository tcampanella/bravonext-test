package com.tcampanella.last_minute.test.main;

import org.junit.Test;

import com.tcampanella.last_minute.main.ShoppingList;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author Tommaso Campanella
 * 
 *  JUnit test case for the class ShoppingList
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
			
			/**
			 * Standard "file.txt" is used
			 */
			
			shoppingList = new ShoppingList();
			
		} catch (IOException e) {
			
			// Should not happen
			e.printStackTrace();
			
		}
		
		/**
		 * Check that the shopping list has been correctly
		 * populated
		 */
		
		assertTrue(shoppingList.getItems().size() > 0);
		assertTrue(shoppingList.getItem(0).getItems().size() > 0);
		
		/**
		 * Check that, in case a wrong file name is provided,
		 * a FileNotFound exception is thrown
		 */
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
