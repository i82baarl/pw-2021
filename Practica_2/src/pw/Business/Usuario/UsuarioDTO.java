package pw.Business.Usuario;

public class UsuarioDTO {
	protected String nombre, apellidos, correo, password, nick;
	
	public UsuarioDTO(){}

	public UsuarioDTO(String mail, String nom, String ape, String pass, String nck) {
		this.correo = mail;
		this.nombre = nom;
		this.apellidos = ape;
		this.password = pass;
		this.nick = nck;
	}
	
	public String getNombre() {return this.nombre;}
	public String getApellidos() {return this.apellidos;}
	public String getCorreo() {return this.correo;}
	public String getPassword() {return this.password;}
	public String getNick() {return this.nick;}
	
	public void setNombre (String name) {
		this.nombre = name;
	}
	
	public void setApellidos (String lastname) {
		this.apellidos = lastname;
	}
	
	public void setCorreo (String mail) {
		this.correo = mail;
	}
	
	public void setPassword (String pass) {
		this.password = pass;
	}
	
	public void setNick (String nck) {
		this.nick = nck;
	}
	
	public String toString() {
		String userInfo = "Nombre: " + this.nombre + this.apellidos + "\nNick: " + this.nick + "\nCorreo: " + this.correo + "\nContrasena: " + this.password;
		return userInfo;
	}
}
