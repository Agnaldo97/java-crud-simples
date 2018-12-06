package teste;

import br.usjt.projetoDP.dao.ClienteDAO;
import br.usjt.projetoDP.dao.PassagemDAO;
import br.usjt.projetoDP.model.Cliente;
import br.usjt.projetoDP.model.Passagem;
import br.usjt.projetoDP.model.Voo;

import org.junit.Test;


public class TesteBanco {

	@Test
	public void initBanco() {
		
		try {
			
			Passagem passagem = new Passagem();
			PassagemDAO passagemDAO = new PassagemDAO();
			Cliente cliente = new Cliente();
			Voo voo = new Voo();
			
			voo.setId(1);
			cliente.setCpf("11111111111");
			
			passagem.setFileiras(2);
			passagem.setPoltrona('W');
			passagem.setFormaPagamento("Débito");
			passagem.setParcelasPagamento(1);
			passagem.setVoo(voo);
			passagem.setCliente(cliente);
			
			
			passagemDAO.adicionarPassagem(passagem);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void cadastrar() {
		
		try {
			
			System.out.println("Cadastrar");
			
			ClienteDAO dao = new ClienteDAO();
			Cliente cliente = new Cliente();
			cliente.setCpf("11111111111");
			cliente.setNome("admin");
			cliente.setTelefone("1-1111-1111");
			cliente.setEndereco("rua teste 2");
			cliente.setCidade("Santo André");
			cliente.setEstado("SP");
			cliente.setRg("111111111");
			cliente.setSenha("teste");
			cliente.setEmail("teste@test");
			
			dao.cadastrar(cliente);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void dados() {
		
		try {
			
			System.out.println("update");
			
			ClienteDAO dao = new ClienteDAO();
			Cliente cliente = new Cliente();
			
			cliente.setCpf("11111111111");
			cliente.setNome("teste");
			cliente.setTelefone("1-1111-1111");
			cliente.setEndereco("rua teste 2");
			cliente.setCidade("Santo André");
			cliente.setEstado("SP");
			cliente.setRg("111111111");
			cliente.setEmail("teste@test");
			
			dao.alterarDados(cliente);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void senha() {
		
		try {
			
			System.out.println("update");
			
			ClienteDAO dao = new ClienteDAO();
			Cliente cliente = new Cliente();
			
			cliente.setCpf("11111111111");
			cliente.setSenha("admin");
			
			dao.alterarSenha(cliente);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void initBuscar() {
		
		ClienteDAO dao = new ClienteDAO();
		
		try {
			
			if(dao.validarLogin("00000000000", "admin")) {
				System.out.println("ok");
			}	
			
			
		} catch (Exception e) {

			e.printStackTrace();
		
		}
	}
}
