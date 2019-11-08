package itesm.database.DAO_Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import itesm.business.SalaBean;
import itesm.database.Conexion;
import itesm.database.DAO_Interfaces.DAOSalas;

public class DAOSalasImpl extends Conexion implements DAOSalas{

	@Override
	public void insertar(SalaBean sala) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
	      
   	 	establishConnection();
        conn = getCon();
        
        /*String sql ="INSERT INTO sala (id_sala, nombre, disponibilidad)";
        sql+="VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, sala.getId_sala());
        ps.setString(2, sala.getNombre_sala());
        ps.setString(3, sala.getEstado_sala());*/
        
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
		return null;
	}

	@Override
	public void editar(SalaBean entidad) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<SalaBean> consultar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
