package com.cydeo.day14;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P02_SpartanMockAPI extends SpartanTestBase {

   /* @BeforeAll
    public static void init(){
        baseURI="https://be9422f8-2852-4100-9210-07b443a18f6d.mock.pstmn.io";
    }

    */



    @Test
    public void test1(){
        Response response = given().accept(ContentType.TEXT)
                .log().all()
                .when().get("/api/hello")
                .then().statusCode(200)
                .extract().response();
        assertEquals("Hello from Sparta",response.asString());


    }

    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .log().all()
                .when().get("/api/spartans")
                .then().statusCode(200)
                .extract().response();

        response.prettyPrint();

    }





}
