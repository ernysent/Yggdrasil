package com.github.ernysent.yggdrasil.ui.calendar;

import com.github.ernysent.yggdrasil.domain.Worker;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import com.vaadin.flow.component.button.Button;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
@VaadinSessionScope
public class ShiftsDialog extends Dialog {

  private DatePicker shiftDateField  = new DatePicker("Data");
  private Grid<Worker> workersGridField = new Grid<>(Worker.class);


  public ShiftsDialog() {

    shiftDateField.setValue(LocalDate.now());

    workersGridField.setColumns("firstName","lastName");

    Button closeButton = new Button("Close");
    Button saveButton = new Button("Save");
    Button addWorkerButton = new Button("add");

    //Event

    closeButton.addClickListener(click ->{
      close();
    });




// Button location
    HorizontalLayout buttonsLayout = new HorizontalLayout(saveButton,closeButton);
    HorizontalLayout fieldsLayout = new HorizontalLayout(shiftDateField,workersGridField);
    add(fieldsLayout,addWorkerButton,buttonsLayout);
  }

}
