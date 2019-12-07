package com.dao.reportes;


import java.sql.Connection;
import itesm.database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import itesm.business.ConsultaBean;



public class ConsultaDAO {
	
	private ConsultaBean consulta;
	
	public ConsultaBean getConsulta() {
		return consulta;
	}
	

	public void setConsulta(ConsultaBean consulta) {
		this.consulta = consulta;
	}

	
	public ArrayList<ConsultaBean> listaConsultas(String id, String date_s, String date_f) throws SQLException{
		
		ArrayList<ConsultaBean> listina = new ArrayList<ConsultaBean>();
		String ret = "error";
		Conexion conexion = new Conexion();
	    Connection conn = null;
	      
		 conexion.establishConnection();
	     conn = conexion.getCon();
	     String sql ="SELECT * FROM (Consultas)";
	      sql+= "WHERE fecha BETWEEN ? AND ? AND id_paciente = ?";
	    // sql+=" id_propietario = ?"; "SELECT * FROM Cancelaciones";
	     PreparedStatement ps = conn.prepareStatement(sql);
	     ps.setString(1,date_s);
	     ps.setString(2,date_f);
	     ps.setString(3,id);
	     ResultSet rs = ps.executeQuery();
	     while (rs.next()) {
	    	 ConsultaBean consulta = new ConsultaBean();
	    	 consulta.setFecha_consulta(rs.getString(2));
	    	 consulta.setId_empleado(rs.getString(5));
	    	 consulta.setId_paciente(rs.getString(7));
	    	 consulta.setObservaciones(rs.getString(9));
	    	 consulta.setId_sala(rs.getString(6));
	        listina.add(consulta);
	       
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