package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entidad.Proveedor;
import util.MySqlDBConexion;

public class ProveedorModel {

	public int insertaProveedor(Proveedor obj) {
		int salida = -1;

		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// 1 Crear conexion
			conn = MySqlDBConexion.getConexion();

			// 2 Crear sentencia SQL
			String sql = "INSERT INTO proveedores (razonSocial, ruc, direccion, fechaCreacion, email, rubro, estado) VALUES (?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getRazonSocial());
			pstm.setString(2, obj.getRuc());
			pstm.setString(3, obj.getDireccion());
			pstm.setString(4, obj.getFechaCreacion());
			pstm.setString(5, obj.getEmail());
			pstm.setString(6, obj.getRubro());
			pstm.setString(7, obj.getEstado());

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

}