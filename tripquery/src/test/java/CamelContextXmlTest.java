import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CamelContextXmlTest extends CamelSpringTestSupport {

	// TODO Create test message bodies that work for the route(s) being tested
	// Expected message bodies
	protected Object[] expectedBodies = { "<something id='1'>expectedBody1</something>",
			"<something id='2'>expectedBody2</something>" };
	// Templates to send to input endpoints
	@Produce(uri = "direct:rest1")
	protected ProducerTemplate inputEndpoint;
	@Produce(uri = "direct:rest2")
	protected ProducerTemplate input2Endpoint;
	@Produce(uri = "direct:rest3")
	protected ProducerTemplate input3Endpoint;
	@Produce(uri = "direct:501")
	protected ProducerTemplate input4Endpoint;
	@Produce(uri = "direct:receiveMessage")
	protected ProducerTemplate input5Endpoint;
	// Mock endpoints used to consume messages from the output endpoints and then perform assertions
	@EndpointInject(uri = "mock:output")
	protected MockEndpoint outputEndpoint;
	@EndpointInject(uri = "mock:output2")
	protected MockEndpoint output2Endpoint;
	@EndpointInject(uri = "mock:output3")
	protected MockEndpoint output3Endpoint;
	@EndpointInject(uri = "mock:output4")
	protected MockEndpoint output4Endpoint;
	@EndpointInject(uri = "mock:output5")
	protected MockEndpoint output5Endpoint;
	@EndpointInject(uri = "mock:output6")
	protected MockEndpoint output6Endpoint;
	@EndpointInject(uri = "mock:output7")
	protected MockEndpoint output7Endpoint;

	@Test
	public void testCamelRoute() throws Exception {
		// Create routes from the output endpoints to our mock endpoints so we can assert expectations
		context.addRoutes(new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from("sql:SELECT * FROM travel?dataSource=dataSource").to(outputEndpoint);
				from("sql:SELECT * FROM travel WHERE Supplier_name SOUNDS LIKE :#${headers.airline}?dataSource=dataSource")
						.to(output3Endpoint);
				from("direct:receiveMessage?exchangePattern=InOnly").to(output4Endpoint);
				from("direct:receiveMessage?exchangePattern=InOnly").to(output2Endpoint);
				from("amqp:queue:receiveFlights?connectionFactory=jmsConnectionFactory&jmsMessageType=Text&deliveryMode=2")
						.to(output7Endpoint);
				from("sql:SELECT * FROM travel WHERE Paid_fare >= :#${headers.money}?dataSource=dataSource")
						.to(output5Endpoint);
				from("direct:receiveMessage?exchangePattern=InOnly").to(output6Endpoint);
			}
		});

		// Define some expectations

		// TODO Ensure expectations make sense for the route(s) we're testing
		outputEndpoint.expectedBodiesReceivedInAnyOrder(expectedBodies);

		// Send some messages to input endpoints
		for (Object expectedBody : expectedBodies) {
			inputEndpoint.sendBody(expectedBody);
		}

		// Validate our expectations
		assertMockEndpointsSatisfied();
	}

	@Override
	protected ClassPathXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("spring/camel-context.xml");
	}

} 
