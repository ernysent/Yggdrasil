package com.github.ernysent.yggdrasil.ui.calendar;


import com.github.ernysent.yggdrasil.domain.Shifts;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@UIScope
@Component
@PreserveOnRefresh
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
