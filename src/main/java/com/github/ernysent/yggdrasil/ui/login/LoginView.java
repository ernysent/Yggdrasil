package com.github.ernysent.yggdrasil.ui.login;

import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@Route("login")
public class LoginView extends VerticalLayout {

  private Environment environment;

  @Autowired
  public LoginView(Environment environment) {
    // See login-rich-content.css
    addClassName("login-rich-content");
    LoginForm loginForm = new LoginForm();
    loginForm.setForgotPasswordButtonVisible(false);
    loginForm.getElement().getThemeList().add("dark");
    add(loginForm);
    setSizeFull();
    setJustifyContentMode(JustifyContentMode.CENTER);
    setAlignItems(Alignment.CENTER);
    // Prevent the example from stealing focus when browsing the documentation
    loginForm.getElement().setAttribute("no-autofocus", "");
    loginForm.addLoginListener( l->{
      if (l.getUsername().toString().equals(environment.getProperty("login"))
              && l.getPassword().toString().equals(environment.getProperty("password"))) {
        System.out.println("Login OK!");
        getUI().ifPresent(
                ui -> {
                  System.out.println("Navigate to home!");
                  ui.getSession().setAttribute("authentificated", true);
                  ui.navigate("home");
        });
      } else {
        Notification.show("Incorrect login or password, please try again");
        loginForm.setEnabled(true);
      }
    });
  }
}
