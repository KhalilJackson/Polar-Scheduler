package edu.bowdoin.csci.PolarScheduler.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests custom ArrayList.
 * 
 * @author Sarah Heckman
 * @author Kai Presler-Marshall
 */
public class ArrayListTest {

	private ArrayList<String> list;

	/**
	 * Sets up the test.
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		list = new ArrayList<String>();
	}

	/**
	 * Tests that a ArrayList is constructed correctly. A ArrayList of any generic
	 * type should be not null and empty, which implies a size of 0. Test method for
	 * {@link ArrayList#ArrayList()}.
	 */
	@Test
	public void testArrayList() {
		Assertions.assertNotNull(list,
				"ArrayList.ArrayList() - list should not be null after construction, but was null.");
		Assertions.assertTrue(list.isEmpty(),
				"ArrayList.ArrayList() - list should be empty after construction, but was not");
		Assertions.assertEquals(0, list.size(),
				"ArrayList.ArrayList() - list should have a size of 0 after construction, but size was not 0");
	}

	/**
	 * Tests adding elements to an empty ArrayList. This is the simplest test (other
	 * than creating a list and doing nothing with it) and only tries to add
	 * elements to the end of the list, and then checks their contents -- it does
	 * not try to add elements anywhere else, or modify the list once it is created.
	 */
	@Test
	public void testAddE() {

		list.add("apple");
		Assertions.assertEquals(1, list.size(),
				"ArrayList.addE() - Attempted to add element at index 0 to an empty list.  Size should be 1, but was not.");
		Assertions.assertEquals("apple", list.get(0),
				"ArrayList.addE() - Attempted to add element at index 0 to an empty list.  The element at index 0 was incorrect.");

		// Add element to the front of a list
		list.add("orange");
		Assertions.assertEquals(2, list.size(),
				"ArrayList.addE() - Added apple at 0 and orange at 1.  Size should be two but was not.");
		Assertions.assertEquals("apple", list.get(0),
				"ArrayList.addE() - Added apple at 0 and orange at 1. apple should be at index 0, but it was not.");
		Assertions.assertEquals("orange", list.get(1),
				"ArrayList.addE() - Added apple at 0 and orange at 1. orange should be at index 1, but it was not.");
		
		list.add("grapefruit");
		Assertions.assertEquals(3, list.size(),
				"ArrayList.addE() - Added apple at 0, orange at 1, and grapefruit at 2.  Size should be three but was not.");
		Assertions.assertEquals("apple", list.get(0),
				"ArrayList.addE() - Added apple at 0, orange at 1, and grapefruit at 2. apple should be at index 0, but it was not.");
		Assertions.assertEquals("orange", list.get(1),
				"ArrayList.addE() - Added apple at 0, orange at 1, and grapefruit at 2. orange should be at index 1, but it was not.");
		Assertions.assertEquals("grapefruit", list.get(2),
				"ArrayList.addE() - Added apple at 0, orange at 1, and grapefruit at 2. grapefruit should be at index 2, but it was not.");


	}

