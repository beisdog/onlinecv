package com.beisert.onlinecv.service;

import java.util.ArrayList;

import com.beisert.onlinecv.domain.AddressData;
import com.beisert.onlinecv.domain.Certification;
import com.beisert.onlinecv.domain.CommunicationData;
import com.beisert.onlinecv.domain.Education;
import com.beisert.onlinecv.domain.GenericContainer;
import com.beisert.onlinecv.domain.I18NText;
import com.beisert.onlinecv.domain.Job;
import com.beisert.onlinecv.domain.LanguageSkill;
import com.beisert.onlinecv.domain.OnlineCV;
import com.beisert.onlinecv.domain.PersonalData;
import com.beisert.onlinecv.domain.Project;
import com.beisert.onlinecv.domain.SimpleDate;
import com.beisert.onlinecv.domain.UserSkill;
import com.beisert.onlinecv.domain.CommunicationData.CommunicationType;
import com.beisert.onlinecv.domain.LanguageSkill.LanguageSkillLevel;
import com.beisert.onlinecv.domain.LanguageText.Locale;
import com.beisert.onlinecv.domain.UserSkill.Category;
import com.beisert.onlinecv.domain.UserSkill.SkillLevel;


/**
 * Generates Online CV data objects.
 * 
 * @author dbe
 *
 */
public class TestDataGenerator {
	
