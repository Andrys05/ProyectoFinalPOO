package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Clinica;
import logico.Medico;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListMed extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnModi;
	private JButton btnElim;
	private JButton btnCancel;
	private static JTable Tabla;
	private Medico selected = null;
	private static DefaultTableModel model;
	private static Object row[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListMed dialog = new ListMed();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListMed() {
		setTitle("Listar M\u00E9dicos");
		setBounds(100, 100, 686, 329);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				String[] headers = {"Nombre","Cédula","Dirección","Teléfono","Usuario","Contraseña"};
				
				Tabla = new JTable();
				Tabla.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int ind =-1;
						 ind = Tabla.getSelectedRow();
						 if(ind >= 0) {
							  btnElim.setEnabled(true);
							  btnModi.setEnabled(true);
							  selected = Clinica.getInstance().buscarMedico(Tabla.getValueAt(ind, 0).toString());
							}
					}
				});
				scrollPane.setViewportView(Tabla);
				
				model = new DefaultTableModel();
				model.setColumnIdentifiers(headers);
				Tabla.setModel(model);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModi = new JButton("Modificar Datos");
				btnModi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegMed update = new RegMed(selected);
						update.setModal(true);
						update.setVisible(true);
					}
				});
				btnModi.setActionCommand("OK");
				buttonPane.add(btnModi);
				getRootPane().setDefaultButton(btnModi);
			}
			{
				btnElim = new JButton("Eliminar");
				btnElim.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(selected != null) {
							int option = JOptionPane.showConfirmDialog(null,"Está Seguro(a) que desea eliminar este empleado?"+selected.getNombre(), "Confirmación",JOptionPane.OK_CANCEL_OPTION);
							if(option == JOptionPane.OK_OPTION) {
								Clinica.getInstance().eliminarMedico(selected);
								btnElim.setEnabled(false);
								btnModi.setEnabled(false);
								loadMedicos();
							}
						
						}
					}
				});
				buttonPane.add(btnElim);
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
		loadMedicos();
	}

	public static void loadMedicos() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		
		for (Medico aux : Clinica.getInstance().getMisMedicos()) {
			if(aux != null){
			row[0] = aux.getNombre();
			row[1] = aux.getCedula();
			row[2] = aux.getDireccion();
			row[3] = aux.getTelefono();
			row[4] = aux.getUsuario();
			row[5] = aux.getContrasenaDoctor();
			model.addRow(row);
		  }
	
		
		}
	}

}
