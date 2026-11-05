# To-Do List (JavaFX)

A desktop to-do list app written for **COP3330 (Object-Oriented Programming), Summer 2021, at UCF** (Assignment 4, part 2; the design-only first part is [yu-cop3330-assignment4](https://github.com/yuuniper/yu-cop3330-assignment4)). This is archived coursework, kept for reference and not maintained.

## What it does

- Add, edit, and remove to-do items, each with a title, description, due date, and completed checkbox
- Filter the list to all, completed, or incomplete items
- Sort items by due date
- Clear the whole list
- Save the list to a JSON file and load it back

## Tools

- Java with JavaFX 16 (fetched automatically by the Gradle JavaFX plugin)
- Gradle (the included wrapper uses 8.14.3, which runs on JDK 17 through 21)
- Gson, org.json, and json-simple for JSON handling
- JUnit 5
- PlantUML class diagram in `uml/ToDoList.puml`

## Build, test, and run

```bash
./gradlew build
./gradlew run
```

On Windows, use `gradlew.bat` instead of `./gradlew`.

Note: a couple of default file paths in the code use Windows-style separators (`\ToDoList.json`), so those defaults only resolve on Windows. Saving and loading through the file chooser works on any platform.

## Usage

- **Add an item:** click "+", enter a title, description, and date, tick the checkbox if it is already complete, then click "Add".
- **Edit an item:** select it in the list; its fields appear. Change them and click "Edit" to save.
- **Remove an item:** select it and click "-".
- **Clear the list:** click "Clear List".
- **Filter:** choose all, completed, or incomplete items from the drop-down.
- **Sort by date:** click "Sort".
- **Save:** File > Save, then name the file and save it as `.json`.
- **Load:** File > Load, then pick a previously saved `.json` file.

_Dedicated to Rey._
