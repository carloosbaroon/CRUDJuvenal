package itesm.database.DAO_Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import itesm.business.AtencionBean;
import itesm.database.Conexion;
import itesm.database.DAO_Interfaces.DAOAtencion;

public class DAOAtencionImpl extends Conexion implements DAOAtencion {

	@Override
	public void insertar(AtencionBean atencion) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		establishConnection();
		conn = getCon();
		
		if(atencion.getId_consulta() == "")
		{
			String sql = "INSERT INTO atenciones (id_sala, id_paciente, fecha, hora_entrada)";
			sql+="VALUES ( ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, atencion.getId_sala());
			ps.setString(2, atencion.getId_paciente());
			ps.setString(3, atencion.getFecha());
			ps.setString(4, atencion.getHora_entrada());
			
			ps.execute();

		}
		else
		{
			String sql = "INSERT INTO atenciones (id_consulta, id_sala, id_paciente, fecha, hora_entrada)";
			sql+="VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, atencion.getId_consulta());
			ps.setString(2, atencion.getId_sala());
			ps.setString(3, atencion.getId_paciente());
			ps.setString(4, atencion.getFecha());
			ps.setString(5, atencion.getHora_entrada());
			
			ps.execute();

		}	
		
		
		if (conn != null) {
           try {
              closeConnection();
           } catch (Exception e) {
				e.printStackTrace();
           }
        }
		
	}

	@Override
	public AtencionBean buscar(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(AtencionBean entidad) throws Exception {
		Connection conn = null;
	      
   	 	establishConnection();
        conn = getCon();
        String sql = "UPDATE atenciones SET hora_salida = ? WHERE fecha = ? AND id_paciente = ? AND id_sala = ? AND id_consulta = ?";
                
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, entidad.getHora_salida());
        ps.setString(2, entidad.getFecha());
        ps.setString(3, entidad.getId_paciente());
        ps.setString(4, entidad.getId_sala());
        ps.setString(5, entidad.getId_consulta());
        
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
	public ArrayList<AtencionBean> consultar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
