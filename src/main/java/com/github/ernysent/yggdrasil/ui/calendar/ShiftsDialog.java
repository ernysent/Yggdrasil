package com.github.ernysent.yggdrasil.ui.calendar;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class ShiftsDialog extends Dialog {

  private DatePicker shiftDateField;
//  private Worker workerField = new Worker();

  public ShiftsDialog (){
    shiftDateField = new DatePicker();
    shiftDateField.setValue(LocalDate.now());
    HorizontalLayout fieldsLayout = new HorizontalLayout(shiftDateField);
    add(fieldsLayout);
  }

}
