/**
 * 
 */
package edu.bowdoin.csci.PolarScheduler.utils;

import java.util.AbstractList;
import java.util.Collection;

/**
 * @author Khalil Jackson
 *
 */
public class ArrayList<E> extends AbstractList<E> {
	

	
	  /**
	   * Default starting array capacity if not specified.
	   */
	private static final int INIT_SIZE = 10;
	
	  /**
	   * The internal array storing the list elements.
	   */
	protected E[] list;
	
	  /**
	   * The number of list elements currently stored in the array (typically less
	   * than the array length).
	   */
	protected int size;
	
	  /**
	   * Construct a new list with the given starting capacity.
	   * 
	   * @param startingCapacity
	   *          The desired starting list capacity.
	   */
	@SuppressWarnings("unchecked")
	public ArrayList(int startingCapacity) {
		Object[] myArray = new Object[INIT_SIZE];
		list = (E[]) myArray;
		size = 0;
	  }
	
	  /**
	   * Construct a new list with the default starting capacity.
	   */
	public ArrayList() {
		this(INIT_SIZE); // just call the other constructor
	}
	
	  /**
	   * Ensure that the internal array has at least minCapacity size. Creates a new
	   * array and copies over the existing elements if the current capacity is less
	   * than minCapacity.
	   * 
	   * @param minCapacity
	   *          The minimum desired list capacity.
	   */
	@SuppressWarnings("unchecked")
	private void ensureCapacity(int minCapacity) {
		if (list.length < minCapacity) {
			int newLength = list.length;
			
			if (newLength == 0) {
				newLength = 1;
				}
			while (newLength < minCapacity) {
	        newLength *= 2; // double the list size
	        }
			
		Object[] newElementData = new Object[newLength];
		
		for (int i = 0; i < size; i++) {
			newElementData[i] = list[i];
		}
		list = (E[]) newElementData; // save the new array
	
	    }
	  }
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public boolean add(E element) {
		
			ensureCapacity(size + 1);
		    list[size] = element;
		    size++;
		    return true;
	    
	}
	
	@Override
	public void add(int index, E element) {
		
		if (((size == 0) & (index > 0)) || (index < 0) || (index > size)) {
			throw new IndexOutOfBoundsException();
			
		}
		
		
		if (element == null) {
			
			throw new NullPointerException();
		}
		
		if (contains(element)) {
			throw new IllegalArgumentException();
		}
		

		ensureCapacity(size + 1);
	
	    // shift all existing elements right starting at index
	    for (int i = size; i > index; i--) {
	      list[i] = list[i - 1];
	    }
	
	    list[index] = element;
	    size++;
  
	}
	
	@Override
	public E get(int index) {
		
		if (index > (size() - 1)) {
			
			throw new IndexOutOfBoundsException();
		} else {
			
			return (E) list[index];
			
		}
		
	}
	
	@Override
	public E set(int index, E element) {
		
		if ((index >= size)) {
			
			throw new IndexOutOfBoundsException();
		}
		
		if (element == null) {
			
			throw new NullPointerException();
		}
		
		if (contains(element)) {
			
			throw new IllegalArgumentException();
			
		}
		
	    E previousElement = (E) list[index];
	    list[index] = element;
	    return previousElement;
	    
	}
	
	@Override
	public E remove(int index) {
	    E removedElement = get(index);
	    size--;
	
	    // shift all existing elements left starting at index
	    for (int i = index; i < size; i++) {
	    	list[i] = list[i + 1];
	    	
	    }
	
	    // clear the now-unused space in the array
	    list[size] = null;
	
	    return removedElement;
	  }
	
	@Override
	public boolean contains(Object obj) {
		
		for (int i = 0; i < size; i++) {
			
			if (list[i].equals(obj)) {
	        return true;
	        }
	    }
	    return false;
	    
	}
	
	@Override
	public String toString() {
		
		String str = "[";
		
		for (int i = 0; i < size; i++) {
			str += list[i];
			
			if (i < size - 1) {
				str += ", ";
				
			}
			
		}
		
		return str + "]";
		
	}


}
