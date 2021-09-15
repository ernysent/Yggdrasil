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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


@PageTitle("Worrkers")
@Route(value = "workers", layout = MainLayout.class)


public class WorkersView extends HorizontalLayout {

  String[] columnNames = {
      "Nr.","First Name","Last Name","Posithion","Active",
  };
  Object[][] data = {{"1","Nastia", "Sinkarenko","Painter","Active"}};
  JTable table = new JTable(data, columnNames);
  JScrollPane scrollPane = new JScrollPane(table);

}


