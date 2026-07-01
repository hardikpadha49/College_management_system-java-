package repository;
import model.Role;
import model.User;
import java.sql.*;
public class UserRepository {
    public User login(String username,String password) throws Exception {
        String query = "SELECT * from users where username=? and password=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String UserName = rs.getString("username");
                String pass = rs.getString("password");
                String role = rs.getString("role");
                Role role1 = Role.valueOf(role);
                return new User(id, UserName, pass, role1);
            } else {
                return null;
            }
        }
    }

    public int createUser(String username,String password,Role role)throws Exception {
        String query = "INSERT INTO users (username,password,role) values(?,?,?)";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            String role1 = String.valueOf(role);

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role1);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return -1;
            }
        }
    }

    public boolean existsById(int id) throws Exception {

        String query = "SELECT id FROM users WHERE id=?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            return rs.next();
        }
    }
}


