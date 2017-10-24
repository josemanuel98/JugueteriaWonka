package org.jwonkafx.gui;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class MainWindow extends javafx.application.Application
{
    @FXML Button btnCargarModuloClientes;
    @FXML Pane panel;
    @FXML BorderPane pnlPrincipal;
    @FXML Button btnCargarModuloEmpleado;
    @FXML Button btnCargarModuloVentas;
    @FXML Button btnCargarModuloCompras;
    @FXML Button btnCargarModuloProducto;
    FXMLLoader fxmll;
    Scene scene;
    Stage window;
    PanelVenta panelVentas;
    PanelCompra panelCompras;
    PanelClientes panelClientes;
    PanelProducto panelProducto;
    public MainWindow()
    {
        super();
        fxmll = new FXMLLoader(System.class.getResource("/org/jwonkafx/gui/fxml/window_main.fxml"));
        fxmll.setController(this);
    }
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        fxmll.load();
        scene = new Scene(fxmll.getRoot());
        primaryStage.setScene(scene);
        window = primaryStage;
        window.setTitle("Jugueteria Wonka");
        window.show();
        inicializarComponentes();
    }   
    private void inicializarComponentes() throws Exception 
    {
        window.setOnCloseRequest(evt->{System.exit(0);});
        panelClientes = new PanelClientes();
        panelVentas = new PanelVenta();
        panelCompras = new PanelCompra();
        panelProducto = new PanelProducto();
        btnCargarModuloClientes.setOnAction(evt ->
        {
            try
            {
                panelClientes.inicializar();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            pnlPrincipal.setCenter(panelClientes.getPanelRoot());
        });
        btnCargarModuloVentas.setOnAction(evt ->
        {
            try
            {
                panelVentas.inicializar();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            pnlPrincipal.setCenter(panelVentas.getPanelRoot());
        });
        btnCargarModuloCompras.setOnAction(evt ->
        {
            try
            {
                panelCompras.inicializar();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            pnlPrincipal.setCenter(panelCompras.getPanelRoot());
        });
        btnCargarModuloProducto.setOnAction(evt ->
        {
            try
            {
                panelProducto.inicializar();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            pnlPrincipal.setCenter(panelProducto.getPanelRoot());
        });
    }
}