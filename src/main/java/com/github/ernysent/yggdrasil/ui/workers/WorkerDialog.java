package com.github.ernysent.yggdrasil.ui.workers;

import com.github.ernysent.yggdrasil.domain.Worker;
import com.github.ernysent.yggdrasil.service.WorkerService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.stereotype.Component;

@Component
public class WorkerDialog extends Dialog {
    private TextField nameField = new TextField("First Name");
    private TextField lastNameField = new TextField("Last Name");
    private TextField phoneField = new TextField("Phone number");
    private ComboBox<String> positionField = new ComboBox<>();
    private Checkbox activeField = new Checkbox();
    private Worker worker;

    public void setSetWorker(Worker worker) {
        this.worker = worker;
        if (worker != null) {
            nameField.setValue(worker.getFirstName());
            lastNameField.setValue(worker.getLastName());
            phoneField.setValue(worker.getPhoneNumber());
            positionField.setValue(worker.getPosition());
            activeField.setValue(worker.getActive());
        } else {
            nameField.clear();
            lastNameField.clear();
            phoneField.clear();
            positionField.clear();
            activeField.clear();
        }
    }

    public interface ChangeHandler {
        void onChange();
    }

    private ChangeHandler changeHandler;

    public void setChangeHandler(ChangeHandler changeHandler) {
        this.changeHandler = changeHandler;
    }

    public WorkerDialog(WorkerService workerService){

        // Design


        positionField.setItems("Painter","Assembler");
        positionField.setLabel("Position");
        positionField.setPlaceholder("Position");


        activeField.setLabel("Active");
        activeField.setValue(true);

        Button closeButton = new Button("Close");
        Button saveButton = new Button("Save");
        HorizontalLayout fieldsLayout = new HorizontalLayout(nameField,lastNameField,positionField,phoneField,activeField);
        fieldsLayout.setSpacing(true);
        HorizontalLayout buttonLayout = new HorizontalLayout(closeButton,saveButton);
        //buttonLayout.setSpacing();
        add(fieldsLayout, buttonLayout);

        // Events
        closeButton.addClickListener(click -> {
            close();
        });

        saveButton.addClickListener(click -> {

            if(worker == null) {
                worker = new Worker();
            }
            worker.setFirstName(nameField.getValue());
            worker.setLastName(lastNameField.getValue());
            worker.setPosition(positionField.getValue());
            worker.setPhoneNumber(phoneField.getValue());
            worker.setActive(activeField.getValue());

            if (!workerService.save(worker)) {
                Notification.show("Please enter another Worker");
            }

            changeHandler.onChange();
            //grid.getDataProvider().refreshAll();

            close();

        });
    }
}
