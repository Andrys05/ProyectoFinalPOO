package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Clinica;
import logico.Consulta;
import logico.Medico;
import logico.Paciente;
import logico.Vacuna;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListVac extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnModi;
	private JButton btnCancelar;
	private JTable tabla;
	private Vacuna select=null;
	private JButton btnElim;
	private static DefaultTableModel model;
	private static Object row[];
	private static Paciente miPaciente = null;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			ListVac dialog = new ListVac();
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
	public ListVac(Paciente paciente) {
		Clinica.getInstance().setVacunaCodigo("");
		miPaciente = paciente;
		if(miPaciente != null)
			setTitle("Historial de Vacunas de "+ miPaciente.getNombre());
		else {
			setTitle("Listado de Vacunas");
		}
		setBounds(100, 100, 733, 433);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				String[] headers = {"Código","Nombre","Descripción"};

				tabla = new JTable();
				tabla.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						int index = tabla.getSelectedRow();
						if(index >= 0) {
						  btnElim.setEnabled(true);
						  btnModi.setEnabled(true);
						  select = Clinica.getInstance().buscarVacuna(tabla.getValueAt(index,0).toString());
						}
						  
					}
				});
				scrollPane.setViewportView(tabla);
				model = new DefaultTableModel();
				model.setColumnIdentifiers(headers);
				tabla.setModel(model);
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
						ModVac vacunaMod = new ModVac(select);
						vacunaMod.setModal(true);
						vacunaMod.setLocationRelativeTo(null);
						vacunaMod.setVisible(true);
						loadVacunas();
					}
				});
				{
					btnNewButton = new JButton("Seleccionar Vacuna (Solo Consulta)");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(select != null) {
								Clinica.getInstance().setVacunaCodigo(select.getCodigo());
								dispose();
							}
							else
								JOptionPane.showMessageDialog(null, "Disculpe, parece que no hay un valor seleccionado aqui para: \n" + Clinica.getVacunaCodigo() + "\n Por favor, seleccione una Vacuna y intentalo de nuevo.\n", "Error", JOptionPane.INFORMATION_MESSAGE);
						}
					});
					buttonPane.add(btnNewButton);
				}
				btnModi.setActionCommand("OK");
				buttonPane.add(btnModi);
				getRootPane().setDefaultButton(btnModi);
			}
			{
				btnElim = new JButton("Eliminar");
				btnElim.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(select != null) {
							int option = JOptionPane.showConfirmDialog(null,"Está Seguro(a) que desea eliminar este empleado?"+select.getNombre(), "Confirmación",JOptionPane.OK_CANCEL_OPTION);
							if(option == JOptionPane.OK_OPTION) {
								Clinica.getInstance().eliminarVac(select);;
								btnElim.setEnabled(true);
								btnModi.setEnabled(true);
								loadVacunas();
							}
						
						}
					}
				});
				btnElim.setActionCommand("Cancel");
				buttonPane.add(btnElim);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(btnCancelar);
			}
		}
		loadVacunas();
	}
	
	
	public static void loadVacunas() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		
		if(miPaciente == null) {
		for (Vacuna aux : Clinica.getInstance().getMisVacunas()) {
			if(aux != null){
			row[0] = aux.getCodigo();
			row[1] = aux.getNombre();
			row[2] = aux.getDescrip();
			model.addRow(row);
		  }
		}
	}
		else {
			for(Consulta aux : Clinica.getInstance().getMisConsultas()) {
				if(aux.getPaciente().getCedula().equalsIgnoreCase(miPaciente.getCedula()) && aux.getVacuna() != null)
				{
					row[0] = aux.getVacuna().getCodigo();
					row[1] = aux.getVacuna().getNombre();
					row[2] = aux.getVacuna().getDescrip();
					model.addRow(row);
				}
			}
			
		}
}

}
