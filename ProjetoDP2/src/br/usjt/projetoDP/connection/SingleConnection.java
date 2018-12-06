package br.usjt.projetoDP.connection;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.SQLException;

public class SingleConnection {
	
	// dados para a conexao com o banco de dados
	private static String url = "jdbc:mysql://localhost/flighthigh";
	private static String password = "admin";
	private static String user = "root";
	private static Connection connection = null;
	
	
	static {
		
		conectar();
		
	}
 
	// garante que sempre que a class SingleConnection for chamada abra a conexao com o banco de dados
	public SingleConnection() {
		
		conectar();
		
	}
	
	// metodo que faz qa conexão com o banco
	private static void conectar() {
		
		try {
			
			if (connection == null) {
				
				Class.forName("org.gjt.mm.mysql.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
				System.out.println("Conectou com Sucesso");
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	// metodo que retorna a conexao com o banco de dados
	public static Connection getConnection() {
		return connection;
	}	
}
