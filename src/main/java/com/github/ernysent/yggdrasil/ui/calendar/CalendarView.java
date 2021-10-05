package com.github.ernysent.yggdrasil.ui.calendar;
import com.github.ernysent.yggdrasil.domain.Shifts;
import com.github.ernysent.yggdrasil.domain.Worker;
import com.github.ernysent.yggdrasil.ui.MainLayout;
import com.github.ernysent.yggdrasil.ui.workers.WorkerDialog;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Calendar")
@Route(value = "calendar", layout = MainLayout.class)
@PreserveOnRefresh
public class CalendarView extends HorizontalLayout{

  @Autowired
  public CalendarView(CalendarLayout calendarLayout, ShiftsDialog shiftsDialog){
    System.out.println(calendarLayout);
    add(calendarLayout);

    Shifts shifts = new Shifts();

    /*
    shifts.setData(LocalDate.now());
    List<Worker> workers = new ArrayList<>();
    workers.add(new Worker());

    shifts.setWorker(workers);
    */

  }
}
