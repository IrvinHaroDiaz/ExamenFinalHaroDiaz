package com.bd.medico2025.modelo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "MEDICO")
public class Medico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedicoT3;
    
    private String nombreT3;
    
    private String apellidoT3;
    
    private String emailT3;
    
    private String dniT3;
    
    private String estadoCivilT3;
    
    @Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
    @Column(nullable = false)
    private Date fechaNacimT3;



    public Medico() {}
    

    public Medico(int idMedicoT3, String nombreT3, String apellidoT3, String emailT3, String dniT3,
                  String estadoCivilT3, Date fechaNacimT3) {
        this.idMedicoT3 = idMedicoT3;
        this.nombreT3 = nombreT3;
        this.apellidoT3 = apellidoT3;
        this.emailT3 = emailT3;
        this.dniT3 = dniT3;
        this.estadoCivilT3 = estadoCivilT3;
        this.fechaNacimT3 = fechaNacimT3;
    }

    // Getters y Setters
    public int getIdMedicoT3() { return idMedicoT3; }
    public void setIdMedicoT3(int idMedicoT3) { this.idMedicoT3 = idMedicoT3; }

    public String getNombreT3() { return nombreT3; }
    public void setNombreT3(String nombreT3) { this.nombreT3 = nombreT3; }

    public String getApellidoT3() { return apellidoT3; }
    public void setApellidoT3(String apellidoT3) { this.apellidoT3 = apellidoT3; }

    public String getEmailT3() { return emailT3; }
    public void setEmailT3(String emailT3) { this.emailT3 = emailT3; }

    public String getDniT3() { return dniT3; }
    public void setDniT3(String dniT3) { this.dniT3 = dniT3; }

    public String getEstadoCivilT3() { return estadoCivilT3; }
    public void setEstadoCivilT3(String estadoCivilT3) { this.estadoCivilT3 = estadoCivilT3; }

    public Date getFechaNacimT3() { return fechaNacimT3; }
    public void setFechaNacimT3(Date fechaNacimT3) { this.fechaNacimT3 = fechaNacimT3; }
}