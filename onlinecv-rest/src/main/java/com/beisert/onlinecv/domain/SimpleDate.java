package com.beisert.onlinecv.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import io.swagger.annotations.ApiModel;
@ApiModel
@XmlType( propOrder={"year","month","day"})
@XmlAccessorType(XmlAccessType.FIELD)
public class SimpleDate {
	
	int year;
	int month;
	int day;
	public SimpleDate(){}
	public SimpleDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	

}
