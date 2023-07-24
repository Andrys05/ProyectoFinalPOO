package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logico.Clinica;
import logico.Paciente;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;

public class ListarPaciente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static DefaultTableModel modelo;
	private static Object[] fila;
	private static int seleccion;
	private JComboBox cbxCondicion;
	private static JButton btnSeleccionar;
	private static JButton btnModificar;
	private static JButton btnConsultaHistorial;
	static JLabel lblNewLabel_1;
	private static Paciente seleccionado = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarPaciente dialog = new ListarPaciente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @return 
	 */
	public ListarPaciente() {
		Clinica.getInstance().setPacienteCedula("");
		setTitle("Listado de Pacientes");
		setBounds(100, 100, 996, 487);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(10, 53, 950, 341);
			panel.add(scrollPane);
			
			lblNewLabel_1 = new JLabel("Cantidad de Pacientes en Lista: " + Clinica.getInstance().cantPacientes(seleccion));
			lblNewLabel_1.setBounds(10, 28, 304, 14);
			panel.add(lblNewLabel_1);
			
			table = new JTable(modelo) {
	            @Override
	            public boolean isCellEditable(int fila, int columna) {
	                return false;
	            }
	        };
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (table.getSelectedRow() >= 0) {
						int index = table.getSelectedRow();
						if(index >= 0) {
							btnModificar.setEnabled(true);
							btnConsultaHistorial.setEnabled(true);
							btnSeleccionar.setEnabled(true);
							String cedula =  table.getValueAt(index, 0).toString();
							seleccionado = Clinica.getInstance().buscarPaciente(cedula);
						}
					}
				}
			});
			modelo = new DefaultTableModel();
			String[] headers = {"Cedula", "Nombre", "Sexo", "Nacimiento", "Direccion", "Telefono", "Estado", "Contacto Em.", "Telefono de Contacto Em."};
			table.setModel(modelo);
			modelo.setColumnIdentifiers(headers);
			loadPacientes(0);
			scrollPane.setViewportView(table);
			
			cbxCondicion = new JComboBox();
			cbxCondicion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					seleccion = cbxCondicion.getSelectedIndex();
					loadPacientes(seleccion);
				}
			});
			cbxCondicion.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Sanos", "Enfermos", "Hombres", "Mujeres"}));
			cbxCondicion.setBounds(801, 28, 159, 20);
			panel.add(cbxCondicion);
			
			JLabel lblNewLabel = new JLabel("Filtros de Busqueda:");
			lblNewLabel.setBounds(653, 31, 138, 14);
			panel.add(lblNewLabel);
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegPaciente pacienteMod = new RegPaciente(seleccionado);
						pacienteMod.setModal(true);
						pacienteMod.setLocationRelativeTo(null);
						pacienteMod.setVisible(true);
					}
				});
				
				btnConsultaHistorial = new JButton("Ver Consulta Historial");
				btnConsultaHistorial.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ListConsultas list = new ListConsultas(seleccionado);
						list.setModal(true);
						list.setLocationRelativeTo(null);
						list.setVisible(true);
					}
				});
				
				btnSeleccionar = new JButton("Seleccionar Paciente (Solo Consulta)");
				btnSeleccionar.setEnabled(false);
				btnSeleccionar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(seleccionado != null) {
							Clinica.getInstance().setPacienteCedula(seleccionado.getCedula());
							dispose();
						}
						else
							JOptionPane.showMessageDialog(null, "Disculpe, parece que no hay un valor seleccionado aqui para: \n" + Clinica.getPacienteCedula() + "\n Por favor, seleccione un paciente y intentalo de nuevo.\n", "Error", JOptionPane.INFORMATION_MESSAGE);
					}
				});
				buttonPane.add(btnSeleccionar);
				btnConsultaHistorial.setEnabled(false);
				buttonPane.add(btnConsultaHistorial);
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				btnModificar.setEnabled(false);
				buttonPane.add(btnCancelar);
			}
		}
		loadPacientes(seleccion);
	}

	public static void loadPacientes(int seleccion) {
		modelo.setRowCount(0);
		fila = new Object[modelo.getColumnCount()];
		
		
		switch(seleccion){
		case 0:
			for(Paciente aux : Clinica.getInstance().getMisPacientes()) {
					fila[0] = aux.getCedula();
					fila[1] = aux.getNombre();
					fila[2] = aux.getSexo();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					String fechaNacimientoStr = dateFormat.format(aux.getFechaDeNacim());
					fila[3] = fechaNacimientoStr;
					fila[4] = aux.getDireccion();
					fila[5] = aux.getTelefono();
					if(((Paciente) aux).isEstado() == false)
						fila[6] = "Sano";
					else
						fila[6] = "Enfermo";
					fila[7] = ((Paciente) aux).getContactoEmergencia();
					fila[8] = ((Paciente) aux).getNumEmergencia();
					modelo.addRow(fila);
			}
			break;
		case 1: 
			for(Paciente aux : Clinica.getInstance().getMisPacientes()) {
				if (aux.isEstado() == false) {
					fila[0] = aux.getCedula();
					fila[1] = aux.getNombre();
					fila[2] = aux.getSexo();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					String fechaNacimientoStr = dateFormat.format(aux.getFechaDeNacim());
					fila[3] = fechaNacimientoStr;
					fila[4] = aux.getDireccion();
					fila[5] = aux.getTelefono();
					fila[6] = "Sano";
					fila[7] = ((Paciente) aux).getContactoEmergencia();
					fila[8] = ((Paciente) aux).getNumEmergencia();
					modelo.addRow(fila);
				}
			}
			break;
		case 2: 
			for(Paciente aux : Clinica.getInstance().getMisPacientes()) {
				if (aux.isEstado() == true) {
					fila[0] = aux.getCedula();
					fila[1] = aux.getNombre();
					fila[2] = aux.getSexo();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					String fechaNacimientoStr = dateFormat.format(aux.getFechaDeNacim());
					fila[3] = fechaNacimientoStr;
					fila[4] = aux.getDireccion();
					fila[5] = aux.getTelefono();
					fila[6] = "Enfermo";
					fila[7] = ((Paciente) aux).getContactoEmergencia();
					fila[8] = ((Paciente) aux).getNumEmergencia();
					modelo.addRow(fila);
				}
			}
			break;
		case 3: 
			for(Paciente aux : Clinica.getInstance().getMisPacientes()) {
				if (aux.getSexo() == 'H') {
					fila[0] = aux.getCedula();
					fila[1] = aux.getNombre();
					fila[2] = aux.getSexo();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					String fechaNacimientoStr = dateFormat.format(aux.getFechaDeNacim());
					fila[3] = fechaNacimientoStr;
					fila[4] = aux.getDireccion();
					fila[5] = aux.getTelefono();
					if(((Paciente) aux).isEstado() == false)
						fila[6] = "Sano";
					else
						fila[6] = "Enfermo";
					fila[7] = ((Paciente) aux).getContactoEmergencia();
					fila[8] = ((Paciente) aux).getNumEmergencia();
					modelo.addRow(fila);
				}
			}
			break;
		case 4:
			for(Paciente aux : Clinica.getInstance().getMisPacientes()) {
				if (aux.getSexo() == 'M') {
					fila[0] = aux.getCedula();
					fila[1] = aux.getNombre();
					fila[2] = aux.getSexo();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					String fechaNacimientoStr = dateFormat.format(aux.getFechaDeNacim());
					fila[3] = fechaNacimientoStr;
					fila[4] = aux.getDireccion();
					fila[5] = aux.getTelefono();
					if(((Paciente) aux).isEstado() == false)
						fila[6] = "Sano";
					else
						fila[6] = "Enfermo";
					fila[7] = ((Paciente) aux).getContactoEmergencia();
					fila[8] = ((Paciente) aux).getNumEmergencia();
					modelo.addRow(fila);
				}
			}
			break;
		default:
			break;
		}
		table.setModel(modelo);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(150);
		columnModel.getColumn(1).setPreferredWidth(100);
		columnModel.getColumn(2).setPreferredWidth(40);
		columnModel.getColumn(3).setPreferredWidth(80);
		columnModel.getColumn(4).setPreferredWidth(150);
		columnModel.getColumn(5).setPreferredWidth(80);
		columnModel.getColumn(6).setPreferredWidth(60);
		columnModel.getColumn(7).setPreferredWidth(140);
		columnModel.getColumn(8).setPreferredWidth(150);
		lblNewLabel_1.setText("Cantidad de Pacientes en Lista: " + Clinica.getInstance().cantPacientes(seleccion));
	}
}

