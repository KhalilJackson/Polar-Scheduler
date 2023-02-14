package edu.bowdoin.csci.PolarScheduler.scheduler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.bowdoin.csci.PolarScheduler.course.Course;
import edu.bowdoin.csci.PolarScheduler.scheduler.PolarScheduler;

public class PolarSchedulerTest {
	
    private PolarScheduler scheduler = new PolarScheduler();

	
	@BeforeEach
	public void setUp() throws Exception {
		scheduler = new PolarScheduler();
		
		//scheduler.
		
		//scheduler.addCourseToSchedule("CSCI", "1101");
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
		
		
	    try {
	    	
	    	//scheduler.createNewCourse();
	    	
	        Assertions.fail("Trying to set an empty string as the course title should throw an IllegalArgumentException, but did not");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
		
		
		
		
	}
	
	
	
	@Test
	public void testGetCourseFromCatalogue() {
		
		
		
		
		
		
		
	}
	
	
	@Test
	public void testAddCourseToSchedule() {
		
		
	}
	
	
	

	@Test
	public void testRemoveCourseFromSchedule() {
		
		
		
	}
	
	
	
	@Test
	public void testResetSchedule() {
		
		
		
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
