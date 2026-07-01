package repository;
import model.Marks;
import java.sql.*;
import java.util.*;

public class MarksRepository {
    public boolean addMarks(Marks marks) throws Exception{
        String query="INSERT into marks(student_id,subject,marks) values(?,?,?)";
        try(Connection con=DBConnection.getConnection();PreparedStatement ps=con.prepareStatement(query)){
            ps.setInt(1,marks.getStudent_id());
            ps.setString(2, marks.getSubject());
            ps.setInt(3,marks.getMarks());
            int rows=ps.executeUpdate();
            return rows>0;
        }
    }
    public boolean updateMarks(Marks marks) throws Exception{
        String query="Update marks set subject=?,marks=? where id=? AND student_id=?";
        try(Connection con=DBConnection.getConnection();PreparedStatement ps=con.prepareStatement(query)){
            ps.setString(1,marks.getSubject());
            ps.setInt(2,marks.getMarks());
            ps.setInt(3,marks.getId());
            ps.setInt(4,marks.getStudent_id());
            int rows=ps.executeUpdate();
            return rows>0;
        }
    }
    public List<Marks> getMarksByStudentId(int studentId) throws Exception{
        String query="Select * from marks where student_id=?";
        List<Marks> lst=new ArrayList<>();
        try (Connection con=DBConnection.getConnection();PreparedStatement ps= con.prepareStatement(query)){
            ps.setInt(1,studentId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Marks mark=new Marks(rs.getInt("id"),
                        rs.getInt("student_id"),
                        rs.getString("subject"),
                        rs.getInt("marks"));
                lst.add(mark);
            }
        }
        return lst;
    }
    public boolean deleteMarks(int id) throws Exception{
        String query="Delete from marks where id=?";
        try(Connection con=DBConnection.getConnection();PreparedStatement ps=con.prepareStatement(query)){
            ps.setInt(1,id);
            int rows=ps.executeUpdate();
            return rows>0;
        }
    }
    public List<Marks> getAllMarks() throws Exception{
        String query="Select * from marks";
        List<Marks> list=new ArrayList<>();
        try (Connection con=DBConnection.getConnection();PreparedStatement ps= con.prepareStatement(query);ResultSet rs=ps.executeQuery()){
            while(rs.next()){
                Marks mark=new Marks(rs.getInt("id"),
                        rs.getInt("student_id"),
                        rs.getString("subject"),
                        rs.getInt("marks"));
                list.add(mark);
            }
        }
        return list;
    }
}
