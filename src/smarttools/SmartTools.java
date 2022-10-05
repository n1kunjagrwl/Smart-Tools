package smarttools;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.*; 


public class SmartTools extends Application {

    Button cal_button, tempconv_button, elecbill_button, exit_button;
    Scene scene;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start (Stage primaryStage) throws Exception {
                
        StackPane layout = new StackPane();
        
        exit_button = new Button();
        cal_button = new Button();
        tempconv_button = new Button();
        elecbill_button = new Button();
      
        exit_button.setText("Exit");
        cal_button.setText("Calculator");
        tempconv_button.setText("Temperature Convertor");
        elecbill_button.setText("Electricity Bill Generator");
        
        cal_button.setOnAction((ActionEvent e) -> {
            try {
                Calculator obj = new Calculator();
                Scene scene_cal = new Scene(obj.layout(), 720, 720);
                primaryStage.setScene(scene_cal);
                primaryStage.show();
                Calculator.exit.setOnAction(action -> {
                    primaryStage.setScene(scene);
                    primaryStage.show();
                });
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        
        tempconv_button.setOnAction((ActionEvent e) -> {
            try {
                TemperatureConvertor obj = new TemperatureConvertor();
                Scene scene_cal = new Scene(obj.layout(), 400, 400);
                primaryStage.setScene(scene_cal);
                primaryStage.show();
                TemperatureConvertor.exit.setOnAction(action -> {
                    primaryStage.setScene(scene);
                    primaryStage.show();
                });
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        
        elecbill_button.setOnAction((ActionEvent e) -> {
            try {
                ElectricityBillGenerator obj = new ElectricityBillGenerator();
                Scene scene_cal = new Scene(obj.layout(), 500, 470);
                primaryStage.setScene(scene_cal);
                primaryStage.show();
                ElectricityBillGenerator.exit.setOnAction(action -> {
                    primaryStage.setScene(scene);
                    primaryStage.show();
                });
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
       
        layout.getChildren().add(cal_button);
        layout.getChildren().add(tempconv_button);
        layout.getChildren().add(elecbill_button);
       
        tempconv_button.setTranslateY(-100);
        elecbill_button.setTranslateY(100);
      
        scene = new Scene(layout, 400, 400);
        primaryStage.setTitle("Smart Tools");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
}
    
