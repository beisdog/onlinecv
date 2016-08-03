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

	PersonalData personalData;

	List<TechnicalSkillData> technicalSkills = new ArrayList<TechnicalSkillData>();
	
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

	public List<TechnicalSkillData> getTechnicalSkills() {
		return technicalSkills;
	}

	public void setTechnicalSkills(List<TechnicalSkillData> technicalSkills) {
		this.technicalSkills = technicalSkills;
	}

}
