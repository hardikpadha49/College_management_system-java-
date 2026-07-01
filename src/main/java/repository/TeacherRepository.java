package repository;
import model.Teacher;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class TeacherRepository {
    public boolean addTeacher(Teacher teacher) throws Exception {
        String query = "INSERT INTO teacher (user_id, name, subject, email) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, teacher.getUser_id());
            ps.setString(2, teacher.getName());
            ps.setString(3, teacher.getSubject());
            ps.setString(4, teacher.getEmail());
            int rows=ps.executeUpdate();
            return rows > 0;
        }
    }
    public List<Teacher> getAllTeachers() throws Exception {
        String query = "SELECT * FROM teacher";
        List<Teacher> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Teacher teacher = new Teacher(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("subject"),
                        rs.getString("email")
                );
                list.add(teacher);
            }
        }
        return list;
    }
    public Teacher getTeacherById(int id) throws Exception {
        String query = "SELECT * FROM teacher WHERE id=?";
        Teacher teacher = null;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    teacher = new Teacher(
                            rs.getInt("id"),
                            rs.getInt("user_id"),
                            rs.getString("name"),
                            rs.getString("subject"),
                            rs.getString("email")
                    );
                }
            }
            return teacher;
        }
    }
    public boolean updateTeacher(Teacher teacher) throws Exception {
        String query = "UPDATE teacher SET name=?, subject=?, email=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, teacher.getName());
            ps.setString(2, teacher.getSubject());
            ps.setString(3, teacher.getEmail());
            ps.setInt(4, teacher.getId());
            int rows=ps.executeUpdate();
            return rows>0;
        }
    }
    public boolean deleteTeacher(int id) throws Exception {
        String query = "DELETE FROM users WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            Teacher teach=getTeacherById(id);
            if(teach==null) return false;
            int user_id=teach.getUser_id();
            ps.setInt(1,user_id);
            int rows=ps.executeUpdate();
            return rows>0;
        }
    }
}