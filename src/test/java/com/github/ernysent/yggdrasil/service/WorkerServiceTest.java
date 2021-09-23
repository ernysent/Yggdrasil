package com.github.ernysent.yggdrasil.service;

import com.github.ernysent.yggdrasil.domain.Worker;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WorkerServiceTest {

    @Autowired
    WorkerService workerService;

    @Test
    void save() {
        Worker worker1 = new Worker(
                "Ivan",
                "PetrovTest",
                "Assembler",
                "+37023423423"
                );

        workerService.save(worker1);

        Worker petrov = workerService.finByLastName("PetrovTest");
        Assert.assertEquals(petrov.getLastName(), "PetrovTest");
        System.out.println("Petrov: " + petrov.getLastName());
    }

    @Test
    void testSaveDublicate() {
        Worker worker1 = new Worker(
                "Ivan",
                "PetrovTest",
                "Assembler",
                "+37023423423"
        );
        boolean result =  workerService.save(worker1);
        Assert.assertEquals(true, result);

        result = workerService.save(worker1);
        Assert.assertEquals(false, result);

    }

    @Test
    void delete() {
        Worker worker1 = new Worker(
                "Ivan",
                "PetrovTest",
                "Assembler",
                "+37023423423"
        );
        workerService.save(worker1);
        workerService.delete(worker1);

        Worker ivan = workerService.finByLastName("PetrovTest");
        Assert.assertEquals(null, ivan);
    }

    @Test
    void findAll() {
        Worker worker1 = new Worker(
                "Ivan",
                "PetrovTest",
                "Assembler",
                "+37023423423"
        );
        Worker worker2 = new Worker(
                "Tosha",
                "ToshaTest",
                "Assembler",
                "+370234786"
        );
        workerService.save(worker1);
        workerService.save(worker2);
        List<Worker> workers = workerService.findAll();
        Assert.assertEquals(2, workers.size());
    }

    @Test
    void finByLastName() {
        Worker worker1 = new Worker(
                "Ivan",
                "PetrovTest",
                "Assembler",
                "+37023423423"
        );

        workerService.save(worker1);

        Worker petrov = workerService.finByLastName("PetrovTest");
        Assert.assertEquals(petrov.getLastName(), "PetrovTest");
        System.out.println("Petrov: " + petrov.getLastName());
    }

    @Test
    void findByLastNameAndFirstName() {
        Worker worker1 = new Worker(
                "Ivan",
                "PetrovTest",
                "Assembler",
                "+37023423423"
        );

        workerService.save(worker1);

        Worker petrov = workerService.findByLastNameAndFirstName("PetrovTest", "Ivan");
        Assert.assertEquals(petrov.getLastName(), "PetrovTest");
        Assert.assertEquals(petrov.getFirstName(), "Ivan");
        System.out.println("Petrov: " + petrov.getLastName() + " " + petrov.getFirstName());
    }
}