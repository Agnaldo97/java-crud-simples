package br.usjt.projetoDP.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.usjt.projetoDP.connection.SingleConnection;
import br.usjt.projetoDP.model.Cliente;

public class ClienteDAO {
	
	private Connection connection;

	// garante que sempre que a class for chamada abra a conexao com o banco
	public ClienteDAO() {

		connection = SingleConnection.getConnection();

	}
	
	// metodo que faz um insert na tabela cliente 
	public boolean cadastrar(Cliente cliente) {

		try {

			String sql = "insert into cliente (cpf, nome, telefone, endereco, cidade, estado, rg, senha, email) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);

			insert.setString(1, cliente.getCpf());
			insert.setString(2, cliente.getNome());
			insert.setString(3, cliente.getTelefone());
			insert.setString(4, cliente.getEndereco());
			insert.setString(5, cliente.getCidade());
			insert.setString(6, cliente.getEstado());
			insert.setString(7, cliente.getRg());
			insert.setString(8, cliente.getSenha());
			insert.setString(9, cliente.getEmail());
			insert.execute();
			connection.commit(); // salva no banco
			
			return true;

		} catch (Exception e) {

			try {

				connection.rollback(); // reverte operação

			} catch (SQLException e1) {

				e1.printStackTrace();

			}
			
			e.printStackTrace();
		}
		
		return false;
	}

	// altera os dados do cliente
	public boolean alterarDados(Cliente cliente) {
		
		try {
			
			String sql = "update cliente set nome=?, telefone=?, endereco=?, cidade=?, estado=?, rg=?, email=? where cpf="+ cliente.getCpf()+";";
			PreparedStatement update = connection.prepareStatement(sql);
			
			update.setString(1, cliente.getNome());
			update.setString(2, cliente.getTelefone());
			update.setString(3, cliente.getEndereco());
			update.setString(4, cliente.getCidade());
			update.setString(5, cliente.getEstado());
			update.setString(6, cliente.getRg());
			update.setString(7, cliente.getEmail());
			
			update.execute();
			connection.commit(); // salva no banco
			
			return true;
			
		} catch (Exception e) {
			
			try {
				
				connection.rollback(); // reverte operação

			} catch (SQLException e1) {

				e1.printStackTrace();

			}
			
			e.printStackTrace();

			return false;
		}		
	}
	
	// altera senha do cliente
	public boolean alterarSenha(Cliente cliente) {
		
		try {
			
			String sql = "update cliente set senha=? where cpf='"+ cliente.getCpf()+"'";
			PreparedStatement update = connection.prepareStatement(sql);
			
			update.setString(1, cliente.getSenha());
			update.execute();
			
			connection.commit();
			
			return true;
			
		} catch (Exception e) {
			
			try {
				
				connection.rollback(); // reverte operação

			} catch (SQLException e1) {

				e1.printStackTrace();

			}

			return false;
		}
	}
	
	public boolean validarLogin(String login, String senha) throws Exception{
		
		String sql = "select * from cliente where cpf='" + login + "' and senha='" + senha + "'";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {

			return true; // possui usuário
			
		} else {

			return false; // não validou usuário
		}		
	}
	
	public List<Cliente> listar(String cpf) throws Exception {

		List<Cliente> list = new ArrayList<Cliente>();

		String sql = "select * from cliente where cpf =" + cpf;
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) {

			Cliente cliente = new Cliente();
			cliente.setCpf(resultado.getString("cpf"));
			cliente.setNome(resultado.getString("nome"));
			cliente.setTelefone(resultado.getString("telefone"));
			cliente.setEstado(resultado.getString("estado"));
			cliente.setCidade(resultado.getString("cidade"));
			cliente.setEndereco(resultado.getString("endereco"));
			cliente.setRg(resultado.getString("rg"));
			cliente.setEmail(resultado.getString("email"));

			list.add(cliente);
		}

		return list;
	}
}
