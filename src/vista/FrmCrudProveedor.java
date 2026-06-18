package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import entidad.Proveedor;
import model.ProveedorModel;
import util.ValidateUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class FrmCrudProveedor extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// Campos del formulario
	private JTextField txtCodigo;
	private JTextField txtRazonSocial;
	private JTextField txtRuc;
	private JTextField txtDireccion;
	private JTextField txtFechaCreacion;
	private JTextField txtEmail;
	private JTextField txtRubro;
	private JComboBox<String> cmbEstado;

	// Tabla
	private JTable table;

	// Botones
	private JButton btnListar;
	private JButton btnBuscar;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JButton btnEliminarLogico;
	private JButton btnEliminarFisico;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
					FrmCrudProveedor frame = new FrmCrudProveedor();
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
	public FrmCrudProveedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1370, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// ── Título ──────────────────────────────────────────
		JLabel lblTitulo = new JLabel("Mantenimiento Proveedor");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setBounds(31, 11, 1280, 34);
		contentPane.add(lblTitulo);

		// ── Labels ──────────────────────────────────────────
		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setBounds(31, 65, 101, 14);
		contentPane.add(lblCodigo);

		JLabel lblRazonSocial = new JLabel("Razón Social");
		lblRazonSocial.setBounds(31, 100, 101, 14);
		contentPane.add(lblRazonSocial);

		JLabel lblRuc = new JLabel("RUC");
		lblRuc.setBounds(31, 135, 101, 14);
		contentPane.add(lblRuc);

		JLabel lblDireccion = new JLabel("Dirección");
		lblDireccion.setBounds(31, 170, 101, 14);
		contentPane.add(lblDireccion);

		JLabel lblFechaCreacion = new JLabel("Fecha Creación");
		lblFechaCreacion.setBounds(31, 205, 120, 14);
		contentPane.add(lblFechaCreacion);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(31, 240, 101, 14);
		contentPane.add(lblEmail);

		JLabel lblRubro = new JLabel("Rubro");
		lblRubro.setBounds(31, 275, 101, 14);
		contentPane.add(lblRubro);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(31, 310, 101, 14);
		contentPane.add(lblEstado);

		// ── TextFields ──────────────────────────────────────
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(163, 62, 120, 20);
		contentPane.add(txtCodigo);

		txtRazonSocial = new JTextField();
		txtRazonSocial.setColumns(10);
		txtRazonSocial.setBounds(163, 97, 250, 20);
		contentPane.add(txtRazonSocial);

		txtRuc = new JTextField();
		txtRuc.setColumns(10);
		txtRuc.setBounds(163, 132, 150, 20);
		contentPane.add(txtRuc);

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(163, 167, 300, 20);
		contentPane.add(txtDireccion);

		txtFechaCreacion = new JTextField();
		txtFechaCreacion.setColumns(10);
		txtFechaCreacion.setBounds(163, 202, 143, 20);
		contentPane.add(txtFechaCreacion);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(163, 237, 250, 20);
		contentPane.add(txtEmail);

		txtRubro = new JTextField();
		txtRubro.setColumns(10);
		txtRubro.setBounds(163, 272, 200, 20);
		contentPane.add(txtRubro);

		// ── ComboBox Estado ─────────────────────────────────
		cmbEstado = new JComboBox<>(new String[] { "Activo", "Inactivo", "En Revisión" });
		cmbEstado.setBounds(163, 307, 150, 22);
		contentPane.add(cmbEstado);

		// ── Botones ─────────────────────────────────────────
		btnListar = new JButton("Listar Todos");
		btnListar.addActionListener(this);
		btnListar.setBounds(490, 60, 140, 23);
		contentPane.add(btnListar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(490, 95, 140, 23);
		contentPane.add(btnBuscar);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(490, 130, 140, 23);
		contentPane.add(btnRegistrar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(490, 165, 140, 23);
		contentPane.add(btnActualizar);

		btnEliminarLogico = new JButton("Eliminar lógico");
		btnEliminarLogico.addActionListener(this);
		btnEliminarLogico.setBounds(490, 200, 140, 23);
		contentPane.add(btnEliminarLogico);

		btnEliminarFisico = new JButton("Eliminar físico");
		btnEliminarFisico.addActionListener(this);
		btnEliminarFisico.setBounds(490, 235, 140, 23);
		contentPane.add(btnEliminarFisico);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(490, 270, 140, 23);
		contentPane.add(btnLimpiar);

		// ── Tabla ────────────────────────────────────────────
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(660, 50, 680, 420);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Código", "Razón Social", "RUC", "Dirección", "Fecha Creación", "Email", "Rubro", "Estado" }));

		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(130);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		table.getColumnModel().getColumn(5).setPreferredWidth(130);
		table.getColumnModel().getColumn(6).setPreferredWidth(70);
		table.getColumnModel().getColumn(7).setPreferredWidth(70);

		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);

		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		defaults.putIfAbsent("Table.alternateRowColor", new Color(176, 245, 215));

		scrollPane.setViewportView(table);
	}

	// ═══════════════════════════════════════════════════════════
	// ACTION PERFORMED
	// ═══════════════════════════════════════════════════════════
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLimpiar) {
			do_btnLimpiar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminarFisico) {
			do_btnEliminarFisico_actionPerformed(e);
		}
		if (e.getSource() == btnEliminarLogico) {
			do_btnEliminarLogico_actionPerformed(e);
		}
		if (e.getSource() == btnActualizar) {
			do_btnActualizar_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrar) {
			do_btnRegistrar_actionPerformed(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
		if (e.getSource() == btnListar) {
			do_btnListar_actionPerformed(e);
		}
	}

	protected void do_btnListar_actionPerformed(ActionEvent e) {
		listarTodos();
	}

	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		buscar();
	}

	protected void do_btnRegistrar_actionPerformed(ActionEvent e) {
		registrar();
		listarTodos();
		limpiar();
	}

	protected void do_btnActualizar_actionPerformed(ActionEvent e) {
		actualizar();
		listarTodos();
		limpiar();
	}

	protected void do_btnEliminarLogico_actionPerformed(ActionEvent e) {
		eliminarLogico();
		listarTodos();
		limpiar();
	}

	protected void do_btnEliminarFisico_actionPerformed(ActionEvent e) {
		eliminarFisico();
		listarTodos();
		limpiar();
	}

	protected void do_btnLimpiar_actionPerformed(ActionEvent e) {
		limpiar();
	}

	// ═══════════════════════════════════════════════════════════
	// MOUSE LISTENER
	// ═══════════════════════════════════════════════════════════
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			do_table_mouseClicked(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void do_table_mouseClicked(MouseEvent e) {
		seleccionarFila();
	}

	// ═══════════════════════════════════════════════════════════
	// MÉTODOS CRUD
	// ═══════════════════════════════════════════════════════════

	void seleccionarFila() {
		int fila = table.getSelectedRow();
		txtCodigo.setText(table.getValueAt(fila, 0).toString());
		txtRazonSocial.setText(table.getValueAt(fila, 1).toString());
		txtRuc.setText(table.getValueAt(fila, 2).toString());
		txtDireccion.setText(table.getValueAt(fila, 3).toString());
		txtFechaCreacion.setText(table.getValueAt(fila, 4).toString());
		txtEmail.setText(table.getValueAt(fila, 5).toString());
		txtRubro.setText(table.getValueAt(fila, 6).toString());
		cmbEstado.setSelectedItem(table.getValueAt(fila, 7).toString());
	}

	void listarTodos() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

		ProveedorModel model = new ProveedorModel();
		List<Proveedor> lista = model.listaTodos();
		for (Proveedor p : lista) {
			Object[] rowData = {
				p.getIdProveedor(),
				p.getRazonSocial(),
				p.getRuc(),
				p.getDireccion(),
				p.getFechaCreacion(),
				p.getEmail(),
				p.getRubro(),
				p.getEstado()
			};
			dtm.addRow(rowData);
		}
	}

	void buscar() {
		String codigo = txtCodigo.getText().trim();
		if (codigo.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Seleccione un proveedor o ingrese un código válido");
			return;
		}
		ProveedorModel model = new ProveedorModel();
		Proveedor objProveedor = model.buscaProveedor(Integer.parseInt(codigo));
		if (objProveedor == null) {
			JOptionPane.showMessageDialog(this, "No existe el proveedor con código " + codigo);
			limpiar();
			return;
		}
		txtCodigo.setText(String.valueOf(objProveedor.getIdProveedor()));
		txtRazonSocial.setText(objProveedor.getRazonSocial());
		txtRuc.setText(objProveedor.getRuc());
		txtDireccion.setText(objProveedor.getDireccion());
		txtFechaCreacion.setText(objProveedor.getFechaCreacion());
		txtEmail.setText(objProveedor.getEmail());
		txtRubro.setText(objProveedor.getRubro());
		cmbEstado.setSelectedItem(objProveedor.getEstado());

		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		Object[] rowData = {
			objProveedor.getIdProveedor(),
			objProveedor.getRazonSocial(),
			objProveedor.getRuc(),
			objProveedor.getDireccion(),
			objProveedor.getFechaCreacion(),
			objProveedor.getEmail(),
			objProveedor.getRubro(),
			objProveedor.getEstado()
		};
		dtm.addRow(rowData);
	}

	void registrar() {
		// 1 Recibir los datos del formulario en String
		String razonSocial   = txtRazonSocial.getText().trim();
		String ruc           = txtRuc.getText().trim();
		String direccion     = txtDireccion.getText().trim();
		String fechaCreacion = txtFechaCreacion.getText().trim();
		String email         = txtEmail.getText().trim();
		String rubro         = txtRubro.getText().trim();
		String estado        = cmbEstado.getSelectedItem().toString();

		// 2 Validar los datos
		if (razonSocial.matches(ValidateUtil.RAZON_SOCIAL) == false) {
			JOptionPane.showMessageDialog(this, "La Razón Social no es válida (1-100 caracteres)");
			return;
		}
		if (ruc.matches(ValidateUtil.RUC) == false) {
			JOptionPane.showMessageDialog(this, "El RUC no es válido. Debe tener exactamente 11 dígitos");
			return;
		}
		if (direccion.matches(ValidateUtil.DIRECCION) == false) {
			JOptionPane.showMessageDialog(this, "La Dirección no es válida (5-150 caracteres)");
			return;
		}
		if (fechaCreacion.matches(ValidateUtil.FECHA_CREACION) == false) {
			JOptionPane.showMessageDialog(this, "La Fecha de Creación no es válida. Formato: YYYY-MM-DD");
			return;
		}
		if (email.matches(ValidateUtil.EMAIL) == false) {
			JOptionPane.showMessageDialog(this, "El Email no es válido");
			return;
		}
		if (rubro.matches(ValidateUtil.RUBRO) == false) {
			JOptionPane.showMessageDialog(this, "El Rubro no es válido (3-50 letras)");
			return;
		}

		// 3 Crear el objeto Proveedor
		Proveedor obj = new Proveedor();
		obj.setRazonSocial(razonSocial);
		obj.setRuc(ruc);
		obj.setDireccion(direccion);
		obj.setFechaCreacion(fechaCreacion);
		obj.setEmail(email);
		obj.setRubro(rubro);
		obj.setEstado(estado);

		// 4 Llamar al Model
		ProveedorModel model = new ProveedorModel();
		int salida = model.insertaProveedor(obj);

		// 5 Mostrar el resultado
		if (salida > 0) {
			JOptionPane.showMessageDialog(this, "Proveedor registrado correctamente");
		} else {
			JOptionPane.showMessageDialog(this, "Error al registrar el proveedor");
		}
	}

	void actualizar() {
		// 1 Recibir los datos del formulario en String
		String codigo        = txtCodigo.getText().trim();
		String razonSocial   = txtRazonSocial.getText().trim();
		String ruc           = txtRuc.getText().trim();
		String direccion     = txtDireccion.getText().trim();
		String fechaCreacion = txtFechaCreacion.getText().trim();
		String email         = txtEmail.getText().trim();
		String rubro         = txtRubro.getText().trim();
		String estado        = cmbEstado.getSelectedItem().toString();

		// 2 Validar los datos
		if (codigo.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Seleccione un proveedor o ingrese un código válido");
			return;
		}
		if (razonSocial.matches(ValidateUtil.RAZON_SOCIAL) == false) {
			JOptionPane.showMessageDialog(this, "La Razón Social no es válida (1-100 caracteres)");
			return;
		}
		if (ruc.matches(ValidateUtil.RUC) == false) {
			JOptionPane.showMessageDialog(this, "El RUC no es válido. Debe tener exactamente 11 dígitos");
			return;
		}
		if (direccion.matches(ValidateUtil.DIRECCION) == false) {
			JOptionPane.showMessageDialog(this, "La Dirección no es válida (5-150 caracteres)");
			return;
		}
		if (fechaCreacion.matches(ValidateUtil.FECHA_CREACION) == false) {
			JOptionPane.showMessageDialog(this, "La Fecha de Creación no es válida. Formato: YYYY-MM-DD");
			return;
		}
		if (email.matches(ValidateUtil.EMAIL) == false) {
			JOptionPane.showMessageDialog(this, "El Email no es válido");
			return;
		}
		if (rubro.matches(ValidateUtil.RUBRO) == false) {
			JOptionPane.showMessageDialog(this, "El Rubro no es válido (3-50 letras)");
			return;
		}

		// 3 Crear el objeto Proveedor
		Proveedor obj = new Proveedor();
		obj.setIdProveedor(Integer.parseInt(codigo));
		obj.setRazonSocial(razonSocial);
		obj.setRuc(ruc);
		obj.setDireccion(direccion);
		obj.setFechaCreacion(fechaCreacion);
		obj.setEmail(email);
		obj.setRubro(rubro);
		obj.setEstado(estado);

		// 4 Llamar al Model
		ProveedorModel model = new ProveedorModel();
		int salida = model.actualizaProveedor(obj);

		// 5 Mostrar el resultado
		if (salida > 0) {
			JOptionPane.showMessageDialog(this, "Proveedor actualizado correctamente");
		} else {
			JOptionPane.showMessageDialog(this, "Error al actualizar el proveedor");
		}
	}

	void eliminarLogico() {
		String codigo = txtCodigo.getText().trim();
		if (codigo.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Seleccione un proveedor o ingrese un código válido");
			return;
		}
		ProveedorModel model = new ProveedorModel();
		Proveedor objProveedor = model.buscaProveedor(Integer.parseInt(codigo));
		if (objProveedor == null) {
			JOptionPane.showMessageDialog(this, "No existe el proveedor con código " + codigo);
			return;
		}
		// Alternar estado: si es "Activo" pasa a "Inactivo", y viceversa
		String nuevoEstado = "Activo".equalsIgnoreCase(objProveedor.getEstado()) ? "Inactivo" : "Activo";
		objProveedor.setEstado(nuevoEstado);
		model.actualizaProveedor(objProveedor);
		JOptionPane.showMessageDialog(this, "Estado cambiado a: " + nuevoEstado);
	}

	void eliminarFisico() {
		String codigo = txtCodigo.getText().trim();
		if (codigo.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Seleccione un proveedor o ingrese un código válido");
			return;
		}

		int confirm = JOptionPane.showConfirmDialog(
				this,
				"¿Confirma eliminar el proveedor con código " + codigo + "?",
				"Confirmar eliminación",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);
		if (confirm != JOptionPane.YES_OPTION) {
			return;
		}

		ProveedorModel model = new ProveedorModel();
		int salida = model.eliminaProveedor(Integer.parseInt(codigo));
		if (salida > 0) {
			JOptionPane.showMessageDialog(this, "Proveedor eliminado correctamente");
		} else {
			JOptionPane.showMessageDialog(this, "Error al eliminar el proveedor");
		}
	}

	void limpiar() {
		txtCodigo.setText("");
		txtRazonSocial.setText("");
		txtRuc.setText("");
		txtDireccion.setText("");
		txtFechaCreacion.setText("");
		txtEmail.setText("");
		txtRubro.setText("");
		cmbEstado.setSelectedIndex(0);
	}
}