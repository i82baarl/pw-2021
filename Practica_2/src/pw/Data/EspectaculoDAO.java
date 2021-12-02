package pw.Data;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

import pw.Business.*;

public class EspectaculoDAO {

    protected Connection connection = null;
	private MainProperties properties;

	public EspectaculoDAO (String path) {
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
     * Crear Espectaculo Puntual
     * @param espectaculo
     * @param fecha
     * @param hora
     * @return estado del query
     */

    public int crearEspectaculoPuntual(String espectaculo, String fecha, String hora){
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(properties.getSQL_CrearEspectaculoPuntal());
            status = ps.executeUpdate();

            ps.setString(2, espectaculo);
            ps.setString(3, fecha);
            ps.setString(4, hora);

            closeConnection();
            if(ps!=null)
                ps.close();
            if(con!=null)
                con.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return status;
    }

    /**
     * Crear Espectaculo de Temporada
     * @param espectaculo
     * @param finicial
     * @param ffinal
     * @param dia
     * @param hora
     * @param fecha
     * @return estado del query
     */

    public int crearEspectaculoTemporada(String espectaculo, String finicial, String ffinal, String dia, String hora, String fecha) {
        int status = 0;
        try{
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(properties.getSQL_CrearEspectaculoTemporada());
            status = ps.executeUpdate();

            ps.setString(2, espectaculo);
            ps.setString(6, finicial);
            ps.setString(7, ffinal);
            ps.setString(5, dia);
            ps.setString(4, hora);
            ps.setString(3, fecha);

            closeConnection();
            if(ps!=null)
                ps.close();
            if(con!=null)
                ps.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return status;
    }

    /**
     * Crear Espectaculo Multiple
     * @param fecha
     * @param hora
     * @param espectaculo
     * @return estado del query
     */

    public int crearEspectaculoMultiple(String fecha, String hora, String espectaculo) {
        int status = 0;
        try{
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(properties.getSQL_CrearEspectaculoMultiple());
            status = ps.executeUpdate();

            ps.setString(3, fecha);
            ps.setString(4, hora);
            ps.setString(2, espectaculo);

            closeConnection();
            if(ps!=null)
                ps.close();
            if(con!=null)
                ps.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return status;
    }

    /**
     * Esta función compara dos fechas 
     * @param fecha_hoy
     * @param fecha
     * @return true si fecha es menor que fecha hoy
     * @throws ParseException
     */
    private Boolean compara_fechas(String fecha_hoy,String fecha) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
        Date date1 = dateFormat.parse(fecha_hoy);
        Date date2 = dateFormat.parse(fecha);
        if(!date1.after(date2))
        return true;
        else
        return false;
    }
}