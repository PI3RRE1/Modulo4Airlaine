package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VooDAO;
import model.Voo;


@WebServlet(urlPatterns = {"/voo", "/voo-save", "/voo-delete"})
public class VooController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VooDAO vdao = new VooDAO();
       
   
    public VooController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String route = request.getServletPath();
		switch(route) {
		case "/voo":
			read(request, response);
			break;
		case "/voo-save":
			save(request, response);
			break;
		case "/voo-delete":
			save(request, response);
			break;
		default:
			save(request, response);
			break;
		}
	}
protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	Voo voo = new Voo();
	voo.setAereporto(request.getParameter("aeroporto"));
	voo.setCompanhia_aerea(request.getParameter("companhia_aerea"));
	String data = request.getParameter("data_embarque");
	try {
		voo.setData_embarque(sdf.parse(data));
	} catch (Exception e) {
		// TODO: handle exception
	}
	voo.setDestino(request.getParameter("destino"));
	voo.setNumero_assento(Integer.parseInt(request.getParameter("numero_assento")));
	voo.setOrigem(request.getParameter("origem"));
	voo.setPreco(Double.parseDouble(request.getParameter("preco")));
	
	
	if (request.getParameter("id") !=null) {
		voo.setId(Integer.parseInt(request.getParameter("id")));
		vdao.update(voo);
		
	}else {
		vdao.create(voo);
	}
		
	}
protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List < Voo > voos = vdao.read();
	request.setAttribute("voos", voos);
	RequestDispatcher rd = request.getRequestDispatcher("./voo.jsp");
	rd.forward(request, response);
	
}
protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
	vdao.delete(id);
	response.sendRedirect("/voo");
	
}

}
