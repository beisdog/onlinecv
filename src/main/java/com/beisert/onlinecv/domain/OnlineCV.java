package com.beisert.onlinecv.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.jongo.marshall.jackson.oid.MongoId;
import org.jongo.marshall.jackson.oid.MongoObjectId;

/**
 * Data object for an online cv
 */
@XmlType( propOrder={"_id","user","cvName","personalData","userSkills","projects"})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OnlineCV {
	
	@MongoId
	@MongoObjectId
	String _id;
	
	String user;
	String cvName;

	PersonalData personalData;

//	@XmlElementWrapper(name="technicalSkills")
//	@XmlElement(name="skill")
	List<UserSkill> userSkills = null;
	
//	@XmlElementWrapper(name="projects")
//	@XmlElement(name="project")
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

	public List<UserSkill> getUserSkills() {
		//needed for jaxb
		if(userSkills == null) userSkills = new ArrayList<UserSkill>();
		return userSkills;
	}

	public void setUserSkills(List<UserSkill> technicalSkills) {
		this.userSkills = technicalSkills;
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