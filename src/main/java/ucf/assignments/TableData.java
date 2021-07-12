package ucf.assignments;

import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TableData {
    /*public String getDate(DatePicker dateBox) {
        // Don't need
            LocalDate myDate = dateBox.getValue();

            String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("YYYY.MM.DD"));
        System.out.println(myFormattedDate);
        return myFormattedDate;
    }*/
    private String item;
    private boolean isChecked;

    public TableData(String item, boolean isChecked){
        this.item = item;
        this.isChecked = isChecked;
    }

    public String getItem(){
        return item;
    }

    public boolean getIsChecked(){
        return isChecked;
    }
}
