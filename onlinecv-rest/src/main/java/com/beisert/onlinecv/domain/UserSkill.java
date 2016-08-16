package com.beisert.onlinecv.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import io.swagger.annotations.ApiModel;

@ApiModel
@XmlType( propOrder={"category","skill","numberOfYears","yearLastUsed","skillLevel","mainSkill"})
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSkill {
	
	public static enum Category{
		
		PROGRAMMING,DATABASE,METHODS,TOOLS,OS,SAP,FRAMEWORKS, SERVER;
		
	}

	Category category = null;
	String skill;
	double numberOfYears;
	int yearLastUsed;
	SkillLevel skillLevel = SkillLevel.EXPERT;
	boolean mainSkill = true;

	public SkillLevel getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(SkillLevel skillLevel) {
		this.skillLevel = skillLevel;
	}

	public static enum SkillLevel {
		BEGINNER, GOOD_EXPERIENCE, EXPERT;
	}

	public UserSkill() {
	}

	public UserSkill(String skill, double numberOfYears, int yearLastUsed) {
		super();
		this.skill = skill;
		this.numberOfYears = numberOfYears;
		this.yearLastUsed = yearLastUsed;
	}

	public UserSkill(Category category, String skill, double numberOfYears, int yearLastUsed, SkillLevel skillLevel,
			boolean mainSkill) {
		super();
		this.category = category;
		this.skill = skill;
		this.numberOfYears = numberOfYears;
		this.yearLastUsed = yearLastUsed;
		this.skillLevel = skillLevel;
		this.mainSkill = mainSkill;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public double getNumberOfYears() {
		return numberOfYears;
	}

	public void setNumberOfYears(double numberOfYears) {
		this.numberOfYears = numberOfYears;
	}

	public int getYearLastUsed() {
		return yearLastUsed;
	}

	public void setYearLastUsed(int yearLastUsed) {
		this.yearLastUsed = yearLastUsed;
	}

	public boolean isMainSkill() {
		return mainSkill;
	}

	public void setMainSkill(boolean mainSkill) {
		this.mainSkill = mainSkill;
	}

}
