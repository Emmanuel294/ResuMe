package com.resume.api.ResuMe.web.responses.Tools;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.resume.api.ResuMe.entity.Tools;
import com.resume.api.ResuMe.web.responses.BaseResponse;

import java.util.ArrayList;
import java.util.List;

public class ToolsResponse extends BaseResponse {

    @JsonProperty("tools")
    private List<Tools> toolsList;

    public ToolsResponse(List<Tools> tools,Integer statusCode, String message){
        this.toolsList = tools;
        this.statusCode = statusCode;
        this.message = message;
    }

    public ToolsResponse(Tools tool,Integer statusCode, String message){
        List<Tools> tools = new ArrayList<>();
        tools.add(tool);
        this.toolsList = tools;
        this.statusCode = statusCode;
        this.message = message;
    }
}
