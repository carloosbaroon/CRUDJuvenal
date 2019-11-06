package itesm.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

import itesm.business.PacienteBean;

public class DAOPacienteImpl extends Conexion implements DAOPaciente{

	@Override
	public void insertarPaciente(PacienteBean paciente) throws Exception {
		Connection conn = null;
	      
   	 	establishConnection();
        conn = getCon();
        String sql = "INSERT INTO paciente (id_paciente, id_propietario, nombre, categoria, raza, edad)";
        sql+="VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        System.out.println("id_paciente: " + paciente.getId());
        System.out.println("id_propietario: " + paciente.getIdOwner());
        
        ps.setString(1, paciente.getId());
        ps.setString(2, paciente.getIdOwner());
        ps.setString(3, paciente.getName());
        ps.setString(4, paciente.getCategoria());
        ps.setString(5, paciente.getRaza());
        ps.setString(6, Integer.toString(paciente.getEdad()));
        
        ps.execute();

        if (conn != null) {
           try {
              closeConnection();
           } catch (Exception e) {
				e.printStackTrace();
           }
        }
		
	}

}
