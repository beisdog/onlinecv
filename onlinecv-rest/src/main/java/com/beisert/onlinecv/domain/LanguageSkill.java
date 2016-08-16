package com.beisert.onlinecv.domain;

import com.beisert.onlinecv.domain.LanguageText.Locale;


public class LanguageSkill {
	
	Locale locale;
	
	public static enum LanguageSkillLevel{
		MOTHERTONGUE,VERY_GOOD,GOOD,BASIC;
	}
	
	LanguageSkillLevel skillLevel;
	
	

	public LanguageSkill() {
		super();
	}

	public LanguageSkill(Locale locale, LanguageSkillLevel skillLevel) {
		super();
		this.locale = locale;
		this.skillLevel = skillLevel;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public LanguageSkillLevel getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(LanguageSkillLevel skillLevel) {
		this.skillLevel = skillLevel;
	}

}
