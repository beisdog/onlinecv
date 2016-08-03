<<<<<<< HEAD
package com.beisert.onlinecv.gwt.shared;

public class AdressData {
  
  String street;
  String houseNumber;
  String additionalLine;
  String zip;
  String city;
  String countryName;
  
=======
package com.beisert.onlinecv.gwt.shared.domain;

public class AdressData {

	String street;
	String houseNumber;
	String additionalLine;
	String zip;
	String city;
	String countryName;
	
	
	public AdressData(){}
	
	public AdressData(String street, String houseNumber, String additionalLine, String zip, String city,
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

>>>>>>> 5b7e992de2754950669724678236ad1a13c68da2
}
