package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import logico.Clinica;
import logico.Enfermedad;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;


public class RegistrarEnfermedad extends JFrame {

	private JPanel contentPane;
	private JTextField textNombreEnfermedad;
	private JTextField textSintomas;
	ArrayList<String> Sintomas = new ArrayList<>(100);
	private JRadioButton rdbSi;
	private JRadioButton rdbNo;
	private JButton btnNewButton_1;
	private JTextField txtCodigo;

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
		setTitle("Registrar Enfermemdad");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBackground(SystemColor.menu);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Datos de enfermedad", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(SystemColor.text);
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBounds(10, 11, 774, 290);
		panel_2.setBounds(15, 219, 774, 290);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(10, 96, 69, 20);
		panel_2.add(lblNewLabel_1);
		
		textNombreEnfermedad = new JTextField();
		textNombreEnfermedad.setBounds(90, 93, 664, 26);
		panel_2.add(textNombreEnfermedad);
		textNombreEnfermedad.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Sintomas:");
		lblNewLabel_2.setBounds(10, 144, 86, 20);
		panel_2.add(lblNewLabel_2);
		
		textSintomas = new JTextField();
		textSintomas.setBounds(90, 141, 664, 26);
		panel_2.add(textSintomas);
		textSintomas.setColumns(10);
		
		btnNewButton_1 = new JButton("Agregar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 Sintomas.add(textSintomas.getText());
			 JOptionPane.showMessageDialog(contentPane, "Añadido");
			 textSintomas.setText("");
				
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(324, 179, 115, 29);
		panel_2.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Permanente");
		lblNewLabel_3.setBounds(40, 199, 104, 20);
		panel_2.add(lblNewLabel_3);
		
		rdbSi = new JRadioButton("Si");
		rdbSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbNo.setSelected(false);
			}
		});
		rdbSi.setBackground(SystemColor.menu);
		rdbSi.setBounds(15, 215, 69, 29);
		rdbSi.setBounds(288, 230, 104, 29);
		panel_2.add(rdbSi);
		
		rdbNo = new JRadioButton("No");
		rdbNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbSi.setSelected(false);
			}
		});
		rdbNo.setBackground(SystemColor.menu);
		rdbNo.setBounds(98, 215, 155, 29);
		rdbNo.setBounds(414, 230, 155, 29);
		panel_2.add(rdbNo);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(90, 49, 664, 26);
		panel_2.add(txtCodigo);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 52, 69, 20);
		panel_2.add(lblCodigo);
		
		JButton btnNewButton_2 = new JButton("Registrar");
		btnNewButton_2.setBackground(new Color(240, 240, 240));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(getContentPane(), "Registrado con exito");
				boolean aux1 = true;
				if(rdbNo.isSelected()) {
					aux1 = false;
				}
				Enfermedad aux = new Enfermedad(txtCodigo.getText(), textNombreEnfermedad.getText(), Sintomas, aux1);
				Clinica.getInstance().insertarEnfermedad(aux);
				textNombreEnfermedad.setText("");
				txtCodigo.setText("");
				textNombreEnfermedad.setText("");
				textSintomas.setText("");
			}
		});
		btnNewButton_2.setBounds(575, 316, 97, 25);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Volver");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_3.setBounds(682, 316, 97, 25);
		btnNewButton_3.setBounds(660, 588, 115, 29);
		panel.add(btnNewButton_3);
	}
}
