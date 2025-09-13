package com.rcoem.sms.application.mapper;

import com.rcoem.sms.application.dto.StudentDetails;
import com.rcoem.sms.domain.entities.StudentInfo;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentDetails toDto(StudentInfo studentInfo) {
        return StudentDetails.builder()
                .id(studentInfo.getId())
                .rollNo(studentInfo.getRollNo())
                .name(studentInfo.getName())
                .course(studentInfo.getCourse())
                .email(studentInfo.getEmail())
                .mobileNumber(studentInfo.getMobileNumber())
                .department(studentInfo.getDepartment())
                .gender(studentInfo.getGender())
                .dateOfBirth(studentInfo.getDateOfBirth())
                .build();
    }

    public StudentInfo toEntity(StudentDetails studentDetails) {
        return StudentInfo.builder()
                .id(studentDetails.getId())
                .rollNo(studentDetails.getRollNo())
                .name(studentDetails.getName())
                .course(studentDetails.getCourse())
                .email(studentDetails.getEmail())
                .mobileNumber(studentDetails.getMobileNumber())
                .department(studentDetails.getDepartment())
                .gender(studentDetails.getGender())
                .dateOfBirth(studentDetails.getDateOfBirth())
                .build();
    }
}