package ucf.assignments;

import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GetInfo {
    public String getDate(DatePicker dateBox) {
        // Don't need
            LocalDate myDate = dateBox.getValue();

            String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("YYYY.MM.DD"));
        System.out.println(myFormattedDate);
        return myFormattedDate;
    }


    public boolean getChecked(CheckBox initialCheckBox) {
        return initialCheckBox.isSelected();
    }
}
