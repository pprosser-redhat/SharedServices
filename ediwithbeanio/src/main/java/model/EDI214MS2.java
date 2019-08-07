package model;

public class EDI214MS2 extends EDI214RecordType {
	
	
	private String StandardCarrierAlphaCode;
	private String EquipmentNumber;
	public String getStandardCarrierAlphaCode() {
		return StandardCarrierAlphaCode;
	}
	public void setStandardCarrierAlphaCode(String standardCarrierAlphaCode) {
		StandardCarrierAlphaCode = standardCarrierAlphaCode;
	}
	public String getEquipmentNumber() {
		return EquipmentNumber;
	}
	public void setEquipmentNumber(String equipmentNumber) {
		EquipmentNumber = equipmentNumber;
	}
	@Override
	public String toString() {
		return "EDI214MS2 [RecordType=" + getRecordType() + " StandardCarrierAlphaCode=" + StandardCarrierAlphaCode + ", EquipmentNumber="
				+ EquipmentNumber + "]";
	}

	
	
	
}
