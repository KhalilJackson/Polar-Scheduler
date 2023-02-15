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
	
	public Course getCourseFromCatalogue(String a, String b) {
		
		
		
		return null;
		
	}
	
	public boolean addCourseToSchedule(String a, String b) {
		
		return true;
	}
	
	public void createNewCourse(String a, String b, String c, String d, String e, String f, String g) {
		
		
		
	}
	
	public boolean createNewCourse(Course huh) {
		
		return true;
	}
	
	
	public boolean removeCourseFromSchedule(String a, String b) {
		
		return true;
	}
	
	
	public void resetSchedule() {
		
		//Sets schedule to a new ArrayList to reset
		schedule = new ArrayList<Course>();
		
	}
	
	public String[] getCourseCatalogue() {
		
		return null;
	}
	
	
	public String[] getScheduledCourses() {
		
		return null;
	}
	
	
	public String[] getFullScheduledCourses() {
		
		return null;
	}
	
	
	public void setScheduleTitle(String a) {
		
		
	}
	
	
	public String getScheduleTitle() {
		
		return null;
	}
 	
	
	
	

}
