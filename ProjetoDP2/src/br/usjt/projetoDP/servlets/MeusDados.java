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
import br.usjt.projetoDP.model.Cliente;

@WebServlet(name = "MeusDados.do", urlPatterns = { "/MeusDados.do" })
public class MeusDados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MeusDados() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		doPost(request, response);
		
		// try {
			
		// 	PassagemDAO passagemDAO = new PassagemDAO();
		// 	String cpf = "00000000000";
		// 	List<Passagem> passagens = passagemDAO.listar(cpf);
		// 	String data = "";
		// 	int totalUsuarios = passagens.size();
		// 	int index = 1;
			
			
		// 	if (!passagens.isEmpty()) {
								
				
		// 		for (Passagem passagem : passagens) {
					 
		// 			data +=  " ["+
		// 			      "\""+ passagem.getId()				+"\", "+
		// 			      "\""+ passagem.getFileiras()		    +"\","+
		// 			      "\""+ passagem.getPoltrona()		    +"\","+
		// 			      "\""+ passagem.getFormaPagamento()	+"\","+
		// 			      "\""+ passagem.getParcelasPagamento() +"\""+
		// 			    "]";
					
		// 			if (index < totalUsuarios){
						
		// 				data += ",";
		// 			}
					
		// 			index++;
		// 		}
				
		// 		String json = "{"+
		// 						  "\"draw\": 1,"+
		// 						  "\"recordsTotal\": "+passagens.size()+","+
		// 						  "\"recordsFiltered\": "+passagens.size()+","+
		// 						  "\"data\": ["+data+"]"+ // fechamento do data
		// 						"}";// fechamento do json
				 
				
		// 		response.setStatus(200); //resposta OK Sucesso
				
		// 		// json de resposta - escreve a resposta http
		// 		response.getWriter().write(json);
		// 	}
			
		// } catch (Exception e) {
					
		// 	e.printStackTrace();
		// }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("Meus Dados (post)");
		
		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = new Cliente();
		
		try {
			
			// pega usuario logado na sessão
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			cliente = (Cliente)session.getAttribute("usuario");
			
			RequestDispatcher view = request.getRequestDispatcher("/meusDados.jsp");
			request.setAttribute("dadosCliente", dao.listar(cliente.getCpf()));
			view.forward(request, response);
			
 		} catch (Exception e) {
			
			//TODO: handle exception
			e.printStackTrace();
		}
	}

}
