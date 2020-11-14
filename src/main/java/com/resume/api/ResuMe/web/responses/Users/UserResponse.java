package com.resume.api.ResuMe.web.responses.Users;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.resume.api.ResuMe.entity.User;
import com.resume.api.ResuMe.web.responses.BaseResponse;

public class UserResponse extends BaseResponse {

    @JsonProperty("user_data")
    private User user;

    public UserResponse(User user,Integer statusCode, String message){
        this.user = user;
        this.statusCode = statusCode;
        this.message = message;
    }
}
