package com.github.ernysent.yggdrasil.views.workers;

import com.github.ernysent.yggdrasil.Main;
import com.github.ernysent.yggdrasil.ProdCalc;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.github.ernysent.yggdrasil.views.MainLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTextField;


@PageTitle("Worrkers")
@Route(value = "workers", layout = MainLayout.class)


public class WorkersView extends HorizontalLayout {
//  private TextField boxes;
//  private Button count;
//
//  public WorkersView(){
//
//      // Design
//      addClassName("workers-view");
//      boxes = new TextField("Your number of boxes");
//      boxes.setPlaceholder("write here");
//      boxes.addKeyPressListener(keyPressEvent -> {
//        if(keyPressEvent.getCode().isPresent()) {
//          if (keyPressEvent.getCode().get().getKeys().get(0).equals("Enter")) {
//            System.out.println("Hi too 3");
//            count.click();
//          }
//        }
//      });
//      count = new Button("count");
//        Label sample = new Label();
//      add(boxes, count,sample);
//      setVerticalComponentAlignment(Alignment.END, boxes, count);
//
//
//      // Events
//      count.addClickListener(e -> {
//          Notification.show( boxes.getValue() + " Boxes");
//          int boxesValue = Integer.parseInt(boxes.getValue());
//          ProdCalc prodCalc = new ProdCalc();
//          int meters = prodCalc.calcMeters(boxesValue);
//          sample.setText("Meters: " + meters);
//      } );
//
//      setMargin(true);
//  }
}


