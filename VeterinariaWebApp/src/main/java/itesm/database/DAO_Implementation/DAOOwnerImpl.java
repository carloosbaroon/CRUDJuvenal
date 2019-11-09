package itesm.database.DAO_Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import itesm.business.OwnerBean;
import itesm.database.Conexion;
import itesm.database.DAO_Interfaces.DAOOwner;

public class DAOOwnerImpl extends Conexion implements DAOOwner{

	@Override
	public void insertar(OwnerBean owner) throws Exception {
		Connection conn = null;
	      
   	 	establishConnection();
        conn = getCon();
        String sql = "INSERT INTO propietario (id_propietario, nombre, direccion, telefono, rfc)";
        sql+="VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, owner.getId());
        ps.setString(2, owner.getNombre());
        ps.setString(3, owner.getDireccion());
        ps.setString(4, Integer.toString(owner.getTelefono()));
        ps.setString(5, owner.getRfc());
        
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
	public OwnerBean buscar(String id) throws Exception {
		Connection conn = null;
	      
   	 	establishConnection();
        conn = getCon();
        String sql = "SELECT * FROM propietario WHERE";
        sql+=" id_propietario = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        
        OwnerBean owner = null;
        
        while (rs.next()) {
        	owner = new OwnerBean();
           owner.setId(rs.getString(1));
           owner.setNombre(rs.getString(2));
           owner.setDireccion(rs.getString(3));
           owner.setTelefono(Integer.parseInt(rs.getString(4)));
           owner.setRfc(rs.getString(5));
        }

        if (conn != null) {
           try {
              closeConnection();
           } catch (Exception e) {
				e.printStackTrace();
           }
        }
        
        return owner;
	}

	@Override
	public void editar(OwnerBean entidad) throws Exception {
		Connection conn = null;
	      
   	 	establishConnection();
        conn = getCon();
        String sql = "UPDATE propietario SET nombre = ?, direccion = ?, telefono = ?, rfc = ? WHERE id_propietario = ?";
                
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, entidad.getNombre());
        ps.setString(2, entidad.getDireccion());
        ps.setString(3, Integer.toString(entidad.getTelefono()));
        ps.setString(4, entidad.getRfc());
        ps.setString(5, entidad.getId());
        
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
	public ArrayList<OwnerBean> consultar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
