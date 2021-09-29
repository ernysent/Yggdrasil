package com.github.ernysent.yggdrasil.ui.calendar;

import com.github.ernysent.yggdrasil.service.ShiftsService;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.spring.annotation.UIScope;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@UIScope
@Component
@PreserveOnRefresh
public class CalendarLayout extends VerticalLayout {

  @Autowired
  public CalendarLayout(ShiftsGrid shiftsGrid
      , ShiftsService shiftsService
      ){

    DatePicker valueDatePicker = new DatePicker();
    LocalDate now = LocalDate.now();
    valueDatePicker.setValue(now);
    add(valueDatePicker, shiftsGrid);

//    valueDatePicker.setValue( EVENT -> {
//      System.out.println(valueDatePicker);
//      items = shiftsService.get(Date date);
//      shiftsGrid.setItems(items);
//
//    });


  }

}
