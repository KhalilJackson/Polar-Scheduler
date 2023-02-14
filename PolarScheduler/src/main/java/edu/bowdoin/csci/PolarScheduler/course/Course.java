package edu.bowdoin.csci.PolarScheduler.course;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Course {
	
	private static final int MIN_NAME_LENGTH = 4;
	private static final int MAX_NAME_LENGTH = 10;
	private static final int MIN_LETTER_COUNT = 4;
	private static final int MAX_LETTER_COUNT = 10;
	private static final int DIGIT_COUNT = 5;
	private static final int SECTION_LENGTH = 21;
	private static final int UPPER_HOUR = 12;
	private static final int UPPER_MINUTE = 12;
	
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
		
		//Ensures title is not null or an empty string
		if ((title == null) || (title == "")) {
			throw new IllegalArgumentException();
		} else {
		this.title = title;
		}
	}
	
	public String getSection() {
		return section;
	}
	

	public void setSection(String section) {
		
		//Ensures section is between 1-4 characters
		if ((section.length() < 1) || (section.length() < 4)) {
			throw new IllegalArgumentException();
		} else {
			this.section = section;
		}
	}
	
	
	public String getInstructorId() {
		return instructorId;
	}
	
	//Ensures instructor id is not null or empty string,
	//no longer than 20 characters, and has no spaces
	public void setInstructorId(String instructorId) {
		
		if (((instructorId == null) || (instructorId == "")) || (instructorId.length() > 20) || (instructorId.contains(" "))) {
			throw new IllegalArgumentException();
		} else {
		this.instructorId = instructorId;
		}
	}
	public String getName() {
		return name;
	}
	
	//What do I do for this?
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
	
	public Course() {
		super();

	}
	
	public Course(String name, String title, String section, String instructorId, String meetingDays) {
		super();
		
		
		//setName(name);
		
		setTitle(title);
		setSection(section);
		setInstructorId(instructorId);
		this.meetingDays = meetingDays;
		//setMeetingDays(meetingDays);
		
//		this.name = name;
//		this.title = title;
//		this.section = section;
//		this.instructorId = instructorId;
//		this.meetingDays = meetingDays;
	}
	
	
	public Course(String name, String title, String section, String instructorId, String meetingDays, int startTime,
			int endTime) {
		super();
		
		
		//setName(name);
		
		setTitle(title);
		setSection(section);
		setInstructorId(instructorId);
		setMeetingDaysAndTime(meetingDays, startTime, endTime);
		
		
//		this.name = name;
//		this.title = title;
//		this.section = section;
//		this.instructorId = instructorId;
//		this.meetingDays = meetingDays;
//		this.startTime = startTime;
//		this.endTime = endTime;
	}
	
	
	public void setMeetingDaysAndTime(String s, int w, int e) {
		
		//Creates a hash set to get rid of duplicate characters
		Set<Character> check = new HashSet<Character>();
		
		//Add characters to the set
		for (int i = 0; i < s.length(); i++) {
			
			check.add(s.charAt(i));
		}
		
		//If there are duplicates, throw exception
		if (s.length() != check.size()) {
			throw new IllegalArgumentException();
		}
		
		//If days are not of acceptable characters, throw exception		
		for (char day: check) {
			
			if ((day == 'M') || (day == 'T') || (day == 'W') || (day == 'H') || (day == 'F') || (day == 'A')) {
				
			} else {
				throw new IllegalArgumentException();
			}
		}
		
		//If there is an A, make sure it is the only meeting day
		//Also ensures start and end times are set to zero
		if ((s.contains("A"))) {
			
			if ((s.length() > 1)) {
				throw new IllegalArgumentException();
			}
			
			if ((w != 0) && (e != 0)) {
				throw new IllegalArgumentException();
			}
			
		}
		
		//Makes sure start time falls within acceptable range
		if ((w < 0) || (w > 2_359)) {
			throw new IllegalArgumentException();
		}
		
		//Makes sure end time falls within acceptable range
		if ((e < 0) || (e > 2_359)) {
			throw new IllegalArgumentException();
		}
		
		//Makes sure end time is after start time
		if (w < e) {
			throw new IllegalArgumentException();
		}
		
		this.meetingDays = s;
		this.startTime = w;
		this.endTime = e;			
		
	}
	
	public String getMeetingString() {
		
		String timeString = "Class meets from " + startTime + " to " + endTime + " on " + meetingDays;
		
		return timeString;
		
	}
	
	private int getTimeString(int s) {
		return s;
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(endTime, instructorId, meetingDays, name, section, startTime, title);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return endTime == other.endTime && Objects.equals(instructorId, other.instructorId)
				&& Objects.equals(meetingDays, other.meetingDays) && Objects.equals(name, other.name)
				&& Objects.equals(section, other.section) && startTime == other.startTime
				&& Objects.equals(title, other.title);
	}
	
	
	
	/**
	* Returns a comma separated value String of all Course fields.
	* 
	* @return String representation of Course
	 */
	@Override
	public String toString() {
	    if ("A".equals(meetingDays)) {
	        return name + "," + title + "," + section + "," + instructorId + "," + meetingDays;
	    }
	    return name + "," + title + "," + section + "," + instructorId + "," + meetingDays + ","
	            + startTime + "," + endTime;
	}

}
