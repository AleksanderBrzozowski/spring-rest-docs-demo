package com.brzozowski.demo

import groovy.transform.TypeChecked
import io.restassured.RestAssured
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@TypeChecked
@SpringBootTest(webEnvironment = RANDOM_PORT)
class IntegrationSpec extends Specification {

    @LocalServerPort
    Integer port

    RequestSpecification given() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .port(port)
    }

}
