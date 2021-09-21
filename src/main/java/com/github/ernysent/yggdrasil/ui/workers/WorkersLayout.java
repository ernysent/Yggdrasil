package com.github.ernysent.yggdrasil.ui.workers;

import com.github.ernysent.yggdrasil.data.WorkerRepository;
import com.github.ernysent.yggdrasil.domain.Worker;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
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
        Dialog dialog = new Dialog();

        Button addWorkerButton = new Button("Add", event ->{
            TextField nameField = new TextField("First Name");
            TextField lastNameField = new TextField("Last Name");
            TextField phoneField = new TextField("Phone number");

            ComboBox<String> positionField = new ComboBox<>();
            positionField.setItems("Painter","Assembler");
            positionField.setLabel("Position");
            positionField.setPlaceholder("Position");

            Checkbox activeField = new Checkbox();
            activeField.setLabel("Active");
            activeField.setValue(true);
            add(activeField);

//            ComboBox<Boolean> activeField = new ComboBox();
//            activeField.setLabel("Active");
//            activeField.setItems(true,false);
//            activeField.setValue(false);


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
                workersList.clear();
                workerRepository.findAll().forEach(workersList::add);
                grid.setItems(workersList);
                //grid.getDataProvider().refreshAll();
                dialog.close();
            });

            HorizontalLayout fieldsLayout = new HorizontalLayout(nameField,lastNameField,positionField,phoneField,activeField);
            fieldsLayout.setSpacing(true);
            HorizontalLayout buttonLayout = new HorizontalLayout(closeButton,saveButton);
            //buttonLayout.setSpacing();
            dialog.add(fieldsLayout, buttonLayout);

            dialog.open();

        });

        Button removeButton = new Button("Remove last", event ->{
           workersList.remove(workersList.size()-1);
//           workerRepository.deleteById();
           grid.getDataProvider().refreshAll();
        });

//        Edit Button



        Button editButton = new Button("Edit");
        editButton.addClickListener(click ->{
            grid.asSingleSelect().getValue();

            dialog.open();

        });

        // Get Workers from DB and place in List

        workerRepository.findAll().forEach(workersList::add);

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


//
    }

}
