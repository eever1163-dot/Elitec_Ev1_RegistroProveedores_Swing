package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

	public List<Proveedor> listaProveedor(String razonSocial, LocalDate desde, LocalDate hasta) {
	    ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
	    Connection conn = null;
	    PreparedStatement pstm = null;
	    ResultSet rs = null;

	    try {
	        conn = MySqlDBConexion.getConexion();
	        String sql = "SELECT * FROM proveedores WHERE "
	                + " razonSocial LIKE ? AND "
	                + " ( ? ='9999-01-01' or fechaCreacion > ? ) AND "
	                + " ( ? ='9999-01-01' or fechaCreacion < ? ) ";
	        pstm = conn.prepareStatement(sql);
	        pstm.setString(1, "%" + razonSocial + "%");
	        pstm.setDate(2, java.sql.Date.valueOf(desde));
	        pstm.setDate(3, java.sql.Date.valueOf(desde));
	        pstm.setDate(4, java.sql.Date.valueOf(hasta));
	        pstm.setDate(5, java.sql.Date.valueOf(hasta));

	        System.out.println("SQL: " + pstm.toString());

	        rs = pstm.executeQuery();

	        while (rs.next()) {
	            Proveedor p = new Proveedor();
	            p.setIdProveedor(rs.getInt("idProveedor"));
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