package br.usjt.projetoDP.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.usjt.projetoDP.connection.SingleConnection;
import br.usjt.projetoDP.model.Voo;

public class VooDAO {
	
	private Connection connection;

	public VooDAO() {

		connection = SingleConnection.getConnection();
	}
	
	public List<Voo> listarDestinos() throws Exception {
		
		List<Voo> list = new ArrayList<Voo>();
		

		String sql = "select distinct origem, destino from voo";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) {
			Voo voo = new Voo();
			voo.setOrigem(resultado.getString("origem"));
			voo.setDestino(resultado.getString("destino"));

			list.add(voo);
		}

		return list;
	}
}
