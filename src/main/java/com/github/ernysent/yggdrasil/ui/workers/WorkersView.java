package com.github.ernysent.yggdrasil.ui.workers;

import com.github.ernysent.yggdrasil.ui.MainLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@PageTitle("Workers")
@Route(value = "workers", layout = MainLayout.class)
@PreserveOnRefresh
public class WorkersView extends HorizontalLayout  {

  @Autowired
  public  WorkersView (WorkersLayout workersLayout) {
    System.out.println("WorkersLayout Constructor");
    System.out.println("workersLayout: " + workersLayout);

    add(workersLayout);

  }
}


