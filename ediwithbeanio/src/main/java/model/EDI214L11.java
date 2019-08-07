package model;

public class EDI214L11 extends EDI214RecordType {

	private String ReferenceIdentification;
	private String ReferenceIdentificationQualifier;
	
	public String getReferenceIdentification() {
		return ReferenceIdentification;
	}
	public void setReferenceIdentification(String referenceIdentification) {
		ReferenceIdentification = referenceIdentification;
	}
	public String getReferenceIdentificationQualifier() {
		return ReferenceIdentificationQualifier;
	}
	public void setReferenceIdentificationQualifier(String referenceIdentificationQualifier) {
		ReferenceIdentificationQualifier = referenceIdentificationQualifier;
	}
	@Override
	public String toString() {
		return "EDI214L11 [RecordType=" + getRecordType() + " ReferenceIdentification=" + ReferenceIdentification + ", ReferenceIdentificationQualifier="
				+ ReferenceIdentificationQualifier + "]";
	}
	
	
	
	
}
