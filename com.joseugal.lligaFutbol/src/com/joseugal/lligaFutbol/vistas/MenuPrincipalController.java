/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joseugal.lligaFutbol.vistas;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.joseugal.lligaFutbol.GestorEscenas;
//import com.joseugal.lligaFutbol.modelo.*;

/**
 * FXML Controller class
 *
 * @author pauro
 */
public class MenuPrincipalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }

    @FXML
    private void handleActionButtonCargaCrudJugadores(ActionEvent event) {
        try {
            GestorEscenas.getGestor().cargaVistaCrudJugadores ();
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void handleActionButtonCargaCrudEquipos(ActionEvent event) {
        try {
            GestorEscenas.getGestor().cargaVistaCrudEquipos ();
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}