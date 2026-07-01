package service;

import model.Teacher;
import model.Role;
import util.ValidationUtil;
import repository.UserRepository;
import repository.TeacherRepository;

import java.util.List;

public class TeacherService {

    private TeacherRepository teacherRepository;
    private UserRepository userRepository;

    public TeacherService(TeacherRepository teacherRepository, UserRepository userRepository){
        this.teacherRepository = teacherRepository;
        this.userRepository = userRepository;
    }
    public boolean createTeacher(String username, String password, String name, String subject, String email) throws Exception {

        ValidationUtil.validateName(name);
        ValidationUtil.validateNotEmpty("Username", username);
        ValidationUtil.validateNotEmpty("Password", password);
        ValidationUtil.validateNotEmpty("Subject", subject);
        ValidationUtil.validateEmail(email);

        int userId = userRepository.createUser(username, password, Role.TEACHER);
        if(userId == -1) return false;
        Teacher teacher = new Teacher(userId, name, subject, email);
        return teacherRepository.addTeacher(teacher);
    }
    public boolean updateTeacher(int id, int userId, String name, String subject, String email) throws Exception {

        ValidationUtil.validateName(name);
        ValidationUtil.validateNotEmpty("Subject", subject);
        ValidationUtil.validateEmail(email);

        Teacher teacher = new Teacher(id, userId, name, subject, email);
        return teacherRepository.updateTeacher(teacher);
    }
    public boolean deleteTeacher(int teacherId) throws Exception {
        if(teacherId <= 0){
            throw new IllegalArgumentException("Invalid Teacher ID");
        }
        Teacher teacher = teacherRepository.getTeacherById(teacherId);
        if(teacher == null) return false;
        return teacherRepository.deleteTeacher(teacher.getUser_id());
    }
    public Teacher getTeacherById(int teacherId) throws Exception {
        if(teacherId <= 0){
            throw new IllegalArgumentException("Invalid Teacher ID");
        }
        return teacherRepository.getTeacherById(teacherId);
    }
    public List<Teacher> getAllTeachers() throws Exception {
        return teacherRepository.getAllTeachers();
    }
}