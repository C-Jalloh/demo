package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    private final VideoService videoService;

    public HelloController(VideoService videoService) {
        this.videoService = videoService;
    }
   @GetMapping("/")
public String index() {

    return "index";
}
    
}