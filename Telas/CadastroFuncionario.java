package Telas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import Acoes.FuncionarioDAO;
import Acoes.SGFuncionario;
import Acoes.Validacao;
import Complementar.MascarasTShirt;

public class CadastroFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	MaskFormatter maskcpf, maskrg, masknas, maskadm, masktel, maskcel;
	private JTextField txtNumero, txtNome, txtSobrenome, txtFuncao, txtEndereco, txtUsuario, txtSalario, txtEmail;
	private JRadioButton sexFem, sexMas ;
	private JButton btnCadastrar, btnLogoff, btnMenuPrincipal;
	private JLabel lblNome, lblSobrenome, lblEndereco, lblNumero, lblDataNascimento, lblTelefone,
	lblCelular, lblEmail, lblCpf, lblRg, lblDataAdmissao, lblSalario, lblCargo, lblSenha, lblfundo;
	private JFormattedTextField txtDataNasc, txtTel, txtCel, txtCpf, txtRg, txtDataAdm;	;
	private JPasswordField txtSenha;
	private RadioButtonBorder genero;
	private ButtonGroup grupogenero;
	private String sexo;
	MascarasTShirt masc;
	
	public CadastroFuncionario(){
		
		setTitle("Cadastro de Funcionários");
		setBounds(180, 2, 1037, 740);
		setResizable(false);
		setLayout(null);
		dispose();
		
		txtNome = new JTextField();
		txtNome.setBounds(196, 220, 212, 26);
		this.add(txtNome);	
		
		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(196, 257, 212, 26);
		this.add(txtSobrenome);
		
		txtFuncao = new JTextField();
		txtFuncao.setBounds(564, 405, 212, 26);
		this.add(txtFuncao);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(196, 294, 212, 26);
		this.add(txtEndereco);
		
		txtNumero = new JFormattedTextField	();
		txtNumero.setBounds(196, 331, 212, 26);
		this.add(txtNumero);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(564, 442, 212, 26);
		this.add(txtUsuario);
		
		txtSenha = new JPasswordField();
		txtSenha.setName("");
		txtSenha.setToolTipText("");
		txtSenha.setBounds(564, 480, 212, 26);
		this.add(txtSenha);
		
		txtSalario = new JTextField();
		txtSalario.setBounds(564, 368, 212, 26);
		this.add(txtSalario);

		///////////////////////// RADIO BUTTON ////////////////////


		sexFem = new JRadioButton("Feminino", false);
		sexFem.setBounds(660, 226, 84, 26);
		sexFem.setLayout( new FlowLayout());
		this.add(sexFem);

		sexMas = new JRadioButton("Masculino", false);
		sexMas.setBounds(564, 226, 84, 26);
		sexMas.setLayout( new FlowLayout());
		this.add(sexMas);

		grupogenero = new ButtonGroup();
		grupogenero.add(sexFem);
		grupogenero.add(sexMas);

		this.add(sexFem);
		this.add(sexMas);

		sexFem.addItemListener((ItemListener) genero);
		sexMas.addItemListener((ItemListener) genero);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				if(sexMas.isSelected()) {
					sexo="Masculino";
				}	
				else {
					sexo="Feminino";
				}
				
				// Verificação do @ do email
				
				
				boolean status = Validacao.email_Validation(txtEmail.getText());
				
				if(status == true) {
					
					FuncionarioDAO funcDAO = new FuncionarioDAO();
					SGFuncionario funcionario = new SGFuncionario ();
					
					funcionario.setNome(txtNome.getText());
					funcionario.setSobrenome(txtSobrenome.getText());
					funcionario.setEndereco(txtEndereco.getText());
					funcionario.setNumero(txtNumero.getText());	
					funcionario.setDatanasc(txtDataNasc.getText());
					funcionario.setCel(txtCel.getText());
					funcionario.setTel(txtTel.getText());
					funcionario.setEmail(txtEmail.getText());
					funcionario.setCpf(txtCpf.getText());
					funcionario.setRg(txtRg.getText());
					funcionario.setSexo(sexo);
					funcionario.setDataadm(txtDataAdm.getText());				
					funcionario.setFuncao(txtFuncao.getText());
					funcionario.setSalario(Float.parseFloat(txtSalario.getText()));				
					funcionario.setUsuario(txtUsuario.getText());	
					funcionario.setSenha(txtSenha.getText());				
					funcionario.setAtivo("Ativo");
					funcDAO.inserir(funcionario);

					txtNumero.setText("");
					txtNome.setText("");
					txtSobrenome.setText("");
					txtFuncao.setText("");
					txtEndereco.setText("");
					txtUsuario.setText("");
					txtSalario.setText("");
					txtEmail.setText("");
					txtDataNasc.setText("");
					txtTel.setText("");
					txtCel.setText("");
					txtCpf.setText("");
					txtRg.setText("");
					txtDataAdm.setText("");		
					txtSenha.setText("");				
					txtNome.setText("");

					grupogenero.clearSelection();

					JOptionPane.showMessageDialog(null,"Usuário Cadastrado com sucesso!");
					
				}else {
					JOptionPane.showMessageDialog(null,"Email inválido");
				}
				
			

			}
		});
		
		btnCadastrar.setFocusPainted(false);
		btnCadastrar.setBackground(new Color(239,123,0));
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBounds(69, 591, 106, 36);
		this.add(btnCadastrar);
		
		btnLogoff = new JButton("LOGOFF");
		btnLogoff.setForeground(Color.WHITE);
		btnLogoff.setContentAreaFilled(false);
		btnLogoff.setBorderPainted(false);
		btnLogoff.setSelectedIcon(null);
		btnLogoff.setFocusPainted(false);
		btnLogoff.setIcon(null);
		btnLogoff.setBounds(900, 34, 111, 36);
		this.add(btnLogoff);
		//Altera o botão quando o mouse se aproxima
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
		
		btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setForeground(Color.WHITE);
		btnMenuPrincipal.setActionCommand("MenuPrincipal");
		btnMenuPrincipal.setContentAreaFilled(false);
		btnMenuPrincipal.setBorderPainted(false);
		btnMenuPrincipal.setFocusPainted(false);
		btnMenuPrincipal.setSize(new Dimension(10, 10));
		btnMenuPrincipal.setBounds(104, 34, 157, 36);
		this.add(btnMenuPrincipal);		
		btnMenuPrincipal.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				//Esta com o mouse sobre o botão
				btnMenuPrincipal.setBorderPainted(true);
			}
			
			public void mouseExited(MouseEvent e) {
				//Saiu com o mouse de cima do botão
				btnMenuPrincipal.setBorderPainted(false);
			}
			
			public void mouseClicked(MouseEvent e) {
				// Chamar a tela Home					
				dispose();
				Home home = new Home();
				home.setAlwaysOnTop(true);
			}
		});
		
		try {

			maskcpf = new  MaskFormatter("###.###.###-##");
			maskrg = new  MaskFormatter("##.###.###-#");
			masknas = new  MaskFormatter("##/##/####");
			maskadm = new  MaskFormatter("##/##/####");
			masktel = new  MaskFormatter("(##) ####-####");
			maskcel = new  MaskFormatter("(##) #####-####");

		} catch (Exception e) {
		}
		
		txtDataNasc = new JFormattedTextField(masknas);
		txtDataNasc.setBounds(196, 368, 212, 26);
		this.add(txtDataNasc);

		txtTel = new JFormattedTextField(masktel);
		txtTel.setBounds(196, 405, 212, 26);
		this.add(txtTel);

		txtCel = new JFormattedTextField(maskcel);
		txtCel.setBounds(196, 442, 212, 26);
		this.add(txtCel);

		txtEmail = new JTextField();
		txtEmail.setBounds(196, 480, 212, 26);
		this.add(txtEmail);

		txtCpf = new JFormattedTextField(maskcpf);
		txtCpf.setBounds(564, 257, 212, 26);
		this.add(txtCpf);

		txtRg = new JFormattedTextField(maskrg);
		txtRg.setBounds(564, 294, 212, 26);
		this.add(txtRg);

		txtDataAdm = new JFormattedTextField(maskadm);
		txtDataAdm.setBounds(564, 331, 212, 26);
		this.add(txtDataAdm);

		//////////////////////////////// LABEL'S ////////////////////////////////
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(74, 231, 76, 16);
		this.add(lblNome);


		lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setBounds(74, 269, 76, 14);
		this.add(lblSobrenome);
		
		lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBounds(74, 306, 76, 14);
		this.add(lblEndereco);
		
		lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setBounds(74, 343, 76, 14);
		this.add(lblNumero);


		lblDataNascimento = new JLabel("Data Nascimento");
		lblDataNascimento.setBounds(74, 380, 101, 14);
		this.add(lblDataNascimento);


		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(74, 417, 76, 14);
		this.add(lblTelefone);


		lblCelular = new JLabel("Celular");
		lblCelular.setBounds(74, 454, 76, 14);
		this.add(lblCelular);


		lblEmail = new JLabel("Email");
		lblEmail.setBounds(74, 492, 76, 14);
		this.add(lblEmail);


		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(463, 269, 91, 14);
		this.add(lblCpf);


		lblRg = new JLabel("RG");
		lblRg.setBounds(463, 306, 91, 14);
		this.add(lblRg);


		lblDataAdmissao = new JLabel("Data Admiss\u00E3o");
		lblDataAdmissao.setBounds(463, 337, 91, 14);
		this.add(lblDataAdmissao);


		lblSalario = new JLabel("Sal\u00E1rio");
		lblSalario.setBounds(463, 380, 84, 14);
		this.add(lblSalario);


		lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(463, 417, 91, 14);
		this.add(lblCargo);

		JLabel lblUsuario = new JLabel("Usuário");
		lblUsuario.setBounds(463, 454, 84, 14);
		this.add(lblUsuario);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(463, 492, 84, 14);
		this.add(lblSenha);

		lblfundo = new JLabel("");
		lblfundo.setIcon(new ImageIcon("src/Imagens/CadastroFuncionario.jpg"));
		lblfundo.setForeground(Color.BLACK);
		lblfundo.setBackground(SystemColor.window);
		lblfundo.setBounds(0, -11, 1021, 728);
		this.add(lblfundo);
	}
	
	public static void main(String[] args){
		new CadastroFuncionario().setVisible(true);
	}
}




