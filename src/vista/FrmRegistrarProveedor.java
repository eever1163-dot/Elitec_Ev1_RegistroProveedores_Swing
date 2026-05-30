package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
 
import entidad.Proveedor;
import model.ProveedorModel;
import util.ValidateUtil;
 
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmRegistrarProveedor extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtRazonSocial;
	private JTextField txtRuc;
	private JTextField txtDireccion;
	private JTextField txtFechaCreacion;
	private JTextField txtEmail;
	private JTextField txtRubro;
	private JButton btnRegistrar;
	private JComboBox<String> comboEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					FrmRegistrarProveedor frame = new FrmRegistrarProveedor();
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
	public FrmRegistrarProveedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro Proveedores");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(125, 10, 148, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Razom Social");
		lblNewLabel_1.setBounds(10, 46, 83, 12);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ruc");
		lblNewLabel_2.setBounds(10, 68, 44, 12);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Drireccion");
		lblNewLabel_3.setBounds(10, 90, 65, 12);
		contentPane.add(lblNewLabel_3);
		
		txtRazonSocial = new JTextField();
		txtRazonSocial.setBounds(142, 43, 96, 18);
		contentPane.add(txtRazonSocial);
		txtRazonSocial.setColumns(10);
		
		txtRuc = new JTextField();
		txtRuc.setBounds(142, 65, 96, 18);
		contentPane.add(txtRuc);
		txtRuc.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(142, 87, 96, 18);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha Creacion");
		lblNewLabel_4.setBounds(10, 112, 83, 12);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setBounds(10, 134, 44, 12);
		contentPane.add(lblNewLabel_5);
		
		txtFechaCreacion = new JTextField();
		txtFechaCreacion.setBounds(142, 109, 96, 18);
		contentPane.add(txtFechaCreacion);
		txtFechaCreacion.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(142, 131, 96, 18);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Rubro");
		lblNewLabel_6.setBounds(10, 156, 44, 12);
		contentPane.add(lblNewLabel_6);
		
		txtRubro = new JTextField();
		txtRubro.setBounds(142, 153, 96, 18);
		contentPane.add(txtRubro);
		txtRubro.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(177, 222, 84, 20);
		contentPane.add(btnRegistrar);
		
		JLabel lblNewLabel_7 = new JLabel("Estado");
		lblNewLabel_7.setBounds(10, 181, 44, 12);
		contentPane.add(lblNewLabel_7);
		
		comboEstado = new JComboBox<>();
		comboEstado.setModel(new DefaultComboBoxModel<>(new String[] {"Activo", "Suspendido", "Inactivo"}));
		comboEstado.setBounds(142, 181, 96, 20);
		contentPane.add(comboEstado);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {

		// 1 Recibir los datos del formulario en String
				String razonSocial = txtRazonSocial.getText().trim();
				String ruc = txtRuc.getText().trim();
				String direccion = txtDireccion.getText().trim();
				String fechaCreacion = txtFechaCreacion.getText().trim();
				String email = txtEmail.getText().trim();
				String rubro = txtRubro.getText().trim();
				String estado = (String) comboEstado.getSelectedItem();
		 
				// 2 Validar datos
				if (razonSocial.matches(ValidateUtil.RAZON_SOCIAL) == false) {
					JOptionPane.showMessageDialog(this, "La razón social no es válida. Solo letras, números y caracteres permitidos (máx. 100)");
					return;
				}
				if (ruc.matches(ValidateUtil.RUC) == false) {
					JOptionPane.showMessageDialog(this, "El RUC no es válido. Debe tener exactamente 11 dígitos");
					return;
				}
				if (direccion.matches(ValidateUtil.DIRECCION) == false) {
					JOptionPane.showMessageDialog(this, "La dirección no es válida. Debe tener entre 5 y 150 caracteres");
					return;
				}
				if (fechaCreacion.matches(ValidateUtil.FECHA_CREACION) == false) {
					JOptionPane.showMessageDialog(this, "La fecha de creación no es válida. Use el formato YYYY-MM-DD");
					return;
				}
				if (email.matches(ValidateUtil.EMAIL) == false) {
					JOptionPane.showMessageDialog(this, "El email no es válido");
					return;
				}
				if (rubro.matches(ValidateUtil.RUBRO) == false) {
					JOptionPane.showMessageDialog(this, "El rubro no es válido. Solo letras (mín. 3, máx. 50 caracteres)");
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
		 
				// 4 Crear el objeto ProveedorModel
				ProveedorModel model = new ProveedorModel();
				int salida = model.insertaProveedor(obj);
		 
				// 5 Mostrar el resultado
				if (salida > 0) {
					JOptionPane.showMessageDialog(this, "Proveedor registrado correctamente");
				} else {
					JOptionPane.showMessageDialog(this, "Error al registrar el proveedor");
				}
				
	           }
	}
