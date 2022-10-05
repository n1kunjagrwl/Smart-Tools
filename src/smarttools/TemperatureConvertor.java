
package smarttools;

import java.util.stream.IntStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TemperatureConvertor {
    
    static Button exit = new Button();
    int scale;
    double cel, far, kel;
        
    @FXML
    private TextField celsiusDisplay;
    
    @FXML
    private TextField fahrenheitDisplay;
    
    @FXML
    private TextField kelvinDisplay;
    
    @FXML
    private Label instruct;
    
    public Parent layout() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("TemperatureConvertorFXML.fxml"));
        return root; 
        }
    
    //Button Controllers 
    public void exitIsClicked(ActionEvent e) {
        exit.fire();
    }
    
    public void celsiusButtonisclicked(ActionEvent e){
        instruct.setText("Base Scale: CELSIUS");
        scale = 1;
    }
    
    public void fahrenheitButtonisclicked(ActionEvent e){
        instruct.setText("Base Scale: FAHRENHEIT");
        scale = 2;
    }
    
    public void kelvinButtonisclicked(ActionEvent e){
        instruct.setText("Base Scale: KELVIN");
        scale = 3;
    }    
    
    public void calculateButtonisclicked(ActionEvent e){
        try{
        if(scale == 1){
            cel = Double.parseDouble(celsiusDisplay.getText());
            far = (cel * 9)/5.0 + 32;
            kel = cel + 273.15;
            fahrenheitDisplay.setText(Double.toString(far));
            kelvinDisplay.setText(Double.toString(kel));
        }
        else if(scale == 2){
            far = Double.parseDouble(fahrenheitDisplay.getText());
            cel = ((far - 32) * 5 )/ 9.0;
            kel = cel + 273.15;
            celsiusDisplay.setText(Double.toString(cel));
            kelvinDisplay.setText(Double.toString(kel));
        }
        else if(scale == 3){
            kel = Double.parseDouble(kelvinDisplay.getText());
            cel = kel - 273.15;
            far = (cel * 5 / 9.0) + 32;
            celsiusDisplay.setText(Double.toString(cel));
            fahrenheitDisplay.setText(Double.toString(far));
        }
        else
            instruct.setText("BASE SCALE NOT SELECTED");
    }
        catch(Exception a){
            instruct.setText("WRONG INPUT");
        }
    }
      
}