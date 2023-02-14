package edu.bowdoin.csci.PolarScheduler.course;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.bowdoin.csci.PolarScheduler.utils.ArrayList;

public class CourseTest {
    
    private Course course = new Course("EOS 1020", "branch", "30 college", "Zubin", "Bronco");

	
	@BeforeEach
	public void setUp() throws Exception {
		course = new Course();
	}
	
	
	@Test
    public void testInvalidCourseNames() {
		
		
		

        try {
            course = new Course(null, "branch", "30 college", "Zubin", "Bronco");
            Assertions.fail("Trying to set a `null` Course name should throw an IllegalArgumentException, but did not");           
            
        } catch (IllegalArgumentException iae) {
            // Exception expected, carry on
        }
        
        
        try {
        	course = new Course("E 1111", "branch", "30 college", "Zubin", "Bronco");
            Assertions.fail("Trying to set a too few characters should throw an IllegalArgumentException, but did not");           
            
        } catch (IllegalArgumentException iae) {
            // Exception expected, carry on
        }
        
        
        try {
        	course = new Course("HESFQ 1101", "branch", "30 college", "Zubin", "Bronco");
            Assertions.fail("Trying to set a too many  should throw an IllegalArgumentException, but did not");           
            
        } catch (IllegalArgumentException iae) {
            // Exception expected, carry on
        }
        
        
        try {
        	course = new Course("101", "branch", "30 college", "Zubin", "Bronco");
            Assertions.fail("Trying to set a `null` Course name should throw an IllegalArgumentException, but did not");           
            
        } catch (IllegalArgumentException iae) {
            // Exception expected, carry on
        } 
        
        
        try {
        	course = new Course("CSCI 11", "branch", "30 college", "Zubin", "Bronco");
            Assertions.fail("Trying to set a `null` Course name should throw an IllegalArgumentException, but did not");           
            
        } catch (IllegalArgumentException iae) {
            // Exception expected, carry on
        } 
        
        
        try {
        	course = new Course("CSCI\t1103", "branch", "30 college", "Zubin", "Bronco");
            Assertions.fail("Trying to set a `null` Course name should throw an IllegalArgumentException, but did not");           
            
        } catch (IllegalArgumentException iae) {
            // Exception expected, carry on
        } 
        
        
    }
	
	@Test
	public void testValidCourseNames() {

	    try {
		       
	        course = new Course("CSCI 2335", "branch", "30 college", "Zubin", "Bronco");
	        Assertions.assertEquals("CSCI 2335", course.getTitle());           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
		
	}
	
	
	@Test
	public void testInvalidCourseTitles() {
		

	    try {
	       
	        course.setTitle(null);
	        Assertions.fail("Trying to set a `null` Course title should throw an IllegalArgumentException, but did not");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	    try {
	    	
	    	course.setTitle("");
	        Assertions.fail("Trying to set an empty string as the course title should throw an IllegalArgumentException, but did not");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
		
	}
	
	
	@Test
	public void testValidCourseTitles() {
		
	    try {
	    	
	        course.setTitle("The Beginning of the End");
	        Assertions.assertEquals("The Beginning of the End", course.getTitle());
	                   
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	}
	
	
	@Test
	public void testInvalidCourseSection() {
		
	    try {

	        course.setSection("");
	        Assertions.fail("Trying to set an empty string as course section should throw an IllegalArgumentException, but did not");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	    
	    try {

	    	course.setSection("12345");
	        Assertions.fail("Trying to set an string of more than four characters as course section should throw an IllegalArgumentException, but did not");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
		
	}
	
	@Test
	public void testValidCourseSection() {
		
	    try {

	    	course.setSection("123");
	    	Assertions.assertEquals("123", course.getSection());
	                   
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
		
		
	}
	
	
	@Test
	public void testInvalidCourseInstructors() {
		
	    try {

	        course.setInstructorId(null);
	        Assertions.fail("Trying to set an empty string as course section should throw an IllegalArgumentException, but did not");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	    
	    try {

	    	course.setInstructorId("");
	        Assertions.fail("Trying to set an string of more than four characters as course section should throw an IllegalArgumentException, but did not");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	    try {

	        course.setInstructorId("thisisaverylongidwithmorethantwentycharacters");
	        Assertions.fail("Trying to set an empty string as course section should throw an IllegalArgumentException, but did not");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	    try {

	        course.setInstructorId("Dr. K");
	        Assertions.fail("Trying to set an empty string as course section should throw an IllegalArgumentException, but did not");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
		
	}
	
	@Test
	public void testValidInstructors() {
		
	    try {

	        course.setInstructorId("MistakenID");
	        Assertions.assertEquals("MistakenID", course.getInstructorId());           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }			
	    
	}
	
	
	@Test
	public void testInvalidMeetingDaysStartTimesEndTimes() {
		
		
		
	    try {

	    	course.setMeetingDaysAndTime("M", 1, 1);
	        Assertions.assertEquals("MistakenID", course.getInstructorId());           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    try {

	    	course.setMeetingDaysAndTime("T", 1, 1);
	        Assertions.assertEquals("MistakenID", course.getInstructorId());           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    try {

	    	course.setMeetingDaysAndTime("W", 1, 1);
	        Assertions.assertEquals("MistakenID", course.getInstructorId());           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    try {

	    	course.setMeetingDaysAndTime("H", 1, 1);
	        Assertions.assertEquals("MistakenID", course.getInstructorId());           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    try {

	    	course.setMeetingDaysAndTime("F", 1, 1);
	        Assertions.assertEquals("MistakenID", course.getInstructorId());           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    try {

	    	course.setMeetingDaysAndTime("A", 1, 1);
	        Assertions.assertEquals("MistakenID", course.getInstructorId());           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
		
	    
	    
	    try {

	    	course.setMeetingDaysAndTime("M", 1, 1);
	        Assertions.assertEquals("MistakenID", course.getInstructorId());           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
		
	    
	    
	    
	    try {

	    	course.setMeetingDaysAndTime("MM", 1, 1);
	        Assertions.fail("Duplicate days");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    try {

	    	course.setMeetingDaysAndTime("TT", 1, 1);
	        Assertions.fail("Duplicate days");         
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    try {

	    	course.setMeetingDaysAndTime("AA", 1, 1);
	        Assertions.fail("Two As");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    
	    try {

	    	course.setMeetingDaysAndTime("A", 4000, 1);
	        Assertions.fail("Star time too big");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    try {

	    	course.setMeetingDaysAndTime("A", -10, 1);
	        Assertions.fail("Start time to small");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    
	    try {

	    	course.setMeetingDaysAndTime("A", 1, 4000);
	        Assertions.fail("Endtime to BIG");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    try {

	    	course.setMeetingDaysAndTime("A", 1000, -1000);
	        Assertions.fail("Endtime to SMALL");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    
	    try {

	    	course.setMeetingDaysAndTime("A", 1600, 1200);
	        Assertions.fail("Two As");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    try {

	    	course.setMeetingDaysAndTime("A", 0000, 1000);
	        Assertions.fail("Two As");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    try {

	    	course.setMeetingDaysAndTime("A", 1000, 0000);
	        Assertions.fail("Two As");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    
	  
	}
	
	
	@Test
	public void testMeetingString() {
		
	    	
	    	Assertions.assertEquals("Arranged", course.getMeetingString());

	}
	
	

}
