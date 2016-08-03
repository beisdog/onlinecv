<<<<<<< HEAD
package com.beisert.onlinecv.gwt.shared;

public class TechnicalSkillData {
  
  
  String skill;
  double numberOfYears;
  int yearLastUsed;
  
  
=======
package com.beisert.onlinecv.gwt.shared.domain;

public class TechnicalSkillData {

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

	public static enum SkillLevel{
		BEGINNER,GOOD_EXPERIENCE,EXPERT;
	}
	
	public TechnicalSkillData(){}

	public TechnicalSkillData(String skill, double numberOfYears, int yearLastUsed) {
		super();
		this.skill = skill;
		this.numberOfYears = numberOfYears;
		this.yearLastUsed = yearLastUsed;
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

>>>>>>> 5b7e992de2754950669724678236ad1a13c68da2
}
