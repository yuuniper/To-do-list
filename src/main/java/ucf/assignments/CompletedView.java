package ucf.assignments;

import javafx.scene.control.ListView;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CompletedView {
    public static void gotoview(String selection, JSONArray jsonArray, ListView listItems) {
        if (selection.equals("All Items")){
            displayAllItems(jsonArray, listItems);
        }
        else if(selection.equals("Completed Items")){
            displayItems(jsonArray, listItems, true);
        }
        else{
            displayItems(jsonArray, listItems, false);
        }
    }

    public static void displayItems(JSONArray jsonArray, ListView listItems, boolean isComplete) {
        listItems.getItems().clear();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++){

                JSONObject jsn = jsonArray.getJSONObject(i);

                String item = jsn.getString("Task");
                Boolean isTask = jsn.getBoolean("Complete");
                if (isTask.equals(isComplete)){
                    listItems.getItems().add(item);
                }
            }
        }
    }

    public static void displayAllItems(JSONArray jsonArray, ListView listItems){

        listItems.getItems().clear();

        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsn = jsonArray.getJSONObject(i);

                String item = jsn.getString("Task");

                listItems.getItems().add(item);
            }
        }
    }
}
