/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jwonkafx.gui;

import com.github.sarxos.webcam.Webcam;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.grios.jwebcam.WebCamAdapterFX;
import org.jwonkafx.core.ClienteController;
import org.jwonkafx.gui.components.TableAdapterCliente;
import org.jwonkafx.model.Cliente;
import org.jwonkafx.model.Persona;

/**
 *
 * @author Josem
 */
public class ClienteWindow  {

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
    @FXML TextField TextFieldtxtFiltro;
    @FXML ComboBox cmbGenero;
    @FXML DatePicker dpkFechaNacimiento;
    @FXML CheckBox chbActivo;
    @FXML Button btnTomarFoto;
    @FXML Button btnCrearNuevo;
    @FXML Button btnGuardar;
    @FXML Button btnEliminar;
    @FXML Button btnConsultar;
    @FXML Button btnIniciarCamaraWeb;
    @FXML Button btnBuscarCliente;
    @FXML ImageView imgvCamaraWeb;
    @FXML TableView<Cliente> tblClientes;
    @FXML AnchorPane pnlRoot;
    @FXML ComboBox cmbCamarasWeb;
    @FXML ImageView imgvFoto;
    
    FXMLLoader fxmll;
    Scene scene;
    Stage window;
    ClienteController cc;
    WebCamAdapterFX webcamfx;
    Alert alertDefault;
    
    public void start() throws Exception {
        fxmll = new FXMLLoader(System.class.getResource("/org/jwonkafx/gui/fxml/panel_clientes.fxml"));
        fxmll.setController(this);;
        fxmll.load();
        
        tblClientes.setItems(FXCollections.observableArrayList());
        TableAdapterCliente.adapt(tblClientes);
        
        btnGuardar.setOnAction(evt -> {
            guardarCliente();
        });
        
        btnConsultar.setOnAction(evt -> {
            consultar("");
        });
        
        btnIniciarCamaraWeb.setOnAction(evt -> {
            iniciarCamaraWeb();
        });
        
        btnTomarFoto.setOnAction(evt -> {
            tomarFoto();
        });
        
        btnEliminar.setOnAction(evt -> {
            eliminarCliente();
        });
        
        tblClientes.setOnMouseClicked(evt -> {
            llenarContenedores(tblClientes.getSelectionModel().selectedItemProperty().getValue());
        });
        
        consultarWebCams();
        
    }
    
    public AnchorPane getPanelRoot(){
        return pnlRoot;
    }
    
    public void consultar(String filtro){
        ObservableList<Cliente> clientes = null;
        cc = new ClienteController();
        try{
            clientes = cc.getAll(filtro);
            tblClientes.setItems(clientes);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public void consultarWebCams(){
        //Se consultan las webcams conectadas al equipo y se guardan en un arreglo
        Webcam[] cams = WebCamAdapterFX.getSystemCamDevicesAsArray();
        //Se limpia el ComboBox de la webcam
        cmbCamarasWeb.getItems().clear();
        //Por cada webcam en el arreglo se agrega su nombre en el ComboBox
        for(Webcam w : cams){
            cmbCamarasWeb.getItems().add(w.getName());
        }
    }
    
    private void iniciarCamaraWeb(){
        if(webcamfx == null){
            webcamfx = new WebCamAdapterFX(imgvCamaraWeb);
        }
        
        if(webcamfx.isStarted()){
            webcamfx.stop();
        }
        
        if(cmbCamarasWeb.getSelectionModel().getSelectedItem() != null){
            webcamfx.start(cmbCamarasWeb.getSelectionModel().getSelectedItem().toString());
        }
    }
    
    private void tomarFoto(){
        if(webcamfx != null && webcamfx.isStarted()){
            imgvFoto.setImage(SwingFXUtils.toFXImage(webcamfx.getBufferedImage(), null));
        }
    }
    
    private void llenarContenedores(Cliente c){
        txtNombre.setText(c.getPersona().getNombre());
        txtApellidoPaterno.setText(c.getPersona().getPaterno());
        txtApellidoMaterno.setText(c.getPersona().getMaterno());
        txtCodigoPostal.setText(c.getPersona().getCodigoPostal());
        txtDomicilio.setText(c.getPersona().getDomicilio());
        txtCurp.setText(c.getPersona().getCurp());
        txtRfc.setText(c.getPersona().getRfc());
        dpkFechaNacimiento.setPromptText(c.getPersona().getFechaNacimiento());
        
        try{
            imgvFoto.setImage(SwingFXUtils.toFXImage(WebCamAdapterFX.decodeImageURLSafe(c.getPersona().getFotografia()), null));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cmbGenero.setValue(c.getPersona().getGenero());
        
        if(c.getActivo() == 1){
            chbActivo.setSelected(true);
        }else{
            chbActivo.setSelected(false);
        }
        txtEmail.setText(c.getEmail());
        txtTelefono.setText(c.getTelefono());
        txtIdPersona.setText("" + c.getPersona().getIdPersona());
        txtIdCliente.setText("" + c.getIdCliente());
    }
    
    private void eliminarCliente(){
        try{
            cc = new ClienteController();
            int Id = Integer.valueOf(txtIdCliente.getText());
            cc.delete(Id);
            consultar("");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void guardarCliente(){
        
        try{
            Cliente c = new Cliente();
            Persona p = new Persona();
            
            cc = new ClienteController();
            
            p.setNombre(txtNombre.getText());
            p.setPaterno(txtApellidoPaterno.getText());
            p.setMaterno(txtApellidoMaterno.getText());
            p.setGenero(cmbGenero.getSelectionModel().getSelectedItem().toString());
            p.setRfc(txtRfc.getText());
            p.setCurp(txtCurp.getText());
            p.setCodigoPostal(txtCodigoPostal.getText());
            String date_s = dpkFechaNacimiento.getValue().toString();
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
            Date date = dt.parse(date_s);
            SimpleDateFormat dt1 = new SimpleDateFormat("dd/mm/yyyy");
            p.setFechaNacimiento(dt1.format(date));
            p.setDomicilio(txtDomicilio.getText());
            if(imgvFoto.getImage() != null){
                p.setFotografia(WebCamAdapterFX.encodeImageURLSafe(SwingFXUtils.fromFXImage(imgvFoto.getImage(), null)));
            }else{
                p.setFotografia("");
            }
            if(!txtIdPersona.getText().trim().isEmpty()){
                p.setIdPersona(Integer.parseInt(txtIdPersona.getText()));
            }
            
            c.setActivo(chbActivo.isSelected() ? 1:0);
        
            c.setTelefono(txtTelefono.getText());
            c.setEmail(txtEmail.getText());
            if(!txtIdCliente.getText().trim().isEmpty()){
                c.setIdCliente(Integer.valueOf(txtIdCliente.getText()));
            }
            
            c.setPersona(p);
        
            if(c.getIdCliente() > 0 && c.getPersona().getIdPersona() > 0){
                cc.update(c);
            }else{
                cc.add(c);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
