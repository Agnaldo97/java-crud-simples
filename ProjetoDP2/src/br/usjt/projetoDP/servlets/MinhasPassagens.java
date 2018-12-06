package br.usjt.projetoDP.servlets;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import br.usjt.projetoDP.dao.PassagemDAO;
import br.usjt.projetoDP.model.Cliente;
import br.usjt.projetoDP.model.Passagem;


@WebServlet(name = "MinhasPassagens.do", urlPatterns = { "/MinhasPassagens.do" })
public class MinhasPassagens extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MinhasPassagens() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("passagens");
		
		try {
			
			PassagemDAO passagemDAO = new PassagemDAO();
			String cpf = "00000000000";
			List<Passagem> passagens = passagemDAO.listar(cpf);
			String data = "";
			int totalUsuarios = passagens.size();
			int index = 1;
			
			
			if (!passagens.isEmpty()) {
								
				
				for (Passagem passagem : passagens) {
					 
					data +=  " ["+
					      "\""+ passagem.getId()				+"\", "+
					      "\""+ passagem.getFileiras()		    +"\","+
					      "\""+ passagem.getPoltrona()		    +"\","+
					      "\""+ passagem.getFormaPagamento()	+"\","+
					      "\""+ passagem.getParcelasPagamento() +"\""+
					    "]";
					
					if (index < totalUsuarios){
						
						data += ",";
					}
					
					index++;
				}
				
				String json = "{"+
								  "\"draw\": 1,"+
								  "\"recordsTotal\": "+passagens.size()+","+
								  "\"recordsFiltered\": "+passagens.size()+","+
								  "\"data\": ["+data+"]"+ // fechamento do data
								"}";// fechamento do json
				 
				
				response.setStatus(200); //resposta OK Sucesso
				
				// json de resposta - escreve a resposta http
				response.getWriter().write(json);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		System.out.println("Minhas Passagens (post)");
		
		try {
			
			PassagemDAO passagemDAO = new PassagemDAO();
			Cliente cliente = new Cliente();
			
			// pega usuario logado na sessão
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			cliente = (Cliente)session.getAttribute("usuario");			
			
			// direciona para  a jsp
			RequestDispatcher view = request.getRequestDispatcher("/minhasPassagens.jsp");

			// busca as passagens compradas
			request.setAttribute("passagensCompradas", passagemDAO.listar(cliente.getCpf()));
			
			view.forward(request, response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
