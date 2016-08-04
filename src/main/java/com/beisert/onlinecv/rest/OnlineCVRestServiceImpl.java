package com.beisert.onlinecv.rest;



import org.json.simple.JSONObject;

import com.beisert.onlinecv.gwt.shared.domain.AdressData;
import com.beisert.onlinecv.gwt.shared.domain.CommunicationData;
import com.beisert.onlinecv.gwt.shared.domain.CommunicationData.CommunicationType;
import com.beisert.onlinecv.gwt.shared.domain.GenericContainer;
import com.beisert.onlinecv.gwt.shared.domain.I18Text;
import com.beisert.onlinecv.gwt.shared.domain.OnlineCV;
import com.beisert.onlinecv.gwt.shared.domain.PersonalData;
import com.beisert.onlinecv.gwt.shared.domain.ProjectData;
import com.beisert.onlinecv.gwt.shared.domain.SkillData;
import com.beisert.onlinecv.util.DateUtil;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/onlinecv")
public class OnlineCVRestServiceImpl {
  
  @GET
  @Path("{user}")
  @Produces(MediaType.APPLICATION_JSON)
  public OnlineCV findCVByUser(@PathParam("user") String user) {
  
    
    OnlineCV cv = new OnlineCV();
    
    PersonalData pd = new PersonalData();
    pd.setFirstName("David");
    pd.setLastName("Beisert");
    pd.setBirthDate(DateUtil.createSqlDate(1976, 7, 4));
    pd.setNumberOfChildren(2);
    
    
    SkillData java = new SkillData("java", 18d, 2016);
	cv.getTechnicalSkills().add(java);
    SkillData j2ee = new SkillData("j2ee", 18d, 2016);
	cv.getTechnicalSkills().add(j2ee);
    SkillData hibernate = new SkillData("hibernate", 18d, 2016);
	cv.getTechnicalSkills().add(hibernate);
    
    ProjectData project1 = new ProjectData(new I18Text("Tolles project", "Great Project"), new I18Text("schön","beautiful"), "BAYER", DateUtil.createSqlDate(2016, 1, 1), DateUtil.createSqlDate(2016, 8, 1), java,j2ee,hibernate);
	project1.getAdditionalInfos().add(new GenericContainer(new I18Text("Rolle", "Role"), new I18Text("Architekt", "Architect")));
	
    
    cv.getProjects().add(project1);
    
    cv.setPersonalData(pd);
    
    AdressData ad = new AdressData("Farnsburgerstrasse","54","","4052","Basel","Switzerland");
    pd.setAddress(ad);
    
    pd.setCommunicationData(new ArrayList<CommunicationData>());
    pd.getCommunicationData().add(new CommunicationData(CommunicationType.EMAIL, "david.beisert@beisert-btc.de", ""));
    pd.getCommunicationData().add(new CommunicationData(CommunicationType.MOBILE, "+49 151 58771341", ""));
    
    return cv;
    
  }
}
