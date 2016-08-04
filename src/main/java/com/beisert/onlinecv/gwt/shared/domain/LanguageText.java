package com.beisert.onlinecv.gwt.shared.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * Part of I18Text.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class LanguageText {

	@XmlAttribute
	String locale;
	@XmlValue
	String text;

	public LanguageText(){}
	
	public LanguageText(String locale, String text) {
		super();
		this.locale = locale;
		this.text = text;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


}
