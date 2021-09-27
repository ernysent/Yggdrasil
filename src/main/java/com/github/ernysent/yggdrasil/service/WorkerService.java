package com.github.ernysent.yggdrasil.service;

import com.github.ernysent.yggdrasil.data.WorkerRepository;
import com.github.ernysent.yggdrasil.domain.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkerService {

    @Autowired
    WorkerRepository workerRepository;

    public void delete(Worker worker) {
        // Check
        workerRepository.delete(worker);
    }

    public List<Worker> findAll() {
        List<Worker> workers = new ArrayList<>();
        workerRepository.findAll().forEach(workers::add);
        return  workers;
    }

    public boolean save(Worker worker) {
        Worker workerInRepo = workerRepository.findByLastName(worker.getLastName());
        System.out.println(workerInRepo);
        if ((workerInRepo == null) || (worker.getId() != null)) {
            workerRepository.save(worker);
            System.out.println("Saved)");
            return  true;
        } else {
            System.out.println("None");
            return  false;
        }
    }

    public Worker finByLastName(String lastName) {
        return workerRepository.findByLastName(lastName);
    }

    public Worker findByLastNameAndFirstName(String lastName, String firstName) {
        return workerRepository.findByLastNameAndFirstName(lastName, firstName);
    }
}
