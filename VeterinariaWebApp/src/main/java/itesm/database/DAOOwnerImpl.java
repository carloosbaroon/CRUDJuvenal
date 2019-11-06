package itesm.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import itesm.business.OwnerBean;

public class DAOOwnerImpl extends Conexion implements DAOOwner{

	@Override
	public String insertarOwner(OwnerBean owner) throws Exception {
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
     
		return "success";
	}

	@Override
	public OwnerBean buscarOwner(String id) throws Exception {
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

}
