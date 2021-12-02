package pw.Business;

import java.util.Properties;
import java.io.*;

public class MainProperties {

    private String servidor, usuario, contrasena, sql_CrearUsuario, sql_ComprobarUsuario, sql_EliminarUsuario,
    sql_ModificarUsuario1, sql_ModificarUsuario2, sql_Login, sql_CrearEspectaculoPuntual,
    sql_CrearEspectaculoTemporada, sql_CrearEspectaculoMultiple;

    public MainProperties(String path) {
        //config.properties
        Properties prop = new Properties();
	    String filename = path + "config.properties";
	    try {
	    	BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
	    	prop.load(reader);
        
	    	servidor = prop.getProperty("servidor");
	    	usuario = prop.getProperty("usuario");
	    	contrasena = prop.getProperty("contrasena");
        
	    	reader.close();
        
	    } catch (FileNotFoundException e) {
	    	e.printStackTrace();
	    } catch (IOException e) {
            e.printStackTrace();
	    }

        // sql.properties

        filename = path + "sql.properties";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
			prop.load(reader);

            sql_CrearUsuario = prop.getProperty("sql_CrearUsuario");
            sql_ComprobarUsuario = prop.getProperty("sql_ComprobarUsuario");
            sql_EliminarUsuario = prop.getProperty("sql_EliminarUsuario");
            sql_ModificarUsuario1 = prop.getProperty("sql_ModificarUsuario1");
            sql_ModificarUsuario2 = prop.getProperty("sql_ModificarUsuario2");
            sql_Login = prop.getProperty("sql_Login");
            
            sql_CrearEspectaculoPuntual = prop.getProperty("sql_CrearEspectaculoPuntual");
            sql_CrearEspectaculoTemporada = prop.getProperty("sql_CrearEspectaculoTemporada");
            sql_CrearEspectaculoMultiple = prop.getProperty("sql_CrearEspectaculoMultiple");

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // GETTERS USUARIO

    public String getServidor(){return servidor;}
	public String getUsuario(){return usuario;}
	public String getContrasena(){return contrasena;}
    public String getSQL_CrearUsuario(){return sql_CrearUsuario;}
    public String getSQL_ComprobarUsuario(){return sql_ComprobarUsuario;}
    public String getSQL_EliminarUsuario(){return sql_EliminarUsuario;}
    public String getSQL_ModificarUsuario1(){return sql_ModificarUsuario1;}
    public String getSQL_ModificarUsuario2(){return sql_ModificarUsuario2;}
    public String getSQL_Login(){return sql_Login;}
    
    // GETTERS ESPECTACULO

    public String getSQL_CrearEspectaculoPuntal(){return sql_CrearEspectaculoPuntual;}
    public String getSQL_CrearEspectaculoTemporada(){return sql_CrearEspectaculoTemporada;}
    public String getSQL_CrearEspectaculoMultiple(){return sql_CrearEspectaculoMultiple;}

}
