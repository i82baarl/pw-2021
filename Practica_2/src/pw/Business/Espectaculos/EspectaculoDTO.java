package pw.Business.Espectaculos;

import java.util.Date;

public class EspectaculoDTO {
    protected String titulo, descripcion, categoria;
    protected int id_espectaculo, id_sesion, programacion, dia;
    protected Date fecha, hora, fInicial, fFinal;

	public EspectaculoDTO(int idEspec, int idSes) {
		this.id_espectaculo = idEspec;
        this.id_sesion = idSes;
	}
	
	public String getTitulo() {return this.titulo;}
	public String getDescripcion() {return this.descripcion;}
	public String getCategoria() {return this.categoria;}
	public int getIdEspectaculo() {return this.id_espectaculo;}
	public int getIdSesion() {return this.id_sesion;}
	public int getProgramacion() {return this.programacion;}
    public Date getFecha() {return this.fecha;}
    public Date getHora() {return this.hora;}
    public Date getfInicial() {return this.fInicial;}
    public Date getfFinal() {return this.fFinal;}

	public void setTitulo (String tit) {
		this.titulo = tit;
	}
	
	public void setDescripcion (String desc) {
		this.descripcion = desc;
	}

    public void setCategoria (String cate) {
		this.categoria = cate;
	}
	
    public void setIdEspectaculo (int idEsp) {
		this.id_espectaculo = idEsp;
	}

	public void setIdSesion (int idSes) {
		this.id_sesion = idSes;
	}

	public void setProgramacion (int prog) {
        this.programacion = prog;
    }

    public void setFecha (Date fech) {
        this.fecha = fech;
    }

    public void setHora (Date hor) {
        this.hora = hor;
    }

    public void setfInicial (Date fIni) {
        this.fInicial = fIni;
    }

    public void setfFinal (Date fFin) {
        this.fFinal = fFin;
    }
}
