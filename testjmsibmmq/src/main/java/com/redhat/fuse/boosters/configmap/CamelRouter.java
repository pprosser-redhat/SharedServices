/**
 *  Copyright 2005-2016 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package com.redhat.fuse.boosters.configmap;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;


import javax.jms.JMSException;

import com.ibm.msg.client.jms.JmsConnectionFactory;
import com.ibm.msg.client.jms.JmsFactoryFactory;
import com.ibm.msg.client.wmq.WMQConstants;

    @Component
    public class CamelRouter extends RouteBuilder {

 //   @Autowired
 //  JmsConnectionFactory amqpConnectionFactory;

 /*   @Value("${AMQP_HOST}")
    private String amqpHost;
    @Value("${AMQP_SERVICE_PORT}")
    private String amqpPort;
    @Value("${AMQP_SERVICE_USERNAME}")
    private String userName;
    @Value("${AMQP_SERVICE_PASSWORD}")
    private String pass;
    @Value("${AMQP_REMOTE_URI}")
    private String remoteUri;

    @Value("${AMQP_HOST_2}")
    private String amqpHost_2;
    @Value("${AMQP_SERVICE_PORT_2}")
    private String amqpPort_2;
    @Value("${AMQP_SERVICE_USERNAME_2}")
    private String userName_2;
    @Value("${AMQP_SERVICE_PASSWORD_2}")
    private String pass_2;
    @Value("${AMQP_REMOTE_URI_2}") */
    // 
    //private String remoteUri_2;

    //  Show as an example of setting up 2 amqp components potentially using different connections - I know the guys were talking about
    // us
    
    //Bean One
  /*  @Bean 
    public org.apache.camel.component.amqp.AMQPComponent amqpConnection() {
        org.apache.camel.component.amqp.AMQPComponent amqp = new org.apache.camel.component.amqp.AMQPComponent();
        org.apache.qpid.jms.JmsConnectionFactory jmsConnectionFactory = new org.apache.qpid.jms.JmsConnectionFactory();
        jmsConnectionFactory.setRemoteURI(remoteUri);
        jmsConnectionFactory.setUsername(userName);
        jmsConnectionFactory.setPassword(pass);
        amqp.setConnectionFactory(jmsConnectionFactory);
        return amqp;
    } */

    // Bean Two
  /*  @Bean
    public org.apache.camel.component.amqp.AMQPComponent SecondAmqpConnection() {
        org.apache.camel.component.amqp.AMQPComponent amqp = new org.apache.camel.component.amqp.AMQPComponent();
        org.apache.qpid.jms.JmsConnectionFactory jmsConnectionFactory2 = new org.apache.qpid.jms.JmsConnectionFactory();
        jmsConnectionFactory2.setRemoteURI(remoteUri_2);
        jmsConnectionFactory2.setUsername(userName_2);
        jmsConnectionFactory2.setPassword(pass_2);
        amqp.setConnectionFactory(jmsConnectionFactory2);
        return amqp;
    } */

    @Bean
    public org.apache.camel.component.jms.JmsComponent wmq() {
        org.apache.camel.component.jms.JmsComponent wmq = new org.apache.camel.component.jms.JmsComponent();

        
        // Set the properties
        try {
            JmsFactoryFactory ff = JmsFactoryFactory.getInstance(WMQConstants.WMQ_PROVIDER);
            JmsConnectionFactory mqcf = ff.createConnectionFactory();
            mqcf.setStringProperty(WMQConstants.WMQ_HOST_NAME, "philqm-1086.qm.eu-gb.mq.appdomain.cloud");
            mqcf.setIntProperty(WMQConstants.WMQ_PORT, 31632);
            mqcf.setStringProperty(WMQConstants.WMQ_CHANNEL, "CLOUD.ADMIN.SVRCONN");
            mqcf.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CM_CLIENT);
            mqcf.setBooleanProperty(WMQConstants.USER_AUTHENTICATION_MQCSP, true);
            mqcf.setStringProperty(WMQConstants.USERID, "firstapplica");
            mqcf.setStringProperty(WMQConstants.PASSWORD, "8QEtSikPz2ztysaUlHy7N2NfQAeJQzTJPYsIY1PluJuw");
            mqcf.setStringProperty(WMQConstants.WMQ_QUEUE_MANAGER, "philqm");
            
            wmq.setConnectionFactory(mqcf);

            System.out.println ("UserID value: " + WMQConstants.USERID);
            return wmq;
              } catch (JMSException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            return null;
		}

    }

    @Override
    public void configure() throws Exception {

        restConfiguration()
                // to use undertow component and run on port 8080
                .component("servlet").port(8080)
                // lets enable pretty printing json responses
                .dataFormatProperty("prettyPrint", "true");

        rest("/api")
            .post("hello/{name}")
                .to("direct:sendMessage");
    
        
        from("timer:timer1?period=5s").description("Timer send to JMS")
            .setHeader("name")
                .simple("A message added by the timer")
            .to("direct:sendMessage");    
            
        from("direct:sendMessage")
            .setBody()
                .simple("${header.name}")
            .log("########### The outgoing message ${body}")
        .to("wmq:queue:DEV.QUEUE.1");

        from("wmq:queue:DEV.QUEUE.1")
            .setBody().simple("${header.name}")
            .log("########### The incoming message ${body}")
                .to("log:phil");

        
          // .to("amqpConnection:queue:{{queuename}}?exchangePattern=InOnly");

        //from("SecondAmqpConnection:queue:{{queuename}}").description("Receive message from queue")
        //    .to("log:messagelog"); 
    }

}