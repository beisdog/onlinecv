package com.beisert.onlinecv.gwt.shared.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProjectData {
	
	I18Text title;
	
	List<TechnicalSkillData> usedSkills = new ArrayList<TechnicalSkillData>();
	
	I18Text description;
	
	java.sql.Date from;
	
	java.sql.Date to;
	
	String customer;
	
	
	
	public ProjectData(I18Text title, I18Text description, String customer, Date from, Date to,
			TechnicalSkillData...usedSkills) {
		super();
		this.title = title;
		this.description = description;
		this.customer = customer;
		this.from = from;
		this.to = to;
		this.usedSkills = Arrays.asList(usedSkills);
	}

	GenericContainer additionalInfos = null;

	public I18Text getTitle() {
		return title;
	}

	public void setTitle(I18Text title) {
		this.title = title;
	}

	public List<TechnicalSkillData> getUsedSkills() {
		return usedSkills;
	}

	public void setUsedSkills(List<TechnicalSkillData> usedSkills) {
		this.usedSkills = usedSkills;
	}

	public I18Text getDescription() {
		return description;
	}

	public void setDescription(I18Text description) {
		this.description = description;
	}

	public java.sql.Date getFrom() {
		return from;
	}

	public void setFrom(java.sql.Date from) {
		this.from = from;
	}

	public java.sql.Date getTo() {
		return to;
	}

	public void setTo(java.sql.Date to) {
		this.to = to;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public GenericContainer getAdditionalInfos() {
		return additionalInfos;
	}

	public void setAdditionalInfos(GenericContainer additionalInfos) {
		this.additionalInfos = additionalInfos;
	}
	
	
	
	

}
