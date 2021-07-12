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


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HomePageController {

    AddItem makeItem = new AddItem();
    JSONArray jsonArray = new JSONArray();
    //ListViewController listView = new ListViewController();

    @FXML
    private TextArea descriptionBox;

    @FXML
    private DatePicker dateBox;

    @FXML
    private TextField itemAdd;

    @FXML
    private CheckBox initialCheckBox;

    @FXML
    private TableColumn<TableData, Boolean> checkedColumn;


    @FXML
    private TableColumn<TableData, String> itemColumn;

    @FXML
    private TableView<TableData> entireTable;

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



    private void addItemToJsonFile() throws IOException {
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


