import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PushMe extends Application
{
   @Override
   public void start(Stage stage)
   {
      // create and configure a text field for user entry
      TextField pushMeTextField = new TextField();
      pushMeTextField.setMaxWidth(250);
   
      // create and configure a label to display the output
      Label pushMeLabel= new Label();
      pushMeLabel.setTextFill(Color.RED);
      pushMeLabel.setFont(Font.font("Arial", 20));
      
      //Upper Case
      Button upperCaseButton = new Button();
      upperCaseButton.setText("Upper Case");
      upperCaseButton.setOnAction(e -> pushMeLabel.setText("You entered: " + pushMeTextField.getText().toUpperCase()));
      
     // Lower Case
      Button lowerCaseButton = new Button();
      lowerCaseButton.setText("Lower Case");
      lowerCaseButton.setOnAction(e -> pushMeLabel.setText("You entered: " + pushMeTextField.getText().toLowerCase()));
      
      // create and configure a label which will cause the text to be displayed
      Button pushMeButton = new Button();
      pushMeButton.setText("Type something in the box then push me");
      pushMeButton.setOnAction(e -> pushMeLabel.setText("You entered: " + pushMeTextField.getText()));
           
      // create and configure a VBox to hold our components       
      VBox root = new VBox();
      root.setSpacing(10);
      root.setAlignment(Pos.CENTER);
      
      //add the components to the VBox
      root.getChildren().addAll(pushMeTextField, pushMeButton, upperCaseButton, lowerCaseButton, pushMeLabel);
     
   
      // create a new scene
      Scene scene = new Scene(root, 350, 150);
      
      //add the scene to the stage, then configure the stage and make it visible
      stage.setScene(scene);
      stage.setTitle("Push Me");
      stage.show();        
   }
   
   public static void main(String[] args)
   {
      launch(args);
   }
   
}
