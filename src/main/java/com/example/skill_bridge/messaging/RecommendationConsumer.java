package com.example.skill_bridge.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.example.skill_bridge.config.RabbitConfig;

@Component
public class RecommendationConsumer {

    @RabbitListener(queues = RabbitConfig.RECOMMENDATIONS_QUEUE)
    public void onRecommendation(Long id) {
        // Example: when recommendation id arrives, you could process
        System.out.println("Received recommendation event for id: " + id);
    }
}
