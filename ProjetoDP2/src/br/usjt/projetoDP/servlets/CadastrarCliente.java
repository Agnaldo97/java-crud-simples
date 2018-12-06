package br.usjt.projetoDP.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.projetoDP.dao.ClienteDAO;
import br.usjt.projetoDP.model.Cliente;


@WebServlet(name = "CadastrarCliente.do", urlPatterns = { "/CadastrarCliente.do" })
public class CadastrarCliente extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public CadastrarCliente() {
    	
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			ClienteDAO dao = new ClienteDAO();
			Cliente cliente = new Cliente();
			
			String cpf 		= request.getParameter("cpf");
			String nome 	= request.getParameter("nome");
			String telefone = request.getParameter("telefone");
			String endereco = request.getParameter("endereco");
			String cidade   = request.getParameter("cidade");
			String estado   = request.getParameter("estado");
			String rg		= request.getParameter("rg");
			String senha	= request.getParameter("senha");
			String email	= request.getParameter("email");
			
			if
			(
				cpf.isEmpty() 	   ||
				nome.isEmpty() 	   ||
				telefone.isEmpty() ||
				endereco.isEmpty() ||
				cidade.isEmpty()   ||
				estado.isEmpty()   ||
				rg.isEmpty() 	   ||
				senha.isEmpty()    ||
				email.isEmpty()
			) 
			{				
				response.setStatus(500);
				
			} else {
				
				cliente.setCpf(cpf);
				cliente.setNome(nome);
				cliente.setTelefone(telefone);
				cliente.setEndereco(endereco);
				cliente.setCidade(cidade);
				cliente.setEstado(estado);
				cliente.setRg(rg);
				cliente.setSenha(senha);
				cliente.setEmail(email);
			}
			
			
			if (dao.cadastrar(cliente)) {
				
				response.setStatus(200);
				response.getWriter().write("200");
				
			}			
		} catch (Exception e) {
		
			response.setStatus(500);
			e.printStackTrace();
		} 
	}
}
