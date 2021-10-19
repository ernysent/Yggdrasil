package com.github.ernysent.yggdrasil.ui.calendar;

import com.github.ernysent.yggdrasil.domain.Shifts;
import com.github.ernysent.yggdrasil.service.ShiftsService;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
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
      ShiftCreateDialog shiftCreateDialog
      ){

    DatePicker valueDatePicker = new DatePicker();
    LocalDate now = LocalDate.now();
    valueDatePicker.setValue(now);

    Button createShifts = new Button("Create");


    HorizontalLayout shiftsDateAndCreate = new HorizontalLayout(valueDatePicker,createShifts);
    add(shiftsDateAndCreate, shiftsGrid);

    createShifts.addClickListener( click ->{
      shiftCreateDialog.open();
      shiftCreateDialog.createShift(valueDatePicker.getValue());
    });

    shiftsGrid.setItems(shiftsService.findAll());

//    valueDatePicker.setValue( EVENT -> {
//      System.out.println(valueDatePicker);
//      items = shiftsService.get(Date date);
//      shiftsGrid.setItems(items);
////
//    });


  }

}
