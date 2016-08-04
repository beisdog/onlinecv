package com.beisert.onlinecv.gwt.shared.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.jongo.marshall.jackson.oid.MongoId;
import org.jongo.marshall.jackson.oid.MongoObjectId;

/**
 * Data object for an online cv
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OnlineCV {
	
	@MongoId
	@MongoObjectId
	String _id;
	
	String user;
	String cvName;

	PersonalData personalData;

	@XmlElementWrapper(name="technicalSkills")
	@XmlElement(name="skill")
	List<SkillData> technicalSkills = null;
	
	@XmlElementWrapper(name="projects")
	@XmlElement(name="project")
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
		//needed for jaxb
		if(technicalSkills == null) technicalSkills = new ArrayList<SkillData>();
		return technicalSkills;
	}

	public void setTechnicalSkills(List<SkillData> technicalSkills) {
		this.technicalSkills = technicalSkills;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String id) {
		this._id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
