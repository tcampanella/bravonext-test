/**
 * 
 */
package com.tcampanella.last_minute.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.tcampanella.last_minute.iface.IReceipt;
import com.tcampanella.last_minute.iface.IReference;
import com.tcampanella.last_minute.iface.Item;

/**
 * @author Tommaso Campanella
 *
 */
public class Receipt implements IReference<ShoppingBasket>, IReceipt {
	
	private final ShoppingBasket shoppingBasket;
	private final List<Item> items = new ArrayList<Item>();	
	
	private BigDecimal total_cost = new BigDecimal("0.0");
	/**
	 * @return the total_cost
	 */

	private BigDecimal total_taxes = new BigDecimal("0.0");
	
	public Receipt(ShoppingBasket shoppingBasket) {
		
		this.shoppingBasket = shoppingBasket;
		generateReceipt();
		
	}
	
	private void generateReceipt() {
		
		for(Item inputItem : shoppingBasket.getItems()) {
			
			Item receiptItem = new Output_Item(inputItem);
			total_cost = total_cost.add(receiptItem.getPrice().multiply(new BigDecimal(""+receiptItem.getAmount())));
			total_taxes = total_taxes.add(receiptItem.getPrice().subtract(((Output_Item)receiptItem).getReference().getPrice()));

			items.add(receiptItem);
			
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
	
	public List<Item> getItems() {
		
		return items;
	}
	
	public Item getItem(int index) {
		
		return items.get(index);
	}

	/* (non-Javadoc)
	 * @see com.tcampanella.last_minute.main.IReference#getReference()
	 */
	public ShoppingBasket getReference() {
		// TODO Auto-generated method stub
		return this.shoppingBasket;
	}
	
	@Override
	public String toString() {
	
		StringBuilder string = new StringBuilder();
        
		for(Item item : items)
			string.append(""+item.getAmount() + " "+item.getName() + ": " + item.getPrice() +"\n"); 

		string.append("\nSales Taxes: " + this.getTotal_taxes() + " Total: " + this.getTotal_cost()+"\n\n");
		
		return string.toString();
		
	}

}
