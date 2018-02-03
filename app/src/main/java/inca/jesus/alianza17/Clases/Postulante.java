package inca.jesus.alianza17.Clases;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesus on 22/06/2017.
 */

public class Postulante {

      public int id;
      public String num_incripcion;
      public String apellidos;
      public String nombres;
      public String f_nacimiento;
      public int edad;
      public String categoria,domicilio;
      public int telefono;
      public String email;
      public String Posicion;
      public String foto;

    public Postulante(int id, String num_incripcion, String apellidos, String nombres, String f_nacimiento, int edad, String categoria, String domicilio, int telefono, String email,String foto, String posicion) {
        this.id = id;
        this.num_incripcion = num_incripcion;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.f_nacimiento = f_nacimiento;
        this.edad = edad;
        this.categoria = categoria;
        this.domicilio = domicilio;

        this.telefono = telefono;
        this.email = email;
        this.foto=foto;
        Posicion = posicion;
    }


    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum_incripcion() {
        return num_incripcion;
    }

    public void setNum_incripcion(String num_incripcion) {
        this.num_incripcion = num_incripcion;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getF_nacimiento() {
        return f_nacimiento;
    }

    public void setF_nacimiento(String f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }


    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosicion() {
        return Posicion;
    }

    public void setPosicion(String posicion) {
        Posicion = posicion;
    }
}
