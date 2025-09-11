package com.rcoem.sms.application.services;

import com.rcoem.sms.application.dto.TeacherDetails;
import com.rcoem.sms.application.mapper.TeacherMapper;
import com.rcoem.sms.domain.entities.Teacher;
import com.rcoem.sms.domain.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<TeacherDetails> getAllTeachers() {
        return teacherRepository.findAll()
                .stream()
                .map(teacherMapper::toDto)
                .toList();
    }

    @Override
    public TeacherDetails createTeacher(TeacherDetails teacherDetails) {
        String uid = "TEACHER" + UUID.randomUUID();
        teacherDetails.setId(uid);
        Teacher saved = teacherRepository.save(teacherMapper.toEntity(teacherDetails));
        return teacherMapper.toDto(saved);
    }

    @Override
    public TeacherDetails getTeacherById(String id) {
        Optional<Teacher> teacherInfo = teacherRepository.findById(id);
        return teacherInfo.map(teacherMapper::toDto).orElse(null);
    }

    @Override
    public TeacherDetails updateTeacherById(TeacherDetails teacherDetails) {
        Teacher updated = teacherRepository.save(teacherMapper.toEntity(teacherDetails));
        return teacherMapper.toDto(updated);
    }

    @Override
    public void deleteTeacherById(TeacherDetails teacherDetails) {
        teacherRepository.delete(teacherMapper.toEntity(teacherDetails));
    }
}
