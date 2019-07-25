package utills;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class APIUtills {
    //Global Setup Variables
    public static String path; //Rest request path
    public static Response res;//Response of the request
    public static RequestSpecification httpRequest = RestAssured.given();// Specification setting up



    /*
    ***Sets Base URI***
    Before starting the test, we should set the RestAssured.baseURI
    */
    public static void setBaseURI(String baseURI) {
        httpRequest.baseUri( baseURI);
    }

    /*
    ***Sets base path***
    Before starting the test, we should set the RestAssured.basePath
    */
    public static void setBasePath(String basePathTerm) {
        httpRequest.basePath( basePathTerm);


    }

    /*
    ***Sets ContentType***
    We should set content type as JSON or XML before starting the test
    */
    public static void setContentType(ContentType Type) {
        given().contentType(Type);
    }

    public static void setParam(String param1, String param2) {
        given().param(param1, param2);
    }

    /*
    ***Returns response***
    We send "path" as a parameter to the Rest Assured'a "get" method
    and "get" method returns response of API
    */
    public static void getResponse() {
        res= httpRequest.get(path);
    }

    public void processRequest(Map<String, String> featureData) {
    }

    public void processResponse(Map<String, String> featureData) {
    }
}

