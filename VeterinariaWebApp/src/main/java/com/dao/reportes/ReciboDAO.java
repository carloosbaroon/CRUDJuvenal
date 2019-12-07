package com.dao.reportes;


import java.sql.Connection;
import itesm.database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import itesm.business.AtencionBean;



public class ReciboDAO {
	
	private AtencionBean recibo;
	
	public AtencionBean getRecibo() {
		return recibo;
	}
	

	public void setRecibo(AtencionBean recibo) {
		this.recibo = recibo;
	}

	
	public ArrayList<AtencionBean> listaRecibos(String id) throws SQLException{
		
		ArrayList<AtencionBean> listina = new ArrayList<AtencionBean>();
		String ret = "error";
		Conexion conexion = new Conexion();
	    Connection conn = null;
	      
		 conexion.establishConnection();
	     conn = conexion.getCon();
	     String sql ="SELECT * FROM (Atenciones)";
	      sql+= "WHERE id_atencion = ?" ;
	    // sql+=" id_propietario = ?"; "SELECT * FROM Cancelaciones";
	      PreparedStatement ps = conn.prepareStatement(sql);
		     ps.setString(1,id);
		   
		     ResultSet rs = ps.executeQuery();
		     while (rs.next()) {
		    	 AtencionBean recibo = new AtencionBean();
		    	 recibo.setId_atencion(rs.getString(1));
		    	 recibo.setDetalle(rs.getString(8));
		    	 recibo.setId_paciente(rs.getString(4));
		    	 recibo.setFecha(rs.getString(5));
		    	 recibo.setHora_entrada(rs.getString(6));
		    	 recibo.setMonto(rs.getString(9));
		        listina.add(recibo);
	       
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