package Telas;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Acoes.AcessoLogin;
import Acoes.SGFuncionario;

public class Login extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JButton btlogin;
	private JTextField txtusuario;
	private JPasswordField txtsenha;
	private JLabel lblfundotela, lblogin, lblsenha;
	private Font letra;
	private String nome;
	
	public Login () {
		
		//Definições da tela
		setTitle ("Login - T-Shirt Games Desktop");
		setFont(letra);
		setSize (1024,700);
		setLocation (180, 2); 
		setResizable (false); 
		setBackground (new Color (255,250,200));
		Color Fundo = new Color (240,240,240); 
		getContentPane (). setBackground(Fundo);
		setLayout (null);
		dispose();
		
		//Definições de fonte
		letra = new Font("Arial", Font.PLAIN,18);

		//Título do Login		
		lblogin = new JLabel();
		lblogin.setText("Login");
		lblogin.setBounds(300,340,100,50);
		lblogin.setFont(new Font("Verdana", Font.BOLD,20));
		this.add(lblogin);

		//Campo para digitar login 
		txtusuario = new JTextField();
		txtusuario.setText("Digite o usuario");
		txtusuario.setFont(new Font("Verdana", Font.BOLD,12));
		txtusuario.setForeground(new Color (169,169,169));
		txtusuario.setBounds(385,350,250,30);
		this.add(txtusuario);

		//Limpar o campo para digitar o login
		txtusuario.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){

				if (txtusuario.getText().equals("Digite o usuario")){
					txtusuario.setText("");
					txtusuario.setForeground(new Color (0,0,0));
				}
			}
			public void mouseExited(MouseEvent e){

				if (txtusuario.getText().equals("")){
					txtusuario.setText("Digite o usuario");
					txtusuario.setForeground(new Color (169,169,169));
				}
			}
			public void mouseClicked(MouseEvent e) {

				txtusuario.setForeground(new Color (0,0,0));
			}
		});

		txtusuario.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				if (txtusuario.getText().equals("Digite o usuario")) {
					txtusuario.setText("");
					txtusuario.setForeground(new Color (0,0,0));
				}
			}
		});

		//Título da senha
		lblsenha = new JLabel();
		lblsenha.setText("Senha");
		lblsenha.setBounds(300,380,100,50);
		lblsenha.setFont(new Font("Verdana", Font.BOLD,20));
		this.add(lblsenha);

		//Campo para digitar senha
		txtsenha = new JPasswordField();
		txtsenha.setText("12345678");
		txtsenha.setFont(new Font("Verdana", Font.BOLD,12));
		txtsenha.setForeground(new Color (169,169,169));
		txtsenha.setBounds(385,390,250,30);
		this.add(txtsenha);

		//Limpar o campo para digitar a senha
		txtsenha.addMouseListener(new MouseAdapter(){
			@SuppressWarnings("deprecation")
			public void mouseEntered(MouseEvent e){

				if (txtsenha.getText().equals("12345678")){
					txtsenha.setText("");
					txtsenha.setForeground(new Color (0,0,0));
				}
			}
			@SuppressWarnings("deprecation")
			public void mouseExited(MouseEvent e){

				if (txtsenha.getText().equals("")){
					txtsenha.setText("12345678");
					txtsenha.setForeground(new Color (169,169,169));
				}
			}
			public void mouseClicked(MouseEvent e) {
				txtsenha.setForeground(new Color (0,0,0));
			}
		});

		txtsenha.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			public void keyPressed(KeyEvent e) {

				if (txtsenha.getText().equals("12345678")) {
					txtsenha.setText("");
					txtsenha.setForeground(new Color (0,0,0));
				}
			}
		});

		//Botão para logar    
		btlogin = new JButton();
		btlogin.setBounds(450,450,120,40);
		btlogin.setText("Entrar");
		btlogin.setFont(new Font("Verdana", Font.BOLD,16));
		btlogin.setBackground(new Color (0,0,0));
		btlogin.setForeground(new Color (255,255,255));
		this.add(btlogin);

		btlogin.addActionListener(new ActionListener () {
			@SuppressWarnings({ "deprecation", "static-access" })
			public void actionPerformed(ActionEvent arg0){
				
				AcessoLogin consulta = new AcessoLogin();
				consulta.Login(txtusuario.getText(), txtsenha.getText(), "Ativo");

				if(consulta.acesso == true) {
					
					AcessoLogin cdao = new AcessoLogin();
					SGFuncionario pro = new SGFuncionario();
					pro = cdao.RetornaNome(nome, txtusuario.getText());
					
					JOptionPane.showMessageDialog(null, "Bem Vindo " + nome.valueOf(pro.getNome()));
					Home principal = new Home();
					principal.setVisible(true);
					dispose();					
				}				
				
				if(consulta.acesso == false){
					
					AcessoLogin consultaMaster = new AcessoLogin();
					consultaMaster.Master(txtusuario.getText(), txtsenha.getText());
					
					if(consultaMaster.acesso == true) {
						JOptionPane.showMessageDialog(null, "Bem Vindo usuário Master!");
						Home principal = new Home();
						principal.setVisible(true);
						dispose();
					}
					if(consultaMaster.acesso == false) {
						JOptionPane.showMessageDialog(null, "O usuário ou a senha esta incorreto! Verifique se foi digitado corretamente ou o usuário foi desabilitado para acessar o sistema, Por favor, entre em contato com o Administrador.");
						txtusuario.setText("");
						txtsenha.setText("");
						txtusuario.requestFocus();
					}
					consultaMaster.acesso = false;
				}
				consulta.acesso = false;
			}
		});
		
		//Imagem de fundo
		lblfundotela = new JLabel(new ImageIcon("src/Imagens/login.gif"));
		lblfundotela.setBounds (0,0,1024,680);
		this.add(lblfundotela);
	}
	
	public static void main(String[] args) {
		new Login().setVisible(true);
	}
}
