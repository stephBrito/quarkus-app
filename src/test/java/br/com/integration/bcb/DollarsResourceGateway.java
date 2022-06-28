package br.com.integration.bcb;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DollarsResourceGateway {
    @Test
    @Order(1)
    public void testGetAll() {
        given()
                .when().get("/v1/dollar/getallsavedquotes")
                .then()
                .statusCode(200);
    }
}
