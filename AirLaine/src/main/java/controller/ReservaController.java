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

import dao.ClienteDAO;
import dao.ReservaDAO;
import dao.VooDAO;
import model.Reserva;


@WebServlet(urlPatterns = {"/reserva", "/reserva-save", "/reserva-delete"})
public class ReservaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReservaDAO rdao = new ReservaDAO();
	ClienteDAO cdao = new ClienteDAO();
	VooDAO vdao = new VooDAO();
       
    
    public ReservaController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String route = request.getServletPath();
		switch(route) {
		case "/reserva":
			read(request, response);
			break;
		case "/reserva-save":
			save(request, response);
			break;
		case "/reserva-delete":
			delete(request, response);
			break;
		default:
			
			break;
		}
	}
protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	Reserva reserva = new Reserva();
	reserva.setCancelado(Boolean.parseBoolean( request.getParameter("cancelado")));
	int idcliente = Integer.parseInt(request.getParameter("cliente"));
	reserva.setCliente(cdao.readById(idcliente));
	String data = request.getParameter("data");
	try {
		reserva.setData_reserva(sdf.parse(data));
	} catch (Exception e) {
		// TODO: handle exception
	}
	reserva.setNum_pessoas(Integer.parseInt(request.getParameter("num_pessoas")));
	int idvoo = Integer.parseInt(request.getParameter("voo"));
	reserva.setVoo(vdao.readById(idvoo));
	
	
	if (request.getParameter("id") !=null) {
		reserva.setId(Integer.parseInt(request.getParameter("id")));
		rdao.update(reserva);
		
	}else {
		rdao.create(reserva);
	}
	response.sendRedirect("./reserva-save");
	}
protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List < Reserva > reservas = rdao.read();
	request.setAttribute("reservas", reservas);
	RequestDispatcher rd = request.getRequestDispatcher("./reserva.jsp");
	rd.forward(request, response);
	
}
protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
	rdao.delete(id);
	response.sendRedirect("./reserva");
	
}

}
