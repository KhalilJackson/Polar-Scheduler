package edu.bowdoin.csci.PolarScheduler.course;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.bowdoin.csci.PolarScheduler.scheduler.PolarScheduler;
import edu.bowdoin.csci.PolarScheduler.utils.ArrayList;

public class CourseTest {
    
    private Course course = new Course("EOS 1020", "Earth", "123", "Cooler", "MTW");

	@BeforeEach
	public void setUp() throws Exception {
		course = new Course();
	}
	
	/**
	* Tests the construction and setting of course names.
	* 
	* @void method
	 */
	@Test
    public void testInvalidCourseNames() {
		
		
		//Attempting to catch null name attempts
        try {
            course = new Course(null, "branch", "30 college", "Zubin", "Bronco");
            Assertions.fail("Trying to set a `null` course name should throw an IllegalArgumentException, but did not");           
            
        } catch (IllegalArgumentException iae) {
            // Exception expected, carry on
        }
        
        //Attempting to catch a name that is too short
        try {
        	course = new Course("E 1111", "branch", "30 college", "Zubin", "Bronco");
            Assertions.fail("Trying to set a course name with too few characters should throw an IllegalArgumentException, but did not");           
            
        } catch (IllegalArgumentException iae) {
            // Exception expected, carry on
        }
        
        //Attempting to catch a name that is too long
        try {
        	course = new Course("HESFQ 1101", "branch", "30 college", "Zubin", "Bronco");
            Assertions.fail("Trying to set a course name with too many characters should throw an IllegalArgumentException, but did not");           
            
        } catch (IllegalArgumentException iae) {
            // Exception expected, carry on
        }
        
        //Attempting to catch a name with no letters
        try {
        	course = new Course("101", "branch", "30 college", "Zubin", "Bronco");
            Assertions.fail("Trying to set a course name with no letters should throw an IllegalArgumentException, but did not");           
            
        } catch (IllegalArgumentException iae) {
            // Exception expected, carry on
        } 
        
        //Attempting to catch a name that has a space
        try {
        	course = new Course("CSCI 11", "branch", "30 college", "Zubin", "Bronco");
            Assertions.fail("Trying to set a course name with a space should throw an IllegalArgumentException, but did not");           
            
        } catch (IllegalArgumentException iae) {
            // Exception expected, carry on
        } 
        
        //Attempting to catch a name with a special character
        try {
        	course = new Course("CSCI\t1103", "branch", "30 college", "Zubin", "Bronco");
            Assertions.fail("Trying to set a course name woth \t should throw an IllegalArgumentException, but did not");           
            
        } catch (IllegalArgumentException iae) {
            // Exception expected, carry on
        }    
    }
	
	/**
	* Tests the setting of meeting days.
	* 
	* @void
	 */
	@Test
    public void testSetMeetingDays() {
		
		//Cannot have duplicates nor more than one character in meeting day when it is "A"
		try {
			
			course = new Course("CSCI 2335", "branch", "30 college", "Zubin", "Bronco");
			
	        course.setMeetingDays("AAA");
	        Assertions.fail("Cannot have duplicate");
        
			
		} catch (IllegalArgumentException iae) {
			
		}
		
		//Cannot have duplicates
		try {
			
			course = new Course("CSCI 2335", "branch", "30 college", "Zubin", "Bronco");
			
	        course.setMeetingDays("MM");
	        Assertions.fail("Cannot have duplicate");
        
			
		} catch (IllegalArgumentException iae) {
			
		}
		
		//Cannot have duplicates
		try {
			
			course = new Course("CSCI 2335", "branch", "30 college", "Zubin", "Bronco");
			
	        course.setMeetingDays("TT");
	        Assertions.fail("Cannot have duplicate");
        
			
		} catch (IllegalArgumentException iae) {
			
		}
		
		//Cannot have duplicates
		try {
			
			course = new Course("CSCI 2335", "branch", "30 college", "Zubin", "Bronco");
			
	        course.setMeetingDays("WW");
	        Assertions.fail("Cannot have duplicate");
        
			
		} catch (IllegalArgumentException iae) {
			
		}
		
		//Cannot have duplicates
		try {
			
			course = new Course("CSCI 2335", "branch", "30 college", "Zubin", "Bronco");
			
	        course.setMeetingDays("HH");
	        Assertions.fail("Cannot have duplicate");
        
			
		} catch (IllegalArgumentException iae) {
			
		}
	    
		//Cannot have duplicates
		try {
			
			course = new Course("CSCI 2335", "branch", "30 college", "Zubin", "Bronco");
			
	        course.setMeetingDays("FF");
	        Assertions.fail("Cannot have duplicate");
        
			
		} catch (IllegalArgumentException iae) {
			
		}
		
		//Cannot have character that is not day of the week
		try {
			
			course = new Course("CSCI 2335", "branch", "30 college", "Zubin", "Bronco");
			
	        course.setMeetingDays("Z");
	        Assertions.fail("Cannot have duplicate");
        
			
		} catch (IllegalArgumentException iae) {
			
		}  
    }
	
