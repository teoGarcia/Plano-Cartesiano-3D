package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;

import Control.ControlCoordenadas;
import Control.ControlVistas;

import java.awt.Font;
import java.awt.Color;
import java.awt.List;
import java.awt.SystemColor;
import java.awt.event.ItemListener;

import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class VistaCoordenadas extends JFrame {

	private JButton btnAgregarPunto;
	private JTextField txtX1;
	private JTextField txtY1;
	private JTextField txtZ1;
	private JButton btnGenerarGrfica;
	private List listaPuntos;
	private ControlVistas cv;
	private ControlCoordenadas cc;
	private JButton btnRegresar;
	


	/**
	 * Create the application.
	 */
	public VistaCoordenadas(ControlVistas cv) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaCoordenadas.class.getResource("/Imagenes/Icono1.png")));
		setTitle("SpaVecGenerator");
		this.setCv(cv);
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		cc = new ControlCoordenadas(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);	
		
		
		JLabel lblUbicarPuntos = new JLabel("Crear Puntos");
		lblUbicarPuntos.setForeground(UIManager.getColor("Button.highlight"));
		lblUbicarPuntos.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblUbicarPuntos.setBounds(140, 22, 114, 30);
		getContentPane().add(lblUbicarPuntos, BorderLayout.NORTH);
		
		JLabel lblX = new JLabel("X");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblX.setForeground(UIManager.getColor("Button.highlight"));
		lblX.setBounds(50, 107, 18, 14);
		getContentPane().add(lblX);
		
		JLabel lblY = new JLabel("Y");
		lblY.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblY.setForeground(UIManager.getColor("Button.highlight"));
		lblY.setBounds(50, 153, 18, 17);
		getContentPane().add(lblY);
		
		JLabel lblZ = new JLabel("Z");
		lblZ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblZ.setForeground(UIManager.getColor("Button.highlight"));
		lblZ.setBounds(50, 202, 18, 14);
		getContentPane().add(lblZ);
		
		txtX1 = new JTextField();
		txtX1.setBounds(89, 105, 61, 20);
		getContentPane().add(txtX1, BorderLayout.WEST);
		txtX1.addKeyListener(cc);
		
		txtY1 = new JTextField();
		txtY1.setBounds(89, 152, 61, 20);
		getContentPane().add(txtY1);
		txtY1.addKeyListener(cc);
		
		txtZ1 = new JTextField();
		txtZ1.setBounds(89, 199, 61, 20);
		getContentPane().add(txtZ1);
		txtZ1.addKeyListener(cc);
		
		btnAgregarPunto = new JButton("Crear Punto");
		btnAgregarPunto.setBounds(55, 238, 123, 23);
		btnAgregarPunto.addActionListener(cc);
		getContentPane().add(btnAgregarPunto);
		
		btnGenerarGrfica = new JButton("Vista 3D");
		btnGenerarGrfica.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGenerarGrfica.setBounds(41, 323, 137, 38);
		btnGenerarGrfica.setIcon(new javax.swing.ImageIcon(VistaCoordenadas.class.getResource("/Imagenes/coordinatesystem.png")));
		btnGenerarGrfica.addActionListener(cc);
		getContentPane().add(btnGenerarGrfica);
	
		listaPuntos = new List();
		listaPuntos.setBounds(233, 105, 123, 156);
		getContentPane().add(listaPuntos);
		listaPuntos.setMultipleMode(true);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRegresar.setIcon(new ImageIcon(VistaCoordenadas.class.getResource("/Imagenes/regresa1.png")));
		btnRegresar.setBounds(225, 324, 137, 38);
		btnRegresar.addActionListener(cc);
		getContentPane().add(btnRegresar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VistaCoordenadas.class.getResource("/Imagenes/FondoAzul.jpeg")));
		lblNewLabel.setBounds(0, 0, 394, 372);
		getContentPane().add(lblNewLabel);
	}
	
	
	public void BorrarCampos(){
		
		txtX1.setText("");
		txtY1.setText("");
		txtZ1.setText("");
		
	}

	
	
	public JButton getBtnAadir() {
		return btnAgregarPunto;
	}

	public void setBtnAadir(JButton btnAadir) {
		this.btnAgregarPunto = btnAadir;
	}

	public JTextField getTxtX1() {
		return txtX1;
	}

	public void setTxtX1(JTextField txtX1) {
		this.txtX1 = txtX1;
	}

	public JTextField getTxtY1() {
		return txtY1;
	}

	public void setTxtY1(JTextField txtY1) {
		this.txtY1 = txtY1;
	}

	public JTextField getTxtZ1() {
		return txtZ1;
	}

	public void setTextZ1(JTextField spinnerZ1) {
		this.txtZ1 = spinnerZ1;
	}
	
	public JButton getBtnGenerarGrfica() {
		return btnGenerarGrfica;
	}

	public void setBtnGenerarGrfica(JButton btnGenerarGrfica) {
		this.btnGenerarGrfica = btnGenerarGrfica;
	}

	public List getListaPuntos() {
		return listaPuntos;
	}

	public void setListaPuntos(List listaPuntos) {
		this.listaPuntos = listaPuntos;
	}

	public ControlVistas getCv() {
		return cv;
	}


	public void setCv(ControlVistas cv) {
		this.cv = cv;
	}


	public ControlCoordenadas getCc() {
		return cc;
	}


	public void setCc(ControlCoordenadas cc) {
		this.cc = cc;
	}


	public JButton getBtnRegresar() {
		return btnRegresar;
	}


	public void setBtnRegresar(JButton btnRegresar) {
		this.btnRegresar = btnRegresar;
	}
}
