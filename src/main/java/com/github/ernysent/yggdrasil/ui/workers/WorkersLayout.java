package com.github.ernysent.yggdrasil.ui.workers;

import com.github.ernysent.yggdrasil.domain.Worker;
import com.github.ernysent.yggdrasil.service.WorkerService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@UIScope
@Component
@PreserveOnRefresh
public class WorkersLayout extends VerticalLayout {

    @Autowired
    public WorkersLayout(
            WorkerService workerService,
            WorkerDialog workerDialog
    ) {
        List<Worker> workersList = new ArrayList<>();
        Grid<Worker> grid = new Grid<>(Worker.class);
        grid.setItems(workersList);

        Button addWorkerButton = new Button("Add", event ->
        {
                workerDialog.setSetWorker(null);
                workerDialog.open();
        });

        Button removeButton = new Button("Remove");
        removeButton.addClickListener( click ->{
            Worker worker = grid.asSingleSelect().getValue();
            if (worker != null){
                workersList.clear();
                workerService.delete(worker);
                List<Worker> l = workerService.findAll();

                grid.setItems(l);
            }else { Notification.show("Please select Worker");}


        });

//        Edit Button



        Button editButton = new Button("Edit");
        editButton.addClickListener(click ->{
            Worker worker = grid.asSingleSelect().getValue();
            if (worker != null) {
                workerDialog.setSetWorker(worker);
                workerDialog.open();
            } else {
                Notification.show("Please select Worker");
            }
        });

        // Get Workers from DB and place in List

        workerService.findAll().forEach(workersList::add);

        System.out.println(workersList.size() + "<<<<<<");

        grid.removeColumnByKey("id");
        grid.setColumns("id", "firstName", "lastName", "position", "phoneNumber");
        grid.addColumn(Worker::getActive).setHeader("Active");

        grid.asSingleSelect().setValue(workersList.get(0));

//        Multi galocki rabotatj ne liubiat :3

//        grid.setSelectionMode(Grid.SelectionMode.MULTI);
//        grid.asMultiSelect().select(workersList.get(0), workersList.get(1));
        HorizontalLayout remeditButton = new HorizontalLayout(removeButton,editButton);
        add(addWorkerButton, remeditButton, grid);

        // Events
        workerDialog.setChangeHandler(() -> {
            workersList.clear();
            workerService.findAll().forEach(workersList::add);
            grid.setItems(workersList);
        });
//
    }

}
