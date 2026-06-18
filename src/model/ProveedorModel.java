package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Proveedor;
import util.MySqlDBConexion;

public class ProveedorModel {

	// ─────────────────────────────────────────
	// INSERT
	// ─────────────────────────────────────────
	public int insertaProveedor(Proveedor obj) {
		int salida = -1;

		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// 1 Crear conexion
			conn = MySqlDBConexion.getConexion();

			// 2 Crear sentencia SQL
			String sql = "INSERT INTO proveedores (razonSocial, ruc, direccion, fechaCreacion, email, rubro, estado) "
					+ "VALUES (?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getRazonSocial());
			pstm.setString(2, obj.getRuc());
			pstm.setString(3, obj.getDireccion());
			pstm.setString(4, obj.getFechaCreacion());
			pstm.setString(5, obj.getEmail());
			pstm.setString(6, obj.getRubro());
			pstm.setString(7, obj.getEstado());

			System.out.println("SQL: " + pstm.toString());

			// 3 Ejecutar sentencia SQL
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	// ─────────────────────────────────────────
	// SELECT ALL
	// ─────────────────────────────────────────
	public List<Proveedor> listaTodos() {
		ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			conn = MySqlDBConexion.getConexion();
			String sql = "SELECT * FROM proveedores";
			pstm = conn.prepareStatement(sql);

			System.out.println("SQL: " + pstm.toString());

			rs = pstm.executeQuery();

			while (rs.next()) {
				Proveedor p = new Proveedor();
				p.setIdProveedor(rs.getInt("idproveedor"));
				p.setRazonSocial(rs.getString("razonSocial"));
				p.setRuc(rs.getString("ruc"));
				p.setDireccion(rs.getString("direccion"));
				p.setFechaCreacion(rs.getString("fechaCreacion"));
				p.setEmail(rs.getString("email"));
				p.setRubro(rs.getString("rubro"));
				p.setEstado(rs.getString("estado"));
				lista.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

	// ─────────────────────────────────────────
	// SELECT BY ID
	// ─────────────────────────────────────────
	public Proveedor buscaProveedor(int id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Proveedor p = null;

		try {
			conn = MySqlDBConexion.getConexion();
			String sql = "SELECT * FROM proveedores WHERE idproveedor = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			System.out.println("SQL: " + pstm.toString());

			rs = pstm.executeQuery();

			if (rs.next()) {
				p = new Proveedor();
				p.setIdProveedor(rs.getInt("idproveedor"));
				p.setRazonSocial(rs.getString("razonSocial"));
				p.setRuc(rs.getString("ruc"));
				p.setDireccion(rs.getString("direccion"));
				p.setFechaCreacion(rs.getString("fechaCreacion"));
				p.setEmail(rs.getString("email"));
				p.setRubro(rs.getString("rubro"));
				p.setEstado(rs.getString("estado"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return p;
	}

	// ─────────────────────────────────────────
	// UPDATE
	// ─────────────────────────────────────────
	public int actualizaProveedor(Proveedor obj) {
		int salida = -1;

		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// 1 Crear conexion
			conn = MySqlDBConexion.getConexion();

			// 2 Crear sentencia SQL
			String sql = "UPDATE proveedores SET razonSocial=?, ruc=?, direccion=?, fechaCreacion=?, "
					+ "email=?, rubro=?, estado=? WHERE idproveedor=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getRazonSocial());
			pstm.setString(2, obj.getRuc());
			pstm.setString(3, obj.getDireccion());
			pstm.setString(4, obj.getFechaCreacion());
			pstm.setString(5, obj.getEmail());
			pstm.setString(6, obj.getRubro());
			pstm.setString(7, obj.getEstado());
			pstm.setInt(8, obj.getIdProveedor());

			System.out.println("SQL: " + pstm.toString());

			// 3 Ejecutar sentencia SQL
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	// ─────────────────────────────────────────
	// DELETE FISICO
	// ─────────────────────────────────────────
	public int eliminaProveedor(int id) {
		int salida = -1;

		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// 1 Crear conexion
			conn = MySqlDBConexion.getConexion();

			// 2 Crear sentencia SQL
			String sql = "DELETE FROM proveedores WHERE idproveedor = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			System.out.println("SQL: " + pstm.toString());

			// 3 Ejecutar sentencia SQL
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	// ─────────────────────────────────────────
	// SELECT con filtros (para FrmConsultaProveedor)
	// ─────────────────────────────────────────
	public List<Proveedor> listaProveedor(String razonSocial, String desde, String hasta) {
		ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			conn = MySqlDBConexion.getConexion();
			String sql = "SELECT * FROM proveedores WHERE "
					+ " razonSocial LIKE ? AND "
					+ " ( ? ='9999-01-01' OR fechaCreacion >= ? ) AND "
					+ " ( ? ='9999-01-01' OR fechaCreacion <= ? ) ";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%" + razonSocial + "%");
			pstm.setString(2, desde);
			pstm.setString(3, desde);
			pstm.setString(4, hasta);
			pstm.setString(5, hasta);

			System.out.println("SQL: " + pstm.toString());

			rs = pstm.executeQuery();

			while (rs.next()) {
				Proveedor p = new Proveedor();
				p.setIdProveedor(rs.getInt("idproveedor"));
				p.setRazonSocial(rs.getString("razonSocial"));
				p.setRuc(rs.getString("ruc"));
				p.setDireccion(rs.getString("direccion"));
				p.setFechaCreacion(rs.getString("fechaCreacion"));
				p.setEmail(rs.getString("email"));
				p.setRubro(rs.getString("rubro"));
				p.setEstado(rs.getString("estado"));
				lista.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}
}