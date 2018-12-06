package br.usjt.projetoDP.filter;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.usjt.projetoDP.connection.SingleConnection;
import br.usjt.projetoDP.model.Cliente;


@WebFilter(urlPatterns= {"/minhasPassagens.jsp", "/meusDados.jsp"})
public class FilterAutenticacao implements Filter{

	private static Connection connection;
	
	// faz alguma coisa quando a aplicação é derrubada
	@Override
	public void destroy() {
		
	}

	// intercepta todas a requisições
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		String urlPage = req.getServletPath();
		
		// retorna null caso nao estaja logado
		Cliente clienteLogado = (Cliente) session.getAttribute("usuario");
		
		System.out.println(clienteLogado);
		
		if (clienteLogado == null) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp?url="+urlPage);
			dispatcher.forward(request, response);
			return;			
		}
		
		//executa as ações do request e response
		chain.doFilter(request, response);
	}

	// executa alguma coisa quando a aplicação é iniciada
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	
		connection = SingleConnection.getConnection();
		
	}
}
