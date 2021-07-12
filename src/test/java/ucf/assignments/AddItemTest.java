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
    void getJsonArray_check_if_same() {
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
    void getDirectory_check_file_path() throws IOException {
        String userPath = System.getProperty("user.dir");
        String directory = userPath + "\\ToDoList.json";

        String actual = AddItem.getDirectory();

        Assert.assertEquals(directory, actual);
    }


}