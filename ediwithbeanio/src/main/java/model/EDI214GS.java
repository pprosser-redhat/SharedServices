package model;

public class EDI214GS extends EDI214RecordType {
	
	private String FunctionalIdentifierCode;
	private String ApplicationSendersCode;
	private String ApplicationReceiversCode;
	private String Date;
	private String Time;
	private String GroupControlNumber;
	private String ResponsibleAgencyCode;
	private String VersionReleaseIndustryIdentifierCode;
	
	public String getFunctionalIdentifierCode() {
		return FunctionalIdentifierCode;
	}
	public void setFunctionalIdentifierCode(String functionalIdentifierCode) {
		FunctionalIdentifierCode = functionalIdentifierCode;
	}
	public String getApplicationSendersCode() {
		return ApplicationSendersCode;
	}
	public void setApplicationSendersCode(String applicationSendersCode) {
		ApplicationSendersCode = applicationSendersCode;
	}
	public String getApplicationReceiversCode() {
		return ApplicationReceiversCode;
	}
	public void setApplicationReceiversCode(String applicationReceiversCode) {
		ApplicationReceiversCode = applicationReceiversCode;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getGroupControlNumber() {
		return GroupControlNumber;
	}
	public void setGroupControlNumber(String groupControlNumber) {
		GroupControlNumber = groupControlNumber;
	}
	public String getResponsibleAgencyCode() {
		return ResponsibleAgencyCode;
	}
	public void setResponsibleAgencyCode(String responsibleAgencyCode) {
		ResponsibleAgencyCode = responsibleAgencyCode;
	}
	public String getVersionReleaseIndustryIdentifierCode() {
		return VersionReleaseIndustryIdentifierCode;
	}
	public void setVersionReleaseIndustryIdentifierCode(String versionReleaseIndustryIdentifierCode) {
		VersionReleaseIndustryIdentifierCode = versionReleaseIndustryIdentifierCode;
	}
	
	@Override
	public String toString() {
		return "EDI214GS [recordType=" + getRecordType() + ", FunctionalIdentifierCode=" + FunctionalIdentifierCode
				+ ", ApplicationSendersCode=" + ApplicationSendersCode + ", ApplicationReceiversCode="
				+ ApplicationReceiversCode + ", Date=" + Date + ", Time=" + Time + ", GroupControlNumber="
				+ GroupControlNumber + ", ResponsibleAgencyCode=" + ResponsibleAgencyCode
				+ ", VersionReleaseIndustryIdentifierCode=" + VersionReleaseIndustryIdentifierCode + "]";
	}
	
	
	
}
