package Dao;

import modele.entities.User;
import utilitaire.SingletonConnexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAuth implements IDaoAuth {
    private Connection con = SingletonConnexion.getCon();

    @Override
    public User auth(String Email,String password) {
        User authenticatedUser = null;
        try {
            String query = "SELECT * FROM user WHERE email = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, Email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String role = rs.getString("role");
                String email = rs.getString("email");
                authenticatedUser = new User(id, firstname, lastname, role);
                authenticatedUser.setEmail(email);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authenticatedUser;
    }
}
