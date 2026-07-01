package repository;

import model.Student;
import java.sql.*;
import java.util.*;

public class StudentRepository{
    public boolean addStudent(Student student)throws Exception{
        String query="INSERT into student(user_id,roll_no,name,class_name) values (?,?,?,?)";
        try(Connection con=DBConnection.getConnection();PreparedStatement ps=con.prepareStatement(query)){
            ps.setInt(1,student.getUserId());
            ps.setString(2,student.getRollNo());
            ps.setString(3,student.getName());
            ps.setString(4,student.getClassName());
            int rows=ps.executeUpdate();
            return rows > 0;
        }
    }
    public Student getStudentById(int id)throws Exception{
        String query="Select * from student where id =?";
        try(Connection con=DBConnection.getConnection();PreparedStatement ps=con.prepareStatement(query)){
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                int id1=rs.getInt("id");
                int user_id=rs.getInt("user_id");
                String rno=rs.getString("roll_no");
                String name=rs.getString("name");
                String className=rs.getString("class_name");
                return new Student(id1,user_id,rno,name,className);
            }
            else{
                return null;
            }
        }
    }
    public Student getStudentByUserId(int userId)throws Exception {
        String query = "Select * from student where user_id =?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("roll_no"),
                        rs.getString("name"),
                        rs.getString("class_name")
                );
            }
        }
        return null;
    }
    public List<Student> getAllStudents()throws Exception{
        String query="Select*from student";
        List<Student> student=new ArrayList<>();
        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery()){
            while (rs.next()){
               Student stu=new Student(rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("roll_no"),
                        rs.getString("name"),
                        rs.getString("class_name"));
               student.add(stu);
            }
        }
        return student;
    }
    public boolean deleteStudent(int id)throws Exception{
        String query="DELETE from users where id=?";
        try(Connection con= DBConnection.getConnection();PreparedStatement ps=con.prepareStatement(query)){
            Student stu=getStudentById(id);
            if(stu==null) return false;
            int user_id=stu.getUserId();
            ps.setInt(1,user_id);
            int rows=ps.executeUpdate();
            return rows>0;
        }
    }
    public boolean updateStudent(Student student)throws Exception{
        String query="Update student set roll_no=?,name=?,class_name=? where id=?";
        try(Connection con= DBConnection.getConnection();PreparedStatement ps=con.prepareStatement(query)){
            ps.setString(1,student.getRollNo());
            ps.setString(2,student.getName());
            ps.setString(3,student.getClassName());
            ps.setInt(4,student.getId());
            int rows=ps.executeUpdate();
            return rows>0;

        }

    }

}
