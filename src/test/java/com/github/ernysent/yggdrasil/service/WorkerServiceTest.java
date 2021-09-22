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
        Worker worker = new Worker(
                "Ivan",
                "PetrovTest",
                "Assembler",
                "+37023423423"
                );

        workerService.save(worker);
        Iterable<Worker> workers = workerService.findAll();
        workers.forEach(w -> {
            System.out.println("Worker: " + worker.getId() + " -> " + worker.getLastName());
            Assert.assertEquals(worker.getLastName(), "PetrovTest");
        });
    }

    @Test
    void delete() {

    }
}