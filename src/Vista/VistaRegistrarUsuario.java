package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import Control.ControlRegistrarUsuario;
import Control.ControlVistas;

import java.awt.SystemColor;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class VistaRegistrarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldApellido;
	private JTextField txtNombre;
	private JTextField txtUsuario;
	private JTextField txtRespuesta;
	private ControlRegistrarUsuario cru;
	private JButton btnGuardar;
	private JComboBox comboPregunta;
	private ControlVistas cv;
	private JButton btnRegresar;
	private JPasswordField pssw_Clave;
	private JPasswordField pssw_ConfirClave;

	public VistaRegistrarUsuario(ControlVistas cv) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaRegistrarUsuario.class.getResource("/Imagenes/IconoOriginal.png")));
		setTitle("SpaVecGenerator");
		this.setCv(cv);
		Contenido();
	}

	/**
	 * Create the frame.
	 */
	public void Contenido() {
		
		
		cru = new ControlRegistrarUsuario(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 481);
		setLocationRelativeTo(null);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroDeUn = new JLabel("Registro de usuario");
		lblRegistroDeUn.setForeground(SystemColor.textHighlightText);
		lblRegistroDeUn.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblRegistroDeUn.setBounds(98, 11, 187, 32);
		contentPane.add(lblRegistroDeUn);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(SystemColor.textHighlightText);
		lblNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNombre.setBounds(10, 219, 70, 21);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(SystemColor.textHighlightText);
		lblApellido.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblApellido.setBounds(10, 266, 70, 19);
		contentPane.add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(172, 267, 187, 21);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(172, 221, 187, 21);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 78, 70, 26);
		contentPane.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(172, 83, 187, 21);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setForeground(SystemColor.textHighlightText);
		lblClave.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblClave.setBounds(10, 125, 52, 21);
		contentPane.add(lblClave);
		
		JLabel lblConfirmarClave = new JLabel("Confirmar Clave");
		lblConfirmarClave.setForeground(SystemColor.textHighlightText);
		lblConfirmarClave.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblConfirmarClave.setBounds(10, 174, 117, 21);
		contentPane.add(lblConfirmarClave);
		
		JLabel lblPreguntaDeSeguridad = new JLabel("Pregunta de Seguridad");
		lblPreguntaDeSeguridad.setForeground(SystemColor.textHighlightText);
		lblPreguntaDeSeguridad.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblPreguntaDeSeguridad.setBounds(10, 310, 161, 21);
		contentPane.add(lblPreguntaDeSeguridad);
		
		comboPregunta = new JComboBox();
		comboPregunta.setForeground(SystemColor.textText);
		comboPregunta.setModel(new DefaultComboBoxModel(new String[] {"\u00BFNombre de su Primer Colegio?", "\u00BFCual es su comida favorita?", "\u00BFNombre de su canci\u00F3n favorita?", "\u00BFNombre de su primer mascota?", "\u00BFNombre de su pelicula favorita?"}));
		comboPregunta.setBounds(172, 312, 187, 21);
		contentPane.add(comboPregunta);
		
		JLabel lblRespuesta = new JLabel("Respuesta");
		lblRespuesta.setForeground(SystemColor.textHighlightText);
		lblRespuesta.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblRespuesta.setBounds(10, 353, 99, 21);
		contentPane.add(lblRespuesta);
		
		txtRespuesta = new JTextField();
		txtRespuesta.setBounds(172, 355, 187, 21);
		contentPane.add(txtRespuesta);
		txtRespuesta.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(233, 413, 104, 32);
		btnGuardar.addActionListener(cru);
		contentPane.add(btnGuardar);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(52, 413, 104, 32);
		btnRegresar.addActionListener(cru);
		contentPane.add(btnRegresar);
		
		pssw_Clave = new JPasswordField();
		pssw_Clave.setBounds(172, 127, 187, 21);
		contentPane.add(pssw_Clave);
		
		pssw_ConfirClave = new JPasswordField();
		pssw_ConfirClave.setBounds(172, 176, 187, 21);
		contentPane.add(pssw_ConfirClave);
		
		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setIcon(new ImageIcon(VistaRegistrarUsuario.class.getResource("/Imagenes/FondoAzul.jpeg")));
		lblImagen.setBounds(0, 0, 384, 456);
		contentPane.add(lblImagen);
	}
	
	
	
	

	public void BorrarCampos(){
		
		txtUsuario.setText("");
		pssw_Clave.setText("");
		pssw_ConfirClave.setText("");
		txtNombre.setText("");
		textFieldApellido.setText("");
		comboPregunta.setSelectedIndex(0);
		txtRespuesta.setText("");
	}
	
	

	public JTextField getTextFieldApellido() {
		return textFieldApellido;
	}

	public void setTextFieldApellido(JTextField textFieldApellido) {
		this.textFieldApellido = textFieldApellido;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}


	public JTextField getTxtRespuesta() {
		return txtRespuesta;
	}

	public void setTxtRespuesta(JTextField txtRespuesta) {
		this.txtRespuesta = txtRespuesta;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JComboBox getComboPregunta() {
		return comboPregunta;
	}

	public void setComboPregunta(JComboBox comboPregunta) {
		this.comboPregunta = comboPregunta;
	}

	public ControlVistas getCv() {
		return cv;
	}

	public void setCv(ControlVistas cv) {
		this.cv = cv;
	}

	public JButton getBtnRegresar() {
		return btnRegresar;
	}

	public void setBtnRegresar(JButton btnRegresar) {
		this.btnRegresar = btnRegresar;
	}

	public JPasswordField getPssw_Clave() {
		return pssw_Clave;
	}

	public void setPssw_Clave(JPasswordField pssw_Clave) {
		this.pssw_Clave = pssw_Clave;
	}

	public JPasswordField getPssw_ConfirClave() {
		return pssw_ConfirClave;
	}

	public void setPssw_ConfirClave(JPasswordField pssw_ConfirClave) {
		this.pssw_ConfirClave = pssw_ConfirClave;
	}
}
