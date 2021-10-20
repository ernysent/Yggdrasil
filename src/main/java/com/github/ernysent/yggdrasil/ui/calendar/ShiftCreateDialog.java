package com.github.ernysent.yggdrasil.ui.calendar;

import com.github.ernysent.yggdrasil.domain.Shifts;
import com.github.ernysent.yggdrasil.domain.Worker;
import com.github.ernysent.yggdrasil.service.ShiftsService;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import com.vaadin.flow.component.button.Button;
import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@UIScope
public class ShiftCreateDialog extends Dialog {

  private final DatePicker shiftDateField  = new DatePicker();
  private final Grid<Worker> workersGridField = new Grid<>(Worker.class);
  private final Button closeButton = new Button("Close");
  private final Button saveButton = new Button("Save");
  private final Button addWorkerButton = new Button("add");
  private final Button removeButton = new Button("remove");

  private Shifts shift;
 // private final ShiftsGrid shiftsGrid;

  @Autowired
  public ShiftCreateDialog(
      ShiftWorkersDialog shiftWorkerDialog,
      ShiftsService shiftsService
      ) {

    // Design

    setWidth(800, Unit.PIXELS);
    Label dates = new Label("Data");
    shiftDateField.setValue(LocalDate.now());


    workersGridField.setColumns("firstName","lastName","position","phoneNumber");
    // Button location
    HorizontalLayout buttonsLayout = new HorizontalLayout(saveButton,closeButton);
    HorizontalLayout fieldsLayout = new HorizontalLayout(shiftDateField,addWorkerButton,removeButton);
    VerticalLayout layout = new VerticalLayout();
    layout.add( new H2("Create shift"));
    add(layout,dates,fieldsLayout,workersGridField,buttonsLayout);

    //Events
    addWorkerButton.addClickListener(click -> {
      shiftWorkerDialog.open();
    });

    closeButton.addClickListener(click ->{
      close();
    });

    removeButton.addClickListener(click ->{
      Worker worker = workersGridField.asSingleSelect().getValue();
      if (worker!= null){
        shift.deleteWorker(worker);
        workersGridField.setItems(shift.getWorkers());

        Notification.show("Worker deleted");
      }else {
        Notification.show("Please select Worker");
      }

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
      shift.setData(shiftDateField.getValue());

      if (!shiftsService.save(shift)){
        Notification notification = new Notification();
        Notification.show( "Shift at this date: "+shift.getData()+" already exists");
      } else {
        shiftsService.save(shift);
        System.out.println("Save Shift");
        close();
      }
    });
  }

  public void createShift(LocalDate date) {
    shift = new Shifts();
    shift.setData(date);
    shiftDateField.setValue(date);
    workersGridField.setItems(new ArrayList<>());
  }
}
