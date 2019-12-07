package com.dao.reportes;


import java.sql.Connection;
import itesm.database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import itesm.business.CancelacionBean;



public class CancelacionDAO {
	
	private CancelacionBean cancelacion;
	
	public CancelacionBean getCancelacion() {
		return cancelacion;
	}
	

	public void setCancelacion(CancelacionBean cancelacion) {
		this.cancelacion = cancelacion;
	}

	
	public ArrayList<CancelacionBean> listaCancelaciones(int date) throws SQLException{
		
		ArrayList<CancelacionBean> listina = new ArrayList<CancelacionBean>();
		String ret = "error";
		Conexion conexion = new Conexion();
	    Connection conn = null;
	      
		 conexion.establishConnection();
	     conn = conexion.getCon();
	     String sql ="SELECT * FROM (Cancelaciones)";
	      sql+= "WHERE EXTRACT(MONTH FROM fecha)= ?" ;
	    // sql+=" id_propietario = ?"; "SELECT * FROM Cancelaciones";
	     PreparedStatement ps = conn.prepareStatement(sql);
	     ps.setInt(1,date);
	     ResultSet rs = ps.executeQuery();
	     while (rs.next()) {
	    	 CancelacionBean cancelacion = new CancelacionBean();
	    	 cancelacion.setId_consulta(rs.getString(1));
	    	 cancelacion.setFecha(rs.getString(2));
	    	 cancelacion.setMotivo(rs.getString(3));
	        listina.add(cancelacion);
	       
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