package Telas;

import javax.swing.JFrame;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import Acoes.FuncionarioDAO;
import Acoes.SGFuncionario;
import Acoes.Validacao;

public class DescricaoFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	MaskFormatter maskcpf,maskrg,masknas,maskadm,masktel,maskcel;
	private JButton btbuscar, btsalvar, bteditar;
	private JLabel lbldadospessoais, lblnome, lblsobrenome, lblId, lblcpf, lblrg,lbldatanasc, lbltelefone, lblcelular,
	lblendereco, lblN, lblGenero, lbldadoscolaborador, lblcargo, lblemail, lbldataadm, lblativoinativo, lblbackground;
	private JTextField txtbuscar, txtnome, txtsobrenome, txtid, txtcpf, txtrg, txtdatanasc, txtemail, txttelefone,
	txtcelular, txtcargo, txtdataadm, txtendereco, txtativoinativo, txtgenero, txtnumero;

	public DescricaoFuncionario() {
		
		setTitle("Descrição Funcionário");
		setBounds(210, 100, 969, 579);
		setResizable(false);
		setLayout(null);
		dispose();
		
		try {

			maskcpf = new  MaskFormatter("###.###.###-##");
			maskrg = new  MaskFormatter("##.###.###-#");
			masknas = new  MaskFormatter("##/##/####");
			maskadm = new  MaskFormatter("##/##/####");
			masktel = new  MaskFormatter("(##) ####-####");
			maskcel = new  MaskFormatter("(##) #####-####");

		} catch (Exception e) {
		}
		
		//BOTÕES
		btbuscar = new JButton("");
		btbuscar.setIcon(new ImageIcon("src/Imagens/lupa.png"));
		btbuscar.setContentAreaFilled(false);
		btbuscar.setBorderPainted(false);
		btbuscar.setFocusPainted(false);
		btbuscar.setBounds(889, 104, 59, 28);
		this.add(btbuscar);
		btbuscar.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				btbuscar.setBorderPainted(true);
			}
			
			public void mouseExited(MouseEvent e) {
				btbuscar.setBorderPainted(false);
			}
			
			public void mouseClicked(MouseEvent e) {
				
			}
		});

		btsalvar = new JButton("Salvar");
		btsalvar.setEnabled(false);
		btsalvar.setForeground(Color.WHITE);
		btsalvar.setFont(new Font("Verdana", Font.BOLD, 11));
		btsalvar.setContentAreaFilled(false);
		btsalvar.setBorderPainted(false);
		btsalvar.setFocusPainted(false);
		btsalvar.setVisible(false);
		btsalvar.setBounds(828, 489, 100, 23);
		this.add(btsalvar);
		btsalvar.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				btsalvar.setBorderPainted(true);
			}
			
			public void mouseExited(MouseEvent e) {
				btsalvar.setBorderPainted(false);
			}
			
			public void mouseClicked(MouseEvent e) {
				txtnome.setEditable(false);
				txtsobrenome.setEditable(false);
				txtcpf.setEditable(false);
				txtrg.setEditable(false);
				txtdatanasc.setEditable(false);
				txtemail.setEditable(false);
				txttelefone.setEditable(false);
				txtcelular.setEditable(false);
				txtcargo.setEditable(false);
				txtdataadm.setEditable(false);
				txtendereco.setEditable(false);
				txtativoinativo.setEditable(false);
				txtgenero.setEditable(false);
				txtnumero.setEditable(false);
				btsalvar.setEnabled(false);
				btsalvar.setVisible(false);
				
                boolean status = Validacao.email_Validation(txtemail.getText());
				
				if(status == true) {
				
				FuncionarioDAO comandos = new FuncionarioDAO();
				SGFuncionario funcionario = new SGFuncionario();
				
				funcionario.setIdfunc(Integer.parseInt(txtid.getText()));
				funcionario.setNome(txtnome.getText());
				funcionario.setSobrenome(txtsobrenome.getText());
				funcionario.setEndereco(txtendereco.getText());
				funcionario.setNumero(txtnumero.getText());	
				funcionario.setDatanasc(txtdatanasc.getText());
				funcionario.setCel(txtcelular.getText());
				funcionario.setTel(txttelefone.getText());
				funcionario.setEmail(txtemail.getText());
				funcionario.setCpf(txtcpf.getText());
				funcionario.setRg(txtrg.getText());
				funcionario.setDataadm(txtdataadm.getText());				
				funcionario.setFuncao(txtcargo.getText());
				funcionario.setAtivo(txtativoinativo.getText());
				funcionario.setSexo(txtgenero.getText());
				comandos.alterar(funcionario);
				} 
			else {
				JOptionPane.showMessageDialog(null,"Email inválido");
			}
			}
		});
		
		//COMANDO PARA DAR UPDATE DO BANCO DE DADOS
		
		
		bteditar = new JButton("Editar");
		bteditar.setForeground(Color.WHITE);
		bteditar.setFont(new Font("Verdana", Font.BOLD, 12));
		bteditar.setContentAreaFilled(false);
		bteditar.setBorderPainted(false);
		bteditar.setFocusPainted(false);
		bteditar.setBounds(828, 455, 100, 23);
		this.add(bteditar);
		bteditar.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				bteditar.setBorderPainted(true);
			}
			
			public void mouseExited(MouseEvent e) {
				bteditar.setBorderPainted(false);
			}
			
			public void mouseClicked(MouseEvent e) {
				txtnome.setEditable(true);
				txtsobrenome.setEditable(true);
				txtcpf.setEditable(true);
				txtrg.setEditable(true);
				txtdatanasc.setEditable(true);
				txtemail.setEditable(true);
				txttelefone.setEditable(true);
				txtcelular.setEditable(true);
				txtcargo.setEditable(true);
				txtdataadm.setEditable(true);
				txtendereco.setEditable(true);
				txtativoinativo.setEditable(true);
				txtgenero.setEditable(true);
				txtnumero.setEditable(true);
				btsalvar.setEnabled(true);
				btsalvar.setVisible(true);
			}
		});
		
		//lABELS PARA TITULO DAS TEXT FIELD'S
		lbldadospessoais = new JLabel("Dados Pessoais:");
		lbldadospessoais.setForeground(Color.WHITE);
		lbldadospessoais.setFont(new Font("Verdana", Font.BOLD, 15));
		lbldadospessoais.setBounds(44, 190, 134, 14);
		this.add(lbldadospessoais);
		
		lblnome = new JLabel("Nome");
		lblnome.setForeground(Color.WHITE);
		lblnome.setFont(new Font("Verdana", Font.BOLD, 13));
		lblnome.setBounds(70, 235, 46, 14);
		this.add(lblnome);
		
		lblsobrenome = new JLabel("Sobrenome");
		lblsobrenome.setForeground(Color.WHITE);
		lblsobrenome.setFont(new Font("Verdana", Font.BOLD, 13));
		lblsobrenome.setBounds(356, 235, 83, 14);
		this.add(lblsobrenome);
		
		lblId = new JLabel("ID");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Verdana", Font.BOLD, 13));
		lblId.setBounds(702, 235, 16, 14);
		this.add(lblId);
		
		lblcpf = new JLabel("CPF");
		lblcpf.setForeground(Color.WHITE);
		lblcpf.setFont(new Font("Verdana", Font.BOLD, 13));
		lblcpf.setBounds(70, 271, 28, 14);
		this.add(lblcpf);
		
		lblrg = new JLabel("RG");
		lblrg.setForeground(Color.WHITE);
		lblrg.setFont(new Font("Verdana", Font.BOLD, 13));
		lblrg.setBounds(70, 303, 28, 14);
		this.add(lblrg);
		
		lbldatanasc = new JLabel("Data de Nascimento");
		lbldatanasc.setForeground(Color.WHITE);
		lbldatanasc.setFont(new Font("Verdana", Font.BOLD, 13));
		lbldatanasc.setBounds(462, 271, 146, 14);
		this.add(lbldatanasc);
		
		lbltelefone = new JLabel("Telefone");
		lbltelefone.setForeground(Color.WHITE);
		lbltelefone.setFont(new Font("Verdana", Font.BOLD, 13));
		lbltelefone.setBounds(250, 271, 70, 14);
		this.add(lbltelefone);
		
		lblcelular = new JLabel("Celular");
		lblcelular.setForeground(Color.WHITE);
		lblcelular.setFont(new Font("Verdana", Font.BOLD, 13));
		lblcelular.setBounds(250, 303, 70, 14);
		this.add(lblcelular);
		
		lblendereco = new JLabel("Endere\u00E7o");
		lblendereco.setForeground(Color.WHITE);
		lblendereco.setFont(new Font("Verdana", Font.BOLD, 13));
		lblendereco.setBounds(70, 337, 70, 14);
		this.add(lblendereco);
		
		lblN = new JLabel("N\u00BA");
		lblN.setForeground(Color.WHITE);
		lblN.setFont(new Font("Verdana", Font.BOLD, 13));
		lblN.setBounds(638, 339, 18, 14);
		this.add(lblN);
		
		lblGenero = new JLabel("Genero");
		lblGenero.setForeground(Color.WHITE);
		lblGenero.setFont(new Font("Verdana", Font.BOLD, 12));
		lblGenero.setBounds(462, 305, 53, 14);
		this.add(lblGenero);
		
		lbldadoscolaborador = new JLabel("Dados do Colaborador:");
		lbldadoscolaborador.setForeground(Color.WHITE);
		lbldadoscolaborador.setFont(new Font("Verdana", Font.BOLD, 15));
		lbldadoscolaborador.setBounds(44, 394, 194, 14);
		this.add(lbldadoscolaborador);
		
		lblcargo = new JLabel("Cargo");
		lblcargo.setForeground(Color.WHITE);
		lblcargo.setFont(new Font("Verdana", Font.BOLD, 13));
		lblcargo.setBounds(70, 430, 46, 20);
		this.add(lblcargo);
		
		lblemail = new JLabel("Email");
		lblemail.setForeground(Color.WHITE);
		lblemail.setFont(new Font("Verdana", Font.BOLD, 13));
		lblemail.setBounds(356, 433, 46, 14);
		this.add(lblemail);
		
		lbldataadm = new JLabel("Data de Admi\u00E7\u00E3o");
		lbldataadm.setForeground(Color.WHITE);
		lbldataadm.setFont(new Font("Verdana", Font.BOLD, 13));
		lbldataadm.setBounds(70, 474, 123, 14);
		this.add(lbldataadm);
		
		lblativoinativo = new JLabel("Ativo/Inativo");
		lblativoinativo.setForeground(Color.WHITE);
		lblativoinativo.setFont(new Font("Verdana", Font.BOLD, 13));
		lblativoinativo.setBounds(356, 474, 100, 14);
		this.add(lblativoinativo);
		
		//TEXT FIELD'S
		txtbuscar = new JTextField();
		txtbuscar.setBounds(440, 104, 449, 29);
		this.add(txtbuscar);
		
		txtnome = new JTextField();
		txtnome.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtnome.setEditable(false);
		txtnome.setBounds(126, 233, 200, 20);
		this.add(txtnome);
		
		txtsobrenome = new JTextField();
		txtsobrenome.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtsobrenome.setEditable(false);
		txtsobrenome.setBounds(451, 233, 200, 20);
		this.add(txtsobrenome);
		
		txtendereco = new JTextField();
		txtendereco.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtendereco.setEditable(false);
		txtendereco.setBounds(150, 335, 478, 20);
		this.add(txtendereco);
		
		txtnumero = new JTextField();
		txtnumero.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtnumero.setEditable(false);
		txtnumero.setBounds(666, 336, 46, 20);
		this.add(txtnumero);
		
		txtgenero = new JTextField();
		txtgenero.setEditable(false);
		txtgenero.setBounds(525, 302, 100, 20);
		this.add(txtgenero);
		
		txtcargo = new JTextField();
		txtcargo.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtcargo.setEditable(false);
		txtcargo.setBounds(126, 431, 194, 20);
		this.add(txtcargo);
		
		txtemail = new JTextField();
		txtemail.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtemail.setEditable(false);
		txtemail.setBounds(412, 431, 186, 20);
		this.add(txtemail);
		
		txtativoinativo = new JTextField();
		txtativoinativo.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtativoinativo.setEditable(false);
		txtativoinativo.setBounds(462, 472, 100, 20);
		this.add(txtativoinativo);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtid.setEditable(false);
		txtid.setBounds(728, 233, 86, 20);
		this.add(txtid);
		
		//TEXT FIELD'S COM MASCARA
		txtcpf = new JFormattedTextField(maskcpf);
		txtcpf.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtcpf.setEditable(false);
		txtcpf.setBounds(104, 269, 100, 20);
		this.add(txtcpf);
		
		txtrg = new JFormattedTextField(maskrg);
		txtrg.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtrg.setEditable(false);
		txtrg.setBounds(104, 301, 100, 20);
		this.add(txtrg);
		
		txttelefone = new JFormattedTextField(masktel);
		txttelefone.setFont(new Font("Verdana", Font.PLAIN, 11));
		txttelefone.setEditable(false);
		txttelefone.setBounds(325, 269, 100, 20);
		this.add(txttelefone);
		
		txtcelular = new JFormattedTextField(maskcel);
		txtcelular.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtcelular.setEditable(false);
		txtcelular.setBounds(325, 301, 100, 20);
		this.add(txtcelular);
		
		txtdatanasc = new JFormattedTextField(masknas);
		txtdatanasc.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtdatanasc.setEditable(false);
		txtdatanasc.setBounds(618, 269, 100, 20);
		this.add(txtdatanasc);
		
		txtdataadm = new JFormattedTextField(maskadm);
		txtdataadm.setEditable(false);
		txtdataadm.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtdataadm.setBounds(203, 472, 100, 20);
		this.add(txtdataadm);
		
		//COMANDOS PARA CONSULTA NO BANCO DE DADOS
		btbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try{
					String digitado =  txtbuscar.getText();
					FuncionarioDAO cdao = new FuncionarioDAO();
					SGFuncionario pro = new SGFuncionario();

					pro = cdao.consultar(digitado);
					txtid.setText(Integer.toString(pro.getIdfunc()));
				    txtnome.setText(pro.getNome());
					txtsobrenome.setText(pro.getSobrenome());
					txtendereco.setText(pro.getEndereco());
					txtnumero.setText(pro.getNumero());
					txtdatanasc.setText(pro.getDatanasc());
					txtcelular.setText(pro.getCel());
					txttelefone.setText(pro.getTel());
					txtemail.setText(pro.getEmail());
					txtgenero.setText(pro.getSexo());
					txtcpf.setText(pro.getCpf());
					txtrg.setText(pro.getRg());
					txtdataadm.setText(pro.getDataadm());				
					txtcargo.setText(pro.getFuncao());
					txtativoinativo.setText(pro.getAtivo());
					
					txtbuscar.setText("");

				} 
				catch (Exception ee) {
					JOptionPane.showMessageDialog(null, "Funcionário não localizado, verifique se o ID foi digitado corretamente.");
					
					txtid.setText("");
					txtnome.setText("");
                    txtsobrenome.setText("");
                    txtendereco.setText("");
                    txtnumero.setText("");	
                    txtdatanasc.setText("");
                    txtcelular.setText("");
                    txttelefone.setText("");
                    txtemail.setText("");
                    txtgenero.setText("");
                    txtcpf.setText("");
                    txtrg.setText("");
                    txtdataadm.setText("");				
                    txtcargo.setText("");
                    txtativoinativo.setText("");
                    
				}
			}
		});

		txtbuscar.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					try{

						String digitado =  txtbuscar.getText();
						FuncionarioDAO cdao = new FuncionarioDAO();
						SGFuncionario pro = new SGFuncionario();

						pro = cdao.consultar(digitado);
						txtid.setText(Integer.toString(pro.getIdfunc()));
					    txtnome.setText(pro.getNome());
						txtsobrenome.setText(pro.getSobrenome());
						txtendereco.setText(pro.getEndereco());
						txtnumero.setText(pro.getNumero());	
						txtdatanasc.setText(pro.getDatanasc());
						txtcelular.setText(pro.getCel());
						txttelefone.setText(pro.getTel());
						txtemail.setText(pro.getEmail());
						txtgenero.setText(pro.getSexo());
						txtcpf.setText(pro.getCpf());
						txtrg.setText(pro.getRg());
						txtdataadm.setText(pro.getDataadm());				
						txtcargo.setText(pro.getFuncao());
						txtativoinativo.setText(pro.getAtivo());

						txtbuscar.setText("");
						
					} 
					catch (Exception ee) {
						JOptionPane.showMessageDialog(null, "Produto não localizado, verifique se o Produto ou ID foi digitado corretamente.");
						
						txtid.setText("");
						txtnome.setText("");
	                    txtsobrenome.setText("");
	                    txtendereco.setText("");
	                    txtnumero.setText("");	
	                    txtdatanasc.setText("");
	                    txtcelular.setText("");
	                    txttelefone.setText("");
	                    txtemail.setText("");
	                    txtgenero.setText("");
	                    txtcpf.setText("");
	                    txtrg.setText("");
	                    txtdataadm.setText("");				
	                    txtcargo.setText("");
	                    txtativoinativo.setText("");
						
					}
				}
			}
		});
		
		//BACKGROUND
		lblbackground = new JLabel("");
		lblbackground.setFont(new Font("Verdana", Font.BOLD, 13));
		lblbackground.setForeground(Color.WHITE);
		lblbackground.setBounds(0, 0, 963, 541);
		lblbackground.setIcon(new ImageIcon("src/Imagens/DescricaoFuncionario.gif"));
		this.add(lblbackground);
	}
	
	public void enviadodatabela(String codigo) {
		
		txtbuscar.setText(codigo);
		
		try{
			String recebido =  txtbuscar.getText();
			FuncionarioDAO cdao = new FuncionarioDAO();
			SGFuncionario pro = new SGFuncionario();

			pro = cdao.consultar(recebido);
			txtid.setText(Integer.toString(pro.getIdfunc()));
		    txtnome.setText(pro.getNome());
			txtsobrenome.setText(pro.getSobrenome());
			txtendereco.setText(pro.getEndereco());
			txtnumero.setText(pro.getNumero());
			txtdatanasc.setText(pro.getDatanasc());
			txtcelular.setText(pro.getCel());
			txttelefone.setText(pro.getTel());
			txtemail.setText(pro.getEmail());
			txtgenero.setText(pro.getSexo());
			txtcpf.setText(pro.getCpf());
			txtrg.setText(pro.getRg());
			txtdataadm.setText(pro.getDataadm());				
			txtcargo.setText(pro.getFuncao());
			txtativoinativo.setText(pro.getAtivo());
			
			txtbuscar.setText("");

		} 
		catch (Exception ee) {
			JOptionPane.showMessageDialog(null, "Produto não localizado, verifique se o Produto ou ID foi digitado corretamente.");
			
			txtid.setText("");
			txtnome.setText("");
            txtsobrenome.setText("");
            txtendereco.setText("");
            txtnumero.setText("");	
            txtdatanasc.setText("");
            txtcelular.setText("");
            txttelefone.setText("");
            txtemail.setText("");
            txtgenero.setText("");
            txtcpf.setText("");
            txtrg.setText("");
            txtdataadm.setText("");				
            txtcargo.setText("");
            txtativoinativo.setText("");
            
		}
	}
	
	public static void main(String[] args) {
		new DescricaoFuncionario().setVisible(true);
	}
}
