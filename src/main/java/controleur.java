

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class controleur
 */
@WebServlet("/controleur")
public class controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String motCle = request.getParameter("motCle");
		CatalogueImpl metier= new CatalogueImpl();
		List<Produit> prods = metier.getProduitsParMotCle(motCle);
		ProduitModele produitModel = new ProduitModele();
		produitModel.setMotCle(motCle);
		produitModel.setProduits(prods);
		
		request.setAttribute("modele", produitModel);
		request.getRequestDispatcher("ProduitsView.jsp").forward(request, response);
	}

}
