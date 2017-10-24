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
import org.jwonkafx.model.Venta;
import org.jwonkafx.model.DetalleVenta;
import org.jwonkafx.model.FormadePago;
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
    @FXML TextField txtFormadePago;
    @FXML Label lblIdProd;
    @FXML ImageView imgProducto;
    @FXML TableView<Producto> tblProducto;
    @FXML TableView<Cliente> tblvCveCliente;
    @FXML TableView<Empleado> tblvCveEmpleado;
    @FXML DatePicker dpkFechaVenta;
    @FXML Button btnGenerarVenta;
    FXMLLoader fxmll;
    ControladorVenta cv;
    ControladorCliente cc;
    ControladorEmpleado ce;
    ControladorProducto cp;
    public PanelVenta()
    {
        cv = new ControladorVenta();
        cc = new ControladorCliente();
        ce = new ControladorEmpleado();
        cp = new ControladorProducto();
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
        consultar("");
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
        btnGenerarVenta.setOnAction((ActionEvent evt)->
        {
            gVenta();
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
        ObservableList<Cliente> clientes = null;
        ObservableList<Producto> productos = null;
        ObservableList<Empleado> empleados = null;
        try
        {
            clientes = cc.getAll(filtro);
            empleados = ce.getAll(filtro);
            productos = cp.getAll(filtro);
            tblProducto.setItems(productos);
            tblvCveCliente.setItems(clientes);
            tblvCveEmpleado.setItems(empleados);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public void gVenta()
    {
        Venta ven = new Venta();
        DetalleVenta dven = new DetalleVenta();
        FormadePago fp = new FormadePago();
        Empleado em = new Empleado();
        Cliente cli = new Cliente();
        Producto prod = new Producto();
        int pc;
        try
        {
            ven.setFecha(dpkFechaVenta.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            fp.setDescripcion(txtFormadePago.getText());
            ven.setFP(fp);
            em.setIdEmpleado(Integer.valueOf(txtCveEmpleado.getText()));
            ven.setEmpleado(em);
            cli.setId(Integer.valueOf(txtCveCliente.getText()));
            ven.setCliente(cli);
            dven.setCantidadProducto(Integer.valueOf(txtCantProducto.getText()));
            pc = (Integer.valueOf(txtCantProducto.getText())) * (Integer.valueOf(txtPrecio.getText()));
            dven.setPrecio(pc);
            prod.setIdProducto(Integer.valueOf(lblIdProd.getText()));
            dven.setProducto(prod);
            cv.InsertV(ven, dven);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}