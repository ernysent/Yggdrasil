package com.github.ernysent.yggdrasil.ui.home;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.github.ernysent.yggdrasil.ui.MainLayout;
import com.vaadin.flow.router.RouteAlias;
@PageTitle("Home")
@Route(value = "home", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)

public class HomeView extends HorizontalLayout {

}
