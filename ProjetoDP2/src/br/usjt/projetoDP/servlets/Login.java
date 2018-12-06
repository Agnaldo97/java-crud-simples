package br.usjt.projetoDP.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.projetoDP.dao.ClienteDAO;
import br.usjt.projetoDP.dao.PassagemDAO;
import br.usjt.projetoDP.model.Cliente;

@WebServlet(name = "Login.do", urlPatterns = { "/Login.do" })
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ClienteDAO dao = new ClienteDAO();
       
    public Login() {
    	
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (Boolean.parseBoolean(request.getParameter("deslogar"))) {
			
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String login = request.getParameter("usuario");
			String senha = request.getParameter("senha");
			String url = request.getParameter("url");
			
			if (dao.validarLogin(login, senha)) {
				
				PassagemDAO passagemDAO = new PassagemDAO();
				
				Cliente cliente = new Cliente();
				cliente.setCpf(login);
				cliente.setSenha(senha);

				// adiciona usuario logado na sessão
				HttpServletRequest req = (HttpServletRequest) request;
				HttpSession session = req.getSession();
				session.setAttribute("usuario", cliente);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
				
				//request.setAttribute("passagens", passagemDAO.listar(login));
				
				dispatcher.forward(request, response);
				
			} else {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");				
				dispatcher.forward(request, response);				
			}
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}
}
