package edu.bowdoin.csci.PolarScheduler.scheduler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.bowdoin.csci.PolarScheduler.course.Course;
import edu.bowdoin.csci.PolarScheduler.scheduler.PolarScheduler;
import edu.bowdoin.csci.PolarScheduler.utils.ArrayList;

public class PolarSchedulerTest {
	
    PolarScheduler scheduler = new PolarScheduler();
    Course course1;
    Course course2;

	
	@BeforeEach
	public void setUp() throws Exception {
		scheduler = new PolarScheduler();
		
		course1 = new Course("EOS 1020", "Earth", "123", "Cooler", "MTW", 1120, 1220);
		course2 = new Course("CSCI 1101", "Computer", "321", "Warmer", "TWH", 1020, 1220);
		
	}
	
	/**
	* Tests constructor.
	* 
	* @void
	 */
	@Test
	public void testPolarScheduler() {
		
		
		//Ensures schedule is set to proper title
		Assertions.assertEquals("My Schedule", scheduler.getScheduleTitle());		
	}
	
	/**
	* Tests createNewCourse with Course parameter.
	* 
	* @void
	 */
	@Test
	public void testCreateNewCourse() {
		
		
		//Tries to create the same course twice, which should lead to false
    	scheduler.createNewCourse(course1);
    	Assertions.assertEquals(false, scheduler.createNewCourse(course1));
    	
    	//Tries to add second course, which should be true
    	Assertions.assertEquals(true, scheduler.createNewCourse(course2));
	}
	
	/**
	* Tests getCourseFromCatalogue.
	* 
	* @void
	 */
	@Test
	public void testGetCourseFromCatalogue() {
		
		//Add courses to catalogue
    	scheduler.createNewCourse(course1);
    	scheduler.createNewCourse(course2);
		
	    //Tries to get course1 and course2, should return them respectively
    	Assertions.assertEquals(course1, scheduler.getCourseFromCatalogue("EOS 1020", "123"));
    	Assertions.assertEquals(course2, scheduler.getCourseFromCatalogue("CSCI 1101", "321"));           
	        
	    //Ensures a course that is not in the catalogue returns null
    	Assertions.assertEquals(null, scheduler.getCourseFromCatalogue("ABDC 1234", "0011"));           
	}
	
