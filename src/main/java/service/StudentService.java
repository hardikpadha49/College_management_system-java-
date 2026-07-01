package service;
import model.Role;
import model.Student;
import repository.UserRepository;
import repository.StudentRepository;
import util.ValidationUtil;

import java.util.List;

public class StudentService {
    private StudentRepository studentRepository;
    private UserRepository userRepository;
    public StudentService(StudentRepository studentRepository,UserRepository userRepository){
        this.studentRepository=studentRepository;
        this.userRepository=userRepository;
    }
    public boolean createStudent(String rollNo,String name,String className) throws Exception{
        ValidationUtil.validateRollNo(rollNo);
        ValidationUtil.validateName(name);
        ValidationUtil.validateNotEmpty("Class name",className);
        String username=rollNo;
        String password=rollNo;
        int userId=userRepository.createUser(username,password, Role.STUDENT);
        if(userId==-1) return false;
        Student student=new Student(userId,rollNo,name,className);
        return studentRepository.addStudent(student);
    }
    public boolean updateStudent(int id,int userId,String rollNo,String name,String className)throws Exception{
        ValidationUtil.validateRollNo(rollNo);
        ValidationUtil.validateName(name);
        ValidationUtil.validateNotEmpty("Class name",className);
        Student student=new Student(id,userId,rollNo,name,className);
        return studentRepository.updateStudent(student);
    }
    public boolean deleteStudent(int studentId) throws Exception{
        if(studentId<=0){
            throw new IllegalArgumentException("Invalid Student ID");
        }
        return studentRepository.deleteStudent(studentId);
    }
    public Student getStudentById(int studentId)throws Exception{
        if(studentId<=0){
            throw new IllegalArgumentException("Invalid Student ID");
        }
        return studentRepository.getStudentById(studentId);
    }
    public List<Student> getAllStudents()throws Exception{
        return studentRepository.getAllStudents();
    }
    public Student getStudentByUserId(int userId) throws Exception{
        if(userId<=0){
            throw new IllegalArgumentException("Invalid User ID");
        }
        return studentRepository.getStudentByUserId(userId);
    }
}
