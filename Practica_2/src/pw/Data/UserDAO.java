package pw.Data;

import java.sql.*;

import pw.Business.*;

public class UserDAO {
	
	protected Connection connection = null;
	private MainProperties properties;

	public UserDAO (String path) {
		properties = new MainProperties(path);
	}

	/**
	 * Conexión a la Base de Datos
	 * @return conexion
	 */
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = (Connection) DriverManager.getConnection("jdbc:mysql:" + properties.getServidor(), properties.getUsuario(), properties.getContrasena());
			System.out.println("Conexion a Database abierta con exito");
		} catch (SQLException e) {
			System.err.println("Conexion a MySQL ha fallado");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver no encontrado");
			e.printStackTrace();
		}
		return this.connection;
	}
	
	/**
	 * Cerrar Conexión con la Base de Datos
	 */
	public void closeConnection() {
		try {
			if(this.connection != null && !this.connection.isClosed()) {
				this.connection.close();
				System.out.println("Conexion a Datbase cerrada con exito");
			}
		} catch (SQLException e) {
			System.err.println("Error al intentar cerrar la conexion");
			e.printStackTrace();
		}
	}
	
	/**
	 * Meter usuario en Base de Datos
	 * @param email
	 * @param nombre
	 * @param apellidos
	 * @param contrasena
	 * @param nick
	 * @return estado del query
	*/

	public int createUser(String email, String nombre, String apellidos, String contrasena, String nick){
		int status = 0;
		try {
			Connection connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement(properties.getSQL_CrearUsuario());
			
			stmt.setString(1,nombre);
            stmt.setString(2,apellidos);
            stmt.setString(3,email);
            stmt.setString(4,nick);
            stmt.setString(5,contrasena);

			closeConnection();
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return status;
	}

	/**
	 * Comprobar existencia de usuario
	 * @param email
	 * @return true si existe el usuario
	 */

	 public Boolean existe(String email){
        Statement stmt = null;
        try {
            Connection con=getConnection();
            stmt = con.createStatement();
            ResultSet rs =  stmt.executeQuery(properties.getSQL_ComprobarUsuario()+"'"+email+"'");
            rs.next();
            rs.getString("email");
            
        if (stmt != null) 
            stmt.close();
        if(con!=null)
        	con.close();
        } catch (Exception e) { return false;}
        return true;
    }

	/**
	 * Eliminar usuario de la Base de Datos
     * @param email
     * @return estado de query
     */

	public int DarBaja(String email){
        int status=0;
    try{
        Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement(properties.getSQL_EliminarUsuario());
        ps.setString(1,email);
        status=ps.executeUpdate();
    }catch(Exception e){System.out.println(e);}
    return status;
    }

	/**
	 * Modificar usuario de la Base de Datos
	 * @param nombre
	 * @param apellidos
	 * @param correo_nuevo
	 * @param correo_antiguo
	 * @param nick
	 * @param contrasena
	 * @return estado del query
	 */

	public int MoficarDatos(String nombre,String apellidos,String correo_nuevo,String correo_antiguo,String nick,String contrasena){
		int status=0;
		try{
			Connection con=getConnection();
			if(!correo_nuevo.equals("")){
				PreparedStatement ps=con.prepareStatement(properties.getSQL_ModificarUsuario1() + "email" + properties.getSQL_ModificarUsuario2());
				ps.setString(1,correo_nuevo);
				ps.setString(2,correo_antiguo);
				status=ps.executeUpdate();
			}
			if(!nombre.equals("")){
				PreparedStatement ps=con.prepareStatement(properties.getSQL_ModificarUsuario1() + "nombre"+ properties.getSQL_ModificarUsuario2());
				ps.setString(1,nombre);
				ps.setString(2,correo_antiguo);
				status=ps.executeUpdate();
			}
			if(!apellidos.equals("")){
				PreparedStatement ps=con.prepareStatement(properties.getSQL_ModificarUsuario1() + "apellidos"+ properties.getSQL_ModificarUsuario2());
				ps.setString(1,apellidos);
				ps.setString(2,correo_antiguo);
				status=ps.executeUpdate();
			}
			if(!nick.equals("")){
				PreparedStatement ps=con.prepareStatement(properties.getSQL_ModificarUsuario1() + "nick"+ properties.getSQL_ModificarUsuario2());
				ps.setString(1,nick);
				ps.setString(2,correo_antiguo);
				status=ps.executeUpdate();
			}
			if(!contrasena.equals("")){
				PreparedStatement ps=con.prepareStatement(properties.getSQL_ModificarUsuario1() + "contrasena"+ properties.getSQL_ModificarUsuario2());
				ps.setString(1,contrasena);
				ps.setString(2,correo_antiguo);
				status=ps.executeUpdate();
			}

		}catch(Exception e){System.out.println(e);}
		return status;
	}

	/**
	 * Compruebar datos de login
	 * @param email
	 * @param contrasena
	 * @return true si el login es exitoso
	 */

	public Boolean login(String email,String contrasena){
        Statement stmt = null;
        try {
            Connection con=getConnection();
            stmt = con.createStatement();
            ResultSet rs =  stmt.executeQuery(properties.getSQL_Login()+"'"+email+"'");
            rs.next();
            rs.getString("email");
            String real=rs.getString("contrasena");
            
            if (stmt != null) 
            stmt.close();
            if(con!= null)
            con.close();	

            if(real.equals(contrasena))
            return true;
            else return false;
            
        } catch (Exception e) { return false;}
    }
}
