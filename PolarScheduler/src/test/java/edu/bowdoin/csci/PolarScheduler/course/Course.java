package edu.bowdoin.csci.PolarScheduler.course;

public class Course {
	
	private static final int MIN_NAME_LENGTH;
	private static final int MAX_NAME_LENGTH;
	private static final int MIN_LETTER_COUNT;
	private static final int MAX_LETTER_COUNT;
	private static final int DIGIT_COUNT;
	private static final int SECTION_LENGTH;
	private static final int UPPER_HOUR;
	private static final int UPPER_MINUTE;
	
	private String name;
	private String title;
	private String section;
	private String instructorId;
	private String meetingDays;
	private int startTime;
	private int endTime;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}
	public String getName() {
		return name;
	}
	
	private void setName() {
		this.name = name;
	}
	
	public String getMeetingDays() {
		return meetingDays;
	}
	public int getStartTime() {
		return startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	
	
	public Course(String name, String title, String section, String instructorId, String meetingDays) {
		super();
		this.name = name;
		this.title = title;
		this.section = section;
		this.instructorId = instructorId;
		this.meetingDays = meetingDays;
	}
	
	
	public Course(String name, String title, String section, String instructorId, String meetingDays, int startTime,
			int endTime) {
		super();
		this.name = name;
		this.title = title;
		this.section = section;
		this.instructorId = instructorId;
		this.meetingDays = meetingDays;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	
	
	
	
	public void setMeetingDaysAndTime(String s, int w, int e) {
		
		
	}
	
	public void getMeetingString() {
		
		
	}
	
	private int getTimeString(int s) {
		return s;
		
	}
	
	public int hashCode() {
		return endTime;
		
		
	}
	
	public boolean equals(Object o) {
		return false;
		
		
	}
	
	public String toString() {
		return instructorId;
		
	}

}
