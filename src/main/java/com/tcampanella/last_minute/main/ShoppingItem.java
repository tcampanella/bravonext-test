package com.tcampanella.last_minute.main;

import java.math.BigDecimal;

import com.tcampanella.last_minute.iface.Item;

/**
 * 
 * @author Tommaso Campanella
 *
 * Class representing a single Item in a Shopping Basket
 */

public class ShoppingItem implements Item{
	
	/**
	 *  Item name
	 */
	private String name;
	
	/**
	 * Item price (before taxes)
	 */
	private BigDecimal price;
	
	/**
	 * Number of items
	 */
	private int amount;

	/**
	 * Good exempted from basic sales taxes
	 */
	boolean exempted;
	
	/**
	 * Good imported
	 */
	private boolean imported;
	
	
	public ShoppingItem(String name,BigDecimal price, int amount, boolean exempted, boolean imported) {
		
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.exempted = exempted;
		this.imported = imported;
		
	}

	/* 
	 * @see com.tcampanella.last_minute.main.Item#getName()
	 */
	public String getName() {

		return this.name;
	}

	/* 
	 * @see com.tcampanella.last_minute.main.Item#getPrice()
	 */
	public BigDecimal getPrice() {

		return this.price;
	}

	/* 
	 * @see com.tcampanella.last_minute.main.Item#getAmount()
	 */
	public int getAmount() {

		return this.amount;
	}
	
	public boolean isExempted() {

		return this.exempted;
	}

	/* 
	 * @see com.tcampanella.last_minute.main.Item#isImported()
	 */
	public boolean isImported() {

		return this.imported;
	}

}
