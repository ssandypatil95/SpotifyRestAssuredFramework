package com.spotify.api;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilders {
	
	@Step
	public static RequestSpecification reqSpec()
	{
		return  new RequestSpecBuilder()
		
		.setBaseUri("https://api.spotify.com")
		.setBasePath("/v1")
		.setContentType(ContentType.JSON)
		.addFilter(new AllureRestAssured())
		.log(LogDetail.ALL)
		.build();
	}
	
	@Step
	public static ResponseSpecification resSpec()
	{ 
		return new ResponseSpecBuilder()
	 	 
		 .expectContentType(ContentType.JSON)
		 .log(LogDetail.ALL)
		 .build();
		
	}

}
