package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Administrador;
import logico.Clinica;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegAdmin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JTextField txtContrasena;
	private JTextField txtConfirmacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegAdmin dialog = new RegAdmin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegAdmin() {
		setTitle("Registrar Administrador");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				txtUsuario = new JTextField();
				txtUsuario.setBounds(30, 46, 147, 20);
				panel.add(txtUsuario);
				txtUsuario.setColumns(10);
			}
			{
				txtContrasena = new JTextField();
				txtContrasena.setBounds(30, 107, 147, 20);
				panel.add(txtContrasena);
				txtContrasena.setColumns(10);
			}
			{
				txtConfirmacion = new JTextField();
				txtConfirmacion.setBounds(30, 168, 147, 20);
				panel.add(txtConfirmacion);
				txtConfirmacion.setColumns(10);
			}
			{
				JLabel lblNewLabel = new JLabel("Usuario:");
				lblNewLabel.setBounds(30, 31, 172, 14);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Contrasena:");
				lblNewLabel_1.setBounds(30, 92, 147, 14);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Confirmar Contrasena:");
				lblNewLabel_2.setBounds(30, 153, 147, 14);
				panel.add(lblNewLabel_2);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCrear = new JButton("Registrar");
				btnCrear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!(txtUsuario.getText().isEmpty() || txtContrasena.getText().isEmpty() || txtConfirmacion.getText().isEmpty())
					            && txtContrasena.getText().equals(txtConfirmacion.getText())) {
							Administrador admin = new Administrador(txtUsuario.getText(), txtContrasena.getText());
							Clinica.getInstance().regAdmin(admin);
							JOptionPane.showMessageDialog(null, "Admin Creado!\n", "Admin", JOptionPane.INFORMATION_MESSAGE);
							clean();
						}
						else
							JOptionPane.showMessageDialog(null, "Disculpe, parece que faltan algunos datos en la registracion del administrador.\n Por favor, llene los datos que faltan e intenta la registracion de nuevo.\n", "Datos Ausentes", JOptionPane.INFORMATION_MESSAGE);
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
		txtUsuario.setText("");
		txtContrasena.setText("");
		txtConfirmacion.setText("");
	}

}
