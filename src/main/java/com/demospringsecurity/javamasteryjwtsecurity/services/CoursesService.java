package com.demospringsecurity.javamasteryjwtsecurity.services;

import com.demospringsecurity.javamasteryjwtsecurity.model.dto.CourseDTO;
import com.demospringsecurity.javamasteryjwtsecurity.repository.CourseRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {
    private final CourseRepo courseRepo;

    public CoursesService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public List<CourseDTO> courses() {
        return this.courseRepo.findAll();
    }

    public List<CourseDTO> findAllBtUserUsername(String username) {
        return this.courseRepo.findAllBtUserUsername(username);
    }
}
