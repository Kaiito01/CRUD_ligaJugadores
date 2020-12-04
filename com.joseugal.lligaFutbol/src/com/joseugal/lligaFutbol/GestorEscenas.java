/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joseugal.lligaFutbol;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class GestorEscenas {

    private static GestorEscenas gestor;
    private final Stage ventana;

    //private Scene iniciarSesion;
    private Scene menuPrincipal;
    private Scene vistaCrudJugadores;
    private Scene vistaCrudEquipos;


    //private final static String VISTA_INICIAR_SESION = "vistas/InicioSesion.fxml";
    private final static String VISTA_MENU_PRINCIPAL = "vistas/MenuPrincipal.fxml";
    private final static String VISTA_VER_JUGADORES = "vistas/VerJugadores.fxml";
    private final static String VISTA_VER_EQUIPOS = "vistas/VerEquipos.fxml";



    //private MiControlador controladorJugadores;
    //private MiControlador controladorEquipos;




    /**
     * Constructor privado de la clase. Crea todas las escenas y muestra la del
     * menu principal
     *
     * @param stage la ventana de la aplicación
     * @throws IOException
     */
    private GestorEscenas(Stage stage) throws IOException {
        this.ventana = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(VISTA_MENU_PRINCIPAL));
        Parent root = loader.load();
        menuPrincipal = new Scene(root);
        stage.setTitle("Gestor Clientes/Alquileres");
        stage.setScene(menuPrincipal);
        stage.show();

    }

    public static GestorEscenas getGestor(){
        if(gestor == null){
            throw new RuntimeException("ERROR: Gestor no inicializado");
        }
        return gestor;
    }
    public static void inicializar(Stage stage) throws IOException {
        if (gestor == null) {
            gestor = new GestorEscenas(stage);
        }
    }

    // Cargamos menu principal
    public void cargaMenuPrincipal() throws IOException {
        if (menuPrincipal == null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(VISTA_MENU_PRINCIPAL));
            Parent root = loader.load();
            menuPrincipal = new Scene(root);
        }
        ventana.setScene(menuPrincipal);
    }

    // Cargamos Vista CRUD Jugadores
    public void cargaVistaCrudJugadores() throws IOException {
        if (vistaCrudJugadores == null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource( VISTA_VER_JUGADORES ));
            Parent root = loader.load();
            vistaCrudJugadores = new Scene(root);
            //controladorJugadores = loader.getController();
        }
        ventana.setScene(vistaCrudJugadores);
        //controladorJugadores.actualizarGUI();
    }


    // Cargamos CRUD Equipos
    public void cargaVistaCrudEquipos() throws IOException {
        if (vistaCrudEquipos == null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(VISTA_VER_EQUIPOS));
            Parent root = loader.load();
            vistaCrudEquipos = new Scene(root);
            //controladorEquipos = loader.getController();
        }
        ventana.setScene(vistaCrudEquipos);
        //controladorEquipos.actualizarGUI();
    }


}