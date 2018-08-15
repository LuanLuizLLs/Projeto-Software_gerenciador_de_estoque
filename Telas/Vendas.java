package Telas;

import java.awt.*;

import javax.swing.*;

import java.awt.event.KeyEvent;

import Acoes.ControleVenda;
import Acoes.Factory;
import Acoes.ModeloTabela;
import Acoes.ModeloVenda;
import Acoes.SGProduto;
import Acoes.TabelaEstoqueCon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

import java.awt.event.KeyAdapter;

import javax.swing.table.DefaultTableModel;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Vendas extends JFrame {

	int flag=1;

	Factory con = new Factory();
	ModeloVenda mod = new ModeloVenda();
	ControleVenda control = new ControleVenda();

	private static final long serialVersionUID = 1L;

	private JTextField txtquantidade, txtcodprod, txtvalortotal, txtvalordoitem;
	private JLabel lblTotal,lblTabelaPesquisa,lblValorDoItem,lblCoddoproduto,lbproduto,lbimagemprod,lblQuantidade,Background;
	private JTable tablevenda, tabelapesquisa;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane;
	private JButton menuprincipal,logoff,btnFinalizar,btnInseriritem,btnbuscar;
	private String caminho;
	Factory conexaoBanco;
	int codVenda;


	///// metodo para preencher a tabela
	@SuppressWarnings({ "unchecked", "static-access" })
	public void preencherTabelaPesquisa(String SQL){ 
		@SuppressWarnings("rawtypes")
		ArrayList dados = new ArrayList();
		String [] Colunas = new String[]{"Código", "nome", "Quantidade", "Valor de venda", "Imagem"};
		con.conectaBanco();//conexão com o banco
		con.executeSQL(SQL);//para executar o sql

		try{

			con.rs.first();
			do{
				//comando para fazer a buscar no banco e aparecer na tabela
				dados.add(new Object[] {con.rs.getInt("id"),con.rs.getString("produto"),con.rs.getInt("quantidade"),con.rs.getFloat("valor_venda"),con.rs.getString("imagem"),}); 

			}while (con.rs.next());
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao preencher o Arraylist tabela pesquisa" + ex);
		}

		ModeloTabela modelo = new ModeloTabela(dados, Colunas);
		tabelapesquisa.setModel(modelo);
		tabelapesquisa.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabelapesquisa.getColumnModel().getColumn(0).setResizable(false);
		tabelapesquisa.getColumnModel().getColumn(1).setPreferredWidth(200);
		tabelapesquisa.getColumnModel().getColumn(1).setResizable(false);
		tabelapesquisa.getColumnModel().getColumn(2).setPreferredWidth(140);
		tabelapesquisa.getColumnModel().getColumn(2).setResizable(false);
		tabelapesquisa.getColumnModel().getColumn(3).setPreferredWidth(120);
		tabelapesquisa.getColumnModel().getColumn(3).setResizable(false);
		tabelapesquisa.getColumnModel().getColumn(4).setPreferredWidth(105);
		tabelapesquisa.getColumnModel().getColumn(4).setResizable(false);
		tabelapesquisa.getTableHeader().setReorderingAllowed(false);
		tabelapesquisa.setAutoResizeMode(tabelapesquisa.AUTO_RESIZE_OFF);
		tabelapesquisa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


	}

	public Vendas() {

		@SuppressWarnings("unused")
		SGProduto sgprod = new SGProduto();
		setTitle("Venda de Produtos");
		setResizable(false);
		setBounds(180, 2, 1024, 748);
		this.setLayout(null);
		
		// Botão para direcionar ao Home(Menu Principal)
		menuprincipal = new JButton();
		menuprincipal.setText("Menu Principal"); 
		menuprincipal.setFont (new Font("",Font.BOLD,12));
		menuprincipal.setBounds(105,30,140,35);
		menuprincipal.setContentAreaFilled(false);
		menuprincipal.setBorderPainted(false);
		menuprincipal.setFocusPainted(false);
		menuprincipal.setForeground(new Color(255,255,255));
		this.add(menuprincipal);
				
		// Altera o botão quando o mouse se aproxima
		menuprincipal.addMouseListener(new MouseAdapter() {
	    public void mouseEntered(MouseEvent e) {
		//Esta com o mouse sobre o botão
		 menuprincipal.setBorderPainted(true);
	    }
		public void mouseExited(MouseEvent e) {
		//Saiu com o mouse de cima do botão
		 menuprincipal.setBorderPainted(false);
		}	
		public void mouseClicked(MouseEvent e) {
		// Chamar a tela Home
		 dispose();
		 Home home = new Home();
		 home.setAlwaysOnTop(true);
		}
		});
				
		// Botão para direcionar fazer Logoff
	    logoff = new JButton();
		logoff.setBounds(930,30,85,35);
		logoff.setContentAreaFilled(false);
		logoff.setBorderPainted(false);
		logoff.setFocusPainted(false);
		logoff.setText("LOGOFF");
		logoff.setFont (new Font("",Font.BOLD,11));
		logoff.setForeground(new Color(255,255,255));
		this.add (logoff);

        // Alteração visual do botão através do mouse
		logoff.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent e) {
		// Esta com o mouse sobre o botão
		 logoff.setBorderPainted(true);
		}
					
		public void mouseExited(MouseEvent e) {
		// Saiu com o mouse de cima do botão
		 logoff.setBorderPainted(false);
		}
		public void mouseClicked(MouseEvent e) {
		 Frame[] TelasAbertas = Frame.getFrames();
						
		 for (Frame telas : TelasAbertas){
		 telas.dispose();}
					    
		 Login login = new Login();
		 login.setVisible(true);
		}
		});
				
		///////Todas as labels//////
		
		lblCoddoproduto = new JLabel("COD. DO PRODUTO");
		lblCoddoproduto.setBounds(18, 142, 116, 14);
		this.add(lblCoddoproduto);

		lblTabelaPesquisa = new JLabel("TABELA PESQUISA:");
		lblTabelaPesquisa.setBounds(18, 200, 116, 14);
		this.add(lblTabelaPesquisa);

		lbimagemprod = new JLabel();
		lbimagemprod.setBounds(714, 86, 234, 233);
		this.add(lbimagemprod);

		lblTotal = new JLabel("TOTAL");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTotal.setBounds(724, 551, 78, 37);
		this.add(lblTotal);

		lblQuantidade = new JLabel("QUANTIDADE");
		lblQuantidade.setBounds(357, 143, 86, 14);
		this.add(lblQuantidade);
		
		lbproduto = new JLabel("");
		lbproduto.setBounds(529, 75, 166, 29);
		this.add(lbproduto);

		lblValorDoItem = new JLabel("VALOR DO ITEM");
		lblValorDoItem.setBounds(243, 142, 104, 14);
		this.add(lblValorDoItem);

		/////Todas as textFields/////
		
		txtcodprod= new JTextField();
		txtcodprod.setColumns(10);
		txtcodprod.setBounds(18, 163, 116, 29);
		this.add(txtcodprod);
		txtcodprod.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					try{
						preencherTabelaPesquisa("select * from produtos where produto like '%"+txtcodprod.getText()+"%'  or id like '"+txtcodprod.getText()+"'");
					} 
					catch (Exception ee) {
						JOptionPane.showMessageDialog(null, "Produto não localizado, verifique se o Produto ou ID foi digitado corretamente.");    
					}
				}
			}});

		txtquantidade = new JTextField();
		txtquantidade.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent evt) {
				float valorTotal;
				valorTotal = Float.parseFloat(txtvalordoitem.getText())*Integer.parseInt(txtquantidade.getText());
				txtvalortotal.setText(String.valueOf(valorTotal));
			}
		});
		txtquantidade.setColumns(10);
		txtquantidade.setBounds(358, 163, 103, 29);
		this.add(txtquantidade);
		
		txtvalortotal = new JTextField();
		txtvalortotal.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtvalortotal.setBounds(812, 551, 190, 37);
		this.add(txtvalortotal);
		txtvalortotal.setColumns(10);
	
		txtvalordoitem = new JTextField("");
		txtvalordoitem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				float valorTotal;
				valorTotal = Float.parseFloat(txtvalordoitem.getText())*Integer.parseInt(txtquantidade.getText());
				txtvalortotal.setText(String.valueOf(valorTotal));
			}
		});
		txtvalordoitem.setColumns(10);
		txtvalordoitem.setBounds(244, 162, 103, 29);
		this.add(txtvalordoitem);

		////Botôes////
		
		btnFinalizar = new JButton("FINALIZAR VENDA");
		btnFinalizar.setToolTipText("Finalizar");
		btnFinalizar.setBackground(new Color (239,123,0)); 
		btnFinalizar.setForeground(new Color (255,255,255));
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
			}
		});
		btnFinalizar.setBounds(865, 609, 137, 48);
		this.add(btnFinalizar);

		btnInseriritem = new JButton("INSERIR ITEM");
		btnInseriritem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				conexaoBanco = new Factory();
				conexaoBanco.conectaBanco();
				conexaoBanco.executeSQL("select produto, quantidade, valordoitem from venda_produto");
				tablevenda.setModel(new TabelaEstoqueCon(conexaoBanco.rs));
				
				} catch (Exception erro) {

				}
				//Ajusta a largura das colunas
				tablevenda.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				tablevenda.getColumnModel().getColumn(0).setPreferredWidth(150);
				tablevenda.getColumnModel().getColumn(0).setResizable(false);
				tablevenda.getColumnModel().getColumn(1).setPreferredWidth(250);
				tablevenda.getColumnModel().getColumn(1).setResizable(false);
				tablevenda.getColumnModel().getColumn(2).setPreferredWidth(280);
				tablevenda.getColumnModel().getColumn(2).setResizable(false);
			}
		});

		btnInseriritem.setToolTipText("Excluir item");
		btnInseriritem.setBackground(new Color (239,123,0)); 
		btnInseriritem.setForeground(new Color (255,255,255));
		btnInseriritem.setBounds(471, 163, 109, 29);
		this.add(btnInseriritem);
		btnInseriritem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ModeloVenda ModeloVenda = new ModeloVenda ();

				ModeloVenda.setProduto(txtcodprod.getText());
				ModeloVenda.setQuantidade(Integer.parseInt(txtquantidade.getText()));	
				ModeloVenda.setValordoitem(Float.parseFloat(txtvalordoitem.getText()));				

				ControleVenda ControleVenda = new ControleVenda();
				ControleVenda.addvenda(ModeloVenda);

				txtcodprod.setText("");
				txtquantidade.setText("");
				txtvalordoitem.setText("");
				JOptionPane.showMessageDialog(null,"Itém adicionado com sucesso!");

			}});

		btnbuscar = new JButton("BUSCAR");
		btnbuscar.setBackground(new Color (239,123,0)); 
		btnbuscar.setForeground(new Color (255,255,255));
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				con.conectaBanco();
				try{
					preencherTabelaPesquisa("select * from produtos where produto like '%"+txtcodprod.getText()+"%'  or id like '"+txtcodprod.getText()+"'");
				} 
				catch (Exception ee) {
					JOptionPane.showMessageDialog(null, "Produto não localizado, verifique se o Produto ou ID foi digitado corretamente.");    
				}
			}
		});
		btnbuscar.setBounds(144, 163, 89, 29);
		this.add(btnbuscar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 357, 685, 299);
		this.add(scrollPane);

		tablevenda = new JTable();
		tablevenda.setModel(new DefaultTableModel());
		tablevenda.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				con.conectaBanco();
				caminho = (String) tablevenda.getValueAt(tablevenda.getSelectedRow(), 4);
				ImageIcon mostrarImagem = new ImageIcon(caminho);
				lbimagemprod.setIcon(new ImageIcon(mostrarImagem.getImage().getScaledInstance(lbimagemprod.getWidth(),lbimagemprod.getHeight(),Image.SCALE_DEFAULT)));

				String valortotal = "" + tablevenda.getValueAt(tablevenda.getSelectedRow(), 4);
				txtvalortotal.setText(String.valueOf(valortotal));
				}
		});
		scrollPane.setViewportView(tablevenda);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(18, 221, 664, 106);
		this.add(scrollPane_1);

		tabelapesquisa = new JTable();
		tabelapesquisa.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				con.conectaBanco();
				String nome_produto = "" + tabelapesquisa.getValueAt(tabelapesquisa.getSelectedRow(), 1);
				txtcodprod.setText(nome_produto);

				String valor_venda = "" + tabelapesquisa.getValueAt(tabelapesquisa.getSelectedRow(), 3);
				txtvalordoitem.setText(String.valueOf(valor_venda));
				txtquantidade.setText("1");

				caminho = (String) tabelapesquisa.getValueAt(tabelapesquisa.getSelectedRow(), 4);
				ImageIcon mostrarImagem = new ImageIcon(caminho);
				lbimagemprod.setIcon(new ImageIcon(mostrarImagem.getImage().getScaledInstance(lbimagemprod.getWidth(),lbimagemprod.getHeight(),Image.SCALE_DEFAULT)));

				String valortotal = "" + tablevenda.getValueAt(tablevenda.getSelectedRow(), 4);
				txtvalortotal.setText(String.valueOf(valortotal));
				}
		});
		scrollPane_1.setViewportView(tabelapesquisa);

		Background = new JLabel();
		Background.setIcon(new ImageIcon("src/Imagens/Vendas.gif"));
		Background.setBounds(0, 0, 1018, 701);
		this.add(Background);
		
	}

	public static void main (String [] args){
		new Vendas().setVisible(true);	
	}	
}
