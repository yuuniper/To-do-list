package ucf.assignments;

import javafx.scene.control.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class MyListView {
    public static void gotoview(String selection, JSONArray jsonArray, ListView listItems) {
        int counter = 0;
        if (selection.equals("All Items")) {
            counter = displayAllItems(jsonArray, listItems);
        } else if (selection.equals("Completed Items")) {
            counter = displayItems(jsonArray, listItems, true);
        } else {
            // if selection equals Incomplete
            counter = displayItems(jsonArray, listItems, false);
        }

        counter = gotoViewTestFunction(jsonArray, selection);
    }

    public static int displayItems(JSONArray jsonArray, ListView listItems, boolean isComplete) {
        listItems.getItems().clear();
        int counter = 0;
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsn = jsonArray.getJSONObject(i);

                String item = jsn.getString("Task");
                Boolean isTask = jsn.getBoolean("Complete");
                if (isTask.equals(isComplete)) {
                    listItems.getItems().add(item);
                    counter++;
                }
            }
        }
        return counter;
    }

    public static int displayAllItems(JSONArray jsonArray, ListView listItems) {

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
        Collections.sort(jsonValues, new Comparator<JSONObject>() {

            private static final String KEY_NAME = "Date";

            @Override
            public int compare(JSONObject a, JSONObject b) {
                // Compare by Dates
                String valA = new String();
                String valB = new String();

                try {
                    valA = (String) a.get(KEY_NAME);
                    valB = (String) b.get(KEY_NAME);
                } catch (JSONException e) {
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

    public static int gotoViewTestFunction(JSONArray jsonArray, String selection) {
        // This function mirrors the above "gotoview" function
        // The FXML element is integral to the function
        // But since JUnit testing does not tolerate FXML elements,
        // I've just decided to copy the function instead
        int counter = 0;
        if (selection.equals("All Items")) {
            if (jsonArray != null) {
                System.out.println(jsonArray.length());
                for (int i = 0; i < jsonArray.length(); i++) {
                    System.out.println("I am being accessed");
                    JSONObject jsn = jsonArray.getJSONObject(i);
                    String item = jsn.getString("Task");
                    counter++;
                }
            }
            return counter;
        } else if (selection.equals("Completed Items")) {
            if (jsonArray != null) {
                System.out.println(jsonArray.length());
                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsn = jsonArray.getJSONObject(i);

                    String item = jsn.getString("Task");
                    Boolean isTask = jsn.getBoolean("Complete");
                    if (isTask.equals(true)) {
                        counter++;

                    }
                }
                return counter;
            }
        } else {
            // if selection equals Incomplete
            if (jsonArray != null) {
                System.out.println(jsonArray.length());
                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsn = jsonArray.getJSONObject(i);

                    String item = jsn.getString("Task");
                    Boolean isTask = jsn.getBoolean("Complete");
                    if (isTask.equals(false)) {
                        counter++;

                    }
                }
            }
        }
        return counter;

    }

    public static JSONArray sortTester(JSONArray jsonArray) {
        // This function mirrors the above "sort" function
        // The FXML element is integral to the function
        // But since JUnit testing does not tolerate FXML elements,
        // I've just decided to copy the function instead without the FXML elements
        JSONArray sortArray = getSort(jsonArray);

        if (jsonArray != null) {
            for (int i = 0; i < sortArray.length(); i++) {

                JSONObject jsn = sortArray.getJSONObject(i);

                String item = jsn.getString("Task");
            }
        }
        return sortArray;
    }
}
