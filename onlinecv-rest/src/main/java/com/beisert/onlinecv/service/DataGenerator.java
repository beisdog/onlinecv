package com.beisert.onlinecv.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
public class DataGenerator {
	
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
        pd.setWorkPermit(new I18NText("B-Bewilligung für die Schweiz", "B work permit for switzerland"));
        
        
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
                		new I18NText("Ausbildung als IT-Fachinformatiker","Bsc. IT Applied Computer Science (Work and study)"),
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
        		new I18NText("System Architekt im Bereich Online Services, Mobile und SOA","System architect for Online Services, Mobile and SOA"),
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
        		new I18NText("Karitative Arbeit","Charity service"), 
        		new I18NText("Kapstadt, Südafrika","Capetown, South Africa"),
        		"LDS"
        		)
        );
        
        //skills
        UserSkill java = new UserSkill(Category.PROGRAMMING,"Java", 18d, 2016, SkillLevel.EXPERT, true);
        cv.getUserSkills().add(java);
        UserSkill j2ee = new UserSkill(Category.PROGRAMMING,"J2EE (EJB,JMS,Servlet)", 18d, 2016,SkillLevel.EXPERT,true);
        cv.getUserSkills().add(j2ee);
        
        UserSkill hibernate = new UserSkill(Category.PROGRAMMING,"Hibernate", 10d, 2016,SkillLevel.EXPERT,true);
        cv.getUserSkills().add(hibernate);
        UserSkill jpa = new UserSkill(Category.PROGRAMMING,"JPA", 5d, 2016,SkillLevel.EXPERT,true);
        cv.getUserSkills().add(jpa);
        UserSkill spring = new UserSkill(Category.PROGRAMMING,"Spring", 10d, 2016, SkillLevel.GOOD_EXPERIENCE,true);
        cv.getUserSkills().add(spring);
        UserSkill camel = new UserSkill(Category.PROGRAMMING,"Camel", 1d, 2016, SkillLevel.GOOD_EXPERIENCE,true);
        cv.getUserSkills().add(camel);
        UserSkill junit = new UserSkill(Category.PROGRAMMING,"JUnit", 10d, 2016, SkillLevel.EXPERT,true);
        cv.getUserSkills().add(junit);
        //XSLT
        UserSkill fop = new UserSkill(Category.PROGRAMMING,"XSLT/FOP", 2d, 2016, SkillLevel.GOOD_EXPERIENCE,false);
        cv.getUserSkills().add(fop);
        UserSkill jquery = new UserSkill(Category.PROGRAMMING,"JQuery", 2d, 2016, SkillLevel.GOOD_EXPERIENCE,false);
        cv.getUserSkills().add(jquery);
        UserSkill angular = new UserSkill(Category.PROGRAMMING,"AngularJS", 0.5d, 2016, SkillLevel.BEGINNER,false);
        cv.getUserSkills().add(angular);
        UserSkill html = new UserSkill(Category.PROGRAMMING,"HTML/CSS", 0.5d, 2016, SkillLevel.GOOD_EXPERIENCE,false);
        cv.getUserSkills().add(html);
        UserSkill net = new UserSkill(Category.PROGRAMMING,"C#, ASP .NET", 2d, 2008, SkillLevel.GOOD_EXPERIENCE,false);
        cv.getUserSkills().add(net);
        UserSkill rails = new UserSkill(Category.PROGRAMMING,"Ruby on Rails", 2d, 2008, SkillLevel.GOOD_EXPERIENCE,false);
        cv.getUserSkills().add(rails);
        UserSkill php = new UserSkill(Category.PROGRAMMING,"PHP", 5d, 2014, SkillLevel.BEGINNER,false);
        cv.getUserSkills().add(php);
        UserSkill grails = new UserSkill(Category.PROGRAMMING,"Grails", 2d, 2016, SkillLevel.GOOD_EXPERIENCE,false);
        cv.getUserSkills().add(grails);
        UserSkill jsf = new UserSkill(Category.PROGRAMMING,"JSF (Richfaces,Primefaces)", 3d, 2013, SkillLevel.GOOD_EXPERIENCE,false);
        cv.getUserSkills().add(jsf);
        UserSkill vaadin = new UserSkill(Category.PROGRAMMING,"Vaadin", 2d, 2016, SkillLevel.GOOD_EXPERIENCE,false);
        cv.getUserSkills().add(vaadin);
        UserSkill gwt = new UserSkill(Category.PROGRAMMING,"GWT", 1d, 2007, SkillLevel.GOOD_EXPERIENCE,false);
        cv.getUserSkills().add(gwt);
        UserSkill ws = new UserSkill(Category.PROGRAMMING,"Web Services", 10d, 2016, SkillLevel.EXPERT,false);
        cv.getUserSkills().add(ws);
        UserSkill selenium = new UserSkill(Category.PROGRAMMING,"Selenium", 0.5d, 2016, SkillLevel.GOOD_EXPERIENCE,false);
        cv.getUserSkills().add(selenium);
        
        //Middleware
        UserSkill tomcat = new UserSkill(Category.SERVER,"Tomcat", 11d, 2016, SkillLevel.GOOD_EXPERIENCE,false);
        cv.getUserSkills().add(tomcat);
        UserSkill jboss = new UserSkill(Category.SERVER,"JBoss/Wildfly", 2d, 2016, SkillLevel.GOOD_EXPERIENCE,false);
        cv.getUserSkills().add(jboss);
        UserSkill wls = new UserSkill(Category.SERVER,"Weblogic", 0.5d, 2016, SkillLevel.GOOD_EXPERIENCE,false);
        cv.getUserSkills().add(wls);       
        
        //SAP
        UserSkill sapBPM = new UserSkill(Category.SAP,"SAP BPM", 6d, 2016,SkillLevel.EXPERT,true);
        cv.getUserSkills().add(sapBPM);
        UserSkill sapWD = new UserSkill(Category.SAP,"SAP Web Dynpro Java", 10d, 2016,SkillLevel.EXPERT,true);
        cv.getUserSkills().add(sapWD);
        UserSkill portaladmin = new UserSkill(Category.SAP,"SAP Portals Administration", 10d, 2016,SkillLevel.GOOD_EXPERIENCE,true);
        cv.getUserSkills().add(portaladmin);
        UserSkill iview = new UserSkill(Category.SAP,"Portal iView Development", 6d, 2014,SkillLevel.EXPERT,true);
        cv.getUserSkills().add(iview);
        UserSkill nwdi = new UserSkill(Category.SAP,"Netweaver Development Infrastructure Administration", 8d, 2014,SkillLevel.EXPERT,true);
        cv.getUserSkills().add(nwdi);
        
        
        //Tools
        UserSkill git = new UserSkill(Category.TOOLS,"Git", 1d, 2016,SkillLevel.GOOD_EXPERIENCE,true);
        cv.getUserSkills().add(git);
        UserSkill maven = new UserSkill(Category.TOOLS,"Maven", 1d, 2016,SkillLevel.GOOD_EXPERIENCE,true);
        cv.getUserSkills().add(maven);
        UserSkill wily = new UserSkill(Category.TOOLS,"WILY", 3d, 2015,SkillLevel.GOOD_EXPERIENCE,true);
        cv.getUserSkills().add(wily);
        UserSkill profiler = new UserSkill(Category.TOOLS,"Java Profiler", 1d, 2015,SkillLevel.GOOD_EXPERIENCE,true);
        cv.getUserSkills().add(profiler);
        
        //METHODS
        UserSkill scrum = new UserSkill(Category.METHODS,"Scrum", 7d, 2016,SkillLevel.EXPERT,true);
        cv.getUserSkills().add(scrum);
        UserSkill project = new UserSkill(Category.METHODS,"Projectmanagement", 4d, 2016,SkillLevel.GOOD_EXPERIENCE,true);
        cv.getUserSkills().add(project);
        //OS
        UserSkill windows = new UserSkill(Category.OS,"WINDOWS", 16d, 2016,SkillLevel.GOOD_EXPERIENCE,true);
        cv.getUserSkills().add(windows);
        UserSkill linux = new UserSkill(Category.OS,"LINUX", 6d, 2016,SkillLevel.GOOD_EXPERIENCE,true);
        cv.getUserSkills().add(linux);
        UserSkill mac = new UserSkill(Category.OS,"Mac OS", 6d, 2016,SkillLevel.GOOD_EXPERIENCE,true);
        cv.getUserSkills().add(mac);
        UserSkill unix = new UserSkill(Category.OS,"Unix (HP,Solaris)", 4d, 2006,SkillLevel.GOOD_EXPERIENCE,true);
        cv.getUserSkills().add(unix);
        
        //Database
        UserSkill oracle = new UserSkill(Category.DATABASE,"ORACLE", 16d, 2016,SkillLevel.GOOD_EXPERIENCE,true);
        cv.getUserSkills().add(oracle);
        UserSkill mysql = new UserSkill(Category.DATABASE,"MySQL", 3d, 2016,SkillLevel.GOOD_EXPERIENCE,true);
        cv.getUserSkills().add(mysql);
        UserSkill sql = new UserSkill(Category.DATABASE,"SQL Server", 5d, 2010,SkillLevel.GOOD_EXPERIENCE,true);
        cv.getUserSkills().add(sql);
        
        
        
        //Projects

        Project p =  new Project("symparch",new I18NText("Architektur Online Services und SOA", "SOA Infrastructure")); 
        p.setDescription(new I18NText(
        		"Verantwortung der SOA Strategie und der Gesamtarchitektur der Online Angebotes einer Krankenversicherung sowie Aufbau eines neuen SOA Frameworks", 
        		"Setup of SOA Infrastruktur mit Microservices und Camel"));
        p.setCustomer("Sympany AG");
        p.setFrom(new SimpleDate(2016, 4, 1)); 
        p.setTo( new SimpleDate(2016, 10, 1));
        p.skills( java, j2ee,jpa,camel,maven, jboss, wls, vaadin);
        p.setProjectSize(new I18NText("6 Entwickler", "6 Developers"));
        p.setRole(new I18NText("Architekt","Architekt"));
        p.setResponsibility(new I18NText(
        		"Systemaufbau, Architektur, Refactoring, Ausfallsicherheit, Fehlerbehebung, Technologie Evaluation, Dienstleister Überprüfung, Codereviews, Coaching, System Dokumentation",
        		"System Design, Architecture, Refactoring, High Availability, Troubleshooting, Technology Evaluation, Management of Externals, Codereviews, Coaching, System Documentation"));
        p.setProjectLocation(new I18NText("Schweiz", "Switzerland"));
        p.setIndustry(new I18NText("Versicherung", "Insurance"));
        cv.getProjects().add(p);
        //Scrapping
        p =  new Project("bayscrap",new I18NText("Freigabe Prozesse zur Vernichtung von Beständen", "-")); 
        p.setDescription(new I18NText(
        		"Erstellung eines Workflows zur Vernichtung von Lagerbeständen", 
        		"-"));
        p.setCustomer("Bayer AG");
        p.setFrom(new SimpleDate(2015, 8, 1)); 
        p.setTo( new SimpleDate(2016, 4, 1));
        p.skills( java, j2ee,jpa,camel,maven);
        p.setProjectSize(new I18NText("3 Entwickler", "3 Developers"));
        p.setRole(new I18NText("Projektleitung, Entwicklung","Projectmanager, Developer"));
        p.setResponsibility(new I18NText(
        		"Budgetplanung, Resourcenplanung, Schätzungen, Technisches Design. Anforderungsmanagement. Entwickler Coaching. BPM Process Design",
        		"-"));
        p.setProjectLocation(new I18NText("Deutschland", "Germany"));
        p.setIndustry(new I18NText("Pharma", "Pharma"));
        cv.getProjects().add(p);
        
        //SAP WILY
        p =  new Project("sapwily",new I18NText("Performance Analyse und Optimierung", "-")); 
        p.setDescription(new I18NText(
        		"Eine Anwendung zum Antragsmanagement im Öffentlichen Dienst hatte grosse Performance Probleme. Ziel war das Ermitteln der imperformanten Codeteile und Neuimplementierung und Optimierung der kritischen Pfade und der Datenbank Abfragen und Strukturen", 
        		"-"));
        p.setCustomer("SAP Custom Development");
        p.setFrom(new SimpleDate(2015, 1, 1)); 
        p.setTo( new SimpleDate(2015, 8, 1));
        p.skills( java, j2ee,jpa,wily,sapWD, profiler);
        p.setProjectSize(new I18NText("4 Entwickler, 1 Architekt, 1 Projektleiter", "4 Entwickler, 1 Architekt, 1 Projektleiter"));
        p.setRole(new I18NText("Entwickler","Developer"));
        p.setResponsibility(new I18NText(
        		"Performance Analyse, Entwickeln von optimiertem Code, Testing",
        		"-"));
        p.setProjectLocation(new I18NText("Deutschland", "Germany"));
        p.setIndustry(new I18NText("ISV", "ISV"));
        cv.getProjects().add(p);
        
        //JSF
        p =  new Project("szjsf",new I18NText("Neuimplementierung einer JSF Applikation in eine mobilfähige Version", "-")); 
        p.setDescription(new I18NText(
        		"Ein existierendes Expertensystem soll mobilfähig gemacht werden. ", 
        		"-"));
        p.setCustomer("Südzucker AG");
        p.setFrom(new SimpleDate(2015, 1, 1)); 
        p.setTo( new SimpleDate(2015, 3, 1));
        p.skills( java, j2ee,jpa,jsf,scrum, tomcat);
        p.setProjectSize(new I18NText("1 Entwickler, 1 Projektleiter", "1 Developer, 1 Projectlead"));
        p.setRole(new I18NText("Projektleiter","Projectlead"));
        p.setResponsibility(new I18NText(
        		"Evaluierung von verschiedenen JSF Frameworks auf ihre Mobilfähigkeiten. Neuimplementierung mit Primefaces sowie verschiedene UI Design Studien.",
        		"-"));
        p.setProjectLocation(new I18NText("Deutschland", "Germany"));
        p.setIndustry(new I18NText("Lebensmittel", "?"));
        cv.getProjects().add(p);
        
        //BTM
        p =  new Project("baybtm",new I18NText("Weiterentwicklung einer Software zur Verwaltung von Marken und Schutzrechten", "-")); 
        p.setDescription(new I18NText(
        		"Verwaltung der Schutzrechte von Marken. Das Ziel war es durch eine Anwendung keine Termine mehr beim Abmelden oder Verlängern der Marken (Trademarks) zu verpassen, sowie die weltweiten Markennamen zu konsolidieren (Doppelt Anmeldungen) und somit Geld einzusparen. ", 
        		"-"));
        p.setCustomer("Bayer AG");
        p.setFrom(new SimpleDate(2014, 1, 1)); 
        p.setTo( new SimpleDate(2014, 12, 1));
        p.skills( java, j2ee,jpa,sapWD,sapBPM,scrum);
        p.setProjectSize(new I18NText("1 Entwickler, 1 Projektleiter", "1 Developer, 1 Projectlead"));
        p.setRole(new I18NText("Entwickler","Developer"));
        p.setResponsibility(new I18NText(
        		"Entwicklung, Anforderungsmanagement, Architektur",
        		"-"));
        p.setProjectLocation(new I18NText("Deutschland", "Germany"));
        p.setIndustry(new I18NText("Lebensmittel", "?"));
        cv.getProjects().add(p);
        //Bayer
        p =  new Project("bayholger",new I18NText("Erweiterung mehrere Prozesse im Bereich chemische Formulierungen", "-")); 
        p.setDescription(new I18NText(
        		"Integrieren und Erweitern bestehender SAP BPM Prozesse, die den kompletten Lebenszyklus von der Forschung bis zur Registrierung neuer Formulierungen begleitet", 
        		"-"));
        p.setCustomer("Bayer AG");
        p.setFrom(new SimpleDate(2013, 1, 1)); 
        p.setTo( new SimpleDate(2013, 12, 1));
        p.skills( java, j2ee,jpa,sapWD,sapBPM,scrum);
        p.setProjectSize(new I18NText("10 Entwickler, 1 Projektleiter", "10 Developer, 1 Projectlead"));
        p.setRole(new I18NText("Entwickler","Developer"));
        p.setResponsibility(new I18NText(
        		"Entwicklung, Coaching anderer Junior Entwickler",
        		"-"));
        p.setProjectLocation(new I18NText("Deutschland", "Germany"));
        p.setIndustry(new I18NText("Chemie", "?"));
        cv.getProjects().add(p);
        //Produkthierarchien
        p =  new Project("bayph",new I18NText("Konzernweiter Prozess zur Verwaltung von Produkthierarchien", "-")); 
        p.setDescription(new I18NText(
        		"Entwicklung eines Workflows zur Verteilung von Produkthierarchien und Übermittlung dieser an die Stammdatensysteme.", 
        		"-"));
        p.setCustomer("Bayer AG");
        p.setFrom(new SimpleDate(2012, 10, 1)); 
        p.setTo( new SimpleDate(2012, 12, 1));
        p.skills( java, j2ee,jpa,sapWD,sapBPM,scrum);
        p.setProjectSize(new I18NText("2 Entwickler, 1 Projektleiter", "2 Developer, 1 Projectlead"));
        p.setRole(new I18NText("Senior Entwickler, Architekt","Developer,Architelt"));
        p.setResponsibility(new I18NText(
        		"Entwicklung",
        		"-"));
        p.setProjectLocation(new I18NText("Deutschland", "Germany"));
        p.setIndustry(new I18NText("Chemie", "?"));
        cv.getProjects().add(p);
        //elabel
        p =  new Project("bayelbl",new I18NText("Entwicklung von Prozessen für die Verpackungsentwicklung", "-")); 
        p.setDescription(new I18NText(
        		"Ablösung einer Lotus Notes Anwendung zur Verwaltung von Etiketten „Artworks“ und deren Bestellprozessen und Workflows in SAP BPM", 
        		"-"));
        p.setCustomer("Bayer AG");
        p.setFrom(new SimpleDate(2011, 4, 1)); 
        p.setTo( new SimpleDate(2012, 10, 1));
        p.skills( java, j2ee,jpa,sapWD,sapBPM,scrum);
        p.setProjectSize(new I18NText("2 Entwickler, 1 Projektleiter", "2 Developer, 1 Projectlead"));
        p.setRole(new I18NText("Senior Entwickler, Architekt","Senior Developer, Architect"));
        p.setResponsibility(new I18NText(
        		"Entwicklung, Coaching von Entwicklern",
        		"-"));
        p.setProjectLocation(new I18NText("Deutschland", "Germany"));
        p.setIndustry(new I18NText("Chemie", "?"));
        cv.getProjects().add(p);
        //SABIC
        p =  new Project("sabic",new I18NText("Online Bestell Process und Beschwerdemanagement", "-")); 
        p.setDescription(new I18NText(
        		"Entwicklung einer B2B Order Online Applikation für Metalle und Chemikalien sowie von Beschwerdemanagement und Lieferverfolgung", 
        		"-"));
        p.setCustomer("SABIC");
        p.setFrom(new SimpleDate(2010, 12, 1)); 
        p.setTo( new SimpleDate(2011, 3, 1));
        p.skills( java, j2ee,jpa,sapWD,sapBPM,scrum);
        p.setProjectSize(new I18NText("3 Entwickler, 1 Projektleiter", "3 Developer, 1 Projectlead"));
        p.setRole(new I18NText("Senior Entwickler","Senior Developer"));
        p.setResponsibility(new I18NText(
        		"Entwicklung, Coaching von Entwicklern",
        		"-"));
        p.setProjectLocation(new I18NText("Saudi Arabien", "Saudi Arabia"));
        p.setIndustry(new I18NText("Stahl", "Steel"));
        cv.getProjects().add(p);
        
        
		return cv;
	}

	public static void ensureProjectKeysAreUnique(OnlineCV cv) {
		Map<String,Project> uniqueKeys = new HashMap<String,Project>();
	    //make sure each project key is filled and is unique because this is needed for the reporting.
	    //BIRT requires a key for joining a dataset and the key is used to join the skills.
	    if(cv.getProjects()!=null){
	    	cv.getProjects().stream().forEach(p -> {
	    		if( p.getKey()==null ){
	    			p.setKey(UUID.randomUUID().toString());
	    			uniqueKeys.put(p.getKey(), p);
	    		} else {
	    			String key = p.getKey();
	    			//Override and make unique
	    			if(uniqueKeys.containsKey(key)){
	    				p.setKey(UUID.randomUUID().toString());
	        			uniqueKeys.put(p.getKey(), p);
	    			}
	    		}
	    	});
	    }
	}


}
