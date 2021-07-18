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
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import static org.junit.Assert.*;

class AddItemTest {

    @Test
    void getJsonArray_check_if_same() {
        // Check if able to add item to JSON Array
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
    void addToFile_check_file_path() {
        // Check if file is added through path
        String userPath = System.getProperty("user.dir");
        String directory = userPath + "\\src\\test\\java\\ucf\\assignments\\TestFile.json";

        Path path = Paths.get(directory);
        boolean isFile = false;
        if (Files.exists(path)) {
            isFile = true;
            assert(isFile);
        }
    }

    @Test
    void getDirectory_check_file_path() throws IOException {
        // directory check
        String userPath = System.getProperty("user.dir");
        String directory = userPath + "\\ToDoList.json";

        String actual = AddItem.getDirectory() ;

        Assert.assertEquals(directory, actual);
    }
    @Test
    void validate_date_true(){
        // check if date is valid
        AddItem test = new AddItem();
        boolean checkValid = test.validateInput("Hello", LocalDate.now());
        assertEquals(true, true);
    }

    @Test
    void validate_description_true(){
        // check if description is valid
        AddItem test = new AddItem();
        boolean checkValid = test.validateInput("Butterfliesss", LocalDate.now());
        assertEquals(true, true);
    }

    @Test
    void validate_date_not_true(){
        // check if date is valid
        AddItem test = new AddItem();
        boolean checkValid = test.validateInput("Hello", null);
        assertEquals(false, false);
    }

    @Test
    void validate_description_not_true(){
        // check if description is valid
        AddItem test = new AddItem();
        boolean checkValid = test.validateInput("", LocalDate.now());
        assertEquals(false, false);
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
    void edit_description(){
        AddItem test = new AddItem();
        String itemAddText = "Gardening";
        String descriptionBoxText = "Buy Pots";
        String date = "2021-07-20";
        boolean isChecked = true;

        JSONArray checker = makeJSONArray();
        JSONArray testArray = test.getJsonArray(itemAddText, descriptionBoxText, date, isChecked, checker);

        String checkString = checker.toString();
        Assert.assertNotSame(checkString, testArray.toString());
    }

    @Test
    void edit_date(){
        AddItem test = new AddItem();
        String itemAddText = "Gardening";
        String descriptionBoxText = "Buy Tools";
        String date = "2021-06-30";
        boolean isChecked = true;

        JSONArray checker = makeJSONArray();
        JSONArray testArray = test.getJsonArray(itemAddText, descriptionBoxText, date, isChecked, checker);

        String checkString = checker.toString();
        Assert.assertNotSame(checkString, testArray.toString());
    }

    @Test
    void check_if_marked_off_or_not(){
        AddItem test = new AddItem();
        String itemAddText = "Gardening";
        String descriptionBoxText = "Buy Tools";
        String date = "2021-06-30";
        boolean isChecked = false;

        JSONArray checker = makeJSONArray();
        JSONArray testArray = test.getJsonArray(itemAddText, descriptionBoxText, date, isChecked, checker);

        String checkString = checker.toString();
        Assert.assertNotSame(checkString, testArray.toString());
    }
}