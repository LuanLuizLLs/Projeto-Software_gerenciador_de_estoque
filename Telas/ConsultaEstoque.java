package Telas;

import java.awt.Font;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumn;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import Acoes.Factory;
import Acoes.TabelaProdutoCon;
import Complementar.CentralizarDadosTable;

public class ConsultaEstoque extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtConsulta;
	private JButton btbuscar, btmenuprincipal, btlogoff, btRefresh;
	private JTable tableEstoque;
	private JScrollPane scrollPane;
	private JLabel lbfundo;
	private Factory conexaoBanco;
	private DescricaoProduto descricaoproduto;

	public ConsultaEstoque() {
				
		setTitle("Consulta de Produtos");
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
					conexaoBanco.executeSQL("select id, produto, modelo, tamanho, cor, valor_venda, quantidade from produtos where produto like '%"+txtConsulta.getText()+"%' or id like '"+txtConsulta.getText()+"'");
					tableEstoque.setModel(new TabelaProdutoCon(conexaoBanco.rs));
					
				} catch (Exception er) {
					System.out.println("Erro " + er);
				}
				Tabela();
			}
		});
		
		txtConsulta.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(txtConsulta.getText().equals(null)) {
						
						try {
							
							conexaoBanco = new Factory();
							conexaoBanco.conectaBanco();
							conexaoBanco.executeSQL("select id, produto, modelo, tamanho, cor, valor_venda, quantidade from produtos");
							tableEstoque.setModel(new TabelaProdutoCon(conexaoBanco.rs));
							
						} catch (Exception er) {
							System.out.println("Erro " + er);
						}
						Tabela();
						
					}
					else {
						
						try {
							
							conexaoBanco = new Factory();
							conexaoBanco.conectaBanco();
							conexaoBanco.executeSQL("select id, produto, modelo, tamanho, cor, valor_venda, quantidade from produtos where produto like '%"+txtConsulta.getText()+"%' or id like '"+txtConsulta.getText()+"'");
							tableEstoque.setModel(new TabelaProdutoCon(conexaoBanco.rs));
							
						} catch (Exception er) {
							System.out.println("Erro " + er);
						}
						Tabela();
						
					}
					
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
					conexaoBanco.executeSQL("select id, produto, modelo, tamanho, cor, valor_venda, quantidade from produtos");
					tableEstoque.setModel(new TabelaProdutoCon(conexaoBanco.rs));
					
				} catch (Exception er) {
					System.out.println("Erro " + er);
				}
				Tabela();
			}
		});
		
		//Trazer todos os dados do Banco de dados
		scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 206, 947, 463);
		this.add(scrollPane);
		tableEstoque = new JTable();
		scrollPane.setViewportView(tableEstoque);
		
		try {
				
			conexaoBanco = new Factory();
			conexaoBanco.conectaBanco();
			conexaoBanco.executeSQL("select id, produto, modelo, tamanho, cor, valor_venda, quantidade from produtos");
			tableEstoque.setModel(new TabelaProdutoCon(conexaoBanco.rs));

		} catch (Exception e) {
			System.out.println("Erro " + e);
		}
		Tabela();
		
		//Ação em uma linha na JTable
		tableEstoque.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {

					Object x = tableEstoque.getModel().getValueAt(tableEstoque.getSelectedRow(), 0);//pego o codigo do produto na posição 0 da tabela
					String codigo = x.toString();
					descricaoproduto = new DescricaoProduto();
					descricaoproduto.setVisible(true);
					descricaoproduto.enviadodatabela(codigo);
				}
			}
		});
		
		lbfundo = new JLabel(new ImageIcon("src/Imagens/TabelaProdutos.gif"));
		lbfundo.setLocation(0, 0);
		lbfundo.setSize(1024, 720);
		this.add(lbfundo);
	}
	
	public void Tabela() {
		
		//Ajusta a largura das colunas
		tableEstoque.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableEstoque.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableEstoque.getTableHeader().setReorderingAllowed(false);
		
		tableEstoque.getColumnModel().getColumn(0).setPreferredWidth(44);
		//Centraliza os dados da tabela
		CentralizarDadosTable tcr0 = new CentralizarDadosTable();
		TableColumn column0 =  tableEstoque.getColumnModel().getColumn(0);
		column0.setCellRenderer(tcr0);
		/////////////////////////////////////////////////////////////
		
		tableEstoque.getColumnModel().getColumn(1).setPreferredWidth(250);
		tableEstoque.getColumnModel().getColumn(2).setPreferredWidth(350);
		tableEstoque.getColumnModel().getColumn(3).setPreferredWidth(70);
		//Centraliza os dados da tabela
		CentralizarDadosTable tcr3 = new CentralizarDadosTable();
		TableColumn column3 =  tableEstoque.getColumnModel().getColumn(3);
		column3.setCellRenderer(tcr3);
		/////////////////////////////////////////////////////////////
		
		tableEstoque.getColumnModel().getColumn(4).setPreferredWidth(80);
		tableEstoque.getColumnModel().getColumn(5).setPreferredWidth(70);
		tableEstoque.getColumnModel().getColumn(6).setPreferredWidth(80);
		//Centraliza os dados da tabela
		CentralizarDadosTable tcr6 = new CentralizarDadosTable();
		TableColumn column6 =  tableEstoque.getColumnModel().getColumn(6);
		column6.setCellRenderer(tcr6);
		/////////////////////////////////////////////////////////////////
	}
	
	public static void main(String[] args) {
		new ConsultaEstoque().setVisible(true);
	}
}
