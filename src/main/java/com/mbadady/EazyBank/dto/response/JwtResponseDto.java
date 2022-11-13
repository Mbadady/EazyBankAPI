package com.mbadady.EazyBank.dto.response;

public class JwtResponseDto {
    private String accessKey;
    private String tokenType = "Bearer";

    public JwtResponseDto(String accessKey, String tokenType) {
        this.accessKey = accessKey;
        this.tokenType = tokenType;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
