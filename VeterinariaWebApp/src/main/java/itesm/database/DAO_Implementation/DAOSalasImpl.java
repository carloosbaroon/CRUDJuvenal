package itesm.database.DAO_Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import itesm.business.SalaBean;
import itesm.business.UsuarioBean;
import itesm.database.Conexion;
import itesm.database.DAO_Interfaces.DAOSalas;

public class DAOSalasImpl extends Conexion implements DAOSalas{

	@Override
	public void insertar(SalaBean sala) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
	      
   	 	establishConnection();
        conn = getCon();
        
        
        String sql ="INSERT INTO sala (nombre, disponibilidad)";
        sql+="VALUES ( ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, sala.getNombre_sala());
        ps.setString(2, sala.getEstado_sala());
		
        ps.execute();

        if (conn != null) {
           try {
              closeConnection();
           } catch (Exception e) {
				e.printStackTrace();
           }
        }
	}

	@Override
	public SalaBean buscar(String id) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
	      
   	 	establishConnection();
        conn = getCon();
                
        String sql ="SELECT * FROM sala WHERE";
        sql+=" id_sala = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        
        SalaBean sala = null;

        while (rs.next()) {
        	sala = new SalaBean();
        	sala.setId_sala(rs.getString(1));
        	sala.setNombre_sala(rs.getString(2));
        	sala.setEstado_sala(rs.getString(3));           
        }
        
        if (conn != null) {
            try {
               closeConnection();
            } catch (Exception e) {
 				e.printStackTrace();
            }
        }
		return sala;
	}

	@Override
	public void editar(SalaBean sala) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
	      
   	 	establishConnection();
        conn = getCon();
                
        String sql ="UPDATE sala SET nombre = ?, disponibilidad = ? WHERE id_sala = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, sala.getNombre_sala());
        ps.setString(2, sala.getEstado_sala());
        ps.setString(3, sala.getId_sala());
		
        ps.execute();

        if (conn != null) {
           try {
              closeConnection();
           } catch (Exception e) {
				e.printStackTrace();
           }
        }
		
	}
	
	@Override
	public void editarEstado(String id_sala, String estado) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
	      
   	 	establishConnection();
        conn = getCon();
                
        String sql ="UPDATE sala SET disponibilidad = ? WHERE id_sala = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, estado);
        ps.setString(2, id_sala);
		
        ps.execute();

        if (conn != null) {
           try {
              closeConnection();
           } catch (Exception e) {
				e.printStackTrace();
           }
        }
		
	}

	@Override
	public ArrayList<SalaBean> consultar() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<SalaBean> buffer_salas = new ArrayList<SalaBean>();
		String ret = "error";
		
		Connection conn = null;
	      
   	 	establishConnection();
        conn = getCon();
                
        String sql ="SELECT * FROM sala";
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
        	SalaBean salaAux = new SalaBean();
        	salaAux.setId_sala(rs.getString(1));
        	salaAux.setNombre_sala(rs.getString(2));
        	salaAux.setEstado_sala(rs.getString(3));
           
	       	buffer_salas.add(salaAux);
        }
        
        if (conn != null) {
            try {
               closeConnection();
            } catch (Exception e) {
 				e.printStackTrace();
            }
        }
        
		return buffer_salas;
	}

}
