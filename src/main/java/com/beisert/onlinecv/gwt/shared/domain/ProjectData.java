package com.beisert.onlinecv.gwt.shared.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectData {
	
	I18Text title;
	@XmlElementWrapper(name="usedSkills")
	@XmlElement(name="skill")
	List<SkillData> usedSkills = new ArrayList<SkillData>();
	
	I18Text description;
	
	SimpleDate from;
	
	SimpleDate to;
	
	String customer;
	
	
	public ProjectData(){}
	
	public ProjectData(I18Text title, I18Text description, String customer, SimpleDate from, SimpleDate to,
			SkillData...usedSkills) {
		super();
		this.title = title;
		this.description = description;
		this.customer = customer;
		this.from = from;
		this.to = to;
		this.usedSkills = Arrays.asList(usedSkills);
	}

	@XmlElement(name="additionalInfo")
	List<GenericContainer> additionalInfos = null;

	public I18Text getTitle() {
		return title;
	}

	public void setTitle(I18Text title) {
		this.title = title;
	}

	public List<SkillData> getUsedSkills() {
		return usedSkills;
	}

	public void setUsedSkills(List<SkillData> usedSkills) {
		this.usedSkills = usedSkills;
	}

	public I18Text getDescription() {
		return description;
	}

	public void setDescription(I18Text description) {
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
