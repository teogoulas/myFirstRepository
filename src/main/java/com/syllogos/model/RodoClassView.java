package com.syllogos.model;

import java.time.LocalDate;

public class RodoClassView {

	private String className;

	private String day;

	private String time;

	private String tutorName;

	private String additionalInfo;

	private Integer duration;

	public RodoClassView(String className, String day, String time, String tutorName, String additionalInfo, Integer duration) {
		this.className = className;
		this.day = day;
		this.time = time;
		this.tutorName = tutorName;
		this.additionalInfo = additionalInfo;
		this.duration = duration;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
}