	/**
	 * Tests adding elements to an empty ArrayList. Then tests adding elements to
	 * the front, middle, and back of a ArrayList. The size and contents should be
	 * checked after each insertion. Additionally, the bounds of the list should be
	 * checked and null elements should not be added to the list. Finally, test that
	 * the ArrayList with an initial capacity of 10 grows when an 11th element is
	 * added. Test method for {@link ArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntE() {
		// Attempt to add an element to index 1 in an empty list.
		// Check that the element was not added.
		try {
			list.add(1, "apple");
			Assertions.fail(
					"ArrayList.addIntE() - Attempted to add element to empty list at index 1.  Should throw IOOBE, but did not.");
		} catch (IndexOutOfBoundsException e) {
			Assertions.assertEquals(0, list.size(),
					"ArrayList.addIntE() - Attempted to add element to empty list at index 1. Size should remain 0, but it was not 0");
		}

		// Add element to empty list
		list.add(0, "apple");
		Assertions.assertEquals(1, list.size(),
				"ArrayList.addIntE() - Attempted to add element at index 0 to an empty list.  Size should be 1, but was not.");
		Assertions.assertEquals("apple", list.get(0),
				"ArrayList.addIntE() - Attempted to add element at index 0 to an empty list.  The element at index 0 was incorrect.");

		// Add element to the front of a list
		list.add(0, "orange");
		Assertions.assertEquals(2, list.size(),
				"ArrayList.addIntE() - Added apple at 0 and orange at 0.  Size should be two but was not.");
		Assertions.assertEquals("orange", list.get(0),
				"ArrayList.addIntE() - Added apple at 0 and orange at 0. orange should be at index 0, but it was not.");
		Assertions.assertEquals("apple", list.get(1),
				"ArrayList.addIntE() - Added apple at 0 and orange at 0. apple should be at index 1, but it was not.");

		// Add element to the middle of a list
		list.add(1, "banana");
		Assertions.assertEquals(3, list.size(),
				"ArrayList.addIntE() - Added apple at 0, orange at 0, and banana at 1.  Size should be three but was not.");
		Assertions.assertEquals("orange", list.get(0),
				"ArrayList.addIntE() - Added apple at 0, orange at 0, and banana at 1. orange should be at index 0, but it was not.");
		Assertions.assertEquals("banana", list.get(1),
				"ArrayList.addIntE() - Added apple at 0, orange at 0, and banana at 1. banana should be at index 1, but it was not.");
		Assertions.assertEquals("apple", list.get(2),
				"ArrayList.addIntE() - Added apple at 0, orange at 0, and banana at 1. apple should be at index 2, but it was not.");

		// Add element to the back of a list
		list.add(3, "kiwi");
		Assertions.assertEquals(4, list.size(),
				"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, and kiwi at 3. Size should be four but was not.");
		Assertions.assertEquals("orange", list.get(0),
				"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, and kiwi at 3. orange should be at index 0, but it was not.");
		Assertions.assertEquals("banana", list.get(1),
				"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, and kiwi at 3. banana should be at index 1, but it was not.");
		Assertions.assertEquals("apple", list.get(2),
				"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, and kiwi at 3. apple should be at index 2, but it was not.");
		Assertions.assertEquals("kiwi", list.get(3),
				"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, and kiwi at 3. kiwi should be at index 3, but it was not.");

		// Attempt to add a null element. Check that the element
		// was not added.
		try {
			list.add(1, null);
			Assertions.fail("ArrayList.addIntE() - cannot add null elements.  A NPE should be thrown, but was not.");
		} catch (NullPointerException e) {
			Assertions.assertEquals(4, list.size(),
					"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, kiwi at 3, and null at 1. Size should be four but was not.");
			Assertions.assertEquals("orange", list.get(0),
					"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, kiwi at 3, and null at 1. orange should be at index 0, but it was not.");
			Assertions.assertEquals("banana", list.get(1),
					"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, kiwi at 3, and null at 1. banana should be at index 1, but it was not.");
			Assertions.assertEquals("apple", list.get(2),
					"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, kiwi at 3, and null at 1. apple should be at index 2, but it was not.");
			Assertions.assertEquals("kiwi", list.get(3),
					"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, kiwi at 3, and null at 1. kiwi should be at index 3, but it was not.");
		}

		// Attempt to add at index -1. Check that the element was not
		// added.
		try {
			list.add(-1, "mango");
			Assertions.fail(
					"ArrayList.addIntE() - cannot add an element at -1.  An IOOBE should be thrown, but was not.");
		} catch (IndexOutOfBoundsException e) {
			Assertions.assertEquals(4, list.size(),
					"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, kiwi at 3, and mango at -1. Size should be four but was not.");
			Assertions.assertEquals("orange", list.get(0),
					"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, kiwi at 3, and mango at -1. orange should be at index 0, but it was not.");
			Assertions.assertEquals("banana", list.get(1),
					"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, kiwi at 3, and mango at -1. banana should be at index 1, but it was not.");
			Assertions.assertEquals("apple", list.get(2),
					"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, kiwi at 3, and mango at -1. apple should be at index 2, but it was not.");
			Assertions.assertEquals("kiwi", list.get(3),
					"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, kiwi at 3, and mango at -1. kiwi should be at index 3, but it was not.");
		}

		// Attempt to add at index 5 (since there are 4 elements in the list).
		// Check that the element was not added.
		try {
			list.add(5, "mango");
			Assertions.fail(
					"ArrayList.addIntE() - cannot add an element at 5 if size is 4.  An IOOBE should be thrown, but was not.");
		} catch (IndexOutOfBoundsException e) {
			Assertions.assertEquals(4, list.size(),
					"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, kiwi at 3, and mango at 5 if size is 4. Size should be four but was not.");
			Assertions.assertEquals("orange", list.get(0),
					"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, kiwi at 3, and mango at 5 if size is 4. orange should be at index 0, but it was not.");
			Assertions.assertEquals("banana", list.get(1),
					"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, kiwi at 3, and mango at 5 if size is 4. banana should be at index 1, but it was not.");
			Assertions.assertEquals("apple", list.get(2),
					"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, kiwi at 3, and mango at 5 if size is 4. apple should be at index 2, but it was not.");
			Assertions.assertEquals("kiwi", list.get(3),
					"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, kiwi at 3, and mango at 5 if size is 4. kiwi should be at index 3, but it was not.");
		}

		// Attempt to add a duplicate element.
		// Check that the element was not added.
		try {
			list.add(1, "apple");
			Assertions.fail(
					"ArrayList.addIntE() - cannot add a duplicate element apple.  An IAE should be thrown, but was not.");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(4, list.size(),
					"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, kiwi at 3, and apple at 1 (duplicate value). Size should be four but was not.");
			Assertions.assertEquals("orange", list.get(0),
					"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, kiwi at 3, and apple at 1 (duplicate value). orange should be at index 0, but it was not.");
			Assertions.assertEquals("banana", list.get(1),
					"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, kiwi at 3, and apple at 1 (duplicate value). banana should be at index 1, but it was not.");
			Assertions.assertEquals("apple", list.get(2),
					"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, kiwi at 3, and apple at 1 (duplicate value). apple should be at index 2, but it was not.");
			Assertions.assertEquals("kiwi", list.get(3),
					"ArrayList.addIntE() - Added apple at 0, orange at 0, banana at 1, kiwi at 3, and apple at 1 (duplicate value). kiwi should be at index 3, but it was not.");
		}

		// Test adding an 11th element to an ArrayList with an initial
		// capacity of 10.

		list.add(4, "cherry");
		list.add(5, "blueberry");
		list.add(6, "pineapple");
		list.add(7, "pear");
		list.add(8, "grapes");
		list.add(9, "lemon");
		list.add(10, "lime");
		Assertions.assertEquals(11, list.size(), "ArrayList.addIntE() - added 11 elements, but size is incorrect.");
		Assertions.assertEquals("orange", list.get(0),
				"ArrayList.addIntE() - added 11 elements, orange should be at 0, but was not");
		Assertions.assertEquals("banana", list.get(1),
				"ArrayList.addIntE() - added 11 elements, banana should be at 1, but was not");
		Assertions.assertEquals("apple", list.get(2),
				"ArrayList.addIntE() - added 11 elements, apple should be at 2, but was not");
		Assertions.assertEquals("kiwi", list.get(3),
				"ArrayList.addIntE() - added 11 elements, kiwi should be at 3, but was not");
		Assertions.assertEquals("cherry", list.get(4),
				"ArrayList.addIntE() - added 11 elements, cherry should be at 4, but was not");
		Assertions.assertEquals("blueberry", list.get(5),
				"ArrayList.addIntE() - added 11 elements, blueberry should be at 5, but was not");
		Assertions.assertEquals("pineapple", list.get(6),
				"ArrayList.addIntE() - added 11 elements, pineapple should be at 6, but was not");
		Assertions.assertEquals("pear", list.get(7),
				"ArrayList.addIntE() - added 11 elements, pear should be at 7, but was not");
		Assertions.assertEquals("grapes", list.get(8),
				"ArrayList.addIntE() - added 11 elements, grapes should be at 8, but was not");
		Assertions.assertEquals("lemon", list.get(9),
				"ArrayList.addIntE() - added 11 elements, lemon should be at 9, but was not");
		Assertions.assertEquals("lime", list.get(10),
				"ArrayList.addIntE() - added 11 elements, lime should be at 10, but was not");

	}

	/**
	 * Tests that elements are correctly removed from the front, middle, and back of
	 * an ArrayList. Removing the last element should leave an empty list. The
	 * bounds are checked for the appropriate exceptions. Test method for
	 * {@link ArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveInt() {
		// Attempt to remove an element from an empty list
		String s = null;
		try {
			s = list.remove(0);
			Assertions.fail(
					"ArrayList.remove() - Attempting to remove an element from an empty list should throw an IOOBE, but it did not.");
		} catch (IndexOutOfBoundsException e) {
			Assertions.assertNull(s, 
					"ArrayList.remove() - Attempting to remove an element from an empty list should not return a non-null object.");
		}

		// Add 4 elements to the list and test that the contents are correct.
		// Reuse code from your testAddIntE.
		list.add(0, "orange");
		list.add(1, "banana");
		list.add(2, "apple");
		list.add(3, "kiwi");
		Assertions.assertEquals(4, list.size(),
				"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test.  Size should be 4, but was not.");
		Assertions.assertEquals("orange", list.get(0),
				"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test.  orange should be at index 0, but was not");
		Assertions.assertEquals("banana", list.get(1),
				"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test.  banana should be at index 1, but was not.");
		Assertions.assertEquals("apple", list.get(2),
				"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test.  apple should be at index 2, but was not.");
		Assertions.assertEquals("kiwi", list.get(3),
				"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test.  kiwi should be at index 3, but was not.");

		// Test that IndexOutOfBoundsException is thrown when remove() is passed
		// a negative index. Make sure the list is unchanged.
		try {
			s = list.remove(-1);
			Assertions.fail(
					"ArrayList.remove() - Attempting to remove an element from index -1 should throw an IOOBE, but it did not.");
		} catch (IndexOutOfBoundsException e) {
			Assertions.assertNull(s,
					"ArryList.remove() - Attempting to remove an element from index -1 threw the IOOBE, but still returned a non-null object.");
			Assertions.assertEquals(4, list.size(),
					"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test. Attempting to remove an element from index -1.  Size should be 4, but was not.");
			Assertions.assertEquals("orange", list.get(0),
					"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test. Attempting to remove an element from index -1.  orange should be at index 0, but was not.");
			Assertions.assertEquals("banana", list.get(1),
					"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test. Attempting to remove an element from index -1.  banana should be at index 1, but was not.");
			Assertions.assertEquals("apple", list.get(2),
					"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test. Attempting to remove an element from index -1.  apple should be at index 2, but was not.");
			Assertions.assertEquals("kiwi", list.get(3),
					"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test. Attempting to remove an element from index -1.  kiwi should be at index 3, but was not.");
		}

		// Test that IndexOutOfBoundsException is thrown when remove() is passed
		// an index > size() - 1. Make sure the list is unchanged.
		try {
			s = list.remove(4);
			Assertions.fail(
					"ArrayList.remove() - Attempting to remove an element from index 4 should throw an IOOBE, but it did not.");
		} catch (IndexOutOfBoundsException e) {
			Assertions.assertNull(s,
					"ArryList.remove() - Attempting to remove an element from index 4 threw the IOOBE, but still returned a non-null object.");
			Assertions.assertEquals(4, list.size(),
					"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test. Attempting to remove an element from index 4.  Size should be 4, but was not.");
			Assertions.assertEquals("orange", list.get(0),
					"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test. Attempting to remove an element from index 4.  orange should be at index 0, but was not.");
			Assertions.assertEquals("banana", list.get(1),
					"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test. Attempting to remove an element from index 4.  banana should be at index 1, but was not.");
			Assertions.assertEquals("apple", list.get(2),
					"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test. Attempting to remove an element from index 4.  apple should be at index 2, but was not.");
			Assertions.assertEquals("kiwi", list.get(3),
					"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test. Attempting to remove an element from index 4.  kiwi should be at index 3, but was not.");
		}

		// Remove middle element. Test that the removed element is correct and
		// that the remaining list is correct after the removal.
		String s1 = list.remove(1);
		Assertions.assertEquals(s1, "banana",
				"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test. Removed element at index 1. Returned value should be banana, but was not.");
		Assertions.assertEquals(3, list.size(),
				"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test. Removed element at index 1. Size should be three but was not.");
		Assertions.assertEquals("orange", list.get(0),
				"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test. Removed element at index 1. Element at index 0 should be orange, but was not.");
		Assertions.assertEquals("apple", list.get(1),
				"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test. Removed element at index 1. Element at index 1 should be apple, but was not.");
		Assertions.assertEquals("kiwi", list.get(2),
				"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test. Removed element at index 1. Element at index 2 should be kiwi, but was not.");

		// Remove first element
		String s2 = list.remove(0);
		Assertions.assertEquals(s2, "orange",
				"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test. Removed element at index 1 then index 0. Returned value should be orange, but was not.");
		Assertions.assertEquals(2, list.size(),
				"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test. Removed element at index 1 then index 0. Size should be two but was not.");
		Assertions.assertEquals("apple", list.get(0),
				"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test. Removed element at index 1 then index 0. Element at index 0 should be apple, but was not.");
		Assertions.assertEquals("kiwi", list.get(1),
				"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test. Removed element at index 1 then index 0. Element at index 1 should be kiwi, but was not.");

		// Remove last element
		String s3 = list.remove(1);
		Assertions.assertEquals(s3, "kiwi",
				"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test. Removed element at index 1 then index 0 then index 1. Returned value should be kiwi, but was not.");
		Assertions.assertEquals(1, list.size(),
				"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test. Removed element at index 1 then index 0 then index 1. Size should be one but was not.");
		Assertions.assertEquals("apple", list.get(0),
				"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test. Removed element at index 1 then index 0 then index 1. Element at index 0 should be apple, but was not.");

		// Remove only element
		String s4 = list.remove(0);
		Assertions.assertEquals(s4, "apple",
				"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test. Removed element at index 1 then index 0 then 1 then 0. Returned value should be apple, but was not.");
		Assertions.assertEquals(0, list.size(),
				"ArrayList.remove() - Adding elements orange, banana, apple, and kiwi to set up remove test. Removed element at index 1 then index 0 then 1 then 0. Size should be zero but was not.");

	}

	/**
	 * Tests setting an element in an empty list, the bounds of the list when using
	 * the set() method, and setting an element at the front, middle, and back of
	 * the list. The set() method is also passed null. Test method for
	 * {@link ArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSetIntE() {
		// Attempt to set a value in an empty list
		String s = null;
		try {
			s = list.set(0, "strawberry");
			Assertions.fail(
					"ArrayList.set() - IOOBE should be thrown when attempting to set a value at index 0 in an empty list, but it was not thrown.");
		} catch (IndexOutOfBoundsException e) {
			Assertions.assertNull(s,
					"ArrayList.set() - IOOBE was thrown when attempting to set a value at index 0 in an empty list, but set returned a non-null object.");
		}

		// Add 4 elements to the list and test that the contents are correct.
		// Reuse code from your testAddIntE.
		list.add(0, "orange");
		list.add(1, "banana");
		list.add(2, "apple");
		list.add(3, "kiwi");
		Assertions.assertEquals(4, list.size(),
				"ArrayList.set() - Adding elements orange, banana, apple, and kiwi to set up set test.  Size should be 4, but was not.");
		Assertions.assertEquals("orange", list.get(0),
				"ArrayList.set() - Adding elements orange, banana, apple, and kiwi to set up set test.  orange should be at index 0, but was not.");
		Assertions.assertEquals("banana", list.get(1),
				"ArrayList.set() - Adding elements orange, banana, apple, and kiwi to set up set test.  banana should be at index 1, but was not.");
		Assertions.assertEquals("apple", list.get(2),
				"ArrayList.set() - Adding elements orange, banana, apple, and kiwi to set up set test.  apple should be at index 2, but was not.");
		Assertions.assertEquals("kiwi", list.get(3),
				"ArrayList.set() - Adding elements orange, banana, apple, and kiwi to set up set test.  kiwi should be at index 3, but was not.");

		// Test that IndexOutOfBoundsException is thrown when set() is passed
		// a negative index. Make sure the list is unchanged.
		try {
			s = list.set(-1, "strawberry");
			Assertions.fail(
					"ArrayList.set() - Attempting to set an element from index -1 should throw an IOOBE, but it did not.");
		} catch (IndexOutOfBoundsException e) {
			Assertions.assertNull(s,
					"ArryList.set() - Attempting to set an element from index -1 threw the IOOBE, but still returned a non-null object.");
			Assertions.assertEquals(4, list.size(),
					"ArrayList.set() - Adding elements orange, banana, apple, and kiwi to set up set test. Attempting to set an element at index -1.  Size should be 4, but was not.");
			Assertions.assertEquals("orange", list.get(0),
					"ArrayList.set() - Adding elements orange, banana, apple, and kiwi to set up set test. Attempting to set an element at index -1.  orange should be at index 0, but was not.");
			Assertions.assertEquals("banana", list.get(1),
					"ArrayList.set() - Adding elements orange, banana, apple, and kiwi to set up set test. Attempting to set an element at index -1.  banana should be at index 1, but was not.");
			Assertions.assertEquals("apple", list.get(2),
					"ArrayList.set() - Adding elements orange, banana, apple, and kiwi to set up set test. Attempting to set an element at index -1.  apple should be at index 2, but was not.");
			Assertions.assertEquals("kiwi", list.get(3),
					"ArrayList.set() - Adding elements orange, banana, apple, and kiwi to set up set test. Attempting to set an element at index -1.  kiwi should be at index 3, but was not.");
		}

		// Test that IndexOutOfBoundsException is thrown when remove() is passed
		// an index > size() - 1. Make sure the list is unchanged.
		try {
			s = list.remove(4);
			Assertions.fail(
					"ArrayList.set() - Attempting to set an element from index 4 should throw an IOOBE, but it did not.");
		} catch (IndexOutOfBoundsException e) {
			Assertions.assertNull(s,
					"ArryList.set() - Attempting to set an element from index 4 threw the IOOBE, but still returned a non-null object.");
			Assertions.assertEquals(4, list.size(),
					"ArrayList.set() - Adding elements orange, banana, apple, and kiwi to set up set test. Attempting to set an element from index 4.  Size should be 4, but was not.");
			Assertions.assertEquals("orange", list.get(0),
					"ArrayList.set() - Adding elements orange, banana, apple, and kiwi to set up set test. Attempting to set an element from index 4.  orange should be at index 0, but was not.");
			Assertions.assertEquals("banana", list.get(1),
					"ArrayList.set() - Adding elements orange, banana, apple, and kiwi to set up set test. Attempting to set an element from index 4.  banana should be at index 1, but was not.");
			Assertions.assertEquals("apple", list.get(2),
					"ArrayList.set() - Adding elements orange, banana, apple, and kiwi to set up set test. Attempting to set an element from index 4.  apple should be at index 2, but was not.");
			Assertions.assertEquals("kiwi", list.get(3),
					"ArrayList.set() - Adding elements orange, banana, apple, and kiwi to set up set test. Attempting to set an element from index 4.  kiwi should be at index 3, but was not.");
		}

		// Set middle element. Test that the element is modified correctly, set()
		// returns the
		// right value, and that the rest of the list is correct.
		String s1 = list.set(1, "strawberry");
		Assertions.assertEquals(s1, "banana",
				"ArrayList.set() - List of four orange, banana, apple, and kiwi.  Call to set(1, \"strawberry\", should return banana, but did not.");
		Assertions.assertEquals(4, list.size(),
				"ArrayList.set() - List of four orange, banana, apple, and kiwi. Set 1 to strawberry. Call to set should leave size 4, but it did not.");
		Assertions.assertEquals("orange", list.get(0),
				"ArrayList.set() - List of four orange, banana, apple, and kiwi. Set 1 to strawberry. orange should be at index 0, but was not.");
		Assertions.assertEquals("strawberry", list.get(1),
				"ArrayList.set() - List of four orange, banana, apple, and kiwi. Set 1 to strawberry. strawberry should be at index 1, but was not");
		Assertions.assertEquals("apple", list.get(2),
				"ArrayList.set() - List of four orange, banana, apple, and kiwi. Set 1 to strawberry. apple should be at index 2, but was not");
		Assertions.assertEquals("kiwi", list.get(3),
				"ArrayList.set() - List of four orange, banana, apple, and kiwi. Set 1 to strawberry. kiwi should be at index 3, but was not");

		// Set first element
		String s2 = list.set(0, "blackberry");
		Assertions.assertEquals(s2, "orange",
				"ArrayList.set() - List of four orange, banana, apple, and kiwi.  Call to set(0, \"blackberry\", should return orange, but did not.");
		Assertions.assertEquals(4, list.size(),
				"ArrayList.set() - List of four orange, banana, apple, and kiwi. Set 1 to strawberry and 0 to blackberry. Call to set should leave size 4, but it did not.");
		Assertions.assertEquals("blackberry", list.get(0),
				"ArrayList.set() - List of four orange, banana, apple, and kiwi. Set 1 to strawberry and 0 to blackberry. blackberry should be at index 0, but was not.");
		Assertions.assertEquals("strawberry", list.get(1),
				"ArrayList.set() - List of four orange, banana, apple, and kiwi. Set 1 to strawberry and 0 to blackberry. strawberry should be at index 1, but was not.");
		Assertions.assertEquals("apple", list.get(2),
				"ArrayList.set() - List of four orange, banana, apple, and kiwi. Set 1 to strawberry and 0 to blackberry. apple should be at index 2, but was not.");
		Assertions.assertEquals("kiwi", list.get(3),
				"ArrayList.set() - List of four orange, banana, apple, and kiwi. Set 1 to strawberry and 0 to blackberry. kiwi should be at index 3, but was not.");

		// Set last element
		String s3 = list.set(3, "passion fruit");
		Assertions.assertEquals(s3, "kiwi",
				"ArrayList.set() - List of four orange, banana, apple, and kiwi.  Call to set(3, \"passion fruit\", should return kiwi, but did not.");
		Assertions.assertEquals(4, list.size(),
				"ArrayList.set() - List of four orange, banana, apple, and kiwi. Set 1 to strawberry, 0 to blackberry, 3 to passion fruit. Call to set should leave size 4, but it did not.");
		Assertions.assertEquals("blackberry", list.get(0),
				"ArrayList.set() - List of four orange, banana, apple, and kiwi. Set 1 to strawberry, 0 to blackberry, 3 to passion fruit. blackberry should be at index 0, but was not.");
		Assertions.assertEquals("strawberry", list.get(1),
				"ArrayList.set() - List of four orange, banana, apple, and kiwi. Set 1 to strawberry, 0 to blackberry, 3 to passion fruit. strawberry should be at index 1, but was not.");
		Assertions.assertEquals("apple", list.get(2),
				"ArrayList.set() - List of four orange, banana, apple, and kiwi. Set 1 to strawberry, 0 to blackberry, 3 to passion fruit. apple should be at index 2, but was not.");
		Assertions.assertEquals("passion fruit", list.get(3),
				"ArrayList.set() - List of four orange, banana, apple, and kiwi. Set 1 to strawberry, 0 to blackberry, 3 to passion fruit. passion fruit should be at index 3, but was not.");

		// Attempt to set an element to null. Check that the element
		// was not modified.
		try {
			s = list.set(2, null);
			Assertions.fail("ArrayList.set() ");
		} catch (NullPointerException e) {
			Assertions.assertNull(s);
			Assertions.assertEquals(4, list.size());
			Assertions.assertEquals("blackberry", list.get(0));
			Assertions.assertEquals("strawberry", list.get(1));
			Assertions.assertEquals("apple", list.get(2));
			Assertions.assertEquals("passion fruit", list.get(3));
		}

		// Attempt to set a null element. Check that the element
		// was not added.
		try {
			s = list.set(2, null);
			Assertions.fail("ArrayList.set() - cannot set null elements.  A NPE should be thrown, but was not.");
		} catch (NullPointerException e) {
			Assertions.assertEquals(4, list.size(),
					"ArrayList.set() - List was blackberry, strawberry, apple, passion fruit.  Tried to set value at index 1 to null.  List should have remained size 4, but did not.");
			Assertions.assertEquals("blackberry", list.get(0),
					"ArrayList.set() - List was blackberry, strawberry, apple, passion fruit.  Tried to set value at index 1 to null.  blackberry should be at index 0, but was not.");
			Assertions.assertEquals("strawberry", list.get(1),
					"ArrayList.set() - List was blackberry, strawberry, apple, passion fruit.  Tried to set value at index 1 to null.  strawberry should be at index 1, but was not.");
			Assertions.assertEquals("apple", list.get(2),
					"ArrayList.set() - List was blackberry, strawberry, apple, passion fruit.  Tried to set value at index 1 to null.  apple should be at index 2, but was not.");
			Assertions.assertEquals("passion fruit", list.get(3),
					"ArrayList.set() - List was blackberry, strawberry, apple, passion fruit.  Tried to set value at index 1 to null.  passion fruit should be at index 3, but was not.");
		}

		// Attempt to set a null element. Check that the element
		// was not added.
		try {
			s = list.set(2, "strawberry");
			Assertions.fail("ArrayList.set() - cannot set duplicate elements.  A IAE should be thrown, but was not.");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(4, list.size(),
					"ArrayList.set() - List was blackberry, strawberry, apple, passion fruit.  Tried to set value at index 2 to strawberry.  List should have remained size 4, but did not.");
			Assertions.assertEquals("blackberry", list.get(0),
					"ArrayList.set() - List was blackberry, strawberry, apple, passion fruit.  Tried to set value at index 2 to strawberry.  blackberry should be at index 0, but was not.");
			Assertions.assertEquals("strawberry", list.get(1),
					"ArrayList.set() - List was blackberry, strawberry, apple, passion fruit.  Tried to set value at index 2 to strawberry.  strawberry should be at index 1, but was not.");
			Assertions.assertEquals("apple", list.get(2),
					"ArrayList.set() - List was blackberry, strawberry, apple, passion fruit.  Tried to set value at index 2 to strawberry.  apple should be at index 2, but was not.");
			Assertions.assertEquals("passion fruit", list.get(3),
					"ArrayList.set() - List was blackberry, strawberry, apple, passion fruit.  Tried to set value at index 2 to strawberry.  passion fruit should be at index 3, but was not.");
		}
	}

	/**
	 * Main get() functionality is tested in the other test methods. This method
	 * will focus on testing the exceptions associated with bounds. Test method for
	 * {@link ArrayList#get(int)}.
	 */
	@Test
	public void testGetInt() {
		// Add 4 elements to the list and test that the contents are correct.
		// Reuse code from your testAddIntE.
		list.add(0, "orange");
		list.add(1, "banana");
		list.add(2, "apple");
		list.add(3, "kiwi");
		Assertions.assertEquals(4, list.size(),
				"ArrayList.set() - Adding elements orange, banana, apple, and kiwi to set up set test.  Size should be 4, but was not.");
		Assertions.assertEquals("orange", list.get(0),
				"ArrayList.set() - Adding elements orange, banana, apple, and kiwi to set up set test.  orange should be at index 0, but was not");
		Assertions.assertEquals("banana", list.get(1),
				"ArrayList.set() - Adding elements orange, banana, apple, and kiwi to set up set test.  banana should be at index 1, but was not.");
		Assertions.assertEquals("apple", list.get(2),
				"ArrayList.set() - Adding elements orange, banana, apple, and kiwi to set up set test.  apple should be at index 2, but was not.");
		Assertions.assertEquals("kiwi", list.get(3),
				"ArrayList.set() - Adding elements orange, banana, apple, and kiwi to set up set test.  kiwi should be at index 3, but was not.");

		// Test that IndexOutOfBoundsException is thrown when get() is passed
		// a negative index. Make sure the list is unchanged.
		String s = null;
		try {
			s = list.get(-1);
			Assertions.fail(
					"ArrayList.get() - Attempting to get an element from index -1 should throw an IOOBE, but it did not.");
		} catch (IndexOutOfBoundsException e) {
			Assertions.assertNull(s,
					"ArryList.get() - Attempting to get an element from index -1 threw the IOOBE, but still returned a non-null object.");
			Assertions.assertEquals(4, list.size(),
					"ArrayList.get() - Adding elements orange, banana, apple, and kiwi to set up get test. Attempting to get an element at index -1.  Size should be 4, but was not.");
			Assertions.assertEquals("orange", list.get(0),
					"ArrayList.get() - Adding elements orange, banana, apple, and kiwi to set up get test. Attempting to get an element at index -1.  orange should be at index 0, but was not.");
			Assertions.assertEquals("banana", list.get(1),
					"ArrayList.get() - Adding elements orange, banana, apple, and kiwi to set up get test. Attempting to get an element at index -1.  banana should be at index 1, but was not.");
			Assertions.assertEquals("apple", list.get(2),
					"ArrayList.get() - Adding elements orange, banana, apple, and kiwi to set up get test. Attempting to get an element at index -1.  apple should be at index 2, but was not.");
			Assertions.assertEquals("kiwi", list.get(3),
					"ArrayList.get() - Adding elements orange, banana, apple, and kiwi to set up get test. Attempting to get an element at index -1.  kiwi should be at index 3, but was not.");
		}

		// Test that IndexOutOfBoundsException is thrown when get() is passed
		// an index > size() - 1. Make sure the list is unchanged.
		try {
			s = list.get(4);
			Assertions.fail(
					"ArrayList.get() - Attempting to get an element from index 4 should throw an IOOBE, but it did not.");
		} catch (IndexOutOfBoundsException e) {
			Assertions.assertNull(s,
					"ArryList.get() - Attempting to get an element from index 4 threw the IOOBE, but still returned a non-null object.");
			Assertions.assertEquals(4, list.size(),
					"ArrayList.get() - Adding elements orange, banana, apple, and kiwi to set up get test. Attempting to get an element from index 4.  Size should be 4, but was not.");
			Assertions.assertEquals("orange", list.get(0),
					"ArrayList.get() - Adding elements orange, banana, apple, and kiwi to set up get test. Attempting to get an element from index 4.  orange should be at index 0, but was not.");
			Assertions.assertEquals("banana", list.get(1),
					"ArrayList.get() - Adding elements orange, banana, apple, and kiwi to set up get test. Attempting to get an element from index 4.  banana should be at index 1, but was not.");
			Assertions.assertEquals("apple", list.get(2),
					"ArrayList.get() - Adding elements orange, banana, apple, and kiwi to set up get test. Attempting to get an element from index 4.  apple should be at index 2, but was not.");
			Assertions.assertEquals("kiwi", list.get(3),
					"ArrayList.get() - Adding elements orange, banana, apple, and kiwi to set up get test. Attempting to get an element from index 4.  kiwi should be at index 3, but was not.");
		}
	}

}