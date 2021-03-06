package com.github.ernysent.yggdrasil.ui;

import com.github.ernysent.yggdrasil.domain.Shifts;
import com.github.ernysent.yggdrasil.domain.Worker;
import com.github.ernysent.yggdrasil.service.ShiftsService;
import com.github.ernysent.yggdrasil.service.WorkerService;
import com.github.ernysent.yggdrasil.ui.calculator.CalculatorView;
import com.github.ernysent.yggdrasil.ui.calendar.CalendarView;
import com.github.ernysent.yggdrasil.ui.home.HomeView;
import com.github.ernysent.yggdrasil.ui.workers.WorkersView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * The main view is a top-level placeholder for other views.
 */
@PWA(name = "Yggdrasil", shortName = "Yggdrasil", enableInstallPrompt = false)
@Theme(themeFolder = "yggdrasil")
@PageTitle("Main")
@PreserveOnRefresh
public class MainLayout extends AppLayout  implements BeforeEnterObserver {

    private final WorkerService workerService;
    private final ShiftsService shiftsService;

    public static class MenuItemInfo {

        private String text;
        private String iconClass;
        private Class<? extends Component> view;

        public MenuItemInfo(String text, String iconClass, Class<? extends Component> view) {
            this.text = text;
            this.iconClass = iconClass;
            this.view = view;
        }

        public String getText() {
            return text;
        }

        public String getIconClass() {
            return iconClass;
        }

        public Class<? extends Component> getView() {
            return view;
        }

    }

    @Autowired
    public MainLayout(
        WorkerService workerService,
        ShiftsService shiftsService)
    {
        this.workerService = workerService;
        this.shiftsService = shiftsService;
        startupLoader();
        System.out.println("MainLayout Constructor");
        addToNavbar(createHeaderContent());
    }

    private Component createHeaderContent() {
        Header header = new Header();
        header.addClassNames("bg-base", "border-b", "border-contrast-10", "box-border", "flex", "flex-col", "w-full");

        Div layout = new Div();
        layout.addClassNames("flex", "h-xl", "items-center", "px-l");


        H1 appName = new H1("Yggdrasil");
        appName.addClassNames("my-0", "me-auto", "text-l");
        layout.add(appName);

        Button logout = new Button("Logout",  new Icon(VaadinIcon.EXIT));
        logout.addClickListener(a-> {
            UI.getCurrent().getSession().setAttribute("authentificated", false);
            UI.getCurrent().navigate("login");
        });
        layout.add(logout);

        Nav nav = new Nav();
        nav.addClassNames("flex", "gap-s", "overflow-auto", "px-m");

        for (RouterLink link : createLinks()) {
            nav.add(link);
        }

        header.add(layout, nav);
        return header;
    }

    private List<RouterLink> createLinks() {
        MenuItemInfo[] menuItems = new MenuItemInfo[]{ //
                new MenuItemInfo("Home", "la la-globe", HomeView.class),//

          //      new MenuItemInfo("Hello World", "la la-globe", HelloWorldView.class), //

         //       new MenuItemInfo("About", "la la-globe", AboutView.class), //

                new MenuItemInfo("Workers", "la la-file", WorkersView.class),

                new MenuItemInfo("Calculator", "la la-file", CalculatorView.class),//

                new MenuItemInfo("Calendar", "la la-file", CalendarView.class),//

        };
        List<RouterLink> links = new ArrayList<>();
        for (MenuItemInfo menuItemInfo : menuItems) {
            links.add(createLink(menuItemInfo));

        }
        return links;
    }

    private static RouterLink createLink(MenuItemInfo menuItemInfo) {
        RouterLink link = new RouterLink();
        link.addClassNames("flex", "h-m", "items-center", "px-s", "relative", "text-secondary");
        link.setRoute(menuItemInfo.getView());

        Span icon = new Span();
        icon.addClassNames("me-s", "text-l");
        if (!menuItemInfo.getIconClass().isEmpty()) {
            icon.addClassNames(menuItemInfo.getIconClass());
        }

        Span text = new Span(menuItemInfo.getText());
        text.addClassNames("font-medium", "text-s", "whitespace-nowrap");

        link.add(icon, text);
        return link;
    }

    private void startupLoader () {
        List<Worker> workers = workerService.findAll();
        List<Shifts> shifts = shiftsService.findAll();
        if(workers.size() == 0) {
            System.out.println("Data Loader method");
            Worker painter = new Worker("John", "Connor", "Painter", "12345");
            Worker assembler1 = new Worker("Leaf", "Larsen", "Assembler", "67891");
            Worker assembler2 = new Worker("Semen", "Petrov", "Assembler", "23423");
            //workersList.add(painter);
            //workersList.add(assembler1);
            //workersList.add(assembler2);

            // Save to DB
            workerService.save(painter);
            workerService.save(assembler1);
            workerService.save(assembler2);
        }
        if (shifts.size() == 0){
            System.out.println("Calendar Loader method");
            Shifts bigBang = new Shifts(LocalDate.now(), workerService.findAll());
            shiftsService.save(bigBang);
        }


    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if(UI.getCurrent().getSession().getAttribute("authentificated") == null) {
            System.out.println("1 forward -> login");
            beforeEnterEvent.forwardTo("login");
        } else {
            if (!UI.getCurrent().getSession().getAttribute("authentificated").equals(true)) {
                beforeEnterEvent.forwardTo("login");
                System.out.println("2 forward -> login");
            }
        }
    }
}
