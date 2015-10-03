package com.tcampanella.bravonext.main;

import java.util.ArrayList;
import java.util.List;

import com.tcampanella.bravonext.iface.IList;
import com.tcampanella.bravonext.iface.IReference;
import com.tcampanella.bravonext.iface.IShoppingList;

/**
 * @author Tommaso Campanella
 *
 */
public class ReceiptList implements IList<Receipt>, IReference<ShoppingList> {

	/**
	 * List of Receipts
	 */
	private List<Receipt> recepits = new ArrayList<Receipt>();
	
	/**
	 * Reference to the ShoppingList
	 * the ReceiptList is created from
	 */
	private IShoppingList shoppingList;
	
	public ReceiptList(IShoppingList shoppingList) {
		
		this.shoppingList = shoppingList;
		populateReceiptList(shoppingList);
		
	}

	/**
	 * Private method to populate a new ReceiptList
	 * 
	 * @param shoppingList
	 */
	private void populateReceiptList(IShoppingList shoppingList) {
		
		for(ShoppingBasket shoppingBasket: shoppingList.getItems()) {
			
			recepits.add(new Receipt(shoppingBasket));
			
		}
	}

	/*
	 * 
	 * @see com.tcampanella.last_minute.iface.IReference#getReference()
	 */
	public ShoppingList getReference() {
		
		return (ShoppingList) this.shoppingList;
	}
	
	/* 
	 * @see com.tcampanella.last_minute.main.IList#getItems()
	 */
	public List<Receipt> getItems(){
		
		return this.recepits;
	}
	
	/* 
	 * @see com.tcampanella.last_minute.main.IList#getItem(int index)
	 */
	public Receipt getItem(int index) {
		
		return recepits.get(index);
	}
	
	/**
	 * The following method will return a String formatted as follows:
	 * 
	 	Output 1:
		1 book : 12.49
		1 music CD: 16.49
		1 chocolate bar: 0.85
		
		Sales Taxes: 1.50 Total: 29.83
		
		Output 2:
		1 imported box of chocolates: 10.50
		1 imported bottle of perfume: 54.65
		
		Sales Taxes: 7.65 Total: 65.15
		
		Output 3:
		1 imported bottle of perfume: 32.19
		1 bottle of perfume: 20.89
		1 packet of headache pills: 9.75
		1 imported box of chocolates: 11.85
		
		Sales Taxes: 6.70 Total: 74.68

	 */
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
	
}
