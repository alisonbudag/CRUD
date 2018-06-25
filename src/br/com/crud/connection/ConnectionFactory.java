package br.com.crud.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionFactory {
	
	//Constante para acessar o Banco de Dados
	private final String url = "jdbc:mysql://localhost:3306/crud";
	private final String user = "root";
	private final String password = "proway";
	
	//Método para retornar a conexão com o DB
	public Connection obterConexao(){
			
		//Variável para retornar conexão
		Connection conexao = null;
		
		//Realizar a conexão
		try{
			conexao = DriverManager.getConnection(url, user, password);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Falha: "+e.getMessage());
			throw new RuntimeException(e);
		}
		
		//Retorno
		return conexao;
		
	}
	
}
