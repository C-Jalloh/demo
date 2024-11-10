package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class HelloController {
    private final VideoService videoService;

    public HelloController(VideoService videoService) {
        this.videoService = videoService;
    }
   @GetMapping("/")
public String index(Model model) {
     model.addAttribute("videos", videoService.getVideos());  // Passing the videos to the view.
    return "index";
}

@PostMapping("/new-video")
public String newVideo(@ModelAttribute Video newVideo) {
    //TODO: process POST request
    videoService.createVideo(newVideo);
    return "redirect:/";
}

    
}