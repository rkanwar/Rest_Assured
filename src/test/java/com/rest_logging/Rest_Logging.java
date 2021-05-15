package com.rest_logging;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Rest_Logging {
    
  @Test @Ignore
  public void log_all_datils() {
      
      given().auth().basic("integration", "eoDd4upKtf1wegzprFqi")
      .baseUri("http://edflux-int-app-01.springernature.com:7779").when().get("/hier/oid/0b0225498026c308")
      .then().log().all();
        
  }
  
  @Test @Ignore
  public void log_body_or_header() {
      
      given().auth().basic("integration", "eoDd4upKtf1wegzprFqi")
      .baseUri("http://edflux-int-app-01.springernature.com:7779").when().get("/hier/oid/0b0225498026c308")
      .then().log().headers();
        
  }
  
  @Test @Ignore
  public void log_cookies() {
      
      given().auth().basic("integration", "eoDd4upKtf1wegzprFqi")
      .baseUri("http://edflux-int-app-01.springernature.com:7779").when().get("/hier/oid/0b0225498026c308")
      //.then().log().cookies();
      .then().log().status();
        
  }
  
  @Test
  public void log_if_error() {
      
      given().auth().basic("integration", "eoDd4upKtf1wegzprFqi")
      .baseUri("http://edflux-int-app-01.springernature.com:7779").when().get("/hier/oid/0b0225498026c308")
      //.then().log().cookies();
      .then().log().ifValidationFails()
      .statusCode(201);
        
  }
}
