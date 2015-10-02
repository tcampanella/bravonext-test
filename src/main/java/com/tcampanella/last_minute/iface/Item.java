/**
 * 
 */
package com.tcampanella.last_minute.iface;

import java.math.BigDecimal;

/**
 * @author Tommaso Campanella
 *
 */
public interface Item {
	
	
	public String getName();
	public BigDecimal getPrice();
	public int getAmount();
	public boolean isImported();
	public boolean isExempted();
	
}
