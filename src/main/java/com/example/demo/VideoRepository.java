package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository
<VideoEntity, Long> {


    List<VideoEntity> findByName (String name);
    List<VideoEntity> findByNameContainsOrDescriptionContainsAllIgnoreCase(String name, String description);
    List<VideoEntity> findByNameContainsIgnoreCase(String name);
    List<VideoEntity> findByDescriptionContainsIgnoreCase(String description);
}