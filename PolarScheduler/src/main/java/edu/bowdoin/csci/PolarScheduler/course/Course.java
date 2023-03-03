package edu.bowdoin.csci.PolarScheduler.course;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Course {
	
	private static final int MIN_NAME_LENGTH = 8;
	private static final int MAX_NAME_LENGTH = 9;
	private static final int MIN_LETTER_COUNT = 3;
	private static final int MAX_LETTER_COUNT = 4;
	private static final int DIGIT_COUNT = 4;
	private static final int SECTION_LENGTH = 4;
	private static final int UPPER_HOUR = 24;
	private static final int UPPER_MINUTE = 60;
	
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
		if ((section.length() < 1) || (section.length() > 4)) {
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
	private void setName(String name) {
		
		int letterCounter = 0;
		int numberCounter = 0;
		
		boolean space = false;
		
		//Ensure name is not null or empty string
		if ((name == null) || (name == "")) {
			throw new IllegalArgumentException("Invalid Course Name.");
		}
		
		//Ensure name is between 8-9 characters
		if ((name.length() < 8) || (name.length() > 9)) {
			throw new IllegalArgumentException("Invalid Course Name.");
		}
		
		//Iterate through string by each character
		for (int index = 0; index < name.length(); index++){
			
		    //char character = name.charAt(index);
		    
			//Ensures character is one of the first 3-4 letters in the string
		    if ((Character.isLetter(name.charAt(index))) && (numberCounter == 0) && (space == false) && (letterCounter < 4)) {
		    	
		    	letterCounter++;
		    }
		    
		    //Ensures there is a space in between the letters and numbers
		    if ((name.charAt(index) == ' ') && (space == false)) {
		    	space = true;
		    }
		    
		    //Ensures numbers are the last 4 characters in the name
		    if ((Character.isDigit(name.charAt(index))) && ((letterCounter == 3) || (letterCounter == 4)) && (space == true) && (numberCounter < 4)) {
		    
		    	
		    	numberCounter++;
		    }
		    
		    //throw new IllegalArgumentException("Invalid Course Name.");
		}
		
		if (((letterCounter == 3) || (letterCounter == 4)) && (space == true) && (numberCounter == 4)) {
		this.name = name;
		}
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
		
		
		setName(name);
		setTitle(title);
		setSection(section);
		setInstructorId(instructorId);
		setMeetingDays(meetingDays);
		
	}
	
	
	public Course(String name, String title, String section, String instructorId, String meetingDays, int startTime,
			int endTime) {
		super();
		
		
		setName(name);
		setTitle(title);
		setSection(section);
		setInstructorId(instructorId);
		setMeetingDaysAndTime(meetingDays, startTime, endTime);
	}
	
	
	public void setMeetingDays(String s) {
		
		
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
				//System.out.println("Found more than one");
				throw new IllegalArgumentException("Can't have more than a single A if A is used");
			}
			
		}
		
		meetingDays = s;
	}
	
	public void setMeetingDaysAndTime(String meetingDays, int startTime, int endTime) {
		
		//Creates a hash set to get rid of duplicate characters
		Set<Character> check = new HashSet<Character>();
		
		//Add characters to the set
		for (int i = 0; i < meetingDays.length(); i++) {
			
			check.add(meetingDays.charAt(i));
		}
		
		//If there are duplicates, throw exception
		if (meetingDays.length() != check.size()) {
			throw new IllegalArgumentException("Invalid meeting days and times.");
		}
		
		//If the last two digits of startTime are greater than 59, throw exception
		if ((startTime % 100) > 59) {
			throw new IllegalArgumentException("Invalid meeting days and times.");
		}
		
		//If the last two digits of endTime are greater than 59, throw exception
		if ((endTime % 100) > 59) {
			throw new IllegalArgumentException("Invalid meeting days and times.");
		}
		
		//If days are not of acceptable characters, throw exception		
		for (char day: check) {
			
			if ((day == 'M') || (day == 'T') || (day == 'W') || (day == 'H') || (day == 'F') || (day == 'A')) {
				
			} else {
				throw new IllegalArgumentException("Invalid meeting days and times.");
			}
		}
		
		//If there is an A, make sure it is the only meeting day
		//Also ensures start and end times are set to zero
		if ((meetingDays.contains("A"))) {
			
			if ((meetingDays.length() > 1)) {
				throw new IllegalArgumentException("Invalid meeting days and times.");
			}
			
			if ((startTime != 0) || (endTime != 0)) {
				throw new IllegalArgumentException("Invalid meeting days and times.");
			}
			
		}
		
		//Makes sure start time falls within acceptable range
		if ((startTime < 0) || (startTime > 2359)) {
			throw new IllegalArgumentException("Invalid meeting days and times.");
		}
		
		//Makes sure end time falls within acceptable range
		if ((endTime < 0) || (endTime > 2359)) {
			throw new IllegalArgumentException("Invalid meeting days and times.");
		}
		
		//Makes sure end time is after start time
		if (startTime > endTime) {
			throw new IllegalArgumentException("Invalid meeting days and times.");
		}
		
		this.meetingDays = meetingDays;
		this.startTime = startTime;
		this.endTime = endTime;			
		
	}
	
	public String getMeetingString() {
		
		if ((meetingDays == "A") || (meetingDays == null)) {
			
			return "Arranged";
		} else {
			
			String time = meetingDays + " " + getTimeString(startTime) + "-" + getTimeString(endTime);
			
			return time;
			
		}
	}
	
	private String getTimeString(int s) {
		
		String code;
		
		//Cast s to use decimal point
		float x = s;
		
		if (s < 1200) {
			
			//Places decimal point in between four digits
			x = x/100;
			
			if ((s % 10) == 0) {
								
				code = Float.toString(x).replace('.', ':') + "0" + "AM";
				return code;
			}
			
			
			//Turn float into string where decimal is replaced with colon
			//and has AM at the end
			code = Float.toString(x).replace('.', ':') + "AM";
			return code;	
			
		} else {
			
			if (s > 1300) {
				
				x = (x - 1200)/100;
				
				if ((s % 10) == 0) {
					
					code = Float.toString(x).replace('.', ':') + "0" + "PM";
					return code;
				}
				
				//Turns into a formatted string with PM
				code = Float.toString(x).replace('.', ':') + "PM";		
				return code; 
				
			}
			
			//Subtracts by 1200 so we can do same math as before
			//x = (x - 1200)/100;
			x = x/100;
			
			if ((s % 10) == 0) {
				
				code = Float.toString(x).replace('.', ':') + "0" + "PM";
				return code;
			}
			
			//Turns into a formatted string with PM
			code = Float.toString(x).replace('.', ':') + "PM";
			//System.out.println(code);
			return code; 
			
		}
			
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
