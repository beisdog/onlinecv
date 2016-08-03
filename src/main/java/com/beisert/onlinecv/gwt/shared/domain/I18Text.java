<<<<<<< HEAD
package com.beisert.onlinecv.gwt.shared;
=======
package com.beisert.onlinecv.gwt.shared.domain;
>>>>>>> 5b7e992de2754950669724678236ad1a13c68da2

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a multilanguage struct.
 */
public class I18Text {
<<<<<<< HEAD
  
  String defaultText;
  
  List<LanguageText> languageTexts = new ArrayList<LanguageText>();
=======

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

>>>>>>> 5b7e992de2754950669724678236ad1a13c68da2
}
