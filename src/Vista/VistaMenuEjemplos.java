package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import Control.ControlMenuEjemplos;
import Control.ControlVistas;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class VistaMenuEjemplos extends JFrame {

	private JPanel contentPane;
	private ControlVistas cv;
	private JButton btnPunto;
	private JButton btnCoordenadas3D;
	private JButton btnSegmento;
	private JButton btnVector;
	private JButton btnVectorUnitario;
	private JButton btnSumaDeVectores;
	private JButton btnAngulos;
	private JButton btnVectorDePosicion;
	private JLabel lblSalir;
	


	public VistaMenuEjemplos(ControlVistas cv) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaMenuEjemplos.class.getResource("/Imagenes/IconoOriginal.png")));
		setTitle("SpaVecGenerator");
		
		this.setCv(cv);
		Contenido();
	}


	/**
	 * Create the frame.
	 */
	public void Contenido() {
		
		ControlMenuEjemplos cme = new ControlMenuEjemplos(this);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		btnPunto = new JButton("Punto");
		btnPunto.setBounds(261, 29, 192, 62);
		btnPunto.addActionListener(cme);
		contentPane.add(btnPunto);
		
		btnCoordenadas3D = new JButton("Coordenadas 3D");
		btnCoordenadas3D.setBounds(26, 29, 192, 62);
		btnCoordenadas3D.addActionListener(cme);
		contentPane.add(btnCoordenadas3D);
		
		btnSegmento = new JButton("Segmento");
		btnSegmento.setBounds(26, 125, 192, 62);
		btnSegmento.addActionListener(cme);
		contentPane.add(btnSegmento);
		
		btnVector = new JButton("Vector");
		btnVector.setBounds(261, 125, 192, 62);
		btnVector.addActionListener(cme);
		contentPane.add(btnVector);
		
		btnVectorUnitario = new JButton("Vector Unitario");
		btnVectorUnitario.setBounds(261, 315, 192, 62);
		btnVectorUnitario.addActionListener(cme);
		contentPane.add(btnVectorUnitario);
		
		btnSumaDeVectores = new JButton("Suma de Vectores");
		btnSumaDeVectores.setBounds(261, 220, 192, 62);
		btnSumaDeVectores.addActionListener(cme);
		contentPane.add(btnSumaDeVectores);
		
		btnAngulos = new JButton("Angulos");
		btnAngulos.setBounds(26, 315, 192, 62);
		btnAngulos.addActionListener(cme);
		contentPane.add(btnAngulos);
		
		btnVectorDePosicion = new JButton("Vector de Posicion ");
		btnVectorDePosicion.setBounds(26, 220, 192, 62);
		btnVectorDePosicion.addActionListener(cme);
		contentPane.add(btnVectorDePosicion);
		
		//261, 315, 192, 62
		
		lblSalir = new JLabel("Salir");
		lblSalir.setForeground(SystemColor.textHighlightText);
		lblSalir.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblSalir.setIcon(new ImageIcon(VistaMenuEjemplos.class.getResource("/Imagenes/X.png")));
		lblSalir.setBounds(168, 409, 142, 42);
		lblSalir.addMouseListener(cme);
		contentPane.add(lblSalir);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(VistaMenuEjemplos.class.getResource("/Imagenes/FondoAzul.jpeg")));
		lblFondo.setBounds(0, 0, 484, 462);
		contentPane.add(lblFondo);
	}


	public JButton getBtnPunto() {
		return btnPunto;
	}


	public void setBtnPunto(JButton btnPunto) {
		this.btnPunto = btnPunto;
	}


	public JButton getBtnCoordenadas3D() {
		return btnCoordenadas3D;
	}


	public void setBtnCoordenadas3D(JButton btnCoordenadas3D) {
		this.btnCoordenadas3D = btnCoordenadas3D;
	}


	public JButton getBtnSegmento() {
		return btnSegmento;
	}


	public void setBtnSegmento(JButton btnSegmento) {
		this.btnSegmento = btnSegmento;
	}


	public JButton getBtnVector() {
		return btnVector;
	}


	public void setBtnVector(JButton btnVector) {
		this.btnVector = btnVector;
	}


	public JButton getBtnVectorUnitario() {
		return btnVectorUnitario;
	}


	public void setBtnVectorUnitario(JButton btnVectorUnitario) {
		this.btnVectorUnitario = btnVectorUnitario;
	}


	public JButton getBtnSumaDeVectores() {
		return btnSumaDeVectores;
	}


	public void setBtnSumaDeVectores(JButton btnSumaDeVectores) {
		this.btnSumaDeVectores = btnSumaDeVectores;
	}


	public JButton getBtnAngulos() {
		return btnAngulos;
	}


	public void setBtnAngulos(JButton btnAngulos) {
		this.btnAngulos = btnAngulos;
	}


	public JButton getBtnVectorDePosicion() {
		return btnVectorDePosicion;
	}


	public void setBtnVectorDePosicion(JButton btnVectorDePosicion) {
		this.btnVectorDePosicion = btnVectorDePosicion;
	}


	public ControlVistas getCv() {
		return cv;
	}


	public void setCv(ControlVistas cv) {
		this.cv = cv;
	}


	public JLabel getLblSalir() {
		return lblSalir;
	}


	public void setLblSalir(JLabel lblSalir) {
		this.lblSalir = lblSalir;
	}

}
