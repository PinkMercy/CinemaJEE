package modele.metier;

import Dao.DaoFilm;
import Dao.DaoSalleCinema;
import Dao.IDaoFilm;
import Dao.IDaoSalleCinema;
import modele.entities.Film;
import modele.entities.SalleCinema;

import java.util.List;

public class ModeleFilm {
    private Film film;

    private IDaoFilm DaoFilm=new DaoFilm();

    public List<Film> getAllFilms(){
        return DaoFilm.getAllFilms();
    }

    public Film addFilm(Film film) {
//        Film f=null;
        this.DaoFilm.addFilm(film.getTitre(), film.getRealisateur(), film.getDuree(), film.getDateSortie(), film.getDescription(),film.getImage() , film.getIdCategorie());
        return film;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film f) {
        this.film = f;
    }

}
