package com.github.ernysent.yggdrasil.ui.calendar;

import com.github.ernysent.yggdrasil.domain.Shifts;
import com.github.ernysent.yggdrasil.domain.Worker;
import com.github.ernysent.yggdrasil.service.ShiftsService;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import com.vaadin.flow.component.button.Button;
import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@VaadinSessionScope
public class ShiftCreateDialog extends Dialog {

  private final DatePicker shiftDateField  = new DatePicker();
  private final Grid<Worker> workersGridField = new Grid<>(Worker.class);
  private final Button closeButton = new Button("Close");
  private final Button saveButton = new Button("Save");
  private final Button addWorkerButton = new Button("add");
  private final Button removeButton = new Button("remove");

  private Shifts shift;
  private final ShiftsGrid shiftsGrid;

  //@Autowired
  public ShiftCreateDialog(
      ShiftWorkersDialog shiftWorkerDialog,
      ShiftsGrid shiftsGrid,
      ShiftsService shiftsService
      ) {
    this.shiftsGrid = shiftsGrid;

    // Design
    setWidth(800, Unit.PIXELS);
    Label dates = new Label("Data");
    shiftDateField.setValue(LocalDate.now());

    workersGridField.setColumns("firstName","lastName","position","phoneNumber");
    // Button location
    HorizontalLayout buttonsLayout = new HorizontalLayout(saveButton,closeButton);
    HorizontalLayout fieldsLayout = new HorizontalLayout(shiftDateField,addWorkerButton,removeButton);
    add(dates,fieldsLayout,workersGridField,buttonsLayout);

    //Events
    addWorkerButton.addClickListener(click -> {
      shiftWorkerDialog.open();
    });

    closeButton.addClickListener(click ->{
      close();
    });

      shiftWorkerDialog.setAddWorkerHandler(() -> {
        Worker worker = shiftWorkerDialog.getSelectedWorker();
         if(!shift.getWorkers().contains(worker)) {
            shift.addWorker(worker);
            workersGridField.setItems(shift.getWorkers());
           Notification.show("Worker "  + worker.getLastName() + " added");
          } else {
           Notification.show("Worker "  + worker.getLastName() + " already added");
         }
      });

    saveButton.addClickListener(click->{
//      shiftsGrid.add(shiftDateField,workersGridField);
      shift.setData(shiftDateField.getValue());
      shiftsService.save(shift);

      shiftsGrid.setItems(shiftsService.findAll());
      System.out.println("Save Shift");
      close();
//      workersGridField.removeAllColumns();

    });
  }

  public void createShift(LocalDate date) {
    shift = new Shifts();
    shift.setData(date);
    shiftDateField.setValue(date);
    workersGridField.setItems(new ArrayList<>());
  }
}
