package com.brzozowski.demo.token

import com.brzozowski.demo.IntegrationSpec
import org.hamcrest.CoreMatchers

class TokenResourceSpec extends IntegrationSpec {

    def "should return token valid and user id 1 for token 'VALID'"() {
        expect:
            given()
                    .queryParam("token", "VALID")
                    .get("/api/token")
                    .then()
                    .body('valid', CoreMatchers.is(true))
                    .body('userId', CoreMatchers.is('1'))
    }

    def "should return token invalid for token 'INVALID'"() {
        expect:
            given()
                    .queryParam("token", "INVALID")
                    .get("/api/token")
                    .then()
                    .body('valid', CoreMatchers.is(false))
    }
}
