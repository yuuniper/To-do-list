/*
 *
 *  *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  *  Copyright 2021 Alice Yu
 *
 */

package ucf.assignments;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ResourceBundle;

public class HomePageController implements Initializable{

    AddItem makeItem = new AddItem();
    JSONArray jsonArray = new JSONArray();
    MyListView myView = new MyListView();

    @FXML
    private TextArea descriptionBox;

    @FXML
    private DatePicker dateBox;

    @FXML
    private TextField itemAdd;

    @FXML
    private CheckBox initialCheckBox;

    @FXML
    private TextField dueDateBox;

    @FXML
    private ComboBox<String> viewingOptions;

    @FXML
    private Label displayMsg;


    @FXML
    private Label errorMsg;

    @FXML
    private ListView listItems;



    FileChooser fileChooser = new FileChooser();

    ListProperty<String> listProperty = new SimpleListProperty<>();

    @FXML
    void addButtonClicked(MouseEvent event) throws IOException {
        addItemToJsonFile();
    }
    @FXML
    void addItemClearButtonClicked(MouseEvent event) {
        clearBoxes(itemAdd, descriptionBox, dateBox, initialCheckBox, displayMsg, errorMsg);
    }

    public void clearBoxes(TextField itemAdd, TextArea descriptionBox, DatePicker dateBox,
                           CheckBox initialCheckBox, Label displayMsg, Label errorMsg){
        // Clear text fields
        itemAdd.setText("");
        descriptionBox.setText("");
        dateBox.setValue(null);
        initialCheckBox.setSelected(false);
        displayMsg.setText("");
        errorMsg.setText("");
    }
    public void addItemToJsonFile() throws IOException {

        // get checkbox status
        boolean isChecked = initialCheckBox.isSelected();

        //validate input
        boolean checkValid = makeItem.validateInput(descriptionBox.getText(), dateBox.getValue());
        System.out.println("validating input");
        if (checkValid == true){
            // get Date
            String myDate = getDate(dateBox.getValue().toString(), displayMsg);

            // make item in Json File
            makeItem.getItem(itemAdd.getText(), descriptionBox.getText(), myDate, isChecked, jsonArray);
            // Display to List View
            listItems.getItems().add(itemAdd.getText());
            // Clear text fields
            itemAdd.setText("");
            descriptionBox.setText("");
            dateBox.getEditor().clear();
            initialCheckBox.setSelected(false);
            displayMsg.setText("");
            errorMsg.setText("");
        } else {
            errorMsg.setText("Invalid Input");
            System.out.println("I'm being accessed");
        }

    }

    public String getDate(String date, Label displayMsg) {

        boolean valid = false;
        do {
            try {

                // ResolverStyle.STRICT for 30, 31 days checking, and also leap year.
                LocalDate.parse(date, DateTimeFormatter.ofPattern("uuuu-MM-dd")
                        .withResolverStyle(ResolverStyle.STRICT)
                );

                valid = true;

            } catch (DateTimeParseException e) {
                displayMsg.setText("Retry");
                e.printStackTrace();
                System.out.println("Not valid date");
            } catch(NullPointerException e){
                displayMsg.setText("Retry");
                System.out.println("Not Valid date");
                e.printStackTrace();
            } catch(Exception e){
                displayMsg.setText("Retry");
                System.out.println("Not Valid date");
                e.printStackTrace();
            }
        } while (valid == false);
        return date;
    }


    @FXML
    void clearListClicked(MouseEvent event) {
        clearList(jsonArray);
        clearListView();
        clearBoxes(itemAdd, descriptionBox, dateBox, initialCheckBox, displayMsg, errorMsg);

    }

    public JSONArray clearList(JSONArray jsonArray) {
        JSONArray checkArray = removeList();
        this.jsonArray = new JSONArray();

        return jsonArray;
    }


    public void clearListView() {
        // Clear all items from list view
        listItems.getItems().clear();
    }

