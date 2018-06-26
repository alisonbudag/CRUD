package br.com.crud.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.crud.dao.ProdutoDao;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarProdutoView extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtProduto;
	private JTextField txtValor;

	public AlterarProdutoView(int idProduto) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 313, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigo.setBounds(10, 11, 67, 20);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setText(String.valueOf(idProduto));
		txtCodigo.setEnabled(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(87, 13, 202, 20);
		contentPane.add(txtCodigo);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProduto.setBounds(10, 42, 67, 20);
		contentPane.add(lblProduto);
		
		txtProduto = new JTextField();
		txtProduto.setColumns(10);
		txtProduto.setBounds(87, 44, 202, 20);
		contentPane.add(txtProduto);
		
		JButton btnAlterarProduto = new JButton("Alterar Produto");
		btnAlterarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAlterarProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAlterarProduto.setBounds(63, 106, 176, 31);
		contentPane.add(btnAlterarProduto);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(87, 75, 202, 20);
		contentPane.add(txtValor);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValor.setBounds(10, 73, 67, 20);
		contentPane.add(lblValor);
		
		JButton btnExcluirProduto = new JButton("Excluir Produto");
		btnExcluirProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Chamar o método para excluir
				ProdutoDao pd = new ProdutoDao();
				pd.excluirProduto(idProduto);
				
				//Fechar o JFrame
				dispose();
				
				//Chamar o outro JFrame
				ProdutoView pv = new ProdutoView();
				pv.setVisible(true);
				
			}
		});
		btnExcluirProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExcluirProduto.setBounds(63, 148, 176, 31);
		contentPane.add(btnExcluirProduto);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ProdutoView a = new ProdutoView();
				a.setVisible(true);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(63, 190, 176, 31);
		contentPane.add(btnCancelar);
	}

}
