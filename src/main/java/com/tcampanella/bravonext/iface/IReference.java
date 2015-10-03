package com.tcampanella.bravonext.iface;

/**
 * @author Tommaso Campanella
 *
 * Generic interface to obtain a reference
 * to a related entity
 */
public interface IReference<T> {
	
	public T getReference();

}
