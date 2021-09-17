package com.github.ernysent.yggdrasil.ui.workers;

import com.github.ernysent.yggdrasil.ui.MainLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@PageTitle("Workers")
@Route(value = "workers", layout = MainLayout.class)
public class WorkersView extends HorizontalLayout  {

  @Autowired
  public  WorkersView (WorkersLayout workersLayout) {
    System.out.println("workersLayout: " + workersLayout);

    add(workersLayout);

  }
}


