/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicahiccpmp.alumnos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author vmol2
 */
public class TransaccionesController implements Initializable {

    @FXML
    private TextField txtMonto;
    @FXML
    private ComboBox<String> cmbOrigen;
    @FXML
    private TextField txtResultado;
    @FXML
    private ComboBox<String> cmbResultado;
    @FXML
    private Button btnConvertir;
    @FXML
    private Button btnConvertir1;
    
    private float mntoOrigen = 1;
    
    private float mntoResultado = (float) 1.2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cmbOrigen.getItems().add("Dolar");
        cmbOrigen.getItems().add("Lempira");
        cmbOrigen.getItems().add("Yen");
        cmbOrigen.getItems().add("Euro");
        cmbResultado.getItems().add("Dolar");
        cmbResultado.getItems().add("Lempira");
        cmbResultado.getItems().add("Yen");
        cmbResultado.getItems().add("Euro");
        txtMonto.setText("1");
        cmbOrigen.setValue("Dolar");
        txtResultado.setText("1");
        cmbResultado.setValue("Dolar");
        btnConvertir.setText("Convertir Dolar - Dolar");
        btnConvertir1.setText("Convertir Dolar - Dolar");
    }    
    @FXML
    private void cmb_change(ActionEvent event){
        cmb_changeO(event);
        cmb_changeR(event);
    }
    @FXML
    private void cmb_changeO(ActionEvent event){
        String origen = cmbOrigen.getValue();
        String resultado = cmbResultado.getValue();
        btnConvertir.setText("Convertir " + origen + " - " + resultado);
    }
    @FXML
    private void cmb_changeR(ActionEvent event){
        String origen = cmbOrigen.getValue();
        String resultado = cmbResultado.getValue();
        btnConvertir1.setText("Convertir " + resultado + " - " + origen);
    }
    @FXML
    private void btnEjecutarO(ActionEvent event){
        mtnOrigen_change(event);
    }
    @FXML
    private void btnEjecutarR(ActionEvent event){
        mtnResultado_change(event);
    }
    @FXML
    private void mtnOrigen_change(ActionEvent event) {
        String origen = cmbOrigen.getValue();
        String resultado = cmbResultado.getValue();
        
        double monto = Double.valueOf(txtMonto.getText());
        double cambioDiv = cambio(origen,resultado);
        
        monto *= cambioDiv;
        
        txtResultado.setText(String.valueOf(monto)); 
    }
    
    @FXML
    private void mtnResultado_change(ActionEvent event)
    {
        String origen = cmbOrigen.getValue();
        String resultado = cmbResultado.getValue();
        
        double monto = Double.valueOf(txtResultado.getText());
        double cambioDiv2 = cambio(resultado,origen);
        
        monto *= cambioDiv2;
        
        txtMonto.setText(String.valueOf(monto));
    }
    
    private double cambio(String o,String r)
    {
        if(o.equals("Dolar") && r.equals("Lempira"))
        {
            return 24.06;
        }
        else if(o.equals("Dolar") && r.equals("Yen"))
        {
            return 113.59;
        }
        else if(o.equals("Dolar") && r.equals("Euro"))
        {
            return 0.86;
        }
        else if(o.equals("Lempira") && r.equals("Dolar"))
        {
            return 0.042;
        }
        else if(o.equals("Lempira") && r.equals("Yen"))
        {
            return 4.72;
        }
        else if(o.equals("Lempira") && r.equals("Euro"))
        {
            return 0.036;
        }
        else if(o.equals("Yen") && r.equals("Dolar"))
        {
            return 0.0088;
        }
        else if(o.equals("Yen") && r.equals("Lempira"))
        {
            return 0.21;
        }
        else if(o.equals("Yen") && r.equals("Euro"))
        {
            return 0.0076;
        }
        else if(o.equals("Euro") && r.equals("Dolar"))
        {
            return 1.16;
        }
        else if(o.equals("Euro") && r.equals("Lempira"))
        {
            return 28.02;
        }
        else if(o.equals("Euro") && r.equals("Yen"))
        {
            return 132.30;
        }
        return 1;
    }
    
}
