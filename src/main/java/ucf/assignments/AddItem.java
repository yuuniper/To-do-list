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
        //Demo object = new Demo(1, "geeksforgeeks");
        //String filename = "file.ser";
        //String filename = getDirectory();
        // Serialization
        /*try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(jsonObject);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /*try
        {
            Writer output = null;
            String directory = getDirectory();
            File file = new File(directory);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            output = new BufferedWriter(new FileWriter(file));
            output.write(jsonObject.toString());
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    public static String getDirectory() throws IOException {
        // Get directory path
        //String userPath = System.getProperty("user.dir");
        //return userPath + "\\src\\ToDoList.json";
        // Get Directory
        String userPath = System.getProperty("user.dir");
        String directory = userPath + "\\ToDoList.json";

        // Write to file
        /*FileWriter myWriter = new FileWriter(directory);
        myWriter.write("Total of  names\n");
        myWriter.close();

        System.out.println("Hello");*/

        return directory;

    }
}
