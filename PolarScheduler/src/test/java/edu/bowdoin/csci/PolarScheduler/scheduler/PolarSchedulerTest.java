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
		
		//Ensures constructor creates PolarScheduler with empty ArrayLists
		//for catalogue and courses with a title of "My schedule"
		
		Assertions.assertEquals(null, scheduler.getCourseCatalogue());
		Assertions.assertEquals(null, scheduler.getScheduledCourses());
		Assertions.assertEquals("My schedule", scheduler.getScheduleTitle());
			
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
    	Assertions.assertEquals(course1, scheduler.getCourseFromCatalogue("CSCI 1101", "321"));           
	        
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
    	scheduler.createNewCourse(course1);
		
		
		//Tries to create a duplicate course
	    try {
	    	
	    	Course test = new Course("EOS 1020", "Earth", "123", "Cooler", "MTW", 1120, 1220);
	    	scheduler.createNewCourse(test);
	    	Assertions.fail("Should throw IllegalArgumentException for creating duplicate class but did not");
	                   
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
		//Tries to create a duplicate course
	    try {
	    	
	    	Course test = new Course("EOS 1020", "Earth", "123", "Cooler", "MTW", 1120, 1220);
	    	scheduler.createNewCourse(test);
	    	Assertions.fail("Should throw IllegalArgumentException for creating duplicate class but did not");
	                   
	        
	    } catch (IllegalArgumentException iae) {
	        // Exception expected, carry on
	    }
	    
	    
	    //
		
	    //Tries to create a course with a null start time
	    try {
	    	
	    	//Course test = new Course("EOS 1020", "Earth", "123", "Cooler", "MTW", , 1220);
	    	//scheduler.createNewCourse("EOS 1020", "Earth", "123", "Cooler", "MTW", null, 1220);
	    	//Assertions.assertEquals(IllegalArgumentException, null);
	    	//Assertions.fail("Should throw IllegalArgumentException for missing start time but did not");          
	        
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
    	
		scheduler.createNewCourse(course1);
    	scheduler.createNewCourse(course1);	
    	
    	String[][] newArray = scheduler.getCourseCatalogue();
    	String[][] testCatalogue = {{"EOS 1020", "Earth", "123", "Cooler", "MTW", "1120", "1220"}, {"CSCI 1101", "Computer", "321", "Warmer", "TWH", "1020", "1220"}};
		
    	Assertions.assertArrayEquals(testCatalogue, newArray);
    	
    	
    	Course course3 = new Course("CSCI 2101", "Computation", "321", "Torres", "TWH", 1020, 1220);
    	scheduler.createNewCourse(course3);	
    	
    	newArray = scheduler.getCourseCatalogue();
    	String[][] testCatalogue1 = {{"EOS 1020", "Earth", "123", "Cooler", "MTW", "1120", "1220"}, {"CSCI 1101", "Computer", "321", "Warmer", "TWH", "1020", "1220"}, {"CSCI 2101", "Computation", "321", "Torres", "TWH", "1020", "1220"}};
    	
    	
    	Assertions.assertArrayEquals(testCatalogue1, newArray);
		
	}
	
	@Test
	public void testGetScheduledCourses() {
		
		scheduler.createNewCourse(course1);
    	scheduler.createNewCourse(course1);	
    	
    	scheduler.addCourseToSchedule("EOS 1020", "MTW");
    	scheduler.addCourseToSchedule("CSCI 1101", "TWH");
    	
    	
    	String[][] newArray = scheduler.getScheduledCourses();
    	String[][] testCatalogue = {{"EOS 1020", "Earth", "123", "Cooler", "MTW", "1120", "1220"}, {"CSCI 1101", "Computer", "321", "Warmer", "TWH", "1020", "1220"}};
		
    	Assertions.assertArrayEquals(testCatalogue, newArray);
    	
    	
    	Course course3 = new Course("CSCI 2101", "Computation", "321", "Torres", "TWH", 1020, 1220);
    	scheduler.createNewCourse(course3);	
    	scheduler.addCourseToSchedule("CSCI 2101", "TWH");
    	
    	newArray = scheduler.getScheduledCourses();
    	
    	String[][] testCatalogue1 = {{"EOS 1020", "Earth", "123", "Cooler", "MTW", "1120", "1220"}, {"CSCI 1101", "Computer", "321", "Warmer", "TWH", "1020", "1220"}, {"CSCI 2101", "Computation", "321", "Torres", "TWH", "1020", "1220"}};
    	
    	Assertions.assertArrayEquals(testCatalogue1, newArray);
		
	}
	
	@Test
	public void testGetFullScheduledCourses() {
		
		
		scheduler.createNewCourse(course1);
    	scheduler.createNewCourse(course1);	
    	
    	scheduler.addCourseToSchedule("EOS 1020", "MTW");
    	scheduler.addCourseToSchedule("CSCI 1101", "TWH");
    	
    	
    	String[][] newArray = scheduler.getScheduledCourses();
    	String[][] testCatalogue = {{"EOS 1020", "Earth", "123", "Cooler", "MTW", "1120", "1220"}, {"CSCI 1101", "Computer", "321", "Warmer", "TWH", "1020", "1220"}};
		
    	Assertions.assertArrayEquals(testCatalogue, newArray);
    	
    	
    	Course course3 = new Course("CSCI 2101", "Computation", "321", "Torres", "TWH", 1020, 1220);
    	scheduler.createNewCourse(course3);	
    	scheduler.addCourseToSchedule("CSCI 2101", "TWH");
    	
    	newArray = scheduler.getScheduledCourses();
    	
    	String[][] testCatalogue1 = {{"EOS 1020", "Earth", "123", "Cooler", "MTW", "1120", "1220"}, {"CSCI 1101", "Computer", "321", "Warmer", "TWH", "1020", "1220"}, {"CSCI 2101", "Computation", "321", "Torres", "TWH", "1020", "1220"}};
    	
    	Assertions.assertArrayEquals(testCatalogue1, newArray);
		
		
	
			
		
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
