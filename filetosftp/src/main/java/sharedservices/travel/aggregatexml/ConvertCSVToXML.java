package sharedservices.travel.aggregatexml;

import org.apache.camel.Exchange;

import org.apache.camel.Processor;

import sharedservices.xml.travel.flights.Flighttype;
import sharedservices.xml.travel.flights.ObjectFactory;

import sharedservices.travel.Flight;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertCSVToXML implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		Flight flight = (Flight) exchange.getIn().getBody();
		
		// Convert CSV row to Flighttype object
		
		ObjectFactory of = new ObjectFactory();
		
		Flighttype flightType = of.createFlighttype();
		
		flightType.setDeparture(flight.getDeparture());
		flightType.setDestination(flight.getDestination());
		flightType.setDirectorate(flight.getDirectorate());
		flightType.setMonth(flight.getDeparture_2011());
		flightType.setPaidFare(flight.getPaidFare().intValue());
		flightType.setSupplierName(flight.getSupplierNqme());
		flightType.setTicketClass(flight.getTicketClassDescription());
		
		// Transform incoming date
		
		Date date = new SimpleDateFormat("dd/MM/yy").parse(flight.getDate());
		SimpleDateFormat formatDate = new SimpleDateFormat("dd MMMMMMMMM yy");
		flightType.setDate(formatDate.format(date));
		
		exchange.getIn().setBody(flightType);
		
	}

}
