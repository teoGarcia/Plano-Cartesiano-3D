package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import Control.ControlVistaPaletaColores;
import Control.ControlVistas;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.Window.Type;

public class VistaPaletaColores extends JFrame {

	private JPanel contentPane;
	private JLabel lblRojo;
	private JLabel lblNegro;
	private JLabel lblColorGeneral;
	private JLabel lblVerde;
	private JLabel lblAzul;
	private JLabel lblAzulClaro;
	private JLabel lblPurpura;
	private JLabel lblRosado;
	private JLabel lblAmarillo;
	private JLabel lblNombreColor;
	
	private ControlVistas cv;
	private JButton btnAceptar;
	private JButton btnRegresar;

	public VistaPaletaColores(ControlVistas cv) {
		
		this.cv=cv;
		Contenido();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Create the frame.
	 */
	public void Contenido() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Selecciona un color");

		ControlVistaPaletaColores cvpc = new ControlVistaPaletaColores(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 180);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		lblColorGeneral = new JLabel("");
		lblColorGeneral.setBackground(Color.WHITE);
		lblColorGeneral.setForeground(Color.BLACK);
		lblColorGeneral.setOpaque(true);
		lblColorGeneral.addMouseListener(cvpc);
		lblColorGeneral.setBounds(27, 11, 69, 55);
		contentPane.add(lblColorGeneral);
		
		lblNegro = new JLabel("");
		lblNegro.setToolTipText("Negro");
		lblNegro.setBackground(Color.BLACK);
		lblNegro.setBounds(149, 11, 29, 26);
		lblNegro.setOpaque(true);
		lblNegro.addMouseListener(cvpc);
		contentPane.add(lblNegro);
		
		lblRojo = new JLabel("");
		lblRojo.setToolTipText("Rojo");
		lblRojo.setBackground(Color.RED);
		lblRojo.setBounds(149, 55, 29, 26);
		lblRojo.setOpaque(true);
		lblRojo.addMouseListener(cvpc);
		contentPane.add(lblRojo);
		
		lblVerde = new JLabel("");
		lblVerde.setToolTipText("Verde");
		lblVerde.setBackground(Color.GREEN);
		lblVerde.setBounds(211, 11, 29, 26);
		lblVerde.setOpaque(true);
		lblVerde.addMouseListener(cvpc);
		contentPane.add(lblVerde);
		
		lblAzul = new JLabel("");
		lblAzul.setToolTipText("Azul");
		lblAzul.setBackground(Color.BLUE);
		lblAzul.setBounds(211, 55, 29, 26);
		lblAzul.setOpaque(true);
		lblAzul.addMouseListener(cvpc);
		contentPane.add(lblAzul);
		
		lblAzulClaro = new JLabel("");
		lblAzulClaro.setToolTipText("Turquesa");
		lblAzulClaro.setBackground(new Color(0, 255, 255));
		lblAzulClaro.setBounds(269, 11, 29, 26);
		lblAzulClaro.setOpaque(true);
		lblAzulClaro.addMouseListener(cvpc);
		contentPane.add(lblAzulClaro);
		
		lblPurpura = new JLabel("");
		lblPurpura.setToolTipText("P\u00FArpura");
		lblPurpura.setBackground(new Color(128, 0, 128));
		lblPurpura.setBounds(269, 55, 29, 26);
		lblPurpura.setOpaque(true);
		lblPurpura.addMouseListener(cvpc);
		contentPane.add(lblPurpura);
		
		lblAmarillo = new JLabel("");
		lblAmarillo.setToolTipText("Amarillo");
		lblAmarillo.setBackground(new Color(255, 255, 0));
		lblAmarillo.setBounds(321, 11, 29, 26);
		lblAmarillo.setOpaque(true);
		lblAmarillo.addMouseListener(cvpc);
		contentPane.add(lblAmarillo);
		
		lblRosado = new JLabel("");
		lblRosado.setToolTipText("Rosa");
		lblRosado.setBackground(new Color(255, 128, 128));
		lblRosado.setBounds(321, 55, 29, 26);
		lblRosado.setOpaque(true);
		lblRosado.addMouseListener(cvpc);
		contentPane.add(lblRosado);
		
		lblNombreColor = new JLabel("Color");
		lblNombreColor.setBounds(27, 67, 77, 30);
		contentPane.add(lblNombreColor);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(61, 119, 94, 26);
		btnAceptar.addActionListener(cvpc);
		contentPane.add(btnAceptar);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(231, 120, 89, 25);
		btnRegresar.addActionListener(cvpc);
		contentPane.add(btnRegresar);
	}

	public JLabel getLblRojo() {
		return lblRojo;
	}

	public void setLblRojo(JLabel lblRojo) {
		this.lblRojo = lblRojo;
	}

	public JLabel getLblNegro() {
		return lblNegro;
	}

	public void setLblNegro(JLabel lblNegro) {
		this.lblNegro = lblNegro;
	}

	public JLabel getLblColorGeneral() {
		return lblColorGeneral;
	}

	public void setLblColorGeneral(JLabel lblColorGeneral) {
		this.lblColorGeneral = lblColorGeneral;
	}

	public JLabel getLblVerde() {
		return lblVerde;
	}

	public void setLblVerde(JLabel lblVerde) {
		this.lblVerde = lblVerde;
	}

	public JLabel getLblAzul() {
		return lblAzul;
	}

	public void setLblAzul(JLabel lblAzul) {
		this.lblAzul = lblAzul;
	}

	public JLabel getLblAzulClaro() {
		return lblAzulClaro;
	}

	public void setLblAzulClaro(JLabel lblAzulClaro) {
		this.lblAzulClaro = lblAzulClaro;
	}

	public JLabel getLblPurpura() {
		return lblPurpura;
	}

	public void setLblPurpura(JLabel lblPurpura) {
		this.lblPurpura = lblPurpura;
	}

	public JLabel getLblRosado() {
		return lblRosado;
	}

	public void setLblRosado(JLabel lblRosado) {
		this.lblRosado = lblRosado;
	}

	public JLabel getLblAmarillo() {
		return lblAmarillo;
	}

	public void setLblAmarillo(JLabel lblAmarillo) {
		this.lblAmarillo = lblAmarillo;
	}

	public JLabel getLblNombreColor() {
		return lblNombreColor;
	}

	public void setLblNombreColor(JLabel lblNombreColor) {
		this.lblNombreColor = lblNombreColor;
	}

	public ControlVistas getCv() {
		return cv;
	}

	public void setCv(ControlVistas cv) {
		this.cv = cv;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	public JButton getBtnRegresar() {
		return btnRegresar;
	}

	public void setBtnRegresar(JButton btnRegresar) {
		this.btnRegresar = btnRegresar;
	}
}
