/*
 *
 *  *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  *  Copyright 2021 Alice Yu
 *
 */
package ucf.assignments;
import javafx.scene.control.DatePicker;
import org.json.JSONObject;

import java.io.*;
import java.time.LocalDate;

import org.json.simple.parser.*;
import org.json.*;



public class AddItem {

    public JSONArray addPreviousItemsFromJsonFile(String directory) throws FileNotFoundException {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = new JSONArray();

        try (FileReader reader = new FileReader(getDirectory()))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

             jsonArray = (JSONArray) obj;
            System.out.println(jsonArray);

            //Iterate over array
            jsonArray.forEach( item -> parseItemObject( (JSONObject) item ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }
    private void parseItemObject(JSONObject item)
    {
        String task = (String) item.get("Task");
        System.out.println(task);

        boolean isChecked = (Boolean) item.get("Checked");
        System.out.println(isChecked);
        String description = (String) item.get("Description");
        System.out.println(description);
        DatePicker date = (DatePicker) item.get("Date");
        System.out.println(date);
    }

    public void getItem(String itemAddText, String descriptionBoxText, String date, boolean isChecked, JSONArray jsonArray) throws IOException {

        // Make JsonArray
        jsonArray = getJsonArray(itemAddText, descriptionBoxText, date, isChecked, jsonArray);

        String directory = addToFile(jsonArray);
    }

    public boolean validateInput(String descriptionBoxText, LocalDate date) {
        boolean checkValid = true;
        if(descriptionBoxText.length() < 1 || descriptionBoxText.length() > 256){
            System.out.println("Invalid length ");
            checkValid = false;
        }
        if (date == null){
            System.out.println("Not correct date");
            checkValid = false;
        }

        return checkValid;
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

    public String addToFile(JSONArray jsonArray) throws IOException {
        String directory = "";
        try {
            directory = getDirectory();
            FileWriter file = new FileWriter(directory);
            file.write(jsonArray.toString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return directory;
    }

    public String getDirectory() throws IOException {
        // Get Directory
        String userPath = System.getProperty("user.dir");
        String directory = userPath + "\\ToDoList.json";

        return directory;
    }

}


