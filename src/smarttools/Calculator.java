package smarttools;

import javafx.event.ActionEvent;
import java.lang.Math;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Calculator {
    
    double number1, number2, answer;
    int option;
    String text;
    static Button exit = new Button();
    
    @FXML
    private TextField display;
    
    public Parent layout() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CalculatorFXML.fxml"));
        return root;

    }
    
    //Button Controllers 
    public void exitIsClicked(ActionEvent e) {
        exit.fire();
    }
    public void zero(ActionEvent e){
        display.setText(display.getText() + "0");
    }
    public void one(ActionEvent e){
        display.setText(display.getText() + "1");
    }
    public void two(ActionEvent e){
        display.setText(display.getText() + "2");
    }
    public void three(ActionEvent e){
        display.setText(display.getText() + "3");
    }
    public void four(ActionEvent e){
        display.setText(display.getText() + "4");
    }
    public void five(ActionEvent e){
        display.setText(display.getText() + "5");
    }
    public void six(ActionEvent e){
        display.setText(display.getText() + "6");
    }
    public void seven(ActionEvent e){
        display.setText(display.getText() + "7");
    }
    public void eight(ActionEvent e){
        display.setText(display.getText() + "8");
    }
    public void nine(ActionEvent e){
        display.setText(display.getText() + "9");
    }
    public void clear(ActionEvent e){
        display.setText("");
        answer = 0;
        number1 = 0;
    }
    public void backspace(ActionEvent e){
        text = display.getText();
        text = text.substring(0, text.length()-1);
        display.setText(text);
    }
    public void add(ActionEvent e){
        number1 = Double.parseDouble(display.getText());                      
        display.setText("");
        option = 1;
    }
    public void subtract(ActionEvent e){
        number1 = Double.parseDouble(display.getText());
        display.setText("");
        option = 2;
    }
    public void multiply(ActionEvent e){
        number1 = Double.parseDouble(display.getText());
        display.setText("");
        option = 3;
    }
    public void divide(ActionEvent e){
        number1 = Double.parseDouble(display.getText());
        display.setText("");
        option = 4;
    }
    public void sqrroot(ActionEvent e){
        number1 = Double.parseDouble(display.getText());
        double a = Math.sqrt(number1);
        display.setText(a+ "");
    }
    public void equals(ActionEvent e){
        number2 = Double.parseDouble(display.getText());
        switch(option){
            case 1: 
                answer = number1 + number2;
                display.setText("" + (int)answer);
                break;
            case 2:
                answer = (number1 - number2);
                display.setText("" + (int)answer);
                break;
            case 3:
                answer = (number1 * number2);
                display.setText("" + (int)answer);
                break;
            case 4:
                if(number2 == 0){
                    display.setText("Division by 0");
                } 
                else{  
                    answer = number1 / number2;
                    display.setText(String.format("%.10f",answer));
                }
                break;
        }
    }
    
    
}
