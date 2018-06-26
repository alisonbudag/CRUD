package br.com.crud.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.crud.bean.ProdutoBean;
import br.com.crud.dao.ProdutoDao;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ProdutoView extends JFrame {

	private JPanel contentPane;
	private JTextField txtProduto;
	private JTextField txtValor;
	private JTable tblListarProdutos;

	public ProdutoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProduto.setBounds(20, 29, 67, 20);
		contentPane.add(lblProduto);
		
		txtProduto = new JTextField();
		txtProduto.setBounds(97, 31, 202, 20);
		contentPane.add(txtProduto);
		txtProduto.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValor.setBounds(20, 60, 67, 20);
		contentPane.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(97, 62, 202, 20);
		contentPane.add(txtValor);
		
		ProdutoDao a = new ProdutoDao();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 161, 304, 176);
		contentPane.add(scrollPane);
		
		tblListarProdutos = new JTable();
		tblListarProdutos.setModel(a.listarProdutos());
		scrollPane.setViewportView(tblListarProdutos);
		
		JButton btnCadastrarProduto = new JButton("Cadastrar Produto");
		btnCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Instanciar um objeto da classe ProdutoBean
				ProdutoBean pb = new ProdutoBean();
				pb.setNomeProduto(txtProduto.getText());
				pb.setValorProduto(Double.parseDouble(txtValor.getText()));
				
				
				//Executar método do cadastro
				ProdutoDao pd = new ProdutoDao();
				pd.cadastrarProduto(pb);
				
				//Limpar Campos
				txtProduto.setText("");
				txtValor.setText("");
				txtProduto.requestFocus();
				
				//Atualizar a tabela
				tblListarProdutos.setModel(a.listarProdutos());
				
			}
		});
		btnCadastrarProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCadastrarProduto.setBounds(81, 105, 176, 31);
		contentPane.add(btnCadastrarProduto);
		
	}
}
