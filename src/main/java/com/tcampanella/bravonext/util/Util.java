package com.tcampanella.bravonext.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.tcampanella.bravonext.iface.IUtil;
import com.tcampanella.bravonext.iface.Item;
import com.tcampanella.bravonext.main.ShoppingBasket;
import com.tcampanella.bravonext.main.ShoppingItem;

/**
 * @author Tommaso Campanella
 *
 * Utility class
 */
public class Util implements IUtil {
	
	/**
	 * Standard increment for rounding up sales taxes amount
	 */
	private final BigDecimal increment = new BigDecimal("0.05");
	
	/**
	 * Hard coded exemption list
	 */
	public static final String[] exemptions = new String[] { "chocolate","book","headache pills"};

	/**
	 * 
	 * @param name
	 * @return true if the Item is tax exempt
	 */
	public boolean isExempt(String name) {
		
		boolean exempted = false;
		
		for(String string: exemptions) {
			
			if(name.toLowerCase().contains(string))
				exempted = true;
			
		}
		
		return exempted;
	}
	
	/**
	 * 
	 * @param item
	 * @return the amount of taxes based of the Item
	 * 		   given as parameter
	 */
	public BigDecimal calculateTaxes(Item item) {
		
		BigDecimal taxes = null;
		
		if(item.isExempted() && !item.isImported())
			return new BigDecimal("0.0");
		else {
		
			float value = 0;
			
			if(!item.isExempted())
				value += 10;
			
			if(item.isImported())
				value += 5;
				
			taxes = roundNumber(item.getPrice().multiply(new BigDecimal("" + (value/100))));
				
		}
		
		return taxes;
		
	}
	
	/**
	 * Method to round up a number by a standard increment
	 * @param numberTobeRounded
	 * @return rounded "numberTobeRounded"
	 */
	public BigDecimal roundNumber(BigDecimal numberToBeRounded) {
		
		return roundNumber(numberToBeRounded,this.increment);
	}
	
	/**
	 * Method to round up a number by a given increment
	 * 
	 * @param numberTobeRounded
	 * @param increment
	 * @return rounded "numberTobeRounded"
	 */
	public BigDecimal roundNumber(BigDecimal numberToBeRounded, BigDecimal increment) {
		
		return (numberToBeRounded.divide(increment,0,RoundingMode.UP)).multiply(increment);
	}
	
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
				throws UnsupportedEncodingException, IOException, FileNotFoundException {
		
		List<ShoppingBasket> shoppingBaskets = new ArrayList<ShoppingBasket>();
		List<Item> shoppintItems = new ArrayList<Item>();
		 
		try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"))) {
		    
			String line = br.readLine();

		    /**
		     * 1) First a number
		     * 2) then a String concluded by "at"
		     * 3) then a number
		     * 
		     */
		    
		    while (line != null) {
		    	
		    	/**
		    	 * Skip any empty line
		    	 */
		    	if(line.length() == 0) {
		    		
		    		line = br.readLine();
		    		continue;
		    		
		    	}
		    	
		    	if(line.toLowerCase().startsWith("input")){
		    		
		    		line = br.readLine();
		    		
		    		/**
		    		 * Reset the list of ShoppingItems
		    		 */
		    		shoppintItems.clear();
		    		
		    		while(line != null && line.length() > 0) {
		    	
		    			/**
		    			 * Initialise variables
		    			 */
				    	int amount = -1;
				    	String name = null;
				    	BigDecimal price = null;
				    	boolean imported = false;
				    	
						String firstString[] = line.split(" ",2);
						amount = Integer.parseInt(firstString[0]);
						
						String secondString[] = firstString[1].split(" at ",2);
						
						if(secondString[0].contains("imported"))
							imported = true;
		
						name = secondString[0];
						price = new BigDecimal(secondString[1].trim());
						
						shoppintItems.add(new ShoppingItem(name, price, amount, isExempt(name), imported));
				    	
				        line = br.readLine();
				        
		    		}
		    		
		    		shoppingBaskets.add(new ShoppingBasket(shoppintItems));
			        
		    	} 
		    	
			}
		    
		}
		
		return shoppingBaskets;

	}
	
}
