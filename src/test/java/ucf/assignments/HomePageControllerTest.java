/*
 *
 *  *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  *  Copyright 2021 Alice Yu
 *
 */

package ucf.assignments;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ucf.assignments.HomePageController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class HomePageControllerTest {
    JSONArray jsonArray = new JSONArray();
    JSONArray checker = new JSONArray();

    @Test
    void addItemToJsonFile_check_if_added() throws IOException {
        // Check if added item is in JSON Array
        /*HomePageController test = new HomePageController();
        test.addItemToJsonFile();

        AddItem addItem = new AddItem();
        String itemAddText = "Gardening";
        String descriptionBoxText = "Buy tools";
        String date = "2021-07-20";
        boolean isChecked = true;

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Task", "Gardening");
        jsonObject.put("Description", "Buy tools");
        jsonObject.put("Date", "2021-07-20");
        jsonObject.put("Complete", true);

        checker.put(jsonObject);
        JSONArray testJsonArray = addItem.getJsonArray(itemAddText, descriptionBoxText, date, isChecked, jsonArray);
        boolean testJsonArrayEle = testJsonArray.toString().contains("Gardening");
        boolean checkEle = checker.toString().contains("Gardening");

        Assert.assertEquals(testJsonArrayEle, checkEle);*/


    }

    public JSONArray  makeJsonArray(){
        // helper function to addItemToJsonFile_check_if_added
        AddItem test = new AddItem();
        String itemAddText = "Gardening";
        String descriptionBoxText = "Buy tools";
        String date = "2021-07-20";
        boolean isChecked = true;

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Task", "Gardening");
        jsonObject.put("Description", "Buy tools");
        jsonObject.put("Date", "2021-07-20");
        jsonObject.put("Complete", true);

        checker.put(jsonObject);
        JSONArray testJsonArray = test.getJsonArray(itemAddText, descriptionBoxText, date, isChecked, jsonArray);
        return testJsonArray;
    }

    @Test
    void removeList_check() {
        HomePageController test = new HomePageController();
        makeJsonArray();
        JSONArray clear = test.removeList();

        boolean testJsonArrayEle = clear.toString().contains("Gardening");
        boolean checkEle = checker.toString().contains("Gardening");

        Assert.assertNotSame(testJsonArrayEle, checkEle);

    }


    @Test
    void addItemClicked() {
        // create a json object with all values for an item (Date, description...)
        // addItem(json object)
        // isItem = check json file for item
        // assertTrue(isItem);
    }

    @Test
    void removeItemClicked() {
        //  create a json object with all values for an item (Date, description...)
        // removeItem(json object)
        // isItem = check json file for item
        // assertNotTrue(isItem)

    }

    @Test
    void allItemsButtonClicked() {
        // get all values from Json file
        // put into list
        // assertEquals(listValues, allValues())
    }

    @Test
    void completedItemsClicked() {
        // get all completed values from Json file
        // put into list
        // assertEquals(completedValuesList, completedItems())
    }

    @Test
    void incompleteItemsClicked() {
        // get all completed values from Json file
        // put into list
        // assertEquals(incompleteValuesList, incompleteItems())
    }

    @Test
    void saveListClicked() {
        // Load all values from Json file
        // into listFromJson
        // listValues = saveList()
        // assertEquals(listValues, listFromJson)
    }

    @Test
    void setTitle() {
        // get data from text field into String title
        // setTitle()
        // assertEquals(setTitle(), title)
    }

    @Test
    void loadList() {
        // load all items in a list from Json file
        // into itemsListFromJson
        // listValues = loadList()
        // assertEquals(listValues, itemsListFromJson)
    }

    @Test
    void getTitle() {
        // create a json object with all values for an item (Date, description...)
        // String title;
        // assertEquals(getTitle(), title)
    }

    @Test
    void checkIfMarked(){
        // get a json object with all values for an item (Date, description...)
        // boolean saved = savelist(json object)
        // boolean check = json File value of item
        // assertEquals(saved, check)
    }

    @Test
    void checkIfItemEdited(){
        // get a json object with all values for an item (Date, description...)
        // String saved = savelist(json object)
        // String check = json File value of item
        // assertEquals(saved, check)
    }

    @Test
    void checkIfDueDateEdited(){
        // get a json object with all values for an item (Date, description...)
        // String saved = savelist(json object)
        // String check = json File value of item
        // assertEquals(saved, check)
    }

    @Test
    void checkIfDueDescriptionEdited(){
        // get a json object with all values for an item (Date, description...)
        // String saved = savelist(json object)
        // String check = json File value of item
        // assertEquals(saved, check)


    }
}