package ucf.assignments;

import javafx.scene.control.ListView;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class CompletedView {
    public static void gotoview(String selection, JSONArray jsonArray, ListView listItems) {
        if (selection.equals("All Items")){
           // displayAllItems(jsonArray);
        }
        else if(selection.equals("Completed Items")){
            displayCompletedItems(jsonArray, listItems);
        }
        else{
            //displayIncompleteItems(jsonArray);
        }
    }

    public static void displayCompletedItems(JSONArray jsonArray, ListView listItems) {
        ArrayList<JSONObject> itemsList = new ArrayList<>();

        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++){

                JSONObject jsn = jsonArray.getJSONObject(i);

                Boolean isTask = jsn.getBoolean("Complete");
                if (isTask.equals("true")){
                    System.out.println(isTask);
                    itemsList.add(jsn);
                }
            }
            listItems.getItems().add(itemsList);
        }
    }
}
