package com.woodwing;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetBusinessDomain {

    /*
     * @Test public void getBusinessDomainID() {
     * 
     * given() .auth().basic("integration", "eoDd4upKtf1wegzprFqi")
     * .baseUri("http://edflux-int-app-01.springernature.com:7779") .when()
     * .get("/hier/oid/0b0225498026c308") .then() .statusCode(200);
     * 
     * }
     */

    @Test @Ignore
    public void valid_json_response() {

        given().auth().basic("integration", "eoDd4upKtf1wegzprFqi")
                .baseUri("http://edflux-int-app-01.springernature.com:7779").when().get("/hier/oid/0b0225498026c308")
                .then().statusCode(200).body("elements[0].dcmiTitle", equalTo("QA_DND_BD_Regression"),
                        "elements[0].oid", equalTo("0b0225498026c308"));

    }

    @Test @Ignore
    public void extract_response_data() {

        Response res = given().auth().basic("integration", "eoDd4upKtf1wegzprFqi")
                .baseUri("http://edflux-int-app-01.springernature.com:7779").when().get("/hier/oid/0b0225498026c308")
                .then().extract().response();
        System.out.println(res.asString());
    }

    
    @Test @Ignore
    public void extract_single_value() {

        String oid = given().auth().basic("integration", "eoDd4upKtf1wegzprFqi")
                .baseUri("http://edflux-int-app-01.springernature.com:7779").when().get("/hier/oid/0b0225498026c308")
                .then().extract().path("elements[0].oid");
       System.out.println(oid);
    }
    
    @Test
    public void verify_status_line() {

        given().auth().basic("integration", "eoDd4upKtf1wegzprFqi")
                .baseUri("http://edflux-int-app-01.springernature.com:7779").when().get("/hier/oid/0b0225498026c308")
                .then().statusLine("HTTP/1.1 200 ");
       //System.out.println(oid);
    }
}
