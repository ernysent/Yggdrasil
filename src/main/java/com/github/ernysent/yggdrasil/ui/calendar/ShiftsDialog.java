package com.github.ernysent.yggdrasil.ui.calendar;

import com.github.ernysent.yggdrasil.domain.Worker;
import com.github.ernysent.yggdrasil.service.WorkerService;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import com.vaadin.flow.component.button.Button;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
@VaadinSessionScope
public class ShiftsDialog extends Dialog {

  private DatePicker shiftDateField  = new DatePicker();
  private Grid<Worker> workersGridField = new Grid<>(Worker.class);
  private Button closeButton = new Button("Close");
  private Button saveButton = new Button("Save");
  private Button addWorkerButton = new Button("add");
  private Button removeButton = new Button("remove");

  public ShiftsDialog(shiftWorkerDialog shiftWorkerDialog) {
    setWidth(800, Unit.PIXELS);
    Label dates = new Label("Data");
    shiftDateField.setValue(LocalDate.now());

    workersGridField.setColumns("firstName","lastName","position","phoneNumber");


    addWorkerButton.addClickListener(click ->{
      shiftWorkerDialog.open();

    });

    //Event

    closeButton.addClickListener(click ->{
      close();
    });




// Button location
    HorizontalLayout buttonsLayout = new HorizontalLayout(saveButton,closeButton);
    HorizontalLayout fieldsLayout = new HorizontalLayout(shiftDateField,addWorkerButton,removeButton);
    add(dates,fieldsLayout,workersGridField,buttonsLayout);
  }

}
