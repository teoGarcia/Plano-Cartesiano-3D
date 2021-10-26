package Vista;

import java.awt.BorderLayout;

import Control.ControlVistaSesion;
import Control.ControlVistas;

import com.sun.awt.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.text.Utilities;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import org.omg.CORBA.Bounds;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class VistaInicioSesion extends JFrame{
	
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private JLabel lblIniciarSesion;
	private JLabel lblHazOlvidado;
	private ControlVistaSesion cvs;
	private JButton btnIngresar;
	private JLabel lblImagenClave;
	private ControlVistas cv;
	private JLabel lblRegistrate;
	
	
	/**
	 * Launch the application.
	 */
	
	public VistaInicioSesion(ControlVistas cv) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaInicioSesion.class.getResource("/Imagenes/IconoOriginal.png")));
		setTitle("SpaVecGenerator");

		this.setCv(cv);
		Contenido();
	}

	/**
	 * Create the frame.
	 */
	public void Contenido() {
		
		cvs = new ControlVistaSesion(this);
		
		
		setBounds(100, 100, 339, 389);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		//setResizable(false);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		txtUsuario.setToolTipText("Escribe aqui el usuario");
		txtUsuario.setBounds(74, 112, 222, 41);
		txtUsuario.addKeyListener(cvs);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Escribe aqui la clave");
		passwordField.setBounds(74, 185, 222, 41);
		passwordField.addKeyListener(cvs);
		getContentPane().add(passwordField);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setForeground(SystemColor.desktop);
		btnIngresar.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnIngresar.setIcon(new ImageIcon(VistaInicioSesion.class.getResource("/Imagenes/ingresarbtn.png")));
		btnIngresar.setBounds(93, 287, 161, 53);
		btnIngresar.addActionListener(cvs);
		btnIngresar.addKeyListener(cvs);
		getContentPane().add(btnIngresar);
		
		JLabel lblImagenUsuario = new JLabel("");
		lblImagenUsuario.setIcon(new ImageIcon(VistaInicioSesion.class.getResource("/Imagenes/Usuario.png")));
		lblImagenUsuario.setBounds(18, 112, 46, 41);
		
		getContentPane().add(lblImagenUsuario);
		
		lblIniciarSesion = new JLabel("Iniciar Sesion");
		lblIniciarSesion.setForeground(SystemColor.textHighlightText);
		lblIniciarSesion.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblIniciarSesion.setBounds(101, 41, 153, 41);
		getContentPane().add(lblIniciarSesion);
		
		lblHazOlvidado = new JLabel("\u00BFOlvidaste tu clave?  ");
		lblHazOlvidado.setForeground(SystemColor.textHighlightText);
		lblHazOlvidado.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblHazOlvidado.setBounds(178, 229, 146, 23);
		lblHazOlvidado.addMouseListener(cvs);
		getContentPane().add(lblHazOlvidado);
		
		lblImagenClave = new JLabel("");
		lblImagenClave.setIcon(new ImageIcon(VistaInicioSesion.class.getResource("/Imagenes/clave.png")));
		lblImagenClave.setBounds(18, 185, 46, 41);
		getContentPane().add(lblImagenClave);
		
		lblRegistrate = new JLabel("Registrate");
		lblRegistrate.setForeground(SystemColor.textHighlightText);
		lblRegistrate.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblRegistrate.setBounds(74, 230, 94, 21);
		lblRegistrate.addMouseListener(cvs);
		getContentPane().add(lblRegistrate);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(VistaInicioSesion.class.getResource("/Imagenes/FondoAzul.jpeg")));
		lblImagen.setBounds(0, 0, 334, 362);
		getContentPane().add(lblImagen);
		
	}

	public JLabel getLblIniciarSesion() {
		return lblIniciarSesion;
	}

	public void setLblIniciarSesion(JLabel lblIniciarSesion) {
		this.lblIniciarSesion = lblIniciarSesion;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JLabel getLblHazOlvidado() {
		return lblHazOlvidado;
	}

	public void setLblHazOlvidado(JLabel lblHazOlvidado) {
		this.lblHazOlvidado = lblHazOlvidado;
	}

	public JButton getBtnIngresar() {
		return btnIngresar;
	}

	public void setBtnIngresar(JButton btnIngresar) {
		this.btnIngresar = btnIngresar;
	}

	public ControlVistas getCv() {
		return cv;
	}

	public void setCv(ControlVistas cv) {
		this.cv = cv;
	}

	public JLabel getLblRegistrate() {
		return lblRegistrate;
	}

	public void setLblRegistrate(JLabel lblRegistrate) {
		this.lblRegistrate = lblRegistrate;
	}
}
