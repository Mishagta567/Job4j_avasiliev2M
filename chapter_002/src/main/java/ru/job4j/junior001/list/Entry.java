package ru.job4j.junior001.list;


import net.jcip.annotations.ThreadSafe;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ThreadSafe динамический список  [#1105]
 *
 * @author   A_Vasiliev
 * @since    05.01.2018
 * @version  1.0.0
 */

@ThreadSafe
public class Entry {
    Object object;
    Entry previoues;
    Entry next;

    public Entry(Object obj) {
    	this.object = obj;
	 }

	public Entry getNext() {
		return next;
	}

	public Entry getPrevioues() {
		return previoues;
	}

	public void setNext(Entry next) {
		this.next = next;
	}

	public void setPrevioues(Entry previoues) {
		this.previoues = previoues;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}