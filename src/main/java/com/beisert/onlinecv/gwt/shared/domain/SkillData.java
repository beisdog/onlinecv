package com.beisert.onlinecv.gwt.shared.domain;

public class SkillData {

	String category = "technical";
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

	public SkillData() {
	}

	public SkillData(String skill, double numberOfYears, int yearLastUsed) {
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
