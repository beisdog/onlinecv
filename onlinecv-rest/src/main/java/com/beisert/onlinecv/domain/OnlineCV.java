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

import io.swagger.annotations.ApiModel;

/**
 * Data object for an online cv
 */
@ApiModel
@XmlType( propOrder={"_id","user","name","personalData","education","certifications","jobs","languageSkills","userSkills","projects"})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OnlineCV {
	
	@MongoId
	@MongoObjectId
	String _id;
	
	String user;
	String name;

	PersonalData personalData;
	
	List<Education> education = new ArrayList<Education>();
	
	List<Certification> certifications = new ArrayList<Certification>();
	
	List<UserSkill> userSkills = new ArrayList<UserSkill>();
	
	List<LanguageSkill> languageSkills = new ArrayList<LanguageSkill>();
	
	List<Job> jobs = new ArrayList<Job>();
	
	
	List<Project> projects = new ArrayList<Project>();
	

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public PersonalData getPersonalData() {
		return personalData;
	}

	public void setPersonalData(PersonalData personalData) {
		this.personalData = personalData;
	}

	public List<UserSkill> getUserSkills() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Education> getEducation() {
		return education;
	}

	public void setEducation(List<Education> education) {
		this.education = education;
	}

	public List<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<Certification> certifications) {
		this.certifications = certifications;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public List<LanguageSkill> getLanguageSkills() {
		return languageSkills;
	}

	public void setLanguageSkills(List<LanguageSkill> languageSkills) {
		this.languageSkills = languageSkills;
	}

}
