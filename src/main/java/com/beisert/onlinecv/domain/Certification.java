package com.beisert.onlinecv.domain;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"from","title"})
public class Certification {
	
	SimpleDate from;
	
	I18NText title = new I18NText();
	
	

	public Certification() {
		super();
	}
	

	public Certification(SimpleDate from, I18NText title) {
		super();
		this.from = from;
		this.title = title;
	}


	public SimpleDate getFrom() {
		return from;
	}

	public void setFrom(SimpleDate from) {
		this.from = from;
	}

	public I18NText getTitle() {
		return title;
	}

	public void setTitle(I18NText title) {
		this.title = title;
	}

}
