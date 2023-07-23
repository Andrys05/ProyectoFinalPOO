package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import logico.Cita;
import logico.Clinica;
import logico.Paciente;
import logico.Medico;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class RegMed extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnOk;
	private JButton btnCancel;
	private JTextField txtNombre;
	private JTextField txtCed;
	private JTextField txtTel;
	private JRadioButton rdbtnFem;
	private JRadioButton rdbtnMas;
	private JTextField txtEsp;
	private JTextField txtUsu;
	private JTextField txtContra;
	private boolean control;
	private JLabel lblNewLabel_8;
	private JSpinner spnEdad;
	private Medico miMed = null;
	private JTextPane txtDir;

	
	 public static void main(String[] args) {
	        try {
	            RegMed dialog = new RegMed(null);
	            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	            dialog.setVisible(true);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	/**
	 * Create the dialog.
	 */
	public RegMed(Medico med) {
		
		setTitle("Registrar M\u00E9dico");
		setBounds(100, 100, 573, 434);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(12, 13, 56, 16);
		contentPanel.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(12, 42, 206, 22);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00E9dula");
		lblNewLabel_1.setBounds(279, 87, 56, 16);
		contentPanel.add(lblNewLabel_1);
		
		txtCed = new JTextField();
		txtCed.setBounds(279, 116, 131, 22);
		contentPanel.add(txtCed);
		txtCed.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tel\u00E9fono");
		lblNewLabel_2.setBounds(12, 87, 56, 16);
		contentPanel.add(lblNewLabel_2);
		
		txtTel = new JTextField();
		txtTel.setBounds(12, 116, 131, 22);
		contentPanel.add(txtTel);
		txtTel.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Sexo");
		lblNewLabel_3.setBounds(279, 163, 56, 16);
		contentPanel.add(lblNewLabel_3);
		
		rdbtnFem = new JRadioButton("Femenino");
		rdbtnFem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnFem.isSelected()) {
					rdbtnMas.setSelected(false);
				}
			}
		});
		rdbtnFem.setBounds(368, 188, 93, 25);
		contentPanel.add(rdbtnFem);
		
		rdbtnMas = new JRadioButton("Masculino");
		rdbtnMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMas.isSelected()) {
					rdbtnFem.setSelected(false);
				}
			}
		});
		rdbtnMas.setBounds(279, 188, 85, 25);
		contentPanel.add(rdbtnMas);
		
		JLabel lblNewLabel_4 = new JLabel("Especialidad");
		lblNewLabel_4.setBounds(12, 160, 85, 16);
		contentPanel.add(lblNewLabel_4);
		
		txtEsp = new JTextField();
		txtEsp.setBounds(12, 189, 162, 22);
		contentPanel.add(txtEsp);
		txtEsp.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Direcci\u00F3n");
		lblNewLabel_5.setBounds(279, 230, 56, 16);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Usuario");
		lblNewLabel_6.setBounds(12, 224, 56, 16);
		contentPanel.add(lblNewLabel_6);
		
		txtUsu = new JTextField();
		txtUsu.setBounds(12, 253, 116, 22);
		contentPanel.add(txtUsu);
		txtUsu.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Contrase\u00F1a");
		lblNewLabel_7.setBounds(12, 288, 72, 16);
		contentPanel.add(lblNewLabel_7);
		
		txtContra = new JTextField();
		txtContra.setBounds(12, 312, 116, 22);
		contentPanel.add(txtContra);
		txtContra.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Edad");
		lblNewLabel_8.setBounds(279, 13, 56, 16);
		contentPanel.add(lblNewLabel_8);
		
		spnEdad = new JSpinner();
		spnEdad.setModel(new SpinnerNumberModel(1, null, 100, 1));
		spnEdad.setBounds(279, 42, 85, 22);
		contentPanel.add(spnEdad);
		
		txtDir = new JTextPane();
		txtDir.setBounds(279, 259, 223, 75);
		contentPanel.add(txtDir);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnOk = new JButton("Aceptar");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!control) {
							Medico aux = new Medico(txtUsu.getText(),txtContra.getText(),txtEsp.getText(),txtNombre.getText(),txtCed.getText(),txtDir.getText(),Integer.parseInt(spnEdad.getValue().toString()),rdbtnMas.isSelected(),txtTel.getText());
							Clinica.getInstance().insertarMedico(aux);
						    JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Registro", JOptionPane.INFORMATION_MESSAGE);				  
						    clear();
						}else {
							
							med.setUsuario(txtUsu.getText());
							med.setContrasenaDoctor(txtContra.getText());
							med.setNombre(txtNombre.getText());
							med.setCedula(txtCed.getText());
							med.setDireccion(txtDir.getText());
							med.setedad(Integer.valueOf(spnEdad.getValue().toString()));
							med.setEspecialidad(txtEsp.getText());
							med.setTelefono(txtTel.getText());
							Clinica.getInstance().modiMed(med);
							dispose();
							ListMed.loadMedicos();
						}
					}
				});
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				btnCancel = new JButton("Cancelar");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
		loadMed();
	}



	private void loadMed() {
		
		if(miMed != null) {
		txtUsu.setText(miMed.getUsuario());
		txtContra.setText(miMed.getContrasenaDoctor());
		txtEsp.setText(miMed.getEspecialidad());
		txtNombre.setText(miMed.getNombre());
		txtCed.setText(miMed.getCedula());
		txtDir.setText(miMed.getDireccion());
		spnEdad.setValue(new Integer(miMed.getedad()));
		rdbtnMas.setSelected(false);
		rdbtnFem.setSelected(false);
		
		if(miMed.getSexo()) {
			rdbtnMas.setSelected(true);
		}else {
			rdbtnFem.setSelected(true);
		}
		txtTel.setText(miMed.getTelefono());
	 }
		
	}



	private void clear() {
		txtUsu.setText("");
		txtContra.setText("");
		txtEsp.setText("");
		txtNombre.setText("");
		txtCed.setText("");
		txtDir.setText("");
		spnEdad.setValue(Integer.valueOf(0));
		rdbtnMas.setSelected(false);
		rdbtnFem.setSelected(false);
		txtTel.setText("");
	
	}
}
