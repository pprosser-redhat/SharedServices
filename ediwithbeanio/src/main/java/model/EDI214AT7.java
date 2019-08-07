package model;

public class EDI214AT7 extends EDI214RecordType{
	
	private String ShipmentStatusCode;
	private String ShipmentStatusorAppointmentReasonCode;
	private String ShipmentAppointmentStatusCode;
	private String ShipmentStatusorAppointmentReasonCode2;
	private String Date;
	private String Time;
	private String TimeCode;
	
	public String getShipmentStatusCode() {
		return ShipmentStatusCode;
	}
	public void setShipmentStatusCode(String shipmentStatusCode) {
		ShipmentStatusCode = shipmentStatusCode;
	}
	public String getShipmentStatusorAppointmentReasonCode() {
		return ShipmentStatusorAppointmentReasonCode;
	}
	public void setShipmentStatusorAppointmentReasonCode(String shipmentStatusorAppointmentReasonCode) {
		ShipmentStatusorAppointmentReasonCode = shipmentStatusorAppointmentReasonCode;
	}
	public String getShipmentAppointmentStatusCode() {
		return ShipmentAppointmentStatusCode;
	}
	public void setShipmentAppointmentStatusCode(String shipmentAppointmentStatusCode) {
		ShipmentAppointmentStatusCode = shipmentAppointmentStatusCode;
	}
	public String getShipmentStatusorAppointmentReasonCode2() {
		return ShipmentStatusorAppointmentReasonCode2;
	}
	public void setShipmentStatusorAppointmentReasonCode2(String shipmentStatusorAppointmentReasonCode2) {
		ShipmentStatusorAppointmentReasonCode2 = shipmentStatusorAppointmentReasonCode2;
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
	public String getTimeCode() {
		return TimeCode;
	}
	public void setTimeCode(String timeCode) {
		TimeCode = timeCode;
	}
	
	@Override
	public String toString() {
		return "EDI214AT7 [recordtype=" + getRecordType() + ", ShipmentStatusCode=" + ShipmentStatusCode
				+ ", ShipmentStatusorAppointmentReasonCode=" + ShipmentStatusorAppointmentReasonCode
				+ ", ShipmentAppointmentStatusCode=" + ShipmentAppointmentStatusCode
				+ ", ShipmentStatusorAppointmentReasonCode2=" + ShipmentStatusorAppointmentReasonCode2 + ", Date="
				+ Date + ", Time=" + Time + ", TimeCode=" + TimeCode + "]";
	}
	
	

}
