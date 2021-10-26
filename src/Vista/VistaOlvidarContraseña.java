package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.ControlOlvidarClave;
import Control.ControlVistas;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Toolkit;

public class VistaOlvidarContraseña extends JFrame {

	private JPanel contentPane;
	private ControlVistas cv;
	private JTextField txtUsuario;
	private JTextField txtRespuesta;
	private JTextField txtRecuperarClave;
	
	private JButton btnRegresar;

	private ControlOlvidarClave coc;
	private JButton btnGenerarClave;
	private JComboBox comboPregunta;
	
	public VistaOlvidarContraseña(ControlVistas cv) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaOlvidarContraseña.class.getResource("/Imagenes/IconoOriginal.png")));
		setTitle("SpaVecGenerator");
		this.cv = cv;
		contenido();
	}
		public void contenido(){
			
		coc = new ControlOlvidarClave(this);
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(100,100,357,349);
		setLocationRelativeTo(null);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRecuperar = new JLabel("Recuperar Clave");
		lblRecuperar.setForeground(SystemColor.textHighlightText);
		lblRecuperar.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblRecuperar.setBounds(118, 23, 131, 33);
		contentPane.add(lblRecuperar);
		
		JLabel lblPreguntaSecreta = new JLabel("Pregunta Secreta");
		lblPreguntaSecreta.setForeground(SystemColor.textHighlightText);
		lblPreguntaSecreta.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblPreguntaSecreta.setBounds(42, 137, 122, 22);
		contentPane.add(lblPreguntaSecreta);
		
		JLabel lblRespuesta = new JLabel("Respuesta");
		lblRespuesta.setForeground(SystemColor.textHighlightText);
		lblRespuesta.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblRespuesta.setBounds(42, 185, 122, 22);
		contentPane.add(lblRespuesta);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(SystemColor.textHighlightText);
		lblUsuario.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblUsuario.setBounds(45, 88, 66, 22);
		contentPane.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Recuperar clave");
		lblClave.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblClave.setForeground(SystemColor.textHighlightText);
		lblClave.setBounds(42, 229, 103, 22);
		contentPane.add(lblClave);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(174, 90, 143, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtRespuesta = new JTextField();
		txtRespuesta.setText("");
		txtRespuesta.setBounds(174, 187, 143, 20);
		contentPane.add(txtRespuesta);
		txtRespuesta.setColumns(10);
		
		txtRecuperarClave = new JTextField();
		txtRecuperarClave.setEditable(false);
		txtRecuperarClave.setBounds(174, 231, 143, 20);
		contentPane.add(txtRecuperarClave);
		txtRecuperarClave.setColumns(10);
		
		
		comboPregunta = new JComboBox();
		comboPregunta.setForeground(SystemColor.textText);
		comboPregunta.setModel(new DefaultComboBoxModel(new String[] {"\u00BFNombre de su Primer Colegio?", "\u00BFCual es su comida favorita?", "\u00BFNombre de su canci\u00F3n favorita?", "\u00BFNombre de su primer mascota?", "\u00BFNombre de su pelicula favorita?"}));
		comboPregunta.setBounds(174, 139, 143, 20);
		contentPane.add(comboPregunta);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(214, 289, 103, 33);
		btnRegresar.addActionListener(coc);
		contentPane.add(btnRegresar);
		
		btnGenerarClave = new JButton("Generar Clave");
		btnGenerarClave.setBounds(42, 289, 103, 33);
		btnGenerarClave.addActionListener(coc);
		contentPane.add(btnGenerarClave);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(VistaOlvidarContraseña.class.getResource("/Imagenes/FondoAzul.jpeg")));
		lblFondo.setBounds(0, 0, 356, 322);
		contentPane.add(lblFondo);
		
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
		public JTextField getTxtRecuperarClave() {
			return txtRecuperarClave;
		}
		public void setTxtRecuperarClave(JTextField txtRecuperarClave) {
			this.txtRecuperarClave = txtRecuperarClave;
		}
		public JButton getBtnRegresar() {
			return btnRegresar;
		}
		public void setBtnRegresar(JButton btnRegresar) {
			this.btnRegresar = btnRegresar;
		}
		public ControlVistas getCv() {
			return cv;
		}
		public void setCv(ControlVistas cv) {
			this.cv = cv;
		}
		public JButton getBtnGenerarClave() {
			return btnGenerarClave;
		}
		public void setBtnGenerarClave(JButton btnGenerarClave) {
			this.btnGenerarClave = btnGenerarClave;
		}
		public JComboBox getComboPregunta() {
			return comboPregunta;
		}
		public void setComboPregunta(JComboBox comboPregunta) {
			this.comboPregunta = comboPregunta;
		}
}
