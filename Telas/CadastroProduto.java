package Telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;

import Acoes.ProdutoDAO;
import Acoes.SGProduto;

public class CadastroProduto extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JLabel lbtituloimagem, lbimagemprod,lbfundotela,lbtitulocproduto,lbproduto,lbmodelo,lbtamanho,lbcor,lbvcusto,lbvvenda,lbquantidade;
	private JFormattedTextField txnomeprod,txmodelo,txtamanho,txcor,txvcusto,txquantidade,txvvenda;
	private JTextField tximagemprod;
	private Dimension dtextmaiscurto,dtextcurto,dtextmedio, dtextlongo;
	private Font fontpadrao;	
	private JButton btimagemprod, menuprincipal,cadastrar,logoff;
	private JFileChooser localimageprod;
	
	public CadastroProduto(){
		
		// Definições do JFrame CadastroProduto 
		setTitle ("Cadastro de Produtos");
		setLayout (null);
		setSize (1037,755);
		setLocation (180, 2);
		setResizable (false);
		Color Fundo = new Color(250,250,250);
		setBackground(Fundo);
		dispose();

		// Definições de Dimensões 
		dtextlongo = new Dimension(250,26);
		dtextmedio = new Dimension(200,26);
		dtextcurto = new Dimension(100,26);
		dtextmaiscurto = new Dimension(80,26);

		// Definições de Fontes
		fontpadrao = new Font("", Font.PLAIN,16);

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
		logoff.setBounds(940,30,85,35);
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
		
		// Titulo da Tela Cadastro de produtos
		lbtitulocproduto = new JLabel();
		lbtitulocproduto.setText("CADASTRO DE PRODUTOS");
		lbtitulocproduto.setFont (new Font("",Font.PLAIN,18));
		lbtitulocproduto.setBounds(40,160,300,30);
		this.add (lbtitulocproduto);

		// Titulo para o campo produto
		lbproduto = new JLabel();
		lbproduto.setSize(dtextlongo);
		lbproduto.setLocation(80,230);
		lbproduto.setText("Produto");
		lbproduto.setFont(fontpadrao);
		this.add (lbproduto);

		// Campo para digitar o nome do produto
		txnomeprod = new JFormattedTextField();
		txnomeprod.setSize(dtextlongo);	
		txnomeprod.setLocation(150,230);
		this.add (txnomeprod);

		// Titulo para o campo modelo
		lbmodelo = new JLabel();
		lbmodelo.setSize(dtextlongo);
		lbmodelo.setLocation(80,280);
		lbmodelo.setText("Modelo");
		lbmodelo.setFont(fontpadrao);
		this.add (lbmodelo);

		// Campo para digitar o modelo
		txmodelo = new JFormattedTextField();
		txmodelo.setSize(dtextlongo);
		txmodelo.setLocation(150,280);
		this.add (txmodelo);

		// Titulo para o tamanho
		lbtamanho = new JLabel();
		lbtamanho.setSize(dtextcurto);
		lbtamanho.setLocation(415,230);
		lbtamanho.setText("Tam.");
		lbtamanho.setFont(fontpadrao);
		this.add (lbtamanho);

		// Campo para o tamanho 
		txtamanho = new JFormattedTextField();
		txtamanho.setSize(dtextmaiscurto);	
		txtamanho.setLocation(470,230);
		this.add (txtamanho);

		// Titulo para o campo cor
		lbcor = new JLabel();
		lbcor.setSize(dtextmedio);
		lbcor.setText("Cor");
		lbcor.setFont(fontpadrao);
		lbcor.setLocation(415,280);
		this.add (lbcor);

		// Campo para digitar a cor 
		txcor = new JFormattedTextField();
		txcor.setSize(dtextmaiscurto);	
		txcor.setLocation(470,280);
		this.add (txcor);	 

		// Titulo para o campo valor de venda quantidade
		lbquantidade = new JLabel();
		lbquantidade.setSize(dtextmedio);
		lbquantidade.setText("Quantidade");
		lbquantidade.setFont(fontpadrao);
		lbquantidade.setLocation(570,230);
		this.add (lbquantidade);

		// Campo para digitar a quantidade
		txquantidade = new JFormattedTextField();
		txquantidade.setSize(dtextmaiscurto);	
		txquantidade.setLocation(680,230);
		this.add (txquantidade);

		// Titulo para o campo valor de venda
		lbvcusto = new JLabel();
		lbvcusto.setSize(dtextlongo);
		lbvcusto.setText("Valor Custo");
		lbvcusto.setFont(fontpadrao);
		lbvcusto.setLocation(100,330);
		this.add (lbvcusto);

		// Campo para digitar o valor de custo
		txvcusto = new JFormattedTextField();
		txvcusto.setSize(dtextcurto);	
		txvcusto.setLocation(210,330);
		this.add (txvcusto);

		// Titulo do campo valor de venda
		lbvvenda = new JLabel();
		lbvvenda.setSize(dtextlongo);
		lbvvenda.setText("Valor Venda");
		lbvvenda.setFont(fontpadrao);
		lbvvenda.setLocation(340,330);
		this.add (lbvvenda);

		// Campo para digitar o valor de venda		
		txvvenda = new JFormattedTextField();
		txvvenda.setSize(dtextcurto);	
		txvvenda.setLocation(450,330);
		this.add (txvvenda);	

		// Area para inserir a imagem
		lbimagemprod = new JLabel();
		lbimagemprod.setBounds(800,230,150,130);
		lbimagemprod.setBorder(BorderFactory.createLineBorder(new Color(239,123,0), 4));
		this.add (lbimagemprod);

		// Titulo do inserir imagem
		lbtituloimagem = new JLabel();
		lbtituloimagem.setSize(dtextlongo);
		lbtituloimagem.setText("Insira uma imagem aqui");
		lbtituloimagem.setFont(fontpadrao);
		lbtituloimagem.setLocation(570,280);
		this.add (lbtituloimagem);

		// Campo de texto que recebe o local da imagem
		tximagemprod = new JTextField("Local da Imagem");
		tximagemprod.setBounds(800,365,150,30);
		tximagemprod.setHorizontalAlignment(JTextField.CENTER);
		this.add (tximagemprod);

		// Botão para inserir a imagem do produto
		btimagemprod = new JButton("Inserir");
		btimagemprod.setBounds(570,320,200,35);
		btimagemprod.setFont(new Font("",Font.BOLD,14));
		btimagemprod.setBackground(new Color (239,123,0)); 
		btimagemprod.setFocusPainted(false);
		btimagemprod.setForeground(new Color (255,255,255));
		btimagemprod.addActionListener(new FileOpenListener());
		this.add (btimagemprod);

		// Filtros para definir que tipo de imagens posso visualizar na pesquisa 
		localimageprod = new JFileChooser();
		final ExtensionFileFilter filtroimg = new ExtensionFileFilter();
		filtroimg.addExtension("jpg");
		filtroimg.addExtension("jpeg");
		filtroimg.addExtension("png");
		filtroimg.addExtension("gif");
		filtroimg.addExtension("mpeg");
		filtroimg.setDescription("Imagens com Extensão: JPG, JPEG, PNG, GIF, MPEG");
		localimageprod.setFileFilter(filtroimg);
		localimageprod.setAccessory(new ImagePreviewer(localimageprod));
		localimageprod.setFileView(new FileIconView(filtroimg, new ImageIcon("")));

		// Botão para Cadastrar as informações
		cadastrar = new JButton ();
		cadastrar.setText("CADASTRAR");
		cadastrar.setFont(new Font("",Font.BOLD,14));
		cadastrar.setBounds(80,380,150,35);
		cadastrar.setFocusPainted(false);
		cadastrar.setBackground(new Color (239,123,0)); 
		cadastrar.setForeground(new Color (255,255,255));
		this.add(cadastrar);

		// Acão do Botão Cadastro enviar dados para o Banco de Dados
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SGProduto acaoCadastrar = new SGProduto();
				ProdutoDAO cadastrardao = new ProdutoDAO();

				acaoCadastrar.setProduto(txnomeprod.getText());
				acaoCadastrar.setImagem(tximagemprod.getText());
				acaoCadastrar.setModelo(txmodelo.getText());
				acaoCadastrar.setTamanho(txtamanho.getText());
				acaoCadastrar.setCor(txcor.getText());
				acaoCadastrar.setValor_custo(Float.parseFloat(txvcusto.getText()));
				acaoCadastrar.setValor_venda(Float.parseFloat(txvvenda.getText()));
				acaoCadastrar.setQuantidade(Integer.parseInt(txquantidade.getText()));
				cadastrardao.inserir(acaoCadastrar);
				
				JOptionPane.showMessageDialog(null, "O Produto foi cadastrado com sucesso!");

				txnomeprod.setText("");
				txmodelo.setText("");
				txtamanho.setText("");
				txcor.setText("");
				txvcusto.setText("");
				txvvenda.setText("");
				txquantidade.setText("");	
				tximagemprod.setText("Local da Imagem");
				lbimagemprod.setIcon(new ImageIcon());
			}
		}); 
		// Fim da ação para o botão de cadastrar

		// Imagem de fundo
		lbfundotela = new JLabel(new ImageIcon("src/Imagens/CadastroProduto.gif"));
		lbfundotela.setSize (1024,700);
		lbfundotela.setLocation(0,0);
		this.add(lbfundotela);
	}

	// Classe de definições de filtro do FileChooser 	
	class ExtensionFileFilter extends FileFilter {
		public void addExtension(String extension) {
			if (!extension.startsWith("."))
				extension = "." + extension;
			extensions.add(extension.toLowerCase());
		}

		public void setDescription(String aDescription) {
			description = aDescription;
		}

		public String getDescription() {
			return description;
		}

		public boolean accept(File f) {
			if (f.isDirectory())
				return true;
			String name = f.getName().toLowerCase();
			for (String extension : extensions)
				if (name.endsWith(extension))
					return true;
			return false;
		}

		private String description = "";
		private ArrayList<String> extensions = new ArrayList<String>();
	}

	// Sub-Classe para salvar o caminho da imagem
	class FileIconView extends FileView {
		public FileIconView(FileFilter aFilter, Icon anIcon) {
			filter = aFilter;
			icon = anIcon;
		}
		public Icon getIcon(File f) {
			if (!f.isDirectory() && filter.accept(f))
				return icon;
			else
				return null;
		}

		private FileFilter filter;
		private Icon icon;
	}
	private class FileOpenListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			localimageprod.setCurrentDirectory(new File("."));
			int result = localimageprod.showOpenDialog(CadastroProduto.this);
			if (result == JFileChooser.APPROVE_OPTION) {
				String caminho = localimageprod.getSelectedFile().getPath();
				// Converte o valor da variavel caminho para ImageIcon
				ImageIcon icon1 = new ImageIcon(caminho);
				// Redimensionaliza o tamanho da imagem de acordo com a JLabel
				lbimagemprod.setIcon(new ImageIcon(icon1.getImage().getScaledInstance(lbimagemprod.getWidth(),lbimagemprod.getHeight(), Image.SCALE_DEFAULT)));
				tximagemprod.setText(caminho);
			}
		}
	}

	// Sub-Classe para pré-visualização da imagem na Label
	class ImagePreviewer extends JLabel {

		private static final long serialVersionUID = 1L;

		public ImagePreviewer(JFileChooser chooser) {

			setPreferredSize(new Dimension(100, 100));
			setBorder(BorderFactory.createEtchedBorder());

			chooser.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent event) {
					if (event.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY) {
						File f = (File) event.getNewValue();
						if (f == null) {
							setIcon(null);
							return;
						}
						ImageIcon icon = new ImageIcon(f.getPath());
						if (icon.getIconWidth() > getWidth())
							icon = new ImageIcon(icon.getImage().getScaledInstance(getWidth(), -1, Image.SCALE_DEFAULT));
						setIcon(icon);
					}
				}
			});
		}
	};

	public static void main(String[] args){
		new CadastroProduto().setVisible(true);
	}
}