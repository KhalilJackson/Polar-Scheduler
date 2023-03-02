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
	
	@Test
	public void testPolarScheduler() {
		
		
		//Ensures schedule is set to proper title
		Assertions.assertEquals("My Schedule", scheduler.getScheduleTitle());
				
			
	}
	
	
	@Test
	public void testCreateNewCourse() {
		
		
		//Tries to create the same course twice, which should lead to an error
	    	
    	scheduler.createNewCourse(course1);
    	Assertions.assertEquals(false, scheduler.createNewCourse(course1));
    	
    	
    	//scheduler.createNewCourse(course1);
        //Assertions.fail("Trying to create a duplicate course should throw an UllegalArgumentException but did not");           
        
		
	    
	    //Ensures courses were added
    	//scheduler.createNewCourse(course1);
    	//scheduler.createNewCourse(course2);
    	
    	Assertions.assertEquals(true, scheduler.createNewCourse(course2));
    	
	}
	
	@Test
	public void testGetCourseFromCatalogue() {
		
    	scheduler.createNewCourse(course1);
    	scheduler.createNewCourse(course2);
		
	    //Tries to get course1 and course2
    	Assertions.assertEquals(course1, scheduler.getCourseFromCatalogue("EOS 1020", "123"));
    	Assertions.assertEquals(course2, scheduler.getCourseFromCatalogue("CSCI 1101", "321"));           
	        
	    //Ensures a course that is not in the catalogue returns null
    	Assertions.assertEquals(null, scheduler.getCourseFromCatalogue("ABDC 1234", "0011"));           
	        
	}
	
	
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
	    	
	    	//Course test = new Course("EOS 1020", "Earth", "123", "Cooler", "MTW", null, 1220);
	    	scheduler.createNewCourse("CSCI 1101", "Computer", "321", "Warmer", "TWH", null, 1220);
	    	Assertions.fail("Should throw IllegalArgumentException for having null startTime but did not");
	                   
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	    
	    
		//Tries to create a course with null endTime
	    try {
	    	
	    	//Course test = new Course("EOS 1020", "Earth", "123", "Cooler", "MTW", null, 1220);
	    	scheduler.createNewCourse("CSCI 1101", "Computer", "321", "Warmer", "TWH", 1120, null);
	    	Assertions.fail("Should throw IllegalArgumentException for having null endTime but did not");
	                   
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	    
	    
		//Tries to create a course with A 
	    try {
	    	
	    	//Course test = new Course("EOS 1020", "Earth", "123", "Cooler", "MTW", null, 1220);
	    	scheduler.createNewCourse("CSCI 1101", "Computer", "321", "Warmer", "TWH", 1120, 1220);
	    	Assertions.fail("Should throw IllegalArgumentException for having non Integer endtime");
	                   
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	}
	
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
	
	@Test
	public void testGetCourseCatalogue() {
    	
		scheduler.createNewCourse(course1);
    	scheduler.createNewCourse(course2);	
    	
    	String[][] newArray = scheduler.getCourseCatalogue();
    	String[][] testCatalogue = {{"EOS 1020", "123", "Earth"}, {"CSCI 1101", "321", "Computer"}};
		
    	Assertions.assertArrayEquals(testCatalogue, newArray);
    	
    	
    	Course course3 = new Course("CSCI 2101", "Computation", "321", "Torres", "TWH", 1020, 1220);
    	scheduler.createNewCourse(course3);	
    	
    	newArray = scheduler.getCourseCatalogue();
    	String[][] testCatalogue1 = {{"EOS 1020", "123", "Earth"}, {"CSCI 1101", "321", "Computer"}, {"CSCI 2101", "321", "Computation"}};
    	
    	
    	Assertions.assertArrayEquals(testCatalogue1, newArray);
		
	}
	
	@Test
	public void testGetScheduledCourses() {
		
	
		scheduler.createNewCourse(course1);
    	scheduler.createNewCourse(course2);
    	
    	scheduler.addCourseToSchedule("EOS 1020", "123");
    	scheduler.addCourseToSchedule("CSCI 1101", "321");
    	
    	
    	String[][] newArray = scheduler.getScheduledCourses();
    	String[][] testCatalogue = {{"EOS 1020", "123", "Earth"}, {"CSCI 1101", "321", "Computer"}};
		
    	Assertions.assertArrayEquals(testCatalogue, newArray);
    	
    	Course course3 = new Course("CSCI 2101", "Computation", "321", "Torres", "TWH", 1020, 1220);
    	scheduler.createNewCourse(course3);	
    	scheduler.addCourseToSchedule("CSCI 2101", "321");
    	
    	newArray = scheduler.getScheduledCourses();
    	
    	String[][] testCatalogue1 = {{"EOS 1020", "123", "Earth"}, {"CSCI 1101", "321", "Computer"}, {"CSCI 2101", "321", "Computation"}};
    	
    	Assertions.assertArrayEquals(testCatalogue1, newArray);
		
	}
	
	@Test
	public void testGetFullScheduledCourses() {
		
		//Add two courses to catalogue
		scheduler.createNewCourse(course1);
    	scheduler.createNewCourse(course2);	
    	
    	//Adds two courses to schedule
    	scheduler.addCourseToSchedule("EOS 1020", "123");
    	scheduler.addCourseToSchedule("CSCI 1101", "321");
    	
    	//Gets 
    	String[][] newArray = scheduler.getFullScheduledCourses();
    	String[][] testCatalogue = {{"EOS 1020", "123", "Earth", "Cooler", "MTW 11:20AM-12:20PM"}, {"CSCI 1101", "321", "Computer", "Warmer", "TWH 10:20AM-12:20PM"}};
    	
		
    	Assertions.assertArrayEquals(testCatalogue, newArray);
    	
    	
    	Course course3 = new Course("CSCI 2101", "Computation", "321", "Torres", "TWH", 1020, 1220);
    	scheduler.createNewCourse(course3);	
    	scheduler.addCourseToSchedule("CSCI 2101", "321");
    	
    	newArray = scheduler.getFullScheduledCourses();
    	
    	String[][] testCatalogue1 = {{"EOS 1020", "123", "Earth", "Cooler", "MTW 11:20AM-12:20PM"}, {"CSCI 1101", "321", "Computer", "Warmer", "TWH 10:20AM-12:20PM"}, {"CSCI 2101", "321", "Computation", "Torres", "TWH 10:20AM-12:20PM"}};
    	
    	Assertions.assertArrayEquals(testCatalogue1, newArray);	
		
    	
    	//Ensures meeting day A gets a schedule string "Arranged"
    	Course course4 = new Course("CSCI 2102", "Computational", "321", "Torres", "A", 0, 0);
    	scheduler.createNewCourse(course4);	
    	scheduler.addCourseToSchedule("CSCI 2102", "321");
    	
    	newArray = scheduler.getFullScheduledCourses();
    	
    	String[][] testCatalogue2 = {{"EOS 1020", "123", "Earth", "Cooler", "MTW 11:20AM-12:20PM"}, {"CSCI 1101", "321", "Computer", "Warmer", "TWH 10:20AM-12:20PM"}, {"CSCI 2101", "321", "Computation", "Torres", "TWH 10:20AM-12:20PM"}, {"CSCI 2102", "321", "Computational", "Torres", "Arranged"}};
    	
    	Assertions.assertArrayEquals(testCatalogue2, newArray);	
    	
    	
    	//Ensures it can take AM times with zeroes after the colon
    	Course course5 = new Course("CSCI 3102", "Computationality", "321", "Torres", "M", 1000, 1155);
    	scheduler.createNewCourse(course5);	
    	scheduler.addCourseToSchedule("CSCI 3102", "321");
    	
    	newArray = scheduler.getFullScheduledCourses();
    	
    	String[][] testCatalogue3 = {{"EOS 1020", "123", "Earth", "Cooler", "MTW 11:20AM-12:20PM"}, {"CSCI 1101", "321", "Computer", "Warmer", "TWH 10:20AM-12:20PM"}, {"CSCI 2101", "321", "Computation", "Torres", "TWH 10:20AM-12:20PM"}, {"CSCI 2102", "321", "Computational", "Torres", "Arranged"}, {"CSCI 3102", "321", "Computationality", "Torres", "M 10:00AM-11:55AM"}};
    	
    	Assertions.assertArrayEquals(testCatalogue3, newArray);	
    	
	}
	
	@Test
	public void testSetScheduleTitle() {
		
		try {
			
			scheduler.setScheduleTitle(null);
			Assertions.fail("Can't se a title to null");
			
		} catch (IllegalArgumentException iae) {	
			
		}
		
		scheduler.setScheduleTitle("Brenda's Got a Baby");
		Assertions.assertEquals("Brenda's Got a Baby", scheduler.getScheduleTitle());
	}	

}
