package com.github.ernysent.yggdrasil.ui.calendar;


import com.github.ernysent.yggdrasil.domain.Worker;
import com.github.ernysent.yggdrasil.service.WorkerService;
import com.vaadin.flow.component.Unit;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@VaadinSessionScope
public class ShiftWorkersDialog extends Dialog {
  private Button addSearchWorkerButton = new Button("Add");
  private Button addWorkersButton = new Button("Add");
  private Button closeButton = new Button("Close");
  private Label search = new Label("Search");
  private Label label2 = new Label("Workers active list");


  private Grid<Worker> gridActiveWorkers = new Grid<>(Worker.class);

  ShiftCreateDialog shiftCreateDialog;

  public Worker getSelectedWorker() {
    return gridActiveWorkers.asSingleSelect().getValue();
  }

    public interface AddWorkerHandler {
    void onAdd();
  }

  private AddWorkerHandler addWorkerHandler;

  public void setAddWorkerHandler(AddWorkerHandler addWorkerHandler) {
    this.addWorkerHandler = addWorkerHandler;
  }


  @Autowired
  public ShiftWorkersDialog(WorkerService workerService){
    setWidth(800, Unit.PIXELS);
    List<Worker> workerList = new ArrayList<>();
    gridActiveWorkers.setItems(workerList);

    gridActiveWorkers.setColumns("firstName","lastName","phoneNumber","position");

//    gridActiveWorkers.asSingleSelect().setValue(workerList.get(0));
    gridActiveWorkers.setItems(workerService.findAll());

    addWorkersButton.addClickListener(click ->{
      Worker worker = gridActiveWorkers.asSingleSelect().getValue();
      if(worker != null){
        addWorkerHandler.onAdd();
      }
    });


    closeButton.addClickListener(click ->{
      close();
    });

    HorizontalLayout layout = new HorizontalLayout();
    layout.add(new H2("Add workers to shift"));
    HorizontalLayout searchLayout = new HorizontalLayout(addSearchWorkerButton);
    HorizontalLayout buttonLayout = new HorizontalLayout(addWorkersButton,closeButton);
    add(layout,search,searchLayout,label2,gridActiveWorkers,buttonLayout);

  }

}
