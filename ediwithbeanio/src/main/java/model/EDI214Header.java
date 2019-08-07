package model;

public class EDI214Header extends EDI214RecordType {
	
	private String AuthorizationInformationQualifier;
	private String AuthorizationInformation;
	private String SecurityInformationQualifier;
	private String SecurityInformation;
	private String InterchangeIDQualifier;
	private String InterchangeSenderID;
	private String InterchangeIDQualifier2;
	private String InterchangeReceiverID;
	private String InterchangeDate;
	private String InterchangeTime;
	private String InterchangeControlStandardsIdentifier;
	private String InterchangeControlVersionNumber;
	private String InterchangeControlNumber;
	private String AcknowledgmentRequested;
	private String UsageIndicator;		
	private String ComponentElementSeparator;
	
	public String getAuthorizationInformationQualifier() {
		return AuthorizationInformationQualifier;
	}
	public void setAuthorizationInformationQualifier(String authorizationInformationQualifier) {
		AuthorizationInformationQualifier = authorizationInformationQualifier;
	}
	public String getAuthorizationInformation() {
		return AuthorizationInformation;
	}
	public void setAuthorizationInformation(String authorizationInformation) {
		AuthorizationInformation = authorizationInformation;
	}
	public String getSecurityInformationQualifier() {
		return SecurityInformationQualifier;
	}
	public void setSecurityInformationQualifier(String securityInformationQualifier) {
		SecurityInformationQualifier = securityInformationQualifier;
	}
	public String getSecurityInformation() {
		return SecurityInformation;
	}
	public void setSecurityInformation(String securityInformation) {
		SecurityInformation = securityInformation;
	}
	public String getInterchangeIDQualifier() {
		return InterchangeIDQualifier;
	}
	public void setInterchangeIDQualifier(String interchangeIDQualifier) {
		InterchangeIDQualifier = interchangeIDQualifier;
	}
	public String getInterchangeSenderID() {
		return InterchangeSenderID;
	}
	public void setInterchangeSenderID(String interchangeSenderID) {
		InterchangeSenderID = interchangeSenderID;
	}
	public String getInterchangeIDQualifier2() {
		return InterchangeIDQualifier2;
	}
	public void setInterchangeIDQualifier2(String interchangeIDQualifier2) {
		InterchangeIDQualifier2 = interchangeIDQualifier2;
	}
	public String getInterchangeReceiverID() {
		return InterchangeReceiverID;
	}
	public void setInterchangeReceiverID(String interchangeReceiverID) {
		InterchangeReceiverID = interchangeReceiverID;
	}
	public String getInterchangeDate() {
		return InterchangeDate;
	}
	public void setInterchangeDate(String interchangeDate) {
		InterchangeDate = interchangeDate;
	}
	public String getInterchangeTime() {
		return InterchangeTime;
	}
	public void setInterchangeTime(String interchangeTime) {
		InterchangeTime = interchangeTime;
	}
	public String getInterchangeControlStandardsIdentifier() {
		return InterchangeControlStandardsIdentifier;
	}
	public void setInterchangeControlStandardsIdentifier(String interchangeControlStandardsIdentifier) {
		InterchangeControlStandardsIdentifier = interchangeControlStandardsIdentifier;
	}
	public String getInterchangeControlVersionNumber() {
		return InterchangeControlVersionNumber;
	}
	public void setInterchangeControlVersionNumber(String interchangeControlVersionNumber) {
		InterchangeControlVersionNumber = interchangeControlVersionNumber;
	}
	public String getInterchangeControlNumber() {
		return InterchangeControlNumber;
	}
	public void setInterchangeControlNumber(String interchangeControlNumber) {
		InterchangeControlNumber = interchangeControlNumber;
	}
	public String getAcknowledgmentRequested() {
		return AcknowledgmentRequested;
	}
	public void setAcknowledgmentRequested(String acknowledgmentRequested) {
		AcknowledgmentRequested = acknowledgmentRequested;
	}
	public String getUsageIndicator() {
		return UsageIndicator;
	}
	public void setUsageIndicator(String usageIndicator) {
		UsageIndicator = usageIndicator;
	}
	public String getComponentElementSeparator() {
		return ComponentElementSeparator;
	}
	public void setComponentElementSeparator(String componentElementSeparator) {
		ComponentElementSeparator = componentElementSeparator;
	}
	@Override
	public String toString() {
		return "EDI214Header [AuthorizationInformationQualifier=" + AuthorizationInformationQualifier
				+ ", RecordType=" + this.getRecordType()
				+ ", AuthorizationInformation=" + AuthorizationInformation + ", SecurityInformationQualifier="
				+ SecurityInformationQualifier + ", SecurityInformation=" + SecurityInformation
				+ ", InterchangeIDQualifier=" + InterchangeIDQualifier + ", InterchangeSenderID=" + InterchangeSenderID
				+ ", InterchangeIDQualifier2=" + InterchangeIDQualifier2 + ", InterchangeReceiverID="
				+ InterchangeReceiverID + ", InterchangeDate=" + InterchangeDate + ", InterchangeTime="
				+ InterchangeTime + ", InterchangeControlStandardsIdentifier=" + InterchangeControlStandardsIdentifier
				+ ", InterchangeControlVersionNumber=" + InterchangeControlVersionNumber + ", InterchangeControlNumber="
				+ InterchangeControlNumber + ", AcknowledgmentRequested=" + AcknowledgmentRequested
				+ ", UsageIndicator=" + UsageIndicator + ", ComponentElementSeparator=" + ComponentElementSeparator
				+ "]";
	}
	
	
	
	

}
