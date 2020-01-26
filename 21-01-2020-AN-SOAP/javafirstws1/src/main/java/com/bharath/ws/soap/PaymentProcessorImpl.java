package com.bharath.ws.soap;

import com.bharath.ws.soap.dto.PaymentProcessorRequest;
import com.bharath.ws.soap.dto.PaymentProcessorResponse;

public class PaymentProcessorImpl implements PaymentProcessor {

	public PaymentProcessorResponse processPayment(PaymentProcessorRequest paymentProcessorRequest) {
		PaymentProcessorResponse paymentProcessorResponse = new PaymentProcessorResponse();
		if(paymentProcessorRequest.getCreditCardInfo().getCardNumber().length()<16) {
			throw new RuntimeException("Please enter a valid length card number");
		}
		paymentProcessorResponse.setResult(true);
		return paymentProcessorResponse;
	}

}