	/**
	* Tests addCourseToSchedule.
	* 
	* @void
	 */
	@Test
	public void testAddCourseToSchedule() {
		
		//Add courses to catalogue
    	scheduler.createNewCourse(course1);
    	scheduler.createNewCourse(course2);
    	
	    //Ensures courses are added and true value is returned
    	Assertions.assertEquals(true, scheduler.addCourseToSchedule("EOS 1020", "123"));
    	Assertions.assertEquals(true, scheduler.addCourseToSchedule("CSCI 1101", "321"));
	       
    	
	    //Ensures a course not in catalogue returns false
	    Assertions.assertEquals(false, scheduler.addCourseToSchedule("ABDC 1234", "0011"));
	        
	    
	    //Ensures a course already added to schedule throws and IllegalArgumentException
	    try {
	    	
	    	scheduler.addCourseToSchedule("CSCI 1101", "321");
	    	Assertions.fail("Should throw an IllegalArgumentException for adding a course already added but did not");
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	}
	
	/**
	* Tests createNewCourse with all Course class parameters.
	* 
	* @void
	 */
	@Test
	public void testCreateNewCourse2() {
		
		//Add courses to catalogue
    	scheduler.createNewCourse(course1);
    	scheduler.createNewCourse(course2);
	                   
    	Assertions.assertEquals(course2, scheduler.getCourseFromCatalogue("CSCI 1101", "321"));
		
		//Tries to create a duplicate course
	    try {
	    	
	    	scheduler.createNewCourse("EOS 1020", "Earth", "123", "Cooler", "MTW", 1120, 1220);
	    	Assertions.fail("Should throw IllegalArgumentException for creating duplicate class but did not");
	                   
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
		//Tries to create a course with a null startTime
	    try {
	    	
	    	scheduler.createNewCourse("CSCI 1101", "Computer", "321", "Warmer", "TWH", null, 1220);
	    	Assertions.fail("Should throw IllegalArgumentException for having null startTime but did not");
	                   
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	    
	    
		//Tries to create a course with null endTime
	    try {
	    	
	    	scheduler.createNewCourse("CSCI 1101", "Computer", "321", "Warmer", "TWH", 1120, null);
	    	Assertions.fail("Should throw IllegalArgumentException for having null endTime but did not");
	                   
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	    
	    
		//Tries to create a course with A 
	    try {
	    	
	    	scheduler.createNewCourse("CSCI 1101", "Computer", "321", "Warmer", "TWH", 1120, 1220);
	    	Assertions.fail("Should throw IllegalArgumentException for having non Integer endtime");
	                   
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
		//Tries to create a course with negative start time 
	    try {
	    	
	    	scheduler.createNewCourse("CSCI 1101", "Computer", "321", "Warmer", "TWH", -1120, 1220);
	    	Assertions.fail("Should throw IllegalArgumentException for having negative startTime");
	                   
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
		//Tries to create a course with more than one weekday when it is A 
	    try {
	    	
	    	scheduler.createNewCourse("CSCI 1101", "Computer", "321", "Warmer", "AM", 0, 0);
	    	Assertions.fail("Should throw IllegalArgumentException for having negative startTime");
	                   
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
		//Tries to create a course with A weekday and a start and end time
	    try {
	    	
	    	scheduler.createNewCourse("CSCI 1101", "Computer", "321", "Warmer", "A", 1000, 1200);
	    	Assertions.fail("Should throw IllegalArgumentException for having negative startTime");
	                   
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	}
	
	/**
	* Tests createNewCourse with all Course class parameters as Strings.
	* 
	* @void
	 */
	@Test
	public void testCreateNewCourse3() {
		
		//Add courses to catalogue
    	scheduler.createNewCourse(course1);
    	scheduler.createNewCourse(course2);
	                   
    	Assertions.assertEquals(course2, scheduler.getCourseFromCatalogue("CSCI 1101", "321"));
		
		//Tries to create a duplicate course
	    try {
	    	
	    	scheduler.createNewCourse("EOS 1020", "Earth", "123", "Cooler", "MTW", "1120", "1220");
	    	Assertions.fail("Should throw IllegalArgumentException for creating duplicate class but did not");
	                   
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
		//Tries to create a course with a null startTime
	    try {
	    	
	    	scheduler.createNewCourse("CSCI 1101", "Computer", "321", "Warmer", "TWH", null, "1220");
	    	Assertions.fail("Should throw IllegalArgumentException for having null startTime but did not");
	                   
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }	    
	    
		//Tries to create a course with null endTime
	    try {
	    	
	    	scheduler.createNewCourse("CSCI 1101", "Computer", "321", "Warmer", "TWH", "1120", null);
	    	Assertions.fail("Should throw IllegalArgumentException for having null endTime but did not");	                   
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	        
		//Tries to create a course with A 
	    try {
	    	
	    	scheduler.createNewCourse("CSCI 1101", "Computer", "321", "Warmer", "TWH", "1120", "1220");
	    	Assertions.fail("Should throw IllegalArgumentException for having non Integer endtime");
	                           
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	  //Tries to create a course with negative start time 
	    try {
	    	
	    	scheduler.createNewCourse("CSCI 1101", "Computer", "321", "Warmer", "TWH", "-1120", "1220");
	    	Assertions.fail("Should throw IllegalArgumentException for having negative startTime");
	                   
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
		//Tries to create a course with more than one weekday when it is A 
	    try {
	    	
	    	scheduler.createNewCourse("CSCI 1101", "Computer", "321", "Warmer", "AM", "0", "0");
	    	Assertions.fail("Should throw IllegalArgumentException for having negative startTime");
	                   
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
		//Tries to create a course with A weekday and a start and end time
	    try {
	    	
	    	scheduler.createNewCourse("CSCI 1101", "Computer", "321", "Warmer", "A", "1000", "1200");
	    	Assertions.fail("Should throw IllegalArgumentException for having negative startTime");
	                   
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	}
	
	/**
	* Tests removeCourseFromSchedule.
	* 
	* @void
	 */
	@Test
	public void testRemoveCourseFromSchedule() {
		
		//Add courses to catalogue
    	scheduler.createNewCourse(course1);
    	scheduler.createNewCourse(course2);
    	
    	//Add courses to schedule
    	scheduler.addCourseToSchedule("EOS 1020", "123");
    	scheduler.addCourseToSchedule("CSCI 1101", "321");
    	
    	//Tests removing added courses
    	Assertions.assertEquals(true, scheduler.removeCourseFromSchedule("EOS 1020", "123"));
    	Assertions.assertEquals(true, scheduler.removeCourseFromSchedule("CSCI 1101", "321"));
    	
    	//Tests removing a non-existent course
    	Assertions.assertEquals(false, scheduler.removeCourseFromSchedule("ABCD 1234", "0000"));
	}
	
	/**
	* Tests resetSchedule.
	* 
	* @void
	 */
	@Test
	public void testResetSchedule() {
		
		//Add courses to catalogue
    	scheduler.createNewCourse(course1);
    	scheduler.createNewCourse(course1);
    	
    	//Add courses to schedule
    	scheduler.addCourseToSchedule("EOS 1020", "123");
    	scheduler.addCourseToSchedule("CSCI 1101", "321");
    	
    	//Reset schedule
    	scheduler.resetSchedule();
    	
    	//Should receive false if trying to remove a course from a reset schedule
    	Assertions.assertEquals(false, scheduler.removeCourseFromSchedule("EOS 1020", "123"));		
	}
	
	/**
	* Tests getCourseCatalogue.
	* 
	* @void
	 */
	@Test
	public void testGetCourseCatalogue() {
    	
		//Add course to catalogue
		scheduler.createNewCourse(course1);
    	scheduler.createNewCourse(course2);	
    	
    	//Get catalogue and create 2d array of expected output
    	String[][] newArray = scheduler.getCourseCatalogue();
    	String[][] testCatalogue = {{"EOS 1020", "123", "Earth"}, {"CSCI 1101", "321", "Computer"}};
		
    	//Assert they are they same
    	Assertions.assertArrayEquals(testCatalogue, newArray);
    	
    	//Add a third course to the catalogue
    	Course course3 = new Course("CSCI 2101", "Computation", "321", "Torres", "TWH", 1020, 1220);
    	scheduler.createNewCourse(course3);	
    	
    	//Get catalogue and create 2d array of expected output
    	newArray = scheduler.getCourseCatalogue();
    	String[][] testCatalogue1 = {{"EOS 1020", "123", "Earth"}, {"CSCI 1101", "321", "Computer"}, {"CSCI 2101", "321", "Computation"}};
    	
    	//Assert they are equal
    	Assertions.assertArrayEquals(testCatalogue1, newArray);
	}
	
	/**
	* Tests getScheduledCourses.
	* 
	* @void
	 */
	@Test
	public void testGetScheduledCourses() {
		
		//Add courses to catalogue
		scheduler.createNewCourse(course1);
    	scheduler.createNewCourse(course2);
    	
    	//Add courses to schedule
    	scheduler.addCourseToSchedule("EOS 1020", "123");
    	scheduler.addCourseToSchedule("CSCI 1101", "321");
    	
    	//Get schedule and create 2d array of expected output
    	String[][] newArray = scheduler.getScheduledCourses();
    	String[][] testCatalogue = {{"EOS 1020", "123", "Earth"}, {"CSCI 1101", "321", "Computer"}};
		
    	//Assert they are the same
    	Assertions.assertArrayEquals(testCatalogue, newArray);
    	
    	//Add third course
    	Course course3 = new Course("CSCI 2101", "Computation", "321", "Torres", "TWH", 1020, 1220);
    	scheduler.createNewCourse(course3);	
    	scheduler.addCourseToSchedule("CSCI 2101", "321");
    	
    	//Get catalogue and create 2d array of expected output
    	newArray = scheduler.getScheduledCourses();
    	String[][] testCatalogue1 = {{"EOS 1020", "123", "Earth"}, {"CSCI 1101", "321", "Computer"}, {"CSCI 2101", "321", "Computation"}};
    	
    	//Assert they are the same
    	Assertions.assertArrayEquals(testCatalogue1, newArray);
		
	}
	
	/**
	* Tests getFullScheduledCourses.
	* 
	* @void
	 */
	@Test
	public void testGetFullScheduledCourses() {
		
		//Add two courses to catalogue
		scheduler.createNewCourse(course1);
    	scheduler.createNewCourse(course2);	
    	
    	//Adds two courses to schedule
    	scheduler.addCourseToSchedule("EOS 1020", "123");
    	scheduler.addCourseToSchedule("CSCI 1101", "321");
    	
    	//Get catalogue and create 2d array of expected output
    	String[][] newArray = scheduler.getFullScheduledCourses();
    	String[][] testCatalogue = {{"EOS 1020", "123", "Earth", "Cooler", "MTW 11:20AM-12:20PM"}, {"CSCI 1101", "321", "Computer", "Warmer", "TWH 10:20AM-12:20PM"}};
    	
    	//Assert they are the same
    	Assertions.assertArrayEquals(testCatalogue, newArray);
    	
    	//Add third course
    	Course course3 = new Course("CSCI 2101", "Computation", "321", "Torres", "TWH", 1020, 1220);
    	scheduler.createNewCourse(course3);	
    	scheduler.addCourseToSchedule("CSCI 2101", "321");
    	
    	//Get catalogue and create 2d array of expected output
    	newArray = scheduler.getFullScheduledCourses();
    	String[][] testCatalogue1 = {{"EOS 1020", "123", "Earth", "Cooler", "MTW 11:20AM-12:20PM"}, {"CSCI 1101", "321", "Computer", "Warmer", "TWH 10:20AM-12:20PM"}, {"CSCI 2101", "321", "Computation", "Torres", "TWH 10:20AM-12:20PM"}};
    	
    	//Assert they are the same
    	Assertions.assertArrayEquals(testCatalogue1, newArray);	
		
    	
    	//Add fourth course
    	Course course4 = new Course("CSCI 2102", "Computational", "321", "Torres", "A", 0, 0);
    	scheduler.createNewCourse(course4);	
    	scheduler.addCourseToSchedule("CSCI 2102", "321");
    	
    	//Get catalogue and create 2d array of expected output
    	newArray = scheduler.getFullScheduledCourses();
    	String[][] testCatalogue2 = {{"EOS 1020", "123", "Earth", "Cooler", "MTW 11:20AM-12:20PM"}, {"CSCI 1101", "321", "Computer", "Warmer", "TWH 10:20AM-12:20PM"}, {"CSCI 2101", "321", "Computation", "Torres", "TWH 10:20AM-12:20PM"}, {"CSCI 2102", "321", "Computational", "Torres", "Arranged"}};
    	
    	//Assert they are the same
    	Assertions.assertArrayEquals(testCatalogue2, newArray);	
    	
    	
    	//Get fifth course
    	Course course5 = new Course("CSCI 3102", "Computationality", "321", "Torres", "M", 1000, 1155);
    	scheduler.createNewCourse(course5);	
    	scheduler.addCourseToSchedule("CSCI 3102", "321");
    	
    	//Get catalogue and create 2d array of expected output
    	newArray = scheduler.getFullScheduledCourses();
    	String[][] testCatalogue3 = {{"EOS 1020", "123", "Earth", "Cooler", "MTW 11:20AM-12:20PM"}, {"CSCI 1101", "321", "Computer", "Warmer", "TWH 10:20AM-12:20PM"}, {"CSCI 2101", "321", "Computation", "Torres", "TWH 10:20AM-12:20PM"}, {"CSCI 2102", "321", "Computational", "Torres", "Arranged"}, {"CSCI 3102", "321", "Computationality", "Torres", "M 10:00AM-11:55AM"}};
    	
    	//Assert they are the same
    	Assertions.assertArrayEquals(testCatalogue3, newArray);	
   
    	
    	//Add sixth course
    	Course course6 = new Course("CSCI 4102", "Comp", "321", "Torres", "M", 1400, 1555);
    	scheduler.createNewCourse(course6);	
    	scheduler.addCourseToSchedule("CSCI 4102", "321");
    	
    	//Get catalogue and create 2d array of expected output
    	newArray = scheduler.getFullScheduledCourses();
    	String[][] testCatalogue4 = {{"EOS 1020", "123", "Earth", "Cooler", "MTW 11:20AM-12:20PM"}, {"CSCI 1101", "321", "Computer", "Warmer", "TWH 10:20AM-12:20PM"}, {"CSCI 2101", "321", "Computation", "Torres", "TWH 10:20AM-12:20PM"}, {"CSCI 2102", "321", "Computational", "Torres", "Arranged"}, {"CSCI 3102", "321", "Computationality", "Torres", "M 10:00AM-11:55AM"}, {"CSCI 4102", "321", "Comp", "Torres", "M 2:00PM-3:55PM"}};
    	
    	//Assert they are the same
    	Assertions.assertArrayEquals(testCatalogue4, newArray);	
    	
    	
    	//Add seventh course
    	Course course7 = new Course("CSCI 5102", "Computate", "321", "Torres", "M", 1205, 1225);
    	scheduler.createNewCourse(course7);	
    	scheduler.addCourseToSchedule("CSCI 5102", "321");
    	
    	//Get catalogue and create 2d array of expected output
    	newArray = scheduler.getFullScheduledCourses();
    	String[][] testCatalogue5 = {{"EOS 1020", "123", "Earth", "Cooler", "MTW 11:20AM-12:20PM"}, {"CSCI 1101", "321", "Computer", "Warmer", "TWH 10:20AM-12:20PM"}, {"CSCI 2101", "321", "Computation", "Torres", "TWH 10:20AM-12:20PM"}, {"CSCI 2102", "321", "Computational", "Torres", "Arranged"}, {"CSCI 3102", "321", "Computationality", "Torres", "M 10:00AM-11:55AM"}, {"CSCI 4102", "321", "Comp", "Torres", "M 2:00PM-3:55PM"}, {"CSCI 5102", "321", "Computate", "Torres", "M 12:05PM-12:25PM"}};
    	
    	//Assert they are the same
    	Assertions.assertArrayEquals(testCatalogue5, newArray);
	}
	
	/**
	* Tests setScheduleTitle.
	* 
	* @void
	 */
	@Test
	public void testSetScheduleTitle() {
		
		//Cannot have null title
		try {
			
			scheduler.setScheduleTitle(null);
			Assertions.fail("Can't se a title to null");
			
		} catch (IllegalArgumentException iae) {	
			
		}
		
		//Assert that set title is what is returned when calling getScheduleTitle
		scheduler.setScheduleTitle("Brenda's Got a Baby");
		Assertions.assertEquals("Brenda's Got a Baby", scheduler.getScheduleTitle());
	}	
}
