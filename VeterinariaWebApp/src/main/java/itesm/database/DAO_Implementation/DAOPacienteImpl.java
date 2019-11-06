package itesm.database.DAO_Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import itesm.business.PacienteBean;
import itesm.database.Conexion;
import itesm.database.DAO_Interfaces.DAOPaciente;

public class DAOPacienteImpl extends Conexion implements DAOPaciente{

	@Override
	public void insertar(PacienteBean paciente) throws Exception {
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

	@Override
	public PacienteBean buscar(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(PacienteBean entidad) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<PacienteBean> consultar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
