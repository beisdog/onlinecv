package com.beisert.onlinecv.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType( propOrder={"lastname","firstname","birthday","numberOfChildren","citizenship","workPermit","hobbies","relationshipStatus","address","communicationData","additionalInfos"})
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonalData {

	String lastname;
	String firstname;

	SimpleDate birthday;

	int numberOfChildren;
	
	I18NText citizenship;
	
	I18NText hobbies;
	
	I18NText workPermit;

	public static enum RelationShipStatus {
		SINGLE,WIDOWED,MARRIED,DIVORCED,IN_A_RELATIONSHIP;
	}
	
	RelationShipStatus relationshipStatus = RelationShipStatus.MARRIED;

	AddressData address;

	List<CommunicationData> communicationData = new ArrayList<CommunicationData>();
	
	List<GenericContainer> additionalInfos = new ArrayList<GenericContainer>();

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastName) {
		this.lastname = lastName;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}

	public SimpleDate getBirthday() {
		return birthday;
	}
	public void setBirthday(SimpleDate birthDate) {
		this.birthday = birthDate;
	}

	public int getNumberOfChildren() {
		return numberOfChildren;
	}

	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}

	public RelationShipStatus getRelationshipStatus() {
		return relationshipStatus;
	}

	public void setRelationshipStatus(RelationShipStatus relationShipStatus) {
		this.relationshipStatus = relationShipStatus;
	}

	public AddressData getAddress() {
		return address;
	}

	public void setAddress(AddressData address) {
		this.address = address;
	}

	public List<CommunicationData> getCommunicationData() {
		return communicationData;
	}

	public void setCommunicationData(List<CommunicationData> communicationData) {
		this.communicationData = communicationData;
	}

	public I18NText getHobbies() {
		return hobbies;
	}

	public void setHobbies(I18NText hobbies) {
		this.hobbies = hobbies;
	}

	public List<GenericContainer> getAdditionalInfos() {
		return additionalInfos;
	}

	public void setAdditionalInfos(List<GenericContainer> additionalInfos) {
		this.additionalInfos = additionalInfos;
	}

	public I18NText getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(I18NText citizenship) {
		this.citizenship = citizenship;
	}

	public I18NText getWorkPermit() {
		return workPermit;
	}

	public void setWorkPermit(I18NText workPermit) {
		this.workPermit = workPermit;
	}

}
