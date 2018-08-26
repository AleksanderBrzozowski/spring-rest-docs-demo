package com.brzozowski.demo

import groovy.transform.TypeChecked
import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import org.junit.Rule
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.restdocs.JUnitRestDocumentation
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.documentationConfiguration

@TypeChecked
@SpringBootTest(webEnvironment = RANDOM_PORT)
class IntegrationSpec extends Specification {

    @LocalServerPort
    Integer port
    @Rule
    JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation()
    RequestSpecification spec

    void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()
        spec = new RequestSpecBuilder()
                .addFilter(documentationConfiguration(restDocumentation)
                .operationPreprocessors()
                .withRequestDefaults(prettyPrint())
                .withResponseDefaults(prettyPrint()))
                .setContentType(ContentType.JSON)
                .setPort(port)
                .build()
    }

    RequestSpecification given() {
        return RestAssured
                .given(spec)
    }

}
