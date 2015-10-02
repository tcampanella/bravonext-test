package com.tcampanella.last_minute.main;

import java.util.ArrayList;
import java.util.List;

import com.tcampanella.last_minute.iface.IList;
import com.tcampanella.last_minute.iface.IReference;

/**
 * @author Tommaso Campanella
 *
 */
public class ReceiptList implements IList<Receipt>, IReference<ShoppingList> {

	private List<Receipt> recepits = new ArrayList<Receipt>();
	private ShoppingList shoppingList;
	
	public ReceiptList(ShoppingList shoppingList) {
		
		this.shoppingList = shoppingList;
		populateReceiptList(shoppingList);
		
	}

	/**
	 * @param shoppingList
	 */
	private void populateReceiptList(ShoppingList shoppingList) {
		
		for(ShoppingBasket shoppingBasket: shoppingList.getItems()) {
			
			recepits.add(new Receipt(shoppingBasket));
			
		}
	}

	public List<Receipt> getItems(){
		
		return this.recepits;
	}
	
	public Receipt getItem(int index) {
		
		return recepits.get(index);
	}
	
	@Override
	public String toString() {
		
		StringBuilder string = new StringBuilder();
        int index = 1;
		for(Receipt recepit : recepits){
			string.append("Output " + index + ":\n");
			string.append(recepit);
			index++;
		}

		return string.toString();
		 
	}
	
	public ShoppingList getReference() {
		
		return this.shoppingList;
	}
}
