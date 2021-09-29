package com.github.ernysent.yggdrasil.ui.calendar;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

@UIScope
@Component
@PreserveOnRefresh
public class ShiftsGrid  extends VerticalLayout {
    public  ShiftsGrid () {
      Grid grid = new Grid();
      add(grid);
    }
}
