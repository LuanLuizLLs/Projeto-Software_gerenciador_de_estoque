package Telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;

import Acoes.ProdutoDAO;
import Acoes.SGProduto;
import Complementar.LetraMaiuscula;

public class DescricaoProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lbimagemprod, lbmodelo, lbtamanho, lbcor, lbvalor_custo, lbvalor_venda, lbquantidade, lbstatus, lbfundo;
	private JTextField txtproduto, txtlocalimagem, txtcodproduto, txtlocalizar, txtmodelo, txttamanho, txtcor, txtvalor_custo, txtvalor_venda, txtquantidade;
	private JButton btlocalizar, btsalvar, bteditar, btalterarimagem;
	private String caminho;
	private JFileChooser localimageprod;
	private int result;
	ConsultaEstoque consulta;
	
	
	public DescricaoProduto() {

		setTitle("Desrição Produto");
		setBounds(210, 100, 969, 579);
		getContentPane().setLayout(null);
		setBackground(new Color(250, 250, 200));
		setResizable(false);
		dispose();
		
		txtproduto = new JTextField();
		txtproduto.setEnabled(false);
		txtproduto.setText("");
		txtproduto.setBorder(BorderFactory.createLineBorder(Color.black));
		txtproduto.setFont(new Font("",Font.BOLD, 13));
		txtproduto.setDisabledTextColor(Color.BLACK);
		txtproduto.setHorizontalAlignment(JTextField.CENTER); 
		txtproduto.setLocation(19, 111);
		txtproduto.setSize(248, 26);
		this.add(txtproduto);

		btalterarimagem = new JButton();
		btalterarimagem.setVisible(false);
		btalterarimagem.setText("ALTERAR IMAGEM");
		btalterarimagem.setBounds(19, 345, 248, 35);
		btalterarimagem.setBackground(new Color (239,123,0)); 
		btalterarimagem.setForeground(new Color (255,255,255));
		btalterarimagem.addActionListener(new FileOpenListener());
		this.add(btalterarimagem);

		txtlocalimagem = new JTextField();
		txtlocalimagem.setVisible(false);
		txtlocalimagem.setEnabled(false);
		txtlocalimagem.setBounds(19, 382, 248, 35);
		this.add(txtlocalimagem);

		lbimagemprod = new JLabel();
		lbimagemprod.setLocation(18, 160);
		lbimagemprod.setSize(250, 259);
		this.add(lbimagemprod);

		txtcodproduto = new JTextField();
		txtcodproduto.setText("");
		txtcodproduto.setBorder(BorderFactory.createLineBorder(Color.black));
		txtcodproduto.setLocation(27, 490);
		txtcodproduto.setDisabledTextColor(Color.BLACK);
		txtcodproduto.setFont(new Font("",Font.BOLD,18));
		txtcodproduto.setHorizontalAlignment(JTextField.CENTER);
		txtcodproduto.setEnabled(false);
		txtcodproduto.setSize(232, 29);
		this.add(txtcodproduto);

		txtlocalizar = new JTextField();
		txtlocalizar.setLocation(445, 110);
		txtlocalizar.setSize(440, 29);
		this.add(txtlocalizar);
		
		btlocalizar = new JButton(new ImageIcon("src/Imagens/lupa.png"));
		btlocalizar.setText("");
		btlocalizar.setContentAreaFilled(false);
		btlocalizar.setBorderPainted(true);
		btlocalizar.setFocusPainted(false);
		btlocalizar.setLocation(885,110);
		btlocalizar.setSize(61, 28);
		this.add(btlocalizar);

		btlocalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{

					String digitado =  txtlocalizar.getText();
					ProdutoDAO cdao = new ProdutoDAO();
					SGProduto pro = new SGProduto();

					pro = cdao.consultar(digitado);
					txtproduto.setText(pro.getProduto());
					lbimagemprod.setText(pro.getImagem());
					txtlocalimagem.setText(pro.getImagem());
					txtcodproduto.setText(Integer.toString(pro.getId()));
					txtmodelo.setText(pro.getModelo());
					txttamanho.setText(pro.getTamanho());
					txtcor.setText(pro.getCor());
					txtvalor_custo.setText(Float.toString(pro.getValor_custo()));
					txtvalor_venda.setText(Float.toString(pro.getValor_venda()));
					txtquantidade.setText(Integer.toString(pro.getQuantidade()));

					caminho = lbimagemprod.getText();
					ImageIcon mostrarImagem = new ImageIcon(caminho);
					lbimagemprod.setIcon(new ImageIcon(mostrarImagem.getImage().getScaledInstance(lbimagemprod.getWidth(),lbimagemprod.getHeight(),Image.SCALE_DEFAULT)));

					try {
						if (txtquantidade.getText().equals("0")) {

							lbstatus.setText("Indisponivel :(");
							lbstatus.setForeground(Color.red);

						} else {

							lbstatus.setText("Disponivel :)");
							lbstatus.setForeground(Color.green);

						}
					} catch (Exception e1) {
						System.out.println("Erro");
					}

					txtlocalizar.setText("");

					bteditar.setEnabled(true);
					btsalvar.setEnabled(true);
					
				} 
				catch (Exception ee) {
					JOptionPane.showMessageDialog(null, "Produto não localizado, verifique se o Produto ou ID foi digitado corretamente.");

					txtlocalizar.setText("");
					txtproduto.setText("");
					lbimagemprod.setIcon(new ImageIcon());
					lbimagemprod.setText("");
					txtcodproduto.setText("");
					txtmodelo.setText("");
					txttamanho.setText("");
					txtcor.setText("");
					txtvalor_custo.setText("");
					txtvalor_venda.setText("");
					txtquantidade.setText("");

					bteditar.setEnabled(false);
					btsalvar.setEnabled(false);
				}
			}
		});

		txtlocalizar.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					try{

						String digitado =  txtlocalizar.getText();
						ProdutoDAO cdao = new ProdutoDAO();
						SGProduto pro = new SGProduto();

						pro = cdao.consultar(digitado);
						txtproduto.setText(pro.getProduto());
						lbimagemprod.setText(pro.getImagem());
						txtlocalimagem.setText(pro.getImagem());
						txtcodproduto.setText(Integer.toString(pro.getId()));
						txtmodelo.setText(pro.getModelo());
						txttamanho.setText(pro.getTamanho());
						txtcor.setText(pro.getCor());
						txtvalor_custo.setText(Float.toString(pro.getValor_custo()));
						txtvalor_venda.setText(Float.toString(pro.getValor_venda()));
						txtquantidade.setText(Integer.toString(pro.getQuantidade()));

						caminho = lbimagemprod.getText();
						ImageIcon mostrarImagem = new ImageIcon(caminho);
						lbimagemprod.setIcon(new ImageIcon(mostrarImagem.getImage().getScaledInstance(lbimagemprod.getWidth(),lbimagemprod.getHeight(),Image.SCALE_DEFAULT)));

						try {
							if (txtquantidade.getText().equals("0")) {

								lbstatus.setText("Indisponivel :(");
								lbstatus.setForeground(Color.red);

							} else {

								lbstatus.setText("Disponivel :)");
								lbstatus.setForeground(Color.green);

							}
						} catch (Exception e1) {
							System.out.println("Erro");
						}

						txtlocalizar.setText("");

						bteditar.setEnabled(true);

					} 
					catch (Exception ee) {
						JOptionPane.showMessageDialog(null, "Produto não localizado, verifique se o Produto ou ID foi digitado corretamente.");

						txtlocalizar.setText("");
						txtproduto.setText("");
						lbimagemprod.setIcon(new ImageIcon());
						lbimagemprod.setText("");
						txtcodproduto.setText("");
						txtmodelo.setText("");
						txttamanho.setText("");
						txtcor.setText("");
						txtvalor_custo.setText("");
						txtvalor_venda.setText("");
						txtquantidade.setText("");
						lbstatus.setText("");

						bteditar.setEnabled(false);

					}
				}
			}
		});

		lbmodelo = new JLabel();
		lbmodelo.setFont(new Font("Verdana",Font.PLAIN,20));
		lbmodelo.setText("Modelo");
		lbmodelo.setLocation(350, 215);
		lbmodelo.setSize(80, 28);
		lbmodelo.setForeground(Color.white);
		this.add(lbmodelo);

		lbtamanho = new JLabel();
		lbtamanho.setFont(new Font("Verdana",Font.PLAIN,20));
		lbtamanho.setText("Tamanho");
		lbtamanho.setLocation(634, 275);
		lbtamanho.setSize(100, 28);
		lbtamanho.setForeground(Color.white);
		this.add(lbtamanho);

		lbcor = new JLabel();
		lbcor.setFont(new Font("Verdana",Font.PLAIN,20));
		lbcor.setText("Cor");
		lbcor.setLocation(350, 275);
		lbcor.setSize(61, 28);
		lbcor.setForeground(Color.white);
		this.add(lbcor);

		lbvalor_custo = new JLabel();
		lbvalor_custo.setFont(new Font("Verdana",Font.PLAIN,20));
		lbvalor_custo.setText("Valor da aquisição do produto");
		lbvalor_custo.setLocation(350, 335);
		lbvalor_custo.setSize(300, 28);
		lbvalor_custo.setForeground(Color.white);
		this.add(lbvalor_custo);

		lbvalor_venda = new JLabel();
		lbvalor_venda.setFont(new Font("Verdana",Font.PLAIN,20));
		lbvalor_venda.setText("Valor para venda do produto");
		lbvalor_venda.setLocation(350, 395);
		lbvalor_venda.setSize(300, 28);
		lbvalor_venda.setForeground(Color.white);
		this.add(lbvalor_venda);

		lbquantidade = new JLabel();
		lbquantidade.setFont(new Font("Verdana",Font.PLAIN,20));
		lbquantidade.setText("Quantidade(s)");
		lbquantidade.setLocation(350, 455);
		lbquantidade.setSize(160, 28);
		lbquantidade.setForeground(Color.white);
		this.add(lbquantidade);

		lbstatus = new JLabel();
		lbstatus.setFont(new Font("Verdana",Font.PLAIN,20));
		lbstatus.setLocation(615, 455);
		lbstatus.setSize(160, 28);
		this.add(lbstatus);


		txtmodelo = new JTextField();
		txtmodelo.setFont(new Font("",Font.BOLD, 13));
		txtmodelo.setDisabledTextColor(Color.BLACK);
		txtmodelo.setEnabled(false);
		txtmodelo.setLocation(438, 219);
		txtmodelo.setSize(356, 25);
		this.add(txtmodelo);

		txttamanho = new JTextField();
		txttamanho.setFont(new Font("",Font.BOLD, 13));
		txttamanho.setDisabledTextColor(Color.BLACK);
		txttamanho.setHorizontalAlignment(JTextField.CENTER);
		txttamanho.setEnabled(false);
		txttamanho.setDocument(new LetraMaiuscula());
		txttamanho.setLocation(744, 280);
		txttamanho.setSize(50, 25);
		this.add(txttamanho);

		txtcor = new JTextField();
		txtcor.setFont(new Font("",Font.BOLD, 13));
		txtcor.setDisabledTextColor(Color.BLACK);
		txtcor.setEnabled(false);
		txtcor.setLocation(400, 279);
		txtcor.setSize(205, 25);
		this.add(txtcor);

		txtvalor_custo = new JTextField();
		txtvalor_custo.setFont(new Font("",Font.BOLD, 13));
		txtvalor_custo.setDisabledTextColor(Color.BLACK);
		txtvalor_custo.setEnabled(false);
		txtvalor_custo.setLocation(660, 339);
		txtvalor_custo.setSize(100, 25);
		this.add(txtvalor_custo);

		txtvalor_venda = new JTextField();
		txtvalor_venda.setFont(new Font("",Font.BOLD, 13));
		txtvalor_venda.setDisabledTextColor(Color.BLACK);
		txtvalor_venda.setEnabled(false);
		txtvalor_venda.setLocation(650, 399);
		txtvalor_venda.setSize(100, 25);
		this.add(txtvalor_venda);

		txtquantidade = new JTextField();
		txtquantidade.setHorizontalAlignment(JTextField.CENTER); 
		txtquantidade.setDisabledTextColor(Color.BLACK);
		txtquantidade.setEnabled(false);
		txtquantidade.setFont(new Font("",Font.BOLD, 13));
		txtquantidade.setForeground(Color.BLACK);
		txtquantidade.setLocation(504, 459);
		txtquantidade.setSize(50, 25);
		this.add(txtquantidade);

		bteditar = new JButton();
		bteditar.setText("Editar");
		bteditar.setForeground(Color.WHITE);
		bteditar.setFont(new Font("Verdana", Font.BOLD, 12));
		bteditar.setContentAreaFilled(false);
		bteditar.setBorderPainted(false);
		bteditar.setFocusPainted(false);
		bteditar.setBounds(823, 458, 115, 30);
		bteditar.setEnabled(false);
		this.add(bteditar);
		bteditar.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				bteditar.setBorderPainted(true);
			}
			
			public void mouseExited(MouseEvent e) {
				bteditar.setBorderPainted(false);
			}
			
			public void mouseClicked(MouseEvent e) {
				txtproduto.setEnabled(true);
				btalterarimagem.setVisible(true);
				txtlocalimagem.setVisible(true);
				txttamanho.setEnabled(true);
				txtcor.setEnabled(true);
				txtvalor_custo.setEnabled(true);
				txtvalor_venda.setEnabled(true);
				txtquantidade.setEnabled(true);
				txtmodelo.setEnabled(true);
				btsalvar.setEnabled(true);
				btsalvar.setVisible(true);
			}
		});

		btsalvar = new JButton();
		btsalvar.setText("Salvar");
		btsalvar.setForeground(Color.WHITE);
		btsalvar.setFont(new Font("Verdana", Font.BOLD, 11));
		btsalvar.setContentAreaFilled(false);
		btsalvar.setBorderPainted(false);
		btsalvar.setFocusPainted(false);
		btsalvar.setBounds(823, 497, 115, 30);
		btsalvar.setVisible(false);
		btsalvar.setEnabled(false);
		this.add(btsalvar);
		btsalvar.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				btsalvar.setBorderPainted(true);
			}
			
			public void mouseExited(MouseEvent e) {
				btsalvar.setBorderPainted(false);
			}
			
			public void mouseClicked(MouseEvent e) {
				SGProduto acaoEditar = new SGProduto();
				ProdutoDAO editardao = new ProdutoDAO();

				acaoEditar.setProduto(txtproduto.getText());
				acaoEditar.setImagem(txtlocalimagem.getText());
				acaoEditar.setModelo(txtmodelo.getText());
				acaoEditar.setTamanho(txttamanho.getText());
				acaoEditar.setCor(txtcor.getText());
				acaoEditar.setValor_custo(Float.parseFloat(txtvalor_custo.getText()));
				acaoEditar.setValor_venda(Float.parseFloat(txtvalor_venda.getText()));
				acaoEditar.setQuantidade(Integer.parseInt(txtquantidade.getText()));
				acaoEditar.setId(Integer.parseInt(txtcodproduto.getText()));
				editardao.alterar(acaoEditar);
					
				try {
					if (txtquantidade.getText().equals("0")) {

						lbstatus.setText("Indisponivel :(");
						lbstatus.setForeground(Color.red);

					} else {

						lbstatus.setText("Disponivel :)");
						lbstatus.setForeground(Color.green);
						
					}
				}
				catch (Exception e1) {
					System.out.println("Erro");
				}
				
				consulta = new ConsultaEstoque();
				consulta.Tabela();
				
				txtproduto.setEnabled(false);
				btalterarimagem.setVisible(false);
				txtlocalimagem.setVisible(false);
				txttamanho.setEnabled(false);
				txtcor.setEnabled(false);
				txtvalor_custo.setEnabled(false);
				txtvalor_venda.setEnabled(false);
				txtquantidade.setEnabled(false);
				txtmodelo.setEnabled(false);
				btsalvar.setEnabled(false);
				btsalvar.setVisible(false);
			}
		});

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

		lbfundo = new JLabel(new ImageIcon("src/Imagens/DescricaoEstoque.gif"));
		lbfundo.setLocation(0, 0);
		lbfundo.setSize(963, 550);
		this.add(lbfundo);
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
			result = localimageprod.showOpenDialog(DescricaoProduto.this);
			if (result == JFileChooser.APPROVE_OPTION) {
				String caminho = localimageprod.getSelectedFile().getPath();
				// Converte o valor da variavel caminho para ImageIcon
				ImageIcon icon1 = new ImageIcon(caminho);
				// Redimensionaliza o tamanho da imagem de acordo com a JLabel
				lbimagemprod.setIcon(new ImageIcon(icon1.getImage().getScaledInstance(lbimagemprod.getWidth(),lbimagemprod.getHeight(), Image.SCALE_DEFAULT)));
				txtlocalimagem.setText(caminho);
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
	
	public void enviadodatabela(String codigo) {
		
		txtlocalizar.setText(codigo);
		
		try{

			String recebido =  txtlocalizar.getText();
			ProdutoDAO cdao = new ProdutoDAO();
			SGProduto pro = new SGProduto();

			pro = cdao.consultar(recebido);
			txtproduto.setText(pro.getProduto());
			lbimagemprod.setText(pro.getImagem());
			txtlocalimagem.setText(pro.getImagem());
			txtcodproduto.setText(Integer.toString(pro.getId()));
			txtmodelo.setText(pro.getModelo());
			txttamanho.setText(pro.getTamanho());
			txtcor.setText(pro.getCor());
			txtvalor_custo.setText(Float.toString(pro.getValor_custo()));
			txtvalor_venda.setText(Float.toString(pro.getValor_venda()));
			txtquantidade.setText(Integer.toString(pro.getQuantidade()));

			caminho = lbimagemprod.getText();
			ImageIcon mostrarImagem = new ImageIcon(caminho);
			lbimagemprod.setIcon(new ImageIcon(mostrarImagem.getImage().getScaledInstance(lbimagemprod.getWidth(),lbimagemprod.getHeight(),Image.SCALE_DEFAULT)));

			try {
				if (txtquantidade.getText().equals("0")) {

					lbstatus.setText("Indisponivel :(");
					lbstatus.setForeground(Color.red);

				} else {

					lbstatus.setText("Disponivel :)");
					lbstatus.setForeground(Color.green);
					
				}
			} catch (Exception e1) {
				System.out.println("Erro");
			}

			txtlocalizar.setText("");

			bteditar.setEnabled(true);

		} 
		catch (Exception ee) {
			JOptionPane.showMessageDialog(null, "Produto não localizado, verifique se o Produto ou ID foi digitado corretamente.");

			txtlocalizar.setText("");
			txtproduto.setText("");
			lbimagemprod.setIcon(new ImageIcon());
			lbimagemprod.setText("");
			txtcodproduto.setText("");
			txtmodelo.setText("");
			txttamanho.setText("");
			txtcor.setText("");
			txtvalor_custo.setText("");
			txtvalor_venda.setText("");
			txtquantidade.setText("");
			lbstatus.setText("");

			bteditar.setEnabled(false);
		}
	}
	
	public static void main(String[] args) {
		new DescricaoProduto().setVisible(true);
	}
}
