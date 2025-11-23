package com.example.skill_bridge.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.skill_bridge.entity.LearningPath;
import com.example.skill_bridge.repository.LearningPathRepository;

@Service
public class LearningPathService {

    private final LearningPathRepository repo;

    public LearningPathService(LearningPathRepository repo) {
        this.repo = repo;
    }

    @Cacheable(value = "learningPaths", key = "#p.pageNumber + '-' + #p.pageSize")
    public Page<LearningPath> findAll(Pageable p) {
        return repo.findAll(p);
    }

    @Cacheable(value = "learningPaths", key = "#id")
    public LearningPath findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("LearningPath not found"));
    }

    @CachePut(value = "learningPaths", key = "#result.id")
    public LearningPath create(LearningPath lp) {
        return repo.save(lp);
    }

    @CachePut(value = "learningPaths", key = "#id")
    public LearningPath update(Long id, LearningPath lp) {
        lp.setId(id);
        return repo.save(lp);
    }

    @CacheEvict(value = "learningPaths", key = "#id")
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
