package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Proveedor;
import model.ProveedorModel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.List;

public class FrmConsultaProveedor extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtRazonSocial;
	private JTextField txtDesde;
	private JTextField txtHasta;
	private JTable table;
	private JButton btnFiltrar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
					FrmConsultaProveedor frame = new FrmConsultaProveedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmConsultaProveedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Consulta sobre proveedor");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(147, 10, 186, 17);
		contentPane.add(lblNewLabel);

		JLabel lblRazonSocial = new JLabel("Raz\u00F3n Social:");
		lblRazonSocial.setBounds(10, 46, 80, 12);
		contentPane.add(lblRazonSocial);

		txtRazonSocial = new JTextField();
		txtRazonSocial.setBounds(101, 43, 96, 18);
		contentPane.add(txtRazonSocial);
		txtRazonSocial.setColumns(10);

		JLabel lblFechaCreacion = new JLabel("Fecha creaci\u00F3n (desde)");
		lblFechaCreacion.setBounds(10, 81, 146, 17);
		contentPane.add(lblFechaCreacion);

		txtDesde = new JTextField();
		txtDesde.setBounds(166, 80, 96, 18);
		contentPane.add(txtDesde);
		txtDesde.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("(hasta)");
		lblNewLabel_1.setBounds(272, 83, 44, 12);
		contentPane.add(lblNewLabel_1);

		txtHasta = new JTextField();
		txtHasta.setBounds(314, 80, 96, 18);
		contentPane.add(txtHasta);
		txtHasta.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 143, 486, 110);
		contentPane.add(scrollPane);

		table = new JTable();

		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Raz\u00F3n Social", "RUC", "Direcci\u00F3n", "Fecha Creaci\u00F3n", "Email", "Rubro", "Estado"
			}
		));
		scrollPane.setViewportView(table);

		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(this);
		btnFiltrar.setBounds(82, 113, 84, 20);
		contentPane.add(btnFiltrar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(207, 113, 84, 20);
		contentPane.add(btnCancelar);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(e);
		}
		if (e.getSource() == btnFiltrar) {
			do_btnFiltrar_actionPerformed(e);
		}
	}
	protected void do_btnFiltrar_actionPerformed(ActionEvent e) {
		//1 Recibimos todos los parametros del formulario
		String razonSocial = txtRazonSocial.getText();
		String desde = txtDesde.getText();
		String hasta = txtHasta.getText();

		//imprimir los parametros recibidos
		System.out.println("Parametros recibidos: ");
		System.out.println("Razon Social: " + razonSocial);
		System.out.println("Desde: " + desde);
		System.out.println("Hasta: " + hasta);

		//2 Validacion
		LocalDate fechaDesde = desde.isEmpty()? LocalDate.parse("9999-01-01"): LocalDate.parse(desde);
		LocalDate fechaHasta = hasta.isEmpty()? LocalDate.parse("9999-01-01"): LocalDate.parse(hasta);

		//3 Crear la clase model
		ProveedorModel objProveedorModel = new ProveedorModel();
		List<Proveedor> lista = objProveedorModel.listaProveedor(razonSocial, fechaDesde, fechaHasta);

		//4 recorremos la lista
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

		for (Proveedor p : lista) {
			Object[] rowData = { p.getIdProveedor(),
								  p.getRazonSocial(),
								  p.getRuc(),
								  p.getDireccion(),
								  p.getFechaCreacion(),
								  p.getEmail(),
								  p.getRubro(),
								  p.getEstado()
								};
			model.addRow(rowData);
		}
	}
	protected void do_btnCancelar_actionPerformed(ActionEvent e) {
		txtRazonSocial.setText("");
		txtDesde.setText("");
		txtHasta.setText("");
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Limpiar la tabla
	}
}
