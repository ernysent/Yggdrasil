package com.github.ernysent.yggdrasil.ui.calendar;
import com.github.ernysent.yggdrasil.domain.Shifts;
import com.github.ernysent.yggdrasil.ui.MainLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Calendar")
@Route(value = "calendar", layout = MainLayout.class)
@PreserveOnRefresh
public class CalendarView extends HorizontalLayout{

  @Autowired
  public CalendarView(CalendarLayout calendarLayout, ShiftCreateDialog shiftsDialog){
    add(calendarLayout);
    Shifts shifts = new Shifts();

  }
}
