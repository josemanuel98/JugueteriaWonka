package org.jwonkafx.gui;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.jwonkafx.core.ControladorCompra;
import org.jwonkafx.core.ControladorEmpleado;
import org.jwonkafx.core.ControladorProducto;
import org.jwonkafx.gui.components.TableAdapterE;
import org.jwonkafx.gui.components.TableAdapterProducto;
import org.jwonkafx.model.Bitacora;
import org.jwonkafx.model.Empleado;
import org.jwonkafx.model.Producto;
public class PanelCompra
{
    @FXML AnchorPane pnlRoot;
    @FXML TextField txtNombre;
    @FXML TextField txtEdadMinima;
    @FXML TextField txtEdadMaxima;
    @FXML TextField txtPrecio;
    @FXML TextField txtStock;
    @FXML TextField txtMarca;
    @FXML TextField txtDescripcion;
    @FXML TextField txtCantProducto;
    @FXML TextField txtCveEmpleado;
    @FXML Label lblIdProd;
    @FXML ImageView imgProducto;
    @FXML DatePicker dpkFechaVenta;
    @FXML TableView<Producto> tblProducto;
    @FXML TableView<Empleado> tblvCveEmpleado;
    @FXML DatePicker dpkFechaCompra;
    @FXML Button btnGenerarCompra;
    FXMLLoader fxmll;
    ControladorEmpleado ce;
    ControladorProducto cp;
    ControladorCompra cC;
    public PanelCompra()
    {
        ce = new ControladorEmpleado();
        cp = new ControladorProducto();
        cC = new ControladorCompra();
    }
    public void inicializar() throws Exception
    {
        fxmll= new FXMLLoader(System.class.getResource("/org/jwonkafx/gui/fxml/panel_compra.fxml"));
        fxmll.setController(this);
        fxmll.load();
        tblProducto.setItems(FXCollections.observableArrayList());
        tblvCveEmpleado.setItems(FXCollections.observableArrayList());
        TableAdapterProducto.adapt(tblProducto);
        TableAdapterE.adapt(tblvCveEmpleado);
        consultar("");
        tblProducto.setOnMouseClicked(evt-> 
        {
            Producto producto = new Producto();
            producto = tblProducto.getSelectionModel().selectedItemProperty().getValue();
            llenar(producto);
        });
        tblvCveEmpleado.setOnMouseClicked(evt-> 
        {
            Empleado empleado = new Empleado();
            empleado = tblvCveEmpleado.getSelectionModel().selectedItemProperty().getValue();
            llenacve(empleado);
        });
        btnGenerarCompra.setOnAction((ActionEvent evt)->
        {
            gCompra();
        });   
    }
    private void llenar(Producto producto)
    {
        lblIdProd.setText("" + producto.getIdProducto());
        txtNombre.setText(producto.getNombre());
        txtEdadMinima.setText("" + producto.getIdProducto());
        txtEdadMaxima.setText("" + producto.getEdadMinima());
        txtPrecio.setText("" + producto.getPrecio());
        txtStock.setText("" + producto.getStock());
        txtMarca.setText(producto.getMarca().getNombre());
        txtDescripcion.setText(producto.getDescripcion());
    }
    private void llenacve(Empleado empleado)
    {
        txtCveEmpleado.setText("" + empleado.getIdEmpleado());
    }
    public AnchorPane getPanelRoot()
    {
        return pnlRoot;
    }
    public void consultar(String filtro) throws Exception
    {
        ObservableList<Empleado> empleados = null;
        ObservableList<Producto> productos = null;
        try
        {
            empleados = ce.getAll(filtro);
            productos = cp.getAll(filtro);
            tblProducto.setItems(productos);
            tblvCveEmpleado.setItems(empleados);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public void gCompra()
    {
        Bitacora com = new Bitacora();
        Producto prod = new Producto();
        int pc;
        try
        {
            com.setFechaAbastecimiento(dpkFechaVenta.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            com.setCantidad(Integer.valueOf(txtCantProducto.getText()));
            pc = (Integer.valueOf(txtPrecio.getText()))*(Integer.valueOf(txtCantProducto.getText()));
            com.setPrecioCompra(pc);
            prod.setIdProducto(Integer.valueOf(lblIdProd.getText()));
            com.setProducto(prod);
            cC.Insert(com);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}