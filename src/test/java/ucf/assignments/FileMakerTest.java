package ucf.assignments;

import org.json.JSONArray;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FileMakerTest {

    // Check loaded file and saved file


    @Test
    void check_loaded_file_by_parseJSONData_check_key() {
        FileMaker makeFile = new FileMaker();

        // Get Directory of Test file
        String userPath = System.getProperty("user.dir");

        String directory = userPath + "\\src\\test\\java\\ucf\\assignments\\TestFile.json";

        // Get JSON array from loaded file
        JSONArray jsonArrayTest = makeFile.parseJSONData(directory);

        // Check if Task is in file
        boolean testJsonArrayEle = jsonArrayTest.toString().contains("Party");
        boolean expected = true;

        assertEquals(expected, testJsonArrayEle);

    }

    @Test
    void check_loaded_file_by_parseJSONData_check_value() {
        FileMaker makeFile = new FileMaker();

        // Get Directory of Test file
        String userPath = System.getProperty("user.dir");
        String directory = userPath +"\\src\\test\\java\\ucf\\assignments\\TestFile.json";

        // Get JSON array from loaded file
        JSONArray jsonArrayTest = makeFile.parseJSONData(directory);

        // Check if Task is in file
        boolean testJsonArrayEle = jsonArrayTest.toString().contains("Call Bill");
        boolean expected = true;

        assertEquals(expected, testJsonArrayEle);

    }


    @Test
    void checkIfSavedFile(){
        // Check if file is saved
        String userPath = System.getProperty("user.dir");
        String directory = userPath + "\\src\\test\\java\\ucf\\assignments\\TestFile.json";

        Path path = Paths.get(directory);
        boolean isFile = false;
        if (Files.exists(path)) {
            isFile = true;
            assert(isFile);
        }
    }

}