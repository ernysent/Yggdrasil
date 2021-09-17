package com.github.ernysent.yggdrasil.ui.workers;

import com.github.ernysent.yggdrasil.data.WorkerRepository;
import com.github.ernysent.yggdrasil.domain.Worker;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@UIScope
@Component
public class WorkersLayout extends VerticalLayout {

    @Autowired
    public WorkersLayout(WorkerRepository workerRepository) {
        List<Worker> workersList = new ArrayList<>();
        Grid<Worker> grid = new Grid<>(Worker.class);
        grid.setItems(workersList);
        Button addWorkerButton = new Button("Add", event ->{
            Dialog dialog = new Dialog();
            TextField nameField = new TextField("Name");
            Button closeButton = new Button("Close");
            closeButton.addClickListener(click -> {
                dialog.close();
            });
            HorizontalLayout ButtonLayout = new HorizontalLayout(closeButton);
            dialog.add(nameField,ButtonLayout);
            dialog.open();
            /*
            Worker w = new Worker("Steve", "Benton", "Painter", "8654321598");

            workerRepository.save(w);
            workerRepository.findAll().forEach(workersList::add);
            grid.setItems(workersList);
            */

        });

        Button removeButton = new Button("Remove last", event ->{
           workersList.remove(workersList.size()-10);
           grid.getDataProvider().refreshAll();
        });

        Worker painter = new Worker("John", "Connor", "Painter", "12345");
        Worker assembler1 = new Worker("Leaf", "Larsen", "Assembler", "67891");
        Worker assembler2 = new Worker("Semen", "Petrov", "Assembler", "23423");
        //workersList.add(painter);
        //workersList.add(assembler1);
        //workersList.add(assembler2);

        // Save to DB
        workerRepository.save(painter);
        workerRepository.save(assembler1);
        workerRepository.save(assembler2);

        // Get Workers from DB and place in List

        workerRepository.findAll().forEach(workersList::add);

        System.out.println(workersList.size() + "<<<<<<");
//        grid.setItems(workersList);
        grid.removeColumnByKey("id");
        grid.setColumns("id", "firstName", "lastName", "position", "phoneNumber");
        grid.addColumn(Worker::getActive).setHeader("Active");
        add(addWorkerButton, removeButton, grid);
    }

}
