package model;

public class EDI214B10 extends EDI214RecordType{

	private String ReferenceIdentification;
	private String ShipmentIdentificationNumber;
	private String StandardCarrierAlphaCode;
	
	public String getReferenceIdentification() {
		return ReferenceIdentification;
	}
	public void setReferenceIdentification(String referenceIdentification) {
		ReferenceIdentification = referenceIdentification;
	}
	public String getShipmentIdentificationNumber() {
		return ShipmentIdentificationNumber;
	}
	public void setShipmentIdentificationNumber(String shipmentIdentificationNumber) {
		ShipmentIdentificationNumber = shipmentIdentificationNumber;
	}
	public String getStandardCarrierAlphaCode() {
		return StandardCarrierAlphaCode;
	}
	public void setStandardCarrierAlphaCode(String standardCarrierAlphaCode) {
		StandardCarrierAlphaCode = standardCarrierAlphaCode;
	}
	
	@Override
	public String toString() {
		return "EDII214B10 [recordType=" + getRecordType() + ", ReferenceIdentification=" + ReferenceIdentification
				+ ", ShipmentIdentificationNumber=" + ShipmentIdentificationNumber + ", StandardCarrierAlphaCode="
				+ StandardCarrierAlphaCode + "]";
	}
	
	
}
