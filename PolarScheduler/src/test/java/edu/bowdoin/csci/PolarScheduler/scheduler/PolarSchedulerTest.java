package edu.bowdoin.csci.PolarScheduler.scheduler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.bowdoin.csci.PolarScheduler.course.Course;
import edu.bowdoin.csci.PolarScheduler.scheduler.PolarScheduler;

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
		
		
		//See if Schedule title set to My Schedule
	    try {
	        Assertions.assertEquals("My schedule", scheduler.getScheduleTitle());            
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	    
	    //See if catalogue is empty
	    try {
	        Assertions.assertEquals(null, scheduler.getCourseCatalogue());            
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	    //see if the schedule is empty
	    try {
	        Assertions.assertEquals(null, scheduler.getScheduledCourses());            
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
		
		
	}
	
	
	@Test
	public void testCreateNewCourse() {
		
		
		//Tries to create the same course twice, which should lead to an error
	    try {
	    	
	    	scheduler.createNewCourse(course1);
	    	scheduler.createNewCourse(course1);
	        Assertions.fail("Trying to create a duplicate course should throw an UllegalArgumentException but did not");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
		
	    //Tries to create a second course and checks to see if both courses were created
	    try {
	    	
	    	//scheduler.createNewCourse(course1);
	    	scheduler.createNewCourse(course2);
	    	Assertions.assertEquals(course1, scheduler.getCourseFromCatalogue("EOS 1020", "123"));
	    	Assertions.assertEquals(course1, scheduler.getCourseFromCatalogue("CSCI 1101", "321"));           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
		
	}
	
	@Test
	public void testGetCourseFromCatalogue() {
		
    	scheduler.createNewCourse(course1);
    	scheduler.createNewCourse(course2);
		
	    //Tries to get course1 and course2
	    try {
	    	
	    	Assertions.assertEquals(course1, scheduler.getCourseFromCatalogue("EOS 1020", "123"));
	    	Assertions.assertEquals(course1, scheduler.getCourseFromCatalogue("CSCI 1101", "321"));           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
		
	    //Ensures a course that is not in the catalogue returns null
	    try {
	    	
	    	Assertions.assertEquals(null, scheduler.getCourseFromCatalogue("ABDC 1234", "0011"));           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }	
		
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
    	scheduler.createNewCourse(course1);
		
		
		//Tries to create a duplicate course
	    try {
	    	
	    	Course test = new Course("EOS 1020", "Earth", "123", "Cooler", "MTW", 1120, 1220);
	    	scheduler.createNewCourse(test);
	    	Assertions.fail("Should throw IllegalArgumentException for creatign duplicate class but did not");
	                   
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
		
	    //Tries to create a course with a null start time
	    try {
	    	
	    	//Course test = new Course("EOS 1020", "Earth", "123", "Cooler", "MTW", , 1220);
//	    	scheduler.createNewCourse("EOS 1020", "Earth", "123", "Cooler", "MTW", null, 1220);
//	    	Assertions.assertEquals(IllegalArgumentException, null);
//	    	Assertions.fail("Should throw IllegalArgumentException for missing start time but did not");          
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
		
	    //Tries to create a second course and checks to see if both courses were created
	    try {
	    	
	    	//scheduler.createNewCourse(course1);
	    	scheduler.createNewCourse(course2);
	    	Assertions.assertEquals(course1, scheduler.getCourseFromCatalogue("EOS 1020", "123"));
	    	Assertions.assertEquals(course1, scheduler.getCourseFromCatalogue("CSCI 1101", "321"));           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	    //Tries to create a second course and checks to see if both courses were created
	    try {
	    	
	    	//scheduler.createNewCourse(course1);
	    	scheduler.createNewCourse(course2);
	    	Assertions.assertEquals(course1, scheduler.getCourseFromCatalogue("EOS 1020", "123"));
	    	Assertions.assertEquals(course1, scheduler.getCourseFromCatalogue("CSCI 1101", "321"));           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	    //Tries to create a second course and checks to see if both courses were created
	    try {
	    	
	    	//scheduler.createNewCourse(course1);
	    	scheduler.createNewCourse(course2);
	    	Assertions.assertEquals(course1, scheduler.getCourseFromCatalogue("EOS 1020", "123"));
	    	Assertions.assertEquals(course1, scheduler.getCourseFromCatalogue("CSCI 1101", "321"));           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	}
	
	
	

	@Test
	public void testRemoveCourseFromSchedule() {
		
		//Add courses to catalogue
    	scheduler.createNewCourse(course1);
    	scheduler.createNewCourse(course1);
    	
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
		
		
		
	}
	
	@Test
	public void testGetScheduledCourses() {
		
		
		
	}
	
	@Test
	public void testGetFullScheduledCourses() {
		
		
		
	}
	
	@Test
	public void testSetScheduleTitle() {
		
		
		
	}
	

	
	
	
	
	
	
	

}
