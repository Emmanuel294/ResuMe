package com.resume.api.ResuMe.controller;

import com.resume.api.ResuMe.entity.Tools;
import com.resume.api.ResuMe.service.IToolsService;
import com.resume.api.ResuMe.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ToolsRestController {

    @Autowired
    private IToolsService iToolsService;

    @Autowired
    private IUserService userService;



    @GetMapping("/tools")
    public List<Tools> getAll(){
        return iToolsService.findAll();
    }

    @GetMapping("/tools/{id}")
    public Tools getById(@PathVariable Long id){
        return iToolsService.findById(id);
    }

    @PostMapping("/tools")
    @ResponseStatus(HttpStatus.CREATED)
    public Tools create(@RequestBody Tools tool){
        tool.setUser(userService.findById(tool.getIdUser()));
        return iToolsService.save(tool);
    }

    @PutMapping("/tools/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Tools update(@PathVariable Long id, @RequestBody Tools tools){
        Tools actTool = iToolsService.findById(id);
        actTool.setName(tools.getName());
        return iToolsService.save(actTool);
    }

    @DeleteMapping("/tools/{id}")
    public void delete(@PathVariable Long id){
        iToolsService.delete(id);
    }

}
