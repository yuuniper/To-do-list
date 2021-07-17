package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyListViewTest {
    @FXML
    ListView listItems;


    @Test
    void gotoview_test_selection() {

        MyListView testMyListView = new MyListView();

        // Make a JSON array to test
        JSONArray testJsonArray = makeJSONArray();
        // Test selection
        String selection = testMyListView.gotoview("All Items", testJsonArray, listItems);
        assertEquals("All Items", selection);
    }

    private JSONArray makeJSONArray() {
        // helper function
        JSONArray checker = new JSONArray();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Task", "Gardening");
        jsonObject.put("Description", "Buy tools");
        jsonObject.put("Date", "2021-07-20");
        jsonObject.put("Complete", true);

        checker.put(jsonObject);
        return checker;
    }

    @Test
    void displayItems_check_Complete() {
        MyListView testMyListView = new MyListView();
        listItems.getItems().add("Hello");

        // Make a JSON array to test
        JSONArray testJsonArray = makeJSONArray();
        int counter =  testMyListView.displayItems(testJsonArray, listItems, true);
        assertEquals(1, counter);
    }

    @Test
    void displayItems_check_Incomplete() {
        MyListView testMyListView = new MyListView();
        listItems.getItems().add("Hello");

        // Make a JSON array to test
        JSONArray testJsonArray = makeJSONArray();
        int counter =  testMyListView.displayItems(testJsonArray, listItems, false);
        assertEquals(1, counter);
    }

    @Test
    void displayAllItems() {

        MyListView testMyListView = new MyListView();
        listItems.getItems().add("Hello");

        // Make a JSON array to test
        JSONArray testJsonArray = makeJSONArray();
        int counter =  testMyListView.displayAllItems(testJsonArray, listItems);
        assertEquals(1, counter);

    }

    @Test
    void sort() {
        MyListView testMyListView = new MyListView();
        listItems.getItems().add("Hello");

        // Make a JSON array to test
        JSONArray testJsonArray = makeJSONArray();
        JSONArray sorted = testMyListView.sort(testJsonArray, listItems);

    }

    @Test
    void getSort() {
        MyListView testMyListView = new MyListView();
        listItems.getItems().add("Hello");

        // Make a JSON array to test
        JSONArray testJsonArray = makeJSONArray();
        //int counter =  testMyListView.displayAllItems(testJsonArray, listItems);
        //assertEquals(1, counter);
    }
}