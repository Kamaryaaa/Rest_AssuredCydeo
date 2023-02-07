package com.cydeo.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.*;

public class SpartanNewTestBase {

    @BeforeAll
    public static void init(){

        baseURI = "http://54.86.2.212";
        port = 7000;
        basePath= "/api";

        //baseUri+port+basePath
        //http://54.86.2.212:7000/api
    }
}
