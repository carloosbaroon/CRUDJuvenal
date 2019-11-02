package itesm.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}