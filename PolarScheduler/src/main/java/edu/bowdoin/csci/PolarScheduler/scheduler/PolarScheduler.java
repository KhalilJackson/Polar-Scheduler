package edu.bowdoin.csci.PolarScheduler.scheduler;

import edu.bowdoin.csci.PolarScheduler.course.Course;
import edu.bowdoin.csci.PolarScheduler.utils.ArrayList;

public class PolarScheduler {
	
	private String title;
	
	private ArrayList<Course> catalogue;
	
	private ArrayList<Course> schedule;
	
	
	public PolarScheduler() {
		
		this.title = "My Schedule";
		this.catalogue = new ArrayList<Course>();
		this.schedule = new ArrayList<Course>();
		
	}
	
	public Course getCourseFromCatalogue(String name, String section) {
		
		//Iterate through course catalogue
		for (Course course: catalogue) {
			
			//Return course if in the catalogue
			if ((name.equals(course.getName())) && (section.equals(course.getSection()))) {
				//System.out.println(course);
				return course;
				
			}
		}	
		
		//Otherwise, return false
		return null;
	}
	
	public boolean addCourseToSchedule(String name, String section) {
		
		Course addCourse = getCourseFromCatalogue(name, section);
		//System.out.println(addCourse);
		
		//Return false if course not found
		if (addCourse == null) {
			//System.out.println(false);
			return false;
		} else {
			
			//Iterate through schedule
			for (Course course: schedule) {
				
				//Throw exception if course already found in schedule
				if (course.getName() == addCourse.getName()) {
					//System.out.println("You are already enrolled in " + course.getName());
					throw new IllegalArgumentException("You are already enrolled in " + course.getName());
				}
			}
			
			//Otherwise, add course and return true
			schedule.add(addCourse);
			return true;
			
		}
	}
	
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
	
	public boolean createNewCourse(Course course) {
		
		if (catalogue.contains(course)) {
			
			return false;
			
		} else {
			
			catalogue.add(course);
			System.out.println(catalogue);
			return true;
		}
	}
	
	
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
	
	
	public void resetSchedule() {
		
		//Sets schedule to a new ArrayList to reset
		schedule = new ArrayList<Course>();
		
	}
	
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
	
	
	public String[][] getScheduledCourses() {
		
		//Initialize 2d array to the size of schedule
		String[][] scheduleArray = new String[schedule.size()][3];
		
		int counter = 0;
			
		//Iterate through schedule
		for (Course course: schedule) {
			
			System.out.println(course + "Hello");  
			
			//Add name, section, and title to correct positions
			scheduleArray[counter][0] = course.getName();
			scheduleArray[counter][1] = course.getSection();
			scheduleArray[counter][2] = course.getTitle();
			counter++;		
		}
		
		//Return array
		return scheduleArray;
	}
	
	
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
	
	
	public void setScheduleTitle(String title) {
		
		if (title == null) {
			throw new IllegalArgumentException();
		} else {
			
			this.title = title;
		}
	}
	
	
	public String getScheduleTitle() {
		
		return title;
	}

}
