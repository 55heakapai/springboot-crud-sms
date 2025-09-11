package com.rcoem.sms.intefaces;

import com.rcoem.sms.application.dto.TeacherDetails;
import com.rcoem.sms.application.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeachersController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public ResponseEntity addTeacher(@RequestBody TeacherDetails teacherDetails) {
        TeacherDetails insertedTeacher = teacherService.createTeacher(teacherDetails);
        return ResponseEntity.created(URI.create("/teachers/" + insertedTeacher.getId())).build();
    }

    @GetMapping
    public List<TeacherDetails> getTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDetails> getTeacherById(@PathVariable String id) {
        TeacherDetails teacherDetails = teacherService.getTeacherById(id);
        return teacherDetails == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(teacherDetails);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherDetails> updateTeacher(@PathVariable String id, @RequestBody TeacherDetails teacherDetails) {
        teacherDetails.setId(id);
        TeacherDetails updatedTeacher = teacherService.updateTeacherById(teacherDetails);
        return updatedTeacher == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updatedTeacher);
    }
}
