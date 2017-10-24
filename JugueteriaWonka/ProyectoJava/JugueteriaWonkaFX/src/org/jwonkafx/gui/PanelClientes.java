package org.jwonkafx.gui;
import com.github.sarxos.webcam.Webcam;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.grios.jwebcam.WebCamAdapterFX;
import org.jwonkafx.core.ControladorCliente;
import org.jwonkafx.gui.components.FechasAdaptador;
import org.jwonkafx.gui.components.TableAdapterCliente;
import org.jwonkafx.model.Cliente;
import org.jwonkafx.model.Persona;
public class PanelClientes
{
    @FXML AnchorPane pnlRoot;
    @FXML TextField txtIdCliente;
    @FXML TextField txtIdPersona;
    @FXML TextField txtNombre;
    @FXML TextField txtApellidoPaterno;
    @FXML TextField txtApellidoMaterno;
    @FXML TextField txtRfc;
    @FXML TextField txtCurp;
    @FXML TextField txtDomicilio;
    @FXML TextField txtCodigoPostal;
    @FXML TextField txtEmail;
    @FXML TextField txtTelefono;
    @FXML TextField txtFiltro;
    @FXML DatePicker dpkFechaNacimiento;
    @FXML ComboBox cmbGenero;
    @FXML ComboBox cmbCamarasWeb;
    @FXML CheckBox chbActivo;
    @FXML ImageView imgvFoto;
    @FXML ImageView imgvCamaraWeb;
    @FXML Button btnTomarFoto;
    @FXML Button btnIniciarCamaraWeb;
    @FXML Button btnCrearNuevo;
    @FXML Button btnGuardar;
    @FXML Button btnEliminar;
    @FXML Button btnConsultar;
    @FXML Button btnBuscarCliente;
    @FXML TableView<Cliente> tblClientes;
    WebCamAdapterFX webcamfx;
    FXMLLoader fxmll;
    ControladorCliente cc;
    public PanelClientes()
    {
        cc = new ControladorCliente();
    }
    public void inicializar() throws Exception
    {
        fxmll= new FXMLLoader(System.class.getResource("/org/jwonkafx/gui/fxml/panel_clientes.fxml"));
        fxmll.setController(this);
        fxmll.load();
        tblClientes.setItems(FXCollections.observableArrayList());
        TableAdapterCliente.adapt(tblClientes);
        btnConsultar.setOnAction(evt-> { consultar("");});
        btnGuardar.setOnAction(evt->{guardarCliente();});
        btnIniciarCamaraWeb.setOnAction(evt-> {iniciarCamaraWeb();});
        btnTomarFoto.setOnAction(evt-> {tomarFoto();});
        consultarWebCam();     
        FechasAdaptador.adaptar(dpkFechaNacimiento, "dd/MM/yyyy");
        TableAdapterCliente.adapt(tblClientes);
        btnCrearNuevo.setOnAction((ActionEvent evt)->
        {
            insertar();
        });   
        btnEliminar.setOnAction((ActionEvent evt)->
        {
            try
            {
                eliminar();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        });
        tblClientes.setOnMouseClicked(evt-> 
        {
            Cliente cliente=new Cliente();
            cliente= tblClientes.getSelectionModel().selectedItemProperty().getValue();
            llenar(cliente);
        });
    }
    private void llenar(Cliente cliente)
    {
        txtIdCliente.setText(""+cliente.getId());
        txtIdPersona.setText(""+cliente.getPersona().getIdPersona());
        txtApellidoPaterno.setText(cliente.getPersona().getApellidoPaterno());
        txtApellidoMaterno.setText(cliente.getPersona().getApellidoMaterno());
        txtCodigoPostal.setText(cliente.getPersona().getCp());
        txtCurp.setText(cliente.getPersona().getCurp());
        txtDomicilio.setText(cliente.getPersona().getDomicilio());
        txtEmail.setText(cliente.getEmail());
        txtRfc.setText(cliente.getPersona().getRfc());
        txtTelefono.setText(cliente.getTelefono());
        cmbGenero.getSelectionModel().select(cliente.getPersona().getGenero());
        txtNombre.setText(cliente.getPersona().getNombre());
        dpkFechaNacimiento.setPromptText(cliente.getPersona().getFechaNacimiento());
    }
    public AnchorPane getPanelRoot()
    {
        return pnlRoot;
    }
    public void insertar()
    {
        Cliente c = new Cliente();
        try
        {
            c.setActivo(1);
            c.getPersona().setCp(this.txtCodigoPostal.getText());
            c.getPersona().setCurp(this.txtCurp.getText());
            c.getPersona().setDomicilio(this.txtDomicilio.getText());
            c.setEmail(this.txtEmail.getText());
            c.getPersona().setFechaNacimiento(this.dpkFechaNacimiento.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            c.getPersona().setFotografia(this.imgvFoto.toString());
            c.getPersona().setGenero(this.cmbGenero.getSelectionModel().getSelectedItem().toString());
            c.getPersona().setApellidoMaterno(this.txtApellidoMaterno.getText());
            c.getPersona().setNombre(this.txtNombre.getText());
            c.getPersona().setApellidoPaterno(this.txtApellidoPaterno.getText());
            c.getPersona().setRfc(this.txtRfc.getText());
            c.setTelefono(this.txtTelefono.getText());
            cc.Insert(c);
        }
        catch(Exception e)
        {
            Alert alert=new Alert(AlertType.ERROR,"Revise los campos \nERROR:"+e,ButtonType.OK);
            alert.show();
            e.printStackTrace();
        }
    }
    public void consultar(String filtro)
    {
        ObservableList<Cliente> clientes= null;
        try
        {
            clientes=cc.getAll(filtro);
            tblClientes.setItems(clientes);    
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void guardarCliente()
    {
        Cliente c = new Cliente();
        Persona p = new Persona();
        try
        {
            p.setApellidoMaterno(txtApellidoMaterno.getText());
            p.setApellidoPaterno(txtApellidoPaterno.getText());
            p.setCp(txtCodigoPostal.getText());
            p.setCurp(txtCurp.getText());
            p.setDomicilio(txtDomicilio.getText());
            p.setFechaNacimiento(dpkFechaNacimiento.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))); 
            if(imgvFoto.getImage()!=null)
                p.setFotografia(WebCamAdapterFX.encodeImageURLSafe(SwingFXUtils.fromFXImage(imgvFoto.getImage(), null)));
            else
                p.setFotografia("");
            p.setFotografia("");
            p.setGenero(cmbGenero.getSelectionModel().getSelectedItem().toString());
            p.setNombre(txtNombre.getText());
            p.setRfc(txtRfc.getText());
            if(!txtIdPersona.getText().trim().isEmpty())
                p.setIdPersona((Integer.valueOf(txtIdPersona.getText())));
            c.setActivo(chbActivo.isSelected()? 1:0);
            c.setEmail(txtEmail.getText());
            c.setPersona(p);
            c.setTelefono((txtTelefono.getText()));
            if(!txtIdCliente.getText().trim().isEmpty())
                c.setId((Integer.valueOf(txtIdCliente.getText())));
            if(c.getId() > 0 && c.getPersona().getIdPersona() > 0)
                cc.Update(c);
            else
                cc.Insert(c);
            consultar("");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    private void eliminar() throws Exception
    {
        try
        {
            int IDCliente;
            IDCliente = Integer.valueOf(txtIdCliente.getText());
            cc.Delete(IDCliente);
            consultar("");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public void consultarWebCam()
    {
        Webcam[] cams= WebCamAdapterFX.getSystemCamDevicesAsArray();
        cmbCamarasWeb.getItems().clear();
        for(Webcam w: cams)
            cmbCamarasWeb.getItems().add(w.getName());
    }
    private void iniciarCamaraWeb()
    {
        if(webcamfx==null)
            webcamfx= new WebCamAdapterFX(imgvCamaraWeb);
        if(webcamfx.isStarted());
            webcamfx.stop();
        if(cmbCamarasWeb.getSelectionModel().getSelectedItem()!=null)
            webcamfx.start(cmbCamarasWeb.getSelectionModel().getSelectedItem().toString());
    }
    private void tomarFoto()
    {
        if(webcamfx!=null && webcamfx.isStarted())
            imgvFoto.setImage(SwingFXUtils.toFXImage(webcamfx.getBufferedImage(),null));
    }
}