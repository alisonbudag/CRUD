package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.crud.bean.ProdutoBean;
import br.com.crud.connection.ConnectionFactory;

public class ProdutoDao {
	
	//Atributo contendo a conexão
	private Connection conexao;
	
	//Construtor
	public ProdutoDao(){
		
		//Instanciar um objeto da classe ConnectionFactory
		
		ConnectionFactory cf = new ConnectionFactory();
		conexao = cf.obterConexao();
		
	}
	
	//Método para cadastrar um produto
	public void cadastrarProduto(ProdutoBean obj){
		
		//SQL
		String sql = "INSERT INTO produtos (nomeProduto, valorProduto) VALUES (?, ?)";
		
		//Tentar realizar o cadastro
		try{
			
			//Preparar o envio dos parâmetros
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, obj.getNomeProduto());
			pstmt.setDouble(2, obj.getValorProduto());
			
			//Executar o comando
			pstmt.execute();
			
			//Finalizar a conexão
			pstmt.close();
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Falha ao cadastrar, erro: "+e.getMessage());
		}
		
	}
	
	//Método para listar os produtos
	public DefaultTableModel listarProdutos(){
		
		DefaultTableModel modelo = new DefaultTableModel();
		
		modelo.addColumn("Código");
		modelo.addColumn("Produto");
		modelo.addColumn("Valor");
		
		return modelo;
		
	}

}
