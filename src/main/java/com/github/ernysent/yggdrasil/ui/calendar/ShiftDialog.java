package com.github.ernysent.yggdrasil.ui.calendar;


import com.github.ernysent.yggdrasil.data.ShiftsRepository;
import com.github.ernysent.yggdrasil.domain.Shifts;
import com.github.ernysent.yggdrasil.service.ShiftsService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import java.lang.reflect.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@VaadinSessionScope
public class ShiftDialog extends Dialog {
  final private Label nameField = new Label();
  final private Grid<Shifts> gridWorkersShiftField = new Grid<>(Shifts.class);
  final private Button closeButton = new Button("Close");
  final private Button editButton = new Button("Edit");

  @Autowired
  public  ShiftDialog(
      ShiftCreateDialog shiftCreateDialog
      ){
    add(nameField,gridWorkersShiftField,closeButton,editButton);

  }

}
