package pw.Business.Espectaculos;

public class CriticasDTO {
    protected String titulo, resena, id_usuario;
    protected float valoraciones, puntuacion;
    protected int id_sesion;

	public CriticasDTO(int id_ses) {
		this.id_sesion = id_ses;
	}
	
	public String getTitulo() {return this.titulo;}
	public float getPuntuaciones() {return this.puntuacion;}
	public String getResena() {return this.resena;}
	public float getValoraciones() {return this.valoraciones;}
	public int getIdSesion() {return this.id_sesion;}
	
	public void setTitulo (String tit) {
		this.titulo = tit;
	}
	
	public void setPuntuaciones (float punt) {
		this.puntuacion = punt;
	}

    public void setResena (String resen) {
		this.resena = resen;
	}
	
	public void setValoraciones (float valor) {
		this.valoraciones = valor;
	}
	
	public void setIdEspectaculo (int idSes) {
		this.id_sesion = idSes;
	}
	
	public String toString() {
		String userInfo = "Titulo: " + this.titulo + "\nResena: " + this.resena + "\nPuntuacion: " + this.puntuacion + "\nValoraciones: " + this.valoraciones;
		return userInfo;
	}
}
