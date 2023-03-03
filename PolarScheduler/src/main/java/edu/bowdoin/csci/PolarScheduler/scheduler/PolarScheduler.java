package edu.bowdoin.csci.PolarScheduler.scheduler;

import edu.bowdoin.csci.PolarScheduler.course.Course;
import edu.bowdoin.csci.PolarScheduler.utils.ArrayList;

public class PolarScheduler {
	
	private String title;
	
	private ArrayList<Course> catalogue;
	
	private ArrayList<Course> schedule;
	
	/**
	* Constructor.
	* 
	 */
	public PolarScheduler() {
		
		this.title = "My Schedule";
		this.catalogue = new ArrayList<Course>();
		this.schedule = new ArrayList<Course>();	
	}
	
	/**
	* Gets course from catalogue by iterating through it and matching name and section.
	* 
	* @return course
	 */
	public Course getCourseFromCatalogue(String name, String section) {
		
		//Iterate through course catalogue
		for (Course course: catalogue) {
			
			//Return course if in the catalogue
			if ((name.equals(course.getName())) && (section.equals(course.getSection()))) {

				return course;
				
			}
		}	
		
		//Otherwise, return false
		return null;
	}
	
	/**
	* Adds course to schedule is it can be and is not a duplicate.
	* 
	* @return true if course was added, false if not
	 */
	public boolean addCourseToSchedule(String name, String section) {
		
		Course addCourse = getCourseFromCatalogue(name, section);
		
		//Return false if course not found
		if (addCourse == null) {

			return false;
		} else {
			
			//Iterate through schedule
			for (Course course: schedule) {
				
				//Throw exception if course already found in schedule
				if (course.getName() == addCourse.getName()) {

					throw new IllegalArgumentException("You are already enrolled in " + course.getName());
				}
			}
			
			//Otherwise, add course and return true
			schedule.add(addCourse);
			return true;
		}
	}
	
	/**
	* Adds course to catalogue by checking its parameters for validity.
	* 
	* @void
	 */
	public void createNewCourse(String name, String title, String section, String instructorId, String meetingDays, Integer startTime, Integer endTime) {
		
		if (startTime == null) {
			
			throw new IllegalArgumentException("Missing start time for non-Arranged course");
			
		}
		
		if (endTime == null) {
			
			throw new IllegalArgumentException("Missing end time for non-Arranged course");
			
		}
		
		if (((startTime < 0000) || (startTime >2359)) || ((endTime < 0) || endTime > 2359)) {
			
			throw new IllegalArgumentException("Invalid start time or end time");
		}
		
		if (meetingDays.contains("A")) {
			
			if (meetingDays.length() > 1) {
				
				throw new IllegalArgumentException("Meeting day A should not be accompanied with other days");
				
			}
			
			if ((startTime != 0) || (endTime != 0)) {
				
				throw new IllegalArgumentException("Should not have startTime or endTime");
				
			}
			
		}
		
		if (getCourseFromCatalogue(name, section) != null) {
			
			throw new IllegalArgumentException("Cannot add a duplicate course");
			
		} else {
			
			Course newCourse = new Course(name, title, section, instructorId, meetingDays, startTime, endTime);
			
			createNewCourse(newCourse);
		}
	}
	
	/**
	* Adds course to catalogue by checking its parameters for validity; this handles start time and end time being passed in as strings.
	* 
	* @void
	 */
	public void createNewCourse(String name, String title, String section, String instructorId, String meetingDays, String startTime, String endTime) {
		
		int transition1 = Integer.parseInt(startTime);
		Integer newStartTime = Integer.valueOf(transition1);
		
		int transition2 = Integer.parseInt(endTime);
		Integer newEndTime = Integer.valueOf(transition2);
		
		
		if (newStartTime == null) {
			
			throw new IllegalArgumentException("Missing start time for non-Arranged course");
			
		}
		
		if (newEndTime == null) {
			
			throw new IllegalArgumentException("Missing end time for non-Arranged course");
			
		}
		
		if (((newStartTime < 0000) || (newStartTime >2359)) || ((newEndTime < 0) || newEndTime > 2359)) {
			
			throw new IllegalArgumentException("Invalid start time or end time");
		}
		
		if (meetingDays.contains("A")) {
			
			if (meetingDays.length() > 1) {
				
				throw new IllegalArgumentException("Meeting day A should not be accompanied with other days");
				
			}
			
			if ((newStartTime != 0) || (newEndTime != 0)) {
				
				throw new IllegalArgumentException("Should not have startTime or endTime");
				
			}
			
		}
		
		if (getCourseFromCatalogue(name, section) != null) {
			
			throw new IllegalArgumentException("Cannot add a duplicate course");
			
		} else {
			
			Course newCourse = new Course(name, title, section, instructorId, meetingDays, newStartTime, newEndTime);
			
			createNewCourse(newCourse);
		}
	}
	
