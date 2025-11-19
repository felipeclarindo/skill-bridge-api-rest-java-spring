package com.example.skill_bridge.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class RabbitConfig {

    public static final String RECOMMENDATIONS_QUEUE = "recommendations";

    @Bean
    public Queue recommendationsQueue() {
        return new Queue(RECOMMENDATIONS_QUEUE, true);
    }
}
