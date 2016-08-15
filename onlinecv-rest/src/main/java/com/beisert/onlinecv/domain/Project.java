package com.beisert.onlinecv.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType( propOrder={"key","title","usedSkills","description","from","to","customer","industry",
		"projectLocation","projectSize","role","objective","responsibility","benefitForCustomer","additionalInfos"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Project {
	
		
	/** unique within cv and mandatory */
	String key;
	
	I18NText title;

	List<UserSkill> usedSkills = new ArrayList<UserSkill>();
	
	I18NText description;
	
	SimpleDate from;
	
	SimpleDate to;
	
	String customer;
	
	I18NText industry;
	
	I18NText projectLocation;
	
	I18NText projectSize;
	
	I18NText role;
	
	I18NText objective;
	
	I18NText responsibility;
	
	I18NText benefitForCustomer;
	
	List<GenericContainer> additionalInfos = null;
	
	public Project(){}
	
	public Project(String key, I18NText title) {
		super();
		this.key = key;
		this.title = title;
	}
	
	public Project(String key, I18NText title, I18NText description, String customer, SimpleDate from, SimpleDate to,
			UserSkill...usedSkills) {
		super();
		this.key = key;
		this.title = title;
		this.description = description;
		this.customer = customer;
		this.from = from;
		this.to = to;
		this.usedSkills = Arrays.asList(usedSkills);
	}



	public I18NText getTitle() {
		return title;
	}

	public void setTitle(I18NText title) {
		this.title = title;
	}

	public List<UserSkill> getUsedSkills() {
		return usedSkills;
	}

	public void setUsedSkills(List<UserSkill> usedSkills) {
		this.usedSkills = usedSkills;
	}

	public I18NText getDescription() {
		return description;
	}

	public void setDescription(I18NText description) {
		this.description = description;
	}

	public SimpleDate getFrom() {
		return from;
	}

	public void setFrom(SimpleDate from) {
		this.from = from;
	}

	public SimpleDate getTo() {
		return to;
	}

	public void setTo(SimpleDate to) {
		this.to = to;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public List<GenericContainer> getAdditionalInfos() {
		if(additionalInfos==null)additionalInfos=new ArrayList<GenericContainer>();
		return additionalInfos;
	}

	public void setAdditionalInfos(List<GenericContainer> additionalInfos) {
		this.additionalInfos = additionalInfos;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public I18NText getIndustry() {
		return industry;
	}

	public void setIndustry(I18NText industry) {
		this.industry = industry;
	}

	public I18NText getProjectLocation() {
		return projectLocation;
	}

	public void setProjectLocation(I18NText projectLocation) {
		this.projectLocation = projectLocation;
	}

	public I18NText getProjectSize() {
		return projectSize;
	}

	public void setProjectSize(I18NText projectSize) {
		this.projectSize = projectSize;
	}

	public I18NText getRole() {
		return role;
	}

	public void setRole(I18NText role) {
		this.role = role;
	}

	public I18NText getObjective() {
		return objective;
	}

	public void setObjective(I18NText objective) {
		this.objective = objective;
	}

	public I18NText getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(I18NText responsibility) {
		this.responsibility = responsibility;
	}

	public I18NText getBenefitForCustomer() {
		return benefitForCustomer;
	}

	public void setBenefitForCustomer(I18NText benefitForCustomer) {
		this.benefitForCustomer = benefitForCustomer;
	}

	public void skills(UserSkill...skills) {
		this.usedSkills = Arrays.asList(skills);
	}
	
	
	
	

}
