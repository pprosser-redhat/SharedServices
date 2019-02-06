package sharedservices.travel.enrich;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import sharedservices.xml.travel.flights.Flighttype;

public class EnrichDepartureLocation implements AggregationStrategy {

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		
		
		Flighttype flightType = (Flighttype) oldExchange.getMessage().getBody();
		flightType.setDepartureDescription((String) newExchange.getMessage().getHeader("locationDescription"));
		oldExchange.getMessage().setBody((Flighttype) flightType);
		
		return oldExchange; 
	}

}
