package com.example.springcache.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CacheService {
    @Cacheable(value = "test")
    public String cacheTest() {
        log.info("execute cacheTest");
        return "random:" + (int) (Math.random() * 10);
    }

    @CachePut(value = "test")
    @Scheduled(fixedDelay = 10000)
    public String updateCacheTest() {
        log.info("execute updateCacheTest");
        return "random:" + (int) (Math.random() * 10);
    }
}
