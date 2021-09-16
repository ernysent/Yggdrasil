package com.github.ernysent.yggdrasil.ui.workers;

import com.github.ernysent.yggdrasil.domain.Worker;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.github.ernysent.yggdrasil.ui.MainLayout;
import java.util.ArrayList;
import java.util.List;


@PageTitle("Worrkers")
@Route(value = "workers", layout = MainLayout.class)
public class WorkersView extends HorizontalLayout {

  List<Worker> personList = new ArrayList<Worker>();
}


