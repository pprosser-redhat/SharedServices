package com.phil;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.reactive.streams.api.CamelReactiveStreamsService;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.reactivestreams.Publisher;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class MyRoutes extends RouteBuilder{

    @Inject
    CamelContext ctx;

    @Inject
    CamelReactiveStreamsService crss;

    @Outgoing("message")
    public Publisher<String> source(){
        return crss.from("seda:receiveFlights", String.class);
    }  

    void onStart(@Observes StartupEvent ev) throws Exception {               
        
        
    }
    void onStop(@Observes ShutdownEvent ev) throws Exception {               
        
    }

	@Override
	public void configure() throws Exception {
   
        // Data Format

        JacksonDataFormat jacksonDataFormat = new JacksonDataFormat();
        jacksonDataFormat.setPrettyPrint(true);

        rest()
            .enableCORS(true)
            .id("rest1")
            
            .get("openapi.json")
                .description("Gets the openapi document for this service")
                .id("openapi.json")
                .bindingMode(RestBindingMode.json)
                .route()
                    .setBody(simple("resource:classpath:openapi.json"))
                    .unmarshal(jacksonDataFormat)
                .endRest();

        rest("trips")
            .enableCORS(true)
            .id("rest2")
            .bindingMode(RestBindingMode.json)
            .get()
                .description("Get all Trips")
                .id("Get Trips")
                .to("direct:trips")
            
            .get("/airline")
                .description("get-tripsbyairline")
                .id("get-tripsbyairline")
                .to("direct:airlines")
                .param()
                    .type(RestParamType.query)
                    .dataType("String")
                    .required(true)
                    .name("airline")
                .endParam()
        
            .get("/searchbyvalue")
                .description("get-tripsbymoney")
                .id("get-tripsbymoney")
                .to("direct:money")
                .param()
                    .type(RestParamType.query)
                    .dataType("String")
                    .required(true)
                    .name("money");
                    
        from("direct:trips")
            .description("Query All trips", "Query All trips", "EN")
            .to("sql:SELECT * FROM travel")
            .to("direct:receiveMessage")
        ;

        from("direct:airlines")
            .description("Query All trips by airline", "Query All trips by airline", "EN")
            .to("sql:SELECT * FROM travel WHERE Supplier_name SOUNDS LIKE :#${headers.airline}")
            .to("direct:receiveMessage")
        ;
        
        from("direct:money")
            .description("Query All trips by money", "Query All trips by money", "EN")
            .to("sql:SELECT * FROM travel WHERE Paid_fare >= :#${headers.money}")
            .to("direct:receiveMessage")
        ;
 
        from("direct:receiveMessage")
            .id("_fromrestcall")
            .description("Publish response to Q")
            .marshal(jacksonDataFormat)
            // amqp connector replaced with reactive small rye amqp as no connector amqp
            /*.to("amqp:queue:receiveFlights?connectionFactory=#jmsConnectionFactory&jmsMessageType=text&deliveryMode=2") */
            .to("seda:receiveFlights")
            .unmarshal(jacksonDataFormat)
            
        ;
            
	}
    
}