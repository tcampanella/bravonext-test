package com.tcampanella.last_minute.main;

import java.math.BigDecimal;

import com.tcampanella.last_minute.iface.IReference;
import com.tcampanella.last_minute.iface.Item;
import com.tcampanella.last_minute.util.Util;

/**
 * 
 * @author Tommaso Campanella
 *
 * Class representing a single Item in a Receipt
 */
public class ReceiptItem implements Item, IReference<Item> {

	/**
	 *  Item name
	 */
	private String name;
	
	/**
	 * Item price (with taxes)
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
	
	/**
	 * A reference to the related sshoppingItem
	 */
	private final Item shoppingItem;
	
	/**
	 * Utility class
	 */
	private static final Util util = new Util();
	
	/*
	 * 
	 * @param shoppingItem
	 * 
	 * A ReceiptItem is created out of an existing SshoppingItem
	 */
	public ReceiptItem(Item shoppingItem) {
		
		this.shoppingItem = shoppingItem;
		this.name = shoppingItem.getName();
		this.amount = shoppingItem.getAmount();
		this.exempted = shoppingItem.isExempted();
		this.imported = shoppingItem.isImported();
		
		/**
		 * The price is calculated including the necessary taxes
		 */
		this.price = util.calculateTaxes(shoppingItem).add(shoppingItem.getPrice()); 
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

	/* 
	 * @see com.tcampanella.last_minute.main.IReference#getReference()
	 */
	public Item getReference() {

		return this.shoppingItem;
	}

}
