package com.rcoem.sms.application.services;

import com.rcoem.sms.application.dto.CourseDetails;
import com.rcoem.sms.application.mapper.CourseMapper;
import com.rcoem.sms.domain.entities.Course;
import com.rcoem.sms.domain.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<CourseDetails> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toDto)
                .toList();
    }

    @Override
    public CourseDetails createCourse(CourseDetails courseDetails) {
        String uid = "COURSE" + UUID.randomUUID();
        courseDetails.setId(uid);
        Course saved = courseRepository.save(courseMapper.toEntity(courseDetails));
        return courseMapper.toDto(saved);
    }

    @Override
    public CourseDetails getCourseById(String id) {
        Optional<Course> courseInfo = courseRepository.findById(id);
        return courseInfo.map(courseMapper::toDto).orElse(null);
    }

    @Override
    public CourseDetails updateCourseById(CourseDetails courseDetails) {
        Course updated = courseRepository.save(courseMapper.toEntity(courseDetails));
        return courseMapper.toDto(updated);
    }

    @Override
    public void deleteCourseById(CourseDetails courseDetails) {
        courseRepository.delete(courseMapper.toEntity(courseDetails));
    }
}
