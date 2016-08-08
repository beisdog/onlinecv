package com.beisert.onlinecv.domain;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"from","to","title","description","company"})
public class Job {
	
	
	SimpleDate from;
	
	SimpleDate to;
	
	I18NText title;

	I18NText description;
	
	
	String company;
	
	public Job(){}

	public Job(SimpleDate from, SimpleDate to, I18NText title, I18NText description, String company) {
		super();
		this.from = from;
		this.to = to;
		this.title = title;
		this.description = description;
		this.company = company;
	}

	public I18NText getTitle() {
		return title;
	}

	public void setTitle(I18NText title) {
		this.title = title;
	}

	public I18NText getDescription() {
		return description;
	}

	public void setDescription(I18NText description) {
		this.description = description;
	}

	public SimpleDate getFrom() {
		return from;
	}

	public void setFrom(SimpleDate from) {
		this.from = from;
	}

	public SimpleDate getTo() {
		return to;
	}

	public void setTo(SimpleDate to) {
		this.to = to;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
