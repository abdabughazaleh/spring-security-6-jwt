package com.demospringsecurity.javamasteryjwtsecurity.repository;

import com.demospringsecurity.javamasteryjwtsecurity.model.dto.CourseDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class CourseRepo {
    private final List<CourseDTO> courses = new ArrayList<>();
    private final AtomicInteger seq = new AtomicInteger(1);

    public CourseRepo() {
        this.courses.add(new CourseDTO(seq.getAndIncrement(), "user", "Java Course", "for java developers"));
        this.courses.add(new CourseDTO(seq.getAndIncrement(), "user", "Spring Boot", "for java advanced developers"));
        this.courses.add(new CourseDTO(seq.getAndIncrement(), "abd", "Spring Security", "for java advanced developers + spring boot"));
        this.courses.add(new CourseDTO(seq.getAndIncrement(), "abd", "Spring data", "for java advanced developers + spring boot"));
        this.courses.add(new CourseDTO(seq.getAndIncrement(), "user", "Clean code", "for all developers"));
    }

    public List<CourseDTO> findAll() {
        return List.copyOf(courses);
    }

    public List<CourseDTO> findAllBtUserUsername(String username) {
        return List.copyOf(courses).stream()
                .filter(c -> c.username().equals(username) )
                .toList();
    }
}
