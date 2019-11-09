package itesm.database.DAO_Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		Connection conn = null;
	      
   	 	establishConnection();
        conn = getCon();
        String sql = "SELECT id_paciente, nombre, categoria, raza, edad FROM paciente WHERE";
        sql+=" id_paciente = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        
        PacienteBean paciente = null;
        
        while (rs.next()) {
       	 	paciente = new PacienteBean();
           paciente.setId(rs.getString(1));
           paciente.setName(rs.getString(2));
           paciente.setCategoria(rs.getString(3));
           paciente.setRaza(rs.getString(4));
           paciente.setEdad(Integer.parseInt(rs.getString(5)));
        }

        if (conn != null) {
           try {
              closeConnection();
           } catch (Exception e) {
				e.printStackTrace();
           }
        }
        
        return paciente;
	}

	@Override
	public void editar(PacienteBean paciente) throws Exception {
		Connection conn = null;
	      
   	 	establishConnection();
        conn = getCon();
        String sql = "UPDATE paciente SET nombre = ?, categoria = ?, raza = ?, edad = ? WHERE id_paciente = ?";
                
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, paciente.getName());
        ps.setString(2, paciente.getCategoria());
        ps.setString(3, paciente.getRaza());
        ps.setString(4, Integer.toString(paciente.getEdad()));
        ps.setString(5, paciente.getId());
        
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
	public ArrayList<PacienteBean> consultar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PacienteBean> consultarPacientesDelPropietario(String fk_propietario) throws Exception {
		ArrayList<PacienteBean> buffer_pacientes = new ArrayList<PacienteBean>();
		String sql = "";
		
	      Connection conn = null;
	      
	    	 establishConnection();
	         conn = getCon();
	        
        	 sql = "SELECT * FROM paciente WHERE";
        	 sql+=" id_propietario = ?";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         System.out.println("FK propietario: " + fk_propietario);
	         ps.setString(1, fk_propietario);
	         ResultSet rs = ps.executeQuery();

	         while (rs.next()) {
	        	PacienteBean paciente = new PacienteBean();
	        	paciente.setId(rs.getString(1));
	        	paciente.setIdOwner(rs.getString(2));
	        	paciente.setName(rs.getString(3));	            
	        	paciente.setCategoria(rs.getString(4));
	        	paciente.setRaza(rs.getString(5));
	        	paciente.setEdad(Integer.parseInt(rs.getString(6)));      
	            
	            buffer_pacientes.add(paciente);
	         }

	         if (conn != null) {
	            try {
	               closeConnection();
	            } catch (Exception e) {
					e.printStackTrace();
	            }
	         }
	      
	      return buffer_pacientes;
	}

	@Override
	public void eliminarPaciente(PacienteBean paciente) throws Exception {
		Connection conn = null;
	      
   	 	establishConnection();
        conn = getCon();
        String sql = "DELETE from paciente WHERE id_paciente = ?";
                
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, paciente.getId());
        
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
