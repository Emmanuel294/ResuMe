package com.resume.api.ResuMe.controller;

import com.resume.api.ResuMe.entity.Tools;
import com.resume.api.ResuMe.service.IToolsService;
import com.resume.api.ResuMe.service.IToolsServiceImpl;
import com.resume.api.ResuMe.service.IUserService;
import com.resume.api.ResuMe.web.responses.Resumes.ResumesResponse;
import com.resume.api.ResuMe.web.responses.Tools.ToolsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.tools.Tool;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ToolsRestController {

    @Autowired
    private IToolsServiceImpl iToolsService;

    @Autowired
    private IUserService userService;



    @GetMapping("/tools")
    public List<Tools> getAll(){
        return iToolsService.findAll();
    }

    @GetMapping("/tools/{id}")
    public ResponseEntity<ToolsResponse> findAllByUser(@PathVariable Long id){
        List<Tools> tools = iToolsService.findAllByUserId(id);
        if(tools != null && tools.size() > 0){
            return new ResponseEntity<ToolsResponse>(new ToolsResponse(tools,HttpStatus.OK.value(),"success"),HttpStatus.OK);
        }
        return new ResponseEntity<ToolsResponse>(new ToolsResponse(tools,HttpStatus.OK.value(),"no content"),HttpStatus.OK);
    }

    @GetMapping("/tools/{id}/{tid}")
    public Tools getById(@PathVariable Long tid){
        return iToolsService.findById(tid);
    }

    @PostMapping("/tools")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ToolsResponse>  create(@RequestBody Tools tool){
        tool.setUser(userService.findById(tool.getIdUser()));
        Tools createdTool = iToolsService.save(tool);
        if(createdTool != null){
            return new ResponseEntity<ToolsResponse>(new ToolsResponse(createdTool,HttpStatus.OK.value(),"success"),HttpStatus.OK);
        }
        return new ResponseEntity<ToolsResponse>(new ToolsResponse(createdTool,HttpStatus.OK.value(),"no content"),HttpStatus.OK);
    }

    @PutMapping("/tools/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ToolsResponse> update(@PathVariable Long id, @RequestBody Tools tool){
        Tools actTool = iToolsService.findById(tool.getId());
        if(actTool != null && actTool.getUser().getId() == id){
            actTool.setName(tool.getName());
            actTool = iToolsService.save(actTool);
            return new ResponseEntity<ToolsResponse>(new ToolsResponse(actTool,HttpStatus.OK.value(),"success"),HttpStatus.OK);
        }

        return new ResponseEntity<ToolsResponse>(new ToolsResponse(actTool,HttpStatus.OK.value(),"no content"),HttpStatus.OK);
    }

    @DeleteMapping("/tools/{id}/{tid}")
    public ResponseEntity<ToolsResponse> delete(@PathVariable Long id, @PathVariable Long tid){
        Tools actTool = iToolsService.findById(tid);
        if(actTool != null && actTool.getUser().getId() == id){
            iToolsService.deleteProjectsTools(actTool.getId());
            iToolsService.delete(actTool.getId());
            return new ResponseEntity<ToolsResponse>(new ToolsResponse(actTool,HttpStatus.OK.value(),"success"),HttpStatus.OK);
        }

        return new ResponseEntity<ToolsResponse>(new ToolsResponse(actTool,HttpStatus.OK.value(),"no content"),HttpStatus.OK);
    }

}
