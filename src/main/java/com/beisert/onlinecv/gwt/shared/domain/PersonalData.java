package com.beisert.onlinecv.gwt.shared.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.fasterxml.jackson.annotation.JsonFormat;

@XmlAccessorType(XmlAccessType.FIELD)
public class PersonalData {

	String lastName;
	String firstName;

	SimpleDate birthDate;

	int numberOfChildren;

	public static enum RelationShipStatus {
		SINGLE,WIDOWED,MARRIED,DIVORCED,IN_A_RELATIONSHIP;
	}
	
	RelationShipStatus relationShipStatus = RelationShipStatus.MARRIED;

	AdressData address;

	@XmlElementWrapper(name="communications")
	List<CommunicationData> communicationData = new ArrayList<CommunicationData>();

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public SimpleDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(SimpleDate birthDate) {
		this.birthDate = birthDate;
	}

	public int getNumberOfChildren() {
		return numberOfChildren;
	}

	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}

	public RelationShipStatus getRelationShipStatus() {
		return relationShipStatus;
	}

	public void setRelationShipStatus(RelationShipStatus relationShipStatus) {
		this.relationShipStatus = relationShipStatus;
	}

	public AdressData getAddress() {
		return address;
	}

	public void setAddress(AdressData address) {
		this.address = address;
	}

	public List<CommunicationData> getCommunicationData() {
		return communicationData;
	}

	public void setCommunicationData(List<CommunicationData> communicationData) {
		this.communicationData = communicationData;
	}

}
