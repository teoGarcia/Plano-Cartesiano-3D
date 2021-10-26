package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.SystemColor;

import javax.swing.JButton;

import Control.ControlMenu;
import Control.ControlVistas;
import java.awt.Color;
import java.awt.Toolkit;

public class VistaMenu extends JFrame {

	private JPanel contentPane;
	private ControlVistas cv;
	private ControlMenu cm;
	private JButton btnGrficar;
	private JButton btnVectorUnitario;
	private JButton btnEjemplos;
	private JLabel lblCerrarSesion;

	public VistaMenu(ControlVistas cv) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaMenu.class.getResource("/Imagenes/IconoOriginal.png")));
		this.cv = cv;
		contenido();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Create the frame.
	 */
		public void contenido() {
			
		cm = new ControlMenu(this);
			
		setTitle("SpaVecGenerator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 390);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnGrficar = new JButton("Gr\u00E1ficar");
		btnGrficar.setBackground(Color.WHITE);
		btnGrficar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnGrficar.setIcon(new ImageIcon(VistaMenu.class.getResource("/Imagenes/GraficarMenu.png")));
		btnGrficar.setBounds(27, 100, 245, 81);
		btnGrficar.addActionListener(cm);
		contentPane.add(btnGrficar);
		
		btnVectorUnitario = new JButton("Vector Unitario");
		btnVectorUnitario.setIcon(new ImageIcon(VistaMenu.class.getResource("/Imagenes/VectorUnitarioMenu1.png")));
		btnVectorUnitario.setFont(new Font("Arial", Font.PLAIN, 18));
		btnVectorUnitario.setBackground(Color.WHITE);
		btnVectorUnitario.setBounds(355, 100, 256, 81);
		btnVectorUnitario.addActionListener(cm);
		contentPane.add(btnVectorUnitario);
		
		
		btnEjemplos = new JButton("Ejemplos");
		btnEjemplos.setIcon(new ImageIcon(VistaMenu.class.getResource("/Imagenes/Ejemplos.png")));
		btnEjemplos.setFont(new Font("Arial", Font.PLAIN, 18));
		btnEjemplos.setBackground(Color.WHITE);
		btnEjemplos.setBounds(200, 238, 233, 81);
		btnEjemplos.addActionListener(cm);
		contentPane.add(btnEjemplos);
		
		lblCerrarSesion = new JLabel("");
		lblCerrarSesion.setIcon(new ImageIcon(VistaMenu.class.getResource("/Imagenes/Borrar.png")));
		lblCerrarSesion.setForeground(SystemColor.textHighlightText);
		lblCerrarSesion.setToolTipText("Salir");
		lblCerrarSesion.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblCerrarSesion.setBounds(475, 11, 159, 27);
		lblCerrarSesion.addMouseListener(cm);
		contentPane.add(lblCerrarSesion);
		
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(VistaMenu.class.getResource("/Imagenes/FondoAzul.jpeg")));
		lblFondo.setBounds(0, 0, 634, 362);
		contentPane.add(lblFondo);
	}

	public JButton getBtnGrficar() {
		return btnGrficar;
	}

	public void setBtnGrficar(JButton btnGrficar) {
		this.btnGrficar = btnGrficar;
	}

	public JButton getBtnVectorUnitario() {
		return btnVectorUnitario;
	}

	public void setBtnVectorUnitario(JButton btnVectorUnitario) {
		this.btnVectorUnitario = btnVectorUnitario;
	}

	public JButton getBtnEjemplos() {
		return btnEjemplos;
	}

	public void setBtnEjemplos(JButton btnEjemplos) {
		this.btnEjemplos = btnEjemplos;
	}

	public ControlVistas getCv() {
		return cv;
	}

	public void setCv(ControlVistas cv) {
		this.cv = cv;
	}

	public JLabel getLblCerrarSesion() {
		return lblCerrarSesion;
	}

	public void setLblCerrarSesion(JLabel lblCerrarSesion) {
		this.lblCerrarSesion = lblCerrarSesion;
	}
}
