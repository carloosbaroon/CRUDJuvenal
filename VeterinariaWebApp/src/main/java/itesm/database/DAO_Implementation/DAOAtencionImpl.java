package itesm.database.DAO_Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	public void editar(AtencionBean atencion) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
	      
   	 	establishConnection();
        conn = getCon();
                
        String sql ="UPDATE atenciones SET hora_salida = ?, detalle = ?, monto = ?, factura = ? WHERE id_atencion = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, atencion.getHora_salida());
        ps.setString(2, atencion.getDetalle());
        ps.setString(3, atencion.getMonto());
        ps.setString(4, atencion.getFactura());
        ps.setString(5, atencion.getId_atencion());
		
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

	@Override
	public ArrayList<AtencionBean> consultarAtencionesToday(String datesyst) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<AtencionBean> buffer_atenciones_today = new ArrayList<AtencionBean>();
		Connection conn = null;
		
		establishConnection();
		conn = getCon();
		
		String sql ="SELECT * FROM atenciones WHERE";
        sql+=" fecha = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, datesyst);
        ResultSet rs = ps.executeQuery();
        
        AtencionBean atencion = null;
        
        while(rs.next()) {
        	atencion = new AtencionBean();
        	atencion.setId_atencion(rs.getString(1));
        	atencion.setId_consulta(rs.getString(2));
        	atencion.setId_sala(rs.getString(3));
        	atencion.setId_paciente(rs.getString(4));
        	atencion.setHora_entrada(rs.getString(6));
        	
        	buffer_atenciones_today.add(atencion);
        }
        
        if (conn != null) {
            try {
               closeConnection();
            } catch (Exception e) {
 				e.printStackTrace();
            }
        }
		return buffer_atenciones_today;
	}

}
