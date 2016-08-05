package com.beisert.onlinecv.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
@XmlType( propOrder={"category","skill","numberOfYears","yearLastUsed","skillLevel"})
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSkill {

	String category = "technical";
	@XmlAttribute(name="skill")
	String skill;
	double numberOfYears;
	int yearLastUsed;
	SkillLevel skillLevel = SkillLevel.EXPERT;

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
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

}
