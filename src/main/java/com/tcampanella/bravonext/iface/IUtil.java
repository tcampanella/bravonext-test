package com.tcampanella.bravonext.iface;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;

import com.tcampanella.bravonext.main.ShoppingBasket;

/**
 * @author Tommaso Campanella
 *
 * Util interface
 */
public interface IUtil {
	
	/**
	 * Method to check if a name (Item) is tax exempt
	 * 
	 * @param name
	 * @return
	 */
	public boolean isExempt(String name);
	
	/**
	 * Method to calculate the taxes to be payed for
	 * a given Item
	 * 
	 * @param item
	 * @return
	 */
	public BigDecimal calculateTaxes(Item item);
	
	/**
	 * Method to round up a number
	 * 
	 * @param numberTobeRounded
	 * @return
	 */
	public BigDecimal roundNumber(BigDecimal numberTobeRounded);

	/**
	 * Method to round up a number by a given increment
	 * @param numberTobeRounded
	 * @param increment
	 * @return
	 */
	public BigDecimal roundNumber(BigDecimal numberTobeRounded, BigDecimal increment);
	
	/**
	 * Method to read a ShoppingList from a text file
	 * N.B.: the file MUST be UTF-8 formatted
	 * 
	 * @param inputStream
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public  List<ShoppingBasket> readShoppingList(FileInputStream inputStream) 
				throws UnsupportedEncodingException, IOException, FileNotFoundException;
	
}
