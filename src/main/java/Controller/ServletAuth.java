package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.entities.User;
import modele.metier.ModeleAuth;
import Dao.DaoAuth;

import java.io.IOException;
@WebServlet("/ServletAuth")
public class ServletAuth extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ModeleAuth modeleAuth = new ModeleAuth();
    private DaoAuth dao;

    public void init() {
        this.dao = new DaoAuth();
    }

    public ServletAuth() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean isAuthenticated = modeleAuth.auth(email,password);

        if (isAuthenticated) {
            response.sendRedirect("ServletListSalle");
        } else {
            response.sendRedirect("login.jsp?error=1");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the login page by default
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
