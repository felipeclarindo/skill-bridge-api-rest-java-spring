
package com.example.skill_bridge.service;

import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.CacheEvict;

import com.example.skill_bridge.repository.RecommendationRepository;
import com.example.skill_bridge.entity.Recommendation;
import com.example.skill_bridge.config.RabbitConfig;

import java.util.List;

@Service
public class RecommendationService {

    private final RecommendationRepository repo;
    private final RabbitTemplate rabbit;

    public RecommendationService(RecommendationRepository repo, RabbitTemplate rabbit) {
        this.repo = repo;
        this.rabbit = rabbit;
    }

    @Cacheable(value = "recommendations")
    public List<Recommendation> getAll() {
        return repo.findAll();
    }

    @Cacheable(value = "recommendations", key = "#id")
    public Recommendation getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Rec not found"));
    }

    @CachePut(value = "recommendations", key = "#result.id")
    public Recommendation create(Recommendation r) {
        Recommendation saved = repo.save(r);
        rabbit.convertAndSend(RabbitConfig.RECOMMENDATIONS_QUEUE, saved.getId());
        return saved;
    }

    @CachePut(value = "recommendations", key = "#id")
    public Recommendation update(Long id, Recommendation r) {
        r.setId(id);
        return repo.save(r);
    }

    @CacheEvict(value = "recommendations", key = "#id")
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
