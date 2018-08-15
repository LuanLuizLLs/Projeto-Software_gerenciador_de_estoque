package Telas;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.TableColumn;

import Acoes.Factory;
import Acoes.TabelaFuncionarioCon;
import Complementar.CentralizarDadosTable;

public class ConsultaFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtConsulta;
	private JButton btbuscar, btmenuprincipal, btlogoff, btRefresh;
	private JScrollPane scrollPane;
	private JTable tableFuncionario;
	private JLabel lbfundo;
	private Factory conexaoBanco;
	private DescricaoFuncionario descricaofuncionario;

	public ConsultaFuncionario() {
		
		setTitle("Consulta de Funcionários");
		setBounds(180, 2, 1037, 755);
		setResizable(false);
		setLayout(null);
		dispose();
		
		txtConsulta = new JTextField();
		txtConsulta.setText("Consultar:");
		txtConsulta.setFont(new Font("Verdana", Font.BOLD,11));
		txtConsulta.setBounds(40, 135, 870, 30);
		txtConsulta.setForeground(new Color (169,169,169));
		this.add(txtConsulta);
		txtConsulta.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){

				if (txtConsulta.getText().equals("Consultar:")){
					txtConsulta.setText("");
					txtConsulta.setForeground(new Color (0,0,0));
				}
			}
			public void mouseExited(MouseEvent e){

				if (txtConsulta.getText().equals("")){
					txtConsulta.setText("Consultar:");
					txtConsulta.setForeground(new Color (169,169,169));
				}
			}
			public void mouseClicked(MouseEvent e) {
				txtConsulta.setForeground(new Color (0,0,0));
			}
		});

		txtConsulta.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				if (txtConsulta.getText().equals("Consultar:")) {
					txtConsulta.setText("");
					txtConsulta.setForeground(new Color (0,0,0));
				}
			}
		});
		
		btbuscar = new JButton(new ImageIcon("src/Imagens/lupa.png"));
		btbuscar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btbuscar.setForeground(Color.WHITE);
		btbuscar.setBackground(new Color(239, 123, 0));
		btbuscar.setBorderPainted(true);
		btbuscar.setFocusPainted(false);
		btbuscar.setBounds(910, 135, 80, 29);
		this.add(btbuscar);
		btbuscar.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				btbuscar.setBorderPainted(true);
			}
			
			public void mouseExited(MouseEvent e) {
				btbuscar.setBorderPainted(true);
			}
			
			public void mouseClicked(MouseEvent e) {
				
				try {
					
					conexaoBanco = new Factory();
					conexaoBanco.conectaBanco();
					conexaoBanco.executeSQL("select idfunc, nome, sobrenome, cpf, cargo from funcionarios where nome like '%"+txtConsulta.getText()+"%' or idfunc like '"+txtConsulta.getText()+"'");
					tableFuncionario.setModel(new TabelaFuncionarioCon(conexaoBanco.rs));
					
				} catch (Exception er) {
					System.out.println("Erro " + er);
				}
				Tabela();
			}
		});
		
		txtConsulta.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					try {
						
						conexaoBanco = new Factory();
						conexaoBanco.conectaBanco();
						conexaoBanco.executeSQL("select idfunc, nome, sobrenome, cpf, cargo from funcionarios where nome like '%"+txtConsulta.getText()+"%' or idfunc like '"+txtConsulta.getText()+"'");
						tableFuncionario.setModel(new TabelaFuncionarioCon(conexaoBanco.rs));
						
					} catch (Exception er) {
						System.out.println("Erro " + er);
					}
					Tabela();
				}
			}
		});
		
		btmenuprincipal = new JButton("Menu Principal");
		btmenuprincipal.setForeground(Color.WHITE);
		btmenuprincipal.setContentAreaFilled(false);
		btmenuprincipal.setBorderPainted(false);
		btmenuprincipal.setFocusPainted(false);
		btmenuprincipal.setFont(new Font("Verdana", Font.BOLD, 11));
		btmenuprincipal.setBounds(104, 31, 157, 34);
		this.add(btmenuprincipal);
		btmenuprincipal.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				btmenuprincipal.setBorderPainted(true);
			}
			
			public void mouseExited(MouseEvent e) {
				btmenuprincipal.setBorderPainted(false);
			}
			
			public void mouseClicked(MouseEvent e) {
				// Chamar a tela Home					
				dispose();
				Home home = new Home();
				home.setAlwaysOnTop(true);
			}
		}); 
		
		btlogoff = new JButton("LOGOFF");
		btlogoff.setForeground(Color.WHITE);
		btlogoff.setFont(new Font("Verdana", Font.BOLD, 11));
		btlogoff.setContentAreaFilled(false);
		btlogoff.setBorderPainted(false);
		btlogoff.setFocusPainted(false);
		btlogoff.setBounds(935, 30, 85, 35);
		this.add(btlogoff);
		btlogoff.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				btlogoff.setBorderPainted(true);
			}
			
			public void mouseExited(MouseEvent e) {
				btlogoff.setBorderPainted(false);
			}
			
			public void mouseClicked(MouseEvent e) {
				Frame[] TelasAbertas = Frame.getFrames();
				
			    for (Frame telas : TelasAbertas){
			    telas.dispose();}
			    
			    Login login = new Login();
			    login.setVisible(true);
			}
		});
		
		btRefresh = new JButton("Refresh");
		btRefresh.setBounds(40, 180, 89, 23);
		this.add(btRefresh);
		btRefresh.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				try {
					conexaoBanco = new Factory();
					conexaoBanco.conectaBanco();
					conexaoBanco.executeSQL("select idfunc, nome, sobrenome, cpf, cargo from funcionarios");
					tableFuncionario.setModel(new TabelaFuncionarioCon(conexaoBanco.rs));
				} catch (Exception erro) {
				}
				Tabela();
			}
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 206, 947, 463);
		this.add(scrollPane);
		tableFuncionario = new JTable();
		scrollPane.setViewportView(tableFuncionario);
		
		//conexão com o banco para preencher a tabela
		try {
			conexaoBanco = new Factory();
			conexaoBanco.conectaBanco();
			conexaoBanco.executeSQL("select idfunc, nome, sobrenome, cpf, cargo from funcionarios");
			tableFuncionario.setModel(new TabelaFuncionarioCon(conexaoBanco.rs));
		} catch (Exception erro) {
		}
		Tabela();
		
		//Ação em uma linha na JTable
		tableFuncionario.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {

					Object x = tableFuncionario.getModel().getValueAt(tableFuncionario.getSelectedRow(), 0);//pego o codigo do produto na posição 0 da tabela
					String codigo = x.toString();
					descricaofuncionario = new DescricaoFuncionario();
					descricaofuncionario.setVisible(true);
					descricaofuncionario.enviadodatabela(codigo);
				}
			}
		});
		
		lbfundo = new JLabel(new ImageIcon("src/Imagens/TabelaFuncionarios.gif"));
		lbfundo.setLocation(0, 0);
		lbfundo.setSize(1024, 720);
		this.add(lbfundo);
	}
	
	public void Tabela() {
		
		//Ajusta a largura das colunas
		tableFuncionario.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableFuncionario.getColumnModel().getColumn(0).setPreferredWidth(44);
		//Centraliza os dados da tabela
		CentralizarDadosTable tcr0 = new CentralizarDadosTable();
		TableColumn column0 =  tableFuncionario.getColumnModel().getColumn(0);
		column0.setCellRenderer(tcr0);
		/////////////////////////////////////////////////////////////
		tableFuncionario.getColumnModel().getColumn(1).setPreferredWidth(250);
		tableFuncionario.getColumnModel().getColumn(2).setPreferredWidth(350);
		tableFuncionario.getColumnModel().getColumn(3).setPreferredWidth(100);
		//Centraliza os dados da tabela
		CentralizarDadosTable tcr3 = new CentralizarDadosTable();
		TableColumn column3 =  tableFuncionario.getColumnModel().getColumn(3);
		column3.setCellRenderer(tcr3);
		/////////////////////////////////////////////////////////////
		tableFuncionario.getColumnModel().getColumn(4).setPreferredWidth(200);
		////////////////////////////////////////////////////////////	
	}
	
	public static void main(String[] args) {
		new ConsultaFuncionario().setVisible(true);
	}
}
