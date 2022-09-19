package com.bubble_dog.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")
public class ClienteModel {
    
    @Id
    private Long cedula;

    @Column(name="Nombre")
    private String  nombre;
    @Column(name="Apellido")
    private String apellido;
    @Column(name="email")
    private String email;
    @Column(name="Nombre_Mascota")
    private String nombreMascota;
    @Column(name="Raza")
    private String raza;
    @Column(name="Vacunado")
    private String vacunado;

    
    public ClienteModel() {
    }

    public ClienteModel(Long cedula, String nombre, String apellido, String email, String nombreMascota, String raza,
            String vacunado ) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nombreMascota = nombreMascota;
        this.raza = raza;
        this.vacunado = vacunado;
        
    }

    @Override
    public String toString() {
        return "ClienteModel [apellido=" + apellido + ", cedula=" + cedula + ", email=" + email  +  ", nombre=" + nombre + ", nombreMascota="
                + nombreMascota + ", raza=" + raza + ", vacunado=" + vacunado + "]";
    }

    public Long getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public String getRaza() {
        return raza;
    }

    public String getVacunado() {
        return vacunado;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setVacunado(String vacunado) {
        this.vacunado = vacunado;
    }
    
}
