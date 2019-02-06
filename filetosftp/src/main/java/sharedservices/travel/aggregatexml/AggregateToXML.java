package sharedservices.travel.aggregatexml;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import sharedservices.xml.travel.flights.Flights;
import sharedservices.xml.travel.flights.Flighttype;
import sharedservices.xml.travel.flights.ObjectFactory;

public class AggregateToXML implements AggregationStrategy {

	Flights flights;

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

		if (oldExchange == null) {

			oldExchange = newExchange;

			Integer messagesProcessed = 0;

			oldExchange.getIn().setHeader("MessagesProcessed", messagesProcessed);

			// First row from spreadsheet is header so just return the exchange
			return oldExchange;

		}

		if (oldExchange.getIn().getBody().toString()
				.startsWith("Departure_2011,Ticket_class_description")) { /* Create fights if first flight through */

			ObjectFactory of = new ObjectFactory();

			flights = of.createFlights();
		} else {

			flights = (Flights) oldExchange.getIn().getBody();
		}

		Flighttype ft = (Flighttype) newExchange.getIn().getBody();

		flights.getFlight().add(ft);

		oldExchange.getIn().setBody(flights);

		// Count messages processed
		Integer messagesProcessed = (Integer) oldExchange.getIn().getHeader("MessagesProcessed");
		messagesProcessed = new Integer(messagesProcessed.intValue() + 1);
		oldExchange.getIn().setHeader("MessagesProcessed", messagesProcessed);

		return oldExchange;
	}
}
