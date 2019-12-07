package com.dao.reportes;


import java.sql.Connection;
import itesm.database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import itesm.business.AtencionBean;



public class FacturaDAO {
	
	private AtencionBean factura;
	
	public AtencionBean getFactura() {
		return factura;
	}
	

	public void setFactura(AtencionBean factura) {
		this.factura = factura;
	}

	
	public ArrayList<AtencionBean> listaFacturas(String date_s, String date_f) throws SQLException{
		
		ArrayList<AtencionBean> listina = new ArrayList<AtencionBean>();
		String ret = "error";
		Conexion conexion = new Conexion();
	    Connection conn = null;
	      
		 conexion.establishConnection();
	     conn = conexion.getCon();
	     String sql ="SELECT * FROM (Atenciones)";
	      sql+= "WHERE fecha BETWEEN ? AND ? AND factura = 'facturada'";
	    // sql+=" id_propietario = ?"; "SELECT * FROM Cancelaciones";
	     PreparedStatement ps = conn.prepareStatement(sql);
	     ps.setString(1,date_s);
	     ps.setString(2,date_f);
	     ResultSet rs = ps.executeQuery();
	     while (rs.next()) {
	    	 AtencionBean factura = new AtencionBean();
	    	 factura.setId_atencion(rs.getString(1));
	    	 factura.setId_paciente(rs.getString(4));
	    	 factura.setFecha(rs.getString(5));
	    	 factura.setHora_entrada(rs.getString(6));
	    	 factura.setHora_salida(rs.getString(7));
	    	 factura.setFactura(rs.getString(10));
	    	 factura.setMonto(rs.getString(9));
	        listina.add(factura);
	       
	     }
	
	     if (conn != null) {
	        try {
	           conexion.closeConnection();
	        } catch (Exception e) {
				e.printStackTrace();
	        }
	     }
	    
		return listina;
	}
}