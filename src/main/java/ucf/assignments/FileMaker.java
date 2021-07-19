package ucf.assignments;

import com.google.gson.*;
import javafx.scene.control.DatePicker;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.JSONArray;

import org.json.simple.parser.JSONParser;
//import org.json.simple.JSONObject;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.*;


public class FileMaker {

    public JSONArray loadFile() {
        // Make fileChooser
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        // Launch
        File file = chooser.showOpenDialog(new Stage());

        // Get File Path and JSON Array
        JSONArray jsonArray = parseJSONData(file.getAbsolutePath());

        return jsonArray;
    }

    public JSONArray parseJSONData(String filePath)  {
        // This code is unnecessarily and painfully janky
        // But I couldn't parse it using a JSON parser since
        // it wouldn't convert between JSON Simple vs json.

        // Create JSON Array
        JSONArray jsonArray = new JSONArray();

        try {
            // create Gson instance
            Gson gson = new Gson();

            // Read in file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            JsonParser parser = new JsonParser();
            JsonObject object = parser.parse(br).getAsJsonObject();
            // Get To Do List Array
            JsonArray jsonArrayToDoList = object.get("To Do List").getAsJsonArray();

            // Add To Do List JsonArray to JSONArray data type
            for (JsonElement itemElement : jsonArrayToDoList){

                // Retrieve from jsonObject
                JsonObject itemObject = itemElement.getAsJsonObject();
                String date = itemObject.get("Date").getAsString();
                String item = itemObject.get("Task").getAsString();
                String description = itemObject.get("Description").getAsString();
                Boolean isChecked = itemObject.get("Complete").getAsBoolean();

                // Add to JSONArray
                JSONObject jsonObject = new JSONObject();

                jsonObject.put("Task", item);
                jsonObject.put("Description", description);
                jsonObject.put("Date", date);
                jsonObject.put("Complete", isChecked);

                jsonArray.put(jsonObject);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return jsonArray;
    }


    public static void saveList(JSONArray jsonArray) throws FileNotFoundException {
        // Save List to file
        FileChooser fileChooser = new FileChooser();
        // Add extensions
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
        fileChooser.getExtensionFilters().add(extFilter);
        // Show window
        File file = fileChooser.showSaveDialog(new Stage());

        // Put the jsonArray into a JSONObject to make it easier to handle
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("To Do List", jsonArray);


        if (file != null){
            // Write to JSON file
            String jsonObjectAsString = saveSystem(file, jsonObject.toString());
        }
    }

    public static String saveSystem(File file, String jsonObject){
        try {
            // Write to JSON file
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(jsonObject);

            // Flush printWriter
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
