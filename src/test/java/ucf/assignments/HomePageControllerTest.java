/*
 *
 *  *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  *  Copyright 2021 Alice Yu
 *
 */

package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ucf.assignments.HomePageController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import static org.junit.Assert.*;

class HomePageControllerTest {
    JSONArray jsonArray = new JSONArray();
    JSONArray checker = new JSONArray();

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

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("Task", "Picnic");
        jsonObject2.put("Description", "Buy Sandwiches, Buy Lillies");
        jsonObject2.put("Date", "2021-07-14");
        jsonObject2.put("Complete", false);

        checker.put(jsonObject2);
        JSONArray testJsonArray = test.getJsonArray(itemAddText, descriptionBoxText, date, isChecked, jsonArray);
        return testJsonArray;
    }

    @Test
    void removeList_check() {
        // Test to see if able to remove an item from a list
        HomePageController test = new HomePageController();
        makeJsonArray();
        JSONArray clear = test.removeList();

        boolean testJsonArrayEle = clear.toString().contains("Gardening");
        boolean checkEle = checker.toString().contains("Gardening");

        Assert.assertNotSame(testJsonArrayEle, checkEle);

    }

    @Test
    void clearAllItemsOffList_check(){
        // Check if All Items are cleared
        HomePageController test = new HomePageController();
        // Make JSON array
        JSONArray jsonArray = checker;
        JSONArray testArray = test.clearList(jsonArray);
        // Check if either contain element
        boolean testJsonArrayEle = testArray.toString().contains("Picnic");
        JSONArray clear = new JSONArray();
        boolean checkEle = clear.toString().contains("Picnic");

        assertEquals(testJsonArrayEle, checkEle);
    }

}