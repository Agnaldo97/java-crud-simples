package br.usjt.projetoDP.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.projetoDP.dao.ClienteDAO;
import br.usjt.projetoDP.model.Cliente;

@WebServlet(name = "AlterarSenha.do", urlPatterns = { "/AlterarSenha.do" })
public class AlterarSenha extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public AlterarSenha() {
    	
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			ClienteDAO dao = new ClienteDAO();
			Cliente cliente = new Cliente();
			
			
			String login = request.getParameter("usuario");
			String senha = request.getParameter("senha");
			
			cliente.setCpf(login);
			cliente.setSenha(senha);
			
			if (dao.alterarSenha(cliente)) {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
				
				
			} else {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/alterarSenha.jsp");
				dispatcher.forward(request, response);				
			}
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}
}
