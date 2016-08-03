<<<<<<< HEAD
package com.beisert.onlinecv.gwt.shared;

public class CommunicationData {
  
   /**
    * email, fax, tel
    */
  	String type;
   String data;
   String additionalInfo;
=======
package com.beisert.onlinecv.gwt.shared.domain;

public class CommunicationData {

	/**
	 * email, fax, tel
	 */
	public static enum CommunicationType{
		EMAIL,PHONE,SKYPE,MOBILE;
	}
	CommunicationType type = CommunicationType.EMAIL;
	String data;
	String additionalInfo;
	
	public CommunicationData(){}

	public CommunicationData(CommunicationType type, String data, String additionalInfo) {
		super();
		this.type = type;
		this.data = data;
		this.additionalInfo = additionalInfo;
	}

	public CommunicationType getType() {
		return type;
	}

	public void setType(CommunicationType type) {
		this.type = type;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

>>>>>>> 5b7e992de2754950669724678236ad1a13c68da2
}
