package sharedservices.travel;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import java.math.BigDecimal;

@CsvRecord(separator = ",", crlf = ",\n")
public class Flight {
	
	@DataField(pos = 1)
	private String departure_2011;
	
	@DataField(pos = 2)
	private String ticketClassDescription;
	
	@DataField(pos = 3)
	private String departure;
	
	@DataField(pos = 4)
	private String destination;
	
	@DataField(pos = 5, precision = 2)
	private BigDecimal paidFare;
	
	@DataField(pos = 6)
	private String supplierNqme;
	
	@DataField(pos = 7)
	private String directorate;
	
	@DataField(pos = 8)
	private String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDeparture_2011() {
		return departure_2011;
	}
	public void setDeparture_2011(String departure_2011) {
		this.departure_2011 = departure_2011;
	}
	public String getTicketClassDescription() {
		return ticketClassDescription;
	}
	public void setTicketClassDescription(String ticketClassDescription) {
		this.ticketClassDescription = ticketClassDescription;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public BigDecimal getPaidFare() {
		return paidFare;
	}
	public void setPaidFare(BigDecimal paidFare) {
		this.paidFare = paidFare;
	}
	public String getSupplierNqme() {
		return supplierNqme;
	}
	public void setSupplierNqme(String supplierNqme) {
		this.supplierNqme = supplierNqme;
	}
	public String getDirectorate() {
		return directorate;
	}
	public void setDirectorate(String directorate) {
		this.directorate = directorate;
	}
	
	@Override
	public String toString() {
		return "Flight [departure_2011=" + departure_2011 + ", ticketClassDescription=" + ticketClassDescription
				+ ", departure=" + departure + ", destination=" + destination + ", paidFare=" + paidFare
				+ ", supplierNqme=" + supplierNqme + ", directorate=" + directorate + ", date=" + date + "]";
	}
	
	
	
	
}















