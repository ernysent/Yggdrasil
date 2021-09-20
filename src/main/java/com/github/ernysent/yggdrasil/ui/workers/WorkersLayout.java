package com.github.ernysent.yggdrasil.ui.workers;

import com.github.ernysent.yggdrasil.data.WorkerRepository;
import com.github.ernysent.yggdrasil.domain.Worker;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridMultiSelectionModel;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
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
    public WorkersLayout(WorkerRepository workerRepository) {
        List<Worker> workersList = new ArrayList<>();
        Grid<Worker> grid = new Grid<>(Worker.class);
        grid.setItems(workersList);
        Div messageDiv = new Div();
        Button addWorkerButton = new Button("Add", event ->{
            Dialog dialog = new Dialog();
            TextField nameField = new TextField("First Name");
            TextField lastNameField = new TextField("Last Name");
            TextField phoneField = new TextField("Phone number");

            ComboBox<String> positionField = new ComboBox<>();
            positionField.setItems("Painter","Assembler");
            positionField.setLabel("Position");
            positionField.setPlaceholder("Position");

            ComboBox<Boolean> activeField = new ComboBox();
            activeField.setLabel("Active");
            activeField.setItems(true,false);
            activeField.setValue(false);


//            TextField positionField = new TextField("Position");

            Button closeButton = new Button("Close");
            Button saveButton = new Button("Save");


            closeButton.addClickListener(click -> {
                dialog.close();
            });

            saveButton.addClickListener(click -> {
                Worker worker = new Worker();
                worker.setFirstName(nameField.getValue());
                worker.setLastName(lastNameField.getValue());
                worker.setPosition(positionField.getValue());
                worker.setPhoneNumber(phoneField.getValue());
                worker.setActive(activeField.getValue());


                workerRepository.save(worker);
                grid.setItems(worker);
                dialog.close();
            });

            HorizontalLayout fieldsLayout = new HorizontalLayout(nameField,lastNameField,positionField,phoneField,activeField);
            fieldsLayout.setSpacing(true);
            HorizontalLayout buttonLayout = new HorizontalLayout(closeButton,saveButton);
            //buttonLayout.setSpacing();
            dialog.add(fieldsLayout, buttonLayout);

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

        // Get Workers from DB and place in List

        workerRepository.findAll().forEach(workersList::add);

        System.out.println(workersList.size() + "<<<<<<");

        grid.removeColumnByKey("id");
        grid.setColumns("id", "firstName", "lastName", "position", "phoneNumber");
        grid.addColumn(Worker::getActive).setHeader("Active");

        grid.setSelectionMode(Grid.SelectionMode.MULTI);

        NativeButton deselectBtn = new NativeButton("Deselect all");
        deselectBtn.addClickListener( event -> grid.asMultiSelect().deselectAll());
        NativeButton selecctAllBtn = new NativeButton("Select all");
        selecctAllBtn.addClickListener(
                event -> ((GridMultiSelectionModel<Worker>) grid.getSelectionModel()).selectAll()
                );

//        grid.asSingleSelect().addValueChangeListener( event ->{
//            String message = String.format("Selection changed from %s to %s",
//                    event.getOldValue(),event.getValue());
//            messageDiv.setText(message);
//        });
        grid.asMultiSelect().select(workersList.get(0), workersList.get(1));
        add(addWorkerButton, removeButton, grid, messageDiv,selecctAllBtn,deselectBtn);
    }

}
