package com.resume.api.ResuMe.web.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseResponse {

    @JsonProperty("status_code")
    protected Integer statusCode;

    @JsonProperty("message")
    protected String message;

    protected BaseResponse() {

    }
}
