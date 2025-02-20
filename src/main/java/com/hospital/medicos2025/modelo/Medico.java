package com.hospital.medicos2025.modelo;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "TBL_MEDICOT3")
public class Medico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedicoT3;
    
    @Column(length = 20, nullable = false)
    private String nombreT3;
    
    @Column(length = 80, nullable = false)
    private String apellidoT3;
    
    @Column(length = 30, nullable = false, unique = true)
    private String emailT3;
    
    @Column(length = 8, nullable = false, unique = true)
    private String dniT3;
    
    @Column(length = 20, nullable = false)
    private String estadoCivilT3;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @CreationTimestamp // Se llenará automáticamente con la fecha actual si es nula
    private Date fechaNacimt3;



    public Medico() {}

    public Medico(int idMedicoT3, String nombreT3, String apellidoT3, String emailT3, String dniT3,
                  String estadoCivilT3, Date fechaNacimT3) {
        this.idMedicoT3 = idMedicoT3;
        this.nombreT3 = nombreT3;
        this.apellidoT3 = apellidoT3;
        this.emailT3 = emailT3;
        this.dniT3 = dniT3;
        this.estadoCivilT3 = estadoCivilT3;
        this.fechaNacimt3 = fechaNacimT3;
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

    public Date getFechaNacimT3() { return fechaNacimt3; }
    public void setFechaNacimT3(Date fechaNacimT3) { this.fechaNacimt3 = fechaNacimT3; }
}