/*
 *
 *  *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  *  Copyright 2021 Alice Yu
 *
 */

package ucf.assignments;

import com.google.gson.JsonElement;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HomePageController implements Initializable{

    AddItem makeItem = new AddItem();
    JSONArray jsonArray = new JSONArray();
    CompletedView myView = new CompletedView();

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
    // private ListView<String>listItems;
    private ListView listItems;

    ListProperty<String> listProperty = new SimpleListProperty<>();

    @FXML
    void addButtonClicked(MouseEvent event) throws IOException {
        addItemToJsonFile();
        //displayToList(jsonArray);

    }

    public void displayToList(JSONArray jsonArray){
        ArrayList<String> itemsList = new ArrayList<String>();

        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length();i++){
                JSONObject jsn = jsonArray.getJSONObject(i);

                String keyVal = jsn.getString("Task");
                itemsList.add(keyVal);
                System.out.println(keyVal);
                listItems.getItems().add(keyVal);
            }
        }

    }



    public void addItemToJsonFile() throws IOException {
        // get Date
        String myDate = dateBox.getValue().toString();
        // get checkbox status
        boolean isChecked = initialCheckBox.isSelected();

        // make item in Json File
        makeItem.getItem(itemAdd.getText(), descriptionBox.getText(), myDate, isChecked, jsonArray);
        // Display to List View
        listItems.getItems().add(itemAdd.getText());


        // Clear text fields
        itemAdd.setText("");
        descriptionBox.setText("");
        dateBox.getEditor().clear();
        initialCheckBox.setSelected(false);
    }

    //ObservableList<TableData> list = FXCollections.observableArrayList();

    /*@Override
    public void initialize(URL url, ResourceBundle rb){
        checkedColumn.setCellValueFactory(new PropertyValueFactory<TableData, Boolean>("checkedColumn"));
        itemColumn.setCellValueFactory(new PropertyValueFactory<TableData, String>("itemColumn"));
        //entireTable.setItems(list);
        entireTable.getColumns().add(checkedColumn);
        entireTable.getColumns().add(itemColumn);

        for (int i = 0; i < jsonArray.length(); i++){
            entireTable.getItems().add(new TableData("right", false));
        }
    }*/



    /*@Override
    public void initialize(URL url, ResourceBundle rb){
        ArrayList<String> itemsList = new ArrayList<String>();

        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length();i++){
                JSONObject jsn = jsonArray.getJSONObject(i);

                String keyVal = jsn.getString("Task");
                itemsList.add(keyVal);
                System.out.println(keyVal);
            }
        }
        listItems.itemsProperty().bind(listProperty);
        //listItems.getItems().addAll(itemsList);
        listProperty.set(FXCollections.observableArrayList(itemsList));

    }*/



    @FXML
    void clearListClicked(MouseEvent event) {
        JSONArray checkArray = removeList();
        clearListView();
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
    void completedItemsClicked(ActionEvent event) {

    }

    @FXML
    void removeButtonClicked(MouseEvent event) throws IOException {
        removeFromJsonFile();
    }

    public void removeFromJsonFile(){

        Object itemSelected = listItems.getSelectionModel().getSelectedItem();
        System.out.println(itemSelected);
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++){

                JSONObject jsn = jsonArray.getJSONObject(i);

                String isTask = jsn.getString("Task");
                if (isTask.equals(itemSelected)){
                    jsonArray.remove(i);
                    try {
                        makeItem.addToFile(jsonArray);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // Clear text fields
                    itemAdd.setText("");
                    descriptionBox.setText("");
                    dateBox.getEditor().clear();
                    initialCheckBox.setSelected(false);
                    dueDateBox.setText("");
                    listItems.getItems().remove(itemSelected);
                }
            }
        }

    }
    @FXML
    void uncompletedItemsClicked(ActionEvent event) {

    }

    @FXML
    void editButtonClicked(MouseEvent event) throws IOException {
        // add edited item
        addItemToJsonFile();
        // delete old item
        removeFromJsonFile();
    }

    @FXML
    void selectItemClicked(MouseEvent event) {
        displaySelectedItem();
    }

    @FXML
    void loadClicked(ActionEvent event) {
        FileMaker makeFile = new FileMaker();
        //jsonArray = makeFile.loadFile();
    }

    @FXML
    void saveClicked(ActionEvent event) {
        FileMaker makeFile = new FileMaker();
        //String path =
                makeFile.saveList(listItems);

    }

    public void displaySelectedItem(){
        //ArrayList<String> itemsList = new ArrayList<String>();
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
                    dueDateBox.setText(date);
                    dateBox.setValue(LocalDate.parse(date));

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

        // Loading from previously saved json File to list
        /*try {
            addPreviousItems();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

    }

    public void addPreviousItems() throws FileNotFoundException {
        jsonArray = AddItem.addPreviousItemsFromJsonFile();
    }

    public void viewButtonClicked(ActionEvent event) {
        String selection  = viewingOptions.getSelectionModel().getSelectedItem().toString();
        System.out.println(selection);
        CompletedView.gotoview(selection, jsonArray, listItems);
    }




}


