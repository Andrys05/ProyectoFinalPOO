package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logico.Clinica;
import logico.Consulta;
import logico.Paciente;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

public class ListConsultas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static DefaultTableModel modelo;
	private static Object[] fila;
	private static int seleccion;
	private int codigo;
	private static Consulta seleccionado = null;
	private static Paciente miPaciente = null;
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			ListConsultas dialog = new ListConsultas();
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
	public ListConsultas(Paciente paciente) {
		miPaciente = paciente;
		if(miPaciente != null) 
			setTitle("Consulta Historial de "+ miPaciente.getNombre());
		else
			setTitle("Listado de Consultas");
		setBounds(100, 100, 853, 491);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 36, 807, 362);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{
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
								//btnModificar.setEnabled(true);
								seleccionado = Clinica.getInstance().buscarConsulta(table.getValueAt(index, 0).toString());
								codigo = (int)table.getModel().getValueAt(index, 0);
							}
						}
					});
					modelo = new DefaultTableModel();
					String[] headers = {"Codigo", "Paciente", "Medico", "Tiempo", "Desc.", "Diagnostico"};
					modelo.setColumnIdentifiers(headers);
					loadConsultas(0);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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

	public static void loadConsultas(int seleccion) {
		modelo.setRowCount(0);
		fila = new Object[modelo.getColumnCount()];
		
		if(miPaciente == null) {
			for(Consulta aux : Clinica.getInstance().getMisConsultas()) {
				fila[0] = aux.getCodigo();
				fila[1] = aux.getPaciente().getNombre();
				fila[2] = aux.getMedico().getNombre();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
				String fechaOcurrida = dateFormat.format(aux.getFechaConsulta());
				fila[3] = fechaOcurrida;
				fila[4] = aux.getDescripcion();
				if(aux.getDiagnostico() == null) 
					fila[5] = "N/A";
				else
					fila[5] = aux.getDiagnostico().getNombre();
				modelo.addRow(fila);
			}
		}
		else {
			for(Consulta aux : Clinica.getInstance().getMisConsultas()) {
				if(aux.getPaciente().getCedula() == miPaciente.getCedula()) {
					fila[0] = aux.getCodigo();
					fila[1] = aux.getPaciente().getNombre();
					fila[2] = aux.getMedico().getNombre();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
					String fechaOcurrida = dateFormat.format(aux.getFechaConsulta());
					fila[3] = fechaOcurrida;
					fila[4] = aux.getDescripcion();
					if(aux.getDiagnostico() == null) 
						fila[5] = "N/A";
					else
						fila[5] = aux.getDiagnostico().getNombre();
					modelo.addRow(fila);
				}
			}
		}
		
		table.setModel(modelo);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(110);
		columnModel.getColumn(1).setPreferredWidth(120);
		columnModel.getColumn(2).setPreferredWidth(120);
		columnModel.getColumn(3).setPreferredWidth(120);
		columnModel.getColumn(4).setPreferredWidth(220);
		columnModel.getColumn(5).setPreferredWidth(120);
	}
}
