package com.accesodatos;

import java.util.Date;

public class Reserva {
    private String usuario;
    private String instalacion;
    private String horario;
    private Date fecha;

    public String getUsuario() { 
        return usuario; 
    }
    public void setUsuario(String usuario) { 
        this.usuario = usuario; 
    }

    public String getInstalacion() { 
        return instalacion; 
    }
    public void setInstalacion(String instalacion) { 
        this.instalacion = instalacion; 
    }

    public String getHorario() { 
        return horario; 
    }
    public void setHorario(String horario) { 
        this.horario = horario; 
    }

    public Date getFecha() { 
        return fecha; 
    }
    public void setFecha(Date fecha) { 
        this.fecha = fecha; 
    }
}