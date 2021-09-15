package com.github.ernysent.yggdrasil.views.calculator;
import com.github.ernysent.yggdrasil.ProdCalc;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.github.ernysent.yggdrasil.views.MainLayout;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Calculator")
@Route(value = "calculator", layout = MainLayout.class)

public class CalculatorView extends HorizontalLayout{
  private TextField boxes;
  private Button count;

  public CalculatorView(){
    // Design
    addClassName("workers-view");
    boxes = new TextField("Your number of boxes");
    boxes.setPlaceholder("write here");
    boxes.addKeyPressListener(keyPressEvent -> {
      if(keyPressEvent.getCode().isPresent()) {
        if (keyPressEvent.getCode().get().getKeys().get(0).equals("Enter")) {
          System.out.println("Hi too 3");
          count.click();
        }
      }
    });
    count = new Button("count");
    Label sample = new Label();
    add(boxes, count,sample);
    setVerticalComponentAlignment(Alignment.END, boxes, count);


    // Events
    count.addClickListener(e -> {
      Notification.show( boxes.getValue() + " Boxes");
      int boxesValue = Integer.parseInt(boxes.getValue());
      ProdCalc prodCalc = new ProdCalc();
      int meters = prodCalc.calcMeters(boxesValue);
      int board = prodCalc.calcBoard(boxesValue);
      double remains = prodCalc.calcRemains(boxesValue,board);
//      double sumdye = prodCalc.calcPaint(boxesValue);
//      double collect = prodCalc.calcCollector(boxesValue);
//      double paint = prodCalc.calcPainters(boxesValue);
      sample.setText("Meters: " + meters +"\nBoard: " + board+  "\nRemains: "+remains);
//      Section1(box,meters,board,remains);
//      section2(sumdye);
    } );

    setMargin(true);


  }

}
