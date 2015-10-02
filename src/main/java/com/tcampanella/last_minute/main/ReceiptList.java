/**
 * 
 */
package com.tcampanella.last_minute.main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tommaso Campanella
 *
 */
public class ReceiptList {

	private List<Recepit> recepits = new ArrayList<Recepit>();
	
	public ReceiptList(ShoppingList shoppingList) {
		
		populateReceiptList(shoppingList);
		
	}

	/**
	 * @param shoppingList
	 */
	private void populateReceiptList(ShoppingList shoppingList) {
		
		for(ShoppingBasket shoppingBasket: shoppingList.getShoppingBaskets()) {
			
			recepits.add(new Recepit(shoppingBasket));
			
		}
	}

	public List<Recepit> getReceipts(){
		
		return this.recepits;
	}
	
	public Recepit getReceipt(int index) {
		
		return recepits.get(index);
	}
	
	@Override
	public String toString() {
		
		StringBuilder string = new StringBuilder();
        int index = 1;
		for(Recepit recepit : recepits){
			string.append("Output " + index + ":\n");
			string.append(recepit);
			index++;
		}

		return string.toString();
		 
	}
}
