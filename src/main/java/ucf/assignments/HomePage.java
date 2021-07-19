 /*
  *
  *  *  UCF COP3330 Summer 2021 Assignment 4 Solution
  *  *  Copyright 2021 Alice Yu
  *
  */

 package ucf.assignments;

 import javafx.application.Application;
 import javafx.fxml.FXMLLoader;
 import javafx.scene.Parent;
 import javafx.scene.Scene;
 import javafx.stage.Stage;

 import java.io.IOException;
 import java.net.URL;

 public class HomePage extends Application {

     public static void main(String[] args) {
         launch(args);
     }

     @Override
     public void start(Stage primaryStage) {
         try {
             Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
             Scene scene = new Scene(root);

             URL url = this.getClass().getResource("Style.css");
             if (url == null){
                 System.out.println("Couldn't find anything");
                 System.out.println(-1);
             }

             String css = url.toExternalForm();
             root.getStylesheets().add(css);

             //scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
             primaryStage.setScene(scene);
             primaryStage.setTitle("ToDoList");
             primaryStage.show();

         } catch (IOException e) {
             e.printStackTrace();
         }
     }
 }
