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

public class RegPaciente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtDir;
	private JTextField txtContactoEmer;
	private JTextField txtNumeroEmer;
	private char sexo;
	JSpinner spnEdad;
	JComboBox<String> cbxSexo;
	private Paciente miPaciente = null;
	

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
		miPaciente = paciente;
		setResizable(false);
		if(miPaciente == null) {
			setTitle("Registrar Paciente");
		}
		else {
			setTitle("Modificar Paciente");
		}
		setBounds(100, 100, 431, 312);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(30, 37, 117, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setBounds(30, 22, 117, 14);
			panel.add(lblNewLabel);
			
			txtCedula = new JTextField();
			txtCedula.setColumns(10);
			txtCedula.setBounds(30, 83, 117, 20);
			panel.add(txtCedula);
			
			JLabel lblCedula = new JLabel("Cedula:");
			lblCedula.setBounds(30, 68, 117, 14);
			panel.add(lblCedula);
			
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(30, 129, 117, 20);
			panel.add(txtTelefono);
			
			JLabel lblNumeroDeTelefono = new JLabel("Numero de Telefono:");
			lblNumeroDeTelefono.setBounds(30, 114, 174, 14);
			panel.add(lblNumeroDeTelefono);
			
			txtDir = new JTextField();
			txtDir.setColumns(10);
			txtDir.setBounds(30, 175, 117, 20);
			panel.add(txtDir);
			
			JLabel lblDireccion = new JLabel("Direccion:");
			lblDireccion.setBounds(30, 160, 117, 14);
			panel.add(lblDireccion);
			
			SpinnerDateModel modelo = new SpinnerDateModel();
	        spnEdad = new JSpinner(new SpinnerDateModel(new Date(), null, new Date(), Calendar.DAY_OF_MONTH));
	        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spnEdad, "dd/MM/yyyy");
	        spnEdad.setEditor(dateEditor);
	        spnEdad.setBounds(214, 37, 127, 20);
	        panel.add(spnEdad);
			
			JLabel lblNewLabel_1 = new JLabel("Fecha de Nacimiento:");
			lblNewLabel_1.setBounds(214, 22, 168, 14);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Sexo:");
			lblNewLabel_2.setBounds(214, 68, 46, 14);
			panel.add(lblNewLabel_2);
			
			txtContactoEmer = new JTextField();
			txtContactoEmer.setBounds(214, 129, 127, 20);
			panel.add(txtContactoEmer);
			txtContactoEmer.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Contacto de Emergencia:");
			lblNewLabel_3.setBounds(214, 114, 168, 14);
			panel.add(lblNewLabel_3);
			
			JLabel lblNumeroDeCont = new JLabel("Numero de Contacto de ER:");
			lblNumeroDeCont.setBounds(214, 160, 168, 14);
			panel.add(lblNumeroDeCont);
			
			txtNumeroEmer = new JTextField();
			txtNumeroEmer.setColumns(10);
			txtNumeroEmer.setBounds(214, 175, 127, 20);
			panel.add(txtNumeroEmer);
			
			sexo = 'H';
			String[] sexos = {"Hombre", "Mujer"};
			cbxSexo = new JComboBox(sexos);
			cbxSexo.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
			cbxSexo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==cbxSexo) {
						if(cbxSexo.getSelectedItem().equals("Hombre")) {
							sexo = 'H';
						}
						else {
							sexo = 'M';
						}
						//Para probar que el valor correcto del char estaba funcionando
						//JOptionPane.showMessageDialog(null, "Sexo es " + sexo + "!", "Sexo", JOptionPane.INFORMATION_MESSAGE); 
					}
				}
			});
			cbxSexo.setBounds(214, 83, 127, 20);
			panel.add(cbxSexo);
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
						if(txtNombre.getText().isEmpty() || txtCedula.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtDir.getText().isEmpty() || 
								txtContactoEmer.getText().isEmpty() || txtNumeroEmer.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Disculpe, parece que faltan algunos datos en la registracion del paciente. Por favor, llene los datos que faltan e intenta la registracion de nuevo.\n", "Datos Ausentes", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							if (miPaciente == null) {
									//SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
									//String fechaNacimientoStr = dateFormat.format(fechaNacim);
									Paciente nuevoPaciente = new Paciente(txtNombre.getText(), txtCedula.getText(), txtDir.getText(), fechaNacim, sexo, txtTelefono.getText(), false, txtContactoEmer.getText(), txtNumeroEmer.getText(), null);
									Clinica.getInstance().insertarPaciente(nuevoPaciente);
									JOptionPane.showMessageDialog(null, "Paciente Registrado!\n", "Registracion!", JOptionPane.INFORMATION_MESSAGE); 
									clean();
								}
							else {
									//Nota: La unica cosa que funciona aqui es Genero por ahora
									miPaciente.setNombre(txtNombre.getText());
									miPaciente.setCedula(txtCedula.getText());
									miPaciente.setTelefono(txtTelefono.getText());
									miPaciente.setDireccion(txtCedula.getText());
									miPaciente.setFechaDeNacim(fechaNacim);
									miPaciente.setContactoEmergencia(txtContactoEmer.getText());
									miPaciente.setNumEmergencia(txtNumeroEmer.getText());
									cbxSexo.setSelectedItem(sexo);
									
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
			txtTelefono.setText(miPaciente.getDireccion());
			txtDir.setText(miPaciente.getDireccion());
			txtContactoEmer.setText(miPaciente.getContactoEmergencia());
			txtNumeroEmer.setText(miPaciente.getNumEmergencia());
			//Falta esta parte de ser arreglado
			if(miPaciente.getSexo()=='H')
				cbxSexo.setSelectedItem("Hombre");
			else
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
		cbxSexo.setSelectedItem("Hombre");
		spnEdad.setValue(new Date());
		miPaciente = null;
	}
}
