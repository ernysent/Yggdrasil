package com.github.ernysent.yggdrasil.ui.calendar;
import com.github.ernysent.yggdrasil.domain.Shifts;
import com.github.ernysent.yggdrasil.domain.Worker;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.NativeButtonRenderer;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.spring.annotation.UIScope;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@UIScope
@Component
@PreserveOnRefresh
public class ShiftsGrid  extends VerticalLayout {
    Grid<Shifts> grid = new Grid<>();

    @Autowired
    public ShiftsGrid (ShiftDialog shiftDialog) {

      grid.setItems();
      grid.addColumn(Shifts::getData).setHeader("Date");
      grid.addColumn(shifts -> shifts.getWorkers().size()).setHeader("Workers");

//      grid.setSelectionMode(SelectionMode.NONE);
//      grid.setItemDetailsRenderer(TemplateRenderer.<Shifts>of(
//          "<div class='custom-details' style='border: 1px solid gray; padding: 10px; width: 100%; box-sizing: border-box;'>"
//              + "<div>Hi! My name is <b>[[item.firstName]]!</b></div>"
//              + "</div>")
//          .withEventHandler("handleClick",shifts -> {
//            grid.getDataProvider().refreshItem(shifts);
//          })
//      );
//      grid.setDetailsVisibleOnClick(false);
//      grid.addColumn(new NativeButtonRenderer<Shifts>("Details", item ->
//          grid.setDetailsVisible(item, !grid.isDetailsVisible(item))));

      add(grid);

      grid.addItemDoubleClickListener(event ->{
        System.out.println("Duoble click");

      });
    }

  public void setItems(List<Shifts> all) {
      grid.setItems(all);
  }
}
