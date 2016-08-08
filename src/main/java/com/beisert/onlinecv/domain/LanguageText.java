package com.beisert.onlinecv.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Part of I18Text.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class LanguageText {
	
	public static enum Locale{
		ENGLISH,FRENCH,ITALIAN,GERMAN;
	} 

	Locale locale;
	String text;

	public LanguageText(){}
	
	public LanguageText(Locale locale, String text) {
		super();
		this.locale = locale;
		this.text = text;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


}
