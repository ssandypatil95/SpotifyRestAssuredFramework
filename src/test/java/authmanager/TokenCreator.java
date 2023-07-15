package authmanager;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class TokenCreator {
	
	
	public static String renewToken()
	{
		HashMap<String, String> param = new HashMap<String, String>();
		
		param.put("grant_type", "refresh_token");
		param.put("refresh_token", "refresh-Token");
		param.put("client_id", "7ed653f6cc1841d5b1a45c6f86bf9003");
		param.put("client_secret", "268f9dce0a9b46a0963d5242e4dea6cc");
		
		
		RestAssured.baseURI = "https://accounts.spotify.com";
		
		Response response = given()
		.contentType(ContentType.URLENC)
		
		.formParams(param)
		
		.when()
		
		.post("/api/token")
		
		.then()
		
		.extract()
		
		.response();
		
		if(response.statusCode()!=200)
		{
			throw new RuntimeException("Failed to create the access token");
		}
		
		
		 String token = response.path("access_token");
		 
		 return token;
		
		
	}

}
