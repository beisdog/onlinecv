package com.beisert.onlinecv.gwt.shared.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Data object for an online cv
 */
@XmlRootElement
public class OnlineCV {
	
	
	String id;
	
	String user;

	PersonalData personalData;

	List<SkillData> technicalSkills = new ArrayList<SkillData>();
	
	List<ProjectData> projects = new ArrayList<ProjectData>();
	

	public List<ProjectData> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectData> projects) {
		this.projects = projects;
	}

	public PersonalData getPersonalData() {
		return personalData;
	}

	public void setPersonalData(PersonalData personalData) {
		this.personalData = personalData;
	}

	public List<SkillData> getTechnicalSkills() {
		return technicalSkills;
	}

	public void setTechnicalSkills(List<SkillData> technicalSkills) {
		this.technicalSkills = technicalSkills;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
