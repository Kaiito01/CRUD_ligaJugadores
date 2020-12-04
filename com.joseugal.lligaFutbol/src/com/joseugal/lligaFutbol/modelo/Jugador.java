package com.joseugal.lligaFutbol.modelo;

public class Jugador {
    private int id = 0;
    private int id_equipo= 0;
    private String nombre;
    private int dorsal= 0;
    private int edad= 0;

    public Jugador(int id, int id_equipo, String nombre, int dorsal, int edad){
    this.id = id;
    this.id_equipo = id_equipo;
    this.nombre = nombre;
    this.dorsal = dorsal;
    this.edad = edad;
    }

    public int getId () {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public int getId_equipo () {
        return id_equipo;
    }

    public void setId_equipo ( int id_equipo ) {
        this.id_equipo = id_equipo;
    }

    public String getNombre () {
        return nombre;
    }

    public void setNombre ( String nombre ) {
        this.nombre = nombre;
    }

    public int getDorsal () {
        return dorsal;
    }

    public void setDorsal ( int dorsal ) {
        this.dorsal = dorsal;
    }

    public int getEdad () {
        return edad;
    }

    public void setEdad ( int edad ) {
        this.edad = edad;
    }

}
