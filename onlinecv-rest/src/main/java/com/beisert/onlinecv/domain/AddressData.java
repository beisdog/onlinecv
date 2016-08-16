package com.beisert.onlinecv.domain;

import javax.xml.bind.annotation.XmlType;

import io.swagger.annotations.ApiModel;

@ApiModel
@XmlType( propOrder={"street","houseNumber","additionalLine","zip","city","countryName"})
public class AddressData {

	String street;
	String houseNumber;
	String additionalLine;
	String zip;
	String city;
	String countryName;
	
	
	public AddressData(){}
	
	public AddressData(String street, String houseNumber, String additionalLine, String zip, String city,
			String countryName) {
		super();
		this.street = street;
		this.houseNumber = houseNumber;
		this.additionalLine = additionalLine;
		this.zip = zip;
		this.city = city;
		this.countryName = countryName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getAdditionalLine() {
		return additionalLine;
	}

	public void setAdditionalLine(String additionalLine) {
		this.additionalLine = additionalLine;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
