package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.entities.Film;
import modele.metier.ModeleFilm;

import java.io.IOException;
import java.util.List;

import Dao.DaoFilm;


@WebServlet("/ServletFilm")
public class ServletFilm extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ModeleFilm modeleFilm = new ModeleFilm();
    private DaoFilm dao;

    public void init() {
        this.dao = new DaoFilm();
    }

    public ServletFilm() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titre = request.getParameter("titre");
        String realisateur = request.getParameter("realisateur");
        String action = request.getParameter("action");
        Film film = new Film();
        if(titre != null) film.setTitre(titre);
        if(realisateur != null) film.setRealisateur(realisateur);
        if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
             titre = request.getParameter("titre");
             realisateur = request.getParameter("realisateur");
            String description = request.getParameter("description");
            String dateSortie = request.getParameter("dateSortie");
            String duree = request.getParameter("duree");
            String image = request.getParameter("image");
            film = new Film(id, titre, realisateur, description, dateSortie, duree, image);
            dao.update(film);
            response.sendRedirect("ServletFilm");
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.delete(id);
            response.sendRedirect("ServletFilm");
        } else if ("add".equals(action)) {
             titre = request.getParameter("titre");
             realisateur = request.getParameter("realisateur");
            String description = request.getParameter("description");
            String dateSortie = request.getParameter("dateSortie");
            String duree = request.getParameter("duree");
            String image = request.getParameter("image");
            int IdCategorie = Integer.parseInt(request.getParameter("IdCategorie"));
            film = new Film(0, titre, realisateur, description, dateSortie, duree, image, IdCategorie);
            modeleFilm.addFilm(film);
            response.sendRedirect("ServletFilm");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            Film film = dao.getFilmById(id);
            request.setAttribute("film", film);
            request.getRequestDispatcher("ModifierFilm.jsp").forward(request, response);
        } else {
            List<Film> list;
            list = dao.getAllFilms();
            request.setAttribute("list", list);
            request.getRequestDispatcher("ListFilms.jsp").forward(request, response);
        }
    }
}
