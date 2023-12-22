package com.interswitch.test.bookstore.pojo;

public class JWTAuthResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private Long userID;

    public JWTAuthResponse() {
    }

    public JWTAuthResponse(String accessToken, String tokenType, Long userID) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.userID = userID;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Object getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}
