package itesm.database.DAO_Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import itesm.business.CancelacionBean;
import itesm.database.Conexion;
import itesm.database.DAO_Interfaces.DAOCancelacion;

public class DAOCancelacionImpl extends Conexion implements DAOCancelacion{

	@Override
	public void insertar(CancelacionBean cancelacion) throws Exception {
		Connection conn = null;
	      
   	 	establishConnection();
        conn = getCon();
        String sql = "INSERT INTO cancelaciones (id_consulta, fecha, motivo)";
        sql+="VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, cancelacion.getId_consulta());
        ps.setString(2, cancelacion.getFecha());
        ps.setString(3, cancelacion.getMotivo());
        
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
	public CancelacionBean buscar(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(CancelacionBean entidad) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<CancelacionBean> consultar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
