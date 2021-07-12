/*
 *
 *  *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  *  Copyright 2021 Alice Yu
 *
 */
package ucf.assignments;
import org.json.JSONObject;

import java.io.*;

import org.json.simple.parser.*;
import org.json.*;



public class AddItem {
    public void getItem(String itemAddText, String descriptionBoxText, String date, boolean isChecked, JSONArray jsonArray) throws IOException {

        // Make JsonArray
         jsonArray = getJsonArray(itemAddText, descriptionBoxText, date, isChecked, jsonArray);
         addToFile(jsonArray);
         getDirectory();
    }

    public JSONArray getJsonArray(String itemAddText, String descriptionBoxText, String date, boolean isChecked, JSONArray jsonArray) {
        System.out.println(itemAddText + descriptionBoxText + date + isChecked);

        JSONObject jsonObject = new JSONObject();


        jsonObject.put("Task", itemAddText);
        jsonObject.put("Description", descriptionBoxText);
        jsonObject.put("Date", date);
        jsonObject.put("Complete", isChecked);

        jsonArray.put(jsonObject);
        return jsonArray;
    }

    public void addToFile(JSONArray jsonArray) throws IOException {
        try {
            String directory = getDirectory();
            FileWriter file = new FileWriter(directory);
            file.write(jsonArray.toString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getDirectory() throws IOException {
        // Get Directory
        String userPath = System.getProperty("user.dir");
        String directory = userPath + "\\ToDoList.json";

        return directory;
    }
}
