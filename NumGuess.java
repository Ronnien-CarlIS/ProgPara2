import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import java.util.Random;

public class NumGuess extends Application{
   private int randnum, att;
   
   @Override
   public void start(Stage stage){
   
      Random random = new Random(); 
      int maxNum = 100; 
      randnum = random.nextInt(maxNum);
      att = 5;
      
      System.out.println(randnum);
      
      TextField userInputNumber = new TextField();
      userInputNumber.setMaxWidth(160);
      userInputNumber.setFont(Font.font("Arial", 15));
      
      
      Button submit = new Button("Guess");
         
      
      Text msg = new Text(10, 20, "Guess the number");
      msg.setFont(Font.font("Arial", 15));
      
      
      Text msgatt = new Text(10, 20, "You have "+ att +" attemp/s left");
      msgatt.setFont(Font.font("Arial", 15));
      
      
      Text text = new Text(10, 20, "Max random number : "+maxNum); 
      text.setFont(Font.font("Arial", 15));
      
     
      submit.setOnAction( 
         e -> {
            if(att > 0){
               int guessNum = Integer.parseInt(userInputNumber.getText());
               if(guessNum > randnum){
                  msg.setText("Number too high");
                  msg.setFill(Color.RED);
                  att -= 1;
                  msgatt.setText("You have " + att + " attemp/s left");     
               }
               else if(guessNum < randnum){
                  msg.setText("Number too low");
                  msg.setFill(Color.RED);
                  att -= 1;
                  msgatt.setText("You have " + att + " attemp/s left");
               }
               
               else{
                  msg.setText("You Guessed the Correct Number!");
                  msg.setFill(Color.GREEN);
                  randnum = random.nextInt(maxNum);
                  att = 5;
                  msgatt.setText("New random number generated\nYou have " + att + " attemp/s left");
               }
               
            }
            else{
               randnum = random.nextInt(maxNum);
               att = 5;
               msgatt.setText("GAME OVER!!!\n\nNew Random number is generated\n" + att + " attemp/s left");
            } 
            
         });
     
      
      VBox root = new VBox();
      root.setSpacing(10);
      root.setAlignment(Pos.CENTER);
   
      root.getChildren().addAll(msgatt, text, userInputNumber, submit, msg);
   
      Scene scene = new Scene(root, 400, 400);
      stage.setScene(scene);
      stage.setTitle("Number Guesing by Ronnien Carl C. Baterna");
      stage.show();
   }
   
   
   public static void main(String[] args){
      launch(args);
   }
  
            }
