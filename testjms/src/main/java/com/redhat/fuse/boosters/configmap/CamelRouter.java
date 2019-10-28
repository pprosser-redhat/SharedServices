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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;
import org.apache.qpid.jms.JmsConnectionFactory;

/**
 * A simple Camel REST DSL route that implements the greetings service.
 * 
 */
@Component
public class CamelRouter extends RouteBuilder {

 //   @Autowired
 //  JmsConnectionFactory amqpConnectionFactory;

    @Value("${AMQP_HOST}")
    private String amqpHost;
    @Value("${AMQP_SERVICE_PORT}")
    private String amqpPort;
    @Value("${AMQP_SERVICE_USERNAME}")
    private String userName;
    @Value("${AMQP_SERVICE_PASSWORD}")
    private String pass;
    @Value("${AMQP_REMOTE_URI}")
    private String remoteUri;

    @Bean 
    public org.apache.camel.component.amqp.AMQPComponent amqpConnection() {
        org.apache.camel.component.amqp.AMQPComponent amqp = new org.apache.camel.component.amqp.AMQPComponent();
        org.apache.qpid.jms.JmsConnectionFactory jmsConnectionFactory = new org.apache.qpid.jms.JmsConnectionFactory();
        jmsConnectionFactory.setRemoteURI(remoteUri);
        jmsConnectionFactory.setUsername(userName);
        jmsConnectionFactory.setPassword(pass);
        amqp.setConnectionFactory(jmsConnectionFactory);
        return amqp;
    }

    @Override
    public void configure() throws Exception {

        from("timer:timer1?period=5s").description("Timer send to JMS")
            .setBody()
                .simple("A message added")
            .to("amqpConnection:queue:testqueue");     

        from("amqpConnection:queue:{{queuename}}").description("Receive message from queue")
            .to("log:messagelog");
    }

}