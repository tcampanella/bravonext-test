package com.tcampanella.last_minute.main;

import java.math.BigDecimal;

import com.tcampanella.last_minute.iface.Item;

public class Input_Item implements Item{
	
	private String name;
	private BigDecimal price;
	private int amount;
	private boolean exempted;
	private boolean imported;
	
	
	public Input_Item(String name,BigDecimal price, int amount, boolean exempted, boolean imported) {
		
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
		// TODO Auto-generated method stub
		return this.name;
	}

	/* 
	 * @see com.tcampanella.last_minute.main.Item#getPrice()
	 */
	public BigDecimal getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}

	/* 
	 * @see com.tcampanella.last_minute.main.Item#getAmount()
	 */
	public int getAmount() {
		// TODO Auto-generated method stub
		return this.amount;
	}
	
	public boolean isExempted() {
		// TODO Auto-generated method stub
		return this.exempted;
	}

	/* 
	 * @see com.tcampanella.last_minute.main.Item#isImported()
	 */
	public boolean isImported() {
		// TODO Auto-generated method stub
		return this.imported;
	}

}
