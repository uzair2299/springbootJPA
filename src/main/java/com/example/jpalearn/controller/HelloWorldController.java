package com.example.jpalearn.controller;

import org.springframework.web.bind.annotation.*;

@RestController

public class HelloWorldController {
    @RequestMapping(method = RequestMethod.GET,path = "/helloWorld")
    public String helloWorld(){
        return "Hello Word";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/helloWorld/pathParameter/{name}")
    public String helloWorldPathParameter(@PathVariable String name){
        return  String.format("Hello Word , %s",name);
    }
}
