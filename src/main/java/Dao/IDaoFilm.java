package Dao;

import modele.entities.Film;
import modele.entities.SalleCinema;

import java.util.List;

public interface IDaoFilm {
    public List<Film> getAllFilms();

    public Film addFilm(String titre, String realisateur, String duree, String dateSortie, String description, String image , int IdCategorie);

    public int update(Film film);

    public void delete(int id);

}
