package org.jwonkafx.gui;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.jwonkafx.core.ControladorCliente;
import org.jwonkafx.core.ControladorEmpleado;
import org.jwonkafx.core.ControladorProducto;
import org.jwonkafx.core.ControladorVenta;
import org.jwonkafx.gui.components.TableAdapterC;
import org.jwonkafx.gui.components.TableAdapterE;
import org.jwonkafx.gui.components.TableAdapterProducto;
import org.jwonkafx.model.Cliente;
import org.jwonkafx.model.Empleado;
import org.jwonkafx.model.Producto;
public class PanelVenta
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
    @FXML TextField txtCveCliente;
    @FXML TextField txtCveEmpleado;
    @FXML ImageView imgProducto;
    @FXML TableView<Producto> tblProducto;
    @FXML TableView<Cliente> tblvCveCliente;
    @FXML TableView<Empleado> tblvCveEmpleado;
    @FXML Button btnGenerarVenta;
    @FXML Button btnBCC;
    @FXML Button btnBCE;
    FXMLLoader fxmll;
    ControladorVenta cv;
    ControladorProducto cp;
    ControladorCliente cc;
    ControladorEmpleado ce;
    public PanelVenta()
    {
        cv = new ControladorVenta();
    }
    public void inicializar() throws Exception
    {
        fxmll= new FXMLLoader(System.class.getResource("/org/jwonkafx/gui/fxml/panel_venta.fxml"));
        fxmll.setController(this);
        fxmll.load();
        tblProducto.setItems(FXCollections.observableArrayList());
        tblvCveCliente.setItems(FXCollections.observableArrayList());
        tblvCveEmpleado.setItems(FXCollections.observableArrayList());
        TableAdapterProducto.adapt(tblProducto);
        TableAdapterC.adapt(tblvCveCliente);
        TableAdapterE.adapt(tblvCveEmpleado);
        tblProducto.setOnMouseClicked(evt-> 
        {
            Producto producto = new Producto();
            producto = tblProducto.getSelectionModel().selectedItemProperty().getValue();
            llenar(producto);
        });
        tblvCveCliente.setOnMouseClicked(evt-> 
        {
            Cliente cliente = new Cliente();
            cliente = tblvCveCliente.getSelectionModel().selectedItemProperty().getValue();
            llenacvc(cliente);
        });
        tblvCveEmpleado.setOnMouseClicked(evt-> 
        {
            Empleado empleado = new Empleado();
            empleado = tblvCveEmpleado.getSelectionModel().selectedItemProperty().getValue();
            llenacve(empleado);
        });
//        btnBCC.setOnAction((ActionEvent evt) ->
//        {
//            JDialog ventanaEmergente = new JDialog();
//            ventanaEmergente.setSize(400, 400);
//            ventanaEmergente.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
//            ventanaEmergente.setVisible(true);
//        });
        consultar("");
    }
    private void llenar(Producto producto)
    {
        txtNombre.setText(producto.getNombre());
        txtEdadMinima.setText("" + producto.getIdProducto());
        txtEdadMaxima.setText("" + producto.getEdadMinima());
        txtPrecio.setText("" + producto.getPrecio());
        txtStock.setText("" + producto.getStock());
        txtMarca.setText(producto.getMarca().getNombre());
        txtDescripcion.setText(producto.getDescripcion());
    }
    private void llenacvc(Cliente cliente)
    {
        txtCveCliente.setText("" + cliente.getId());
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
        ObservableList<Cliente> clientes = cc.getAll(filtro);
        ObservableList<Producto> productos = cp.getAll(filtro);
        ObservableList<Empleado> empleados = ce.getAll(filtro);
        try
        {
//            clientes = cc.getAll(filtro);
//            empleados = ce.getAll(filtro);
//            productos = cp.getAll(filtro);
            tblProducto.setItems(productos);
            tblvCveCliente.setItems(clientes);
            tblvCveEmpleado.setItems(empleados);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}