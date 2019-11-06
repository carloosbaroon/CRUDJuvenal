package itesm.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import itesm.database.Conexion;
import itesm.business.EmpleadoBean;
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
        String sql = "INSERT INTO usuario (id_usuario, id_empleado,password_user, confirmar_password, privilegios, estado, no_intentos)";
        sql+="VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        //If column 'empleado_id_fk' is not null, set the value 1 to the col 'elegido'
        if(usuario.getId_empleado_FK() != null) {
        	System.out.println("No esta vacio el campo 'empleado_id_fk'");
        	String sqlUpdate = "UPDATE empleado SET elegido = 1 WHERE id_empleado = ?";
        	PreparedStatement ps = conn.prepareStatement(sqlUpdate);
        	ps.setString(1, usuario.getId_empleado_FK());
        	ps.execute();
        }
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, usuario.getUsuarioID());
        ps.setString(2, usuario.getId_empleado_FK());
        ps.setString(3, usuario.getPassword());
        ps.setString(4, usuario.getConfirmar_password());
        ps.setString(5, usuario.getPrivilegios());
        ps.setString(6, usuario.getEstado());
        ps.setString(7, usuario.getIntentos());
        
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

	@Override
	public void eliminarUsuario(UsuarioBean usuario) throws Exception {
		Connection conn = null;
	      
   	 	establishConnection();
        conn = getCon();
        String sql = "DELETE from usuario WHERE id_usuario = ?";
                
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, usuario.getUsuarioID());
        
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
	public UsuarioBean buscarUsuario(UsuarioBean usuario) throws Exception {
	      Connection conn = null;
	      
	    	 establishConnection();
	         conn = getCon();
	         String sql = "SELECT * FROM usuario WHERE";
	         sql+=" id_usuario = ?";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ps.setString(1, usuario.getUsuarioID());
	         ResultSet rs = ps.executeQuery();

	         while (rs.next()) {
	            usuario.setUsuarioID(rs.getString(1));
	            usuario.setId_empleado_FK(rs.getString(2));
	            usuario.setPassword(rs.getString(3));
	            usuario.setConfirmar_password(rs.getString(4));
	            usuario.setPrivilegios(rs.getString(5));
	            usuario.setEstado(rs.getString(6));
	            usuario.setIntentos(rs.getString(7));
	         }

	         if (conn != null) {
	            try {
	               closeConnection();
	            } catch (Exception e) {
					e.printStackTrace();
	            }
	         }
	         
	         return usuario;
	}

	@Override
	public void editarUsuario(UsuarioBean usuario) throws Exception {
		Connection conn = null;
	      
   	 	establishConnection();
        conn = getCon();
        String sql = "UPDATE usuario SET password_user = ?, confirmar_password = ? WHERE id_usuario = ?";
                
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, usuario.getPassword());
        ps.setString(2, usuario.getConfirmar_password());
        ps.setString(3, usuario.getUsuarioID());
        
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
	public void actualizarEstado(UsuarioBean usuario) throws Exception {
		Connection conn = null;
	      
   	 	establishConnection();
        conn = getCon();
        System.out.println("Usuario: " + usuario.getUsuarioID());
        System.out.println("Estado: " + usuario.getEstado());
        
        String sql = "UPDATE usuario SET estado = ? WHERE id_usuario = ?";
                
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, usuario.getEstado());
        ps.setString(2, usuario.getUsuarioID());
        
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