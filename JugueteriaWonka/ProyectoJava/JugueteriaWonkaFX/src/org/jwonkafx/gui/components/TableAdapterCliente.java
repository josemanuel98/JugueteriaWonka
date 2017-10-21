/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jwonkafx.gui.components;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import org.jwonkafx.model.Cliente;

/**
 *
 * @author Josem
 */
public class TableAdapterCliente {
    public static void adapt(TableView<Cliente> tbl){
        TableColumn<Cliente, Integer> tcIdCliente = new TableColumn("Cve. Cliente");
        TableColumn<Cliente, Integer> tcIdPersona = new TableColumn("Cve. Persona");
        TableColumn<Cliente, String> tcNombre = new TableColumn("Nombre");
        TableColumn<Cliente, String> tcApellidoPaterno = new TableColumn("Apellido Paterno");
        TableColumn<Cliente, String> tcApellidoMaterno = new TableColumn("Apellido Materno");
        TableColumn<Cliente, String> tcGenero = new TableColumn("Genero");
        TableColumn<Cliente, String> tcRfc = new TableColumn("RFC");
        TableColumn<Cliente, String> tcCurp = new TableColumn("CURP");
        TableColumn<Cliente, String> tcFechaNacimiento = new TableColumn("Fecha de Nacimiento");
        TableColumn<Cliente, String> tcCp = new TableColumn("Código Postal");
        TableColumn<Cliente, String> tcDomicilio = new TableColumn("Domicilio");
        TableColumn<Cliente, String> tcEmail = new TableColumn("Email");
        TableColumn<Cliente, String> tcTelefono = new TableColumn("Teléfono");
        TableColumn<Cliente, Integer> tcActivo = new TableColumn("Activo");
        TableColumn<Cliente, String> tcFotografia = new TableColumn("Fotografia");
        
        tcIdCliente.setCellFactory(new Callback<TableColumn<Cliente, Integer>, TableCell<Cliente, Integer>>(){
            @Override
            public TableCell<Cliente, Integer> call(TableColumn<Cliente, Integer> param){
                return new TableCell<Cliente, Integer>(){
                    @Override
                    protected void updateItem(Integer item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getIdCliente());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        
        tcIdPersona.setCellFactory(new Callback<TableColumn<Cliente, Integer>, TableCell<Cliente, Integer>>(){
            @Override
            public TableCell<Cliente, Integer> call(TableColumn<Cliente, Integer> param){
                return new TableCell<Cliente, Integer>(){
                    @Override
                    protected void updateItem(Integer item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getPersona().getIdPersona());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        
        tcNombre.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>(){
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, String> param){
                return new TableCell<Cliente, String>(){
                    @Override
                    protected void updateItem(String item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getPersona().getNombre());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcApellidoPaterno.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>(){
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, String> param){
                return new TableCell<Cliente, String>(){
                    @Override
                    protected void updateItem(String item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getPersona().getPaterno());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcApellidoMaterno.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>(){
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, String> param){
                return new TableCell<Cliente, String>(){
                    @Override
                    protected void updateItem(String item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getPersona().getMaterno());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcGenero.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>(){
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, String> param){
                return new TableCell<Cliente, String>(){
                    @Override
                    protected void updateItem(String item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getPersona().getGenero());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcRfc.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>(){
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, String> param){
                return new TableCell<Cliente, String>(){
                    @Override
                    protected void updateItem(String item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getPersona().getRfc());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcCurp.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>(){
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, String> param){
                return new TableCell<Cliente, String>(){
                    @Override
                    protected void updateItem(String item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getPersona().getCurp());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcFechaNacimiento.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>(){
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, String> param){
                return new TableCell<Cliente, String>(){
                    @Override
                    protected void updateItem(String item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getPersona().getFechaNacimiento());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcCp.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>(){
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, String> param){
                return new TableCell<Cliente, String>(){
                    @Override
                    protected void updateItem(String item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getPersona().getCodigoPostal());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcDomicilio.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>(){
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, String> param){
                return new TableCell<Cliente, String>(){
                    @Override
                    protected void updateItem(String item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getPersona().getDomicilio());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcEmail.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>(){
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, String> param){
                return new TableCell<Cliente, String>(){
                    @Override
                    protected void updateItem(String item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getEmail());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcTelefono.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>(){
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, String> param){
                return new TableCell<Cliente, String>(){
                    @Override
                    protected void updateItem(String item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getTelefono());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcActivo.setCellFactory(new Callback<TableColumn<Cliente, Integer>, TableCell<Cliente, Integer>>(){
            @Override
            public TableCell<Cliente, Integer> call(TableColumn<Cliente, Integer> param){
                return new TableCell<Cliente, Integer>(){
                    @Override
                    protected void updateItem(Integer item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getActivo());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcFotografia.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>(){
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, String> param){
                return new TableCell<Cliente, String>(){
                    @Override
                    protected void updateItem(String item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getPersona().getFotografia());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tbl.getColumns().clear();
        tbl.getColumns().addAll(
                tcIdCliente, 
                tcIdPersona, 
                tcNombre, 
                tcApellidoPaterno, 
                tcApellidoMaterno,
                tcGenero,
                tcRfc,
                tcCurp,
                tcFechaNacimiento,
                tcCp,
                tcDomicilio,
                tcEmail,
                tcTelefono,
                tcActivo,
                tcFotografia
        );
        
    }
}
