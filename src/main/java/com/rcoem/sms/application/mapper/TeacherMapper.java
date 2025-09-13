package com.rcoem.sms.application.mapper;

import com.rcoem.sms.application.dto.TeacherDetails;
import com.rcoem.sms.domain.entities.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {
    public TeacherDetails toDto(Teacher teacher) {
        return TeacherDetails.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .email(teacher.getEmail())
                .mobileNumber(teacher.getMobileNumber())
                .designation(teacher.getDesignation())
                .department(teacher.getDepartment())
                .subjectSpecialization(teacher.getSubjectSpecialization())
                .build();
    }

    public Teacher toEntity(TeacherDetails teacherDetails) {
        return Teacher.builder()
                .id(teacherDetails.getId())
                .name(teacherDetails.getName())
                .email(teacherDetails.getEmail())
                .mobileNumber(teacherDetails.getMobileNumber())
                .designation(teacherDetails.getDesignation())
                .department(teacherDetails.getDepartment())
                .subjectSpecialization(teacherDetails.getSubjectSpecialization())
                .build();
    }
}
