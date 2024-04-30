import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class SimpleCalc extends Application{
   private double result = 0, result1 = 0;
   
   @Override
   public void start(Stage stage){
   
      TextField num1 = new TextField();
      TextField num2 = new TextField();
   
      num1.setMaxWidth(130);
      num1.setFont(Font.font("Arial", 20));
      
      num2.setMaxWidth(130);
      num2.setFont(Font.font("Arial", 20));
      
      TextField answerField = new TextField();
      answerField.setMaxWidth(250);
      answerField.setFont(Font.font("Arial", 20));
      answerField.setEditable(false);
      
      Label answerlabel = new Label("Answer:");
      answerlabel.setFont(Font.font("Arial", 15));
      
      Button addButton = new Button("+");
      Button subButton = new Button("-");
      Button mulButton = new Button("*");
      Button divButton = new Button("/");
      Button clrButton = new Button("clear");
      
      addButton.setPrefSize(30, 30); 
      subButton.setPrefSize(30, 30);
      mulButton.setPrefSize(30, 30);
      divButton.setPrefSize(30, 30);
      clrButton.setPrefSize(60, 50);
   
      Text resultText = new Text("");
      resultText.setFont(Font.font("Arial", 15));
      addButton.setOnAction( 
         e -> {
            result = Double.parseDouble(num1.getText())+Double.parseDouble(num2.getText());
            answerField.setText(Double.toString(result));
            num1.setText("");
            num2.setText(""); 
         });
         
      subButton.setOnAction( 
         e -> {
            result = Double.parseDouble(num1.getText())-Double.parseDouble(num2.getText());
            answerField.setText(Double.toString(result));
            num1.setText("");
            num2.setText(""); 
         });
         
      mulButton.setOnAction( 
         e -> {
            result = Double.parseDouble(num1.getText())*Double.parseDouble(num2.getText());
            answerField.setText("Answer: "+Double.toString(result));
            num1.setText("");
            num2.setText(""); 
         });
         
      divButton.setOnAction( 
         e -> {
            if(Double.parseDouble(num2.getText()) == 0){
               answerField.setText("Cannot divide zero");
               num2.setText("");
            }
            
            else{
               result = Double.parseDouble(num1.getText())/Double.parseDouble(num2.getText());
               answerField.setText("Answer: "+Double.toString(result));
               num1.setText("");
               num2.setText(""); 
            }
         });
         
      clrButton.setOnAction( 
         e -> {
            num1.setText(""); 
            num2.setText(""); 
            answerField.setText("");
         });
       
      HBox hbox = new HBox(10);
      hbox.setSpacing(10);
      hbox.setAlignment(Pos.CENTER);
   
      hbox.getChildren().addAll(answerlabel);   
      
      VBox root = new VBox();
      root.setSpacing(10);
      root.setAlignment(Pos.CENTER);
   
      root.getChildren().addAll(num1, num2, hbox, answerField, addButton, subButton, mulButton, divButton, clrButton);
   
      Scene scene = new Scene(root, 400, 400);
      stage.setScene(scene);
      stage.setTitle("Simple Calculator by Ronnien Carl C. Baterna");
      stage.show();
   
   }
   
   
   public static void main(String[] args){
      launch(args);
   }
}
