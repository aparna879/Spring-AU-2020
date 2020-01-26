package com.bharath.ws.soap;

import java.util.*;
import com.bharath.ws.soap.dto.RegisterProcessorRequest;
import com.bharath.ws.soap.dto.RegisterProcessorResponse;

public class RegisterProcessorImpl implements RegisterProcessor {
	
	public RegisterProcessorResponse processRegister(RegisterProcessorRequest registerProcessorRequest) {
		RegisterProcessorResponse registerProcessorResponse = new RegisterProcessorResponse();
		if(registerProcessorRequest.getPhone().length()<10) {
			throw new RuntimeException("Please enter a valid Phone Number");
		}
		registerProcessorResponse.setResult(true, registerProcessorRequest.getName());
		return registerProcessorResponse;
	}

	@Override
	public RegisterProcessorResponse processPayment(RegisterProcessorRequest registerProcessorRequest) {
		return null;
	}
}
