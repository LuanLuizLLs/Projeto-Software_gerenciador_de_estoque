package Telas;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Home extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JButton consultafunc, cadastrofunc, consultaprod, cadastroprod, vendaprod, btnLogoff;
	private JLabel l1, fundo;
	
	public Home() {
		
		setBounds(180, 2, 1028, 748);
		setResizable(false);
		setTitle("Home");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		btnLogoff = new JButton("LOGOFF");
		btnLogoff.setForeground(Color.WHITE);
		btnLogoff.setContentAreaFilled(false);
		btnLogoff.setBorderPainted(false);
		btnLogoff.setSelectedIcon(null);
		btnLogoff.setFocusPainted(false);
		btnLogoff.setIcon(null);
		btnLogoff.setBounds(911, 32, 111, 36);
		this.add(btnLogoff);
		btnLogoff.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				//Esta com o mouse sobre o botão
				btnLogoff.setBorderPainted(true);
			}
			
			public void mouseExited(MouseEvent e) {
				//Saiu com o mouse de cima do botão
				btnLogoff.setBorderPainted(false);
			}
			
			public void mouseClicked(MouseEvent e) {
				Frame[] TelasAbertas = Frame.getFrames();
				
			    for (Frame telas : TelasAbertas){
			    telas.dispose();}
			    
			    Login login = new Login();
			    login.setVisible(true);
			}
		});
				
		consultafunc = new JButton();
		consultafunc.setSize(235,95);
		consultafunc.setLocation(497,330);
		consultafunc.setOpaque(false);
		consultafunc.setContentAreaFilled(false);
		consultafunc.setBorderPainted(false);
		consultafunc.setFocusPainted(false);
		this.add(consultafunc);		
		consultafunc.addActionListener(new ActionListener() {
			/* puxando a class que esta a tela */				
			public void actionPerformed(ActionEvent e) {
				/* declarando o nome da tela */						
				ConsultaFuncionario consultaFunc = null;
				consultaFunc = new ConsultaFuncionario();
				consultaFunc.setVisible(true);
			}
		});

		consultaprod = new JButton();
		consultaprod.setSize(235,95);
		consultaprod.setLocation(378, 435);
		consultaprod.setOpaque(false);
		consultaprod.setContentAreaFilled(false);
		consultaprod.setBorderPainted(false);
		consultaprod.setFocusPainted(false);
		this.add(consultaprod);
		consultaprod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConsultaEstoque consultaestoque = null;
				consultaestoque = new ConsultaEstoque();
				consultaestoque.setVisible(true);
			}
		});
			
		cadastrofunc = new JButton("");
		cadastrofunc.setSize(235,95);
		cadastrofunc.setLocation(258,330);
		cadastrofunc.setOpaque(false);
		cadastrofunc.setContentAreaFilled(false);
		cadastrofunc.setBorderPainted(false);
		cadastrofunc.setFocusPainted(false);
		this.add(cadastrofunc);			
		cadastrofunc.addActionListener(new ActionListener() {				
			public void actionPerformed(ActionEvent e) {
								
				CadastroFuncionario cadastrofuncionario = null;
				cadastrofuncionario = new CadastroFuncionario();
				cadastrofuncionario.setVisible(true);
			}
		});
		
		cadastroprod = new JButton();
		cadastroprod.setSize(235,95);
		cadastroprod.setLocation(138, 435);
		cadastroprod.setOpaque(true);
		cadastroprod.setContentAreaFilled(false);
		cadastroprod.setBorderPainted(false);
		cadastroprod.setFocusPainted(false);
		this.add(cadastroprod);			
		cadastroprod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastroProduto cadastroproduto = null;
				cadastroproduto = new CadastroProduto();
				cadastroproduto.setVisible(true);
			}
		});
		
		vendaprod = new JButton();
		vendaprod.setSize(235,95);
		vendaprod.setLocation(618, 435);
		vendaprod.setContentAreaFilled(false);
		vendaprod.setBorderPainted(false);
		vendaprod.setFocusPainted(false);
		this.add(vendaprod);
		vendaprod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Vendas vendas = null;
				vendas = new Vendas();
				vendas.setVisible(true);
				
			}
		});
		
		/* titulo do meio*/	
		l1 = new JLabel();
		l1.setText("MENU PRINCIPAL");
		l1.setSize(700,200);
		l1.setLocation(280,80);
		l1.setFont(new Font("Arial", Font.BOLD,60));
		this.add(l1);
		
		fundo = new JLabel();
		fundo.setIcon( new ImageIcon ("src/Imagens/home.gif"));
		fundo.setBounds(0, 0, 1024, 720);
		this.add(fundo);
		
	}

	public static void main (String [] args){
		new Home().setVisible(true);	
	}
}
