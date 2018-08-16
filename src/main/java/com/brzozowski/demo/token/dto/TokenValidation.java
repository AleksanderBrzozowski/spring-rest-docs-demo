package com.brzozowski.demo.token.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Data
public abstract class TokenValidation {
    private boolean valid;

    private TokenValidation(boolean valid) {
        this.valid = valid;
    }

    @EqualsAndHashCode(callSuper = true)
    @Value
    public static class TokenValid extends TokenValidation {
        String userId;

        public TokenValid(String userId) {
            super(true);
            this.userId = userId;
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Value
    public static class TokenInvalid extends TokenValidation {
        public static final TokenInvalid INSTANCE = new TokenInvalid();

        private TokenInvalid() {
            super(false);
        }
    }
}

