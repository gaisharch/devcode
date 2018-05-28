package model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class VerifyUserRequest {
    private final String sessionId;
    private final String userId;

    @JsonCreator
    public VerifyUserRequest(@JsonProperty("sessionId") String sessionId,
                             @JsonProperty("userId")String userId) {
        this.sessionId = sessionId;
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getUserId() {
        return userId;
    }
}
