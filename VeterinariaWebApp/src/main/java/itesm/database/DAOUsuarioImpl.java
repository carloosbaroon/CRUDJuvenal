package itesm.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import itesm.database.Conexion;
import itesm.business.UsuarioBean;


public class DAOUsuarioImpl extends Conexion implements DAOUsuario{
	/** 
	 * Consultar si existe el usuario.
	 * @return SUCCESS=Todo salio bien, ERROR=Si hubo un problema
	 */

	@Override
	public String insertarUsuario(UsuarioBean usuario) throws Exception {
		Connection conn = null;
	      
   	 	establishConnection();
        conn = getCon();
        String sql = "INSERT INTO usuario (id_usuario, password_user, confirmar_password, privilegios, estado, no_intentos)";
        sql+="VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, usuario.getUsuarioID());
        ps.setString(2, usuario.getPassword());
        ps.setString(3, usuario.getConfirmar_password());
        ps.setString(4, usuario.getPrivilegios());
        ps.setString(5, usuario.getEstado());
        ps.setString(6, usuario.getIntentos());
        
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
	public String verificarUsuario(UsuarioBean usuario) throws Exception {	
		String ret = "error";
	      Connection conn = null;
	      
	    	 establishConnection();
	         conn = getCon();
	         String sql = "SELECT id_usuario, privilegios FROM usuario WHERE";
	         sql+=" id_usuario = ? AND password_user = ?";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ps.setString(1, usuario.getUsuarioID());
	         ps.setString(2, usuario.getPassword());
	         ResultSet rs = ps.executeQuery();

	         while (rs.next()) {
	            usuario.setUsuarioID((rs.getString(1)));
	            usuario.setPrivilegios(rs.getString(2));
	            if(usuario.getPrivilegios().equals("Administrador"))
	            	return "admin";
            	else
            		return "user";
	         }

	         if (conn != null) {
	            try {
	               closeConnection();
	            } catch (Exception e) {
					e.printStackTrace();
	            }
	         }
	      
	      return ret;
	}

	@Override
	public ArrayList<UsuarioBean> consultarUsuarios() throws Exception {
		String ret = "error";
		ArrayList<UsuarioBean> buffer_usuarios = new ArrayList<UsuarioBean>();
		
	      Connection conn = null;
	      
	    	 establishConnection();
	         conn = getCon();
	         String sql = "SELECT id_usuario, password_user, id_empleado, privilegios, estado FROM usuario";
	         Statement statement = conn.createStatement();
	         ResultSet rs = statement.executeQuery(sql);

	         while (rs.next()) {
	        	UsuarioBean usuarioAux = new UsuarioBean();
	        	usuarioAux.setUsuarioID((rs.getString(1)));
	        	usuarioAux.setPassword(rs.getString(2));
	        	usuarioAux.setId_empleado_FK(rs.getString(3));	            
	        	usuarioAux.setPrivilegios(rs.getString(4));
	        	usuarioAux.setEstado(rs.getString(5));
	            
	            buffer_usuarios.add(usuarioAux);
	         }

	         if (conn != null) {
	            try {
	               closeConnection();
	            } catch (Exception e) {
					e.printStackTrace();
	            }
	         }
	      
	      return buffer_usuarios;
	}
}