/**
 * 
 */
package com.tcampanella.last_minute.iface;

import java.math.BigDecimal;

/**
 * @author Tommaso Campanella
 *
 */
public interface IReceipt extends IList<Item>{
	
	
	public BigDecimal getTotal_cost();
	public BigDecimal getTotal_taxes();

}
