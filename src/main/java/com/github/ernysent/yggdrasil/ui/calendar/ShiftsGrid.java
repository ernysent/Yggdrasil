package com.github.ernysent.yggdrasil.ui.calendar;

import com.github.ernysent.yggdrasil.domain.Shifts;
import com.github.ernysent.yggdrasil.service.ShiftsService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.spring.annotation.UIScope;
import java.util.List;
import org.springframework.stereotype.Component;

@UIScope
@Component
@PreserveOnRefresh
public class ShiftsGrid  extends VerticalLayout {
    private  Grid<Shifts> grid = new Grid();

    public  ShiftsGrid () {
      grid.addColumn(Shifts::getData).setHeader("Date");
      grid.addColumn(shifts -> shifts.getWorkers().size()).setHeader("Workers");
      add(grid);

      grid.addItemDoubleClickListener(event ->{
        System.out.println("Duoble click");
      });

    }

  public void setItems(List<Shifts> all) {
      grid.setItems(all);
  }
}
