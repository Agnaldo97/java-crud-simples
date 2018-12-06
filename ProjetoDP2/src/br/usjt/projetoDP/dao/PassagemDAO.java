package br.usjt.projetoDP.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.usjt.projetoDP.connection.SingleConnection;
import br.usjt.projetoDP.model.Cliente;
import br.usjt.projetoDP.model.Passagem;
import br.usjt.projetoDP.model.Voo;

public class PassagemDAO {
	
		
	private Connection connection;

	public PassagemDAO() {

		connection = SingleConnection.getConnection();

	}

	public boolean adicionarPassagem(Passagem passagem) {


		try {

			Cliente pg = passagem.getCliente();
			Voo voo = passagem.getVoo();
			String sql = "insert into passagem (fileira, poltrona, formaPagamento, parcelasPagamento, id_voo, cpf_cliente) values (?,?,?,?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			

			insert.setInt(1, passagem.getFileiras());
			insert.setString(2, String.valueOf(passagem.getPoltrona()));
			insert.setString(3, passagem.getFormaPagamento());
			insert.setInt(4, passagem.getParcelasPagamento());
			insert.setLong(5, voo.getId());
			insert.setString(6, pg.getCpf());
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
			
			return false;
		}
	}

	public List<Passagem> listar(String cpf) throws Exception {

		List<Passagem> list = new ArrayList<Passagem>();
		ClienteDAO dao = new ClienteDAO();
		Voo voo = new Voo();

		String sql = "select * from  passagem where cpf_cliente =" + cpf;
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) {

			Passagem passagem = new Passagem();
			passagem.setId(resultado.getLong("id"));
			passagem.setFileiras(resultado.getInt("fileira"));
			passagem.setPoltrona(resultado.getString("poltrona").charAt(0));
			passagem.setFormaPagamento(resultado.getString("formaPagamento"));
			passagem.setParcelasPagamento(resultado.getInt("parcelasPagamento"));
			//passagem.setCliente(resultado.c);

			list.add(passagem);
		}

		return list;
	}
}
