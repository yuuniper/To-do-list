package ucf.assignments;

import org.json.JSONArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileMakerTest {


    @Test
    void parseJSONData_check_key() {
        FileMaker makeFile = new FileMaker();

        // Get Directory of Test file
        String userPath = System.getProperty("user.dir");
        String directory = userPath + "\\TestFile.json";

        // Get JSON array from loaded file
        JSONArray jsonArrayTest = makeFile.parseJSONData(directory);

        // Check if Task is in file
        boolean testJsonArrayEle = jsonArrayTest.toString().contains("Party");
        boolean expected = true;

        assertEquals(expected, testJsonArrayEle);

    }

    @Test
    void parseJSONData_check_value() {
        FileMaker makeFile = new FileMaker();

        // Get Directory of Test file
        String userPath = System.getProperty("user.dir");
        String directory = userPath + "\\TestFile.json";

        // Get JSON array from loaded file
        JSONArray jsonArrayTest = makeFile.parseJSONData(directory);

        // Check if Task is in file
        boolean testJsonArrayEle = jsonArrayTest.toString().contains("Call Bill");
        boolean expected = true;

        assertEquals(expected, testJsonArrayEle);

    }
}