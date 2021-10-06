package com.github.ernysent.yggdrasil.ui.calendar;


import com.github.ernysent.yggdrasil.domain.Worker;
import com.github.ernysent.yggdrasil.service.WorkerService;
import com.vaadin.flow.component.Unit;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@VaadinSessionScope
public class shiftWorkerDialog extends Dialog {
  private Button addSearchWorkerButton = new Button("Add");
  private Button removeButton = new Button("Remove");
  private Button addWorkersButton = new Button("Add");
  private Button saveButton = new Button("Save");
  private Button closeButton = new Button("Close");


  private Grid<Worker> gridActiveWorkers = new Grid<>(Worker.class);

  @Autowired
  public shiftWorkerDialog(WorkerService workerService){
    setWidth(800, Unit.PIXELS);
    List<Worker> workerList = new ArrayList<>();
    gridActiveWorkers.setItems(workerList);

    gridActiveWorkers.setColumns("firstName","lastName","phoneNumber","position");
//    gridActiveWorkers.asSingleSelect().setValue(workerList.get(0));
    gridActiveWorkers.setItems(workerService.findAll());

    add(gridActiveWorkers);

  }

}
