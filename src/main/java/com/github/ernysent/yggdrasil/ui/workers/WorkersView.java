package com.github.ernysent.yggdrasil.ui.workers;

import com.github.ernysent.yggdrasil.data.WorkerRepository;
import com.github.ernysent.yggdrasil.domain.Worker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.github.ernysent.yggdrasil.ui.MainLayout;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


@PageTitle("Worrkers")
@Route(value = "workers", layout = MainLayout.class)
public class WorkersView extends HorizontalLayout  {

  List<Worker> workersList = new ArrayList<>();
  Grid<Worker> grid = new Grid<>(Worker.class);

  @Autowired
  WorkerRepository workerRepository;

  @Autowired
  public  WorkersView (WorkerRepository workerRepository) {
    this.workerRepository  = workerRepository;
    Worker painter = new Worker("John", "Connor", "Painter", "12345");
    Worker assembler1 = new Worker( "Leaf", "Larsen", "Assembler", "67891");
    Worker assembler2 = new Worker( "Semen", "Petrov", "Assembler", "23423");
    //workersList.add(painter);
    //workersList.add(assembler1);
    //workersList.add(assembler2);

    // Save to DB
    workerRepository.save(painter);
    workerRepository.save(assembler1);
    workerRepository.save(assembler2);

    // Get Workers from DB and place in List
    workerRepository.findAll().forEach(workersList::add);

    System.out.println(workersList.size() + "<<<<<<");
    grid.setItems(workersList);
    //grid.removeColumnByKey("id");
    grid.setColumns("id","firstName","lastName","position","phoneNumber");
    grid.addColumn(Worker::getActive).setHeader("Active");
    grid.addColumn(Worker::getFirstName).setHeader("First Name");
    grid.addColumn(Worker::getLastName).setHeader("Last Name");
    grid.addColumn(Worker::getPosition).setHeader("Position");
    grid.addColumn(Worker::getPhoneNumber).setHeader("Phone Number");

    add(grid);

  }



}


