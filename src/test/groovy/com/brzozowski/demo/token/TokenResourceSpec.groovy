package com.brzozowski.demo.token

import com.brzozowski.demo.IntegrationSpec
import org.apache.http.HttpStatus
import org.hamcrest.CoreMatchers

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.document

class TokenResourceSpec extends IntegrationSpec {


    def "should return token valid and user id 1 for token 'VALID'"() {
        expect:
            given()
                    .filter(document('tokens/check-valid-token',
                    requestParameters(
                            parameterWithName('token').description('Token')),
                    responseFields(
                            fieldWithPath('valid').description('Is token valid'),
                            fieldWithPath('userId').description('User id'))))
                    .queryParam("token", "VALID")
                    .get("/api/tokens")
                    .then()
                    .statusCode(HttpStatus.SC_OK)
                    .body('valid', CoreMatchers.is(true))
                    .body('userId', CoreMatchers.is('1'))
    }

    def "should return token invalid for token 'INVALID'"() {
        expect:
            given()
                    .filter(document('tokens/check-invalid-token'))
                    .queryParam("token", "INVALID")
                    .get("/api/tokens")
                    .then()
                    .statusCode(HttpStatus.SC_OK)
                    .body('valid', CoreMatchers.is(false))
    }
}
