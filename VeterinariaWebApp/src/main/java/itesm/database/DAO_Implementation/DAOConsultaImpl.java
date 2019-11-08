package itesm.database.DAO_Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import itesm.business.ConsultaBean;
import itesm.business.SalaBean;
import itesm.database.Conexion;
import itesm.database.DAO_Interfaces.DAOConsulta;

public class DAOConsultaImpl extends Conexion implements DAOConsulta{

	@Override
	public void insertar(ConsultaBean consulta) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
	      
   	 	establishConnection();
        conn = getCon();
        
        String sql ="INSERT INTO consultas (fecha, hora_inicial, hora_final, id_empleado, id_sala, id_paciente, observaciones, estado)";
        sql+="VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, consulta.getFecha_consulta());
        ps.setString(2, consulta.getHora_inicial());
        ps.setString(3, consulta.getHora_final());
        ps.setString(4, consulta.getId_empleado());
        ps.setString(5, consulta.getId_sala());
        ps.setString(6, consulta.getId_paciente());
        ps.setString(7, consulta.getObservaciones());
        ps.setString(8, consulta.getEstado_consulta());
		
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
	public ConsultaBean buscar(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<SalaBean> consultarDisponibles(String fecha, String hora_inicial, String hora_final) throws Exception {
		// TODO Auto-generated method stub
		// NO ES CORRECTO LA IMPLEMENTACION
		ArrayList<SalaBean> buffer_salas = new ArrayList<SalaBean>();
		String ret = "error";
		
		Connection conn = null;
	      
   	 	establishConnection();
        conn = getCon();
                
        String sql ="SELECT sala.id_sala, sala.nombre FROM consultas JOIN sala ";
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
        	SalaBean salaAux = new SalaBean();
        	salaAux.setId_sala(rs.getString(1));
        	salaAux.setNombre_sala(rs.getString(2));
           
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
	

	@Override
	public void editar(ConsultaBean entidad) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ConsultaBean> consultar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
