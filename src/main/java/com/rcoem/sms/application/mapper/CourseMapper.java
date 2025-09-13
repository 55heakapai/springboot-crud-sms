package com.rcoem.sms.application.mapper;

import com.rcoem.sms.application.dto.CourseDetails;
import com.rcoem.sms.domain.entities.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    public CourseDetails toDto(Course course) {
        return CourseDetails.builder()
                .id(course.getId())
                .courseCode(course.getCourseCode())
                .courseName(course.getCourseName())
                .description(course.getDescription())
                .department(course.getDepartment())
                .build();
    }

    public Course toEntity(CourseDetails courseDetails) {
        return Course.builder()
                .id(courseDetails.getId())
                .courseCode(courseDetails.getCourseCode())
                .courseName(courseDetails.getCourseName())
                .description(courseDetails.getDescription())
                .department(courseDetails.getDepartment())
                .build();
    }
}
