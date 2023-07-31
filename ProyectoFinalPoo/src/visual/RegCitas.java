package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Cita;
import logico.Clinica;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class RegCitas extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCedula;
	private JTextField txtDoctor;
	private JTextField txtTipo;
	private JTextField txtHora;
	private JTextField txtFecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegCitas frame = new RegCitas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegCitas() {
		setResizable(false);
		setTitle("Registrar Cita");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Datos del paciente:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(15, 28, 242, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		   
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(15, 119, 81, 20);
		contentPane.add(lblNombre);
		
		JLabel lblCedula = new JLabel("C\u00E9dula:");
		lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCedula.setBounds(15, 74, 81, 20);
		contentPane.add(lblCedula);
		
		JLabel lblDatosDeLa = new JLabel("Datos de la cita:");
		lblDatosDeLa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDatosDeLa.setBounds(15, 209, 196, 20);
		contentPane.add(lblDatosDeLa);
		
		JLabel lblDoctor = new JLabel("Doctor:");
		lblDoctor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDoctor.setBounds(15, 245, 81, 20);
		contentPane.add(lblDoctor);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipo.setBounds(15, 288, 81, 20);
		contentPane.add(lblTipo);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFecha.setBounds(15, 330, 81, 20);
		contentPane.add(lblFecha);
		
		JLabel lblHora_1 = new JLabel("Hora:");
		lblHora_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHora_1.setBounds(295, 330, 81, 20);
		contentPane.add(lblHora_1);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(86, 116, 563, 26);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCedula = new JTextField();
		txtCedula.setColumns(10);
		txtCedula.setBounds(86, 71, 563, 26);
		contentPane.add(txtCedula);
		
		txtDoctor = new JTextField();
		txtDoctor.setColumns(10);
		txtDoctor.setBounds(86, 245, 563, 26);
		contentPane.add(txtDoctor);
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(86, 285, 563, 26);
		contentPane.add(txtTipo);
		
		txtHora = new JTextField();
		txtHora.setColumns(10);
		txtHora.setBounds(357, 327, 146, 26);
		contentPane.add(txtHora);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(86, 327, 146, 26);
		contentPane.add(txtFecha);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Cita aux = new Cita( txtNombre.getText(),  txtFecha.getText(), txtHora.getText(),  txtDoctor.getText(),  txtTipo.getText(),  txtCedula.getText());
				Clinica.getInstance().RegistrarCita(aux);
			}
		});
		btnRegistrar.setBounds(408, 385, 115, 29);
		contentPane.add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(534, 385, 115, 29);
		contentPane.add(btnCancelar);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedula = txtCedula.getText(); 
				if(Clinica.getInstance().buscarPaciente(cedula) != null) {
					JOptionPane.showMessageDialog(getContentPane(), "Usuario Encontrado");
					txtNombre.setText(Clinica.getInstance().buscarPaciente(cedula).getNombre());
				}
				else if(Clinica.getInstance().buscarPaciente(cedula) == null) {
					JOptionPane.showMessageDialog(getContentPane(), "Usuario no Encontrado");
				}
			}
		});
		btnNewButton.setBounds(284, 158, 115, 29);
		contentPane.add(btnNewButton);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}
}




		
