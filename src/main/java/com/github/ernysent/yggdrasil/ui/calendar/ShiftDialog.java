package com.github.ernysent.yggdrasil.ui.calendar;


import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@VaadinSessionScope
public class ShiftDialog extends Dialog {


  @Autowired
  public  ShiftDialog(){

  }

}