	/**
	* Adds course to catalogue using Course object.
	* 
	* @return true if course added, false if not
	 */
	public boolean createNewCourse(Course course) {
		
		if (catalogue.contains(course)) {
			
			return false;
			
		} else {
			
			catalogue.add(course);
			return true;
		}
	}
	
	/**
	* Removes course from schedule.
	* 
	* @return true if removed, false if not
	 */
	public boolean removeCourseFromSchedule(String a, String b) {
		
		//Iterate through schedule
		for (Course course: schedule) {
			
			//If course and section match, remove course and return true
			if ((course.getName() == a) && (course.getSection() == b)) {
				schedule.remove(course);
				return true;
			}
		
		}
		
		//Otherwise, return false
		return false;
	}
	
	/**
	* Resets scehdule.
	* 
	* @void
	 */
	public void resetSchedule() {
		
		//Sets schedule to a new ArrayList to reset
		schedule = new ArrayList<Course>();
	}
	
	/**
	* Gets course catalogue by iterating through catalogue and formating strings.
	* 
	* @return 2d array of course catalogue
	 */
	public String[][] getCourseCatalogue() {
		
		//Initialize 2d array to the size of catalogue
		String[][] catalogueArray = new String[catalogue.size()][3];
		
		int counter = 0;
			
		//Iterate through catalogue
		for (Course course: catalogue) {
			
			//Add name, section, and title to correct positions
			catalogueArray[counter][0] = course.getName();
			catalogueArray[counter][1] = course.getSection();
			catalogueArray[counter][2] = course.getTitle();
			counter++;		
		}
		
		//Return array 
		return catalogueArray;
	}
	
	/**
	* Gets course schedule by iterating through schedule and formating strings.
	* 
	* @return 2d array of course schedule
	 */
	public String[][] getScheduledCourses() {
		
		//Initialize 2d array to the size of schedule
		String[][] scheduleArray = new String[schedule.size()][3];
		
		int counter = 0;
			
		//Iterate through schedule
		for (Course course: schedule) {
			  
			//Add name, section, and title to correct positions
			scheduleArray[counter][0] = course.getName();
			scheduleArray[counter][1] = course.getSection();
			scheduleArray[counter][2] = course.getTitle();
			counter++;		
		}
		
		//Return array
		return scheduleArray;
	}
	
	/**
	* Gets full course schedule by iterating through schedule and formating strings.
	* 
	* @return 2d array of full course schedule
	 */
	public String[][] getFullScheduledCourses() {
		
		
		//Initialize 2d array to the size of schedule
		String[][] scheduleArray = new String[schedule.size()][5];
		
		int counter = 0;
			
		//Iterate through schedule
		for (Course course: schedule) {
			
			//Add name, section, and title to correct positions
			scheduleArray[counter][0] = course.getName();
			scheduleArray[counter][1] = course.getSection();
			scheduleArray[counter][2] = course.getTitle();
			scheduleArray[counter][3] = course.getInstructorId();
			scheduleArray[counter][4] = course.getMeetingString();
			counter++;		
		}
		
		//Return array
		return scheduleArray;
	}
	
	/**
	* Sets schedule title solong as it is not null.
	* 
	* @void
	 */
	public void setScheduleTitle(String title) {
		
		if (title == null) {
			throw new IllegalArgumentException();
		} else {
			
			this.title = title;
		}
	}
	
	/**
	* Gets schedule title.
	* 
	* @return title as a string
	 */
	public String getScheduleTitle() {
		
		return title;
	}
}
