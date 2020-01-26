package com.soap.config;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.soap.main.CustomerOrdersWsImpl;

@Configuration
public class WebServiceConfig {

	@Autowired
	private Bus bus;

	@Bean
	public Endpoint endpoint() {
		Endpoint endPoint = (Endpoint) new EndpointImpl(bus, new CustomerOrdersWsImpl());
		((EndpointImpl) endPoint).publish("/customerordersservice");
		return endPoint;
	}

}
