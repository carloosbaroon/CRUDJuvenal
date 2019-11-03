package itesm.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import itesm.business.EmpleadoBean;

public class DAOEmpleadoImpl extends Conexion implements DAOEmpleado{

	@Override
	public String insertarEmpleado(EmpleadoBean empleado) throws Exception {
		Connection conn = null;
	      
   	 	establishConnection();
        conn = getCon();
        String sql = "INSERT INTO empleado (id_empleado, nombre_completo, direccion, telefono, puesto, especialidad, turno, estado)";
        sql+="VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, empleado.getId_empleado());
        ps.setString(2, empleado.getNombre_completo());
        ps.setString(3, empleado.getDireccion());
        ps.setString(4, empleado.getTelefono());
        ps.setString(5, empleado.getPuesto());
        ps.setString(6, empleado.getEspecialidad());
        ps.setString(7, empleado.getTurno());
        ps.setString(8, empleado.getEstado());
        
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
	public ArrayList<EmpleadoBean> consultarEmpleados() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
