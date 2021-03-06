package com.beisert.onlinecv.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

import com.beisert.onlinecv.domain.LanguageText.Locale;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a multilanguage struct.
 */
@ApiModel
@XmlType( propOrder={"defaultText","languageTexts"})
public class I18NText {

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

	public I18NText() {
	}

	public I18NText(String de, String en) {
		this.defaultText = de;
		this.languageTexts.add(new LanguageText(Locale.ENGLISH, en));
	}

}
