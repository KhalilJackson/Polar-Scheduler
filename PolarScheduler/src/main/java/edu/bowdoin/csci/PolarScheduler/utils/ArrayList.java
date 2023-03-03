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
		Object[] myArray = new Object[startingCapacity];
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
	
	/**
	 * Returns the size of the ArrayList.
	 */
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * Boolean value that lets us know if the ArrayList is empty.
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Adds element to the list.
	 */
	@Override
	public boolean add(E element) {
		
		//Ensure list has capacity for element
		ensureCapacity(size + 1);
		
		//Add element to end of list and increment size
	    list[size] = element;
	    size++;
	    
	    //Return true
	    return true;   
	}
	
	/**
	 * Adds element at specific point in the list.
	 */
	@Override
	public void add(int index, E element) {
		
		//Ensures index within bounds
		if (((size == 0) & (index > 0)) || (index < 0) || (index > size)) {
			throw new IndexOutOfBoundsException();
		}
		
		//Ensures element is not null
		if (element == null) {
			
			throw new NullPointerException();
		}
		
		//Ensures list does not contain element
		if (contains(element)) {
			throw new IllegalArgumentException();
		}
		
		//Ensures list has enough space for the element
		ensureCapacity(size + 1);
	
	    //Shift all existing elements right starting at index
	    for (int i = size; i > index; i--) {
	      list[i] = list[i - 1];
	    }
	
	    list[index] = element;
	    size++;
	}
	
	/**
	 * Get element at particular index.
	 */
	@Override
	public E get(int index) {
		
		//Ensure index is within bounds
		if (index > (size() - 1)) {
			
			throw new IndexOutOfBoundsException();
		} else {
			
			//Return element at index
			return (E) list[index];
		}
	}
	
	/**
	 * Sets element at a particular index.
	 */
	@Override
	public E set(int index, E element) {
		
		//Ensure index is in bounds
		if ((index >= size)) {
			
			throw new IndexOutOfBoundsException();
		}
		
		//Ensure element is not null
		if (element == null) {
			
			throw new NullPointerException();
		}
		
		//Ensure list does not contain element
		if (contains(element)) {
			
			throw new IllegalArgumentException();
		}
		
	    E previousElement = (E) list[index];
	    list[index] = element;
	    return previousElement;
	}
	
	/**
	 * Removes element at index.
	 */
	@Override
	public E remove(int index) {
		
		//Get element at index
	    E removedElement = get(index);
	    size--;
	
	    //Shift all existing elements left starting at index
	    for (int i = index; i < size; i++) {
	    	list[i] = list[i + 1];
	    	
	    }
	
	    //Clear the now-unused space in the array
	    list[size] = null;
	
	    //Return the removed element
	    return removedElement;
	}
	
	/**
	 * Iterates through list to see if object exists inside.
	 */
	@Override
	public boolean contains(Object obj) {
		
		//Iterate through list by index
		for (int i = 0; i < size; i++) {
			
			//If index contains object, return true
			if (list[i].equals(obj)) {
	        return true;
	        }
	    }
		
		//Else, return false
	    return false;  
	}
	
	/**
	 * To string method that formats list contents.
	 */
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
