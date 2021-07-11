/*
 *
 *  *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  *  Copyright 2021 Alice Yu
 *
 */

package ucf.assignments;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EditListController {

    // variables

        @FXML
        private TableView<Task> table;

        @FXML
        private TableColumn<Task, String> checkBoxData;

        @FXML
        private TableColumn<Task, String> taskData;

        @FXML
        private TableColumn<Task, String> descriptionData;

        @FXML
        private TableColumn<Task, String> dueDateData;

        @FXML
        private TextField getTitle;

        @FXML
        private TextField getTask;

        @FXML
        private TextField getDescription;

        @FXML
        private CheckBox getCheckBox;

        @FXML
        private DatePicker getDate;


        @FXML
        void homeClicked(ActionEvent event) {
            // load home page
            // set stage
            // set scene
            // show scene
        }

    @FXML
    public void addItemClicked(ActionEvent actionEvent) {
        // get info from toDoListTitle, getTask, getDescription, getDate
        // Write info to Json file
        // add info as a row to the Table
        // Display to Table
    }
    @FXML
    public void removeItemClicked(ActionEvent actionEvent) {
        // get row that user wants to delete
        // delete from Json file
        // delete row from table
        // Display to table
    }
    @FXML
    public void allItemsButtonClicked(ActionEvent actionEvent) {
        // load all items from Json file
        // display to table
    }
    @FXML
    public void completedItemsClicked(ActionEvent actionEvent) {
        // loop for entire Json file
        // search for values with "completed" checkmark
        // load values
        // display to table
    }
    @FXML
    public void incompleteItemsClicked(ActionEvent actionEvent) {
        // loop for entire Json file
        // search for values with incomplete status
        // load values
        // display to table
    }
    @FXML
    public void saveListClicked(ActionEvent actionEvent) {
        // get all values from table
        // save to Json File
    }
    @FXML
    public String setTitle(){
        // if the user clicked new list
        // get title from text field
        String title = "temp";
        // save title to json file
        // display title
        return title;
    }

    @FXML
    public void loadList(Object list){
        // load list items from Json file
        // send title to getTitle()
        // display to table

    }

    @FXML
    public void getTitle(String savedTitle){
            // set title to savedTitle
        // display to textfield
    }

}





