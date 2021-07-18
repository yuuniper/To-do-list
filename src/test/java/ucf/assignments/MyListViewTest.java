package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyListViewTest {
    JSONArray checker = new JSONArray();

    private JSONArray makeJSONArray() {
        // helper function
        JSONArray checker = new JSONArray();

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

        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("Task", "Swimming");
        jsonObject3.put("Description", "Bring Goggles");
        jsonObject3.put("Date", "2021-07-18");
        jsonObject3.put("Complete", false);

        checker.put(jsonObject3);
        return checker;
    }

    @Test
    void displayItems_check_Complete() {
        MyListView testMyListView = new MyListView();
        // Make a Test JSON Array
        JSONArray checker = makeJSONArray();
        // Count number of completed items
        int counter =  testMyListView.gotoViewTestFunction(checker, "Completed Items");
        assertEquals(1, counter);
    }

    @Test
    void displayItems_check_Incomplete() {
        MyListView testMyListView = new MyListView();
        // Make a Test JSON Array
        JSONArray checker = makeJSONArray();
        // Count number of incomplete items
        int counter =  testMyListView.gotoViewTestFunction(checker, "Incomplete Items");
        assertEquals(2, counter);
    }

    @Test
    void displayAllItems() {
        MyListView testMyListView = new MyListView();
        // Make a Test JSON Array
        JSONArray checker = makeJSONArray();
        // Count all items
        int counter =  testMyListView.gotoViewTestFunction(checker, "All Items");
        assertEquals(3, counter);
    }

    @Test
    void sort_tester() {
        MyListView testMyListView = new MyListView();
        // Make a Test JSON Array
        JSONArray checker = makeJSONArray();
        // Get Sorted Array
        JSONArray sorted = testMyListView.sortTester(checker);
        // Check new order
        String checkString = "[{\"Task\":\"Picnic\",\"Description\":\"Buy Sandwiches, Buy Lillies\",\"Complete\":false,\"Date\":\"2021-07-14\"},{\"Task\":\"Swimming\",\"Description\":\"Bring Goggles\",\"Complete\":false,\"Date\":\"2021-07-18\"},{\"Task\":\"Gardening\",\"Description\":\"Buy tools\",\"Complete\":true,\"Date\":\"2021-07-20\"}]";
        assertEquals(checkString, sorted.toString());
    }

}