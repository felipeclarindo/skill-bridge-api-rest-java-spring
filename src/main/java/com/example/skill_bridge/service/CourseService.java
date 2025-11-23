package com.example.skill_bridge.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.skill_bridge.entity.Course;
import com.example.skill_bridge.repository.CourseRepository;

@Service
public class CourseService {

    private final CourseRepository repo;

    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    @Cacheable(value = "courses", key = "#p.pageNumber + '-' + #p.pageSize")
    public Page<Course> findAll(Pageable p) {
        return repo.findAll(p);
    }

    @Cacheable(value = "courses", key = "#id")
    public Course findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    @CachePut(value = "courses", key = "#result.id")
    public Course create(Course c) {
        return repo.save(c);
    }

    @CachePut(value = "courses", key = "#id")
    public Course update(Long id, Course c) {
        c.setId(id);
        return repo.save(c);
    }

    @CacheEvict(value = "courses", key = "#id")
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