	/**
	* Tests the equals function.
	* 
	* @void
	 */
	@Test
	public void testEquals() {
		
		Course test = new Course();
		PolarScheduler tester = new PolarScheduler();
		
		//Should be false since it is null
		Assertions.assertEquals(false, test.equals(null));
		
		//Should be false since the type is different
		Assertions.assertEquals(false, test.equals(tester));
	}
	
	/**
	* Tests the toString method.
	* 
	* @void
	 */
	@Test
	public void testToString() {
		
		
		course = new Course("EOS 1020", "Earth", "123", "Cooler", "A");
		
		//Tests case where meetingdays is "A"
		Assertions.assertEquals("EOS 1020,Earth,123,Cooler,A", course.toString());
		
		//Tests case where meetingDays is not "A"
		course = new Course("EOS 1020", "Earth", "123", "Cooler", "MTW", 1000, 1200);
		Assertions.assertEquals("EOS 1020,Earth,123,Cooler,MTW,1000,1200", course.toString());		
	}
	
	/**
	* Test valid course names to ensure they are valid.
	* 
	* @void
	 */
	@Test
	public void testValidCourseNames() {

	    try {
		       
	        course = new Course("CSCI 2335", "branch", "30 college", "Zubin", "Bronco");
	        Assertions.assertEquals("CSCI 2335", course.getTitle());           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	}
	
	/**
	* Tests invalid course titles.
	* 
	* @void
	 */
	@Test
	public void testInvalidCourseTitles() {
		
		//Null title should fail
	    try {
	       
	        course.setTitle(null);
	        Assertions.fail("Trying to set a `null` Course title should throw an IllegalArgumentException, but did not");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	    //Empty string should fail
	    try {
	    	
	    	course.setTitle("");
	        Assertions.fail("Trying to set an empty string as the course title should throw an IllegalArgumentException, but did not");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	}
	
	/**
	* Tests valid course titles.
	* 
	* @void
	 */
	@Test
	public void testValidCourseTitles() {
		
	    try {
	    	
	        course.setTitle("The Beginning of the End");
	        Assertions.assertEquals("The Beginning of the End", course.getTitle());
	                   
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	}
	
	/**
	* Tests invalid course section.
	* 
	* @void
	 */
	@Test
	public void testInvalidCourseSection() {
		
		//Cannot have empty string
	    try {

	        course.setSection("");
	        Assertions.fail("Trying to set an empty string as course section should throw an IllegalArgumentException, but did not");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	    //Cannot have more than four characters
	    try {

	    	course.setSection("12345");
	        Assertions.fail("Trying to set an string of more than four characters as course section should throw an IllegalArgumentException, but did not");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	}
	
	/**
	* Tests valid course sections.
	* 
	* @void
	 */
	@Test
	public void testValidCourseSection() {
		
	    try {

	    	course.setSection("123");
	    	Assertions.assertEquals("123", course.getSection());
	                   
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	}
	
	/**
	* Tests invalid course instructors.
	* 
	* @void
	 */
	@Test
	public void testInvalidCourseInstructors() {
		
		//Cannot be null
	    try {

	        course.setInstructorId(null);
	        Assertions.fail("Trying to set an empty string as an instructor is should throw an IllegalArgumentException, but did not");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	    //Cannot be empty string
	    try {

	    	course.setInstructorId("");
	        Assertions.fail("Trying to set an empty string should throw an IllegalArgumentException, but did not");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	    //Cannot be longer than 20 characters
	    try {

	        course.setInstructorId("thisisaverylongidwithmorethantwentycharacters");
	        Assertions.fail("Trying to set a string longer than twenty characters should throw an IllegalArgumentException, but did not");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	    //Cannot have special characters
	    try {

	        course.setInstructorId("Dr. K");
	        Assertions.fail("Trying to use a special character should throw an IllegalArgumentException, but did not");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	}
	
	/**
	* Tests valid Instructors.
	* 
	* @void
	 */
	@Test
	public void testValidInstructors() {
		
	    try {

	        course.setInstructorId("MistakenID");
	        Assertions.assertEquals("MistakenID", course.getInstructorId());           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }			
	}
	
	/**
	* Tests invalid meeting days and start times.
	* 
	* @void
	 */
	@Test
	public void testInvalidMeetingDaysStartTimesEndTimes() {
		
		//Must use weekday character
	    try {

	    	course.setMeetingDaysAndTime("Z", 1000, 1200);
	    	Assertions.fail("Should throw an IllegalArgumentException for unallowed weekday but did not");      
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }	
	    
	    //Must use weekday character
	    try {

	    	course.setMeetingDaysAndTime("k", 1000, 1200);
	    	Assertions.fail("Should throw an IllegalArgumentException for unallowed weekday but did not");      
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }	
	    
	    //Cannot use a special character
	    try {

	    	course.setMeetingDaysAndTime("@", 1000, 1200);
	    	Assertions.fail("Should throw an IllegalArgumentException for unallowed weekday but did not");      
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }	
	    
	    //Cannot use numbers
	    try {

	    	course.setMeetingDaysAndTime("2", 1000, 1200);
	    	Assertions.fail("Should throw an IllegalArgumentException for unallowed weekday but did not");      
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }	
	    
	    //Cannot use duplicates
	    try {

	    	course.setMeetingDaysAndTime("MM", 1000, 11000);
	    	Assertions.fail("Should throw an IllegalArgumentException for duplicate values but did not");      
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }	
	    
	    //Cannot use duplicates
	    try {

	    	course.setMeetingDaysAndTime("TT", 1000, 11000);
	    	Assertions.fail("Should throw an IllegalArgumentException for duplicate values but did not");      
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }	
	    
	    //Cannot use duplicates
	    try {

	    	course.setMeetingDaysAndTime("WW", 1000, 11000);
	    	Assertions.fail("Should throw an IllegalArgumentException for duplicate values but did not");      
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }	
	    
	    //Cannot use duplicates
	    try {

	    	course.setMeetingDaysAndTime("HH", 1000, 11000);
	    	Assertions.fail("Should throw an IllegalArgumentException for duplicate values but did not");      
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	    //Cannot use duplicates
	    try {

	    	course.setMeetingDaysAndTime("FF", 1000, 11000);
	    	Assertions.fail("Should throw an IllegalArgumentException for duplicate values but did not");      
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }	
	    
	    //Cannot use duplicates or more than one day if it is "A"
	    try {

	    	course.setMeetingDaysAndTime("AA", 1000, 11000);
	    	Assertions.fail("Should throw an IllegalArgumentException for duplicate values but did not");      
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }	
	    
	    //End time too big
	    try {

	    	course.setMeetingDaysAndTime("AM", 1000, 11000);
	    	Assertions.fail("Should throw an IllegalArgumentException for having too big end time but did not");      
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }	
		
		//Start time too big
	    try {

	    	course.setMeetingDaysAndTime("A", 4000, 1);
	        Assertions.fail("Start time too big");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    //Cannot have negatives
	    try {

	    	course.setMeetingDaysAndTime("A", -10, 1);
	        Assertions.fail("Start time to small");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    //End time too big
	    try {

	    	course.setMeetingDaysAndTime("A", 1, 4000);
	        Assertions.fail("Endtime to BIG");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    //Cannot have negatives
	    try {

	    	course.setMeetingDaysAndTime("A", 1000, -1000);
	        Assertions.fail("Endtime to SMALL");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    //Cannot have A and times
	    try {

	    	course.setMeetingDaysAndTime("A", 1600, 1200);
	        Assertions.fail("Day is A while there are start and end times");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    //Cannot have A and times
	    try {

	    	course.setMeetingDaysAndTime("A", 0000, 1000);
	        Assertions.fail("Day is A with an end time");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    //Cannot have A and times
	    try {

	    	course.setMeetingDaysAndTime("A", 1000, 0000);
	        Assertions.fail("Day is A with a start time");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
		//Cannot have duplicates
	    try {

	    	course.setMeetingDaysAndTime("MM", 1, 1);
	        Assertions.fail("Duplicate days");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    //Cannot have duplicates
	    try {

	    	course.setMeetingDaysAndTime("TT", 1, 1);
	        Assertions.fail("Duplicate days");         
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	    //Cannot have duplicates
	    try {

	    	course.setMeetingDaysAndTime("AA", 1, 1);
	        Assertions.fail("Two As");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    //S
	    try {

	    	course.setMeetingDaysAndTime("M", 4000, 1);
	        Assertions.fail("Star time too big");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    try {

	    	course.setMeetingDaysAndTime("M", -10, 1);
	        Assertions.fail("Start time to small");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    
	    try {

	    	course.setMeetingDaysAndTime("M", 1, 4000);
	        Assertions.fail("Endtime to BIG");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    try {

	    	course.setMeetingDaysAndTime("M", 1000, -1000);
	        Assertions.fail("Endtime to SMALL");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    try {

	    	course.setMeetingDaysAndTime("M", 1200, 1000);
	        Assertions.fail("Endtime to SMALL");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }	
	    
	    try {

	    	course.setMeetingDaysAndTime("A", 1600, 1200);
	        Assertions.fail("Day is A while there are start and end times");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    try {

	    	course.setMeetingDaysAndTime("A", 0000, 1000);
	        Assertions.fail("Day is A with an end time");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	    
	    try {

	    	course.setMeetingDaysAndTime("A", 1000, 0000);
	        Assertions.fail("Day is A with a start time");           
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }		
	}
	
	/**
	* Tests getMeetingDays.
	* 
	* @void
	 */
	@Test
	public void testGetMeetingDays() {
		
		course = new Course("EOS 1020", "Earth", "123", "Cooler", "MTW", 1000, 1400);
		
		Assertions.assertEquals("MTW", course.getMeetingDays());
	}
	
	/**
	* Tests getStartTime.
	* 
	* @void
	 */
	@Test
	public void testGetStartTime() {
		
		course = new Course("EOS 1020", "Earth", "123", "Cooler", "MTW", 1000, 1400);
		
		Assertions.assertEquals(1000, course.getStartTime());
		
	}
	
	/**
	* Tests getEndTime.
	* 
	* @void
	 */
	@Test
	public void testGetEndTime() {
		
		course = new Course("EOS 1020", "Earth", "123", "Cooler", "MTW", 1000, 1400);
		
		Assertions.assertEquals(1400, course.getEndTime());
	}
	
	/**
	* Tests getMeetingString.
	* 
	* @void
	 */
	@Test
	public void testMeetingString() {
		
		course = new Course();
		
		Assertions.assertEquals("Arranged", course.getMeetingString());

	}
}
