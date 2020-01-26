package com.bharath.ws.soap.dto;

import javax.xml.bind.annotation.XmlType;

@XmlType(name="RegisterProcessorResponse")
public class RegisterProcessorResponse {
	private boolean result;
	private String resName;
	private String resPhone;

	public String isResult() {
		return "Hello! Your name is "+resName+".";
	}

	public void setResult(boolean result, String name, String phone) {
		this.result = result;
		this.resName = name;
		this.resPhone = phone;
	}
}
