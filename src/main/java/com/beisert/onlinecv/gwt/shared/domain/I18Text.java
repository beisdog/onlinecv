package com.beisert.onlinecv.gwt.shared.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a multilanguage struct.
 */
public class I18Text {

	String defaultText;

	List<LanguageText> languageTexts = new ArrayList<LanguageText>();

	public String getDefaultText() {
		return defaultText;
	}

	public void setDefaultText(String defaultText) {
		this.defaultText = defaultText;
	}

	public List<LanguageText> getLanguageTexts() {
		return languageTexts;
	}

	public void setLanguageTexts(List<LanguageText> languageTexts) {
		this.languageTexts = languageTexts;
	}

	public I18Text() {
	}

	public I18Text(String de, String en) {
		this.defaultText = de;
		this.languageTexts.add(new LanguageText("en", en));
	}

}
