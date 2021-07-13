package ucf.assignments;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.JSONArray;

import javax.swing.*;
import java.io.File;

public class FileMaker {
    //public JSONArray loadFile() {
   // FileChooser fc = new FileChooser();
    /* FileChooser fileChooser = new FileChooser();
     fileChooser.setTitle("Save Image");
     //System.out.println(pic.getId());
     File file = fileChooser.showSaveDialog(stage);
     if (file != null) {
         try {
             ImageIO.write(SwingFXUtils.fromFXImage(pic.getImage(),
                     null), "png", file);
         } catch (IOException ex) {
             System.out.println(ex.getMessage());
         }
     }
    File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null){
        listItems.getItems().add(selectedFile.getName());
    } else {
        System.out.println("File does not exist");
    }
    //}*/

    public void saveList(ListView listItems) {
        /*Stage stage;
        Parent root;

            stage = (Stage) btn1.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXML2.fxml"));


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/
    }

     /*JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showSaveDialog(FileChooserDemo.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = filechooser.getSelectedFile();
            log.append("Saving: " + file.getName() + "." + newline);
        } else {
            log.append("Save command cancelled by user." + newline);
        }*/
}
