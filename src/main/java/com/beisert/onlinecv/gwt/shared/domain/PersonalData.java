package com.beisert.onlinecv.gwt.shared;

import java.util.List;



public class PersonalData {
  
  String lastName;
  String firstName;
  
  java.sql.Date birthDate;
  
  int numberOfChildren;
  
  String relationShipStatus = "married";
  
  AdressData address;
  
  List<CommunicationData> communicationData;
  
}
