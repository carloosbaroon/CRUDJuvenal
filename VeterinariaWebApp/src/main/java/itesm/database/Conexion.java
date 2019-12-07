package itesm.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class Conexion {
	
	private int noCon;
	private String estatus = null;
	private Connection con = null;
	private String connectionUrl = "jdbc:mysql://localhost/veterinaria?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String username = "root";
	private String password = "";
	
	public int getNoCon() {
		return noCon;
	}
	public void setNoCon(int noCon) {
		this.noCon = noCon;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public Connection getCon(boolean autoCommit) {
		setAutoCommit(autoCommit);
		return con;
	}
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}

	/*public void establishConnection(){
		
		if(con == null)
		{
	  		try {
	  			// Establish the connection.
	  			Class.forName ("com.mysql.cj.jdbc.Driver");
	      		con = DriverManager.getConnection(connectionUrl,username,password);
	      		
	  		} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}*/
	
	public void establishConnection(){
		
		try {
			InitialContext initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
		    DataSource ds = (DataSource) initContext.lookup("jdbc/ConexionMySQL");
		    con = ds.getConnection();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setAutoCommit(boolean type){
		try {
			con.setAutoCommit(type);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void commit()
	{
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	public void closeConnection()
	{
		
		if (con != null) 
		{
			try { 
				con.close(); 
				con = null;
			} 
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
