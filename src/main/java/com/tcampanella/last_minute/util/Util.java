package com.tcampanella.last_minute.util;

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

import com.tcampanella.last_minute.iface.Item;
import com.tcampanella.last_minute.main.Input_Item;
import com.tcampanella.last_minute.main.ShoppingBasket;

/**
 * @author Tommaso Campanella
 *
 */
public class Util {
	
	private final BigDecimal increment = new BigDecimal("0.05");
	public static final String[] exemptions = new String[] { "chocolate","book","headache pills"};

	public boolean isExempted(String name) {
		
		boolean exempted = false;
		
		for(String string: exemptions) {
			
			if(name.toLowerCase().contains(string))
				exempted = true;
			
		}
		
		return exempted;
	}
	
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
	
	public BigDecimal roundNumber(BigDecimal numberTobeRounded) {
		
		return (numberTobeRounded.divide(increment,0,RoundingMode.UP)).multiply(increment);
	}
	
	public  List<ShoppingBasket> readShoppingList(FileInputStream inputStream) throws UnsupportedEncodingException, IOException, FileNotFoundException {
		
		List<ShoppingBasket> shoppingBaskets = new ArrayList<ShoppingBasket>();
		List<Item> items = new ArrayList<Item>();
		 
		try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"))) {
		    
			String line = br.readLine();

		    /**
		     * First a number
		     * then a String concluded by "at"
		     * then a number
		     * 
		     */
		    
		    while (line != null) {
		    	
		    	if(line.length() == 0) {
		    		
		    		line = br.readLine();
		    		continue;
		    		
		    	}
		    	
		    	if(line.toLowerCase().startsWith("input")){
		    		
		    		line = br.readLine();
		    		items.clear();
		    		
		    		while(line != null && line.length() > 0) {
		    	
				    	int amount = -1;
				    	String name = null;
				    	BigDecimal price = null;
				    	boolean imported = false;
				    	
						String numbers[] = line.split(" ",2);
						
						amount = Integer.parseInt(numbers[0]);
						
						String following = numbers[1];
						String numbers2[] = following.split(" at ",2);
						
						if(numbers2[0].contains("imported"))
							imported = true;
		
						name = numbers2[0];
						
						price = new BigDecimal(numbers2[1].trim());
						
				    	items.add(new Input_Item(name, price, amount, isExempted(name), imported));
				    	
				        line = br.readLine();
				        
		    		}
		    		
		    		shoppingBaskets.add(new ShoppingBasket(items));
			        
		    	} 
			}
		    
		}
		
		return shoppingBaskets;

	}
	
}
