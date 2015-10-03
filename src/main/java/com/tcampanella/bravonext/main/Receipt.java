package com.tcampanella.bravonext.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.tcampanella.bravonext.iface.IReceipt;
import com.tcampanella.bravonext.iface.IReference;
import com.tcampanella.bravonext.iface.IShoppingBasket;
import com.tcampanella.bravonext.iface.Item;

/**
 * @author Tommaso Campanella
 * 
 * Class representing a Receipt
 *
 */
public class Receipt implements IReference<ShoppingBasket>, IReceipt {
	
	/**
	 * List of ReceiptItem
	 */
	private final List<Item> receiptItems = new ArrayList<Item>();	
	
	/**
	 * Total cost of the Receipt (including taxes)
	 */
	private BigDecimal total_cost = new BigDecimal("0.0");
	
	/**
	 * Total taxes of the Receipt
	 */
	private BigDecimal total_taxes = new BigDecimal("0.0");
	
	/**
	 * Reference to the ShoppingBasket a Receipt
	 * is created from
	 */
	private final IShoppingBasket shoppingBasket;
	
	
	/**
	 * 
	 * @param shoppingBasket
	 */
	public Receipt(ShoppingBasket shoppingBasket) {
		
		this.shoppingBasket = shoppingBasket;
		generateReceipt();
		
	}
	
	/**
	 * Method to populate a Receipt from a ShoppingBasket
	 */
	private void generateReceipt() {
		
		for(Item shoppingItem : shoppingBasket.getItems()) {
			
			Item receiptItem = new ReceiptItem(shoppingItem);
			total_cost = 
					total_cost.add(receiptItem.getPrice().multiply(new BigDecimal(""+receiptItem.getAmount())));
			total_taxes = 
					total_taxes.add(receiptItem.getPrice().subtract(((ReceiptItem)receiptItem).getReference().getPrice()));

			receiptItems.add(receiptItem);
			
		}
		
	}
	
	public BigDecimal getTotal_cost() {
		return total_cost;
	}

	/**
	 * @return the total_taxes
	 */
	public BigDecimal getTotal_taxes() {
		return total_taxes;
	}
	
	/* 
	 * @see com.tcampanella.last_minute.main.IReference#getReference()
	 */
	public ShoppingBasket getReference() {

		return (ShoppingBasket) this.shoppingBasket;
	}
	
	/**
	 * The following method will return a String formatted as follows:
	 * 
	 	1 book : 12.49
		1 music CD: 16.49
		1 chocolate bar: 0.85
		
		Sales Taxes: 1.50 Total: 29.83
		
	 */
	@Override
	public String toString() {
	
		StringBuilder string = new StringBuilder();
        
		for(Item item : receiptItems)
			string.append(""+item.getAmount() + " "+item.getName() + ": " + item.getPrice() +"\n"); 

		string.append("\nSales Taxes: " + this.getTotal_taxes() + " Total: " + this.getTotal_cost()+"\n\n");
		
		return string.toString();
		
	}
	
	/* 
	 * @see com.tcampanella.last_minute.main.IList#getItems()
	 */
	public List<Item> getItems() {
		
		return receiptItems;
	}
	
	/* 
	 * @see com.tcampanella.last_minute.main.IList#getItem(int index)
	 */
	public Item getItem(int index) {
		
		return receiptItems.get(index);
	}

}
