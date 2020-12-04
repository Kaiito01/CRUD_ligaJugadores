/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joseugal.lligaFutbol;



import com.joseugal.lligaFutbol.modelo.GestorBD;
import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MainApp extends Application {
    Connection conn = null;

    @Override
    public void start ( Stage stage ) throws Exception {
        GestorEscenas.inicializar ( stage );
    }

    /**
     * @param args the command line arguments
     */
    public static void main ( String[] args ) {
        launch ( args );
    }

    public static void reseteaBD(Connection conn){
        // Eliminamos las tablas
        GestorBD.eliminaTablas ( conn );
        // Cargamos Tabla Equipos
        GestorBD.creaEquipos ( conn );
        // Cargamos Tabla Jugadores
        GestorBD.creaJugadores ( conn );
        // Insertamos Datos Equipos
        GestorBD.cargaEquipos ( conn );
        // Insertamos Datos Jugadores
        GestorBD.cargaJugadores ( conn );
    }

}