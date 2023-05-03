package com.infy.projectname.app.response;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class BaseResponse<T> {
	
	private int ResponseStatus;
	private Date date=new Date();
	private String responseMassage;
	private T body;
	
	public BaseResponse(int responseStatus, String responseMassage, T body) {
		super();
		ResponseStatus = responseStatus;
		this.responseMassage = responseMassage;
		this.body = body;
	}
	
	

}
