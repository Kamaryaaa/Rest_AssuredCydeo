package com.cydeo.day12;

import com.cydeo.utilities.SpartanNewTestBase;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;


public class P02_SpartanSpecTest extends SpartanNewTestBase {

    @Test
    public void getAllSpartans(){
        given().
                log().all()
                .accept(ContentType.JSON)
                .auth().basic("admin","admin")
        .when()
                .get("/spartans")
        .then()
                .statusCode(200)
                .contentType(ContentType.JSON);

    }

    @Test
    public void getAllSpartanWithReqResSpec(){
        given().
                spec(reqSpec)
        .when()
                .get("/spartans")
        .then()
                .spec(resSpec);

    }

    @Test
    public void getOneSpartanWithReqResSpec(){

        given()
                .spec(reqSpec)
                .and()
                .pathParam("id",10)
        .when().
                get("/spartans/{id}")
        .then()
                .spec(resSpec)
                .body("id",is(10));
    }

    @Test
    public void getOneSpartanAsUser(){

        given()
                .spec(reqUserSpec)
                .and()
                .pathParam("id",10)
                .when().
                get("/spartans/{id}")
                .then()
                .spec(resSpec)
                .body("id",is(10));
    }

    @Test
    public void getOneSpartanWithDynamicSpecs(){

        given()
                .spec(dynamicReqSpec("user","user"))
                .and()
                .pathParam("id",10)
                .when().
                get("/spartans/{id}")
            .then()
                .spec(dynamicResSpec(200))
                .body("id",is(10));
    }

    /**
     *  Create GET_RBAC.csv
     *    username,password,id,statusCode
     *    admin,admin,3,200
     *    editor,editor,3,200
     *    user,user,3,200
     *
     *  Create a parameterized test to check RBAC for GET method
     *
     *
     */


    /**
     *  Create DELETE_RBAC.csv
     *   username,password,id,statuscode
     *
     *    editor,editor,3,403
     *    user,user,3,403
     *    admin,admin,3,204
     *
     *  Create a parameterized test to check RBAC for GET method
     *
     *
     */

}
