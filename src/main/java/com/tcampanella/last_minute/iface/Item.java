package com.tcampanella.last_minute.iface;

import java.math.BigDecimal;

/**
 * @author Tommaso Campanella
 *
 * General interface for an Item 
 * 
 */
public interface Item {
	
	
	public String getName();
	
	public BigDecimal getPrice();
	
	public int getAmount();
	
	public boolean isImported();
	
	public boolean isExempted();
	
}