	public static OnlineCV generateNewOnlineCVFor(String userName, String lastName, String firstName) {
		OnlineCV cv = new OnlineCV();
    	
    	cv.setUser(userName);
    	cv.setName(lastName + ", " + firstName);

        PersonalData pd = new PersonalData();
        pd.setFirstname(firstName);
        pd.setLastname(lastName);
        pd.setBirthday(new SimpleDate(1976, 7, 4));
        pd.setNumberOfChildren(2);
        pd.setCitizenship(new I18NText("Deutsch", "German"));
        
        pd.setHobbies(new I18NText("Lesen, Schwimmen, Reisen, Gitarre", "Reading, Swimming, Travelling, Guitar"));
        pd.getAdditionalInfos().add(
        		new GenericContainer(new I18NText("Führerschein","Driving License"), new I18NText("Auto", "Car"))
        );
        pd.getAdditionalInfos().add(
        		new GenericContainer(new I18NText("Schweizer Arbeitserlaubnis","Swiss work permit"), new I18NText("B-Bewilligung bis 2020", "B permit until 2016"))
        );
        
        cv.setPersonalData(pd);
        AddressData ad = new AddressData("Farnsburgerstrasse", "54", "", "4052", "Basel", "Switzerland");
        pd.setAddress(ad);
        pd.setCommunicationData(new ArrayList<CommunicationData>());
        pd.getCommunicationData().add(new CommunicationData(CommunicationType.EMAIL, "david.beisert@beisert-btc.de", ""));
        pd.getCommunicationData().add(new CommunicationData(CommunicationType.MOBILE, "+49 151 58771341", ""));
        
        
        //Education
        cv.getEducation().add(
        		new Education(
        				new SimpleDate(1992,6,1),
                		new SimpleDate(1995,6,1), 
                		new I18NText("Abitur","Highschool with permission to study"), 
                		new I18NText("",""),
                		"Rudi-Stephan Gymnasium Worms"
        		)
        );
        cv.getEducation().add(
        		new Education(
        				new SimpleDate(1998,8,1),
                		new SimpleDate(2000,9,1), 
                		new I18NText("Ausbildung IT Fachinformatiker","Dual Education IT Applied Computer Science "), 
                		new I18NText("Ausbildung als IT-Fachinformatiker bei Bechtle IT-Systemhaus and Werner of Siemens School","Work and study"),
                		"Bechtle IT-Systemhaus, Werner von Siemens Schule"
        		)
        );
        
        //Certification
        cv.getCertifications().add(
        		new Certification(new SimpleDate(2016,5,1),new I18NText("ITIL Foundation zertifiziert","ITIL Foundation certified"))
        );
        
        //Languages
        cv.getLanguageSkills().add(new LanguageSkill(Locale.GERMAN,LanguageSkillLevel.MOTHERTONGUE));
        cv.getLanguageSkills().add(new LanguageSkill(Locale.ENGLISH,LanguageSkillLevel.VERY_GOOD));
        
        //JOBS
        cv.getJobs()
        .add(new Job(
        		new SimpleDate(2016,4,18),
        		new SimpleDate(2016,10,30), 
        		new I18NText("IT Architekt","IT Architect"), 
        		new I18NText("Verantwortllich for Architektur","Responsible for architectur"),
        		"Sympany"
        		)
        );
        cv.getJobs()
        .add(new Job(new SimpleDate(2014,10,01),new SimpleDate(2016,3,31), 
        		new I18NText("Beisert-BTC als freier J2EE und SAP Netweaver Berater.","IT Freelancer for J2EE and SAP Netweaver"), 
        		new I18NText("(Siehe angefügte Projektliste)","See project list"),
        		"Beisert-BTC"
        		)
        );
        cv.getJobs()
        .add(new Job(new SimpleDate(2002,3,1),new SimpleDate(2004,9,31), 
        		new I18NText("Berater für SAP AG und Axentiv AG","Consultant for SAP AG and Axentiv AG"), 
        		new I18NText("Spezialist für J2EE und SAP Netweaver","Specializing in J2EE and SAP Netweaver"),
        		"Axentiv AG"
        		)
        );
        cv.getJobs()
        .add(new Job(new SimpleDate(2000,9,1),new SimpleDate(2001,12,31), 
        		new I18NText("Software Entwickler","Software Developer"), 
        		new I18NText("Spezialist für e-Commerce und IBM WebShere","Specializing in e-Commerce and IBM WebSphere"),
        		"Cenit AG"
        		)
        );
        cv.getJobs()
        .add(new Job(new SimpleDate(2000,7,1),new SimpleDate(2000,8,30), 
        		new I18NText("Software Entwickler","Software Developer"), 
        		new I18NText("Spezialist für Groupware und Web Development","Specializing in Groupware and Web Development"),
        		"Bechtle IT Systemhaus"
        		)
        );
        cv.getJobs()
        .add(new Job(new SimpleDate(1998,9,1),new SimpleDate(2000,7,31), 
        		new I18NText("Ausbildung zum IT-Fachinformatiker (.NET, Lotus Notes)",""), 
        		new I18NText("Spezialisierung auf Anwendungsentwicklung","Specializing in Application Development"),
        		"Bechtle IT Systemhaus"
        		)
        );
        cv.getJobs()
        .add(new Job(new SimpleDate(1997,9,1),new SimpleDate(1998,8,31), 
        		new I18NText("Zivildienst","Civil service (like military service)"), 
        		new I18NText("Altersheim und Behindertenheim","Seniors home and handicapped home"),
        		"DRK"
        		)
        );
        cv.getJobs()
        .add(new Job(new SimpleDate(1995,9,1),new SimpleDate(1997,9,1), 
        		new I18NText("Caritative Arbeit","Charity service"), 
        		new I18NText("Kapstadt, Südafrika","Capetown, South Africa"),
        		" "
        		)
        );
        
        //skills
        UserSkill java = new UserSkill(Category.PROGRAMMING,"Java", 18d, 2016, SkillLevel.EXPERT, true);
        cv.getUserSkills().add(java);
        UserSkill j2ee = new UserSkill(Category.PROGRAMMING,"J2EE", 18d, 2016,SkillLevel.EXPERT,true);
        cv.getUserSkills().add(j2ee);
        
        UserSkill hibernate = new UserSkill(Category.FRAMEWORKS,"Hibernate", 10d, 2016,SkillLevel.EXPERT,true);
        cv.getUserSkills().add(hibernate);
        UserSkill jpa = new UserSkill(Category.FRAMEWORKS,"JPA", 5d, 2016,SkillLevel.EXPERT,true);
        cv.getUserSkills().add(jpa);
        UserSkill spring = new UserSkill(Category.FRAMEWORKS,"Spring", 10d, 2016, SkillLevel.GOOD_EXPERIENCE,true);
        cv.getUserSkills().add(spring);
        UserSkill camel = new UserSkill(Category.FRAMEWORKS,"Camel", 1d, 2016, SkillLevel.GOOD_EXPERIENCE,true);
        cv.getUserSkills().add(camel);
        UserSkill junit = new UserSkill(Category.FRAMEWORKS,"JUnit", 10d, 2016, SkillLevel.EXPERT,true);
        cv.getUserSkills().add(junit);
        
        //SAP
        UserSkill sapBPM = new UserSkill(Category.SAP,"SAP BPM", 6d, 2016,SkillLevel.EXPERT,true);
        cv.getUserSkills().add(sapBPM);
        UserSkill sapWD = new UserSkill(Category.SAP,"SAP Web Dynpro Java", 10d, 2016,SkillLevel.EXPERT,true);
        cv.getUserSkills().add(sapWD);
        
        //Tools
        UserSkill git = new UserSkill(Category.TOOLS,"Git", 1d, 2016,SkillLevel.GOOD_EXPERIENCE,true);
        cv.getUserSkills().add(git);
        UserSkill maven = new UserSkill(Category.TOOLS,"Maven", 1d, 2016,SkillLevel.GOOD_EXPERIENCE,true);
        cv.getUserSkills().add(maven);

        Project soang =  new Project(
	        				new I18NText("SOA Infrastruktur Aufbau", "SOA Infrastructure"), 
	        				new I18NText("Aufbau eine SOA Infrastruktur mit Microservices und Camel", "Setup of SOA Infrastruktur mit Microservices und Camel"), 
	        				"Sympany AG",
	                        new SimpleDate(2016, 1, 1), 
	                        new SimpleDate(2016, 8, 1), 
	                         java, j2ee,jpa,camel,maven
	    );
        soang.getAdditionalInfos().add(new GenericContainer(new I18NText("Rolle", "Role"), new I18NText("Architekt", "Architect")));
        cv.getProjects().add(soang);
        
        Project scrapping =  new Project(
				new I18NText("Erstellung eines Workflows zur Vernichtung von Lagerbeständen", "Scrapping Workflow"), 
				new I18NText("Budgetplanung, Resourcenplanung, Schätzungen,Technisches Design. Anforderungsmanagement. Entwickler Coaching. BPM Process Design", "-"), 
				"Bayer AG",
                new SimpleDate(2015, 8, 1), 
                new SimpleDate(2016, 4, 1), 
                 java, j2ee,jpa,hibernate,junit,sapBPM,sapWD
        		);
        scrapping.getAdditionalInfos().add(new GenericContainer(new I18NText("Rolle", "Role"), new I18NText("Architekt", "Architect")));
        cv.getProjects().add(scrapping);
        
        Project additional =  new Project(
				new I18NText("etc.", "etc."), 
				new I18NText("", "-"), 
				"-",
                new SimpleDate(2000, 1, 1), 
                new SimpleDate(2015, 3, 1), 
                 java, j2ee,jpa,hibernate,junit,sapBPM,sapWD
        		);
        additional.getAdditionalInfos().add(new GenericContainer(new I18NText("Rolle", "Role"), new I18NText("Architekt", "Architect")));
        cv.getProjects().add(additional);
        
		return cv;
	}


}
