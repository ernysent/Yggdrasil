package com.github.ernysent.yggdrasil.ui.workers;

import com.github.ernysent.yggdrasil.domain.Worker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.github.ernysent.yggdrasil.ui.MainLayout;
import java.util.ArrayList;
import java.util.List;


@PageTitle("Worrkers")
@Route(value = "workers", layout = MainLayout.class)
public class WorkersView extends HorizontalLayout {

  List<Worker> workersList = new ArrayList<>();
  Grid<Worker> grid = new Grid<>(Worker.class);

  public  WorkersView () {
    Worker painter = new Worker(1, "John", "Connor", "Painter", "12345");
    Worker assembler1 = new Worker(2, "Leaf", "Larsen", "Assembler", "67891");
    Worker assembler2 = new Worker(2, "Semen", "Petrov", "Assembler", "23423");
    workersList.add(painter);
    workersList.add(assembler1);
    workersList.add(assembler2);


    grid.setItems(workersList);
    grid.removeColumnByKey("id");
    grid.setColumns("firstName","lastName","position","phoneNumber");


//    grid.addColumn(Worker::getFirstName).setHeader("First Name");
//    grid.addColumn(Worker::getLastName).setHeader("Last Name");
//    grid.addColumn(Worker::getPosition).setHeader("Position");
    grid.addColumn(Worker::getActive).setHeader("Active");
//    grid.addColumn(Worker::getPhoneNumber).setHeader("Phone Number");
    add(grid);
  }



}


