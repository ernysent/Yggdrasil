package com.github.ernysent.yggdrasil.service;

import com.github.ernysent.yggdrasil.domain.Worker;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WorkerServiceTest {

    @Autowired
    WorkerService workerService;

/*
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
*/

    @Test
    void save() {
        Worker worker1 = new Worker(
                "Ivan",
                "PetrovTest",
                "Assembler",
                "+37023423423"
                );

        Worker worker2 = new Worker(
                "Semen",
                "LasTest",
                "Painter",
                "+370565756"
        );

        workerService.save(worker1);
        workerService.save(worker2);

        Worker petrov = workerService.finByLastName("PetrovTest");
        System.out.println("Petrov: " + petrov.getLastName());

        Worker petrovic = workerService.findByLastNameAndFirstName("PetrovTest", "Ivan");

        Iterable<Worker> workers = workerService.findAll();
        workers.forEach(w -> {
            System.out.println("Worker: " + worker1.getId() + " -> " + worker1.getLastName());
            Assert.assertEquals(worker1.getLastName(), "PetrovTest");
        });
    }

    @Test
    void delete() {

    }
}