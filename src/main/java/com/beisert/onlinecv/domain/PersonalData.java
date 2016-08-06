package com.beisert.onlinecv.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType( propOrder={"lastname","firstname","birthday","numberOfChildren","relationshipStatus","address","communicationData"})
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonalData {

	String lastname;
	String firstname;

	SimpleDate birthday;

	int numberOfChildren;

	public static enum RelationShipStatus {
		SINGLE,WIDOWED,MARRIED,DIVORCED,IN_A_RELATIONSHIP;
	}
	
	RelationShipStatus relationshipStatus = RelationShipStatus.MARRIED;

	AddressData address;

	List<CommunicationData> communicationData = new ArrayList<CommunicationData>();

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

}
