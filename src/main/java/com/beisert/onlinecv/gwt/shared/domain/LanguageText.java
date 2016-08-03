package com.beisert.onlinecv.gwt.shared.domain;

/**
 * Part of I18Text.
 */
public class LanguageText {

	String locale;
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
