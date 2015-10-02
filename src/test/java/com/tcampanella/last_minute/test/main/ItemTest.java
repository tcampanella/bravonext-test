package com.tcampanella.last_minute.test.main;

import org.junit.Test;

import com.tcampanella.last_minute.iface.Item;
import com.tcampanella.last_minute.main.Input_Item;
import com.tcampanella.last_minute.main.Output_Item;

import static org.junit.Assert.*;

import java.math.BigDecimal;

/**
 * @author Tommaso Campanella
 *
 */
public class ItemTest {
	
	
	@Test
	public void testInput_item() {
		
		/**
		 * Create new Input_item
		 */
		
		Item inputItem = new Input_Item("book",new BigDecimal("1.0"),1,true,false);
		
		assertTrue(inputItem.getAmount() == 1);
		assertTrue(inputItem.getName().equals("book"));
		assertTrue(inputItem.getPrice().equals(new BigDecimal("1.0")));
		assertTrue(inputItem.isExempted());
		assertFalse(inputItem.isImported());
		
	}
	
	@Test
	public void testOutput_item() {
		
		/**
		 * Create new Input_item
		 */
		
		Item inputItem = new Input_Item("book",new BigDecimal("1.0"),1,false,false);
		
		/**
		 * Create new Output_item
		 */
		
		Item outputItem = new Output_Item(inputItem);
		
		assertTrue(outputItem.getAmount() == 1);
		assertTrue(outputItem.getName().equals("book"));
		assertTrue(outputItem.getPrice().equals(new BigDecimal("1.10")));
		assertFalse(outputItem.isExempted());
		assertFalse(outputItem.isImported());
		
		assertTrue(((Output_Item)outputItem).getReference().getName().equals(outputItem.getName()));
		assertTrue(((Output_Item)outputItem).getReference().equals(inputItem));
		
	}

}
