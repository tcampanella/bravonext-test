package com.tcampanella.last_minute.main;

import java.math.BigDecimal;

import com.tcampanella.last_minute.util.Util;

public class Output_Item implements Item, IReference<Item> {

	private String name;
	private BigDecimal price;
	private int amount;
	private boolean exempted;
	private boolean imported;
	
	private final Item input_Item;
	private static final Util util = new Util();
	
	public Output_Item(Item input_Item) {
		
		this.input_Item = input_Item;
		
		this.name = input_Item.getName();
		this.amount = input_Item.getAmount();
		this.exempted = input_Item.isExempted();
		this.imported = input_Item.isImported();
		this.price = util.calculateTaxes(input_Item).add(input_Item.getPrice()); 
	}
	
	/* (non-Javadoc)
	 * @see com.tcampanella.last_minute.main.Item#getName()
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	/* (non-Javadoc)
	 * @see com.tcampanella.last_minute.main.Item#getPrice()
	 */
	public BigDecimal getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}

	/* (non-Javadoc)
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
	/* (non-Javadoc)
	 * @see com.tcampanella.last_minute.main.Item#isImported()
	 */
	public boolean isImported() {
		// TODO Auto-generated method stub
		return this.imported;
	}

	/* (non-Javadoc)
	 * @see com.tcampanella.last_minute.main.IReference#getReference()
	 */
	public Item getReference() {
		// TODO Auto-generated method stub
		return this.input_Item;
	}

	
	
}
