package com.tcampanella.last_minute.iface;

import java.math.BigDecimal;

/**
 * @author Tommaso Campanella
 * 
 * Interface that exposes two methods to access
 * the total cost and taxes of a single receipt
 *  *
 */
public interface IReceipt extends IList<Item>{
	
	
	public BigDecimal getTotal_cost();
	
	public BigDecimal getTotal_taxes();

}
