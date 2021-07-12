package ucf.assignments;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class AddItemTest {

    @Test
    void getJsonArray() {
        AddItem test = new AddItem();
        String itemAddText = "Gardening";
        String descriptionBoxText = "Buy tools";
        String date = "2021-07-20";
        boolean isChecked = true;

        JSONArray jsonArray = new JSONArray();
        JSONArray checker = new JSONArray();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Task", "Gardening");
        jsonObject.put("Description", "Buy tools");
        jsonObject.put("Date", "2021-07-20");
        jsonObject.put("Complete", true);

        checker.put(jsonObject);


        JSONArray testJsonArray = test.getJsonArray(itemAddText, descriptionBoxText, date, isChecked, jsonArray);
        boolean testJsonArrayEle = testJsonArray.toString().contains("Gardening");
        boolean checkEle = checker.toString().contains("Gardening");

        Assert.assertEquals(testJsonArrayEle, checkEle);

    }

    @Test
    void addToFile() {
        String userPath = System.getProperty("user.dir");
        String directory = userPath + "\\ToDoList.json";

        Path path = Paths.get(directory);
        boolean isFile = false;
        if (Files.exists(path)) {
            isFile = true;
            assert(isFile);
        }
    }

    @Test
    void getDirectory() throws IOException {
        String userPath = System.getProperty("user.dir");
        String directory = userPath + "\\ToDoList.json";

        String actual = AddItem.getDirectory();

        Assert.assertEquals(directory, actual);
    }


        @Test
        void addItemClicked() {
            // create a json object with all values for an item (Date, description...)
            // addItem(json object)
            // isItem = check json file for item
            // assertTrue(isItem);
        }

        @Test
        void removeItemClicked() {
            //  create a json object with all values for an item (Date, description...)
            // removeItem(json object)
            // isItem = check json file for item
            // assertNotTrue(isItem)

        }

        @Test
        void allItemsButtonClicked() {
            // get all values from Json file
            // put into list
            // assertEquals(listValues, allValues())
        }

        @Test
        void completedItemsClicked() {
            // get all completed values from Json file
            // put into list
            // assertEquals(completedValuesList, completedItems())
        }

        @Test
        void incompleteItemsClicked() {
            // get all completed values from Json file
            // put into list
            // assertEquals(incompleteValuesList, incompleteItems())
        }

        @Test
        void saveListClicked() {
            // Load all values from Json file
            // into listFromJson
            // listValues = saveList()
            // assertEquals(listValues, listFromJson)
        }

        @Test
        void setTitle() {
            // get data from text field into String title
            // setTitle()
            // assertEquals(setTitle(), title)
        }

        @Test
        void loadList() {
            // load all items in a list from Json file
            // into itemsListFromJson
            // listValues = loadList()
            // assertEquals(listValues, itemsListFromJson)
        }

        @Test
        void getTitle() {
            // create a json object with all values for an item (Date, description...)
            // String title;
            // assertEquals(getTitle(), title)
        }

        @Test
        void checkIfMarked(){
            // get a json object with all values for an item (Date, description...)
            // boolean saved = savelist(json object)
            // boolean check = json File value of item
            // assertEquals(saved, check)
        }

        @Test
        void checkIfItemEdited(){
             // get a json object with all values for an item (Date, description...)
            // String saved = savelist(json object)
            // String check = json File value of item
            // assertEquals(saved, check)
        }

        @Test
        void checkIfDueDateEdited(){
            // get a json object with all values for an item (Date, description...)
            // String saved = savelist(json object)
            // String check = json File value of item
            // assertEquals(saved, check)
        }

        @Test
        void checkIfDueDescriptionEdited(){
            // get a json object with all values for an item (Date, description...)
            // String saved = savelist(json object)
            // String check = json File value of item
            // assertEquals(saved, check)


    }
}