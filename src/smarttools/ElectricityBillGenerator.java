package smarttools;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ElectricityBillGenerator {
    
    static Button exit = new Button();
    double units, cost = 0;
    int flag;
    
    @FXML
    private TextField billDisplay;
    
    @FXML
    private TextField unitField;
    
    @FXML
    private Button calculateButton;
    
    public Parent layout() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ElectricityBillGeneratorFXML.fxml"));
        return root;
    }
    
    //Button Controllers 
    public void exitIslicked(ActionEvent e) {
        exit.fire();
    }
    
    public void calculateisclicked(){
        try{
        units = Double.parseDouble(unitField.getText());
        
        if(units <= 50) flag = 1;
        if(units > 50 && units <= 150) flag = 2;
        if(units > 150 && units <= 300) flag = 3;
        if(units > 300 && units <= 500) flag = 3;
        if(units > 500) flag = 5;

        switch(flag)
          {
            case 1:
                cost =  units * 4.75;
                break;
            case 2:
                 cost = (units - 50) * 6.5 + 50 * 4.75;
                 break;
            case 3:
                cost = 50 * 4.75 + 100 * 6.5 + (units - 150)*7.35;
                break;
            case 4:
                cost = 50 * 4.75 + 100 * 6.5 + 150*7.35 + (units - 300)*7.65;
                break;
            case 5:
                cost = 50 * 4.75 + 100 * 6.5 + 150*7.35 + 200*7.65 + (units-500)*7.95;
                break;
            }
        billDisplay.setText(String.format("%.4f",cost) + " Rs");
        }
        catch(Exception e){
            billDisplay.setText("Wrong Input");
        }
    }
}
