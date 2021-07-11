/*
 *
 *  *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  *  Copyright 2021 Alice Yu
 *
 */

package assignments;

import org.junit.jupiter.api.Test;

class HomePageControllerTest {

    @Test
    void addListClicked() {
        // set text fields with a random task, date, title, date, and checkbox status
        // get values
        // addNewList  = addList(JsonObject)
        // assert(addNewList, JsonObject)

    }

    @Test
    void removeListClicked() {
        // Create random to do list with appropriate values
        // get values
        // removeList(jsonObject)
        // assertNotEquals(removeList.getValue(JsonFile))
    }

    @Test
    void editListClicked() {
        // Create a random list
        // get values
        // editList(jsonObject)
        // assertTrue(editList.getValue(JsonFile))

    }

    @Test
    void loadListView() {
         // create a list with all the info from the Json File
        // checklist;
        // listValues = loadList();
        // assert(list, checklist);
    }

    @Test
    void saveListClicked() {
        // Create a random list
        // get values
        // saveList(jsonObject)
        // assertTrue(SaveList.getValue(JsonFile))
    }
}