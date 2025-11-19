package com.example.skill_bridge.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    @Bean
    public CaffeineCacheManager cacheManager() {
        CaffeineCacheManager cm = new CaffeineCacheManager();
        cm.setCaffeine(Caffeine.newBuilder().expireAfterWrite(10, TimeUnit.MINUTES).maximumSize(1000));
        return cm;
    }
}
