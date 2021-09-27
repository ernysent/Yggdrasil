package com.github.ernysent.yggdrasil.ui.workers;

import com.github.ernysent.yggdrasil.domain.Worker;
import com.github.ernysent.yggdrasil.service.WorkerService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.spring.annotation.UIScope;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@UIScope
@Component
@PreserveOnRefresh
public class WorkersLayout extends VerticalLayout {

    private Grid<Worker> grid = new Grid<>(Worker.class);

    @Autowired
    public WorkersLayout(
            WorkerService workerService,
            WorkerDialog workerDialog
    ) {
        List<Worker> workersList = new ArrayList<>();
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
                workerService.delete(worker);
                grid.setItems(workerService.findAll());
                setCounter(workerService.findAll().size());
            } else {
                Notification.show("Please select Worker");
            }
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
        grid.addComponentColumn(item ->
            {
                Icon icon;
                if (item.getActive()){
                    icon = VaadinIcon.CHECK.create();
                    icon.setColor("green");
                } else {
                    icon = VaadinIcon.CLOSE_SMALL.create();
                    icon.setColor("red");
                }
                return icon;
            })
            .setKey("active")
            .setHeader("Active")
            .setComparator(Comparator.comparing(Worker::getActive))
//        ;
//        grid.addColumn(Worker::getActive).setHeader("Active")
            .setFooter("Total: " + workersList.size() + " people");

        grid.asSingleSelect().setValue(workersList.get(0));

//        Multi galocki rabotatj ne liubiat :3

//        grid.setSelectionMode(Grid.SelectionMode.MULTI);
//        grid.asMultiSelect().select(workersList.get(0), workersList.get(1));
        HorizontalLayout remeditButton = new HorizontalLayout(removeButton,editButton);
        add(addWorkerButton, remeditButton, grid);

        //grid.addColumn(Worker::getFirstName).setHeader("First Name")


        // Events
        workerDialog.setChangeHandler(() -> {
            grid.setItems(workerService.findAll());
            setCounter(workerService.findAll().size());
        });
//
    }

    private void setCounter(int size) {
        grid.getFooterRows().get(0).getCells().get(5)
            .setText("Total: " + size + " people");
    }

}
