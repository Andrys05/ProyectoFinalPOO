package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Clinica;
import logico.Paciente;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;

public class RegPaciente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtDir;
	private JTextField txtContactoEmer;
	private JTextField txtNumeroEmer;
	private char sexo = 'H';
	JSpinner spnEdad;
	JComboBox<String> cbxSexo;
	private Paciente miPaciente = null;
	private JTextArea txtAlergias;
	

	/**
	 * Launch the application.
	 */
	/*
	 public static void main(String[] args) {
	        try {
	            RegPaciente dialog = new RegPaciente(null);
	            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	            dialog.setVisible(true);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	   */ 
	/**
	 * Create the dialog.
	 */
	public RegPaciente(Paciente paciente) {
		setTitle("Registrar Paciente");
		miPaciente = paciente;	
		setResizable(false);
		if(miPaciente == null) {
			setTitle("Registrar Paciente");
		}
		else {
			setTitle("Modificar Paciente");
		}
		setBounds(100, 100, 527, 461);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(30, 37, 148, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setBounds(30, 22, 117, 14);
			panel.add(lblNewLabel);
			
			txtCedula = new JTextField();
			txtCedula.setColumns(10);
			txtCedula.setBounds(30, 97, 148, 20);
			panel.add(txtCedula);
			
			JLabel lblCedula = new JLabel("Cedula:");
			lblCedula.setBounds(30, 82, 117, 14);
			panel.add(lblCedula);
			
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(30, 157, 148, 20);
			panel.add(txtTelefono);
			
			JLabel lblNumeroDeTelefono = new JLabel("Numero de Telefono:");
			lblNumeroDeTelefono.setBounds(30, 142, 174, 14);
			panel.add(lblNumeroDeTelefono);
			
			txtDir = new JTextField();
			txtDir.setColumns(10);
			txtDir.setBounds(30, 217, 148, 20);
			panel.add(txtDir);
			
			JLabel lblDireccion = new JLabel("Direccion:");
			lblDireccion.setBounds(30, 202, 117, 14);
			panel.add(lblDireccion);
			
			SpinnerDateModel modelo = new SpinnerDateModel();
	        spnEdad = new JSpinner(new SpinnerDateModel(new Date(), null, new Date(), Calendar.DAY_OF_MONTH));
	        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spnEdad, "dd/MM/yyyy");
	        spnEdad.setEditor(dateEditor);
	        spnEdad.setBounds(303, 37, 168, 20);
	        panel.add(spnEdad);
			
			JLabel lblNewLabel_1 = new JLabel("Fecha de Nacimiento:");
			lblNewLabel_1.setBounds(303, 22, 168, 14);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Sexo:");
			lblNewLabel_2.setBounds(303, 82, 46, 14);
			panel.add(lblNewLabel_2);
			
			txtContactoEmer = new JTextField();
			txtContactoEmer.setBounds(303, 157, 168, 20);
			panel.add(txtContactoEmer);
			txtContactoEmer.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Contacto de Emergencia:");
			lblNewLabel_3.setBounds(303, 142, 168, 14);
			panel.add(lblNewLabel_3);
			
			JLabel lblNumeroDeCont = new JLabel("Numero de Contacto de ER:");
			lblNumeroDeCont.setBounds(303, 202, 168, 14);
			panel.add(lblNumeroDeCont);
			
			txtNumeroEmer = new JTextField();
			txtNumeroEmer.setColumns(10);
			txtNumeroEmer.setBounds(303, 217, 168, 20);
			panel.add(txtNumeroEmer);
			
			String[] sexos = {"Hombre", "Mujer"};
			cbxSexo = new JComboBox(sexos);
			cbxSexo.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
			cbxSexo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==cbxSexo) {
						if(cbxSexo.getSelectedItem().equals("Hombre")) {
							sexo = 'H';
						}
						if(cbxSexo.getSelectedItem().equals("Mujer")) {
							sexo = 'M';
						}
						//Para probar que el valor correcto del char estaba funcionando
						//JOptionPane.showMessageDialog(null, "Sexo es " + sexo + "!", "Sexo", JOptionPane.INFORMATION_MESSAGE); 
					}
				}
			});
			cbxSexo.setBounds(303, 97, 168, 20);
			panel.add(cbxSexo);
			
			JLabel lblNewLabel_4 = new JLabel("Alergias:");
			lblNewLabel_4.setBounds(30, 261, 117, 14);
			panel.add(lblNewLabel_4);
			
			txtAlergias = new JTextArea();
			txtAlergias.setBounds(30, 285, 441, 69);
			panel.add(txtAlergias);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Date fechaNacim = (Date) spnEdad.getValue();
						if (txtNombre.getText().isEmpty() || txtCedula.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtDir.getText().isEmpty() || 
							    txtContactoEmer.getText().isEmpty() || txtNumeroEmer.getText().isEmpty() || (sexo != 'H' && sexo != 'M')) {
							JOptionPane.showMessageDialog(null, "Disculpe, parece que faltan algunos datos en la registracion del paciente. Por favor, llene los datos que faltan e intenta la registracion de nuevo.\n", "Datos Ausentes", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							if (miPaciente == null) {
									//SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
									//String fechaNacimientoStr = dateFormat.format(fechaNacim);
								
									if(txtAlergias.getText().isEmpty())
										txtAlergias.setText("N/A");
									miPaciente = new Paciente(txtNombre.getText(), txtCedula.getText(), txtDir.getText(), fechaNacim, sexo, txtTelefono.getText(), false, txtContactoEmer.getText(), txtNumeroEmer.getText(), txtAlergias.getText());
									Clinica.getInstance().insertarPaciente(miPaciente);
									JOptionPane.showMessageDialog(null, "Paciente Registrado!\n", "Registracion!", JOptionPane.INFORMATION_MESSAGE); 
									clean();
								}
							else {
									miPaciente.setNombre(txtNombre.getText());
									miPaciente.setCedula(txtCedula.getText());
									miPaciente.setTelefono(txtTelefono.getText());
									miPaciente.setDireccion(txtDir.getText());
									miPaciente.setFechaDeNacim(fechaNacim);
									miPaciente.setContactoEmergencia(txtContactoEmer.getText());
									miPaciente.setNumEmergencia(txtNumeroEmer.getText());
									miPaciente.setSexo(sexo);
									miPaciente.setAlergias(txtAlergias.getText());
									
									Clinica.getInstance().modificarPaciente(miPaciente);
									dispose();
									ListarPaciente.loadPacientes(0);
								}
					} 
					
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		loadPaciente();
	}


	public void loadPaciente() {
		if(miPaciente != null) {
			txtNombre.setText(miPaciente.getNombre());
			txtCedula.setText(miPaciente.getCedula());
			txtTelefono.setText(miPaciente.getTelefono());
			txtDir.setText(miPaciente.getDireccion());
			txtContactoEmer.setText(miPaciente.getContactoEmergencia());
			txtNumeroEmer.setText(miPaciente.getNumEmergencia());
			txtAlergias.setText(miPaciente.getAlergias());
			//Falta esta parte de ser arreglado
			if(miPaciente.getSexo()=='H')
				cbxSexo.setSelectedItem("Hombre");
			if(miPaciente.getSexo()=='M')
				cbxSexo.setSelectedItem("Mujer");
			
			spnEdad.setValue(miPaciente.getFechaDeNacim());
			
		}
		
	}


	private void clean() {
		txtNombre.setText("");
		txtCedula.setText("");
		txtTelefono.setText("");
		txtDir.setText("");
		txtContactoEmer.setText("");
		txtNumeroEmer.setText("");
		cbxSexo.setSelectedItem("");
		spnEdad.setValue(new Date());
		txtAlergias.setText("");
		miPaciente = null;
	}
}
