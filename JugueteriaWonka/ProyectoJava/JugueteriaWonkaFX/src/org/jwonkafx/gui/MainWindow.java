/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jwonkafx.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Josem
 */
public class MainWindow extends javafx.application.Application {
    
    @FXML Button btnCargarModuloClientes;
    @FXML BorderPane pnlPrincipal;
    
    FXMLLoader fxmll;
    Scene scene;
    Stage window;
    
    ClienteWindow clienteWindow;
    
    public MainWindow(){
        super();
        fxmll = new FXMLLoader(System.class.getResource("/org/jwonkafx/gui/fxml/window_main.fxml"));
        fxmll.setController(this);
        //ClienteWindow clienteW = new ClienteWindow();
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        try{
            fxmll.load();
            
            scene = new Scene(fxmll.getRoot());
            window = primaryStage;
            window.setScene(scene);
            primaryStage.setScene(scene);
            inicializarComponentes();
            
            window.setTitle("Jugueteria Wonka");
            window.show();

        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        
    }
    
    private void inicializarComponentes() throws Exception{
        window.setOnCloseRequest(evt -> {System.exit(0);});
        clienteWindow = new ClienteWindow();
        clienteWindow.start();
        btnCargarModuloClientes.setOnAction(evt -> {
        //clienteWindow.consultarWebCams();
            pnlPrincipal.setCenter(clienteWindow.getPanelRoot());
        });
    }
    
}
