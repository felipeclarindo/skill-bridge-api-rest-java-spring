package com.example.skill_bridge.service;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.CacheEvict;

import com.example.skill_bridge.repository.WorkRepository;
import com.example.skill_bridge.entity.Work;

@Service
public class WorkService {

    private final WorkRepository repo;

    public WorkService(WorkRepository repo) {
        this.repo = repo;
    }

    @Cacheable(value = "works", key = "#p.pageNumber + '-' + #p.pageSize")
    public Page<Work> findAll(Pageable p) {
        return repo.findAll(p);
    }

    @Cacheable(value = "works", key = "#id")
    public Work findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Work not found"));
    }

    @CachePut(value = "works", key = "#result.id")
    public Work create(Work w) {
        return repo.save(w);
    }

    @CachePut(value = "works", key = "#id")
    public Work update(Long id, Work w) {
        w.setId(id);
        return repo.save(w);
    }

    @CacheEvict(value = "works", key = "#id")
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
