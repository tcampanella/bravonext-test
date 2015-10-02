/**
 * 
 */
package com.tcampanella.last_minute.main;

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
