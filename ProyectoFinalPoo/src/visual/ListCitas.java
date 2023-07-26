package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Clinica;

import java.awt.Color;


public class ListCitas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object row[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListCitas dialog = new ListCitas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListCitas() {
		setBounds(100, 100, 588, 476);
		setLocationRelativeTo(null);
		setTitle("Listado de Citas");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					{
						String headers[]= {"Numero de cita","Paciente","Doctor","Tipo","Fecha","Hora"};
					    model = new DefaultTableModel();
						model.setColumnIdentifiers(headers);
						table = new JTable();
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								if(table.getSelectedRow()>-1) {
									//okButton.setEnabled(true);
								}
							}
						});
						table.setModel(model);
						scrollPane.setViewportView(table);
					}
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Volver");
				okButton.setForeground(Color.BLACK);
				okButton.setBackground(Color.LIGHT_GRAY);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();		
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		loadTable();
	}
	private void loadTable() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for(int i = 0; i < Clinica.getInstance().getMisCitas().size();i++) {
		 row[0] = i;
		 row[1] = Clinica.getInstance().getMisCitas().get(i).getNombre();
		 row[2] = Clinica.getInstance().getMisCitas().get(i).getDoctor();
		 row[3] = Clinica.getInstance().getMisCitas().get(i).getTipo();
		 row[4] = Clinica.getInstance().getMisCitas().get(i).getFecha();
		 row[5] = Clinica.getInstance().getMisCitas().get(i).getHora();
		 
		 model.addRow(row);
		}
		}

}