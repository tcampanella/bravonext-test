package com.tcampanella.last_minute.main;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Tommaso Campanella
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

		ShoppingList shoppingList = new ShoppingList();
		ReceiptList receiptList = new ReceiptList(shoppingList);
		
		System.out.println(receiptList);
	}

}
