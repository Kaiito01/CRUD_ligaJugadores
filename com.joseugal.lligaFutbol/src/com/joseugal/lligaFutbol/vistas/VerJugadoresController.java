
package com.joseugal.lligaFutbol.vistas;



import com.joseugal.lligaFutbol.MiControlador;
import com.joseugal.lligaFutbol.modelo.Jugador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.joseugal.lligaFutbol.modelo.GestorBD;
import javafx.scene.control.TableView;


public class VerJugadoresController implements Initializable, MiControlador {
    private final Connection conn = GestorBD.getConnection();

    // Colecciones
    private ObservableList<Jugador> listaJugadores;

    @FXML
    private TableView<Jugador> tbvJugadores;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaJugadores = FXCollections.observableArrayList ();
        verJugadores ( conn , listaJugadores );
        tbvJugadores.setItems ( listaJugadores );

    }

    public void verJugadores(Connection conn, ObservableList<Jugador> listaJugadores){

        try{

            String query = "SELECT * FROM jugadores ";
            PreparedStatement statement = conn.prepareStatement ( query );
            ResultSet resultat = statement.executeQuery ();
            while ( resultat.next () ){
                listaJugadores.add (
                        new Jugador ( resultat.getInt ( "id" ), resultat.getInt ( "id_equipo" ), resultat.getString ( "nombre" ), resultat.getInt ( "dorsal" ),resultat.getInt ( "edad" ))
                );
            }

        }catch (SQLException e){
            GestorBD.printSQLException ( e );
        }

    }


    @Override
    public void actualizarGUI () {

    }
}

