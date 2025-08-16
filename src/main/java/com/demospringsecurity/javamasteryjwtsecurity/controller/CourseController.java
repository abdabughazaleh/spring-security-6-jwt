package com.demospringsecurity.javamasteryjwtsecurity.controller;

import com.demospringsecurity.javamasteryjwtsecurity.model.dto.CourseDTO;
import com.demospringsecurity.javamasteryjwtsecurity.services.CoursesService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CoursesService coursesService;

    public CourseController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    @GetMapping("/all")
    public List<CourseDTO> courses() {
        return this.coursesService.courses();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/my-courses")
    public List<CourseDTO> myCourses(@AuthenticationPrincipal Jwt jwt) {
        var username = jwt.getSubject();
        return this.coursesService.findAllBtUserUsername(username);
    }

    @GetMapping("/user-courses/{username}") // admin
    public List<CourseDTO> anyUserCourses(@PathVariable("username") String username) {
        return this.coursesService.findAllBtUserUsername(username);
    }
}
