package com.github.ernysent.yggdrasil.ui.calendar;

import com.github.ernysent.yggdrasil.service.ShiftsService;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.component.button.Button;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@UIScope
@Component
@PreserveOnRefresh
public class CalendarLayout extends VerticalLayout {

  @Autowired
  public CalendarLayout(
      ShiftsGrid shiftsGrid,
      ShiftsService shiftsService,
      ShiftCreateDialog shiftsDialog
      ){

    DatePicker valueDatePicker = new DatePicker();
    LocalDate now = LocalDate.now();
    valueDatePicker.setValue(now);

    Button createShifts = new Button("Create");

    createShifts.addClickListener( click ->{
      shiftsDialog.open();
      shiftsDialog.createShift(valueDatePicker.getValue());
    });

    HorizontalLayout layout = new HorizontalLayout();
    layout.add(new H1("Calendar"));
    HorizontalLayout shiftsDateAndCreate = new HorizontalLayout(valueDatePicker,createShifts);
    add(layout,shiftsDateAndCreate, shiftsGrid);

    shiftsGrid.setItems(shiftsService.findAll());

//    valueDatePicker.setValue( EVENT -> {
//      System.out.println(valueDatePicker);
//      items = shiftsService.get(Date date);
//      shiftsGrid.setItems(items);
////
//    });


  }

}
