package com.github.ernysent.yggdrasil.ui.login;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.router.Route;
@Route("login-rich-content")
public class LoginView extends Div{
  public LoginView() {
    // See login-rich-content.css
    addClassName("login-rich-content");

    LoginForm loginForm = new LoginForm();
    loginForm.getElement().getThemeList().add("dark");
    add(loginForm);
    // Prevent the example from stealing focus when browsing the documentation
    loginForm.getElement().setAttribute("no-autofocus", "");
  }

}
