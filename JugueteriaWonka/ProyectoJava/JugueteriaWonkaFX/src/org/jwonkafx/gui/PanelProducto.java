package org.jwonkafx.gui;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.jwonkafx.core.ControladorEmpleado;
import org.jwonkafx.core.ControladorProducto;
import org.jwonkafx.gui.components.TableAdapterProducto;
import org.jwonkafx.model.Marca;
import org.jwonkafx.model.Producto;
public class PanelProducto
{
    @FXML AnchorPane pnlRoot;
    @FXML TextField txtIdmarca;
    @FXML TextField txtNombreMarca;
    @FXML TextField txtNombreProducto;
    @FXML TextField txtEdadMax;
    @FXML TextField txtEdadMin;
    @FXML TextField txtStock;
    @FXML TextField txtPrecio;
    @FXML TextField txtDescripcion;
    @FXML TextField txtFiltro;
    @FXML ImageView imgProducto;
    @FXML Label lblIdProducto;
    @FXML TableView<Producto> tblProductos;
    @FXML Button btnCrearNuevo;
    @FXML Button btnGuardar;
    @FXML Button btnEliminar;
    @FXML Button btnConsultar;
    @FXML Button btnElegirImagen;
    @FXML Button btnBuscarProducto;
    @FXML CheckBox chbActivo;
    FXMLLoader fxmll;
    ControladorEmpleado ce;
    ControladorProducto cp;
    public PanelProducto()
    {
        cp = new ControladorProducto();
    }
    public void inicializar() throws Exception
    {
        fxmll= new FXMLLoader(System.class.getResource("/org/jwonkafx/gui/fxml/panel_productos.fxml"));
        fxmll.setController(this);
        fxmll.load();
        tblProductos.setItems(FXCollections.observableArrayList());
        TableAdapterProducto.adapt(tblProductos);
        consultar("");
        tblProductos.setOnMouseClicked(evt-> 
        {
            Producto producto = new Producto();
            producto = tblProductos.getSelectionModel().selectedItemProperty().getValue();
            llenar(producto);
        });
        btnCrearNuevo.setOnAction((ActionEvent evt)->
        {
            ingresar();
        });
        btnGuardar.setOnAction((ActionEvent evt)->
        {
            actualizar();
        });
        btnEliminar.setOnAction((ActionEvent evt)->
        {
            eliminar();
        });
        btnConsultar.setOnAction((ActionEvent evt)->
        {
            try 
            {
                consultar("");
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        });
        btnElegirImagen.setOnAction((ActionEvent evt)->
        {
            
        });
        btnBuscarProducto.setOnAction((ActionEvent evt)->
        {
            try 
            {
                consult(txtFiltro.getText());
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        });
    }
    private void llenar(Producto producto)
    {
        txtIdmarca.setText("" + producto.getMarca().getIdMarca());
        txtNombreMarca.setText(producto.getMarca().getNombre());
        txtNombreProducto.setText(producto.getNombre());
        txtEdadMin.setText("" + producto.getEdadMinima());
        txtEdadMax.setText("" + producto.getEdadMaxima());
        txtPrecio.setText("" + producto.getPrecio());
        txtStock.setText("" + producto.getStock());
        lblIdProducto.setText("" + producto.getIdProducto());
        txtDescripcion.setText(producto.getDescripcion());
    }
    public AnchorPane getPanelRoot()
    {
        return pnlRoot;
    }
    public void consultar(String filtro) throws Exception
    {
        ObservableList<Producto> productos = null;
        try
        {
            productos = cp.getAll(filtro);
            tblProductos.setItems(productos);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public void consult(String filtro)
    {
        ObservableList<Producto> productos = null;
        try
        {
            productos = cp.getAl(filtro);
            tblProductos.setItems(productos);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public void ingresar()
    {
        Producto prod = new Producto();
        Marca mar = new Marca();
        try
        {
            mar.setNombre(txtNombreMarca.getText());
            prod.setMarca(mar);
            prod.setNombre(txtNombreProducto.getText());
            prod.setEdadMinima(Integer.valueOf(txtEdadMin.getText()));
            prod.setEdadMaxima(Integer.valueOf(txtEdadMax.getText()));
            prod.setStock(Integer.valueOf(txtStock.getText()));
            prod.setPrecio(Integer.valueOf(txtPrecio.getText()));
            prod.setDescripcion(txtDescripcion.getText());
            prod.setActivo(chbActivo.isSelected()? 1:0);
            prod.setFotografia("foto");
            cp.Insert(prod);
            consultar("");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public void actualizar()
    {
        Producto prod = new Producto();
        Marca mar = new Marca();
        try
        {
            mar.setNombre(txtNombreMarca.getText());
            prod.setMarca(mar);
            prod.setIdProducto(Integer.valueOf(lblIdProducto.getText()));
            prod.setNombre(txtNombreProducto.getText());
            prod.setEdadMinima(Integer.valueOf(txtEdadMin.getText()));
            prod.setEdadMaxima(Integer.valueOf(txtEdadMax.getText()));
            prod.setStock(Integer.valueOf(txtStock.getText()));
            prod.setPrecio(Integer.valueOf(txtPrecio.getText()));
            prod.setDescripcion(txtDescripcion.getText());
            prod.setActivo(chbActivo.isSelected()? 1:0);
            prod.setFotografia("foto");
            cp.Update(prod);
            consultar("");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public void eliminar()
    {
        Producto prod = new Producto();
        Marca mar = new Marca();
        try
        {
            prod.setIdProducto(Integer.valueOf(lblIdProducto.getText()));
            cp.Delete(prod);
            consultar("");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}