package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Clinica;
import logico.Consulta;
import logico.Enfermedad;
import logico.Medico;
import logico.Paciente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class RegConsulta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtConsultaCodigo;
	private JTextField txtPaciente;
	private JTextField txtCedMedico;
	private JTextField txtDescripcion;
	private JTextField txtDiagnostico;
	JSpinner spnFecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegConsulta dialog = new RegConsulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegConsulta() {
		setBounds(100, 100, 456, 382);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			txtConsultaCodigo = new JTextField();
			txtConsultaCodigo.setEditable(false);
			txtConsultaCodigo.setText("Co-" + Clinica.getInstance().consultaCodigo);
			txtConsultaCodigo.setBounds(10, 48, 138, 20);
			panel.add(txtConsultaCodigo);
			txtConsultaCodigo.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Codigo:");
			lblNewLabel.setBounds(10, 30, 46, 14);
			panel.add(lblNewLabel);
			
			txtPaciente = new JTextField();
			txtPaciente.setBounds(10, 99, 138, 20);
			panel.add(txtPaciente);
			txtPaciente.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Cedula del Paciente:");
			lblNewLabel_1.setBounds(10, 79, 161, 14);
			panel.add(lblNewLabel_1);
			
			txtCedMedico = new JTextField();
			txtCedMedico.setBounds(10, 141, 138, 20);
			panel.add(txtCedMedico);
			txtCedMedico.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Cedula del Medico:");
			lblNewLabel_2.setBounds(10, 125, 138, 14);
			panel.add(lblNewLabel_2);
			
			txtDescripcion = new JTextField();
			txtDescripcion.setBounds(10, 207, 410, 82);
			panel.add(txtDescripcion);
			txtDescripcion.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Descripcion:");
			lblNewLabel_3.setBounds(10, 191, 124, 14);
			panel.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Diagnostico (codigo de Enfermedad):");
			lblNewLabel_4.setBounds(177, 125, 214, 14);
			panel.add(lblNewLabel_4);
			
			txtDiagnostico = new JTextField();
			txtDiagnostico.setBounds(177, 141, 180, 20);
			panel.add(txtDiagnostico);
			txtDiagnostico.setColumns(10);
			
			spnFecha = new JSpinner();
			spnFecha.setModel(new SpinnerDateModel(new Date(), null, new Date(), Calendar.DAY_OF_YEAR));
			JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spnFecha, "dd/MM/yyyy hh:mm");
			spnFecha.setEditor(dateEditor);
			spnFecha.setEnabled(false);
			spnFecha.setBounds(177, 99, 181, 20);
			panel.add(spnFecha);
			
			JLabel lblNewLabel_5 = new JLabel("Fecha/Tiempo de Reunion:");
			lblNewLabel_5.setBounds(177, 79, 180, 14);
			panel.add(lblNewLabel_5);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCrear = new JButton("Crear");
				btnCrear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Date fechaOcurrida = (Date) spnFecha.getValue();
						Paciente paciente = Clinica.getInstance().buscarPaciente(txtPaciente.getText());
						Medico medico = Clinica.getInstance().buscarMedico(txtCedMedico.getText());
						Enfermedad diagnostico = Clinica.getInstance().buscarEnfermedad(txtDiagnostico.getText());
						if(paciente == null || medico == null || txtDescripcion.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Disculpe, parece que faltan algunos datos en la creacion de una nueva consulta. Por favor, llene los datos que faltan e intenta la creacion de nuevo.\n", "Datos Ausentes", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							Consulta nuevaConsulta = new Consulta(txtConsultaCodigo.getText(), paciente, medico, txtDescripcion.getText(), fechaOcurrida, diagnostico);
							
							//Si el paciente tiene una enfermedad, su estado cambia a true (para decir que esta enfermo)
							//Si no, su estado quede o vuelve a ser false (para decir que no esta enfermo)
							if(diagnostico != null)
								nuevaConsulta.getPaciente().setEstado(true);					
							else 
								nuevaConsulta.getPaciente().setEstado(false);
							
							Clinica.getInstance().insertarConsulta(nuevaConsulta);
							JOptionPane.showMessageDialog(null, "Consulta Creada!\n", "Creacion!", JOptionPane.INFORMATION_MESSAGE); 
							clean();
						}
					}
				});
				btnCrear.setActionCommand("OK");
				buttonPane.add(btnCrear);
				getRootPane().setDefaultButton(btnCrear);
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
	}
	private void clean() {
		txtConsultaCodigo.setText("Co-" + Clinica.getInstance().consultaCodigo);
		txtPaciente.setText("");
		txtCedMedico.setText("");
		txtDescripcion.setText("");
		txtDiagnostico.setText("");
		spnFecha.setValue(new Date());
	}
}
