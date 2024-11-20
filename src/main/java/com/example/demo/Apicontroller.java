package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class Apicontroller {
    private final VideoService videoService;

    public Apicontroller(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping("/api/videos")
    public Video newVideo(@RequestBody Video newVideo) {
        return videoService.createVideo(newVideo);
    }

    @GetMapping("/api/videos")
    public List<Video> all() {
        return videoService.getVideos();
    }

}
