package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {
    private final VideoService videoService;

    public HelloController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("videos", videoService.getVideos()); // Passing the videos to the view.
        return "index";
    }

    @PostMapping("/new-video")
    public String newVideo(@ModelAttribute Video newVideo) {

        videoService.createVideo(newVideo);
        return "redirect:/";
    }

    @GetMapping("/react")
    public String react() {
        return "react";
    }

    @PostMapping("/multi-field-search")
    public String multiFieldSearch( //
            @ModelAttribute VideoSearch search, //
            Model model) {
        List<VideoEntity> searchResults = //
                videoService.search(search);
        model.addAttribute("videos", searchResults);
        return "index";
    }
}