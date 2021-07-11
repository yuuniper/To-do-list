/*
 *
 *  *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  *  Copyright 2021 Alice Yu
 *
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.json.JSONArray;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HomePageController {

    AddItem makeItem = new AddItem();
    JSONArray jsonArray = new JSONArray();

    @FXML
    private TextArea descriptionBox;

    @FXML
    private DatePicker dateBox;

    @FXML
    private TextField itemAdd;

    @FXML
    private CheckBox initialCheckBox;

    @FXML
    void addButtonClicked(MouseEvent event) throws IOException {

        GetInfo myInfo = new GetInfo(); // don't need anymore

        String myDate = dateBox.getValue().toString();
       boolean isChecked = myInfo.getChecked(initialCheckBox);

        makeItem.getItem(itemAdd.getText(), descriptionBox.getText(), myDate, isChecked, jsonArray);
    }




    @FXML
    void allItemsClicked(ActionEvent event) {

    }

    @FXML
    void clearListClicked(MouseEvent event) {

    }

    @FXML
    void completedItemsClicked(ActionEvent event) {

    }

    @FXML
    void dateClicked(MouseEvent event) {

    }

    @FXML
    void descriptionClicked(MouseEvent event) {

    }

    @FXML
    void removeButtonClicked(MouseEvent event) {

    }

    @FXML
    void uncompletedItemsClicked(ActionEvent event) {

    }

}


