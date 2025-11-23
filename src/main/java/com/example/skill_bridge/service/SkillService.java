package com.example.skill_bridge.service;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.CacheEvict;

import com.example.skill_bridge.repository.SkillRepository;
import com.example.skill_bridge.entity.Skill;

@Service
public class SkillService {

    private final SkillRepository repo;

    public SkillService(SkillRepository repo) {
        this.repo = repo;
    }

    @Cacheable(value = "skills", key = "#p.pageNumber + '-' + #p.pageSize")
    public Page<Skill> findAll(Pageable p) {
        return repo.findAll(p);
    }

    @Cacheable(value = "skills", key = "#id")
    public Skill findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Skill not found"));
    }

    @CachePut(value = "skills", key = "#result.id")
    public Skill create(Skill s) {
        return repo.save(s);
    }

    @CachePut(value = "skills", key = "#id")
    public Skill update(Long id, Skill s) {
        s.setId(id);
        return repo.save(s);
    }

    @CacheEvict(value = "skills", key = "#id")
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
