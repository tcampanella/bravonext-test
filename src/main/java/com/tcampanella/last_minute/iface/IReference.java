package com.tcampanella.last_minute.iface;

/**
 * @author Tommaso Campanella
 *
 * Generic interface to obtain a reference
 * to a related entity
 */
public interface IReference<T> {
	
	public T getReference();

}
