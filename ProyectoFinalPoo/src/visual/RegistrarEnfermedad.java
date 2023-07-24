package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import logico.Clinica;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarEnfermedad extends JFrame {

	private JPanel contentPane;
	private JTextField textCedula;
	private JTextField textNombre;
	private JTextField textNombreEnfermedad;
	private JTextField textSintomas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarEnfermedad frame = new RegistrarEnfermedad();
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
	public RegistrarEnfermedad() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 255, 250));
		panel_1.setBorder(new TitledBorder(null, "Datos de paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(15, 16, 774, 188);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cedula:");
		lblNewLabel.setBounds(15, 37, 69, 20);
		panel_1.add(lblNewLabel);
		
		textCedula = new JTextField();
		textCedula.setBounds(83, 34, 676, 26);
		panel_1.add(textCedula);
		textCedula.setColumns(10);
		
		JLabel lblNombrel = new JLabel("Nombre:");
		lblNombrel.setBounds(15, 90, 69, 20);
		panel_1.add(lblNombrel);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		textNombre.setBounds(83, 87, 676, 26);
		panel_1.add(textNombre);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Clinica.getInstance().buscarPaciente(textCedula.getText()) != null) {
					JOptionPane.showMessageDialog(getContentPane(), "Usuario Encontrado");
					textNombre.setText(Clinica.getInstance().buscarPaciente(textCedula.getText()).getNombre());
				}
				else if(Clinica.getInstance().buscarPaciente(textCedula.getText()) == null) {
					JOptionPane.showMessageDialog(getContentPane(), "Usuario no Encontrado");
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(329, 129, 115, 29);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Datos de enfermedad", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(new Color(245, 255, 250));
		panel_2.setBounds(15, 239, 774, 290);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(15, 36, 69, 20);
		panel_2.add(lblNewLabel_1);
		
		textNombreEnfermedad = new JTextField();
		textNombreEnfermedad.setBounds(95, 33, 664, 26);
		panel_2.add(textNombreEnfermedad);
		textNombreEnfermedad.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Sintomas:");
		lblNewLabel_2.setBounds(15, 84, 86, 20);
		panel_2.add(lblNewLabel_2);
		
		textSintomas = new JTextField();
		textSintomas.setBounds(95, 81, 664, 26);
		panel_2.add(textSintomas);
		textSintomas.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Agregar");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(329, 119, 115, 29);
		panel_2.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Permanente");
		lblNewLabel_3.setBounds(335, 182, 104, 20);
		panel_2.add(lblNewLabel_3);
		
		JRadioButton rdbSi = new JRadioButton("Si");
		rdbSi.setBackground(new Color(245, 255, 250));
		rdbSi.setBounds(245, 230, 155, 29);
		panel_2.add(rdbSi);
		
		JRadioButton rdbNo = new JRadioButton("No");
		rdbNo.setBackground(new Color(245, 255, 250));
		rdbNo.setBounds(467, 230, 155, 29);
		panel_2.add(rdbNo);
	}
}
