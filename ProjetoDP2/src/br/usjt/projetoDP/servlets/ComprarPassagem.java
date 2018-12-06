package br.usjt.projetoDP.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.projetoDP.dao.VooDAO;
import br.usjt.projetoDP.model.Voo;


@WebServlet(name = "ComprarPassagem.do", urlPatterns = { "/ComprarPassagem.do" })
public class ComprarPassagem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ComprarPassagem() {
    	
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			VooDAO dao = new VooDAO();
			List<Voo> voos = dao.listarDestinos();
			
			if (!voos.isEmpty()) {
				
				int totalEventos = voos.size();
				int index = 1;
				String  datas = "[";
				
				for (Voo voo : voos) {
					datas += "{ \"destino\": \""+voo.getDestino()+"\", \"origem\":\""+voo.getOrigem()+"\" }";
					
					if (index < totalEventos){
						datas += ",";
					}
					
					index++;
				}
				
				datas += "]";
				
				response.setStatus(200);
				response.getWriter().write(datas);
				
				//RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
				//request.setAttribute("listaDestino", voo);
				//view.forward(request, response);
			}
			
			
		
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			
			
			String dtPartida = formataDataPadrao(request.getParameter("dataPartida"));
			String dtRetorno = formataDataPadrao(request.getParameter("dataRetorno"));
			String origem 	 = request.getParameter("selectOrigem");
			String destino 	 = request.getParameter("selectDestino");
			
			System.out.println(dtPartida);
			System.out.println(dtRetorno);
			System.out.println(origem);
			System.out.println(destino);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	private String formataDataPadrao(String data) {
		
		String dt = data.replaceAll("/", "-");
		String[] arraDT  = dt.split("-");
		String novaData = arraDT[2]+"-"+arraDT[1]+"-"+arraDT[0];
		
		return novaData;
	}
}
