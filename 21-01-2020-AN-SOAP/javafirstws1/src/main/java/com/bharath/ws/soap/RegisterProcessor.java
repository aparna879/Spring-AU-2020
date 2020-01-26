package com.bharath.ws.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.bharath.ws.soap.dto.RegisterProcessorResponse;
import com.bharath.ws.soap.dto.RegisterProcessorRequest;

@WebService(name = "RegisterProcessor")
public interface RegisterProcessor {
	@WebMethod
	public @WebResult(name = "response") RegisterProcessorResponse processPayment(
			@WebParam(name = "registerProcessorRequest") RegisterProcessorRequest registerProcessorRequest) /*throws Exception*/;
}
