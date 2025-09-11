package com.rcoem.sms.intefaces;

import com.rcoem.sms.application.dto.CourseDetails;
import com.rcoem.sms.application.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity addCourse(@RequestBody CourseDetails courseDetails) {
        CourseDetails insertedCourse = courseService.createCourse(courseDetails);
        return ResponseEntity.created(URI.create("/courses/" + insertedCourse.getId())).build();
    }

    @GetMapping
    public List<CourseDetails> getCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDetails> getCourseById(@PathVariable String id) {
        CourseDetails courseDetails = courseService.getCourseById(id);
        return courseDetails == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(courseDetails);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDetails> updateCourse(@PathVariable String id, @RequestBody CourseDetails courseDetails) {
        courseDetails.setId(id);
        CourseDetails updatedCourse = courseService.updateCourseById(courseDetails);
        return updatedCourse == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updatedCourse);
    }
}
