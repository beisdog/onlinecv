package com.beisert.onlinecv.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType( propOrder={"key","title","usedSkills","description","from","to","customer","additionalInfos"})
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectData {
	
	/** unique within cv and mandatory */
	String key;
	
	I18NText title;

	List<UserSkill> usedSkills = new ArrayList<UserSkill>();
	
	I18NText description;
	
	SimpleDate from;
	
	SimpleDate to;
	
	String customer;
	@XmlElement(name="additionalInfo")
	List<GenericContainer> additionalInfos = null;
	
	public ProjectData(){}
	
	public ProjectData(I18NText title, I18NText description, String customer, SimpleDate from, SimpleDate to,
			UserSkill...usedSkills) {
		super();
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
	
	
	
	

}
