package ucf.assignments;

import javafx.scene.control.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class MyListView {
    public static String gotoview(String selection, JSONArray jsonArray, ListView listItems) {
        if (selection.equals("All Items")){
            int count = displayAllItems(jsonArray, listItems);
        }
        else if(selection.equals("Completed Items")){
            int count = displayItems(jsonArray, listItems, true);
        }
        else{
            // if selection equals Incomplete
            int count = displayItems(jsonArray, listItems, false);
        }

        return selection;
    }

    public static int displayItems(JSONArray jsonArray, ListView listItems, boolean isComplete) {
        // Display either incomplete or complete items
        listItems.getItems().clear();
        int counter = 0;
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++){

                JSONObject jsn = jsonArray.getJSONObject(i);

                String item = jsn.getString("Task");
                Boolean isTask = jsn.getBoolean("Complete");
                if (isTask.equals(isComplete)){
                    listItems.getItems().add(item);
                    counter++;
                }
            }
        }
        return counter;
    }

    public static int displayAllItems(JSONArray jsonArray, ListView listItems){

        listItems.getItems().clear();
        int counter = 0;

        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsn = jsonArray.getJSONObject(i);

                String item = jsn.getString("Task");

                listItems.getItems().add(item);
                counter++;
            }
        }
        return counter;
    }

    public static JSONArray sort(JSONArray jsonArray, ListView listItems) {
        listItems.getItems().clear();
        JSONArray sortArray = getSort(jsonArray);

        if (jsonArray != null) {
            for (int i = 0; i < sortArray.length(); i++) {

                JSONObject jsn = sortArray.getJSONObject(i);

                String item = jsn.getString("Task");

                listItems.getItems().add(item);
            }
        }
        return sortArray;
    }

    public static JSONArray getSort(JSONArray jsonArray) {

        JSONArray jsonArr = new JSONArray(jsonArray);
        JSONArray sortedJsonArray = new JSONArray();

        // Add to a list
        List<JSONObject> jsonValues = new ArrayList<JSONObject>();
        for (int i = 0; i < jsonArr.length(); i++) {
            jsonValues.add(jsonArr.getJSONObject(i));
        }
        // Sort by List
        Collections.sort( jsonValues, new Comparator<JSONObject>() {

            private static final String KEY_NAME = "Date";

            @Override
            public int compare(JSONObject a, JSONObject b) {
                // Compare by Dates
                String valA = new String();
                String valB = new String();

                try {
                    valA = (String) a.get(KEY_NAME);
                    valB = (String) b.get(KEY_NAME);
                }
                catch (JSONException e) {
                    //do something
                }

                return valA.compareTo(valB);
            }
        });

        for (int i = 0; i < jsonArr.length(); i++) {
            // Put values into sorted Array
            sortedJsonArray.put(jsonValues.get(i));
        }
        System.out.println(sortedJsonArray);
        return sortedJsonArray;
    }
}
