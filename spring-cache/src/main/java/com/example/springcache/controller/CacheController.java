package com.example.springcache.controller;

import com.example.springcache.service.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CacheController {
    private final CacheService cacheService;
    @GetMapping("/cache")
    public String cacheTest() {
        return cacheService.cacheTest();
    }
}
