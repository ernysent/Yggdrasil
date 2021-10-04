package com.github.ernysent.yggdrasil.ui.calendar;

import com.github.ernysent.yggdrasil.domain.Worker;
import com.github.ernysent.yggdrasil.service.ShiftsService;
import com.github.ernysent.yggdrasil.service.WorkerService;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import java.awt.TextField;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class ShiftsDialog extends Dialog {
  private DatePicker shiftDateField = new DatePicker();
  private LocalDate now = LocalDate.now();
//  private Worker workerField = new Worker();

  public void ShiftsDialog (){
    shiftDateField.setValue(now);
    HorizontalLayout fieldsLayout = new HorizontalLayout(shiftDateField);
    add(fieldsLayout);
  }

}
