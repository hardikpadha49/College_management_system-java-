package repository;
import java.sql.*;
import model.Parent;
import java.util.*;
public class ParentRepository {
    public boolean addParent(Parent parent) throws Exception {
        String query = "Insert INTO parent (user_id,name, phone,student_id) VALUES (?,?,?,?)";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setInt(1, parent.getUser_id());
            ps.setString(2, parent.getName());
            ps.setString(3, parent.getPhone_no());
            ps.setInt(4, parent.getStudent_id());
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }
    public boolean updateParent(Parent parent) throws Exception{
        String query="UPDATE parent SET name=?, phone=?, student_id=? WHERE id=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setString(1, parent.getName());
            ps.setString(2, parent.getPhone_no());
            ps.setInt(3, parent.getStudent_id());
            ps.setInt(4, parent.getId());
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }
    public Parent getParentById(int id) throws Exception{
        String query="SELECT * FROM parent WHERE id=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Parent(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getInt("student_id"));
            }
        }
        return null;
    }
    public boolean deleteParent(int id) throws Exception{
        String query="DELETE FROM users WHERE id=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            Parent par=getParentById(id);
            if(par==null) return false;
            int user_id=par.getUser_id();
            ps.setInt(1,user_id);
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }
    public List<Parent> getAllParents() throws Exception{
        List<Parent> list=new ArrayList<>();
        String query="SELECT * FROM parent";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs=ps.executeQuery()){
            while (rs.next()){
                Parent parent=new Parent(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getInt("student_id")
                );
                list.add(parent);
            }
        }
        return list;
    }

}
