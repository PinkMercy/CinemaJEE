package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.entities.SalleCinema;
import modele.metier.ModeleSalleCinema;

import java.io.IOException;
import java.util.List;

import Dao.DaoSalleCinema;


public class ServletListSalle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ModeleSalleCinema modeleSalle=new ModeleSalleCinema();
       private DaoSalleCinema dao;
       public void init() {
    	   this.dao=new DaoSalleCinema();
       }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListSalle() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    String action = request.getParameter("action");
    if (action.equals("update")) {
        int id = Integer.parseInt(request.getParameter("id"));
        String nomSalle = request.getParameter("nom");
        int capacite = Integer.parseInt(request.getParameter("capacite"));
        String adresse = request.getParameter("adresse");
        SalleCinema salle = new SalleCinema();
        salle.setId(id);
        salle.setNom(nomSalle);
        salle.setCapacite(capacite);
        salle.setAdresse(adresse);
        dao.update(salle);
        response.sendRedirect("ServletListSalle");
    } else if (action.equals("delete") ) {
    	int id = Integer.parseInt(request.getParameter("id"));
        dao.delete(id);
        response.sendRedirect("ServletListSalle");
    }else if(action.equals("add")){
    	String nom=request.getParameter("nom");
		String adresse=request.getParameter("adresse");
		int capacite=Integer.parseInt(request.getParameter("capacite"));
		this.modeleSalle.setSalle(new SalleCinema(0,nom,adresse,capacite));
		this.modeleSalle.addSalle();
		response.sendRedirect("ServletListSalle");
    }
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String idStr = request.getParameter("id");
    if (idStr != null && !idStr.isEmpty()) {
        int id = Integer.parseInt(idStr);
        SalleCinema salle = dao.getSalleById(id);
        System.out.println("Salle récupérée : " + salle);
        request.setAttribute("salle", salle);
        request.getRequestDispatcher("ModifierSalle.jsp").forward(request, response);
        return; 
    }
    
    
    List<SalleCinema> list;
    list = dao.getAllSalles();
    
    request.setAttribute("list", list);
    request.getRequestDispatcher("ListSalles.jsp").forward(request, response);
    
    
}


}
