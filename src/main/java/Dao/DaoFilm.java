package Dao;

import modele.entities.Film;
import modele.entities.SalleCinema;
import utilitaire.SingletonConnexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoFilm implements IDaoFilm {
    private Connection con = SingletonConnexion.getCon();

    @Override
    public List<Film> getAllFilms() {
        List<Film> films = new ArrayList<>();
        String query = "SELECT * FROM Film";
        try (PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Film f = new Film(rs.getInt("id"), rs.getString("titre"), rs.getString("realisateur"),
                        rs.getString("description"), rs.getString("dateSortie"),
                        rs.getString("duree"), rs.getString("image"));
                films.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider better error handling or logging
        }
        return films;
    }

    @Override
    public Film addFilm(String titre, String realisateur, String description, String dateSortie, String duree, String image, int IdCategorie) {
        Film film = new Film();
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Film (titre, realisateur, description, dateSortie, duree, image,IdCategorie) VALUES (?, ?, ?, ?, ?, ?,?)");
            ps.setString(1, titre);
            ps.setString(2, realisateur);
            ps.setString(3, description);
            ps.setString(4, dateSortie);
            ps.setString(5, duree);
            ps.setString(6, image);
            ps.setInt(7, IdCategorie);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }


    @Override
    public int update(Film film) {
        String query = "UPDATE Film SET titre=?, realisateur=?, duree=?, dateSortie=?, description=?, image=? WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, film.getTitre());
            ps.setString(2, film.getRealisateur());
            ps.setString(3, film.getDuree());
            ps.setString(4, film.getDateSortie());
            ps.setString(5, film.getDescription());
            ps.setString(6, film.getImage());
            ps.setInt(7, film.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Film WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Film getFilmById(int id) {
        String query = "SELECT * FROM Film WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Film(rs.getInt("id"), rs.getString("titre"), rs.getString("realisateur"),
                            rs.getString("description"), rs.getString("dateSortie"),
                            rs.getString("duree"), rs.getString("image"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
