package com.github.ernysent.yggdrasil;

import com.github.ernysent.yggdrasil.data.WorkerRepository;
import com.github.ernysent.yggdrasil.domain.Worker;
import com.vaadin.flow.component.dependency.NpmPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.vaadin.artur.helpers.LaunchUtil;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
@NpmPackage(value = "@fontsource/montserrat", version = "4.5.0")
@NpmPackage(value = "lumo-css-framework", version = "^4.0.10")
@NpmPackage(value = "line-awesome", version = "1.3.0")
public class Application extends SpringBootServletInitializer implements ApplicationRunner {

    @Autowired
    WorkerRepository workerRepository;

    public static void main(String[] args) {
        System.out.println("Main method");

        LaunchUtil.launchBrowserInDevelopmentMode(SpringApplication.run(Application.class, args));
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Application Run method");
        Worker painter = new Worker("John", "Connor", "Painter", "12345");
        Worker assembler1 = new Worker("Leaf", "Larsen", "Assembler", "67891");
        Worker assembler2 = new Worker("Semen", "Petrov", "Assembler", "23423");
        //workersList.add(painter);
        //workersList.add(assembler1);
        //workersList.add(assembler2);

        // Save to DB
        workerRepository.save(painter);
        workerRepository.save(assembler1);
        workerRepository.save(assembler2);

    }
}