    public JSONArray removeList(){
        if (jsonArray != null) {
            // make a new jsonArray element to clear out the old one
                JSONArray jsonArray = new JSONArray();
                try {
                    // clear json file
                    makeItem.addToFile(jsonArray);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        return jsonArray;
        }



    @FXML
    void removeButtonClicked(MouseEvent event) throws IOException {

        Object itemSelected = listItems.getSelectionModel().getSelectedItem();
        removeFromJsonFile(itemSelected);
    }

    public void removeFromJsonFile(Object itemSelected){
        System.out.println(itemSelected);
        // Search for object in JSON Array
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++){

                JSONObject jsn = jsonArray.getJSONObject(i);

                String isTask = jsn.getString("Task");
                // Remove from JSON Array and JSON file
                if (isTask.equals(itemSelected)){
                    jsonArray.remove(i);
                    try {
                        makeItem.addToFile(jsonArray);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // Clear text fields
                    clearBoxes(itemAdd, descriptionBox, dateBox, initialCheckBox, displayMsg, errorMsg);

                    listItems.getItems().remove(itemSelected);
                }
            }
        }

    }


    @FXML
    void editButtonClicked(MouseEvent event) throws IOException {
        editList();
    }

    public void editList() {
        // add edited item
        try {
            addItemToJsonFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // delete old item
        Object itemSelected = listItems.getSelectionModel().getSelectedItem();

        removeFromJsonFile(itemSelected);
    }

    @FXML
    void selectItemClicked(MouseEvent event) {
        System.out.println("Selected Item being clicked");
        displaySelectedItem();
    }

    @FXML
    void loadClicked(ActionEvent event) {
        clearBoxes(itemAdd, descriptionBox, dateBox, initialCheckBox, displayMsg, errorMsg);
        clearListView();
        FileMaker makeFile = new FileMaker();
        jsonArray = makeFile.loadFile();
        try {
            makeItem.addToFile(jsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MyListView.displayAllItems(jsonArray, listItems);
    }

    @FXML
    void saveClicked(ActionEvent event) {
        try {
            FileMaker.saveList(jsonArray);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void displaySelectedItem(){
        Object itemSelected = listItems.getSelectionModel().getSelectedItem();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++){

                JSONObject jsn = jsonArray.getJSONObject(i);

                String isTask = jsn.getString("Task");
                if (isTask.equals(itemSelected)){
                    itemAdd.setText(isTask);
                    String description = (String) jsn.get("Description");
                    descriptionBox.setText(description);

                    String date = jsn.getString("Date");
                    //dueDateBox.setText(date);
                    displayMsg.setText(date);

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate lt = LocalDate.parse(date, formatter);
                    dateBox.setValue(lt);
                    //dateBox.setValue(LocalDate.of(date));

                    boolean checkbox = (boolean) jsn.get("Complete");
                    initialCheckBox.setSelected(checkbox);

                }
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Combo button
        ObservableList<String> list = FXCollections.observableArrayList("All Items", "Completed Items", "Incomplete Items");
        viewingOptions.setItems(list);
        viewingOptions.setValue("All Items");


        String userPath = System.getProperty("user.dir");
        String directory = userPath + "\\ToDoList.json";

        fileChooser.setInitialDirectory(new File(directory));

    }

    public void addPreviousItems() throws FileNotFoundException {
        AddItem myItem = new AddItem();
        String directory = "";
        try {
            directory = myItem.getDirectory();
        } catch (IOException e) {
            e.printStackTrace();
        }
        jsonArray = myItem.addPreviousItemsFromJsonFile(directory);
    }

    @FXML
    public void viewButtonClicked(ActionEvent event) {
        String selection  = viewingOptions.getSelectionModel().getSelectedItem().toString();
        MyListView.gotoview(selection, jsonArray, listItems);
        clearBoxes(itemAdd, descriptionBox, dateBox, initialCheckBox, displayMsg, errorMsg);
    }

    @FXML
    public void sortButtonClicked(MouseEvent event) {
        JSONArray sorted =  MyListView.sort(jsonArray, listItems);
    }
}


