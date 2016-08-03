package com.beisert.onlinecv.gwt.shared;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Data object for an online cv
 */
@XmlRootElement
public class OnlineCV {
  
  
  PersonalData personalData;
  
  List<TechnicalSkillData> technicalSkills;
  
}
